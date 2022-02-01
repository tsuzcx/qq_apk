package com.tencent.matrix.resource.analyzer.a;

import com.e.a.b.a;
import com.e.a.b.b;
import com.e.a.b.b.a;
import com.e.a.b.f;
import com.e.a.b.k;
import com.e.a.b.l;
import com.e.a.b.p;
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
  private final com.tencent.matrix.resource.analyzer.model.d cHT;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cHU;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cHV;
  private final Set<com.e.a.b.i> cHW;
  private final Set<com.e.a.b.i> cHX;
  private final Set<com.e.a.b.i> cHY;
  private boolean cHZ;
  
  public c(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.cHT = paramd;
    this.cHU = new LinkedList();
    this.cHV = new LinkedList();
    this.cHW = new HashSet();
    this.cHX = new HashSet();
    this.cHY = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.e.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.e.a.b.e.au(parami1)) && (!com.e.a.b.e.at(parami1)) && (!this.cHW.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.cHX.contains(parami1))) && ((!this.cHZ) || (!d(parami1))) && (!this.cHY.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.cHW.add(parami1);
          this.cHU.add(parame);
          return;
        }
      }
    }
    label133:
    this.cHX.add(parami1);
    this.cHV.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (com.e.a.b.c)parami.cHA;
    Map localMap = (Map)this.cHT.cHq.get(((com.e.a.b.c)localObject1).mClassName);
    localObject1 = ((com.e.a.b.c)localObject1).Bj().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.e.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.e.a.b.d)localObject2).cdS == p.cfn)
      {
        localObject2 = ((com.e.a.b.d)localObject2).mName;
        if (!"$staticOverhead".equals(localObject2))
        {
          localObject3 = (com.e.a.b.i)((Map.Entry)localObject3).getValue();
          int j = 1;
          int i = j;
          if (localMap != null)
          {
            com.tencent.matrix.resource.analyzer.model.e locale = (com.tencent.matrix.resource.analyzer.model.e)localMap.get(localObject2);
            i = j;
            if (locale != null)
            {
              if (!locale.cHv) {
                a(locale, parami, (com.e.a.b.i)localObject3, (String)localObject2, j.b.cHN);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.e.a.b.i)localObject3, (String)localObject2, j.b.cHN);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.Bv().iterator();
    while (paraml.hasNext())
    {
      com.e.a.b.j localj = (com.e.a.b.j)paraml.next();
      switch (1.cIa[localj.ceE.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.ceE);
      case 1: 
        Object localObject = com.e.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.cHT.cHr.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).cHv)) {
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
    Object localObject4 = (b)parami.cHA;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((b)localObject4).Bh();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.cHT.cHs.get(((com.e.a.b.c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.cHv))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.cHT.cHp.get(((com.e.a.b.c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((com.e.a.b.c)localObject2).Bk();
      break;
      if ((localObject1 != null) && (localObject1.cHv)) {
        return;
      }
      localObject3 = ((b)localObject4).Bi().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (b.a)((Iterator)localObject3).next();
        localObject2 = ((b.a)localObject4).cdU;
        if (((com.e.a.b.d)localObject2).cdS == p.cfn)
        {
          localObject4 = (com.e.a.b.i)((b.a)localObject4).mValue;
          str = ((com.e.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).cHv) || (localObject1.cHv)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.e.a.b.i)localObject4, str, j.b.cHM);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.cHA;
    if (((a)localObject).cdS == p.cfn)
    {
      localObject = ((a)localObject).Bg();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.e.a.b.i)localObject[i], "[" + i + "]", j.b.cHP);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.e.a.b.i parami)
  {
    return (parami.Bh() != null) && (parami.Bh().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.e.a.b.i, a> a(l paraml, Collection<com.e.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.cHU.clear();
    this.cHV.clear();
    this.cHW.clear();
    this.cHX.clear();
    this.cHY.clear();
    b(paraml);
    this.cHZ = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.e.a.b.i)paraml.next())) {
        this.cHZ = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.cHU.isEmpty()) || (!this.cHV.isEmpty())) {
      if (!this.cHU.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cHU.poll();
      }
    }
    label199:
    label490:
    label493:
    label498:
    for (;;)
    {
      com.e.a.b.i locali;
      boolean bool;
      int i;
      Object localObject;
      if (paramCollection.contains(paraml.cHA))
      {
        locali = paraml.cHA;
        if (paraml.cHz != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.cHA);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.cHY.add(paraml.cHA)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.cHA instanceof com.e.a.b.j)) {
          break label408;
        }
        localObject = (com.e.a.b.j)paraml.cHA;
        locali = ((com.e.a.b.j)localObject).Bu();
        if (((com.e.a.b.j)localObject).ceE != k.ceU) {
          break label395;
        }
        localObject = f.c((com.e.a.b.i)localObject);
        if (paraml.cHz == null) {
          break label493;
        }
      }
      for (paraml = paraml.cHz;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.e.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.cHO);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cHV.poll();
        if (paraml.cHz != null) {
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
        if ((paraml.cHA instanceof com.e.a.b.c))
        {
          a(paraml);
          break;
        }
        if ((paraml.cHA instanceof b))
        {
          b(paraml);
          break;
        }
        if ((paraml.cHA instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.cHA);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i cIb;
    public final boolean cIc;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.cIb = parami;
      this.cIc = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.cHB == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.cHB.cHA;
      } while ((localObject4 instanceof com.e.a.b.j));
      j.b localb = parami.cHD;
      String str = parami.cHC;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof com.e.a.b.c))
      {
        localObject1 = ((com.e.a.b.c)localObject4).Bj().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = (com.e.a.b.d)((Map.Entry)localObject5).getKey();
          localObject5 = ((Map.Entry)localObject5).getValue();
          localArrayList.add("static " + ((com.e.a.b.d)localObject3).mName + " = " + localObject5);
        }
      }
      if ((localObject4 instanceof a))
      {
        localObject1 = (a)localObject4;
        if (((a)localObject1).cdS == p.cfn)
        {
          localObject1 = ((a)localObject1).Bg();
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
        localObject1 = ((com.e.a.b.i)localObject4).Bh().Bj().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.e.a.b.e.b((Map.Entry)localObject3));
        }
        localObject1 = ((b)localObject4).Bi().iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(com.e.a.b.e.a((b.a)((Iterator)localObject1).next()));
        }
      }
      if ((localObject4 instanceof com.e.a.b.c))
      {
        localObject3 = ((com.e.a.b.c)localObject4).mClassName;
        if (!(localObject4 instanceof com.e.a.b.c)) {
          break label442;
        }
        localObject1 = j.a.cHI;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.cHz, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).Bh().mClassName;
          break;
        }
        localObject3 = ((com.e.a.b.i)localObject4).Bh().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.cHK;
        }
        else
        {
          localObject5 = ((com.e.a.b.i)localObject4).Bh();
          if (com.e.a.b.e.b((com.e.a.b.c)localObject5))
          {
            localObject1 = j.a.cHJ;
            localObject2 = com.e.a.b.e.a((com.e.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((com.e.a.b.c)localObject5).Bk().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.cHH;
              }
            }
            try
            {
              localObject4 = Class.forName(((com.e.a.b.c)localObject5).mClassName).getInterfaces();
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
            localObject1 = j.a.cHH;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.cHH;
          }
        }
      }
    }
    
    public final h IM()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.cIb, null, null); locali != null; locali = locali.cHB)
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