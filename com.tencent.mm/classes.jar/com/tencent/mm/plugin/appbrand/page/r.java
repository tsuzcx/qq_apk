package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class r
  implements f.b, f.c
{
  z ckP;
  private e jFy;
  private List<com.tencent.mm.plugin.appbrand.menu.r> jFz;
  private String mAppId;
  private View mez;
  
  public r(z paramz, List<com.tencent.mm.plugin.appbrand.menu.r> paramList)
  {
    this(paramz, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public r(z paramz, List<com.tencent.mm.plugin.appbrand.menu.r> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.mez = null;
    this.mAppId = paramz.getAppId();
    this.ckP = paramz;
    this.jFz = paramList;
    paramList = paramz.getRuntime().getWindowAndroid();
    if (paramList.EX()) {}
    for (boolean bool = false;; bool = true)
    {
      paramz = paramz.getContext();
      if (paramBoolean) {}
      for (int i = 0;; i = 1)
      {
        this.jFy = new e(paramz, bool, i);
        ae.i("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", new Object[] { Integer.valueOf(paramList.getVDisplayMetrics().widthPixels) });
        if (paramList.EX()) {
          this.jFy.lEh = ((int)(paramList.getVDisplayMetrics().widthPixels * paramList.getScale()));
        }
        paramz = this.ckP.bvw();
        if (paramz != null)
        {
          this.jFy.P(paramz, true);
          this.mez = paramz;
        }
        paramz = this.ckP.bvx();
        if (paramz != null) {
          this.jFy.setFooterView(paramz);
        }
        this.jFy.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135008);
            r.a(r.this, paramAnonymousl, true);
            AppMethodBeat.o(135008);
          }
        };
        this.jFy.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135009);
            r.a(r.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135009);
          }
        };
        this.jFy.LsQ = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(135010);
            r.a(r.this, paramAnonymousl, false);
            AppMethodBeat.o(135010);
          }
        };
        this.jFy.LsT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(135011);
            r.a(r.this, paramAnonymousMenuItem);
            AppMethodBeat.o(135011);
          }
        };
        if (e.a.mZn == this.ckP.mgs) {
          this.jFy.setBackgroundColor(Color.parseColor("#000000"));
        }
        AppMethodBeat.o(176563);
        return;
      }
    }
  }
  
  private boolean aYN()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.jFy.bqD();
      this.ckP.b(this);
      this.ckP.b(this);
      AppMethodBeat.o(135015);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(135015);
    }
    return false;
  }
  
  protected void a(e parame) {}
  
  public final boolean aYM()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.jFy;
        if (!this.ckP.bvy())
        {
          if (this.ckP.isFullScreen())
          {
            break label143;
            locale.lEe = bool;
            locale = this.jFy;
            if (this.ckP.bvy()) {
              break label148;
            }
            if (this.ckP.isFullScreen())
            {
              break label148;
              locale.lEf = bool;
              a(this.jFy);
              this.jFy.cPF();
              this.ckP.a(this);
              this.ckP.a(this);
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
        ae.e("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
        AppMethodBeat.o(135014);
        return false;
      }
      label143:
      continue;
      label148:
      boolean bool = true;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135017);
    aYN();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    aYN();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r
 * JD-Core Version:    0.7.0.1
 */