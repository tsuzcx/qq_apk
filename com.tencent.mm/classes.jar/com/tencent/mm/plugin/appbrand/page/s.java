package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class s
  implements f.b, f.c
{
  aa caw;
  private e jiS;
  private List<p> jiT;
  private View lAH;
  private String mAppId;
  
  public s(aa paramaa, List<p> paramList)
  {
    this(paramaa, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public s(aa paramaa, List<p> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.lAH = null;
    this.mAppId = paramaa.getAppId();
    this.caw = paramaa;
    this.jiT = paramList;
    paramList = paramaa.getRuntime().getWindowAndroid();
    if ((paramList != null) && (paramList.aTx())) {}
    for (boolean bool = false;; bool = true)
    {
      paramaa = paramaa.getContext();
      if (paramBoolean) {}
      for (;;)
      {
        this.jiS = new e(paramaa, bool, i);
        paramaa = this.caw.CQ();
        if (paramaa != null)
        {
          this.jiS.J(paramaa, true);
          this.lAH = paramaa;
        }
        paramList = this.caw.bqL();
        if (paramList != null) {
          this.jiS.setFooterView(paramList);
        }
        this.jiS.ISu = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135008);
            s.a(s.this, paramAnonymousl, true);
            AppMethodBeat.o(135008);
          }
        };
        this.jiS.ISv = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135009);
            s.a(s.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135009);
          }
        };
        this.jiS.Jfj = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135010);
            s.a(s.this, paramAnonymousl, false);
            AppMethodBeat.o(135010);
          }
        };
        this.jiS.Jfl = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135011);
            s.a(s.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135011);
          }
        };
        if (this.caw.lCx) {
          this.jiS.setBackgroundColor(Color.parseColor("#000000"));
        }
        paramList = this.caw.getRuntime().getWindowAndroid();
        if ((paramaa != null) && (paramList != null)) {
          paramaa.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(135012);
              paramAnonymousView = paramAnonymousView.getRootView().findViewById(2131297463);
              if ((s.this.caw.bqM()) || (paramAnonymousView == null))
              {
                AppMethodBeat.o(135012);
                return;
              }
              AppMethodBeat.o(135012);
            }
            
            public final void onViewDetachedFromWindow(View paramAnonymousView) {}
          });
        }
        AppMethodBeat.o(176563);
        return;
        i = 1;
      }
    }
  }
  
  private boolean aUY()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.jiS.bmi();
      this.caw.b(this);
      this.caw.b(this);
      AppMethodBeat.o(135015);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(135015);
    }
    return false;
  }
  
  protected void a(e parame) {}
  
  public final boolean aUX()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.jiS;
        if (!this.caw.bqM())
        {
          if (this.caw.isFullScreen())
          {
            break label142;
            locale.lcG = bool;
            locale = this.jiS;
            if (this.caw.bqM()) {
              break label147;
            }
            if (this.caw.isFullScreen())
            {
              break label147;
              locale.lcH = bool;
              a(this.jiS);
              this.jiS.cED();
              this.caw.a(this);
              this.caw.a(this);
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
        ac.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
        AppMethodBeat.o(135014);
        return false;
      }
      label142:
      continue;
      label147:
      boolean bool = true;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135017);
    aUY();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    aUY();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */