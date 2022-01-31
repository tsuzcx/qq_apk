package com.tencent.mm.d.a;

import com.eclipsesource.v8.MultiContextNodeJS;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$2
  implements j.a
{
  i$2(i parami) {}
  
  public final boolean Cp()
  {
    AppMethodBeat.i(113813);
    boolean bool = i.a(this.cbs).handleMessage();
    AppMethodBeat.o(113813);
    return bool;
  }
  
  public final void closeUVLoop()
  {
    AppMethodBeat.i(113815);
    if (i.a(this.cbs) != null) {
      i.a(this.cbs).closeUVLoop();
    }
    AppMethodBeat.o(113815);
  }
  
  public final void wakeUpUVLoop()
  {
    AppMethodBeat.i(113814);
    if (i.a(this.cbs) != null) {
      i.a(this.cbs).wakeUpUVLoop();
    }
    AppMethodBeat.o(113814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.i.2
 * JD-Core Version:    0.7.0.1
 */