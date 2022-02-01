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
  public final Map<String, Map<String, e>> dbO;
  public final Map<String, Map<String, e>> dbP;
  public final Map<String, e> dbQ;
  public final Map<String, e> dbR;
  
  d(b paramb)
  {
    this.dbO = f(paramb.dbO);
    this.dbP = f(paramb.dbP);
    this.dbQ = g(paramb.dbQ);
    this.dbR = g(paramb.dbR);
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
    Iterator localIterator1 = this.dbO.entrySet().iterator();
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
        if (((e)localEntry.getValue()).dbU) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.dbP.entrySet().iterator();
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
        if (((e)localEntry.getValue()).dbU) {}
        for (localObject1 = " (always)";; localObject1 = "")
        {
          localObject2 = (String)localObject2 + "| Static field: " + (String)localObject3 + "." + (String)localEntry.getKey() + (String)localObject1 + "\n";
          break;
        }
      }
    }
    localIterator1 = this.dbQ.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).dbU) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Thread:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    localIterator1 = this.dbR.entrySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject3 = (Map.Entry)localIterator1.next();
      if (((e)((Map.Entry)localObject3).getValue()).dbU) {}
      for (localObject2 = " (always)";; localObject2 = "")
      {
        localObject1 = (String)localObject1 + "| Class:" + (String)((Map.Entry)localObject3).getKey() + (String)localObject2 + "\n";
        break;
      }
    }
    return localObject1;
  }
  
  static final class b
    implements d.a
  {
    final Map<String, Map<String, d.c>> dbO = new LinkedHashMap();
    final Map<String, Map<String, d.c>> dbP = new LinkedHashMap();
    final Map<String, d.c> dbQ = new LinkedHashMap();
    final Map<String, d.c> dbR = new LinkedHashMap();
    d.c dbS;
    
    public final b P(String paramString1, String paramString2)
    {
      b.c(paramString1, "mClassName");
      b.c(paramString2, "fieldName");
      Map localMap = (Map)this.dbO.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.dbO.put(paramString1, localObject);
      }
      this.dbS = new d.c("field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.dbS);
      return this;
    }
    
    public final b Q(String paramString1, String paramString2)
    {
      b.c(paramString1, "mClassName");
      b.c(paramString2, "fieldName");
      Map localMap = (Map)this.dbP.get(paramString1);
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new LinkedHashMap();
        this.dbP.put(paramString1, localObject);
      }
      this.dbS = new d.c("static field " + paramString1 + "#" + paramString2);
      ((Map)localObject).put(paramString2, this.dbS);
      return this;
    }
    
    public final d XB()
    {
      return new d(this);
    }
    
    public final b XC()
    {
      this.dbS.dbU = true;
      return this;
    }
    
    public final b fG(String paramString)
    {
      b.c(paramString, "threadName");
      this.dbS = new d.c("any threads named ".concat(String.valueOf(paramString)));
      this.dbQ.put(paramString, this.dbS);
      return this;
    }
    
    public final b fH(String paramString)
    {
      b.c(paramString, "mClassName");
      this.dbS = new d.c("any subclass of ".concat(String.valueOf(paramString)));
      this.dbR.put(paramString, this.dbS);
      return this;
    }
    
    public final b fI(String paramString)
    {
      this.dbS.dbT = paramString;
      return this;
    }
  }
  
  static final class c
  {
    String dbT;
    boolean dbU;
    final String dbV;
    String name;
    
    c(String paramString)
    {
      this.dbV = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.model.d
 * JD-Core Version:    0.7.0.1
 */