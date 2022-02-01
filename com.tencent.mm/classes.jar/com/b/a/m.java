package com.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;

class m
{
  final p aFC;
  final a aFD;
  private final Object aFE;
  final Object aFF;
  private final AtomicInteger aFG;
  volatile Thread aFH;
  volatile boolean aFI;
  private volatile int aFJ;
  
  public m(p paramp, a parama)
  {
    AppMethodBeat.i(183603);
    this.aFE = new Object();
    this.aFF = new Object();
    this.aFJ = -1;
    this.aFC = ((p)l.checkNotNull(paramp));
    this.aFD = ((a)l.checkNotNull(parama));
    this.aFG = new AtomicInteger();
    AppMethodBeat.o(183603);
  }
  
  static void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(183609);
    if ((paramThrowable instanceof j))
    {
      k.pn();
      AppMethodBeat.o(183609);
      return;
    }
    k.pq();
    AppMethodBeat.o(183609);
  }
  
  private void d(long paramLong1, long paramLong2)
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
        if (i == this.aFJ) {
          break label111;
        }
        j = 1;
        label38:
        if (paramLong2 < 0L) {
          break label117;
        }
        if ((k != 0) && (j != 0)) {
          dJ(i);
        }
        this.aFJ = i;
      }
      synchronized (this.aFE)
      {
        this.aFE.notifyAll();
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
  
  private boolean isStopped()
  {
    AppMethodBeat.i(183607);
    if ((Thread.currentThread().isInterrupted()) || (this.aFI))
    {
      AppMethodBeat.o(183607);
      return true;
    }
    AppMethodBeat.o(183607);
    return false;
  }
  
  private void pr()
  {
    int j = 0;
    try
    {
      AppMethodBeat.i(183605);
      int i = j;
      if (this.aFH != null)
      {
        i = j;
        if (this.aFH.getState() != Thread.State.TERMINATED) {
          i = 1;
        }
      }
      if ((!this.aFI) && (!this.aFD.isCompleted()) && (i == 0))
      {
        this.aFH = new Thread(new a((byte)0), "Source reader for " + this.aFC);
        this.aFH.start();
      }
      AppMethodBeat.o(183605);
      return;
    }
    finally {}
  }
  
  private void ps()
  {
    AppMethodBeat.i(183608);
    try
    {
      this.aFC.close();
      AppMethodBeat.o(183608);
      return;
    }
    catch (n localn)
    {
      c(new n("Error closing source " + this.aFC, localn));
      AppMethodBeat.o(183608);
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
      l.b(bool, "Data offset must be positive!");
      l.b(true, "Length must be in range [0..buffer.length]");
      label27:
      if ((!this.aFD.isCompleted()) && (this.aFD.available() < 8192L + paramLong) && (!this.aFI))
      {
        pr();
        synchronized (this.aFE)
        {
          try
          {
            this.aFE.wait(1000L);
            i = this.aFG.get();
            if (i <= 0) {
              break label27;
            }
            this.aFG.set(0);
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
    int i = this.aFD.c(paramArrayOfByte, paramLong);
    if ((this.aFD.isCompleted()) && (this.aFJ != 100))
    {
      this.aFJ = 100;
      dJ(100);
    }
    AppMethodBeat.o(183604);
    return i;
  }
  
  protected void dJ(int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.b.a.m
 * JD-Core Version:    0.7.0.1
 */