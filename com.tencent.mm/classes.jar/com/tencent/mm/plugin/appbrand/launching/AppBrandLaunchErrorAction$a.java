package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.protobuf.azj;
import java.lang.reflect.Constructor;

final class AppBrandLaunchErrorAction$a
  implements Parcelable.Creator<AppBrandLaunchErrorAction>
{
  static AppBrandLaunchErrorAction a(String paramString, int paramInt, ab paramab)
  {
    Intent localIntent = null;
    AppMethodBeat.i(131694);
    if ((paramab == null) || (paramab.field_launchAction == null))
    {
      AppMethodBeat.o(131694);
      return null;
    }
    switch (paramab.field_launchAction.wld)
    {
    default: 
      paramString = localIntent;
    }
    for (;;)
    {
      if (paramString != null) {
        AppBrandStickyBannerLogic.b.aMO();
      }
      AppMethodBeat.o(131694);
      return paramString;
      paramString = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramab.field_launchAction.xhl, paramab.field_launchAction.xoH);
      continue;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramab.field_launchAction.xoF);
      localIntent.putExtra("forceHideShare", true);
      paramString = new AppBrandLaunchErrorActionStartActivity(paramString, paramInt, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
  
  private static AppBrandLaunchErrorAction k(Parcel paramParcel)
  {
    AppMethodBeat.i(131693);
    String str = paramParcel.readString();
    if (str == null)
    {
      AppMethodBeat.o(131693);
      return null;
    }
    try
    {
      paramParcel = (AppBrandLaunchErrorAction)Class.forName(str).getDeclaredConstructor(new Class[] { Parcel.class }).newInstance(new Object[] { paramParcel });
      AppMethodBeat.o(131693);
      return paramParcel;
    }
    catch (Exception paramParcel)
    {
      AppMethodBeat.o(131693);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a
 * JD-Core Version:    0.7.0.1
 */