package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Method;

public abstract class a
  implements f
{
  public final boolean a(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    if ((Util.isNullOrNil(paramLaunchParcel.username)) && (Util.isNullOrNil(paramLaunchParcel.appId))) {
      return false;
    }
    paramLaunchParcel.mYM = Util.nowMilliSecond();
    Object localObject2;
    if ((paramContext == null) || (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))) {
      localObject2 = MMApplicationContext.getContext();
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
            com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", localThrowable, "call convertActivityFromTranslucent Fail: %s", new Object[] { localThrowable.getMessage() });
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
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", localException, "convertActivityFromTranslucent %s", new Object[] { paramContext.getClass().getSimpleName() });
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
    if (paramString3 == null)
    {
      paramString1 = null;
      localLaunchParcel.kHw = paramString1;
      if (!j.a.isValid(paramInt1)) {
        break label94;
      }
    }
    for (localLaunchParcel.iOo = paramInt1;; localLaunchParcel.iOo = 0)
    {
      localLaunchParcel.version = paramInt2;
      localLaunchParcel.mYK = paramAppBrandStatObject;
      localLaunchParcel.cys = paramAppBrandLaunchReferrer;
      localLaunchParcel.mYL = paramLaunchParamsOptional;
      return a(paramContext, localLaunchParcel);
      paramString1 = paramString3.trim();
      break;
      label94:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", "start with invalid versionType[%d], use 0 instead, stack=%s", new Object[] { Integer.valueOf(paramInt1), android.util.Log.getStackTraceString(new Throwable()) });
    }
  }
  
  protected abstract boolean b(Context paramContext, LaunchParcel paramLaunchParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a
 * JD-Core Version:    0.7.0.1
 */