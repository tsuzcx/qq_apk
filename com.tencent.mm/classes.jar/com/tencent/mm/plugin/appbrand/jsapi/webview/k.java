package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class k
  extends d<ah>
{
  public static final int CTRL_INDEX = 300;
  public static final String NAME = "updateHTMLWebView";
  
  private static boolean a(ah paramah, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327466);
    if (paramJSONObject.has("backgroundColor")) {}
    try
    {
      paramView.setBackgroundColor(i.agw(paramJSONObject.getString("backgroundColor")));
      label27:
      paramJSONObject = paramJSONObject.optString("src", "");
      Log.i("MicroMsg.AppBrand.JsApiUpdateHTMLWebView", "onUpdateView appId[%s] viewId[%d] viewHash[%d] src[%s]", new Object[] { paramah.getAppId(), Integer.valueOf(paramInt), Integer.valueOf(paramView.hashCode()), paramJSONObject });
      if (TextUtils.isEmpty(paramJSONObject))
      {
        AppMethodBeat.o(327466);
        return true;
      }
      ((g.c)paramView).getController().acz(paramJSONObject);
      AppMethodBeat.o(327466);
      return true;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47021);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47021);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.k
 * JD-Core Version:    0.7.0.1
 */