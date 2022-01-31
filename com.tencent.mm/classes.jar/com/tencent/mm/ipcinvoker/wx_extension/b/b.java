package com.tencent.mm.ipcinvoker.wx_extension.b;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private final List<b.b<a>> dHt = new LinkedList();
  private final List<Object> dHu = new LinkedList();
  
  private void Ce()
  {
    try
    {
      Iterator localIterator = this.dHu.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    finally {}
  }
  
  private void Cf()
  {
    try
    {
      Iterator localIterator = this.dHu.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    finally {}
  }
  
  public final boolean a(a parama)
  {
    if (c(parama)) {
      return false;
    }
    synchronized (this.dHt)
    {
      this.dHt.add(new b.b(parama));
      Ce();
      return true;
    }
  }
  
  public final boolean b(a parama)
  {
    if (parama == null) {
      return false;
    }
    synchronized (this.dHt)
    {
      boolean bool = this.dHt.remove(new b.b(parama));
      Cf();
      return bool;
    }
  }
  
  public final boolean c(a parama)
  {
    if (parama == null) {
      return false;
    }
    synchronized (this.dHt)
    {
      Iterator localIterator = this.dHt.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (b.b)localIterator.next();
        if (localObject != null)
        {
          localObject = (a)((b.b)localObject).get();
          if ((localObject != null) && (parama.equals(localObject))) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public final int size()
  {
    synchronized (this.dHt)
    {
      int i = this.dHt.size();
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.b.b
 * JD-Core Version:    0.7.0.1
 */