package com.google.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends i
  implements Iterable<i>
{
  private final List<i> elements;
  
  public g()
  {
    AppMethodBeat.i(108120);
    this.elements = new ArrayList();
    AppMethodBeat.o(108120);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(223508);
    Object localObject = parami;
    if (parami == null) {
      localObject = k.bLm;
    }
    this.elements.add(localObject);
    AppMethodBeat.o(223508);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108125);
    if ((paramObject == this) || (((paramObject instanceof g)) && (((g)paramObject).elements.equals(this.elements))))
    {
      AppMethodBeat.o(108125);
      return true;
    }
    AppMethodBeat.o(108125);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(108126);
    int i = this.elements.hashCode();
    AppMethodBeat.o(108126);
    return i;
  }
  
  public final Iterator<i> iterator()
  {
    AppMethodBeat.i(108121);
    Iterator localIterator = this.elements.iterator();
    AppMethodBeat.o(108121);
    return localIterator;
  }
  
  public final Number yZ()
  {
    AppMethodBeat.i(108122);
    if (this.elements.size() == 1)
    {
      localObject = ((i)this.elements.get(0)).yZ();
      AppMethodBeat.o(108122);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(108122);
    throw ((Throwable)localObject);
  }
  
  public final String za()
  {
    AppMethodBeat.i(108123);
    if (this.elements.size() == 1)
    {
      localObject = ((i)this.elements.get(0)).za();
      AppMethodBeat.o(108123);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(108123);
    throw ((Throwable)localObject);
  }
  
  public final boolean zb()
  {
    AppMethodBeat.i(108124);
    if (this.elements.size() == 1)
    {
      boolean bool = ((i)this.elements.get(0)).zb();
      AppMethodBeat.o(108124);
      return bool;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108124);
    throw localIllegalStateException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.a.g
 * JD-Core Version:    0.7.0.1
 */