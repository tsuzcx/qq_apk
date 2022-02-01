package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.ui.aw;
import java.util.Map;

public class k
  extends ah
  implements p
{
  String tfV;
  
  k()
  {
    super(a.class);
  }
  
  public final void arb()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.arb();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void arg()
  {
    AppMethodBeat.i(319939);
    cEC().setNavHidden(false);
    AppMethodBeat.o(319939);
  }
  
  public final void c(cb paramcb)
  {
    AppMethodBeat.i(319972);
    super.c(paramcb);
    cEC().setNavHidden(true);
    AppMethodBeat.o(319972);
  }
  
  public final l cBh()
  {
    AppMethodBeat.i(370011);
    l locall = (l)super.getRuntime();
    AppMethodBeat.o(370011);
    return locall;
  }
  
  public final void cBp() {}
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((l)super.getRuntime()).tfX.a(this, paramInt, paramString);
    AppMethodBeat.o(47521);
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<k>
  {
    public a(k paramk)
    {
      super();
    }
    
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> aqh()
    {
      AppMethodBeat.i(162530);
      Map localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.cBv();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean b(String paramString, cb paramcb)
    {
      AppMethodBeat.i(319914);
      ((k)aqX()).V(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((k)k.a.this.aqX()).cEC().hZ(false);
          ((k)k.a.this.aqX()).cEC().setNavHidden(false);
          ((k)k.a.this.aqX()).cEC().setMainTitle(k.a.this.getContext().getResources().getString(ba.i.appbrand_functional_page_for_wmpf_title));
          ((k)k.a.this.aqX()).cEC().setBackgroundColor(androidx.core.content.a.w(k.a.this.getContext(), ba.c.normal_actionbar_color));
          Object localObject = ((k)k.a.this.aqX()).cEC();
          if (aw.isDarkMode())
          {
            locala = f.a.uzg;
            ((b)localObject).setForegroundStyle(locala.name());
            localObject = (k)k.a.this.aqX();
            if (!aw.isDarkMode()) {
              break label231;
            }
          }
          label231:
          for (f.a locala = f.a.uzg;; locala = f.a.uzf)
          {
            ((k)localObject).Zz(locala.name());
            ((k)k.a.this.aqX()).getContentView().setBackgroundColor(androidx.core.content.a.w(k.a.this.getContext(), ba.c.normal_bg_color));
            k.a((k)k.a.this.aqX());
            ((k)k.a.this.aqX()).aeN("onLoadURL");
            AppMethodBeat.o(47516);
            return;
            locala = f.a.uzf;
            break;
          }
        }
      });
      AppMethodBeat.o(319914);
      return true;
    }
    
    public final bd eC(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */