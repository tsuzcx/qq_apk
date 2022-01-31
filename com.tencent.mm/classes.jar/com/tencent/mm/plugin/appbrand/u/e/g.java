package com.tencent.mm.plugin.appbrand.u.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class g
  implements c
{
  private byte[] content;
  private TreeMap<String, String> iZT;
  
  public g()
  {
    AppMethodBeat.i(73267);
    this.iZT = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    AppMethodBeat.o(73267);
  }
  
  public final String Fy(String paramString)
  {
    AppMethodBeat.i(73269);
    paramString = (String)this.iZT.get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(73269);
      return "";
    }
    AppMethodBeat.o(73269);
    return paramString;
  }
  
  public final boolean Fz(String paramString)
  {
    AppMethodBeat.i(73271);
    boolean bool = this.iZT.containsKey(paramString);
    AppMethodBeat.o(73271);
    return bool;
  }
  
  public final Iterator<String> aOs()
  {
    AppMethodBeat.i(73268);
    Iterator localIterator = Collections.unmodifiableSet(this.iZT.keySet()).iterator();
    AppMethodBeat.o(73268);
    return localIterator;
  }
  
  public final byte[] aOt()
  {
    return this.content;
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(73270);
    this.iZT.put(paramString1, paramString2);
    AppMethodBeat.o(73270);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.e.g
 * JD-Core Version:    0.7.0.1
 */