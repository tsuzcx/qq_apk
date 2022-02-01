package com.tencent.mobileqq.log;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import jdd;
import jde;
import jdf;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;
import mqq.app.permission.PermissionManager;

public class ReportLog
  extends CrashHandler
{
  static final int jdField_a_of_type_Int = 10000001;
  public static ProgressDialog a;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  public static String a;
  private static Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  public static boolean a = false;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  static final int jdField_b_of_type_Int = 10000002;
  public static String b;
  private static boolean jdField_b_of_type_Boolean = false;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  private static final String c = "ReportLog";
  private static String d;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_ArrayOfByte = null;
    d = "0";
    jdField_a_of_type_JavaLangString = "/Tencent/MobileQQ/log/";
    jdField_a_of_type_AndroidOsHandler = new jdd(Looper.getMainLooper());
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = new jde();
    jdField_b_of_type_JavaLangString = "https://bugtrace.3g.qq.com/upload/1/0";
  }
  
  public ReportLog()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    ReportLogHelper.a(paramActivity, paramString, jdField_a_of_type_AndroidOsHandler);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean;
    } while (!paramBoolean);
    try
    {
      jdField_a_of_type_JavaLangString = ReportLogHelper.a(paramContext, "/Tencent/MobileQQ/log/") + "/";
      ReportLogHelper.jdField_a_of_type_JavaLangString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      ReportLogHelper.jdField_b_of_type_JavaLangString = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.utils.httputils.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: getstatic 150	com/tencent/common/config/AppSetting:a	I
    //   6: ldc 152
    //   8: ldc 154
    //   10: invokestatic 160	com/tencent/qphone/base/util/QLog:doReportLogSelf	(ILjava/lang/String;Ljava/lang/String;)V
    //   13: aload_0
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: putstatic 162	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   22: new 93	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: ldc 45
    //   32: invokestatic 97	com/tencent/mobileqq/log/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 103
    //   40: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: putstatic 47	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: new 164	java/io/File
    //   52: dup
    //   53: new 93	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   60: getstatic 47	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   63: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 166
    //   68: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 8
    //   79: aload 8
    //   81: invokevirtual 173	java/io/File:exists	()Z
    //   84: ifeq -67 -> 17
    //   87: aconst_null
    //   88: ldc 175
    //   90: iconst_1
    //   91: invokestatic 178	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   94: iconst_1
    //   95: putstatic 37	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   98: aload 8
    //   100: invokevirtual 182	java/io/File:length	()J
    //   103: lstore 4
    //   105: lload 4
    //   107: l2i
    //   108: newarray byte
    //   110: astore 7
    //   112: new 184	java/io/BufferedInputStream
    //   115: dup
    //   116: new 186	java/io/FileInputStream
    //   119: dup
    //   120: aload 8
    //   122: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   128: astore_2
    //   129: lload 4
    //   131: l2i
    //   132: istore_3
    //   133: aload_2
    //   134: astore_1
    //   135: aload_2
    //   136: aload 7
    //   138: iconst_0
    //   139: iload_3
    //   140: invokevirtual 196	java/io/BufferedInputStream:read	([BII)I
    //   143: i2l
    //   144: lload 4
    //   146: lcmp
    //   147: ifeq +41 -> 188
    //   150: aload_2
    //   151: astore_1
    //   152: new 144	java/lang/Exception
    //   155: dup
    //   156: ldc 198
    //   158: invokespecial 199	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_1
    //   163: aload_2
    //   164: astore_0
    //   165: aload_1
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   173: aload_0
    //   174: ifnull -157 -> 17
    //   177: aload_0
    //   178: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   181: return
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   194: aload 8
    //   196: invokevirtual 209	java/io/File:delete	()Z
    //   199: pop
    //   200: getstatic 39	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   203: ifnonnull +11 -> 214
    //   206: ldc 211
    //   208: invokevirtual 33	java/lang/String:getBytes	()[B
    //   211: putstatic 39	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   214: getstatic 43	com/tencent/mobileqq/log/ReportLog:d	Ljava/lang/String;
    //   217: ifnonnull +8 -> 225
    //   220: ldc 41
    //   222: putstatic 43	com/tencent/mobileqq/log/ReportLog:d	Ljava/lang/String;
    //   225: new 213	KQQ/UploadInfo
    //   228: dup
    //   229: invokespecial 214	KQQ/UploadInfo:<init>	()V
    //   232: astore_1
    //   233: aload_1
    //   234: getstatic 150	com/tencent/common/config/AppSetting:a	I
    //   237: i2l
    //   238: putfield 218	KQQ/UploadInfo:lAppID	J
    //   241: aload_1
    //   242: getstatic 43	com/tencent/mobileqq/log/ReportLog:d	Ljava/lang/String;
    //   245: invokestatic 224	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   248: putfield 227	KQQ/UploadInfo:lFromMID	J
    //   251: aload_1
    //   252: lconst_0
    //   253: putfield 230	KQQ/UploadInfo:lToMID	J
    //   256: aload_1
    //   257: iconst_1
    //   258: putfield 234	KQQ/UploadInfo:shType	S
    //   261: aload_1
    //   262: getstatic 39	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   265: putfield 237	KQQ/UploadInfo:vSignature	[B
    //   268: aload_1
    //   269: invokevirtual 240	KQQ/UploadInfo:toByteArray	()[B
    //   272: astore_1
    //   273: new 242	com/tencent/qphone/base/util/Cryptor
    //   276: dup
    //   277: invokespecial 243	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   280: aload_1
    //   281: getstatic 35	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   284: invokevirtual 247	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   287: astore_1
    //   288: new 249	KQQ/HttpUploadReq
    //   291: dup
    //   292: invokespecial 250	KQQ/HttpUploadReq:<init>	()V
    //   295: astore_2
    //   296: aload_2
    //   297: aload_1
    //   298: putfield 253	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   301: aload_2
    //   302: aload 7
    //   304: putfield 256	KQQ/HttpUploadReq:vFileData	[B
    //   307: new 258	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   310: dup
    //   311: getstatic 71	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   314: aload_2
    //   315: invokevirtual 259	KQQ/HttpUploadReq:toByteArray	()[B
    //   318: getstatic 67	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   321: invokespecial 262	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   324: astore_1
    //   325: aload_1
    //   326: ldc_w 264
    //   329: invokevirtual 266	com/tencent/mobileqq/utils/httputils/HttpMsg:c	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: aload_1
    //   334: invokevirtual 271	com/tencent/mobileqq/utils/httputils/HttpCommunicator:a	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   337: pop
    //   338: iconst_0
    //   339: putstatic 37	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   342: iconst_0
    //   343: ifeq -326 -> 17
    //   346: new 273	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 274	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   359: return
    //   360: astore_0
    //   361: aload 6
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 205	java/io/BufferedInputStream:close	()V
    //   372: aload_0
    //   373: athrow
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 206	java/io/IOException:printStackTrace	()V
    //   379: goto -7 -> 372
    //   382: astore_0
    //   383: goto -19 -> 364
    //   386: astore_2
    //   387: aconst_null
    //   388: astore_0
    //   389: goto -222 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	paramHttpCommunicator	com.tencent.mobileqq.utils.httputils.HttpCommunicator
    //   0	392	1	paramContext	Context
    //   0	392	2	paramProgressDialog	ProgressDialog
    //   132	8	3	i	int
    //   103	42	4	l	long
    //   1	361	6	localObject	Object
    //   110	193	7	arrayOfByte	byte[]
    //   77	118	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   135	150	162	java/lang/Exception
    //   152	162	162	java/lang/Exception
    //   190	194	162	java/lang/Exception
    //   177	181	182	java/io/IOException
    //   346	354	354	java/io/IOException
    //   94	129	360	finally
    //   194	214	360	finally
    //   214	225	360	finally
    //   225	342	360	finally
    //   368	372	374	java/io/IOException
    //   135	150	382	finally
    //   152	162	382	finally
    //   169	173	382	finally
    //   190	194	382	finally
    //   94	129	386	java/lang/Exception
    //   194	214	386	java/lang/Exception
    //   214	225	386	java/lang/Exception
    //   225	342	386	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    d = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {}
    while ((jdField_a_of_type_Boolean) || (!BaseActivity.sTopActivity.permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))) {
      return;
    }
    a(paramString1, paramString2, true);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReportLogHelper.a(paramString1, paramString2, paramBoolean);
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    if ((paramThrowable instanceof OutOfMemoryError)) {
      a(BaseActivity.sTopActivity, "uncaughtException");
    }
    SharedPreferencesProxyManager.getInstance().trySave();
    paramThread = (MobileQQ)BaseApplication.getContext();
    try
    {
      ReportLogHelper.jdField_a_of_type_JavaLangString = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      ReportLogHelper.jdField_b_of_type_JavaLangString = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      label65:
      Object localObject = new ByteArrayOutputStream();
      paramThrowable.printStackTrace(new PrintStream((OutputStream)localObject));
      localObject = new StringBuilder(new String(((ByteArrayOutputStream)localObject).toByteArray()));
      if ((paramThrowable instanceof OutOfMemoryError))
      {
        System.gc();
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(BitmapManager.a());
        ((StringBuilder)localObject).append("\n");
      }
      a("crash", ((StringBuilder)localObject).toString(), true);
      paramThread.crashed();
      paramThread.sendBroadcast(new Intent("qqplayer_exit_action"));
      paramThread = new jdf(this, paramThread);
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(paramThread);
        return;
      }
      paramThread.run();
      return;
    }
    catch (Exception localException)
    {
      break label65;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog
 * JD-Core Version:    0.7.0.1
 */