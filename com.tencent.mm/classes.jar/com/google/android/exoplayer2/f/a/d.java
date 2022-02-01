package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long bkf;
  private final LinkedList<h> btf = new LinkedList();
  final LinkedList<i> btg;
  private final PriorityQueue<h> bth;
  private h bti;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.btf.add(new h());
      i += 1;
    }
    this.btg = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.btg.add(new e(this));
      i += 1;
    }
    this.bth = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.btf.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void al(long paramLong)
  {
    this.bkf = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.bti)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.sp()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.bti = null;
      return;
      bool = false;
      break;
      label37:
      this.bth.add(paramh);
    }
  }
  
  public void flush()
  {
    this.bkf = 0L;
    while (!this.bth.isEmpty()) {
      c((h)this.bth.poll());
    }
    if (this.bti != null)
    {
      c(this.bti);
      this.bti = null;
    }
  }
  
  public void release() {}
  
  protected abstract boolean uG();
  
  protected abstract com.google.android.exoplayer2.f.d uH();
  
  public i uK()
  {
    if (this.btg.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.bth.isEmpty()) || (((h)this.bth.peek()).timeUs > this.bkf)) {
          break;
        }
        localh = (h)this.bth.poll();
        if (localh.sq())
        {
          localObject = (i)this.btg.pollFirst();
          ((i)localObject).dM(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!uG());
      localObject = uH();
    } while (localh.sp());
    i locali = (i)this.btg.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h uL()
  {
    if (this.bti == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.btf.isEmpty()) {
        break;
      }
      return null;
    }
    this.bti = ((h)this.btf.pollFirst());
    return this.bti;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */