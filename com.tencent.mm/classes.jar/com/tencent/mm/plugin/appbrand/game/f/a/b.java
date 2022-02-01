package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.magicbrush.ui.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ah;

public abstract class b
  extends h
  implements e
{
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a mVj;
  private com.tencent.mm.media.j.a nBj;
  private MMHandler nBk;
  private HandlerThread nty = com.tencent.threadpool.c.d.jv("GameTextureView_renderThread", -2);
  private SurfaceTexture rrU;
  private c.b rrV;
  private AtomicBoolean rrW = new AtomicBoolean(false);
  private e.a rrX;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.nty.start();
    this.nBk = new MMHandler(this.nty.getLooper());
  }
  
  private void ag(Runnable paramRunnable)
  {
    if (Thread.currentThread().getId() == this.nty.getId())
    {
      paramRunnable.run();
      return;
    }
    this.nBk.post(paramRunnable);
  }
  
  public final void H(final kotlin.g.a.a<ah> parama)
  {
    if (Thread.currentThread().getId() == this.nty.getId())
    {
      parama.invoke();
      return;
    }
    this.nBk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45193);
        parama.invoke();
        AppMethodBeat.o(45193);
      }
    });
  }
  
  public EGLContext getEGLContext()
  {
    if (this.rrV == null) {
      return null;
    }
    return this.rrV.eXL;
  }
  
  public int getPreviewTextureId()
  {
    if ((this.mVj == null) || (this.mVj.bul() == null)) {
      return -1;
    }
    return this.mVj.bul().nAF;
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45194);
        b.a(b.this, paramInt1);
        b.b(b.this, paramInt2);
        b.a(b.this, paramSurfaceTexture);
        b localb = b.this;
        c.a locala = com.tencent.mm.media.util.c.nFs;
        b.a(localb, c.a.a(new Surface(paramSurfaceTexture), null, 0, 0, EGL14.EGL_NO_CONTEXT));
        if (b.a(b.this) != null)
        {
          b.a(b.this).onSurfaceCreated(null, null);
          b.a(b.this).ek(paramInt1, paramInt2);
          b.a(b.this).el(paramInt1, paramInt2);
          b.a(b.this).gp(true);
        }
        b.a(b.this, b.b(b.this).getSurfaceTexture(), paramInt1, paramInt2);
        b.c(b.this).getAndSet(true);
        if (b.d(b.this) != null)
        {
          b.d(b.this);
          b.b(b.this).getSurfaceTexture();
        }
        AppMethodBeat.o(45194);
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45198);
        Log.i("MicroMsg.CameraPreviewGLTextureView", "hy: onSurfaceTextureDestroyed in thread! can preview: %b", new Object[] { Boolean.valueOf(b.c(b.this).get()) });
        try
        {
          if (b.c(b.this).get())
          {
            boolean bool = b.b(b.this, b.b(b.this).getSurfaceTexture());
            b.c(b.this).getAndSet(false);
            if (b.a(b.this) == null) {
              break label170;
            }
            b.a(b.this).release(bool);
          }
          for (;;)
          {
            if (b.g(b.this) != null)
            {
              EGL14.eglDestroyContext(b.g(b.this).nFB, b.g(b.this).eXL);
              EGL14.eglDestroySurface(b.g(b.this).nFB, b.g(b.this).eglSurface);
              b.h(b.this).release();
            }
            AppMethodBeat.o(45198);
            return;
            label170:
            Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: no renderer!");
          }
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: error in surface destroy!!", new Object[0]);
          AppMethodBeat.o(45198);
        }
      }
    });
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45195);
        b.b(b.this, b.b(b.this).getSurfaceTexture(), paramInt1, paramInt2);
        b.a(b.this, paramInt1);
        b.b(b.this, paramInt2);
        b.a(b.this).ek(b.e(b.this), b.f(b.this));
        AppMethodBeat.o(45195);
      }
    });
  }
  
  public void requestRender()
  {
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45197);
        try
        {
          if (b.a(b.this).nDv)
          {
            ((SurfaceTexture)Objects.requireNonNull(b.b(b.this).getSurfaceTexture())).updateTexImage();
            b.a(b.this).onDrawFrame(null);
          }
          while (b.c(b.this).get())
          {
            if (b.g(b.this) == null) {
              break label194;
            }
            EGLExt.eglPresentationTimeANDROID(b.g(b.this).nFB, b.g(b.this).eglSurface, System.nanoTime());
            EGL14.eglSwapBuffers(b.g(b.this).nFB, b.g(b.this).eglSurface);
            AppMethodBeat.o(45197);
            return;
            Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
          }
          Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
          ((com.tencent.mm.plugin.appbrand.x.a)com.tencent.luggage.a.e.U(com.tencent.mm.plugin.appbrand.x.a.class)).idkeyStat(808L, 2L, 1L, true);
          AppMethodBeat.o(45197);
          return;
        }
        label194:
        AppMethodBeat.o(45197);
      }
    });
  }
  
  public void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    this.rrX = parama;
    if (this.rrW.get()) {
      this.mVj.getSurfaceTexture();
    }
  }
  
  public void setOnTextureDrawFinishDelegate(kotlin.g.a.b<com.tencent.mm.media.g.d, ah> paramb)
  {
    this.mVj.nKB = paramb;
  }
  
  public void setPreviewRenderer(final com.tencent.mm.media.j.a parama)
  {
    Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
    if (this.mVj != null)
    {
      this.mVj.t(true, false);
      this.mVj = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    }
    this.mVj = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    this.mVj.b(parama);
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45196);
        b.a(b.this, parama);
        AppMethodBeat.o(45196);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.b
 * JD-Core Version:    0.7.0.1
 */