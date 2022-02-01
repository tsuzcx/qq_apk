package com.google.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class bo
  extends d<String>
  implements bp, RandomAccess
{
  private static final bo dTl;
  public static final bp dTm = dTl;
  private final List<Object> list;
  
  static
  {
    bo localbo = new bo();
    dTl = localbo;
    localbo.ZP();
  }
  
  public bo()
  {
    this(10);
  }
  
  public bo(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  public bo(bp parambp)
  {
    this.list = new ArrayList(parambp.size());
    addAll(parambp);
  }
  
  private bo(ArrayList<Object> paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  private static String bx(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof h)) {
      return ((h)paramObject).ZV();
    }
    return bj.G((byte[])paramObject);
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    ZQ();
    Object localObject = paramCollection;
    if ((paramCollection instanceof bp)) {
      localObject = ((bp)paramCollection).aiu();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final List<?> aiu()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public final bp aiv()
  {
    Object localObject = this;
    if (super.ZO()) {
      localObject = new dr(this);
    }
    return localObject;
  }
  
  public final void clear()
  {
    ZQ();
    this.list.clear();
    this.modCount += 1;
  }
  
  public final void d(h paramh)
  {
    ZQ();
    this.list.add(paramh);
    this.modCount += 1;
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final h ll(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    h localh;
    if ((localObject instanceof h)) {
      localh = (h)localObject;
    }
    for (;;)
    {
      if (localh != localObject) {
        this.list.set(paramInt, localh);
      }
      return localh;
      if ((localObject instanceof String)) {
        localh = h.dS((String)localObject);
      } else {
        localh = h.z((byte[])localObject);
      }
    }
  }
  
  public final int size()
  {
    return this.list.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bo
 * JD-Core Version:    0.7.0.1
 */