package com.tencent.mm.model.d;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.lang.reflect.Method;

public final class b$1
  implements Runnable
{
  public b$1(b paramb) {}
  
  public final void run()
  {
    File localFile = new File(b.access$000() + "MMSQL.trace");
    if (!localFile.exists())
    {
      y.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
      return;
    }
    if (!g.DN().Dc())
    {
      y.w("MicroMsg.SQLTraceManager", "acc not ready ");
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b.bp(ae.getContext());
    boolean bool2 = false;
    boolean bool1;
    if (l2 > l1) {
      bool1 = true;
    }
    for (;;)
    {
      l1 = localFile.length();
      y.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1) });
      if ((!bool1) || (l1 <= b.c(this.dZD))) {
        break;
      }
      Object localObject = this.dZD;
      Context localContext = ae.getContext();
      String str = ae.getContext().getPackageName();
      try
      {
        PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(localContext.getPackageManager(), new Object[] { str, new b.2((b)localObject) });
        if ((b.d(this.dZD)[1] != 0L) || (b.e(this.dZD) > 1L))
        {
          y.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", new Object[] { Long.valueOf(localFile.length()) });
          if (localFile.length() > b.f(this.dZD))
          {
            y.e("MicroMsg.SQLTraceManager", "log file invaild format");
            y.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            b.a(this.dZD, localFile);
            b.g(this.dZD);
            b.h(this.dZD);
            b.c(ae.getContext(), System.currentTimeMillis());
            return;
            if (l1 - l2 > 86400000L)
            {
              bool1 = true;
              continue;
            }
            bool1 = bool2;
            if (l1 - l2 <= b.a(this.dZD)) {
              continue;
            }
            bool1 = bool2;
            if (!b.b(this.dZD)) {
              continue;
            }
            bool1 = true;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ((b)localObject).bwO[0] = -1L;
          ((b)localObject).bwO[1] = -1L;
          ((b)localObject).bwO[2] = -1L;
          continue;
          localObject = b.jp(b.access$000() + "MMSQL.trace");
          y.i("MicroMsg.SQLTraceManager", "read content success");
          this.dZD.jo((String)localObject);
        }
        y.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
        b.i(this.dZD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.b.1
 * JD-Core Version:    0.7.0.1
 */