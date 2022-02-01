package com.tencent.h.a.c;

import com.tencent.g.c.i;
import com.tencent.h.a.h.a;
import com.tencent.h.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements b
{
  private com.tencent.h.a.a.c ahXG;
  private com.tencent.h.a.b.a ahXH;
  
  public d(com.tencent.h.a.a.c paramc)
  {
    this.ahXG = paramc;
  }
  
  public final boolean a(i.a parama)
  {
    long l2 = 0L;
    AppMethodBeat.i(212160);
    if (this.ahXH != null)
    {
      h.a locala = this.ahXH.kdk();
      long l1 = l2;
      if (locala != null)
      {
        l1 = l2;
        if (locala.ahWr == com.tencent.h.a.c.ahWm) {
          l1 = 30L;
        }
      }
      boolean bool = this.ahXH.a(parama, l1);
      AppMethodBeat.o(212160);
      return bool;
    }
    AppMethodBeat.o(212160);
    return false;
  }
  
  public final boolean b(h.a parama, a parama1)
  {
    AppMethodBeat.i(212152);
    if ((this.ahXH != null) && (!this.ahXH.isAlive()))
    {
      i.i("sensor_MasterManager", "[method: start ] mEngine is not Alive : ");
      this.ahXH = null;
    }
    if (this.ahXH != null) {
      if (parama.ahWr != this.ahXH.kdk().ahWr) {
        this.ahXH.destroy();
      }
    }
    for (this.ahXH = new c("master_engine", this.ahXG);; this.ahXH = new c("master_engine", this.ahXG))
    {
      boolean bool = this.ahXH.a(parama, parama1);
      AppMethodBeat.o(212152);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.d
 * JD-Core Version:    0.7.0.1
 */