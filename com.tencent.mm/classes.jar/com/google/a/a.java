package com.google.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class a
  extends b
  implements at
{
  protected int bNa = -1;
  
  private static Map A(List paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    at localat = (at)localIterator.next();
    paramList = localat.AS();
    l.f localf1 = paramList.ci("key");
    l.f localf2 = paramList.ci("value");
    Object localObject = localat.f(localf2);
    paramList = localObject;
    if ((localObject instanceof l.e)) {
      paramList = Integer.valueOf(((l.e)localObject).bSM.bPE);
    }
    localHashMap.put(localat.f(localf1), paramList);
    while (localIterator.hasNext())
    {
      localat = (at)localIterator.next();
      localObject = localat.f(localf2);
      paramList = localObject;
      if ((localObject instanceof l.e)) {
        paramList = Integer.valueOf(((l.e)localObject).bSM.bPE);
      }
      localHashMap.put(localat.f(localf1), paramList);
    }
    return localHashMap;
  }
  
  private static g ak(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return g.z((byte[])paramObject);
    }
    return (g)paramObject;
  }
  
  private static int al(Object paramObject)
  {
    return ao.c(A((List)paramObject));
  }
  
  protected static int b(int paramInt, Map<l.f, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      l.f localf = (l.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      paramInt = paramInt * 37 + localf.bSP.bPE;
      if (localf.FG()) {
        paramInt = paramInt * 53 + al(localObject);
      } else if (localf.bSS != l.f.b.bTu) {
        paramInt = paramInt * 53 + localObject.hashCode();
      } else if (localf.FJ()) {
        paramInt = paramInt * 53 + ae.B((List)localObject);
      } else {
        paramInt = paramInt * 53 + ae.a((ae.a)localObject);
      }
    }
    return paramInt;
  }
  
  private static boolean k(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return ak(paramObject1).equals(ak(paramObject2));
  }
  
  protected at.a a(b paramb)
  {
    throw new UnsupportedOperationException("Nested builder is not supported for this type.");
  }
  
  public void a(i parami)
  {
    ba.a(this, FS(), parami);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof at));
      paramObject = (at)paramObject;
      bool1 = bool2;
    } while (AS() != paramObject.AS());
    Map localMap1 = FS();
    Map localMap2 = paramObject.FS();
    int i;
    if (localMap1.size() != localMap2.size()) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      bool1 = bool2;
      if (!Ax().equals(paramObject.Ax())) {
        break;
      }
      return true;
      Iterator localIterator = localMap1.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (l.f)localIterator.next();
          if (!localMap2.containsKey(localObject2))
          {
            i = 0;
            break;
          }
          Object localObject3 = localMap1.get(localObject2);
          Object localObject1 = localMap2.get(localObject2);
          if (((l.f)localObject2).bSS == l.f.b.bTs)
          {
            if (((l.f)localObject2).FJ())
            {
              localObject2 = (List)localObject3;
              localObject1 = (List)localObject1;
              if (((List)localObject2).size() != ((List)localObject1).size())
              {
                i = 0;
                break;
              }
              i = 0;
              for (;;)
              {
                if (i >= ((List)localObject2).size()) {
                  break label279;
                }
                if (!k(((List)localObject2).get(i), ((List)localObject1).get(i)))
                {
                  i = 0;
                  break;
                }
                i += 1;
              }
              label279:
              continue;
            }
            if (k(localObject3, localObject1)) {
              continue;
            }
            i = 0;
            break;
          }
          if (((l.f)localObject2).FG())
          {
            if (ao.b(A((List)localObject3), A((List)localObject1))) {
              continue;
            }
            i = 0;
            break;
          }
          if (!localObject3.equals(localObject1))
          {
            i = 0;
            break;
          }
        }
      }
      i = 1;
    }
  }
  
  public int hashCode()
  {
    int j = this.bNb;
    int i = j;
    if (j == 0)
    {
      i = b(AS().hashCode() + 779, FS()) * 29 + Ax().hashCode();
      this.bNb = i;
    }
    return i;
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = AS().getFields().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (l.f)localIterator.next();
      if ((((l.f)localObject).FH()) && (!e((l.f)localObject))) {
        return false;
      }
    }
    localIterator = FS().entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        l.f localf = (l.f)((Map.Entry)localObject).getKey();
        if (localf.bSS.bTz == l.f.a.bTe)
        {
          if (localf.FJ())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((at)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((at)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final String toString()
  {
    return bx.a(this);
  }
  
  public int yC()
  {
    int i = this.bNa;
    if (i != -1) {
      return i;
    }
    this.bNa = ba.a(this, FS());
    return this.bNa;
  }
  
  final ca yD()
  {
    return a.b(this);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends b.a
    implements at.a
  {
    private BuilderType a(g paramg, r paramr)
    {
      return (a)super.b(paramg, paramr);
    }
    
    protected static ca b(at paramat)
    {
      ArrayList localArrayList = new ArrayList();
      ba.a(paramat, "", localArrayList);
      return new ca(localArrayList);
    }
    
    private BuilderType v(byte[] paramArrayOfByte)
    {
      return (a)super.w(paramArrayOfByte);
    }
    
    public BuilderType a(at paramat)
    {
      Object localObject1 = paramat.FS();
      if (paramat.AS() != AS()) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        l.f localf = (l.f)((Map.Entry)localObject2).getKey();
        if (localf.FJ())
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          while (((Iterator)localObject2).hasNext()) {
            e(localf, ((Iterator)localObject2).next());
          }
        }
        else if (localf.bSS.bTz == l.f.a.bTe)
        {
          at localat = (at)f(localf);
          if (localat == localat.AQ()) {
            f(localf, ((Map.Entry)localObject2).getValue());
          } else {
            f(localf, localat.AM().c(localat).c((at)((Map.Entry)localObject2).getValue()).Bn());
          }
        }
        else
        {
          f(localf, ((Map.Entry)localObject2).getValue());
        }
      }
      a(paramat.Ax());
      return this;
    }
    
    public BuilderType a(cc paramcc)
    {
      f(cc.ac(Ax()).ae(paramcc).HM());
      return this;
    }
    
    public BuilderType a(h paramh, r paramr)
    {
      cc.a locala;
      if (paramh.bNr) {
        locala = null;
      }
      for (;;)
      {
        int i = paramh.yT();
        if (i != 0)
        {
          ba.a locala1 = new ba.a(this);
          if (ba.a(paramh, locala, paramr, AS(), locala1, i)) {}
        }
        else
        {
          if (locala != null) {
            f(locala.HM());
          }
          return this;
          locala = cc.ac(Ax());
        }
      }
    }
    
    public boolean a(l.j paramj)
    {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    public l.f b(l.j paramj)
    {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    public String toString()
    {
      return bx.a(this);
    }
    
    public BuilderType yE()
    {
      throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
    }
    
    void yF()
    {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
  }
  
  protected static abstract interface b
  {
    public abstract void yH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.a
 * JD-Core Version:    0.7.0.1
 */