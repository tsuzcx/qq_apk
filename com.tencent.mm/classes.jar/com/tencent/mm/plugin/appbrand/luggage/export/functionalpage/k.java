package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.ui.al;
import java.util.Map;

public class k
  extends ad
  implements p
{
  k()
  {
    super(a.class);
  }
  
  public final void Es()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.Es();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void Ex()
  {
    AppMethodBeat.i(222812);
    bvi().setNavHidden(false);
    AppMethodBeat.o(222812);
  }
  
  public final void bta() {}
  
  public final void h(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((l)super.getRuntime()).lTa.a(this, paramInt, paramString);
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
    
    public final Map<String, m> DJ()
    {
      AppMethodBeat.i(162530);
      Map localMap = j.btf();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean cZ(String paramString)
    {
      AppMethodBeat.i(47518);
      ((k)Eo()).K(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((k)k.a.this.Eo()).bvi().fE(false);
          ((k)k.a.this.Eo()).bvi().setNavHidden(false);
          ((k)k.a.this.Eo()).bvi().setMainTitle(k.a.this.getContext().getResources().getString(2131758234));
          ((k)k.a.this.Eo()).bvi().setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100705));
          Object localObject = ((k)k.a.this.Eo()).bvi();
          if (al.isDarkMode())
          {
            locala = e.a.mZo;
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).setForegroundStyle(locala.name());
            localObject = (k)k.a.this.Eo();
            if (!al.isDarkMode()) {
              break label228;
            }
          }
          label228:
          for (e.a locala = e.a.mZo;; locala = e.a.mZn)
          {
            ((k)localObject).PE(locala.name());
            ((k)k.a.this.Eo()).kfr.setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100706));
            k.a((k)k.a.this.Eo());
            ((k)k.a.this.Eo()).TY("onLoadURL");
            AppMethodBeat.o(47516);
            return;
            locala = e.a.mZn;
            break;
          }
        }
      });
      AppMethodBeat.o(47518);
      return true;
    }
    
    public final ax dJ(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */