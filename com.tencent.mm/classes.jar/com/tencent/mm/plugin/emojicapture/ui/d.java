package com.tencent.mm.plugin.emojicapture.ui;

import a.d.a.a;
import a.d.a.b;
import a.n;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import com.tencent.mm.sdk.platformtools.ah;

public final class d
{
  final String TAG;
  final SurfaceTexture fwG;
  private ah joA;
  final com.tencent.mm.plugin.emojicapture.ui.a.g joB;
  EGLDisplay jov;
  EGLContext jow;
  EGLSurface jox;
  public boolean joy;
  HandlerThread joz;
  boolean needRender;
  
  public d(SurfaceTexture paramSurfaceTexture, com.tencent.mm.plugin.emojicapture.ui.a.g paramg, b<? super d, n> paramb)
  {
    this.fwG = paramSurfaceTexture;
    this.joB = paramg;
    this.TAG = "MicroMsg.EmojiVideoPlayTextureRenderSurface";
    this.jov = EGL14.EGL_NO_DISPLAY;
    this.jow = EGL14.EGL_NO_CONTEXT;
    this.jox = EGL14.EGL_NO_SURFACE;
    paramSurfaceTexture = com.tencent.mm.sdk.f.e.aap("EmojiVideoPlayTextureRenderSurface_renderThread");
    a.d.b.g.j(paramSurfaceTexture, "ThreadPool.newFreeHandle…derSurface_renderThread\")");
    this.joz = paramSurfaceTexture;
    this.joz.start();
    this.joA = new ah(this.joz.getLooper());
    c((a)new d.1(this, paramb));
  }
  
  final void c(a<n> parama)
  {
    this.joA.post((Runnable)new e(parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.d
 * JD-Core Version:    0.7.0.1
 */