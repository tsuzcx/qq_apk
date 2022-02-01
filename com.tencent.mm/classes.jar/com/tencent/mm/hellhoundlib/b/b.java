package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> jXw;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.jXw = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final void Fs(long paramLong)
  {
    AppMethodBeat.i(215288);
    bn(Long.valueOf(paramLong));
    AppMethodBeat.o(215288);
  }
  
  public final Object[] aFi()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.jXw.toArray();
    this.jXw.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void bn(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.jXw.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void eL(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    bn(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void sg(int paramInt)
  {
    AppMethodBeat.i(168727);
    bn(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */