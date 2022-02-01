package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.ui.aj;
import java.util.Map;

public class i
  extends ae
  implements m
{
  i()
  {
    super(a.class);
  }
  
  public final void CR()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.CR();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void box() {}
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((j)super.getRuntime()).lqZ.a(this, paramInt, paramString);
    AppMethodBeat.o(47521);
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<i>
  {
    public a(i parami)
    {
      super();
    }
    
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.m> Ch()
    {
      AppMethodBeat.i(162530);
      Map localMap = q.beI();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean cd(String paramString)
    {
      AppMethodBeat.i(47518);
      ((i)CM()).N(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((i)i.a.this.CM()).bs(false);
          ((i)i.a.this.CM()).bqy().setNavHidden(true);
          ((i)i.a.this.CM()).onReady();
          i.a.this.lyD.setVisibility(4);
          aj.jJ(i.a.this.getContext());
          AppMethodBeat.o(47516);
        }
      });
      AppMethodBeat.o(47518);
      return true;
    }
    
    public final ay dH(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.i
 * JD-Core Version:    0.7.0.1
 */