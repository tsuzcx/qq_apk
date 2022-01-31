package com.tencent.mm.plugin.gallery.model;

import java.util.LinkedList;

public final class f<E>
  extends LinkedList<E>
{
  private byte[] dMQ = new byte[0];
  
  public final boolean aC(E paramE)
  {
    synchronized (this.dMQ)
    {
      boolean bool = super.contains(paramE);
      return bool;
    }
  }
  
  public final E aXu()
  {
    synchronized (this.dMQ)
    {
      if (size() > 0)
      {
        Object localObject1 = super.poll();
        return localObject1;
      }
      return null;
    }
  }
  
  public final boolean add(E paramE)
  {
    synchronized (this.dMQ)
    {
      boolean bool = super.add(paramE);
      return bool;
    }
  }
  
  public final void bn(E paramE)
  {
    synchronized (this.dMQ)
    {
      if (aC(paramE)) {
        super.remove(paramE);
      }
      return;
    }
  }
  
  public final int size()
  {
    synchronized (this.dMQ)
    {
      int i = super.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.f
 * JD-Core Version:    0.7.0.1
 */