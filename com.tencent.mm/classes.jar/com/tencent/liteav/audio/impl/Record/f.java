package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class f
  implements Runnable
{
  private static final String a;
  private static f b;
  private Context c;
  private int d = 48000;
  private int e = 1;
  private int f = 16;
  private int g = 0;
  private AudioRecord h;
  private byte[] i = null;
  private WeakReference<h> j;
  private Thread k = null;
  private boolean l = false;
  
  static
  {
    AppMethodBeat.i(66662);
    a = "AudioCenter:" + f.class.getSimpleName();
    b = null;
    AppMethodBeat.o(66662);
  }
  
  public static f a()
  {
    AppMethodBeat.i(66651);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new f();
      }
      f localf = b;
      AppMethodBeat.o(66651);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(66651);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(66658);
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordError(paramInt, paramString);
        AppMethodBeat.o(66658);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66658);
    }
    TXCLog.e(a, "onRecordError:no callback");
    AppMethodBeat.o(66658);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(66657);
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        AppMethodBeat.o(66657);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66657);
    }
    TXCLog.e(a, "onRecordPcmData:no callback");
    AppMethodBeat.o(66657);
  }
  
  private void d()
  {
    AppMethodBeat.i(66655);
    int i1 = this.d;
    int i2 = this.e;
    int i3 = this.f;
    int i4 = this.g;
    TXCLog.i(a, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
    int m = 12;
    if (i2 == 1) {
      m = 16;
    }
    if (i3 == 8) {}
    int i5;
    for (int n = 3;; n = 2)
    {
      i5 = AudioRecord.getMinBufferSize(i1, m, n);
      if (i4 == 1) {}
      for (;;)
      {
        try
        {
          TXCLog.i(a, "audio record type: system aec");
          if (this.c != null) {
            ((AudioManager)this.c.getSystemService("audio")).setMode(3);
          }
          this.h = new AudioRecord(7, i1, m, n, i5 * 2);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          continue;
          m = i2 * 1024 * i3 / 8;
          if (m <= i5) {
            continue;
          }
          this.i = new byte[i5];
          TXCLog.i(a, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(this.i.length), Integer.valueOf(this.h.getState()) }));
          if (this.h == null) {
            continue;
          }
          try
          {
            this.h.startRecording();
            AppMethodBeat.o(66655);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(a, "mic startRecording failed.");
            a(-1, "start recording failed!");
            AppMethodBeat.o(66655);
            return;
          }
          this.i = new byte[m];
          continue;
          AppMethodBeat.o(66655);
          return;
        }
        if ((this.h != null) && (this.h.getState() == 1)) {
          continue;
        }
        TXCLog.e(a, "audio record: initialize the mic failed.");
        e();
        a(-1, "没有麦克风权限!");
        AppMethodBeat.o(66655);
        return;
        TXCLog.i(a, "audio record type: system normal");
        this.h = new AudioRecord(1, i1, m, n, i5 * 2);
      }
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(66656);
    if (this.h != null) {
      TXCLog.i(a, "stop mic");
    }
    try
    {
      this.h.setRecordPositionUpdateListener(null);
      this.h.stop();
      this.h.release();
      label42:
      this.h = null;
      this.i = null;
      AppMethodBeat.o(66656);
      return;
    }
    catch (Exception localException)
    {
      break label42;
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(66659);
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStart();
        AppMethodBeat.o(66659);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66659);
    }
    TXCLog.e(a, "onRecordStart:no callback");
    AppMethodBeat.o(66659);
  }
  
  private void g()
  {
    AppMethodBeat.i(66660);
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStop();
        AppMethodBeat.o(66660);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(66660);
    }
    TXCLog.e(a, "onRecordStop:no callback");
    AppMethodBeat.o(66660);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(66653);
    b();
    this.c = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.l = true;
    this.k = new Thread(this, "AudioSysRecord Thread");
    this.k.start();
    AppMethodBeat.o(66653);
  }
  
  /* Error */
  public void a(h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 227
    //   4: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +16 -> 24
    //   11: aload_0
    //   12: aconst_null
    //   13: putfield 89	com/tencent/liteav/audio/impl/Record/f:j	Ljava/lang/ref/WeakReference;
    //   16: ldc 227
    //   18: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: new 91	java/lang/ref/WeakReference
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 230	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   33: putfield 89	com/tencent/liteav/audio/impl/Record/f:j	Ljava/lang/ref/WeakReference;
    //   36: ldc 227
    //   38: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -20 -> 21
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	f
    //   0	49	1	paramh	h
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   11	21	44	finally
    //   24	41	44	finally
  }
  
  public void b()
  {
    AppMethodBeat.i(66654);
    this.l = false;
    long l1 = System.currentTimeMillis();
    if ((this.k != null) && (this.k.isAlive()) && (Thread.currentThread().getId() != this.k.getId())) {}
    try
    {
      this.k.join();
      TXCLog.i(a, "stop record cost time(MS): " + (System.currentTimeMillis() - l1));
      this.k = null;
      AppMethodBeat.o(66654);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e(a, "record stop Exception: " + localException.getMessage());
      }
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = this.l;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    AppMethodBeat.i(66661);
    if (!this.l)
    {
      TXCLog.w(a, "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(66661);
      return;
    }
    f();
    d();
    int m = 0;
    int n = 0;
    while ((this.l) && (!Thread.interrupted()) && (this.h != null) && (n <= 5))
    {
      System.currentTimeMillis();
      int i1 = this.h.read(this.i, m, this.i.length - m);
      if (i1 != this.i.length - m)
      {
        if (i1 <= 0)
        {
          TXCLog.e(a, "read pcm eror, len =".concat(String.valueOf(i1)));
          n += 1;
        }
        else
        {
          m += i1;
        }
      }
      else
      {
        a(this.i, this.i.length, TXCTimeUtil.getTimeTick());
        m = 0;
        n = 0;
      }
    }
    e();
    if (n > 5)
    {
      a(-1, "read data failed!");
      AppMethodBeat.o(66661);
      return;
    }
    g();
    AppMethodBeat.o(66661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.f
 * JD-Core Version:    0.7.0.1
 */