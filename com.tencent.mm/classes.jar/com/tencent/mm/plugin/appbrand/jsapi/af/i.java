package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public final class i
  extends d
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47021);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47021);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
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
      paramView.setBackgroundColor(g.afE(paramJSONObject.getString("backgroundColor")));
      label43:
      paramJSONObject = paramJSONObject.optString("src", "");
      Log.i("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s]", new Object[] { paramh.getAppId(), Integer.valueOf(paramInt), Integer.valueOf(paramView.hashCode()), paramJSONObject });
      if (TextUtils.isEmpty(paramJSONObject))
      {
        AppMethodBeat.o(47020);
        return true;
      }
      paramh = ((a)paramView).getWebView();
      if ((paramJSONObject.indexOf("#") >= 0) && (!TextUtils.isEmpty(paramh.getUrl()))) {
        paramh.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { r.afJ(paramJSONObject) }), null);
      }
      for (;;)
      {
        AppMethodBeat.o(47020);
        return true;
        paramh.loadUrl(paramJSONObject);
      }
    }
    catch (Exception localException)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.i
 * JD-Core Version:    0.7.0.1
 */