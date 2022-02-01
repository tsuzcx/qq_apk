package com.tencent.mm.plugin.brandservice.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;

public abstract interface b
  extends a
{
  public abstract void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, cc paramcc);
  
  public abstract void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt);
  
  public abstract void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void a(v paramv, ab paramab, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2, i parami);
  
  public abstract void a(cc paramcc, Activity paramActivity);
  
  public abstract void a(cc paramcc, Context paramContext);
  
  public abstract void ase();
  
  public abstract void b(c paramc, Activity paramActivity, au paramau);
  
  public abstract int dav();
  
  public abstract long eA(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.api.b
 * JD-Core Version:    0.7.0.1
 */