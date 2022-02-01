package com.tencent.mm.plugin.appbrand.luggage.c;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.u;

public final class c
  extends u
{
  private final bx kPL;
  
  public c(Context paramContext, o paramo)
  {
    super(paramContext, paramo);
    AppMethodBeat.i(47554);
    this.kPL = new bx()
    {
      private final bx kPM;
      
      public final <WIDGET extends View> WIDGET c(Context paramAnonymousContext, Class<WIDGET> paramAnonymousClass)
      {
        AppMethodBeat.i(47553);
        if (com.tencent.mm.plugin.appbrand.widget.tabbar.a.class == paramAnonymousClass)
        {
          paramAnonymousContext = (View)paramAnonymousClass.cast(new com.tencent.mm.plugin.m.a.d.a(paramAnonymousContext));
          AppMethodBeat.o(47553);
          return paramAnonymousContext;
        }
        paramAnonymousContext = this.kPM.c(paramAnonymousContext, paramAnonymousClass);
        AppMethodBeat.o(47553);
        return paramAnonymousContext;
      }
    };
    super.setDecorWidgetFactory(this.kPL);
    AppMethodBeat.o(47554);
  }
  
  public final ae bhw()
  {
    AppMethodBeat.i(175010);
    d locald = e.KA(getAppId());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.c
 * JD-Core Version:    0.7.0.1
 */