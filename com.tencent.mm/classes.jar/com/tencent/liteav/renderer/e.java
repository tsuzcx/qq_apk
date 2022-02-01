package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.g;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class e
  extends a
  implements TextureView.SurfaceTextureListener
{
  private static final float[] a = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  private long A;
  private long B;
  private long C;
  private long D;
  private boolean E;
  private boolean F;
  private boolean G;
  private boolean H;
  private a I;
  private SurfaceTexture b;
  private int c;
  protected boolean d;
  protected TextureView e;
  protected d f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected volatile int m;
  protected int n;
  protected int o;
  protected f p;
  WeakReference<b> q;
  private g r;
  private h s;
  private Surface t;
  private int u;
  private int v;
  private int w;
  private int[] x;
  private int y;
  private long z;
  
  public e()
  {
    AppMethodBeat.i(16795);
    this.d = false;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.c = 800;
    this.u = 0;
    this.l = 0;
    this.m = -1;
    this.n = 0;
    this.o = 0;
    this.x = new int[5];
    this.y = 500;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = false;
    this.F = false;
    this.H = false;
    this.I = new a();
    this.G = false;
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
    int i1 = 360 - (this.u + this.l) % 360;
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
    if (this.v == 0)
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
    if ((this.s != null) && (this.s.a() != paramBoolean))
    {
      this.s.c();
      this.s = null;
    }
    if (this.s == null)
    {
      this.s = new h(Boolean.valueOf(paramBoolean));
      this.s.b();
    }
    int i3;
    int i4;
    if (paramArrayOfFloat != null)
    {
      this.s.a(paramArrayOfFloat);
      i3 = this.n;
      i4 = this.o;
      if (this.v != 0) {
        break label267;
      }
      this.s.a(h.a);
      label110:
      if (this.w != 1) {
        break label280;
      }
      this.s.a(true);
    }
    for (;;)
    {
      int i2 = (this.u + this.l) % 360;
      int i1 = i2;
      if (paramBoolean) {
        if (this.u != 90)
        {
          i1 = i2;
          if (this.u != 270) {}
        }
        else
        {
          i1 = (this.u + this.l + 180) % 360;
        }
      }
      this.s.b(i1);
      this.s.b(paramInt2, paramInt3);
      this.s.a(i3, i4);
      paramInt1 = this.s.d(paramInt1);
      AppMethodBeat.o(16816);
      return new int[] { paramInt1, i3, i4 };
      this.s.a(a);
      break;
      label267:
      this.s.a(h.b);
      break label110;
      label280:
      this.s.a(false);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(16821);
    if (!this.G)
    {
      setStatusValue(6001, this.k, Long.valueOf(TXCTimeUtil.getTimeTick()));
      setStatusValue(6010, this.k, Integer.valueOf(this.i));
      setStatusValue(6011, this.k, Integer.valueOf(this.j));
      TXCLog.i("TXCVideoRender", "[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:" + hashCode() + " id:" + getID() + " type:" + this.k);
      this.G = true;
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.k) }), "streamType: 2-big, 3-small, 7-sub", 0);
      TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.k);
    }
    if (!this.I.o)
    {
      AppMethodBeat.o(16821);
      return;
    }
    a locala = this.I;
    locala.c += 1L;
    o();
    long l1 = a(this.I.n);
    if (this.I.d != 0L)
    {
      this.I.j = a(this.I.d);
      locala = this.I;
      locala.k += this.I.j;
      if (this.I.j > 200L)
      {
        locala = this.I;
        locala.e += 1L;
        setStatusValue(6009, this.k, Long.valueOf(this.I.e));
      }
      if (this.I.j > this.y)
      {
        locala = this.I;
        locala.f += 1L;
        setStatusValue(6003, this.k, Long.valueOf(this.I.f));
        if (this.I.j > this.I.i)
        {
          this.I.i = this.I.j;
          setStatusValue(6005, this.k, Long.valueOf(this.I.i));
        }
        TXCLog.w("TXCVideoRender", "render frame count:" + this.I.c + " block time:" + this.I.j + "> 500");
      }
      if (this.I.j > this.c)
      {
        this.A += this.I.j;
        TXCLog.w("TXCVideoRender", "render frame count:" + this.I.c + " block time:" + this.I.j + "> " + this.c);
        com.tencent.liteav.basic.util.h.a(this.q, getID(), 2105, "Current video block for " + this.I.j + "ms", this.I.j);
        locala = this.I;
        locala.h += this.I.j;
        setStatusValue(6006, this.k, Long.valueOf(this.I.h));
      }
      if (this.I.j > 1000L)
      {
        locala = this.I;
        locala.g += 1L;
        setStatusValue(6004, this.k, Long.valueOf(this.I.g));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.I.c + " block time:" + this.I.j + "> 1000");
      }
    }
    if ((this.I.n != 0L) && (l1 > this.c))
    {
      this.B += 1L;
      this.C += l1;
    }
    l1 = TXCTimeUtil.getTimeTick();
    if (this.z == 0L) {
      this.z = l1;
    }
    for (;;)
    {
      this.I.d = TXCTimeUtil.getTimeTick();
      this.I.n = this.I.d;
      if (this.D == 0L) {
        this.D = this.I.d;
      }
      this.I.m = this.j;
      this.I.l = this.i;
      AppMethodBeat.o(16821);
      return;
      if (l1 - this.z >= 2000L)
      {
        setStatusValue(17015, this.k, Long.valueOf(this.B));
        setStatusValue(17016, this.k, Long.valueOf(this.C));
        if (this.D != 0L)
        {
          TXCKeyPointReportProxy.a(getID(), 40005, (int)this.A, this.k);
          TXCKeyPointReportProxy.a(getID(), 40065, (int)this.C, this.k);
          TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.z), this.k);
          setStatusValue(6012, this.k, Long.valueOf(this.I.k));
        }
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.z = l1;
      }
    }
  }
  
  private void b(Surface paramSurface)
  {
    AppMethodBeat.i(16813);
    TXCLog.i("TXCVideoRender", "surface-render: set surface ".concat(String.valueOf(paramSurface)));
    if (this.t == paramSurface)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
      AppMethodBeat.o(16813);
      return;
    }
    this.t = paramSurface;
    this.m = 1;
    if (paramSurface != null)
    {
      TXCLog.i("TXCVideoRender", "surface-render: set surface start render thread ".concat(String.valueOf(paramSurface)));
      c(null);
      AppMethodBeat.o(16813);
      return;
    }
    try
    {
      if (this.r != null)
      {
        TXCLog.i("TXCVideoRender", "surface-render: set surface stop render thread " + this.r);
        this.r.a();
        this.r = null;
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
    AppMethodBeat.i(16808);
    if (paramTextureView != null) {
      this.m = 0;
    }
    if (((this.e == null) && (paramTextureView != null)) || ((this.e != null) && (!this.e.equals(paramTextureView)))) {}
    for (int i1 = 1;; i1 = 0)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.e + ",new=" + paramTextureView + "id " + getID() + "_" + this.k);
      if (i1 != 0)
      {
        if ((this.e != null) && (this.b == null))
        {
          b(this.e.getSurfaceTexture());
          this.e.setSurfaceTextureListener(null);
        }
        this.d = false;
        this.e = paramTextureView;
        if (this.e != null)
        {
          if (this.e.getWidth() != 0) {
            this.g = this.e.getWidth();
          }
          if (this.e.getHeight() != 0) {
            this.h = this.e.getHeight();
          }
          this.f = new d(this.e);
          this.f.b(this.i, this.j);
          this.f.a(this.g, this.h);
          this.f.a(this.v);
          this.f.c((this.u + this.l) % 360);
          this.e.setSurfaceTextureListener(this);
          if (this.b != null)
          {
            if ((TXCBuild.VersionInt() >= 16) && (this.e.getSurfaceTexture() != this.b))
            {
              TXCLog.w("TXCVideoRender", "play:vrender: setSurfaceTexture " + this.e + ", surfaceTexture " + this.b);
              try
              {
                this.e.setSurfaceTexture(this.b);
                AppMethodBeat.o(16808);
                return;
              }
              catch (Exception paramTextureView)
              {
                TXCLog.e("TXCVideoRender", "setSurfaceTexture error ".concat(String.valueOf(paramTextureView)));
                AppMethodBeat.o(16808);
                return;
              }
            }
            TXCLog.w("TXCVideoRender", "play:vrender: not setSurfaceTexture old surfaceTexture " + this.e.getSurfaceTexture() + ", new surfaceTexture " + this.b);
            AppMethodBeat.o(16808);
            return;
          }
          if (this.e.isAvailable()) {
            a(this.e.getSurfaceTexture());
          }
        }
      }
      AppMethodBeat.o(16808);
      return;
    }
  }
  
  public SurfaceTexture a()
  {
    return null;
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16809);
    if (((this.i != paramInt1) || (this.j != paramInt2)) && ((this.i != paramInt1) || (this.j != paramInt2)))
    {
      this.i = paramInt1;
      this.j = paramInt2;
      if (this.f != null) {
        this.f.b(this.i, this.j);
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
    this.E = true;
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
  
  public void a(b paramb)
  {
    AppMethodBeat.i(229734);
    this.q = new WeakReference(paramb);
    AppMethodBeat.o(229734);
  }
  
  public void a(final p paramp)
  {
    AppMethodBeat.i(229727);
    final TextureView localTextureView = this.e;
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
              if (paramp != null) {
                paramp.onTakePhotoComplete(localObject);
              }
              AppMethodBeat.o(16755);
            }
          });
        }
        AppMethodBeat.o(229727);
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
    if (this.r != null)
    {
      this.r.a(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16920);
          if (e.a(e.this) != null) {
            e.a(e.this).a(paramp);
          }
          AppMethodBeat.o(16920);
        }
      });
      AppMethodBeat.o(229727);
      return;
    }
    if (paramp != null) {
      paramp.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(229727);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16799);
    if (paramInt3 != this.l)
    {
      this.l = paramInt3;
      e(this.u);
    }
    a(paramInt1, paramInt2);
    b();
    AppMethodBeat.o(16799);
  }
  
  public void a(f paramf)
  {
    this.p = paramf;
  }
  
  protected void a(Object paramObject, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(229887);
    if (this.m == 1)
    {
      paramArrayOfFloat = a(paramInt, this.i, this.j, paramArrayOfFloat, paramBoolean);
      paramInt = paramArrayOfFloat[0];
      int i1 = paramArrayOfFloat[1];
      int i2 = paramArrayOfFloat[2];
      System.arraycopy(paramArrayOfFloat, 0, this.x, 0, 3);
      if (paramBoolean)
      {
        this.x[3] = 1;
        this.x[4] = 180;
      }
      for (;;)
      {
        try
        {
          paramArrayOfFloat = this.t;
          if (paramArrayOfFloat != null)
          {
            if (this.r != null)
            {
              Surface localSurface = this.r.b();
              if ((localSurface != paramArrayOfFloat) || ((localSurface != null) && (!localSurface.isValid())))
              {
                TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface surface change stop render thread " + this.r + ", " + localSurface + ", " + paramArrayOfFloat);
                this.r.a();
                this.r = null;
              }
            }
            if ((this.r == null) && (this.m == 1) && (paramArrayOfFloat.isValid()))
            {
              this.r = new g();
              TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface start render thread " + this.r + "," + paramArrayOfFloat);
              this.r.a(paramObject, paramArrayOfFloat);
            }
            if ((this.r != null) && (this.m == 1))
            {
              if (paramBoolean) {
                this.r.a(paramInt, true, 180, this.n, this.o, i1, i2, false, false);
              }
            }
            else
            {
              return;
              this.x[3] = 0;
              this.x[4] = 0;
              break;
            }
            this.r.a(paramInt, false, 0, this.n, this.o, i1, i2, false, false);
            continue;
          }
          if (this.r == null) {
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(229887);
        }
        TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface stop render thread " + this.r);
        this.r.a();
        this.r = null;
      }
    }
    AppMethodBeat.o(229887);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16802);
    l();
    int i1;
    String str2;
    int i2;
    if (this.F)
    {
      i1 = hashCode();
      str2 = getID();
      i2 = this.k;
      if (!paramBoolean) {
        break label183;
      }
    }
    for (String str1 = "true";; str1 = "false")
    {
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]", new Object[] { Integer.valueOf(i1), str2, Integer.valueOf(i2), str1 }), "streamType: 2-big, 3-small, 7-sub", 0);
      this.F = false;
      this.G = false;
      this.H = false;
      if ((!paramBoolean) || (this.m != 1)) {
        break;
      }
      this.m = -1;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
      d();
      try
      {
        if (this.r != null)
        {
          TXCLog.i("TXCVideoRender", "surface-render:stop render thread " + this.r);
          this.r.a();
          this.r = null;
        }
        return;
      }
      finally
      {
        label183:
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
  
  protected void b(SurfaceTexture paramSurfaceTexture)
  {
    this.E = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.I.o = paramBoolean;
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(16804);
    this.v = paramInt;
    if (this.f != null) {
      this.f.a(paramInt);
    }
    AppMethodBeat.o(16804);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16817);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(16817);
  }
  
  public void c(Object paramObject) {}
  
  public void d() {}
  
  public void d(int paramInt)
  {
    AppMethodBeat.i(16805);
    this.w = paramInt;
    if (this.f != null)
    {
      if (paramInt == 2)
      {
        this.f.a(false);
        AppMethodBeat.o(16805);
        return;
      }
      this.f.a(true);
    }
    AppMethodBeat.o(16805);
  }
  
  public void d(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(229895);
    TXCLog.i("TXCVideoRender", "surface-render: set setSurfaceSize " + paramInt1 + "*" + paramInt2);
    if ((paramInt1 != this.n) || (paramInt2 != this.o))
    {
      if ((this.r != null) && (this.m == 1) && (this.x != null))
      {
        this.r.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(182260);
            e.this.n = paramInt1;
            e.this.o = paramInt2;
            g localg;
            int i;
            if (e.a(e.this) != null)
            {
              localg = e.a(e.this);
              i = e.b(e.this)[0];
              if (e.b(e.this)[3] != 1) {
                break label125;
              }
            }
            label125:
            for (boolean bool = true;; bool = false)
            {
              localg.a(i, bool, e.b(e.this)[4], e.this.n, e.this.o, e.b(e.this)[1], e.b(e.this)[2], true, false);
              AppMethodBeat.o(182260);
              return;
            }
          }
        });
        AppMethodBeat.o(229895);
        return;
      }
      this.n = paramInt1;
      this.o = paramInt2;
    }
    AppMethodBeat.o(229895);
  }
  
  public void e()
  {
    AppMethodBeat.i(229754);
    Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.k) }), "streamType: 2-big, 3-small, 7-sub", 0);
    this.F = true;
    if (TXCBuild.VersionInt() >= 21) {}
    for (this.H = true;; this.H = false)
    {
      this.G = false;
      l();
      AppMethodBeat.o(229754);
      return;
    }
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(229765);
    this.u = paramInt;
    if (this.f != null) {
      this.f.c((this.l + paramInt) % 360);
    }
    AppMethodBeat.o(229765);
  }
  
  public int f()
  {
    AppMethodBeat.i(229782);
    int i1;
    if (this.e != null)
    {
      i1 = this.e.getWidth();
      AppMethodBeat.o(229782);
      return i1;
    }
    if (this.t != null)
    {
      i1 = this.n;
      AppMethodBeat.o(229782);
      return i1;
    }
    AppMethodBeat.o(229782);
    return 0;
  }
  
  public void f(int paramInt)
  {
    this.y = paramInt;
  }
  
  public int g()
  {
    AppMethodBeat.i(229792);
    int i1;
    if (this.e != null)
    {
      i1 = this.e.getHeight();
      AppMethodBeat.o(229792);
      return i1;
    }
    if (this.t != null)
    {
      i1 = this.o;
      AppMethodBeat.o(229792);
      return i1;
    }
    AppMethodBeat.o(229792);
    return 0;
  }
  
  public int h()
  {
    AppMethodBeat.i(16806);
    int i1 = this.i;
    AppMethodBeat.o(16806);
    return i1;
  }
  
  public int i()
  {
    AppMethodBeat.i(16807);
    int i1 = this.j;
    AppMethodBeat.o(16807);
    return i1;
  }
  
  protected void j() {}
  
  protected void k()
  {
    AppMethodBeat.i(229876);
    try
    {
      if (this.r != null)
      {
        TXCLog.i("TXCVideoRender", "surface-render: onRenderThreadEGLDestroy stop render thread " + this.r);
        this.r.a();
        this.r = null;
      }
      if (this.s != null)
      {
        this.s.c();
        this.s = null;
      }
      AppMethodBeat.o(229876);
      return;
    }
    finally
    {
      AppMethodBeat.o(229876);
    }
  }
  
  public void l()
  {
    AppMethodBeat.i(229904);
    m();
    this.I.b = 0L;
    this.I.c = 0L;
    this.I.e = 0L;
    this.I.f = 0L;
    this.I.g = 0L;
    this.I.h = 0L;
    this.I.i = 0L;
    this.I.k = 0L;
    this.D = 0L;
    setStatusValue(6001, this.k, Long.valueOf(0L));
    setStatusValue(6003, this.k, Long.valueOf(0L));
    setStatusValue(6005, this.k, Long.valueOf(0L));
    setStatusValue(6006, this.k, Long.valueOf(0L));
    setStatusValue(6004, this.k, Long.valueOf(0L));
    setStatusValue(6012, this.k, Long.valueOf(0L));
    AppMethodBeat.o(229904);
  }
  
  public void m()
  {
    AppMethodBeat.i(16814);
    n();
    this.I.a = 0L;
    this.I.d = 0L;
    this.I.j = 0L;
    this.A = 0L;
    AppMethodBeat.o(16814);
  }
  
  public void n()
  {
    AppMethodBeat.i(16818);
    this.I.n = 0L;
    this.C = 0L;
    this.B = 0L;
    this.I.l = 0;
    this.I.m = 0;
    setStatusValue(6002, this.k, Double.valueOf(0.0D));
    AppMethodBeat.o(16818);
  }
  
  public void o()
  {
    AppMethodBeat.i(16820);
    if (this.I.a == 0L)
    {
      this.I.a = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(16820);
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.I.a;
    if (l1 >= 950L)
    {
      double d1 = (this.I.c - this.I.b) * 1000.0D / l1;
      setStatusValue(6002, this.k, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1, this.k);
      this.I.b = this.I.c;
      a locala = this.I;
      locala.a = (l1 + locala.a);
    }
    AppMethodBeat.o(16820);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16810);
    TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + paramSurfaceTexture + "id " + getID() + "_" + this.k);
    this.g = paramInt1;
    this.h = paramInt2;
    if (this.f != null) {
      this.f.a(this.g, this.h);
    }
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        if ((TXCBuild.VersionInt() >= 16) && (this.e.getSurfaceTexture() != this.b)) {
          this.e.setSurfaceTexture(this.b);
        }
        this.b = null;
        this.E = true;
        AppMethodBeat.o(16810);
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e("TXCVideoRender", "setSurfaceTexture failed.", localException);
        a(paramSurfaceTexture);
        continue;
      }
      a(paramSurfaceTexture);
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(16812);
    try
    {
      this.E = false;
      TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.H + "id " + getID() + "_" + this.k);
      if (this.H) {
        this.b = paramSurfaceTexture;
      }
      while (this.b == null)
      {
        AppMethodBeat.o(16812);
        return true;
        this.I.a = 0L;
        b(paramSurfaceTexture);
        if (paramSurfaceTexture == this.b) {
          this.b = null;
        }
      }
    }
    catch (Exception paramSurfaceTexture)
    {
      for (;;)
      {
        TXCLog.e("TXCVideoRender", "onSurfaceTextureDestroyed failed.", paramSurfaceTexture);
      }
      AppMethodBeat.o(16812);
    }
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16811);
    TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + paramInt1 + "," + paramInt2 + " old:" + this.g + "," + this.h);
    if (!this.E)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
      this.E = true;
      a(paramSurfaceTexture);
    }
    this.g = paramInt1;
    this.h = paramInt2;
    if (this.f != null) {
      this.f.a(this.g, this.h);
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
    public long j;
    public long k;
    public int l;
    public int m;
    public long n;
    public boolean o = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */