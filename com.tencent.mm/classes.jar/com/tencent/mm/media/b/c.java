package com.tencent.mm.media.b;

import a.f.b.j;
import a.l;
import a.l.m;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/config/VideoCodecConfig;", "Lcom/tencent/mm/media/config/BaseCodecConfig;", "()V", "bitrate", "", "getBitrate", "()I", "setBitrate", "(I)V", "codecInfo", "Landroid/media/MediaCodecInfo;", "getCodecInfo", "()Landroid/media/MediaCodecInfo;", "setCodecInfo", "(Landroid/media/MediaCodecInfo;)V", "colorFormat", "getColorFormat", "setColorFormat", "forceCQ", "", "getForceCQ", "()Z", "setForceCQ", "(Z)V", "frameRate", "getFrameRate", "setFrameRate", "iFrameInterval", "getIFrameInterval", "setIFrameInterval", "initError", "getInitError", "setInitError", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "targetHeight", "getTargetHeight", "setTargetHeight", "targetWidth", "getTargetWidth", "setTargetWidth", "configToFormat", "Landroid/media/MediaFormat;", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  public static final c.a eRC;
  public int bitrate;
  public boolean eRA;
  private MediaCodecInfo eRB;
  public int eRu;
  public int eRv;
  public int eRw;
  private int eRx;
  public int eRy;
  public boolean eRz;
  public String name;
  
  static
  {
    AppMethodBeat.i(12850);
    eRC = new c.a((byte)0);
    AppMethodBeat.o(12850);
  }
  
  public c()
  {
    AppMethodBeat.i(12849);
    this.eRx = 2130708361;
    this.eRy = 1;
    j.q("video/avc", "<set-?>");
    this.MIME_TYPE = "video/avc";
    String str = this.MIME_TYPE;
    j.q(str, "mimeType");
    int m = MediaCodecList.getCodecCount();
    ab.i(a.TAG, "numCodec:".concat(String.valueOf(m)));
    int i;
    Object localObject2;
    int j;
    label161:
    Object localObject3;
    if (((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVM, 0) == 1)
    {
      i = 0;
      if (i < m)
      {
        localObject1 = MediaCodecList.getCodecInfoAt(i);
        j.p(localObject1, "codecInfo");
        if (((MediaCodecInfo)localObject1).isEncoder())
        {
          ab.i(a.TAG, "config to use supportedHardcodeEncoder:" + Arrays.toString(this.eRr));
          localObject2 = this.eRr;
          int n = localObject2.length;
          j = 0;
          if (j < n)
          {
            localObject3 = localObject2[j];
            if ((localObject1 != null) && (m.I(((MediaCodecInfo)localObject1).getName(), (String)localObject3, true)))
            {
              localObject2 = ((MediaCodecInfo)localObject1).getSupportedTypes();
              j.p(localObject2, "types");
              j = localObject2.length;
              i = k;
              label212:
              if (i < j)
              {
                ab.i(a.TAG, "hardcodeEncoder: " + ((MediaCodecInfo)localObject1).getName() + "  type:" + localObject2[i]);
                if (!m.I(localObject2[i], str, true)) {}
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      this.eRB = ((MediaCodecInfo)localObject1);
      if (this.eRB != null) {
        break label492;
      }
      h.qsU.j(1047L, 0L, 1L);
      this.eRz = true;
      AppMethodBeat.o(12849);
      return;
      i += 1;
      break label212;
      ab.i(a.TAG, "selectCodec from hardcodeEncoder " + this.eRr + ": " + ((MediaCodecInfo)localObject1).getName());
      continue;
      j += 1;
      break label161;
      i += 1;
      break;
      i = 0;
      for (;;)
      {
        if (i >= m) {
          break label486;
        }
        localObject2 = MediaCodecList.getCodecInfoAt(i);
        j.p(localObject2, "codecInfo");
        if (((MediaCodecInfo)localObject2).isEncoder())
        {
          localObject3 = ((MediaCodecInfo)localObject2).getSupportedTypes();
          j.p(localObject3, "types");
          k = localObject3.length;
          j = 0;
          for (;;)
          {
            if (j >= k) {
              break label479;
            }
            ab.i(a.TAG, "selectCodec:  " + m + "  type: " + localObject3[j]);
            localObject1 = localObject2;
            if (m.I(localObject3[j], str, true)) {
              break;
            }
            j += 1;
          }
        }
        label479:
        i += 1;
      }
      label486:
      localObject1 = null;
    }
    label492:
    Object localObject1 = this.eRB;
    if (localObject1 == null) {
      j.ebi();
    }
    this.name = ((MediaCodecInfo)localObject1).getName();
    this.eRy = ((com.tencent.mm.plugin.expt.a.a)g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lSz, 1);
    ab.i("MicroMsg.VideoCodecConfig", "codecInfo.name : " + this.name + "  iFrameInterval " + this.eRy);
    AppMethodBeat.o(12849);
  }
  
  public final MediaFormat Ux()
  {
    AppMethodBeat.i(12848);
    ab.i("MicroMsg.VideoCodecConfig", "targetWidth:" + this.eRu + ", targetHeight:" + this.eRv + ", bitrate:" + this.bitrate + ", frameRate:" + this.eRw + ", colorFormat:" + this.eRx + ", iFrameInterval:" + this.eRy);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat(this.MIME_TYPE, this.eRu, this.eRv);
    Object localObject = this.eRB;
    if (localObject == null) {
      j.ebi();
    }
    j.p(localMediaFormat, "mediaFormat");
    a((MediaCodecInfo)localObject, localMediaFormat);
    localObject = this.eRB;
    if (localObject == null) {
      j.ebi();
    }
    j.q(localObject, "codecInfo");
    j.q(localMediaFormat, "mediaFormat");
    for (;;)
    {
      try
      {
        if (d.fv(21))
        {
          localObject = ((MediaCodecInfo)localObject).getCapabilitiesForType(this.MIME_TYPE);
          if (localObject != null)
          {
            localObject = ((MediaCodecInfo.CodecCapabilities)localObject).getEncoderCapabilities();
            if (localObject != null)
            {
              if (!((MediaCodecInfo.EncoderCapabilities)localObject).isBitrateModeSupported(1)) {
                continue;
              }
              ab.i(a.TAG, "support vbr bitrate mode");
              localMediaFormat.setInteger("bitrate-mode", 1);
            }
          }
        }
      }
      catch (Exception localException)
      {
        ab.e(a.TAG, "trySetBitRateMode error: %s", new Object[] { localException.getMessage() });
        continue;
        ab.i(a.TAG, "both vbr and cbr bitrate mode not support!");
        continue;
      }
      localMediaFormat.setInteger("bitrate", this.bitrate);
      localMediaFormat.setInteger("frame-rate", this.eRw);
      localMediaFormat.setInteger("color-format", this.eRx);
      localMediaFormat.setInteger("i-frame-interval", this.eRy);
      if (this.eRA)
      {
        ab.i("MicroMsg.VideoCodecConfig", "mediaformat force set BITRATE_MODE_CQ, %s", new Object[] { localMediaFormat.toString() });
        localMediaFormat.setInteger("bitrate-mode", 0);
      }
      AppMethodBeat.o(12848);
      return localMediaFormat;
      if (!((MediaCodecInfo.EncoderCapabilities)localObject).isBitrateModeSupported(2)) {
        continue;
      }
      ab.i(a.TAG, "support cbr bitrate mode");
      localMediaFormat.setInteger("bitrate-mode", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.c
 * JD-Core Version:    0.7.0.1
 */