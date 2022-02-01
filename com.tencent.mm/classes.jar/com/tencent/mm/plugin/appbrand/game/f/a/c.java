package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.view.SurfaceHolder;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.x;

public final class c
  extends com.tencent.magicbrush.ui.g
  implements e
{
  SurfaceHolder jAv;
  int mSurfaceHeight;
  int mSurfaceWidth;
  private a oot;
  boolean oou;
  int oov;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(45245);
    this.jAv = null;
    this.oou = false;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    this.oov = 0;
    this.oot = new a(this);
    this.oot.init();
    AppMethodBeat.o(45245);
  }
  
  static boolean zO(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  static boolean zP(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(264885);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(264885);
  }
  
  final void a(final b paramb)
  {
    AppMethodBeat.i(264876);
    if (paramb != null) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45199);
          paramb.onDone();
          AppMethodBeat.o(45199);
        }
      });
    }
    AppMethodBeat.o(264876);
  }
  
  public final void a(final boolean paramBoolean, final int paramInt, final b<? super Boolean, Void> paramb, final MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(264881);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45203);
        Log.i("MicroMsg.GameGLSurfaceView", "hy: request switch to render mode %d", new Object[] { Integer.valueOf(paramInt) });
        if ((!paramBoolean) && (c.a(c.this).isSupport(paramInt)))
        {
          Log.i("MicroMsg.GameGLSurfaceView", "hy: support status not changed!");
          paramb.invoke(Boolean.TRUE);
          AppMethodBeat.o(45203);
          return;
        }
        if ((paramMBRuntime.isDestroyed()) || (c.this.jAv == null))
        {
          Log.w("MicroMsg.GameGLSurfaceView", "hy: runtime  destroyed!");
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(45203);
          return;
        }
        if (!(paramMBRuntime instanceof com.tencent.magicbrush.e))
        {
          Log.w("MicroMsg.GameGLSurfaceView", "hy: runtime is not magic brush!");
          paramb.invoke(Boolean.FALSE);
          AppMethodBeat.o(45203);
          return;
        }
        c.a(c.this).a(c.this.jAv, new c.b()
        {
          public final void onDone()
          {
            AppMethodBeat.i(45202);
            if (c.2.this.ooy == 0) {
              c.a(c.this, new a(c.this));
            }
            for (;;)
            {
              c.a(c.this).init();
              c.a(c.this).a(c.this.jAv, new c.b()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(45201);
                  c.a(c.this).a(c.this.jAv, c.this.oov, c.this.mSurfaceWidth, c.this.mSurfaceHeight, new c.b()
                  {
                    public final void onDone()
                    {
                      AppMethodBeat.i(45200);
                      if (!c.a(c.this).isSupport(c.2.this.ooy))
                      {
                        Log.i("MicroMsg.GameGLSurfaceView", "switch record not support!");
                        c.2.this.ooA.invoke(Boolean.FALSE);
                        AppMethodBeat.o(45200);
                        return;
                      }
                      c.2.this.ooA.invoke(Boolean.TRUE);
                      AppMethodBeat.o(45200);
                    }
                  });
                  AppMethodBeat.o(45201);
                }
              });
              AppMethodBeat.o(45202);
              return;
              if ((c.zO(c.2.this.ooy)) && (c.zP(c.2.this.ooy)))
              {
                localIllegalArgumentException = new IllegalArgumentException("not support live and record at same time now");
                AppMethodBeat.o(45202);
                throw localIllegalArgumentException;
              }
              if (c.zP(c.2.this.ooy))
              {
                c.a(c.this, new f(c.this));
              }
              else
              {
                if (!c.zO(c.2.this.ooy)) {
                  break;
                }
                c.a(c.this, new g(c.this));
              }
            }
            IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("invalid flag");
            AppMethodBeat.o(45202);
            throw localIllegalArgumentException;
          }
        }, true);
        AppMethodBeat.o(45203);
      }
    });
    AppMethodBeat.o(264881);
  }
  
  final void b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(264884);
    super.surfaceCreated(paramSurfaceHolder);
    AppMethodBeat.o(264884);
  }
  
  public final Object bOP()
  {
    AppMethodBeat.i(264882);
    Object localObject = super.getSurfaceTexture();
    AppMethodBeat.o(264882);
    return localObject;
  }
  
  final void c(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(264887);
    super.surfaceDestroyed(paramSurfaceHolder);
    AppMethodBeat.o(264887);
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(45258);
    com.tencent.mm.media.j.a locala = this.oot.getAbsSurfaceRenderer();
    AppMethodBeat.o(45258);
    return locala;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(45252);
    EGLContext localEGLContext = this.oot.getEGLContext();
    AppMethodBeat.o(45252);
    return localEGLContext;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(45255);
    int i = this.oot.getPreviewTextureId();
    AppMethodBeat.o(45255);
    return i;
  }
  
  public final int getSurfaceHeight()
  {
    return this.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(264883);
    Object localObject = this.oot.getSurfaceTexture();
    AppMethodBeat.o(264883);
    return localObject;
  }
  
  public final int getSurfaceWidth()
  {
    return this.mSurfaceWidth;
  }
  
  public final void i(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(45257);
    this.oot.i(parama);
    AppMethodBeat.o(45257);
  }
  
  public final boolean isAvailable()
  {
    return this.oou;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(45256);
    this.oot.requestRender();
    AppMethodBeat.o(45256);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(45251);
    Log.i("MicroMsg.GameGLSurfaceView", "setOnSurfaceTextureAvailableDelegate:");
    this.oot.setOnSurfaceTextureAvailableDelegate(parama);
    AppMethodBeat.o(45251);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, x> paramb)
  {
    AppMethodBeat.i(45253);
    this.oot.setOnTextureDrawFinishDelegate(paramb);
    AppMethodBeat.o(45253);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(45254);
    this.oot.setPreviewRenderer(parama);
    AppMethodBeat.o(45254);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(45249);
    Log.i("MicroMsg.GameGLSurfaceView", "surfaceChanged %s", new Object[] { paramSurfaceHolder });
    try
    {
      this.oov = paramInt1;
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.jAv = paramSurfaceHolder;
      this.oot.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3, null);
      AppMethodBeat.o(45249);
      return;
    }
    finally
    {
      AppMethodBeat.o(45249);
    }
  }
  
  /* Error */
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: ldc 177
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 145
    //   7: ldc 179
    //   9: iconst_1
    //   10: anewarray 170	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 45	com/tencent/mm/plugin/appbrand/game/f/a/c:jAv	Landroid/view/SurfaceHolder;
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 60	com/tencent/mm/plugin/appbrand/game/f/a/c:oot	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$a;
    //   33: aload_1
    //   34: aconst_null
    //   35: invokeinterface 182 3 0
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 47	com/tencent/mm/plugin/appbrand/game/f/a/c:oou	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc 177
    //   51: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: ldc 177
    //   60: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: ldc 177
    //   70: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	c
    //   0	75	1	paramSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   22	29	55	finally
    //   42	49	65	finally
  }
  
  /* Error */
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    // Byte code:
    //   0: ldc 183
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 145
    //   7: ldc 185
    //   9: aload_1
    //   10: invokestatic 191	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 195	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: aload_1
    //   23: putfield 45	com/tencent/mm/plugin/appbrand/game/f/a/c:jAv	Landroid/view/SurfaceHolder;
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 60	com/tencent/mm/plugin/appbrand/game/f/a/c:oot	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$a;
    //   32: aload_1
    //   33: aconst_null
    //   34: iconst_0
    //   35: invokeinterface 198 4 0
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 47	com/tencent/mm/plugin/appbrand/game/f/a/c:oou	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc 183
    //   51: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: ldc 183
    //   60: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: ldc 183
    //   70: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	c
    //   0	75	1	paramSurfaceHolder	SurfaceHolder
    // Exception table:
    //   from	to	target	type
    //   21	28	55	finally
    //   42	49	65	finally
  }
  
  static abstract interface a
    extends e
  {
    public abstract void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb);
    
    public abstract void a(SurfaceHolder paramSurfaceHolder, c.b paramb);
    
    public abstract void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean);
    
    public abstract com.tencent.mm.media.j.a getAbsSurfaceRenderer();
    
    public abstract Object getSurfaceTexture();
    
    public abstract void init();
    
    public abstract boolean isSupport(int paramInt);
  }
  
  static abstract interface b
  {
    public abstract void onDone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.c
 * JD-Core Version:    0.7.0.1
 */