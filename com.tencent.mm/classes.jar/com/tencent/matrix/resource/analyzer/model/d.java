package com.tencent.matrix.resource.analyzer.model;

import com.tencent.matrix.resource.a.a.b;
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
  public final Map<String, Map<String, e>> fan;
  public final Map<String, Map<String, e>> fao;
  public final Map<String, e> fap;
  public final Map<String, e> faq;
  
  d(b paramb)
  {
    this.fan = m(paramb.fan);
    this.fao = m(paramb.fao);
    this.fap = n(paramb.fap);
    this.faq = n(paramb.faq);
  }
  
  private static Map<String, Map<String, e>> m(Map<String, Map<String, c>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), n((Map)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static Map<String, e> n(Map<String, c> paramMap)
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
    Iterator localIterator1 = this.fan.entrySet().iterator();
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
        if (((e)localEntry.getValue()).fat) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.fao.entrySet().iterator();
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
        if (((e)localEntry.getValue()).fat) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.fap.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).fat) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.faq.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).fat) {}
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
    public abstract d.b T(String paramString1, String paramString2);
    
    public abstract d.b U(String paramString1, String paramString2);
    
    public abstract d azh();
    
    public abstract d.b hj(String paramString);
    
    public abstract d.b hk(String paramString);
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> fan = new LinkedHashMap();
    final Map<String, Map<String, d.c>> fao = new LinkedHashMap();
    final Map<String, d.c> fap = new LinkedHashMap();
    final Map<String, d.c> faq = new LinkedHashMap();
    d.c far;
    
    public final b T(String paramString1, String paramString2)
    {
      b.c(paramString1, "mClassName");
      b.c(paramString2, "fieldName");
      Map localMap = (Map)this.fan.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.fan.put(paramString1, localObject);
      }
      this.far = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.far);
      return this;
    }
    
    public final b U(String paramString1, String paramString2)
    {
      b.c(paramString1, "mClassName");
      b.c(paramString2, "fieldName");
      Map localMap = (Map)this.fao.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.fao.put(paramString1, localObject);
      }
      this.far = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.far);
      return this;
    }
    
    public final d azh()
    {
      return new d(this);
    }
    
    public final b azi()
    {
      this.far.fat = true;
      return this;
    }
    
    public final b hj(String paramString)
    {
      b.c(paramString, "threadName");
      this.far = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.fap.put(paramString, this.far);
      return this;
    }
    
    public final b hk(String paramString)
    {
      b.c(paramString, "mClassName");
      this.far = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.faq.put(paramString, this.far);
      return this;
    }
    
    public final b hl(String paramString)
    {
      this.far.fas = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String fas;
    boolean fat;
    final String fau;
    String name;
    
    c(String paramString)
    {
      this.fau = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */