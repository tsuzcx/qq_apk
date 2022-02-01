package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import java.util.Locale;

final class AppBrandLaunchErrorActionAlert
  extends AppBrandLaunchErrorAction
{
  final String iCC;
  final String jdT;
  
  @Keep
  AppBrandLaunchErrorActionAlert(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47044);
    this.iCC = paramParcel.readString();
    this.jdT = paramParcel.readString();
    AppMethodBeat.o(47044);
  }
  
  AppBrandLaunchErrorActionAlert(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramString1, paramInt);
    this.iCC = paramString2;
    this.jdT = paramString3;
  }
  
  final void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222737);
    String str1 = this.jdT;
    String str2 = this.iCC;
    ae.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) alert title:%s, message:%s", new Object[] { paramString, str2, str1 });
    if (!(paramContext instanceof Activity))
    {
      a.a(null, str1, str2, ak.getResources().getString(2131755835), "", null, null, null);
      AppMethodBeat.o(222737);
      return;
    }
    h.a(paramContext, str1, str2, false, null);
    AppMethodBeat.o(222737);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174926);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionAlert[%s %s]", new Object[] { this.iCC, this.jdT });
    AppMethodBeat.o(174926);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47045);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.iCC);
    paramParcel.writeString(this.jdT);
    AppMethodBeat.o(47045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert
 * JD-Core Version:    0.7.0.1
 */