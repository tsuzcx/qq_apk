package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int aWh;
  private final Thread aWn;
  private final LinkedList<I> aWo = new LinkedList();
  private final LinkedList<O> aWp = new LinkedList();
  protected final I[] aWq;
  private final O[] aWr;
  protected int aWs;
  private int aWt;
  private I aWu;
  private boolean aWv;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.aWq = paramArrayOfI;
    this.aWs = 2;
    int i = 0;
    while (i < this.aWs)
    {
      this.aWq[i] = sB();
      i += 1;
    }
    this.aWr = paramArrayOfO;
    this.aWt = 2;
    i = j;
    while (i < this.aWt)
    {
      this.aWr[i] = sC();
      i += 1;
    }
    this.aWn = new Thread()
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
            bool = localg.sz();
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
    this.aWn.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.aWq;
    int i = this.aWs;
    this.aWs = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.aWr;
    int i = this.aWt;
    this.aWt = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private boolean sA()
  {
    return (!this.aWo.isEmpty()) && (this.aWt > 0);
  }
  
  private I sw()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aWu == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.aWs == 0)
          {
            localObject1 = null;
            this.aWu = ((e)localObject1);
            localObject1 = this.aWu;
            return localObject1;
          }
          Object localObject1 = this.aWq;
          int i = this.aWs - 1;
          this.aWs = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O sx()
  {
    synchronized (this.lock)
    {
      if (this.aWp.isEmpty()) {
        return null;
      }
      f localf = (f)this.aWp.removeFirst();
      return localf;
    }
  }
  
  private void sy()
  {
    if (sA()) {
      this.lock.notify();
    }
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      sy();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.aWv = true;
      this.aWh = 0;
      if (this.aWu != null)
      {
        a(this.aWu);
        this.aWu = null;
      }
      if (!this.aWo.isEmpty()) {
        a((e)this.aWo.removeFirst());
      }
    }
    while (!this.aWp.isEmpty()) {
      b((f)this.aWp.removeFirst());
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
  
  protected abstract I sB();
  
  protected abstract O sC();
  
  final boolean sz()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!sA())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.aWo.removeFirst();
    Object localObject5 = this.aWr;
    int i = this.aWt - 1;
    this.aWt = i;
    localObject5 = localObject5[i];
    boolean bool = this.aWv;
    this.aWv = false;
    if (locale.sq()) {
      ((f)localObject5).dM(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aWv)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.sp()) {
            ((f)localObject5).dM(-2147483648);
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
        if (((f)localObject5).sp())
        {
          this.aWh += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).aWh = this.aWh;
      this.aWh = 0;
      this.aWp.addLast(localObject5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */