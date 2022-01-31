package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class a
  implements com.tencent.liteav.beauty.d, com.tencent.liteav.videoencoder.d
{
  private static final String a = a.class.getSimpleName();
  private int b = 300;
  private long c = 0L;
  private a.a d;
  private HandlerThread e;
  private boolean f = false;
  private com.tencent.liteav.videoencoder.b g;
  private com.tencent.liteav.basic.f.b h;
  private c i = null;
  private ByteBuffer j = null;
  private Bitmap k = null;
  private int l = 0;
  private int m = 0;
  private WeakReference<b> n = null;
  
  public a(b paramb)
  {
    this.n = new WeakReference(paramb);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1;
    if (paramInt1 > 0) {
      if (paramInt1 >= 8) {
        i1 = 8;
      }
    }
    for (this.b = (1000 / i1);; this.b = 200)
    {
      long l1 = paramInt2;
      if (paramInt2 <= 0) {
        break label67;
      }
      this.c = (l1 * 1000L + System.currentTimeMillis());
      return;
      i1 = paramInt1;
      if (paramInt1 > 3) {
        break;
      }
      i1 = 3;
      break;
    }
    label67:
    this.c = (System.currentTimeMillis() + 300000L);
  }
  
  private void c()
  {
    d();
    this.e = new HandlerThread("TXImageCapturer");
    this.e.start();
    this.d = new a.a(this, this.e.getLooper(), this.b, this.c);
  }
  
  private void d()
  {
    if (this.d != null)
    {
      this.d.removeCallbacksAndMessages(null);
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.quit();
      this.e = null;
    }
  }
  
  private void e()
  {
    try
    {
      if ((this.n != null) && (this.f))
      {
        b localb = (b)this.n.get();
        if (localb != null)
        {
          Bitmap localBitmap = this.k;
          ByteBuffer localByteBuffer2 = this.j;
          ByteBuffer localByteBuffer1 = localByteBuffer2;
          if (localByteBuffer2 == null)
          {
            localByteBuffer1 = localByteBuffer2;
            if (localBitmap != null)
            {
              localByteBuffer1 = ByteBuffer.allocateDirect(localBitmap.getWidth() * localBitmap.getHeight() * 4);
              localBitmap.copyPixelsToBuffer(localByteBuffer1);
              localByteBuffer1.rewind();
              this.j = localByteBuffer1;
            }
          }
          if ((localBitmap != null) && (localByteBuffer1 != null)) {
            localb.a(localBitmap, localByteBuffer1, this.l, this.m);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return 0;
  }
  
  public void a()
  {
    this.f = false;
    this.j = null;
    this.k = null;
    TXCLog.w(a, "bkgpush: stop background publish");
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    }
    this.f = true;
    b(paramInt1, paramInt2);
    c();
    if (this.d != null) {
      this.d.sendEmptyMessageDelayed(1001, this.b);
    }
    TXCLog.w(a, "bkgpush: start background publish with time:" + (this.c - System.currentTimeMillis()) / 1000L + ", interval:" + this.b);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    TXCLog.w(a, "bkgpush: got texture");
    if (this.g != null) {
      this.g.a(paramInt1, paramInt2, paramInt3, TXCTimeUtil.getTimeTick());
    }
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4)
  {
    if (this.f)
    {
      TXCLog.w(a, "bkgpush: start background publish return when started");
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {}
    try
    {
      TXCLog.w(a, "bkgpush: background publish img is empty, add default img");
      paramBitmap = new ColorDrawable(-16777216);
      localBitmap = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      paramBitmap.draw(new Canvas(localBitmap));
      TXCLog.w(a, "bkgpush: generate bitmap");
      this.k = localBitmap;
    }
    catch (Error paramBitmap)
    {
      break label80;
    }
    catch (Exception paramBitmap)
    {
      label80:
      break label80;
    }
    this.l = paramInt3;
    this.m = paramInt4;
    a(paramInt1, paramInt2);
  }
  
  public void a(MediaFormat paramMediaFormat) {}
  
  public void a(com.tencent.liteav.basic.f.b paramb, int paramInt)
  {
    this.h = paramb;
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder("bkgpush: got nal type: ");
    Object localObject = paramb;
    if (paramb != null) {
      localObject = Integer.valueOf(paramb.b);
    }
    TXCLog.w(str, localObject);
    if (this.g != null)
    {
      this.g.a(null);
      paramb = this.g;
    }
    try
    {
      if (this.n != null)
      {
        localObject = (b)this.n.get();
        if (localObject != null) {
          ((b)localObject).a(paramb);
        }
      }
      return;
    }
    catch (Exception paramb) {}
  }
  
  public void a(EGLContext paramEGLContext, Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    TXCLog.w(a, "bkgpush: generate background push");
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {}
    for (;;)
    {
      try
      {
        TXCLog.w(a, "bkgpush: background publish img is empty, add default img");
        paramBitmap = new ColorDrawable(-16777216);
        localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramBitmap.draw(new Canvas(localBitmap));
        TXCLog.w(a, "bkgpush: generate nal");
        paramBitmap = new TXSVideoEncoderParam();
        paramBitmap.width = paramInt1;
        paramBitmap.height = paramInt2;
        paramBitmap.fps = 1;
        paramBitmap.gop = 1;
        paramBitmap.enableBFrame = false;
        paramBitmap.realTime = true;
        paramBitmap.encoderProfile = 1;
        paramBitmap.encoderMode = 1;
        paramBitmap.glContext = paramEGLContext;
        this.g = new com.tencent.liteav.videoencoder.b(2);
        this.g.a(this);
        this.g.a(paramBitmap);
        if ((paramInt1 != 720) && (paramInt1 != 1280)) {
          continue;
        }
        this.g.a(1800);
        int i1 = localBitmap.getWidth();
        int i2 = localBitmap.getHeight();
        paramEGLContext = ByteBuffer.allocateDirect(i1 * i2 * 4);
        localBitmap.copyPixelsToBuffer(paramEGLContext);
        paramEGLContext.rewind();
        if (this.i == null)
        {
          this.i = new c(paramContext, true);
          this.i.a(this);
        }
        paramContext = com.tencent.liteav.basic.util.a.a(i1, i2, paramInt1, paramInt2);
        this.i.a(paramContext);
        this.i.a(false);
        this.i.a(paramInt1, paramInt2);
        this.i.a(0);
        this.i.a(paramEGLContext.array(), i1, i2, 0, 2, 0);
        this.i.a();
        this.i.a(null);
        this.i = null;
        return;
      }
      catch (Error paramEGLContext)
      {
        return;
        if (paramInt1 == 960) {
          continue;
        }
        if (paramInt1 != 544) {
          continue;
        }
        continue;
      }
      catch (Exception paramEGLContext) {}
      this.g.a(1200);
      continue;
      this.g.a(800);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, long paramLong) {}
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(Bitmap paramBitmap, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
    
    public abstract void a(com.tencent.liteav.videoencoder.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteav.a
 * JD-Core Version:    0.7.0.1
 */