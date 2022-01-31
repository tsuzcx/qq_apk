package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.b;

abstract class a
  implements g
{
  public final boolean a(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    if ((bk.bl(paramLaunchParcel.username)) && (bk.bl(paramLaunchParcel.appId))) {
      return false;
    }
    paramLaunchParcel.gMo = bk.UY();
    Object localObject2;
    if (paramContext == null) {
      localObject2 = ae.getContext();
    }
    for (;;)
    {
      return b((Context)localObject2, paramLaunchParcel);
      localObject2 = paramContext;
      if (!(paramContext instanceof Activity)) {
        continue;
      }
      localObject2 = null;
      Object localObject1 = null;
      try
      {
        TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { 16842840 });
        localObject1 = localTypedArray;
        localObject2 = localTypedArray;
        if (!localTypedArray.getBoolean(0, false))
        {
          localObject1 = localTypedArray;
          localObject2 = localTypedArray;
          b.ab((Activity)paramContext);
        }
        localObject2 = paramContext;
        if (localTypedArray == null) {
          continue;
        }
        localTypedArray.recycle();
        localObject2 = paramContext;
      }
      catch (Exception localException)
      {
        localObject2 = localObject1;
        y.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", localException, "convertActivityFromTranslucent %s", new Object[] { paramContext.getClass().getSimpleName() });
        localObject2 = paramContext;
        if (localObject1 == null) {
          continue;
        }
        localObject1.recycle();
        localObject2 = paramContext;
      }
      finally
      {
        if (localObject2 != null) {
          ((TypedArray)localObject2).recycle();
        }
      }
    }
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramString1;
    localLaunchParcel.appId = paramString2;
    if (paramString3 == null) {}
    for (paramString1 = null;; paramString1 = paramString3.trim())
    {
      localLaunchParcel.fPq = paramString1;
      localLaunchParcel.fJy = paramInt1;
      localLaunchParcel.version = paramInt2;
      localLaunchParcel.gMm = paramAppBrandStatObject;
      localLaunchParcel.fPr = paramAppBrandLaunchReferrer;
      localLaunchParcel.gMn = paramLaunchParamsOptional;
      return a(paramContext, localLaunchParcel);
    }
  }
  
  protected abstract boolean b(Context paramContext, LaunchParcel paramLaunchParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.a
 * JD-Core Version:    0.7.0.1
 */