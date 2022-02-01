package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private int cKM;
  private final Thread cKS;
  private final LinkedList<I> cKT = new LinkedList();
  private final LinkedList<O> cKU = new LinkedList();
  private final I[] cKV;
  private final O[] cKW;
  private int cKX;
  private int cKY;
  private I cKZ;
  private boolean cLa;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  protected g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.cKV = paramArrayOfI;
    this.cKX = 2;
    int i = 0;
    while (i < this.cKX)
    {
      this.cKV[i] = RL();
      i += 1;
    }
    this.cKW = paramArrayOfO;
    this.cKY = 2;
    i = j;
    while (i < this.cKY)
    {
      this.cKW[i] = RM();
      i += 1;
    }
    this.cKS = new Thread()
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
            bool = localg.RJ();
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
    this.cKS.start();
  }
  
  private I RF()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        RH();
        if (this.cKZ == null)
        {
          bool = true;
          a.checkState(bool);
          if (this.cKX == 0)
          {
            localObject1 = null;
            this.cKZ = ((e)localObject1);
            localObject1 = this.cKZ;
            return localObject1;
          }
          Object localObject1 = this.cKV;
          int i = this.cKX - 1;
          this.cKX = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O RG()
  {
    synchronized (this.lock)
    {
      RH();
      if (this.cKU.isEmpty()) {
        return null;
      }
      f localf = (f)this.cKU.removeFirst();
      return localf;
    }
  }
  
  private void RH()
  {
    if (this.exception != null) {
      throw this.exception;
    }
  }
  
  private void RI()
  {
    if (RK()) {
      this.lock.notify();
    }
  }
  
  private boolean RK()
  {
    return (!this.cKT.isEmpty()) && (this.cKY > 0);
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.cKV;
    int i = this.cKX;
    this.cKX = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.cKW;
    int i = this.cKY;
    this.cKY = (i + 1);
    arrayOff[i] = paramO;
  }
  
  protected final void RE()
  {
    int i = 0;
    if (this.cKX == this.cKV.length) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      e[] arrayOfe = this.cKV;
      int j = arrayOfe.length;
      while (i < j)
      {
        arrayOfe[i].hr(1024);
        i += 1;
      }
    }
  }
  
  final boolean RJ()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!RK())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.cKT.removeFirst();
    Object localObject4 = this.cKW;
    int i = this.cKY - 1;
    this.cKY = i;
    localObject4 = localObject4[i];
    boolean bool = this.cLa;
    this.cLa = false;
    if (locale.Ry()) {
      ((f)localObject4).hp(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.cLa)
        {
          b((f)localObject4);
          a(locale);
          return true;
          if (locale.Rx()) {
            ((f)localObject4).hp(-2147483648);
          }
          this.exception = a(locale, (f)localObject4, bool);
          if (this.exception == null) {
            continue;
          }
          ??? = this.lock;
          return false;
        }
        if (((f)localObject4).Rx())
        {
          this.cKM += 1;
          b((f)localObject4);
        }
      }
      ((f)localObject4).cKM = this.cKM;
      this.cKM = 0;
      this.cKU.addLast(localObject4);
    }
  }
  
  protected abstract I RL();
  
  protected abstract O RM();
  
  protected abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  protected void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      RI();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.cLa = true;
      this.cKM = 0;
      if (this.cKZ != null)
      {
        a(this.cKZ);
        this.cKZ = null;
      }
      if (!this.cKT.isEmpty()) {
        a((e)this.cKT.removeFirst());
      }
    }
    while (!this.cKU.isEmpty()) {
      b((f)this.cKU.removeFirst());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */