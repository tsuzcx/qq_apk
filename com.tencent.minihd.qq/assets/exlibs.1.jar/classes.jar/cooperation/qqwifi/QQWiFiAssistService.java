package cooperation.qqwifi;

import android.app.Notification;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pluginsdk.PluginProxyService;
import com.tencent.qphone.base.util.QLog;

public class QQWiFiAssistService
  extends PluginProxyService
{
  private static final String jdField_a_of_type_JavaLangString = "QQWiFiAssistService";
  private long jdField_a_of_type_Long = 0L;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        startForeground(9998, new Notification());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void b()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 18) {
        stopForeground(true);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "QQWiFiAssistService onCreate");
    }
    a();
    super.onCreate();
  }
  
  public void onDestroy()
  {
    b();
    super.onDestroy();
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public int onStartCommand(android.content.Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 73	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +37 -> 40
    //   6: ldc 8
    //   8: iconst_2
    //   9: new 75	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   16: ldc 78
    //   18: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc 87
    //   27: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: iload_3
    //   31: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 101	cooperation/qqwifi/QQWiFiAssistService:getApplicationContext	()Landroid/content/Context;
    //   44: invokestatic 107	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   47: astore 4
    //   49: aload_1
    //   50: ifnull +93 -> 143
    //   53: aload_1
    //   54: invokevirtual 112	android/content/Intent:toURI	()Ljava/lang/String;
    //   57: astore 5
    //   59: aload 4
    //   61: invokeinterface 118 1 0
    //   66: ldc 120
    //   68: aload 5
    //   70: invokeinterface 126 3 0
    //   75: invokeinterface 129 1 0
    //   80: pop
    //   81: aload_0
    //   82: aload_1
    //   83: iload_2
    //   84: iload_3
    //   85: invokespecial 131	com/tencent/mobileqq/pluginsdk/PluginProxyService:onStartCommand	(Landroid/content/Intent;II)I
    //   88: pop
    //   89: aload_0
    //   90: aload_1
    //   91: ldc 133
    //   93: iconst_0
    //   94: invokevirtual 137	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   97: putfield 139	cooperation/qqwifi/QQWiFiAssistService:jdField_a_of_type_Boolean	Z
    //   100: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +31 -> 134
    //   106: ldc 8
    //   108: iconst_2
    //   109: new 75	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   116: ldc 141
    //   118: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: getfield 139	cooperation/qqwifi/QQWiFiAssistService:jdField_a_of_type_Boolean	Z
    //   125: invokevirtual 144	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   128: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_0
    //   135: getfield 139	cooperation/qqwifi/QQWiFiAssistService:jdField_a_of_type_Boolean	Z
    //   138: ifeq +201 -> 339
    //   141: iconst_2
    //   142: ireturn
    //   143: aload 4
    //   145: ldc 120
    //   147: ldc 146
    //   149: invokeinterface 150 3 0
    //   154: astore 5
    //   156: invokestatic 73	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   159: ifeq +29 -> 188
    //   162: ldc 8
    //   164: iconst_2
    //   165: new 75	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   172: ldc 152
    //   174: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 5
    //   179: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 4
    //   193: astore_1
    //   194: aload 5
    //   196: invokestatic 158	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   199: ifne +10 -> 209
    //   202: aload 5
    //   204: iconst_0
    //   205: invokestatic 162	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   208: astore_1
    //   209: aload_1
    //   210: astore 4
    //   212: aload_1
    //   213: ifnonnull +74 -> 287
    //   216: new 109	android/content/Intent
    //   219: dup
    //   220: aload_0
    //   221: invokevirtual 101	cooperation/qqwifi/QQWiFiAssistService:getApplicationContext	()Landroid/content/Context;
    //   224: ldc 2
    //   226: invokespecial 165	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   229: astore 4
    //   231: aload 4
    //   233: ldc 167
    //   235: iconst_m1
    //   236: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   239: pop
    //   240: aload 4
    //   242: ldc 172
    //   244: aload_0
    //   245: ldc 174
    //   247: invokestatic 180	com/tencent/mobileqq/pluginsdk/PluginUtils:getInstalledPluginPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   250: invokevirtual 185	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   253: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   256: pop
    //   257: aload 4
    //   259: ldc 190
    //   261: ldc 192
    //   263: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   266: pop
    //   267: aload 4
    //   269: ldc 194
    //   271: ldc 174
    //   273: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   276: pop
    //   277: aload 4
    //   279: ldc 196
    //   281: ldc 198
    //   283: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   286: pop
    //   287: invokestatic 73	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   290: ifeq +11 -> 301
    //   293: ldc 8
    //   295: iconst_2
    //   296: ldc 200
    //   298: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: aload 4
    //   303: ldc 202
    //   305: iconst_1
    //   306: invokevirtual 205	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   309: pop
    //   310: aload_0
    //   311: aload 4
    //   313: iload_2
    //   314: iload_3
    //   315: invokespecial 131	com/tencent/mobileqq/pluginsdk/PluginProxyService:onStartCommand	(Landroid/content/Intent;II)I
    //   318: pop
    //   319: iconst_2
    //   320: ireturn
    //   321: astore_1
    //   322: aload_1
    //   323: invokevirtual 208	java/net/URISyntaxException:printStackTrace	()V
    //   326: aload 4
    //   328: astore_1
    //   329: goto -120 -> 209
    //   332: astore_1
    //   333: iconst_2
    //   334: ireturn
    //   335: astore_1
    //   336: goto -79 -> 257
    //   339: iconst_1
    //   340: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	QQWiFiAssistService
    //   0	341	1	paramIntent	android.content.Intent
    //   0	341	2	paramInt1	int
    //   0	341	3	paramInt2	int
    //   47	280	4	localObject	java.lang.Object
    //   57	146	5	str	String
    // Exception table:
    //   from	to	target	type
    //   194	209	321	java/net/URISyntaxException
    //   0	40	332	java/lang/Throwable
    //   40	49	332	java/lang/Throwable
    //   53	134	332	java/lang/Throwable
    //   134	141	332	java/lang/Throwable
    //   143	188	332	java/lang/Throwable
    //   194	209	332	java/lang/Throwable
    //   216	240	332	java/lang/Throwable
    //   240	257	332	java/lang/Throwable
    //   257	287	332	java/lang/Throwable
    //   287	301	332	java/lang/Throwable
    //   301	319	332	java/lang/Throwable
    //   322	326	332	java/lang/Throwable
    //   240	257	335	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWiFiAssistService
 * JD-Core Version:    0.7.0.1
 */