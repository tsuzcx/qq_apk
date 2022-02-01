package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements r
{
  private ConcurrentHashMap<Integer, z> cDe;
  
  public g()
  {
    AppMethodBeat.i(188760);
    this.cDe = new ConcurrentHashMap();
    AppMethodBeat.o(188760);
  }
  
  public final z Wy(int paramInt)
  {
    AppMethodBeat.i(188763);
    z localz = (z)this.cDe.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(188763);
    return localz;
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(188762);
    if (!this.cDe.containsKey(Integer.valueOf(19))) {
      this.cDe.put(Integer.valueOf(19), paramz);
    }
    AppMethodBeat.o(188762);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */