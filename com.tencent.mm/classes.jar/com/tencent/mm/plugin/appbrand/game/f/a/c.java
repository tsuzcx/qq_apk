package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.opengl.EGLContext;
import android.view.SurfaceHolder;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ah;
import kotlin.g.a.b;

public final class c
  extends com.tencent.magicbrush.ui.g
  implements e
{
  int mSurfaceHeight;
  int mSurfaceWidth;
  private a rsc;
  SurfaceHolder rsd;
  boolean rse;
  int rsf;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(45245);
    this.rsd = null;
    this.rse = false;
    this.mSurfaceWidth = 0;
    this.mSurfaceHeight = 0;
    this.rsf = 0;
    this.rsc = new a(this);
    this.rsc.init();
    AppMethodBeat.o(45245);
  }
  
  static boolean Ag(int paramInt)
  {
    return (paramInt & 0x1) > 0;
  }
  
  static boolean Ah(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  public final void H(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(45257);
    this.rsc.H(parama);
    AppMethodBeat.o(45257);
  }
  
  final void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(318501);
    super.surfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(318501);
  }
  
  final void a(final b paramb)
  {
    AppMethodBeat.i(318473);
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
    AppMethodBeat.o(318473);
  }
  
  public final void a(final boolean paramBoolean, final int paramInt, final b<? super Boolean, Void> paramb, final MBRuntime paramMBRuntime)
  {
    AppMethodBeat.i(318479);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45203);
        Log.i("MicroMsg.GameGLSurfaceView", "hy: request switch to render mode %d", new Object[] { Integer.valueOf(paramInt) });
        if ((!paramBoolean) && (c.a(c.this).Af(paramInt)))
        {
          Log.i("MicroMsg.GameGLSurfaceView", "hy: support status not changed!");
          paramb.invoke(Boolean.TRUE);
          AppMethodBeat.o(45203);
          return;
        }
        if ((paramMBRuntime.isDestroyed()) || (c.this.rsd == null))
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
        c.a(c.this).a(c.this.rsd, new c.b()
        {
          public final void onDone()
          {
            AppMethodBeat.i(45202);
            if (c.2.this.rsi == 0) {
              c.a(c.this, new a(c.this));
            }
            for (;;)
            {
              c.a(c.this).init();
              c.a(c.this).a(c.this.rsd, new c.b()
              {
                public final void onDone()
                {
                  AppMethodBeat.i(45201);
                  c.a(c.this).a(c.this.rsd, c.this.rsf, c.this.mSurfaceWidth, c.this.mSurfaceHeight, new c.b()
                  {
                    public final void onDone()
                    {
                      AppMethodBeat.i(45200);
                      if (!c.a(c.this).Af(c.2.this.rsi))
                      {
                        Log.i("MicroMsg.GameGLSurfaceView", "switch record not support!");
                        c.2.this.rsk.invoke(Boolean.FALSE);
                        AppMethodBeat.o(45200);
                        return;
                      }
                      c.2.this.rsk.invoke(Boolean.TRUE);
                      AppMethodBeat.o(45200);
                    }
                  });
                  AppMethodBeat.o(45201);
                }
              });
              AppMethodBeat.o(45202);
              return;
              if ((c.Ag(c.2.this.rsi)) && (c.Ah(c.2.this.rsi)))
              {
                localIllegalArgumentException = new IllegalArgumentException("not support live and record at same time now");
                AppMethodBeat.o(45202);
                throw localIllegalArgumentException;
              }
              if (c.Ah(c.2.this.rsi))
              {
                c.a(c.this, new f(c.this));
              }
              else
              {
                if (!c.Ag(c.2.this.rsi)) {
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
    AppMethodBeat.o(318479);
  }
  
  final void b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(318492);
    super.surfaceCreated(paramSurfaceHolder);
    AppMethodBeat.o(318492);
  }
  
  final void c(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(318506);
    super.surfaceDestroyed(paramSurfaceHolder);
    AppMethodBeat.o(318506);
  }
  
  public final Object cpd()
  {
    AppMethodBeat.i(318485);
    Object localObject = super.getSurfaceTexture();
    AppMethodBeat.o(318485);
    return localObject;
  }
  
  public final com.tencent.mm.media.j.a getAbsSurfaceRenderer()
  {
    AppMethodBeat.i(45258);
    com.tencent.mm.media.j.a locala = this.rsc.getAbsSurfaceRenderer();
    AppMethodBeat.o(45258);
    return locala;
  }
  
  public final EGLContext getEGLContext()
  {
    AppMethodBeat.i(45252);
    EGLContext localEGLContext = this.rsc.getEGLContext();
    AppMethodBeat.o(45252);
    return localEGLContext;
  }
  
  public final int getPreviewTextureId()
  {
    AppMethodBeat.i(45255);
    int i = this.rsc.getPreviewTextureId();
    AppMethodBeat.o(45255);
    return i;
  }
  
  public final int getSurfaceHeight()
  {
    return this.mSurfaceHeight;
  }
  
  public final Object getSurfaceTexture()
  {
    AppMethodBeat.i(318489);
    Object localObject = this.rsc.getSurfaceTexture();
    AppMethodBeat.o(318489);
    return localObject;
  }
  
  public final int getSurfaceWidth()
  {
    return this.mSurfaceWidth;
  }
  
  public final boolean isAvailable()
  {
    return this.rse;
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(45256);
    this.rsc.requestRender();
    AppMethodBeat.o(45256);
  }
  
  public final void setOnSurfaceTextureAvailableDelegate(e.a parama)
  {
    AppMethodBeat.i(45251);
    Log.i("MicroMsg.GameGLSurfaceView", "setOnSurfaceTextureAvailableDelegate:");
    this.rsc.setOnSurfaceTextureAvailableDelegate(parama);
    AppMethodBeat.o(45251);
  }
  
  public final void setOnTextureDrawFinishDelegate(b<d, ah> paramb)
  {
    AppMethodBeat.i(45253);
    this.rsc.setOnTextureDrawFinishDelegate(paramb);
    AppMethodBeat.o(45253);
  }
  
  public final void setPreviewRenderer(com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(45254);
    this.rsc.setPreviewRenderer(parama);
    AppMethodBeat.o(45254);
  }
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(45249);
    Log.i("MicroMsg.GameGLSurfaceView", "surfaceChanged %s", new Object[] { paramSurfaceHolder });
    try
    {
      this.rsf = paramInt1;
      this.mSurfaceWidth = paramInt2;
      this.mSurfaceHeight = paramInt3;
      this.rsd = paramSurfaceHolder;
      this.rsc.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3, null);
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
    //   0: ldc 178
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 146
    //   7: ldc 180
    //   9: iconst_1
    //   10: anewarray 171	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_1
    //   16: aastore
    //   17: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 45	com/tencent/mm/plugin/appbrand/game/f/a/c:rsd	Landroid/view/SurfaceHolder;
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_0
    //   30: getfield 60	com/tencent/mm/plugin/appbrand/game/f/a/c:rsc	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$a;
    //   33: aload_1
    //   34: aconst_null
    //   35: invokeinterface 183 3 0
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: iconst_1
    //   44: putfield 47	com/tencent/mm/plugin/appbrand/game/f/a/c:rse	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc 178
    //   51: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: ldc 178
    //   60: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: ldc 178
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
    //   0: ldc 184
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 146
    //   7: ldc 186
    //   9: aload_1
    //   10: invokestatic 192	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 196	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: aload_1
    //   23: putfield 45	com/tencent/mm/plugin/appbrand/game/f/a/c:rsd	Landroid/view/SurfaceHolder;
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_0
    //   29: getfield 60	com/tencent/mm/plugin/appbrand/game/f/a/c:rsc	Lcom/tencent/mm/plugin/appbrand/game/f/a/c$a;
    //   32: aload_1
    //   33: aconst_null
    //   34: iconst_0
    //   35: invokeinterface 199 4 0
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 47	com/tencent/mm/plugin/appbrand/game/f/a/c:rse	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc 184
    //   51: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: return
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: ldc 184
    //   60: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_1
    //   64: athrow
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: ldc 184
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
    public abstract boolean Af(int paramInt);
    
    public abstract void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3, c.b paramb);
    
    public abstract void a(SurfaceHolder paramSurfaceHolder, c.b paramb);
    
    public abstract void a(SurfaceHolder paramSurfaceHolder, c.b paramb, boolean paramBoolean);
    
    public abstract com.tencent.mm.media.j.a getAbsSurfaceRenderer();
    
    public abstract Object getSurfaceTexture();
    
    public abstract void init();
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