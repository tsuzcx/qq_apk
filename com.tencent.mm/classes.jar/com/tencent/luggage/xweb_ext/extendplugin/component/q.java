package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class q
{
  private static final Field cEl;
  private final List<b> mListeners;
  private final SurfaceTexture mSurfaceTexture;
  
  static
  {
    AppMethodBeat.i(215554);
    Object localObject = null;
    try
    {
      Field localField = SurfaceTexture.class.getDeclaredField("mOnFrameAvailableHandler");
      localObject = localField;
      localField.setAccessible(true);
      localObject = localField;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.AppBrand.SurfaceTextureWrapper", "get mOnFrameAvailableHandler fail since " + localException.toString());
      }
    }
    cEl = localObject;
    AppMethodBeat.o(215554);
  }
  
  private q(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(215549);
    this.mListeners = new ArrayList();
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(215549);
  }
  
  /* Error */
  public static q d(SurfaceTexture paramSurfaceTexture)
  {
    // Byte code:
    //   0: ldc 97
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: getstatic 48	com/tencent/luggage/xweb_ext/extendplugin/component/q:cEl	Ljava/lang/reflect/Field;
    //   10: ifnonnull +12 -> 22
    //   13: aload_0
    //   14: monitorexit
    //   15: ldc 97
    //   17: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: getstatic 48	com/tencent/luggage/xweb_ext/extendplugin/component/q:cEl	Ljava/lang/reflect/Field;
    //   25: aload_0
    //   26: invokevirtual 101	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 103	android/os/Handler
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +19 -> 53
    //   37: ldc 53
    //   39: ldc 105
    //   41: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_0
    //   45: monitorexit
    //   46: ldc 97
    //   48: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aconst_null
    //   52: areturn
    //   53: aload_2
    //   54: instanceof 8
    //   57: ifeq +27 -> 84
    //   60: ldc 53
    //   62: ldc 107
    //   64: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_2
    //   68: checkcast 8	com/tencent/luggage/xweb_ext/extendplugin/component/q$a
    //   71: getfield 113	com/tencent/luggage/xweb_ext/extendplugin/component/q$a:cEo	Lcom/tencent/luggage/xweb_ext/extendplugin/component/q;
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: ldc 97
    //   79: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: areturn
    //   84: new 2	com/tencent/luggage/xweb_ext/extendplugin/component/q
    //   87: dup
    //   88: aload_0
    //   89: invokespecial 115	com/tencent/luggage/xweb_ext/extendplugin/component/q:<init>	(Landroid/graphics/SurfaceTexture;)V
    //   92: astore_1
    //   93: new 8	com/tencent/luggage/xweb_ext/extendplugin/component/q$a
    //   96: dup
    //   97: aload_2
    //   98: aload_1
    //   99: invokespecial 118	com/tencent/luggage/xweb_ext/extendplugin/component/q$a:<init>	(Landroid/os/Handler;Lcom/tencent/luggage/xweb_ext/extendplugin/component/q;)V
    //   102: astore_2
    //   103: getstatic 48	com/tencent/luggage/xweb_ext/extendplugin/component/q:cEl	Ljava/lang/reflect/Field;
    //   106: aload_0
    //   107: aload_2
    //   108: invokevirtual 122	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   111: aload_0
    //   112: monitorexit
    //   113: ldc 97
    //   115: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: areturn
    //   120: astore_1
    //   121: ldc 53
    //   123: new 55	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 124
    //   129: invokespecial 61	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload_1
    //   133: invokevirtual 65	java/lang/Exception:toString	()Ljava/lang/String;
    //   136: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 76	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: monitorexit
    //   147: ldc 97
    //   149: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aconst_null
    //   153: areturn
    //   154: astore_1
    //   155: aload_0
    //   156: monitorexit
    //   157: ldc 97
    //   159: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramSurfaceTexture	SurfaceTexture
    //   74	45	1	localq	q
    //   120	13	1	localException	Exception
    //   154	9	1	localObject1	Object
    //   32	76	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	33	120	java/lang/Exception
    //   37	44	120	java/lang/Exception
    //   53	75	120	java/lang/Exception
    //   84	111	120	java/lang/Exception
    //   7	15	154	finally
    //   22	33	154	finally
    //   37	44	154	finally
    //   44	46	154	finally
    //   53	75	154	finally
    //   75	77	154	finally
    //   84	111	154	finally
    //   111	113	154	finally
    //   121	147	154	finally
    //   155	157	154	finally
  }
  
  private void onFrameAvailable()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(215552);
        Iterator localIterator = this.mListeners.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        final b localb = (b)localIterator.next();
        if (localb.handler == null) {
          localb.cEq.onFrameAvailable(this.mSurfaceTexture);
        } else {
          localb.handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215543);
              localb.cEq.onFrameAvailable(q.a(q.this));
              AppMethodBeat.o(215543);
            }
          });
        }
      }
      finally {}
    }
    AppMethodBeat.o(215552);
  }
  
  public final void a(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener)
  {
    try
    {
      AppMethodBeat.i(215551);
      this.mListeners.remove(new b(paramOnFrameAvailableListener, null));
      AppMethodBeat.o(215551);
      return;
    }
    finally
    {
      paramOnFrameAvailableListener = finally;
      throw paramOnFrameAvailableListener;
    }
  }
  
  public final void a(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
  {
    try
    {
      AppMethodBeat.i(215550);
      paramOnFrameAvailableListener = new b(paramOnFrameAvailableListener, paramHandler);
      this.mListeners.remove(paramOnFrameAvailableListener);
      this.mListeners.add(paramOnFrameAvailableListener);
      AppMethodBeat.o(215550);
      return;
    }
    finally
    {
      paramOnFrameAvailableListener = finally;
      throw paramOnFrameAvailableListener;
    }
  }
  
  static final class a
    extends Handler
  {
    public final q cEo;
    private final Handler cEp;
    
    public a(Handler paramHandler, q paramq)
    {
      super();
      AppMethodBeat.i(215544);
      this.cEp = paramHandler;
      this.cEo = paramq;
      AppMethodBeat.o(215544);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(215545);
      this.cEp.handleMessage(paramMessage);
      q.b(this.cEo);
      AppMethodBeat.o(215545);
    }
  }
  
  static final class b
  {
    public final SurfaceTexture.OnFrameAvailableListener cEq;
    public final Handler handler;
    
    public b(SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
    {
      this.cEq = paramOnFrameAvailableListener;
      this.handler = paramHandler;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(215546);
      if (this == paramObject)
      {
        AppMethodBeat.o(215546);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(215546);
        return false;
      }
      paramObject = (b)paramObject;
      boolean bool = this.cEq.equals(paramObject.cEq);
      AppMethodBeat.o(215546);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(215547);
      int i = Objects.hash(new Object[] { this.cEq });
      AppMethodBeat.o(215547);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.q
 * JD-Core Version:    0.7.0.1
 */