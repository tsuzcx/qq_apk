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
  private final com.tencent.matrix.resource.analyzer.model.d cwp;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cwq;
  private final Queue<com.tencent.matrix.resource.analyzer.model.i> cwr;
  private final Set<com.d.a.b.i> cws;
  private final Set<com.d.a.b.i> cwt;
  private final Set<com.d.a.b.i> cwu;
  private boolean cwv;
  
  public c(com.tencent.matrix.resource.analyzer.model.d paramd)
  {
    this.cwp = paramd;
    this.cwq = new LinkedList();
    this.cwr = new LinkedList();
    this.cws = new HashSet();
    this.cwt = new HashSet();
    this.cwu = new HashSet();
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.e parame, com.tencent.matrix.resource.analyzer.model.i parami, com.d.a.b.i parami1, String paramString, j.b paramb)
  {
    if (parami1 == null) {}
    for (;;)
    {
      return;
      if ((!com.d.a.b.e.ar(parami1)) && (!com.d.a.b.e.aq(parami1)) && (!this.cws.contains(parami1)))
      {
        if (parame == null) {}
        for (int i = 1; ((i != 0) || (!this.cwt.contains(parami1))) && ((!this.cwv) || (!d(parami1))) && (!this.cwu.contains(parami1)); i = 0)
        {
          parame = new com.tencent.matrix.resource.analyzer.model.i(parame, parami1, parami, paramString, paramb);
          if (i == 0) {
            break label133;
          }
          this.cws.add(parami1);
          this.cwq.add(parame);
          return;
        }
      }
    }
    label133:
    this.cwt.add(parami1);
    this.cwr.add(parame);
  }
  
  private void a(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject1 = (com.d.a.b.c)parami.cvW;
    Map localMap = (Map)this.cwp.cvM.get(((com.d.a.b.c)localObject1).mClassName);
    localObject1 = ((com.d.a.b.c)localObject1).zL().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = (com.d.a.b.d)((Map.Entry)localObject3).getKey();
      if (((com.d.a.b.d)localObject2).bTF == p.bUZ)
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
              if (!locale.cvR) {
                a(locale, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.cwj);
              }
              i = 0;
            }
          }
          if (i != 0) {
            a(null, parami, (com.d.a.b.i)localObject3, (String)localObject2, j.b.cwj);
          }
        }
      }
    }
  }
  
  private void b(l paraml)
  {
    paraml = paraml.zX().iterator();
    while (paraml.hasNext())
    {
      com.d.a.b.j localj = (com.d.a.b.j)paraml.next();
      switch (1.cww[localj.bUr.ordinal()])
      {
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        throw new UnsupportedOperationException("Unknown root type:" + localj.bUr);
      case 1: 
        Object localObject = com.d.a.b.e.a(f.c(localj));
        localObject = (com.tencent.matrix.resource.analyzer.model.e)this.cwp.cvN.get(localObject);
        if ((localObject == null) || (!((com.tencent.matrix.resource.analyzer.model.e)localObject).cvR)) {
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
    Object localObject4 = (b)parami.cvW;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((b)localObject4).zJ();
    Object localObject1 = null;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = (com.tencent.matrix.resource.analyzer.model.e)this.cwp.cvO.get(((com.d.a.b.c)localObject2).mClassName);
      if ((localObject3 == null) || ((localObject1 != null) && (localObject1.cvR))) {
        break label247;
      }
      localObject1 = localObject3;
    }
    label137:
    label242:
    label247:
    for (;;)
    {
      localObject3 = (Map)this.cwp.cvL.get(((com.d.a.b.c)localObject2).mClassName);
      if (localObject3 != null) {
        localLinkedHashMap.putAll((Map)localObject3);
      }
      localObject2 = ((com.d.a.b.c)localObject2).zM();
      break;
      if ((localObject1 != null) && (localObject1.cvR)) {
        return;
      }
      localObject3 = ((b)localObject4).zK().iterator();
      String str;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (b.a)((Iterator)localObject3).next();
        localObject2 = ((b.a)localObject4).bTH;
        if (((com.d.a.b.d)localObject2).bTF == p.bUZ)
        {
          localObject4 = (com.d.a.b.i)((b.a)localObject4).mValue;
          str = ((com.d.a.b.d)localObject2).mName;
          localObject2 = (com.tencent.matrix.resource.analyzer.model.e)localLinkedHashMap.get(str);
          if ((localObject2 == null) || ((localObject1 != null) && ((!((com.tencent.matrix.resource.analyzer.model.e)localObject2).cvR) || (localObject1.cvR)))) {
            break label242;
          }
        }
      }
      for (;;)
      {
        a((com.tencent.matrix.resource.analyzer.model.e)localObject2, parami, (com.d.a.b.i)localObject4, str, j.b.cwi);
        break label137;
        break;
        localObject2 = localObject1;
      }
    }
  }
  
  private void c(com.tencent.matrix.resource.analyzer.model.i parami)
  {
    Object localObject = (a)parami.cvW;
    if (((a)localObject).bTF == p.bUZ)
    {
      localObject = ((a)localObject).zI();
      int i = 0;
      while (i < localObject.length)
      {
        a(null, parami, (com.d.a.b.i)localObject[i], "[" + i + "]", j.b.cwl);
        i += 1;
      }
    }
  }
  
  private static boolean d(com.d.a.b.i parami)
  {
    return (parami.zJ() != null) && (parami.zJ().mClassName.equals(String.class.getName()));
  }
  
  public final Map<com.d.a.b.i, a> a(l paraml, Collection<com.d.a.b.i> paramCollection)
  {
    HashMap localHashMap = new HashMap();
    if (paramCollection.isEmpty()) {
      return localHashMap;
    }
    this.cwq.clear();
    this.cwr.clear();
    this.cws.clear();
    this.cwt.clear();
    this.cwu.clear();
    b(paraml);
    this.cwv = true;
    paraml = paramCollection.iterator();
    while (paraml.hasNext()) {
      if (d((com.d.a.b.i)paraml.next())) {
        this.cwv = false;
      }
    }
    paramCollection = new HashSet(paramCollection);
    if ((!this.cwq.isEmpty()) || (!this.cwr.isEmpty())) {
      if (!this.cwq.isEmpty()) {
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cwq.poll();
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
      if (paramCollection.contains(paraml.cvW))
      {
        locali = paraml.cvW;
        if (paraml.cvV != null)
        {
          bool = true;
          localHashMap.put(locali, new a(paraml, bool));
          paramCollection.remove(paraml.cvW);
          if (paramCollection.isEmpty()) {
            break label490;
          }
        }
      }
      else
      {
        if (this.cwu.add(paraml.cvW)) {
          break label390;
        }
        i = 1;
        if (i != 0) {
          break label393;
        }
        if (!(paraml.cvW instanceof com.d.a.b.j)) {
          break label408;
        }
        localObject = (com.d.a.b.j)paraml.cvW;
        locali = ((com.d.a.b.j)localObject).zW();
        if (((com.d.a.b.j)localObject).bUr != k.bUH) {
          break label395;
        }
        localObject = f.c((com.d.a.b.i)localObject);
        if (paraml.cvV == null) {
          break label493;
        }
      }
      for (paraml = paraml.cvV;; paraml = null)
      {
        a(paraml, new com.tencent.matrix.resource.analyzer.model.i(null, (com.d.a.b.i)localObject, null, null, null), locali, "<Java Local>", j.b.cwk);
        break;
        paraml = (com.tencent.matrix.resource.analyzer.model.i)this.cwr.poll();
        if (paraml.cvV != null) {
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
        if ((paraml.cvW instanceof com.d.a.b.c))
        {
          a(paraml);
          break;
        }
        if ((paraml.cvW instanceof b))
        {
          b(paraml);
          break;
        }
        if ((paraml.cvW instanceof a))
        {
          c(paraml);
          break;
        }
        throw new IllegalStateException("Unexpected type for " + paraml.cvW);
        return localHashMap;
      }
    }
  }
  
  public static final class a
  {
    public final com.tencent.matrix.resource.analyzer.model.i cwx;
    public final boolean cwy;
    
    public a(com.tencent.matrix.resource.analyzer.model.i parami, boolean paramBoolean)
    {
      this.cwx = parami;
      this.cwy = paramBoolean;
    }
    
    private static com.tencent.matrix.resource.analyzer.model.j d(com.tencent.matrix.resource.analyzer.model.i parami)
    {
      Object localObject2 = null;
      if (parami.cvX == null) {}
      Object localObject4;
      do
      {
        return null;
        localObject4 = parami.cvX.cvW;
      } while ((localObject4 instanceof com.d.a.b.j));
      j.b localb = parami.cvZ;
      String str = parami.cvY;
      ArrayList localArrayList = new ArrayList();
      Object localObject1;
      Object localObject5;
      Object localObject3;
      if ((localObject4 instanceof com.d.a.b.c))
      {
        localObject1 = ((com.d.a.b.c)localObject4).zL().entrySet().iterator();
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
        if (((a)localObject1).bTF == p.bUZ)
        {
          localObject1 = ((a)localObject1).zI();
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
        localObject1 = ((com.d.a.b.i)localObject4).zJ().zL().entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localArrayList.add("static " + com.d.a.b.e.b((Map.Entry)localObject3));
        }
        localObject1 = ((b)localObject4).zK().iterator();
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
        localObject1 = j.a.cwe;
      }
      for (;;)
      {
        return new com.tencent.matrix.resource.analyzer.model.j(str, localb, (j.a)localObject1, (String)localObject3, (String)localObject2, parami.cvV, localArrayList);
        if ((localObject4 instanceof a))
        {
          localObject3 = ((a)localObject4).zJ().mClassName;
          break;
        }
        localObject3 = ((com.d.a.b.i)localObject4).zJ().mClassName;
        break;
        label442:
        if ((localObject4 instanceof a))
        {
          localObject1 = j.a.cwg;
        }
        else
        {
          localObject5 = ((com.d.a.b.i)localObject4).zJ();
          if (com.d.a.b.e.b((com.d.a.b.c)localObject5))
          {
            localObject1 = j.a.cwf;
            localObject2 = com.d.a.b.e.a((com.d.a.b.i)localObject4);
            localObject2 = "(named '" + (String)localObject2 + "')";
          }
          else
          {
            if (((String)localObject3).matches("^.+\\$\\d+$"))
            {
              localObject4 = ((com.d.a.b.c)localObject5).zM().mClassName;
              if (Object.class.getName().equals(localObject4)) {
                localObject1 = j.a.cwd;
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
            localObject1 = j.a.cwd;
            localObject2 = "(anonymous subclass of " + (String)localObject4 + ")";
            continue;
            localObject1 = j.a.cwd;
          }
        }
      }
    }
    
    public final h Hj()
    {
      ArrayList localArrayList = new ArrayList();
      for (com.tencent.matrix.resource.analyzer.model.i locali = new com.tencent.matrix.resource.analyzer.model.i(null, null, this.cwx, null, null); locali != null; locali = locali.cvX)
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