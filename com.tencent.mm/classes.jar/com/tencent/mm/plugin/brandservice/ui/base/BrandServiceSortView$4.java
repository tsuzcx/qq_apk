package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class BrandServiceSortView$4
  implements Runnable
{
  BrandServiceSortView$4(BrandServiceSortView paramBrandServiceSortView, String paramString, Context paramContext, int paramInt) {}
  
  public final void run()
  {
    d locald = z.My().kQ(this.dol);
    ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(this.dol);
    ((com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.r(com.tencent.mm.pluginsdk.g.class)).a(locald, (Activity)this.val$context, localad, false, new BrandServiceSortView.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.4
 * JD-Core Version:    0.7.0.1
 */