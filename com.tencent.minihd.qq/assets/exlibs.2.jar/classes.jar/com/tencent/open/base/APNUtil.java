package com.tencent.open.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public class APNUtil
{
  public static final int a = 1;
  protected static Uri a;
  protected static final String a;
  public static final int b = 2;
  public static final String b = "wifi";
  public static final int c = 4;
  public static final String c = "cmwap";
  public static final int d = 8;
  public static final String d = "cmnet";
  public static final int e = 16;
  public static final String e = "uniwap";
  public static final int f = 32;
  public static final String f = "uninet";
  public static final int g = 64;
  public static final String g = "wap";
  public static final int h = 128;
  public static final String h = "net";
  public static final int i = 256;
  public static final String i = "ctwap";
  public static final int j = 512;
  public static final String j = "ctnet";
  public static final int k = 1024;
  public static final String k = "none";
  public static final int l = 2048;
  public static final String l = "3gnet";
  public static final String m = "3gwap";
  public static final String n = "unconnect";
  public static final String o = "unknown";
  public static final String p = "wifi";
  public static final String q = "2g";
  public static final String r = "3g";
  public static final String s = "4g";
  public static final String t = "apn";
  public static final String u = "proxy";
  public static final String v = "port";
  
  static
  {
    jdField_a_of_type_JavaLangString = APNUtil.class.getName();
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  }
  
  /* Error */
  public static int a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 101	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 120	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_3
    //   15: aload_3
    //   16: ifnonnull +17 -> 33
    //   19: aload_3
    //   20: ifnull +9 -> 29
    //   23: aload_3
    //   24: invokeinterface 125 1 0
    //   29: iconst_m1
    //   30: istore_1
    //   31: iload_1
    //   32: ireturn
    //   33: aload_3
    //   34: astore_0
    //   35: aload_3
    //   36: invokeinterface 129 1 0
    //   41: pop
    //   42: aload_3
    //   43: astore_0
    //   44: aload_3
    //   45: aload_3
    //   46: ldc 81
    //   48: invokeinterface 133 2 0
    //   53: invokeinterface 137 2 0
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: aload_3
    //   62: ifnull -31 -> 31
    //   65: aload_3
    //   66: invokeinterface 125 1 0
    //   71: iload_2
    //   72: ireturn
    //   73: astore 4
    //   75: aconst_null
    //   76: astore_3
    //   77: aload_3
    //   78: astore_0
    //   79: aload 4
    //   81: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   84: aload_3
    //   85: ifnull +9 -> 94
    //   88: aload_3
    //   89: invokeinterface 125 1 0
    //   94: iconst_m1
    //   95: ireturn
    //   96: astore_3
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: ifnull +9 -> 109
    //   103: aload_0
    //   104: invokeinterface 125 1 0
    //   109: aload_3
    //   110: athrow
    //   111: astore_3
    //   112: goto -13 -> 99
    //   115: astore 4
    //   117: goto -40 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   30	31	1	i1	int
    //   58	14	2	i2	int
    //   14	75	3	localCursor	android.database.Cursor
    //   96	14	3	localObject1	Object
    //   111	1	3	localObject2	Object
    //   73	7	4	localException1	Exception
    //   115	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	15	73	java/lang/Exception
    //   0	15	96	finally
    //   35	42	111	finally
    //   44	59	111	finally
    //   79	84	111	finally
    //   35	42	115	java/lang/Exception
    //   44	59	115	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    int i1 = b(paramContext);
    if (i1 == 2) {
      paramContext = "wifi";
    }
    String str;
    do
    {
      return paramContext;
      if (i1 == 1) {
        return "cmwap";
      }
      if (i1 == 4) {
        return "cmnet";
      }
      if (i1 == 16) {
        return "uniwap";
      }
      if (i1 == 8) {
        return "uninet";
      }
      if (i1 == 64) {
        return "wap";
      }
      if (i1 == 32) {
        return "net";
      }
      if (i1 == 512) {
        return "ctwap";
      }
      if (i1 == 256) {
        return "ctnet";
      }
      if (i1 == 2048) {
        return "3gnet";
      }
      if (i1 == 1024) {
        return "3gwap";
      }
      str = b(paramContext);
      if (str == null) {
        break;
      }
      paramContext = str;
    } while (str.length() != 0);
    return "none";
  }
  
  public static boolean a(Context paramContext)
  {
    int i1 = b(paramContext);
    return (i1 == 1) || (i1 == 16) || (i1 == 64) || (i1 == 512) || (i1 == 1024);
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return 128;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 128;
      }
      if (((NetworkInfo)localObject).getTypeName().toUpperCase().equals("WIFI")) {
        return 2;
      }
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      if (((String)localObject).startsWith("cmwap")) {
        return 1;
      }
      if ((((String)localObject).startsWith("cmnet")) || (((String)localObject).startsWith("epc.tmobile.com"))) {
        break label232;
      }
      if (((String)localObject).startsWith("uniwap")) {
        return 16;
      }
      if (((String)localObject).startsWith("uninet")) {
        return 8;
      }
      if (((String)localObject).startsWith("wap")) {
        return 64;
      }
      if (((String)localObject).startsWith("net")) {
        return 32;
      }
      if (((String)localObject).startsWith("ctwap")) {
        return 512;
      }
      if (((String)localObject).startsWith("ctnet")) {
        return 256;
      }
      if (((String)localObject).startsWith("3gwap")) {
        return 1024;
      }
      if (((String)localObject).startsWith("3gnet")) {
        return 2048;
      }
      if (((String)localObject).startsWith("#777"))
      {
        paramContext = c(paramContext);
        if (paramContext != null)
        {
          int i1 = paramContext.length();
          if (i1 > 0) {
            return 512;
          }
        }
        return 256;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 128;
    label232:
    return 4;
  }
  
  /* Error */
  public static String b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 101	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 120	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 125 1 0
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 129 1 0
    //   41: pop
    //   42: aload_0
    //   43: ldc 75
    //   45: invokeinterface 133 2 0
    //   50: istore_1
    //   51: iconst_m1
    //   52: iload_1
    //   53: if_icmpeq +25 -> 78
    //   56: aload_0
    //   57: iload_1
    //   58: invokeinterface 198 2 0
    //   63: astore_3
    //   64: aload_3
    //   65: astore_2
    //   66: aload_0
    //   67: ifnull -34 -> 33
    //   70: aload_0
    //   71: invokeinterface 125 1 0
    //   76: aload_3
    //   77: areturn
    //   78: ldc 200
    //   80: astore_2
    //   81: aload_0
    //   82: ifnull -49 -> 33
    //   85: aload_0
    //   86: invokeinterface 125 1 0
    //   91: ldc 200
    //   93: areturn
    //   94: astore_3
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   103: aload_0
    //   104: ifnull +9 -> 113
    //   107: aload_0
    //   108: invokeinterface 125 1 0
    //   113: ldc 200
    //   115: areturn
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: ifnull +9 -> 129
    //   123: aload_0
    //   124: invokeinterface 125 1 0
    //   129: aload_2
    //   130: athrow
    //   131: astore_2
    //   132: goto -13 -> 119
    //   135: astore_2
    //   136: goto -17 -> 119
    //   139: astore_2
    //   140: goto -41 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   50	8	1	i1	int
    //   1	99	2	localObject1	Object
    //   116	14	2	localObject2	Object
    //   131	1	2	localObject3	Object
    //   135	1	2	localObject4	Object
    //   139	1	2	localException1	Exception
    //   63	14	3	str	String
    //   94	4	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	94	java/lang/Exception
    //   2	17	116	finally
    //   35	51	131	finally
    //   56	64	131	finally
    //   99	103	135	finally
    //   35	51	139	java/lang/Exception
    //   56	64	139	java/lang/Exception
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 101	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 120	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 125 1 0
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 129 1 0
    //   41: pop
    //   42: aload_0
    //   43: aload_0
    //   44: ldc 78
    //   46: invokeinterface 133 2 0
    //   51: invokeinterface 198 2 0
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_0
    //   60: ifnull -27 -> 33
    //   63: aload_0
    //   64: invokeinterface 125 1 0
    //   69: aload_2
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   80: aload_0
    //   81: ifnull +9 -> 90
    //   84: aload_0
    //   85: invokeinterface 125 1 0
    //   90: ldc 200
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 125 1 0
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -13 -> 96
    //   112: astore_1
    //   113: goto -17 -> 96
    //   116: astore_1
    //   117: goto -41 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   1	76	1	localObject1	Object
    //   93	14	1	localObject2	Object
    //   108	1	1	localObject3	Object
    //   112	1	1	localObject4	Object
    //   116	1	1	localException1	Exception
    //   56	14	2	str	String
    //   71	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	71	java/lang/Exception
    //   2	17	93	finally
    //   35	57	108	finally
    //   76	80	112	finally
    //   35	57	116	java/lang/Exception
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 114	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 101	com/tencent/open/base/APNUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 120	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnonnull +17 -> 35
    //   21: aload_0
    //   22: ifnull +9 -> 31
    //   25: aload_0
    //   26: invokeinterface 125 1 0
    //   31: aconst_null
    //   32: astore_2
    //   33: aload_2
    //   34: areturn
    //   35: aload_0
    //   36: invokeinterface 129 1 0
    //   41: pop
    //   42: aload_0
    //   43: invokeinterface 209 1 0
    //   48: ifeq +29 -> 77
    //   51: aload_0
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: invokeinterface 125 1 0
    //   61: ldc 211
    //   63: astore_2
    //   64: aload_0
    //   65: ifnull -32 -> 33
    //   68: aload_0
    //   69: invokeinterface 125 1 0
    //   74: ldc 211
    //   76: areturn
    //   77: aload_0
    //   78: aload_0
    //   79: ldc 81
    //   81: invokeinterface 133 2 0
    //   86: invokeinterface 198 2 0
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: ifnonnull +6 -> 101
    //   98: ldc 211
    //   100: astore_1
    //   101: aload_1
    //   102: astore_2
    //   103: aload_0
    //   104: ifnull -71 -> 33
    //   107: aload_0
    //   108: invokeinterface 125 1 0
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 140	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +9 -> 134
    //   128: aload_0
    //   129: invokeinterface 125 1 0
    //   134: ldc 211
    //   136: areturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +9 -> 150
    //   144: aload_0
    //   145: invokeinterface 125 1 0
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -13 -> 140
    //   156: astore_1
    //   157: goto -17 -> 140
    //   160: astore_1
    //   161: goto -41 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramContext	Context
    //   1	120	1	localObject1	Object
    //   137	14	1	localObject2	Object
    //   152	1	1	localObject3	Object
    //   156	1	1	localObject4	Object
    //   160	1	1	localException1	Exception
    //   32	71	2	localObject5	Object
    //   115	4	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	17	115	java/lang/Exception
    //   2	17	137	finally
    //   35	51	152	finally
    //   55	61	152	finally
    //   77	92	152	finally
    //   120	124	156	finally
    //   35	51	160	java/lang/Exception
    //   55	61	160	java/lang/Exception
    //   77	92	160	java/lang/Exception
  }
  
  public static boolean d(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return true;
      }
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i1 = 0;
        while (i1 < paramContext.length)
        {
          boolean bool = paramContext[i1].isConnectedOrConnecting();
          if (bool) {
            return true;
          }
          i1 += 1;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      LogUtility.c(jdField_a_of_type_JavaLangString, "checkNetWork Exception", paramContext);
    }
  }
  
  public static String e(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "MOBILE";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.getTypeName();
    }
    return "MOBILE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.base.APNUtil
 * JD-Core Version:    0.7.0.1
 */