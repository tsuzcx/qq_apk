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
  static a cFZ;
  Integer cGa;
  String cGb;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(87628);
    this.cGa = null;
    this.cGb = null;
    try
    {
      aT(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.cGa = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.cGb = s.be(paramContext);
      AppMethodBeat.o(87628);
      return;
    }
    catch (Throwable paramContext)
    {
      s.IC();
      AppMethodBeat.o(87628);
    }
  }
  
  private static a aT(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87627);
      if (cFZ == null) {
        cFZ = new a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = cFZ;
      AppMethodBeat.o(87627);
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String aSt;
    String appVersion;
    String cGc;
    DisplayMetrics cGd;
    int cGe;
    String cGf;
    String cGg;
    String cGh;
    String cGi;
    int cGj;
    String cGk;
    String cGl;
    Context ctx;
    String imsi;
    String model;
    String packageName;
    String timezone;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(87626);
      this.cGc = "2.21";
      this.cGe = Build.VERSION.SDK_INT;
      this.model = Build.MODEL;
      this.cGf = Build.MANUFACTURER;
      this.aSt = Locale.getDefault().getLanguage();
      this.cGg = "WX";
      this.cGj = 0;
      this.packageName = null;
      this.ctx = null;
      this.cGk = null;
      this.cGl = null;
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.cGd = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cGd);
        if (s.p(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.cGh = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.cGi = s.bd(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.cGl = s.IE();
        AppMethodBeat.o(87626);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          s.IC();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */