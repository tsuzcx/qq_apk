package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.mm.plugin.clean.c.a.a.a;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class e
  extends Thread
  implements a.a
{
  private ah dPi = new ah(Looper.getMainLooper());
  private long endTime = 0L;
  private h iBO;
  private ArrayList<a> iBP;
  private int iBQ = 0;
  private b iBw;
  private int iBy = 0;
  private int iBz = 0;
  private boolean isStop;
  private long startTime = 0L;
  
  public e(b paramb, h paramh, ArrayList<a> paramArrayList)
  {
    this.iBw = paramb;
    this.iBO = paramh;
    this.iBP = paramArrayList;
  }
  
  private void aDH()
  {
    this.endTime = System.currentTimeMillis();
    y.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[] { Long.valueOf(this.endTime - this.startTime) });
    if ((this.iBO != null) && (!this.isStop)) {
      this.dPi.post(new e.2(this));
    }
  }
  
  public final void a(com.tencent.mm.plugin.clean.c.a.a parama)
  {
    interrupt();
    this.iBz += 1;
    if ((this.iBO != null) && (!this.isStop)) {
      this.dPi.post(new Runnable()
      {
        public final void run()
        {
          e.c(e.this).cA(e.a(e.this), e.b(e.this));
        }
      });
    }
    if (this.iBz == this.iBy) {
      aDH();
    }
  }
  
  public final void aDZ()
  {
    y.i("MicroMsg.DeleteFileController", "stop analyseController");
    this.isStop = true;
    interrupt();
  }
  
  public final void run()
  {
    this.startTime = System.currentTimeMillis();
    this.iBy = this.iBP.size();
    y.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[] { Integer.valueOf(this.iBy) });
    if (this.iBy == 0) {
      aDH();
    }
    for (;;)
    {
      return;
      int i = 0;
      while ((!this.isStop) && (i < this.iBP.size()))
      {
        a locala = (a)this.iBP.get(i);
        y.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[] { Integer.valueOf(i), locala.filePath });
        e.a locala1 = new e.a(this, locala);
        while (!this.iBw.b(locala1)) {
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        y.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[] { locala.filePath });
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.e
 * JD-Core Version:    0.7.0.1
 */