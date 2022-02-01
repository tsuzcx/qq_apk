package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.base.h;
import java.util.Locale;

final class AppBrandLaunchErrorActionAlert
  extends AppBrandLaunchErrorAction
{
  final String hFN;
  final String ihJ;
  
  @Keep
  AppBrandLaunchErrorActionAlert(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47044);
    this.hFN = paramParcel.readString();
    this.ihJ = paramParcel.readString();
    AppMethodBeat.o(47044);
  }
  
  AppBrandLaunchErrorActionAlert(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramString1, paramInt);
    this.hFN = paramString2;
    this.ihJ = paramString3;
  }
  
  final void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195986);
    String str1 = this.ihJ;
    String str2 = this.hFN;
    ad.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) alert title:%s, message:%s", new Object[] { paramString, str2, str1 });
    if (!(paramContext instanceof Activity))
    {
      a.a(null, str1, str2, aj.getResources().getString(2131755835), "", null, null, null);
      AppMethodBeat.o(195986);
      return;
    }
    h.a(paramContext, str1, str2, false, null);
    AppMethodBeat.o(195986);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174926);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionAlert[%s %s]", new Object[] { this.hFN, this.ihJ });
    AppMethodBeat.o(174926);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47045);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hFN);
    paramParcel.writeString(this.ihJ);
    AppMethodBeat.o(47045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert
 * JD-Core Version:    0.7.0.1
 */