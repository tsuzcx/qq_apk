package com.tencent.mm.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class u
{
  private static volatile u dVe;
  private Map<String, u.c> dVf = new u.a((byte)0);
  
  public static u Hc()
  {
    if (dVe == null) {}
    try
    {
      if (dVe == null) {
        dVe = new u();
      }
      return dVe;
    }
    finally {}
  }
  
  public static String ij(String paramString)
  {
    return "SessionId@" + paramString + "#" + System.nanoTime();
  }
  
  public final u.b ih(String paramString)
  {
    paramString = (u.c)this.dVf.get(paramString);
    if (paramString != null) {
      return paramString.dVh;
    }
    return null;
  }
  
  public final u.b ii(String paramString)
  {
    paramString = (u.c)this.dVf.remove(paramString);
    if (paramString != null) {
      return paramString.dVh;
    }
    return null;
  }
  
  public String toString()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataCenter \nDataStore size : ").append(this.dVf.size());
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(this.dVf.entrySet());
    Iterator localIterator = localLinkedHashSet.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry != null)
      {
        u.c localc = (u.c)localEntry.getValue();
        if (localc != null)
        {
          localStringBuilder.append("\nDataStore id : ").append((String)localEntry.getKey());
          localStringBuilder.append(", CT : ").append(localc.dVi).append("ms");
          localStringBuilder.append(", TTL : ").append((l - localc.dVi) / 1000L).append("s");
        }
      }
    }
    localLinkedHashSet.clear();
    return localStringBuilder.toString();
  }
  
  public final u.b v(String paramString, boolean paramBoolean)
  {
    u.c localc2 = (u.c)this.dVf.get(paramString);
    u.c localc1 = localc2;
    if (localc2 == null)
    {
      if (!paramBoolean) {
        return null;
      }
      localc1 = new u.c();
      this.dVf.put(paramString, localc1);
    }
    return localc1.dVh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.u
 * JD-Core Version:    0.7.0.1
 */