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
  public final Map<String, Map<String, e>> cyC;
  public final Map<String, Map<String, e>> cyD;
  public final Map<String, e> cyE;
  public final Map<String, e> cyF;
  
  d(b paramb)
  {
    this.cyC = f(paramb.cyC);
    this.cyD = f(paramb.cyD);
    this.cyE = g(paramb.cyE);
    this.cyF = g(paramb.cyF);
  }
  
  private static Map<String, Map<String, e>> f(Map<String, Map<String, c>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), g((Map)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static Map<String, e> g(Map<String, c> paramMap)
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
    Iterator localIterator1 = this.cyC.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cyI) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cyD.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cyI) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cyE.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cyI) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.cyF.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cyI) {}
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
    public abstract d.b F(String paramString1, String paramString2);
    
    public abstract d.b G(String paramString1, String paramString2);
    
    public abstract d Hw();
    
    public abstract d.b dm(String paramString);
    
    public abstract d.b dn(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> cyC = new LinkedHashMap();
    final Map<String, Map<String, d.c>> cyD = new LinkedHashMap();
    final Map<String, d.c> cyE = new LinkedHashMap();
    final Map<String, d.c> cyF = new LinkedHashMap();
    private d.c cyG;
    
    public final b F(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cyC.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cyC.put(paramString1, localObject);
      }
      this.cyG = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cyG);
      return this;
    }
    
    public final b G(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cyD.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cyD.put(paramString1, localObject);
      }
      this.cyG = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cyG);
      return this;
    }
    
    public final d Hw()
    {
      return new d(this);
    }
    
    public final b Hx()
    {
      this.cyG.cyI = true;
      return this;
    }
    
    public final b dm(String paramString)
    {
      b.checkNotNull(paramString, "threadName");
      this.cyG = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.cyE.put(paramString, this.cyG);
      return this;
    }
    
    public final b dn(String paramString)
    {
      b.checkNotNull(paramString, "mClassName");
      this.cyG = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.cyF.put(paramString, this.cyG);
      return this;
    }
    
    public final b jdMethod_do(String paramString)
    {
      this.cyG.name = paramString;
      return this;
    }
    
    public final b dp(String paramString)
    {
      this.cyG.cyH = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String cyH;
    boolean cyI;
    final String cyJ;
    String name;
    
    c(String paramString)
    {
      this.cyJ = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */