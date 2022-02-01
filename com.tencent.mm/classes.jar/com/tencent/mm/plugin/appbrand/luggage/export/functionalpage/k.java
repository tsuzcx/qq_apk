package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.a.d.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.ui.al;
import java.util.Map;

public class k
  extends ae
  implements p
{
  k()
  {
    super(a.class);
  }
  
  public final void Eq()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.Eq();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void Ev()
  {
    AppMethodBeat.i(188650);
    bux().setNavHidden(false);
    AppMethodBeat.o(188650);
  }
  
  public final void bsp() {}
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((l)super.getRuntime()).lOz.a(this, paramInt, paramString);
    AppMethodBeat.o(47521);
  }
  
  public final void ha(boolean paramBoolean) {}
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<k>
  {
    public a(k paramk)
    {
      super();
    }
    
    public final Map<String, m> DG()
    {
      AppMethodBeat.i(162530);
      Map localMap = j.bsu();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean cX(String paramString)
    {
      AppMethodBeat.i(47518);
      ((k)El()).M(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((k)k.a.this.El()).bux().hK(false);
          ((k)k.a.this.El()).bux().setNavHidden(false);
          ((k)k.a.this.El()).bux().setMainTitle(k.a.this.getContext().getResources().getString(2131758234));
          ((k)k.a.this.El()).bux().setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100705));
          Object localObject = ((k)k.a.this.El()).bux();
          if (al.isDarkMode())
          {
            locala = d.a.mfZ;
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).setForegroundStyle(locala.name());
            localObject = (k)k.a.this.El();
            if (!al.isDarkMode()) {
              break label228;
            }
          }
          label228:
          for (d.a locala = d.a.mfZ;; locala = d.a.mfY)
          {
            ((k)localObject).OW(locala.name());
            ((k)k.a.this.El()).kca.setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100706));
            k.a((k)k.a.this.El());
            ((k)k.a.this.El()).Tn("onLoadURL");
            AppMethodBeat.o(47516);
            return;
            locala = d.a.mfY;
            break;
          }
        }
      });
      AppMethodBeat.o(47518);
      return true;
    }
    
    public final ay dF(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */