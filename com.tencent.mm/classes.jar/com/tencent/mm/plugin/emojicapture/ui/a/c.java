package com.tencent.mm.plugin.emojicapture.ui.a;

import a.d.a.a;
import a.d.b.g;
import a.k;
import a.n;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public final class c
{
  public final String TAG;
  final int height;
  final EGL10 jqV;
  EGLDisplay jqW;
  EGLContext jqX;
  EGLSurface jqY;
  EGLConfig jqZ;
  public GL10 jra;
  public d jrb;
  public Surface jrc;
  public ah jrd;
  HandlerThread jre;
  public a<n> jrf;
  final int width;
  
  public c(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.TAG = "MicroMsg.EmojiCaptureEGLPixelBuffer";
    Object localObject = EGLContext.getEGL();
    if (localObject == null) {
      throw new k("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
    }
    this.jqV = ((EGL10)localObject);
    this.jqW = EGL10.EGL_NO_DISPLAY;
    this.jqX = EGL10.EGL_NO_CONTEXT;
    this.jqY = EGL10.EGL_NO_SURFACE;
    localObject = e.aap("EmojiCaptureMixEGLPixelBuffer_GLThread");
    g.j(localObject, "ThreadPool.newFreeHandle…EGLPixelBuffer_GLThread\")");
    this.jre = ((HandlerThread)localObject);
    this.jre.start();
    this.jrd = new ah(this.jre.getLooper());
    this.jrd.post((Runnable)new c.1(this));
  }
  
  public final void c(a<n> parama)
  {
    g.k(parama, "callback");
    this.jrd.post((Runnable)new c.e(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.a.c
 * JD-Core Version:    0.7.0.1
 */