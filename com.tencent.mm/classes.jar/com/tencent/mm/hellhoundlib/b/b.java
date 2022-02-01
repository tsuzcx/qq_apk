package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> hlM;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.hlM = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final Object[] axR()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.hlM.toArray();
    this.hlM.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void bm(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.hlM.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void en(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    bm(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void pH(int paramInt)
  {
    AppMethodBeat.i(168727);
    bm(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
  
  public final void zo(long paramLong)
  {
    AppMethodBeat.i(186285);
    bm(Long.valueOf(paramLong));
    AppMethodBeat.o(186285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */