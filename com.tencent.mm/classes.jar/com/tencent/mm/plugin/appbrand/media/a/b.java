package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static com.tencent.mm.ag.b b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(137804);
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)))
    {
      ab.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", new Object[] { paramString4, paramString3 });
      AppMethodBeat.o(137804);
      return null;
    }
    ab.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", new Object[] { paramString2, paramString4 });
    com.tencent.mm.ag.b localb = new com.tencent.mm.ag.b();
    localb.appId = paramString1;
    localb.ceu = paramString2;
    localb.processName = paramString6;
    localb.cfG = paramString3;
    localb.fromScene = 0;
    try
    {
      paramString1 = new JSONObject(paramString4);
      int i = paramString1.optInt("startTime", 0);
      boolean bool1 = paramString1.optBoolean("autoplay", false);
      boolean bool2 = paramString1.optBoolean("loop", false);
      double d = paramString1.optDouble("volume", 1.0D);
      localb.startTime = i;
      localb.fqW = i;
      localb.fqX = bool1;
      localb.fqY = bool2;
      localb.fra = d;
      if (paramString3.startsWith("file://"))
      {
        localb.filePath = paramString3.substring(7);
        ab.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", new Object[] { localb.filePath });
        AppMethodBeat.o(137804);
        return localb;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "parseAudioPlayParam", new Object[0]);
        continue;
        if ((!paramString3.startsWith("http://")) && (!paramString3.startsWith("https://")))
        {
          paramString1 = f.cG(paramString3, paramString5);
          if (!paramString1.isOpen())
          {
            ab.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", new Object[] { paramString3 });
            try
            {
              paramString1.close();
              AppMethodBeat.o(137804);
              return null;
            }
            catch (IOException paramString1)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "", new Object[0]);
              }
            }
          }
          localb.filePath = paramString3;
          localb.fri = paramString1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.b
 * JD-Core Version:    0.7.0.1
 */