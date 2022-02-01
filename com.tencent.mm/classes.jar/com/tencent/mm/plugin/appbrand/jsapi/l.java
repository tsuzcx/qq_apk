package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONArray;

public final class l
{
  volatile d jvV;
  
  public l(d paramd)
  {
    this.jvV = paramd;
  }
  
  private static int[] GF(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(140639);
    localObject2 = new int[0];
    Object localObject1 = localObject2;
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      localObject1 = localObject2;
      paramString = new int[localJSONArray.length()];
      for (;;)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        paramString[i] = localJSONArray.getInt(i);
        i += 1;
      }
      return localObject2;
    }
    catch (Exception paramString)
    {
      ad.e("MicroMsg.AppBrandJSInterface", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(140639);
    }
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(140637);
    try
    {
      d locald = this.jvV;
      if (locald == null)
      {
        AppMethodBeat.o(140637);
        return "";
      }
      paramString1 = locald.w(paramString1, paramString2, paramInt);
      AppMethodBeat.o(140637);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "invokeHandler", new Object[0]);
      AppMethodBeat.o(140637);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(140636);
    try
    {
      d locald = this.jvV;
      if (locald == null)
      {
        AppMethodBeat.o(140636);
        return;
      }
      locald.b(paramString1, paramString2, GF(paramString3));
      AppMethodBeat.o(140636);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "publishHandler", new Object[0]);
      AppMethodBeat.o(140636);
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l
 * JD-Core Version:    0.7.0.1
 */