package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String ijD;
  final String ijE;
  final Intent ijF;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(131699);
    this.ijD = paramParcel.readString();
    this.ijE = paramParcel.readString();
    this.ijF = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
    AppMethodBeat.o(131699);
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.ijD = paramString2;
    this.ijE = paramString3;
    this.ijF = paramIntent;
  }
  
  final void cS(Context paramContext)
  {
    AppMethodBeat.i(131701);
    Intent localIntent = this.ijF;
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.ijD, this.ijE, localIntent);
      AppMethodBeat.o(131701);
      return;
      localIntent.setFlags(localIntent.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131700);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.ijD);
    paramParcel.writeString(this.ijE);
    paramParcel.writeParcelable(this.ijF, 0);
    AppMethodBeat.o(131700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */