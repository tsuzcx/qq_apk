package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class b$e
  implements MenuItem.OnMenuItemClickListener
{
  b$e(b paramb) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = this.hgt.getActivity();
    if (paramMenuItem != null) {
      paramMenuItem.finish();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b.e
 * JD-Core Version:    0.7.0.1
 */