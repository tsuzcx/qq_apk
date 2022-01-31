package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@TargetApi(16)
public final class g
{
  public static short[] SizeFormat2WH;
  public static int VFMT_HEVC_HW;
  public static int VFMT_i264;
  public static int frameID;
  private static String path;
  private static int streamqueuesize;
  private static final String[] supportedH264HwCodecPrefixes;
  public String ENCODING;
  private int TIMEOUT_USEC;
  public byte[] configbyte;
  public int encLen;
  public boolean isRuning;
  public int kJZ;
  private byte[] kKa;
  private MediaMuxer kKb;
  private BufferedOutputStream kKc;
  com.tencent.mm.plugin.voip.model.g kKd;
  public int kKe;
  public int kKf;
  public int kKg;
  public int kKh;
  a kKi;
  public long mGeneratedIdx;
  private boolean mMuxerStarted;
  int mPrevResolution;
  int mProfileCfg;
  private int mTrackIndex;
  int m_CapH;
  int m_CapW;
  int m_br_kbps;
  int m_framerate;
  int m_height;
  int m_width;
  MediaCodec mediaCodec;
  protected MediaFormat mediaFormat;
  private BufferedOutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(145850);
    streamqueuesize = 100;
    frameID = 0;
    path = Environment.getExternalStorageDirectory().getAbsolutePath();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK" };
    AppMethodBeat.o(145850);
  }
  
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(145845);
    this.kJZ = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.kKa = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.kKd = null;
    this.kKe = 0;
    this.kKf = 8;
    this.kKg = 0;
    this.kKh = 0;
    this.kKi = null;
    this.isRuning = false;
    this.encLen = 0;
    this.mPrevResolution = 8;
    this.m_width = 320;
    this.m_height = 240;
    this.m_CapW = 320;
    this.m_CapH = 240;
    this.ENCODING = paramString;
    this.m_framerate = paramInt1;
    this.m_br_kbps = paramInt2;
    this.mProfileCfg = -1;
    paramString = path + "/AVLog/mediacodec.h264";
    new StringBuilder().append(path).append("/AVLog/enc.yuv");
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      this.outputStream = new BufferedOutputStream(new FileOutputStream(paramString));
      frameID = 0;
      this.mGeneratedIdx = 0L;
      this.kKi = new a();
      this.mediaCodec = null;
      this.kKf = 8;
      this.kKe = 0;
      this.kKg = 0;
      this.kJZ = 0;
      this.kKa = null;
      this.kKh = 0;
      AppMethodBeat.o(145845);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("OpenVoice[HWEnc]", " error:" + paramString.toString());
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(145846);
    try
    {
      if (this.mediaCodec != null)
      {
        this.mediaCodec.stop();
        this.mediaCodec.release();
      }
      AppMethodBeat.o(145846);
      return;
    }
    catch (Exception localException)
    {
      ab.e("OpenVoice[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(145846);
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(145843);
    paramMediaCodecInfo = paramMediaCodecInfo.getName();
    String[] arrayOfString = supportedH264HwCodecPrefixes;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramMediaCodecInfo.startsWith(arrayOfString[i]))
        {
          bool1 = true;
          ab.d("OpenVoice[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
        }
      }
      else
      {
        AppMethodBeat.o(145843);
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(145842);
    bool2 = false;
    bool1 = bool2;
    if (d.fv(23))
    {
      for (;;)
      {
        try
        {
          paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
          bool1 = bool2;
          if (paramMediaCodecInfo == null) {
            continue;
          }
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          bool1 = bool2;
          if (paramMediaCodecInfo == null) {
            continue;
          }
          paramString = new MediaCodecInfo.CodecProfileLevel();
          paramString.level = 0;
          paramString.profile = 0;
          int k = paramMediaCodecInfo.length;
          i = 0;
          if (i >= k) {
            continue;
          }
          Object localObject = paramMediaCodecInfo[i];
          m = localObject.profile;
          n = localObject.level;
          bool1 = false;
          switch (m)
          {
          }
        }
        catch (Exception paramMediaCodecInfo)
        {
          int i;
          int m;
          int n;
          boolean bool3;
          ab.e("OpenVoice[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
          bool1 = bool2;
          continue;
          int j = 0;
          continue;
          j = 1;
          continue;
        }
        if (j != 0)
        {
          bool3 = true;
          bool1 = bool3;
          if (m >= paramString.profile)
          {
            bool1 = bool3;
            if (n >= paramString.level)
            {
              bool1 = bool3;
              if (m <= paramInt)
              {
                paramString.profile = m;
                paramString.level = n;
                bool1 = bool3;
              }
            }
          }
        }
        ab.i("OpenVoice[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ab.i("OpenVoice[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
      bool1 = bool2;
      if (paramString.profile > 0)
      {
        bool1 = bool2;
        if (paramString.level >= 256)
        {
          this.mediaFormat.setInteger("profile", paramString.profile);
          this.mediaFormat.setInteger("level", 256);
          bool1 = true;
        }
      }
    }
    AppMethodBeat.o(145842);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(145841);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.kKf)
      {
        String str = paramMediaCodecInfo.getName();
        String[] arrayOfString = supportedH264HwCodecPrefixes;
        int k = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= k) {
            break;
          }
          bool2 = bool1;
          if (str.startsWith(arrayOfString[i]))
          {
            bool2 = bool1;
            try
            {
              MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramMediaCodecInfo.getCapabilitiesForType(paramString).profileLevels;
              bool2 = bool1;
              int m = arrayOfCodecProfileLevel.length;
              int j = 0;
              for (;;)
              {
                bool2 = bool1;
                if (j >= m) {
                  break;
                }
                MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[j];
                bool3 = bool1;
                bool2 = bool1;
                if (localCodecProfileLevel.profile == 8) {
                  bool3 = true;
                }
                bool2 = bool3;
                ab.d("OpenVoice[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.kKf + ", MIME:" + paramString);
                j += 1;
                bool1 = bool3;
              }
              i += 1;
            }
            catch (Exception localException) {}
          }
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(145841);
    return bool2;
  }
  
  @SuppressLint({"NewApi"})
  private int bhm()
  {
    boolean bool1 = false;
    AppMethodBeat.i(145844);
    if (this.mediaCodec != null) {
      StopEncoder();
    }
    String str = this.ENCODING;
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    int j;
    if (i < k)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        label60:
        if (j < arrayOfString.length) {
          if (arrayOfString[j].equalsIgnoreCase(str)) {
            ab.d("OpenVoice[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(localMediaCodecInfo.getName())));
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label169;
      }
      ab.e("OpenVoice[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.kJZ = 2001;
      i = -this.kJZ;
      AppMethodBeat.o(145844);
      return i;
      j += 1;
      break label60;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label169:
    ab.i("OpenVoice[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 4);
    str = this.mediaFormat.getString("mime");
    this.kKe = 1;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.fv(23)))
    {
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x1) == 0)) {
        break label517;
      }
      i = 1;
      if ((this.mProfileCfg <= 0) || ((this.mProfileCfg & 0x4) == 0)) {
        break label522;
      }
      j = 1;
      label351:
      boolean bool2 = b(localMediaCodecInfo, str);
      if ((j == 0) || (!bool2)) {
        break label527;
      }
      this.mediaFormat.setInteger("profile", 8);
      this.mediaFormat.setInteger("level", 256);
      bool1 = true;
      label398:
      if (!bool1) {
        break label583;
      }
    }
    label517:
    label522:
    label527:
    label583:
    for (this.kKe = this.mediaFormat.getInteger("profile");; this.kKe = 1)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.mediaCodec = MediaCodec.createEncoderByType(str);
        ab.i("OpenVoice[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.kKe);
        this.mediaCodec.configure(this.mediaFormat, null, null, 1);
        this.mediaCodec.start();
        this.kKd = new com.tencent.mm.plugin.voip.model.g();
        AppMethodBeat.o(145844);
        return 2000;
      }
      catch (Exception localException)
      {
        ab.e("OpenVoice[HWEnc]", " error:" + localException.toString());
        this.kJZ = 2002;
        i = -this.kJZ;
        AppMethodBeat.o(145844);
      }
      i = 0;
      break;
      j = 0;
      break label351;
      if (i != 0)
      {
        this.mediaFormat.setInteger("profile", 1);
        this.mediaFormat.setInteger("level", 256);
        bool1 = true;
        break label398;
      }
      if (localMediaCodecInfo == null) {
        break label398;
      }
      bool1 = a(localMediaCodecInfo, str, this.kKf);
      break label398;
    }
    return i;
  }
  
  private void s(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145849);
    int i = VFMT_i264;
    if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
      i = VFMT_HEVC_HW;
    }
    i = l.c(paramArrayOfByte, this.m_width, paramInt1, i);
    if (i > 0) {
      ab.d("OpenVoice[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
    }
    AppMethodBeat.o(145849);
  }
  
  @SuppressLint({"NewApi"})
  public final boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(145848);
    try
    {
      if (this.mediaCodec != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ab.v("OpenVoice[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.mediaCodec.setParameters(localBundle);
        AppMethodBeat.o(145848);
        return true;
      }
    }
    catch (Exception localException)
    {
      ab.e("OpenVoice[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(145848);
    }
    return false;
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 459
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_2
    //   7: aload_0
    //   8: getfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapW	I
    //   11: if_icmpne +11 -> 22
    //   14: iload_3
    //   15: aload_0
    //   16: getfield 162	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapH	I
    //   19: if_icmpeq +13 -> 32
    //   22: aload_0
    //   23: iload_2
    //   24: putfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapW	I
    //   27: aload_0
    //   28: iload_3
    //   29: putfield 162	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapH	I
    //   32: aload_0
    //   33: getfield 132	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKa	[B
    //   36: ifnonnull +22 -> 58
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapW	I
    //   44: aload_0
    //   45: getfield 162	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapH	I
    //   48: imul
    //   49: iconst_3
    //   50: imul
    //   51: iconst_2
    //   52: idiv
    //   53: newarray byte
    //   55: putfield 132	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKa	[B
    //   58: ldc 209
    //   60: new 168	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 461
    //   67: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 164	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_framerate	I
    //   74: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: ldc_w 463
    //   80: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_0
    //   84: getfield 166	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_br_kbps	I
    //   87: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 257	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: getfield 148	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKi	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/a;
    //   100: getfield 467	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/a:cSkipFlag	B
    //   103: ifne +1102 -> 1205
    //   106: aload_1
    //   107: aload_1
    //   108: arraylength
    //   109: aload_0
    //   110: getfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapW	I
    //   113: aload_0
    //   114: getfield 162	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_CapH	I
    //   117: iload 4
    //   119: aload_0
    //   120: getfield 132	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKa	[B
    //   123: invokestatic 471	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/l:videoHWProcess	([BIIII[B)I
    //   126: pop
    //   127: aload_0
    //   128: getfield 132	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKa	[B
    //   131: astore_1
    //   132: invokestatic 475	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/l:bhq	()Lcom/tencent/wxmm/v2conference;
    //   135: getfield 480	com/tencent/wxmm/v2conference:field_HWEncW	I
    //   138: istore_2
    //   139: invokestatic 475	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/l:bhq	()Lcom/tencent/wxmm/v2conference;
    //   142: getfield 483	com/tencent/wxmm/v2conference:field_HWEncH	I
    //   145: istore_3
    //   146: aload_0
    //   147: getfield 156	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_width	I
    //   150: iload_2
    //   151: if_icmpne +18 -> 169
    //   154: aload_0
    //   155: getfield 158	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_height	I
    //   158: iload_3
    //   159: if_icmpne +10 -> 169
    //   162: aload_0
    //   163: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   166: ifnonnull +266 -> 432
    //   169: ldc 209
    //   171: new 168	java/lang/StringBuilder
    //   174: dup
    //   175: ldc_w 485
    //   178: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: iload_2
    //   182: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc_w 487
    //   188: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_3
    //   192: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 489
    //   198: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 156	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_width	I
    //   205: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 487
    //   211: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: getfield 158	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_height	I
    //   218: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 300	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: iload_2
    //   229: putfield 156	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_width	I
    //   232: aload_0
    //   233: iload_3
    //   234: putfield 158	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_height	I
    //   237: aload_0
    //   238: aload_0
    //   239: getfield 156	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_width	I
    //   242: aload_0
    //   243: getfield 158	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:m_height	I
    //   246: imul
    //   247: iconst_3
    //   248: imul
    //   249: iconst_1
    //   250: ishr
    //   251: putfield 152	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:encLen	I
    //   254: aload_0
    //   255: invokespecial 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:bhm	()I
    //   258: istore_3
    //   259: iload_3
    //   260: istore_2
    //   261: iload_3
    //   262: ifge +172 -> 434
    //   265: ldc 209
    //   267: ldc_w 493
    //   270: iload_3
    //   271: invokestatic 444	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   274: invokevirtual 254	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   277: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: aload_0
    //   281: iconst_0
    //   282: putfield 150	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:isRuning	Z
    //   285: aload_0
    //   286: invokespecial 340	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:StopEncoder	()V
    //   289: aload_0
    //   290: getfield 202	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:outputStream	Ljava/io/BufferedOutputStream;
    //   293: ifnull +17 -> 310
    //   296: aload_0
    //   297: getfield 202	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:outputStream	Ljava/io/BufferedOutputStream;
    //   300: invokevirtual 496	java/io/BufferedOutputStream:flush	()V
    //   303: aload_0
    //   304: getfield 202	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:outputStream	Ljava/io/BufferedOutputStream;
    //   307: invokevirtual 499	java/io/BufferedOutputStream:close	()V
    //   310: aload_0
    //   311: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKc	Ljava/io/BufferedOutputStream;
    //   314: ifnull +17 -> 331
    //   317: aload_0
    //   318: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKc	Ljava/io/BufferedOutputStream;
    //   321: invokevirtual 496	java/io/BufferedOutputStream:flush	()V
    //   324: aload_0
    //   325: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKc	Ljava/io/BufferedOutputStream;
    //   328: invokevirtual 499	java/io/BufferedOutputStream:close	()V
    //   331: aload_0
    //   332: getfield 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKb	Landroid/media/MediaMuxer;
    //   335: ifnull +17 -> 352
    //   338: aload_0
    //   339: getfield 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKb	Landroid/media/MediaMuxer;
    //   342: invokevirtual 506	android/media/MediaMuxer:stop	()V
    //   345: aload_0
    //   346: getfield 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKb	Landroid/media/MediaMuxer;
    //   349: invokevirtual 507	android/media/MediaMuxer:release	()V
    //   352: ldc_w 459
    //   355: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: iload_3
    //   359: ireturn
    //   360: astore 7
    //   362: ldc 209
    //   364: new 168	java/lang/StringBuilder
    //   367: dup
    //   368: ldc_w 509
    //   371: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   374: aload 7
    //   376: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   379: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   388: aload_0
    //   389: sipush 2003
    //   392: putfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   395: aload_0
    //   396: getfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   399: ineg
    //   400: istore_3
    //   401: goto -142 -> 259
    //   404: astore_1
    //   405: ldc 209
    //   407: new 168	java/lang/StringBuilder
    //   410: dup
    //   411: ldc 211
    //   413: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   420: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto -77 -> 352
    //   432: iconst_0
    //   433: istore_2
    //   434: getstatic 69	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:frameID	I
    //   437: bipush 100
    //   439: if_icmpgt +416 -> 855
    //   442: aload_0
    //   443: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKc	Ljava/io/BufferedOutputStream;
    //   446: ifnull +409 -> 855
    //   449: aload_0
    //   450: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKc	Ljava/io/BufferedOutputStream;
    //   453: aload_0
    //   454: getfield 132	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKa	[B
    //   457: iconst_0
    //   458: aload_0
    //   459: getfield 152	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:encLen	I
    //   462: invokevirtual 512	java/io/BufferedOutputStream:write	([BII)V
    //   465: aload_1
    //   466: ifnull +703 -> 1169
    //   469: aload_0
    //   470: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   473: ifnull +696 -> 1169
    //   476: aload_0
    //   477: iconst_0
    //   478: putfield 146	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKh	I
    //   481: invokestatic 518	java/lang/System:currentTimeMillis	()J
    //   484: lstore 5
    //   486: ldc 209
    //   488: new 168	java/lang/StringBuilder
    //   491: dup
    //   492: ldc_w 520
    //   495: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   498: aload_0
    //   499: getfield 152	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:encLen	I
    //   502: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   505: ldc_w 522
    //   508: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: getstatic 69	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:frameID	I
    //   514: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   517: ldc_w 524
    //   520: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: lload 5
    //   525: invokevirtual 527	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   528: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 257	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload_0
    //   535: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   538: invokevirtual 531	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   541: astore 8
    //   543: aload_0
    //   544: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   547: invokevirtual 534	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   550: astore 7
    //   552: aload_0
    //   553: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   556: ldc2_w 535
    //   559: invokevirtual 540	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   562: istore_3
    //   563: iload_3
    //   564: iflt +71 -> 635
    //   567: aload_0
    //   568: getfield 136	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mGeneratedIdx	J
    //   571: ldc2_w 541
    //   574: lmul
    //   575: ldc2_w 543
    //   578: ldiv
    //   579: lstore 5
    //   581: aload 8
    //   583: iload_3
    //   584: aaload
    //   585: astore 8
    //   587: aload 8
    //   589: invokevirtual 550	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   592: pop
    //   593: aload 8
    //   595: aload_1
    //   596: iconst_0
    //   597: aload_0
    //   598: getfield 152	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:encLen	I
    //   601: invokevirtual 554	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   604: pop
    //   605: aload_0
    //   606: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   609: iload_3
    //   610: iconst_0
    //   611: aload_0
    //   612: getfield 152	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:encLen	I
    //   615: lload 5
    //   617: ldc2_w 555
    //   620: ladd
    //   621: iconst_0
    //   622: invokevirtual 560	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   625: aload_0
    //   626: aload_0
    //   627: getfield 136	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mGeneratedIdx	J
    //   630: lconst_1
    //   631: ladd
    //   632: putfield 136	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mGeneratedIdx	J
    //   635: new 562	android/media/MediaCodec$BufferInfo
    //   638: dup
    //   639: invokespecial 563	android/media/MediaCodec$BufferInfo:<init>	()V
    //   642: astore_1
    //   643: aload_0
    //   644: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   647: aload_1
    //   648: aload_0
    //   649: getfield 128	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:TIMEOUT_USEC	I
    //   652: i2l
    //   653: invokevirtual 567	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   656: istore_3
    //   657: iload_3
    //   658: bipush 254
    //   660: if_icmpne +552 -> 1212
    //   663: ldc 209
    //   665: ldc_w 569
    //   668: aload_0
    //   669: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   672: invokevirtual 573	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   675: invokestatic 250	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   678: invokevirtual 254	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   681: invokestatic 300	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   684: goto +528 -> 1212
    //   687: iload_3
    //   688: iflt +473 -> 1161
    //   691: aload 7
    //   693: iload_3
    //   694: aaload
    //   695: astore 8
    //   697: aload_1
    //   698: getfield 576	android/media/MediaCodec$BufferInfo:size	I
    //   701: newarray byte
    //   703: astore 9
    //   705: aload 8
    //   707: aload 9
    //   709: invokevirtual 580	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   712: pop
    //   713: aload_0
    //   714: getfield 202	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:outputStream	Ljava/io/BufferedOutputStream;
    //   717: ifnull +16 -> 733
    //   720: aload_0
    //   721: getfield 202	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:outputStream	Ljava/io/BufferedOutputStream;
    //   724: aload 9
    //   726: iconst_0
    //   727: aload 9
    //   729: arraylength
    //   730: invokevirtual 512	java/io/BufferedOutputStream:write	([BII)V
    //   733: aload_1
    //   734: getfield 583	android/media/MediaCodec$BufferInfo:flags	I
    //   737: iconst_2
    //   738: if_icmpne +240 -> 978
    //   741: aload_0
    //   742: getfield 140	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKe	I
    //   745: iconst_1
    //   746: if_icmpeq +154 -> 900
    //   749: aload_0
    //   750: getfield 138	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKd	Lcom/tencent/mm/plugin/voip/model/g;
    //   753: aload 9
    //   755: invokevirtual 587	com/tencent/mm/plugin/voip/model/g:bp	([B)Z
    //   758: ifeq +142 -> 900
    //   761: aload_0
    //   762: aload_0
    //   763: getfield 138	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKd	Lcom/tencent/mm/plugin/voip/model/g;
    //   766: getfield 590	com/tencent/mm/plugin/voip/model/g:tuv	I
    //   769: putfield 144	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKg	I
    //   772: aload_0
    //   773: iconst_1
    //   774: putfield 142	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKf	I
    //   777: ldc 209
    //   779: new 168	java/lang/StringBuilder
    //   782: dup
    //   783: ldc_w 592
    //   786: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   789: aload_0
    //   790: getfield 142	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKf	I
    //   793: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   796: ldc_w 594
    //   799: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_0
    //   803: getfield 144	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKg	I
    //   806: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   809: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 300	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload_0
    //   816: invokespecial 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:bhm	()I
    //   819: istore_2
    //   820: ldc_w 459
    //   823: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: iload_2
    //   827: ireturn
    //   828: astore 7
    //   830: ldc 209
    //   832: new 168	java/lang/StringBuilder
    //   835: dup
    //   836: ldc 211
    //   838: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: aload 7
    //   843: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   846: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   855: goto -390 -> 465
    //   858: astore_1
    //   859: ldc 209
    //   861: new 168	java/lang/StringBuilder
    //   864: dup
    //   865: ldc_w 596
    //   868: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   871: aload_1
    //   872: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   875: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   881: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   884: aload_0
    //   885: sipush 2005
    //   888: putfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   891: aload_0
    //   892: getfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   895: ineg
    //   896: istore_2
    //   897: goto -77 -> 820
    //   900: aload_0
    //   901: aload 9
    //   903: aload_1
    //   904: getfield 583	android/media/MediaCodec$BufferInfo:flags	I
    //   907: aload 9
    //   909: arraylength
    //   910: invokespecial 598	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:s	([BII)V
    //   913: aload_0
    //   914: getfield 600	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mMuxerStarted	Z
    //   917: ifeq +22 -> 939
    //   920: aload 8
    //   922: ifnull +17 -> 939
    //   925: aload_0
    //   926: getfield 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKb	Landroid/media/MediaMuxer;
    //   929: aload_0
    //   930: getfield 602	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mTrackIndex	I
    //   933: aload 8
    //   935: aload_1
    //   936: invokevirtual 606	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   939: aload_1
    //   940: getfield 583	android/media/MediaCodec$BufferInfo:flags	I
    //   943: istore_2
    //   944: getstatic 69	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:frameID	I
    //   947: iconst_1
    //   948: iadd
    //   949: putstatic 69	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:frameID	I
    //   952: aload_0
    //   953: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   956: iload_3
    //   957: iconst_0
    //   958: invokevirtual 610	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   961: aload_0
    //   962: getfield 207	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:mediaCodec	Landroid/media/MediaCodec;
    //   965: aload_1
    //   966: aload_0
    //   967: getfield 128	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:TIMEOUT_USEC	I
    //   970: i2l
    //   971: invokevirtual 567	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   974: istore_3
    //   975: goto -288 -> 687
    //   978: aload_0
    //   979: getfield 140	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKe	I
    //   982: iconst_1
    //   983: if_icmpeq +124 -> 1107
    //   986: aload_0
    //   987: getfield 138	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKd	Lcom/tencent/mm/plugin/voip/model/g;
    //   990: aload 9
    //   992: invokevirtual 613	com/tencent/mm/plugin/voip/model/g:bq	([B)Z
    //   995: ifeq +112 -> 1107
    //   998: aload_0
    //   999: aload_0
    //   1000: getfield 138	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKd	Lcom/tencent/mm/plugin/voip/model/g;
    //   1003: getfield 590	com/tencent/mm/plugin/voip/model/g:tuv	I
    //   1006: putfield 144	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKg	I
    //   1009: aload_0
    //   1010: iconst_1
    //   1011: putfield 142	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKf	I
    //   1014: ldc 209
    //   1016: new 168	java/lang/StringBuilder
    //   1019: dup
    //   1020: ldc_w 592
    //   1023: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1026: aload_0
    //   1027: getfield 142	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKf	I
    //   1030: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1033: ldc_w 594
    //   1036: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_0
    //   1040: getfield 144	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKg	I
    //   1043: invokevirtual 289	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokestatic 300	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1052: aload_0
    //   1053: invokespecial 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:bhm	()I
    //   1056: istore_2
    //   1057: ldc_w 459
    //   1060: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1063: iload_2
    //   1064: ireturn
    //   1065: astore_1
    //   1066: ldc 209
    //   1068: new 168	java/lang/StringBuilder
    //   1071: dup
    //   1072: ldc_w 596
    //   1075: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1078: aload_1
    //   1079: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1082: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1091: aload_0
    //   1092: sipush 2005
    //   1095: putfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1098: aload_0
    //   1099: getfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1102: ineg
    //   1103: istore_2
    //   1104: goto -47 -> 1057
    //   1107: aload_0
    //   1108: aload 9
    //   1110: aload_1
    //   1111: getfield 583	android/media/MediaCodec$BufferInfo:flags	I
    //   1114: aload 9
    //   1116: arraylength
    //   1117: invokespecial 598	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:s	([BII)V
    //   1120: goto -207 -> 913
    //   1123: astore_1
    //   1124: ldc 209
    //   1126: new 168	java/lang/StringBuilder
    //   1129: dup
    //   1130: ldc 211
    //   1132: invokespecial 212	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1135: aload_1
    //   1136: invokevirtual 213	java/lang/Exception:toString	()Ljava/lang/String;
    //   1139: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1145: invokestatic 219	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: aload_0
    //   1149: sipush 2004
    //   1152: putfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1155: aload_0
    //   1156: getfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1159: ineg
    //   1160: istore_2
    //   1161: ldc_w 459
    //   1164: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1167: iload_2
    //   1168: ireturn
    //   1169: aload_0
    //   1170: getfield 146	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKh	I
    //   1173: istore_3
    //   1174: aload_0
    //   1175: iload_3
    //   1176: iconst_1
    //   1177: iadd
    //   1178: putfield 146	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kKh	I
    //   1181: iload_3
    //   1182: iconst_5
    //   1183: if_icmple +19 -> 1202
    //   1186: aload_0
    //   1187: sipush 2006
    //   1190: putfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1193: aload_0
    //   1194: getfield 122	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/g:kJZ	I
    //   1197: ineg
    //   1198: istore_2
    //   1199: goto -38 -> 1161
    //   1202: goto -41 -> 1161
    //   1205: aconst_null
    //   1206: astore_1
    //   1207: iconst_0
    //   1208: istore_2
    //   1209: goto -744 -> 465
    //   1212: goto -525 -> 687
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1215	0	this	g
    //   0	1215	1	paramArrayOfByte	byte[]
    //   0	1215	2	paramInt1	int
    //   0	1215	3	paramInt2	int
    //   0	1215	4	paramInt3	int
    //   484	132	5	l	long
    //   360	15	7	localException1	Exception
    //   550	142	7	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   828	14	7	localException2	Exception
    //   541	393	8	localObject	Object
    //   703	412	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   254	259	360	java/lang/Exception
    //   285	310	404	java/lang/Exception
    //   310	331	404	java/lang/Exception
    //   331	352	404	java/lang/Exception
    //   449	465	828	java/lang/Exception
    //   815	820	858	java/lang/Exception
    //   1052	1057	1065	java/lang/Exception
    //   476	563	1123	java/lang/Exception
    //   567	581	1123	java/lang/Exception
    //   587	635	1123	java/lang/Exception
    //   635	657	1123	java/lang/Exception
    //   663	684	1123	java/lang/Exception
    //   697	733	1123	java/lang/Exception
    //   733	815	1123	java/lang/Exception
    //   859	897	1123	java/lang/Exception
    //   900	913	1123	java/lang/Exception
    //   913	920	1123	java/lang/Exception
    //   925	939	1123	java/lang/Exception
    //   939	975	1123	java/lang/Exception
    //   978	1052	1123	java/lang/Exception
    //   1066	1104	1123	java/lang/Exception
    //   1107	1120	1123	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.g
 * JD-Core Version:    0.7.0.1
 */