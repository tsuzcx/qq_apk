package com.tencent.luggage.webview.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.WebResourceResponse;

public final class a
  implements c
{
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final WebResourceResponse bf(String paramString)
  {
    try
    {
      paramString = new WebResourceResponse("application/javascript", "UTF-8", this.mContext.getAssets().open("LuggageBridge.js"));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final String qx()
  {
    return "^luggage://bridge$";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.webview.a.a
 * JD-Core Version:    0.7.0.1
 */