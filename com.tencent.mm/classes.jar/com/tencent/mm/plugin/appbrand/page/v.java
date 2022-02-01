package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class v
  implements h.b, h.c
{
  private ad cvo;
  private String mAppId;
  private e nBc;
  private List<com.tencent.mm.plugin.appbrand.menu.v> nBd;
  private View qqD;
  Runnable qqE;
  Runnable qqF;
  
  public v(ad paramad, List<com.tencent.mm.plugin.appbrand.menu.v> paramList)
  {
    this(paramad, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public v(ad paramad, List<com.tencent.mm.plugin.appbrand.menu.v> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.qqD = null;
    this.mAppId = paramad.getAppId();
    this.cvo = paramad;
    this.nBd = paramList;
    paramList = paramad.getContext();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.nBc = new e(paramList, false, i);
      paramad = paramad.getRuntime().getWindowAndroid();
      Log.i("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", new Object[] { Integer.valueOf(paramad.getVDisplayMetrics().widthPixels) });
      if (paramad.RZ())
      {
        paramList = this.nBc;
        float f = paramad.getVDisplayMetrics().widthPixels;
        paramList.pMI = ((int)(paramad.getScale() * f));
      }
      paramad = this.cvo.cep();
      if (paramad != null)
      {
        this.nBc.Z(paramad, true);
        this.qqD = paramad;
      }
      paramad = this.cvo.ceq();
      if (paramad != null) {
        this.nBc.setFooterView(paramad);
      }
      this.nBc.ODT = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(243067);
          v.a(v.this, paramAnonymouso, true);
          AppMethodBeat.o(243067);
        }
      };
      this.nBc.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(245581);
          v.a(v.this, paramAnonymousMenuItem);
          AppMethodBeat.o(245581);
        }
      };
      this.nBc.Ymx = new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(244193);
          v.a(v.this, paramAnonymouso, false);
          AppMethodBeat.o(244193);
        }
      };
      this.nBc.YmA = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(245504);
          v.a(v.this, paramAnonymousMenuItem);
          AppMethodBeat.o(245504);
        }
      };
      if (f.a.roU == this.cvo.qsD) {
        this.nBc.setBackgroundColor(Color.parseColor("#000000"));
      }
      AppMethodBeat.o(176563);
      return;
    }
  }
  
  protected void a(e parame) {}
  
  public final boolean bEY()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.nBc;
        if (!this.cvo.bEN())
        {
          if (this.cvo.QT())
          {
            break label192;
            locale.pMF = bool;
            locale = this.nBc;
            if (this.cvo.bEN()) {
              break label197;
            }
            if (this.cvo.QT())
            {
              break label197;
              locale.pMG = bool;
              a(this.nBc);
              this.nBc.eik();
              this.cvo.a(this);
              this.cvo.a(this);
              this.nBc.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
              {
                public final void onViewAttachedToWindow(View paramAnonymousView)
                {
                  AppMethodBeat.i(242892);
                  if (v.this.qqE != null) {
                    v.this.qqE.run();
                  }
                  AppMethodBeat.o(242892);
                }
                
                public final void onViewDetachedFromWindow(View paramAnonymousView)
                {
                  AppMethodBeat.i(242893);
                  if (v.this.qqF != null) {
                    v.this.qqF.run();
                  }
                  AppMethodBeat.o(242893);
                }
              });
              this.nBc.getWindow().setFlags(131072, 131072);
              this.nBc.getWindow().setSoftInputMode(48);
              AppMethodBeat.o(135014);
              return true;
            }
          }
          else
          {
            bool = false;
            continue;
          }
          bool = false;
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
        AppMethodBeat.o(135014);
        return false;
      }
      label192:
      continue;
      label197:
      boolean bool = true;
    }
  }
  
  protected final boolean bEZ()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.nBc.bYF();
      this.cvo.b(this);
      this.cvo.b(this);
      AppMethodBeat.o(135015);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(135015);
    }
    return false;
  }
  
  protected final ad getPageView()
  {
    return this.cvo;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135017);
    bEZ();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    bEZ();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */