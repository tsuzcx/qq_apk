package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class s
  implements f.b, f.c
{
  aa ckN;
  private e jCA;
  private List<q> jCB;
  private String mAppId;
  private View mag;
  
  public s(aa paramaa, List<q> paramList)
  {
    this(paramaa, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public s(aa paramaa, List<q> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.mag = null;
    this.mAppId = paramaa.getAppId();
    this.ckN = paramaa;
    this.jCB = paramList;
    paramList = paramaa.getRuntime().getWindowAndroid();
    if ((paramList != null) && (paramList.aWN())) {}
    for (boolean bool = false;; bool = true)
    {
      paramaa = paramaa.getContext();
      if (paramBoolean) {}
      for (;;)
      {
        this.jCA = new e(paramaa, bool, i);
        paramaa = this.ckN.Ep();
        if (paramaa != null)
        {
          this.jCA.K(paramaa, true);
          this.mag = paramaa;
        }
        paramList = this.ckN.buL();
        if (paramList != null) {
          this.jCA.setFooterView(paramList);
        }
        this.jCA.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135008);
            s.a(s.this, paramAnonymousl, true);
            AppMethodBeat.o(135008);
          }
        };
        this.jCA.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135009);
            s.a(s.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135009);
          }
        };
        this.jCA.KWs = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135010);
            s.a(s.this, paramAnonymousl, false);
            AppMethodBeat.o(135010);
          }
        };
        this.jCA.KWv = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135011);
            s.a(s.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135011);
          }
        };
        if (this.ckN.mbY) {
          this.jCA.setBackgroundColor(Color.parseColor("#000000"));
        }
        paramList = this.ckN.getRuntime().getWindowAndroid();
        if ((paramaa != null) && (paramList != null)) {
          paramaa.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(135012);
              paramAnonymousView = paramAnonymousView.getRootView().findViewById(2131297463);
              if ((s.this.ckN.buM()) || (paramAnonymousView == null))
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
  
  private boolean aYs()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.jCA.bpT();
      this.ckN.b(this);
      this.ckN.b(this);
      AppMethodBeat.o(135015);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(135015);
    }
    return false;
  }
  
  protected void a(e parame) {}
  
  public final boolean aYr()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.jCA;
        if (!this.ckN.buM())
        {
          if (this.ckN.isFullScreen())
          {
            break label142;
            locale.lzG = bool;
            locale = this.jCA;
            if (this.ckN.buM()) {
              break label147;
            }
            if (this.ckN.isFullScreen())
            {
              break label147;
              locale.lzH = bool;
              a(this.jCA);
              this.jCA.cMW();
              this.ckN.a(this);
              this.ckN.a(this);
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
        ad.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
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
    aYs();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    aYs();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */