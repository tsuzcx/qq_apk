package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.h;
import java.util.Locale;

final class AppBrandLaunchErrorActionAlert
  extends AppBrandLaunchErrorAction
{
  final String jxR;
  final String kbW;
  
  @Keep
  AppBrandLaunchErrorActionAlert(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(47044);
    this.jxR = paramParcel.readString();
    this.kbW = paramParcel.readString();
    AppMethodBeat.o(47044);
  }
  
  AppBrandLaunchErrorActionAlert(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    super(paramString1, paramInt);
    this.jxR = paramString2;
    this.kbW = paramString3;
  }
  
  final void ae(Context paramContext, String paramString)
  {
    AppMethodBeat.i(227049);
    String str1 = this.kbW;
    String str2 = this.jxR;
    Log.i("MicroMsg.AppBrandLaunchErrorAction", "showError(%s) alert title:%s, message:%s", new Object[] { paramString, str2, str1 });
    if (!(paramContext instanceof Activity))
    {
      a.a(null, str1, str2, MMApplicationContext.getResources().getString(2131755921), "", null, null, null);
      AppMethodBeat.o(227049);
      return;
    }
    h.a(paramContext, str1, str2, false, null);
    AppMethodBeat.o(227049);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(174926);
    String str = String.format(Locale.ENGLISH, "AppBrandLaunchErrorActionAlert[%s %s]", new Object[] { this.jxR, this.kbW });
    AppMethodBeat.o(174926);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(47045);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jxR);
    paramParcel.writeString(this.kbW);
    AppMethodBeat.o(47045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorActionAlert
 * JD-Core Version:    0.7.0.1
 */