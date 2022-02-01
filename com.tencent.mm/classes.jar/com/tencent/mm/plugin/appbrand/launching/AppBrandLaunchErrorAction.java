package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.protobuf.btc;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Constructor;

public abstract class AppBrandLaunchErrorAction
  implements Parcelable
{
  public static final a CREATOR = new a();
  final String appId;
  final int hQh;
  
  AppBrandLaunchErrorAction(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.hQh = paramParcel.readInt();
  }
  
  AppBrandLaunchErrorAction(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.hQh = paramInt;
  }
  
  public abstract void U(Context paramContext, String paramString);
  
  public final int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getName());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hQh);
  }
  
  static final class a
    implements Parcelable.Creator<AppBrandLaunchErrorAction>
  {
    static AppBrandLaunchErrorAction a(String paramString, int paramInt, ax paramax)
    {
      Intent localIntent = null;
      AppMethodBeat.i(47042);
      if ((paramax == null) || (paramax.field_launchAction == null))
      {
        AppMethodBeat.o(47042);
        return null;
      }
      switch (paramax.field_launchAction.FqN)
      {
      default: 
        paramString = localIntent;
      }
      for (;;)
      {
        if (paramString != null) {
          AppBrandStickyBannerLogic.b.bAe();
        }
        AppMethodBeat.o(47042);
        return paramString;
        paramString = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramax.field_launchAction.GFh, paramax.field_launchAction.GNu);
        continue;
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramax.field_launchAction.GNs);
        localIntent.putExtra("forceHideShare", true);
        paramString = new AppBrandLaunchErrorActionStartActivity(paramString, paramInt, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    
    private static AppBrandLaunchErrorAction k(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
 * JD-Core Version:    0.7.0.1
 */