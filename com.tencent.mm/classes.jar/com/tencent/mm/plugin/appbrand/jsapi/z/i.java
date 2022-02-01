package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public final class i
  extends c
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47021);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47021);
    return i;
  }
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47020);
    if (!(paramView instanceof a))
    {
      AppMethodBeat.o(47020);
      return false;
    }
    if (paramJSONObject.has("backgroundColor")) {}
    try
    {
      paramView.setBackgroundColor(g.Ni(paramJSONObject.getString("backgroundColor")));
      label43:
      paramJSONObject = paramJSONObject.optString("src", "");
      ad.i("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s]", new Object[] { parame.getAppId(), Integer.valueOf(paramInt), Integer.valueOf(paramView.hashCode()), paramJSONObject });
      if (TextUtils.isEmpty(paramJSONObject))
      {
        AppMethodBeat.o(47020);
        return true;
      }
      parame = ((a)paramView).getWebView();
      if ((paramJSONObject.indexOf("#") >= 0) && (!TextUtils.isEmpty(parame.getUrl()))) {
        parame.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { paramJSONObject }), null);
      }
      for (;;)
      {
        AppMethodBeat.o(47020);
        return true;
        parame.loadUrl(paramJSONObject);
      }
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.i
 * JD-Core Version:    0.7.0.1
 */