package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  extends b
  implements Runnable
{
  private boolean d;
  private Thread e;
  private byte[] f;
  private int g;
  private int h;
  private long i;
  
  public d()
  {
    AppMethodBeat.i(66663);
    this.d = false;
    this.e = null;
    this.f = new byte[20480];
    this.g = 0;
    this.h = 0;
    this.i = 0L;
    AppMethodBeat.o(66663);
  }
  
  private int e()
  {
    return (this.g + this.f.length - this.h) % this.f.length;
  }
  
  private int f()
  {
    AppMethodBeat.i(66667);
    int j = this.f.length;
    int k = e();
    AppMethodBeat.o(66667);
    return j - k;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(66664);
    super.a(paramContext, paramInt1, paramInt2, paramInt3);
    c();
    this.d = true;
    this.e = new Thread(this, "AudioCustomRecord Thread");
    this.e.start();
    AppMethodBeat.o(66664);
  }
  
  public void a(a parama)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(146235);
        this.i = parama.e;
        parama = parama.f;
        if ((parama == null) || (f() < parama.length))
        {
          StringBuilder localStringBuilder = new StringBuilder("缓冲区不够. 自定义数据长度 = ");
          if (parama == null)
          {
            j = -1;
            TXCLog.e("AudioCenter:TXCAudioCustomRecord", j + ", 剩余缓冲区长度 = " + f());
            AppMethodBeat.o(146235);
            return;
          }
          j = parama.length;
          continue;
        }
        if (this.g + parama.length <= this.f.length)
        {
          System.arraycopy(parama, 0, this.f, this.g, parama.length);
          j = this.g;
          this.g = (parama.length + j);
          AppMethodBeat.o(146235);
          continue;
        }
        j = this.f.length - this.g;
      }
      finally {}
      System.arraycopy(parama, 0, this.f, this.g, j);
      this.g = (parama.length - j);
      System.arraycopy(parama, j, this.f, 0, this.g);
      AppMethodBeat.o(146235);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(66666);
        this.i = TXCTimeUtil.getTimeTick();
        if ((paramArrayOfByte == null) || (f() < paramArrayOfByte.length))
        {
          StringBuilder localStringBuilder = new StringBuilder("缓冲区不够. 自定义数据长度 = ");
          if (paramArrayOfByte == null)
          {
            j = -1;
            TXCLog.e("AudioCenter:TXCAudioCustomRecord", j + ", 剩余缓冲区长度 = " + f());
            AppMethodBeat.o(66666);
            return;
          }
          j = paramArrayOfByte.length;
          continue;
        }
        if (this.g + paramArrayOfByte.length <= this.f.length)
        {
          System.arraycopy(paramArrayOfByte, 0, this.f, this.g, paramArrayOfByte.length);
          this.g += paramArrayOfByte.length;
          AppMethodBeat.o(66666);
          continue;
        }
        j = this.f.length - this.g;
      }
      finally {}
      System.arraycopy(paramArrayOfByte, 0, this.f, this.g, j);
      this.g = (paramArrayOfByte.length - j);
      System.arraycopy(paramArrayOfByte, j, this.f, 0, this.g);
      AppMethodBeat.o(66666);
    }
  }
  
  public void c()
  {
    AppMethodBeat.i(66665);
    this.d = false;
    long l = System.currentTimeMillis();
    if ((this.e != null) && (this.e.isAlive()) && (Thread.currentThread().getId() != this.e.getId())) {}
    try
    {
      this.e.join();
      TXCLog.i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.e = null;
      AppMethodBeat.o(66665);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        TXCLog.e("AudioCenter:TXCAudioCustomRecord", "custom record stop Exception: " + localInterruptedException.getMessage());
      }
    }
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void run()
  {
    AppMethodBeat.i(66668);
    if (!this.d)
    {
      TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
      AppMethodBeat.o(66668);
      return;
    }
    a();
    int j = this.b * 1024 * this.c / 8;
    byte[] arrayOfByte = new byte[j];
    while ((this.d) && (!Thread.interrupted())) {
      if (j <= e()) {
        try
        {
          if (this.h + j <= this.f.length)
          {
            System.arraycopy(this.f, this.h, arrayOfByte, 0, j);
            this.h += j;
          }
          for (;;)
          {
            a(arrayOfByte, j, this.i);
            break;
            int k = this.f.length - this.h;
            System.arraycopy(this.f, this.h, arrayOfByte, 0, k);
            this.h = (j - k);
            System.arraycopy(this.f, 0, arrayOfByte, k, this.h);
          }
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        finally
        {
          AppMethodBeat.o(66668);
        }
      }
    }
    b();
    AppMethodBeat.o(66668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.d
 * JD-Core Version:    0.7.0.1
 */