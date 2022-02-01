package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b<ah>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  private static int a(ah paramah, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(184724);
    try
    {
      if (paramJSONObject.has("backgroundColor"))
      {
        i = com.tencent.mm.plugin.appbrand.af.i.agw(paramJSONObject.getString("backgroundColor"));
        AppMethodBeat.o(184724);
        return i;
      }
    }
    catch (Exception paramJSONObject)
    {
      int i;
      if ((paramah instanceof d))
      {
        AppMethodBeat.o(184724);
        return 0;
      }
      if (paramah.getRuntime().getAppConfig().ckr())
      {
        i = androidx.core.content.a.w(paramah.getContext(), ba.c.Dark_0);
        AppMethodBeat.o(184724);
        return i;
      }
      AppMethodBeat.o(184724);
    }
    return -1;
  }
  
  static void c(g.c paramc)
  {
    AppMethodBeat.i(327470);
    for (;;)
    {
      try
      {
        localObject1 = paramc.getPageView().tti;
        if (localObject1 != null)
        {
          ((bd)localObject1).getWrapperView().setFocusable(false);
          ((bd)localObject1).getWrapperView().setFocusableInTouchMode(false);
          ((bd)localObject1).getContentView().setFocusable(false);
          ((bd)localObject1).getContentView().setFocusableInTouchMode(false);
          if ((((bd)localObject1).getWrapperView() instanceof ViewGroup)) {
            ((ViewGroup)((bd)localObject1).getWrapperView()).setDescendantFocusability(393216);
          }
        }
      }
      finally
      {
        Object localObject1;
        continue;
      }
      try
      {
        localObject1 = paramc.getWebView().getView();
        ((View)localObject1).setFocusable(true);
        ((View)localObject1).setFocusableInTouchMode(true);
        ((View)localObject1).setFocusable(true);
        ((View)localObject1).setFocusableInTouchMode(true);
        paramc.getAndroidView().requestFocus();
      }
      finally
      {
        AppMethodBeat.o(327470);
        return;
      }
    }
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47015);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47015);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.i
 * JD-Core Version:    0.7.0.1
 */