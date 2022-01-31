package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  static int epM = 0;
  static String epN = null;
  
  public static int Lo()
  {
    int m = 15;
    AppMethodBeat.i(92941);
    int i;
    int j;
    int k;
    if (n.Lv())
    {
      i = 7;
      j = i;
      if (ac.ert.epP)
      {
        j = i;
        if (ac.ert.epR == 0)
        {
          ab.d("MicroMsg.CpuChecker", "disable armv6 by server ");
          j = i & 0xFFFFFFFD;
        }
      }
      k = j;
      if (ac.ert.epP)
      {
        k = j;
        if (ac.ert.epQ == 0)
        {
          ab.d("MicroMsg.CpuChecker", "disable armv7 by server ");
          k = j & 0xFFFFFFFB;
        }
      }
      i = n.getNumCores();
      if (i <= 16) {
        break label185;
      }
      j = 15;
      label98:
      i = bo.getInt(Lp(), 0) / 1000;
      if (j <= 4) {
        break label196;
      }
      i *= 4;
    }
    label135:
    label185:
    label196:
    label236:
    label239:
    for (;;)
    {
      label119:
      int n = i / 100;
      if (n > 30)
      {
        i = 30;
        if ((i > 5) || (j < 4)) {
          break label236;
        }
        i = m;
      }
      for (;;)
      {
        i = (k + (j << 4) << 8) + i;
        epM = i;
        AppMethodBeat.o(92941);
        return i;
        if (n.Lw())
        {
          i = 3;
          break;
        }
        i = 1;
        break;
        j = i;
        if (i > 0) {
          break label98;
        }
        j = 1;
        break label98;
        if (j > 2)
        {
          i *= 2;
          break label119;
        }
        if (j <= 1) {
          break label239;
        }
        i = i * 3 >> 1;
        break label119;
        i = n;
        if (n >= 5) {
          break label135;
        }
        i = 5;
        break label135;
      }
    }
  }
  
  /* Error */
  public static String Lp()
  {
    // Byte code:
    //   0: ldc 82
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 84	java/io/BufferedReader
    //   8: dup
    //   9: new 86	java/io/FileReader
    //   12: dup
    //   13: ldc 88
    //   15: invokespecial 92	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +53 -> 83
    //   33: aload_1
    //   34: astore_0
    //   35: new 100	java/lang/NullPointerException
    //   38: dup
    //   39: ldc 102
    //   41: invokespecial 103	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: ldc 82
    //   49: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: ldc 47
    //   61: aload_2
    //   62: ldc 105
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_1
    //   72: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   75: ldc 82
    //   77: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 115
    //   82: areturn
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 120	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload_1
    //   91: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   94: ldc 82
    //   96: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   108: ldc 82
    //   110: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -12 -> 104
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -65 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	82	0	localBufferedReader1	java.io.BufferedReader
    //   21	70	1	localBufferedReader2	java.io.BufferedReader
    //   101	13	1	localObject1	Object
    //   115	1	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   28	27	2	localObject4	Object
    //   56	30	2	localThrowable1	java.lang.Throwable
    //   89	11	2	str	String
    //   119	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	29	56	java/lang/Throwable
    //   35	45	56	java/lang/Throwable
    //   47	52	56	java/lang/Throwable
    //   54	56	56	java/lang/Throwable
    //   85	90	56	java/lang/Throwable
    //   5	22	101	finally
    //   24	29	115	finally
    //   35	45	115	finally
    //   47	52	115	finally
    //   54	56	115	finally
    //   59	71	115	finally
    //   85	90	115	finally
    //   5	22	119	java/lang/Throwable
  }
  
  /* Error */
  public static String Lq()
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 84	java/io/BufferedReader
    //   8: dup
    //   9: new 86	java/io/FileReader
    //   12: dup
    //   13: ldc 124
    //   15: invokespecial 92	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +53 -> 83
    //   33: aload_1
    //   34: astore_0
    //   35: new 100	java/lang/NullPointerException
    //   38: dup
    //   39: ldc 126
    //   41: invokespecial 103	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: ldc 122
    //   49: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: ldc 47
    //   61: aload_2
    //   62: ldc 105
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_1
    //   72: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   75: ldc 122
    //   77: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 115
    //   82: areturn
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 120	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload_1
    //   91: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   94: ldc 122
    //   96: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   108: ldc 122
    //   110: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -12 -> 104
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -65 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	82	0	localBufferedReader1	java.io.BufferedReader
    //   21	70	1	localBufferedReader2	java.io.BufferedReader
    //   101	13	1	localObject1	Object
    //   115	1	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   28	27	2	localObject4	Object
    //   56	30	2	localThrowable1	java.lang.Throwable
    //   89	11	2	str	String
    //   119	1	2	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	29	56	java/lang/Throwable
    //   35	45	56	java/lang/Throwable
    //   47	52	56	java/lang/Throwable
    //   54	56	56	java/lang/Throwable
    //   85	90	56	java/lang/Throwable
    //   5	22	101	finally
    //   24	29	115	finally
    //   35	45	115	finally
    //   47	52	115	finally
    //   54	56	115	finally
    //   59	71	115	finally
    //   85	90	115	finally
    //   5	22	119	java/lang/Throwable
  }
  
  /* Error */
  public static String Lr()
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 84	java/io/BufferedReader
    //   8: dup
    //   9: new 86	java/io/FileReader
    //   12: dup
    //   13: ldc 132
    //   15: invokespecial 92	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_1
    //   22: aload_1
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnonnull +53 -> 83
    //   33: aload_1
    //   34: astore_0
    //   35: new 100	java/lang/NullPointerException
    //   38: dup
    //   39: ldc 134
    //   41: invokespecial 103	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: ldc 130
    //   49: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: athrow
    //   56: astore_2
    //   57: aload_1
    //   58: astore_0
    //   59: ldc 47
    //   61: aload_2
    //   62: ldc 105
    //   64: iconst_0
    //   65: anewarray 4	java/lang/Object
    //   68: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aload_1
    //   72: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   75: ldc 130
    //   77: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: ldc 115
    //   82: areturn
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: invokevirtual 120	java/lang/String:trim	()Ljava/lang/String;
    //   89: astore_2
    //   90: aload_1
    //   91: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   94: ldc 130
    //   96: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: invokestatic 113	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   108: ldc 130
    //   110: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -12 -> 104
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -65 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   23	82	0	localBufferedReader1	java.io.BufferedReader
    //   21	70	1	localBufferedReader2	java.io.BufferedReader
    //   101	13	1	localObject1	Object
    //   115	1	1	localObject2	Object
    //   121	1	1	localObject3	Object
    //   28	27	2	localObject4	Object
    //   56	30	2	localException1	java.lang.Exception
    //   89	11	2	str	String
    //   119	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   24	29	56	java/lang/Exception
    //   35	45	56	java/lang/Exception
    //   47	52	56	java/lang/Exception
    //   54	56	56	java/lang/Exception
    //   85	90	56	java/lang/Exception
    //   5	22	101	finally
    //   24	29	115	finally
    //   35	45	115	finally
    //   47	52	115	finally
    //   54	56	115	finally
    //   59	71	115	finally
    //   85	90	115	finally
    //   5	22	119	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.e.m
 * JD-Core Version:    0.7.0.1
 */