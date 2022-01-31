package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface j
  extends a
{
  public abstract void a(Context paramContext, String paramString1, int paramInt, String paramString2, AppBrandStatObject paramAppBrandStatObject, String paramString3, String paramString4);
  
  @Deprecated
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, AppBrandStatObject paramAppBrandStatObject, String paramString4);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, j.b paramb);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, j.b paramb, Bundle paramBundle);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.j
 * JD-Core Version:    0.7.0.1
 */