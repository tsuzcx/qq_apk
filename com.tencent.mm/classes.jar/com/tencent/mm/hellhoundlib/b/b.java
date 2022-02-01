package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  private List<Object> fYb;
  
  public b()
  {
    AppMethodBeat.i(168726);
    this.fYb = new ArrayList();
    AppMethodBeat.o(168726);
  }
  
  public final Object[] ado()
  {
    AppMethodBeat.i(168730);
    Object[] arrayOfObject = this.fYb.toArray();
    this.fYb.clear();
    AppMethodBeat.o(168730);
    return arrayOfObject;
  }
  
  public final void be(Object paramObject)
  {
    AppMethodBeat.i(168729);
    this.fYb.add(paramObject);
    AppMethodBeat.o(168729);
  }
  
  public final void du(boolean paramBoolean)
  {
    AppMethodBeat.i(168728);
    be(Boolean.valueOf(paramBoolean));
    AppMethodBeat.o(168728);
  }
  
  public final void lT(int paramInt)
  {
    AppMethodBeat.i(168727);
    be(Integer.valueOf(paramInt));
    AppMethodBeat.o(168727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.b
 * JD-Core Version:    0.7.0.1
 */