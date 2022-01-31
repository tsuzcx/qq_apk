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
import java.util.Locale;
import java.util.TimeZone;

final class b$a
{
  String auI = Locale.getDefault().getLanguage();
  String bth;
  String bti = "2.21";
  DisplayMetrics btj;
  int btk = Build.VERSION.SDK_INT;
  String btl = Build.MANUFACTURER;
  String btm;
  String bto;
  int btp = 0;
  String btq = null;
  String btr = null;
  String channel = "WX";
  Context ctx = null;
  String imsi;
  String model = Build.MODEL;
  String packageName = null;
  String timezone;
  
  private b$a(Context paramContext)
  {
    this.ctx = paramContext.getApplicationContext();
    try
    {
      this.bth = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
      label105:
      this.btj = new DisplayMetrics();
      ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.btj);
      if (s.l(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          this.btm = paramContext.getSimOperator();
          this.imsi = paramContext.getSubscriberId();
        }
      }
      this.timezone = TimeZone.getDefault().getID();
      this.bto = s.av(this.ctx);
      this.packageName = this.ctx.getPackageName();
      this.btr = s.rF();
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label105;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.c.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */