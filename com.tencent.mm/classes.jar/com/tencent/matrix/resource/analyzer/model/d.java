package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.analyzer.a.b;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
  implements Serializable
{
  public final Map<String, Map<String, e>> cHp;
  public final Map<String, Map<String, e>> cHq;
  public final Map<String, e> cHr;
  public final Map<String, e> cHs;
  
  d(b paramb)
  {
    this.cHp = l(paramb.cHp);
    this.cHq = l(paramb.cHq);
    this.cHr = m(paramb.cHr);
    this.cHs = m(paramb.cHs);
  }
  
  private static Map<String, Map<String, e>> l(Map<String, Map<String, c>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), m((Map)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static Map<String, e> m(Map<String, c> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), new e((c)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  public final String toString()
  {
    Object localObject1 = "";
    Iterator localIterator1 = this.cHp.entrySet().iterator();
    Object localObject2;
    Object localObject3;
    Iterator localIterator2;
    Map.Entry localEntry;
    while (localIterator1.hasNext())
    {
      localObject2 = (Map.Entry)localIterator1.next();
      localObject3 = (String)((Map.Entry)localObject2).getKey();
      localIterator2 = ((Map)((Map.Entry)localObject2).getValue()).entrySet().iterator();
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (localIterator2.hasNext())
      {
        localEntry = (Map.Entry)localIterator2.next();
        if (((e)localEntry.getValue()).cHv) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cHq.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      localObject2 = (Map.Entry)localIterator1.next();
      localObject3 = (String)((Map.Entry)localObject2).getKey();
      localIterator2 = ((Map)((Map.Entry)localObject2).getValue()).entrySet().iterator();
      localObject2 = localObject1;
      localObject1 = localObject2;
      if (localIterator2.hasNext())
      {
        localEntry = (Map.Entry)localIterator2.next();
        if (((e)localEntry.getValue()).cHv) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cHr.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cHv) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.cHs.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cHv) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Class:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    return localObject1;
  }
  
  public static abstract interface a
  {
    public abstract d.b H(String paramString1, String paramString2);
    
    public abstract d IK();
    
    public abstract d.b J(String paramString1, String paramString2);
    
    public abstract d.b eb(String paramString);
    
    public abstract d.b ec(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> cHp = new LinkedHashMap();
    final Map<String, Map<String, d.c>> cHq = new LinkedHashMap();
    final Map<String, d.c> cHr = new LinkedHashMap();
    final Map<String, d.c> cHs = new LinkedHashMap();
    private d.c cHt;
    
    public final b H(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cHp.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cHp.put(paramString1, localObject);
      }
      this.cHt = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cHt);
      return this;
    }
    
    public final d IK()
    {
      return new d(this);
    }
    
    public final b IL()
    {
      this.cHt.cHv = true;
      return this;
    }
    
    public final b J(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cHq.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cHq.put(paramString1, localObject);
      }
      this.cHt = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cHt);
      return this;
    }
    
    public final b eb(String paramString)
    {
      b.checkNotNull(paramString, "threadName");
      this.cHt = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.cHr.put(paramString, this.cHt);
      return this;
    }
    
    public final b ec(String paramString)
    {
      b.checkNotNull(paramString, "mClassName");
      this.cHt = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.cHs.put(paramString, this.cHt);
      return this;
    }
    
    public final b ed(String paramString)
    {
      this.cHt.name = paramString;
      return this;
    }
    
    public final b ee(String paramString)
    {
      this.cHt.cHu = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String cHu;
    boolean cHv;
    final String cHw;
    String name;
    
    c(String paramString)
    {
      this.cHw = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */