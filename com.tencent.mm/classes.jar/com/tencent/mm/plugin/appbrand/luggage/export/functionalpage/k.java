package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.ui.ao;
import java.util.Map;

public class k
  extends ag
  implements p
{
  private String naA;
  
  k()
  {
    super(a.class);
  }
  
  public final void NR()
  {
    AppMethodBeat.i(47522);
    try
    {
      super.NR();
      AppMethodBeat.o(47522);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      AppMethodBeat.o(47522);
    }
  }
  
  public final void NW()
  {
    AppMethodBeat.i(227141);
    bRi().setNavHidden(false);
    AppMethodBeat.o(227141);
  }
  
  public final void acu(String paramString)
  {
    this.naA = paramString;
  }
  
  public final void bOE() {}
  
  public final void bOF()
  {
    AppMethodBeat.i(227142);
    super.bOF();
    bRi().setNavHidden(true);
    AppMethodBeat.o(227142);
  }
  
  public final void i(int paramInt, String paramString)
  {
    AppMethodBeat.i(47521);
    ((l)super.getRuntime()).naC.a(this, paramInt, paramString);
    AppMethodBeat.o(47521);
  }
  
  static final class a
    extends com.tencent.mm.plugin.appbrand.page.a<k>
  {
    public a(k paramk)
    {
      super();
    }
    
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf()
    {
      AppMethodBeat.i(162530);
      Map localMap = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.bOM();
      AppMethodBeat.o(162530);
      return localMap;
    }
    
    public final boolean dy(String paramString)
    {
      AppMethodBeat.i(47518);
      ((k)NN()).P(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(47516);
          ((k)k.a.this.NN()).bRi().gz(false);
          ((k)k.a.this.NN()).bRi().setNavHidden(false);
          ((k)k.a.this.NN()).bRi().setMainTitle(k.a.this.getContext().getResources().getString(2131756052));
          ((k)k.a.this.NN()).bRi().setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100898));
          Object localObject = ((k)k.a.this.NN()).bRi();
          if (ao.isDarkMode())
          {
            locala = e.a.omt;
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject).setForegroundStyle(locala.name());
            localObject = (k)k.a.this.NN();
            if (!ao.isDarkMode()) {
              break label228;
            }
          }
          label228:
          for (e.a locala = e.a.omt;; locala = e.a.oms)
          {
            ((k)localObject).YP(locala.name());
            ((k)k.a.this.NN()).getContentView().setBackgroundColor(android.support.v4.content.b.n(k.a.this.getContext(), 2131100899));
            k.a((k)k.a.this.NN());
            ((k)k.a.this.NN()).adM("onLoadURL");
            AppMethodBeat.o(47516);
            return;
            locala = e.a.oms;
            break;
          }
        }
      });
      AppMethodBeat.o(47518);
      return true;
    }
    
    public final bb ee(Context paramContext)
    {
      AppMethodBeat.i(47517);
      paramContext = new com.tencent.luggage.game.page.a();
      AppMethodBeat.o(47517);
      return paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k
 * JD-Core Version:    0.7.0.1
 */