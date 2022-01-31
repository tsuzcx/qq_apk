package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends h
  implements Iterable<e.b>
{
  public final List<String> arD = new ArrayList();
  public transient e.a arE = new e.a();
  public final List<h> arx = new ArrayList();
  
  public final h Y(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("name is null");
    }
    int i = indexOf(paramString);
    if (i != -1) {
      return (h)this.arx.get(i);
    }
    return null;
  }
  
  public final e a(String paramString, h paramh)
  {
    if (paramString == null) {
      throw new NullPointerException("name is null");
    }
    if (paramh == null) {
      throw new NullPointerException("value is null");
    }
    this.arE.h(paramString, this.arD.size());
    this.arD.add(paramString);
    this.arx.add(paramh);
    return this;
  }
  
  final void a(i parami)
  {
    parami.kf();
    Iterator localIterator1 = this.arD.iterator();
    Iterator localIterator2 = this.arx.iterator();
    for (int i = 1; localIterator1.hasNext(); i = 0)
    {
      if (i == 0) {
        parami.ki();
      }
      parami.ad((String)localIterator1.next());
      parami.kh();
      ((h)localIterator2.next()).a(parami);
    }
    parami.kg();
  }
  
  public final e b(String paramString, h paramh)
  {
    if (paramString == null) {
      throw new NullPointerException("name is null");
    }
    if (paramh == null) {
      throw new NullPointerException("value is null");
    }
    int i = indexOf(paramString);
    if (i != -1)
    {
      this.arx.set(i, paramh);
      return this;
    }
    this.arE.h(paramString, this.arD.size());
    this.arD.add(paramString);
    this.arx.add(paramh);
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (e)paramObject;
    } while ((this.arD.equals(paramObject.arD)) && (this.arx.equals(paramObject.arx)));
    return false;
  }
  
  public final e g(String paramString, int paramInt)
  {
    b(paramString, a.cy(paramInt));
    return this;
  }
  
  public final int hashCode()
  {
    return (this.arD.hashCode() + 31) * 31 + this.arx.hashCode();
  }
  
  public final int indexOf(String paramString)
  {
    e.a locala = this.arE;
    int i = locala.N(paramString);
    i = (locala.arI[i] & 0xFF) - 1;
    if ((i != -1) && (paramString.equals(this.arD.get(i)))) {
      return i;
    }
    return this.arD.lastIndexOf(paramString);
  }
  
  public final boolean isObject()
  {
    return true;
  }
  
  public final Iterator<e.b> iterator()
  {
    return new e.1(this, this.arD.iterator(), this.arx.iterator());
  }
  
  public final e jS()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.a.e
 * JD-Core Version:    0.7.0.1
 */