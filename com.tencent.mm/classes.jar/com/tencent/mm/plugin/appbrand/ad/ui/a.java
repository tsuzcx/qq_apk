package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.v;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public final class a
{
  private ad cvo;
  private Context mContext;
  private e nBc;
  private List<v> nBd;
  
  public a(Context paramContext, ad paramad, List<v> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.cvo = paramad;
    this.nBd = paramList;
    this.nBc = new e(paramContext, false, 0);
    paramContext = this.cvo.cep();
    if (paramContext != null) {
      this.nBc.Z(paramContext, true);
    }
    this.nBc.ODT = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymouso, true);
        AppMethodBeat.o(160557);
      }
    };
    this.nBc.ODU = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.nBc.Ymx = new q.f()
    {
      public final void onCreateMMMenu(o paramAnonymouso)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymouso, false);
        AppMethodBeat.o(160559);
      }
    };
    this.nBc.YmA = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (f.a.roU == this.cvo.qsD) {
      this.nBc.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean bEY()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.nBc.eik();
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
  
  public final boolean bEZ()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.nBc.bYF();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */