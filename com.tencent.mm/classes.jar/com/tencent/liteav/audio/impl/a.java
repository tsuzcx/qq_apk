package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static final a a;
  private ConcurrentHashMap<Integer, WeakReference<b>> b;
  private PhoneStateListener c;
  private Context d;
  
  static
  {
    AppMethodBeat.i(246413);
    a = new a();
    AppMethodBeat.o(246413);
  }
  
  private a()
  {
    AppMethodBeat.i(16413);
    this.b = new ConcurrentHashMap();
    this.c = null;
    AppMethodBeat.o(16413);
  }
  
  public static a a()
  {
    return a;
  }
  
  private void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(16444);
        Iterator localIterator = this.b.entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        b localb = (b)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
        if (localb != null) {
          localb.onCallStateChanged(paramInt);
        } else {
          localObject.remove();
        }
      }
      finally {}
    }
    AppMethodBeat.o(16444);
  }
  
  public void a(Context paramContext)
  {
    AppMethodBeat.i(246409);
    if (this.c != null)
    {
      AppMethodBeat.o(246409);
      return;
    }
    this.d = paramContext.getApplicationContext();
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      private byte _hellAccFlag_;
      
      public void run()
      {
        AppMethodBeat.i(246693);
        if (a.a(a.this) != null)
        {
          AppMethodBeat.o(246693);
          return;
        }
        a.a(a.this, new PhoneStateListener()
        {
          public void onCallStateChanged(int paramAnonymous2Int, String paramAnonymous2String)
          {
            AppMethodBeat.i(246669);
            super.onCallStateChanged(paramAnonymous2Int, paramAnonymous2String);
            TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:".concat(String.valueOf(paramAnonymous2Int)));
            a.a(a.this, paramAnonymous2Int);
            AppMethodBeat.o(246669);
          }
        });
        try
        {
          TelephonyManager localTelephonyManager = (TelephonyManager)a.b(a.this).getSystemService("phone");
          Object localObject = a.a(a.this);
          localObject = c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/liteav/audio/impl/a$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/liteav/audio/impl/a$1", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          AppMethodBeat.o(246693);
          return;
        }
        catch (Exception localException)
        {
          TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", localException);
          AppMethodBeat.o(246693);
        }
      }
    });
    AppMethodBeat.o(246409);
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnonnull +11 -> 19
    //   11: ldc 121
    //   13: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 43	com/tencent/liteav/audio/impl/a:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   23: aload_1
    //   24: invokevirtual 125	java/lang/Object:hashCode	()I
    //   27: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: new 75	java/lang/ref/WeakReference
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 134	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   38: invokevirtual 138	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   41: pop
    //   42: ldc 121
    //   44: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -31 -> 16
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	a
    //   0	55	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   11	16	50	finally
    //   19	47	50	finally
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(246410);
    super.finalize();
    if ((this.c != null) && (this.d != null)) {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        private byte _hellAccFlag_;
        
        public void run()
        {
          AppMethodBeat.i(246536);
          if ((a.a(a.this) != null) && (a.b(a.this) != null)) {}
          try
          {
            TelephonyManager localTelephonyManager = (TelephonyManager)a.b(a.this).getApplicationContext().getSystemService("phone");
            Object localObject = a.a(a.this);
            localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/liteav/audio/impl/a$2", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/liteav/audio/impl/a$2", "run", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            a.a(a.this, null);
            AppMethodBeat.o(246536);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", localException);
            }
          }
        }
      });
    }
    AppMethodBeat.o(246410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a
 * JD-Core Version:    0.7.0.1
 */