package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public class u
  implements i.b, i.c
{
  ac cwK;
  private e kHi;
  private List<t> kHj;
  private String mAppId;
  private View noT;
  
  public u(ac paramac, List<t> paramList)
  {
    this(paramac, paramList, true);
    AppMethodBeat.i(135013);
    AppMethodBeat.o(135013);
  }
  
  public u(ac paramac, List<t> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(176563);
    this.noT = null;
    this.mAppId = paramac.getAppId();
    this.cwK = paramac;
    this.kHj = paramList;
    paramList = paramac.getContext();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.kHi = new e(paramList, false, i);
      paramac = paramac.getRuntime().getWindowAndroid();
      Log.i("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", new Object[] { Integer.valueOf(paramac.getVDisplayMetrics().widthPixels) });
      if (paramac.OD())
      {
        paramList = this.kHi;
        float f = paramac.getVDisplayMetrics().widthPixels;
        paramList.mLQ = ((int)(paramac.getScale() * f));
      }
      paramac = this.cwK.bRy();
      if (paramac != null)
      {
        this.kHi.V(paramac, true);
        this.noT = paramac;
      }
      paramac = this.cwK.bRz();
      if (paramac != null) {
        this.kHi.setFooterView(paramac);
      }
      this.kHi.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(135008);
          u.a(u.this, paramAnonymousm, true);
          AppMethodBeat.o(135008);
        }
      };
      this.kHi.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(135009);
          u.a(u.this, paramAnonymousMenuItem);
          AppMethodBeat.o(135009);
        }
      };
      this.kHi.QNH = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(135010);
          u.a(u.this, paramAnonymousm, false);
          AppMethodBeat.o(135010);
        }
      };
      this.kHi.QNK = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(135011);
          u.a(u.this, paramAnonymousMenuItem);
          AppMethodBeat.o(135011);
        }
      };
      if (e.a.oms == this.cwK.nqR) {
        this.kHi.setBackgroundColor(Color.parseColor("#000000"));
      }
      AppMethodBeat.o(176563);
      return;
    }
  }
  
  private boolean btZ()
  {
    AppMethodBeat.i(135015);
    try
    {
      this.kHi.bMo();
      this.cwK.b(this);
      this.cwK.b(this);
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
  
  protected void a(e parame) {}
  
  public final boolean btY()
  {
    AppMethodBeat.i(135014);
    for (;;)
    {
      try
      {
        e locale = this.kHi;
        if (!this.cwK.btO())
        {
          if (this.cwK.isFullScreen())
          {
            break label143;
            locale.mLN = bool;
            locale = this.kHi;
            if (this.cwK.btO()) {
              break label148;
            }
            if (this.cwK.isFullScreen())
            {
              break label148;
              locale.mLO = bool;
              a(this.kHi);
              this.kHi.dGm();
              this.cwK.a(this);
              this.cwK.a(this);
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
      label143:
      continue;
      label148:
      boolean bool = true;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(135017);
    btZ();
    AppMethodBeat.o(135017);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135016);
    btZ();
    AppMethodBeat.o(135016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */