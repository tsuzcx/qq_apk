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
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class r
  implements f.b, f.c
{
  aa cdz;
  private e iIO;
  private List<p> iIP;
  private View kYX;
  private String mAppId;
  
  public r(aa paramaa, List<p> paramList)
  {
    this(paramaa, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public r(aa paramaa, List<p> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.kYX = null;
    this.mAppId = paramaa.getAppId();
    this.cdz = paramaa;
    this.iIP = paramList;
    paramList = paramaa.getRuntime().getWindowAndroid();
    if ((paramList != null) && (paramList.aMH())) {}
    for (boolean bool = false;; bool = true)
    {
      paramaa = paramaa.getContext();
      if (paramBoolean) {}
      for (;;)
      {
        this.iIO = new e(paramaa, bool, i);
        paramaa = this.cdz.Dn();
        if (paramaa != null)
        {
          this.iIO.J(paramaa, true);
          this.kYX = paramaa;
        }
        paramList = this.cdz.bjU();
        if (paramList != null) {
          this.iIO.setFooterView(paramList);
        }
        this.iIO.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135008);
            r.a(r.this, paramAnonymousl, true);
            AppMethodBeat.o(135008);
          }
        };
        this.iIO.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135009);
            r.a(r.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135009);
          }
        };
        this.iIO.HEP = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135010);
            r.a(r.this, paramAnonymousl, false);
            AppMethodBeat.o(135010);
          }
        };
        this.iIO.HER = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135011);
            r.a(r.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135011);
          }
        };
        if (this.cdz.laY) {
          this.iIO.setBackgroundColor(Color.parseColor("#000000"));
        }
        paramList = this.cdz.getRuntime().getWindowAndroid();
        if ((paramaa != null) && (paramList != null)) {
          paramaa.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
          {
            public final void onViewAttachedToWindow(View paramAnonymousView)
            {
              AppMethodBeat.i(135012);
              paramAnonymousView = paramAnonymousView.getRootView().findViewById(2131297463);
              if ((r.this.cdz.bjV()) || (paramAnonymousView == null))
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
  
  private boolean aOi()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.iIO.bfo();
      this.cdz.b(this);
      this.cdz.b(this);
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
  
  public final boolean aOh()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.iIO;
        if (!this.cdz.bjV())
        {
          if (this.cdz.isFullScreen())
          {
            break label142;
            locale.kBo = bool;
            locale = this.iIO;
            if (this.cdz.bjV()) {
              break label147;
            }
            if (this.cdz.isFullScreen())
            {
              break label147;
              locale.kBp = bool;
              a(this.iIO);
              this.iIO.csG();
              this.cdz.a(this);
              this.cdz.a(this);
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
    aOi();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    aOi();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */