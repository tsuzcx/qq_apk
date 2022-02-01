package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configToFormat", "Landroid/media/MediaFormat;", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a gOe;
  public int bitrate;
  public int frameRate;
  public int gNU;
  public int gNV;
  private int gNW;
  public int gNX;
  public boolean gNY;
  public boolean gNZ;
  private boolean gOa;
  public int gOb;
  public int gOc;
  private MediaCodecInfo gOd;
  public String mimeType;
  public String name;
  
  static
  {
    AppMethodBeat.i(93521);
    gOe = new d.a((byte)0);
    AppMethodBeat.o(93521);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(93520);
    this.gNW = 2130708361;
    this.gNX = 1;
    this.mimeType = "video/avc";
    ac.i("MicroMsg.VideoCodecConfig", "init, enableHevc:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.gOd = selectCodec("video/hevc");
      if (this.gOd == null)
      {
        ac.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
        this.gOd = selectCodec("video/avc");
        this.mimeType = "video/avc";
        h.wUl.n(1280L, 61L, 1L);
      }
    }
    while (this.gOd == null)
    {
      h.wUl.n(1047L, 0L, 1L);
      this.gNY = true;
      AppMethodBeat.o(93520);
      return;
      StringBuilder localStringBuilder = new StringBuilder("success select hevc codec:");
      localObject = this.gOd;
      if (localObject != null) {}
      for (localObject = ((MediaCodecInfo)localObject).getName();; localObject = null)
      {
        ac.i("MicroMsg.VideoCodecConfig", (String)localObject);
        this.mimeType = "video/hevc";
        h.wUl.n(1280L, 60L, 1L);
        break;
      }
      this.gOd = selectCodec("video/avc");
      this.mimeType = "video/avc";
    }
    Object localObject = this.gOd;
    if (localObject == null) {
      k.fOy();
    }
    this.name = ((MediaCodecInfo)localObject).getName();
    this.gNX = ((b)g.ab(b.class)).a(b.a.pNj, 1);
    ac.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.gNX);
    AppMethodBeat.o(93520);
  }
  
  public final MediaFormat aqq()
  {
    AppMethodBeat.i(93518);
    ac.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.gNU + ", targetHeight:" + this.gNV + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.gNW + ", iFrameInterval:" + this.gNX + ", value: minQP:" + this.gOb + ", maxQP:" + this.gOc);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mimeType, this.gNU, this.gNV);
    Object localObject1 = this.gOd;
    if (localObject1 == null) {
      k.fOy();
    }
    k.g(localMediaFormat, "mediaFormat");
    a((MediaCodecInfo)localObject1, localMediaFormat, this.mimeType);
    localObject1 = this.gOd;
    if (localObject1 == null) {
      k.fOy();
    }
    Object localObject2 = this.mimeType;
    k.h(localObject1, "codecInfo");
    k.h(localMediaFormat, "mediaFormat");
    k.h(localObject2, "mimeType");
    for (;;)
    {
      try
      {
        if (com.tencent.mm.compatible.util.d.kZ(21))
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
              ac.i("MicroMsg.VideoCodecConfig", "support vbr bitrate mode");
              localMediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        ac.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.frameRate);
      localMediaFormat.setInteger("color-format", this.gNW);
      localMediaFormat.setInteger("i-frame-interval", this.gNX);
      if (this.gNZ)
      {
        ac.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      if ((this.gOb != 0) && (this.gOc != 0))
      {
        localObject2 = aw.aKT("HardcoderQP");
        if (localObject2 != null)
        {
          localObject1 = ((aw)localObject2).decodeString("HCMinQPKey", null);
          localObject2 = ((aw)localObject2).decodeString("HCMaxQPKey", null);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localMediaFormat.setInteger((String)localObject2, this.gOc);
            localMediaFormat.setInteger((String)localObject1, this.gOb);
            this.gOa = true;
            ac.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + (String)localObject1 + ", max:" + (String)localObject2 + ", value: minQP:" + this.gOb + ", maxQP:" + this.gOc);
          }
        }
      }
      ac.i("MicroMsg.VideoCodecConfig", "mediaFormat: %s", new Object[] { localMediaFormat });
      AppMethodBeat.o(93518);
      return localMediaFormat;
      if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(2)) {
        continue;
      }
      ac.i("MicroMsg.VideoCodecConfig", "support cbr bitrate mode");
      localMediaFormat.setInteger("bitrate-mode", 2);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93519);
    String str = "VideoCodecConfig(targetWidth=" + this.gNU + ", targetHeight=" + this.gNV + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.gNW + ", iFrameInterval=" + this.gNX + ", name=" + this.name + ", initError=" + this.gNY + ", forceCQ=" + this.gNZ + ", codecInfo=" + this.gOd + ')';
    AppMethodBeat.o(93519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.b.d
 * JD-Core Version:    0.7.0.1
 */