package com.tencent.mm.model.d;

import android.content.Context;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.File;
import java.lang.reflect.Method;

public final class b$1
  implements Runnable
{
  public b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(16391);
    File localFile = new File(b.access$000() + "MMSQL.trace");
    if (!localFile.exists())
    {
      ab.w("MicroMsg.SQLTraceManager", "SqlTrace file is not  exists");
      AppMethodBeat.o(16391);
      return;
    }
    if (!g.RJ().QU())
    {
      ab.w("MicroMsg.SQLTraceManager", "acc not ready ");
      AppMethodBeat.o(16391);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = b.bT(ah.getContext());
    boolean bool2 = false;
    boolean bool1;
    if (l2 > l1) {
      bool1 = true;
    }
    for (;;)
    {
      l1 = localFile.length();
      ab.i("MicroMsg.SQLTraceManager", "check need upload ,file size is %d,time out  %b", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1) });
      if ((bool1) && (l1 > b.c(this.fpI)))
      {
        Object localObject = this.fpI;
        Context localContext = ah.getContext();
        String str = ah.getContext().getPackageName();
        try
        {
          PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(localContext.getPackageManager(), new Object[] { str, new b.2((b)localObject) });
          if ((b.d(this.fpI)[1] != 0L) || (b.e(this.fpI) > 1L))
          {
            ab.i("MicroMsg.SQLTraceManager", "start file upload ,file length is %d ", new Object[] { Long.valueOf(localFile.length()) });
            if (localFile.length() > b.f(this.fpI))
            {
              ab.e("MicroMsg.SQLTraceManager", "log file invaild format");
              ab.i("MicroMsg.SQLTraceManager", "set last Upload Time %d ", new Object[] { Long.valueOf(System.currentTimeMillis()) });
              b.a(this.fpI, localFile);
              b.g(this.fpI);
              b.h(this.fpI);
              b.c(ah.getContext(), System.currentTimeMillis());
              AppMethodBeat.o(16391);
              return;
              if (l1 - l2 > 86400000L)
              {
                bool1 = true;
                continue;
              }
              bool1 = bool2;
              if (l1 - l2 <= b.a(this.fpI)) {
                continue;
              }
              bool1 = bool2;
              if (!b.b(this.fpI)) {
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
            ((b)localObject).bYy[0] = -1L;
            ((b)localObject).bYy[1] = -1L;
            ((b)localObject).bYy[2] = -1L;
            continue;
            localObject = b.qd(b.access$000() + "MMSQL.trace");
            ab.i("MicroMsg.SQLTraceManager", "read content success");
            this.fpI.qc((String)localObject);
          }
          ab.i("MicroMsg.SQLTraceManager", "wait for get packageStats");
          b.i(this.fpI);
        }
      }
    }
    AppMethodBeat.o(16391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.b.1
 * JD-Core Version:    0.7.0.1
 */