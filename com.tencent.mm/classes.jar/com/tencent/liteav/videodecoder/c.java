package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class c
  implements a
{
  private MediaCodec.BufferInfo a = new MediaCodec.BufferInfo();
  private MediaCodec b = null;
  private String c = "video/avc";
  private int d = 540;
  private int e = 960;
  private long f = 0L;
  private long g = 0L;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private Surface k = null;
  private int l = 0;
  private ArrayList<b> m = new ArrayList();
  private d n;
  private WeakReference<com.tencent.liteav.basic.c.a> o;
  
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    i1 = 1;
    i3 = -1;
    for (;;)
    {
      try
      {
        if ((this.b != null) || (this.k == null))
        {
          TXCLog.e("MediaCodecDecoder", "decode: init decoder error, can not init for decoder=" + this.b + ",surface=" + this.k);
          return -1;
        }
        this.j = paramBoolean;
        if (this.j)
        {
          this.c = "video/hevc";
          localMediaFormat = MediaFormat.createVideoFormat(this.c, this.d, this.e);
          if (paramByteBuffer1 != null) {
            localMediaFormat.setByteBuffer("csd-0", paramByteBuffer1);
          }
          if (paramByteBuffer2 != null) {
            localMediaFormat.setByteBuffer("csd-1", paramByteBuffer2);
          }
          this.b = MediaCodec.createDecoderByType(this.c);
        }
      }
      catch (Exception paramByteBuffer1)
      {
        MediaFormat localMediaFormat;
        i1 = 0;
        i2 = i3;
        continue;
      }
      try
      {
        this.b.configure(localMediaFormat, this.k, null, 0);
        i1 = 2;
        this.b.setVideoScalingMode(1);
        i1 = 3;
        this.b.start();
        i2 = 4;
        i1 = i2;
        TXCLog.w("MediaCodecDecoder", "decode: start decoder success, is hevc: " + this.j);
        try
        {
          this.l = 0;
          return 0;
        }
        catch (Exception paramByteBuffer1)
        {
          i3 = 0;
          i1 = i2;
          i2 = i3;
        }
      }
      catch (Exception paramByteBuffer1)
      {
        i2 = i3;
        continue;
      }
      if (this.b != null) {}
      try
      {
        this.b.release();
        TXCLog.w("MediaCodecDecoder", "decode: , decoder release success");
      }
      catch (Exception paramByteBuffer2)
      {
        TXCLog.e("MediaCodecDecoder", "decode: , decoder release exception: " + paramByteBuffer1.toString());
        this.b = null;
        continue;
      }
      finally
      {
        this.b = null;
      }
      TXCLog.e("MediaCodecDecoder", "decode: init decoder " + i1 + " step exception: " + paramByteBuffer1.toString());
      f();
      return i2;
      this.c = "video/avc";
    }
  }
  
  private void a()
  {
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.stop();
        TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
      }
      catch (Exception localException2)
      {
        TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + localException2.toString());
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
          this.b = null;
          continue;
        }
        catch (Exception localException3)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException3.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
        }
      }
      finally
      {
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
        }
        catch (Exception localException4)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException4.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
        }
      }
      try
      {
        this.b.release();
        TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
      }
      catch (Exception localException1)
      {
        TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException1.toString());
        this.b = null;
      }
      finally
      {
        this.b = null;
      }
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    this.b.releaseOutputBuffer(paramInt, true);
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.d("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.n != null) {
        this.n.a(null, this.d, this.e, paramLong1, paramLong2);
      }
      label56:
      d();
      return;
    }
    catch (Exception localException)
    {
      break label56;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if (!this.i) {}
    }
    else
    {
      return;
    }
    if ((this.j) && (!e()))
    {
      a();
      f();
      return;
    }
    a();
    a(null, null, this.j);
  }
  
  @TargetApi(16)
  private void b()
  {
    if (this.b == null)
    {
      TXCLog.e("MediaCodecDecoder", "null decoder");
      return;
    }
    b localb = (b)this.m.get(0);
    if ((localb == null) || (localb.a.length == 0))
    {
      TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
      this.m.remove(0);
      return;
    }
    ByteBuffer[] arrayOfByteBuffer = this.b.getInputBuffers();
    if ((arrayOfByteBuffer == null) || (arrayOfByteBuffer.length == 0))
    {
      TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
      return;
    }
    int i1;
    try
    {
      i1 = this.b.dequeueInputBuffer(10000L);
      if (i1 >= 0)
      {
        arrayOfByteBuffer[i1].put(localb.a);
        this.b.queueInputBuffer(i1, 0, localb.a.length, localb.g, 0);
        this.m.remove(0);
        if (this.f == 0L) {
          TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: " + i1);
        }
      }
    }
    catch (Exception localException2)
    {
      try
      {
        for (;;)
        {
          i1 = this.b.dequeueOutputBuffer(this.a, 10000L);
          if (i1 < 0) {
            break;
          }
          a(i1, this.a.presentationTimeUs, this.a.presentationTimeUs);
          this.l = 0;
          return;
          localException2 = localException2;
          TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + localException2);
          i1 = -10000;
          continue;
          TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          g();
          TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!" + localException1);
          i1 = -10000;
        }
      }
    }
    if (i1 == -1) {}
    try
    {
      Thread.sleep(10L);
      label297:
      TXCLog.d("MediaCodecDecoder", "decode: no output from decoder available when timeout");
      g();
      return;
      if (i1 == -3)
      {
        TXCLog.d("MediaCodecDecoder", "decode: output buffers changed");
        return;
      }
      if (i1 == -2)
      {
        c();
        return;
      }
      TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: " + i1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label297;
    }
  }
  
  private void c()
  {
    MediaFormat localMediaFormat = this.b.getOutputFormat();
    TXCLog.d("MediaCodecDecoder", "decode output format changed: " + localMediaFormat);
    int i3 = Math.abs(localMediaFormat.getInteger("crop-right") - localMediaFormat.getInteger("crop-left"));
    int i1 = Math.abs(localMediaFormat.getInteger("crop-bottom") - localMediaFormat.getInteger("crop-top"));
    int i4 = localMediaFormat.getInteger("width");
    int i2 = localMediaFormat.getInteger("height");
    i3 = Math.min(i3 + 1, i4);
    i1 = Math.min(i1 + 1, i2);
    if ((i3 != this.d) || (i1 != this.e))
    {
      this.d = i3;
      this.e = i1;
    }
    try
    {
      if (this.n != null) {
        this.n.a(this.d, this.e);
      }
      label160:
      TXCLog.d("MediaCodecDecoder", "decode: video size change to w:" + i3 + ",h:" + i1);
      do
      {
        do
        {
          return;
        } while (!this.h);
        this.h = false;
      } while (this.n == null);
      this.n.a(this.d, this.e);
      return;
    }
    catch (Exception localException)
    {
      break label160;
    }
  }
  
  private void d()
  {
    if (this.f == 0L) {
      TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
    }
    long l1 = System.currentTimeMillis();
    if ((this.f > 0L) && (l1 > this.f + 1000L) && (l1 > this.g + 2000L) && (this.g != 0L))
    {
      TXCLog.e("MediaCodecDecoder", "frame interval[" + (l1 - this.f) + "] > 1000");
      this.g = l1;
    }
    if (this.g == 0L) {
      this.g = l1;
    }
    this.f = l1;
  }
  
  private boolean e()
  {
    Object localObject;
    int i3;
    int i1;
    String[] arrayOfString1;
    int i4;
    int i2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new MediaCodecList(1).getCodecInfos();
      i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfString1 = localObject[i1];
        String[] arrayOfString2 = arrayOfString1.getSupportedTypes();
        i4 = arrayOfString2.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString2[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + arrayOfString1.getName() + ",encoder:" + arrayOfString1.isEncoder());
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      return false;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i3 = MediaCodecList.getCodecCount();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = MediaCodecList.getCodecInfoAt(i1);
        arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
        i4 = arrayOfString1.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString1[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + ((MediaCodecInfo)localObject).getName() + ",encoder:" + ((MediaCodecInfo)localObject).isEncoder());
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void f()
  {
    if (!this.i)
    {
      TXCLog.w("MediaCodecDecoder", "decode hw decode error, hevc: " + this.j);
      if (!this.j) {
        break label58;
      }
      com.tencent.liteav.basic.util.a.a(this.o, -2304, "h265解码失败");
    }
    for (;;)
    {
      this.i = true;
      return;
      label58:
      com.tencent.liteav.basic.util.a.a(this.o, 2106, "硬解启动失败，采用软解");
    }
  }
  
  private void g()
  {
    if (this.l >= 40)
    {
      f();
      this.l = 0;
      return;
    }
    this.l += 1;
  }
  
  public int config(Surface paramSurface)
  {
    if (paramSurface == null) {
      return -1;
    }
    this.k = paramSurface;
    return 0;
  }
  
  public void decode(b paramb)
  {
    boolean bool = true;
    if (paramb.i == 1) {}
    for (;;)
    {
      a(bool);
      this.m.add(paramb);
      int i1;
      do
      {
        if (this.m.isEmpty()) {
          break;
        }
        i1 = this.m.size();
        b();
      } while (i1 != this.m.size());
      return;
      bool = false;
    }
  }
  
  public boolean isHevc()
  {
    return this.j;
  }
  
  public void setListener(d paramd)
  {
    this.n = paramd;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference)
  {
    this.o = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
  }
  
  public void stop()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.c
 * JD-Core Version:    0.7.0.1
 */