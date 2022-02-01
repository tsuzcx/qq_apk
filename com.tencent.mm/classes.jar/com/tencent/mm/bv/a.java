package com.tencent.mm.bv;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  /* Error */
  public static boolean h(Context paramContext, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 7
    //   11: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokestatic 20	com/tencent/mm/bv/a:lI	(Landroid/content/Context;)Ljava/util/Map;
    //   20: astore_0
    //   21: iconst_0
    //   22: istore_2
    //   23: iload_2
    //   24: bipush 10
    //   26: if_icmpge +161 -> 187
    //   29: aload_1
    //   30: iload_2
    //   31: aaload
    //   32: astore_3
    //   33: aload_0
    //   34: aload_3
    //   35: invokeinterface 26 2 0
    //   40: checkcast 28	java/lang/Integer
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +103 -> 150
    //   50: ldc 30
    //   52: ldc 32
    //   54: iconst_2
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload 4
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_3
    //   66: aastore
    //   67: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload 4
    //   72: invokevirtual 41	java/lang/Integer:intValue	()I
    //   75: new 43	com/tencent/mm/hellhoundlib/b/a
    //   78: dup
    //   79: invokespecial 47	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   82: invokestatic 53	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   85: astore 5
    //   87: new 4	java/lang/Object
    //   90: dup
    //   91: invokespecial 54	java/lang/Object:<init>	()V
    //   94: astore 6
    //   96: aload 6
    //   98: aload 5
    //   100: invokevirtual 58	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   103: ldc 60
    //   105: ldc 62
    //   107: ldc 63
    //   109: ldc 65
    //   111: ldc 62
    //   113: ldc 66
    //   115: invokestatic 72	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 5
    //   120: iconst_0
    //   121: invokevirtual 76	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
    //   124: checkcast 28	java/lang/Integer
    //   127: invokevirtual 41	java/lang/Integer:intValue	()I
    //   130: invokestatic 80	android/os/Process:killProcess	(I)V
    //   133: aload 6
    //   135: ldc 60
    //   137: ldc 62
    //   139: ldc 63
    //   141: ldc 65
    //   143: ldc 62
    //   145: ldc 66
    //   147: invokestatic 84	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   150: iload_2
    //   151: iconst_1
    //   152: iadd
    //   153: istore_2
    //   154: goto -131 -> 23
    //   157: astore 5
    //   159: ldc 30
    //   161: ldc 86
    //   163: iconst_3
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_3
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload 4
    //   175: aastore
    //   176: dup
    //   177: iconst_2
    //   178: aload 5
    //   180: aastore
    //   181: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: goto -34 -> 150
    //   187: ldc 7
    //   189: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: iconst_1
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   0	194	1	paramVarArgs	String[]
    //   22	132	2	i	int
    //   32	138	3	str	String
    //   43	131	4	localInteger	Integer
    //   85	34	5	locala	com.tencent.mm.hellhoundlib.b.a
    //   157	22	5	localObject1	Object
    //   94	40	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   70	150	157	finally
  }
  
  private static Map<String, Integer> lI(Context paramContext)
  {
    AppMethodBeat.i(152429);
    HashMap localHashMap = new HashMap();
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          localHashMap.put(localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid));
        }
        AppMethodBeat.o(152429);
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ProcessOperator", paramContext, "", new Object[0]);
      }
    }
    return localHashMap;
  }
  
  public static void lJ(Context paramContext)
  {
    AppMethodBeat.i(152432);
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramContext = paramContext.getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject1).uid == j) && (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i))
      {
        localObject1 = c.a(((ActivityManager.RunningAppProcessInfo)localObject1).pid, new com.tencent.mm.hellhoundlib.b.a());
        Object localObject2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    paramContext = c.a(i, new com.tencent.mm.hellhoundlib.b.a());
    Object localObject1 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramContext.aYi(), "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    Process.killProcess(((Integer)paramContext.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/process/ProcessOperator", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
    AppMethodBeat.o(152432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bv.a
 * JD-Core Version:    0.7.0.1
 */