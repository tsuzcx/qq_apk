package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
{
  private static final b a;
  private ConcurrentHashMap<Integer, WeakReference<c>> b;
  private PhoneStateListener c;
  private Context d;
  
  static
  {
    AppMethodBeat.i(16452);
    a = new b();
    AppMethodBeat.o(16452);
  }
  
  private b()
  {
    AppMethodBeat.i(16445);
    this.b = new ConcurrentHashMap();
    this.c = null;
    AppMethodBeat.o(16445);
  }
  
  public static b a()
  {
    return a;
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(16448);
        Iterator localIterator = this.b.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        c localc = (c)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
        if (localc != null) {
          localc.a(paramInt);
        } else {
          localObject.remove();
        }
      }
      finally {}
    }
    AppMethodBeat.o(16448);
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(16449);
    if (this.c != null)
    {
      AppMethodBeat.o(16449);
      return;
    }
    this.d = paramContext.getApplicationContext();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(16475);
        if (b.a(b.this) != null)
        {
          AppMethodBeat.o(16475);
          return;
        }
        b.a(b.this, new PhoneStateListener()
        {
          public void onCallStateChanged(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(16411);
            super.onCallStateChanged(paramAnonymous2Int, paramAnonymous2String);
            TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:".concat(String.valueOf(paramAnonymous2Int)));
            b.a(b.this, paramAnonymous2Int);
            AppMethodBeat.o(16411);
          }
        });
        ((TelephonyManager)b.b(b.this).getSystemService("phone")).listen(b.a(b.this), 32);
        AppMethodBeat.o(16475);
      }
    });
    AppMethodBeat.o(16449);
  }
  
  /* Error */
  public void a(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16446
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: sipush 16446
    //   15: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 42	com/tencent/liteav/audio/impl/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 119	java/lang/Object:hashCode	()I
    //   29: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: new 74	java/lang/ref/WeakReference
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 128	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   40: invokevirtual 132	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: sipush 16446
    //   47: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: goto -32 -> 18
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	b
    //   0	58	1	paramc	c
    // Exception table:
    //   from	to	target	type
    //   2	8	53	finally
    //   12	18	53	finally
    //   21	50	53	finally
  }
  
  /* Error */
  public void b(c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 16447
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnonnull +12 -> 21
    //   12: sipush 16447
    //   15: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 42	com/tencent/liteav/audio/impl/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 119	java/lang/Object:hashCode	()I
    //   29: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokevirtual 136	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   35: ifeq +18 -> 53
    //   38: aload_0
    //   39: getfield 42	com/tencent/liteav/audio/impl/b:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   42: aload_1
    //   43: invokevirtual 119	java/lang/Object:hashCode	()I
    //   46: invokestatic 125	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: invokevirtual 139	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: sipush 16447
    //   56: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -41 -> 18
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	b
    //   0	67	1	paramc	c
    // Exception table:
    //   from	to	target	type
    //   2	8	62	finally
    //   12	18	62	finally
    //   21	53	62	finally
    //   53	59	62	finally
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(16450);
    super.finalize();
    if ((this.c != null) && (this.d != null)) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(16412);
          if ((b.a(b.this) != null) && (b.b(b.this) != null)) {
            ((TelephonyManager)b.b(b.this).getApplicationContext().getSystemService("phone")).listen(b.a(b.this), 0);
          }
          b.a(b.this, null);
          AppMethodBeat.o(16412);
        }
      });
    }
    AppMethodBeat.o(16450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.b
 * JD-Core Version:    0.7.0.1
 */