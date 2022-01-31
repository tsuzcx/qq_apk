package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.bf;

final class q$34
  implements aa
{
  q$34(q paramq) {}
  
  public final boolean anq()
  {
    if (q.d(this.gTY).ZQ()) {
      return false;
    }
    y localy = q.c(this.gTY);
    y.4 local4 = new y.4(localy, Boolean.valueOf(false));
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      local4.b(null);
    }
    local4.b(localy.mHandler);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.q.34
 * JD-Core Version:    0.7.0.1
 */