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
  static a cOm;
  Integer cOn;
  String cOo;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(87628);
    this.cOn = null;
    this.cOo = null;
    try
    {
      aU(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.cOn = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.cOo = s.bf(paramContext);
      AppMethodBeat.o(87628);
      return;
    }
    catch (Throwable paramContext)
    {
      s.JL();
      AppMethodBeat.o(87628);
    }
  }
  
  private static a aU(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87627);
      if (cOm == null) {
        cOm = new a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = cOm;
      AppMethodBeat.o(87627);
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String appVersion;
    String cOp;
    DisplayMetrics cOq;
    int cOr;
    String cOs;
    String cOt;
    String cOu;
    String cOv;
    int cOw;
    String cOx;
    String cOy;
    Context ctx;
    String imsi;
    String language;
    String model;
    String packageName;
    String timezone;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(87626);
      this.cOp = "2.21";
      this.cOr = Build.VERSION.SDK_INT;
      this.model = Build.MODEL;
      this.cOs = Build.MANUFACTURER;
      this.language = Locale.getDefault().getLanguage();
      this.cOt = "WX";
      this.cOw = 0;
      this.packageName = null;
      this.ctx = null;
      this.cOx = null;
      this.cOy = null;
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.cOq = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cOq);
        if (s.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.cOu = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.cOv = s.be(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.cOy = s.JN();
        AppMethodBeat.o(87626);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          s.JL();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */