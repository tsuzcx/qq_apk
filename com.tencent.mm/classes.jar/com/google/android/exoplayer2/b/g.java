package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;

public abstract class g<I extends e, O extends f, E extends Exception>
  implements c<I, O, E>
{
  private final Thread ayG;
  private final LinkedList<I> ayH = new LinkedList();
  private final LinkedList<O> ayI = new LinkedList();
  public final I[] ayJ;
  private final O[] ayK;
  public int ayL;
  private int ayM;
  private I ayN;
  private boolean ayO;
  private int ayz;
  private E exception;
  private final Object lock = new Object();
  private boolean released;
  
  public g(I[] paramArrayOfI, O[] paramArrayOfO)
  {
    this.ayJ = paramArrayOfI;
    this.ayL = 2;
    int i = 0;
    while (i < this.ayL)
    {
      this.ayJ[i] = lM();
      i += 1;
    }
    this.ayK = paramArrayOfO;
    this.ayM = 2;
    i = j;
    while (i < this.ayM)
    {
      this.ayK[i] = lN();
      i += 1;
    }
    this.ayG = new g.1(this);
    this.ayG.start();
  }
  
  private void a(I paramI)
  {
    paramI.clear();
    e[] arrayOfe = this.ayJ;
    int i = this.ayL;
    this.ayL = (i + 1);
    arrayOfe[i] = paramI;
  }
  
  private void b(O paramO)
  {
    paramO.clear();
    f[] arrayOff = this.ayK;
    int i = this.ayM;
    this.ayM = (i + 1);
    arrayOff[i] = paramO;
  }
  
  private I lG()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        lI();
        if (this.ayN == null)
        {
          bool = true;
          a.aC(bool);
          if (this.ayL == 0)
          {
            localObject1 = null;
            this.ayN = ((e)localObject1);
            localObject1 = this.ayN;
            return localObject1;
          }
          Object localObject1 = this.ayJ;
          int i = this.ayL - 1;
          this.ayL = i;
          localObject1 = localObject1[i];
        }
      }
      boolean bool = false;
    }
  }
  
  private O lH()
  {
    synchronized (this.lock)
    {
      lI();
      if (this.ayI.isEmpty()) {
        return null;
      }
      f localf = (f)this.ayI.removeFirst();
      return localf;
    }
  }
  
  private void lI()
  {
    if (this.exception != null) {
      throw this.exception;
    }
  }
  
  private void lJ()
  {
    if (lL()) {
      this.lock.notify();
    }
  }
  
  private boolean lL()
  {
    return (!this.ayH.isEmpty()) && (this.ayM > 0);
  }
  
  public abstract E a(I paramI, O paramO, boolean paramBoolean);
  
  public void a(O paramO)
  {
    synchronized (this.lock)
    {
      b(paramO);
      lJ();
      return;
    }
  }
  
  public final void flush()
  {
    synchronized (this.lock)
    {
      this.ayO = true;
      this.ayz = 0;
      if (this.ayN != null)
      {
        a(this.ayN);
        this.ayN = null;
      }
      if (!this.ayH.isEmpty()) {
        a((e)this.ayH.removeFirst());
      }
    }
    while (!this.ayI.isEmpty()) {
      b((f)this.ayI.removeFirst());
    }
  }
  
  final boolean lK()
  {
    synchronized (this.lock)
    {
      if ((!this.released) && (!lL())) {
        this.lock.wait();
      }
    }
    if (this.released) {
      return false;
    }
    e locale = (e)this.ayH.removeFirst();
    Object localObject5 = this.ayK;
    int i = this.ayM - 1;
    this.ayM = i;
    localObject5 = localObject5[i];
    boolean bool = this.ayO;
    this.ayO = false;
    if (locale.lz()) {
      ((f)localObject5).cG(4);
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.ayO)
        {
          b((f)localObject5);
          a(locale);
          return true;
          if (locale.ly()) {
            ((f)localObject5).cG(-2147483648);
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
        if (((f)localObject5).ly())
        {
          this.ayz += 1;
          b((f)localObject5);
        }
      }
      ((f)localObject5).ayz = this.ayz;
      this.ayz = 0;
      this.ayI.addLast(localObject5);
    }
  }
  
  public abstract I lM();
  
  public abstract O lN();
  
  public final void release()
  {
    synchronized (this.lock)
    {
      this.released = true;
      this.lock.notify();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g
 * JD-Core Version:    0.7.0.1
 */