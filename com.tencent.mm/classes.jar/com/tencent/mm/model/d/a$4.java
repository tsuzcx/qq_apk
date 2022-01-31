package com.tencent.mm.model.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.reflect.Method;

public final class a$4
  implements Runnable
{
  public a$4(a parama) {}
  
  public final void run()
  {
    File localFile = new File(a.Je());
    if (!localFile.exists())
    {
      y.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
      return;
    }
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
      return;
    }
    long l1 = a.k(this.dZq).getLong("handler_report_lastUploadTime", 0L);
    long l2 = System.currentTimeMillis();
    int i;
    if ((l2 - l1 > a.l(this.dZq)) || (l1 > l2)) {
      i = 1;
    }
    while ((a.i(this.dZq)) && (i != 0))
    {
      y.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", new Object[] { Long.valueOf(localFile.length()), Boolean.valueOf(true) });
      Object localObject = this.dZq;
      Context localContext = ae.getContext();
      String str2 = ae.getContext().getPackageName();
      try
      {
        PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(localContext.getPackageManager(), new Object[] { str2, new a.5((a)localObject) });
        if ((a.m(this.dZq)[1] != 0L) || (a.n(this.dZq) > 1L)) {
          if (localFile.length() > a.o(this.dZq))
          {
            y.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
            a.a(this.dZq, localFile);
            a.p(this.dZq);
            a.q(this.dZq);
            a.k(this.dZq).edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
            return;
            i = 0;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ((a)localObject).bwO[0] = -1L;
          ((a)localObject).bwO[1] = -1L;
          ((a)localObject).bwO[2] = -1L;
          continue;
          str2 = a.jn(a.Je());
          a locala = this.dZq;
          Intent localIntent = new Intent();
          localIntent.setClassName(ae.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
          localIntent.setAction("uncatch_exception");
          localIntent.putExtra("exceptionPid", Process.myPid());
          String str1 = at.dVC.L("login_weixin_username", "");
          localObject = str1;
          if (bk.bl(str1)) {
            localObject = at.dVC.L("login_user_name", "never_login_crash");
          }
          localIntent.putExtra("userName", (String)localObject);
          localIntent.putExtra("tag", "handler");
          localIntent.putExtra("exceptionMsg", Base64.encodeToString((locala.Jb() + str2).getBytes(), 2));
          ae.getContext().startService(localIntent);
        }
        a.r(this.dZq);
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|checkAndUpload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.d.a.4
 * JD-Core Version:    0.7.0.1
 */