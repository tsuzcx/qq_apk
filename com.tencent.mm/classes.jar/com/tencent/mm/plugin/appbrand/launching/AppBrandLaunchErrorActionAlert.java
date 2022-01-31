package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert
  extends AppBrandLaunchErrorAction
{
  final String fcY;
  final String fcZ;
  
  @Keep
  AppBrandLaunchErrorActionAlert(Parcel paramParcel)
  {
    super(paramParcel);
    this.fcY = paramParcel.readString();
    this.fcZ = paramParcel.readString();
  }
  
  AppBrandLaunchErrorActionAlert(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramString1, paramInt);
    this.fcY = paramString2;
    this.fcZ = paramString3;
  }
  
  final void cr(Context paramContext)
  {
    String str1 = this.fcZ;
    String str2 = this.fcY;
    if (!(paramContext instanceof Activity))
    {
      a.a(null, str1, str2, ae.getResources().getString(y.j.app_ok), "", null, null, null);
      return;
    }
    h.a(paramContext, str1, str2, false, null);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fcY);
    paramParcel.writeString(this.fcZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert
 * JD-Core Version:    0.7.0.1
 */