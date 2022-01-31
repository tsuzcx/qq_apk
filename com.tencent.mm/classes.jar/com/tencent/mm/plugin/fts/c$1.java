package com.tencent.mm.plugin.fts;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class c$1
  implements Runnable
{
  c$1(c paramc, int paramInt) {}
  
  public final void run()
  {
    Looper.prepare();
    c.a(this.ktI)[this.val$id] = new ah();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.1
 * JD-Core Version:    0.7.0.1
 */