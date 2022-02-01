package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Locale;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String lgZ;
  final String lha;
  final Intent lhb;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47047);
    this.lgZ = paramParcel.readString();
    this.lha = paramParcel.readString();
    this.lhb = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(47047);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.lgZ = paramString2;
    this.lha = paramString3;
    this.lhb = paramIntent;
  }
  
  final void V(Context paramContext, String paramString)
  {
    AppMethodBeat.i(186809);
    ac.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) startActivity %s -> %s", new Object[] { paramString, paramContext.getClass().getName(), this.lha });
    paramString = this.lhb;
    if (!(paramContext instanceof Activity)) {
      paramString.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.lgZ, this.lha, paramString);
      AppMethodBeat.o(186809);
      return;
      paramString.setFlags(paramString.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174927);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionStartActivity[%s.%s|%s]", new Object[] { this.lgZ, this.lha, this.lhb });
    AppMethodBeat.o(174927);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47048);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.lgZ);
    paramParcel.writeString(this.lha);
    paramParcel.writeParcelable(this.lhb, 0);
    AppMethodBeat.o(47048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */