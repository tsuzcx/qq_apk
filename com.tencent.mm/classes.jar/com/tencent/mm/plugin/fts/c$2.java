package com.tencent.mm.plugin.fts;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public final void run()
  {
    Looper.prepare();
    c.a(this.ktI, new ah());
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.c.2
 * JD-Core Version:    0.7.0.1
 */