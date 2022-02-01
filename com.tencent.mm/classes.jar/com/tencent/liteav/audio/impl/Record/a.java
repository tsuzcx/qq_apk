package com.tencent.liteav.audio.impl.Record;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
  implements Runnable
{
  private WeakReference<c> a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  private Thread f;
  private byte[] g;
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(230445);
    c localc = null;
    try
    {
      if (this.a != null) {
        localc = (c)this.a.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        AppMethodBeat.o(230445);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230445);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
    AppMethodBeat.o(230445);
  }
  
  private void b()
  {
    AppMethodBeat.i(230449);
    c localc = null;
    try
    {
      if (this.a != null) {
        localc = (c)this.a.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordStart();
        AppMethodBeat.o(230449);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230449);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
    AppMethodBeat.o(230449);
  }
  
  private void c()
  {
    AppMethodBeat.i(230455);
    c localc = null;
    try
    {
      if (this.a != null) {
        localc = (c)this.a.get();
      }
      if (localc != null)
      {
        localc.onAudioRecordStop();
        AppMethodBeat.o(230455);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(230455);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
    AppMethodBeat.o(230455);
  }
  
  public void a()
  {
    AppMethodBeat.i(230462);
    this.e = false;
    long l = System.currentTimeMillis();
    if ((this.f != null) && (this.f.isAlive()) && (Thread.currentThread().getId() != this.f.getId())) {}
    try
    {
      this.f.join();
      TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.f = null;
      AppMethodBeat.o(230462);
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
  
  public void run()
  {
    AppMethodBeat.i(230473);
    if (!this.e)
    {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(230473);
      return;
    }
    b();
    int i = this.b;
    int j = this.c;
    int k = this.d;
    int m = j * 1024 * k / 8;
    this.g = new byte[m];
    Arrays.fill(this.g, (byte)0);
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    while ((this.e) && (!Thread.interrupted())) {
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
        l1 += this.g.length;
        a(this.g, this.g.length, TXCTimeUtil.getTimeTick());
      }
    }
    c();
    AppMethodBeat.o(230473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.a
 * JD-Core Version:    0.7.0.1
 */