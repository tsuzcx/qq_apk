package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.base.h;

final class e$d$2$1
  implements Runnable
{
  e$d$2$1(e.d.2 param2) {}
  
  public final void run()
  {
    h.a(this.hil.hih.hhH.getActivity(), this.hil.hih.hhH.getResources().getString(y.j.app_brand_desktop_add_collection_over_limit, new Object[] { Integer.valueOf(e.y(this.hil.hih.hhH)) }), "", this.hil.hih.hhH.getResources().getString(y.j.app_ok), false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.e.d.2.1
 * JD-Core Version:    0.7.0.1
 */