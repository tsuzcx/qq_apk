package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.g.f;

public final class j
{
  private static boolean nCx = false;
  
  /* Error */
  public static com.tencent.mm.kernel.b.f act(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 18
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 18
    //   14: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokestatic 39	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   23: astore_3
    //   24: ldc 41
    //   26: aload_3
    //   27: invokevirtual 45	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   30: ifeq +93 -> 123
    //   33: aload_3
    //   34: monitorenter
    //   35: invokestatic 51	com/tencent/mm/kernel/h:aHC	()Lcom/tencent/mm/kernel/d;
    //   38: aload_3
    //   39: invokevirtual 57	com/tencent/mm/kernel/d:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   42: checkcast 41	com/tencent/mm/kernel/b/f
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +12 -> 59
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: invokestatic 63	com/tencent/mm/kernel/g:bx	(Ljava/lang/Object;)Z
    //   56: ifeq +21 -> 77
    //   59: invokestatic 51	com/tencent/mm/kernel/h:aHC	()Lcom/tencent/mm/kernel/d;
    //   62: aload_3
    //   63: invokevirtual 67	com/tencent/mm/kernel/d:ac	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/f;
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 71	com/tencent/mm/kernel/h:aHD	()Lcom/tencent/mm/kernel/e;
    //   71: invokevirtual 77	com/tencent/mm/kernel/e:aHf	()Lcom/tencent/mm/kernel/b/g;
    //   74: invokevirtual 81	com/tencent/mm/kernel/b/f:execute	(Lcom/tencent/mm/kernel/b/g;)V
    //   77: aload_3
    //   78: monitorexit
    //   79: ldc 18
    //   81: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: areturn
    //   86: astore_1
    //   87: aload_3
    //   88: monitorexit
    //   89: ldc 18
    //   91: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: ldc 83
    //   99: ldc 85
    //   101: iconst_2
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_1
    //   112: aastore
    //   113: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 18
    //   118: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aconst_null
    //   122: areturn
    //   123: ldc 83
    //   125: ldc 93
    //   127: iconst_1
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload_0
    //   134: aastore
    //   135: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: goto -22 -> 116
    //   141: astore_1
    //   142: goto -45 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramString	java.lang.String
    //   51	34	1	localf1	com.tencent.mm.kernel.b.f
    //   86	9	1	localObject	Object
    //   96	16	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   141	1	1	localClassCastException	java.lang.ClassCastException
    //   45	8	2	localf2	com.tencent.mm.kernel.b.f
    //   23	65	3	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   35	46	86	finally
    //   52	59	86	finally
    //   59	77	86	finally
    //   77	79	86	finally
    //   19	35	96	java/lang/ClassNotFoundException
    //   87	96	96	java/lang/ClassNotFoundException
    //   123	138	96	java/lang/ClassNotFoundException
    //   19	35	141	java/lang/ClassCastException
    //   87	96	141	java/lang/ClassCastException
    //   123	138	141	java/lang/ClassCastException
  }
  
  public static void bFt()
  {
    AppMethodBeat.i(44133);
    try
    {
      if (!nCx)
      {
        new f().execute(h.aHD().aHf());
        nCx = true;
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(44133);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.j
 * JD-Core Version:    0.7.0.1
 */