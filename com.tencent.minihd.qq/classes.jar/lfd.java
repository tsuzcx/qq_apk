import android.content.Context;
import android.content.Intent;
import com.tencent.open.business.base.appreport.AppReportReceiver;

public class lfd
  implements Runnable
{
  public lfd(AppReportReceiver paramAppReportReceiver, Intent paramIntent, Context paramContext) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 8
    //   2: istore_1
    //   3: aload_0
    //   4: getfield 16	lfd:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   7: invokevirtual 33	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload 5
    //   20: ldc 35
    //   22: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   25: ifeq +220 -> 245
    //   28: aload_0
    //   29: getfield 16	lfd:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   32: invokevirtual 45	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   35: astore_3
    //   36: aload_3
    //   37: ifnull +476 -> 513
    //   40: aload_3
    //   41: ldc 47
    //   43: invokevirtual 53	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   46: astore 4
    //   48: aload_3
    //   49: ldc 55
    //   51: invokevirtual 59	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: aload 4
    //   56: invokestatic 64	com/tencent/open/business/base/appreport/AppReportReceiver:a	(Ljava/lang/String;Ljava/util/ArrayList;)Z
    //   59: ifeq +454 -> 513
    //   62: aload_0
    //   63: getfield 14	lfd:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   66: aload 4
    //   68: invokevirtual 67	com/tencent/open/business/base/appreport/AppReportReceiver:a	(Ljava/util/ArrayList;)Z
    //   71: ifeq +442 -> 513
    //   74: aload_0
    //   75: getfield 18	lfd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   78: ldc 69
    //   80: invokevirtual 75	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   83: checkcast 77	android/app/ActivityManager
    //   86: iconst_1
    //   87: invokevirtual 81	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   90: astore_3
    //   91: aload_3
    //   92: invokeinterface 87 1 0
    //   97: iconst_1
    //   98: if_icmplt +80 -> 178
    //   101: aload_3
    //   102: iconst_0
    //   103: invokeinterface 91 2 0
    //   108: checkcast 93	android/app/ActivityManager$RunningTaskInfo
    //   111: getfield 97	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   114: invokevirtual 102	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   117: astore_3
    //   118: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +28 -> 149
    //   124: ldc 110
    //   126: iconst_2
    //   127: new 112	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   134: ldc 115
    //   136: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_3
    //   140: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_3
    //   150: ifnull +28 -> 178
    //   153: aload_3
    //   154: invokevirtual 129	java/lang/String:length	()I
    //   157: ifle +21 -> 178
    //   160: aload_3
    //   161: ldc 131
    //   163: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   166: ifne +347 -> 513
    //   169: aload_3
    //   170: ldc 137
    //   172: invokevirtual 135	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   175: ifne +338 -> 513
    //   178: getstatic 142	com/tencent/mobileqq/app/BrowserAppInterface:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   181: invokevirtual 146	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   184: istore_2
    //   185: iload_2
    //   186: ifne +327 -> 513
    //   189: invokestatic 151	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   192: ifnull +15 -> 207
    //   195: invokestatic 151	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   198: invokevirtual 154	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:unRegisterMsfService	()V
    //   201: invokestatic 151	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:get	()Lcom/tencent/mobileqq/msf/sdk/MsfServiceSdk;
    //   204: invokevirtual 157	com/tencent/mobileqq/msf/sdk/MsfServiceSdk:unbindMsfService	()V
    //   207: aload_0
    //   208: getfield 16	lfd:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   211: ldc 159
    //   213: iconst_0
    //   214: invokevirtual 163	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   217: ifne +296 -> 513
    //   220: aload_0
    //   221: getfield 14	lfd:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   224: invokevirtual 165	com/tencent/open/business/base/appreport/AppReportReceiver:a	()V
    //   227: return
    //   228: astore_3
    //   229: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +281 -> 513
    //   235: ldc 167
    //   237: iconst_2
    //   238: ldc 169
    //   240: aload_3
    //   241: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   244: return
    //   245: aload_0
    //   246: getfield 16	lfd:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   249: ldc 174
    //   251: iconst_0
    //   252: invokevirtual 163	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   255: istore_2
    //   256: aload_0
    //   257: getfield 16	lfd:jdField_a_of_type_AndroidContentIntent	Landroid/content/Intent;
    //   260: invokevirtual 177	android/content/Intent:getDataString	()Ljava/lang/String;
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull +248 -> 513
    //   268: aload_3
    //   269: ldc 179
    //   271: invokevirtual 183	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   274: ifeq +239 -> 513
    //   277: aload_3
    //   278: bipush 8
    //   280: invokevirtual 187	java/lang/String:substring	(I)Ljava/lang/String;
    //   283: astore_3
    //   284: invokestatic 192	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   287: invokevirtual 196	com/tencent/common/app/BaseApplicationImpl:getFirstSimpleAccount	()Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   290: invokevirtual 201	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   293: astore 4
    //   295: aload 5
    //   297: ldc 203
    //   299: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +106 -> 408
    //   305: iload_2
    //   306: ifne +102 -> 408
    //   309: aload_3
    //   310: ldc 205
    //   312: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +18 -> 333
    //   318: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +192 -> 513
    //   324: ldc 110
    //   326: iconst_2
    //   327: ldc 207
    //   329: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: return
    //   333: aload_3
    //   334: ldc 209
    //   336: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: istore_2
    //   340: iload_2
    //   341: ifeq +167 -> 508
    //   344: aload_0
    //   345: getfield 18	lfd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   348: invokevirtual 213	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   351: aload 4
    //   353: invokestatic 218	com/tencent/open/business/base/StaticAnalyz:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   356: iconst_2
    //   357: istore_1
    //   358: new 220	android/content/IntentFilter
    //   361: dup
    //   362: invokespecial 221	android/content/IntentFilter:<init>	()V
    //   365: astore 5
    //   367: aload 5
    //   369: ldc 35
    //   371: invokevirtual 225	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   374: invokestatic 192	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   377: aload_0
    //   378: getfield 14	lfd:jdField_a_of_type_ComTencentOpenBusinessBaseAppreportAppReportReceiver	Lcom/tencent/open/business/base/appreport/AppReportReceiver;
    //   381: aload 5
    //   383: invokevirtual 229	com/tencent/common/app/BaseApplicationImpl:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   386: pop
    //   387: getstatic 233	com/tencent/common/app/BaseApplicationImpl:b	Z
    //   390: ifeq +97 -> 487
    //   393: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   396: ifeq +117 -> 513
    //   399: ldc 235
    //   401: iconst_2
    //   402: ldc 237
    //   404: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: return
    //   408: aload 5
    //   410: ldc 239
    //   412: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   415: ifeq +31 -> 446
    //   418: iload_2
    //   419: ifne +27 -> 446
    //   422: aload_3
    //   423: ldc 205
    //   425: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   428: ifeq -70 -> 358
    //   431: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +79 -> 513
    //   437: ldc 110
    //   439: iconst_2
    //   440: ldc 241
    //   442: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: return
    //   446: aload 5
    //   448: ldc 243
    //   450: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   453: ifeq +60 -> 513
    //   456: iload_2
    //   457: ifeq +56 -> 513
    //   460: aload_3
    //   461: ldc 205
    //   463: invokevirtual 41	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +55 -> 521
    //   469: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   472: ifeq +11 -> 483
    //   475: ldc 110
    //   477: iconst_2
    //   478: ldc 245
    //   480: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: invokestatic 248	com/tencent/open/downloadnew/YybHandleUtil:a	()V
    //   486: return
    //   487: aload_0
    //   488: getfield 18	lfd:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   491: invokevirtual 213	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   494: aload_3
    //   495: iload_1
    //   496: aconst_null
    //   497: aconst_null
    //   498: aload 4
    //   500: invokestatic 253	com/tencent/open/business/base/appreport/AppReport:a	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/smtt/sdk/WebView;Ljava/lang/String;)V
    //   503: return
    //   504: astore_3
    //   505: goto -298 -> 207
    //   508: iconst_2
    //   509: istore_1
    //   510: goto -152 -> 358
    //   513: return
    //   514: astore 5
    //   516: iconst_2
    //   517: istore_1
    //   518: goto -160 -> 358
    //   521: iconst_4
    //   522: istore_1
    //   523: goto -165 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	526	0	this	lfd
    //   2	521	1	i	int
    //   184	273	2	bool	boolean
    //   35	135	3	localObject1	Object
    //   228	13	3	localThrowable	java.lang.Throwable
    //   263	232	3	str	java.lang.String
    //   504	1	3	localException1	java.lang.Exception
    //   46	453	4	localObject2	Object
    //   10	437	5	localObject3	Object
    //   514	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	12	228	java/lang/Throwable
    //   18	36	228	java/lang/Throwable
    //   40	149	228	java/lang/Throwable
    //   153	178	228	java/lang/Throwable
    //   178	185	228	java/lang/Throwable
    //   189	207	228	java/lang/Throwable
    //   207	227	228	java/lang/Throwable
    //   245	264	228	java/lang/Throwable
    //   268	305	228	java/lang/Throwable
    //   309	332	228	java/lang/Throwable
    //   333	340	228	java/lang/Throwable
    //   344	356	228	java/lang/Throwable
    //   358	407	228	java/lang/Throwable
    //   408	418	228	java/lang/Throwable
    //   422	445	228	java/lang/Throwable
    //   446	456	228	java/lang/Throwable
    //   460	483	228	java/lang/Throwable
    //   483	486	228	java/lang/Throwable
    //   487	503	228	java/lang/Throwable
    //   189	207	504	java/lang/Exception
    //   344	356	514	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */