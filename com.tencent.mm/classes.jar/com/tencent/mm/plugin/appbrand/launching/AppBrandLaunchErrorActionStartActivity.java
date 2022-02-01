package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Locale;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String kFG;
  final String kFH;
  final Intent kFI;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47047);
    this.kFG = paramParcel.readString();
    this.kFH = paramParcel.readString();
    this.kFI = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(47047);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.kFG = paramString2;
    this.kFH = paramString3;
    this.kFI = paramIntent;
  }
  
  final void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195987);
    ad.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", new Object[] { paramString, paramContext.getClass().getName(), this.kFH });
    paramString = this.kFI;
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.kFG, this.kFH, paramString);
      AppMethodBeat.o(195987);
      return;
      paramString.setFlags(paramString.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174927);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", new Object[] { this.kFG, this.kFH, this.kFI });
    AppMethodBeat.o(174927);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.kFG);
    paramParcel.writeString(this.kFH);
    paramParcel.writeParcelable(this.kFI, 0);
    AppMethodBeat.o(47048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */