package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class y
{
  private static volatile y gMy;
  private Map<String, c> gMz;
  
  private y()
  {
    AppMethodBeat.i(125111);
    this.gMz = new a((byte)0);
    AppMethodBeat.o(125111);
  }
  
  public static y arz()
  {
    AppMethodBeat.i(125110);
    if (gMy == null) {}
    try
    {
      if (gMy == null) {
        gMy = new y();
      }
      y localy = gMy;
      AppMethodBeat.o(125110);
      return localy;
    }
    finally
    {
      AppMethodBeat.o(125110);
    }
  }
  
  private c tA(String paramString)
  {
    AppMethodBeat.i(125112);
    c localc = new c();
    this.gMz.put(paramString, localc);
    AppMethodBeat.o(125112);
    return localc;
  }
  
  public static String tD(String paramString)
  {
    AppMethodBeat.i(125116);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    AppMethodBeat.o(125116);
    return paramString;
  }
  
  public final y.b E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125114);
    c localc2 = (c)this.gMz.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(125114);
        return null;
      }
      localc1 = tA(paramString);
    }
    paramString = localc1.gMB;
    AppMethodBeat.o(125114);
    return paramString;
  }
  
  public final y.b tB(String paramString)
  {
    AppMethodBeat.i(125113);
    paramString = (c)this.gMz.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.gMB;
      AppMethodBeat.o(125113);
      return paramString;
    }
    AppMethodBeat.o(125113);
    return null;
  }
  
  public final y.b tC(String paramString)
  {
    AppMethodBeat.i(125115);
    paramString = (c)this.gMz.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.gMB;
      AppMethodBeat.o(125115);
      return paramString;
    }
    AppMethodBeat.o(125115);
    return null;
  }
  
  public String toString()
  {
    AppMethodBeat.i(125117);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.gMz.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.gMz.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        c localc = (c)localEntry.getValue();
        if (localc != null)
        {
          ((StringBuilder)localObject).append("\nDataStore id : ").append((String)localEntry.getKey());
          ((StringBuilder)localObject).append(", CT : ").append(localc.gMC).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.gMC) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(125117);
    return localObject;
  }
  
  static final class a<K, V>
    extends ConcurrentHashMap<K, V>
  {
    public final boolean containsValue(Object paramObject)
    {
      AppMethodBeat.i(125093);
      if (paramObject == null)
      {
        AppMethodBeat.o(125093);
        return false;
      }
      boolean bool = super.containsValue(paramObject);
      AppMethodBeat.o(125093);
      return bool;
    }
    
    public final V get(Object paramObject)
    {
      AppMethodBeat.i(125090);
      if (paramObject == null)
      {
        AppMethodBeat.o(125090);
        return null;
      }
      paramObject = super.get(paramObject);
      AppMethodBeat.o(125090);
      return paramObject;
    }
    
    public final V put(K paramK, V paramV)
    {
      AppMethodBeat.i(125091);
      if (paramK == null)
      {
        AppMethodBeat.o(125091);
        return null;
      }
      if (paramV == null)
      {
        paramK = super.remove(paramK);
        AppMethodBeat.o(125091);
        return paramK;
      }
      paramK = super.put(paramK, paramV);
      AppMethodBeat.o(125091);
      return paramK;
    }
    
    public final V remove(Object paramObject)
    {
      AppMethodBeat.i(125092);
      if (paramObject == null)
      {
        AppMethodBeat.o(125092);
        return null;
      }
      paramObject = super.remove(paramObject);
      AppMethodBeat.o(125092);
      return paramObject;
    }
  }
  
  static final class c
  {
    y.b gMB;
    long gMC;
    
    c()
    {
      AppMethodBeat.i(125109);
      this.gMB = new y.b();
      this.gMC = System.currentTimeMillis();
      AppMethodBeat.o(125109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.y
 * JD-Core Version:    0.7.0.1
 */