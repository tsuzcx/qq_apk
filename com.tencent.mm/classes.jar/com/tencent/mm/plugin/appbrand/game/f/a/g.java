package com.tencent.mm.plugin.appbrand.game.f.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLExt;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.a.b;
import kotlin.x;

final class g
  implements c.a
{
  private HandlerThread kVN;
  private MMHandler kVO;
  com.tencent.mm.media.j.a kWg;
  com.tencent.mm.media.widget.camerarecordview.preview.a.a krm;
  private com.tencent.mm.media.j.a ooF;
  volatile boolean ooK;
  final c ook;
  com.tencent.mm.media.k.c.b oom;
  AtomicBoolean oon;
  e.a ooo;
  Surface surface;
  
  public g(c paramc)
  {
    AppMethodBeat.i(282276);
    this.oon = new AtomicBoolean(false);
    this.ooF = null;
    this.ooK = false;
    this.ook = paramc;
    AppMethodBeat.o(282276);
  }
  
  private void aa(Runnable paramRunnable)
  {
    AppMethodBeat.i(282284);
    if (Thread.currentThread().getId() == this.kVN.getId())
    {
      paramRunnable.run();
      AppMethodBeat.o(282284);
      return;
    }
    this.kVO.post(paramRunnable);
    AppMethodBeat.o(282284);
  }
  
  public final void a(final SurfaceHolder paramSurfaceHolder, final int paramInt1, final int paramInt2, final int paramInt3, final c.b paramb)
  {
    AppMethodBeat.i(282281);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(265355);
        if (g.this.kWg != null)
        {
          g.this.kWg.du(paramInt2, paramInt3);
          g.this.kWg.dv(paramInt2, paramInt3);
        }
        g.this.oon.getAndSet(true);
        if (g.this.ooo != null) {
          g.this.krm.getSurfaceTexture();
        }
        g.this.ook.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
        g.this.ook.a(paramb);
        AppMethodBeat.o(265355);
      }
    });
    AppMethodBeat.o(282281);
  }
  
  public final void a(final SurfaceHolder paramSurfaceHolder, final c.b paramb)
  {
    AppMethodBeat.i(282279);
    try
    {
      this.ooF = new g.1(this);
      setPreviewRenderer(new g.2(this));
      aa(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268569);
          g.this.surface = paramSurfaceHolder.getSurface();
          if ((g.this.surface != null) && (g.this.surface.isValid()))
          {
            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface switch to record!");
            g.this.ooK = true;
            Object localObject = g.this;
            com.tencent.mm.media.k.c.a locala = com.tencent.mm.media.k.c.lar;
            ((g)localObject).oom = com.tencent.mm.media.k.c.a.a(g.this.surface, null, 0, 0, EGL14.EGL_NO_CONTEXT);
            if (g.this.kWg != null)
            {
              g.this.kWg.onSurfaceCreated(null, null);
              localObject = paramSurfaceHolder.getSurfaceFrame();
              g.this.kWg.du(((Rect)localObject).width(), ((Rect)localObject).height());
              g.this.kWg.dv(((Rect)localObject).width(), ((Rect)localObject).height());
              g.this.kWg.fF(true);
            }
          }
          for (;;)
          {
            g.this.ook.b(paramSurfaceHolder);
            g.this.ook.a(paramb);
            AppMethodBeat.o(268569);
            return;
            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "renderer is null!");
            continue;
            if (g.this.surface == null) {
              Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface is null!");
            } else if (!g.this.surface.isValid()) {
              Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "surface is disable!");
            }
          }
        }
      });
      AppMethodBeat.o(282279);
      return;
    }
    catch (Exception paramSurfaceHolder)
    {
      Log.e("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: onSurfaceTextureAvailable, error:" + paramSurfaceHolder.getMessage());
      this.ook.a(paramb);
      AppMethodBeat.o(282279);
    }
  }
  
  public final void a(SurfaceHolder paramSurfaceHolder, final c.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(282282);
    if (this.ooF != null) {
      this.ooF.release(false);
    }
    aa(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 26
        //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 34
        //   7: ldc 36
        //   9: iconst_1
        //   10: anewarray 4	java/lang/Object
        //   13: dup
        //   14: iconst_0
        //   15: aload_0
        //   16: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   19: getfield 40	com/tencent/mm/plugin/appbrand/game/f/a/g:oon	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   22: invokevirtual 46	java/util/concurrent/atomic/AtomicBoolean:get	()Z
        //   25: invokestatic 52	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   28: aastore
        //   29: invokestatic 57	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   32: aload_0
        //   33: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   36: getfield 40	com/tencent/mm/plugin/appbrand/game/f/a/g:oon	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   39: invokevirtual 46	java/util/concurrent/atomic/AtomicBoolean:get	()Z
        //   42: ifeq +114 -> 156
        //   45: aload_0
        //   46: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   49: getfield 40	com/tencent/mm/plugin/appbrand/game/f/a/g:oon	Ljava/util/concurrent/atomic/AtomicBoolean;
        //   52: iconst_0
        //   53: invokevirtual 61	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
        //   56: pop
        //   57: aload_0
        //   58: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   61: getfield 65	com/tencent/mm/plugin/appbrand/game/f/a/g:kWg	Lcom/tencent/mm/media/j/a;
        //   64: ifnull +112 -> 176
        //   67: aload_0
        //   68: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   71: getfield 65	com/tencent/mm/plugin/appbrand/game/f/a/g:kWg	Lcom/tencent/mm/media/j/a;
        //   74: iconst_1
        //   75: invokevirtual 71	com/tencent/mm/media/j/a:release	(Z)V
        //   78: aload_0
        //   79: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   82: getfield 75	com/tencent/mm/plugin/appbrand/game/f/a/g:oom	Lcom/tencent/mm/media/k/c$b;
        //   85: ifnull +71 -> 156
        //   88: aload_0
        //   89: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   92: getfield 75	com/tencent/mm/plugin/appbrand/game/f/a/g:oom	Lcom/tencent/mm/media/k/c$b;
        //   95: getfield 81	com/tencent/mm/media/k/c$b:las	Landroid/opengl/EGLDisplay;
        //   98: aload_0
        //   99: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   102: getfield 75	com/tencent/mm/plugin/appbrand/game/f/a/g:oom	Lcom/tencent/mm/media/k/c$b;
        //   105: getfield 85	com/tencent/mm/media/k/c$b:lau	Landroid/opengl/EGLContext;
        //   108: invokestatic 91	android/opengl/EGL14:eglDestroyContext	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLContext;)Z
        //   111: pop
        //   112: aload_0
        //   113: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   116: getfield 75	com/tencent/mm/plugin/appbrand/game/f/a/g:oom	Lcom/tencent/mm/media/k/c$b;
        //   119: getfield 81	com/tencent/mm/media/k/c$b:las	Landroid/opengl/EGLDisplay;
        //   122: aload_0
        //   123: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   126: getfield 75	com/tencent/mm/plugin/appbrand/game/f/a/g:oom	Lcom/tencent/mm/media/k/c$b;
        //   129: getfield 95	com/tencent/mm/media/k/c$b:eglSurface	Landroid/opengl/EGLSurface;
        //   132: invokestatic 99	android/opengl/EGL14:eglDestroySurface	(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)Z
        //   135: pop
        //   136: aload_0
        //   137: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   140: getfield 103	com/tencent/mm/plugin/appbrand/game/f/a/g:ook	Lcom/tencent/mm/plugin/appbrand/game/f/a/c;
        //   143: aload_0
        //   144: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   147: getfield 103	com/tencent/mm/plugin/appbrand/game/f/a/g:ook	Lcom/tencent/mm/plugin/appbrand/game/f/a/c;
        //   150: getfield 109	com/tencent/mm/plugin/appbrand/game/f/a/c:jAv	Landroid/view/SurfaceHolder;
        //   153: invokevirtual 113	com/tencent/mm/plugin/appbrand/game/f/a/c:c	(Landroid/view/SurfaceHolder;)V
        //   156: aload_0
        //   157: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   160: getfield 103	com/tencent/mm/plugin/appbrand/game/f/a/g:ook	Lcom/tencent/mm/plugin/appbrand/game/f/a/c;
        //   163: aload_0
        //   164: getfield 18	com/tencent/mm/plugin/appbrand/game/f/a/g$5:oow	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;
        //   167: invokevirtual 117	com/tencent/mm/plugin/appbrand/game/f/a/c:a	(Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;)V
        //   170: ldc 26
        //   172: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   175: return
        //   176: ldc 34
        //   178: ldc 122
        //   180: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   183: goto -105 -> 78
        //   186: astore_1
        //   187: ldc 34
        //   189: aload_1
        //   190: ldc 128
        //   192: iconst_0
        //   193: anewarray 4	java/lang/Object
        //   196: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   199: aload_0
        //   200: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   203: getfield 103	com/tencent/mm/plugin/appbrand/game/f/a/g:ook	Lcom/tencent/mm/plugin/appbrand/game/f/a/c;
        //   206: aload_0
        //   207: getfield 18	com/tencent/mm/plugin/appbrand/game/f/a/g$5:oow	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;
        //   210: invokevirtual 117	com/tencent/mm/plugin/appbrand/game/f/a/c:a	(Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;)V
        //   213: ldc 26
        //   215: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   218: return
        //   219: astore_1
        //   220: aload_0
        //   221: getfield 16	com/tencent/mm/plugin/appbrand/game/f/a/g$5:ooL	Lcom/tencent/mm/plugin/appbrand/game/f/a/g;
        //   224: getfield 103	com/tencent/mm/plugin/appbrand/game/f/a/g:ook	Lcom/tencent/mm/plugin/appbrand/game/f/a/c;
        //   227: aload_0
        //   228: getfield 18	com/tencent/mm/plugin/appbrand/game/f/a/g$5:oow	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;
        //   231: invokevirtual 117	com/tencent/mm/plugin/appbrand/game/f/a/c:a	(Lcom/tencent/mm/plugin/appbrand/game/f/a/c$b;)V
        //   234: ldc 26
        //   236: invokestatic 120	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   239: aload_1
        //   240: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	241	0	this	5
        //   186	4	1	localThrowable	Throwable
        //   219	21	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   32	78	186	java/lang/Throwable
        //   78	156	186	java/lang/Throwable
        //   176	183	186	java/lang/Throwable
        //   32	78	219	finally
        //   78	156	219	finally
        //   176	183	219	finally
        //   187	199	219	finally
      }
    });
    AppMethodBeat.o(282282);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    return this.ooF;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(282286);
    Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "getEGLContext environment:" + this.oom);
    if (this.oom == null)
    {
      AppMethodBeat.o(282286);
      return null;
    }
    EGLContext localEGLContext = this.oom.lau;
    AppMethodBeat.o(282286);
    return localEGLContext;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(282289);
    Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "getPreviewTextureId previewController:" + this.krm.aZm());
    if ((this.krm == null) || (this.krm.aZm() == null))
    {
      AppMethodBeat.o(282289);
      return -1;
    }
    int i = this.krm.aZm().kVj;
    AppMethodBeat.o(282289);
    return i;
  }
  
  public final int getSurfaceHeight()
  {
    return this.ook.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(282283);
    SurfaceTexture localSurfaceTexture = this.krm.getSurfaceTexture();
    AppMethodBeat.o(282283);
    return localSurfaceTexture;
  }
  
  public final int getSurfaceWidth()
  {
    return this.ook.mSurfaceWidth;
  }
  
  public final void i(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(282291);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268301);
        parama.invoke();
        AppMethodBeat.o(268301);
      }
    });
    AppMethodBeat.o(282291);
  }
  
  public final void init()
  {
    AppMethodBeat.i(282277);
    this.kVN = com.tencent.e.c.d.im("GameTextureView_renderThread", -2);
    this.kVN.start();
    this.kVO = new MMHandler(this.kVN.getLooper());
    AppMethodBeat.o(282277);
  }
  
  public final boolean isAvailable()
  {
    return this.ook.oou;
  }
  
  public final boolean isSupport(int paramInt)
  {
    AppMethodBeat.i(282278);
    if (!this.ooK)
    {
      AppMethodBeat.o(282278);
      return false;
    }
    if ((c.zO(paramInt)) && (!c.zP(paramInt)))
    {
      AppMethodBeat.o(282278);
      return true;
    }
    AppMethodBeat.o(282278);
    return false;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(282290);
    aa(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279785);
        try
        {
          if (g.this.kWg.kYl)
          {
            ((SurfaceTexture)Objects.requireNonNull(g.this.krm.getSurfaceTexture())).updateTexImage();
            g.this.kWg.onDrawFrame(null);
          }
          while (g.this.oon.get())
          {
            if (g.this.oom == null) {
              break label194;
            }
            EGLExt.eglPresentationTimeANDROID(g.this.oom.las, g.this.oom.eglSurface, System.nanoTime());
            EGL14.eglSwapBuffers(g.this.oom.las, g.this.oom.eglSurface);
            AppMethodBeat.o(279785);
            return;
            Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: renderer already released!");
          }
          Log.w("MicroMsg.GameRecordableSurfaceView.RecordableImp", "hy: can not render because already destroyed");
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.GameRecordableSurfaceView.RecordableImp", localThrowable, "hy: encounter exception! gl get error: %d", new Object[] { Integer.valueOf(EGL14.eglGetError()) });
          ((com.tencent.mm.plugin.appbrand.w.a)e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(808L, 2L, 1L, true);
          AppMethodBeat.o(279785);
          return;
        }
        label194:
        AppMethodBeat.o(279785);
      }
    });
    AppMethodBeat.o(282290);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(282285);
    this.ooo = parama;
    if (this.oon.get()) {
      this.krm.getSurfaceTexture();
    }
    AppMethodBeat.o(282285);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<com.tencent.mm.media.g.d, x> paramb)
  {
    AppMethodBeat.i(282287);
    Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "setOnTextureDrawFinishDelegate:");
    this.krm.lfQ = paramb;
    AppMethodBeat.o(282287);
  }
  
  public final void setPreviewRenderer(final com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(282288);
    Log.i("MicroMsg.GameRecordableSurfaceView.RecordableImp", "setRenderer: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
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
        g.this.kWg = parama;
      }
    });
    AppMethodBeat.o(282288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.g
 * JD-Core Version:    0.7.0.1
 */