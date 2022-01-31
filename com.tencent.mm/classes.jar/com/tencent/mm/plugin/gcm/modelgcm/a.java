package com.tencent.mm.plugin.gcm.modelgcm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class a
  implements com.tencent.mm.ah.f
{
  private static a lhp;
  private Context context;
  private int lhm = 3;
  private int lhn = 0;
  private String lho = "";
  private GoogleCloudMessaging lhq;
  
  private a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static a baB()
  {
    y.i("GcmRegister", "GCM getInstance");
    if (lhp != null) {
      return lhp;
    }
    Object localObject = ae.getContext();
    if (localObject == null)
    {
      y.e("GcmRegister", "GCM appcontext null");
      return null;
    }
    localObject = new a((Context)localObject);
    lhp = (a)localObject;
    return localObject;
  }
  
  private SharedPreferences baG()
  {
    return this.context.getSharedPreferences(a.class.getSimpleName(), 0);
  }
  
  private static int dB(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.e("GcmRegister", "Could not get package name.");
    }
    return 0;
  }
  
  private static boolean dC(Context paramContext)
  {
    try
    {
      if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 8) {
        return false;
      }
      int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
      if (i != 0)
      {
        y.w("GcmRegister", "device not support GCM reason = " + i);
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      y.e("GcmRegister", paramContext.toString());
      return false;
    }
    return true;
  }
  
  private void gD(boolean paramBoolean)
  {
    Object localObject = baG();
    y.i("GcmRegister", "Saving regSvrResult: " + paramBoolean);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("isRegToSvr", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
    if (paramBoolean)
    {
      this.lhn = aa.Uu().eNL.CK();
      return;
    }
    this.lhn = 0;
  }
  
  public final void aq(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = baG();
    int i = dB(paramContext);
    paramContext = localSharedPreferences.getString("registration_id", "");
    y.i("GcmRegister", "Saving regId on app version[%s] regid[%s to %s] same[%b]", new Object[] { Integer.valueOf(i), bk.aac(paramContext), bk.aac(paramString), Boolean.valueOf(paramContext.equals(paramString)) });
    if (bk.bl(paramContext)) {
      com.tencent.mm.plugin.report.f.nEG.a(452L, 37L, 1L, false);
    }
    if (bk.bl(paramString)) {
      com.tencent.mm.plugin.report.f.nEG.a(452L, 38L, 1L, false);
    }
    com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.nEG;
    if (paramContext.equals(paramString)) {}
    for (long l = 39L;; l = 40L)
    {
      localf.a(452L, l, 1L, false);
      paramContext = localSharedPreferences.edit();
      paramContext.putString("registration_id", paramString);
      paramContext.putInt("appVersion", i);
      paramContext.putLong("regtime", bk.UX());
      paramContext.commit();
      return;
    }
  }
  
  public final void baC()
  {
    y.i("GcmRegister", "checkregister");
    aa.Us().postDelayed(new a.1(this), 5000L);
  }
  
  public final void baD()
  {
    String str = baE();
    y.i("GcmRegister", "doRegist old regid[%s]", new Object[] { str });
    if (dC(this.context))
    {
      this.lhq = GoogleCloudMessaging.getInstance(this.context);
      if ((bk.bl(str)) || (baF()))
      {
        y.i("GcmRegister", "doRegist registerInBackground as regid[%s] is null or expired", new Object[] { str });
        new a.a(this).execute(new Void[] { null, null, null });
      }
    }
    do
    {
      return;
      baH();
      return;
      y.i("GcmRegister", "Google Play Services Unavailable.");
      h.nFQ.aC(11250, "2,0");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 0L, 1L, false);
    } while (!baJ());
    baE();
    baI();
  }
  
  @SuppressLint({"NewApi"})
  public final String baE()
  {
    SharedPreferences localSharedPreferences = baG();
    String str = localSharedPreferences.getString("registration_id", "");
    if (str.length() == 0)
    {
      y.i("GcmRegister", "registrationId not found.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 1L, 1L, false);
      return "";
    }
    if (localSharedPreferences.getInt("appVersion", -2147483648) != dB(this.context))
    {
      y.i("GcmRegister", "App version changed.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 2L, 1L, false);
      return "";
    }
    com.tencent.mm.plugin.report.f.nEG.a(452L, 4L, 1L, false);
    return str;
  }
  
  final boolean baF()
  {
    boolean bool = false;
    long l = bk.cn(baG().getLong("regtime", 0L));
    if (l > 259200L)
    {
      y.i("GcmRegister", "gcm regid timeout[%d, %d]", new Object[] { Long.valueOf(l), Integer.valueOf(259200) });
      com.tencent.mm.plugin.report.f.nEG.a(452L, 3L, 1L, false);
      bool = true;
    }
    return bool;
  }
  
  public final void baH()
  {
    com.tencent.mm.plugin.report.f.nEG.a(452L, 11L, 1L, false);
    int i = aa.Uu().eNL.CK();
    String str = baE();
    if (bk.bl(str))
    {
      y.i("GcmRegister", "sendRegistrationIdToBackend regid is empty.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 13L, 1L, false);
      return;
    }
    if ((this.lhn != 0) && (i == this.lhn) && (str.equals(this.lho)))
    {
      y.i("GcmRegister", "uin[%s][%s] already reg to weixin svr", new Object[] { Integer.valueOf(this.lhn), bk.aac(str) });
      com.tencent.mm.plugin.report.f.nEG.a(452L, 12L, 1L, false);
      return;
    }
    this.lho = str;
    y.i("GcmRegister", "regToWeixinServer [%s]", new Object[] { bk.aac(this.lho) });
    try
    {
      new e(str, i).a(aa.Uu(), this);
      com.tencent.mm.plugin.report.f.nEG.a(452L, 14L, 1L, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.plugin.report.f.nEG.a(452L, 15L, 1L, false);
      y.e("GcmRegister", "NetScenePushReg doScene error:" + localThrowable.toString());
    }
  }
  
  public final void baI()
  {
    y.i("GcmRegister", "unregToWeixinServer");
    com.tencent.mm.plugin.report.f.nEG.a(452L, 18L, 1L, false);
    String str = baE();
    if (bk.bl(str))
    {
      y.e("GcmRegister", "unregToWeixinServer regid is empty.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 19L, 1L, false);
      return;
    }
    if (!baJ())
    {
      y.e("GcmRegister", "is not reg to Svr. no need unreg.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 20L, 1L, false);
      return;
    }
    gD(false);
    try
    {
      new f(str, aa.Uu().eNL.CK()).a(aa.Uu(), this);
      com.tencent.mm.plugin.report.f.nEG.a(452L, 21L, 1L, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      y.e("GcmRegister", "NetScenePushUnReg doScene error:" + localThrowable.toString());
      com.tencent.mm.plugin.report.f.nEG.a(452L, 22L, 1L, false);
    }
  }
  
  public final boolean baJ()
  {
    return baG().getBoolean("isRegToSvr", false);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool = false;
    y.i("GcmRegister", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    paramm.edh = true;
    if (paramm == null) {}
    do
    {
      return;
      if ((paramm instanceof e))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          y.i("GcmRegister", "NetScenePushReg success.");
          com.tencent.mm.plugin.report.f.nEG.a(452L, 16L, 1L, false);
          bool = true;
        }
        for (;;)
        {
          gD(bool);
          return;
          y.i("GcmRegister", "NetScenePushReg faild.");
          com.tencent.mm.plugin.report.f.nEG.a(452L, 17L, 1L, false);
        }
      }
    } while (!(paramm instanceof f));
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      y.i("GcmRegister", "NetScenePushUnReg success.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 23L, 1L, false);
    }
    for (;;)
    {
      gD(false);
      return;
      y.e("GcmRegister", "NetScenePushUnReg faild.");
      com.tencent.mm.plugin.report.f.nEG.a(452L, 24L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gcm.modelgcm.a
 * JD-Core Version:    0.7.0.1
 */