package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> mxq;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.mxq = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final Object[] aYj()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.mxq.toArray();
    this.mxq.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void cH(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.mxq.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void fv(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    cH(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(231508);
    cH(Long.valueOf(paramLong));
    AppMethodBeat.o(231508);
  }
  
  public final void sc(int paramInt)
  {
    AppMethodBeat.i(168727);
    cH(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */