package com.tencent.mm.media.b;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "STRING_SPILT", "", "supportedHardcodeEncoder", "", "[Ljava/lang/String;", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", "profile", "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  public static final a.a nxH;
  private final String nxI;
  private String[] nxJ;
  
  static
  {
    AppMethodBeat.i(93516);
    nxH = new a.a((byte)0);
    AppMethodBeat.o(93516);
  }
  
  public a()
  {
    AppMethodBeat.i(93515);
    this.nxI = ";";
    this.nxJ = new String[] { "OMX.oppo.h264.encoder" };
    Object localObject = ((c)h.ax(c.class)).a(c.a.yVE, "");
    s.s(localObject, "supportedHardcodeEncoderList");
    Object[] arrayOfObject = ((Collection)n.b((CharSequence)localObject, new String[] { this.nxI })).toArray(new String[0]);
    if (arrayOfObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(93515);
      throw ((Throwable)localObject);
    }
    this.nxJ = ((String[])arrayOfObject);
    Log.i("MicroMsg.VideoCodecConfig", "supportedHardcodeEncoderList : " + localObject + "  supportedHardcodeEncoder size:" + this.nxJ.length);
    if (this.nxJ.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = b.nxK;
        b.gk(false);
      }
      AppMethodBeat.o(93515);
      return;
    }
  }
  
  public static void a(MediaCodecInfo paramMediaCodecInfo, MediaFormat paramMediaFormat, String paramString)
  {
    AppMethodBeat.i(93514);
    s.u(paramMediaCodecInfo, "codecInfo");
    s.u(paramMediaFormat, "mediaFormat");
    s.u(paramString, "mimeType");
    if (d.rb(23)) {}
    for (;;)
    {
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
            int i = 0;
            int k = paramMediaCodecInfo.length;
            int m;
            int n;
            if (i < k)
            {
              Object localObject = paramMediaCodecInfo[i];
              i += 1;
              m = localObject.profile;
              n = localObject.level;
              Log.i("MicroMsg.VideoCodecConfig", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
            }
            switch (m)
            {
            default: 
              if ((j == 0) || (m < paramString.profile) || (n < paramString.level)) {
                break label342;
              }
              paramString.profile = m;
              paramString.level = n;
              continue;
              Log.i("MicroMsg.VideoCodecConfig", "best profile: %s, level: %s", new Object[] { Integer.valueOf(paramString.profile), Integer.valueOf(paramString.level) });
              if ((paramString.profile > 0) && (paramString.level >= 256))
              {
                paramMediaFormat.setInteger("profile", paramString.profile);
                paramMediaFormat.setInteger("level", paramString.level);
                if ((((c)h.ax(c.class)).a(c.a.yVH, true)) && (paramString.level >= 65536))
                {
                  paramMediaFormat.setInteger("level", 65536);
                  AppMethodBeat.o(93514);
                  return;
                }
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
      label342:
      continue;
      int j = 0;
      continue;
      j = 1;
    }
  }
  
  public final MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(93513);
    s.u(paramString, "mimeType");
    int n = MediaCodecList.getCodecCount();
    Log.i("MicroMsg.VideoCodecConfig", s.X("numCodec:", Integer.valueOf(n)));
    int i = 0;
    int k;
    MediaCodecInfo localMediaCodecInfo;
    String[] arrayOfString;
    int i1;
    if (n > 0)
    {
      k = i + 1;
      localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        Log.i("MicroMsg.VideoCodecConfig", s.X("config to use supportedHardcodeEncoder:", Arrays.toString(this.nxJ)));
        arrayOfString = this.nxJ;
        i = 0;
        i1 = arrayOfString.length;
      }
    }
    label422:
    for (;;)
    {
      label88:
      Object localObject;
      int j;
      int i2;
      if (i < i1)
      {
        localObject = arrayOfString[i];
        i += 1;
        if ((localMediaCodecInfo == null) || (!n.T(localMediaCodecInfo.getName(), (String)localObject, true))) {
          break label422;
        }
        localObject = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        i2 = localObject.length - 1;
        if (i2 < 0) {}
      }
      for (;;)
      {
        int m = j + 1;
        Log.i("MicroMsg.VideoCodecConfig", "hardcodeEncoder: " + localMediaCodecInfo.getName() + "  type:" + localObject[j]);
        if (n.T(localObject[j], paramString, true))
        {
          paramString = b.nxK;
          b.gk(true);
          AppMethodBeat.o(93513);
          return localMediaCodecInfo;
        }
        if (m > i2)
        {
          Log.i("MicroMsg.VideoCodecConfig", "selectCodec from hardcodeEncoder " + this.nxJ + ": " + localMediaCodecInfo.getName());
          break label88;
          if (k >= n)
          {
            i = 0;
            if (n > 0)
            {
              j = i + 1;
              localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
              if (localMediaCodecInfo.isEncoder())
              {
                arrayOfString = localMediaCodecInfo.getSupportedTypes();
                i = 0;
                m = arrayOfString.length - 1;
                if (m < 0) {}
              }
            }
            for (;;)
            {
              k = i + 1;
              Log.i("MicroMsg.VideoCodecConfig", "selectCodec:  " + n + "  type: " + arrayOfString[i]);
              if (n.T(arrayOfString[i], paramString, true))
              {
                AppMethodBeat.o(93513);
                return localMediaCodecInfo;
              }
              if (k > m)
              {
                if (j >= n)
                {
                  AppMethodBeat.o(93513);
                  return null;
                }
                i = j;
                break;
              }
              i = k;
            }
          }
          i = k;
          break;
        }
        j = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.b.a
 * JD-Core Version:    0.7.0.1
 */