package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long bkK;
  private final LinkedList<h> bre = new LinkedList();
  final LinkedList<i> brf;
  private final PriorityQueue<h> brg;
  private h brh;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.bre.add(new h());
      i += 1;
    }
    this.brf = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.brf.add(new e(this));
      i += 1;
    }
    this.brg = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.bre.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void ah(long paramLong)
  {
    this.bkK = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.brh)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.sy()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.brh = null;
      return;
      bool = false;
      break;
      label37:
      this.brg.add(paramh);
    }
  }
  
  public void flush()
  {
    this.bkK = 0L;
    while (!this.brg.isEmpty()) {
      c((h)this.brg.poll());
    }
    if (this.brh != null)
    {
      c(this.brh);
      this.brh = null;
    }
  }
  
  public void release() {}
  
  protected abstract boolean uA();
  
  protected abstract com.google.android.exoplayer2.f.d uB();
  
  public i uE()
  {
    if (this.brf.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.brg.isEmpty()) || (((h)this.brg.peek()).timeUs > this.bkK)) {
          break;
        }
        localh = (h)this.brg.poll();
        if (localh.sz())
        {
          localObject = (i)this.brf.pollFirst();
          ((i)localObject).dL(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!uA());
      localObject = uB();
    } while (localh.sy());
    i locali = (i)this.brf.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h uF()
  {
    if (this.brh == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.bre.isEmpty()) {
        break;
      }
      return null;
    }
    this.brh = ((h)this.bre.pollFirst());
    return this.brh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */