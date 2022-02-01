package com.tencent.matrix.backtrace;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.e.c;
import java.util.concurrent.atomic.AtomicInteger;

public class WarmUpService
  extends Service
{
  private static volatile boolean eNd = false;
  private static volatile boolean eNe = false;
  private static HandlerThread eNf;
  private static Handler eNg;
  private static final AtomicInteger eNh = new AtomicInteger(0);
  private static final byte[] eNi = new byte[0];
  private final Messenger cP = new Messenger(new Handler(com.tencent.matrix.e.b.aAo().getLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      Object localObject;
      Bundle localBundle;
      if ((paramAnonymousMessage.obj instanceof Bundle))
      {
        localObject = (Bundle)paramAnonymousMessage.obj;
        localBundle = ((Bundle)localObject).getBundle("invoke-args");
        localObject = ((Bundle)localObject).getBinder("invoke-resp");
        localBundle = WarmUpService.a(WarmUpService.this, paramAnonymousMessage.what, localBundle);
        localObject = new Messenger((IBinder)localObject);
      }
      try
      {
        ((Messenger)localObject).send(Message.obtain(null, paramAnonymousMessage.what, localBundle));
        return;
      }
      catch (RemoteException paramAnonymousMessage)
      {
        c.printErrStackTrace("Matrix.WarmUpService", paramAnonymousMessage, "", new Object[0]);
      }
    }
  });
  private final b eNj = new b();
  
  private static void dv(boolean paramBoolean)
  {
    c.i("Matrix.WarmUpService", "Schedule suicide", new Object[0]);
    arrayOfByte = eNi;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        eNg.sendEmptyMessageDelayed(1, 60000L);
        return;
      }
      finally {}
      if (eNh.decrementAndGet() == 0) {
        eNg.sendEmptyMessageDelayed(1, 60000L);
      }
    }
  }
  
  /* Error */
  private Bundle h(int paramInt, Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: ldc 86
    //   9: ldc 112
    //   11: iconst_0
    //   12: anewarray 90	java/lang/Object
    //   15: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: getstatic 46	com/tencent/matrix/backtrace/WarmUpService:eNi	[B
    //   21: astore 7
    //   23: aload 7
    //   25: monitorenter
    //   26: getstatic 98	com/tencent/matrix/backtrace/WarmUpService:eNg	Landroid/os/Handler;
    //   29: iconst_1
    //   30: invokevirtual 115	android/os/Handler:removeMessages	(I)V
    //   33: getstatic 44	com/tencent/matrix/backtrace/WarmUpService:eNh	Ljava/util/concurrent/atomic/AtomicInteger;
    //   36: invokevirtual 118	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   39: pop
    //   40: aload 7
    //   42: monitorexit
    //   43: new 120	android/os/Bundle
    //   46: dup
    //   47: invokespecial 121	android/os/Bundle:<init>	()V
    //   50: astore 7
    //   52: aload 7
    //   54: ldc 123
    //   56: iconst_m1
    //   57: invokevirtual 127	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   60: aload_2
    //   61: ifnonnull +34 -> 95
    //   64: ldc 86
    //   66: ldc 129
    //   68: iconst_0
    //   69: anewarray 90	java/lang/Object
    //   72: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: iconst_0
    //   76: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   79: aload_0
    //   80: monitorexit
    //   81: aload 7
    //   83: areturn
    //   84: astore_2
    //   85: aload 7
    //   87: monitorexit
    //   88: aload_2
    //   89: athrow
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    //   95: aload_2
    //   96: ldc 133
    //   98: aconst_null
    //   99: invokevirtual 137	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 8
    //   104: ldc 86
    //   106: ldc 139
    //   108: iconst_1
    //   109: anewarray 90	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload 8
    //   116: aastore
    //   117: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload 8
    //   122: invokestatic 143	com/tencent/matrix/backtrace/WarmUpService:isNullOrNil	(Ljava/lang/String;)Z
    //   125: ifeq +21 -> 146
    //   128: ldc 86
    //   130: ldc 145
    //   132: iconst_0
    //   133: anewarray 90	java/lang/Object
    //   136: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: iconst_0
    //   140: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   143: goto -64 -> 79
    //   146: aload_0
    //   147: getfield 76	com/tencent/matrix/backtrace/WarmUpService:eNj	Lcom/tencent/matrix/backtrace/b;
    //   150: aload 8
    //   152: invokevirtual 149	com/tencent/matrix/backtrace/b:setSavingPath	(Ljava/lang/String;)V
    //   155: iload_1
    //   156: bipush 100
    //   158: if_icmpne +261 -> 419
    //   161: aload_2
    //   162: ldc 151
    //   164: aconst_null
    //   165: invokevirtual 137	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 8
    //   170: aload 8
    //   172: invokestatic 143	com/tencent/matrix/backtrace/WarmUpService:isNullOrNil	(Ljava/lang/String;)Z
    //   175: ifeq +21 -> 196
    //   178: ldc 86
    //   180: ldc 153
    //   182: iconst_0
    //   183: anewarray 90	java/lang/Object
    //   186: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: iconst_0
    //   190: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   193: goto -114 -> 79
    //   196: aload_2
    //   197: ldc 155
    //   199: iconst_0
    //   200: invokevirtual 159	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   203: istore 5
    //   205: ldc 86
    //   207: ldc 161
    //   209: iconst_2
    //   210: anewarray 90	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload 8
    //   217: aastore
    //   218: dup
    //   219: iconst_1
    //   220: iload 5
    //   222: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload 8
    //   231: iload 5
    //   233: invokestatic 173	com/tencent/matrix/backtrace/f:O	(Ljava/lang/String;I)Ljava/lang/String;
    //   236: astore_2
    //   237: aload_0
    //   238: aload_2
    //   239: invokestatic 179	com/tencent/matrix/backtrace/f$a:t	(Landroid/content/Context;Ljava/lang/String;)I
    //   242: istore_1
    //   243: iload_1
    //   244: iconst_3
    //   245: if_icmplt +23 -> 268
    //   248: iconst_0
    //   249: istore_1
    //   250: goto +190 -> 440
    //   253: aload 7
    //   255: ldc 123
    //   257: iload_1
    //   258: invokevirtual 127	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   261: iconst_0
    //   262: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   265: goto -186 -> 79
    //   268: getstatic 183	com/tencent/matrix/backtrace/f$a:eNr	Ljava/util/Map;
    //   271: aload_2
    //   272: iload_1
    //   273: iconst_1
    //   274: iadd
    //   275: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: invokeinterface 189 3 0
    //   283: pop
    //   284: aload_0
    //   285: getstatic 183	com/tencent/matrix/backtrace/f$a:eNr	Ljava/util/Map;
    //   288: invokestatic 192	com/tencent/matrix/backtrace/f:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   291: iload 4
    //   293: istore_1
    //   294: goto +146 -> 440
    //   297: astore_2
    //   298: iconst_0
    //   299: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   302: aload_2
    //   303: athrow
    //   304: aload 8
    //   306: iload 5
    //   308: iconst_1
    //   309: invokestatic 198	com/tencent/matrix/backtrace/WeChatBacktraceNative:warmUp	(Ljava/lang/String;IZ)Z
    //   312: istore 6
    //   314: aload 8
    //   316: iload 5
    //   318: invokestatic 202	com/tencent/matrix/backtrace/WeChatBacktraceNative:testLoadQut	(Ljava/lang/String;I)Z
    //   321: ifne +30 -> 351
    //   324: ldc 86
    //   326: ldc 204
    //   328: iconst_2
    //   329: anewarray 90	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: aload 8
    //   336: aastore
    //   337: dup
    //   338: iconst_1
    //   339: iload 5
    //   341: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: invokestatic 207	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: iconst_0
    //   349: istore 6
    //   351: aload 8
    //   353: iload 5
    //   355: invokestatic 173	com/tencent/matrix/backtrace/f:O	(Ljava/lang/String;I)Ljava/lang/String;
    //   358: astore_2
    //   359: aload_0
    //   360: aload_2
    //   361: invokestatic 179	com/tencent/matrix/backtrace/f$a:t	(Landroid/content/Context;Ljava/lang/String;)I
    //   364: istore_1
    //   365: iload 6
    //   367: ifeq +33 -> 400
    //   370: getstatic 183	com/tencent/matrix/backtrace/f$a:eNr	Ljava/util/Map;
    //   373: aload_2
    //   374: invokeinterface 211 2 0
    //   379: pop
    //   380: aload_0
    //   381: getstatic 183	com/tencent/matrix/backtrace/f$a:eNr	Ljava/util/Map;
    //   384: invokestatic 192	com/tencent/matrix/backtrace/f:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   387: iload_3
    //   388: istore_1
    //   389: iload 6
    //   391: ifne -138 -> 253
    //   394: bipush 254
    //   396: istore_1
    //   397: goto -144 -> 253
    //   400: getstatic 183	com/tencent/matrix/backtrace/f$a:eNr	Ljava/util/Map;
    //   403: aload_2
    //   404: iload_1
    //   405: iconst_1
    //   406: iadd
    //   407: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: invokeinterface 189 3 0
    //   415: pop
    //   416: goto -36 -> 380
    //   419: ldc 86
    //   421: ldc 213
    //   423: iconst_1
    //   424: anewarray 90	java/lang/Object
    //   427: dup
    //   428: iconst_0
    //   429: iload_1
    //   430: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   433: aastore
    //   434: invokestatic 207	com/tencent/matrix/e/c:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -176 -> 261
    //   440: iload_1
    //   441: ifne -137 -> 304
    //   444: bipush 253
    //   446: istore_1
    //   447: goto -194 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	WarmUpService
    //   0	450	1	paramInt	int
    //   0	450	2	paramBundle	Bundle
    //   4	384	3	i	int
    //   1	291	4	j	int
    //   203	151	5	k	int
    //   312	78	6	bool	boolean
    //   102	250	8	str	String
    // Exception table:
    //   from	to	target	type
    //   26	43	84	finally
    //   7	26	90	finally
    //   75	79	90	finally
    //   85	90	90	finally
    //   139	143	90	finally
    //   189	193	90	finally
    //   261	265	90	finally
    //   298	304	90	finally
    //   43	60	297	finally
    //   64	75	297	finally
    //   95	139	297	finally
    //   146	155	297	finally
    //   161	189	297	finally
    //   196	243	297	finally
    //   253	261	297	finally
    //   268	291	297	finally
    //   304	314	297	finally
    //   314	348	297	finally
    //   351	365	297	finally
    //   370	380	297	finally
    //   380	387	297	finally
    //   400	416	297	finally
    //   419	437	297	finally
  }
  
  /* Error */
  private static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	com/tencent/matrix/backtrace/WarmUpService:eNd	Z
    //   6: istore_0
    //   7: iload_0
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 46	com/tencent/matrix/backtrace/WarmUpService:eNi	[B
    //   18: astore_1
    //   19: aload_1
    //   20: monitorenter
    //   21: getstatic 216	com/tencent/matrix/backtrace/WarmUpService:eNf	Landroid/os/HandlerThread;
    //   24: ifnonnull +45 -> 69
    //   27: new 59	android/os/HandlerThread
    //   30: dup
    //   31: ldc 218
    //   33: invokespecial 220	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   36: astore_2
    //   37: aload_2
    //   38: putstatic 216	com/tencent/matrix/backtrace/WarmUpService:eNf	Landroid/os/HandlerThread;
    //   41: aload_2
    //   42: invokevirtual 223	android/os/HandlerThread:start	()V
    //   45: new 102	android/os/Handler
    //   48: dup
    //   49: getstatic 216	com/tencent/matrix/backtrace/WarmUpService:eNf	Landroid/os/HandlerThread;
    //   52: invokevirtual 63	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   55: new 8	com/tencent/matrix/backtrace/WarmUpService$a
    //   58: dup
    //   59: iconst_0
    //   60: invokespecial 226	com/tencent/matrix/backtrace/WarmUpService$a:<init>	(B)V
    //   63: invokespecial 229	android/os/Handler:<init>	(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
    //   66: putstatic 98	com/tencent/matrix/backtrace/WarmUpService:eNg	Landroid/os/Handler;
    //   69: aload_1
    //   70: monitorexit
    //   71: iconst_1
    //   72: invokestatic 131	com/tencent/matrix/backtrace/WarmUpService:dv	(Z)V
    //   75: iconst_1
    //   76: putstatic 34	com/tencent/matrix/backtrace/WarmUpService:eNd	Z
    //   79: goto -68 -> 11
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_2
    //   89: aload_1
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	2	0	bool	boolean
    //   82	8	1	localObject1	Object
    //   36	6	2	localHandlerThread	HandlerThread
    //   88	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	82	finally
    //   15	21	82	finally
    //   71	79	82	finally
    //   89	93	82	finally
    //   21	69	88	finally
    //   69	71	88	finally
  }
  
  private static boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }
  
  /* Error */
  private static void m(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/tencent/matrix/backtrace/WarmUpService:eNe	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: ldc 86
    //   17: ldc 239
    //   19: iconst_0
    //   20: anewarray 90	java/lang/Object
    //   23: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: invokestatic 244	com/tencent/matrix/backtrace/g:loadLibrary	()V
    //   29: aload_0
    //   30: ldc 246
    //   32: iconst_0
    //   33: invokevirtual 252	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   36: istore_1
    //   37: aload_0
    //   38: ldc 254
    //   40: invokevirtual 258	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore_0
    //   44: ldc 86
    //   46: ldc_w 260
    //   49: iconst_1
    //   50: anewarray 90	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: iload_1
    //   56: invokestatic 265	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   59: aastore
    //   60: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: ldc 86
    //   65: ldc_w 267
    //   68: iconst_1
    //   69: anewarray 90	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: aastore
    //   76: invokestatic 96	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_0
    //   80: invokestatic 272	com/tencent/matrix/xlog/XLogNative:hs	(Ljava/lang/String;)V
    //   83: iload_1
    //   84: invokestatic 275	com/tencent/matrix/backtrace/g:enableLogger	(Z)V
    //   87: iconst_1
    //   88: putstatic 36	com/tencent/matrix/backtrace/WarmUpService:eNe	Z
    //   91: goto -80 -> 11
    //   94: astore_0
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_0
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramIntent	Intent
    //   6	78	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	94	finally
    //   15	91	94	finally
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (!eNe) {
      m(paramIntent);
    }
    return this.cP.getBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (!eNd) {
      init();
    }
  }
  
  static final class b
  {
    volatile Messenger eNl;
    volatile Messenger eNm;
    final Bundle[] eNn = { null };
    final HandlerThread[] eNo = { null };
    final boolean[] eNp = { false };
    ServiceConnection mConnection = new ServiceConnection()
    {
      public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
      {
        WarmUpService.b.this.eNm = new Messenger(paramAnonymousIBinder);
        synchronized (WarmUpService.b.this.eNp)
        {
          WarmUpService.b.this.eNp[0] = true;
          WarmUpService.b.this.eNp.notifyAll();
          c.i("Matrix.WarmUpInvoker", "This remote invoker(%s) connected.", new Object[] { this });
          return;
        }
      }
      
      public final void onServiceDisconnected(ComponentName arg1)
      {
        WarmUpService.b.this.eNm = null;
        synchronized (WarmUpService.b.this.eNp)
        {
          WarmUpService.b.this.eNp[0] = false;
          WarmUpService.b.this.eNp.notifyAll();
          c.i("Matrix.WarmUpInvoker", "This remote invoker(%s) disconnected.", new Object[] { this });
        }
        synchronized (WarmUpService.b.this.eNn)
        {
          WarmUpService.b.this.eNn[0] = null;
          WarmUpService.b.this.eNn.notifyAll();
          return;
          localObject1 = finally;
          throw localObject1;
        }
      }
    };
    
    /* Error */
    public final Bundle G(Bundle arg1)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 50	com/tencent/matrix/backtrace/WarmUpService$b:eNm	Landroid/os/Messenger;
      //   4: astore_2
      //   5: aload_2
      //   6: ifnull +95 -> 101
      //   9: new 28	android/os/Bundle
      //   12: dup
      //   13: invokespecial 51	android/os/Bundle:<init>	()V
      //   16: astore_3
      //   17: aload_3
      //   18: ldc 53
      //   20: aload_1
      //   21: invokevirtual 57	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
      //   24: aload_3
      //   25: ldc 59
      //   27: aload_0
      //   28: getfield 61	com/tencent/matrix/backtrace/WarmUpService$b:eNl	Landroid/os/Messenger;
      //   31: invokevirtual 67	android/os/Messenger:getBinder	()Landroid/os/IBinder;
      //   34: invokevirtual 71	android/os/Bundle:putBinder	(Ljava/lang/String;Landroid/os/IBinder;)V
      //   37: aload_2
      //   38: aconst_null
      //   39: bipush 100
      //   41: aload_3
      //   42: invokestatic 77	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
      //   45: invokevirtual 81	android/os/Messenger:send	(Landroid/os/Message;)V
      //   48: aload_0
      //   49: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   52: astore_1
      //   53: aload_1
      //   54: monitorenter
      //   55: aload_0
      //   56: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   59: iconst_0
      //   60: aconst_null
      //   61: aastore
      //   62: aload_0
      //   63: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   66: ldc2_w 82
      //   69: invokevirtual 87	java/lang/Object:wait	(J)V
      //   72: aload_0
      //   73: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   76: iconst_0
      //   77: aaload
      //   78: astore_2
      //   79: aload_1
      //   80: monitorexit
      //   81: aload_2
      //   82: areturn
      //   83: astore_2
      //   84: aload_1
      //   85: monitorexit
      //   86: aload_2
      //   87: athrow
      //   88: astore_1
      //   89: ldc 89
      //   91: aload_1
      //   92: ldc 91
      //   94: iconst_0
      //   95: anewarray 4	java/lang/Object
      //   98: invokestatic 97	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   101: aconst_null
      //   102: areturn
      //   103: astore_1
      //   104: goto -15 -> 89
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	107	0	this	b
      //   4	78	2	localObject1	Object
      //   83	4	2	localObject2	Object
      //   16	26	3	localBundle	Bundle
      // Exception table:
      //   from	to	target	type
      //   55	81	83	finally
      //   0	5	88	android/os/RemoteException
      //   9	55	88	android/os/RemoteException
      //   84	88	88	android/os/RemoteException
      //   0	5	103	java/lang/InterruptedException
      //   9	55	103	java/lang/InterruptedException
      //   84	88	103	java/lang/InterruptedException
    }
    
    /* Error */
    public final void bG(android.content.Context arg1)
    {
      // Byte code:
      //   0: aload_1
      //   1: aload_0
      //   2: getfield 39	com/tencent/matrix/backtrace/WarmUpService$b:mConnection	Landroid/content/ServiceConnection;
      //   5: invokevirtual 105	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
      //   8: ldc 89
      //   10: ldc 107
      //   12: iconst_1
      //   13: anewarray 4	java/lang/Object
      //   16: dup
      //   17: iconst_0
      //   18: aload_0
      //   19: invokevirtual 111	java/lang/Object:hashCode	()I
      //   22: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   25: aastore
      //   26: invokestatic 121	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   29: aload_0
      //   30: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   33: astore_1
      //   34: aload_1
      //   35: monitorenter
      //   36: aload_0
      //   37: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   40: iconst_0
      //   41: aaload
      //   42: ifnull +20 -> 62
      //   45: aload_0
      //   46: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   49: iconst_0
      //   50: aaload
      //   51: invokevirtual 125	android/os/HandlerThread:quitSafely	()Z
      //   54: pop
      //   55: aload_0
      //   56: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   59: iconst_0
      //   60: aconst_null
      //   61: aastore
      //   62: aload_1
      //   63: monitorexit
      //   64: aload_0
      //   65: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   68: astore_1
      //   69: aload_1
      //   70: monitorenter
      //   71: aload_0
      //   72: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   75: iconst_0
      //   76: aconst_null
      //   77: aastore
      //   78: aload_0
      //   79: getfield 30	com/tencent/matrix/backtrace/WarmUpService$b:eNn	[Landroid/os/Bundle;
      //   82: invokevirtual 128	java/lang/Object:notifyAll	()V
      //   85: aload_1
      //   86: monitorexit
      //   87: return
      //   88: astore_1
      //   89: ldc 89
      //   91: aload_1
      //   92: ldc 91
      //   94: iconst_0
      //   95: anewarray 4	java/lang/Object
      //   98: invokestatic 97	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   101: goto -93 -> 8
      //   104: astore_2
      //   105: aload_1
      //   106: monitorexit
      //   107: aload_2
      //   108: athrow
      //   109: astore_2
      //   110: aload_1
      //   111: monitorexit
      //   112: aload_2
      //   113: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	this	b
      //   104	4	2	localObject1	Object
      //   109	4	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   0	8	88	finally
      //   36	62	104	finally
      //   62	64	104	finally
      //   71	87	109	finally
    }
    
    /* Error */
    public final boolean d(android.content.Context paramContext, Bundle arg2)
    {
      // Byte code:
      //   0: invokestatic 136	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   3: invokestatic 139	android/os/Looper:myLooper	()Landroid/os/Looper;
      //   6: if_acmpne +13 -> 19
      //   9: new 141	java/lang/RuntimeException
      //   12: dup
      //   13: ldc 143
      //   15: invokespecial 146	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   18: athrow
      //   19: aload_0
      //   20: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   23: iconst_0
      //   24: baload
      //   25: ifeq +5 -> 30
      //   28: iconst_1
      //   29: ireturn
      //   30: ldc 89
      //   32: ldc 148
      //   34: iconst_1
      //   35: anewarray 4	java/lang/Object
      //   38: dup
      //   39: iconst_0
      //   40: aload_0
      //   41: invokevirtual 111	java/lang/Object:hashCode	()I
      //   44: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   47: aastore
      //   48: invokestatic 121	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   51: aload_0
      //   52: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   55: astore_3
      //   56: aload_3
      //   57: monitorenter
      //   58: aload_0
      //   59: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   62: iconst_0
      //   63: aaload
      //   64: ifnull +20 -> 84
      //   67: aload_0
      //   68: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   71: iconst_0
      //   72: aaload
      //   73: invokevirtual 125	android/os/HandlerThread:quitSafely	()Z
      //   76: pop
      //   77: aload_0
      //   78: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   81: iconst_0
      //   82: aconst_null
      //   83: aastore
      //   84: aload_0
      //   85: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   88: iconst_0
      //   89: new 32	android/os/HandlerThread
      //   92: dup
      //   93: new 150	java/lang/StringBuilder
      //   96: dup
      //   97: ldc 152
      //   99: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   102: aload_0
      //   103: invokevirtual 111	java/lang/Object:hashCode	()I
      //   106: invokevirtual 157	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   109: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   112: invokespecial 162	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
      //   115: aastore
      //   116: aload_0
      //   117: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   120: iconst_0
      //   121: aaload
      //   122: invokevirtual 165	android/os/HandlerThread:start	()V
      //   125: aload_0
      //   126: new 63	android/os/Messenger
      //   129: dup
      //   130: new 11	com/tencent/matrix/backtrace/WarmUpService$b$2
      //   133: dup
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 34	com/tencent/matrix/backtrace/WarmUpService$b:eNo	[Landroid/os/HandlerThread;
      //   139: iconst_0
      //   140: aaload
      //   141: invokevirtual 168	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
      //   144: invokespecial 171	com/tencent/matrix/backtrace/WarmUpService$b$2:<init>	(Lcom/tencent/matrix/backtrace/WarmUpService$b;Landroid/os/Looper;)V
      //   147: invokespecial 174	android/os/Messenger:<init>	(Landroid/os/Handler;)V
      //   150: putfield 61	com/tencent/matrix/backtrace/WarmUpService$b:eNl	Landroid/os/Messenger;
      //   153: aload_3
      //   154: monitorexit
      //   155: new 176	android/content/Intent
      //   158: dup
      //   159: invokespecial 177	android/content/Intent:<init>	()V
      //   162: astore_3
      //   163: aload_3
      //   164: new 179	android/content/ComponentName
      //   167: dup
      //   168: aload_1
      //   169: ldc 6
      //   171: invokespecial 182	android/content/ComponentName:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   174: invokevirtual 186	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
      //   177: pop
      //   178: aload_3
      //   179: ldc 188
      //   181: aload_2
      //   182: ldc 188
      //   184: iconst_0
      //   185: invokevirtual 192	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
      //   188: invokevirtual 196	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
      //   191: pop
      //   192: aload_3
      //   193: ldc 198
      //   195: aload_2
      //   196: ldc 198
      //   198: aconst_null
      //   199: invokevirtual 202	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   202: invokevirtual 205	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   205: pop
      //   206: aload_1
      //   207: aload_3
      //   208: aload_0
      //   209: getfield 39	com/tencent/matrix/backtrace/WarmUpService$b:mConnection	Landroid/content/ServiceConnection;
      //   212: iconst_1
      //   213: invokevirtual 209	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
      //   216: pop
      //   217: aload_0
      //   218: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   221: astore_2
      //   222: aload_2
      //   223: monitorenter
      //   224: aload_0
      //   225: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   228: iconst_0
      //   229: baload
      //   230: ifne +13 -> 243
      //   233: aload_0
      //   234: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   237: ldc2_w 210
      //   240: invokevirtual 87	java/lang/Object:wait	(J)V
      //   243: aload_2
      //   244: monitorexit
      //   245: aload_0
      //   246: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   249: iconst_0
      //   250: baload
      //   251: ifne +8 -> 259
      //   254: aload_0
      //   255: aload_1
      //   256: invokevirtual 213	com/tencent/matrix/backtrace/WarmUpService$b:bG	(Landroid/content/Context;)V
      //   259: aload_0
      //   260: getfield 41	com/tencent/matrix/backtrace/WarmUpService$b:eNp	[Z
      //   263: iconst_0
      //   264: baload
      //   265: ireturn
      //   266: astore_1
      //   267: aload_3
      //   268: monitorexit
      //   269: aload_1
      //   270: athrow
      //   271: astore_3
      //   272: aload_2
      //   273: monitorexit
      //   274: aload_3
      //   275: athrow
      //   276: astore_2
      //   277: ldc 89
      //   279: aload_2
      //   280: ldc 91
      //   282: iconst_0
      //   283: anewarray 4	java/lang/Object
      //   286: invokestatic 97	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   289: goto -44 -> 245
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	292	0	this	b
      //   0	292	1	paramContext	android.content.Context
      //   55	213	3	localObject1	Object
      //   271	4	3	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   58	84	266	finally
      //   84	155	266	finally
      //   224	243	271	finally
      //   243	245	271	finally
      //   217	224	276	java/lang/InterruptedException
      //   272	276	276	java/lang/InterruptedException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.backtrace.WarmUpService
 * JD-Core Version:    0.7.0.1
 */