package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.ai.d;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;

public abstract interface c
  extends a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bi parambi);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(m paramm, q paramq, int paramInt1, l paraml, View paramView, boolean paramBoolean, int paramInt2, j paramj);
  
  public abstract void a(bi parambi, Activity paramActivity);
  
  public abstract void a(bi parambi, Context paramContext);
  
  public abstract void b(d paramd, Activity paramActivity, ad paramad);
  
  public abstract long cz(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.c
 * JD-Core Version:    0.7.0.1
 */