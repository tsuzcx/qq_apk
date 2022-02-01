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
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.g;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
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
  private boolean D;
  private boolean E;
  private boolean F;
  private boolean G;
  private a H;
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
  WeakReference<b> p;
  private g q;
  private h r;
  private Surface s;
  private int t;
  private int u;
  private int v;
  private int[] w;
  private int x;
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
    this.w = new int[5];
    this.x = 500;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = false;
    this.E = false;
    this.G = false;
    this.H = new a();
    this.F = false;
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
        break label267;
      }
      this.r.a(h.a);
      label110:
      if (this.v != 1) {
        break label280;
      }
      this.r.a(true);
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
      label267:
      this.r.a(h.b);
      break label110;
      label280:
      this.r.a(false);
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(16821);
    if (!this.F)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("EVT_USERID", getID());
      ((Bundle)localObject).putInt("EVT_ID", 2003);
      ((Bundle)localObject).putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      ((Bundle)localObject).putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      ((Bundle)localObject).putCharSequence("EVT_MSG", "Render the first video frame(IDR)");
      ((Bundle)localObject).putInt("EVT_PARAM1", this.h);
      ((Bundle)localObject).putInt("EVT_PARAM2", this.i);
      com.tencent.liteav.basic.util.h.a(this.p, 2003, (Bundle)localObject);
      setStatusValue(6001, this.j, Long.valueOf(TXCTimeUtil.getTimeTick()));
      setStatusValue(6010, this.j, Integer.valueOf(this.h));
      setStatusValue(6011, this.j, Integer.valueOf(this.i));
      TXCLog.i("TXCVideoRender", "[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:" + hashCode() + " id:" + getID() + " type:" + this.j);
      this.F = true;
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
      TXCKeyPointReportProxy.a(getID(), 40022, 0L, this.j);
    }
    if (!this.H.o)
    {
      AppMethodBeat.o(16821);
      return;
    }
    Object localObject = this.H;
    ((a)localObject).c += 1L;
    o();
    long l1 = a(this.H.n);
    if (this.H.d != 0L)
    {
      this.H.j = a(this.H.d);
      localObject = this.H;
      ((a)localObject).k += this.H.j;
      if (this.H.j > 200L)
      {
        localObject = this.H;
        ((a)localObject).e += 1L;
        setStatusValue(6009, this.j, Long.valueOf(this.H.e));
      }
      if (this.H.j > this.x)
      {
        localObject = this.H;
        ((a)localObject).f += 1L;
        setStatusValue(6003, this.j, Long.valueOf(this.H.f));
        if (this.H.j > this.H.i)
        {
          this.H.i = this.H.j;
          setStatusValue(6005, this.j, Long.valueOf(this.H.i));
        }
        TXCLog.w("TXCVideoRender", "render frame count:" + this.H.c + " block time:" + this.H.j + "> 500");
      }
      if (this.H.j > this.c)
      {
        this.z += this.H.j;
        TXCLog.w("TXCVideoRender", "render frame count:" + this.H.c + " block time:" + this.H.j + "> " + this.c);
        com.tencent.liteav.basic.util.h.a(this.p, getID(), 2105, "Current video block for " + this.H.j + "ms", this.H.j);
        localObject = this.H;
        ((a)localObject).h += this.H.j;
        setStatusValue(6006, this.j, Long.valueOf(this.H.h));
      }
      if (this.H.j > 1000L)
      {
        localObject = this.H;
        ((a)localObject).g += 1L;
        setStatusValue(6004, this.j, Long.valueOf(this.H.g));
        TXCLog.w("TXCVideoRender", "render frame count:" + this.H.c + " block time:" + this.H.j + "> 1000");
      }
    }
    if ((this.H.n != 0L) && (l1 > this.c))
    {
      this.A += 1L;
      this.B += l1;
    }
    l1 = TXCTimeUtil.getTimeTick();
    if (this.y == 0L) {
      this.y = l1;
    }
    for (;;)
    {
      this.H.d = TXCTimeUtil.getTimeTick();
      this.H.n = this.H.d;
      if (this.C == 0L) {
        this.C = this.H.d;
      }
      this.H.m = this.i;
      this.H.l = this.h;
      AppMethodBeat.o(16821);
      return;
      if (l1 - this.y >= 2000L)
      {
        setStatusValue(17015, this.j, Long.valueOf(this.A));
        setStatusValue(17016, this.j, Long.valueOf(this.B));
        if (this.C != 0L)
        {
          TXCKeyPointReportProxy.a(getID(), 40005, (int)this.z, this.j);
          TXCKeyPointReportProxy.a(getID(), 40065, (int)this.B, this.j);
          TXCKeyPointReportProxy.a(getID(), 40006, (int)(l1 - this.y), this.j);
          setStatusValue(6012, this.j, Long.valueOf(this.H.k));
        }
        this.z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.y = l1;
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
            try
            {
              this.d.setSurfaceTexture(this.b);
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
    this.D = true;
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
    AppMethodBeat.i(220335);
    this.p = new WeakReference(paramb);
    AppMethodBeat.o(220335);
  }
  
  public void a(final p paramp)
  {
    AppMethodBeat.i(220323);
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
              if (paramp != null) {
                paramp.onTakePhotoComplete(localObject);
              }
              AppMethodBeat.o(16755);
            }
          });
        }
        AppMethodBeat.o(220323);
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
            e.a(e.this).a(paramp);
          }
          AppMethodBeat.o(16920);
        }
      });
      AppMethodBeat.o(220323);
      return;
    }
    if (paramp != null) {
      paramp.onTakePhotoComplete(null);
    }
    AppMethodBeat.o(220323);
  }
  
  public void a(TXSVideoFrame paramTXSVideoFrame, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(16799);
    if (paramInt3 != this.k)
    {
      this.k = paramInt3;
      e(this.t);
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
    AppMethodBeat.i(220423);
    if (this.l == 1)
    {
      paramArrayOfFloat = a(paramInt, this.h, this.i, paramArrayOfFloat, paramBoolean);
      paramInt = paramArrayOfFloat[0];
      int i1 = paramArrayOfFloat[1];
      int i2 = paramArrayOfFloat[2];
      System.arraycopy(paramArrayOfFloat, 0, this.w, 0, 3);
      if (paramBoolean)
      {
        this.w[3] = 1;
        this.w[4] = 180;
      }
      for (;;)
      {
        try
        {
          paramArrayOfFloat = this.s;
          if (paramArrayOfFloat != null)
          {
            if (this.q != null)
            {
              Surface localSurface = this.q.b();
              if ((localSurface != paramArrayOfFloat) || ((localSurface != null) && (!localSurface.isValid())))
              {
                TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface surface change stop render thread " + this.q + ", " + localSurface + ", " + paramArrayOfFloat);
                this.q.a();
                this.q = null;
              }
            }
            if ((this.q == null) && (this.l == 1) && (paramArrayOfFloat.isValid()))
            {
              this.q = new g();
              TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface start render thread " + this.q + "," + paramArrayOfFloat);
              this.q.a(paramObject, paramArrayOfFloat);
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
              this.w[3] = 0;
              this.w[4] = 0;
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
          AppMethodBeat.o(220423);
        }
        TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface stop render thread " + this.q);
        this.q.a();
        this.q = null;
      }
    }
    AppMethodBeat.o(220423);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16802);
    l();
    int i1;
    String str2;
    int i2;
    if (this.E)
    {
      i1 = hashCode();
      str2 = getID();
      i2 = this.j;
      if (!paramBoolean) {
        break label185;
      }
    }
    for (String str1 = "true";; str1 = "false")
    {
      Monitor.a(2, String.format("Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]", new Object[] { Integer.valueOf(i1), str2, Integer.valueOf(i2), str1 }), "streamType: 2-big, 3-small, 7-sub", 0);
      this.E = false;
      this.F = false;
      this.G = false;
      if ((!paramBoolean) || (this.l != 1)) {
        break;
      }
      this.l = -1;
      TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
      d();
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
        label185:
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
    this.D = false;
  }
  
  public void b(boolean paramBoolean)
  {
    this.H.o = paramBoolean;
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
    this.v = paramInt;
    if (this.e != null)
    {
      if (paramInt == 2)
      {
        this.e.a(false);
        AppMethodBeat.o(16805);
        return;
      }
      this.e.a(true);
    }
    AppMethodBeat.o(16805);
  }
  
  public void d(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(220428);
    TXCLog.i("TXCVideoRender", "surface-render: set setSurfaceSize " + paramInt1 + "*" + paramInt2);
    if ((paramInt1 != this.m) || (paramInt2 != this.n))
    {
      if ((this.q != null) && (this.l == 1) && (this.w != null))
      {
        this.q.a(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(182260);
            e.this.m = paramInt1;
            e.this.n = paramInt2;
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
              localg.a(i, bool, e.b(e.this)[4], e.this.m, e.this.n, e.b(e.this)[1], e.b(e.this)[2], true, false);
              AppMethodBeat.o(182260);
              return;
            }
          }
        });
        AppMethodBeat.o(220428);
        return;
      }
      this.m = paramInt1;
      this.n = paramInt2;
    }
    AppMethodBeat.o(220428);
  }
  
  public void e()
  {
    AppMethodBeat.i(220341);
    Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", new Object[] { Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.j) }), "streamType: 2-big, 3-small, 7-sub", 0);
    this.E = true;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (this.G = true;; this.G = false)
    {
      this.F = false;
      l();
      AppMethodBeat.o(220341);
      return;
    }
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(220363);
    this.t = paramInt;
    if (this.e != null) {
      this.e.c((this.k + paramInt) % 360);
    }
    AppMethodBeat.o(220363);
  }
  
  public int f()
  {
    AppMethodBeat.i(220368);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getWidth();
      AppMethodBeat.o(220368);
      return i1;
    }
    if (this.s != null)
    {
      i1 = this.m;
      AppMethodBeat.o(220368);
      return i1;
    }
    AppMethodBeat.o(220368);
    return 0;
  }
  
  public void f(int paramInt)
  {
    this.x = paramInt;
  }
  
  public int g()
  {
    AppMethodBeat.i(220370);
    int i1;
    if (this.d != null)
    {
      i1 = this.d.getHeight();
      AppMethodBeat.o(220370);
      return i1;
    }
    if (this.s != null)
    {
      i1 = this.n;
      AppMethodBeat.o(220370);
      return i1;
    }
    AppMethodBeat.o(220370);
    return 0;
  }
  
  public int h()
  {
    AppMethodBeat.i(16806);
    int i1 = this.h;
    AppMethodBeat.o(16806);
    return i1;
  }
  
  public int i()
  {
    AppMethodBeat.i(16807);
    int i1 = this.i;
    AppMethodBeat.o(16807);
    return i1;
  }
  
  protected void j() {}
  
  protected void k()
  {
    AppMethodBeat.i(220410);
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
      AppMethodBeat.o(220410);
      return;
    }
    finally
    {
      AppMethodBeat.o(220410);
    }
  }
  
  public void l()
  {
    AppMethodBeat.i(220442);
    m();
    this.H.b = 0L;
    this.H.c = 0L;
    this.H.e = 0L;
    this.H.f = 0L;
    this.H.g = 0L;
    this.H.h = 0L;
    this.H.i = 0L;
    this.H.k = 0L;
    this.C = 0L;
    setStatusValue(6001, this.j, Long.valueOf(0L));
    setStatusValue(6003, this.j, Long.valueOf(0L));
    setStatusValue(6005, this.j, Long.valueOf(0L));
    setStatusValue(6006, this.j, Long.valueOf(0L));
    setStatusValue(6004, this.j, Long.valueOf(0L));
    setStatusValue(6012, this.j, Long.valueOf(0L));
    AppMethodBeat.o(220442);
  }
  
  public void m()
  {
    AppMethodBeat.i(16814);
    n();
    this.H.a = 0L;
    this.H.d = 0L;
    this.H.j = 0L;
    this.z = 0L;
    AppMethodBeat.o(16814);
  }
  
  public void n()
  {
    AppMethodBeat.i(16818);
    this.H.n = 0L;
    this.B = 0L;
    this.A = 0L;
    this.H.l = 0;
    this.H.m = 0;
    setStatusValue(6002, this.j, Double.valueOf(0.0D));
    AppMethodBeat.o(16818);
  }
  
  public void o()
  {
    AppMethodBeat.i(16820);
    if (this.H.a == 0L)
    {
      this.H.a = TXCTimeUtil.getTimeTick();
      AppMethodBeat.o(16820);
      return;
    }
    long l1 = TXCTimeUtil.getTimeTick() - this.H.a;
    if (l1 >= 950L)
    {
      double d1 = (this.H.c - this.H.b) * 1000.0D / l1;
      setStatusValue(6002, this.j, Double.valueOf(d1));
      TXCKeyPointReportProxy.a(getID(), 40001, (int)d1, this.j);
      this.H.b = this.H.c;
      a locala = this.H;
      locala.a = (l1 + locala.a);
    }
    AppMethodBeat.o(16820);
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
      this.D = true;
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
      this.D = false;
      TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.G + "id " + getID() + "_" + this.j);
      if (this.G) {
        this.b = paramSurfaceTexture;
      }
      while (this.b == null)
      {
        AppMethodBeat.o(16812);
        return true;
        this.H.a = 0L;
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
    TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + paramInt1 + "," + paramInt2 + " old:" + this.f + "," + this.g);
    if (!this.D)
    {
      TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
      this.D = true;
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
    public long j;
    public long k;
    public int l;
    public int m;
    public long n;
    public boolean o = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.renderer.e
 * JD-Core Version:    0.7.0.1
 */