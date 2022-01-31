package c.t.m.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;

final class dg$2
  implements Runnable
{
  dg$2(dg paramdg) {}
  
  public final void run()
  {
    dg localdg = this.a;
    for (;;)
    {
      try
      {
        j.a("AppContext", 4, "doInBg: app status init start");
        localdh = localdg.b;
        localPackageInfo = localdg.f();
        int i = localPackageInfo.versionCode;
        localdh.i = localPackageInfo.versionName;
        localObject1 = localdg.a.getApplicationInfo().loadLabel(localdg.d);
        if (localObject1 != null)
        {
          localObject1 = ((CharSequence)localObject1).toString();
          localdh.j = ((String)localObject1);
        }
      }
      catch (Throwable localThrowable2)
      {
        dh localdh;
        PackageInfo localPackageInfo;
        Object localObject1;
        Object localObject2;
        boolean bool1;
        boolean bool2;
        boolean bool3;
        j.a("AppContext", "doInBg: app status init error", localThrowable2);
        continue;
      }
      try
      {
        localObject2 = localdg.e;
        if (localObject2 != null)
        {
          localdh.a = ((TelephonyManager)localObject2).getPhoneType();
          localdg.i = er.a(((TelephonyManager)localObject2).getDeviceId(), er.a).toUpperCase(Locale.ENGLISH);
          localObject1 = er.a(((TelephonyManager)localObject2).getSubscriberId(), er.b);
          localObject2 = er.a(((TelephonyManager)localObject2).getLine1Number(), er.c);
          localdh.b = localdg.i;
          localdh.c = ((String)localObject1);
          localdh.d = ((String)localObject2);
        }
      }
      catch (Throwable localThrowable1)
      {
        j.a("AppContext", "", localThrowable1);
        continue;
      }
      localdh.e = er.a(localdg.g().replaceAll(":", "").toUpperCase(Locale.ENGLISH), er.d);
      localObject1 = localdg.d;
      bool1 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.location.gps");
      bool2 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.wifi");
      bool3 = ((PackageManager)localObject1).hasSystemFeature("android.hardware.telephony");
      j.a("AppContext", 4, "doInBg: hasGps=" + bool1 + ",hasWifi=" + bool2 + ",hasCell=" + bool3);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("os:").append(Build.MODEL).append(" ").append(Build.VERSION.RELEASE).append(" ").append(localdh.a()).append("  app:").append(localPackageInfo.versionCode).append(" ").append(localPackageInfo.versionName).append(" sdk: ").append(localdh.d()).append(" ").append(localdh.e());
      j.a("AppContext", 4, ((StringBuilder)localObject1).toString());
      j.a("AppContext", 4, "doInBg: app status init done");
      dg.a(this.a).countDown();
      return;
      localObject1 = "unknown";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.dg.2
 * JD-Core Version:    0.7.0.1
 */