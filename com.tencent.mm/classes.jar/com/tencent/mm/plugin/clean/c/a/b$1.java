package com.tencent.mm.plugin.clean.c.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    Looper.prepare();
    ah localah = new ah(Looper.myLooper());
    this.iCd.iCb.put(Long.valueOf(Thread.currentThread().getId()), localah);
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.b.1
 * JD-Core Version:    0.7.0.1
 */