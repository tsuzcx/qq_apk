package com.tencent.mm.plugin.emojicapture.model.b;

import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d$c
  implements Runnable
{
  d$c(d paramd, a.d.a.a parama) {}
  
  public final void run()
  {
    long l = bk.UZ();
    boolean bool = d.a(this.jkQ).baL();
    y.i(d.b(this.jkQ), "finishEncode used " + bk.cp(l) + ", ret:" + bool + ", totally used " + bk.cp(d.c(this.jkQ)) + "ms");
    d.d(this.jkQ).quit();
    a.d.a.a locala = this.jkU;
    if (locala != null) {
      locala.invoke();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d.c
 * JD-Core Version:    0.7.0.1
 */