package com.tencent.mqp.app.sec;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class MQPSecUtil
{
  public static int a = 0;
  private static MQPSecUtil jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil = null;
  private static final String jdField_a_of_type_JavaLangString = "MQPSecUtil";
  private static final String b = "mqpintchk";
  
  /* Error */
  static
  {
    // Byte code:
    //   0: aconst_null
    //   1: putstatic 22	com/tencent/mqp/app/sec/MQPSecUtil:jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil	Lcom/tencent/mqp/app/sec/MQPSecUtil;
    //   4: iconst_1
    //   5: putstatic 24	com/tencent/mqp/app/sec/MQPSecUtil:jdField_a_of_type_Int	I
    //   8: invokestatic 30	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: astore_3
    //   12: new 32	java/io/File
    //   15: dup
    //   16: new 34	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   23: aload_3
    //   24: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   27: invokevirtual 47	java/io/File:getParent	()Ljava/lang/String;
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 53
    //   35: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 14
    //   40: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 55
    //   45: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 65	java/io/File:exists	()Z
    //   59: ifne +31 -> 90
    //   62: ldc 67
    //   64: astore_1
    //   65: getstatic 72	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   68: ldc 74
    //   70: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +95 -> 168
    //   76: ldc 74
    //   78: astore_1
    //   79: aload_1
    //   80: ldc 82
    //   82: if_acmpeq +8 -> 90
    //   85: aload_3
    //   86: aload_1
    //   87: invokestatic 85	com/tencent/mqp/app/sec/MQPSecUtil:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 65	java/io/File:exists	()Z
    //   96: ifne +46 -> 142
    //   99: new 32	java/io/File
    //   102: dup
    //   103: new 34	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   110: aload_3
    //   111: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   114: invokevirtual 47	java/io/File:getParent	()Ljava/lang/String;
    //   117: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: ldc 87
    //   122: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 14
    //   127: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 55
    //   132: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 65	java/io/File:exists	()Z
    //   146: ifeq +82 -> 228
    //   149: aload_1
    //   150: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   153: invokestatic 95	java/lang/System:load	(Ljava/lang/String;)V
    //   156: iconst_1
    //   157: istore_0
    //   158: iload_0
    //   159: ifne +8 -> 167
    //   162: ldc 14
    //   164: invokestatic 98	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   167: return
    //   168: getstatic 72	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   171: ldc 100
    //   173: invokevirtual 80	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   176: ifeq -97 -> 79
    //   179: ldc 82
    //   181: astore_1
    //   182: goto -103 -> 79
    //   185: astore_1
    //   186: aload_1
    //   187: invokevirtual 103	java/lang/Throwable:printStackTrace	()V
    //   190: goto -100 -> 90
    //   193: astore_2
    //   194: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +31 -> 228
    //   200: ldc 11
    //   202: iconst_2
    //   203: new 34	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   210: ldc 110
    //   212: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 90	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   219: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: iconst_0
    //   229: istore_0
    //   230: goto -72 -> 158
    //   233: astore_1
    //   234: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq -70 -> 167
    //   240: ldc 11
    //   242: iconst_2
    //   243: ldc 116
    //   245: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   157	73	0	i	int
    //   64	118	1	localObject	Object
    //   185	31	1	localThrowable	java.lang.Throwable
    //   233	1	1	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   54	39	2	localFile	java.io.File
    //   193	1	2	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   11	100	3	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   65	76	185	java/lang/Throwable
    //   85	90	185	java/lang/Throwable
    //   168	179	185	java/lang/Throwable
    //   149	156	193	java/lang/UnsatisfiedLinkError
    //   162	167	233	java/lang/UnsatisfiedLinkError
  }
  
  public static MQPSecUtil a()
  {
    if (jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil == null) {
      jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil = new MQPSecUtil();
    }
    return jdField_a_of_type_ComTencentMqpAppSecMQPSecUtil;
  }
  
  /* Error */
  private static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 34	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   12: ldc 126
    //   14: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 128
    //   23: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 130
    //   28: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: new 34	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: invokevirtual 43	android/content/Context:getFilesDir	()Ljava/io/File;
    //   47: invokevirtual 47	java/io/File:getParent	()Ljava/lang/String;
    //   50: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 132
    //   55: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 6
    //   63: new 34	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   70: aload 6
    //   72: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 128
    //   77: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 130
    //   82: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore_1
    //   89: new 32	java/io/File
    //   92: dup
    //   93: aload 6
    //   95: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 135	java/io/File:mkdirs	()Z
    //   101: pop
    //   102: aload_0
    //   103: invokevirtual 139	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload 5
    //   108: invokevirtual 145	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   111: astore_0
    //   112: new 147	java/io/FileOutputStream
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 148	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_3
    //   121: sipush 4096
    //   124: newarray byte
    //   126: astore_1
    //   127: aload_0
    //   128: aload_1
    //   129: invokevirtual 154	java/io/InputStream:read	([B)I
    //   132: istore_2
    //   133: iload_2
    //   134: ifle +35 -> 169
    //   137: aload_3
    //   138: aload_1
    //   139: iconst_0
    //   140: iload_2
    //   141: invokevirtual 160	java/io/OutputStream:write	([BII)V
    //   144: goto -17 -> 127
    //   147: astore_1
    //   148: aload_0
    //   149: astore_1
    //   150: aload_3
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 163	java/io/InputStream:close	()V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 164	java/io/OutputStream:close	()V
    //   168: return
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 163	java/io/InputStream:close	()V
    //   177: aload_3
    //   178: ifnull -10 -> 168
    //   181: aload_3
    //   182: invokevirtual 164	java/io/OutputStream:close	()V
    //   185: return
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   191: return
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   197: return
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload 4
    //   203: astore_3
    //   204: aload_0
    //   205: ifnull +7 -> 212
    //   208: aload_0
    //   209: invokevirtual 163	java/io/InputStream:close	()V
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 164	java/io/OutputStream:close	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore_0
    //   223: aload_0
    //   224: invokevirtual 165	java/io/IOException:printStackTrace	()V
    //   227: goto -7 -> 220
    //   230: astore_1
    //   231: aload 4
    //   233: astore_3
    //   234: goto -30 -> 204
    //   237: astore_1
    //   238: goto -34 -> 204
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_3
    //   245: astore_1
    //   246: goto -94 -> 152
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_3
    //   252: aload_0
    //   253: astore_1
    //   254: aload_3
    //   255: astore_0
    //   256: goto -104 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramContext	android.content.Context
    //   0	259	1	paramString	String
    //   132	9	2	i	int
    //   4	251	3	localObject1	Object
    //   1	231	4	localObject2	Object
    //   34	73	5	str1	String
    //   61	33	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   121	127	147	java/lang/Exception
    //   127	133	147	java/lang/Exception
    //   137	144	147	java/lang/Exception
    //   173	177	186	java/io/IOException
    //   181	185	186	java/io/IOException
    //   156	160	192	java/io/IOException
    //   164	168	192	java/io/IOException
    //   102	112	198	finally
    //   208	212	222	java/io/IOException
    //   216	220	222	java/io/IOException
    //   112	121	230	finally
    //   121	127	237	finally
    //   127	133	237	finally
    //   137	144	237	finally
    //   102	112	241	java/lang/Exception
    //   112	121	249	java/lang/Exception
  }
  
  public static void do_report(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MQPSecUtil", 2, "report_tracer:" + paramString);
    }
    ReportController.a((QQAppInterface)BaseApplicationImpl.a().a(), "P_CliOper", "Safe_MQPSecUtil", "", "AntiTrace", paramString, 0, 0, "", "", "", "");
  }
  
  public static native boolean memchk(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte);
  
  public static native byte[] memreport(String paramString, int paramInt1, int paramInt2);
  
  public native void antitrace(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mqp.app.sec.MQPSecUtil
 * JD-Core Version:    0.7.0.1
 */