package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Constructor;

public abstract class AppBrandLaunchErrorAction
  implements Parcelable
{
  public static final a CREATOR = new a();
  final String appId;
  final int hxM;
  
  AppBrandLaunchErrorAction(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.hxM = paramParcel.readInt();
  }
  
  AppBrandLaunchErrorAction(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.hxM = paramInt;
  }
  
  public abstract void V(Context paramContext, String paramString);
  
  public final int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getName());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hxM);
  }
  
  static final class a
    implements Parcelable.Creator<AppBrandLaunchErrorAction>
  {
    static AppBrandLaunchErrorAction a(String paramString, int paramInt, au paramau)
    {
      Intent localIntent = null;
      AppMethodBeat.i(47042);
      if ((paramau == null) || (paramau.field_launchAction == null))
      {
        AppMethodBeat.o(47042);
        return null;
      }
      switch (paramau.field_launchAction.DLI)
      {
      default: 
        paramString = localIntent;
      }
      for (;;)
      {
        if (paramString != null) {
          AppBrandStickyBannerLogic.b.bvY();
        }
        AppMethodBeat.o(47042);
        return paramString;
        paramString = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramau.field_launchAction.EVJ, paramau.field_launchAction.FdQ);
        continue;
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramau.field_launchAction.FdO);
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