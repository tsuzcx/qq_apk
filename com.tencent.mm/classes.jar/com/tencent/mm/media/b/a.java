package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "STRING_SPILT", "", "supportedHardcodeEncoder", "", "[Ljava/lang/String;", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", "profile", "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"})
public class a
{
  public static final a kSd;
  private final String kSb;
  private String[] kSc;
  
  static
  {
    AppMethodBeat.i(93516);
    kSd = new a((byte)0);
    AppMethodBeat.o(93516);
  }
  
  public a()
  {
    AppMethodBeat.i(93515);
    this.kSb = ";";
    this.kSc = new String[] { "OMX.oppo.h264.encoder" };
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFZ, "");
    p.j(localObject, "supportedHardcodeEncoderList");
    Object[] arrayOfObject = ((Collection)n.b((CharSequence)localObject, new String[] { this.kSb })).toArray(new String[0]);
    if (arrayOfObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(93515);
      throw ((Throwable)localObject);
    }
    this.kSc = ((String[])arrayOfObject);
    Log.i("MicroMsg.VideoCodecConfig", "supportedHardcodeEncoderList : " + (String)localObject + "  supportedHardcodeEncoder size:" + this.kSc.length);
    if (this.kSc.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = b.kSf;
        b.fA(false);
      }
      AppMethodBeat.o(93515);
      return;
    }
  }
  
  public static void a(MediaCodecInfo paramMediaCodecInfo, MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(93514);
    p.k(paramMediaCodecInfo, "codecInfo");
    p.k(paramMediaFormat, "mediaFormat");
    p.k(paramString, "mimeType");
    if (d.qV(23)) {}
    for (;;)
    {
      int i;
      try
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.profileLevels;
          if (paramMediaCodecInfo != null)
          {
            paramString = new MediaCodecInfo.CodecProfileLevel();
            paramString.level = 0;
            paramString.profile = 0;
            int k = paramMediaCodecInfo.length;
            i = 0;
            int m;
            int n;
            if (i < k)
            {
              Object localObject = paramMediaCodecInfo[i];
              m = localObject.profile;
              n = localObject.level;
              Log.i("MicroMsg.VideoCodecConfig", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
            }
            switch (m)
            {
            default: 
              if ((j == 0) || (m < paramString.profile) || (n < paramString.level)) {
                break label307;
              }
              paramString.profile = m;
              paramString.level = n;
              break label307;
              Log.i("MicroMsg.VideoCodecConfig", "best profile: %s, level: %s", new Object[] { Integer.valueOf(paramString.profile), Integer.valueOf(paramString.level) });
              if ((paramString.profile > 0) && (paramString.level >= 256))
              {
                paramMediaFormat.setInteger("profile", paramString.profile);
                paramMediaFormat.setInteger("level", paramString.level);
                AppMethodBeat.o(93514);
                return;
              }
              break;
            }
          }
        }
      }
      catch (Exception paramMediaCodecInfo)
      {
        Log.e("MicroMsg.VideoCodecConfig", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
      }
      AppMethodBeat.o(93514);
      return;
      int j = 0;
      continue;
      label307:
      i += 1;
      continue;
      j = 1;
    }
  }
  
  public final MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(93513);
    p.k(paramString, "mimeType");
    int m = MediaCodecList.getCodecCount();
    Log.i("MicroMsg.VideoCodecConfig", "numCodec:".concat(String.valueOf(m)));
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    String[] arrayOfString;
    int j;
    int k;
    while (i < m)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      p.j(localMediaCodecInfo, "codecInfo");
      if (localMediaCodecInfo.isEncoder())
      {
        Log.i("MicroMsg.VideoCodecConfig", "config to use supportedHardcodeEncoder:" + Arrays.toString(this.kSc));
        arrayOfString = this.kSc;
        int n = arrayOfString.length;
        j = 0;
        while (j < n)
        {
          Object localObject = arrayOfString[j];
          if ((localMediaCodecInfo != null) && (n.L(localMediaCodecInfo.getName(), (String)localObject, true)))
          {
            localObject = localMediaCodecInfo.getSupportedTypes();
            k = 0;
            p.j(localObject, "types");
            int i1 = localObject.length;
            while (k < i1)
            {
              Log.i("MicroMsg.VideoCodecConfig", "hardcodeEncoder: " + localMediaCodecInfo.getName() + "  type:" + localObject[k]);
              if (n.L(localObject[k], paramString, true))
              {
                paramString = b.kSf;
                b.fA(true);
                AppMethodBeat.o(93513);
                return localMediaCodecInfo;
              }
              k += 1;
            }
            Log.i("MicroMsg.VideoCodecConfig", "selectCodec from hardcodeEncoder " + this.kSc + ": " + localMediaCodecInfo.getName());
          }
          j += 1;
        }
      }
      i += 1;
    }
    i = 0;
    while (i < m)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      p.j(localMediaCodecInfo, "codecInfo");
      if (localMediaCodecInfo.isEncoder())
      {
        arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        p.j(arrayOfString, "types");
        k = arrayOfString.length;
        while (j < k)
        {
          Log.i("MicroMsg.VideoCodecConfig", "selectCodec:  " + m + "  type: " + arrayOfString[j]);
          if (n.L(arrayOfString[j], paramString, true))
          {
            AppMethodBeat.o(93513);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(93513);
    return null;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/config/BaseCodecConfig$Companion;", "", "()V", "AVC_MIME_TYPE", "", "HEVC_MIME_TYPE", "TAG", "plugin-mediaeditor_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.b.a
 * JD-Core Version:    0.7.0.1
 */