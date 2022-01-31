package com.tencent.mm.plugin.appbrand.jsapi;

import android.webkit.JavascriptInterface;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public final class h
{
  private final d geY;
  private int geZ = 0;
  ConcurrentHashMap<Integer, String> gfa = new ConcurrentHashMap();
  
  public h(d paramd)
  {
    this.geY = paramd;
  }
  
  private static int[] sO(String paramString)
  {
    int i = 0;
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
      y.e("MicroMsg.AppBrandJSInterface", paramString.getMessage());
      localObject2 = localObject1;
    }
  }
  
  @JavascriptInterface
  public final String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString1 = this.geY.n(paramString1, paramString2, paramInt);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "invokeHandler", new Object[0]);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public final boolean isDebugPackage()
  {
    return b.cqk();
  }
  
  @JavascriptInterface
  public final void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.geY.a(paramString1, paramString2, sO(paramString3));
      return;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.AppBrandJSInterface", paramString1, "publishHandler", new Object[0]);
      throw paramString1;
    }
  }
  
  @JavascriptInterface
  public final String retrieveEvent(int paramInt)
  {
    String str2 = (String)this.gfa.get(Integer.valueOf(paramInt));
    this.gfa.remove(Integer.valueOf(paramInt));
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.h
 * JD-Core Version:    0.7.0.1
 */