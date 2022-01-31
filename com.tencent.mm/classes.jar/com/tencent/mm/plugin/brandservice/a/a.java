package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bi parambi);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt1, p paramp, View paramView, boolean paramBoolean, int paramInt2, i parami);
  
  public abstract void a(bi parambi, Activity paramActivity);
  
  public abstract void a(bi parambi, Context paramContext);
  
  public abstract void b(d paramd, Activity paramActivity, ad paramad);
  
  public abstract long db(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.a
 * JD-Core Version:    0.7.0.1
 */