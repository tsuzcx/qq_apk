package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long aHL;
  private final LinkedList<h> aNI = new LinkedList();
  final LinkedList<i> aNJ;
  private final PriorityQueue<h> aNK;
  private h aNL;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.aNI.add(new h());
      i += 1;
    }
    this.aNJ = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.aNJ.add(new e(this));
      i += 1;
    }
    this.aNK = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.aNI.add(paramh);
  }
  
  public void R(long paramLong)
  {
    this.aHL = paramLong;
  }
  
  protected abstract void a(h paramh);
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.aNL)
    {
      bool = true;
      a.aB(bool);
      if (!paramh.ly()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.aNL = null;
      return;
      bool = false;
      break;
      label37:
      this.aNK.add(paramh);
    }
  }
  
  public void flush()
  {
    this.aHL = 0L;
    while (!this.aNK.isEmpty()) {
      c((h)this.aNK.poll());
    }
    if (this.aNL != null)
    {
      c(this.aNL);
      this.aNL = null;
    }
  }
  
  protected abstract boolean np();
  
  protected abstract com.google.android.exoplayer2.f.d nq();
  
  public i nt()
  {
    if (this.aNJ.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.aNK.isEmpty()) || (((h)this.aNK.peek()).ayE > this.aHL)) {
          break;
        }
        localh = (h)this.aNK.poll();
        if (localh.lz())
        {
          localObject = (i)this.aNJ.pollFirst();
          ((i)localObject).cG(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!np());
      localObject = nq();
    } while (localh.ly());
    i locali = (i)this.aNJ.pollFirst();
    locali.a(localh.ayE, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h nu()
  {
    if (this.aNL == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      if (!this.aNI.isEmpty()) {
        break;
      }
      return null;
    }
    this.aNL = ((h)this.aNI.pollFirst());
    return this.aNL;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */