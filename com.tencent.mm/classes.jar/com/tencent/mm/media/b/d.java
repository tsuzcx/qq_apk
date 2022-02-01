package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "enableHevc", "", "(Z)V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "getForceCQ", "()Z", "setForceCQ", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "maxQP", "getMaxQP", "setMaxQP", "mimeType", "", "getMimeType", "()Ljava/lang/String;", "setMimeType", "(Ljava/lang/String;)V", "minQP", "getMinQP", "setMinQP", "name", "getName", "setName", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "useHWQP", "getUseHWQP", "setUseHWQP", "configToFormat", "Landroid/media/MediaFormat;", "isHevcType", "toString", "Companion", "plugin-mediaeditor_release"})
public class d
  extends a
{
  public static final a kSo;
  public int bitrate;
  private int colorFormat;
  public int frameRate;
  public int kSh;
  public boolean kSi;
  public boolean kSj;
  private boolean kSk;
  public int kSl;
  public int kSm;
  private MediaCodecInfo kSn;
  public String mimeType;
  public String name;
  public int targetHeight;
  public int targetWidth;
  
  static
  {
    AppMethodBeat.i(93521);
    kSo = new a((byte)0);
    AppMethodBeat.o(93521);
  }
  
  public d(boolean paramBoolean)
  {
    AppMethodBeat.i(93520);
    this.colorFormat = 2130708361;
    this.kSh = 1;
    this.mimeType = "video/avc";
    Log.i("MicroMsg.VideoCodecConfig", "init, enableHevc:".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      this.kSn = selectCodec("video/hevc");
      if (this.kSn == null)
      {
        Log.e("MicroMsg.VideoCodecConfig", "cannot found hevc codec info! fallback to select avc codec");
        this.kSn = selectCodec("video/avc");
        this.mimeType = "video/avc";
        com.tencent.mm.plugin.report.service.h.IzE.p(1280L, 61L, 1L);
      }
    }
    while (this.kSn == null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(1047L, 0L, 1L);
      this.kSi = true;
      AppMethodBeat.o(93520);
      return;
      StringBuilder localStringBuilder = new StringBuilder("success select hevc codec:");
      localObject = this.kSn;
      if (localObject != null) {}
      for (localObject = ((MediaCodecInfo)localObject).getName();; localObject = null)
      {
        Log.i("MicroMsg.VideoCodecConfig", (String)localObject);
        this.mimeType = "video/hevc";
        com.tencent.mm.plugin.report.service.h.IzE.p(1280L, 60L, 1L);
        break;
      }
      this.kSn = selectCodec("video/avc");
      this.mimeType = "video/avc";
    }
    Object localObject = this.kSn;
    if (localObject == null) {
      p.iCn();
    }
    this.name = ((MediaCodecInfo)localObject).getName();
    this.kSh = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vwe, 1);
    Log.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.kSh);
    AppMethodBeat.o(93520);
  }
  
  public final MediaFormat aUd()
  {
    AppMethodBeat.i(93518);
    Log.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.targetWidth + ", targetHeight:" + this.targetHeight + ", bitrate:" + this.bitrate + ", frameRate:" + this.frameRate + ", colorFormat:" + this.colorFormat + ", iFrameInterval:" + this.kSh + ", value: minQP:" + this.kSl + ", maxQP:" + this.kSm);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.mimeType, this.targetWidth, this.targetHeight);
    Object localObject1 = this.kSn;
    if (localObject1 == null) {
      p.iCn();
    }
    p.j(localMediaFormat, "mediaFormat");
    a((MediaCodecInfo)localObject1, localMediaFormat, this.mimeType);
    localObject1 = this.kSn;
    if (localObject1 == null) {
      p.iCn();
    }
    Object localObject2 = this.mimeType;
    p.k(localObject1, "codecInfo");
    p.k(localMediaFormat, "mediaFormat");
    p.k(localObject2, "mimeType");
    for (;;)
    {
      try
      {
        if (com.tencent.mm.compatible.util.d.qV(21))
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
        Log.e("MicroMsg.VideoCodecConfig", "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        Log.i("MicroMsg.VideoCodecConfig", "both vbr and cbr bitrate mode not support!");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.frameRate);
      localMediaFormat.setInteger("color-format", this.colorFormat);
      localMediaFormat.setInteger("i-frame-interval", this.kSh);
      if (this.kSj)
      {
        Log.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      if ((this.kSl != 0) && (this.kSm != 0))
      {
        localObject2 = MultiProcessMMKV.getMMKV("HardcoderQP");
        if (localObject2 != null)
        {
          localObject1 = ((MultiProcessMMKV)localObject2).decodeString("HCMinQPKey", null);
          localObject2 = ((MultiProcessMMKV)localObject2).decodeString("HCMaxQPKey", null);
          if ((localObject1 != null) && (localObject2 != null))
          {
            localMediaFormat.setInteger((String)localObject2, this.kSm);
            localMediaFormat.setInteger((String)localObject1, this.kSl);
            this.kSk = true;
            Log.i("MicroMsg.VideoCodecConfig", "steve:[hardcoder]configToFormat mediaformat set QP! key: min:" + (String)localObject1 + ", max:" + (String)localObject2 + ", value: minQP:" + this.kSl + ", maxQP:" + this.kSm);
          }
        }
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
    String str = "VideoCodecConfig(targetWidth=" + this.targetWidth + ", targetHeight=" + this.targetHeight + ", bitrate=" + this.bitrate + ", frameRate=" + this.frameRate + ", colorFormat=" + this.colorFormat + ", iFrameInterval=" + this.kSh + ", name=" + this.name + ", initError=" + this.kSi + ", forceCQ=" + this.kSj + ", codecInfo=" + this.kSn + ')';
    AppMethodBeat.o(93519);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/config/VideoCodecConfig$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.d
 * JD-Core Version:    0.7.0.1
 */