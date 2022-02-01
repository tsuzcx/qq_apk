package com.tencent.matrix.g;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class d
{
  private static final ThreadLocal<MessageDigest> cCV = new ThreadLocal()
  {
    private static MessageDigest Ia()
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
      }
    }
  };
  private static final ThreadLocal<MessageDigest> cCW = new ThreadLocal()
  {
    private static MessageDigest Ia()
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        return localMessageDigest;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException("Initialize SHA256-DIGEST failed.", localNoSuchAlgorithmException);
      }
    }
  };
  private static char[] hexDigits;
  private static String processName = null;
  
  static
  {
    hexDigits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static String dg(String paramString)
  {
    paramString = paramString.getBytes();
    paramString = ((MessageDigest)cCV.get()).digest(paramString);
    int j = paramString.length;
    StringBuffer localStringBuffer = new StringBuffer(j * 2);
    int i = 0;
    while (i < j + 0)
    {
      int k = paramString[i];
      char c1 = hexDigits[((k & 0xF0) >> 4)];
      char c2 = hexDigits[(k & 0xF)];
      localStringBuffer.append(c1);
      localStringBuffer.append(c2);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static long dk(String paramString)
  {
    try
    {
      if (paramString.length() <= 0) {
        return 0L;
      }
      long l = Long.decode(paramString).longValue();
      return l;
    }
    catch (NumberFormatException paramString)
    {
      c.printErrStackTrace("Matrix.MatrixUtil", paramString, "", new Object[0]);
    }
    return 0L;
  }
  
  public static String formatTime(String paramString, long paramLong)
  {
    return new SimpleDateFormat(paramString).format(new Date(paramLong));
  }
  
  public static String g(Exception paramException)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement == null) {
      return "";
    }
    paramException = new StringBuilder(paramException.toString());
    int i = 2;
    while (i < arrayOfStackTraceElement.length)
    {
      paramException.append('[');
      paramException.append(arrayOfStackTraceElement[i].getClassName());
      paramException.append(':');
      paramException.append(arrayOfStackTraceElement[i].getMethodName());
      paramException.append("(" + arrayOfStackTraceElement[i].getLineNumber() + ")]");
      paramException.append("\n");
      i += 1;
    }
    return paramException.toString();
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (processName != null) {
      return processName;
    }
    paramContext = getProcessNameInternal(paramContext);
    processName = paramContext;
    return paramContext;
  }
  
  /* Error */
  private static String getProcessNameInternal(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 182	android/os/Process:myPid	()I
    //   3: istore_1
    //   4: aload_0
    //   5: ifnull +7 -> 12
    //   8: iload_1
    //   9: ifgt +6 -> 15
    //   12: ldc 111
    //   14: areturn
    //   15: aload_0
    //   16: ldc 184
    //   18: invokevirtual 190	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   21: checkcast 192	android/app/ActivityManager
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +88 -> 114
    //   29: aload_0
    //   30: invokevirtual 196	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +79 -> 114
    //   38: aload_0
    //   39: invokeinterface 202 1 0
    //   44: astore 4
    //   46: aload 4
    //   48: invokeinterface 208 1 0
    //   53: ifeq +33 -> 86
    //   56: aload 4
    //   58: invokeinterface 211 1 0
    //   63: checkcast 213	android/app/ActivityManager$RunningAppProcessInfo
    //   66: astore_0
    //   67: aload_0
    //   68: getfield 217	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   71: istore_2
    //   72: iload_2
    //   73: iload_1
    //   74: if_icmpne -28 -> 46
    //   77: aload_0
    //   78: ifnull +36 -> 114
    //   81: aload_0
    //   82: getfield 218	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   85: areturn
    //   86: aconst_null
    //   87: astore_0
    //   88: goto -11 -> 77
    //   91: astore_0
    //   92: new 143	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 220
    //   98: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aconst_null
    //   110: astore_0
    //   111: goto -34 -> 77
    //   114: sipush 128
    //   117: newarray byte
    //   119: astore 5
    //   121: new 225	java/io/FileInputStream
    //   124: dup
    //   125: new 143	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 227
    //   131: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: iload_1
    //   135: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc 229
    //   140: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 230	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   149: astore 4
    //   151: aload 4
    //   153: astore_0
    //   154: aload 4
    //   156: aload 5
    //   158: invokevirtual 234	java/io/FileInputStream:read	([B)I
    //   161: istore_3
    //   162: iload_3
    //   163: ifle +53 -> 216
    //   166: iconst_0
    //   167: istore_1
    //   168: goto +147 -> 315
    //   171: aload 4
    //   173: astore_0
    //   174: new 60	java/lang/String
    //   177: dup
    //   178: aload 5
    //   180: iconst_0
    //   181: iload_2
    //   182: ldc 236
    //   184: invokestatic 242	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   187: invokespecial 245	java/lang/String:<init>	([BIILjava/nio/charset/Charset;)V
    //   190: astore 5
    //   192: aload 4
    //   194: invokevirtual 246	java/io/FileInputStream:close	()V
    //   197: aload 5
    //   199: areturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   205: pop
    //   206: aload 5
    //   208: areturn
    //   209: iload_1
    //   210: iconst_1
    //   211: iadd
    //   212: istore_1
    //   213: goto +102 -> 315
    //   216: aload 4
    //   218: invokevirtual 246	java/io/FileInputStream:close	()V
    //   221: ldc 111
    //   223: areturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   229: pop
    //   230: goto -9 -> 221
    //   233: astore 5
    //   235: aconst_null
    //   236: astore 4
    //   238: aload 4
    //   240: astore_0
    //   241: new 143	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 220
    //   247: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: aload 5
    //   252: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   255: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 4
    //   261: ifnull -40 -> 221
    //   264: aload 4
    //   266: invokevirtual 246	java/io/FileInputStream:close	()V
    //   269: goto -48 -> 221
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   277: pop
    //   278: goto -57 -> 221
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_0
    //   285: aload_0
    //   286: ifnull +7 -> 293
    //   289: aload_0
    //   290: invokevirtual 246	java/io/FileInputStream:close	()V
    //   293: aload 4
    //   295: athrow
    //   296: astore_0
    //   297: aload_0
    //   298: invokevirtual 223	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   301: pop
    //   302: goto -9 -> 293
    //   305: astore 4
    //   307: goto -22 -> 285
    //   310: astore 5
    //   312: goto -74 -> 238
    //   315: iload_3
    //   316: istore_2
    //   317: iload_1
    //   318: iload_3
    //   319: if_icmpge -148 -> 171
    //   322: aload 5
    //   324: iload_1
    //   325: baload
    //   326: ifgt -117 -> 209
    //   329: iload_1
    //   330: istore_2
    //   331: goto -160 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   3	327	1	i	int
    //   71	260	2	j	int
    //   161	159	3	k	int
    //   44	221	4	localObject1	Object
    //   281	13	4	localObject2	Object
    //   305	1	4	localObject3	Object
    //   119	88	5	localObject4	Object
    //   233	18	5	localException1	Exception
    //   310	13	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   38	46	91	java/lang/Exception
    //   46	72	91	java/lang/Exception
    //   192	197	200	java/lang/Exception
    //   216	221	224	java/lang/Exception
    //   121	151	233	java/lang/Exception
    //   264	269	272	java/lang/Exception
    //   121	151	281	finally
    //   289	293	296	java/lang/Exception
    //   154	162	305	finally
    //   174	192	305	finally
    //   241	259	305	finally
    //   154	162	310	java/lang/Exception
    //   174	192	310	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.g.d
 * JD-Core Version:    0.7.0.1
 */