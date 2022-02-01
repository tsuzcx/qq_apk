package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class a
{
  private z ckP;
  private e jFy;
  private List<r> jFz;
  private Context mContext;
  
  public a(Context paramContext, z paramz, List<r> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.ckP = paramz;
    this.jFz = paramList;
    this.jFy = new e(paramContext, true, 0);
    paramContext = this.ckP.bvw();
    if (paramContext != null) {
      this.jFy.P(paramContext, true);
    }
    this.jFy.LfS = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymousl, true);
        AppMethodBeat.o(160557);
      }
    };
    this.jFy.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.jFy.LsQ = new n.d()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymousl, false);
        AppMethodBeat.o(160559);
      }
    };
    this.jFy.LsT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (e.a.mZn == this.ckP.mgs) {
      this.jFy.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean aYM()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.jFy.cPF();
      AppMethodBeat.o(160562);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AppBrandAdActionSheet", "show exception = %s", new Object[] { localException });
      AppMethodBeat.o(160562);
    }
    return false;
  }
  
  public final boolean aYN()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.jFy.bqD();
      AppMethodBeat.o(160563);
      return true;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AppBrandAdActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(160563);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */