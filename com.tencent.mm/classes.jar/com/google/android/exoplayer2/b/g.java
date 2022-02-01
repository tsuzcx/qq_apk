package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int bhm;
  private final Thread bhr;
  private final LinkedList<I> bhs = new LinkedList();
  private final LinkedList<O> bht = new LinkedList();
  protected final I[] bhu;
  private final O[] bhv;
  protected int bhw;
  private int bhx;
  private I bhy;
  private boolean bhz;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.bhu = paramArrayOfI;
    this.bhw = 2;
    int i = 0;
    while (i < this.bhw)
    {
      this.bhu[i] = uo();
      i += 1;
    }
    this.bhv = paramArrayOfO;
    this.bhx = 2;
    i = j;
    while (i < this.bhx)
    {
      this.bhv[i] = up();
      i += 1;
    }
    this.bhr = new Thread()
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
            bool = localg.um();
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
    this.bhr.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.bhu;
    int i = this.bhw;
    this.bhw = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.bhv;
    int i = this.bhx;
    this.bhx = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I uj()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.bhy == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.bhw == 0)
          {
            localObject1 = null;
            this.bhy = ((e)localObject1);
            localObject1 = this.bhy;
            return localObject1;
          }
          Object localObject1 = this.bhu;
          int i = this.bhw - 1;
          this.bhw = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O uk()
  {
    synchronized (this.lock)
    {
      if (this.bht.isEmpty()) {
        return null;
      }
      f localf = (f)this.bht.removeFirst();
      return localf;
    }
  }
  
  private void ul()
  {
    if (un()) {
      this.lock.notify();
    }
  }
  
  private boolean un()
  {
    return (!this.bhs.isEmpty()) && (this.bhx > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      ul();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.bhz = true;
      this.bhm = 0;
      if (this.bhy != null)
      {
        a(this.bhy);
        this.bhy = null;
      }
      if (!this.bhs.isEmpty()) {
        a((e)this.bhs.removeFirst());
      }
    }
    while (!this.bht.isEmpty()) {
      b((f)this.bht.removeFirst());
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
  
  final boolean um()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!un())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.bhs.removeFirst();
    Object localObject5 = this.bhv;
    int i = this.bhx - 1;
    this.bhx = i;
    localObject5 = localObject5[i];
    boolean bool = this.bhz;
    this.bhz = false;
    if (locale.ud()) {
      ((f)localObject5).dK(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.bhz)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.uc()) {
            ((f)localObject5).dK(-2147483648);
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
        if (((f)localObject5).uc())
        {
          this.bhm += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).bhm = this.bhm;
      this.bhm = 0;
      this.bht.addLast(localObject5);
    }
  }
  
  protected abstract I uo();
  
  protected abstract O up();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */