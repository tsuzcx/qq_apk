package com.tencent.mm.plugin.clean.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.a.a.a;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class e
  extends Thread
  implements a.a
{
  private long endTime;
  private ak faV;
  private boolean isStop;
  private b kGD;
  private int kGF;
  private int kGG;
  private h kGV;
  private ArrayList<a> kGW;
  private int kGX;
  private long startTime;
  
  public e(b paramb, h paramh, ArrayList<a> paramArrayList)
  {
    AppMethodBeat.i(18703);
    this.kGF = 0;
    this.kGG = 0;
    this.kGX = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.faV = new ak(Looper.getMainLooper());
    this.kGD = paramb;
    this.kGV = paramh;
    this.kGW = paramArrayList;
    AppMethodBeat.o(18703);
  }
  
  private void bgH()
  {
    AppMethodBeat.i(18705);
    this.endTime = System.currentTimeMillis();
    ab.i("MicroMsg.DeleteFileController", "totalUserTime:%d", new Object[] { Long.valueOf(bgI()) });
    if ((this.kGV != null) && (!this.isStop)) {
      this.faV.post(new e.2(this));
    }
    AppMethodBeat.o(18705);
  }
  
  private long bgI()
  {
    return this.endTime - this.startTime;
  }
  
  public final void a(com.tencent.mm.plugin.clean.c.a.a parama)
  {
    AppMethodBeat.i(18707);
    interrupt();
    this.kGG += 1;
    if ((this.kGV != null) && (!this.isStop)) {
      this.faV.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(18700);
          e.c(e.this).dY(e.a(e.this), e.b(e.this));
          AppMethodBeat.o(18700);
        }
      });
    }
    if (this.kGG == this.kGF) {
      bgH();
    }
    AppMethodBeat.o(18707);
  }
  
  public final void bgZ()
  {
    AppMethodBeat.i(18706);
    ab.i("MicroMsg.DeleteFileController", "stop analyseController");
    this.isStop = true;
    interrupt();
    AppMethodBeat.o(18706);
  }
  
  public final void run()
  {
    AppMethodBeat.i(18704);
    this.startTime = System.currentTimeMillis();
    this.kGF = this.kGW.size();
    ab.d("MicroMsg.DeleteFileController", "totalTaskCount=%d", new Object[] { Integer.valueOf(this.kGF) });
    if (this.kGF == 0)
    {
      bgH();
      AppMethodBeat.o(18704);
      return;
    }
    int i = 0;
    while ((!this.isStop) && (i < this.kGW.size()))
    {
      a locala = (a)this.kGW.get(i);
      ab.d("MicroMsg.DeleteFileController", "while loop index=%d | filePath=%s", new Object[] { Integer.valueOf(i), locala.filePath });
      e.a locala1 = new e.a(this, locala);
      while (!this.kGD.b(locala1)) {
        try
        {
          Thread.sleep(100L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      ab.d("MicroMsg.DeleteFileController", "Start task： filePath＝%s", new Object[] { locala.filePath });
      i += 1;
    }
    AppMethodBeat.o(18704);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.e
 * JD-Core Version:    0.7.0.1
 */