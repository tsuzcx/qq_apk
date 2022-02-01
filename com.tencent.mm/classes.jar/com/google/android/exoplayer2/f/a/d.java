package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private final LinkedList<h> bBA = new LinkedList();
  final LinkedList<i> bBB;
  private final PriorityQueue<h> bBC;
  private h bBD;
  private long buZ;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.bBA.add(new h());
      i += 1;
    }
    this.bBB = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.bBB.add(new e(this));
      i += 1;
    }
    this.bBC = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.bBA.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void ah(long paramLong)
  {
    this.buZ = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.bBD)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.uc()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.bBD = null;
      return;
      bool = false;
      break;
      label37:
      this.bBC.add(paramh);
    }
  }
  
  public void flush()
  {
    this.buZ = 0L;
    while (!this.bBC.isEmpty()) {
      c((h)this.bBC.poll());
    }
    if (this.bBD != null)
    {
      c(this.bBD);
      this.bBD = null;
    }
  }
  
  public void release() {}
  
  protected abstract boolean we();
  
  protected abstract com.google.android.exoplayer2.f.d wf();
  
  public i wi()
  {
    if (this.bBB.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.bBC.isEmpty()) || (((h)this.bBC.peek()).timeUs > this.buZ)) {
          break;
        }
        localh = (h)this.bBC.poll();
        if (localh.ud())
        {
          localObject = (i)this.bBB.pollFirst();
          ((i)localObject).dK(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!we());
      localObject = wf();
    } while (localh.uc());
    i locali = (i)this.bBB.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h wj()
  {
    if (this.bBD == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.bBA.isEmpty()) {
        break;
      }
      return null;
    }
    this.bBD = ((h)this.bBA.pollFirst());
    return this.bBD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */