package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int bhA;
  private I bhB;
  private boolean bhC;
  private int bhp;
  private final Thread bhu;
  private final LinkedList<I> bhv = new LinkedList();
  private final LinkedList<O> bhw = new LinkedList();
  protected final I[] bhx;
  private final O[] bhy;
  protected int bhz;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.bhx = paramArrayOfI;
    this.bhz = 2;
    int i = 0;
    while (i < this.bhz)
    {
      this.bhx[i] = uj();
      i += 1;
    }
    this.bhy = paramArrayOfO;
    this.bhA = 2;
    i = j;
    while (i < this.bhA)
    {
      this.bhy[i] = uk();
      i += 1;
    }
    this.bhu = new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(91856);
        g localg = g.this;
        try
        {
          boolean bool;
          do
          {
            bool = localg.uh();
          } while (bool);
          AppMethodBeat.o(91856);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException(localInterruptedException);
          AppMethodBeat.o(91856);
          throw localIllegalStateException;
        }
      }
    };
    this.bhu.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.bhx;
    int i = this.bhz;
    this.bhz = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.bhy;
    int i = this.bhA;
    this.bhA = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I ue()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.bhB == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.bhz == 0)
          {
            localObject1 = null;
            this.bhB = ((e)localObject1);
            localObject1 = this.bhB;
            return localObject1;
          }
          Object localObject1 = this.bhx;
          int i = this.bhz - 1;
          this.bhz = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O uf()
  {
    synchronized (this.lock)
    {
      if (this.bhw.isEmpty()) {
        return null;
      }
      f localf = (f)this.bhw.removeFirst();
      return localf;
    }
  }
  
  private void ug()
  {
    if (ui()) {
      this.lock.notify();
    }
  }
  
  private boolean ui()
  {
    return (!this.bhv.isEmpty()) && (this.bhA > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      ug();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.bhC = true;
      this.bhp = 0;
      if (this.bhB != null)
      {
        a(this.bhB);
        this.bhB = null;
      }
      if (!this.bhv.isEmpty()) {
        a((e)this.bhv.removeFirst());
      }
    }
    while (!this.bhw.isEmpty()) {
      b((f)this.bhw.removeFirst());
    }
  }
  
  public final void release()
  {
    synchronized (this.lock)
    {
      this.released = true;
      this.lock.notify();
    }
  }
  
  final boolean uh()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!ui())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.bhv.removeFirst();
    Object localObject5 = this.bhy;
    int i = this.bhA - 1;
    this.bhA = i;
    localObject5 = localObject5[i];
    boolean bool = this.bhC;
    this.bhC = false;
    if (locale.tY()) {
      ((f)localObject5).dP(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.bhC)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.tX()) {
            ((f)localObject5).dP(-2147483648);
          }
          this.exception = a(locale, (f)localObject5, bool);
          if (this.exception == null) {
            continue;
          }
          synchronized (this.lock)
          {
            return false;
          }
        }
        if (((f)localObject5).tX())
        {
          this.bhp += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).bhp = this.bhp;
      this.bhp = 0;
      this.bhw.addLast(localObject5);
    }
  }
  
  protected abstract I uj();
  
  protected abstract O uk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */