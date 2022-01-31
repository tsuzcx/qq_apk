package com.tencent.mm.plugin.appbrand.menu;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class d$1
  implements n.c
{
  d$1(d paramd, q paramq, String paramString) {}
  
  public final void a(l paraml)
  {
    paraml.fq(1, y.j.app_brand_actionsheet_debug_entrance_silent_restart);
    paraml.fq(2, y.j.app_brand_actionsheet_debug_entrance_nfs_path);
    paraml.e(3, "appID: " + this.gjp.mAppId);
    paraml.e(4, "TRIM PAGE");
    if (bk.bl(this.dGw)) {}
    for (String str = "UNKNOWN PROCESS NAME";; str = this.dGw)
    {
      paraml.e(5, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.1
 * JD-Core Version:    0.7.0.1
 */