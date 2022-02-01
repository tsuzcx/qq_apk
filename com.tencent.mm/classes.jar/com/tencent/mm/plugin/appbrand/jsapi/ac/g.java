package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b<ad>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  private static int a(ad paramad, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(184724);
    try
    {
      if (paramJSONObject.has("backgroundColor"))
      {
        i = com.tencent.mm.plugin.appbrand.y.g.VI(paramJSONObject.getString("backgroundColor"));
        AppMethodBeat.o(184724);
        return i;
      }
    }
    catch (Exception paramJSONObject)
    {
      int i;
      if ((paramad instanceof com.tencent.mm.plugin.appbrand.game.f.d))
      {
        AppMethodBeat.o(184724);
        return 0;
      }
      if (paramad.getRuntime().getAppConfig().bem())
      {
        i = android.support.v4.content.b.n(paramad.getContext(), 2131099726);
        AppMethodBeat.o(184724);
        return i;
      }
      AppMethodBeat.o(184724);
    }
    return -1;
  }
  
  static void l(a parama)
  {
    AppMethodBeat.i(222735);
    for (;;)
    {
      try
      {
        localObject = parama.getPageView().mcJ;
        if (localObject != null)
        {
          ((ax)localObject).getWrapperView().setFocusable(false);
          ((ax)localObject).getWrapperView().setFocusableInTouchMode(false);
          ((ax)localObject).getContentView().setFocusable(false);
          ((ax)localObject).getContentView().setFocusableInTouchMode(false);
          if ((((ax)localObject).getWrapperView() instanceof ViewGroup)) {
            ((ViewGroup)((ax)localObject).getWrapperView()).setDescendantFocusability(393216);
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
        localObject = parama.getWebView().getView();
        ((View)localObject).setFocusable(true);
        ((View)localObject).setFocusableInTouchMode(true);
        ((View)localObject).setFocusable(true);
        ((View)localObject).setFocusableInTouchMode(true);
        parama.requestFocus();
        AppMethodBeat.o(222735);
        return;
      }
      catch (Throwable parama)
      {
        AppMethodBeat.o(222735);
        return;
      }
    }
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47015);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47015);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.g
 * JD-Core Version:    0.7.0.1
 */