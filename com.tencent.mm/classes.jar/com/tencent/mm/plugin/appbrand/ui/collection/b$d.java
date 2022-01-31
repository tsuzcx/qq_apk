package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.appbrand.appusage.f;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import java.util.List;

final class b$d
  implements MenuItem.OnMenuItemClickListener
{
  b$d(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = f.fIe;
    paramMenuItem = f.acM();
    if (paramMenuItem == null) {
      g.cUk();
    }
    c localc = b.a(this.hgt);
    if (localc == null) {
      g.cUk();
    }
    paramMenuItem.a((List)localc.hgv, (f.b)new b.d.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b.d
 * JD-Core Version:    0.7.0.1
 */