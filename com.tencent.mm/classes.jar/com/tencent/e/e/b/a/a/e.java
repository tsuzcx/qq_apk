package com.tencent.e.e.b.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.atomic.AtomicReference;

public abstract class e
  implements a
{
  private c ahuZ;
  
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
    //   11: invokevirtual 23	com/tencent/e/e/b/a/a/e:getIntent	()Landroid/content/Intent;
    //   14: new 8	com/tencent/e/e/b/a/a/e$1
    //   17: dup
    //   18: aload_0
    //   19: aload_2
    //   20: aload_3
    //   21: aload 4
    //   23: invokespecial 26	com/tencent/e/e/b/a/a/e$1:<init>	(Lcom/tencent/e/e/b/a/a/e;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   26: iconst_1
    //   27: invokevirtual 32	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   30: ifne +6 -> 36
    //   33: bipush 156
    //   35: ireturn
    //   36: aload_2
    //   37: invokevirtual 38	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   40: ifnonnull +17 -> 57
    //   43: aload 4
    //   45: monitorenter
    //   46: aload 4
    //   48: ldc2_w 39
    //   51: invokevirtual 44	java/lang/Object:wait	(J)V
    //   54: aload 4
    //   56: monitorexit
    //   57: aload_2
    //   58: invokevirtual 38	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
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
    //   0	79	0	this	e
    //   0	79	1	paramContext	Context
    //   0	79	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	79	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   7	62	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	57	67	finally
    //   46	54	75	finally
  }
  
  /* Error */
  private int a(Context arg1, final AtomicReference<IBinder> paramAtomicReference, final AtomicReference<ServiceConnection> paramAtomicReference1, final AtomicReference<String> paramAtomicReference2)
  {
    // Byte code:
    //   0: new 4	java/lang/Object
    //   3: dup
    //   4: invokespecial 16	java/lang/Object:<init>	()V
    //   7: astore 5
    //   9: new 34	java/util/concurrent/atomic/AtomicReference
    //   12: dup
    //   13: iconst_0
    //   14: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   17: invokespecial 56	java/util/concurrent/atomic/AtomicReference:<init>	(Ljava/lang/Object;)V
    //   20: astore 6
    //   22: getstatic 62	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   25: new 10	com/tencent/e/e/b/a/a/e$2
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: aload 6
    //   34: aload 4
    //   36: aload_3
    //   37: aload 5
    //   39: invokespecial 65	com/tencent/e/e/b/a/a/e$2:<init>	(Lcom/tencent/e/e/b/a/a/e;Landroid/content/Context;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V
    //   42: invokeinterface 71 2 0
    //   47: pop
    //   48: aload 5
    //   50: monitorenter
    //   51: aload 5
    //   53: ldc2_w 39
    //   56: invokevirtual 44	java/lang/Object:wait	(J)V
    //   59: aload 5
    //   61: monitorexit
    //   62: aload 6
    //   64: invokevirtual 38	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   67: checkcast 49	java/lang/Integer
    //   70: invokevirtual 75	java/lang/Integer:intValue	()I
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
    //   0	84	0	this	e
    //   0	84	2	paramAtomicReference	AtomicReference<IBinder>
    //   0	84	3	paramAtomicReference1	AtomicReference<ServiceConnection>
    //   0	84	4	paramAtomicReference2	AtomicReference<String>
    //   7	69	5	localObject	Object
    //   20	43	6	localAtomicReference	AtomicReference
    // Exception table:
    //   from	to	target	type
    //   59	62	74	finally
    //   51	59	80	finally
  }
  
  private c oa(Context paramContext)
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
    finally
    {
      label74:
      break label74;
    }
    return new c((String)localAtomicReference1.get(), i);
  }
  
  public abstract String a(Context paramContext, IBinder paramIBinder);
  
  public abstract Intent getIntent();
  
  public final c nY(Context paramContext)
  {
    if ((this.ahuZ == null) || (this.ahuZ.errorCode != 0)) {
      this.ahuZ = oa(paramContext);
    }
    return this.ahuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.e.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */