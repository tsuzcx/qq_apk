package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int aQQ;
  private final Thread aQW;
  private final LinkedList<I> aQX = new LinkedList();
  private final LinkedList<O> aQY = new LinkedList();
  private final I[] aQZ;
  private final O[] aRa;
  private int aRb;
  private int aRc;
  private I aRd;
  private boolean aRe;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.aQZ = paramArrayOfI;
    this.aRb = 2;
    int i = 0;
    while (i < this.aRb)
    {
      this.aQZ[i] = si();
      i += 1;
    }
    this.aRa = paramArrayOfO;
    this.aRc = 2;
    i = j;
    while (i < this.aRc)
    {
      this.aRa[i] = sj();
      i += 1;
    }
    this.aQW = new Thread()
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
            bool = localg.sg();
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
    this.aQW.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.aQZ;
    int i = this.aRb;
    this.aRb = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.aRa;
    int i = this.aRc;
    this.aRc = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I sc()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        se();
        if (this.aRd == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.aRb == 0)
          {
            localObject1 = null;
            this.aRd = ((e)localObject1);
            localObject1 = this.aRd;
            return localObject1;
          }
          Object localObject1 = this.aQZ;
          int i = this.aRb - 1;
          this.aRb = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O sd()
  {
    synchronized (this.lock)
    {
      se();
      if (this.aQY.isEmpty()) {
        return null;
      }
      f localf = (f)this.aQY.removeFirst();
      return localf;
    }
  }
  
  private void se()
  {
    if (this.exception != null) {
      throw this.exception;
    }
  }
  
  private void sf()
  {
    if (sh()) {
      this.lock.notify();
    }
  }
  
  private boolean sh()
  {
    return (!this.aQX.isEmpty()) && (this.aRc > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      sf();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.aRe = true;
      this.aQQ = 0;
      if (this.aRd != null)
      {
        a(this.aRd);
        this.aRd = null;
      }
      if (!this.aQX.isEmpty()) {
        a((e)this.aQX.removeFirst());
      }
    }
    while (!this.aQY.isEmpty()) {
      b((f)this.aQY.removeFirst());
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
  
  protected final void sb()
  {
    int i = 0;
    if (this.aRb == this.aQZ.length) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      e[] arrayOfe = this.aQZ;
      int j = arrayOfe.length;
      while (i < j)
      {
        arrayOfe[i].ea(1024);
        i += 1;
      }
    }
  }
  
  final boolean sg()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!sh())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.aQX.removeFirst();
    Object localObject4 = this.aRa;
    int i = this.aRc - 1;
    this.aRc = i;
    localObject4 = localObject4[i];
    boolean bool = this.aRe;
    this.aRe = false;
    if (locale.rV()) {
      ((f)localObject4).dY(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aRe)
        {
          b((f)localObject4);
          a(locale);
          return true;
          if (locale.rU()) {
            ((f)localObject4).dY(-2147483648);
          }
          this.exception = a(locale, (f)localObject4, bool);
          if (this.exception == null) {
            continue;
          }
          ??? = this.lock;
          return false;
        }
        if (((f)localObject4).rU())
        {
          this.aQQ += 1;
          b((f)localObject4);
        }
      }
      ((f)localObject4).aQQ = this.aQQ;
      this.aQQ = 0;
      this.aQY.addLast(localObject4);
    }
  }
  
  protected abstract I si();
  
  protected abstract O sj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */