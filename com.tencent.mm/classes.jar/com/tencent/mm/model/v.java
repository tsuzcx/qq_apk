package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class v
{
  private static volatile v fln;
  private Map<String, v.c> flo;
  
  private v()
  {
    AppMethodBeat.i(115091);
    this.flo = new v.a((byte)0);
    AppMethodBeat.o(115091);
  }
  
  public static v aae()
  {
    AppMethodBeat.i(115090);
    if (fln == null) {}
    try
    {
      if (fln == null) {
        fln = new v();
      }
      v localv = fln;
      AppMethodBeat.o(115090);
      return localv;
    }
    finally
    {
      AppMethodBeat.o(115090);
    }
  }
  
  private v.c oN(String paramString)
  {
    AppMethodBeat.i(115092);
    v.c localc = new v.c();
    this.flo.put(paramString, localc);
    AppMethodBeat.o(115092);
    return localc;
  }
  
  public static String oQ(String paramString)
  {
    AppMethodBeat.i(115096);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    AppMethodBeat.o(115096);
    return paramString;
  }
  
  public final v.b oO(String paramString)
  {
    AppMethodBeat.i(115093);
    paramString = (v.c)this.flo.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.flq;
      AppMethodBeat.o(115093);
      return paramString;
    }
    AppMethodBeat.o(115093);
    return null;
  }
  
  public final v.b oP(String paramString)
  {
    AppMethodBeat.i(115095);
    paramString = (v.c)this.flo.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.flq;
      AppMethodBeat.o(115095);
      return paramString;
    }
    AppMethodBeat.o(115095);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115097);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.flo.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.flo.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        v.c localc = (v.c)localEntry.getValue();
        if (localc != null)
        {
          ((StringBuilder)localObject).append("\nDataStore id : ").append((String)localEntry.getKey());
          ((StringBuilder)localObject).append(", CT : ").append(localc.flr).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.flr) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(115097);
    return localObject;
  }
  
  public final v.b z(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(115094);
    v.c localc2 = (v.c)this.flo.get(paramString);
    v.c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(115094);
        return null;
      }
      localc1 = oN(paramString);
    }
    paramString = localc1.flq;
    AppMethodBeat.o(115094);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */