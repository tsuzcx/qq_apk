package com.facebook.jni;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapIteratorHelper
{
  private final Iterator<Map.Entry> mIterator;
  private Object mKey;
  private Object mValue;
  
  public MapIteratorHelper(Map paramMap)
  {
    AppMethodBeat.i(208033);
    this.mIterator = paramMap.entrySet().iterator();
    AppMethodBeat.o(208033);
  }
  
  boolean hasNext()
  {
    AppMethodBeat.i(208037);
    if (this.mIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)this.mIterator.next();
      this.mKey = localEntry.getKey();
      this.mValue = localEntry.getValue();
      AppMethodBeat.o(208037);
      return true;
    }
    this.mKey = null;
    this.mValue = null;
    AppMethodBeat.o(208037);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.jni.MapIteratorHelper
 * JD-Core Version:    0.7.0.1
 */