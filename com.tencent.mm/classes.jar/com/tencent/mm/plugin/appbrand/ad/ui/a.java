package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class a
{
  private ac cwK;
  private e kHi;
  private List<t> kHj;
  private Context mContext;
  
  public a(Context paramContext, ac paramac, List<t> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.cwK = paramac;
    this.kHj = paramList;
    this.kHi = new e(paramContext, false, 0);
    paramContext = this.cwK.bRy();
    if (paramContext != null) {
      this.kHi.V(paramContext, true);
    }
    this.kHi.HLX = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymousm, true);
        AppMethodBeat.o(160557);
      }
    };
    this.kHi.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.kHi.QNH = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymousm, false);
        AppMethodBeat.o(160559);
      }
    };
    this.kHi.QNK = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (e.a.oms == this.cwK.nqR) {
      this.kHi.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean btY()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.kHi.dGm();
      AppMethodBeat.o(160562);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandAdActionSheet", "show exception = %s", new Object[] { localException });
      AppMethodBeat.o(160562);
    }
    return false;
  }
  
  public final boolean btZ()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.kHi.bMo();
      AppMethodBeat.o(160563);
      return true;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrandAdActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(160563);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */