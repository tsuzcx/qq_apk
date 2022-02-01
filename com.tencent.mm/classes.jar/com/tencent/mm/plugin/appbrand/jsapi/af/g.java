package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b<ag>
{
  public static final int CTRL_INDEX = 298;
  public static final String NAME = "insertHTMLWebView";
  
  private static int a(ag paramag, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(184724);
    try
    {
      if (paramJSONObject.has("backgroundColor"))
      {
        i = com.tencent.mm.plugin.appbrand.ac.g.afE(paramJSONObject.getString("backgroundColor"));
        AppMethodBeat.o(184724);
        return i;
      }
    }
    catch (Exception paramJSONObject)
    {
      int i;
      if ((paramag instanceof d))
      {
        AppMethodBeat.o(184724);
        return 0;
      }
      if (paramag.getRuntime().getAppConfig().bzD())
      {
        i = android.support.v4.content.b.n(paramag.getContext(), 2131099740);
        AppMethodBeat.o(184724);
        return i;
      }
      AppMethodBeat.o(184724);
    }
    return -1;
  }
  
  static void l(a parama)
  {
    AppMethodBeat.i(227046);
    for (;;)
    {
      try
      {
        localObject = parama.getPageView().nmX;
        if (localObject != null)
        {
          ((bb)localObject).getWrapperView().setFocusable(false);
          ((bb)localObject).getWrapperView().setFocusableInTouchMode(false);
          ((bb)localObject).getContentView().setFocusable(false);
          ((bb)localObject).getContentView().setFocusableInTouchMode(false);
          if ((((bb)localObject).getWrapperView() instanceof ViewGroup)) {
            ((ViewGroup)((bb)localObject).getWrapperView()).setDescendantFocusability(393216);
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
        AppMethodBeat.o(227046);
        return;
      }
      catch (Throwable parama)
      {
        AppMethodBeat.o(227046);
        return;
      }
    }
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(47015);
    int i = paramJSONObject.getInt("htmlId");
    AppMethodBeat.o(47015);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.g
 * JD-Core Version:    0.7.0.1
 */