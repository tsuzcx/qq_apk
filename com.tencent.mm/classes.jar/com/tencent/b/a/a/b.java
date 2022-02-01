package com.tencent.b.a.a;

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

final class b
{
  static a cOW;
  Integer cOX;
  String cOY;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(87628);
    this.cOX = null;
    this.cOY = null;
    try
    {
      aV(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.cOX = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.cOY = s.bg(paramContext);
      AppMethodBeat.o(87628);
      return;
    }
    catch (Throwable paramContext)
    {
      s.JT();
      AppMethodBeat.o(87628);
    }
  }
  
  private static a aV(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87627);
      if (cOW == null) {
        cOW = new a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = cOW;
      AppMethodBeat.o(87627);
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String appVersion;
    String cOZ;
    DisplayMetrics cPa;
    int cPb;
    String cPc;
    String cPd;
    String cPe;
    String cPf;
    int cPg;
    String cPh;
    String cPi;
    Context ctx;
    String imsi;
    String language;
    String model;
    String packageName;
    String timezone;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(87626);
      this.cOZ = "2.21";
      this.cPb = Build.VERSION.SDK_INT;
      this.model = Build.MODEL;
      this.cPc = Build.MANUFACTURER;
      this.language = Locale.getDefault().getLanguage();
      this.cPd = "WX";
      this.cPg = 0;
      this.packageName = null;
      this.ctx = null;
      this.cPh = null;
      this.cPi = null;
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.cPa = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cPa);
        if (s.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.cPe = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.cPf = s.bf(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.cPi = s.JV();
        AppMethodBeat.o(87626);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          s.JT();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */