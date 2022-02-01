package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.Arrays;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "STRING_SPILT", "", "supportedHardcodeEncoder", "", "[Ljava/lang/String;", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", "profile", "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"})
public class a
{
  public static final a.a hhM;
  private final String hhK;
  private String[] hhL;
  
  static
  {
    AppMethodBeat.i(93516);
    hhM = new a.a((byte)0);
    AppMethodBeat.o(93516);
  }
  
  public a()
  {
    AppMethodBeat.i(93515);
    this.hhK = ";";
    this.hhL = new String[] { "OMX.oppo.h264.encoder" };
    Object localObject = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qyK, "");
    p.g(localObject, "supportedHardcodeEncoderList");
    Object[] arrayOfObject = ((Collection)n.b((CharSequence)localObject, new String[] { this.hhK })).toArray(new String[0]);
    if (arrayOfObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(93515);
      throw ((Throwable)localObject);
    }
    this.hhL = ((String[])arrayOfObject);
    ad.i("MicroMsg.VideoCodecConfig", "supportedHardcodeEncoderList : " + (String)localObject + "  supportedHardcodeEncoder size:" + this.hhL.length);
    if (this.hhL.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = b.hhO;
        b.ea(false);
      }
      AppMethodBeat.o(93515);
      return;
    }
  }
  
  public static void a(MediaCodecInfo paramMediaCodecInfo, MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(93514);
    p.h(paramMediaCodecInfo, "codecInfo");
    p.h(paramMediaFormat, "mediaFormat");
    p.h(paramString, "mimeType");
    if (d.ly(23)) {}
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
              ad.i("MicroMsg.VideoCodecConfig", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
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
              ad.i("MicroMsg.VideoCodecConfig", "best profile: %s, level: %s", new Object[] { Integer.valueOf(paramString.profile), Integer.valueOf(paramString.level) });
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
        ad.e("MicroMsg.VideoCodecConfig", "trySetProfile error: %s", new Object[] { paramMediaCodecInfo.getMessage() });
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
    p.h(paramString, "mimeType");
    int m = MediaCodecList.getCodecCount();
    ad.i("MicroMsg.VideoCodecConfig", "numCodec:".concat(String.valueOf(m)));
    int i = 0;
    MediaCodecInfo localMediaCodecInfo;
    String[] arrayOfString;
    int j;
    int k;
    while (i < m)
    {
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      p.g(localMediaCodecInfo, "codecInfo");
      if (localMediaCodecInfo.isEncoder())
      {
        ad.i("MicroMsg.VideoCodecConfig", "config to use supportedHardcodeEncoder:" + Arrays.toString(this.hhL));
        arrayOfString = this.hhL;
        int n = arrayOfString.length;
        j = 0;
        while (j < n)
        {
          Object localObject = arrayOfString[j];
          if ((localMediaCodecInfo != null) && (n.H(localMediaCodecInfo.getName(), (String)localObject, true)))
          {
            localObject = localMediaCodecInfo.getSupportedTypes();
            k = 0;
            p.g(localObject, "types");
            int i1 = localObject.length;
            while (k < i1)
            {
              ad.i("MicroMsg.VideoCodecConfig", "hardcodeEncoder: " + localMediaCodecInfo.getName() + "  type:" + localObject[k]);
              if (n.H(localObject[k], paramString, true))
              {
                paramString = b.hhO;
                b.ea(true);
                AppMethodBeat.o(93513);
                return localMediaCodecInfo;
              }
              k += 1;
            }
            ad.i("MicroMsg.VideoCodecConfig", "selectCodec from hardcodeEncoder " + this.hhL + ": " + localMediaCodecInfo.getName());
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
      p.g(localMediaCodecInfo, "codecInfo");
      if (localMediaCodecInfo.isEncoder())
      {
        arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        p.g(arrayOfString, "types");
        k = arrayOfString.length;
        while (j < k)
        {
          ad.i("MicroMsg.VideoCodecConfig", "selectCodec:  " + m + "  type: " + arrayOfString[j]);
          if (n.H(arrayOfString[j], paramString, true))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.b.a
 * JD-Core Version:    0.7.0.1
 */