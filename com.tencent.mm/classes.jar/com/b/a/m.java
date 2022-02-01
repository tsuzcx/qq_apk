package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

class m
{
  final p cBn;
  final a cBo;
  private final Object cBp;
  final Object cBq;
  private final AtomicInteger cBr;
  volatile Thread cBs;
  volatile boolean cBt;
  private volatile int cBu;
  
  public m(p paramp, a parama)
  {
    AppMethodBeat.i(183603);
    this.cBp = new Object();
    this.cBq = new Object();
    this.cBu = -1;
    this.cBn = ((p)l.checkNotNull(paramp));
    this.cBo = ((a)l.checkNotNull(parama));
    this.cBr = new AtomicInteger();
    AppMethodBeat.o(183603);
  }
  
  private void OY()
  {
    int j = 0;
    try
    {
      AppMethodBeat.i(183605);
      int i = j;
      if (this.cBs != null)
      {
        i = j;
        if (this.cBs.getState() != Thread.State.TERMINATED) {
          i = 1;
        }
      }
      if ((!this.cBt) && (!this.cBo.isCompleted()) && (i == 0))
      {
        this.cBs = new Thread(new a((byte)0), "Source reader for " + this.cBn);
        this.cBs.start();
      }
      AppMethodBeat.o(183605);
      return;
    }
    finally {}
  }
  
  private void OZ()
  {
    AppMethodBeat.i(183608);
    try
    {
      this.cBn.close();
      AppMethodBeat.o(183608);
      return;
    }
    catch (n localn)
    {
      l(new n("Error closing source " + this.cBn, localn));
      AppMethodBeat.o(183608);
    }
  }
  
  private boolean isStopped()
  {
    AppMethodBeat.i(183607);
    if ((Thread.currentThread().isInterrupted()) || (this.cBt))
    {
      AppMethodBeat.o(183607);
      return true;
    }
    AppMethodBeat.o(183607);
    return false;
  }
  
  static void l(Throwable paramThrowable)
  {
    AppMethodBeat.i(183609);
    if ((paramThrowable instanceof j))
    {
      k.OU();
      AppMethodBeat.o(183609);
      return;
    }
    k.OX();
    AppMethodBeat.o(183609);
  }
  
  private void z(long paramLong1, long paramLong2)
  {
    int k = 1;
    AppMethodBeat.i(183606);
    int i;
    if (paramLong2 == 0L) {
      i = 1;
    }
    for (;;)
    {
      label26:
      int j;
      if (i != 0)
      {
        i = 100;
        if (i == this.cBu) {
          break label111;
        }
        j = 1;
        label38:
        if (paramLong2 < 0L) {
          break label117;
        }
        if ((k != 0) && (j != 0)) {
          hd(i);
        }
        this.cBu = i;
      }
      synchronized (this.cBp)
      {
        this.cBp.notifyAll();
        AppMethodBeat.o(183606);
        return;
        i = 0;
        continue;
        i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
        break label26;
        label111:
        j = 0;
        break label38;
        label117:
        k = 0;
      }
    }
  }
  
  public final int c(byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(183604);
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    }
    for (;;)
    {
      l.c(bool, "Data offset must be positive!");
      l.c(true, "Length must be in range [0..buffer.length]");
      label27:
      if ((!this.cBo.isCompleted()) && (this.cBo.available() < 8192L + paramLong) && (!this.cBt))
      {
        OY();
        synchronized (this.cBp)
        {
          try
          {
            this.cBp.wait(1000L);
            i = this.cBr.get();
            if (i <= 0) {
              break label27;
            }
            this.cBr.set(0);
            paramArrayOfByte = new n("Error reading source " + i + " times");
            AppMethodBeat.o(183604);
            throw paramArrayOfByte;
          }
          catch (InterruptedException paramArrayOfByte)
          {
            paramArrayOfByte = new n("Waiting source data is interrupted!", paramArrayOfByte);
            AppMethodBeat.o(183604);
            throw paramArrayOfByte;
          }
          bool = false;
        }
      }
    }
    int i = this.cBo.c(paramArrayOfByte, paramLong);
    if ((this.cBo.isCompleted()) && (this.cBu != 100))
    {
      this.cBu = 100;
      hd(100);
    }
    AppMethodBeat.o(183604);
    return i;
  }
  
  protected void hd(int paramInt) {}
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(183602);
      m.a(m.this);
      AppMethodBeat.o(183602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.m
 * JD-Core Version:    0.7.0.1
 */