package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
  implements Runnable
{
  private WeakReference<h> a;
  private Context b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private Thread g;
  private byte[] h;
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
  }
  
  private void c()
  {
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStart();
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
  }
  
  private void d()
  {
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStop();
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
  }
  
  public void a()
  {
    this.f = false;
    long l = System.currentTimeMillis();
    if ((this.g != null) && (this.g.isAlive()) && (Thread.currentThread().getId() != this.g.getId())) {}
    try
    {
      this.g.join();
      TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.g = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("AudioCenter:TXCAudioBGMRecord", "record stop Exception: " + localException.getMessage());
      }
    }
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    this.b = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = true;
    this.g = new Thread(this, "AudioSysRecord Thread");
    this.g.start();
  }
  
  public void a(h paramh)
  {
    if (paramh == null) {}
    for (;;)
    {
      try
      {
        this.a = null;
        return;
      }
      finally {}
      this.a = new WeakReference(paramh);
    }
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void run()
  {
    if (!this.f)
    {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      return;
    }
    c();
    int i = this.c;
    int j = this.d;
    int k = this.e;
    int m = j * 1024 * k / 8;
    this.h = new byte[m];
    Arrays.fill(this.h, (byte)0);
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    while ((this.f) && (!Thread.interrupted())) {
      if ((System.currentTimeMillis() - l2) * i * j * k / 8L / 1000L - l1 < m)
      {
        try
        {
          Thread.sleep(10L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      else
      {
        l1 += this.h.length;
        a(this.h, this.h.length, TXCTimeUtil.getTimeTick());
      }
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.a
 * JD-Core Version:    0.7.0.1
 */