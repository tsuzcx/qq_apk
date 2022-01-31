package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import junit.framework.Assert;

public final class e
{
  private static String dGH;
  public static Context sContext;
  
  public static String BV()
  {
    if ((dGH == null) || (dGH.length() == 0)) {
      dGH = v(sContext, Process.myPid());
    }
    return dGH;
  }
  
  public static boolean fE(String paramString)
  {
    return (paramString != null) && (paramString.equals(BV()));
  }
  
  public static Context getContext()
  {
    Assert.assertNotNull("IPCInvoker not initialize.", sContext);
    return sContext;
  }
  
  /* Error */
  private static String v(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: ldc 52
    //   9: invokevirtual 58	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   12: checkcast 60	android/app/ActivityManager
    //   15: astore_0
    //   16: aload_0
    //   17: ifnull +63 -> 80
    //   20: aload_0
    //   21: invokevirtual 64	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +54 -> 80
    //   29: aload_0
    //   30: invokeinterface 70 1 0
    //   35: ifne +45 -> 80
    //   38: aload_0
    //   39: invokeinterface 74 1 0
    //   44: astore_0
    //   45: aload_0
    //   46: invokeinterface 79 1 0
    //   51: ifeq +29 -> 80
    //   54: aload_0
    //   55: invokeinterface 83 1 0
    //   60: checkcast 85	android/app/ActivityManager$RunningAppProcessInfo
    //   63: astore 4
    //   65: aload 4
    //   67: getfield 89	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   70: iload_1
    //   71: if_icmpne -26 -> 45
    //   74: aload 4
    //   76: getfield 92	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   79: areturn
    //   80: sipush 128
    //   83: newarray byte
    //   85: astore 5
    //   87: new 94	java/io/FileInputStream
    //   90: dup
    //   91: new 96	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 98
    //   97: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: iload_1
    //   101: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: ldc 108
    //   106: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   115: astore 4
    //   117: aload 4
    //   119: astore_0
    //   120: aload 4
    //   122: aload 5
    //   124: invokevirtual 119	java/io/FileInputStream:read	([B)I
    //   127: istore_3
    //   128: iload_3
    //   129: ifle +43 -> 172
    //   132: iconst_0
    //   133: istore_1
    //   134: goto +122 -> 256
    //   137: aload 4
    //   139: astore_0
    //   140: new 14	java/lang/String
    //   143: dup
    //   144: aload 5
    //   146: iconst_0
    //   147: iload_2
    //   148: invokespecial 122	java/lang/String:<init>	([BII)V
    //   151: astore 5
    //   153: aload 4
    //   155: invokevirtual 126	java/io/FileInputStream:close	()V
    //   158: aload 5
    //   160: areturn
    //   161: astore_0
    //   162: aload 5
    //   164: areturn
    //   165: iload_1
    //   166: iconst_1
    //   167: iadd
    //   168: istore_1
    //   169: goto +87 -> 256
    //   172: aload 4
    //   174: invokevirtual 126	java/io/FileInputStream:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore 5
    //   181: aconst_null
    //   182: astore 4
    //   184: aload 4
    //   186: astore_0
    //   187: ldc 128
    //   189: ldc 130
    //   191: iconst_1
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload 5
    //   199: invokestatic 136	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 142	com/tencent/mm/ipcinvoker/h/b:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: aload 4
    //   208: ifnull -31 -> 177
    //   211: aload 4
    //   213: invokevirtual 126	java/io/FileInputStream:close	()V
    //   216: goto -39 -> 177
    //   219: astore_0
    //   220: goto -43 -> 177
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: ifnull +7 -> 235
    //   231: aload_0
    //   232: invokevirtual 126	java/io/FileInputStream:close	()V
    //   235: aload 4
    //   237: athrow
    //   238: astore_0
    //   239: goto -62 -> 177
    //   242: astore_0
    //   243: goto -8 -> 235
    //   246: astore 4
    //   248: goto -21 -> 227
    //   251: astore 5
    //   253: goto -69 -> 184
    //   256: iload_3
    //   257: istore_2
    //   258: iload_1
    //   259: iload_3
    //   260: if_icmpge -123 -> 137
    //   263: aload 5
    //   265: iload_1
    //   266: baload
    //   267: sipush 128
    //   270: if_icmpgt +10 -> 280
    //   273: aload 5
    //   275: iload_1
    //   276: baload
    //   277: ifgt -112 -> 165
    //   280: iload_1
    //   281: istore_2
    //   282: goto -145 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	Context
    //   0	285	1	paramInt	int
    //   147	135	2	i	int
    //   127	134	3	j	int
    //   63	149	4	localObject1	Object
    //   223	13	4	localObject2	Object
    //   246	1	4	localObject3	Object
    //   85	78	5	localObject4	Object
    //   179	19	5	localException1	java.lang.Exception
    //   251	23	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   153	158	161	java/lang/Exception
    //   87	117	179	java/lang/Exception
    //   211	216	219	java/lang/Exception
    //   87	117	223	finally
    //   172	177	238	java/lang/Exception
    //   231	235	242	java/lang/Exception
    //   120	128	246	finally
    //   140	153	246	finally
    //   187	206	246	finally
    //   120	128	251	java/lang/Exception
    //   140	153	251	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.e
 * JD-Core Version:    0.7.0.1
 */