package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long aOF;
  private final LinkedList<h> aVc = new LinkedList();
  final LinkedList<i> aVd;
  private final PriorityQueue<h> aVe;
  private h aVf;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.aVc.add(new h());
      i += 1;
    }
    this.aVd = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.aVd.add(new e(this));
      i += 1;
    }
    this.aVe = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.aVc.add(paramh);
  }
  
  protected abstract void a(h paramh);
  
  public void aa(long paramLong)
  {
    this.aOF = paramLong;
  }
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.aVf)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.nD()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.aVf = null;
      return;
      bool = false;
      break;
      label37:
      this.aVe.add(paramh);
    }
  }
  
  public void flush()
  {
    this.aOF = 0L;
    while (!this.aVe.isEmpty()) {
      c((h)this.aVe.poll());
    }
    if (this.aVf != null)
    {
      c(this.aVf);
      this.aVf = null;
    }
  }
  
  protected abstract boolean pM();
  
  protected abstract com.google.android.exoplayer2.f.d pN();
  
  public i pQ()
  {
    if (this.aVd.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.aVe.isEmpty()) || (((h)this.aVe.peek()).aAT > this.aOF)) {
          break;
        }
        localh = (h)this.aVe.poll();
        if (localh.nE())
        {
          localObject = (i)this.aVd.pollFirst();
          ((i)localObject).db(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!pM());
      localObject = pN();
    } while (localh.nD());
    i locali = (i)this.aVd.pollFirst();
    locali.a(localh.aAT, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h pR()
  {
    if (this.aVf == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.aVc.isEmpty()) {
        break;
      }
      return null;
    }
    this.aVf = ((h)this.aVc.pollFirst());
    return this.aVf;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */