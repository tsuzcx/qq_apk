package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
{
  private List<Object> hlM;
  
  public a()
  {
    AppMethodBeat.i(177080);
    this.hlM = new ArrayList();
    AppMethodBeat.o(177080);
  }
  
  public final Object[] axQ()
  {
    AppMethodBeat.i(177082);
    Collections.reverse(this.hlM);
    Object[] arrayOfObject = this.hlM.toArray();
    AppMethodBeat.o(177082);
    return arrayOfObject;
  }
  
  public final a bl(Object paramObject)
  {
    AppMethodBeat.i(177081);
    this.hlM.add(paramObject);
    AppMethodBeat.o(177081);
    return this;
  }
  
  public final Object pG(int paramInt)
  {
    AppMethodBeat.i(177083);
    Object localObject = this.hlM.get(paramInt);
    AppMethodBeat.o(177083);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.b.a
 * JD-Core Version:    0.7.0.1
 */