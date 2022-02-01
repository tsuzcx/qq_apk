package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@e(c.class)
public abstract interface r
  extends a
{
  public abstract void a(Context paramContext, g paramg);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4);
  
  @Deprecated
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject, String paramString4);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, r.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle);
  
  public abstract void a(i parami);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle);
  
  public abstract void b(g paramg, f paramf);
  
  public abstract boolean bW(String paramString, int paramInt);
  
  public abstract void ej(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.r
 * JD-Core Version:    0.7.0.1
 */