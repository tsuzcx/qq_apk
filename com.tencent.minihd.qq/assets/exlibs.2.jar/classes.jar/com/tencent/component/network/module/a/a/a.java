package com.tencent.component.network.module.a.a;

import java.util.LinkedList;

public class a
  extends LinkedList
{
  private final int a;
  private final boolean b;
  
  public a(int paramInt, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramBoolean;
  }
  
  private void a()
  {
    while ((this.a > 0) && (size() > this.a)) {
      if (this.b) {
        removeFirst();
      } else {
        removeLast();
      }
    }
  }
  
  public void add(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    super.add(paramInt, paramObject);
    a();
  }
  
  public boolean add(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    boolean bool = super.add(paramObject);
    a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.a.a.a
 * JD-Core Version:    0.7.0.1
 */