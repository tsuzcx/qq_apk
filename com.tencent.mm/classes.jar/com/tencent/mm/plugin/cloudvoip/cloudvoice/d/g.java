package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.BufferedOutputStream;
import java.io.File;

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
  public long gSc;
  public boolean isRuning;
  public long mGeneratedIdx;
  int mPrevResolution;
  int mProfileCfg;
  int m_CapH;
  int m_CapW;
  int m_br_kbps;
  int m_framerate;
  int m_height;
  int m_width;
  protected MediaFormat mediaFormat;
  public int otc;
  private z otd;
  private byte[] ote;
  private MediaMuxer otf;
  private int otg;
  private boolean oth;
  private BufferedOutputStream oti;
  com.tencent.mm.plugin.voip.model.g otj;
  public int otk;
  public int otl;
  public int otm;
  public int otn;
  a oto;
  private BufferedOutputStream outputStream;
  
  static
  {
    AppMethodBeat.i(90807);
    streamqueuesize = 100;
    frameID = 0;
    path = Environment.getExternalStorageDirectory().getAbsolutePath();
    VFMT_i264 = 18;
    VFMT_HEVC_HW = 19;
    SizeFormat2WH = new short[] { 128, 96, 240, 160, 320, 240, 480, 360, 640, 480 };
    supportedH264HwCodecPrefixes = new String[] { "OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK" };
    AppMethodBeat.o(90807);
  }
  
  public g(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(90802);
    this.otc = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.ote = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.gSc = 0L;
    this.otj = null;
    this.otk = 0;
    this.otl = 8;
    this.otm = 0;
    this.otn = 0;
    this.oto = null;
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
    paramString = new e(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      this.outputStream = new BufferedOutputStream(i.ah(paramString));
      frameID = 0;
      this.mGeneratedIdx = 0L;
      this.oto = new a();
      this.otd = null;
      this.otl = 8;
      this.otk = 0;
      this.otm = 0;
      this.otc = 0;
      this.ote = null;
      this.otn = 0;
      this.gSc = 0L;
      AppMethodBeat.o(90802);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e("OpenVoice[HWEnc]", " error:" + paramString.toString());
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(90805);
    try
    {
      if (this.otd != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ac.v("OpenVoice[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.otd.setParameters(localBundle);
        AppMethodBeat.o(90805);
        return true;
      }
    }
    catch (Exception localException)
    {
      ac.e("OpenVoice[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
      AppMethodBeat.o(90805);
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private void StopEncoder()
  {
    AppMethodBeat.i(90803);
    try
    {
      if (this.otd != null)
      {
        this.otd.stop();
        this.otd.release();
      }
      AppMethodBeat.o(90803);
      return;
    }
    catch (Exception localException)
    {
      ac.e("OpenVoice[HWEnc]", " error:" + localException.toString());
      AppMethodBeat.o(90803);
    }
  }
  
  private static boolean a(MediaCodecInfo paramMediaCodecInfo)
  {
    boolean bool2 = false;
    AppMethodBeat.i(90800);
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
          ac.d("OpenVoice[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
        }
      }
      else
      {
        AppMethodBeat.o(90800);
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    AppMethodBeat.i(90799);
    bool2 = false;
    bool1 = bool2;
    if (d.kZ(23))
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
          ac.e("OpenVoice[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        ac.i("OpenVoice[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ac.i("OpenVoice[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
    AppMethodBeat.o(90799);
    return bool1;
  }
  
  @SuppressLint({"NewApi"})
  private boolean b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(90798);
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (Build.VERSION.SDK_INT >= 18)
    {
      bool2 = bool3;
      if (8 <= this.otl)
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
                ac.d("OpenVoice[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.otl + ", MIME:" + paramString);
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
    AppMethodBeat.o(90798);
    return bool2;
  }
  
  @SuppressLint({"NewApi"})
  private int bVq()
  {
    boolean bool1 = false;
    AppMethodBeat.i(90801);
    if (this.otd != null) {
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
            ac.d("OpenVoice[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(localMediaCodecInfo.getName())));
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label169;
      }
      ac.e("OpenVoice[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.otc = 2001;
      i = -this.otc;
      AppMethodBeat.o(90801);
      return i;
      j += 1;
      break label60;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label169:
    ac.i("OpenVoice[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 1);
    str = this.mediaFormat.getString("mime");
    this.otk = 1;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.kZ(23)))
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
    for (this.otk = this.mediaFormat.getInteger("profile");; this.otk = 1)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.otd = z.q(str, false);
        ac.i("OpenVoice[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.otk);
        this.otd.a(this.mediaFormat, null, 1);
        this.otd.start();
        this.otj = new com.tencent.mm.plugin.voip.model.g();
        AppMethodBeat.o(90801);
        return 2000;
      }
      catch (Exception localException)
      {
        ac.e("OpenVoice[HWEnc]", " error:" + localException.toString());
        this.otc = 2002;
        i = -this.otc;
        AppMethodBeat.o(90801);
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
      bool1 = a(localMediaCodecInfo, str, this.otl);
      break label398;
    }
    return i;
  }
  
  private void u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90806);
    int i = VFMT_i264;
    if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
      i = VFMT_HEVC_HW;
    }
    i = l.c(paramArrayOfByte, this.m_width, paramInt1, i);
    if (i > 0) {
      ac.d("OpenVoice[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
    }
    AppMethodBeat.o(90806);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(200740);
    if ((this.oto == null) || (this.otd == null))
    {
      AppMethodBeat.o(200740);
      return;
    }
    a locala = this.oto;
    locala.iKbps = parama.iKbps;
    locala.cFps = parama.cFps;
    locala.cIPeriod = parama.cIPeriod;
    locala.cResolution = parama.cResolution;
    locala.osG = parama.osG;
    locala.osH = parama.osH;
    locala.cSkipFlag = parama.cSkipFlag;
    locala.cIReqFlag = parama.cIReqFlag;
    locala.cRsvd1 = parama.cRsvd1;
    int i = (int)(this.oto.iKbps * 1.1D);
    if (this.m_br_kbps != i)
    {
      SetBitRate(i);
      ac.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + i);
      this.m_br_kbps = i;
    }
    if ((1 == this.oto.cIReqFlag) && (frameID > 0))
    {
      if (this.otd != null)
      {
        ac.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
        parama = new Bundle();
        parama.putInt("request-sync", 0);
        this.otd.setParameters(parama);
      }
      ac.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
    }
    if (this.oto.cFps != this.m_framerate) {
      this.m_framerate = this.oto.cFps;
    }
    AppMethodBeat.o(200740);
  }
  
  /* Error */
  public final int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc_w 511
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 8
    //   9: iload_2
    //   10: aload_0
    //   11: getfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   14: if_icmpne +11 -> 25
    //   17: iload_3
    //   18: aload_0
    //   19: getfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   22: if_icmpeq +13 -> 35
    //   25: aload_0
    //   26: iload_2
    //   27: putfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   30: aload_0
    //   31: iload_3
    //   32: putfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   35: aload_0
    //   36: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:ote	[B
    //   39: ifnonnull +22 -> 61
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   47: aload_0
    //   48: getfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   51: imul
    //   52: iconst_3
    //   53: imul
    //   54: iconst_2
    //   55: idiv
    //   56: newarray byte
    //   58: putfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:ote	[B
    //   61: ldc 215
    //   63: new 171	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 513
    //   70: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 167	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_framerate	I
    //   77: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 515
    //   83: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_0
    //   87: getfield 169	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_br_kbps	I
    //   90: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 289	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 151	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oto	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/a;
    //   103: getfield 488	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/a:cSkipFlag	B
    //   106: ifne +1171 -> 1277
    //   109: aload_1
    //   110: aload_1
    //   111: arraylength
    //   112: aload_0
    //   113: getfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   116: aload_0
    //   117: getfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   120: iload 4
    //   122: aload_0
    //   123: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:ote	[B
    //   126: invokestatic 519	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:videoHWProcess	([BIIII[B)I
    //   129: pop
    //   130: aload_0
    //   131: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:ote	[B
    //   134: astore_1
    //   135: invokestatic 523	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:bVu	()Lcom/tencent/wxmm/v2conference;
    //   138: getfield 528	com/tencent/wxmm/v2conference:field_HWEncW	I
    //   141: istore_2
    //   142: invokestatic 523	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:bVu	()Lcom/tencent/wxmm/v2conference;
    //   145: getfield 531	com/tencent/wxmm/v2conference:field_HWEncH	I
    //   148: istore_3
    //   149: aload_0
    //   150: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   153: iload_2
    //   154: if_icmpne +18 -> 172
    //   157: aload_0
    //   158: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   161: iload_3
    //   162: if_icmpne +10 -> 172
    //   165: aload_0
    //   166: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   169: ifnonnull +266 -> 435
    //   172: ldc 215
    //   174: new 171	java/lang/StringBuilder
    //   177: dup
    //   178: ldc_w 533
    //   181: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   184: iload_2
    //   185: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 535
    //   191: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_3
    //   195: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: ldc_w 537
    //   201: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   208: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 535
    //   214: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_0
    //   218: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   221: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 331	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_0
    //   231: iload_2
    //   232: putfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   235: aload_0
    //   236: iload_3
    //   237: putfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   245: aload_0
    //   246: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   249: imul
    //   250: iconst_3
    //   251: imul
    //   252: iconst_1
    //   253: ishr
    //   254: putfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   257: aload_0
    //   258: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:bVq	()I
    //   261: istore_2
    //   262: iload_2
    //   263: istore_3
    //   264: iload_2
    //   265: ifge +172 -> 437
    //   268: ldc 215
    //   270: ldc_w 541
    //   273: iload_2
    //   274: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   277: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   280: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload_0
    //   284: iconst_0
    //   285: putfield 153	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isRuning	Z
    //   288: aload_0
    //   289: invokespecial 370	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:StopEncoder	()V
    //   292: aload_0
    //   293: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   296: ifnull +17 -> 313
    //   299: aload_0
    //   300: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   303: invokevirtual 544	java/io/BufferedOutputStream:flush	()V
    //   306: aload_0
    //   307: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   310: invokevirtual 547	java/io/BufferedOutputStream:close	()V
    //   313: aload_0
    //   314: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oti	Ljava/io/BufferedOutputStream;
    //   317: ifnull +17 -> 334
    //   320: aload_0
    //   321: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oti	Ljava/io/BufferedOutputStream;
    //   324: invokevirtual 544	java/io/BufferedOutputStream:flush	()V
    //   327: aload_0
    //   328: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oti	Ljava/io/BufferedOutputStream;
    //   331: invokevirtual 547	java/io/BufferedOutputStream:close	()V
    //   334: aload_0
    //   335: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otf	Landroid/media/MediaMuxer;
    //   338: ifnull +17 -> 355
    //   341: aload_0
    //   342: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otf	Landroid/media/MediaMuxer;
    //   345: invokevirtual 554	android/media/MediaMuxer:stop	()V
    //   348: aload_0
    //   349: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otf	Landroid/media/MediaMuxer;
    //   352: invokevirtual 555	android/media/MediaMuxer:release	()V
    //   355: ldc_w 511
    //   358: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   361: iload_2
    //   362: ireturn
    //   363: astore 8
    //   365: ldc 215
    //   367: new 171	java/lang/StringBuilder
    //   370: dup
    //   371: ldc_w 557
    //   374: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: aload 8
    //   379: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   382: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_0
    //   392: sipush 2003
    //   395: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   398: aload_0
    //   399: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   402: ineg
    //   403: istore_2
    //   404: goto -142 -> 262
    //   407: astore_1
    //   408: ldc 215
    //   410: new 171	java/lang/StringBuilder
    //   413: dup
    //   414: ldc 217
    //   416: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: aload_1
    //   420: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   423: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: goto -77 -> 355
    //   435: iconst_0
    //   436: istore_3
    //   437: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   440: bipush 100
    //   442: if_icmpgt +465 -> 907
    //   445: aload_0
    //   446: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oti	Ljava/io/BufferedOutputStream;
    //   449: ifnull +458 -> 907
    //   452: aload_0
    //   453: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oti	Ljava/io/BufferedOutputStream;
    //   456: aload_0
    //   457: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:ote	[B
    //   460: iconst_0
    //   461: aload_0
    //   462: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   465: invokevirtual 560	java/io/BufferedOutputStream:write	([BII)V
    //   468: iload_3
    //   469: istore_2
    //   470: aload_1
    //   471: ifnull +773 -> 1244
    //   474: aload_0
    //   475: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   478: ifnull +766 -> 1244
    //   481: aload_0
    //   482: iconst_0
    //   483: putfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otn	I
    //   486: invokestatic 566	java/lang/System:currentTimeMillis	()J
    //   489: lstore 6
    //   491: ldc 215
    //   493: new 171	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 568
    //   500: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload_0
    //   504: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   507: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: ldc_w 570
    //   513: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   519: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: ldc_w 572
    //   525: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: lload 6
    //   530: invokevirtual 575	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   533: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 289	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   539: aload_0
    //   540: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   543: invokevirtual 579	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   546: astore 9
    //   548: aload_0
    //   549: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   552: invokevirtual 582	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   555: astore 8
    //   557: aload_0
    //   558: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   561: ldc2_w 583
    //   564: invokevirtual 588	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   567: istore_3
    //   568: iload_3
    //   569: iflt +103 -> 672
    //   572: aload_0
    //   573: getfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   576: lstore 6
    //   578: aload_0
    //   579: getfield 167	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_framerate	I
    //   582: bipush 15
    //   584: invokestatic 594	java/lang/Math:max	(II)I
    //   587: bipush 30
    //   589: invokestatic 597	java/lang/Math:min	(II)I
    //   592: istore 4
    //   594: lload 6
    //   596: lconst_0
    //   597: lcmp
    //   598: ifeq +12 -> 610
    //   601: aload_0
    //   602: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:gSc	J
    //   605: lconst_0
    //   606: lcmp
    //   607: ifne +305 -> 912
    //   610: aload_0
    //   611: ldc2_w 598
    //   614: putfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:gSc	J
    //   617: aload_0
    //   618: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:gSc	J
    //   621: lstore 6
    //   623: aload 9
    //   625: iload_3
    //   626: aaload
    //   627: astore 9
    //   629: aload 9
    //   631: invokevirtual 605	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   634: pop
    //   635: aload 9
    //   637: aload_1
    //   638: iconst_0
    //   639: aload_0
    //   640: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   643: invokevirtual 609	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   646: pop
    //   647: aload_0
    //   648: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   651: iload_3
    //   652: aload_0
    //   653: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   656: lload 6
    //   658: iconst_0
    //   659: invokevirtual 612	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   667: lconst_1
    //   668: ladd
    //   669: putfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   672: new 614	android/media/MediaCodec$BufferInfo
    //   675: dup
    //   676: invokespecial 615	android/media/MediaCodec$BufferInfo:<init>	()V
    //   679: astore_1
    //   680: aload_0
    //   681: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   684: aload_1
    //   685: aload_0
    //   686: getfield 129	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:TIMEOUT_USEC	I
    //   689: i2l
    //   690: invokevirtual 619	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   693: istore 5
    //   695: iload_2
    //   696: istore_3
    //   697: iload 5
    //   699: istore 4
    //   701: iload 5
    //   703: bipush 254
    //   705: if_icmpne +30 -> 735
    //   708: ldc 215
    //   710: ldc_w 621
    //   713: aload_0
    //   714: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   717: invokevirtual 625	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   720: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   723: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   726: invokestatic 331	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   729: iload 5
    //   731: istore 4
    //   733: iload_2
    //   734: istore_3
    //   735: iload_3
    //   736: istore_2
    //   737: iload 4
    //   739: iflt +230 -> 969
    //   742: aload 8
    //   744: iload 4
    //   746: aaload
    //   747: astore 9
    //   749: aload_1
    //   750: getfield 628	android/media/MediaCodec$BufferInfo:size	I
    //   753: newarray byte
    //   755: astore 10
    //   757: aload 9
    //   759: aload 10
    //   761: invokevirtual 632	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   764: pop
    //   765: aload_0
    //   766: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   769: ifnull +16 -> 785
    //   772: aload_0
    //   773: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   776: aload 10
    //   778: iconst_0
    //   779: aload 10
    //   781: arraylength
    //   782: invokevirtual 560	java/io/BufferedOutputStream:write	([BII)V
    //   785: aload_1
    //   786: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   789: iconst_2
    //   790: if_icmpne +309 -> 1099
    //   793: aload_0
    //   794: getfield 143	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otk	I
    //   797: iconst_1
    //   798: if_icmpeq +221 -> 1019
    //   801: aload_0
    //   802: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   805: aload 10
    //   807: invokevirtual 639	com/tencent/mm/plugin/voip/model/g:bG	([B)Z
    //   810: ifeq +209 -> 1019
    //   813: aload_0
    //   814: aload_0
    //   815: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   818: getfield 642	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   821: putfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otm	I
    //   824: aload_0
    //   825: iconst_1
    //   826: putfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otl	I
    //   829: ldc 215
    //   831: new 171	java/lang/StringBuilder
    //   834: dup
    //   835: ldc_w 644
    //   838: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: aload_0
    //   842: getfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otl	I
    //   845: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   848: ldc_w 646
    //   851: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload_0
    //   855: getfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otm	I
    //   858: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   861: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 331	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   867: aload_0
    //   868: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:bVq	()I
    //   871: istore_2
    //   872: ldc_w 511
    //   875: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   878: iload_2
    //   879: ireturn
    //   880: astore 8
    //   882: ldc 215
    //   884: new 171	java/lang/StringBuilder
    //   887: dup
    //   888: ldc 217
    //   890: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   893: aload 8
    //   895: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   898: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: iload_3
    //   908: istore_2
    //   909: goto -439 -> 470
    //   912: aload_0
    //   913: aload_0
    //   914: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:gSc	J
    //   917: ldc_w 647
    //   920: iload 4
    //   922: idiv
    //   923: i2l
    //   924: ladd
    //   925: putfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:gSc	J
    //   928: goto -311 -> 617
    //   931: astore_1
    //   932: ldc 215
    //   934: new 171	java/lang/StringBuilder
    //   937: dup
    //   938: ldc 217
    //   940: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   943: aload_1
    //   944: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   947: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   956: aload_0
    //   957: sipush 2004
    //   960: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   963: aload_0
    //   964: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   967: ineg
    //   968: istore_2
    //   969: ldc_w 511
    //   972: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   975: iload_2
    //   976: ireturn
    //   977: astore_1
    //   978: ldc 215
    //   980: new 171	java/lang/StringBuilder
    //   983: dup
    //   984: ldc_w 649
    //   987: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   990: aload_1
    //   991: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   994: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1000: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1003: aload_0
    //   1004: sipush 2005
    //   1007: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1010: aload_0
    //   1011: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1014: ineg
    //   1015: istore_2
    //   1016: goto -144 -> 872
    //   1019: aload_0
    //   1020: aload 10
    //   1022: aload_1
    //   1023: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1026: aload 10
    //   1028: arraylength
    //   1029: invokespecial 651	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:u	([BII)V
    //   1032: aload_0
    //   1033: getfield 653	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:oth	Z
    //   1036: ifeq +22 -> 1058
    //   1039: aload 9
    //   1041: ifnull +17 -> 1058
    //   1044: aload_0
    //   1045: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otf	Landroid/media/MediaMuxer;
    //   1048: aload_0
    //   1049: getfield 655	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otg	I
    //   1052: aload 9
    //   1054: aload_1
    //   1055: invokevirtual 659	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   1058: aload_1
    //   1059: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1062: istore_3
    //   1063: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   1066: iconst_1
    //   1067: iadd
    //   1068: putstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   1071: aload_0
    //   1072: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1075: iload 4
    //   1077: iconst_0
    //   1078: invokevirtual 663	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   1081: aload_0
    //   1082: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otd	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1085: aload_1
    //   1086: aload_0
    //   1087: getfield 129	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:TIMEOUT_USEC	I
    //   1090: i2l
    //   1091: invokevirtual 619	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1094: istore 4
    //   1096: goto -361 -> 735
    //   1099: aload_0
    //   1100: getfield 143	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otk	I
    //   1103: iconst_1
    //   1104: if_icmpeq +124 -> 1228
    //   1107: aload_0
    //   1108: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1111: aload 10
    //   1113: invokevirtual 666	com/tencent/mm/plugin/voip/model/g:bH	([B)Z
    //   1116: ifeq +112 -> 1228
    //   1119: aload_0
    //   1120: aload_0
    //   1121: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otj	Lcom/tencent/mm/plugin/voip/model/g;
    //   1124: getfield 642	com/tencent/mm/plugin/voip/model/g:Azv	I
    //   1127: putfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otm	I
    //   1130: aload_0
    //   1131: iconst_1
    //   1132: putfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otl	I
    //   1135: ldc 215
    //   1137: new 171	java/lang/StringBuilder
    //   1140: dup
    //   1141: ldc_w 644
    //   1144: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1147: aload_0
    //   1148: getfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otl	I
    //   1151: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1154: ldc_w 646
    //   1157: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: aload_0
    //   1161: getfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otm	I
    //   1164: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1170: invokestatic 331	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1173: aload_0
    //   1174: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:bVq	()I
    //   1177: istore_2
    //   1178: ldc_w 511
    //   1181: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1184: iload_2
    //   1185: ireturn
    //   1186: astore_1
    //   1187: ldc 215
    //   1189: new 171	java/lang/StringBuilder
    //   1192: dup
    //   1193: ldc_w 649
    //   1196: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1199: aload_1
    //   1200: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1203: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokestatic 225	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload_0
    //   1213: sipush 2005
    //   1216: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1219: aload_0
    //   1220: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1223: ineg
    //   1224: istore_2
    //   1225: goto -47 -> 1178
    //   1228: aload_0
    //   1229: aload 10
    //   1231: aload_1
    //   1232: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1235: aload 10
    //   1237: arraylength
    //   1238: invokespecial 651	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:u	([BII)V
    //   1241: goto -209 -> 1032
    //   1244: aload_0
    //   1245: getfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otn	I
    //   1248: istore_3
    //   1249: aload_0
    //   1250: iload_3
    //   1251: iconst_1
    //   1252: iadd
    //   1253: putfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otn	I
    //   1256: iload_3
    //   1257: iconst_5
    //   1258: if_icmple -289 -> 969
    //   1261: aload_0
    //   1262: sipush 2006
    //   1265: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1268: aload_0
    //   1269: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:otc	I
    //   1272: ineg
    //   1273: istore_2
    //   1274: goto -305 -> 969
    //   1277: iconst_0
    //   1278: istore_2
    //   1279: aload 8
    //   1281: astore_1
    //   1282: goto -812 -> 470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1285	0	this	g
    //   0	1285	1	paramArrayOfByte	byte[]
    //   0	1285	2	paramInt1	int
    //   0	1285	3	paramInt2	int
    //   0	1285	4	paramInt3	int
    //   693	37	5	i	int
    //   489	168	6	l	long
    //   7	1	8	localObject1	Object
    //   363	15	8	localException1	Exception
    //   555	188	8	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   880	400	8	localException2	Exception
    //   546	507	9	localObject2	Object
    //   755	481	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   257	262	363	java/lang/Exception
    //   288	313	407	java/lang/Exception
    //   313	334	407	java/lang/Exception
    //   334	355	407	java/lang/Exception
    //   452	468	880	java/lang/Exception
    //   481	568	931	java/lang/Exception
    //   572	594	931	java/lang/Exception
    //   601	610	931	java/lang/Exception
    //   610	617	931	java/lang/Exception
    //   617	623	931	java/lang/Exception
    //   629	672	931	java/lang/Exception
    //   672	695	931	java/lang/Exception
    //   708	729	931	java/lang/Exception
    //   749	785	931	java/lang/Exception
    //   785	867	931	java/lang/Exception
    //   912	928	931	java/lang/Exception
    //   978	1016	931	java/lang/Exception
    //   1019	1032	931	java/lang/Exception
    //   1032	1039	931	java/lang/Exception
    //   1044	1058	931	java/lang/Exception
    //   1058	1096	931	java/lang/Exception
    //   1099	1173	931	java/lang/Exception
    //   1187	1225	931	java/lang/Exception
    //   1228	1241	931	java/lang/Exception
    //   867	872	977	java/lang/Exception
    //   1173	1178	1186	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g
 * JD-Core Version:    0.7.0.1
 */