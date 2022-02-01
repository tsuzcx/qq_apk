package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ad
{
  private static volatile ad okq;
  private Map<String, c> okr;
  
  private ad()
  {
    AppMethodBeat.i(125111);
    this.okr = new a((byte)0);
    AppMethodBeat.o(125111);
  }
  
  private c Jl(String paramString)
  {
    AppMethodBeat.i(125112);
    c localc = new c();
    this.okr.put(paramString, localc);
    AppMethodBeat.o(125112);
    return localc;
  }
  
  public static String Jo(String paramString)
  {
    AppMethodBeat.i(125116);
    paramString = "SessionId@" + paramString + "#" + System.nanoTime();
    AppMethodBeat.o(125116);
    return paramString;
  }
  
  public static ad bCb()
  {
    AppMethodBeat.i(125110);
    if (okq == null) {}
    try
    {
      if (okq == null) {
        okq = new ad();
      }
      ad localad = okq;
      AppMethodBeat.o(125110);
      return localad;
    }
    finally
    {
      AppMethodBeat.o(125110);
    }
  }
  
  public final ad.b Jm(String paramString)
  {
    AppMethodBeat.i(125113);
    paramString = (c)this.okr.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.okt;
      AppMethodBeat.o(125113);
      return paramString;
    }
    AppMethodBeat.o(125113);
    return null;
  }
  
  public final ad.b Jn(String paramString)
  {
    AppMethodBeat.i(125115);
    paramString = (c)this.okr.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.okt;
      AppMethodBeat.o(125115);
      return paramString;
    }
    AppMethodBeat.o(125115);
    return null;
  }
  
  public final ad.b M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(125114);
    c localc2 = (c)this.okr.get(paramString);
    c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(125114);
        return null;
      }
      localc1 = Jl(paramString);
    }
    paramString = localc1.okt;
    AppMethodBeat.o(125114);
    return paramString;
  }
  
  public String toString()
  {
    AppMethodBeat.i(125117);
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("DataCenter \nDataStore size : ").append(this.okr.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.okr.entrySet());
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
          ((StringBuilder)localObject).append(", CT : ").append(localc.oku).append("ms");
          ((StringBuilder)localObject).append(", TTL : ").append((l - localc.oku) / 1000L).append("s");
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
    ad.b okt;
    long oku;
    
    c()
    {
      AppMethodBeat.i(125109);
      this.okt = new ad.b();
      this.oku = System.currentTimeMillis();
      AppMethodBeat.o(125109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */