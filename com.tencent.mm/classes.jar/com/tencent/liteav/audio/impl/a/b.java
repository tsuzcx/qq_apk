package com.tencent.liteav.audio.impl.a;

import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public abstract class b
{
  protected int a;
  protected int b;
  private WeakReference<f> c;
  
  protected void a()
  {
    f localf = null;
    try
    {
      if (this.c != null) {
        localf = (f)this.c.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStart();
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordStart:no callback");
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    f localf = null;
    try
    {
      if (this.c != null) {
        localf = (f)this.c.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordPCM(paramArrayOfByte, paramInt, paramLong);
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordPcmData:no callback");
  }
  
  protected void b()
  {
    f localf = null;
    try
    {
      if (this.c != null) {
        localf = (f)this.c.get();
      }
      if (localf != null)
      {
        localf.onAudioRecordStop();
        return;
      }
    }
    finally {}
    TXCLog.e("AudioCenter:TXCAudioBaseRecord", "onRecordStop:no callback");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.b
 * JD-Core Version:    0.7.0.1
 */