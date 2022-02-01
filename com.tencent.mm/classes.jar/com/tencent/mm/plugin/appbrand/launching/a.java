package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Method;

public abstract class a
  implements f
{
  public final boolean a(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    if ((bt.isNullOrNil(paramLaunchParcel.username)) && (bt.isNullOrNil(paramLaunchParcel.appId))) {
      return false;
    }
    paramLaunchParcel.kOj = bt.eGO();
    Object localObject2;
    if ((paramContext == null) || (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))) {
      localObject2 = aj.getContext();
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
        localTypedArray = paramContext.obtainStyledAttributes(new int[] { 16842840 });
        localObject1 = localTypedArray;
        localObject2 = localTypedArray;
        Activity localActivity;
        if (!localTypedArray.getBoolean(0, false))
        {
          localObject1 = localTypedArray;
          localObject2 = localTypedArray;
          localActivity = (Activity)paramContext;
          localObject1 = localTypedArray;
          localObject2 = localTypedArray;
        }
        try
        {
          Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
          localObject1 = localTypedArray;
          localObject2 = localTypedArray;
          localMethod.setAccessible(true);
          localObject1 = localTypedArray;
          localObject2 = localTypedArray;
          localMethod.invoke(localActivity, new Object[0]);
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localObject1 = localTypedArray;
            localObject2 = localTypedArray;
            ad.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", localThrowable, "call convertActivityFromTranslucent Fail: %s", new Object[] { localThrowable.getMessage() });
          }
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
        TypedArray localTypedArray;
        localObject2 = localObject1;
        ad.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", localException, "convertActivityFromTranslucent %s", new Object[] { paramContext.getClass().getSimpleName() });
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
      localLaunchParcel.iJb = paramString1;
      localLaunchParcel.gXn = paramInt1;
      localLaunchParcel.version = paramInt2;
      localLaunchParcel.kOh = paramAppBrandStatObject;
      localLaunchParcel.cfi = paramAppBrandLaunchReferrer;
      localLaunchParcel.kOi = paramLaunchParamsOptional;
      return a(paramContext, localLaunchParcel);
    }
  }
  
  protected abstract boolean b(Context paramContext, LaunchParcel paramLaunchParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a
 * JD-Core Version:    0.7.0.1
 */