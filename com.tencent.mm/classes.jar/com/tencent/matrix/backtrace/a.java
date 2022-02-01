package com.tencent.matrix.backtrace;

import android.content.Context;
import android.os.Process;

public final class a
{
  private static String eMg = null;
  
  /* Error */
  private static String E(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: iload_1
    //   5: ifgt +6 -> 11
    //   8: ldc 17
    //   10: areturn
    //   11: aload_0
    //   12: ldc 19
    //   14: invokevirtual 25	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 27	android/app/ActivityManager
    //   20: invokevirtual 31	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   23: invokeinterface 37 1 0
    //   28: astore_0
    //   29: aload_0
    //   30: invokeinterface 43 1 0
    //   35: ifeq +53 -> 88
    //   38: aload_0
    //   39: invokeinterface 47 1 0
    //   44: checkcast 49	android/app/ActivityManager$RunningAppProcessInfo
    //   47: astore 4
    //   49: aload 4
    //   51: getfield 53	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   54: iload_1
    //   55: if_icmpne -26 -> 29
    //   58: aload 4
    //   60: getfield 56	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   63: ifnull -34 -> 29
    //   66: aload 4
    //   68: getfield 56	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   71: ldc 17
    //   73: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne -47 -> 29
    //   79: aload 4
    //   81: getfield 56	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: sipush 128
    //   91: newarray byte
    //   93: astore 5
    //   95: aconst_null
    //   96: astore 4
    //   98: new 64	java/io/BufferedInputStream
    //   101: dup
    //   102: new 66	java/io/FileInputStream
    //   105: dup
    //   106: new 68	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 70
    //   112: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: iload_1
    //   116: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc 80
    //   121: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 88	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   130: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_0
    //   134: aload_0
    //   135: aload 5
    //   137: invokevirtual 97	java/io/InputStream:read	([B)I
    //   140: istore_3
    //   141: iload_3
    //   142: ifle +39 -> 181
    //   145: iconst_0
    //   146: istore_1
    //   147: goto +105 -> 252
    //   150: new 58	java/lang/String
    //   153: dup
    //   154: aload 5
    //   156: iconst_0
    //   157: iload_2
    //   158: invokespecial 100	java/lang/String:<init>	([BII)V
    //   161: astore 4
    //   163: aload_0
    //   164: invokevirtual 103	java/io/InputStream:close	()V
    //   167: aload 4
    //   169: areturn
    //   170: astore_0
    //   171: aload 4
    //   173: areturn
    //   174: iload_1
    //   175: iconst_1
    //   176: iadd
    //   177: istore_1
    //   178: goto +74 -> 252
    //   181: aload_0
    //   182: invokevirtual 103	java/io/InputStream:close	()V
    //   185: ldc 17
    //   187: areturn
    //   188: astore_0
    //   189: aload 4
    //   191: astore_0
    //   192: aload_0
    //   193: ifnull -8 -> 185
    //   196: aload_0
    //   197: invokevirtual 103	java/io/InputStream:close	()V
    //   200: goto -15 -> 185
    //   203: astore_0
    //   204: goto -19 -> 185
    //   207: astore_0
    //   208: aconst_null
    //   209: astore 4
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 103	java/io/InputStream:close	()V
    //   221: aload_0
    //   222: athrow
    //   223: astore_0
    //   224: goto -39 -> 185
    //   227: astore 4
    //   229: goto -8 -> 221
    //   232: astore 4
    //   234: aload_0
    //   235: astore 5
    //   237: aload 4
    //   239: astore_0
    //   240: aload 5
    //   242: astore 4
    //   244: goto -33 -> 211
    //   247: astore 4
    //   249: goto -57 -> 192
    //   252: iload_3
    //   253: istore_2
    //   254: iload_1
    //   255: iload_3
    //   256: if_icmpge -106 -> 150
    //   259: aload 5
    //   261: iload_1
    //   262: baload
    //   263: sipush 128
    //   266: if_icmpgt +10 -> 276
    //   269: aload 5
    //   271: iload_1
    //   272: baload
    //   273: ifgt -99 -> 174
    //   276: iload_1
    //   277: istore_2
    //   278: goto -128 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramContext	Context
    //   0	281	1	paramInt	int
    //   157	121	2	i	int
    //   140	117	3	j	int
    //   47	170	4	localObject1	Object
    //   227	1	4	localException1	java.lang.Exception
    //   232	6	4	localObject2	Object
    //   242	1	4	localObject3	Object
    //   247	1	4	localException2	java.lang.Exception
    //   93	177	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	29	87	java/lang/Exception
    //   29	85	87	java/lang/Exception
    //   163	167	170	java/lang/Exception
    //   98	134	188	java/lang/Exception
    //   196	200	203	java/lang/Exception
    //   98	134	207	finally
    //   181	185	223	java/lang/Exception
    //   216	221	227	java/lang/Exception
    //   134	141	232	finally
    //   150	163	232	finally
    //   134	141	247	java/lang/Exception
    //   150	163	247	java/lang/Exception
  }
  
  public static String bD(Context paramContext)
  {
    try
    {
      if (eMg == null) {
        eMg = E(paramContext, Process.myPid());
      }
      paramContext = eMg;
      return paramContext;
    }
    finally {}
  }
  
  public static boolean bE(Context paramContext)
  {
    String str = bD(paramContext);
    return paramContext.getPackageName().equalsIgnoreCase(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.backtrace.a
 * JD-Core Version:    0.7.0.1
 */