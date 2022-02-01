package com.tencent.mm.plugin.appbrand.luggage.c;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bq;
import com.tencent.mm.plugin.appbrand.page.u;

public final class c
  extends u
{
  private final bq lUV;
  
  public c(Context paramContext, p paramp)
  {
    super(paramContext, paramp);
    AppMethodBeat.i(47554);
    this.lUV = new bq()
    {
      private final bq lUW;
      
      public final <WIDGET extends View> WIDGET c(Context paramAnonymousContext, Class<WIDGET> paramAnonymousClass)
      {
        AppMethodBeat.i(47553);
        if (com.tencent.mm.plugin.appbrand.widget.tabbar.a.class == paramAnonymousClass)
        {
          paramAnonymousContext = (View)paramAnonymousClass.cast(new com.tencent.mm.plugin.m.a.d.a(paramAnonymousContext));
          AppMethodBeat.o(47553);
          return paramAnonymousContext;
        }
        paramAnonymousContext = this.lUW.c(paramAnonymousContext, paramAnonymousClass);
        AppMethodBeat.o(47553);
        return paramAnonymousContext;
      }
    };
    super.setDecorWidgetFactory(this.lUV);
    AppMethodBeat.o(47554);
  }
  
  public final ad bsT()
  {
    AppMethodBeat.i(175010);
    d locald = e.ST(getAppId());
    if (locald != null)
    {
      AppMethodBeat.o(175010);
      return locald;
    }
    locald = new d();
    AppMethodBeat.o(175010);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.c
 * JD-Core Version:    0.7.0.1
 */