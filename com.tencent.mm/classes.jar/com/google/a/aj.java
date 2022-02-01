package com.google.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class aj
  extends d<String>
  implements ak, RandomAccess
{
  private static final aj bXL;
  public static final ak bXM = bXL;
  private final List<Object> list;
  
  static
  {
    aj localaj = new aj();
    bXL = localaj;
    localaj.bNd = false;
  }
  
  public aj()
  {
    this(10);
  }
  
  public aj(int paramInt)
  {
    this(new ArrayList(paramInt));
  }
  
  public aj(ak paramak)
  {
    this.list = new ArrayList(paramak.size());
    addAll(paramak);
  }
  
  private aj(ArrayList<Object> paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  private static String as(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof g)) {
      return ((g)paramObject).yO();
    }
    return ae.G((byte[])paramObject);
  }
  
  public final List<?> GQ()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public final ak GR()
  {
    Object localObject = this;
    if (super.yJ()) {
      localObject = new cg(this);
    }
    return localObject;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    yL();
    Object localObject = paramCollection;
    if ((paramCollection instanceof ak)) {
      localObject = ((ak)paramCollection).GQ();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public final boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public final void clear()
  {
    yL();
    this.list.clear();
    this.modCount += 1;
  }
  
  public final void d(g paramg)
  {
    yL();
    this.list.add(paramg);
    this.modCount += 1;
  }
  
  public final Object getRaw(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final int size()
  {
    return this.list.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.aj
 * JD-Core Version:    0.7.0.1
 */