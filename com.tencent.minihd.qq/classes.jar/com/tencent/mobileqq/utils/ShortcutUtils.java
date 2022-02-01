package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import kub;

public class ShortcutUtils
{
  private static final int jdField_a_of_type_Int = 3;
  static String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString = "QQUtils";
  
  static
  {
    jdField_b_of_type_Int = 0;
    a = null;
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName(paramActivity, paramString);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.addFlags(2097152);
    paramString = new Intent();
    paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
    paramString.putExtra("android.intent.extra.shortcut.NAME", paramActivity.getResources().getString(2131365725));
    paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity.getApplicationContext(), 2130838429));
    paramString.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramActivity.sendOrderedBroadcast(paramString, null);
    BadgeUtils.a(paramActivity.getApplicationContext(), 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    new kub(paramContext, paramString).run();
  }
  
  static boolean a(Context paramContext)
  {
    if (a == null) {
      a = QQShortCutUtils.a(paramContext);
    }
    if (a == "empty")
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "cannot find authority");
      }
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 136	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   7: ifne +7 -> 14
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: ireturn
    //   14: getstatic 19	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   17: astore 6
    //   19: aload_0
    //   20: invokevirtual 142	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   23: astore 7
    //   25: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +81 -> 109
    //   31: ldc 144
    //   33: astore 5
    //   35: aload 5
    //   37: astore_0
    //   38: aload_1
    //   39: ifnull +34 -> 73
    //   42: aload 5
    //   44: astore_0
    //   45: aload_1
    //   46: arraylength
    //   47: iconst_1
    //   48: if_icmplt +25 -> 73
    //   51: new 146	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   58: ldc 144
    //   60: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: iconst_0
    //   65: aaload
    //   66: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_0
    //   73: getstatic 15	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   76: iconst_2
    //   77: new 146	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   84: ldc 156
    //   86: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 158
    //   96: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload 7
    //   111: aload 6
    //   113: invokestatic 164	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   116: aconst_null
    //   117: ldc 166
    //   119: aload_1
    //   120: aconst_null
    //   121: invokevirtual 172	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull +26 -> 152
    //   129: aload_1
    //   130: astore_0
    //   131: aload_1
    //   132: invokeinterface 177 1 0
    //   137: istore_3
    //   138: iload_3
    //   139: istore_2
    //   140: aload_1
    //   141: ifnull -129 -> 12
    //   144: aload_1
    //   145: invokeinterface 180 1 0
    //   150: iload_3
    //   151: ireturn
    //   152: aload_1
    //   153: ifnull +9 -> 162
    //   156: aload_1
    //   157: invokeinterface 180 1 0
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: astore_0
    //   170: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +35 -> 208
    //   176: aload_1
    //   177: astore_0
    //   178: getstatic 15	com/tencent/mobileqq/utils/ShortcutUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   181: iconst_2
    //   182: new 146	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   189: ldc 182
    //   191: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 4
    //   196: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   199: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload_1
    //   209: ifnull -47 -> 162
    //   212: aload_1
    //   213: invokeinterface 180 1 0
    //   218: goto -56 -> 162
    //   221: astore_0
    //   222: aload 4
    //   224: astore_1
    //   225: aload_1
    //   226: ifnull +9 -> 235
    //   229: aload_1
    //   230: invokeinterface 180 1 0
    //   235: aload_0
    //   236: athrow
    //   237: astore 4
    //   239: aload_0
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: goto -19 -> 225
    //   247: astore 4
    //   249: goto -81 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramContext	Context
    //   0	252	1	paramArrayOfString	String[]
    //   11	129	2	bool1	boolean
    //   137	14	3	bool2	boolean
    //   1	1	4	localObject1	Object
    //   164	59	4	localException1	java.lang.Exception
    //   237	5	4	localObject2	Object
    //   247	1	4	localException2	java.lang.Exception
    //   33	10	5	str1	String
    //   17	95	6	str2	String
    //   23	87	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   25	31	164	java/lang/Exception
    //   45	73	164	java/lang/Exception
    //   73	109	164	java/lang/Exception
    //   109	125	164	java/lang/Exception
    //   25	31	221	finally
    //   45	73	221	finally
    //   73	109	221	finally
    //   109	125	221	finally
    //   131	138	237	finally
    //   170	176	237	finally
    //   178	208	237	finally
    //   131	138	247	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils
 * JD-Core Version:    0.7.0.1
 */