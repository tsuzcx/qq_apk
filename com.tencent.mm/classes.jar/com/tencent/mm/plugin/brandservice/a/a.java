package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.s;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bl parambl);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(v paramv, s params, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2, k paramk);
  
  public abstract void a(bl parambl, Activity paramActivity);
  
  public abstract void a(bl parambl, Context paramContext);
  
  public abstract void b(c paramc, Activity paramActivity, af paramaf);
  
  public abstract long dv(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.a
 * JD-Core Version:    0.7.0.1
 */