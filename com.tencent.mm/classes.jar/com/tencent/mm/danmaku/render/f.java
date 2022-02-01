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
  private d.a gQa;
  private SurfaceHolder gQc;
  private volatile ReentrantLock gQd;
  private volatile Object gQe;
  private volatile boolean gQf;
  private volatile Object gQg;
  private volatile boolean gQh;
  private SurfaceView mSurfaceView;
  
  public f(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(241711);
    this.gQh = false;
    this.mSurfaceView = paramSurfaceView;
    this.mSurfaceView.setWillNotCacheDrawing(true);
    this.mSurfaceView.setDrawingCacheEnabled(false);
    this.mSurfaceView.setWillNotDraw(true);
    this.mSurfaceView.setZOrderMediaOverlay(true);
    this.gQc = this.mSurfaceView.getHolder();
    this.gQc.addCallback(this);
    this.gQc.setFormat(-2);
    AppMethodBeat.o(241711);
  }
  
  private void atf()
  {
    AppMethodBeat.i(241710);
    this.gQe = c.b(SurfaceView.class, "mDrawingStopped", this.mSurfaceView);
    this.gQg = c.b(SurfaceView.class, "mWindow", this.mSurfaceView);
    if ((this.gQe instanceof Boolean)) {
      this.gQf = ((Boolean)this.gQe).booleanValue();
    }
    AppMethodBeat.o(241710);
  }
  
  private Canvas lockHardwareCanvas()
  {
    AppMethodBeat.i(241713);
    Canvas localCanvas;
    if (a.atq())
    {
      localCanvas = this.gQc.lockHardwareCanvas();
      AppMethodBeat.o(241713);
      return localCanvas;
    }
    this.gQd.lock();
    atf();
    if ((!this.gQf) && (this.gQg != null)) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localCanvas = this.gQc.getSurface().lockHardwareCanvas();
          if (localCanvas == null) {
            break;
          }
          AppMethodBeat.o(241713);
          return localCanvas;
        }
      }
      catch (Exception localException)
      {
        e.e("SurfaceDanmakuView", "Exception locking surface", localException);
      }
      Object localObject = null;
    }
    this.gQd.unlock();
    AppMethodBeat.o(241713);
    return null;
  }
  
  public final void a(d.a parama)
  {
    this.gQa = parama;
  }
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(241720);
    if (paramb != null) {
      paramb.l(null);
    }
    AppMethodBeat.o(241720);
  }
  
  public final float atd()
  {
    AppMethodBeat.i(241718);
    float f = this.mSurfaceView.getY();
    AppMethodBeat.o(241718);
    return f;
  }
  
  public final Canvas lockCanvas()
  {
    AppMethodBeat.i(241712);
    if (this.gQh)
    {
      localCanvas = lockHardwareCanvas();
      AppMethodBeat.o(241712);
      return localCanvas;
    }
    Canvas localCanvas = this.gQc.lockCanvas();
    AppMethodBeat.o(241712);
    return localCanvas;
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(241715);
    this.mSurfaceView.setOnTouchListener(paramOnTouchListener);
    AppMethodBeat.o(241715);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(241717);
    if (this.gQa != null) {
      this.gQa.ash();
    }
    e.i("SurfaceDanmakuView", "surfaceChanged, width = " + paramInt2 + ", height = " + paramInt3);
    AppMethodBeat.o(241717);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(241716);
    if (this.gQa != null) {
      this.gQa.asg();
    }
    int i;
    if (l.gPG) {
      if (l.gPF != null)
      {
        bool = l.gPF.asT();
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
            this.gQd = ((ReentrantLock)paramSurfaceHolder);
          }
          atf();
          if ((this.gQd == null) || (this.gQe == null) || (this.gQg == null)) {
            break label171;
          }
          i = 1;
          label114:
          if (i != 0) {}
        }
        else
        {
          if (!a.atq()) {
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
      this.gQh = bool;
      e.i("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.gQh);
      AppMethodBeat.o(241716);
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
    AppMethodBeat.i(241721);
    if (this.gQa != null) {
      this.gQa.asi();
    }
    e.i("SurfaceDanmakuView", "surfaceDestroyed");
    AppMethodBeat.o(241721);
  }
  
  public final void unlock()
  {
    AppMethodBeat.i(241719);
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
      AppMethodBeat.o(241719);
    }
    AppMethodBeat.o(241719);
  }
  
  public final void unlockCanvasAndPost(Canvas paramCanvas)
  {
    AppMethodBeat.i(241714);
    if (this.gQh)
    {
      if (a.atq())
      {
        this.gQc.unlockCanvasAndPost(paramCanvas);
        AppMethodBeat.o(241714);
        return;
      }
      this.gQc.getSurface().unlockCanvasAndPost(paramCanvas);
      if (this.gQd != null) {
        this.gQd.unlock();
      }
      AppMethodBeat.o(241714);
      return;
    }
    this.gQc.unlockCanvasAndPost(paramCanvas);
    AppMethodBeat.o(241714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.danmaku.render.f
 * JD-Core Version:    0.7.0.1
 */