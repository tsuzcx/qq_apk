package com.tencent.mm.plugin.appbrand.appusage;

import android.os.DeadObjectException;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.ipcinvoker.e.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class o$b$2
  implements b
{
  o$b$2(o.b paramb, j.a parama) {}
  
  public final void c(Exception paramException)
  {
    if ((paramException instanceof DeadObjectException))
    {
      new ah(Looper.myLooper()).post(new o.b.2.1(this));
      return;
    }
    if ((paramException instanceof RuntimeException)) {
      throw ((RuntimeException)paramException);
    }
    y.e("MicroMsg.AppBrandLocalUsageStorageIPCImpl", "onExceptionOccur(%s)", new Object[] { Log.getStackTraceString(paramException) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.o.b.2
 * JD-Core Version:    0.7.0.1
 */