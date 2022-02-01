package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  private List<Object> mxq;
  
  public a()
  {
    AppMethodBeat.i(177080);
    this.mxq = new ArrayList();
    AppMethodBeat.o(177080);
  }
  
  public final Object[] aYi()
  {
    AppMethodBeat.i(177082);
    Collections.reverse(this.mxq);
    Object[] arrayOfObject = this.mxq.toArray();
    AppMethodBeat.o(177082);
    return arrayOfObject;
  }
  
  public final a cG(Object paramObject)
  {
    AppMethodBeat.i(177081);
    this.mxq.add(paramObject);
    AppMethodBeat.o(177081);
    return this;
  }
  
  public final Object sb(int paramInt)
  {
    AppMethodBeat.i(177083);
    Object localObject = this.mxq.get(paramInt);
    AppMethodBeat.o(177083);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.a
 * JD-Core Version:    0.7.0.1
 */