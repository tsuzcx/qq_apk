package com.tencent.component.network.module.a.a;

import java.util.Comparator;

public class b
  extends a
{
  private final Comparator a;
  
  public b(int paramInt, Comparator paramComparator, boolean paramBoolean)
  {
    super(paramInt, paramBoolean);
    this.a = paramComparator;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (this.a == null)
    {
      super.add(paramInt, paramObject);
      return;
    }
    add(paramObject);
  }
  
  public boolean add(Object paramObject)
  {
    int i = 0;
    if (paramObject == null) {
      return false;
    }
    if (this.a == null) {
      return super.add(paramObject);
    }
    int j = size();
    if (i < j)
    {
      Object localObject = get(i);
      if (localObject == null) {}
      while (this.a.compare(paramObject, localObject) > 0)
      {
        i += 1;
        break;
      }
    }
    super.add(i, paramObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.a.b
 * JD-Core Version:    0.7.0.1
 */