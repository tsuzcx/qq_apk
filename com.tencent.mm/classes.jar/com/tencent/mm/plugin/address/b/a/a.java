package com.tencent.mm.plugin.address.b.a;

import com.tencent.mm.plugin.o.a.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  public com.tencent.mm.plugin.o.a.a fth = new com.tencent.mm.plugin.o.a.a();
  
  public final b kf(int paramInt)
  {
    Iterator localIterator = this.fth.lnO.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.lnP == paramInt) {
        return localb;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.b.a.a
 * JD-Core Version:    0.7.0.1
 */