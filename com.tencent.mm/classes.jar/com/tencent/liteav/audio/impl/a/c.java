package com.tencent.liteav.audio.impl.a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
  extends b
  implements Runnable
{
  private boolean c;
  private byte[] d;
  private int e;
  private int f;
  private long g;
  
  private int c()
  {
    return (this.e + this.d.length - this.f) % this.d.length;
  }
  
  public void run()
  {
    AppMethodBeat.i(16410);
    if (!this.c)
    {
      TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
      AppMethodBeat.o(16410);
      return;
    }
    a();
    int i = this.a * 1024 * this.b / 8;
    byte[] arrayOfByte = new byte[i];
    while ((this.c) && (!Thread.interrupted())) {
      if (i <= c()) {
        try
        {
          if (this.f + i <= this.d.length)
          {
            System.arraycopy(this.d, this.f, arrayOfByte, 0, i);
            this.f += i;
          }
          for (;;)
          {
            a(arrayOfByte, i, this.g);
            break;
            int j = this.d.length - this.f;
            System.arraycopy(this.d, this.f, arrayOfByte, 0, j);
            this.f = (i - j);
            System.arraycopy(this.d, 0, arrayOfByte, j, this.f);
          }
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        finally
        {
          AppMethodBeat.o(16410);
        }
      }
    }
    b();
    AppMethodBeat.o(16410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.c
 * JD-Core Version:    0.7.0.1
 */