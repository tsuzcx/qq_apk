package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends h
  implements Iterable<h>
{
  public final List<h> arx = new ArrayList();
  
  public final b a(h paramh)
  {
    if (paramh == null) {
      throw new NullPointerException("value is null");
    }
    this.arx.add(paramh);
    return this;
  }
  
  final void a(i parami)
  {
    parami.kc();
    Iterator localIterator = iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.ke();
      }
      ((h)localIterator.next()).a(parami);
    }
    parami.kd();
  }
  
  public final b ar(boolean paramBoolean)
  {
    this.arx.add(a.aq(paramBoolean));
    return this;
  }
  
  public final h cA(int paramInt)
  {
    return (h)this.arx.get(paramInt);
  }
  
  public final b cz(int paramInt)
  {
    this.arx.add(a.cy(paramInt));
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (b)paramObject;
    return this.arx.equals(paramObject.arx);
  }
  
  public final int hashCode()
  {
    return this.arx.hashCode();
  }
  
  public final boolean isArray()
  {
    return true;
  }
  
  public final Iterator<h> iterator()
  {
    return new b.1(this, this.arx.iterator());
  }
  
  public final b jN()
  {
    return this;
  }
  
  public final b m(double paramDouble)
  {
    this.arx.add(a.l(paramDouble));
    return this;
  }
  
  public final b o(long paramLong)
  {
    this.arx.add(a.n(paramLong));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.a.b
 * JD-Core Version:    0.7.0.1
 */