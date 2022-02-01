package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.d.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class e
  extends com.tencent.liteav.basic.module.a
  implements TextureView.SurfaceTextureListener
{
  private static final float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private long A;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private a F;
  private SurfaceTexture b;
  private int c;
  protected TextureView d;
  protected d e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected volatile int l;
  protected int m;
  protected int n;
  protected f o;
  WeakReference<com.tencent.liteav.basic.c.a> p;
  private com.tencent.liteav.basic.d.e q;
  private h r;
  private Surface s;
  private int t;
  private int u;
  private int[] v;
  private int w;
  private long x;
  private long y;
  private long z;
  
  public e()
  {
    AppMethodBeat.i(16795);
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.c = 800;
    this.t = 0;
    this.k = 0;
    this.l = -1;
    this.m = 0;
    this.n = 0;
    this.v = new int[5];
    this.w = 500;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = false;
    this.C = false;
    this.E = false;
    this.F = new a();
    this.D = false;
    AppMethodBeat.o(16795);
  }
  
  private long a(long paramLong)
  {
    AppMethodBeat.i(16819);
    long l1 = TXCTimeUtil.getTimeTick();
    if (paramLong > l1)
    {
      AppMethodBeat.o(16819);
      return 0L;
    }
    AppMethodBeat.o(16819);
    return l1 - paramLong;
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182261);
    if (paramInt2 / paramInt1 > paramBitmap.getHeight() / paramBitmap.getWidth()) {}
    for (float f1 = paramInt1 / paramBitmap.getWidth();; f1 = paramInt2 / paramBitmap.getHeight())
    {
      Object localObject = new Matrix();
      ((Matrix)localObject).preScale(f1, f1);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, false);
      paramBitmap.recycle();
      AppMethodBeat.o(182261);
      return localObject;
    }
  }
  
  private Bitmap a(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(182262);
    int i1 = 360 - (this.t + this.k) % 360;
    paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
    paramBitmap.recycle();
    paramBitmap = paramMatrix;
    if (i1 != 0)
    {
      paramBitmap = new Matrix();
      paramBitmap.setRotate(i1);
      paramBitmap = Bitmap.createBitmap(paramMatrix, 0, 0, paramMatrix.getWidth(), paramMatrix.getHeight(), paramBitmap, false);
      paramMatrix.recycle();
    }
    int i3;
    int i4;
    int i2;
    label126:
    float f1;
    float f2;
    if (this.u == 0)
    {
      i3 = paramBitmap.getWidth();
      i4 = paramBitmap.getHeight();
      if (paramInt1 < paramInt2)
      {
        i1 = 1;
        if (i3 >= i4) {
          break label217;
        }
        i2 = 1;
        if (i1 == i2) {
          break label311;
        }
        if (i1 == 0) {
          break label223;
        }
        f1 = i4 * paramInt1 / paramInt2;
        f2 = i3;
        paramMatrix = new Matrix();
        paramMatrix.preScale(paramInt1 / f1, paramInt1 / f1);
        paramMatrix = Bitmap.createBitmap(paramBitmap, (int)(0.5F * (f2 - f1)), 0, (int)f1, i4, paramMatrix, false);
        paramBitmap.recycle();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(182262);
      return paramMatrix;
      i1 = 0;
      break;
      label217:
      i2 = 0;
      break label126;
      label223:
      f1 = i3 / paramInt1 * paramInt2;
      f2 = i4;
      paramMatrix = new Matrix();
      paramMatrix.preScale(paramInt2 / f1, paramInt2 / f1);
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (int)((f2 - f1) * 0.5F), i3, (int)f1, null, false);
      paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, false);
      paramBitmap.recycle();
      continue;
      label311:
      paramMatrix = paramBitmap;
      if (paramInt1 != paramBitmap.getWidth())
      {
        paramMatrix = paramBitmap;
        if (paramInt2 != paramBitmap.getHeight())
        {
          paramMatrix = a(paramBitmap, paramInt1, paramInt2);
          continue;
          paramMatrix = paramBitmap;
          if (paramInt1 != paramBitmap.getWidth())
          {
            paramMatrix = paramBitmap;
            if (paramInt2 != paramBitmap.getHeight()) {
              paramMatrix = a(paramBitmap, paramInt1, paramInt2);
            }
          }
        }
      }
    }
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(16816);
    if ((this.r != null) && (this.r.a() != paramBoolean))
    {
      this.r.c();
      this.r = null;
    }
    if (this.r == null)
    {
      this.r = new h(Boolean.valueOf(paramBoolean));
      this.r.b();
    }
    int i3;
    int i4;
    if (paramArrayOfFloat != null)
    {
      this.r.a(paramArrayOfFloat);
      i3 = this.m;
      i4 = this.n;
      if (this.u != 0) {
        break label251;
      }
      this.r.a(h.a);
    }
    for (;;)
    {
      int i2 = (this.t + this.k) % 360;
      int i1 = i2;
      if (paramBoolean) {
        if (this.t != 90)
        {
          i1 = i2;
          if (this.t != 270) {}
        }
        else
        {
          i1 = (this.t + this.k + 180) % 360;
        }
      }
      this.r.b(i1);
      this.r.b(paramInt2, paramInt3);
      this.r.a(i3, i4);
      paramInt1 = this.r.d(paramInt1);
      AppMethodBeat.o(16816);
      return new int[] { paramInt1, i3, i4 };
      this.r.a(a);
      break;
      label251:
      this.r.a(h.b);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(16821);
    if (!this.D)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "渲染首个视频数据包(IDR)");
      ((Bundle)localObject).putInt("EVT_PARAM1", this.h);
      ((Bundle)localObject).putInt("EVT_PARAM2", this.i);
      com.tencent.liteav.basic.util.f.a(this.p, 2003, (Bundle)localObject);
      setStatusValue(6001, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
      TXCLog.i("TXCVideoRender", "trtc_render render first frame " + getID() + ", " + this.j);
      this.D = true;
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
      TXCKeyPointReportProxy.a(getID(), 40023, this.j);
    }
    Object localObject = this.F;
    ((a)localObject).c += 1L;
    n();
    if (this.F.d != 0L)
    {
      this.F.i = a(this.F.d);
      if (this.F.i > this.w)
      {
        localObject = this.F;
        ((a)localObject).e += 1L;
        setStatusValue(6003, this.j, Long.valueOf(this.F.e));
        if (this.F.i > this.F.h)
        {
          this.F.h = this.F.i;
          setStatusValue(6005, this.j, Long.valueOf(this.F.h));
        }
        localObject = this.F;
        ((a)localObject).g += this.F.i;
        setStatusValue(6006, this.j, Long.valueOf(this.F.g));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.F.c + " block time:" + this.F.i + "> 500");
        this.x += 1L;
        this.z += this.F.i;
      }
      if (this.F.i > this.c)
      {
        TXCLog.w("TXCVideoRender", "render frame count:" + this.F.c + " block time:" + this.F.i + "> " + this.c);
        com.tencent.liteav.basic.util.f.a(this.p, getID(), 2105, "当前视频播放出现卡顿" + this.F.i + "ms");
      }
      if (this.F.i > 1000L)
      {
        localObject = this.F;
        ((a)localObject).f += 1L;
        setStatusValue(6004, this.j, Long.valueOf(this.F.f));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.F.c + " block time:" + this.F.i + "> 1000");
      }
    }
    long l1 = TXCTimeUtil.getTimeTick();
    if (this.y == 0L) {
      this.y = l1;
    }
    for (;;)
    {
      this.F.d = TXCTimeUtil.getTimeTick();
      if (this.A == 0L) {
        this.A = this.F.d;
      }
      this.F.k = this.i;
      this.F.j = this.h;
      AppMethodBeat.o(16821);
      return;
      if (l1 - this.y >= 2000L)
      {
        setStatusValue(17015, this.j, Long.valueOf(this.x));
        setStatusValue(17016, this.j, Long.valueOf(this.z));
        if (this.A != 0L)
        {
          TXCKeyPointReportProxy.a(getID(), 40005, (int)this.z);
          TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.y));
        }
        this.x = 0L;
        this.y = l1;
        this.z = 0L;
      }
    }
  }
  
  private void b(Surface paramSurface)
  {
    AppMethodBeat.i(16813);
    TXCLog.i("TXCVideoRender", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
    if (this.s == paramSurface)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
      AppMethodBeat.o(16813);
      return;
    }
    this.s = paramSurface;
    this.l = 1;
    if (paramSurface != null)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set surface start render thread ".concat(String.valueOf(paramSurface)));
      c(null);
      AppMethodBeat.o(16813);
      return;
    }
    try
    {
      if (this.q != null)
      {
        TXCLog.i("TXCVideoRender", "surface-render: set surface stop render thread " + this.q);
        this.q.a();
        this.q = null;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(16813);
    }
  }
  
  private void b(TextureView paramTextureView)
  {
    int i2 = 0;
    AppMethodBeat.i(16808);
    if (paramTextureView != null) {
      this.l = 0;
    }
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
        if (this.d.getWidth() != 0) {
          this.f = this.d.getWidth();
        }
        if (this.d.getHeight() != 0) {
          this.g = this.d.getHeight();
        }
        this.e = new d(this.d);
        this.e.b(this.h, this.i);
        this.e.a(this.f, this.g);
        this.e.a(this.u);
        this.e.c((this.t + this.k) % 360);
        this.d.setSurfaceTextureListener(this);
        if (this.b != null)
        {
          if ((Build.VERSION.SDK_INT >= 16) && (this.d.getSurfaceTexture() != this.b))
          {
            TXCLog.w("TXCVideoRender", "play:vrender: setSurfaceTexture " + this.d + ", surfaceTexture " + this.b);
            this.d.setSurfaceTexture(this.b);
            AppMethodBeat.o(16808);
            return;
          }
          TXCLog.w("TXCVideoRender", "play:vrender: not setSurfaceTexture old surfaceTexture " + this.d.getSurfaceTexture() + ", new surfaceTexture " + this.b);
          AppMethodBeat.o(16808);
          return;
        }
        if (this.d.isAvailable()) {
          a(this.d.getSurfaceTexture());
        }
      }
    }
    AppMethodBeat.o(16808);
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
    AppMethodBeat.i(16809);
    if (((this.h != paramInt1) || (this.i != paramInt2)) && ((this.h != paramInt1) || (this.i != paramInt2)))
    {
      this.h = paramInt1;
      this.i = paramInt2;
      if (this.e != null) {
        this.e.b(this.h, this.i);
      }
    }
    AppMethodBeat.o(16809);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(16800);
    a(paramInt2, paramInt3);
    AppMethodBeat.o(16800);
  }
  
  protected void a(SurfaceTexture paramSurfaceTexture)
  {
    this.B = true;
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(16798);
    b(paramSurface);
    AppMethodBeat.o(16798);
  }
  
  public void a(TextureView paramTextureView)
  {
    AppMethodBeat.i(16797);
    b(paramTextureView);
    AppMethodBeat.o(16797);
  }
  
  public void a(com.tencent.liteav.basic.c.a parama)
  {
    AppMethodBeat.i(16796);
    this.p = new WeakReference(parama);
    AppMethodBeat.o(16796);
  }
  
  public void a(final o paramo)
  {
    AppMethodBeat.i(187381);
    final TextureView localTextureView = this.d;
    if (localTextureView != null) {
      try
      {
        final Bitmap localBitmap = localTextureView.getBitmap();
        if (localBitmap != null) {
          AsyncTask.execute(new Runnable()
          {
            public void run()
            {
              Object localObject = null;
              AppMethodBeat.i(16755);
              try
              {
                Bitmap localBitmap = e.a(e.this, this.a, localBitmap, localTextureView.getWidth(), localTextureView.getHeight());
                localObject = localBitmap;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  TXCLog.w("TXCVideoRender", "takePhoto error ".concat(String.valueOf(localException)));
                }
              }
              catch (Error localError)
              {
                for (;;)
                {
                  TXCLog.w("TXCVideoRender", "takePhoto error ".concat(String.valueOf(localError)));
                }
              }
              if (paramo != null) {
                paramo.onTakePhotoComplete(localObject);
              }
              AppMethodBeat.o(16755);
            }
          });
        }
        AppMethodBeat.o(187381);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
    if (this.q != null)
    {
      this.q.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16920);
          if (e.a(e.this) != null) {
            e.a(e.this).a(paramo);
          }
          AppMethodBeat.o(16920);
        }
      });
      AppMethodBeat.o(187381);
      return;
    }
    if (paramo != null) {
      paramo.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(187381);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16799);
    if (paramInt3 != this.k)
    {
      this.k = paramInt3;
      d(this.t);
    }
    a(paramInt1, paramInt2);
    b();
    AppMethodBeat.o(16799);
  }
  
  public void a(f paramf)
  {
    this.o = paramf;
  }
  
  protected void a(Object paramObject, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(187385);
    if (this.l == 1)
    {
      paramArrayOfFloat = a(paramInt, this.h, this.i, paramArrayOfFloat, paramBoolean);
      paramInt = paramArrayOfFloat[0];
      int i1 = paramArrayOfFloat[1];
      int i2 = paramArrayOfFloat[2];
      System.arraycopy(paramArrayOfFloat, 0, this.v, 0, 3);
      if (paramBoolean)
      {
        this.v[3] = 1;
        this.v[4] = 180;
      }
      for (;;)
      {
        try
        {
          if (this.s != null)
          {
            if ((this.q != null) && (this.q.b() != this.s))
            {
              TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface surface change stop render thread " + this.q + ", " + this.q.b() + ", " + this.s);
              this.q.a();
              this.q = null;
            }
            if ((this.q == null) && (this.l == 1))
            {
              this.q = new com.tencent.liteav.basic.d.e();
              TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface start render thread " + this.q);
              this.q.a(paramObject, this.s);
            }
            if ((this.q != null) && (this.l == 1))
            {
              if (paramBoolean) {
                this.q.a(paramInt, true, 180, this.m, this.n, i1, i2, false, false);
              }
            }
            else
            {
              return;
              this.v[3] = 0;
              this.v[4] = 0;
              break;
            }
            this.q.a(paramInt, false, 0, this.m, this.n, i1, i2, false, false);
            continue;
          }
          if (this.q == null) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(187385);
        }
        TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface stop render thread " + this.q);
        this.q.a();
        this.q = null;
      }
    }
    AppMethodBeat.o(187385);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16802);
    int i1;
    String str2;
    int i2;
    if (this.C)
    {
      i1 = hashCode();
      str2 = getID();
      i2 = this.j;
      if (!paramBoolean) {
        break label181;
      }
    }
    for (String str1 = "true";; str1 = "false")
    {
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]", new Object[] { Integer.valueOf(i1), str2, Integer.valueOf(i2), str1 }), "streamType: 2-big, 3-small, 7-sub", 0);
      this.C = false;
      this.D = false;
      this.E = false;
      if ((!paramBoolean) || (this.l != 1)) {
        break;
      }
      this.l = -1;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
      e();
      try
      {
        if (this.q != null)
        {
          TXCLog.i("TXCVideoRender", "surface-render:stop render thread " + this.q);
          this.q.a();
          this.q = null;
        }
        return;
      }
      finally
      {
        label181:
        AppMethodBeat.o(16802);
      }
    }
    AppMethodBeat.o(16802);
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      this.c = paramInt;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16803);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(16803);
  }
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    this.B = false;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16804);
    this.u = paramInt;
    if (this.e != null) {
      this.e.a(paramInt);
    }
    AppMethodBeat.o(16804);
  }
  
  public void c(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(16817);
    TXCLog.i("TXCVideoRender", "surface-render: set setSurfaceSize " + paramInt1 + "*" + paramInt2);
    if ((paramInt1 != this.m) || (paramInt2 != this.n))
    {
      if ((this.q != null) && (this.l == 1) && (this.v != null))
      {
        this.q.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(182260);
            e.this.m = paramInt1;
            e.this.n = paramInt2;
            com.tencent.liteav.basic.d.e locale;
            int i;
            if (e.a(e.this) != null)
            {
              locale = e.a(e.this);
              i = e.b(e.this)[0];
              if (e.b(e.this)[3] != 1) {
                break label125;
              }
            }
            label125:
            for (boolean bool = true;; bool = false)
            {
              locale.a(i, bool, e.b(e.this)[4], e.this.m, e.this.n, e.b(e.this)[1], e.b(e.this)[2], true, false);
              AppMethodBeat.o(182260);
              return;
            }
          }
        });
        AppMethodBeat.o(16817);
        return;
      }
      this.m = paramInt1;
      this.n = paramInt2;
    }
    AppMethodBeat.o(16817);
  }
  
  public void c(Object paramObject) {}
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(16805);
    this.t = paramInt;
    if (this.e != null) {
      this.e.c((this.k + paramInt) % 360);
    }
    AppMethodBeat.o(16805);
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  public void f()
  {
    AppMethodBeat.i(187382);
    Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
    this.C = true;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.E = true;; this.E = false)
    {
      this.D = false;
      m();
      AppMethodBeat.o(187382);
      return;
    }
  }
  
  public int g()
  {
    AppMethodBeat.i(187383);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getWidth();
      AppMethodBeat.o(187383);
      return i1;
    }
    if (this.s != null)
    {
      i1 = this.m;
      AppMethodBeat.o(187383);
      return i1;
    }
    AppMethodBeat.o(187383);
    return 0;
  }
  
  public int h()
  {
    AppMethodBeat.i(16806);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getHeight();
      AppMethodBeat.o(16806);
      return i1;
    }
    if (this.s != null)
    {
      i1 = this.n;
      AppMethodBeat.o(16806);
      return i1;
    }
    AppMethodBeat.o(16806);
    return 0;
  }
  
  public int i()
  {
    AppMethodBeat.i(16807);
    int i1 = this.h;
    AppMethodBeat.o(16807);
    return i1;
  }
  
  public int j()
  {
    return this.i;
  }
  
  protected void k() {}
  
  protected void l()
  {
    AppMethodBeat.i(187384);
    try
    {
      if (this.q != null)
      {
        TXCLog.i("TXCVideoRender", "surface-render: onRenderThreadEGLDestroy stop render thread " + this.q);
        this.q.a();
        this.q = null;
      }
      if (this.r != null)
      {
        this.r.c();
        this.r = null;
      }
      AppMethodBeat.o(187384);
      return;
    }
    finally
    {
      AppMethodBeat.o(187384);
    }
  }
  
  public void m()
  {
    AppMethodBeat.i(16814);
    this.F.a = 0L;
    this.F.b = 0L;
    this.F.c = 0L;
    this.F.d = 0L;
    this.F.e = 0L;
    this.F.f = 0L;
    this.F.g = 0L;
    this.F.h = 0L;
    this.F.i = 0L;
    this.F.j = 0;
    this.F.k = 0;
    setStatusValue(6001, this.j, Long.valueOf(0L));
    setStatusValue(6002, this.j, Double.valueOf(0.0D));
    setStatusValue(6003, this.j, Long.valueOf(0L));
    setStatusValue(6005, this.j, Long.valueOf(0L));
    setStatusValue(6006, this.j, Long.valueOf(0L));
    setStatusValue(6004, this.j, Long.valueOf(0L));
    AppMethodBeat.o(16814);
  }
  
  public void n()
  {
    AppMethodBeat.i(16818);
    if (this.F.a == 0L)
    {
      this.F.a = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(16818);
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.F.a;
    if (l1 >= 1000L)
    {
      double d1 = (this.F.c - this.F.b) * 1000.0D / l1;
      setStatusValue(6002, this.j, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1);
      this.F.b = this.F.c;
      a locala = this.F;
      locala.a = (l1 + locala.a);
    }
    AppMethodBeat.o(16818);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16810);
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
    }
    for (;;)
    {
      this.B = true;
      AppMethodBeat.o(16810);
      return;
      a(paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16812);
    try
    {
      this.B = false;
      TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.E + "id " + getID() + "_" + this.j);
      if (this.E) {
        this.b = paramSurfaceTexture;
      }
      label75:
      while (this.b == null)
      {
        AppMethodBeat.o(16812);
        return true;
        this.F.a = 0L;
        b(paramSurfaceTexture);
        if (paramSurfaceTexture == this.b) {
          this.b = null;
        }
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      break label75;
      AppMethodBeat.o(16812);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16811);
    TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + paramInt1 + "," + paramInt2 + " old:" + this.f + "," + this.g);
    if (!this.B)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
      this.B = true;
      a(paramSurfaceTexture);
    }
    this.f = paramInt1;
    this.g = paramInt2;
    if (this.e != null) {
      this.e.a(this.f, this.g);
    }
    AppMethodBeat.o(16811);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public static class a
  {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public int j;
    public int k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */