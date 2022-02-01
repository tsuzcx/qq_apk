package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class i
{
  private static String jYK;
  public static b jYL;
  public static Context sContext;
  
  /* Error */
  private static String I(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 15
    //   11: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: ldc 26
    //   19: invokevirtual 32	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   22: checkcast 34	android/app/ActivityManager
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +75 -> 102
    //   30: aload_0
    //   31: invokevirtual 38	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnull +66 -> 102
    //   39: aload_0
    //   40: invokeinterface 44 1 0
    //   45: ifne +57 -> 102
    //   48: aload_0
    //   49: invokeinterface 48 1 0
    //   54: astore_0
    //   55: aload_0
    //   56: invokeinterface 53 1 0
    //   61: ifeq +41 -> 102
    //   64: aload_0
    //   65: invokeinterface 57 1 0
    //   70: checkcast 59	android/app/ActivityManager$RunningAppProcessInfo
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull -22 -> 55
    //   80: aload 4
    //   82: getfield 62	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   85: iload_1
    //   86: if_icmpne -31 -> 55
    //   89: aload 4
    //   91: getfield 65	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   94: astore_0
    //   95: ldc 15
    //   97: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: sipush 128
    //   105: newarray byte
    //   107: astore 5
    //   109: new 67	java/io/FileInputStream
    //   112: dup
    //   113: new 69	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 71
    //   119: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: iload_1
    //   123: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc 81
    //   128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   137: astore 4
    //   139: aload 4
    //   141: astore_0
    //   142: aload 4
    //   144: aload 5
    //   146: invokevirtual 93	java/io/FileInputStream:read	([B)I
    //   149: istore_3
    //   150: iload_3
    //   151: ifle +44 -> 195
    //   154: iconst_0
    //   155: istore_1
    //   156: goto +137 -> 293
    //   159: aload 4
    //   161: astore_0
    //   162: new 95	java/lang/String
    //   165: dup
    //   166: aload 5
    //   168: iconst_0
    //   169: iload_2
    //   170: invokespecial 98	java/lang/String:<init>	([BII)V
    //   173: astore 5
    //   175: aload 4
    //   177: invokevirtual 102	java/io/FileInputStream:close	()V
    //   180: ldc 15
    //   182: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 5
    //   187: areturn
    //   188: iload_1
    //   189: iconst_1
    //   190: iadd
    //   191: istore_1
    //   192: goto +101 -> 293
    //   195: aload 4
    //   197: invokevirtual 102	java/io/FileInputStream:close	()V
    //   200: ldc 15
    //   202: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aconst_null
    //   206: areturn
    //   207: astore 5
    //   209: aconst_null
    //   210: astore 4
    //   212: aload 4
    //   214: astore_0
    //   215: ldc 104
    //   217: ldc 106
    //   219: iconst_1
    //   220: anewarray 4	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload 5
    //   227: invokestatic 112	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 118	com/tencent/mm/ipcinvoker/h/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: aload 4
    //   236: ifnull -36 -> 200
    //   239: aload 4
    //   241: invokevirtual 102	java/io/FileInputStream:close	()V
    //   244: goto -44 -> 200
    //   247: astore_0
    //   248: goto -48 -> 200
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_0
    //   255: aload_0
    //   256: ifnull +7 -> 263
    //   259: aload_0
    //   260: invokevirtual 102	java/io/FileInputStream:close	()V
    //   263: ldc 15
    //   265: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload 4
    //   270: athrow
    //   271: astore_0
    //   272: goto -92 -> 180
    //   275: astore_0
    //   276: goto -76 -> 200
    //   279: astore_0
    //   280: goto -17 -> 263
    //   283: astore 4
    //   285: goto -30 -> 255
    //   288: astore 5
    //   290: goto -78 -> 212
    //   293: iload_3
    //   294: istore_2
    //   295: iload_1
    //   296: iload_3
    //   297: if_icmpge -138 -> 159
    //   300: aload 5
    //   302: iload_1
    //   303: baload
    //   304: sipush 128
    //   307: if_icmpgt +10 -> 317
    //   310: aload 5
    //   312: iload_1
    //   313: baload
    //   314: ifgt -126 -> 188
    //   317: iload_1
    //   318: istore_2
    //   319: goto -160 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramContext	Context
    //   0	322	1	paramInt	int
    //   169	150	2	i	int
    //   149	149	3	j	int
    //   73	167	4	localObject1	Object
    //   251	18	4	localObject2	Object
    //   283	1	4	localObject3	Object
    //   107	79	5	localObject4	Object
    //   207	19	5	localException1	java.lang.Exception
    //   288	23	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   109	139	207	java/lang/Exception
    //   239	244	247	java/lang/Exception
    //   109	139	251	finally
    //   175	180	271	java/lang/Exception
    //   195	200	275	java/lang/Exception
    //   259	263	279	java/lang/Exception
    //   142	150	283	finally
    //   162	175	283	finally
    //   215	234	283	finally
    //   142	150	288	java/lang/Exception
    //   162	175	288	java/lang/Exception
  }
  
  public static boolean Mo(String paramString)
  {
    AppMethodBeat.i(158732);
    if ((paramString != null) && (paramString.equals(aFr())))
    {
      AppMethodBeat.o(158732);
      return true;
    }
    AppMethodBeat.o(158732);
    return false;
  }
  
  public static String aFr()
  {
    AppMethodBeat.i(158733);
    if ((jYK == null) || (jYK.length() == 0)) {
      jYK = I(sContext, Process.myPid());
    }
    String str = jYK;
    AppMethodBeat.o(158733);
    return str;
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(158731);
    Assert.assertNotNull("IPCInvoker not initialize.", sContext);
    Context localContext = sContext;
    AppMethodBeat.o(158731);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.i
 * JD-Core Version:    0.7.0.1
 */