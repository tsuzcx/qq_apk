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
import com.tencent.mm.media.k.c.a;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.x;

public abstract class b
  extends h
  implements e
{
  private HandlerThread kVN = com.tencent.e.c.d.ij("GameTextureView_renderThread", -2);
  private MMHandler kVO;
  private com.tencent.mm.media.j.a kWg;
  private com.tencent.mm.media.widget.camerarecordview.preview.a.a krm;
  private SurfaceTexture ool;
  private c.b oom;
  private AtomicBoolean oon = new AtomicBoolean(false);
  private e.a ooo;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.kVN.start();
    this.kVO = new MMHandler(this.kVN.getLooper());
  }
  
  private void aa(Runnable paramRunnable)
  {
    if (Thread.currentThread().getId() == this.kVN.getId())
    {
      paramRunnable.run();
      return;
    }
    this.kVO.post(paramRunnable);
  }
  
  public EGLContext getEGLContext()
  {
    if (this.oom == null) {
      return null;
    }
    return this.oom.lau;
  }
  
  public int getPreviewTextureId()
  {
    if ((this.krm == null) || (this.krm.aZm() == null)) {
      return -1;
    }
    return this.krm.aZm().kVj;
  }
  
  public final void i(final kotlin.g.a.a<x> parama)
  {
    if (Thread.currentThread().getId() == this.kVN.getId())
    {
      parama.invoke();
      return;
    }
    this.kVO.post(new Runnable()
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
    Log.i("MicroMsg.CameraPreviewGLTextureView", "onSurfaceTextureAvailable, surfaceTexture:%s, width:%d, height:%d", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45194);
        b.a(b.this, paramInt1);
        b.b(b.this, paramInt2);
        b.a(b.this, paramSurfaceTexture);
        b localb = b.this;
        c.a locala = com.tencent.mm.media.k.c.lar;
        b.a(localb, c.a.a(new Surface(paramSurfaceTexture), null, 0, 0, EGL14.EGL_NO_CONTEXT));
        if (b.a(b.this) != null)
        {
          b.a(b.this).onSurfaceCreated(null, null);
          b.a(b.this).du(paramInt1, paramInt2);
          b.a(b.this).dv(paramInt1, paramInt2);
          b.a(b.this).fF(true);
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
    aa(new Runnable()
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
              EGL14.eglDestroyContext(b.g(b.this).las, b.g(b.this).lau);
              EGL14.eglDestroySurface(b.g(b.this).las, b.g(b.this).eglSurface);
              b.h(b.this).release();
            }
            AppMethodBeat.o(45198);
            return;
            label170:
            Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: no renderer!");
          }
          return;
        }
        catch (Throwable localThrowable)
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
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45195);
        b.b(b.this, b.b(b.this).getSurfaceTexture(), paramInt1, paramInt2);
        b.a(b.this, paramInt1);
        b.b(b.this, paramInt2);
        b.a(b.this).du(b.e(b.this), b.f(b.this));
        AppMethodBeat.o(45195);
      }
    });
  }
  
  public void requestRender()
  {
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45197);
        try
        {
          if (b.a(b.this).kYl)
          {
            ((SurfaceTexture)Objects.requireNonNull(b.b(b.this).getSurfaceTexture())).updateTexImage();
            b.a(b.this).onDrawFrame(null);
          }
          while (b.c(b.this).get())
          {
            if (b.g(b.this) == null) {
              break label194;
            }
            EGLExt.eglPresentationTimeANDROID(b.g(b.this).las, b.g(b.this).eglSurface, System.nanoTime());
            EGL14.eglSwapBuffers(b.g(b.this).las, b.g(b.this).eglSurface);
            AppMethodBeat.o(45197);
            return;
            Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: renderer already released!");
          }
          Log.w("MicroMsg.CameraPreviewGLTextureView", "hy: can not render because already destroyed");
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.CameraPreviewGLTextureView", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
          ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808L, 2L, 1L, true);
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
    this.ooo = parama;
    if (this.oon.get()) {
      this.krm.getSurfaceTexture();
    }
  }
  
  public void setOnTextureDrawFinishDelegate(kotlin.g.a.b<com.tencent.mm.media.g.d, x> paramb)
  {
    this.krm.lfQ = paramb;
  }
  
  public void setPreviewRenderer(final com.tencent.mm.media.j.a parama)
  {
    Log.i("MicroMsg.CameraPreviewGLTextureView", "setRenderer: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
    if (this.krm != null)
    {
      this.krm.release(true);
      this.krm = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    }
    this.krm = new com.tencent.mm.media.widget.camerarecordview.preview.a.c(this);
    this.krm.b(parama);
    aa(new Runnable()
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