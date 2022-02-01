package com.google.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
  extends k
  implements Iterable<k>
{
  public final List<k> elements;
  
  public i()
  {
    AppMethodBeat.i(108120);
    this.elements = new ArrayList();
    AppMethodBeat.o(108120);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108125);
    if ((paramObject == this) || (((paramObject instanceof i)) && (((i)paramObject).elements.equals(this.elements))))
    {
      AppMethodBeat.o(108125);
      return true;
    }
    AppMethodBeat.o(108125);
    return false;
  }
  
  public final boolean getAsBoolean()
  {
    AppMethodBeat.i(108124);
    if (this.elements.size() == 1)
    {
      boolean bool = ((k)this.elements.get(0)).getAsBoolean();
      AppMethodBeat.o(108124);
      return bool;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException();
    AppMethodBeat.o(108124);
    throw localIllegalStateException;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(108126);
    int i = this.elements.hashCode();
    AppMethodBeat.o(108126);
    return i;
  }
  
  public final Iterator<k> iterator()
  {
    AppMethodBeat.i(108121);
    Iterator localIterator = this.elements.iterator();
    AppMethodBeat.o(108121);
    return localIterator;
  }
  
  public final Number yx()
  {
    AppMethodBeat.i(108122);
    if (this.elements.size() == 1)
    {
      localObject = ((k)this.elements.get(0)).yx();
      AppMethodBeat.o(108122);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(108122);
    throw ((Throwable)localObject);
  }
  
  public final String yy()
  {
    AppMethodBeat.i(108123);
    if (this.elements.size() == 1)
    {
      localObject = ((k)this.elements.get(0)).yy();
      AppMethodBeat.o(108123);
      return localObject;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(108123);
    throw ((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.a.i
 * JD-Core Version:    0.7.0.1
 */