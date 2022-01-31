package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  protected final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    if (!(paramView instanceof a)) {
      return false;
    }
    parame = paramJSONObject.optString("src", "");
    y.i("URL", parame);
    if (TextUtils.isEmpty(parame)) {
      return true;
    }
    paramView = ((a)paramView).getWebView();
    if ((parame.indexOf("#") >= 0) && (!TextUtils.isEmpty(paramView.getUrl()))) {
      paramView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { parame }), null);
    }
    for (;;)
    {
      return true;
      paramView.loadUrl(parame);
    }
  }
  
  protected final int p(JSONObject paramJSONObject)
  {
    return paramJSONObject.getInt("htmlId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.h
 * JD-Core Version:    0.7.0.1
 */