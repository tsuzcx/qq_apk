package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.protobuf.dgp;
import java.lang.reflect.Constructor;

public abstract class AppBrandLaunchErrorAction
  implements Parcelable
{
  public static final a CREATOR = new a();
  final String appId;
  final int euz;
  
  AppBrandLaunchErrorAction(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.euz = paramParcel.readInt();
  }
  
  AppBrandLaunchErrorAction(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.euz = paramInt;
  }
  
  public abstract void ad(Context paramContext, String paramString);
  
  public final int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getName());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.euz);
  }
  
  static final class a
    implements Parcelable.Creator<AppBrandLaunchErrorAction>
  {
    static AppBrandLaunchErrorAction a(String paramString, int paramInt, ak paramak)
    {
      Object localObject2 = null;
      AppMethodBeat.i(47042);
      if ((paramak == null) || (paramak.field_launchAction == null))
      {
        AppMethodBeat.o(47042);
        return null;
      }
      Object localObject1 = localObject2;
      switch (paramak.field_launchAction.aamK)
      {
      default: 
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localObject1 != null) {
          AppBrandStickyBannerLogic.b.dl(paramString, paramInt);
        }
        AppMethodBeat.o(47042);
        return localObject1;
        localObject1 = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramak.field_launchAction.aaBg, paramak.field_launchAction.aaLG);
        continue;
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramak.field_launchAction.aaLE);
        ((Intent)localObject1).putExtra("forceHideShare", true);
        localObject1 = new AppBrandLaunchErrorActionStartActivity(paramString, paramInt, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        continue;
        localObject1 = new AppBrandLaunchErrorActionBlockBackgroundLaunch(paramString, paramInt);
      }
    }
    
    private static AppBrandLaunchErrorAction o(Parcel paramParcel)
    {
      AppMethodBeat.i(47041);
      String str = paramParcel.readString();
      if (str == null)
      {
        AppMethodBeat.o(47041);
        return null;
      }
      try
      {
        paramParcel = (AppBrandLaunchErrorAction)Class.forName(str).getDeclaredConstructor(new Class[] { Parcel.class }).newInstance(new Object[] { paramParcel });
        AppMethodBeat.o(47041);
        return paramParcel;
      }
      catch (Exception paramParcel)
      {
        AppMethodBeat.o(47041);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
 * JD-Core Version:    0.7.0.1
 */