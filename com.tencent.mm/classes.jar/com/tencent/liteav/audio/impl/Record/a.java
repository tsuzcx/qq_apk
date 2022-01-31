package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(66647);
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        AppMethodBeat.o(66647);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66647);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordPcmData:no callback");
    AppMethodBeat.o(66647);
  }
  
  private void c()
  {
    AppMethodBeat.i(66648);
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStart();
        AppMethodBeat.o(66648);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66648);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStart:no callback");
    AppMethodBeat.o(66648);
  }
  
  private void d()
  {
    AppMethodBeat.i(66649);
    h localh = null;
    try
    {
      if (this.a != null) {
        localh = (h)this.a.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStop();
        AppMethodBeat.o(66649);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66649);
    }
    TXCLog.e("AudioCenter:TXCAudioBGMRecord", "onRecordStop:no callback");
    AppMethodBeat.o(66649);
  }
  
  public void a()
  {
    AppMethodBeat.i(66646);
    this.f = false;
    long l = System.currentTimeMillis();
    if ((this.g != null) && (this.g.isAlive()) && (Thread.currentThread().getId() != this.g.getId())) {}
    try
    {
      this.g.join();
      TXCLog.i("AudioCenter:TXCAudioBGMRecord", "stop record cost time(MS): " + (System.currentTimeMillis() - l));
      this.g = null;
      AppMethodBeat.o(66646);
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
    AppMethodBeat.i(66645);
    a();
    this.b = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = true;
    this.g = new Thread(this, "AudioSysRecord Thread");
    this.g.start();
    AppMethodBeat.o(66645);
  }
  
  /* Error */
  public void a(h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +16 -> 24
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield 36	com/tencent/liteav/audio/impl/Record/a:a	Ljava/lang/ref/WeakReference;
    //   16: ldc 147
    //   18: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: new 38	java/lang/ref/WeakReference
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 150	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   33: putfield 36	com/tencent/liteav/audio/impl/Record/a:a	Ljava/lang/ref/WeakReference;
    //   36: ldc 147
    //   38: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	a
    //   0	49	1	paramh	h
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	21	44	finally
    //   24	41	44	finally
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public void run()
  {
    AppMethodBeat.i(66650);
    if (!this.f)
    {
      TXCLog.w("AudioCenter:TXCAudioBGMRecord", "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(66650);
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
    AppMethodBeat.o(66650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.a
 * JD-Core Version:    0.7.0.1
 */