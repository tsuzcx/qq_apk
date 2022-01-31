package com.tencent.mm.model.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.lang.reflect.Method;

public final class a$4
  implements Runnable
{
  public a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(16376);
    File localFile = new File(a.acb());
    if (!localFile.exists())
    {
      ab.w("MicroMsg.HandlerTraceManager", "summer handler trace file is not exists");
      AppMethodBeat.o(16376);
      return;
    }
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.HandlerTraceManager", "summer acc not ready ");
      AppMethodBeat.o(16376);
      return;
    }
    long l1 = a.l(this.fpv).getLong("handler_report_lastUploadTime", 0L);
    long l2 = System.currentTimeMillis();
    int i;
    if ((l2 - l1 > a.m(this.fpv)) || (l1 > l2)) {
      i = 1;
    }
    while ((a.j(this.fpv)) && (i != 0))
    {
      ab.i("MicroMsg.HandlerTraceManager", "summer check need upload ,file size is %d,time out %b", new Object[] { Long.valueOf(localFile.length()), Boolean.TRUE });
      Object localObject = this.fpv;
      Context localContext = ah.getContext();
      String str2 = ah.getContext().getPackageName();
      try
      {
        PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(localContext.getPackageManager(), new Object[] { str2, new a.5((a)localObject) });
        if ((a.n(this.fpv)[1] != 0L) || (a.o(this.fpv) > 1L)) {
          if (localFile.length() > a.p(this.fpv))
          {
            ab.e("MicroMsg.HandlerTraceManager", "summer log file invaild format");
            a.a(this.fpv, localFile);
            a.q(this.fpv);
            a.r(this.fpv);
            a.l(this.fpv).edit().putLong("handler_report_lastUploadTime", System.currentTimeMillis()).commit();
            AppMethodBeat.o(16376);
            return;
            i = 0;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ((a)localObject).bYy[0] = -1L;
          ((a)localObject).bYy[1] = -1L;
          ((a)localObject).bYy[2] = -1L;
          continue;
          str2 = a.qb(a.acb());
          a locala = this.fpv;
          Intent localIntent = new Intent();
          localIntent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorBroadcastReceiver");
          localIntent.setAction("uncatch_exception");
          localIntent.putExtra("exceptionPid", Process.myPid());
          String str1 = av.flM.Y("login_weixin_username", "");
          localObject = str1;
          if (bo.isNullOrNil(str1)) {
            localObject = av.flM.Y("login_user_name", "never_login_crash");
          }
          localIntent.putExtra("userName", (String)localObject);
          localIntent.putExtra("tag", "handler");
          localIntent.putExtra("exceptionMsg", Base64.encodeToString((locala.abY() + str2).getBytes(), 2));
          ah.getContext().sendBroadcast(localIntent);
        }
        a.s(this.fpv);
      }
    }
    AppMethodBeat.o(16376);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(16377);
    String str = super.toString() + "|checkAndUpload";
    AppMethodBeat.o(16377);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a.4
 * JD-Core Version:    0.7.0.1
 */