package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int aAO;
  private final Thread aAV;
  private final LinkedList<I> aAW = new LinkedList();
  private final LinkedList<O> aAX = new LinkedList();
  protected final I[] aAY;
  private final O[] aAZ;
  protected int aBa;
  private int aBb;
  private I aBc;
  private boolean aBd;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.aAY = paramArrayOfI;
    this.aBa = 2;
    int i = 0;
    while (i < this.aBa)
    {
      this.aAY[i] = nP();
      i += 1;
    }
    this.aAZ = paramArrayOfO;
    this.aBb = 2;
    i = j;
    while (i < this.aBb)
    {
      this.aAZ[i] = nQ();
      i += 1;
    }
    this.aAV = new Thread()
    {
      public final void run()
      {
        AppMethodBeat.i(94745);
        g localg = g.this;
        try
        {
          boolean bool;
          do
          {
            bool = localg.nN();
          } while (bool);
          AppMethodBeat.o(94745);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException(localInterruptedException);
          AppMethodBeat.o(94745);
          throw localIllegalStateException;
        }
      }
    };
    this.aAV.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.aAY;
    int i = this.aBa;
    this.aBa = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.aAZ;
    int i = this.aBb;
    this.aBb = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I nK()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aBc == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.aBa == 0)
          {
            localObject1 = null;
            this.aBc = ((e)localObject1);
            localObject1 = this.aBc;
            return localObject1;
          }
          Object localObject1 = this.aAY;
          int i = this.aBa - 1;
          this.aBa = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O nL()
  {
    synchronized (this.lock)
    {
      if (this.aAX.isEmpty()) {
        return null;
      }
      f localf = (f)this.aAX.removeFirst();
      return localf;
    }
  }
  
  private void nM()
  {
    if (nO()) {
      this.lock.notify();
    }
  }
  
  private boolean nO()
  {
    return (!this.aAW.isEmpty()) && (this.aBb > 0);
  }
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      nM();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.aBd = true;
      this.aAO = 0;
      if (this.aBc != null)
      {
        a(this.aBc);
        this.aBc = null;
      }
      if (!this.aAW.isEmpty()) {
        a((e)this.aAW.removeFirst());
      }
    }
    while (!this.aAX.isEmpty()) {
      b((f)this.aAX.removeFirst());
    }
  }
  
  final boolean nN()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!nO())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.aAW.removeFirst();
    Object localObject5 = this.aAZ;
    int i = this.aBb - 1;
    this.aBb = i;
    localObject5 = localObject5[i];
    boolean bool = this.aBd;
    this.aBd = false;
    if (locale.nE()) {
      ((f)localObject5).db(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.aBd)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.nD()) {
            ((f)localObject5).db(-2147483648);
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
        if (((f)localObject5).nD())
        {
          this.aAO += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).aAO = this.aAO;
      this.aAO = 0;
      this.aAX.addLast(localObject5);
    }
  }
  
  protected abstract I nP();
  
  protected abstract O nQ();
  
  public final void release()
  {
    synchronized (this.lock)
    {
      this.released = true;
      this.lock.notify();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */