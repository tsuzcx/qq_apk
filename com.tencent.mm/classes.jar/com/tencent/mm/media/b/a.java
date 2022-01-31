package com.tencent.mm.media.b;

import a.f.b.j;
import a.l;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "MIME_TYPE", "", "getMIME_TYPE", "()Ljava/lang/String;", "setMIME_TYPE", "(Ljava/lang/String;)V", "supportedHardcodeEncoder", "", "[Ljava/lang/String;", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", "profile", "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"})
public class a
{
  static final String TAG = "MicroMsg.VideoCodecConfig";
  public static final a.a eRs;
  String MIME_TYPE;
  final String[] eRr;
  
  static
  {
    AppMethodBeat.i(12847);
    eRs = new a.a((byte)0);
    TAG = "MicroMsg.VideoCodecConfig";
    AppMethodBeat.o(12847);
  }
  
  public a()
  {
    AppMethodBeat.i(156654);
    this.MIME_TYPE = "video/avc";
    this.eRr = new String[] { "OMX.oppo.h264.encoder" };
    AppMethodBeat.o(156654);
  }
  
  public final void a(MediaCodecInfo paramMediaCodecInfo, MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(12846);
    j.q(paramMediaCodecInfo, "codecInfo");
    j.q(paramMediaFormat, "mediaFormat");
    if (d.fv(23)) {}
    for (;;)
    {
      int i;
      try
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(this.MIME_TYPE);
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          if (paramMediaCodecInfo != null)
          {
            MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
            localCodecProfileLevel.level = 0;
            localCodecProfileLevel.profile = 0;
            int k = paramMediaCodecInfo.length;
            i = 0;
            int m;
            int n;
            if (i < k)
            {
              Object localObject = paramMediaCodecInfo[i];
              m = localObject.profile;
              n = localObject.level;
              ab.i(TAG, "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
            }
            switch (m)
            {
            default: 
              if ((j == 0) || (m < localCodecProfileLevel.profile) || (n < localCodecProfileLevel.level)) {
                break label319;
              }
              localCodecProfileLevel.profile = m;
              localCodecProfileLevel.level = n;
              break label319;
              ab.i(TAG, "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
              if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
              {
                paramMediaFormat.setInteger("profile", localCodecProfileLevel.profile);
                paramMediaFormat.setInteger("level", 256);
                AppMethodBeat.o(12846);
                return;
              }
              break;
            }
          }
        }
      }
      catch (Exception paramMediaCodecInfo)
      {
        ab.e(TAG, "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(12846);
      return;
      int j = 0;
      continue;
      label319:
      i += 1;
      continue;
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.a
 * JD-Core Version:    0.7.0.1
 */