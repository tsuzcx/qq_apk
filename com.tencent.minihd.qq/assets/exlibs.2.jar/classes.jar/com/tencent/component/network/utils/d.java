package com.tencent.component.network.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class d
{
  private static Class jdField_a_of_type_JavaLangClass;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  
  static
  {
    try
    {
      jdField_a_of_type_JavaLangClass = Class.forName("android.os.SystemProperties");
      jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str1;
    do
    {
      return paramString2;
      String str2 = b(paramString1, null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = c(paramString1, null);
      }
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  private static String b(String paramString1, String paramString2)
  {
    if ((jdField_a_of_type_JavaLangClass == null) || (jdField_a_of_type_JavaLangReflectMethod == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)jdField_a_of_type_JavaLangReflectMethod.invoke(jdField_a_of_type_JavaLangClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return paramString2;
  }
  
  /* Error */
  private static String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: invokestatic 59	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 61	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   12: ldc 66
    //   14: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 78	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 4
    //   32: new 80	java/io/BufferedReader
    //   35: dup
    //   36: new 82	java/io/InputStreamReader
    //   39: dup
    //   40: aload 5
    //   42: invokevirtual 88	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   45: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_0
    //   52: new 61	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_0
    //   61: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +33 -> 101
    //   71: aload_3
    //   72: aload 4
    //   74: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -18 -> 60
    //   81: astore_3
    //   82: aload_0
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: astore_3
    //   88: aload_0
    //   89: invokevirtual 100	java/io/BufferedReader:close	()V
    //   92: aload_1
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 103	java/lang/Process:destroy	()V
    //   99: aload_0
    //   100: areturn
    //   101: aload_3
    //   102: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_3
    //   106: aload_3
    //   107: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore_2
    //   111: iload_2
    //   112: ifne +5 -> 117
    //   115: aload_3
    //   116: astore_1
    //   117: aload_0
    //   118: ifnull +53 -> 171
    //   121: aload_1
    //   122: astore_3
    //   123: aload_0
    //   124: invokevirtual 100	java/io/BufferedReader:close	()V
    //   127: goto +44 -> 171
    //   130: aload 4
    //   132: ifnull +10 -> 142
    //   135: aload_1
    //   136: astore_3
    //   137: aload 4
    //   139: invokevirtual 100	java/io/BufferedReader:close	()V
    //   142: aload_1
    //   143: astore_3
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: aload_3
    //   148: areturn
    //   149: astore_1
    //   150: aload_0
    //   151: areturn
    //   152: astore 4
    //   154: aload_0
    //   155: astore_3
    //   156: aload 4
    //   158: astore_0
    //   159: aload_3
    //   160: astore 4
    //   162: goto -32 -> 130
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_0
    //   168: goto -86 -> 82
    //   171: aload_1
    //   172: astore_0
    //   173: goto -79 -> 94
    //   176: astore_0
    //   177: goto -47 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramString1	String
    //   0	180	1	paramString2	String
    //   110	2	2	bool	boolean
    //   1	71	3	localObject1	Object
    //   81	1	3	localIOException	java.io.IOException
    //   87	73	3	str1	String
    //   30	108	4	str2	String
    //   152	5	4	localObject2	Object
    //   160	1	4	str3	String
    //   27	68	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   52	60	81	java/io/IOException
    //   60	66	81	java/io/IOException
    //   71	78	81	java/io/IOException
    //   101	111	81	java/io/IOException
    //   2	29	146	java/lang/Throwable
    //   88	92	146	java/lang/Throwable
    //   123	127	146	java/lang/Throwable
    //   137	142	146	java/lang/Throwable
    //   144	146	146	java/lang/Throwable
    //   94	99	149	java/lang/Throwable
    //   52	60	152	finally
    //   60	66	152	finally
    //   71	78	152	finally
    //   101	111	152	finally
    //   32	52	165	java/io/IOException
    //   32	52	176	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.d
 * JD-Core Version:    0.7.0.1
 */