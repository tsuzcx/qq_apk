package com.tencent.mm.plugin.emojicapture.ui;

import a.d.a.a;
import a.d.b.g;
import a.k;
import a.n;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public final class EmojiCaptureTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private final String TAG = "MicroMsg.EmojiCaptureTextureView";
  private EGLConfig fZb;
  private final EGL10 fwH;
  private EGLDisplay fwI;
  private EGLContext fwJ;
  private EGLSurface fwK;
  private ah handler;
  private HandlerThread handlerThread;
  private SurfaceTexture jof;
  private com.tencent.mm.plugin.emojicapture.ui.a.e jog = new com.tencent.mm.plugin.emojicapture.ui.a.e();
  private GL10 joh;
  
  public EmojiCaptureTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
    setOpaque(false);
    paramContext = com.tencent.mm.sdk.f.e.ds("EmojiCaptureTextureView_renderThread", -2);
    g.j(paramContext, "ThreadPool.newFreeHandle…READ_PRIORITY_FOREGROUND)");
    this.handlerThread = paramContext;
    this.handlerThread.start();
    this.handler = new ah(this.handlerThread.getLooper());
    paramContext = EGLContext.getEGL();
    if (paramContext == null) {
      throw new k("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
    }
    this.fwH = ((EGL10)paramContext);
    this.fwI = EGL10.EGL_NO_DISPLAY;
    this.fwJ = EGL10.EGL_NO_CONTEXT;
    this.fwK = EGL10.EGL_NO_SURFACE;
  }
  
  public final void b(a<n> parama)
  {
    if (!this.handlerThread.isAlive())
    {
      HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.ds("EmojiCaptureTextureView_renderThread", -2);
      g.j(localHandlerThread, "ThreadPool.newFreeHandle…READ_PRIORITY_FOREGROUND)");
      this.handlerThread = localHandlerThread;
      this.handlerThread.start();
      this.handler = new ah(this.handlerThread.getLooper());
    }
    this.handler.post((Runnable)new c(parama));
  }
  
  public final com.tencent.mm.plugin.emojicapture.ui.a.e getRenderer()
  {
    return this.jog;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jof = paramSurfaceTexture;
    b((a)new EmojiCaptureTextureView.a(this, paramSurfaceTexture, paramInt1, paramInt2));
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    b((a)new EmojiCaptureTextureView.b(this));
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    b((a)new EmojiCaptureTextureView.c(this, paramSurfaceTexture, paramInt1, paramInt2));
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public final void requestRender()
  {
    b((a)new EmojiCaptureTextureView.d(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureTextureView
 * JD-Core Version:    0.7.0.1
 */