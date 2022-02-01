package com.facebook.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public class IteratorHelper
{
  private Object mElement;
  private final Iterator mIterator;
  
  public IteratorHelper(Iterable paramIterable)
  {
    AppMethodBeat.i(208051);
    this.mIterator = paramIterable.iterator();
    AppMethodBeat.o(208051);
  }
  
  public IteratorHelper(Iterator paramIterator)
  {
    this.mIterator = paramIterator;
  }
  
  boolean hasNext()
  {
    AppMethodBeat.i(208057);
    if (this.mIterator.hasNext())
    {
      this.mElement = this.mIterator.next();
      AppMethodBeat.o(208057);
      return true;
    }
    this.mElement = null;
    AppMethodBeat.o(208057);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.jni.IteratorHelper
 * JD-Core Version:    0.7.0.1
 */