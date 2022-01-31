package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.br.d;

final class AppBrandLaunchErrorActionStartActivity
  extends AppBrandLaunchErrorAction
{
  final String gIW;
  final String gIX;
  final Intent gIY;
  
  @Keep
  AppBrandLaunchErrorActionStartActivity(Parcel paramParcel)
  {
    super(paramParcel);
    this.gIW = paramParcel.readString();
    this.gIX = paramParcel.readString();
    this.gIY = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
  }
  
  AppBrandLaunchErrorActionStartActivity(String paramString1, int paramInt, String paramString2, String paramString3, Intent paramIntent)
  {
    super(paramString1, paramInt);
    this.gIW = paramString2;
    this.gIX = paramString3;
    this.gIY = paramIntent;
  }
  
  final void cr(Context paramContext)
  {
    Intent localIntent = this.gIY;
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      d.b(paramContext, this.gIW, this.gIX, localIntent);
      return;
      localIntent.setFlags(localIntent.getFlags() & 0xEFFFFFFF);
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.gIW);
    paramParcel.writeString(this.gIX);
    paramParcel.writeParcelable(this.gIY, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionStartActivity
 * JD-Core Version:    0.7.0.1
 */