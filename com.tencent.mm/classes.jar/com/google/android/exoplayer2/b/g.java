package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int aWU;
  private final Thread aWZ;
  private final LinkedList<I> aXa = new LinkedList();
  private final LinkedList<O> aXb = new LinkedList();
  protected final I[] aXc;
  private final O[] aXd;
  protected int aXe;
  private int aXf;
  private I aXg;
  private boolean aXh;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.aXc = paramArrayOfI;
    this.aXe = 2;
    int i = 0;
    while (i < this.aXe)
    {
      this.aXc[i] = sK();
      i += 1;
    }
    this.aXd = paramArrayOfO;
    this.aXf = 2;
    i = j;
    while (i < this.aXf)
    {
      this.aXd[i] = sL();
      i += 1;
    }
    this.aWZ = new Thread()
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
            bool = localg.sI();
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
    this.aWZ.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.aXc;
    int i = this.aXe;
    this.aXe = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.aXd;
    int i = this.aXf;
    this.aXf = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I sF()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aXg == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.aXe == 0)
          {
            localObject1 = null;
            this.aXg = ((e)localObject1);
            localObject1 = this.aXg;
            return localObject1;
          }
          Object localObject1 = this.aXc;
          int i = this.aXe - 1;
          this.aXe = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O sG()
  {
    synchronized (this.lock)
    {
      if (this.aXb.isEmpty()) {
        return null;
      }
      f localf = (f)this.aXb.removeFirst();
      return localf;
    }
  }
  
  private void sH()
  {
    if (sJ()) {
      this.lock.notify();
    }
  }
  
  private boolean sJ()
  {
    return (!this.aXa.isEmpty()) && (this.aXf > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      sH();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.aXh = true;
      this.aWU = 0;
      if (this.aXg != null)
      {
        a(this.aXg);
        this.aXg = null;
      }
      if (!this.aXa.isEmpty()) {
        a((e)this.aXa.removeFirst());
      }
    }
    while (!this.aXb.isEmpty()) {
      b((f)this.aXb.removeFirst());
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
  
  final boolean sI()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!sJ())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.aXa.removeFirst();
    Object localObject5 = this.aXd;
    int i = this.aXf - 1;
    this.aXf = i;
    localObject5 = localObject5[i];
    boolean bool = this.aXh;
    this.aXh = false;
    if (locale.sz()) {
      ((f)localObject5).dL(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aXh)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.sy()) {
            ((f)localObject5).dL(-2147483648);
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
        if (((f)localObject5).sy())
        {
          this.aWU += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).aWU = this.aWU;
      this.aWU = 0;
      this.aXb.addLast(localObject5);
    }
  }
  
  protected abstract I sK();
  
  protected abstract O sL();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */