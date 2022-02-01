package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.page.ca;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.ui.ar;
import java.util.Map;

public class k
  extends ah
  implements p
{
  private String qaP;
  
  k()
  {
    super(a.class);
  }
  
  public final void QO()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.QO();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void QU()
  {
    AppMethodBeat.i(279190);
    cdY().setNavHidden(false);
    AppMethodBeat.o(279190);
  }
  
  public final void ako(String paramString)
  {
    this.qaP = paramString;
  }
  
  public final void b(ca paramca)
  {
    AppMethodBeat.i(279192);
    super.b(paramca);
    cdY().setNavHidden(true);
    AppMethodBeat.o(279192);
  }
  
  public final void caV() {}
  
  public final void j(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((l)super.getRuntime()).qaR.a(this, paramInt, paramString);
    AppMethodBeat.o(47521);
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<k>
  {
    public a(k paramk)
    {
      super();
    }
    
    public final Map<String, o> PX()
    {
      AppMethodBeat.i(162530);
      Map localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.cbc();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean b(String paramString, ca paramca)
    {
      AppMethodBeat.i(265092);
      ((k)QK()).P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((k)k.a.this.QK()).cdY().hk(false);
          ((k)k.a.this.QK()).cdY().setNavHidden(false);
          ((k)k.a.this.QK()).cdY().setMainTitle(k.a.this.getContext().getResources().getString(au.i.appbrand_functional_page_for_wmpf_title));
          ((k)k.a.this.QK()).cdY().setBackgroundColor(androidx.core.content.a.w(k.a.this.getContext(), au.c.normal_actionbar_color));
          Object localObject = ((k)k.a.this.QK()).cdY();
          if (ar.isDarkMode())
          {
            locala = f.a.roV;
            ((b)localObject).setForegroundStyle(locala.name());
            localObject = (k)k.a.this.QK();
            if (!ar.isDarkMode()) {
              break label231;
            }
          }
          label231:
          for (f.a locala = f.a.roV;; locala = f.a.roU)
          {
            ((k)localObject).agD(locala.name());
            ((k)k.a.this.QK()).getContentView().setBackgroundColor(androidx.core.content.a.w(k.a.this.getContext(), au.c.normal_bg_color));
            k.a((k)k.a.this.QK());
            ((k)k.a.this.QK()).alH("onLoadURL");
            AppMethodBeat.o(47516);
            return;
            locala = f.a.roU;
            break;
          }
        }
      });
      AppMethodBeat.o(265092);
      return true;
    }
    
    public final bd ed(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */