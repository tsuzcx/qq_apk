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
  final String lDX;
  final String lDY;
  final Intent lDZ;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47047);
    this.lDX = paramParcel.readString();
    this.lDY = paramParcel.readString();
    this.lDZ = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(47047);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.lDX = paramString2;
    this.lDY = paramString3;
    this.lDZ = paramIntent;
  }
  
  final void U(Context paramContext, String paramString)
  {
    AppMethodBeat.i(188579);
    ad.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", new Object[] { paramString, paramContext.getClass().getName(), this.lDY });
    paramString = this.lDZ;
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.lDX, this.lDY, paramString);
      AppMethodBeat.o(188579);
      return;
      paramString.setFlags(paramString.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174927);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", new Object[] { this.lDX, this.lDY, this.lDZ });
    AppMethodBeat.o(174927);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.lDX);
    paramParcel.writeString(this.lDY);
    paramParcel.writeParcelable(this.lDZ, 0);
    AppMethodBeat.o(47048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */