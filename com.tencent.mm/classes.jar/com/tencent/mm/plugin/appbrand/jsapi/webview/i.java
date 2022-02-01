package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.t;
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
        i = g.ang(paramJSONObject.getString("backgroundColor"));
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
      if (paramah.getRuntime().getAppConfig().bKS())
      {
        i = androidx.core.content.a.w(paramah.getContext(), au.c.Dark_0);
        AppMethodBeat.o(184724);
        return i;
      }
      AppMethodBeat.o(184724);
    }
    return -1;
  }
  
  static void c(g.c paramc)
  {
    AppMethodBeat.i(265174);
    for (;;)
    {
      try
      {
        localObject = paramc.getPageView().qoF;
        if (localObject != null)
        {
          ((bd)localObject).getWrapperView().setFocusable(false);
          ((bd)localObject).getWrapperView().setFocusableInTouchMode(false);
          ((bd)localObject).getContentView().setFocusable(false);
          ((bd)localObject).getContentView().setFocusableInTouchMode(false);
          if ((((bd)localObject).getWrapperView() instanceof ViewGroup)) {
            ((ViewGroup)((bd)localObject).getWrapperView()).setDescendantFocusability(393216);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        continue;
      }
      try
      {
        localObject = paramc.getWebView().getView();
        ((View)localObject).setFocusable(true);
        ((View)localObject).setFocusableInTouchMode(true);
        ((View)localObject).setFocusable(true);
        ((View)localObject).setFocusableInTouchMode(true);
        paramc.getAndroidView().requestFocus();
        AppMethodBeat.o(265174);
        return;
      }
      catch (Throwable paramc)
      {
        AppMethodBeat.o(265174);
        return;
      }
    }
  }
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47015);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47015);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.i
 * JD-Core Version:    0.7.0.1
 */