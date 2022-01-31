package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131677);
    if (!(paramView instanceof a))
    {
      AppMethodBeat.o(131677);
      return false;
    }
    parame = paramJSONObject.optString("src", "");
    ab.i("URL", parame);
    if (TextUtils.isEmpty(parame))
    {
      AppMethodBeat.o(131677);
      return true;
    }
    paramView = ((a)paramView).getWebView();
    if ((parame.indexOf("#") >= 0) && (!TextUtils.isEmpty(paramView.getUrl()))) {
      paramView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { parame }), null);
    }
    for (;;)
    {
      AppMethodBeat.o(131677);
      return true;
      paramView.loadUrl(parame);
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(131678);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(131678);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.h
 * JD-Core Version:    0.7.0.1
 */