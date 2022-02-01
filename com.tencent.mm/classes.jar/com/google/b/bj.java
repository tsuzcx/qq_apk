package com.google.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class bj
  extends d<String>
  implements bk, RandomAccess
{
  private static final bj bZC;
  public static final bk bZD = bZC;
  private final List<Object> list;
  
  static
  {
    bj localbj = new bj();
    bZC = localbj;
    localbj.Al();
  }
  
  public bj()
  {
    this((byte)0);
  }
  
  private bj(byte paramByte)
  {
    this(new ArrayList(10));
  }
  
  public bj(bk parambk)
  {
    this.list = new ArrayList(parambk.size());
    addAll(parambk);
  }
  
  private bj(ArrayList<Object> paramArrayList)
  {
    this.list = paramArrayList;
  }
  
  private static String ap(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof g)) {
      return ((g)paramObject).Ap();
    }
    return be.E((byte[])paramObject);
  }
  
  public final List<?> Iw()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public final bk Ix()
  {
    Object localObject = this;
    if (super.Ak()) {
      localObject = new de(this);
    }
    return localObject;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    Am();
    Object localObject = paramCollection;
    if ((paramCollection instanceof bk)) {
      localObject = ((bk)paramCollection).Iw();
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
    Am();
    this.list.clear();
    this.modCount += 1;
  }
  
  public final void d(g paramg)
  {
    Am();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bj
 * JD-Core Version:    0.7.0.1
 */