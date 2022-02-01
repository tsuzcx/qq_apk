package com.tencent.luggage.webview.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  implements c
{
  private Context mContext;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final String SK()
  {
    return "^luggage://bridge$";
  }
  
  public final WebResourceResponse dx(String paramString)
  {
    AppMethodBeat.i(140556);
    try
    {
      paramString = new WebResourceResponse("application/javascript", "UTF-8", this.mContext.getAssets().open("LuggageBridge.js"));
      AppMethodBeat.o(140556);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(140556);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.webview.a.a
 * JD-Core Version:    0.7.0.1
 */