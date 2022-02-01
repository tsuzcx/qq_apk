package com.tencent.mm.plugin.appbrand.ad.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.List;

public final class a
{
  private ad enm;
  private Context mContext;
  private f qAo;
  private List<w> qAp;
  
  public a(Context paramContext, ad paramad, List<w> paramList)
  {
    AppMethodBeat.i(160561);
    this.mContext = paramContext;
    this.enm = paramad;
    this.qAp = paramList;
    this.qAo = new f(paramContext, false, 0);
    paramContext = this.enm.fc(this.mContext);
    if (paramContext != null) {
      this.qAo.af(paramContext, true);
    }
    this.qAo.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(160557);
        a.a(a.this, paramAnonymouss, true);
        AppMethodBeat.o(160557);
      }
    };
    this.qAo.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160558);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160558);
      }
    };
    this.qAo.GAz = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(160559);
        a.a(a.this, paramAnonymouss, false);
        AppMethodBeat.o(160559);
      }
    };
    this.qAo.agem = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(160560);
        a.a(a.this, paramAnonymousMenuItem);
        AppMethodBeat.o(160560);
      }
    };
    if (f.a.uzf == this.enm.txh) {
      this.qAo.setBackgroundColor(Color.parseColor("#000000"));
    }
    AppMethodBeat.o(160561);
  }
  
  public final boolean cem()
  {
    AppMethodBeat.i(160562);
    try
    {
      this.qAo.dDn();
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
  
  public final boolean cen()
  {
    AppMethodBeat.i(160563);
    try
    {
      this.qAo.cyW();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ad.ui.a
 * JD-Core Version:    0.7.0.1
 */