package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

public class e
  extends com.tencent.liteav.basic.module.a
  implements TextureView.SurfaceTextureListener
{
  private static final float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private long A;
  private boolean B;
  private boolean C;
  private e.a D;
  private SurfaceTexture b;
  private int c;
  protected TextureView d;
  protected d e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected volatile int k;
  protected int l;
  protected int m;
  protected f n;
  WeakReference<com.tencent.liteav.basic.c.a> o;
  private com.tencent.liteav.basic.d.d p;
  private h q;
  private Surface r;
  private int s;
  private int t;
  private int u;
  private int[] v;
  private int w;
  private long x;
  private long y;
  private long z;
  
  public e()
  {
    AppMethodBeat.i(67273);
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.c = 800;
    this.s = 0;
    this.t = 0;
    this.k = -1;
    this.l = 0;
    this.m = 0;
    this.w = 500;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.C = false;
    this.D = new e.a();
    this.B = false;
    AppMethodBeat.o(67273);
  }
  
  private long a(long paramLong)
  {
    AppMethodBeat.i(67298);
    long l1 = TXCTimeUtil.getTimeTick();
    if (paramLong > l1)
    {
      AppMethodBeat.o(67298);
      return 0L;
    }
    AppMethodBeat.o(67298);
    return l1 - paramLong;
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(146760);
    if ((this.q != null) && (this.q.a() != paramBoolean))
    {
      this.q.c();
      this.q = null;
    }
    if (this.q == null)
    {
      this.q = new h(Boolean.valueOf(paramBoolean));
      this.q.b();
    }
    int i1;
    int i2;
    if (paramArrayOfFloat != null)
    {
      this.q.a(paramArrayOfFloat);
      i1 = this.l;
      i2 = this.m;
      if (this.u != 0) {
        break label202;
      }
      this.q.a(h.a);
    }
    for (;;)
    {
      int i3 = this.s;
      int i4 = this.t;
      this.q.b((i3 + i4) % 360);
      this.q.b(paramInt2, paramInt3);
      this.q.a(i1, i2);
      paramInt1 = this.q.d(paramInt1);
      AppMethodBeat.o(146760);
      return new int[] { paramInt1, i1, i2 };
      this.q.a(a);
      break;
      label202:
      this.q.a(h.b);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(67299);
    if (!this.B)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "渲染首个视频数据包(IDR)");
      ((Bundle)localObject).putInt("EVT_PARAM1", this.h);
      ((Bundle)localObject).putInt("EVT_PARAM2", this.i);
      b.a(this.o, 2003, (Bundle)localObject);
      setStatusValue(6001, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
      TXCLog.d("TXCVideoRender", "trtc_render render first frame " + getID() + ", " + this.j);
      this.B = true;
    }
    Object localObject = this.D;
    ((e.a)localObject).c += 1L;
    r();
    if (this.D.d != 0L)
    {
      this.D.i = a(this.D.d);
      if (this.D.i > this.w)
      {
        localObject = this.D;
        ((e.a)localObject).e += 1L;
        setStatusValue(6003, this.j, Long.valueOf(this.D.e));
        if (this.D.i > this.D.h)
        {
          this.D.h = this.D.i;
          setStatusValue(6005, this.j, Long.valueOf(this.D.h));
        }
        localObject = this.D;
        ((e.a)localObject).g += this.D.i;
        setStatusValue(6006, this.j, Long.valueOf(this.D.g));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.D.c + " block time:" + this.D.i + "> 500");
        this.x += 1L;
        this.z += this.D.i;
      }
      if (this.D.i > this.c) {
        TXCLog.w("TXCVideoRender", "render frame count:" + this.D.c + " block time:" + this.D.i + "> " + this.c);
      }
      if (this.D.i > 1000L)
      {
        localObject = this.D;
        ((e.a)localObject).f += 1L;
        setStatusValue(6004, this.j, Long.valueOf(this.D.f));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.D.c + " block time:" + this.D.i + "> 1000");
        b.a(this.o, getID(), 2105, "当前视频播放出现卡顿" + this.D.i + "ms");
      }
    }
    long l1 = TXCTimeUtil.getTimeTick();
    if (this.y == 0L) {
      this.y = l1;
    }
    for (;;)
    {
      this.D.d = TXCTimeUtil.getTimeTick();
      if (this.A == 0L) {
        this.A = this.D.d;
      }
      this.D.k = this.i;
      this.D.j = this.h;
      AppMethodBeat.o(67299);
      return;
      if (l1 - this.y >= 2000L)
      {
        setStatusValue(17015, this.j, Long.valueOf(this.x));
        setStatusValue(17016, this.j, Long.valueOf(this.z));
        this.x = 0L;
        this.y = l1;
        this.z = 0L;
        if (this.A != 0L)
        {
          TXCKeyPointReportProxy.a(getID(), 40005, (int)this.D.g);
          TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.A));
        }
      }
    }
  }
  
  private void b(Surface paramSurface)
  {
    AppMethodBeat.i(67292);
    TXCLog.i("TXCVideoRender", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
    if (this.r == paramSurface)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
      AppMethodBeat.o(67292);
      return;
    }
    this.r = paramSurface;
    this.k = 1;
    if (paramSurface != null)
    {
      g();
      AppMethodBeat.o(67292);
      return;
    }
    try
    {
      if (this.p != null)
      {
        this.p.a();
        this.p = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(67292);
    }
  }
  
  private void b(TextureView paramTextureView)
  {
    int i2 = 0;
    AppMethodBeat.i(67287);
    this.k = 0;
    int i1;
    if ((this.d != null) || (paramTextureView == null))
    {
      i1 = i2;
      if (this.d != null)
      {
        i1 = i2;
        if (this.d.equals(paramTextureView)) {}
      }
    }
    else
    {
      i1 = 1;
    }
    TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.d + ",new=" + paramTextureView + "id " + getID() + "_" + this.j);
    if (i1 != 0)
    {
      if ((this.d != null) && (this.b == null))
      {
        b(this.d.getSurfaceTexture());
        this.d.setSurfaceTextureListener(null);
      }
      this.d = paramTextureView;
      if (this.d != null)
      {
        this.f = this.d.getWidth();
        this.g = this.d.getHeight();
        this.e = new d(this.d);
        this.e.b(this.h, this.i);
        this.e.a(this.f, this.g);
        this.e.a(this.u);
        this.e.c((this.s + this.t) % 360);
        this.d.setSurfaceTextureListener(this);
        if (this.b != null)
        {
          if ((Build.VERSION.SDK_INT >= 16) && (this.d.getSurfaceTexture() != this.b))
          {
            this.d.setSurfaceTexture(this.b);
            AppMethodBeat.o(67287);
          }
        }
        else if (this.d.isAvailable()) {
          a(this.d.getSurfaceTexture());
        }
      }
    }
    AppMethodBeat.o(67287);
  }
  
  public SurfaceTexture a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67288);
    if (((this.h != paramInt1) || (this.i != paramInt2)) && ((this.h != paramInt1) || (this.i != paramInt2)))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      if (this.e != null) {
        this.e.b(this.h, this.i);
      }
    }
    AppMethodBeat.o(67288);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(67279);
    a(paramInt2, paramInt3);
    AppMethodBeat.o(67279);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture) {}
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(67276);
    b(paramSurface);
    AppMethodBeat.o(67276);
  }
  
  public void a(TextureView paramTextureView)
  {
    AppMethodBeat.i(67275);
    b(paramTextureView);
    AppMethodBeat.o(67275);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(146757);
    this.o = new WeakReference(parama);
    AppMethodBeat.o(146757);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(146758);
    if (paramInt3 != this.t)
    {
      this.t = paramInt3;
      d(this.s);
    }
    a(paramInt1, paramInt2);
    b();
    AppMethodBeat.o(146758);
  }
  
  public void a(f paramf)
  {
    this.n = paramf;
  }
  
  protected void a(EGLContext paramEGLContext, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(67294);
    if (this.k == 1)
    {
      paramArrayOfFloat = a(paramInt, this.h, this.i, paramArrayOfFloat, paramBoolean);
      this.v = paramArrayOfFloat;
      paramInt = paramArrayOfFloat[0];
      int i1 = paramArrayOfFloat[1];
      int i2 = paramArrayOfFloat[2];
      for (;;)
      {
        try
        {
          if (this.r != null)
          {
            if ((this.p != null) && (this.p.b() != this.r))
            {
              this.p.a();
              this.p = null;
            }
            if ((this.p == null) && (this.k == 1))
            {
              this.p = new com.tencent.liteav.basic.d.d();
              this.p.a(paramEGLContext, this.r);
            }
            if ((this.p != null) && (this.k == 1))
            {
              if (paramBoolean) {
                this.p.a(paramInt, true, 180, this.l, this.m, i1, i2, false);
              }
            }
            else {
              return;
            }
            this.p.a(paramInt, false, 0, this.l, this.m, i1, i2, false);
            continue;
          }
          if (this.p == null) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(67294);
        }
        this.p.a();
        this.p = null;
      }
    }
    AppMethodBeat.o(67294);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(67283);
    if (paramInt > 0) {
      this.c = paramInt;
    }
    AppMethodBeat.o(67283);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67282);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(67282);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture) {}
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(67284);
    this.u = paramInt;
    if (this.e != null) {
      this.e.a(paramInt);
    }
    AppMethodBeat.o(67284);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67296);
    if ((paramInt1 != this.l) || (paramInt2 != this.m))
    {
      if ((this.p != null) && (this.k == 1) && (this.v != null))
      {
        this.p.a(new e.1(this, paramInt1, paramInt2));
        AppMethodBeat.o(67296);
        return;
      }
      this.l = paramInt1;
      this.m = paramInt2;
    }
    AppMethodBeat.o(67296);
  }
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(146759);
    this.s = paramInt;
    if (this.e != null) {
      this.e.c((this.t + paramInt) % 360);
    }
    AppMethodBeat.o(146759);
  }
  
  public void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  protected void g() {}
  
  protected void h() {}
  
  public void i()
  {
    AppMethodBeat.i(67280);
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.C = true;; this.C = false)
    {
      this.B = false;
      q();
      AppMethodBeat.o(67280);
      return;
    }
  }
  
  public void j()
  {
    AppMethodBeat.i(67281);
    this.B = false;
    this.C = false;
    this.v = null;
    if (this.k == 1)
    {
      this.k = -1;
      h();
      try
      {
        if (this.p != null)
        {
          this.p.a();
          this.p = null;
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(67281);
      }
    }
    AppMethodBeat.o(67281);
  }
  
  public int k()
  {
    AppMethodBeat.i(67285);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getWidth();
      AppMethodBeat.o(67285);
      return i1;
    }
    if (this.r != null)
    {
      i1 = this.l;
      AppMethodBeat.o(67285);
      return i1;
    }
    AppMethodBeat.o(67285);
    return 0;
  }
  
  public int l()
  {
    AppMethodBeat.i(67286);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getHeight();
      AppMethodBeat.o(67286);
      return i1;
    }
    if (this.r != null)
    {
      i1 = this.m;
      AppMethodBeat.o(67286);
      return i1;
    }
    AppMethodBeat.o(67286);
    return 0;
  }
  
  public int m()
  {
    return this.h;
  }
  
  public int n()
  {
    return this.i;
  }
  
  protected void o() {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67289);
    TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + paramSurfaceTexture + "id " + getID() + "_" + this.j);
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.e != null) {
      this.e.a(this.f, this.g);
    }
    if (this.b != null)
    {
      if ((Build.VERSION.SDK_INT >= 16) && (this.d.getSurfaceTexture() != this.b)) {
        this.d.setSurfaceTexture(this.b);
      }
      this.b = null;
      AppMethodBeat.o(67289);
      return;
    }
    a(paramSurfaceTexture);
    AppMethodBeat.o(67289);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(67291);
    try
    {
      TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.C + "id " + getID() + "_" + this.j);
      if (this.C) {
        this.b = paramSurfaceTexture;
      }
      label69:
      while (this.b == null)
      {
        AppMethodBeat.o(67291);
        return true;
        this.D.a = 0L;
        b(paramSurfaceTexture);
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      break label69;
      AppMethodBeat.o(67291);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67290);
    TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + paramInt1 + "," + paramInt2 + " old:" + this.f + "," + this.g);
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.e != null) {
      this.e.a(this.f, this.g);
    }
    AppMethodBeat.o(67290);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  protected void p()
  {
    AppMethodBeat.i(67293);
    try
    {
      if (this.p != null)
      {
        this.p.a();
        this.p = null;
      }
      if (this.q != null)
      {
        this.q.c();
        this.q = null;
      }
      AppMethodBeat.o(67293);
      return;
    }
    finally
    {
      AppMethodBeat.o(67293);
    }
  }
  
  public void q()
  {
    AppMethodBeat.i(67297);
    this.D.a = 0L;
    this.D.b = 0L;
    this.D.c = 0L;
    this.D.d = 0L;
    this.D.e = 0L;
    this.D.f = 0L;
    this.D.g = 0L;
    this.D.h = 0L;
    this.D.i = 0L;
    this.D.j = 0;
    this.D.k = 0;
    setStatusValue(6001, this.j, Long.valueOf(0L));
    setStatusValue(6002, this.j, Double.valueOf(0.0D));
    setStatusValue(6003, this.j, Long.valueOf(0L));
    setStatusValue(6005, this.j, Long.valueOf(0L));
    setStatusValue(6006, this.j, Long.valueOf(0L));
    setStatusValue(6004, this.j, Long.valueOf(0L));
    AppMethodBeat.o(67297);
  }
  
  public void r()
  {
    AppMethodBeat.i(146761);
    if (this.D.a == 0L)
    {
      this.D.a = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(146761);
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.D.a;
    if (l1 >= 1000L)
    {
      double d1 = (this.D.c - this.D.b) * 1000.0D / l1;
      setStatusValue(6002, this.j, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1);
      this.D.b = this.D.c;
      e.a locala = this.D;
      locala.a = (l1 + locala.a);
    }
    AppMethodBeat.o(146761);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */