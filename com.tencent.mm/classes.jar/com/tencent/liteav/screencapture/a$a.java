package com.tencent.liteav.screencapture;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.d.e;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.util.TXCTimeUtil;

public class a$a
  extends Handler
{
  public int a = 0;
  public int[] b = null;
  public Surface c = null;
  public SurfaceTexture d = null;
  public int e = 720;
  public int f = 1280;
  public int g = 25;
  protected boolean h = false;
  protected long i = 0L;
  protected long j = 0L;
  protected com.tencent.liteav.basic.d.b k = null;
  protected e l = null;
  float[] m = new float[16];
  
  public a$a(a parama1, Looper paramLooper, a parama2)
  {
    super(paramLooper);
  }
  
  protected void a(Message paramMessage)
  {
    this.i = 0L;
    this.j = 0L;
    if (!a())
    {
      b();
      this.n.b();
      this.n.a(20000003, null);
      return;
    }
    this.n.a(0, this.k.c());
  }
  
  protected boolean a()
  {
    this.k = com.tencent.liteav.basic.d.b.a(null, null, null, this.e, this.f);
    if (this.k == null) {}
    do
    {
      return false;
      this.b = new int[1];
      this.b[0] = f.b();
      if (this.b[0] <= 0)
      {
        this.b = null;
        return false;
      }
      this.d = new SurfaceTexture(this.b[0]);
      this.c = new Surface(this.d);
      this.d.setDefaultBufferSize(this.e, this.f);
      this.d.setOnFrameAvailableListener(new a.a.1(this));
      this.l = new e();
    } while (!this.l.a());
    this.l.a(true);
    this.l.a(this.e, this.f);
    this.l.a(h.e, h.a(g.a, false, false));
    b.a().a(this.c, this.e, this.f);
    return true;
  }
  
  protected void b()
  {
    c();
    if (this.l != null)
    {
      this.l.d();
      this.l = null;
    }
    if (this.k != null)
    {
      this.k.b();
      this.k = null;
    }
  }
  
  protected void b(Message paramMessage)
  {
    paramMessage = this.n.c();
    if (paramMessage != null) {
      paramMessage.a(a.a(this.n));
    }
    b();
  }
  
  protected void c()
  {
    if (this.d != null)
    {
      this.d.setOnFrameAvailableListener(null);
      this.d.release();
      this.h = false;
      this.d = null;
    }
    b.a().a(this.c);
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
    if (this.b != null)
    {
      GLES20.glDeleteTextures(1, this.b, 0);
      this.b = null;
    }
  }
  
  protected void c(Message paramMessage)
  {
    this.n.a(102, 5L);
    if (!this.n.i) {}
    long l1;
    do
    {
      return;
      if (!this.h)
      {
        this.i = 0L;
        this.j = System.nanoTime();
        return;
      }
      l1 = System.nanoTime();
    } while (l1 < this.j + this.i * 1000L * 1000L * 1000L / this.g);
    if (this.j == 0L) {
      this.j = l1;
    }
    for (;;)
    {
      this.i += 1L;
      if ((this.d == null) || (this.b == null)) {
        break;
      }
      this.d.getTransformMatrix(this.m);
      this.d.updateTexImage();
      this.l.a(this.m);
      GLES20.glViewport(0, 0, this.e, this.f);
      int i1 = this.l.b(this.b[0]);
      this.n.a(0, i1, this.e, this.f, TXCTimeUtil.getTimeTick());
      return;
      if (l1 > this.j + 1000000000L)
      {
        this.i = 0L;
        this.j = l1;
      }
    }
  }
  
  protected void d(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.arg1 <= 0) {}
    for (int i1 = 1;; i1 = paramMessage.arg1)
    {
      this.g = i1;
      this.i = 0L;
      this.j = 0L;
      return;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {}
    for (;;)
    {
      return;
      if ((this.a == this.n.e) || (101 == paramMessage.what))
      {
        switch (paramMessage.what)
        {
        }
        while ((paramMessage != null) && (paramMessage.obj != null))
        {
          ((Runnable)paramMessage.obj).run();
          return;
          a(paramMessage);
          continue;
          c(paramMessage);
          continue;
          b(paramMessage);
          continue;
          d(paramMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.a
 * JD-Core Version:    0.7.0.1
 */