package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.ai;
import java.util.Map;

final class i$a
  extends com.tencent.mm.plugin.appbrand.page.a<i>
{
  public i$a(i parami)
  {
    super(parami);
  }
  
  public final Map<String, m> CD()
  {
    AppMethodBeat.i(162530);
    Map localMap = q.aXL();
    AppMethodBeat.o(162530);
    return localMap;
  }
  
  public final boolean cn(String paramString)
  {
    AppMethodBeat.i(47518);
    ((i)Dj()).L(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47516);
        ((i)i.a.this.Dj()).bt(false);
        ((i)i.a.this.Dj()).bjH().setNavHidden(true);
        ((i)i.a.this.Dj()).onReady();
        i.a.this.kWT.setVisibility(4);
        ai.jy(i.a.this.getContext());
        AppMethodBeat.o(47516);
      }
    });
    AppMethodBeat.o(47518);
    return true;
  }
  
  public final bd dy(Context paramContext)
  {
    AppMethodBeat.i(47517);
    paramContext = new com.tencent.luggage.game.page.a();
    AppMethodBeat.o(47517);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i.a
 * JD-Core Version:    0.7.0.1
 */