package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.mm.af.e;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static com.tencent.mm.af.b b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(paramString4)) || (TextUtils.isEmpty(paramString3)))
    {
      y.e("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam, sourceData or src is null, sourceData:%s, src:%s", new Object[] { paramString4, paramString3 });
      paramString1 = null;
    }
    com.tencent.mm.af.b localb;
    do
    {
      do
      {
        return paramString1;
        y.i("MicroMsg.Audio.AudioPlayerParamParser", "parseAudioPlayParam audioId:%s, sourceData:%s", new Object[] { paramString2, paramString4 });
        localb = new com.tencent.mm.af.b();
        localb.appId = paramString1;
        localb.bFM = paramString2;
        localb.processName = paramString6;
        localb.ceM = paramString3;
        localb.fromScene = 0;
        try
        {
          paramString1 = new JSONObject(paramString4);
          int i = paramString1.optInt("startTime", 0);
          boolean bool1 = paramString1.optBoolean("autoplay", false);
          boolean bool2 = paramString1.optBoolean("loop", false);
          double d = paramString1.optDouble("volume", 1.0D);
          localb.startTime = i;
          localb.eaN = i;
          localb.eaO = bool1;
          localb.eaP = bool2;
          localb.eaR = d;
          if (paramString3.startsWith("file://"))
          {
            localb.filePath = paramString3.substring(7);
            y.i("MicroMsg.Audio.AudioPlayerParamParser", "filePath:%s", new Object[] { localb.filePath });
            return localb;
          }
        }
        catch (JSONException paramString1)
        {
          for (;;)
          {
            y.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "parseAudioPlayParam", new Object[0]);
          }
          paramString1 = localb;
        }
      } while (paramString3.startsWith("http://"));
      paramString1 = localb;
    } while (paramString3.startsWith("https://"));
    paramString1 = f.bR(paramString3, paramString5);
    if (!paramString1.isOpen())
    {
      y.e("MicroMsg.Audio.AudioPlayerParamParser", "the wxa audioDataSource not found for src %s", new Object[] { paramString3 });
      try
      {
        paramString1.close();
        return null;
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.Audio.AudioPlayerParamParser", paramString1, "", new Object[0]);
        }
      }
    }
    localb.filePath = paramString3;
    localb.eaV = paramString1;
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.media.a.b
 * JD-Core Version:    0.7.0.1
 */