package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> gws;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.gws = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final Object[] ahq()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.gws.toArray();
    this.gws.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void bd(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.gws.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void dw(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    bd(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void mr(int paramInt)
  {
    AppMethodBeat.i(168727);
    bd(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
  
  public final void qY(long paramLong)
  {
    AppMethodBeat.i(206533);
    bd(Long.valueOf(paramLong));
    AppMethodBeat.o(206533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */