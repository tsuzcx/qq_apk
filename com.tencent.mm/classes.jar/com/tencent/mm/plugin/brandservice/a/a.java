package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.j;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.w;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bv parambv);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(v paramv, w paramw, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2, j paramj);
  
  public abstract void a(bv parambv, Activity paramActivity);
  
  public abstract void a(bv parambv, Context paramContext);
  
  public abstract void b(c paramc, Activity paramActivity, an paraman);
  
  public abstract void bgT();
  
  public abstract long dz(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.a
 * JD-Core Version:    0.7.0.1
 */