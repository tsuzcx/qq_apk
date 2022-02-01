package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Locale;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String lIw;
  final String lIx;
  final Intent lIy;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47047);
    this.lIw = paramParcel.readString();
    this.lIx = paramParcel.readString();
    this.lIy = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(47047);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.lIw = paramString2;
    this.lIx = paramString3;
    this.lIy = paramIntent;
  }
  
  final void W(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222738);
    ae.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", new Object[] { paramString, paramContext.getClass().getName(), this.lIx });
    paramString = this.lIy;
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.lIw, this.lIx, paramString);
      AppMethodBeat.o(222738);
      return;
      paramString.setFlags(paramString.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174927);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", new Object[] { this.lIw, this.lIx, this.lIy });
    AppMethodBeat.o(174927);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.lIw);
    paramParcel.writeString(this.lIx);
    paramParcel.writeParcelable(this.lIy, 0);
    AppMethodBeat.o(47048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */