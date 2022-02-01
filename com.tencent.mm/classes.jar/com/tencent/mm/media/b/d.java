package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configBFrameFormat", "", "mediaFormat", "Landroid/media/MediaFormat;", "configToFormat", "enableSetBFrameToCodec", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends a
{
  public static final d.a nxN;
  public int bitrate;
  private int colorFormat;
  public int frameRate;
  public String mimeType;
  public String name;
  public int nxO;
  public int nxP;
  public int nxQ;
  public boolean nxR;
  public boolean nxS;
  private boolean nxT;
  public int nxU;
  public int nxV;
  private MediaCodecInfo nxW;
  
  static
  {
    AppMethodBeat.i(93521);
    nxN = new d.a((byte)0);
    AppMethodBeat.o(93521);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(93520);
    this.colorFormat = 2130708361;
    this.nxQ = 1;
    this.mimeType = "video/avc";
    Log.i("MicroMsg.VideoCodecConfig", s.X("init, enableHevc:", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.nxW = selectCodec("video/hevc");
      if (this.nxW == null)
      {
        Log.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
        this.nxW = selectCodec("video/avc");
        this.mimeType = "video/avc";
        com.tencent.mm.plugin.report.service.h.OAn.p(1280L, 61L, 1L);
      }
    }
    while (this.nxW == null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1047L, 0L, 1L);
      this.nxR = true;
      AppMethodBeat.o(93520);
      return;
      localObject = this.nxW;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((MediaCodecInfo)localObject).getName())
      {
        Log.i("MicroMsg.VideoCodecConfig", s.X("success select hevc codec:", localObject));
        this.mimeType = "video/hevc";
        com.tencent.mm.plugin.report.service.h.OAn.p(1280L, 60L, 1L);
        break;
      }
      this.nxW = selectCodec("video/avc");
      this.mimeType = "video/avc";
    }
    Object localObject = this.nxW;
    s.checkNotNull(localObject);
    this.name = ((MediaCodecInfo)localObject).getName();
    this.nxQ = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yJg, 1);
    Log.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.nxQ);
    AppMethodBeat.o(93520);
  }
  
  public final MediaFormat boH()
  {
    AppMethodBeat.i(93518);
    Log.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.nxO + ", targetHeight:" + this.nxP + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.colorFormat + ", iFrameInterval:" + this.nxQ + ", value: minQP:" + this.nxU + ", maxQP:" + this.nxV);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mimeType, this.nxO, this.nxP);
    s.s(localMediaFormat, "createVideoFormat(mimeTy…argetWidth, targetHeight)");
    Object localObject1 = this.nxW;
    s.checkNotNull(localObject1);
    a((MediaCodecInfo)localObject1, localMediaFormat, this.mimeType);
    localObject1 = this.nxW;
    s.checkNotNull(localObject1);
    Object localObject2 = this.mimeType;
    s.u(localObject1, "codecInfo");
    s.u(localMediaFormat, "mediaFormat");
    s.u(localObject2, "mimeType");
    for (;;)
    {
      try
      {
        if (com.tencent.mm.compatible.util.d.rb(21))
        {
          localObject1 = ((MediaCodecInfo)localObject1).getCapabilitiesForType((String)localObject2);
          if (localObject1 != null)
          {
            localObject1 = ((MediaCodecInfo.CodecCapabilities)localObject1).getEncoderCapabilities();
            if (localObject1 != null)
            {
              if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(1)) {
                continue;
              }
              Log.i("MicroMsg.VideoCodecConfig", "support vbr bitrate mode");
              localMediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        MultiProcessMMKV localMultiProcessMMKV;
        int i;
        int j;
        Log.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        Log.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
        continue;
        boolean bool = false;
        continue;
        Log.i("MicroMsg.VideoCodecConfig", "configBFrameFormat, not contain BFrameKey");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.frameRate);
      localMediaFormat.setInteger("color-format", this.colorFormat);
      localMediaFormat.setInteger("i-frame-interval", this.nxQ);
      if (this.nxS)
      {
        Log.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      if ((this.nxU != 0) && (this.nxV != 0))
      {
        localObject2 = MultiProcessMMKV.getMMKV("HardcoderQP");
        if (localObject2 != null)
        {
          localObject1 = ((MultiProcessMMKV)localObject2).decodeString("HCMinQPKey", null);
          localObject2 = ((MultiProcessMMKV)localObject2).decodeString("HCMaxQPKey", null);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localMediaFormat.setInteger((String)localObject2, this.nxV);
            localMediaFormat.setInteger((String)localObject1, this.nxU);
            this.nxT = true;
            Log.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + localObject1 + ", max:" + localObject2 + ", value: minQP:" + this.nxU + ", maxQP:" + this.nxV);
          }
        }
      }
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zwD, 1) != 1) {
        continue;
      }
      bool = true;
      Log.i("MicroMsg.VideoCodecConfig", s.X("enableSetBFrameToCodec:", Boolean.valueOf(bool)));
      if (bool)
      {
        localMultiProcessMMKV = MultiProcessMMKV.getMMKV("HardcoderBFrame");
        if (!localMultiProcessMMKV.containsKey("BFrameKey")) {
          continue;
        }
        localObject2 = localMultiProcessMMKV.getString("BFrameKey", "");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        i = localMultiProcessMMKV.getInt("BFrameKeyOptionOpen", -1);
        j = localMultiProcessMMKV.getInt("BFrameKeyOptionClose", -1);
        Log.i("MicroMsg.VideoCodecConfig", "configBFrameFormat, get BFrameKey:" + (String)localObject1 + ", BFrameKeyOptionOpen:" + i + ", BFrameKeyOptionClose:" + j);
        if ((!Util.isNullOrNil((String)localObject1)) && (i != -1) && (j != -1)) {
          localMediaFormat.setInteger((String)localObject1, i);
        }
        Log.i("MicroMsg.VideoCodecConfig", s.X("finished configBFrame, mediaFormat:", localMediaFormat));
      }
      Log.i("MicroMsg.VideoCodecConfig", "mediaFormat: %s", new Object[] { localMediaFormat });
      AppMethodBeat.o(93518);
      return localMediaFormat;
      if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(2)) {
        continue;
      }
      Log.i("MicroMsg.VideoCodecConfig", "support cbr bitrate mode");
      localMediaFormat.setInteger("bitrate-mode", 2);
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(93519);
    String str = "VideoCodecConfig(targetWidth=" + this.nxO + ", targetHeight=" + this.nxP + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.colorFormat + ", iFrameInterval=" + this.nxQ + ", name=" + this.name + ", initError=" + this.nxR + ", forceCQ=" + this.nxS + ", codecInfo=" + this.nxW + ')';
    AppMethodBeat.o(93519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.b.d
 * JD-Core Version:    0.7.0.1
 */