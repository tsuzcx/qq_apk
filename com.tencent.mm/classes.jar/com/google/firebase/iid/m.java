package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

final class m
{
  private static int bfg = 0;
  private static PendingIntent bfu;
  private final f beX;
  private final Context bfj;
  @GuardedBy("responseCallbacks")
  private final android.support.v4.e.m<String, TaskCompletionSource<Bundle>> bfv;
  private Messenger bfw;
  private Messenger bfx;
  private zzi bfy;
  
  public m(Context paramContext, f paramf)
  {
    AppMethodBeat.i(108735);
    this.bfv = new android.support.v4.e.m();
    this.bfj = paramContext;
    this.beX = paramf;
    this.bfw = new Messenger(new n(this, Looper.getMainLooper()));
    AppMethodBeat.o(108735);
  }
  
  private static void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      AppMethodBeat.i(108736);
      if (bfu == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        bfu = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", bfu);
      AppMethodBeat.o(108736);
      return;
    }
    finally {}
  }
  
  private final void f(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(108737);
    TaskCompletionSource localTaskCompletionSource;
    synchronized (this.bfv)
    {
      localTaskCompletionSource = (TaskCompletionSource)this.bfv.remove(paramString);
      if (localTaskCompletionSource == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0)
        {
          "Missing callback for ".concat(paramString);
          AppMethodBeat.o(108737);
          return;
        }
        new String("Missing callback for ");
      }
    }
    localTaskCompletionSource.setResult(paramBundle);
    AppMethodBeat.o(108737);
  }
  
  /* Error */
  private final Bundle g(Bundle arg1)
  {
    // Byte code:
    //   0: ldc_w 277
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 280	com/google/firebase/iid/m:rZ	()Ljava/lang/String;
    //   9: astore_2
    //   10: new 260	com/google/android/gms/tasks/TaskCompletionSource
    //   13: dup
    //   14: invokespecial 281	com/google/android/gms/tasks/TaskCompletionSource:<init>	()V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   22: astore 4
    //   24: aload 4
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   31: aload_2
    //   32: aload_3
    //   33: invokevirtual 285	android/support/v4/e/m:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: aload 4
    //   39: monitorexit
    //   40: aload_0
    //   41: getfield 48	com/google/firebase/iid/m:beX	Lcom/google/firebase/iid/f;
    //   44: invokevirtual 290	com/google/firebase/iid/f:zzx	()I
    //   47: ifne +34 -> 81
    //   50: new 292	java/io/IOException
    //   53: dup
    //   54: ldc_w 294
    //   57: invokespecial 295	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   60: astore_1
    //   61: ldc_w 277
    //   64: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: aload 4
    //   72: monitorexit
    //   73: ldc_w 277
    //   76: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_1
    //   80: athrow
    //   81: new 80	android/content/Intent
    //   84: dup
    //   85: invokespecial 236	android/content/Intent:<init>	()V
    //   88: astore 4
    //   90: aload 4
    //   92: ldc_w 297
    //   95: invokevirtual 242	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   98: pop
    //   99: aload_0
    //   100: getfield 48	com/google/firebase/iid/m:beX	Lcom/google/firebase/iid/f;
    //   103: invokevirtual 290	com/google/firebase/iid/f:zzx	()I
    //   106: iconst_2
    //   107: if_icmpne +211 -> 318
    //   110: aload 4
    //   112: ldc_w 299
    //   115: invokevirtual 302	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   118: pop
    //   119: aload 4
    //   121: aload_1
    //   122: invokevirtual 306	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   125: pop
    //   126: aload_0
    //   127: getfield 46	com/google/firebase/iid/m:bfj	Landroid/content/Context;
    //   130: aload 4
    //   132: invokestatic 308	com/google/firebase/iid/m:b	(Landroid/content/Context;Landroid/content/Intent;)V
    //   135: aload 4
    //   137: ldc_w 310
    //   140: new 155	java/lang/StringBuilder
    //   143: dup
    //   144: aload_2
    //   145: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokevirtual 131	java/lang/String:length	()I
    //   151: iconst_5
    //   152: iadd
    //   153: invokespecial 157	java/lang/StringBuilder:<init>	(I)V
    //   156: ldc_w 312
    //   159: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 167
    //   168: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 315	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 190	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   177: pop
    //   178: ldc 117
    //   180: iconst_3
    //   181: invokestatic 123	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   184: ifeq +40 -> 224
    //   187: aload 4
    //   189: invokevirtual 153	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   192: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   195: astore_1
    //   196: new 155	java/lang/StringBuilder
    //   199: dup
    //   200: aload_1
    //   201: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual 131	java/lang/String:length	()I
    //   207: bipush 8
    //   209: iadd
    //   210: invokespecial 157	java/lang/StringBuilder:<init>	(I)V
    //   213: ldc_w 317
    //   216: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_1
    //   220: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: ldc 89
    //   228: aload_0
    //   229: getfield 66	com/google/firebase/iid/m:bfw	Landroid/os/Messenger;
    //   232: invokevirtual 253	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   235: pop
    //   236: aload_0
    //   237: getfield 103	com/google/firebase/iid/m:bfx	Landroid/os/Messenger;
    //   240: ifnonnull +10 -> 250
    //   243: aload_0
    //   244: getfield 101	com/google/firebase/iid/m:bfy	Lcom/google/firebase/iid/zzi;
    //   247: ifnull +102 -> 349
    //   250: invokestatic 321	android/os/Message:obtain	()Landroid/os/Message;
    //   253: astore_1
    //   254: aload_1
    //   255: aload 4
    //   257: putfield 78	android/os/Message:obj	Ljava/lang/Object;
    //   260: aload_0
    //   261: getfield 103	com/google/firebase/iid/m:bfx	Landroid/os/Messenger;
    //   264: ifnull +66 -> 330
    //   267: aload_0
    //   268: getfield 103	com/google/firebase/iid/m:bfx	Landroid/os/Messenger;
    //   271: aload_1
    //   272: invokevirtual 325	android/os/Messenger:send	(Landroid/os/Message;)V
    //   275: aload_3
    //   276: invokevirtual 329	com/google/android/gms/tasks/TaskCompletionSource:getTask	()Lcom/google/android/gms/tasks/Task;
    //   279: ldc2_w 330
    //   282: getstatic 337	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   285: invokestatic 343	com/google/android/gms/tasks/Tasks:await	(Lcom/google/android/gms/tasks/Task;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   288: checkcast 226	android/os/Bundle
    //   291: astore_3
    //   292: aload_0
    //   293: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   296: astore_1
    //   297: aload_1
    //   298: monitorenter
    //   299: aload_0
    //   300: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   303: aload_2
    //   304: invokevirtual 258	android/support/v4/e/m:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   307: pop
    //   308: aload_1
    //   309: monitorexit
    //   310: ldc_w 277
    //   313: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aload_3
    //   317: areturn
    //   318: aload 4
    //   320: ldc_w 345
    //   323: invokevirtual 302	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   326: pop
    //   327: goto -208 -> 119
    //   330: aload_0
    //   331: getfield 101	com/google/firebase/iid/m:bfy	Lcom/google/firebase/iid/zzi;
    //   334: aload_1
    //   335: invokevirtual 346	com/google/firebase/iid/zzi:send	(Landroid/os/Message;)V
    //   338: goto -63 -> 275
    //   341: astore_1
    //   342: ldc 117
    //   344: iconst_3
    //   345: invokestatic 123	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   348: pop
    //   349: aload_0
    //   350: getfield 48	com/google/firebase/iid/m:beX	Lcom/google/firebase/iid/f;
    //   353: invokevirtual 290	com/google/firebase/iid/f:zzx	()I
    //   356: iconst_2
    //   357: if_icmpne +15 -> 372
    //   360: aload_0
    //   361: getfield 46	com/google/firebase/iid/m:bfj	Landroid/content/Context;
    //   364: aload 4
    //   366: invokevirtual 352	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   369: goto -94 -> 275
    //   372: aload_0
    //   373: getfield 46	com/google/firebase/iid/m:bfj	Landroid/content/Context;
    //   376: aload 4
    //   378: invokevirtual 356	android/content/Context:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   381: pop
    //   382: goto -107 -> 275
    //   385: astore_2
    //   386: aload_1
    //   387: monitorexit
    //   388: ldc_w 277
    //   391: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   394: aload_2
    //   395: athrow
    //   396: astore_1
    //   397: new 292	java/io/IOException
    //   400: dup
    //   401: ldc_w 358
    //   404: invokespecial 295	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   407: astore_1
    //   408: ldc_w 277
    //   411: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_1
    //   415: athrow
    //   416: astore_3
    //   417: aload_0
    //   418: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   421: astore_1
    //   422: aload_1
    //   423: monitorenter
    //   424: aload_0
    //   425: getfield 44	com/google/firebase/iid/m:bfv	Landroid/support/v4/e/m;
    //   428: aload_2
    //   429: invokevirtual 258	android/support/v4/e/m:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   432: pop
    //   433: aload_1
    //   434: monitorexit
    //   435: ldc_w 277
    //   438: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   441: aload_3
    //   442: athrow
    //   443: astore_1
    //   444: new 292	java/io/IOException
    //   447: dup
    //   448: aload_1
    //   449: invokespecial 361	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   452: astore_1
    //   453: ldc_w 277
    //   456: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload_1
    //   460: athrow
    //   461: astore_2
    //   462: aload_1
    //   463: monitorexit
    //   464: ldc_w 277
    //   467: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   470: aload_2
    //   471: athrow
    //   472: astore_1
    //   473: goto -76 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	476	0	this	m
    //   9	295	2	str	String
    //   385	44	2	localObject1	Object
    //   461	10	2	localObject2	Object
    //   17	300	3	localObject3	Object
    //   416	26	3	localObject4	Object
    //   22	355	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   27	40	69	finally
    //   70	73	69	finally
    //   260	275	341	android/os/RemoteException
    //   330	338	341	android/os/RemoteException
    //   299	310	385	finally
    //   386	388	385	finally
    //   275	292	396	java/lang/InterruptedException
    //   275	292	416	finally
    //   397	416	416	finally
    //   444	461	416	finally
    //   275	292	443	java/util/concurrent/ExecutionException
    //   424	435	461	finally
    //   462	464	461	finally
    //   275	292	472	java/util/concurrent/TimeoutException
  }
  
  private static String rZ()
  {
    try
    {
      AppMethodBeat.i(108740);
      int i = bfg;
      bfg = i + 1;
      String str = Integer.toString(i);
      AppMethodBeat.o(108740);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final Bundle zzd(Bundle paramBundle)
  {
    AppMethodBeat.i(108739);
    Bundle localBundle2 = g(paramBundle);
    Bundle localBundle1 = localBundle2;
    if (localBundle2 != null)
    {
      localBundle1 = localBundle2;
      if (localBundle2.containsKey("google.messenger"))
      {
        paramBundle = g(paramBundle);
        localBundle1 = paramBundle;
        if (paramBundle != null)
        {
          localBundle1 = paramBundle;
          if (paramBundle.containsKey("google.messenger")) {
            localBundle1 = null;
          }
        }
      }
    }
    AppMethodBeat.o(108739);
    return localBundle1;
  }
  
  final Bundle f(Bundle paramBundle)
  {
    AppMethodBeat.i(108738);
    Object localObject;
    if (this.beX.rY() >= 12000000)
    {
      localObject = ai.aj(this.bfj);
      localObject = ((ai)localObject).a(new e(((ai)localObject).sf(), paramBundle));
    }
    try
    {
      localObject = (Bundle)Tasks.await((Task)localObject);
      AppMethodBeat.o(108738);
      return localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        String str = String.valueOf(localInterruptedException);
        new StringBuilder(String.valueOf(str).length() + 22).append("Error making request: ").append(str);
      }
      if (((localInterruptedException.getCause() instanceof d)) && (((d)localInterruptedException.getCause()).errorCode == 4))
      {
        paramBundle = zzd(paramBundle);
        AppMethodBeat.o(108738);
        return paramBundle;
      }
      AppMethodBeat.o(108738);
      return null;
      paramBundle = zzd(paramBundle);
      AppMethodBeat.o(108738);
      return paramBundle;
    }
    catch (ExecutionException localExecutionException)
    {
      label61:
      break label61;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.m
 * JD-Core Version:    0.7.0.1
 */