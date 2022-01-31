package com.tencent.mm.app;

import android.os.FileObserver;

final class m$a
  extends FileObserver
{
  m$a(m paramm, String paramString)
  {
    super(paramString, 712);
  }
  
  /* Error */
  public final void onEvent(int paramInt, String arg2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 25	java/lang/System:currentTimeMillis	()J
    //   5: aload_0
    //   6: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   9: invokestatic 28	com/tencent/mm/app/m:a	(Lcom/tencent/mm/app/m;)J
    //   12: lsub
    //   13: ldc2_w 29
    //   16: lcmp
    //   17: ifge +5 -> 22
    //   20: iconst_1
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq +4 -> 27
    //   26: return
    //   27: aload_0
    //   28: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   31: getfield 34	com/tencent/mm/app/m:bYq	Ljava/util/HashSet;
    //   34: astore 4
    //   36: aload 4
    //   38: monitorenter
    //   39: iload_1
    //   40: lookupswitch	default:+44->84, 8:+54->94, 64:+134->174, 128:+119->159, 512:+134->174
    //   85: iconst_1
    //   86: monitorexit
    //   87: return
    //   88: astore_2
    //   89: aload 4
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    //   94: ldc 36
    //   96: ldc 38
    //   98: aload_2
    //   99: invokestatic 44	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokevirtual 48	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   112: getfield 58	com/tencent/mm/app/m:bYt	Landroid/os/ConditionVariable;
    //   115: invokevirtual 64	android/os/ConditionVariable:open	()V
    //   118: aload_0
    //   119: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   122: getfield 68	com/tencent/mm/app/m:bYz	Lcom/tencent/mm/app/m$b;
    //   125: ifnonnull +34 -> 159
    //   128: aload_0
    //   129: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   132: new 70	com/tencent/mm/app/m$b
    //   135: dup
    //   136: aload_0
    //   137: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   140: iconst_0
    //   141: invokespecial 73	com/tencent/mm/app/m$b:<init>	(Lcom/tencent/mm/app/m;B)V
    //   144: putfield 68	com/tencent/mm/app/m:bYz	Lcom/tencent/mm/app/m$b;
    //   147: aload_0
    //   148: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   151: getfield 68	com/tencent/mm/app/m:bYz	Lcom/tencent/mm/app/m$b;
    //   154: ldc 75
    //   156: invokestatic 81	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   159: aload_0
    //   160: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   163: getfield 34	com/tencent/mm/app/m:bYq	Ljava/util/HashSet;
    //   166: aload_2
    //   167: invokevirtual 87	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: goto -87 -> 84
    //   174: aload_0
    //   175: getfield 13	com/tencent/mm/app/m$a:bYB	Lcom/tencent/mm/app/m;
    //   178: getfield 34	com/tencent/mm/app/m:bYq	Ljava/util/HashSet;
    //   181: aload_2
    //   182: invokevirtual 90	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   185: pop
    //   186: goto -102 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	a
    //   0	189	1	paramInt	int
    //   1	22	3	i	int
    //   34	56	4	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   84	87	88	finally
    //   89	92	88	finally
    //   94	159	88	finally
    //   159	171	88	finally
    //   174	186	88	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.m.a
 * JD-Core Version:    0.7.0.1
 */