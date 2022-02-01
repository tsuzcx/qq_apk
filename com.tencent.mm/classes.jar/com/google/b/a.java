package com.google.b;

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
  implements bt
{
  protected int bOZ = -1;
  
  protected static int a(int paramInt, Map<aj.f, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      aj.f localf = (aj.f)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      paramInt = paramInt * 37 + localf.bUO.bRD;
      if (localf.Hm()) {
        paramInt = paramInt * 53 + ak(localObject);
      } else if (localf.bUR != aj.f.b.bVu) {
        paramInt = paramInt * 53 + localObject.hashCode();
      } else if (localf.Hp()) {
        paramInt = paramInt * 53 + be.z((List)localObject);
      } else {
        paramInt = paramInt * 53 + be.a((be.a)localObject);
      }
    }
    return paramInt;
  }
  
  private static g aj(Object paramObject)
  {
    if ((paramObject instanceof byte[])) {
      return g.x((byte[])paramObject);
    }
    return (g)paramObject;
  }
  
  private static int ak(Object paramObject)
  {
    return bo.c(y((List)paramObject));
  }
  
  private static boolean i(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof byte[])) && ((paramObject2 instanceof byte[]))) {
      return Arrays.equals((byte[])paramObject1, (byte[])paramObject2);
    }
    return aj(paramObject1).equals(aj(paramObject2));
  }
  
  private static Map y(List paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    bt localbt = (bt)localIterator.next();
    paramList = localbt.Cv();
    aj.f localf1 = paramList.cC("key");
    aj.f localf2 = paramList.cC("value");
    Object localObject = localbt.f(localf2);
    paramList = localObject;
    if ((localObject instanceof aj.e)) {
      paramList = Integer.valueOf(((aj.e)localObject).bUL.bRD);
    }
    localHashMap.put(localbt.f(localf1), paramList);
    while (localIterator.hasNext())
    {
      localbt = (bt)localIterator.next();
      localObject = localbt.f(localf2);
      paramList = localObject;
      if ((localObject instanceof aj.e)) {
        paramList = Integer.valueOf(((aj.e)localObject).bUL.bRD);
      }
      localHashMap.put(localbt.f(localf1), paramList);
    }
    return localHashMap;
  }
  
  public int Ad()
  {
    int i = this.bOZ;
    if (i != -1) {
      return i;
    }
    this.bOZ = ca.a(this, Hz());
    return this.bOZ;
  }
  
  final cy Ae()
  {
    return a.b(this);
  }
  
  protected bt.a a(b paramb)
  {
    throw new UnsupportedOperationException("Nested builder is not supported for this type.");
  }
  
  public void a(i parami)
  {
    ca.a(this, Hz(), parami);
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
      } while (!(paramObject instanceof bt));
      paramObject = (bt)paramObject;
      bool1 = bool2;
    } while (Cv() != paramObject.Cv());
    Map localMap1 = Hz();
    Map localMap2 = paramObject.Hz();
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
      if (!Ca().equals(paramObject.Ca())) {
        break;
      }
      return true;
      Iterator localIterator = localMap1.keySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject2 = (aj.f)localIterator.next();
          if (!localMap2.containsKey(localObject2))
          {
            i = 0;
            break;
          }
          Object localObject3 = localMap1.get(localObject2);
          Object localObject1 = localMap2.get(localObject2);
          if (((aj.f)localObject2).bUR == aj.f.b.bVs)
          {
            if (((aj.f)localObject2).Hp())
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
                if (!i(((List)localObject2).get(i), ((List)localObject1).get(i)))
                {
                  i = 0;
                  break;
                }
                i += 1;
              }
              label279:
              continue;
            }
            if (i(localObject3, localObject1)) {
              continue;
            }
            i = 0;
            break;
          }
          if (((aj.f)localObject2).Hm())
          {
            if (bo.b(y((List)localObject3), y((List)localObject1))) {
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
    int j = this.bPa;
    int i = j;
    if (j == 0)
    {
      i = a(Cv().hashCode() + 779, Hz()) * 29 + Ca().hashCode();
      this.bPa = i;
    }
    return i;
  }
  
  public boolean isInitialized()
  {
    Iterator localIterator = Cv().getFields().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (aj.f)localIterator.next();
      if ((((aj.f)localObject).Hn()) && (!e((aj.f)localObject))) {
        return false;
      }
    }
    localIterator = Hz().entrySet().iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        aj.f localf = (aj.f)((Map.Entry)localObject).getKey();
        if (localf.bUR.bVz == aj.f.a.bVe)
        {
          if (localf.Hp())
          {
            localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
            if (!((Iterator)localObject).hasNext()) {
              continue;
            }
            if (((bt)((Iterator)localObject).next()).isInitialized()) {
              break;
            }
            return false;
          }
          if (!((bt)((Map.Entry)localObject).getValue()).isInitialized()) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final String toString()
  {
    return cv.a(this);
  }
  
  public static abstract class a<BuilderType extends a<BuilderType>>
    extends b.a
    implements bt.a
  {
    protected static cy b(bt parambt)
    {
      ArrayList localArrayList = new ArrayList();
      ca.a(parambt, "", localArrayList);
      return new cy(localArrayList);
    }
    
    private BuilderType t(byte[] paramArrayOfByte)
    {
      return (a)super.u(paramArrayOfByte);
    }
    
    public BuilderType Af()
    {
      throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
    }
    
    void Ag()
    {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public BuilderType a(bt parambt)
    {
      Object localObject1 = parambt.Hz();
      if (parambt.Cv() != Cv()) {
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        aj.f localf = (aj.f)((Map.Entry)localObject2).getKey();
        if (localf.Hp())
        {
          localObject2 = ((List)((Map.Entry)localObject2).getValue()).iterator();
          while (((Iterator)localObject2).hasNext()) {
            e(localf, ((Iterator)localObject2).next());
          }
        }
        else if (localf.bUR.bVz == aj.f.a.bVe)
        {
          bt localbt = (bt)f(localf);
          if (localbt == localbt.Ct()) {
            f(localf, ((Map.Entry)localObject2).getValue());
          } else {
            f(localf, localbt.Cp().c(localbt).c((bt)((Map.Entry)localObject2).getValue()).CQ());
          }
        }
        else
        {
          f(localf, ((Map.Entry)localObject2).getValue());
        }
      }
      a(parambt.Ca());
      return this;
    }
    
    public BuilderType a(da paramda)
    {
      f(da.ac(Ca()).ae(paramda).Jm());
      return this;
    }
    
    public BuilderType a(h paramh, ap paramap)
    {
      da.a locala;
      if (paramh.bPq) {
        locala = null;
      }
      for (;;)
      {
        int i = paramh.Av();
        if (i != 0)
        {
          ca.a locala1 = new ca.a(this);
          if (ca.a(paramh, locala, paramap, Cv(), locala1, i)) {}
        }
        else
        {
          if (locala != null) {
            f(locala.Jm());
          }
          return this;
          locala = da.ac(Ca());
        }
      }
    }
    
    public boolean a(aj.j paramj)
    {
      throw new UnsupportedOperationException("hasOneof() is not implemented.");
    }
    
    public aj.f b(aj.j paramj)
    {
      throw new UnsupportedOperationException("getOneofFieldDescriptor() is not implemented.");
    }
    
    void dispose()
    {
      throw new IllegalStateException("Should be overridden by subclasses.");
    }
    
    public String toString()
    {
      return cv.a(this);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Ai();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.a
 * JD-Core Version:    0.7.0.1
 */