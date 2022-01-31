package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;

public class d
  extends b
  implements Runnable
{
  private boolean d = false;
  private Thread e = null;
  private byte[] f = new byte[20480];
  private int g = 0;
  private int h = 0;
  
  private int e()
  {
    return (this.g + this.f.length - this.h) % this.f.length;
  }
  
  private int f()
  {
    return this.f.length - e();
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super.a(paramContext, paramInt1, paramInt2, paramInt3);
    c();
    this.d = true;
    this.e = new Thread(this, "AudioCustomRecord Thread");
    this.e.start();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (f() < paramArrayOfByte.length)
        {
          StringBuilder localStringBuilder = new StringBuilder("缓冲区不够. 自定义数据长度 = ");
          if (paramArrayOfByte == null)
          {
            i = -1;
            TXCLog.e("AudioCenter:TXCAudioCustomRecord", i + ", 剩余缓冲区长度 = " + f());
            return;
          }
          i = paramArrayOfByte.length;
          continue;
        }
        if (this.g + paramArrayOfByte.length <= this.f.length)
        {
          System.arraycopy(paramArrayOfByte, 0, this.f, this.g, paramArrayOfByte.length);
          this.g += paramArrayOfByte.length;
          continue;
        }
        i = this.f.length - this.g;
      }
      finally {}
      System.arraycopy(paramArrayOfByte, 0, this.f, this.g, i);
      this.g = (paramArrayOfByte.length - i);
      System.arraycopy(paramArrayOfByte, i, this.f, 0, this.g);
    }
  }
  
  public void c()
  {
    this.d = false;
    long l = System.currentTimeMillis();
    if ((this.e != null) && (this.e.isAlive()) && (Thread.currentThread().getId() != this.e.getId())) {}
    try
    {
      this.e.join();
      TXCLog.i("AudioCenter:TXCAudioCustomRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.e = null;
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
    if (!this.d)
    {
      TXCLog.w("AudioCenter:TXCAudioCustomRecord", "audio custom record: abandom start audio sys record thread!");
      return;
    }
    a();
    int i = this.b * 1024 * this.c / 8;
    byte[] arrayOfByte = new byte[i];
    while ((this.d) && (!Thread.interrupted())) {
      if (i <= e()) {
        try
        {
          if (this.h + i <= this.f.length)
          {
            System.arraycopy(this.f, this.h, arrayOfByte, 0, i);
            this.h += i;
          }
          for (;;)
          {
            a(arrayOfByte, i, TXCTimeUtil.getTimeTick());
            break;
            int j = this.f.length - this.h;
            System.arraycopy(this.f, this.h, arrayOfByte, 0, j);
            this.h = (i - j);
            System.arraycopy(this.f, 0, arrayOfByte, j, this.h);
          }
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        finally {}
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.d
 * JD-Core Version:    0.7.0.1
 */