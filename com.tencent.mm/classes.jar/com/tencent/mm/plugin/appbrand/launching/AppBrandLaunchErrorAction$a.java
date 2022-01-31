package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.c.atg;
import java.lang.reflect.Constructor;

final class AppBrandLaunchErrorAction$a
  implements Parcelable.Creator<AppBrandLaunchErrorAction>
{
  static AppBrandLaunchErrorAction a(String paramString, int paramInt, t paramt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramt != null)
    {
      if (paramt.field_launchAction == null) {
        localObject1 = localObject2;
      }
    }
    else {
      return localObject1;
    }
    switch (paramt.field_launchAction.ssy)
    {
    default: 
      paramString = localObject3;
    }
    for (;;)
    {
      localObject1 = paramString;
      if (paramString == null) {
        break;
      }
      AppBrandStickyBannerLogic.b.apy();
      return paramString;
      paramString = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramt.field_launchAction.tiz, paramt.field_launchAction.toN);
      continue;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("rawUrl", paramt.field_launchAction.toL);
      ((Intent)localObject1).putExtra("forceHideShare", true);
      paramString = new AppBrandLaunchErrorActionStartActivity(paramString, paramInt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
    }
  }
  
  private static AppBrandLaunchErrorAction i(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    if (str == null) {
      return null;
    }
    try
    {
      paramParcel = (AppBrandLaunchErrorAction)Class.forName(str).getDeclaredConstructor(new Class[] { Parcel.class }).newInstance(new Object[] { paramParcel });
      return paramParcel;
    }
    catch (Exception paramParcel) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a
 * JD-Core Version:    0.7.0.1
 */