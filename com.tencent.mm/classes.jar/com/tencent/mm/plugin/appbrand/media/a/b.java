package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg.Info;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static com.tencent.mm.ai.b a(String paramString1, String paramString2, String paramString3, String paramString4, WxaPkg.Info paramInfo, String paramString5)
  {
    AppMethodBeat.i(182598);
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)))
    {
      ae.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", new Object[] { paramString4, paramString3 });
      AppMethodBeat.o(182598);
      return null;
    }
    ae.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", new Object[] { paramString2, paramString4 });
    com.tencent.mm.ai.b localb = new com.tencent.mm.ai.b();
    localb.appId = paramString1;
    localb.ddg = paramString2;
    localb.processName = paramString5;
    localb.der = paramString3;
    localb.fromScene = 0;
    try
    {
      paramString1 = new JSONObject(paramString4);
      int i = paramString1.optInt("startTime", 0);
      boolean bool1 = paramString1.optBoolean("autoplay", false);
      boolean bool2 = paramString1.optBoolean("loop", false);
      double d1 = paramString1.optDouble("volume", 1.0D);
      double d2 = paramString1.optDouble("playbackRate", 1.0D);
      localb.dez = i;
      localb.hOx = i;
      localb.hOy = bool1;
      localb.loop = bool2;
      localb.hOA = d1;
      localb.hOB = d2;
      if (paramString3.startsWith("file://"))
      {
        localb.filePath = paramString3.substring(7);
        ae.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", new Object[] { localb.filePath });
        AppMethodBeat.o(182598);
        return localb;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "parseAudioPlayParam", new Object[0]);
        continue;
        if ((!paramString3.startsWith("http://")) && (!paramString3.startsWith("https://")))
        {
          paramString1 = f.c(paramInfo);
          if ((paramString1 == null) || (!paramString1.isOpen()))
          {
            ae.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", new Object[] { paramString3 });
            org.apache.commons.a.e.closeQuietly(paramString1);
            AppMethodBeat.o(182598);
            return null;
          }
          localb.filePath = paramString3;
          localb.hOL = paramString1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.b
 * JD-Core Version:    0.7.0.1
 */