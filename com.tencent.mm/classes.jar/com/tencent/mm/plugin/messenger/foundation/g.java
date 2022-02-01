package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements r
{
  private ConcurrentHashMap<Integer, z> evG;
  
  public g()
  {
    AppMethodBeat.i(288627);
    this.evG = new ConcurrentHashMap();
    AppMethodBeat.o(288627);
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(288631);
    if (!this.evG.containsKey(Integer.valueOf(19))) {
      this.evG.put(Integer.valueOf(19), paramz);
    }
    AppMethodBeat.o(288631);
  }
  
  public final z aaA(int paramInt)
  {
    AppMethodBeat.i(288634);
    z localz = (z)this.evG.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(288634);
    return localz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.g
 * JD-Core Version:    0.7.0.1
 */