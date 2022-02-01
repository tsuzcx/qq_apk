package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d
  implements com.google.android.exoplayer2.f.e
{
  private long cYu;
  private final LinkedList<h> deY = new LinkedList();
  final LinkedList<i> deZ;
  private final PriorityQueue<h> dfa;
  private h dfb;
  
  public d()
  {
    int i = 0;
    while (i < 10)
    {
      this.deY.add(new h());
      i += 1;
    }
    this.deZ = new LinkedList();
    i = j;
    while (i < 2)
    {
      this.deZ.add(new e(this));
      i += 1;
    }
    this.dfa = new PriorityQueue();
  }
  
  private void c(h paramh)
  {
    paramh.clear();
    this.deY.add(paramh);
  }
  
  protected abstract boolean TH();
  
  protected abstract com.google.android.exoplayer2.f.d TI();
  
  public i TL()
  {
    if (this.deZ.isEmpty()) {
      return null;
    }
    h localh;
    Object localObject;
    do
    {
      do
      {
        c(localh);
        if ((this.dfa.isEmpty()) || (((h)this.dfa.peek()).timeUs > this.cYu)) {
          break;
        }
        localh = (h)this.dfa.poll();
        if (localh.Ry())
        {
          localObject = (i)this.deZ.pollFirst();
          ((i)localObject).hp(4);
          c(localh);
          return localObject;
        }
        a(localh);
      } while (!TH());
      localObject = TI();
    } while (localh.Rx());
    i locali = (i)this.deZ.pollFirst();
    locali.a(localh.timeUs, (com.google.android.exoplayer2.f.d)localObject, 9223372036854775807L);
    c(localh);
    return locali;
    return null;
  }
  
  public h TM()
  {
    if (this.dfb == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      if (!this.deY.isEmpty()) {
        break;
      }
      return null;
    }
    this.dfb = ((h)this.deY.pollFirst());
    return this.dfb;
  }
  
  protected abstract void a(h paramh);
  
  public void b(h paramh)
  {
    boolean bool;
    if (paramh == this.dfb)
    {
      bool = true;
      a.checkArgument(bool);
      if (!paramh.Rx()) {
        break label37;
      }
      c(paramh);
    }
    for (;;)
    {
      this.dfb = null;
      return;
      bool = false;
      break;
      label37:
      this.dfa.add(paramh);
    }
  }
  
  public void cy(long paramLong)
  {
    this.cYu = paramLong;
  }
  
  public void flush()
  {
    this.cYu = 0L;
    while (!this.dfa.isEmpty()) {
      c((h)this.dfa.poll());
    }
    if (this.dfb != null)
    {
      c(this.dfb);
      this.dfb = null;
    }
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.d
 * JD-Core Version:    0.7.0.1
 */