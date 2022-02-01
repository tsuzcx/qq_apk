package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SecurityUtile
{
  private static int jdField_a_of_type_Int = 4;
  private static final String jdField_a_of_type_JavaLangString = "kc";
  private static byte[] jdField_a_of_type_ArrayOfByte;
  private static char[] jdField_a_of_type_ArrayOfChar = { 0, 1, 0, 1 };
  private static volatile int b = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[] { 0, 1, 0, 1 };
  }
  
  private static String a(Context paramContext)
  {
    paramContext = paramContext.openFileInput("kc");
    byte[] arrayOfByte = new byte[paramContext.available()];
    paramContext.read(arrayOfByte);
    paramContext.close();
    return new String(arrayOfByte, "UTF-8");
  }
  
  public static String a(String paramString)
  {
    return c(paramString);
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 10
    //   8: monitorenter
    //   9: aload_0
    //   10: invokestatic 67	com/tencent/mobileqq/utils/SecurityUtile:a	(Landroid/content/Context;)Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +54 -> 69
    //   18: aload_0
    //   19: invokestatic 69	com/tencent/mobileqq/utils/SecurityUtile:a	(Landroid/content/Context;)Ljava/lang/String;
    //   22: astore 6
    //   24: aload 6
    //   26: ifnull +23 -> 49
    //   29: aload 6
    //   31: astore 4
    //   33: aload 6
    //   35: astore 5
    //   37: aload 6
    //   39: invokevirtual 72	java/lang/String:length	()I
    //   42: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   45: arraylength
    //   46: if_icmpge +23 -> 69
    //   49: aload 6
    //   51: astore 5
    //   53: ldc2_w 73
    //   56: invokestatic 80	java/lang/Thread:sleep	(J)V
    //   59: aload 6
    //   61: astore 5
    //   63: aload_0
    //   64: invokestatic 69	com/tencent/mobileqq/utils/SecurityUtile:a	(Landroid/content/Context;)Ljava/lang/String;
    //   67: astore 4
    //   69: aload 4
    //   71: ifnull +19 -> 90
    //   74: aload 4
    //   76: astore 5
    //   78: aload 4
    //   80: invokevirtual 72	java/lang/String:length	()I
    //   83: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   86: arraylength
    //   87: if_icmpge +150 -> 237
    //   90: aload_0
    //   91: ldc 82
    //   93: iconst_0
    //   94: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   97: ldc 88
    //   99: aconst_null
    //   100: invokeinterface 94 3 0
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +19 -> 128
    //   112: aload 4
    //   114: invokevirtual 72	java/lang/String:length	()I
    //   117: istore_1
    //   118: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   121: arraylength
    //   122: istore_2
    //   123: iload_1
    //   124: iload_2
    //   125: if_icmpge +211 -> 336
    //   128: ldc 96
    //   130: invokestatic 100	com/tencent/util/QQDeviceInfo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   133: astore 5
    //   135: aload 5
    //   137: astore 4
    //   139: getstatic 105	android/os/Build$VERSION:SDK_INT	I
    //   142: bipush 23
    //   144: if_icmplt +112 -> 256
    //   147: aload 5
    //   149: astore 4
    //   151: aload_0
    //   152: ldc 107
    //   154: invokevirtual 111	android/content/Context:checkSelfPermission	(Ljava/lang/String;)I
    //   157: ifne +172 -> 329
    //   160: aload 5
    //   162: ifnull +19 -> 181
    //   165: aload 5
    //   167: astore 4
    //   169: aload 5
    //   171: invokevirtual 72	java/lang/String:length	()I
    //   174: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   177: arraylength
    //   178: if_icmpge +151 -> 329
    //   181: aload 5
    //   183: astore 4
    //   185: aload_0
    //   186: ldc 113
    //   188: invokevirtual 117	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   191: checkcast 119	android/net/wifi/WifiManager
    //   194: invokevirtual 123	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   197: invokevirtual 129	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   200: astore 5
    //   202: aload 5
    //   204: astore 4
    //   206: aload 4
    //   208: ifnull +19 -> 227
    //   211: aload 4
    //   213: astore 5
    //   215: aload 4
    //   217: invokevirtual 72	java/lang/String:length	()I
    //   220: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   223: arraylength
    //   224: if_icmpge +7 -> 231
    //   227: ldc 131
    //   229: astore 5
    //   231: aload_0
    //   232: aload 5
    //   234: invokestatic 134	com/tencent/mobileqq/utils/SecurityUtile:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   237: aload 5
    //   239: invokevirtual 138	java/lang/String:toCharArray	()[C
    //   242: putstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   245: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   248: arraylength
    //   249: putstatic 24	com/tencent/mobileqq/utils/SecurityUtile:b	I
    //   252: ldc 10
    //   254: monitorexit
    //   255: return
    //   256: aload 5
    //   258: ifnull +19 -> 277
    //   261: aload 5
    //   263: astore 4
    //   265: aload 5
    //   267: invokevirtual 72	java/lang/String:length	()I
    //   270: getstatic 18	com/tencent/mobileqq/utils/SecurityUtile:jdField_a_of_type_ArrayOfChar	[C
    //   273: arraylength
    //   274: if_icmpge +55 -> 329
    //   277: aload 5
    //   279: astore 4
    //   281: aload_0
    //   282: ldc 113
    //   284: invokevirtual 117	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   287: checkcast 119	android/net/wifi/WifiManager
    //   290: invokevirtual 123	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   293: invokevirtual 129	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   296: astore 5
    //   298: aload 5
    //   300: astore 4
    //   302: goto -96 -> 206
    //   305: astore 5
    //   307: goto -101 -> 206
    //   310: astore_0
    //   311: ldc 10
    //   313: monitorexit
    //   314: aload_0
    //   315: athrow
    //   316: astore_0
    //   317: goto -80 -> 237
    //   320: astore 4
    //   322: aload 5
    //   324: astore 4
    //   326: goto -257 -> 69
    //   329: aload 5
    //   331: astore 4
    //   333: goto -127 -> 206
    //   336: aload 4
    //   338: astore 5
    //   340: goto -109 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	paramContext	Context
    //   117	9	1	i	int
    //   122	4	2	j	int
    //   13	2	3	bool	boolean
    //   4	297	4	localObject1	Object
    //   320	1	4	localException1	java.lang.Exception
    //   324	13	4	localException2	java.lang.Exception
    //   1	298	5	localObject2	Object
    //   305	25	5	localException3	java.lang.Exception
    //   338	1	5	localObject3	Object
    //   22	38	6	str	String
    // Exception table:
    //   from	to	target	type
    //   128	135	305	java/lang/Exception
    //   139	147	305	java/lang/Exception
    //   151	160	305	java/lang/Exception
    //   169	181	305	java/lang/Exception
    //   185	202	305	java/lang/Exception
    //   265	277	305	java/lang/Exception
    //   281	298	305	java/lang/Exception
    //   9	14	310	finally
    //   18	24	310	finally
    //   37	49	310	finally
    //   53	59	310	finally
    //   63	69	310	finally
    //   78	90	310	finally
    //   90	107	310	finally
    //   112	123	310	finally
    //   128	135	310	finally
    //   139	147	310	finally
    //   151	160	310	finally
    //   169	181	310	finally
    //   185	202	310	finally
    //   215	227	310	finally
    //   231	237	310	finally
    //   237	255	310	finally
    //   265	277	310	finally
    //   281	298	310	finally
    //   311	314	310	finally
    //   231	237	316	java/io/IOException
    //   18	24	320	java/lang/Exception
    //   37	49	320	java/lang/Exception
    //   53	59	320	java/lang/Exception
    //   63	69	320	java/lang/Exception
  }
  
  private static void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.openFileOutput("kc", 0);
    paramContext.write(paramString.getBytes("UTF-8"));
    paramContext.close();
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int i = 0;
      while (i < paramInt2)
      {
        paramArrayOfByte[(i + paramInt1)] = ((byte)(paramArrayOfByte[(i + paramInt1)] ^ jdField_a_of_type_ArrayOfChar[((int)((i + paramLong) % b))]));
        i += 1;
      }
    }
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramArrayOfByte == null) || (paramLong >= paramInt3)) {
      return;
    }
    paramInt3 = (int)(paramInt3 - paramLong);
    if (paramInt3 > paramInt2) {}
    for (;;)
    {
      paramInt3 = 0;
      while (paramInt3 < paramInt2)
      {
        paramArrayOfByte[(paramInt3 + paramInt1)] = ((byte)(paramArrayOfByte[(paramInt3 + paramInt1)] ^ jdField_a_of_type_ArrayOfByte[((int)((paramInt3 + paramLong) % jdField_a_of_type_Int))]));
        paramInt3 += 1;
      }
      break;
      paramInt2 = paramInt3;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    return (paramContext.getFileStreamPath("kc") != null) && (paramContext.getFileStreamPath("kc").exists());
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (b == 0) {
        a(BaseApplicationImpl.getContext());
      }
      int j = paramArrayOfByte.length;
      arrayOfByte = new byte[j];
      int i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfChar[((i + paramInt) % b)]));
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    return c(paramString);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ jdField_a_of_type_ArrayOfByte[(i % jdField_a_of_type_Int)]));
        i += 1;
      }
    }
    return paramArrayOfByte;
  }
  
  private static String c(String paramString)
  {
    int i = 0;
    int j = 0;
    if (paramString == null) {
      return null;
    }
    if (b == 0) {
      a(BaseApplicationImpl.getContext());
    }
    paramString = paramString.toCharArray();
    char[] arrayOfChar = new char[paramString.length];
    if (b >= paramString.length)
    {
      i = j;
      while (i < paramString.length)
      {
        arrayOfChar[i] = ((char)(paramString[i] ^ jdField_a_of_type_ArrayOfChar[i]));
        i += 1;
      }
    }
    while (i < paramString.length)
    {
      arrayOfChar[i] = ((char)(paramString[i] ^ jdField_a_of_type_ArrayOfChar[(i % b)]));
      i += 1;
    }
    if (arrayOfChar.length == 0) {
      return "";
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SecurityUtile
 * JD-Core Version:    0.7.0.1
 */