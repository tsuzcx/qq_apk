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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configToFormat", "Landroid/media/MediaFormat;", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"})
public final class d
  extends a
{
  public static final d.a gns;
  public int bitrate;
  public int frameRate;
  public int gnh;
  public int gni;
  private int gnk;
  public int gnl;
  public boolean gnm;
  public boolean gnn;
  private boolean gno;
  public int gnp;
  public int gnq;
  private MediaCodecInfo gnr;
  public String mimeType;
  public String name;
  
  static
  {
    AppMethodBeat.i(93521);
    gns = new d.a((byte)0);
    AppMethodBeat.o(93521);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(93520);
    this.gnk = 2130708361;
    this.gnl = 1;
    this.mimeType = "video/avc";
    ad.i("MicroMsg.VideoCodecConfig", "init, enableHevc:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.gnr = selectCodec("video/hevc");
      if (this.gnr == null)
      {
        ad.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
        this.gnr = selectCodec("video/avc");
        this.mimeType = "video/avc";
        h.vKh.m(1280L, 61L, 1L);
      }
    }
    while (this.gnr == null)
    {
      h.vKh.m(1047L, 0L, 1L);
      this.gnm = true;
      AppMethodBeat.o(93520);
      return;
      StringBuilder localStringBuilder = new StringBuilder("success select hevc codec:");
      localObject = this.gnr;
      if (localObject != null) {}
      for (localObject = ((MediaCodecInfo)localObject).getName();; localObject = null)
      {
        ad.i("MicroMsg.VideoCodecConfig", (String)localObject);
        this.mimeType = "video/hevc";
        h.vKh.m(1280L, 60L, 1L);
        break;
      }
      this.gnr = selectCodec("video/avc");
      this.mimeType = "video/avc";
    }
    Object localObject = this.gnr;
    if (localObject == null) {
      k.fvU();
    }
    this.name = ((MediaCodecInfo)localObject).getName();
    this.gnl = ((b)g.ab(b.class)).a(b.a.pjS, 1);
    ad.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.gnl);
    AppMethodBeat.o(93520);
  }
  
  public final MediaFormat ajq()
  {
    AppMethodBeat.i(93518);
    ad.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.gnh + ", targetHeight:" + this.gni + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.gnk + ", iFrameInterval:" + this.gnl + ", value: minQP:" + this.gnp + ", maxQP:" + this.gnq);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mimeType, this.gnh, this.gni);
    Object localObject1 = this.gnr;
    if (localObject1 == null) {
      k.fvU();
    }
    k.g(localMediaFormat, "mediaFormat");
    a((MediaCodecInfo)localObject1, localMediaFormat, this.mimeType);
    localObject1 = this.gnr;
    if (localObject1 == null) {
      k.fvU();
    }
    Object localObject2 = this.mimeType;
    k.h(localObject1, "codecInfo");
    k.h(localMediaFormat, "mediaFormat");
    k.h(localObject2, "mimeType");
    for (;;)
    {
      try
      {
        if (com.tencent.mm.compatible.util.d.lf(21))
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
              ad.i("MicroMsg.VideoCodecConfig", "support vbr bitrate mode");
              localMediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        ad.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.frameRate);
      localMediaFormat.setInteger("color-format", this.gnk);
      localMediaFormat.setInteger("i-frame-interval", this.gnl);
      if (this.gnn)
      {
        ad.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      if ((this.gnp != 0) && (this.gnq != 0))
      {
        localObject2 = ax.aFC("HardcoderQP");
        if (localObject2 != null)
        {
          localObject1 = ((ax)localObject2).decodeString("HCMinQPKey", null);
          localObject2 = ((ax)localObject2).decodeString("HCMaxQPKey", null);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localMediaFormat.setInteger((String)localObject2, this.gnq);
            localMediaFormat.setInteger((String)localObject1, this.gnp);
            this.gno = true;
            ad.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + (String)localObject1 + ", max:" + (String)localObject2 + ", value: minQP:" + this.gnp + ", maxQP:" + this.gnq);
          }
        }
      }
      ad.i("MicroMsg.VideoCodecConfig", "mediaFormat: %s", new Object[] { localMediaFormat });
      AppMethodBeat.o(93518);
      return localMediaFormat;
      if (!((MediaCodecInfo.EncoderCapabilities)localObject1).isBitrateModeSupported(2)) {
        continue;
      }
      ad.i("MicroMsg.VideoCodecConfig", "support cbr bitrate mode");
      localMediaFormat.setInteger("bitrate-mode", 2);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(93519);
    String str = "VideoCodecConfig(targetWidth=" + this.gnh + ", targetHeight=" + this.gni + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.gnk + ", iFrameInterval=" + this.gnl + ", name=" + this.name + ", initError=" + this.gnm + ", forceCQ=" + this.gnn + ", codecInfo=" + this.gnr + ')';
    AppMethodBeat.o(93519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.b.d
 * JD-Core Version:    0.7.0.1
 */