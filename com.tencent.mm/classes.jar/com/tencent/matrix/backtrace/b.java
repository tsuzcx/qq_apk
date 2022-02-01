package com.tencent.matrix.backtrace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import android.util.Pair;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

final class b
{
  static volatile d eMo;
  boolean eMh = false;
  String eMi;
  private d eMj;
  c eMk;
  e eMl;
  g.a eMm;
  final boolean[] eMn = { false };
  
  static void a(g.d paramd)
  {
    if ((paramd == g.d.eNL) || (paramd == g.d.eNM)) {
      WeChatBacktraceNative.setBacktraceMode(g.d.eNJ.value);
    }
  }
  
  /* Error */
  final void a(g.a parama, g.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 111	com/tencent/matrix/backtrace/g$a:mContext	Landroid/content/Context;
    //   6: invokestatic 179	com/tencent/matrix/backtrace/f:bI	(Landroid/content/Context;)Ljava/io/File;
    //   9: invokevirtual 185	java/io/File:exists	()Z
    //   12: istore_3
    //   13: iload_3
    //   14: ifeq +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 187	com/tencent/matrix/backtrace/b:eMj	Lcom/tencent/matrix/backtrace/b$d;
    //   24: ifnonnull -7 -> 17
    //   27: aload_0
    //   28: new 29	com/tencent/matrix/backtrace/b$d
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 189	com/tencent/matrix/backtrace/b$d:<init>	(Lcom/tencent/matrix/backtrace/g$d;)V
    //   36: putfield 187	com/tencent/matrix/backtrace/b:eMj	Lcom/tencent/matrix/backtrace/b$d;
    //   39: ldc 166
    //   41: ldc 191
    //   43: iconst_0
    //   44: anewarray 4	java/lang/Object
    //   47: invokestatic 194	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 196	android/content/IntentFilter
    //   53: dup
    //   54: invokespecial 197	android/content/IntentFilter:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc 199
    //   61: invokevirtual 202	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: getfield 111	com/tencent/matrix/backtrace/g$a:mContext	Landroid/content/Context;
    //   68: aload_0
    //   69: getfield 187	com/tencent/matrix/backtrace/b:eMj	Lcom/tencent/matrix/backtrace/b$d;
    //   72: aload_2
    //   73: new 204	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: getfield 111	com/tencent/matrix/backtrace/g$a:mContext	Landroid/content/Context;
    //   84: invokevirtual 211	android/content/Context:getPackageName	()Ljava/lang/String;
    //   87: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 217
    //   92: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aconst_null
    //   99: invokevirtual 224	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   102: pop
    //   103: goto -86 -> 17
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	b
    //   0	111	1	parama	g.a
    //   0	111	2	paramd	g.d
    //   12	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	106	finally
    //   20	103	106	finally
  }
  
  final void setSavingPath(String paramString)
  {
    this.eMi = paramString;
    WeChatBacktraceNative.setSavingPath(paramString);
  }
  
  static final class a
    implements c
  {
    public final boolean N(String paramString, int paramInt)
    {
      return WeChatBacktraceNative.warmUp(paramString, paramInt, false);
    }
  }
  
  static final class b
    implements c
  {
    private Bundle bIB;
    private final String eMi;
    WarmUpService.b eMx = new WarmUpService.b();
    private Context mContext;
    
    b(String paramString)
    {
      this.eMi = paramString;
    }
    
    public final boolean N(String paramString, int paramInt)
    {
      if ((this.eMx.eNp[0] == 0) && (!d(this.mContext, this.bIB))) {
        return false;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("saving-path", this.eMi);
      localBundle.putString("path-of-elf", paramString);
      localBundle.putInt("elf-start-offset", paramInt);
      localBundle = this.eMx.G(localBundle);
      int i;
      if (localBundle != null)
      {
        i = localBundle.getInt("warm-up-result");
        if (i != 0) {
          break label144;
        }
      }
      label144:
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          WeChatBacktraceNative.notifyWarmedUp(paramString, paramInt);
        }
        com.tencent.matrix.e.c.i("Matrix.WarmUpDelegate", "Warm-up %s:%s - retCode %s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i) });
        return bool;
        i = -100;
        break;
      }
    }
    
    public final boolean d(Context paramContext, Bundle paramBundle)
    {
      this.mContext = paramContext;
      this.bIB = paramBundle;
      return this.eMx.d(paramContext, paramBundle);
    }
  }
  
  static final class c
    implements Handler.Callback, Runnable
  {
    private Queue<String> eMA = new LinkedList();
    private Handler eMB = new Handler(Looper.getMainLooper(), this);
    private boolean eMC = false;
    long[] eMD = { 0L };
    private Thread eMy;
    private HashMap<String, Runnable> eMz = new HashMap();
    private String mThreadName;
    
    c(String paramString)
    {
      this.mThreadName = paramString;
    }
    
    final void a(Runnable paramRunnable, String paramString)
    {
      synchronized (this.eMA)
      {
        if (this.eMA.contains(paramString)) {
          return;
        }
        this.eMA.add(paramString);
        this.eMz.put(paramString, paramRunnable);
        try
        {
          if ((this.eMy == null) || (!this.eMy.isAlive()))
          {
            this.eMy = new Thread(this, this.mThreadName);
            this.eMy.start();
            this.eMB.removeMessages(1);
            this.eMB.sendEmptyMessageDelayed(1, 300000L);
          }
          return;
        }
        finally {}
      }
    }
    
    public final boolean handleMessage(Message arg1)
    {
      if (???.what == 1) {}
      synchronized (this.eMD)
      {
        if (this.eMD[0] == 0L) {}
        do
        {
          return false;
          this.eMC = true;
          ??? = b.eMo;
        } while (??? == null);
        ???.a(d.a.eMH, new Object[0]);
        return false;
      }
    }
    
    public final void run()
    {
      this.eMC = false;
      for (;;)
      {
        d locald;
        synchronized (this.eMD)
        {
          this.eMD[0] = System.currentTimeMillis();
          ??? = null;
          locald = null;
          if (locald == null) {}
        }
        try
        {
          long l = System.currentTimeMillis();
          com.tencent.matrix.e.c.i("Matrix.WarmUpDelegate", "Before '%s' task execution..", new Object[] { ??? });
          locald.run();
          com.tencent.matrix.e.c.i("Matrix.WarmUpDelegate", "After '%s' task execution..", new Object[] { ??? });
          l = System.currentTimeMillis() - l;
          locald = b.eMo;
          if (locald != null)
          {
            if (!"warm-up".equalsIgnoreCase((String)???)) {
              break label181;
            }
            locald.a(d.a.eMJ, new Object[] { Long.valueOf(l) });
          }
          label181:
          Runnable localRunnable;
        }
        finally
        {
          synchronized (this.eMA)
          {
            for (;;)
            {
              ??? = (String)this.eMA.poll();
              if (??? == null) {
                synchronized (this.eMD)
                {
                  this.eMD[0] = 0L;
                  this.eMB.removeMessages(1);
                  return;
                  localObject3 = finally;
                  throw localObject3;
                  if ("consuming-up".equalsIgnoreCase((String)???))
                  {
                    localObject3.a(d.a.eMK, new Object[] { Long.valueOf(l) });
                    continue;
                    localObject4 = finally;
                  }
                }
              }
            }
          }
          synchronized (this.eMD)
          {
            this.eMD[0] = 0L;
            this.eMB.removeMessages(1);
            throw localObject4;
            localObject5 = finally;
            throw localObject5;
            localRunnable = (Runnable)this.eMz.remove(???);
            if (localRunnable == null) {
              synchronized (this.eMD)
              {
                this.eMD[0] = 0L;
                this.eMB.removeMessages(1);
                return;
                localObject2 = finally;
                throw localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  static final class d
    extends BroadcastReceiver
  {
    private g.d eME;
    
    d(g.d paramd)
    {
      this.eME = paramd;
    }
    
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      com.tencent.matrix.e.c.i("Matrix.WarmUpDelegate", "Warm-up received.", new Object[0]);
      paramIntent = paramIntent.getAction();
      if (paramIntent == null) {
        return;
      }
      int i = -1;
      switch (paramIntent.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
        }
        WeChatBacktraceNative.setWarmedUp(true);
        b.a(this.eME);
        try
        {
          paramContext.unregisterReceiver(this);
          return;
        }
        finally
        {
          com.tencent.matrix.e.c.printErrStackTrace("Matrix.WarmUpDelegate", paramContext, "Unregister receiver twice.", new Object[0]);
          return;
        }
        if (paramIntent.equals("action.backtrace.warmed-up")) {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.backtrace.b
 * JD-Core Version:    0.7.0.1
 */