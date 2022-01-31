package com.tencent.mm.plugin.brandservice.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.n.d;

final class BrandServiceSortView$3
  implements n.d
{
  BrandServiceSortView$3(BrandServiceSortView paramBrandServiceSortView) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (bk.bl(BrandServiceSortView.d(this.iex))) {
      y.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
    }
    while (paramMenuItem.getItemId() != 0) {
      return;
    }
    y.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[] { Integer.valueOf(paramInt) });
    ad localad = ((j)g.r(j.class)).Fw().abl(BrandServiceSortView.d(this.iex));
    d locald = f.kX(BrandServiceSortView.d(this.iex));
    BrandServiceSortView.a(this.iex, locald, this.iex.getContext(), localad, paramMenuItem.getGroupId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.3
 * JD-Core Version:    0.7.0.1
 */