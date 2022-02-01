package com.tencent.mm.plugin.appbrand.launching.e;

import android.content.Context;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface f
{
  public static final f lNC;
  
  static
  {
    if (((com.tencent.mm.kernel.b.h)g.ajz().ajb()).akw()) {}
    for (Object localObject = new h();; localObject = new b())
    {
      lNC = (f)localObject;
      return;
    }
  }
  
  public abstract boolean a(Context paramContext, LaunchParcel paramLaunchParcel);
  
  public abstract boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.f
 * JD-Core Version:    0.7.0.1
 */