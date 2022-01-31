package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(136160);
    ab.d("MicroMsg.DownloadReporter", "kv16099, sceneId = %d, areaId = %d, positionId = %d, actionId = %d, appId = %s,noticeId = %s, extInfo = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, paramString2, paramString3 });
    h.qsU.e(16099, new Object[] { Integer.valueOf(azn()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(136160);
  }
  
  public static int azn()
  {
    AppMethodBeat.i(136161);
    if (at.isWifi(ah.getContext()))
    {
      AppMethodBeat.o(136161);
      return 0;
    }
    if (at.is4G(ah.getContext()))
    {
      AppMethodBeat.o(136161);
      return 4;
    }
    if (at.is3G(ah.getContext()))
    {
      AppMethodBeat.o(136161);
      return 3;
    }
    if (at.is2G(ah.getContext()))
    {
      AppMethodBeat.o(136161);
      return 2;
    }
    AppMethodBeat.o(136161);
    return 1;
  }
  
  public static String dG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136162);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      label20:
      paramString1 = "";
      try
      {
        paramString2 = URLEncoder.encode(localJSONObject.toString(), "utf-8");
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        label35:
        break label35;
      }
      AppMethodBeat.o(136162);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label20;
    }
  }
  
  public static int uc(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    default: 
      return 0;
    case 2: 
      return 1002;
    case 4: 
      return 1003;
    }
    return 1004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.a
 * JD-Core Version:    0.7.0.1
 */