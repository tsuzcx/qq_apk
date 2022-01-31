package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;

final class AppBrandLaunchErrorActionAlert
  extends AppBrandLaunchErrorAction
{
  final String guJ;
  final String guK;
  
  @Keep
  AppBrandLaunchErrorActionAlert(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(131696);
    this.guJ = paramParcel.readString();
    this.guK = paramParcel.readString();
    AppMethodBeat.o(131696);
  }
  
  AppBrandLaunchErrorActionAlert(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramString1, paramInt);
    this.guJ = paramString2;
    this.guK = paramString3;
  }
  
  final void cS(Context paramContext)
  {
    AppMethodBeat.i(131698);
    String str1 = this.guK;
    String str2 = this.guJ;
    if (!(paramContext instanceof Activity))
    {
      a.a(null, str1, str2, ah.getResources().getString(2131297018), "", null, null, null);
      AppMethodBeat.o(131698);
      return;
    }
    h.a(paramContext, str1, str2, false, null);
    AppMethodBeat.o(131698);
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131697);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.guJ);
    paramParcel.writeString(this.guK);
    AppMethodBeat.o(131697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert
 * JD-Core Version:    0.7.0.1
 */