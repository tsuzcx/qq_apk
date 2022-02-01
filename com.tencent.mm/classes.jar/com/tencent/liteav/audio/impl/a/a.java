package com.tencent.liteav.audio.impl.a;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class a
  implements Runnable
{
  private WeakReference<f> a;
  private Context b;
  private int c;
  private int d;
  private int e;
  private boolean f;
  private Thread g;
  private byte[] h;
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16394);
    f localf = null;
    try
    {
      if (this.a != null) {
        localf = (f)this.a.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        AppMethodBeat.o(16394);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16394);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
    AppMethodBeat.o(16394);
  }
  
  private void c()
  {
    AppMethodBeat.i(16395);
    f localf = null;
    try
    {
      if (this.a != null) {
        localf = (f)this.a.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStart();
        AppMethodBeat.o(16395);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16395);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
    AppMethodBeat.o(16395);
  }
  
  private void d()
  {
    AppMethodBeat.i(16396);
    f localf = null;
    try
    {
      if (this.a != null) {
        localf = (f)this.a.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStop();
        AppMethodBeat.o(16396);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16396);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
    AppMethodBeat.o(16396);
  }
  
  public void a()
  {
    AppMethodBeat.i(16393);
    this.f = false;
    long l = System.currentTimeMillis();
    if ((this.g != null) && (this.g.isAlive()) && (Thread.currentThread().getId() != this.g.getId())) {}
    try
    {
      this.g.join();
      TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.g = null;
      AppMethodBeat.o(16393);
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
    AppMethodBeat.i(16392);
    a();
    this.b = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = true;
    this.g = new Thread(this, "AudioSysRecord Thread");
    this.g.start();
    AppMethodBeat.o(16392);
  }
  
  /* Error */
  public void a(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16391
    //   5: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 35	com/tencent/liteav/audio/impl/a/a:a	Ljava/lang/ref/WeakReference;
    //   17: sipush 16391
    //   20: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 37	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 144	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 35	com/tencent/liteav/audio/impl/a/a:a	Ljava/lang/ref/WeakReference;
    //   38: sipush 16391
    //   41: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	a
    //   0	52	1	paramf	f
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	23	47	finally
    //   26	44	47	finally
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void run()
  {
    AppMethodBeat.i(16397);
    if (!this.f)
    {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(16397);
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
    AppMethodBeat.o(16397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.a
 * JD-Core Version:    0.7.0.1
 */