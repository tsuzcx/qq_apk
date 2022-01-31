package com.tencent.liteav.audio.impl.Record;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

public class f
  implements Runnable
{
  private static final String a = "AudioCenter:" + f.class.getSimpleName();
  private static f b = null;
  private Context c;
  private int d = 48000;
  private int e = 1;
  private int f = 16;
  private int g = TXEAudioDef.TXE_AEC_NONE;
  private AudioRecord h;
  private byte[] i = null;
  private WeakReference<h> j;
  private Thread k = null;
  private boolean l = false;
  
  public static f a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new f();
      }
      return b;
    }
    finally {}
  }
  
  private void a(int paramInt, String paramString)
  {
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordError(paramInt, paramString);
        return;
      }
    }
    finally {}
    TXCLog.e(a, "onRecordError:no callback");
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        return;
      }
    }
    finally {}
    TXCLog.e(a, "onRecordPcmData:no callback");
  }
  
  private void d()
  {
    int i1 = this.d;
    int i2 = this.e;
    int i3 = this.f;
    int i4 = this.g;
    TXCLog.i(a, String.format("audio record sampleRate = %d, channels = %d, bits = %d, aectype = %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4) }));
    if (i2 == 1) {}
    for (int m = 2;; m = 3)
    {
      if (i3 == 8) {}
      for (int n = 3;; n = 2)
      {
        int i5 = AudioRecord.getMinBufferSize(i1, m, n);
        for (;;)
        {
          try
          {
            if (i4 != TXEAudioDef.TXE_AEC_SYSTEM) {
              continue;
            }
            TXCLog.i(a, "audio record type: system aec");
            if (this.c != null) {
              ((AudioManager)this.c.getSystemService("audio")).setMode(3);
            }
            this.h = new AudioRecord(7, i1, m, n, i5 * 2);
            if (this.c != null) {
              ((AudioManager)this.c.getSystemService("audio")).setMode(0);
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            continue;
            m = i2 * 1024 * i3 / 8;
            if (m <= i5) {
              break label384;
            }
          }
          if ((this.h != null) && (this.h.getState() == 1)) {
            continue;
          }
          TXCLog.e(a, "audio record: initialize the mic failed.");
          e();
          a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "open mic failed!");
          return;
          TXCLog.i(a, "audio record type: system normal");
          this.h = new AudioRecord(1, i1, m, n, i5 * 2);
        }
        label384:
        for (this.i = new byte[i5];; this.i = new byte[m])
        {
          TXCLog.i(a, String.format("audio record: mic open rate=%dHZ, channels=%d, bits=%d, buffer=%d/%d, state=%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(this.i.length), Integer.valueOf(this.h.getState()) }));
          if (this.h == null) {
            break;
          }
          try
          {
            this.h.startRecording();
            return;
          }
          catch (Exception localException)
          {
            TXCLog.e(a, "mic startRecording failed.");
            a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "start recording failed!");
            return;
          }
        }
      }
    }
  }
  
  private void e()
  {
    if (this.h != null) {
      TXCLog.i(a, "stop mic");
    }
    try
    {
      this.h.setRecordPositionUpdateListener(null);
      this.h.stop();
      this.h.release();
      label37:
      this.h = null;
      this.i = null;
      return;
    }
    catch (Exception localException)
    {
      break label37;
    }
  }
  
  private void f()
  {
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStart();
        return;
      }
    }
    finally {}
    TXCLog.e(a, "onRecordStart:no callback");
  }
  
  private void g()
  {
    h localh = null;
    try
    {
      if (this.j != null) {
        localh = (h)this.j.get();
      }
      if (localh != null)
      {
        localh.onAudioRecordStop();
        return;
      }
    }
    finally {}
    TXCLog.e(a, "onRecordStop:no callback");
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b();
    this.c = paramContext;
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    this.l = true;
    this.k = new Thread(this, "AudioSysRecord Thread");
    this.k.start();
  }
  
  public void a(h paramh)
  {
    if (paramh == null) {}
    for (;;)
    {
      try
      {
        this.j = null;
        return;
      }
      finally {}
      this.j = new WeakReference(paramh);
    }
  }
  
  public void b()
  {
    this.l = false;
    long l1 = System.currentTimeMillis();
    if ((this.k != null) && (this.k.isAlive()) && (Thread.currentThread().getId() != this.k.getId())) {}
    try
    {
      this.k.join();
      TXCLog.i(a, "stop record cost time(MS): " + (System.currentTimeMillis() - l1));
      this.k = null;
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
    if (!this.l)
    {
      TXCLog.w(a, "audio record: abandom start audio sys record thread!");
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
          TXCLog.e(a, "read pcm eror, len =" + i1);
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
      a(TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT, "read data failed!");
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Record.f
 * JD-Core Version:    0.7.0.1
 */