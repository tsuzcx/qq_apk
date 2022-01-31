package com.tencent.mm.ce;

import java.util.HashSet;
import java.util.Iterator;

public final class a<T>
  implements b.a<T>
{
  private final String mName;
  private T mValue;
  private HashSet<Object<T>> umI;
  private final Object umJ = new Object();
  
  private a(String paramString)
  {
    this.mName = paramString;
    this.umI = new HashSet();
  }
  
  a(String paramString, T paramT)
  {
    this(paramString);
    this.mValue = paramT;
  }
  
  public final T get()
  {
    return this.mValue;
  }
  
  public final String name()
  {
    return this.mName;
  }
  
  final void set(T arg1)
  {
    Object localObject1 = this.mValue;
    int i;
    if ((??? == localObject1) || ((??? != null) && (???.equals(localObject1)))) {
      i = 1;
    }
    label77:
    while (i == 0)
    {
      this.mValue = ???;
      synchronized (this.umJ)
      {
        localObject1 = this.umI.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label77;
        }
        ((Iterator)localObject1).next();
      }
      i = 0;
    }
  }
  
  public final String toString()
  {
    return "Status: " + this.mName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ce.a
 * JD-Core Version:    0.7.0.1
 */