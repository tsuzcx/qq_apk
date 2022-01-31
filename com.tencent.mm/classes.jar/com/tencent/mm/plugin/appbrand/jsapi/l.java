package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public final class l
{
  private final d hwW;
  private int hwX;
  ConcurrentHashMap<Integer, String> hwY;
  
  public l(d paramd)
  {
    AppMethodBeat.i(91027);
    this.hwX = 0;
    this.hwY = new ConcurrentHashMap();
    this.hwW = paramd;
    AppMethodBeat.o(91027);
  }
  
  private static int[] AO(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(91032);
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
      ab.e("MicroMsg.AppBrandJSInterface", paramString.getMessage());
      localObject2 = localObject1;
      AppMethodBeat.o(91032);
    }
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(91029);
    try
    {
      paramString1 = this.hwW.q(paramString1, paramString2, paramInt);
      AppMethodBeat.o(91029);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "invokeHandler", new Object[0]);
      AppMethodBeat.o(91029);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public final boolean isDebugPackage()
  {
    AppMethodBeat.i(91031);
    boolean bool = b.dsf();
    AppMethodBeat.o(91031);
    return bool;
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(91028);
    try
    {
      this.hwW.b(paramString1, paramString2, AO(paramString3));
      AppMethodBeat.o(91028);
      return;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "publishHandler", new Object[0]);
      AppMethodBeat.o(91028);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public final String retrieveEvent(int paramInt)
  {
    AppMethodBeat.i(91030);
    String str = (String)this.hwY.get(Integer.valueOf(paramInt));
    this.hwY.remove(Integer.valueOf(paramInt));
    if (str == null)
    {
      AppMethodBeat.o(91030);
      return "";
    }
    AppMethodBeat.o(91030);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l
 * JD-Core Version:    0.7.0.1
 */