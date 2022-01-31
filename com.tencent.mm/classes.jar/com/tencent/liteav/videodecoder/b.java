package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  implements com.tencent.liteav.basic.c.a, d
{
  boolean a = true;
  boolean b = true;
  boolean c = false;
  boolean d = false;
  Surface e;
  d f;
  private int g;
  private ByteBuffer h;
  private ByteBuffer i;
  private long j;
  private boolean k = false;
  private ArrayList<com.tencent.liteav.basic.f.b> l = new ArrayList();
  private b.a m;
  private WeakReference<com.tencent.liteav.basic.c.a> n;
  
  private void b(com.tencent.liteav.basic.f.b paramb)
  {
    if (paramb.b == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("iframe", bool);
      ((Bundle)localObject).putByteArray("nal", paramb.a);
      ((Bundle)localObject).putLong("pts", paramb.g);
      ((Bundle)localObject).putLong("dts", paramb.h);
      ((Bundle)localObject).putInt("codecId", paramb.i);
      paramb = new Message();
      paramb.what = 101;
      paramb.setData((Bundle)localObject);
      localObject = this.m;
      if (localObject != null) {
        ((Handler)localObject).sendMessage(paramb);
      }
      this.g += 1;
      return;
    }
  }
  
  public int a(SurfaceTexture paramSurfaceTexture, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    return a(new Surface(paramSurfaceTexture), paramByteBuffer1, paramByteBuffer2, paramBoolean);
  }
  
  public int a(Surface paramSurface, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    this.e = paramSurface;
    this.h = paramByteBuffer1;
    this.i = paramByteBuffer2;
    this.a = paramBoolean;
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f != null) {
      this.f.a(paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3)
  {
    if (this.f != null) {
      this.f.a(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3);
    }
    if (this.g > 0) {
      this.g -= 1;
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.f != null) {
      this.f.a(paramSurfaceTexture, paramInt1, paramInt2, paramLong1, paramLong2);
    }
    if (this.g > 0) {
      this.g -= 1;
    }
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.n = new WeakReference(parama);
  }
  
  public void a(com.tencent.liteav.basic.f.b paramb)
  {
    try
    {
      if (paramb.b == 0) {}
      for (int i1 = 1;; i1 = 0)
      {
        if ((!this.d) && (i1 == 0))
        {
          TXCLog.i("TXCVideoDecoder", "play:decode: push nal ignore p frame when not got i frame");
          return;
        }
        if ((!this.d) && (i1 != 0))
        {
          TXCLog.w("TXCVideoDecoder", "play:decode: push first i frame");
          this.d = true;
        }
        if ((!this.k) && (paramb.i == 1) && (!this.b))
        {
          TXCLog.w("TXCVideoDecoder", "play:decode: hevc decode error  ");
          com.tencent.liteav.basic.util.a.a(this.n, -2304, "h265解码失败");
          this.k = true;
        }
        if (this.m != null)
        {
          if (!this.l.isEmpty())
          {
            Iterator localIterator = this.l.iterator();
            while (localIterator.hasNext()) {
              b((com.tencent.liteav.basic.f.b)localIterator.next());
            }
          }
          this.l.clear();
          b(paramb);
          return;
        }
        if ((i1 != 0) && (!this.l.isEmpty())) {
          this.l.clear();
        }
        this.l.add(paramb);
        if (!this.k) {
          b();
        }
        return;
      }
      return;
    }
    catch (Exception paramb) {}
  }
  
  public void a(d paramd)
  {
    this.f = paramd;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    b.a locala = this.m;
    if ((locala != null) && (!locala.d) && (locala.a != null)) {
      ((TXCVideoFfmpegDecoder)locala.a).loadNativeData(paramArrayOfByte, paramLong, paramInt);
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b()
  {
    if ((this.b) && (this.e == null))
    {
      TXCLog.i("TXCVideoDecoder", "play:decode: start decoder error when not setup surface");
      return -1;
    }
    try
    {
      if (this.m != null)
      {
        TXCLog.e("TXCVideoDecoder", "play:decode: start decoder error when decoder is started");
        return -1;
      }
    }
    finally {}
    this.g = 0;
    this.k = false;
    Object localObject2 = new HandlerThread("VDecoder");
    ((HandlerThread)localObject2).start();
    ((HandlerThread)localObject2).setName("VDecoder" + ((HandlerThread)localObject2).getId());
    localObject2 = new b.a(((HandlerThread)localObject2).getLooper());
    ((b.a)localObject2).a(this.c, this.b, this.e, this.h, this.i, this, this);
    TXCLog.w("TXCVideoDecoder", "play:decode: start decode thread");
    Object localObject3 = Message.obtain();
    ((Message)localObject3).what = 100;
    ((Message)localObject3).obj = Boolean.valueOf(this.a);
    ((b.a)localObject2).sendMessage((Message)localObject3);
    this.m = ((b.a)localObject2);
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("EVT_ID", 2008);
    ((Bundle)localObject3).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
    if (this.b)
    {
      localObject2 = "启动硬解";
      ((Bundle)localObject3).putCharSequence("EVT_MSG", (CharSequence)localObject2);
      if (!this.b) {
        break label263;
      }
    }
    label263:
    for (int i1 = 1;; i1 = 2)
    {
      ((Bundle)localObject3).putInt("EVT_PARAM1", i1);
      com.tencent.liteav.basic.util.a.a(this.n, this.j, 2008, (Bundle)localObject3);
      return 0;
      localObject2 = "启动软解";
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    int i2 = 1;
    for (;;)
    {
      try
      {
        this.b = paramBoolean;
        this.l.clear();
        this.d = false;
        this.g = 0;
        Message localMessage = Message.obtain();
        localMessage.what = 103;
        if (this.b)
        {
          i1 = 1;
          localMessage.arg1 = i1;
          if (!this.a) {
            break label100;
          }
          i1 = i2;
          localMessage.arg2 = i1;
          if (this.m != null) {
            this.m.sendMessage(localMessage);
          }
          return;
        }
      }
      finally {}
      int i1 = 0;
      continue;
      label100:
      i1 = 0;
    }
  }
  
  public void c()
  {
    try
    {
      if (this.m != null) {
        this.m.sendEmptyMessage(102);
      }
      this.m = null;
      this.l.clear();
      this.d = false;
      this.g = 0;
      return;
    }
    finally {}
  }
  
  public int d()
  {
    return this.g + this.l.size();
  }
  
  public boolean e()
  {
    b.a locala = this.m;
    if (locala != null) {
      return locala.a();
    }
    return false;
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    com.tencent.liteav.basic.util.a.a(this.n, this.j, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.b
 * JD-Core Version:    0.7.0.1
 */