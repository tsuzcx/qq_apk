package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface p
  extends a
{
  public abstract void a(Context paramContext, f paramf);
  
  public abstract void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4);
  
  @Deprecated
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject, String paramString4);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, p.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.p
 * JD-Core Version:    0.7.0.1
 */