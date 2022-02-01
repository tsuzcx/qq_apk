package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class a
{
  private aa ckN;
  private e jCA;
  private List<q> jCB;
  private Context mContext;
  
  public a(Context paramContext, aa paramaa, List<q> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.ckN = paramaa;
    this.jCB = paramList;
    this.jCA = new e(paramContext, true, 0);
    paramContext = this.ckN.Ep();
    if (paramContext != null) {
      this.jCA.K(paramContext, true);
    }
    this.jCA.KJy = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymousl, true);
        AppMethodBeat.o(160557);
      }
    };
    this.jCA.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.jCA.KWs = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymousl, false);
        AppMethodBeat.o(160559);
      }
    };
    this.jCA.KWv = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (this.ckN.mbY) {
      this.jCA.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean aYr()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.jCA.cMW();
      AppMethodBeat.o(160562);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandAdActionSheet", "show exception = %s", new Object[] { localException });
      AppMethodBeat.o(160562);
    }
    return false;
  }
  
  public final boolean aYs()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.jCA.bpT();
      AppMethodBeat.o(160563);
      return true;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrandAdActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(160563);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */