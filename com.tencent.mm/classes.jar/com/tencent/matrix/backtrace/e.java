package com.tencent.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import com.tencent.matrix.e.c;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
  implements Handler.Callback
{
  private a eMN;
  private b eMO;
  g.f eMP;
  long eMQ = 0L;
  Context mContext;
  Handler mHandler;
  
  e(b paramb, Context paramContext, g.f paramf, long paramLong)
  {
    this.eMO = paramb;
    if (this.mHandler == null) {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
    }
    this.mContext = paramContext;
    this.eMP = paramf;
    this.eMQ = Math.max(paramLong, 3000L);
  }
  
  private void b(Context paramContext, b paramb)
  {
    try
    {
      if ((this.eMN != null) && (this.eMN.d(paramb) == 0))
      {
        c.i("Matrix.WarmUpScheduler", "Unregister idle receiver.", new Object[0]);
        paramContext.unregisterReceiver(this.eMN);
        this.eMN = null;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  final void a(Context paramContext, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   6: ifnonnull +99 -> 105
    //   9: aload_0
    //   10: new 12	com/tencent/matrix/backtrace/e$a
    //   13: dup
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 39	com/tencent/matrix/backtrace/e:mHandler	Landroid/os/Handler;
    //   19: aload_0
    //   20: getfield 54	com/tencent/matrix/backtrace/e:eMP	Lcom/tencent/matrix/backtrace/g$f;
    //   23: aload_0
    //   24: getfield 35	com/tencent/matrix/backtrace/e:eMQ	J
    //   27: invokespecial 89	com/tencent/matrix/backtrace/e$a:<init>	(Landroid/content/Context;Landroid/os/Handler;Lcom/tencent/matrix/backtrace/g$f;J)V
    //   30: putfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   33: aload_0
    //   34: getfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   37: aload_2
    //   38: invokevirtual 93	com/tencent/matrix/backtrace/e$a:c	(Lcom/tencent/matrix/backtrace/e$b;)V
    //   41: ldc 72
    //   43: ldc 95
    //   45: iconst_0
    //   46: anewarray 4	java/lang/Object
    //   49: invokestatic 80	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: new 97	android/content/IntentFilter
    //   55: dup
    //   56: invokespecial 98	android/content/IntentFilter:<init>	()V
    //   59: astore_2
    //   60: aload_2
    //   61: ldc 100
    //   63: invokevirtual 104	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc 106
    //   69: invokevirtual 104	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: ldc 108
    //   75: invokevirtual 104	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   78: aload_2
    //   79: ldc 110
    //   81: invokevirtual 104	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   89: aload_2
    //   90: invokevirtual 114	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   93: pop
    //   94: aload_0
    //   95: getfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   98: aload_1
    //   99: invokevirtual 118	com/tencent/matrix/backtrace/e$a:bF	(Landroid/content/Context;)V
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: aload_0
    //   106: getfield 66	com/tencent/matrix/backtrace/e:eMN	Lcom/tencent/matrix/backtrace/e$a;
    //   109: aload_2
    //   110: invokevirtual 93	com/tencent/matrix/backtrace/e$a:c	(Lcom/tencent/matrix/backtrace/e$b;)V
    //   113: goto -11 -> 102
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	e
    //   0	121	1	paramContext	Context
    //   0	121	2	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	102	116	finally
    //   105	113	116	finally
  }
  
  final void a(final b paramb)
  {
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        e locale = e.this;
        e.b localb = paramb;
        switch (e.2.eMT[locale.eMP.ordinal()])
        {
        default: 
          return;
        case 1: 
          switch (e.2.eMU[localb.ordinal()])
          {
          default: 
            return;
          case 1: 
            c.i("Matrix.WarmUpScheduler", "Schedule warm-up in %ss", new Object[] { Long.valueOf(locale.eMQ / 1000L) });
            locale.mHandler.sendMessageDelayed(Message.obtain(locale.mHandler, 1, new CancellationSignal()), locale.eMQ);
            return;
          case 2: 
            c.i("Matrix.WarmUpScheduler", "Schedule clean-up in %ss", new Object[] { Long.valueOf(locale.eMQ / 1000L) });
            locale.mHandler.sendMessageDelayed(Message.obtain(locale.mHandler, 3, new CancellationSignal()), locale.eMQ);
            return;
          }
          c.i("Matrix.WarmUpScheduler", "Schedule request consuming in %ss", new Object[] { Long.valueOf(locale.eMQ / 1000L) });
          locale.mHandler.sendMessageDelayed(Message.obtain(locale.mHandler, 2, new CancellationSignal()), locale.eMQ);
          return;
        }
        locale.a(locale.mContext, localb);
      }
    });
  }
  
  final void b(b paramb)
  {
    switch (2.eMT[this.eMP.ordinal()])
    {
    default: 
      return;
    }
    b(this.mContext, paramb);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (CancellationSignal)paramMessage.obj;
      b localb = this.eMO;
      localb.eMk.a(new b.1(localb, paramMessage), "warm-up");
      continue;
      paramMessage = (CancellationSignal)paramMessage.obj;
      localb = this.eMO;
      localb.eMk.a(new b.3(localb, paramMessage), "consuming-up");
      continue;
      paramMessage = (CancellationSignal)paramMessage.obj;
      localb = this.eMO;
      localb.eMk.a(new b.2(localb, paramMessage), "clean-up");
      continue;
      paramMessage = (CancellationSignal)paramMessage.obj;
      localb = this.eMO;
      localb.eMk.a(new b.4(localb, paramMessage), "compute-disk-usage");
    }
  }
  
  static final class a
    extends BroadcastReceiver
  {
    private final g.f eMP;
    private final long eMQ;
    private CancellationSignal eMV;
    Handler eMW;
    private final Set<e.b> eMX = new HashSet();
    Context mContext;
    
    a(Context paramContext, Handler paramHandler, g.f paramf, long paramLong)
    {
      this.mContext = paramContext;
      this.eMW = paramHandler;
      this.eMP = paramf;
      this.eMQ = paramLong;
    }
    
    private void p(boolean paramBoolean1, boolean paramBoolean2)
    {
      int j = 1;
      for (;;)
      {
        int i;
        try
        {
          c.i("Matrix.WarmUpScheduler", "Idle status changed: interactive = %s, charging = %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
          e.b localb;
          if (!paramBoolean1)
          {
            i = j;
            if (this.eMP != g.f.eNP)
            {
              if (!paramBoolean2) {
                i = j;
              }
            }
            else
            {
              if ((i == 0) || (this.eMV != null)) {
                break label419;
              }
              this.eMV = new CancellationSignal();
              Iterator localIterator = this.eMX.iterator();
              if (!localIterator.hasNext()) {
                break label485;
              }
              localb = (e.b)localIterator.next();
            }
          }
          switch (e.2.eMU[localb.ordinal()])
          {
          case 1: 
            if (f.bI(this.mContext).exists()) {
              break label225;
            }
            this.eMW.sendMessageDelayed(Message.obtain(this.eMW, 1, this.eMV), this.eMQ);
            c.i("Matrix.WarmUpScheduler", "System idle, trigger warm up in %s seconds.", new Object[] { Long.valueOf(this.eMQ / 1000L) });
            continue;
            i = 0;
          }
        }
        finally {}
        continue;
        label225:
        localObject.remove();
        continue;
        this.eMW.sendMessageDelayed(Message.obtain(this.eMW, 2, this.eMV), this.eMQ);
        c.i("Matrix.WarmUpScheduler", "System idle, trigger consume requested qut in %s seconds.", new Object[] { Long.valueOf(this.eMQ / 1000L) });
        continue;
        if (f.bM(this.mContext)) {
          this.eMW.sendMessageDelayed(Message.obtain(this.eMW, 3, this.eMV), 3000L);
        }
        for (;;)
        {
          c.i("Matrix.WarmUpScheduler", "System idle, trigger clean up in %s seconds.", new Object[] { Long.valueOf(3L) });
          break;
          localObject.remove();
        }
        if (f.bN(this.mContext)) {
          this.eMW.sendMessageDelayed(Message.obtain(this.eMW, 4, this.eMV), 3000L);
        }
        for (;;)
        {
          c.i("Matrix.WarmUpScheduler", "System idle, trigger disk usage in %s seconds.", new Object[] { Long.valueOf(3L) });
          break;
          localObject.remove();
        }
        label419:
        if ((i == 0) && (this.eMV != null))
        {
          this.eMW.removeMessages(1);
          this.eMW.removeMessages(2);
          this.eMW.removeMessages(3);
          this.eMW.removeMessages(4);
          this.eMV.cancel();
          this.eMV = null;
          c.i("Matrix.WarmUpScheduler", "Exit idle state, task cancelled.", new Object[0]);
        }
        label485:
        return;
      }
    }
    
    final void bF(Context paramContext)
    {
      for (;;)
      {
        try
        {
          boolean bool2 = ((PowerManager)paramContext.getSystemService("power")).isInteractive();
          paramContext = paramContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
          if (paramContext != null)
          {
            int i = paramContext.getIntExtra("status", -1);
            if (i == 2) {
              break label81;
            }
            if (i == 5)
            {
              break label81;
              p(bool2, bool1);
              return;
            }
            bool1 = false;
            continue;
          }
          bool1 = false;
        }
        finally {}
        continue;
        label81:
        boolean bool1 = true;
      }
    }
    
    /* Error */
    final void c(e.b paramb)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 30	com/tencent/matrix/backtrace/e$a:eMX	Ljava/util/Set;
      //   6: aload_1
      //   7: invokeinterface 200 2 0
      //   12: istore_2
      //   13: iload_2
      //   14: ifeq +6 -> 20
      //   17: aload_0
      //   18: monitorexit
      //   19: return
      //   20: aload_0
      //   21: getfield 30	com/tencent/matrix/backtrace/e$a:eMX	Ljava/util/Set;
      //   24: aload_1
      //   25: invokeinterface 203 2 0
      //   30: pop
      //   31: goto -14 -> 17
      //   34: astore_1
      //   35: aload_0
      //   36: monitorexit
      //   37: aload_1
      //   38: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	39	0	this	a
      //   0	39	1	paramb	e.b
      //   12	2	2	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	13	34	finally
      //   20	31	34	finally
    }
    
    final int d(e.b paramb)
    {
      try
      {
        this.eMX.remove(paramb);
        int i = this.eMX.size();
        return i;
      }
      finally
      {
        paramb = finally;
        throw paramb;
      }
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if (paramContext == null) {
        return;
      }
      int i = -1;
      for (;;)
      {
        try
        {
          switch (paramContext.hashCode())
          {
          case -1454123155: 
            p(bool2, bool1);
            return;
          }
        }
        finally {}
        if (paramContext.equals("android.intent.action.SCREEN_ON"))
        {
          i = 0;
          break label172;
          if (paramContext.equals("android.intent.action.SCREEN_OFF"))
          {
            i = 1;
            break label172;
            if (paramContext.equals("android.intent.action.ACTION_POWER_CONNECTED"))
            {
              i = 2;
              break label172;
              bool1 = paramContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED");
              if (bool1)
              {
                i = 3;
                break label172;
                bool1 = false;
                bool2 = true;
                continue;
                bool1 = false;
                bool2 = false;
                continue;
                bool1 = true;
                bool2 = false;
                continue;
                bool1 = false;
                bool2 = false;
                continue;
              }
            }
          }
        }
        label172:
        switch (i)
        {
        }
        boolean bool1 = false;
        boolean bool2 = false;
      }
    }
  }
  
  static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.backtrace.e
 * JD-Core Version:    0.7.0.1
 */