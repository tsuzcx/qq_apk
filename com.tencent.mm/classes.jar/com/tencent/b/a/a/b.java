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
  static a cDh;
  Integer cDi;
  String cDj;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(87628);
    this.cDi = null;
    this.cDj = null;
    try
    {
      aU(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.cDi = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.cDj = s.bf(paramContext);
      AppMethodBeat.o(87628);
      return;
    }
    catch (Throwable paramContext)
    {
      s.Il();
      AppMethodBeat.o(87628);
    }
  }
  
  private static a aU(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87627);
      if (cDh == null) {
        cDh = new a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = cDh;
      AppMethodBeat.o(87627);
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String aTm;
    String appVersion;
    String cDk;
    DisplayMetrics cDl;
    int cDm;
    String cDn;
    String cDo;
    String cDp;
    String cDq;
    int cDr;
    String cDs;
    String cDt;
    Context ctx;
    String imsi;
    String model;
    String packageName;
    String timezone;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(87626);
      this.cDk = "2.21";
      this.cDm = Build.VERSION.SDK_INT;
      this.model = Build.MODEL;
      this.cDn = Build.MANUFACTURER;
      this.aTm = Locale.getDefault().getLanguage();
      this.cDo = "WX";
      this.cDr = 0;
      this.packageName = null;
      this.ctx = null;
      this.cDs = null;
      this.cDt = null;
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.cDl = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.cDl);
        if (s.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.cDp = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.cDq = s.be(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.cDt = s.In();
        AppMethodBeat.o(87626);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          s.Il();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */