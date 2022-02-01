package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  private List<Object> gcI;
  
  public a()
  {
    AppMethodBeat.i(177080);
    this.gcI = new ArrayList();
    AppMethodBeat.o(177080);
  }
  
  public final Object[] aeD()
  {
    AppMethodBeat.i(177082);
    Collections.reverse(this.gcI);
    Object[] arrayOfObject = this.gcI.toArray();
    AppMethodBeat.o(177082);
    return arrayOfObject;
  }
  
  public final a ba(Object paramObject)
  {
    AppMethodBeat.i(177081);
    this.gcI.add(paramObject);
    AppMethodBeat.o(177081);
    return this;
  }
  
  public final Object lR(int paramInt)
  {
    AppMethodBeat.i(177083);
    Object localObject = this.gcI.get(paramInt);
    AppMethodBeat.o(177083);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.a
 * JD-Core Version:    0.7.0.1
 */