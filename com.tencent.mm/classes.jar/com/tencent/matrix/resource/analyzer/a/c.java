package com.tencent.matrix.resource.analyzer.a;

import com.c.a.b.a;
import com.c.a.b.b;
import com.c.a.b.b.a;
import com.c.a.b.f;
import com.c.a.b.k;
import com.c.a.b.l;
import com.c.a.b.p;
import com.tencent.matrix.resource.analyzer.model.h;
import com.tencent.matrix.resource.analyzer.model.j.a;
import com.tencent.matrix.resource.analyzer.model.j.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class c
{
  private final com.tencent.matrix.resource.analyzer.model.d cYq;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cYr;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cYs;
  private final Set<com.c.a.b.i> cYt;
  private final Set<com.c.a.b.i> cYu;
  private final Set<com.c.a.b.i> cYv;
  private boolean cYw;
  
  public c(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.cYq = paramd;
    this.cYr = new LinkedList();
    this.cYs = new LinkedList();
    this.cYt = new HashSet();
    this.cYu = new HashSet();
    this.cYv = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.c.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.c.a.b.e.aC(parami1)) && (!com.c.a.b.e.aB(parami1)) && (!this.cYt.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.cYu.contains(parami1))) && ((!this.cYw) || (!d(parami1))) && (!this.cYv.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.cYt.add(parami1);
          this.cYr.add(parame);
          return;
        }
      }
    }
    label133:
    this.cYu.add(parami1);
    this.cYs.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (com.c.a.b.c)parami.cXY;
    Map localMap = (Map)this.cYq.cXO.get(((com.c.a.b.c)localObject1).mClassName);
    localObject1 = ((com.c.a.b.c)localObject1).Kc().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.c.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.c.a.b.d)localObject2).cow == p.cpP)
      {
        localObject2 = ((com.c.a.b.d)localObject2).mName;
        if (!"$staticOverhead".equals(localObject2))
        {
          localObject3 = (com.c.a.b.i)((Map.Entry)localObject3).getValue();
          int j = 1;
          int i = j;
          if (localMap != null)
          {
            com.tencent.matrix.resource.analyzer.model.e locale = (com.tencent.matrix.resource.analyzer.model.e)localMap.get(localObject2);
            i = j;
            if (locale != null)
            {
              if (!locale.cXT) {
                a(locale, parami, (com.c.a.b.i)localObject3, (String)localObject2, j.b.cYk);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.c.a.b.i)localObject3, (String)localObject2, j.b.cYk);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.Kn().iterator();
    while (paraml.hasNext())
    {
      com.c.a.b.j localj = (com.c.a.b.j)paraml.next();
      switch (1.cYx[localj.cpi.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.cpi);
      case 1: 
        Object localObject = com.c.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.cYq.cXP.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).cXT)) {
          a((com.tencent.matrix.resource.analyzer.model.e)localObject, null, localj, null, null);
        }
        break;
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
        a(null, null, localj, null, null);
      }
    }
  }
  
  private void b(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject4 = (b)parami.cXY;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((b)localObject4).Ka();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.cYq.cXQ.get(((com.c.a.b.c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.cXT))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.cYq.cXN.get(((com.c.a.b.c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((com.c.a.b.c)localObject2).Kd();
      break;
      if ((localObject1 != null) && (localObject1.cXT)) {
        return;
      }
      localObject3 = ((b)localObject4).Kb().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (b.a)((Iterator)localObject3).next();
        localObject2 = ((b.a)localObject4).coy;
        if (((com.c.a.b.d)localObject2).cow == p.cpP)
        {
          localObject4 = (com.c.a.b.i)((b.a)localObject4).mValue;
          str = ((com.c.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).cXT) || (localObject1.cXT)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.c.a.b.i)localObject4, str, j.b.cYj);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.cXY;
    if (((a)localObject).cow == p.cpP)
    {
      localObject = ((a)localObject).JZ();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.c.a.b.i)localObject[i], "[" + i + "]", j.b.cYm);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.c.a.b.i parami)
  {
    return (parami.Ka() != null) && (parami.Ka().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.c.a.b.i, a> a(l paraml, Collection<com.c.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.cYr.clear();
    this.cYs.clear();
    this.cYt.clear();
    this.cYu.clear();
    this.cYv.clear();
    b(paraml);
    this.cYw = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.c.a.b.i)paraml.next())) {
        this.cYw = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.cYr.isEmpty()) || (!this.cYs.isEmpty())) {
      if (!this.cYr.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cYr.poll();
      }
    }
    label199:
    label490:
    label493:
    label498:
    for (;;)
    {
      com.c.a.b.i locali;
      boolean bool;
      int i;
      Object localObject;
      if (paramCollection.contains(paraml.cXY))
      {
        locali = paraml.cXY;
        if (paraml.cXX != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.cXY);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.cYv.add(paraml.cXY)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.cXY instanceof com.c.a.b.j)) {
          break label408;
        }
        localObject = (com.c.a.b.j)paraml.cXY;
        locali = ((com.c.a.b.j)localObject).Km();
        if (((com.c.a.b.j)localObject).cpi != k.cpy) {
          break label395;
        }
        localObject = f.c((com.c.a.b.i)localObject);
        if (paraml.cXX == null) {
          break label493;
        }
      }
      for (paraml = paraml.cXX;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.c.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.cYl);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cYs.poll();
        if (paraml.cXX != null) {
          break label498;
        }
        throw new IllegalStateException("Expected node to have an exclusion ".concat(String.valueOf(paraml)));
        bool = false;
        break label199;
        i = 0;
        break label257;
        break;
        a(null, paraml, locali, null, null);
        break;
        if ((paraml.cXY instanceof com.c.a.b.c))
        {
          a(paraml);
          break;
        }
        if ((paraml.cXY instanceof b))
        {
          b(paraml);
          break;
        }
        if ((paraml.cXY instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.cXY);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i cYy;
    public final boolean cYz;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.cYy = parami;
      this.cYz = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.cXZ == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.cXZ.cXY;
      } while ((localObject4 instanceof com.c.a.b.j));
      j.b localb = parami.cYb;
      String str = parami.cYa;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof com.c.a.b.c))
      {
        localObject1 = ((com.c.a.b.c)localObject4).Kc().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (com.c.a.b.d)((Map.Entry)localObject5).getKey();
          localObject5 = ((Map.Entry)localObject5).getValue();
          localArrayList.add("static " + ((com.c.a.b.d)localObject3).mName + " = " + localObject5);
        }
      }
      if ((localObject4 instanceof a))
      {
        localObject1 = (a)localObject4;
        if (((a)localObject1).cow == p.cpP)
        {
          localObject1 = ((a)localObject1).JZ();
          int i = 0;
          while (i < localObject1.length)
          {
            localArrayList.add("[" + i + "] = " + localObject1[i]);
            i += 1;
          }
        }
      }
      else
      {
        localObject1 = ((com.c.a.b.i)localObject4).Ka().Kc().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.c.a.b.e.d((Map.Entry)localObject3));
        }
        localObject1 = ((b)localObject4).Kb().iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(com.c.a.b.e.a((b.a)((Iterator)localObject1).next()));
        }
      }
      if ((localObject4 instanceof com.c.a.b.c))
      {
        localObject3 = ((com.c.a.b.c)localObject4).mClassName;
        if (!(localObject4 instanceof com.c.a.b.c)) {
          break label442;
        }
        localObject1 = j.a.cYf;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.cXX, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).Ka().mClassName;
          break;
        }
        localObject3 = ((com.c.a.b.i)localObject4).Ka().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.cYh;
        }
        else
        {
          localObject5 = ((com.c.a.b.i)localObject4).Ka();
          if (com.c.a.b.e.b((com.c.a.b.c)localObject5))
          {
            localObject1 = j.a.cYg;
            localObject2 = com.c.a.b.e.a((com.c.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((com.c.a.b.c)localObject5).Kd().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.cYe;
              }
            }
            try
            {
              localObject4 = Class.forName(((com.c.a.b.c)localObject5).mClassName).getInterfaces();
              if (localObject4.length > 0)
              {
                localObject4 = localObject4[0];
                localObject4 = "(anonymous implementation of " + ((Class)localObject4).getName() + ")";
                localObject2 = localObject4;
                continue;
              }
              localObject2 = "(anonymous subclass of java.lang.Object)";
            }
            catch (ClassNotFoundException localClassNotFoundException) {}
            localObject1 = j.a.cYe;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.cYe;
          }
        }
      }
    }
    
    public final h Ta()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.cYy, null, null); locali != null; locali = locali.cXZ)
      {
        com.tencent.matrix.resource.analyzer.model.j localj = d(locali);
        if (localj != null) {
          localArrayList.add(0, localj);
        }
      }
      return new h(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.c
 * JD-Core Version:    0.7.0.1
 */