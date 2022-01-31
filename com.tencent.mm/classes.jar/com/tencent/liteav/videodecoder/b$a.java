package com.tencent.liteav.videodecoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

class b$a
  extends Handler
{
  a a;
  d b;
  WeakReference<com.tencent.liteav.basic.c.a> c;
  boolean d;
  boolean e;
  Surface f;
  private ByteBuffer g;
  private ByteBuffer h;
  
  public b$a(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.a != null)
    {
      TXCLog.i("TXCVideoDecoder", "play:decode: start decode ignore hwdec: " + this.d);
      return;
    }
    if (this.d) {}
    for (this.a = new c();; this.a = new TXCVideoFfmpegDecoder())
    {
      this.a.setListener(this.b);
      this.a.setNotifyListener(this.c);
      this.a.config(this.f);
      this.a.start(this.g, this.h, paramBoolean, this.e);
      TXCLog.w("TXCVideoDecoder", "play:decode: start decode hwdec: " + this.d + ", hevc: " + this.e);
      return;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    TXCLog.w("TXCVideoDecoder", "play:decode: restart decode hwdec: " + this.d);
    if (this.a != null)
    {
      this.a.stop();
      this.a.setListener(null);
      this.a.setNotifyListener(null);
      this.a = null;
    }
    a(paramBoolean2);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt)
  {
    b localb = new b();
    localb.a = paramArrayOfByte;
    localb.g = paramLong1;
    localb.h = paramLong2;
    localb.i = paramInt;
    if (this.a != null) {
      this.a.decode(localb);
    }
  }
  
  private void b()
  {
    if (this.a != null)
    {
      this.a.stop();
      this.a.setListener(null);
      this.a.setNotifyListener(null);
      this.a = null;
    }
    Looper.myLooper().quit();
    TXCLog.w("TXCVideoDecoder", "play:decode: stop decode hwdec: " + this.d);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, d paramd, com.tencent.liteav.basic.c.a parama)
  {
    this.e = paramBoolean1;
    this.d = paramBoolean2;
    this.f = paramSurface;
    this.g = paramByteBuffer1;
    this.h = paramByteBuffer2;
    this.b = paramd;
    this.c = new WeakReference(parama);
  }
  
  public boolean a()
  {
    if (this.a != null) {
      return this.a.isHevc();
    }
    return false;
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      a(((Boolean)paramMessage.obj).booleanValue());
      return;
    case 101: 
      try
      {
        paramMessage = paramMessage.getData();
        a(paramMessage.getByteArray("nal"), paramMessage.getLong("pts"), paramMessage.getLong("dts"), paramMessage.getInt("codecId"));
        return;
      }
      catch (Exception paramMessage)
      {
        return;
      }
    case 102: 
      b();
      return;
    }
    boolean bool1;
    if (paramMessage.arg1 == 1)
    {
      bool1 = true;
      if (paramMessage.arg2 != 1) {
        break label123;
      }
    }
    for (;;)
    {
      a(bool1, bool2);
      return;
      bool1 = false;
      break;
      label123:
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.b.a
 * JD-Core Version:    0.7.0.1
 */