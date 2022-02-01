package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.luggage.a.e;
import com.tencent.magicbrush.ui.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.a;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.a.b;
import d.y;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  extends h
  implements d
{
  private HandlerThread gSR = com.tencent.e.c.d.gy("GameTextureView_renderThread", -2);
  private ao gSS;
  private com.tencent.mm.media.i.a gTi;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a grf;
  private SurfaceTexture jRZ;
  private c.b jSa;
  private AtomicBoolean jSb = new AtomicBoolean(false);
  private d.a jSc;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.gSR.start();
    this.gSS = new ao(this.gSR.getLooper());
  }
  
  private void queueEvent(Runnable paramRunnable)
  {
    if (Thread.currentThread().getId() == this.gSR.getId())
    {
      paramRunnable.run();
      return;
    }
    this.gSS.post(paramRunnable);
  }
  
  public EGLContext getEGLContext()
  {
    if (this.jSa == null) {
      return null;
    }
    return this.jSa.gWL;
  }
  
  public int getPreviewTextureId()
  {
    if ((this.grf == null) || (this.grf.auU() == null)) {
      return -1;
    }
    return this.grf.auU().gRW;
  }
  
  public final void h(final d.g.a.a<y> parama)
  {
    if (Thread.currentThread().getId() == this.gSR.getId())
    {
      parama.invoke();
      return;
    }
    this.gSS.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45193);
        parama.invoke();
        AppMethodBeat.o(45193);
      }
    });
  }
  
  public void onSurfaceTextureAvailable(final SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    ac.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45194);
        a.a(a.this, paramInt1);
        a.b(a.this, paramInt2);
        a.a(a.this, paramSurfaceTexture);
        a locala = a.this;
        c.a locala1 = com.tencent.mm.media.j.c.gWJ;
        a.a(locala, c.a.a(new Surface(paramSurfaceTexture), null, 0, 0, EGL14.EGL_NO_CONTEXT));
        if (a.a(a.this) != null)
        {
          a.a(a.this).onSurfaceCreated(null, null);
          a.a(a.this).cR(paramInt1, paramInt2);
          a.a(a.this).cS(paramInt1, paramInt2);
          a.a(a.this).ed(true);
        }
        a.a(a.this, a.b(a.this).getSurfaceTexture(), paramInt1, paramInt2);
        a.c(a.this).getAndSet(true);
        if (a.d(a.this) != null)
        {
          a.d(a.this);
          a.b(a.this);
        }
        AppMethodBeat.o(45194);
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    ac.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45198);
        ac.i("MicroMsg.CameraPreviewGLTextureView", "hy: onSurfaceTextureDestroyed in thread! can preview: %b", new Object[] { Boolean.valueOf(a.c(a.this).get()) });
        try
        {
          if (a.c(a.this).get())
          {
            boolean bool = a.b(a.this, a.b(a.this).getSurfaceTexture());
            a.c(a.this).getAndSet(false);
            if (a.a(a.this) == null) {
              break label170;
            }
            a.a(a.this).release(bool);
          }
          for (;;)
          {
            if (a.g(a.this) != null)
            {
              EGL14.eglDestroyContext(a.g(a.this).gWK, a.g(a.this).gWL);
              EGL14.eglDestroySurface(a.g(a.this).gWK, a.g(a.this).eglSurface);
              a.h(a.this).release();
            }
            AppMethodBeat.o(45198);
            return;
            label170:
            ac.w("MicroMsg.CameraPreviewGLTextureView", "hy: no renderer!");
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ac.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: error in surface destroy!!", new Object[0]);
          AppMethodBeat.o(45198);
        }
      }
    });
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    ac.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45195);
        a.b(a.this, a.b(a.this).getSurfaceTexture(), paramInt1, paramInt2);
        a.a(a.this, paramInt1);
        a.b(a.this, paramInt2);
        a.a(a.this).cR(a.e(a.this), a.f(a.this));
        AppMethodBeat.o(45195);
      }
    });
  }
  
  public void requestRender()
  {
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45197);
        try
        {
          if (a.a(a.this).gVl)
          {
            ((SurfaceTexture)Objects.requireNonNull(a.b(a.this).getSurfaceTexture())).updateTexImage();
            a.a(a.this).onDrawFrame(null);
          }
          while (a.c(a.this).get())
          {
            if (a.g(a.this) == null) {
              break label194;
            }
            EGLExt.eglPresentationTimeANDROID(a.g(a.this).gWK, a.g(a.this).eglSurface, System.nanoTime());
            EGL14.eglSwapBuffers(a.g(a.this).gWK, a.g(a.this).eglSurface);
            AppMethodBeat.o(45197);
            return;
            ac.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
          }
          ac.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
        }
        catch (Throwable localThrowable)
        {
          ac.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
          ((com.tencent.mm.plugin.appbrand.t.a)e.L(com.tencent.mm.plugin.appbrand.t.a.class)).idkeyStat(808L, 2L, 1L, true);
          AppMethodBeat.o(45197);
          return;
        }
        label194:
        AppMethodBeat.o(45197);
      }
    });
  }
  
  public void setOnSurfaceTextureAvailableDelegate(d.a parama)
  {
    this.jSc = parama;
    this.jSb.get();
  }
  
  public void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.f.d, y> paramb)
  {
    this.grf.hco = paramb;
  }
  
  public void setPreviewRenderer(final com.tencent.mm.media.i.a parama)
  {
    ac.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
    if (this.grf != null)
    {
      this.grf.release();
      this.grf = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    }
    this.grf = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    this.grf.b(parama);
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45196);
        a.a(a.this, parama);
        AppMethodBeat.o(45196);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.a
 * JD-Core Version:    0.7.0.1
 */