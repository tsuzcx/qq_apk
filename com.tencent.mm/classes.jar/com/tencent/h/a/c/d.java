package com.tencent.h.a.c;

import android.os.HandlerThread;
import com.tencent.g.c.i;
import com.tencent.h.a.h.a;
import com.tencent.h.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements b
{
  private com.tencent.h.a.a.c ZTg;
  private com.tencent.h.a.b.a ZTh;
  
  public d(com.tencent.h.a.a.c paramc)
  {
    this.ZTg = paramc;
  }
  
  public final boolean a(i.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(207681);
    if (this.ZTh != null)
    {
      h.a locala = this.ZTh.itO();
      long l1 = l2;
      if (locala != null)
      {
        l1 = l2;
        if (locala.ZRU == com.tencent.h.a.c.ZRP) {
          l1 = 30L;
        }
      }
      boolean bool = this.ZTh.a(parama, l1);
      AppMethodBeat.o(207681);
      return bool;
    }
    AppMethodBeat.o(207681);
    return false;
  }
  
  public final boolean b(h.a parama, a parama1)
  {
    AppMethodBeat.i(207679);
    boolean bool;
    if (this.ZTh != null)
    {
      com.tencent.h.a.b.a locala = this.ZTh;
      if (locala.mHandlerThread == null) {
        break label116;
      }
      bool = locala.mHandlerThread.isAlive();
      if (!bool)
      {
        i.i("sensor_MasterManager", "[method: start ] mEngine is not Alive : ");
        this.ZTh = null;
      }
    }
    if (this.ZTh != null) {
      if (parama.ZRU != this.ZTh.itO().ZRU) {
        this.ZTh.destroy();
      }
    }
    for (this.ZTh = new c("master_engine", this.ZTg);; this.ZTh = new c("master_engine", this.ZTg))
    {
      bool = this.ZTh.a(parama, parama1);
      AppMethodBeat.o(207679);
      return bool;
      label116:
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.d
 * JD-Core Version:    0.7.0.1
 */