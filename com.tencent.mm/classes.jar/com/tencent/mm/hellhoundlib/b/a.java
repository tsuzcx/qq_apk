package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  private List<Object> jXw;
  
  public a()
  {
    AppMethodBeat.i(177080);
    this.jXw = new ArrayList();
    AppMethodBeat.o(177080);
  }
  
  public final Object[] aFh()
  {
    AppMethodBeat.i(177082);
    Collections.reverse(this.jXw);
    Object[] arrayOfObject = this.jXw.toArray();
    AppMethodBeat.o(177082);
    return arrayOfObject;
  }
  
  public final a bm(Object paramObject)
  {
    AppMethodBeat.i(177081);
    this.jXw.add(paramObject);
    AppMethodBeat.o(177081);
    return this;
  }
  
  public final Object sf(int paramInt)
  {
    AppMethodBeat.i(177083);
    Object localObject = this.jXw.get(paramInt);
    AppMethodBeat.o(177083);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.a
 * JD-Core Version:    0.7.0.1
 */