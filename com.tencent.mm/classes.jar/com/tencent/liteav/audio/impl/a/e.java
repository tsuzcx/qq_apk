package com.tencent.liteav.audio.impl.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class e
  implements Runnable
{
  private static final String a;
  private static e b;
  private Context c;
  private int d = 48000;
  private int e = 1;
  private int f = 16;
  private int g = 0;
  private AudioRecord h;
  private byte[] i = null;
  private WeakReference<f> j;
  private Thread k = null;
  private boolean l = false;
  private boolean m = false;
  
  static
  {
    AppMethodBeat.i(16409);
    a = "AudioCenter:" + e.class.getSimpleName();
    b = null;
    AppMethodBeat.o(16409);
  }
  
  public static e a()
  {
    AppMethodBeat.i(16398);
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new e();
      }
      e locale = b;
      AppMethodBeat.o(16398);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(16398);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    AppMethodBeat.i(16405);
    f localf = null;
    try
    {
      if (this.j != null) {
        localf = (f)this.j.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordError(paramInt, paramString);
        AppMethodBeat.o(16405);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16405);
    }
    TXCLog.e(a, "onRecordError:no callback");
    AppMethodBeat.o(16405);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16404);
    f localf = null;
    try
    {
      if (this.j != null) {
        localf = (f)this.j.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        AppMethodBeat.o(16404);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16404);
    }
    TXCLog.e(a, "onRecordPcmData:no callback");
    AppMethodBeat.o(16404);
  }
  
  private void c()
  {
    AppMethodBeat.i(16402);
    int i2 = this.d;
    int i3 = this.e;
    int i4 = this.f;
    int i5 = this.g;
    TXCLog.i(a, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5) }));
    int n = 12;
    if (i3 == 1) {
      n = 16;
    }
    if (i4 == 8) {}
    int i6;
    for (int i1 = 3;; i1 = 2)
    {
      i6 = AudioRecord.getMinBufferSize(i2, n, i1);
      if (i5 == 1) {}
      for (;;)
      {
        try
        {
          TXCLog.i(a, "audio record type: system aec");
          if (this.c != null) {
            ((AudioManager)this.c.getSystemService("audio")).setMode(3);
          }
          this.h = new AudioRecord(7, i2, n, i1, i6 * 2);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          continue;
          n = i3 * 1024 * i4 / 8;
          if (n <= i6) {
            continue;
          }
          this.i = new byte[i6];
          TXCLog.i(a, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6), Integer.valueOf(this.i.length), Integer.valueOf(this.h.getState()) }));
          if (this.h == null) {
            continue;
          }
          try
          {
            this.h.startRecording();
            AppMethodBeat.o(16402);
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(a, "mic startRecording failed.");
            a(-1, "start recording failed!");
            AppMethodBeat.o(16402);
            return;
          }
          this.i = new byte[n];
          continue;
          AppMethodBeat.o(16402);
          return;
        }
        if ((this.h != null) && (this.h.getState() == 1)) {
          continue;
        }
        TXCLog.e(a, "audio record: initialize the mic failed.");
        d();
        a(-1, "没有麦克风权限!");
        AppMethodBeat.o(16402);
        return;
        TXCLog.i(a, "audio record type: system normal");
        this.h = new AudioRecord(1, i2, n, i1, i6 * 2);
      }
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(16403);
    if (this.h != null) {
      TXCLog.i(a, "stop mic");
    }
    try
    {
      this.h.setRecordPositionUpdateListener(null);
      this.h.stop();
      this.h.release();
      ((AudioManager)this.c.getSystemService("audio")).setMode(0);
      label59:
      this.h = null;
      this.i = null;
      this.m = false;
      AppMethodBeat.o(16403);
      return;
    }
    catch (Exception localException)
    {
      break label59;
    }
  }
  
  private void e()
  {
    AppMethodBeat.i(16406);
    f localf = null;
    try
    {
      if (this.j != null) {
        localf = (f)this.j.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStart();
        AppMethodBeat.o(16406);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16406);
    }
    TXCLog.e(a, "onRecordStart:no callback");
    AppMethodBeat.o(16406);
  }
  
  private void f()
  {
    AppMethodBeat.i(16407);
    f localf = null;
    try
    {
      if (this.j != null) {
        localf = (f)this.j.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStop();
        AppMethodBeat.o(16407);
        return;
      }
    }
    finally
    {
      AppMethodBeat.o(16407);
    }
    TXCLog.e(a, "onRecordStop:no callback");
    AppMethodBeat.o(16407);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(16400);
    a(true);
    this.c = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.l = true;
    this.k = new Thread(this, "AudioSysRecord Thread");
    this.k.start();
    AppMethodBeat.o(16400);
  }
  
  /* Error */
  public void a(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16399
    //   5: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +17 -> 26
    //   12: aload_0
    //   13: aconst_null
    //   14: putfield 89	com/tencent/liteav/audio/impl/a/e:j	Ljava/lang/ref/WeakReference;
    //   17: sipush 16399
    //   20: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: new 91	java/lang/ref/WeakReference
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 224	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   35: putfield 89	com/tencent/liteav/audio/impl/a/e:j	Ljava/lang/ref/WeakReference;
    //   38: sipush 16399
    //   41: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -21 -> 23
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	e
    //   0	52	1	paramf	f
    // Exception table:
    //   from	to	target	type
    //   2	8	47	finally
    //   12	23	47	finally
    //   26	44	47	finally
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16401);
    this.l = false;
    long l1 = System.currentTimeMillis();
    if ((this.k != null) && (this.k.isAlive()) && (Thread.currentThread().getId() != this.k.getId())) {}
    try
    {
      this.k.join();
      TXCLog.i(a, "stop record cost time(MS): " + (System.currentTimeMillis() - l1));
      this.k = null;
      AppMethodBeat.o(16401);
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
  
  public boolean b()
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
    AppMethodBeat.i(16408);
    if (!this.l)
    {
      TXCLog.w(a, "audio record: abandom start audio sys record thread!");
      AppMethodBeat.o(16408);
      return;
    }
    e();
    c();
    int n = 0;
    int i1 = 0;
    while ((this.l) && (!Thread.interrupted()) && (this.h != null) && (i1 <= 5))
    {
      System.currentTimeMillis();
      int i2 = this.h.read(this.i, n, this.i.length - n);
      if (i2 != this.i.length - n)
      {
        if (i2 <= 0)
        {
          TXCLog.e(a, "read pcm eror, len =".concat(String.valueOf(i2)));
          i1 += 1;
        }
        else
        {
          n += i2;
        }
      }
      else
      {
        if (!this.m)
        {
          a(-6, "采集到第一帧#");
          this.m = true;
        }
        a(this.i, this.i.length, TXCTimeUtil.getTimeTick());
        n = 0;
        i1 = 0;
      }
    }
    d();
    if (i1 > 5)
    {
      a(-1, "read data failed!");
      AppMethodBeat.o(16408);
      return;
    }
    f();
    AppMethodBeat.o(16408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.e
 * JD-Core Version:    0.7.0.1
 */