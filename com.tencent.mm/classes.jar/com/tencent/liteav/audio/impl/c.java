package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static final c a;
  private ConcurrentHashMap<Integer, WeakReference<e>> b;
  private PhoneStateListener c;
  private Context d;
  
  static
  {
    AppMethodBeat.i(66552);
    a = new c();
    AppMethodBeat.o(66552);
  }
  
  private c()
  {
    AppMethodBeat.i(66545);
    this.b = new ConcurrentHashMap();
    this.c = null;
    AppMethodBeat.o(66545);
  }
  
  public static c a()
  {
    return a;
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(66548);
        Iterator localIterator = this.b.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        e locale = (e)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
        if (locale != null) {
          locale.c(paramInt);
        } else {
          localObject.remove();
        }
      }
      finally {}
    }
    AppMethodBeat.o(66548);
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(66549);
    if (this.c != null)
    {
      AppMethodBeat.o(66549);
      return;
    }
    this.d = paramContext.getApplicationContext();
    new Handler(Looper.getMainLooper()).post(new c.1(this));
    AppMethodBeat.o(66549);
  }
  
  /* Error */
  public void a(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 118
    //   13: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 38	com/tencent/liteav/audio/impl/c:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 122	java/lang/Object:hashCode	()I
    //   27: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: new 71	java/lang/ref/WeakReference
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 131	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   38: invokevirtual 135	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: ldc 118
    //   44: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -31 -> 16
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	c
    //   0	55	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   11	16	50	finally
    //   19	47	50	finally
  }
  
  /* Error */
  public void b(e parame)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 136
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 136
    //   13: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 38	com/tencent/liteav/audio/impl/c:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 122	java/lang/Object:hashCode	()I
    //   27: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 140	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq +18 -> 51
    //   36: aload_0
    //   37: getfield 38	com/tencent/liteav/audio/impl/c:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   40: aload_1
    //   41: invokevirtual 122	java/lang/Object:hashCode	()I
    //   44: invokestatic 128	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: invokevirtual 143	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: pop
    //   51: ldc 136
    //   53: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: goto -40 -> 16
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	c
    //   0	64	1	parame	e
    // Exception table:
    //   from	to	target	type
    //   2	7	59	finally
    //   11	16	59	finally
    //   19	51	59	finally
    //   51	56	59	finally
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(66550);
    super.finalize();
    if ((this.c != null) && (this.d != null)) {
      new Handler(Looper.getMainLooper()).post(new c.2(this));
    }
    AppMethodBeat.o(66550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.c
 * JD-Core Version:    0.7.0.1
 */