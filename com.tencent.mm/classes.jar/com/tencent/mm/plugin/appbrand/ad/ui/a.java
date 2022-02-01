package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class a
{
  private aa caw;
  private e jiS;
  private List<p> jiT;
  private Context mContext;
  
  public a(Context paramContext, aa paramaa, List<p> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.caw = paramaa;
    this.jiT = paramList;
    this.jiS = new e(paramContext, true, 0);
    paramContext = this.caw.CQ();
    if (paramContext != null) {
      this.jiS.J(paramContext, true);
    }
    this.jiS.ISu = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymousl, true);
        AppMethodBeat.o(160557);
      }
    };
    this.jiS.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.jiS.Jfj = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymousl, false);
        AppMethodBeat.o(160559);
      }
    };
    this.jiS.Jfl = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (this.caw.lCx) {
      this.jiS.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean aUX()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.jiS.cED();
      AppMethodBeat.o(160562);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AppBrandAdActionSheet", "show exception = %s", new Object[] { localException });
      AppMethodBeat.o(160562);
    }
    return false;
  }
  
  public final boolean aUY()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.jiS.bmi();
      AppMethodBeat.o(160563);
      return true;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AppBrandAdActionSheet", "hide exception = %s", new Object[] { localException });
      AppMethodBeat.o(160563);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */