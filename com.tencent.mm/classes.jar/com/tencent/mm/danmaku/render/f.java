package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.b;
import com.tencent.mm.danmaku.c.l;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.danmaku.f.a;
import com.tencent.mm.danmaku.f.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public final class f
  implements SurfaceHolder.Callback, d
{
  private volatile boolean jAA;
  private d.a jAt;
  private SurfaceHolder jAv;
  private volatile ReentrantLock jAw;
  private volatile Object jAx;
  private volatile boolean jAy;
  private volatile Object jAz;
  private SurfaceView mSurfaceView;
  
  public f(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(284783);
    this.jAA = false;
    this.mSurfaceView = paramSurfaceView;
    this.mSurfaceView.setWillNotCacheDrawing(true);
    this.mSurfaceView.setDrawingCacheEnabled(false);
    this.mSurfaceView.setWillNotDraw(true);
    this.mSurfaceView.setZOrderMediaOverlay(true);
    this.jAv = this.mSurfaceView.getHolder();
    this.jAv.addCallback(this);
    this.jAv.setFormat(-2);
    AppMethodBeat.o(284783);
  }
  
  private void azT()
  {
    AppMethodBeat.i(284782);
    this.jAx = c.b(SurfaceView.class, "mDrawingStopped", this.mSurfaceView);
    this.jAz = c.b(SurfaceView.class, "mWindow", this.mSurfaceView);
    if ((this.jAx instanceof Boolean)) {
      this.jAy = ((Boolean)this.jAx).booleanValue();
    }
    AppMethodBeat.o(284782);
  }
  
  private Canvas azU()
  {
    AppMethodBeat.i(284785);
    Canvas localCanvas;
    if (a.aAg())
    {
      localCanvas = this.jAv.lockHardwareCanvas();
      AppMethodBeat.o(284785);
      return localCanvas;
    }
    this.jAw.lock();
    azT();
    if ((!this.jAy) && (this.jAz != null)) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localCanvas = this.jAv.getSurface().lockHardwareCanvas();
          if (localCanvas == null) {
            break;
          }
          AppMethodBeat.o(284785);
          return localCanvas;
        }
      }
      catch (Exception localException)
      {
        e.e("SurfaceDanmakuView", "Exception locking surface", localException);
      }
      Object localObject = null;
    }
    this.jAw.unlock();
    AppMethodBeat.o(284785);
    return null;
  }
  
  public final void a(d.a parama)
  {
    this.jAt = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(284793);
    if (paramb != null) {
      paramb.m(null);
    }
    AppMethodBeat.o(284793);
  }
  
  public final Canvas azQ()
  {
    AppMethodBeat.i(284784);
    if (this.jAA)
    {
      localCanvas = azU();
      AppMethodBeat.o(284784);
      return localCanvas;
    }
    Canvas localCanvas = this.jAv.lockCanvas();
    AppMethodBeat.o(284784);
    return localCanvas;
  }
  
  public final float azR()
  {
    AppMethodBeat.i(284790);
    float f = this.mSurfaceView.getY();
    AppMethodBeat.o(284790);
    return f;
  }
  
  public final void o(Canvas paramCanvas)
  {
    AppMethodBeat.i(284786);
    if (this.jAA)
    {
      if (a.aAg())
      {
        this.jAv.unlockCanvasAndPost(paramCanvas);
        AppMethodBeat.o(284786);
        return;
      }
      this.jAv.getSurface().unlockCanvasAndPost(paramCanvas);
      if (this.jAw != null) {
        this.jAw.unlock();
      }
      AppMethodBeat.o(284786);
      return;
    }
    this.jAv.unlockCanvasAndPost(paramCanvas);
    AppMethodBeat.o(284786);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(284787);
    this.mSurfaceView.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(284787);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(284789);
    if (this.jAt != null) {
      this.jAt.ayU();
    }
    e.i("SurfaceDanmakuView", "surfaceChanged, width = " + paramInt2 + ", height = " + paramInt3);
    AppMethodBeat.o(284789);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(284788);
    if (this.jAt != null) {
      this.jAt.ayT();
    }
    int i;
    if (l.jzZ) {
      if (l.jzY != null)
      {
        bool = l.jzY.azH();
        if (!bool) {
          break label166;
        }
        i = 1;
        label48:
        if (i == 0) {
          break label176;
        }
        if (Build.VERSION.SDK_INT == 23)
        {
          paramSurfaceHolder = c.b(SurfaceView.class, "mSurfaceLock", this.mSurfaceView);
          if ((paramSurfaceHolder instanceof ReentrantLock)) {
            this.jAw = ((ReentrantLock)paramSurfaceHolder);
          }
          azT();
          if ((this.jAw == null) || (this.jAx == null) || (this.jAz == null)) {
            break label171;
          }
          i = 1;
          label114:
          if (i != 0) {}
        }
        else
        {
          if (!a.aAg()) {
            break label176;
          }
        }
      }
    }
    label166:
    label171:
    label176:
    for (boolean bool = true;; bool = false)
    {
      this.jAA = bool;
      e.i("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.jAA);
      AppMethodBeat.o(284788);
      return;
      bool = true;
      break;
      i = 0;
      break label48;
      i = 0;
      break label114;
    }
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(284795);
    if (this.jAt != null) {
      this.jAt.ayV();
    }
    e.i("SurfaceDanmakuView", "surfaceDestroyed");
    AppMethodBeat.o(284795);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(284792);
    ReentrantLock localReentrantLock = (ReentrantLock)c.b(SurfaceView.class, "mSurfaceLock", this.mSurfaceView);
    Surface localSurface = this.mSurfaceView.getHolder().getSurface();
    try
    {
      Method localMethod = Surface.class.getDeclaredMethod("nativeRelease", new Class[] { Long.TYPE });
      localMethod.setAccessible(true);
      Field localField = Surface.class.getDeclaredField("mLockedObject");
      localField.setAccessible(true);
      Long localLong = (Long)localField.get(localSurface);
      e.i("surface_lock", "SurfaceDanmakuView unlock lockObjectValue = ".concat(String.valueOf(localLong)));
      if (localLong.longValue() != 0L) {
        localMethod.invoke(null, new Object[] { localLong });
      }
      localField.setLong(localSurface, 0L);
      e.d("surface_lock", "SurfaceDanmakuView unlock: release success");
      return;
    }
    catch (Exception localException)
    {
      e.e("surface_lock", "SurfaceDanmakuView unlock:release failed", localException);
      return;
    }
    finally
    {
      e.i("surface_lock", "SurfaceDanmakuView unlock surfaceLock = ".concat(String.valueOf(localReentrantLock)));
      if ((localReentrantLock != null) && (localReentrantLock.isLocked()))
      {
        e.i("surface_lock", "SurfaceDanmakuView unlock");
        localReentrantLock.unlock();
      }
      AppMethodBeat.o(284792);
    }
    AppMethodBeat.o(284792);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.f
 * JD-Core Version:    0.7.0.1
 */