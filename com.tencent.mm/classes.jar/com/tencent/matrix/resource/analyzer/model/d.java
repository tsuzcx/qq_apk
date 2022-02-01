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
  public final Map<String, Map<String, e>> cXN;
  public final Map<String, Map<String, e>> cXO;
  public final Map<String, e> cXP;
  public final Map<String, e> cXQ;
  
  d(b paramb)
  {
    this.cXN = n(paramb.cXN);
    this.cXO = n(paramb.cXO);
    this.cXP = o(paramb.cXP);
    this.cXQ = o(paramb.cXQ);
  }
  
  private static Map<String, Map<String, e>> n(Map<String, Map<String, c>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), o((Map)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static Map<String, e> o(Map<String, c> paramMap)
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
    Iterator localIterator1 = this.cXN.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cXT) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cXO.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cXT) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cXP.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cXT) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.cXQ.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cXT) {}
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
    public abstract d.b L(String paramString1, String paramString2);
    
    public abstract d.b M(String paramString1, String paramString2);
    
    public abstract d SY();
    
    public abstract d.b eL(String paramString);
    
    public abstract d.b eM(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> cXN = new LinkedHashMap();
    final Map<String, Map<String, d.c>> cXO = new LinkedHashMap();
    final Map<String, d.c> cXP = new LinkedHashMap();
    final Map<String, d.c> cXQ = new LinkedHashMap();
    private d.c cXR;
    
    public final b L(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cXN.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cXN.put(paramString1, localObject);
      }
      this.cXR = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cXR);
      return this;
    }
    
    public final b M(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cXO.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cXO.put(paramString1, localObject);
      }
      this.cXR = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cXR);
      return this;
    }
    
    public final d SY()
    {
      return new d(this);
    }
    
    public final b SZ()
    {
      this.cXR.cXT = true;
      return this;
    }
    
    public final b eL(String paramString)
    {
      b.checkNotNull(paramString, "threadName");
      this.cXR = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.cXP.put(paramString, this.cXR);
      return this;
    }
    
    public final b eM(String paramString)
    {
      b.checkNotNull(paramString, "mClassName");
      this.cXR = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.cXQ.put(paramString, this.cXR);
      return this;
    }
    
    public final b eN(String paramString)
    {
      this.cXR.name = paramString;
      return this;
    }
    
    public final b eO(String paramString)
    {
      this.cXR.cXS = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String cXS;
    boolean cXT;
    final String cXU;
    String name;
    
    c(String paramString)
    {
      this.cXU = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */