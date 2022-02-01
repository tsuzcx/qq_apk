package com.tencent.matrix.resource.analyzer.a;

import com.d.a.b.a;
import com.d.a.b.c;
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

public final class b
{
  private final com.tencent.matrix.resource.analyzer.model.d dcq;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> dcr;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> dcs;
  private final Set<com.d.a.b.i> dct;
  private final Set<com.d.a.b.i> dcu;
  private final Set<com.d.a.b.i> dcv;
  private boolean dcw;
  
  public b(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.dcq = paramd;
    this.dcr = new LinkedList();
    this.dcs = new LinkedList();
    this.dct = new HashSet();
    this.dcu = new HashSet();
    this.dcv = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.d.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.d.a.b.e.ay(parami1)) && (!com.d.a.b.e.ax(parami1)) && (!this.dct.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.dcu.contains(parami1))) && ((!this.dcw) || (!d(parami1))) && (!this.dcv.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.dct.add(parami1);
          this.dcr.add(parame);
          return;
        }
      }
    }
    label133:
    this.dcu.add(parami1);
    this.dcs.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (c)parami.dbY;
    Map localMap = (Map)this.dcq.dbP.get(((c)localObject1).mClassName);
    localObject1 = ((c)localObject1).KV().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.d.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.d.a.b.d)localObject2).cjW == p.clp)
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
              if (!locale.dbU) {
                a(locale, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.dck);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.dck);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.Lh().iterator();
    while (paraml.hasNext())
    {
      com.d.a.b.j localj = (com.d.a.b.j)paraml.next();
      switch (1.dcx[localj.ckI.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.ckI);
      case 1: 
        Object localObject = com.d.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.dcq.dbQ.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).dbU)) {
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
    Object localObject4 = (com.d.a.b.b)parami.dbY;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((com.d.a.b.b)localObject4).KU();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.dcq.dbR.get(((c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.dbU))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.dcq.dbO.get(((c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((c)localObject2).KW();
      break;
      if ((localObject1 != null) && (localObject1.dbU)) {
        return;
      }
      localObject3 = ((com.d.a.b.b)localObject4).getValues().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.d.a.b.b.a)((Iterator)localObject3).next();
        localObject2 = ((com.d.a.b.b.a)localObject4).cjY;
        if (((com.d.a.b.d)localObject2).cjW == p.clp)
        {
          localObject4 = (com.d.a.b.i)((com.d.a.b.b.a)localObject4).mValue;
          str = ((com.d.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).dbU) || (localObject1.dbU)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.d.a.b.i)localObject4, str, j.b.dcj);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.dbY;
    if (((a)localObject).cjW == p.clp)
    {
      localObject = ((a)localObject).KT();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.d.a.b.i)localObject[i], "[" + i + "]", j.b.dcm);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.d.a.b.i parami)
  {
    return (parami.KU() != null) && (parami.KU().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.d.a.b.i, a> a(l paraml, Collection<com.d.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.dcr.clear();
    this.dcs.clear();
    this.dct.clear();
    this.dcu.clear();
    this.dcv.clear();
    b(paraml);
    this.dcw = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.d.a.b.i)paraml.next())) {
        this.dcw = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.dcr.isEmpty()) || (!this.dcs.isEmpty())) {
      if (!this.dcr.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.dcr.poll();
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
      if (paramCollection.contains(paraml.dbY))
      {
        locali = paraml.dbY;
        if (paraml.dbX != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.dbY);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.dcv.add(paraml.dbY)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.dbY instanceof com.d.a.b.j)) {
          break label408;
        }
        localObject = (com.d.a.b.j)paraml.dbY;
        locali = ((com.d.a.b.j)localObject).Lg();
        if (((com.d.a.b.j)localObject).ckI != k.ckY) {
          break label395;
        }
        localObject = f.c((com.d.a.b.i)localObject);
        if (paraml.dbX == null) {
          break label493;
        }
      }
      for (paraml = paraml.dbX;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.d.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.dcl);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.dcs.poll();
        if (paraml.dbX != null) {
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
        if ((paraml.dbY instanceof c))
        {
          a(paraml);
          break;
        }
        if ((paraml.dbY instanceof com.d.a.b.b))
        {
          b(paraml);
          break;
        }
        if ((paraml.dbY instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.dbY);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i dcy;
    public final boolean dcz;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.dcy = parami;
      this.dcz = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.dbZ == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.dbZ.dbY;
      } while ((localObject4 instanceof com.d.a.b.j));
      j.b localb = parami.dcb;
      String str = parami.dca;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof c))
      {
        localObject1 = ((c)localObject4).KV().entrySet().iterator();
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
        if (((a)localObject1).cjW == p.clp)
        {
          localObject1 = ((a)localObject1).KT();
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
        localObject1 = ((com.d.a.b.i)localObject4).KU().KV().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.d.a.b.e.e((Map.Entry)localObject3));
        }
        localObject1 = ((com.d.a.b.b)localObject4).getValues().iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(com.d.a.b.e.a((com.d.a.b.b.a)((Iterator)localObject1).next()));
        }
      }
      if ((localObject4 instanceof c))
      {
        localObject3 = ((c)localObject4).mClassName;
        if (!(localObject4 instanceof c)) {
          break label442;
        }
        localObject1 = j.a.dcf;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.dbX, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).KU().mClassName;
          break;
        }
        localObject3 = ((com.d.a.b.i)localObject4).KU().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.dch;
        }
        else
        {
          localObject5 = ((com.d.a.b.i)localObject4).KU();
          if (com.d.a.b.e.b((c)localObject5))
          {
            localObject1 = j.a.dcg;
            localObject2 = com.d.a.b.e.a((com.d.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((c)localObject5).KW().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.dce;
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
            localObject1 = j.a.dce;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.dce;
          }
        }
      }
    }
    
    public final h XD()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.dcy, null, null); locali != null; locali = locali.dbZ)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a.b
 * JD-Core Version:    0.7.0.1
 */