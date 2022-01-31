package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.debugger.r;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.ui.base.l;

public final class h
  extends a
{
  public h()
  {
    super(o.gPp.ordinal());
  }
  
  public final void a(Context paramContext, q paramq, l paraml, String paramString)
  {
    if (((paramq.getRuntime() instanceof com.tencent.mm.plugin.appbrand.n)) && (((com.tencent.mm.plugin.appbrand.n)paramq.getRuntime()).aah()))
    {
      if (r.aeN()) {
        paraml.e(this.gPE, "Disable Preload");
      }
    }
    else {
      return;
    }
    paraml.e(this.gPE, "Enable Preload");
  }
  
  public final void a(Context paramContext, q paramq, String paramString, n paramn)
  {
    if (r.aeN())
    {
      r.cP(false);
      Toast.makeText(paramContext, "Disable success, please restart WeChat to take effect.", 1).show();
      return;
    }
    r.cP(true);
    Toast.makeText(paramContext, "Enable success, please restart WeChat to take effect.", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.h
 * JD-Core Version:    0.7.0.1
 */