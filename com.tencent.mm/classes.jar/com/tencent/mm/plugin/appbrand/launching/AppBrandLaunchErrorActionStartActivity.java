package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Locale;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String mQk;
  final String mQl;
  final Intent mQm;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47047);
    this.mQk = paramParcel.readString();
    this.mQl = paramParcel.readString();
    this.mQm = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(47047);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.mQk = paramString2;
    this.mQl = paramString3;
    this.mQm = paramIntent;
  }
  
  final void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227050);
    Log.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", new Object[] { paramString, paramContext.getClass().getName(), this.mQl });
    paramString = this.mQm;
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    for (;;)
    {
      c.b(paramContext, this.mQk, this.mQl, paramString);
      AppMethodBeat.o(227050);
      return;
      paramString.setFlags(paramString.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174927);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", new Object[] { this.mQk, this.mQl, this.mQm });
    AppMethodBeat.o(174927);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mQk);
    paramParcel.writeString(this.mQl);
    paramParcel.writeParcelable(this.mQm, 0);
    AppMethodBeat.o(47048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */