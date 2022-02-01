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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
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
  public long hni;
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
  private BufferedOutputStream outputStream;
  public int pdb;
  private z pdc;
  private byte[] pdd;
  private MediaMuxer pde;
  private int pdf;
  private boolean pdg;
  private BufferedOutputStream pdh;
  com.tencent.mm.plugin.voip.model.g pdi;
  public int pdj;
  public int pdk;
  public int pdl;
  public int pdm;
  a pdn;
  
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
    this.pdb = 0;
    this.ENCODING = "hevc";
    this.TIMEOUT_USEC = 12000;
    this.mProfileCfg = 1;
    this.pdd = null;
    this.configbyte = null;
    this.mGeneratedIdx = 0L;
    this.hni = 0L;
    this.pdi = null;
    this.pdj = 0;
    this.pdk = 8;
    this.pdl = 0;
    this.pdm = 0;
    this.pdn = null;
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
    paramString = new k(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      this.outputStream = new BufferedOutputStream(o.aj(paramString));
      frameID = 0;
      this.mGeneratedIdx = 0L;
      this.pdn = new a();
      this.pdc = null;
      this.pdk = 8;
      this.pdj = 0;
      this.pdl = 0;
      this.pdb = 0;
      this.pdd = null;
      this.pdm = 0;
      this.hni = 0L;
      AppMethodBeat.o(90802);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e("OpenVoice[HWEnc]", " error:" + paramString.toString());
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  private boolean SetBitRate(int paramInt)
  {
    AppMethodBeat.i(90805);
    try
    {
      if (this.pdc != null)
      {
        Bundle localBundle = new Bundle();
        paramInt *= 1000;
        ae.v("OpenVoice[HWEnc]", "steve: setRates: ".concat(String.valueOf(paramInt)));
        localBundle.putInt("video-bitrate", paramInt);
        this.pdc.setParameters(localBundle);
        AppMethodBeat.o(90805);
        return true;
      }
    }
    catch (Exception localException)
    {
      ae.e("OpenVoice[HWEnc]", "steve: setRates failed:".concat(String.valueOf(localException)));
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
      if (this.pdc != null)
      {
        this.pdc.stop();
        this.pdc.release();
      }
      AppMethodBeat.o(90803);
      return;
    }
    catch (Exception localException)
    {
      ae.e("OpenVoice[HWEnc]", " error:" + localException.toString());
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
          ae.d("OpenVoice[HWEnc]", "steve : known H.264 HW encoder :".concat(String.valueOf(paramMediaCodecInfo)));
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
    if (d.lA(23))
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
          ae.e("OpenVoice[HWEnc]", "trySetProfile error: " + paramMediaCodecInfo.getMessage());
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
        ae.i("OpenVoice[HWEnc]", "steve : profile: " + m + ", level: " + n + ", maxProfile: " + paramInt + ", isRecognized:" + bool1);
        i += 1;
      }
      ae.i("OpenVoice[HWEnc]", "best profile: " + paramString.profile + ", best level: " + paramString.level);
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
      if (8 <= this.pdk)
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
                ae.d("OpenVoice[HWEnc]", "steve : [" + str + "] supported profiles:" + localCodecProfileLevel.profile + ", maxAllowedProfile: " + this.pdk + ", MIME:" + paramString);
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
  private int cbj()
  {
    boolean bool1 = false;
    AppMethodBeat.i(90801);
    if (this.pdc != null) {
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
            ae.d("OpenVoice[HWEnc]", "steve : H.264 HW encoder found:".concat(String.valueOf(localMediaCodecInfo.getName())));
          }
        }
      }
    }
    for (;;)
    {
      if (localMediaCodecInfo != null) {
        break label169;
      }
      ae.e("OpenVoice[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
      this.pdb = 2001;
      i = -this.pdb;
      AppMethodBeat.o(90801);
      return i;
      j += 1;
      break label60;
      i += 1;
      break;
      localMediaCodecInfo = null;
    }
    label169:
    ae.i("OpenVoice[HWEnc]", "steve: found HW codec: " + localMediaCodecInfo.getName());
    this.mediaFormat = MediaFormat.createVideoFormat(this.ENCODING, this.m_width, this.m_height);
    this.mediaFormat.setInteger("color-format", 21);
    this.mediaFormat.setInteger("bitrate", this.m_br_kbps * 1000);
    this.mediaFormat.setInteger("frame-rate", this.m_framerate);
    this.mediaFormat.setInteger("i-frame-interval", 1);
    str = this.mediaFormat.getString("mime");
    this.pdj = 1;
    if ((this.ENCODING.equalsIgnoreCase("video/avc")) && (a(localMediaCodecInfo)) && (d.lA(23)))
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
    for (this.pdj = this.mediaFormat.getInteger("profile");; this.pdj = 1)
    {
      this.mediaFormat.setInteger("bitrate-mode", 2);
      try
      {
        this.pdc = z.q(str, false);
        ae.i("OpenVoice[HWEnc]", "steve: mediaFormat: " + this.mediaFormat + ", actProfile: " + this.pdj);
        this.pdc.a(this.mediaFormat, null, 1);
        this.pdc.start();
        this.pdi = new com.tencent.mm.plugin.voip.model.g();
        AppMethodBeat.o(90801);
        return 2000;
      }
      catch (Exception localException)
      {
        ae.e("OpenVoice[HWEnc]", " error:" + localException.toString());
        this.pdb = 2002;
        i = -this.pdb;
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
      bool1 = a(localMediaCodecInfo, str, this.pdk);
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
      ae.d("OpenVoice[HWEnc]", "steve: send successfully! frameLen = " + paramInt2 + ", type = " + paramInt1 + ", pkt cnt = " + i);
    }
    AppMethodBeat.o(90806);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(211562);
    if ((this.pdn == null) || (this.pdc == null))
    {
      AppMethodBeat.o(211562);
      return;
    }
    a locala = this.pdn;
    locala.iKbps = parama.iKbps;
    locala.cFps = parama.cFps;
    locala.cIPeriod = parama.cIPeriod;
    locala.cResolution = parama.cResolution;
    locala.pcF = parama.pcF;
    locala.pcG = parama.pcG;
    locala.cSkipFlag = parama.cSkipFlag;
    locala.cIReqFlag = parama.cIReqFlag;
    locala.cRsvd1 = parama.cRsvd1;
    int i = (int)(this.pdn.iKbps * 1.1D);
    if (this.m_br_kbps != i)
    {
      SetBitRate(i);
      ae.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + frameID + ", new_br: " + this.m_br_kbps + ", tuneBR:" + i);
      this.m_br_kbps = i;
    }
    if ((1 == this.pdn.cIReqFlag) && (frameID > 0))
    {
      if (this.pdc != null)
      {
        ae.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
        parama = new Bundle();
        parama.putInt("request-sync", 0);
        this.pdc.setParameters(parama);
      }
      ae.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + frameID);
    }
    if (this.pdn.cFps != this.m_framerate) {
      this.m_framerate = this.pdn.cFps;
    }
    AppMethodBeat.o(211562);
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
    //   36: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdd	[B
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
    //   58: putfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdd	[B
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
    //   96: invokestatic 289	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 151	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdn	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/a;
    //   103: getfield 488	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/a:cSkipFlag	B
    //   106: ifne +1179 -> 1285
    //   109: aload_1
    //   110: aload_1
    //   111: arraylength
    //   112: aload_0
    //   113: getfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   116: aload_0
    //   117: getfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   120: iload 4
    //   122: aload_0
    //   123: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdd	[B
    //   126: aload_0
    //   127: getfield 163	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapW	I
    //   130: aload_0
    //   131: getfield 165	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_CapH	I
    //   134: invokestatic 519	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:videoHWProcess	([BIIII[BII)I
    //   137: pop
    //   138: aload_0
    //   139: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdd	[B
    //   142: astore_1
    //   143: invokestatic 523	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:cbn	()Lcom/tencent/wxmm/v2conference;
    //   146: getfield 528	com/tencent/wxmm/v2conference:field_HWEncW	I
    //   149: istore_2
    //   150: invokestatic 523	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:cbn	()Lcom/tencent/wxmm/v2conference;
    //   153: getfield 531	com/tencent/wxmm/v2conference:field_HWEncH	I
    //   156: istore_3
    //   157: aload_0
    //   158: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   161: iload_2
    //   162: if_icmpne +18 -> 180
    //   165: aload_0
    //   166: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   169: iload_3
    //   170: if_icmpne +10 -> 180
    //   173: aload_0
    //   174: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   177: ifnonnull +266 -> 443
    //   180: ldc 215
    //   182: new 171	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 533
    //   189: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: iload_2
    //   193: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc_w 535
    //   199: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload_3
    //   203: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc_w 537
    //   209: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_0
    //   213: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   216: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc_w 535
    //   222: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   229: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: aload_0
    //   239: iload_2
    //   240: putfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   243: aload_0
    //   244: iload_3
    //   245: putfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 159	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_width	I
    //   253: aload_0
    //   254: getfield 161	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_height	I
    //   257: imul
    //   258: iconst_3
    //   259: imul
    //   260: iconst_1
    //   261: ishr
    //   262: putfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   265: aload_0
    //   266: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:cbj	()I
    //   269: istore_2
    //   270: iload_2
    //   271: istore_3
    //   272: iload_2
    //   273: ifge +172 -> 445
    //   276: ldc 215
    //   278: ldc_w 541
    //   281: iload_2
    //   282: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   285: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   288: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 153	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isRuning	Z
    //   296: aload_0
    //   297: invokespecial 370	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:StopEncoder	()V
    //   300: aload_0
    //   301: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   304: ifnull +17 -> 321
    //   307: aload_0
    //   308: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   311: invokevirtual 544	java/io/BufferedOutputStream:flush	()V
    //   314: aload_0
    //   315: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   318: invokevirtual 547	java/io/BufferedOutputStream:close	()V
    //   321: aload_0
    //   322: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdh	Ljava/io/BufferedOutputStream;
    //   325: ifnull +17 -> 342
    //   328: aload_0
    //   329: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdh	Ljava/io/BufferedOutputStream;
    //   332: invokevirtual 544	java/io/BufferedOutputStream:flush	()V
    //   335: aload_0
    //   336: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdh	Ljava/io/BufferedOutputStream;
    //   339: invokevirtual 547	java/io/BufferedOutputStream:close	()V
    //   342: aload_0
    //   343: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pde	Landroid/media/MediaMuxer;
    //   346: ifnull +17 -> 363
    //   349: aload_0
    //   350: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pde	Landroid/media/MediaMuxer;
    //   353: invokevirtual 554	android/media/MediaMuxer:stop	()V
    //   356: aload_0
    //   357: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pde	Landroid/media/MediaMuxer;
    //   360: invokevirtual 555	android/media/MediaMuxer:release	()V
    //   363: ldc_w 511
    //   366: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: iload_2
    //   370: ireturn
    //   371: astore 8
    //   373: ldc 215
    //   375: new 171	java/lang/StringBuilder
    //   378: dup
    //   379: ldc_w 557
    //   382: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   385: aload 8
    //   387: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   390: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload_0
    //   400: sipush 2003
    //   403: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   406: aload_0
    //   407: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   410: ineg
    //   411: istore_2
    //   412: goto -142 -> 270
    //   415: astore_1
    //   416: ldc 215
    //   418: new 171	java/lang/StringBuilder
    //   421: dup
    //   422: ldc 217
    //   424: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: aload_1
    //   428: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   431: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -77 -> 363
    //   443: iconst_0
    //   444: istore_3
    //   445: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   448: bipush 100
    //   450: if_icmpgt +465 -> 915
    //   453: aload_0
    //   454: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdh	Ljava/io/BufferedOutputStream;
    //   457: ifnull +458 -> 915
    //   460: aload_0
    //   461: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdh	Ljava/io/BufferedOutputStream;
    //   464: aload_0
    //   465: getfield 133	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdd	[B
    //   468: iconst_0
    //   469: aload_0
    //   470: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   473: invokevirtual 560	java/io/BufferedOutputStream:write	([BII)V
    //   476: iload_3
    //   477: istore_2
    //   478: aload_1
    //   479: ifnull +773 -> 1252
    //   482: aload_0
    //   483: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   486: ifnull +766 -> 1252
    //   489: aload_0
    //   490: iconst_0
    //   491: putfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdm	I
    //   494: invokestatic 566	java/lang/System:currentTimeMillis	()J
    //   497: lstore 6
    //   499: ldc 215
    //   501: new 171	java/lang/StringBuilder
    //   504: dup
    //   505: ldc_w 568
    //   508: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   511: aload_0
    //   512: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   515: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   518: ldc_w 570
    //   521: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   527: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc_w 572
    //   533: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: lload 6
    //   538: invokevirtual 575	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   541: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 289	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   551: invokevirtual 579	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   554: astore 9
    //   556: aload_0
    //   557: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   560: invokevirtual 582	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   563: astore 8
    //   565: aload_0
    //   566: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   569: ldc2_w 583
    //   572: invokevirtual 588	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   575: istore_3
    //   576: iload_3
    //   577: iflt +103 -> 680
    //   580: aload_0
    //   581: getfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   584: lstore 6
    //   586: aload_0
    //   587: getfield 167	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:m_framerate	I
    //   590: bipush 15
    //   592: invokestatic 594	java/lang/Math:max	(II)I
    //   595: bipush 30
    //   597: invokestatic 597	java/lang/Math:min	(II)I
    //   600: istore 4
    //   602: lload 6
    //   604: lconst_0
    //   605: lcmp
    //   606: ifeq +12 -> 618
    //   609: aload_0
    //   610: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:hni	J
    //   613: lconst_0
    //   614: lcmp
    //   615: ifne +305 -> 920
    //   618: aload_0
    //   619: ldc2_w 598
    //   622: putfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:hni	J
    //   625: aload_0
    //   626: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:hni	J
    //   629: lstore 6
    //   631: aload 9
    //   633: iload_3
    //   634: aaload
    //   635: astore 9
    //   637: aload 9
    //   639: invokevirtual 605	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   642: pop
    //   643: aload 9
    //   645: aload_1
    //   646: iconst_0
    //   647: aload_0
    //   648: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   651: invokevirtual 609	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   654: pop
    //   655: aload_0
    //   656: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   659: iload_3
    //   660: aload_0
    //   661: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:encLen	I
    //   664: lload 6
    //   666: iconst_0
    //   667: invokevirtual 612	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   670: aload_0
    //   671: aload_0
    //   672: getfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   675: lconst_1
    //   676: ladd
    //   677: putfield 137	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:mGeneratedIdx	J
    //   680: new 614	android/media/MediaCodec$BufferInfo
    //   683: dup
    //   684: invokespecial 615	android/media/MediaCodec$BufferInfo:<init>	()V
    //   687: astore_1
    //   688: aload_0
    //   689: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   692: aload_1
    //   693: aload_0
    //   694: getfield 129	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:TIMEOUT_USEC	I
    //   697: i2l
    //   698: invokevirtual 619	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   701: istore 5
    //   703: iload_2
    //   704: istore_3
    //   705: iload 5
    //   707: istore 4
    //   709: iload 5
    //   711: bipush 254
    //   713: if_icmpne +30 -> 743
    //   716: ldc 215
    //   718: ldc_w 621
    //   721: aload_0
    //   722: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   725: invokevirtual 625	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   728: invokestatic 263	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   731: invokevirtual 243	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   734: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: iload 5
    //   739: istore 4
    //   741: iload_2
    //   742: istore_3
    //   743: iload_3
    //   744: istore_2
    //   745: iload 4
    //   747: iflt +230 -> 977
    //   750: aload 8
    //   752: iload 4
    //   754: aaload
    //   755: astore 9
    //   757: aload_1
    //   758: getfield 628	android/media/MediaCodec$BufferInfo:size	I
    //   761: newarray byte
    //   763: astore 10
    //   765: aload 9
    //   767: aload 10
    //   769: invokevirtual 632	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   772: pop
    //   773: aload_0
    //   774: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   777: ifnull +16 -> 793
    //   780: aload_0
    //   781: getfield 208	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:outputStream	Ljava/io/BufferedOutputStream;
    //   784: aload 10
    //   786: iconst_0
    //   787: aload 10
    //   789: arraylength
    //   790: invokevirtual 560	java/io/BufferedOutputStream:write	([BII)V
    //   793: aload_1
    //   794: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   797: iconst_2
    //   798: if_icmpne +309 -> 1107
    //   801: aload_0
    //   802: getfield 143	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdj	I
    //   805: iconst_1
    //   806: if_icmpeq +221 -> 1027
    //   809: aload_0
    //   810: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdi	Lcom/tencent/mm/plugin/voip/model/g;
    //   813: aload 10
    //   815: invokevirtual 639	com/tencent/mm/plugin/voip/model/g:bQ	([B)Z
    //   818: ifeq +209 -> 1027
    //   821: aload_0
    //   822: aload_0
    //   823: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdi	Lcom/tencent/mm/plugin/voip/model/g;
    //   826: getfield 642	com/tencent/mm/plugin/voip/model/g:CpW	I
    //   829: putfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdl	I
    //   832: aload_0
    //   833: iconst_1
    //   834: putfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdk	I
    //   837: ldc 215
    //   839: new 171	java/lang/StringBuilder
    //   842: dup
    //   843: ldc_w 644
    //   846: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   849: aload_0
    //   850: getfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdk	I
    //   853: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   856: ldc_w 646
    //   859: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload_0
    //   863: getfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdl	I
    //   866: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   869: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   875: aload_0
    //   876: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:cbj	()I
    //   879: istore_2
    //   880: ldc_w 511
    //   883: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   886: iload_2
    //   887: ireturn
    //   888: astore 8
    //   890: ldc 215
    //   892: new 171	java/lang/StringBuilder
    //   895: dup
    //   896: ldc 217
    //   898: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   901: aload 8
    //   903: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   906: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: iload_3
    //   916: istore_2
    //   917: goto -439 -> 478
    //   920: aload_0
    //   921: aload_0
    //   922: getfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:hni	J
    //   925: ldc_w 647
    //   928: iload 4
    //   930: idiv
    //   931: i2l
    //   932: ladd
    //   933: putfield 139	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:hni	J
    //   936: goto -311 -> 625
    //   939: astore_1
    //   940: ldc 215
    //   942: new 171	java/lang/StringBuilder
    //   945: dup
    //   946: ldc 217
    //   948: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   951: aload_1
    //   952: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   955: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: aload_0
    //   965: sipush 2004
    //   968: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   971: aload_0
    //   972: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   975: ineg
    //   976: istore_2
    //   977: ldc_w 511
    //   980: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   983: iload_2
    //   984: ireturn
    //   985: astore_1
    //   986: ldc 215
    //   988: new 171	java/lang/StringBuilder
    //   991: dup
    //   992: ldc_w 649
    //   995: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   998: aload_1
    //   999: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1002: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1011: aload_0
    //   1012: sipush 2005
    //   1015: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1018: aload_0
    //   1019: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1022: ineg
    //   1023: istore_2
    //   1024: goto -144 -> 880
    //   1027: aload_0
    //   1028: aload 10
    //   1030: aload_1
    //   1031: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1034: aload 10
    //   1036: arraylength
    //   1037: invokespecial 651	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:u	([BII)V
    //   1040: aload_0
    //   1041: getfield 653	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdg	Z
    //   1044: ifeq +22 -> 1066
    //   1047: aload 9
    //   1049: ifnull +17 -> 1066
    //   1052: aload_0
    //   1053: getfield 551	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pde	Landroid/media/MediaMuxer;
    //   1056: aload_0
    //   1057: getfield 655	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdf	I
    //   1060: aload 9
    //   1062: aload_1
    //   1063: invokevirtual 659	android/media/MediaMuxer:writeSampleData	(ILjava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   1066: aload_1
    //   1067: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1070: istore_3
    //   1071: getstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   1074: iconst_1
    //   1075: iadd
    //   1076: putstatic 70	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:frameID	I
    //   1079: aload_0
    //   1080: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1083: iload 4
    //   1085: iconst_0
    //   1086: invokevirtual 663	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   1089: aload_0
    //   1090: getfield 213	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdc	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   1093: aload_1
    //   1094: aload_0
    //   1095: getfield 129	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:TIMEOUT_USEC	I
    //   1098: i2l
    //   1099: invokevirtual 619	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1102: istore 4
    //   1104: goto -361 -> 743
    //   1107: aload_0
    //   1108: getfield 143	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdj	I
    //   1111: iconst_1
    //   1112: if_icmpeq +124 -> 1236
    //   1115: aload_0
    //   1116: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1119: aload 10
    //   1121: invokevirtual 666	com/tencent/mm/plugin/voip/model/g:bR	([B)Z
    //   1124: ifeq +112 -> 1236
    //   1127: aload_0
    //   1128: aload_0
    //   1129: getfield 141	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdi	Lcom/tencent/mm/plugin/voip/model/g;
    //   1132: getfield 642	com/tencent/mm/plugin/voip/model/g:CpW	I
    //   1135: putfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdl	I
    //   1138: aload_0
    //   1139: iconst_1
    //   1140: putfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdk	I
    //   1143: ldc 215
    //   1145: new 171	java/lang/StringBuilder
    //   1148: dup
    //   1149: ldc_w 644
    //   1152: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1155: aload_0
    //   1156: getfield 145	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdk	I
    //   1159: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1162: ldc_w 646
    //   1165: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: aload_0
    //   1169: getfield 147	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdl	I
    //   1172: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1175: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1178: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1181: aload_0
    //   1182: invokespecial 539	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:cbj	()I
    //   1185: istore_2
    //   1186: ldc_w 511
    //   1189: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1192: iload_2
    //   1193: ireturn
    //   1194: astore_1
    //   1195: ldc 215
    //   1197: new 171	java/lang/StringBuilder
    //   1200: dup
    //   1201: ldc_w 649
    //   1204: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1207: aload_1
    //   1208: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1211: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 225	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1220: aload_0
    //   1221: sipush 2005
    //   1224: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1227: aload_0
    //   1228: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1231: ineg
    //   1232: istore_2
    //   1233: goto -47 -> 1186
    //   1236: aload_0
    //   1237: aload 10
    //   1239: aload_1
    //   1240: getfield 635	android/media/MediaCodec$BufferInfo:flags	I
    //   1243: aload 10
    //   1245: arraylength
    //   1246: invokespecial 651	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:u	([BII)V
    //   1249: goto -209 -> 1040
    //   1252: aload_0
    //   1253: getfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdm	I
    //   1256: istore_3
    //   1257: aload_0
    //   1258: iload_3
    //   1259: iconst_1
    //   1260: iadd
    //   1261: putfield 149	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdm	I
    //   1264: iload_3
    //   1265: iconst_5
    //   1266: if_icmple -289 -> 977
    //   1269: aload_0
    //   1270: sipush 2006
    //   1273: putfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1276: aload_0
    //   1277: getfield 123	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:pdb	I
    //   1280: ineg
    //   1281: istore_2
    //   1282: goto -305 -> 977
    //   1285: iconst_0
    //   1286: istore_2
    //   1287: aload 8
    //   1289: astore_1
    //   1290: goto -812 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1293	0	this	g
    //   0	1293	1	paramArrayOfByte	byte[]
    //   0	1293	2	paramInt1	int
    //   0	1293	3	paramInt2	int
    //   0	1293	4	paramInt3	int
    //   701	37	5	i	int
    //   497	168	6	l	long
    //   7	1	8	localObject1	Object
    //   371	15	8	localException1	Exception
    //   563	188	8	arrayOfByteBuffer	java.nio.ByteBuffer[]
    //   888	400	8	localException2	Exception
    //   554	507	9	localObject2	Object
    //   763	481	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   265	270	371	java/lang/Exception
    //   296	321	415	java/lang/Exception
    //   321	342	415	java/lang/Exception
    //   342	363	415	java/lang/Exception
    //   460	476	888	java/lang/Exception
    //   489	576	939	java/lang/Exception
    //   580	602	939	java/lang/Exception
    //   609	618	939	java/lang/Exception
    //   618	625	939	java/lang/Exception
    //   625	631	939	java/lang/Exception
    //   637	680	939	java/lang/Exception
    //   680	703	939	java/lang/Exception
    //   716	737	939	java/lang/Exception
    //   757	793	939	java/lang/Exception
    //   793	875	939	java/lang/Exception
    //   920	936	939	java/lang/Exception
    //   986	1024	939	java/lang/Exception
    //   1027	1040	939	java/lang/Exception
    //   1040	1047	939	java/lang/Exception
    //   1052	1066	939	java/lang/Exception
    //   1066	1104	939	java/lang/Exception
    //   1107	1181	939	java/lang/Exception
    //   1195	1233	939	java/lang/Exception
    //   1236	1249	939	java/lang/Exception
    //   875	880	985	java/lang/Exception
    //   1181	1186	1194	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.g
 * JD-Core Version:    0.7.0.1
 */