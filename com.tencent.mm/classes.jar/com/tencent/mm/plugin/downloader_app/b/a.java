package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(8921);
    ad.d("MicroMsg.DownloadReporter", "kv16099, sceneId = %d, areaId = %d, positionId = %d, actionId = %d, appId = %s,noticeId = %s, extInfo = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, paramString2, paramString3 });
    h.vKh.f(16099, new Object[] { Integer.valueOf(aUu()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramString1, paramString2, paramString3 });
    AppMethodBeat.o(8921);
  }
  
  public static int aUu()
  {
    AppMethodBeat.i(8922);
    if (ay.isWifi(aj.getContext()))
    {
      AppMethodBeat.o(8922);
      return 0;
    }
    if (ay.is4G(aj.getContext()))
    {
      AppMethodBeat.o(8922);
      return 4;
    }
    if (ay.is3G(aj.getContext()))
    {
      AppMethodBeat.o(8922);
      return 3;
    }
    if (ay.is2G(aj.getContext()))
    {
      AppMethodBeat.o(8922);
      return 2;
    }
    AppMethodBeat.o(8922);
    return 1;
  }
  
  public static String eP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(8923);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(paramString1, paramString2);
      label21:
      paramString1 = "";
      try
      {
        paramString2 = URLEncoder.encode(localJSONObject.toString(), "utf-8");
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString2)
      {
        label36:
        break label36;
      }
      AppMethodBeat.o(8923);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label21;
    }
  }
  
  public static int zU(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.a
 * JD-Core Version:    0.7.0.1
 */