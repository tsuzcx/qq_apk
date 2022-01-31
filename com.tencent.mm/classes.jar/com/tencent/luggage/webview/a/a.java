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
  
  public final WebResourceResponse bG(String paramString)
  {
    AppMethodBeat.i(90943);
    try
    {
      paramString = new WebResourceResponse("application/javascript", "UTF-8", this.mContext.getAssets().open("LuggageBridge.js"));
      AppMethodBeat.o(90943);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(90943);
    }
    return null;
  }
  
  public final String xd()
  {
    return "^luggage://bridge$";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.webview.a.a
 * JD-Core Version:    0.7.0.1
 */