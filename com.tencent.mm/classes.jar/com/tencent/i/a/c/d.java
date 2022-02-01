package com.tencent.i.a.c;

import android.os.HandlerThread;
import com.tencent.h.c.h;
import com.tencent.i.a.h.a;
import com.tencent.i.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements b
{
  private com.tencent.i.a.a.c SrD;
  private com.tencent.i.a.b.a SrE;
  
  public d(com.tencent.i.a.a.c paramc)
  {
    this.SrD = paramc;
  }
  
  public final boolean a(i.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(214738);
    if (this.SrE != null)
    {
      h.a locala = this.SrE.hqh();
      long l1 = l2;
      if (locala != null)
      {
        l1 = l2;
        if (locala.Sqr == com.tencent.i.a.c.Sqm) {
          l1 = 30L;
        }
      }
      boolean bool = this.SrE.a(parama, l1);
      AppMethodBeat.o(214738);
      return bool;
    }
    AppMethodBeat.o(214738);
    return false;
  }
  
  public final boolean b(h.a parama, a parama1)
  {
    AppMethodBeat.i(214737);
    boolean bool;
    if (this.SrE != null)
    {
      com.tencent.i.a.b.a locala = this.SrE;
      if (locala.mHandlerThread == null) {
        break label116;
      }
      bool = locala.mHandlerThread.isAlive();
      if (!bool)
      {
        h.i("sensor_MasterManager", "[method: start ] mEngine is not Alive : ");
        this.SrE = null;
      }
    }
    if (this.SrE != null) {
      if (parama.Sqr != this.SrE.hqh().Sqr) {
        this.SrE.destroy();
      }
    }
    for (this.SrE = new c("master_engine", this.SrD);; this.SrE = new c("master_engine", this.SrD))
    {
      bool = this.SrE.a(parama, parama1);
      AppMethodBeat.o(214737);
      return bool;
      label116:
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.d
 * JD-Core Version:    0.7.0.1
 */