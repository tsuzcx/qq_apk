package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  private List<Object> gws;
  
  public a()
  {
    AppMethodBeat.i(177080);
    this.gws = new ArrayList();
    AppMethodBeat.o(177080);
  }
  
  public final Object[] ahp()
  {
    AppMethodBeat.i(177082);
    Collections.reverse(this.gws);
    Object[] arrayOfObject = this.gws.toArray();
    AppMethodBeat.o(177082);
    return arrayOfObject;
  }
  
  public final a bc(Object paramObject)
  {
    AppMethodBeat.i(177081);
    this.gws.add(paramObject);
    AppMethodBeat.o(177081);
    return this;
  }
  
  public final Object mq(int paramInt)
  {
    AppMethodBeat.i(177083);
    Object localObject = this.gws.get(paramInt);
    AppMethodBeat.o(177083);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.a
 * JD-Core Version:    0.7.0.1
 */