package com.tencent.matrix.resource.analyzer.a;

import com.h.a.b.a;
import com.h.a.b.c;
import com.h.a.b.f;
import com.h.a.b.k;
import com.h.a.b.l;
import com.h.a.b.p;
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

public final class b
{
  private final com.tencent.matrix.resource.analyzer.model.d faQ;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> faR;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> faS;
  private final Set<com.h.a.b.i> faT;
  private final Set<com.h.a.b.i> faU;
  private final Set<com.h.a.b.i> faV;
  private boolean faW;
  
  public b(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.faQ = paramd;
    this.faR = new LinkedList();
    this.faS = new LinkedList();
    this.faT = new HashSet();
    this.faU = new HashSet();
    this.faV = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.h.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.h.a.b.e.bT(parami1)) && (!com.h.a.b.e.bS(parami1)) && (!this.faT.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.faU.contains(parami1))) && ((!this.faW) || (!d(parami1))) && (!this.faV.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.faT.add(parami1);
          this.faR.add(parame);
          return;
        }
      }
    }
    label133:
    this.faU.add(parami1);
    this.faS.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (c)parami.fay;
    Map localMap = (Map)this.faQ.fao.get(((c)localObject1).mClassName);
    localObject1 = ((c)localObject1).akW().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.h.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.h.a.b.d)localObject2).ear == p.ebK)
      {
        localObject2 = ((com.h.a.b.d)localObject2).mName;
        if (!"$staticOverhead".equals(localObject2))
        {
          localObject3 = (com.h.a.b.i)((Map.Entry)localObject3).getValue();
          int j = 1;
          int i = j;
          if (localMap != null)
          {
            com.tencent.matrix.resource.analyzer.model.e locale = (com.tencent.matrix.resource.analyzer.model.e)localMap.get(localObject2);
            i = j;
            if (locale != null)
            {
              if (!locale.fat) {
                a(locale, parami, (com.h.a.b.i)localObject3, (String)localObject2, j.b.faK);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.h.a.b.i)localObject3, (String)localObject2, j.b.faK);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.ali().iterator();
    while (paraml.hasNext())
    {
      com.h.a.b.j localj = (com.h.a.b.j)paraml.next();
      switch (1.faX[localj.ebd.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.ebd);
      case 1: 
        Object localObject = com.h.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.faQ.fap.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).fat)) {
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
    Object localObject4 = (com.h.a.b.b)parami.fay;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((com.h.a.b.b)localObject4).akV();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.faQ.faq.get(((c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.fat))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.faQ.fan.get(((c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((c)localObject2).akX();
      break;
      if ((localObject1 != null) && (localObject1.fat)) {
        return;
      }
      localObject3 = ((com.h.a.b.b)localObject4).getValues().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.h.a.b.b.a)((Iterator)localObject3).next();
        localObject2 = ((com.h.a.b.b.a)localObject4).eat;
        if (((com.h.a.b.d)localObject2).ear == p.ebK)
        {
          localObject4 = (com.h.a.b.i)((com.h.a.b.b.a)localObject4).mValue;
          str = ((com.h.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).fat) || (localObject1.fat)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.h.a.b.i)localObject4, str, j.b.faJ);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.fay;
    if (((a)localObject).ear == p.ebK)
    {
      localObject = ((a)localObject).akU();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.h.a.b.i)localObject[i], "[" + i + "]", j.b.faM);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.h.a.b.i parami)
  {
    return (parami.akV() != null) && (parami.akV().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.h.a.b.i, a> a(l paraml, Collection<com.h.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.faR.clear();
    this.faS.clear();
    this.faT.clear();
    this.faU.clear();
    this.faV.clear();
    b(paraml);
    this.faW = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.h.a.b.i)paraml.next())) {
        this.faW = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.faR.isEmpty()) || (!this.faS.isEmpty())) {
      if (!this.faR.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.faR.poll();
      }
    }
    label199:
    label490:
    label493:
    label498:
    for (;;)
    {
      com.h.a.b.i locali;
      boolean bool;
      int i;
      Object localObject;
      if (paramCollection.contains(paraml.fay))
      {
        locali = paraml.fay;
        if (paraml.fax != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.fay);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.faV.add(paraml.fay)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.fay instanceof com.h.a.b.j)) {
          break label408;
        }
        localObject = (com.h.a.b.j)paraml.fay;
        locali = ((com.h.a.b.j)localObject).alh();
        if (((com.h.a.b.j)localObject).ebd != k.ebt) {
          break label395;
        }
        localObject = f.c((com.h.a.b.i)localObject);
        if (paraml.fax == null) {
          break label493;
        }
      }
      for (paraml = paraml.fax;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.h.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.faL);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.faS.poll();
        if (paraml.fax != null) {
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
        if ((paraml.fay instanceof c))
        {
          a(paraml);
          break;
        }
        if ((paraml.fay instanceof com.h.a.b.b))
        {
          b(paraml);
          break;
        }
        if ((paraml.fay instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.fay);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i faY;
    public final boolean faZ;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.faY = parami;
      this.faZ = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.faz == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.faz.fay;
      } while ((localObject4 instanceof com.h.a.b.j));
      j.b localb = parami.faB;
      String str = parami.faA;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof c))
      {
        localObject1 = ((c)localObject4).akW().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (com.h.a.b.d)((Map.Entry)localObject5).getKey();
          localObject5 = ((Map.Entry)localObject5).getValue();
          localArrayList.add("static " + ((com.h.a.b.d)localObject3).mName + " = " + localObject5);
        }
      }
      if ((localObject4 instanceof a))
      {
        localObject1 = (a)localObject4;
        if (((a)localObject1).ear == p.ebK)
        {
          localObject1 = ((a)localObject1).akU();
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
        localObject1 = ((com.h.a.b.i)localObject4).akV().akW().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.h.a.b.e.i((Map.Entry)localObject3));
        }
        localObject1 = ((com.h.a.b.b)localObject4).getValues().iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(com.h.a.b.e.a((com.h.a.b.b.a)((Iterator)localObject1).next()));
        }
      }
      if ((localObject4 instanceof c))
      {
        localObject3 = ((c)localObject4).mClassName;
        if (!(localObject4 instanceof c)) {
          break label442;
        }
        localObject1 = j.a.faF;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.fax, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).akV().mClassName;
          break;
        }
        localObject3 = ((com.h.a.b.i)localObject4).akV().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.faH;
        }
        else
        {
          localObject5 = ((com.h.a.b.i)localObject4).akV();
          if (com.h.a.b.e.b((c)localObject5))
          {
            localObject1 = j.a.faG;
            localObject2 = com.h.a.b.e.a((com.h.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((c)localObject5).akX().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.faE;
              }
            }
            try
            {
              localObject4 = Class.forName(((c)localObject5).mClassName).getInterfaces();
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
            localObject1 = j.a.faE;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.faE;
          }
        }
      }
    }
    
    public final h azj()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.faY, null, null); locali != null; locali = locali.faz)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.b
 * JD-Core Version:    0.7.0.1
 */