package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long beB;
  private final LinkedList<h> blc = new LinkedList();
  final LinkedList<i> bld;
  private final PriorityQueue<h> ble;
  private h blf;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.blc.add(new h());
      i += 1;
    }
    this.bld = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.bld.add(new e(this));
      i += 1;
    }
    this.ble = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.blc.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void ak(long paramLong)
  {
    this.beB = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.blf)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.rU()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.blf = null;
      return;
      bool = false;
      break;
      label37:
      this.ble.add(paramh);
    }
  }
  
  public void flush()
  {
    this.beB = 0L;
    while (!this.ble.isEmpty()) {
      c((h)this.ble.poll());
    }
    if (this.blf != null)
    {
      c(this.blf);
      this.blf = null;
    }
  }
  
  public void release() {}
  
  protected abstract boolean ue();
  
  protected abstract com.google.android.exoplayer2.f.d uf();
  
  public i ui()
  {
    if (this.bld.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.ble.isEmpty()) || (((h)this.ble.peek()).timeUs > this.beB)) {
          break;
        }
        localh = (h)this.ble.poll();
        if (localh.rV())
        {
          localObject = (i)this.bld.pollFirst();
          ((i)localObject).dY(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!ue());
      localObject = uf();
    } while (localh.rU());
    i locali = (i)this.bld.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h uj()
  {
    if (this.blf == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.blc.isEmpty()) {
        break;
      }
      return null;
    }
    this.blf = ((h)this.blc.pollFirst());
    return this.blf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */