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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.b;
import d.y;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  extends h
  implements d
{
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a gBC;
  private com.tencent.mm.media.i.a gsB;
  private HandlerThread gsj = com.tencent.e.c.d.gu("GameTextureView_renderThread", -2);
  private ap gsk;
  private SurfaceTexture jrH;
  private c.b jrI;
  private AtomicBoolean jrJ = new AtomicBoolean(false);
  private d.a jrK;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public a(Context paramContext)
  {
    super(paramContext);
    this.gsj.start();
    this.gsk = new ap(this.gsj.getLooper());
  }
  
  private void queueEvent(Runnable paramRunnable)
  {
    if (Thread.currentThread().getId() == this.gsj.getId())
    {
      paramRunnable.run();
      return;
    }
    this.gsk.post(paramRunnable);
  }
  
  public EGLContext getEGLContext()
  {
    if (this.jrI == null) {
      return null;
    }
    return this.jrI.gwo;
  }
  
  public int getPreviewTextureId()
  {
    if ((this.gBC == null) || (this.gBC.fQI() == null)) {
      return -1;
    }
    return this.gBC.fQI().gro;
  }
  
  public final void j(final d.g.a.a<y> parama)
  {
    if (Thread.currentThread().getId() == this.gsj.getId())
    {
      parama.invoke();
      return;
    }
    this.gsk.post(new Runnable()
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
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45194);
        a.a(a.this, paramInt1);
        a.b(a.this, paramInt2);
        a.a(a.this, paramSurfaceTexture);
        a locala = a.this;
        c.a locala1 = com.tencent.mm.media.j.c.gwl;
        a.a(locala, c.a.a(new Surface(paramSurfaceTexture), null, 0, 0, EGL14.EGL_NO_CONTEXT));
        if (a.a(a.this) != null)
        {
          a.a(a.this).onSurfaceCreated(null, null);
          a.a(a.this).cT(paramInt1, paramInt2);
          a.a(a.this).cS(paramInt1, paramInt2);
          a.a(a.this).dI(true);
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
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureDestroyed");
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45198);
        ad.i("MicroMsg.CameraPreviewGLTextureView", "hy: onSurfaceTextureDestroyed in thread! can preview: %b", new Object[] { Boolean.valueOf(a.c(a.this).get()) });
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
              EGL14.eglDestroyContext(a.g(a.this).gwm, a.g(a.this).gwo);
              EGL14.eglDestroySurface(a.g(a.this).gwm, a.g(a.this).eglSurface);
              a.h(a.this).release();
            }
            AppMethodBeat.o(45198);
            return;
            label170:
            ad.w("MicroMsg.CameraPreviewGLTextureView", "hy: no renderer!");
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: error in surface destroy!!", new Object[0]);
          AppMethodBeat.o(45198);
        }
      }
    });
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    ad.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureSizeChanged, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    queueEvent(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45195);
        a.b(a.this, a.b(a.this).getSurfaceTexture(), paramInt1, paramInt2);
        a.a(a.this, paramInt1);
        a.b(a.this, paramInt2);
        a.a(a.this).cT(a.e(a.this), a.f(a.this));
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
          if (a.a(a.this).guH)
          {
            ((SurfaceTexture)Objects.requireNonNull(a.b(a.this).getSurfaceTexture())).updateTexImage();
            a.a(a.this).onDrawFrame(null);
          }
          while (a.c(a.this).get())
          {
            if (a.g(a.this) == null) {
              break label194;
            }
            EGLExt.eglPresentationTimeANDROID(a.g(a.this).gwm, a.g(a.this).eglSurface, System.nanoTime());
            EGL14.eglSwapBuffers(a.g(a.this).gwm, a.g(a.this).eglSurface);
            AppMethodBeat.o(45197);
            return;
            ad.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
          }
          ad.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
        }
        catch (Throwable localThrowable)
        {
          ad.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
          ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(808L, 2L, 1L, true);
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
    this.jrK = parama;
    this.jrJ.get();
  }
  
  public void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.f.d, y> paramb)
  {
    this.gBC.gBQ = paramb;
  }
  
  public void setPreviewRenderer(final com.tencent.mm.media.i.a parama)
  {
    ad.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
    if (this.gBC != null)
    {
      this.gBC.release();
      this.gBC = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    }
    this.gBC = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    this.gBC.b(parama);
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