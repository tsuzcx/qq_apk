package com.tencent.matrix.resource.analyzer.a;

import com.d.a.b.a;
import com.d.a.b.b;
import com.d.a.b.b.a;
import com.d.a.b.f;
import com.d.a.b.k;
import com.d.a.b.l;
import com.d.a.b.p;
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
  private final com.tencent.matrix.resource.analyzer.model.d czg;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> czh;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> czi;
  private final Set<com.d.a.b.i> czj;
  private final Set<com.d.a.b.i> czk;
  private final Set<com.d.a.b.i> czl;
  private boolean czm;
  
  public c(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.czg = paramd;
    this.czh = new LinkedList();
    this.czi = new LinkedList();
    this.czj = new HashSet();
    this.czk = new HashSet();
    this.czl = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.d.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.d.a.b.e.ar(parami1)) && (!com.d.a.b.e.aq(parami1)) && (!this.czj.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.czk.contains(parami1))) && ((!this.czm) || (!d(parami1))) && (!this.czl.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.czj.add(parami1);
          this.czh.add(parame);
          return;
        }
      }
    }
    label133:
    this.czk.add(parami1);
    this.czi.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (com.d.a.b.c)parami.cyN;
    Map localMap = (Map)this.czg.cyD.get(((com.d.a.b.c)localObject1).mClassName);
    localObject1 = ((com.d.a.b.c)localObject1).zY().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.d.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.d.a.b.d)localObject2).bVX == p.bXr)
      {
        localObject2 = ((com.d.a.b.d)localObject2).mName;
        if (!"$staticOverhead".equals(localObject2))
        {
          localObject3 = (com.d.a.b.i)((Map.Entry)localObject3).getValue();
          int j = 1;
          int i = j;
          if (localMap != null)
          {
            com.tencent.matrix.resource.analyzer.model.e locale = (com.tencent.matrix.resource.analyzer.model.e)localMap.get(localObject2);
            i = j;
            if (locale != null)
            {
              if (!locale.cyI) {
                a(locale, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.cza);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.cza);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.Ak().iterator();
    while (paraml.hasNext())
    {
      com.d.a.b.j localj = (com.d.a.b.j)paraml.next();
      switch (1.czn[localj.bWJ.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.bWJ);
      case 1: 
        Object localObject = com.d.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.czg.cyE.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).cyI)) {
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
    Object localObject4 = (b)parami.cyN;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((b)localObject4).zW();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.czg.cyF.get(((com.d.a.b.c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.cyI))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.czg.cyC.get(((com.d.a.b.c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((com.d.a.b.c)localObject2).zZ();
      break;
      if ((localObject1 != null) && (localObject1.cyI)) {
        return;
      }
      localObject3 = ((b)localObject4).zX().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (b.a)((Iterator)localObject3).next();
        localObject2 = ((b.a)localObject4).bVZ;
        if (((com.d.a.b.d)localObject2).bVX == p.bXr)
        {
          localObject4 = (com.d.a.b.i)((b.a)localObject4).mValue;
          str = ((com.d.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).cyI) || (localObject1.cyI)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.d.a.b.i)localObject4, str, j.b.cyZ);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.cyN;
    if (((a)localObject).bVX == p.bXr)
    {
      localObject = ((a)localObject).zV();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.d.a.b.i)localObject[i], "[" + i + "]", j.b.czc);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.d.a.b.i parami)
  {
    return (parami.zW() != null) && (parami.zW().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.d.a.b.i, a> a(l paraml, Collection<com.d.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.czh.clear();
    this.czi.clear();
    this.czj.clear();
    this.czk.clear();
    this.czl.clear();
    b(paraml);
    this.czm = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.d.a.b.i)paraml.next())) {
        this.czm = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.czh.isEmpty()) || (!this.czi.isEmpty())) {
      if (!this.czh.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.czh.poll();
      }
    }
    label199:
    label490:
    label493:
    label498:
    for (;;)
    {
      com.d.a.b.i locali;
      boolean bool;
      int i;
      Object localObject;
      if (paramCollection.contains(paraml.cyN))
      {
        locali = paraml.cyN;
        if (paraml.cyM != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.cyN);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.czl.add(paraml.cyN)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.cyN instanceof com.d.a.b.j)) {
          break label408;
        }
        localObject = (com.d.a.b.j)paraml.cyN;
        locali = ((com.d.a.b.j)localObject).Aj();
        if (((com.d.a.b.j)localObject).bWJ != k.bWZ) {
          break label395;
        }
        localObject = f.c((com.d.a.b.i)localObject);
        if (paraml.cyM == null) {
          break label493;
        }
      }
      for (paraml = paraml.cyM;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.d.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.czb);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.czi.poll();
        if (paraml.cyM != null) {
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
        if ((paraml.cyN instanceof com.d.a.b.c))
        {
          a(paraml);
          break;
        }
        if ((paraml.cyN instanceof b))
        {
          b(paraml);
          break;
        }
        if ((paraml.cyN instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.cyN);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i czo;
    public final boolean czp;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.czo = parami;
      this.czp = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.cyO == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.cyO.cyN;
      } while ((localObject4 instanceof com.d.a.b.j));
      j.b localb = parami.cyQ;
      String str = parami.cyP;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof com.d.a.b.c))
      {
        localObject1 = ((com.d.a.b.c)localObject4).zY().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (com.d.a.b.d)((Map.Entry)localObject5).getKey();
          localObject5 = ((Map.Entry)localObject5).getValue();
          localArrayList.add("static " + ((com.d.a.b.d)localObject3).mName + " = " + localObject5);
        }
      }
      if ((localObject4 instanceof a))
      {
        localObject1 = (a)localObject4;
        if (((a)localObject1).bVX == p.bXr)
        {
          localObject1 = ((a)localObject1).zV();
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
        localObject1 = ((com.d.a.b.i)localObject4).zW().zY().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.d.a.b.e.b((Map.Entry)localObject3));
        }
        localObject1 = ((b)localObject4).zX().iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(com.d.a.b.e.a((b.a)((Iterator)localObject1).next()));
        }
      }
      if ((localObject4 instanceof com.d.a.b.c))
      {
        localObject3 = ((com.d.a.b.c)localObject4).mClassName;
        if (!(localObject4 instanceof com.d.a.b.c)) {
          break label442;
        }
        localObject1 = j.a.cyV;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.cyM, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).zW().mClassName;
          break;
        }
        localObject3 = ((com.d.a.b.i)localObject4).zW().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.cyX;
        }
        else
        {
          localObject5 = ((com.d.a.b.i)localObject4).zW();
          if (com.d.a.b.e.b((com.d.a.b.c)localObject5))
          {
            localObject1 = j.a.cyW;
            localObject2 = com.d.a.b.e.a((com.d.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((com.d.a.b.c)localObject5).zZ().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.cyU;
              }
            }
            try
            {
              localObject4 = Class.forName(((com.d.a.b.c)localObject5).mClassName).getInterfaces();
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
            localObject1 = j.a.cyU;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.cyU;
          }
        }
      }
    }
    
    public final h Hy()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.czo, null, null); locali != null; locali = locali.cyO)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.c
 * JD-Core Version:    0.7.0.1
 */