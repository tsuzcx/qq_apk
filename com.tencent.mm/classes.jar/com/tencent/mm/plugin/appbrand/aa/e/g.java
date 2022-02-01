package com.tencent.mm.plugin.appbrand.aa.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
  implements c
{
  private byte[] content;
  private TreeMap<String, String> mqI;
  
  public g()
  {
    AppMethodBeat.i(156665);
    this.mqI = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    AppMethodBeat.o(156665);
  }
  
  public final String RE(String paramString)
  {
    AppMethodBeat.i(156667);
    paramString = (String)this.mqI.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(156667);
      return "";
    }
    AppMethodBeat.o(156667);
    return paramString;
  }
  
  public final boolean RF(String paramString)
  {
    AppMethodBeat.i(156669);
    boolean bool = this.mqI.containsKey(paramString);
    AppMethodBeat.o(156669);
    return bool;
  }
  
  public final Iterator<String> bxL()
  {
    AppMethodBeat.i(156666);
    Iterator localIterator = Collections.unmodifiableSet(this.mqI.keySet()).iterator();
    AppMethodBeat.o(156666);
    return localIterator;
  }
  
  public final byte[] bxM()
  {
    return this.content;
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156668);
    this.mqI.put(paramString1, paramString2);
    AppMethodBeat.o(156668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aa.e.g
 * JD-Core Version:    0.7.0.1
 */