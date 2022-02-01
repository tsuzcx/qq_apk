package com.tencent.mm.plugin.appbrand.ae.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
  implements c
{
  private byte[] content;
  private TreeMap<String, String> ojw;
  
  public g()
  {
    AppMethodBeat.i(156665);
    this.ojw = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    AppMethodBeat.o(156665);
  }
  
  public final String afQ(String paramString)
  {
    AppMethodBeat.i(156667);
    paramString = (String)this.ojw.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(156667);
      return "";
    }
    AppMethodBeat.o(156667);
    return paramString;
  }
  
  public final boolean afR(String paramString)
  {
    AppMethodBeat.i(156669);
    boolean bool = this.ojw.containsKey(paramString);
    AppMethodBeat.o(156669);
    return bool;
  }
  
  public final Iterator<String> bZO()
  {
    AppMethodBeat.i(156666);
    Iterator localIterator = Collections.unmodifiableSet(this.ojw.keySet()).iterator();
    AppMethodBeat.o(156666);
    return localIterator;
  }
  
  public final byte[] getContent()
  {
    return this.content;
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156668);
    this.ojw.put(paramString1, paramString2);
    AppMethodBeat.o(156668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.e.g
 * JD-Core Version:    0.7.0.1
 */