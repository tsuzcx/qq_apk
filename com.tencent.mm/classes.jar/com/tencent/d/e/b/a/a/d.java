package com.tencent.d.e.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public abstract class d
  implements a
{
  private c LOn;
  
  /* Error */
  private int a(Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual 25	com/tencent/d/e/b/a/a/d:getIntent	()Landroid/content/Intent;
    //   14: new 8	com/tencent/d/e/b/a/a/d$1
    //   17: dup
    //   18: aload_0
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: invokespecial 28	com/tencent/d/e/b/a/a/d$1:<init>	(Lcom/tencent/d/e/b/a/a/d;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   26: iconst_1
    //   27: invokevirtual 34	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   30: ifne +6 -> 36
    //   33: bipush 156
    //   35: ireturn
    //   36: aload_2
    //   37: invokevirtual 40	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   40: ifnonnull +17 -> 57
    //   43: aload 4
    //   45: monitorenter
    //   46: aload 4
    //   48: ldc2_w 41
    //   51: invokevirtual 46	java/lang/Object:wait	(J)V
    //   54: aload 4
    //   56: monitorexit
    //   57: aload_2
    //   58: invokevirtual 40	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   61: ifnonnull +12 -> 73
    //   64: bipush 151
    //   66: ireturn
    //   67: astore_1
    //   68: aload 4
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: iconst_0
    //   74: ireturn
    //   75: astore_1
    //   76: goto -22 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	d
    //   0	79	1	paramContext	Context
    //   0	79	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	79	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   7	62	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	54	67	finally
    //   54	57	67	finally
    //   68	71	67	finally
    //   46	54	75	java/lang/Throwable
  }
  
  /* Error */
  private int a(final Context paramContext, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 36	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 58	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: getstatic 64	com/tencent/e/h:LTJ	Lcom/tencent/e/i;
    //   25: new 10	com/tencent/d/e/b/a/a/d$2
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: aload 6
    //   34: aload 4
    //   36: aload_3
    //   37: aload 5
    //   39: invokespecial 67	com/tencent/d/e/b/a/a/d$2:<init>	(Lcom/tencent/d/e/b/a/a/d;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   42: invokeinterface 73 2 0
    //   47: pop
    //   48: aload 5
    //   50: monitorenter
    //   51: aload 5
    //   53: ldc2_w 41
    //   56: invokevirtual 46	java/lang/Object:wait	(J)V
    //   59: aload 5
    //   61: monitorexit
    //   62: aload 6
    //   64: invokevirtual 40	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   67: checkcast 51	java/lang/Integer
    //   70: invokevirtual 77	java/lang/Integer:intValue	()I
    //   73: ireturn
    //   74: astore_1
    //   75: aload 5
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: goto -22 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	d
    //   0	84	1	paramContext	Context
    //   0	84	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	84	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   0	84	4	paramAtomicReference2	AtomicReference<String>
    //   7	69	5	localObject	Object
    //   20	43	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   51	59	74	finally
    //   59	62	74	finally
    //   75	78	74	finally
    //   51	59	80	java/lang/Throwable
  }
  
  private c kU(Context paramContext)
  {
    int j = -1;
    AtomicReference localAtomicReference1 = new AtomicReference();
    localAtomicReference1.set("");
    int i = j;
    try
    {
      AtomicReference localAtomicReference2 = new AtomicReference();
      i = j;
      AtomicReference localAtomicReference3 = new AtomicReference();
      i = j;
      j = a(paramContext, localAtomicReference2, localAtomicReference3);
      i = j;
      if (j == 0)
      {
        i = j;
        j = a(paramContext, localAtomicReference2, localAtomicReference3, localAtomicReference1);
        i = j;
      }
    }
    catch (Throwable paramContext)
    {
      label74:
      break label74;
    }
    return new c((String)localAtomicReference1.get(), i);
  }
  
  public abstract String a(Context paramContext, IBinder paramIBinder);
  
  public abstract Intent getIntent();
  
  public final c kS(Context paramContext)
  {
    if ((this.LOn == null) || (this.LOn.errorCode != 0)) {
      this.LOn = kU(paramContext);
    }
    return this.LOn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */