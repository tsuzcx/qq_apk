package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b<ae>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  private static int a(ae paramae, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(184724);
    try
    {
      if (paramJSONObject.has("backgroundColor"))
      {
        i = com.tencent.mm.plugin.appbrand.z.g.UX(paramJSONObject.getString("backgroundColor"));
        AppMethodBeat.o(184724);
        return i;
      }
    }
    catch (Exception paramJSONObject)
    {
      int i;
      if ((paramae instanceof com.tencent.mm.plugin.appbrand.game.f.d))
      {
        AppMethodBeat.o(184724);
        return 0;
      }
      if (paramae.getRuntime().getAppConfig().bdH())
      {
        i = android.support.v4.content.b.n(paramae.getContext(), 2131099726);
        AppMethodBeat.o(184724);
        return i;
      }
      AppMethodBeat.o(184724);
    }
    return -1;
  }
  
  static void l(a parama)
  {
    AppMethodBeat.i(188576);
    for (;;)
    {
      try
      {
        localObject = parama.getPageView().lYc;
        if (localObject != null)
        {
          ((ay)localObject).getWrapperView().setFocusable(false);
          ((ay)localObject).getWrapperView().setFocusableInTouchMode(false);
          ((ay)localObject).getContentView().setFocusable(false);
          ((ay)localObject).getContentView().setFocusableInTouchMode(false);
          if ((((ay)localObject).getWrapperView() instanceof ViewGroup)) {
            ((ViewGroup)((ay)localObject).getWrapperView()).setDescendantFocusability(393216);
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
        AppMethodBeat.o(188576);
        return;
      }
      catch (Throwable parama)
      {
        AppMethodBeat.o(188576);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.g
 * JD-Core Version:    0.7.0.1
 */