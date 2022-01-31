package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface g
{
  public static final g gMF;
  
  static
  {
    if (((h)com.tencent.mm.kernel.g.DM().Dr()).Ex()) {}
    for (Object localObject = new i();; localObject = new c())
    {
      gMF = (g)localObject;
      return;
    }
  }
  
  public abstract boolean a(Context paramContext, LaunchParcel paramLaunchParcel);
  
  public abstract boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.g
 * JD-Core Version:    0.7.0.1
 */