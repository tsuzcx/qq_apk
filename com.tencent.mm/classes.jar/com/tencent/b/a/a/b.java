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
  static a dfv;
  Integer dfw;
  String dfx;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(87628);
    this.dfw = null;
    this.dfx = null;
    try
    {
      bp(paramContext);
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null) {
        this.dfw = Integer.valueOf(localTelephonyManager.getNetworkType());
      }
      this.dfx = s.bA(paramContext);
      AppMethodBeat.o(87628);
      return;
    }
    catch (Throwable paramContext)
    {
      s.Ug();
      AppMethodBeat.o(87628);
    }
  }
  
  private static a bp(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87627);
      if (dfv == null) {
        dfv = new a(paramContext.getApplicationContext(), (byte)0);
      }
      paramContext = dfv;
      AppMethodBeat.o(87627);
      return paramContext;
    }
    finally {}
  }
  
  static final class a
  {
    String appVersion;
    Context ctx;
    int dfA;
    String dfB;
    String dfC;
    String dfD;
    String dfE;
    int dfF;
    String dfG;
    String dfH;
    String dfy;
    DisplayMetrics dfz;
    String imsi;
    String language;
    String model;
    String packageName;
    String timezone;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(87626);
      this.dfy = "2.21";
      this.dfA = Build.VERSION.SDK_INT;
      this.model = Build.MODEL;
      this.dfB = Build.MANUFACTURER;
      this.language = Locale.getDefault().getLanguage();
      this.dfC = "WX";
      this.dfF = 0;
      this.packageName = null;
      this.ctx = null;
      this.dfG = null;
      this.dfH = null;
      this.ctx = paramContext.getApplicationContext();
      try
      {
        this.appVersion = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
        this.dfz = new DisplayMetrics();
        ((WindowManager)this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.dfz);
        if (s.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            this.dfD = paramContext.getSimOperator();
            this.imsi = paramContext.getSubscriberId();
          }
        }
        this.timezone = TimeZone.getDefault().getID();
        this.dfE = s.bz(this.ctx);
        this.packageName = this.ctx.getPackageName();
        this.dfH = s.Ui();
        AppMethodBeat.o(87626);
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          s.Ug();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */