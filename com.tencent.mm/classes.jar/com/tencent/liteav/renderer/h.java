package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;

public class h
  extends com.tencent.liteav.basic.module.a
  implements TextureView.SurfaceTextureListener
{
  private SurfaceTexture a;
  private long b;
  protected TextureView c;
  protected g d;
  protected int e = 0;
  protected int f = 0;
  protected int g = 0;
  protected int h = 0;
  protected i i;
  WeakReference<com.tencent.liteav.basic.c.a> j;
  private int k = 800;
  private boolean l = false;
  private boolean m = false;
  private h.a n = new h.a();
  
  private long a(long paramLong)
  {
    long l1 = TXCTimeUtil.getTimeTick();
    if (paramLong > l1) {
      return 0L;
    }
    return l1 - paramLong;
  }
  
  private void b()
  {
    if (!this.l)
    {
      com.tencent.liteav.basic.util.a.a(this.j, this.b, 2003, "渲染首个视频数据包(IDR)");
      setStatusValue(6001, Long.valueOf(TXCTimeUtil.getTimeTick()));
      this.l = true;
    }
    h.a locala = this.n;
    locala.c += 1L;
    if (this.n.a == 0L) {
      this.n.a = TXCTimeUtil.getTimeTick();
    }
    for (;;)
    {
      if (this.n.d != 0L)
      {
        this.n.i = a(this.n.d);
        if (this.n.i > 500L)
        {
          locala = this.n;
          locala.e += 1L;
          setStatusValue(6003, Long.valueOf(this.n.e));
          if (this.n.i > this.n.h)
          {
            this.n.h = this.n.i;
            setStatusValue(6005, Long.valueOf(this.n.h));
          }
          locala = this.n;
          locala.g += this.n.i;
          setStatusValue(6006, Long.valueOf(this.n.g));
          TXCLog.w("TXCVideoRender", "render frame count:" + this.n.c + " block time:" + this.n.i + "> 500");
        }
        if (this.n.i > this.k) {
          TXCLog.w("TXCVideoRender", "render frame count:" + this.n.c + " block time:" + this.n.i + "> " + this.k);
        }
        if (this.n.i > 1000L)
        {
          locala = this.n;
          locala.f += 1L;
          setStatusValue(6004, Long.valueOf(this.n.f));
          TXCLog.w("TXCVideoRender", "render frame count:" + this.n.c + " block time:" + this.n.i + "> 1000");
          com.tencent.liteav.basic.util.a.a(this.j, this.b, 2105, "当前视频播放出现卡顿" + this.n.i + "ms");
        }
      }
      this.n.d = TXCTimeUtil.getTimeTick();
      this.n.k = this.h;
      this.n.j = this.g;
      return;
      long l1 = TXCTimeUtil.getTimeTick() - this.n.a;
      if (l1 >= 1000L)
      {
        setStatusValue(6002, Double.valueOf((this.n.c - this.n.b) * 1000.0D / l1));
        this.n.b = this.n.c;
        locala = this.n;
        locala.a = (l1 + locala.a);
      }
    }
  }
  
  private void b(TextureView paramTextureView)
  {
    int i2 = 0;
    int i1;
    if ((this.c != null) || (paramTextureView == null))
    {
      i1 = i2;
      if (this.c != null)
      {
        i1 = i2;
        if (this.c.equals(paramTextureView)) {}
      }
    }
    else
    {
      i1 = 1;
    }
    TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.c + ",new=" + paramTextureView);
    if (i1 != 0)
    {
      if ((this.c != null) && (this.a == null)) {
        b(this.c.getSurfaceTexture());
      }
      this.c = paramTextureView;
      if (this.c != null)
      {
        this.e = this.c.getWidth();
        this.f = this.c.getHeight();
        this.d = new g(this.c);
        this.d.b(this.g, this.h);
        this.d.a(this.e, this.f);
        this.c.setSurfaceTextureListener(this);
        if (this.a == null) {
          break label227;
        }
        if ((Build.VERSION.SDK_INT >= 16) && (this.c.getSurfaceTexture() != this.a)) {
          this.c.setSurfaceTexture(this.a);
        }
      }
    }
    label227:
    while (!this.c.isAvailable()) {
      return;
    }
    a(this.c.getSurfaceTexture());
  }
  
  public SurfaceTexture a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0) {
      this.k = paramInt;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (((this.g != paramInt1) || (this.h != paramInt2)) && ((this.g != paramInt1) || (this.h != paramInt2)))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      if (this.d != null) {
        this.d.b(this.g, this.h);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    a(paramInt2, paramInt3);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    b();
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture) {}
  
  public void a(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    b();
  }
  
  public void a(TextureView paramTextureView)
  {
    b(paramTextureView);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    this.j = new WeakReference(parama);
  }
  
  public void a(i parami)
  {
    this.i = parami;
  }
  
  public void b(int paramInt)
  {
    if (this.d != null) {
      this.d.a(paramInt);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture) {}
  
  public void c(int paramInt)
  {
    if (this.d != null) {
      this.d.c(paramInt);
    }
  }
  
  public void g()
  {
    this.m = true;
    this.l = false;
    l();
  }
  
  public void h()
  {
    this.l = false;
    this.m = false;
  }
  
  public TextureView i()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.g;
  }
  
  public int k()
  {
    return this.h;
  }
  
  public void l()
  {
    this.n.a = 0L;
    this.n.b = 0L;
    this.n.c = 0L;
    this.n.d = 0L;
    this.n.e = 0L;
    this.n.f = 0L;
    this.n.g = 0L;
    this.n.h = 0L;
    this.n.i = 0L;
    this.n.j = 0;
    this.n.k = 0;
    setStatusValue(6001, Long.valueOf(0L));
    setStatusValue(6002, Double.valueOf(0.0D));
    setStatusValue(6003, Long.valueOf(0L));
    setStatusValue(6005, Long.valueOf(0L));
    setStatusValue(6006, Long.valueOf(0L));
    setStatusValue(6004, Long.valueOf(0L));
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + paramSurfaceTexture);
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.d != null) {
      this.d.a(this.e, this.f);
    }
    if (this.a != null)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (this.c.getSurfaceTexture() != this.a)) {
        this.c.setSurfaceTexture(this.a);
      }
      this.a = null;
      return;
    }
    a(paramSurfaceTexture);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.m);
      if (this.m) {
        this.a = paramSurfaceTexture;
      }
      label36:
      while (this.a == null)
      {
        return true;
        this.n.a = 0L;
        b(paramSurfaceTexture);
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      break label36;
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + paramInt1 + "," + paramInt2 + " old:" + this.e + "," + this.f);
    this.e = paramInt1;
    this.f = paramInt2;
    if (this.d != null) {
      this.d.a(this.e, this.f);
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.renderer.h
 * JD-Core Version:    0.7.0.1
 */