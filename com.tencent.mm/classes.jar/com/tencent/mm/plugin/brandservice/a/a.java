package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.api.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.k;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.t;

public abstract interface a
  extends com.tencent.mm.kernel.c.a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bo parambo);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(v paramv, t paramt, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2, k paramk);
  
  public abstract void a(bo parambo, Activity paramActivity);
  
  public abstract void a(bo parambo, Context paramContext);
  
  public abstract void b(c paramc, Activity paramActivity, ai paramai);
  
  public abstract long dx(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.a
 * JD-Core Version:    0.7.0.1
 */