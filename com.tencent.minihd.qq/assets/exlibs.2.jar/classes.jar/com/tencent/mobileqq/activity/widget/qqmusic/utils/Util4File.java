package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import android.content.Context;
import com.tencent.base.os.Native.NativeException;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import java.util.ArrayList;

public class Util4File
{
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final String a = "backuplib";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  public static String b = "";
  public static final String c = "lib";
  private static final String d = "Util4File";
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "libqmfaad2.so", "libqmfaad2fpu.so", "libqmflac.so", "libqmmpg123.so", "libqmvorbis.so", "libape.so", "libapev7a.so", "libimage_filter_common.so", "libimage_filter_common_v7a.so", "libimage_filter_gpu.so", "libimage_filter_gpu_v7a.so", "libvideobase.so", "libvideobase_v7a.so", "libmusicband.so", "libMusicWrapper.so", "libQAFP.so" };
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (paramContext != null)
    {
      str1 = str2;
      if (paramString != null)
      {
        str1 = str2;
        if (!"".equals(paramString))
        {
          str1 = str2;
          if (paramContext.getFilesDir() != null)
          {
            paramContext = paramContext.getFilesDir().getPath();
            str1 = paramContext.replaceAll("files$", "") + paramString + "/";
          }
        }
      }
    }
    return str1;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (!MusicUtil.a(paramString))
    {
      str = paramString;
      if (!paramString.endsWith(File.separator)) {
        str = paramString + File.separator;
      }
    }
    return str;
  }
  
  public static void a()
  {
    jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    b = a(jdField_a_of_type_AndroidContentContext, "backuplib");
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      jdField_a_of_type_JavaUtilArrayList.add(str);
      i += 1;
    }
  }
  
  private static void a(String paramString)
  {
    MLog.c("Util4File", "try to copy " + paramString);
    String str = c(paramString);
    try
    {
      boolean bool = a(paramString, str, b);
      MLog.c("Util4File", "copySoFile result = " + bool);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new Native.NativeException("copy file:" + paramString + " failed!", localThrowable);
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: new 88	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   7: ldc 15
    //   9: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_0
    //   13: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 166
    //   18: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_1
    //   25: getstatic 67	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   28: aload_1
    //   29: invokevirtual 169	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   32: ifne +98 -> 130
    //   35: ldc 18
    //   37: new 88	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   44: ldc 171
    //   46: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 173
    //   55: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 139	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: invokestatic 178	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   68: ldc 18
    //   70: new 88	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   77: ldc 171
    //   79: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 180
    //   88: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 139	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: iconst_1
    //   98: ireturn
    //   99: astore_2
    //   100: ldc 18
    //   102: new 88	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   109: ldc 182
    //   111: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 173
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aload_2
    //   127: invokestatic 185	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Error;)V
    //   130: ldc 18
    //   132: new 88	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   139: ldc 171
    //   141: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 187
    //   150: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 139	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: new 189	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile
    //   162: dup
    //   163: new 88	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   170: getstatic 24	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:b	Ljava/lang/String;
    //   173: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokespecial 191	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:<init>	(Ljava/lang/String;)V
    //   186: astore_2
    //   187: aload_2
    //   188: ifnull +194 -> 382
    //   191: aload_2
    //   192: invokevirtual 194	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:d	()Z
    //   195: ifeq +187 -> 382
    //   198: new 88	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   205: getstatic 24	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:b	Ljava/lang/String;
    //   208: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 197	java/lang/System:load	(Ljava/lang/String;)V
    //   221: ldc 18
    //   223: new 88	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   230: ldc 171
    //   232: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_0
    //   236: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 199
    //   241: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 139	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: iconst_1
    //   251: ireturn
    //   252: astore_1
    //   253: ldc 18
    //   255: new 88	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   262: ldc 182
    //   264: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 187
    //   273: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: aload_1
    //   280: invokestatic 185	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Error;)V
    //   283: ldc 18
    //   285: new 88	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   292: ldc 182
    //   294: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_0
    //   298: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 201
    //   303: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 203	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: iconst_0
    //   313: ireturn
    //   314: astore_2
    //   315: ldc 18
    //   317: new 88	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   324: ldc 182
    //   326: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc 173
    //   335: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload_2
    //   342: invokestatic 206	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   345: goto -215 -> 130
    //   348: astore_2
    //   349: ldc 18
    //   351: new 88	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   358: ldc 182
    //   360: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_0
    //   364: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 173
    //   369: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: aload_2
    //   376: invokestatic 185	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Error;)V
    //   379: goto -249 -> 130
    //   382: aload_1
    //   383: invokestatic 208	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:a	(Ljava/lang/String;)V
    //   386: new 88	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   393: getstatic 24	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:b	Ljava/lang/String;
    //   396: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 197	java/lang/System:load	(Ljava/lang/String;)V
    //   409: goto -188 -> 221
    //   412: astore_1
    //   413: ldc 18
    //   415: new 88	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   422: ldc 182
    //   424: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_0
    //   428: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc 187
    //   433: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: aload_1
    //   440: invokestatic 206	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   443: goto -160 -> 283
    //   446: astore_1
    //   447: ldc 18
    //   449: new 88	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   456: ldc 182
    //   458: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload_0
    //   462: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc 187
    //   467: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: aload_1
    //   474: invokestatic 185	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Error;)V
    //   477: goto -194 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	480	0	paramString	String
    //   24	188	1	str	String
    //   252	148	1	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   412	28	1	localException1	java.lang.Exception
    //   446	28	1	localError1	java.lang.Error
    //   99	28	2	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   186	6	2	localQFile	com.tencent.mobileqq.activity.widget.qqmusic.utils.storage.QFile
    //   314	28	2	localException2	java.lang.Exception
    //   348	28	2	localError2	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   35	97	99	java/lang/UnsatisfiedLinkError
    //   130	187	252	java/lang/UnsatisfiedLinkError
    //   191	221	252	java/lang/UnsatisfiedLinkError
    //   221	250	252	java/lang/UnsatisfiedLinkError
    //   382	409	252	java/lang/UnsatisfiedLinkError
    //   35	97	314	java/lang/Exception
    //   35	97	348	java/lang/Error
    //   130	187	412	java/lang/Exception
    //   191	221	412	java/lang/Exception
    //   221	250	412	java/lang/Exception
    //   382	409	412	java/lang/Exception
    //   130	187	446	java/lang/Error
    //   191	221	446	java/lang/Error
    //   221	250	446	java/lang/Error
    //   382	409	446	java/lang/Error
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 5
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 124	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   15: astore 6
    //   17: iload 5
    //   19: istore 4
    //   21: aload 6
    //   23: ifnull +11 -> 34
    //   26: aload_1
    //   27: ifnonnull +13 -> 40
    //   30: iload 5
    //   32: istore 4
    //   34: ldc 2
    //   36: monitorexit
    //   37: iload 4
    //   39: ireturn
    //   40: aload_2
    //   41: ifnull +16 -> 57
    //   44: aload_2
    //   45: astore 6
    //   47: aload_2
    //   48: invokevirtual 211	java/lang/String:trim	()Ljava/lang/String;
    //   51: invokevirtual 215	java/lang/String:length	()I
    //   54: ifne +21 -> 75
    //   57: ldc 18
    //   59: ldc 217
    //   61: invokestatic 203	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: getstatic 124	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   67: invokevirtual 80	android/content/Context:getFilesDir	()Ljava/io/File;
    //   70: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: astore 6
    //   75: new 189	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile
    //   78: dup
    //   79: aload 6
    //   81: invokespecial 191	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 222	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:b	()Z
    //   87: pop
    //   88: ldc 18
    //   90: new 88	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   97: ldc 224
    //   99: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 226
    //   108: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload 6
    //   113: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 139	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: getstatic 124	com/tencent/mobileqq/activity/widget/qqmusic/utils/Util4File:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   125: invokevirtual 230	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   128: aload_1
    //   129: invokevirtual 236	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   132: astore_1
    //   133: new 189	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile
    //   136: dup
    //   137: aload 6
    //   139: aload_0
    //   140: invokespecial 238	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: astore 9
    //   145: aload 9
    //   147: astore_2
    //   148: aload 9
    //   150: invokevirtual 194	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:d	()Z
    //   153: ifeq +20 -> 173
    //   156: aload 9
    //   158: invokevirtual 241	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:e	()Z
    //   161: pop
    //   162: new 189	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile
    //   165: dup
    //   166: aload 6
    //   168: aload_0
    //   169: invokespecial 238	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: astore_2
    //   173: aload_2
    //   174: invokevirtual 243	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:c	()Z
    //   177: pop
    //   178: new 245	java/io/FileOutputStream
    //   181: dup
    //   182: aload_2
    //   183: invokevirtual 247	com/tencent/mobileqq/activity/widget/qqmusic/utils/storage/QFile:a	()Ljava/io/File;
    //   186: invokespecial 250	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   189: astore_0
    //   190: sipush 4096
    //   193: newarray byte
    //   195: astore_2
    //   196: aload_1
    //   197: invokevirtual 255	java/io/InputStream:available	()I
    //   200: ifle +72 -> 272
    //   203: aload_1
    //   204: aload_2
    //   205: invokevirtual 259	java/io/InputStream:read	([B)I
    //   208: istore_3
    //   209: iload_3
    //   210: ifle +62 -> 272
    //   213: aload_0
    //   214: aload_2
    //   215: iconst_0
    //   216: iload_3
    //   217: invokevirtual 263	java/io/FileOutputStream:write	([BII)V
    //   220: goto -24 -> 196
    //   223: astore 6
    //   225: aload_0
    //   226: astore_2
    //   227: aload_1
    //   228: astore_0
    //   229: aload_2
    //   230: astore_1
    //   231: aload 6
    //   233: astore_2
    //   234: aload_2
    //   235: athrow
    //   236: astore 7
    //   238: aload_0
    //   239: astore 6
    //   241: aload_1
    //   242: astore_2
    //   243: aload 7
    //   245: astore_0
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 266	java/io/FileOutputStream:close	()V
    //   254: aload 6
    //   256: ifnull +8 -> 264
    //   259: aload 6
    //   261: invokevirtual 267	java/io/InputStream:close	()V
    //   264: aload_0
    //   265: athrow
    //   266: astore_0
    //   267: ldc 2
    //   269: monitorexit
    //   270: aload_0
    //   271: athrow
    //   272: iconst_1
    //   273: istore 5
    //   275: aload_0
    //   276: ifnull +7 -> 283
    //   279: aload_0
    //   280: invokevirtual 266	java/io/FileOutputStream:close	()V
    //   283: iload 5
    //   285: istore 4
    //   287: aload_1
    //   288: ifnull -254 -> 34
    //   291: aload_1
    //   292: invokevirtual 267	java/io/InputStream:close	()V
    //   295: iload 5
    //   297: istore 4
    //   299: goto -265 -> 34
    //   302: astore_0
    //   303: aconst_null
    //   304: astore 6
    //   306: aload 8
    //   308: astore_2
    //   309: goto -63 -> 246
    //   312: astore_0
    //   313: aload 8
    //   315: astore_2
    //   316: aload_1
    //   317: astore 6
    //   319: goto -73 -> 246
    //   322: astore 6
    //   324: aload_0
    //   325: astore_2
    //   326: aload 6
    //   328: astore_0
    //   329: aload_1
    //   330: astore 6
    //   332: goto -86 -> 246
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_0
    //   338: aload 7
    //   340: astore_1
    //   341: goto -107 -> 234
    //   344: astore_2
    //   345: aload_1
    //   346: astore_0
    //   347: aload 7
    //   349: astore_1
    //   350: goto -116 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramString1	String
    //   0	353	1	paramString2	String
    //   0	353	2	paramString3	String
    //   208	9	3	i	int
    //   19	279	4	bool1	boolean
    //   7	289	5	bool2	boolean
    //   15	152	6	localObject1	Object
    //   223	9	6	localThrowable	Throwable
    //   239	79	6	str1	String
    //   322	5	6	localObject2	Object
    //   330	1	6	str2	String
    //   4	1	7	localObject3	Object
    //   236	112	7	localObject4	Object
    //   1	313	8	localObject5	Object
    //   143	14	9	localQFile	com.tencent.mobileqq.activity.widget.qqmusic.utils.storage.QFile
    // Exception table:
    //   from	to	target	type
    //   190	196	223	java/lang/Throwable
    //   196	209	223	java/lang/Throwable
    //   213	220	223	java/lang/Throwable
    //   234	236	236	finally
    //   12	17	266	finally
    //   47	57	266	finally
    //   57	75	266	finally
    //   75	122	266	finally
    //   250	254	266	finally
    //   259	264	266	finally
    //   264	266	266	finally
    //   279	283	266	finally
    //   291	295	266	finally
    //   122	133	302	finally
    //   133	145	312	finally
    //   148	173	312	finally
    //   173	190	312	finally
    //   190	196	322	finally
    //   196	209	322	finally
    //   213	220	322	finally
    //   122	133	335	java/lang/Throwable
    //   133	145	344	java/lang/Throwable
    //   148	173	344	java/lang/Throwable
    //   173	190	344	java/lang/Throwable
  }
  
  public static String b(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.lastIndexOf("/");
      if (i < paramString.length() - 1)
      {
        String str = paramString.substring(i + 1);
        i = str.lastIndexOf(".");
        paramString = str;
        if (i > 0) {
          paramString = str.substring(0, i);
        }
        return paramString;
      }
    }
    return "";
  }
  
  private static String c(String paramString)
  {
    return "lib/" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.Util4File
 * JD-Core Version:    0.7.0.1
 */