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
  public final Map<String, Map<String, e>> cvL;
  public final Map<String, Map<String, e>> cvM;
  public final Map<String, e> cvN;
  public final Map<String, e> cvO;
  
  d(b paramb)
  {
    this.cvL = e(paramb.cvL);
    this.cvM = e(paramb.cvM);
    this.cvN = f(paramb.cvN);
    this.cvO = f(paramb.cvO);
  }
  
  private static Map<String, Map<String, e>> e(Map<String, Map<String, c>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), f((Map)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static Map<String, e> f(Map<String, c> paramMap)
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
    Iterator localIterator1 = this.cvL.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cvR) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cvM.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cvR) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cvN.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cvR) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.cvO.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cvR) {}
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
    public abstract d.b G(String paramString1, String paramString2);
    
    public abstract d.b H(String paramString1, String paramString2);
    
    public abstract d Hh();
    
    public abstract d.b cT(String paramString);
    
    public abstract d.b cU(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> cvL = new LinkedHashMap();
    final Map<String, Map<String, d.c>> cvM = new LinkedHashMap();
    final Map<String, d.c> cvN = new LinkedHashMap();
    final Map<String, d.c> cvO = new LinkedHashMap();
    private d.c cvP;
    
    public final b G(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cvL.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cvL.put(paramString1, localObject);
      }
      this.cvP = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cvP);
      return this;
    }
    
    public final b H(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cvM.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cvM.put(paramString1, localObject);
      }
      this.cvP = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cvP);
      return this;
    }
    
    public final d Hh()
    {
      return new d(this);
    }
    
    public final b Hi()
    {
      this.cvP.cvR = true;
      return this;
    }
    
    public final b cT(String paramString)
    {
      b.checkNotNull(paramString, "threadName");
      this.cvP = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.cvN.put(paramString, this.cvP);
      return this;
    }
    
    public final b cU(String paramString)
    {
      b.checkNotNull(paramString, "mClassName");
      this.cvP = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.cvO.put(paramString, this.cvP);
      return this;
    }
    
    public final b cV(String paramString)
    {
      this.cvP.name = paramString;
      return this;
    }
    
    public final b cW(String paramString)
    {
      this.cvP.cvQ = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String cvQ;
    boolean cvR;
    final String cvS;
    String name;
    
    c(String paramString)
    {
      this.cvS = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */