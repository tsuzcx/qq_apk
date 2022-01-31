package com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.util.Log;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;

final class GameGLSurfaceView$k
{
  private static String TAG = "GLThreadManager";
  
  public final void f(GameGLSurfaceView.j paramj)
  {
    for (;;)
    {
      GameGLSurfaceView.i locali;
      try
      {
        AppMethodBeat.i(134088);
        c.c.i("MicroMsg.GLThread", "exiting tid=" + paramj.getId(), new Object[0]);
        localGameGLSurfaceView1 = (GameGLSurfaceView)GameGLSurfaceView.j.a(paramj).get();
        if (localGameGLSurfaceView1 != null)
        {
          GameGLSurfaceView.g(localGameGLSurfaceView1).onDestroy();
          locali = GameGLSurfaceView.j.b(paramj);
          c.c.w("MicroMsg.GLThread", "destroySurface()  tid=" + Thread.currentThread().getId(), new Object[0]);
          locali.destroySurfaceImp();
          GameGLSurfaceView.j.c(paramj);
          GameGLSurfaceView.j.d(paramj);
        }
      }
      finally {}
      try
      {
        locali = GameGLSurfaceView.j.b(paramj);
        c.c.w("MicroMsg.GLThread", "finish() tid=" + Thread.currentThread().getId(), new Object[0]);
        if (locali.mEglContext != null)
        {
          GameGLSurfaceView localGameGLSurfaceView2 = (GameGLSurfaceView)locali.mGLSurfaceViewWeakRef.get();
          if (localGameGLSurfaceView2 != null) {
            GameGLSurfaceView.c(localGameGLSurfaceView2).destroyContext(locali.mEgl, locali.mEglDisplay, locali.mEglContext);
          }
          locali.mEglContext = null;
        }
        if (locali.mEglDisplay != null)
        {
          locali.mEgl.eglTerminate(locali.mEglDisplay);
          locali.mEglDisplay = null;
        }
      }
      catch (Throwable localThrowable)
      {
        c.c.e(TAG, "alvinluo GLThread#threadExiting finish stack = [%s]", new Object[] { Log.getStackTraceString(localThrowable) });
        if (localGameGLSurfaceView1 == null) {
          continue;
        }
        GameGLSurfaceView.g(localGameGLSurfaceView1).aPM();
        continue;
      }
      GameGLSurfaceView.j.e(paramj);
      notifyAll();
      AppMethodBeat.o(134088);
      return;
      c.c.i("MicroMsg.GLThread", "onFinalize:view = null", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.GameGLSurfaceView.k
 * JD-Core Version:    0.7.0.1
 */