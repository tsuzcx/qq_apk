package com.tencent.mm.app;

import android.content.pm.IPackageStatsObserver.Stub;

final class w$6
  extends IPackageStatsObserver.Stub
{
  /* Error */
  public final void onGetStatsCompleted(android.content.pm.PackageStats arg1, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +93 -> 94
    //   4: invokestatic 20	com/tencent/mm/app/w:aCG	()[J
    //   7: iconst_0
    //   8: aload_1
    //   9: getfield 26	android/content/pm/PackageStats:cacheSize	J
    //   12: lastore
    //   13: invokestatic 20	com/tencent/mm/app/w:aCG	()[J
    //   16: iconst_1
    //   17: aload_1
    //   18: getfield 29	android/content/pm/PackageStats:dataSize	J
    //   21: lastore
    //   22: invokestatic 20	com/tencent/mm/app/w:aCG	()[J
    //   25: iconst_2
    //   26: aload_1
    //   27: getfield 32	android/content/pm/PackageStats:codeSize	J
    //   30: lastore
    //   31: ldc 34
    //   33: ldc 36
    //   35: iconst_4
    //   36: anewarray 38	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: iload_2
    //   42: invokestatic 44	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload_1
    //   49: getfield 26	android/content/pm/PackageStats:cacheSize	J
    //   52: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: aload_1
    //   59: getfield 29	android/content/pm/PackageStats:dataSize	J
    //   62: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: aload_1
    //   69: getfield 32	android/content/pm/PackageStats:codeSize	J
    //   72: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: aastore
    //   76: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: invokestatic 20	com/tencent/mm/app/w:aCG	()[J
    //   82: astore_1
    //   83: aload_1
    //   84: monitorenter
    //   85: invokestatic 20	com/tencent/mm/app/w:aCG	()[J
    //   88: invokevirtual 58	java/lang/Object:notify	()V
    //   91: aload_1
    //   92: monitorexit
    //   93: return
    //   94: ldc 34
    //   96: ldc 60
    //   98: iconst_1
    //   99: anewarray 38	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: iload_2
    //   105: invokestatic 44	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   108: aastore
    //   109: invokestatic 55	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: goto -33 -> 79
    //   115: astore_1
    //   116: ldc 34
    //   118: aload_1
    //   119: ldc 61
    //   121: iconst_0
    //   122: anewarray 38	java/lang/Object
    //   125: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: return
    //   129: astore_3
    //   130: aload_1
    //   131: monitorexit
    //   132: aload_3
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	6
    //   0	134	2	paramBoolean	boolean
    //   129	4	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   4	79	115	finally
    //   79	85	115	finally
    //   94	112	115	finally
    //   130	134	115	finally
    //   85	93	129	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.w.6
 * JD-Core Version:    0.7.0.1
 */