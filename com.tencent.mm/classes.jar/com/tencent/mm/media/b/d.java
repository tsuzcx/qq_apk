package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configToFormat", "Landroid/media/MediaFormat;", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a hkM;
  public int bitrate;
  public int frameRate;
  private int hkE;
  public int hkF;
  public boolean hkG;
  public boolean hkH;
  private boolean hkI;
  public int hkJ;
  public int hkK;
  private MediaCodecInfo hkL;
  public String mimeType;
  public String name;
  public int targetHeight;
  public int targetWidth;
  
  static
  {
    AppMethodBeat.i(93521);
    hkM = new d.a((byte)0);
    AppMethodBeat.o(93521);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(93520);
    this.hkE = 2130708361;
    this.hkF = 1;
    this.mimeType = "video/avc";
    ae.i("MicroMsg.VideoCodecConfig", "init, enableHevc:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.hkL = selectCodec("video/hevc");
      if (this.hkL == null)
      {
        ae.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
        this.hkL = selectCodec("video/avc");
        this.mimeType = "video/avc";
        com.tencent.mm.plugin.report.service.g.yxI.n(1280L, 61L, 1L);
      }
    }
    while (this.hkL == null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(1047L, 0L, 1L);
      this.hkG = true;
      AppMethodBeat.o(93520);
      return;
      StringBuilder localStringBuilder = new StringBuilder("success select hevc codec:");
      localObject = this.hkL;
      if (localObject != null) {}
      for (localObject = ((MediaCodecInfo)localObject).getName();; localObject = null)
      {
        ae.i("MicroMsg.VideoCodecConfig", (String)localObject);
        this.mimeType = "video/hevc";
        com.tencent.mm.plugin.report.service.g.yxI.n(1280L, 60L, 1L);
        break;
      }
      this.hkL = selectCodec("video/avc");
      this.mimeType = "video/avc";
    }
    Object localObject = this.hkL;
    if (localObject == null) {
      p.gkB();
    }
    this.name = ((MediaCodecInfo)localObject).getName();
    this.hkF = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qxX, 1);
    ae.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.hkF);
    AppMethodBeat.o(93520);
  }
  
  public final MediaFormat atu()
  {
    AppMethodBeat.i(93518);
    ae.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.targetWidth + ", targetHeight:" + this.targetHeight + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.hkE + ", iFrameInterval:" + this.hkF + ", value: minQP:" + this.hkJ + ", maxQP:" + this.hkK);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mimeType, this.targetWidth, this.targetHeight);
    Object localObject1 = this.hkL;
    if (localObject1 == null) {
      p.gkB();
    }
    p.g(localMediaFormat, "mediaFormat");
    a((MediaCodecInfo)localObject1, localMediaFormat, this.mimeType);
    localObject1 = this.hkL;
    if (localObject1 == null) {
      p.gkB();
    }
    Object localObject2 = this.mimeType;
    p.h(localObject1, "codecInfo");
    p.h(localMediaFormat, "mediaFormat");
    p.h(localObject2, "mimeType");
    for (;;)
    {
      try
      {
        if (com.tencent.mm.compatible.util.d.lA(21))
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
              ae.i("MicroMsg.VideoCodecConfig", "support vbr bitrate mode");
              localMediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        ae.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.frameRate);
      localMediaFormat.setInteger("color-format", this.hkE);
      localMediaFormat.setInteger("i-frame-interval", this.hkF);
      if (this.hkH)
      {
        ae.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      if ((this.hkJ != 0) && (this.hkK != 0))
      {
        localObject2 = ay.aRW("HardcoderQP");
        if (localObject2 != null)
        {
          localObject1 = ((ay)localObject2).decodeString("HCMinQPKey", null);
          localObject2 = ((ay)localObject2).decodeString("HCMaxQPKey", null);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localMediaFormat.setInteger((String)localObject2, this.hkK);
            localMediaFormat.setInteger((String)localObject1, this.hkJ);
            this.hkI = true;
            ae.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + (String)localObject1 + ", max:" + (String)localObject2 + ", value: minQP:" + this.hkJ + ", maxQP:" + this.hkK);
          }
        }
      }
      ae.i("MicroMsg.VideoCodecConfig", "mediaFormat: %s", new Object[] { localMediaFormat });
      AppMethodBeat.o(93518);
      return localMediaFormat;
      if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(2)) {
        continue;
      }
      ae.i("MicroMsg.VideoCodecConfig", "support cbr bitrate mode");
      localMediaFormat.setInteger("bitrate-mode", 2);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93519);
    String str = "VideoCodecConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.hkE + ", iFrameInterval=" + this.hkF + ", name=" + this.name + ", initError=" + this.hkG + ", forceCQ=" + this.hkH + ", codecInfo=" + this.hkL + ')';
    AppMethodBeat.o(93519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.b.d
 * JD-Core Version:    0.7.0.1
 */