package com.tencent.c.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.TimeZone;

final class b$a
{
  String appVersion;
  String axa;
  String bUA;
  String bUB;
  String bUt;
  DisplayMetrics bUu;
  int bUv;
  String bUw;
  String bUx;
  String bUy;
  int bUz;
  String channel;
  Context ctx;
  String imsi;
  String model;
  String packageName;
  String timezone;
  
  private b$a(Context paramContext)
  {
    AppMethodBeat.i(125744);
    this.bUt = "2.21";
    this.bUv = Build.VERSION.SDK_INT;
    this.model = Build.MODEL;
    this.bUw = Build.MANUFACTURER;
    this.axa = Locale.getDefault().getLanguage();
    this.channel = "WX";
    this.bUz = 0;
    this.packageName = null;
    this.ctx = null;
    this.bUA = null;
    this.bUB = null;
    this.ctx = paramContext.getApplicationContext();
    try
    {
      this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
      this.bUu = new DisplayMetrics();
      ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.bUu);
      if (s.q(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          this.bUx = paramContext.getSimOperator();
          this.imsi = paramContext.getSubscriberId();
        }
      }
      this.timezone = TimeZone.getDefault().getID();
      this.bUy = s.aT(this.ctx);
      this.packageName = this.ctx.getPackageName();
      this.bUB = s.zX();
      AppMethodBeat.o(125744);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        s.zV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */