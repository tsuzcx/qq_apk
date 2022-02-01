package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public abstract interface b
  extends a
{
  public abstract void RP();
  
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, ca paramca);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(v paramv, z paramz, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2, i parami);
  
  public abstract void a(ca paramca, Activity paramActivity);
  
  public abstract void a(ca paramca, Context paramContext);
  
  public abstract void b(c paramc, Activity paramActivity, as paramas);
  
  public abstract long dN(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.a.b
 * JD-Core Version:    0.7.0.1
 */