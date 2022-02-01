package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Constructor;

public abstract class AppBrandLaunchErrorAction
  implements Parcelable
{
  public static final a CREATOR = new a();
  final String appId;
  final int iOo;
  
  AppBrandLaunchErrorAction(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.iOo = paramParcel.readInt();
  }
  
  AppBrandLaunchErrorAction(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.iOo = paramInt;
  }
  
  public abstract void ae(Context paramContext, String paramString);
  
  public final int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(getClass().getName());
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iOo);
  }
  
  static final class a
    implements Parcelable.Creator<AppBrandLaunchErrorAction>
  {
    static AppBrandLaunchErrorAction a(String paramString, int paramInt, ap paramap)
    {
      Intent localIntent = null;
      AppMethodBeat.i(47042);
      if ((paramap == null) || (paramap.field_launchAction == null))
      {
        AppMethodBeat.o(47042);
        return null;
      }
      switch (paramap.field_launchAction.KCD)
      {
      default: 
        paramap = localIntent;
      }
      for (;;)
      {
        if (paramap != null) {
          AppBrandStickyBannerLogic.b.cr(paramString, paramInt);
        }
        AppMethodBeat.o(47042);
        return paramap;
        paramap = new AppBrandLaunchErrorActionAlert(paramString, paramInt, paramap.field_launchAction.Mdz, paramap.field_launchAction.Mmh);
        continue;
        localIntent = new Intent();
        localIntent.putExtra("rawUrl", paramap.field_launchAction.Mmf);
        localIntent.putExtra("forceHideShare", true);
        paramap = new AppBrandLaunchErrorActionStartActivity(paramString, paramInt, "webview", ".ui.tools.WebViewUI", localIntent);
      }
    }
    
    private static AppBrandLaunchErrorAction l(Parcel paramParcel)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction
 * JD-Core Version:    0.7.0.1
 */