package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private final PriorityQueue<h> bBA;
  private h bBB;
  private final LinkedList<h> bBy = new LinkedList();
  final LinkedList<i> bBz;
  private long bvf;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.bBy.add(new h());
      i += 1;
    }
    this.bBz = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.bBz.add(new e(this));
      i += 1;
    }
    this.bBA = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.bBy.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void ah(long paramLong)
  {
    this.bvf = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.bBB)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.tX()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.bBB = null;
      return;
      bool = false;
      break;
      label37:
      this.bBA.add(paramh);
    }
  }
  
  public void flush()
  {
    this.bvf = 0L;
    while (!this.bBA.isEmpty()) {
      c((h)this.bBA.poll());
    }
    if (this.bBB != null)
    {
      c(this.bBB);
      this.bBB = null;
    }
  }
  
  public void release() {}
  
  protected abstract boolean vZ();
  
  protected abstract com.google.android.exoplayer2.f.d wa();
  
  public i wd()
  {
    if (this.bBz.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.bBA.isEmpty()) || (((h)this.bBA.peek()).timeUs > this.bvf)) {
          break;
        }
        localh = (h)this.bBA.poll();
        if (localh.tY())
        {
          localObject = (i)this.bBz.pollFirst();
          ((i)localObject).dP(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!vZ());
      localObject = wa();
    } while (localh.tX());
    i locali = (i)this.bBz.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h we()
  {
    if (this.bBB == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.bBy.isEmpty()) {
        break;
      }
      return null;
    }
    this.bBB = ((h)this.bBy.pollFirst());
    return this.bBB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */