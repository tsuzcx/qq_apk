package cooperation.qzone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.HashMap;

public class QZoneNetworkUtil
{
  private static final Uri jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
  public static final String a = "wifi";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap.put("cmwap", new QZoneNetworkUtil.NetworkProxy("10.0.0.172", 80));
    jdField_a_of_type_JavaUtilHashMap.put("3gwap", new QZoneNetworkUtil.NetworkProxy("10.0.0.172", 80));
    jdField_a_of_type_JavaUtilHashMap.put("uniwap", new QZoneNetworkUtil.NetworkProxy("10.0.0.172", 80));
    jdField_a_of_type_JavaUtilHashMap.put("ctwap", new QZoneNetworkUtil.NetworkProxy("10.0.0.200", 80));
  }
  
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      i = Proxy.getDefaultPort();
    }
    do
    {
      return i;
      paramContext = System.getProperty("http.proxyPort");
    } while (a(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static QZoneNetworkUtil.NetworkProxy a(Context paramContext)
  {
    if (!a(paramContext)) {}
    String str;
    int i;
    do
    {
      return null;
      str = b(paramContext);
      i = a(paramContext);
    } while ((a(str)) || (i < 0));
    return new QZoneNetworkUtil.NetworkProxy(str, i);
  }
  
  public static QZoneNetworkUtil.NetworkProxy a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return a(paramContext);
    }
    return b(paramContext);
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokestatic 121	cooperation/qzone/QZoneNetworkUtil:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: aload 4
    //   17: invokevirtual 126	android/net/NetworkInfo:getType	()I
    //   20: iconst_1
    //   21: if_icmpne +19 -> 40
    //   24: ldc 9
    //   26: astore_0
    //   27: aload_0
    //   28: astore_1
    //   29: aload_0
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: invokevirtual 132	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: aload 4
    //   42: invokestatic 135	cooperation/qzone/QZoneNetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   45: ifeq +165 -> 210
    //   48: getstatic 61	android/os/Build$VERSION:SDK_INT	I
    //   51: bipush 17
    //   53: if_icmpge +152 -> 205
    //   56: aload_0
    //   57: invokevirtual 139	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: getstatic 22	cooperation/qzone/QZoneNetworkUtil:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 145	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_2
    //   76: ifnull +32 -> 108
    //   79: aload_2
    //   80: invokeinterface 151 1 0
    //   85: ifeq +23 -> 108
    //   88: aload_2
    //   89: aload_2
    //   90: ldc 153
    //   92: invokeinterface 156 2 0
    //   97: invokeinterface 160 2 0
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: goto -30 -> 75
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: ifnull +11 -> 122
    //   114: aload_2
    //   115: invokeinterface 163 1 0
    //   120: aload_0
    //   121: astore_1
    //   122: aload_1
    //   123: astore_0
    //   124: aload_1
    //   125: invokestatic 169	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   128: ifeq -101 -> 27
    //   131: aload 4
    //   133: invokevirtual 172	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   136: astore_0
    //   137: goto -110 -> 27
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_3
    //   143: aload_2
    //   144: astore_0
    //   145: aload_3
    //   146: astore_2
    //   147: aload_1
    //   148: invokevirtual 173	java/lang/Throwable:printStackTrace	()V
    //   151: aload_2
    //   152: astore_1
    //   153: aload_0
    //   154: ifnull -32 -> 122
    //   157: aload_0
    //   158: invokeinterface 163 1 0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -43 -> 122
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 163 1 0
    //   181: aload_0
    //   182: athrow
    //   183: astore_0
    //   184: goto -13 -> 171
    //   187: astore_1
    //   188: aload_0
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: goto -21 -> 171
    //   195: astore_1
    //   196: aload_2
    //   197: astore_3
    //   198: aload_0
    //   199: astore_2
    //   200: aload_3
    //   201: astore_0
    //   202: goto -55 -> 147
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -85 -> 122
    //   210: aconst_null
    //   211: astore_0
    //   212: goto -185 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramContext	Context
    //   28	97	1	localObject1	Object
    //   140	8	1	localThrowable1	java.lang.Throwable
    //   152	13	1	localObject2	Object
    //   187	4	1	localObject3	Object
    //   195	1	1	localThrowable2	java.lang.Throwable
    //   206	1	1	localObject4	Object
    //   1	199	2	localObject5	Object
    //   142	59	3	localObject6	Object
    //   6	126	4	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   56	71	140	java/lang/Throwable
    //   56	71	168	finally
    //   79	103	183	finally
    //   147	151	187	finally
    //   79	103	195	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (a(paramContext))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(NetworkInfo paramNetworkInfo)
  {
    return (paramNetworkInfo.getType() == 0) || (50 == paramNetworkInfo.getType());
  }
  
  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static QZoneNetworkUtil.NetworkProxy b(Context paramContext)
  {
    if (!a(paramContext)) {
      return null;
    }
    paramContext = a(paramContext);
    paramContext = (QZoneNetworkUtil.NetworkProxy)jdField_a_of_type_JavaUtilHashMap.get(paramContext);
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.a()) {
      return paramContext;
    }
  }
  
  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneNetworkUtil
 * JD-Core Version:    0.7.0.1
 */