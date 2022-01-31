package com.tencent.mm.plugin.appbrand.m;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.widget.b.f;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.am.a;

final class e$2
  implements am.a
{
  e$2(e parame, com.tencent.mm.plugin.appbrand.i parami) {}
  
  public final boolean tC()
  {
    if ((e.a(this.gQh)) || (e.b(this.gQh))) {
      return false;
    }
    f localf = new f(this.fAy.getContext());
    localf.setMessage(this.fAy.getContext().getString(y.j.luggage_app_brand_module_load_tips));
    localf.setOnCancelListener(e.c(this.gQh));
    localf.setCanceledOnTouchOutside(false);
    this.fAy.fys.b(localf);
    e.a(this.gQh, localf);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.e.2
 * JD-Core Version:    0.7.0.1
 */