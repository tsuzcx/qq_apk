package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QzonePerformanceTracer;
import java.util.List;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class QZoneCrashHandler
  extends CrashHandler
{
  public static String a;
  private static Thread.UncaughtExceptionHandler a;
  public static String b = "?";
  private static final String c = "QZ_setting";
  
  static
  {
    jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = null;
    jdField_a_of_type_JavaLangString = null;
  }
  
  public QZoneCrashHandler()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  @SuppressLint({"NewApi"})
  public static String a()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0);
    String str = ((SharedPreferences)localObject).getString("key_last_crash_info", null);
    if (str != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_last_crash_info");
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      return str;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return str;
  }
  
  @SuppressLint({"NewApi"})
  public static void a(String paramString)
  {
    paramString = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0).edit().putString("key_last_crash_info", paramString);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramString.commit();
      return;
    }
    paramString.apply();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 89	java/io/File
    //   6: dup
    //   7: getstatic 94	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   10: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 99	java/io/File:exists	()Z
    //   20: ifne +9 -> 29
    //   23: aload 4
    //   25: invokevirtual 102	java/io/File:mkdirs	()Z
    //   28: pop
    //   29: new 89	java/io/File
    //   32: dup
    //   33: new 104	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   40: getstatic 94	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   43: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 111
    //   48: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 4
    //   59: aload 4
    //   61: invokevirtual 99	java/io/File:exists	()Z
    //   64: ifne +231 -> 295
    //   67: iconst_1
    //   68: istore_3
    //   69: new 116	java/io/FileWriter
    //   72: dup
    //   73: aload 4
    //   75: iconst_1
    //   76: invokespecial 119	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: astore 4
    //   81: iload_3
    //   82: ifeq +105 -> 187
    //   85: aload 4
    //   87: new 104	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   94: ldc 121
    //   96: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: getstatic 126	android/os/Build:MODEL	Ljava/lang/String;
    //   102: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc 128
    //   107: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 131	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   113: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   122: aload 4
    //   124: ldc 136
    //   126: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   129: new 138	android/text/format/Time
    //   132: dup
    //   133: invokespecial 139	android/text/format/Time:<init>	()V
    //   136: astore 5
    //   138: aload 5
    //   140: invokevirtual 142	android/text/format/Time:setToNow	()V
    //   143: aload 4
    //   145: new 104	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   152: aload 5
    //   154: ldc 144
    //   156: invokevirtual 148	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   159: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 150
    //   164: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   173: aload 4
    //   175: ldc 152
    //   177: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   180: aload 4
    //   182: ldc 136
    //   184: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   187: new 138	android/text/format/Time
    //   190: dup
    //   191: invokespecial 139	android/text/format/Time:<init>	()V
    //   194: astore 5
    //   196: aload 5
    //   198: invokevirtual 142	android/text/format/Time:setToNow	()V
    //   201: aload 4
    //   203: new 104	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   210: aload 5
    //   212: ldc 144
    //   214: invokevirtual 148	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 150
    //   222: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: ifnull +32 -> 264
    //   235: aload 4
    //   237: new 104	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   244: ldc 154
    //   246: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_0
    //   250: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 156
    //   255: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   264: aload 4
    //   266: aload_1
    //   267: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   270: aload 4
    //   272: ldc 136
    //   274: invokevirtual 134	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   277: aload 4
    //   279: invokevirtual 159	java/io/FileWriter:close	()V
    //   282: iconst_0
    //   283: ifeq +11 -> 294
    //   286: new 161	java/lang/NullPointerException
    //   289: dup
    //   290: invokespecial 162	java/lang/NullPointerException:<init>	()V
    //   293: athrow
    //   294: return
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -228 -> 69
    //   300: astore_0
    //   301: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   304: ifeq -10 -> 294
    //   307: ldc 169
    //   309: iconst_1
    //   310: new 104	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   317: ldc 171
    //   319: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_0
    //   323: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: return
    //   336: astore_1
    //   337: aload 5
    //   339: astore_0
    //   340: aload_1
    //   341: invokevirtual 181	java/lang/Exception:printStackTrace	()V
    //   344: aload_0
    //   345: ifnull -51 -> 294
    //   348: aload_0
    //   349: invokevirtual 159	java/io/FileWriter:close	()V
    //   352: return
    //   353: astore_0
    //   354: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq -63 -> 294
    //   360: ldc 169
    //   362: iconst_1
    //   363: new 104	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   370: ldc 171
    //   372: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   379: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: return
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_1
    //   393: ifnull +7 -> 400
    //   396: aload_1
    //   397: invokevirtual 159	java/io/FileWriter:close	()V
    //   400: aload_0
    //   401: athrow
    //   402: astore_1
    //   403: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   406: ifeq -6 -> 400
    //   409: ldc 169
    //   411: iconst_1
    //   412: new 104	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   419: ldc 171
    //   421: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_1
    //   425: invokevirtual 174	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: goto -37 -> 400
    //   440: astore_0
    //   441: aload 4
    //   443: astore_1
    //   444: goto -52 -> 392
    //   447: astore 4
    //   449: aload_0
    //   450: astore_1
    //   451: aload 4
    //   453: astore_0
    //   454: goto -62 -> 392
    //   457: astore_1
    //   458: aload 4
    //   460: astore_0
    //   461: goto -121 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramString1	String
    //   0	464	1	paramString2	String
    //   0	464	2	paramBoolean	boolean
    //   68	229	3	i	int
    //   13	429	4	localObject1	Object
    //   447	12	4	localObject2	Object
    //   1	337	5	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   286	294	300	java/lang/Exception
    //   3	29	336	java/lang/Exception
    //   29	67	336	java/lang/Exception
    //   69	81	336	java/lang/Exception
    //   348	352	353	java/lang/Exception
    //   3	29	389	finally
    //   29	67	389	finally
    //   69	81	389	finally
    //   396	400	402	java/lang/Exception
    //   85	187	440	finally
    //   187	231	440	finally
    //   235	264	440	finally
    //   264	282	440	finally
    //   340	344	447	finally
    //   85	187	457	java/lang/Exception
    //   187	231	457	java/lang/Exception
    //   235	264	457	java/lang/Exception
    //   264	282	457	java/lang/Exception
  }
  
  void a() {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    Object localObject = BaseApplicationImpl.a.getAllAccounts();
    if (localObject != null)
    {
      localObject = (SimpleAccount)((List)localObject).get(0);
      if (localObject == null) {
        break label153;
      }
    }
    label153:
    for (localObject = ((SimpleAccount)localObject).getUin();; localObject = "0")
    {
      long l = Long.valueOf((String)localObject).longValue();
      CrashGuard.a().a(paramThrowable, l);
      localObject = (MobileQQ)BaseApplication.getContext();
      String str = QLog.getStackTraceString(paramThrowable);
      QLog.e("crash", 1, str);
      a(str);
      a("crash", str, true);
      BaseApplication.getContext().getSharedPreferences("QZ_Per_Config", 0).edit().putBoolean(QzonePerformanceTracer.f, false).commit();
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
      ((MobileQQ)localObject).crashed();
      ((MobileQQ)localObject).otherProcessExit(false);
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneCrashHandler
 * JD-Core Version:    0.7.0.1
 */