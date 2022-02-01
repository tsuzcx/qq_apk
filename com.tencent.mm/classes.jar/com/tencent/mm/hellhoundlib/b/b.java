package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> gcI;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.gcI = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final Object[] aeE()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.gcI.toArray();
    this.gcI.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void bb(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.gcI.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void du(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    bb(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void lS(int paramInt)
  {
    AppMethodBeat.i(168727);
    bb(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */