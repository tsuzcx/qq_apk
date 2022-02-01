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
  public final Map<String, Map<String, e>> cGG;
  public final Map<String, Map<String, e>> cGH;
  public final Map<String, e> cGI;
  public final Map<String, e> cGJ;
  
  d(b paramb)
  {
    this.cGG = e(paramb.cGG);
    this.cGH = e(paramb.cGH);
    this.cGI = f(paramb.cGI);
    this.cGJ = f(paramb.cGJ);
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
    Iterator localIterator1 = this.cGG.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cGM) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cGH.entrySet().iterator();
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
        if (((e)localEntry.getValue()).cGM) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.cGI.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cGM) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.cGJ.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).cGM) {}
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
    
    public abstract d IC();
    
    public abstract d.b J(String paramString1, String paramString2);
    
    public abstract d.b dW(String paramString);
    
    public abstract d.b dX(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> cGG = new LinkedHashMap();
    final Map<String, Map<String, d.c>> cGH = new LinkedHashMap();
    final Map<String, d.c> cGI = new LinkedHashMap();
    final Map<String, d.c> cGJ = new LinkedHashMap();
    private d.c cGK;
    
    public final b H(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cGG.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cGG.put(paramString1, localObject);
      }
      this.cGK = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cGK);
      return this;
    }
    
    public final d IC()
    {
      return new d(this);
    }
    
    public final b ID()
    {
      this.cGK.cGM = true;
      return this;
    }
    
    public final b J(String paramString1, String paramString2)
    {
      b.checkNotNull(paramString1, "mClassName");
      b.checkNotNull(paramString2, "fieldName");
      Map localMap = (Map)this.cGH.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.cGH.put(paramString1, localObject);
      }
      this.cGK = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.cGK);
      return this;
    }
    
    public final b dW(String paramString)
    {
      b.checkNotNull(paramString, "threadName");
      this.cGK = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.cGI.put(paramString, this.cGK);
      return this;
    }
    
    public final b dX(String paramString)
    {
      b.checkNotNull(paramString, "mClassName");
      this.cGK = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.cGJ.put(paramString, this.cGK);
      return this;
    }
    
    public final b dY(String paramString)
    {
      this.cGK.name = paramString;
      return this;
    }
    
    public final b dZ(String paramString)
    {
      this.cGK.cGL = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String cGL;
    boolean cGM;
    final String cGN;
    String name;
    
    c(String paramString)
    {
      this.cGN = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */