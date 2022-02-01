package cooperation.qzone.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.LogFile;
import com.tencent.qphone.base.util.QLog;
import common.qzone.component.util.SecurityUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mdc;
import mdd;
import mde;
import mdf;

public class QZoneAppCtrlUploadFileLogic
{
  public static final int a = 0;
  public static final String a = "QZoneAppCtrlUploadFileLogic";
  public static final int b = 1;
  public static final String b = "tencent" + File.separator + "zip";
  public static final int c = -1;
  public static final String c = "LOOPMONITOR";
  public static final int d = -2;
  public static final String d = "1";
  public static final int e = -3;
  public static final String e = "0";
  public static final int f = 26214400;
  private static final String f = "anr" + File.separator + "traces.txt";
  private static final int jdField_g_of_type_Int = 100000000;
  private static final String jdField_g_of_type_JavaLangString = "databases";
  private static final String h = "DB";
  private static final String i = "ANR";
  private static final String j = "TRACE";
  private static final String k = "LOGCAT";
  private static final String l = "utf-8";
  
  private static int a(String paramString, File paramFile)
  {
    int m = 0;
    do
    {
      ZipOutputStream localZipOutputStream;
      try
      {
        paramString = new File(paramString);
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramString));
        byte[] arrayOfByte = new byte[1024];
        ZipEntry localZipEntry = new ZipEntry(paramFile.getName());
        localZipEntry.setSize(paramFile.length());
        localZipEntry.setTime(paramFile.lastModified());
        localZipOutputStream.putNextEntry(localZipEntry);
        paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        for (;;)
        {
          int n = paramFile.read(arrayOfByte, 0, 1024);
          if (n == -1) {
            break;
          }
          localZipOutputStream.write(arrayOfByte, 0, n);
        }
        paramFile.close();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: -3");
        }
        m = -3;
        return m;
      }
      localZipOutputStream.close();
      if (paramString.length() >= 26214400L)
      {
        if (!QLog.isDevelopLevel()) {
          break;
        }
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: 26214400");
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("QZoneAppCtrlUploadFileLogic", 4, "stepZipLogFile result: 0");
    return 0;
    return 1;
  }
  
  private int a(String paramString, ArrayList paramArrayList)
  {
    paramString = paramString + ".zip";
    ZipOutputStream localZipOutputStream;
    for (;;)
    {
      try
      {
        paramString = new File(paramString);
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramString));
        byte[] arrayOfByte = new byte[1024];
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break;
        }
        Object localObject = (File)paramArrayList.next();
        ZipEntry localZipEntry = new ZipEntry(((File)localObject).getName());
        localZipEntry.setSize(((File)localObject).length());
        localZipEntry.setTime(((File)localObject).lastModified());
        localZipOutputStream.putNextEntry(localZipEntry);
        localObject = new BufferedInputStream(new FileInputStream((File)localObject));
        int m = ((InputStream)localObject).read(arrayOfByte, 0, 1024);
        if (m != -1) {
          localZipOutputStream.write(arrayOfByte, 0, m);
        } else {
          ((InputStream)localObject).close();
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return -3;
      }
    }
    localZipOutputStream.close();
    long l1 = paramString.length();
    if (l1 >= 26214400L) {
      return 1;
    }
    return 0;
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: invokestatic 190	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   3: invokevirtual 191	java/util/UUID:toString	()Ljava/lang/String;
    //   6: astore_3
    //   7: new 193	java/net/URL
    //   10: dup
    //   11: ldc 195
    //   13: invokespecial 196	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 200	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 202	java/net/HttpURLConnection
    //   22: astore 4
    //   24: aload 4
    //   26: ldc 28
    //   28: invokevirtual 206	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   31: aload 4
    //   33: ldc 28
    //   35: invokevirtual 209	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   38: aload 4
    //   40: iconst_1
    //   41: invokevirtual 213	java/net/HttpURLConnection:setDoInput	(Z)V
    //   44: aload 4
    //   46: iconst_1
    //   47: invokevirtual 216	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   50: aload 4
    //   52: iconst_0
    //   53: invokevirtual 219	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   56: aload 4
    //   58: ldc 221
    //   60: invokevirtual 224	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   63: aload 4
    //   65: ldc 226
    //   67: ldc 45
    //   69: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: aload 4
    //   74: ldc 232
    //   76: ldc 234
    //   78: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload 4
    //   83: ldc 236
    //   85: new 49	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   92: ldc 238
    //   94: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 240
    //   99: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_3
    //   103: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokevirtual 230	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: ifnull +186 -> 299
    //   116: new 242	java/io/DataOutputStream
    //   119: dup
    //   120: aload 4
    //   122: invokevirtual 246	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   125: invokespecial 247	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   128: astore 5
    //   130: new 249	java/lang/StringBuffer
    //   133: dup
    //   134: invokespecial 250	java/lang/StringBuffer:<init>	()V
    //   137: astore 6
    //   139: aload 6
    //   141: ldc 252
    //   143: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   146: pop
    //   147: aload 6
    //   149: aload_3
    //   150: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   153: pop
    //   154: aload 6
    //   156: ldc_w 257
    //   159: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   162: pop
    //   163: aload 6
    //   165: new 49	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 259
    //   175: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 100	java/io/File:getName	()Ljava/lang/String;
    //   182: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 261
    //   188: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 257
    //   194: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   203: pop
    //   204: aload 6
    //   206: new 49	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 263
    //   216: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 257
    //   222: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   231: pop
    //   232: aload 6
    //   234: ldc_w 257
    //   237: invokevirtual 255	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   240: pop
    //   241: aload 5
    //   243: aload 6
    //   245: invokevirtual 264	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   248: invokevirtual 270	java/lang/String:getBytes	()[B
    //   251: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   254: new 123	java/io/FileInputStream
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   262: astore_0
    //   263: sipush 1024
    //   266: newarray byte
    //   268: astore 6
    //   270: aload_0
    //   271: aload 6
    //   273: invokevirtual 276	java/io/InputStream:read	([B)I
    //   276: istore_2
    //   277: iload_2
    //   278: iconst_m1
    //   279: if_icmpeq +23 -> 302
    //   282: aload 5
    //   284: aload 6
    //   286: iconst_0
    //   287: iload_2
    //   288: invokevirtual 277	java/io/DataOutputStream:write	([BII)V
    //   291: goto -21 -> 270
    //   294: astore_0
    //   295: aload_0
    //   296: invokevirtual 278	java/net/MalformedURLException:printStackTrace	()V
    //   299: ldc 24
    //   301: areturn
    //   302: aload_0
    //   303: invokevirtual 154	java/io/InputStream:close	()V
    //   306: aload 5
    //   308: ldc_w 257
    //   311: invokevirtual 270	java/lang/String:getBytes	()[B
    //   314: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   317: aload 5
    //   319: new 49	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   326: ldc 252
    //   328: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_3
    //   332: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 257
    //   338: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 270	java/lang/String:getBytes	()[B
    //   347: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   350: new 49	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   357: astore_0
    //   358: aload_0
    //   359: new 49	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 280
    //   369: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc_w 257
    //   375: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_0
    //   386: ldc_w 257
    //   389: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_0
    //   394: new 49	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   401: aload_1
    //   402: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc_w 257
    //   408: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_0
    //   419: new 49	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   426: ldc 252
    //   428: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_3
    //   432: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 252
    //   437: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc_w 257
    //   443: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload 5
    //   455: aload_0
    //   456: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokevirtual 270	java/lang/String:getBytes	()[B
    //   462: invokevirtual 273	java/io/DataOutputStream:write	([B)V
    //   465: aload 5
    //   467: invokevirtual 283	java/io/DataOutputStream:flush	()V
    //   470: aload 4
    //   472: invokevirtual 287	java/net/HttpURLConnection:getResponseCode	()I
    //   475: sipush 200
    //   478: if_icmpne -179 -> 299
    //   481: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   484: ifeq +12 -> 496
    //   487: ldc 10
    //   489: iconst_4
    //   490: ldc_w 289
    //   493: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: ldc 20
    //   498: areturn
    //   499: astore_0
    //   500: aload_0
    //   501: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   504: goto -205 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	paramFile	File
    //   0	507	1	paramString	String
    //   276	12	2	m	int
    //   6	426	3	str	String
    //   22	449	4	localHttpURLConnection	java.net.HttpURLConnection
    //   128	338	5	localDataOutputStream	java.io.DataOutputStream
    //   137	148	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	112	294	java/net/MalformedURLException
    //   116	270	294	java/net/MalformedURLException
    //   270	277	294	java/net/MalformedURLException
    //   282	291	294	java/net/MalformedURLException
    //   302	496	294	java/net/MalformedURLException
    //   7	112	499	java/io/IOException
    //   116	270	499	java/io/IOException
    //   270	277	499	java/io/IOException
    //   282	291	499	java/io/IOException
    //   302	496	499	java/io/IOException
  }
  
  private static void a(int paramInt) {}
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    do
    {
      String str;
      do
      {
        return;
        str = SecurityUtil.a(paramString);
        paramContext = paramContext.getFilesDir().getParent() + File.separator + "databases" + File.separator + str;
        str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "DB";
        File localFile = new File(str);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        str = str + File.separator + "upload.log.zip";
        if (QLog.isDevelopLevel())
        {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "DB zip filepath: " + str);
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "DB file: " + paramContext);
        }
        paramContext = new File(paramContext);
      } while (!paramContext.exists());
      m = a(str, paramContext);
      if (m == 1)
      {
        a(m);
        a(str);
        return;
      }
      if (m != 0) {
        break;
      }
      b(str);
      paramContext = new File(str);
    } while (!paramContext.exists());
    a(paramContext, paramString);
    return;
    b(m);
  }
  
  public static void a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramLong1 <= 0L) || (paramLong2 <= paramLong1));
        localObject1 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "tencent" + File.separator + "MobileQQ" + File.separator + "trace").listFiles(new mdc(paramLong1, paramLong2));
        localObject2 = new mdd();
        paramContext = new ArrayList();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logFiles length" + localObject1.length);
          }
          int n = localObject1.length;
          m = 0;
          while (m < n)
          {
            paramContext.add(new ShareAppLogHelper.LogFile(localObject1[m].getPath()));
            Collections.sort(paramContext, (Comparator)localObject2);
            m += 1;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "find file: " + paramContext.size());
        }
      } while (paramContext.size() == 0);
      Object localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "TRACE";
      Object localObject1 = (String)localObject2 + File.separator + "upload.log.zip";
      localObject2 = new File((String)localObject2);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "trace zip filepath: " + (String)localObject1);
      }
      m = a((String)localObject1, (File)paramContext.get(paramContext.size() - 1));
      if (m == 1)
      {
        a(m);
        a((String)localObject1);
        return;
      }
      if (m != 0) {
        break;
      }
      b((String)localObject1);
      paramContext = new File((String)localObject1);
    } while (!paramContext.exists());
    a(paramContext, paramString);
    return;
    b(m);
  }
  
  public static void a(Context paramContext, String paramString, File paramFile)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLooperMonitor start zip");
    }
    if ((paramFile == null) || (!paramFile.exists())) {}
    int m;
    do
    {
      return;
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "LOOPMONITOR";
      paramContext = (String)localObject + File.separator + "upload.log.zip";
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (QLog.isDevelopLevel())
      {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "LooperMonitor zip filepath: " + paramContext);
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "LooperMonitor file:" + paramFile.getAbsolutePath());
      }
      m = a(paramContext, paramFile);
      if (m == 1)
      {
        a(m);
        a(paramContext);
        return;
      }
      if (m != 0) {
        break;
      }
      b(paramContext);
      paramContext = new File(paramContext);
    } while (!paramContext.exists());
    a(paramContext, paramString);
    return;
    b(m);
  }
  
  private static void a(String paramString)
  {
    new mdf(paramString).start();
  }
  
  private static void b(int paramInt) {}
  
  public static void b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    do
    {
      Object localObject1;
      do
      {
        return;
        localObject1 = Environment.getDataDirectory().getAbsolutePath() + File.separator + f;
        Object localObject2 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "ANR";
        paramContext = (String)localObject2 + File.separator + "upload.log.zip";
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          ((File)localObject2).mkdirs();
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "anr zip filepath: " + paramContext);
          QLog.d("QZoneAppCtrlUploadFileLogic", 4, "anr file:" + (String)localObject1);
        }
        localObject1 = new File((String)localObject1);
      } while (!((File)localObject1).exists());
      m = a(paramContext, (File)localObject1);
      if (m == 1)
      {
        a(m);
        a(paramContext);
        return;
      }
      if (m != 0) {
        break;
      }
      b(paramContext);
      paramContext = new File(paramContext);
    } while (!paramContext.exists());
    a(paramContext, paramString);
    return;
    b(m);
  }
  
  private static void b(String paramString) {}
  
  public static void c(Context paramContext, String paramString)
  {
    new Thread(new mde(paramContext, paramString), "aysUploadLogcatFile").start();
  }
  
  /* Error */
  public static void d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 431	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc_w 433
    //   6: invokevirtual 437	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: invokevirtual 443	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   12: astore 9
    //   14: invokestatic 446	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   17: ldc_w 448
    //   20: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +473 -> 496
    //   26: new 60	java/io/File
    //   29: dup
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   37: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   49: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: getstatic 77	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:b	Ljava/lang/String;
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 42
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 8
    //   77: aload 8
    //   79: invokevirtual 322	java/io/File:exists	()Z
    //   82: ifne +45 -> 127
    //   85: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   88: ifeq +33 -> 121
    //   91: ldc 10
    //   93: iconst_4
    //   94: new 49	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 453
    //   104: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 8
    //   109: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 8
    //   123: invokevirtual 325	java/io/File:mkdirs	()Z
    //   126: pop
    //   127: new 60	java/io/File
    //   130: dup
    //   131: new 49	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 77	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:b	Ljava/lang/String;
    //   156: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 42
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   173: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 455
    //   183: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 8
    //   194: aload 8
    //   196: invokevirtual 322	java/io/File:exists	()Z
    //   199: ifne +303 -> 502
    //   202: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +33 -> 238
    //   208: ldc 10
    //   210: iconst_4
    //   211: new 49	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 457
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 8
    //   226: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   229: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload 8
    //   240: invokevirtual 460	java/io/File:createNewFile	()Z
    //   243: pop
    //   244: goto +258 -> 502
    //   247: sipush 1024
    //   250: newarray byte
    //   252: astore 10
    //   254: ldc_w 461
    //   257: istore_2
    //   258: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   261: ifeq +12 -> 273
    //   264: ldc 10
    //   266: iconst_4
    //   267: ldc_w 463
    //   270: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: new 89	java/io/FileOutputStream
    //   276: dup
    //   277: aload 8
    //   279: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   282: astore 8
    //   284: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   287: lstore 4
    //   289: iload_2
    //   290: ifle +78 -> 368
    //   293: invokestatic 468	java/lang/System:currentTimeMillis	()J
    //   296: lstore 6
    //   298: lload 6
    //   300: lload 4
    //   302: lsub
    //   303: ldc2_w 469
    //   306: lcmp
    //   307: ifle +77 -> 384
    //   310: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   313: ifeq +55 -> 368
    //   316: ldc 10
    //   318: iconst_4
    //   319: new 49	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 472
    //   329: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: lload 6
    //   334: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: ldc_w 477
    //   340: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: lload 4
    //   345: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: ldc_w 479
    //   351: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: lload 6
    //   356: lload 4
    //   358: lsub
    //   359: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   362: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload 8
    //   370: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   373: aload_0
    //   374: aload_1
    //   375: invokestatic 482	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   378: aload 9
    //   380: invokevirtual 154	java/io/InputStream:close	()V
    //   383: return
    //   384: aload 9
    //   386: aload 10
    //   388: iconst_0
    //   389: iload_2
    //   390: aload 10
    //   392: arraylength
    //   393: invokestatic 488	java/lang/Math:min	(II)I
    //   396: invokevirtual 133	java/io/InputStream:read	([BII)I
    //   399: istore_3
    //   400: iload_3
    //   401: iconst_m1
    //   402: if_icmpne +78 -> 480
    //   405: new 490	java/io/EOFException
    //   408: dup
    //   409: ldc_w 492
    //   412: invokespecial 493	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   415: athrow
    //   416: astore 10
    //   418: aload 8
    //   420: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   423: aload_0
    //   424: aload_1
    //   425: invokestatic 482	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   428: aload 10
    //   430: athrow
    //   431: astore_0
    //   432: aload 9
    //   434: invokevirtual 154	java/io/InputStream:close	()V
    //   437: aload_0
    //   438: athrow
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   444: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   447: ifeq -64 -> 383
    //   450: ldc 10
    //   452: iconst_4
    //   453: new 49	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 495
    //   463: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_0
    //   467: invokevirtual 496	java/io/IOException:toString	()Ljava/lang/String;
    //   470: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: return
    //   480: aload 8
    //   482: aload 10
    //   484: iconst_0
    //   485: iload_3
    //   486: invokevirtual 497	java/io/FileOutputStream:write	([BII)V
    //   489: iload_2
    //   490: iload_3
    //   491: isub
    //   492: istore_2
    //   493: goto -204 -> 289
    //   496: aconst_null
    //   497: astore 8
    //   499: goto -252 -> 247
    //   502: goto -255 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramContext	Context
    //   0	505	1	paramString	String
    //   257	236	2	m	int
    //   399	93	3	n	int
    //   287	70	4	l1	long
    //   296	59	6	l2	long
    //   75	423	8	localObject	Object
    //   12	421	9	localInputStream	InputStream
    //   252	139	10	arrayOfByte1	byte[]
    //   416	67	10	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   284	289	416	finally
    //   293	298	416	finally
    //   310	368	416	finally
    //   384	400	416	finally
    //   405	416	416	finally
    //   480	489	416	finally
    //   273	284	431	finally
    //   368	378	431	finally
    //   418	431	431	finally
    //   0	121	439	java/io/IOException
    //   121	127	439	java/io/IOException
    //   127	238	439	java/io/IOException
    //   238	244	439	java/io/IOException
    //   247	254	439	java/io/IOException
    //   258	273	439	java/io/IOException
    //   378	383	439	java/io/IOException
    //   432	439	439	java/io/IOException
  }
  
  /* Error */
  public static void e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 431	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: ldc_w 433
    //   6: invokevirtual 437	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   9: invokevirtual 443	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   12: astore 5
    //   14: invokestatic 446	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   17: ldc_w 448
    //   20: invokevirtual 451	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifeq +378 -> 401
    //   26: new 60	java/io/File
    //   29: dup
    //   30: new 49	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   37: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   40: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   49: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: getstatic 77	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:b	Ljava/lang/String;
    //   55: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   61: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 42
    //   66: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: aload 4
    //   79: invokevirtual 322	java/io/File:exists	()Z
    //   82: ifne +45 -> 127
    //   85: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   88: ifeq +33 -> 121
    //   91: ldc 10
    //   93: iconst_4
    //   94: new 49	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 453
    //   104: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 4
    //   109: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 4
    //   123: invokevirtual 325	java/io/File:mkdirs	()Z
    //   126: pop
    //   127: new 60	java/io/File
    //   130: dup
    //   131: new 49	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   141: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   144: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   150: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 77	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:b	Ljava/lang/String;
    //   156: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc 42
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: getstatic 63	java/io/File:separator	Ljava/lang/String;
    //   173: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 455
    //   183: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 4
    //   194: aload 4
    //   196: invokevirtual 322	java/io/File:exists	()Z
    //   199: ifne +208 -> 407
    //   202: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   205: ifeq +33 -> 238
    //   208: ldc 10
    //   210: iconst_4
    //   211: new 49	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 457
    //   221: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 4
    //   226: invokevirtual 319	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   229: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: aload 4
    //   240: invokevirtual 460	java/io/File:createNewFile	()Z
    //   243: pop
    //   244: goto +163 -> 407
    //   247: sipush 1024
    //   250: newarray byte
    //   252: astore 6
    //   254: ldc_w 498
    //   257: istore_2
    //   258: new 89	java/io/FileOutputStream
    //   261: dup
    //   262: aload 4
    //   264: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   267: astore 4
    //   269: iload_2
    //   270: ifle +115 -> 385
    //   273: aload 5
    //   275: aload 6
    //   277: iconst_0
    //   278: iload_2
    //   279: aload 6
    //   281: arraylength
    //   282: invokestatic 488	java/lang/Math:min	(II)I
    //   285: invokevirtual 133	java/io/InputStream:read	([BII)I
    //   288: istore_3
    //   289: iload_3
    //   290: iconst_m1
    //   291: if_icmpne +78 -> 369
    //   294: new 490	java/io/EOFException
    //   297: dup
    //   298: ldc_w 492
    //   301: invokespecial 493	java/io/EOFException:<init>	(Ljava/lang/String;)V
    //   304: athrow
    //   305: astore 6
    //   307: aload 4
    //   309: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   312: aload_0
    //   313: aload_1
    //   314: invokestatic 482	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   317: aload 6
    //   319: athrow
    //   320: astore_0
    //   321: aload 5
    //   323: invokevirtual 154	java/io/InputStream:close	()V
    //   326: aload_0
    //   327: athrow
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 290	java/io/IOException:printStackTrace	()V
    //   333: invokestatic 146	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   336: ifeq +32 -> 368
    //   339: ldc 10
    //   341: iconst_4
    //   342: new 49	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 495
    //   352: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: invokevirtual 496	java/io/IOException:toString	()Ljava/lang/String;
    //   359: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: return
    //   369: aload 4
    //   371: aload 6
    //   373: iconst_0
    //   374: iload_3
    //   375: invokevirtual 497	java/io/FileOutputStream:write	([BII)V
    //   378: iload_2
    //   379: iload_3
    //   380: isub
    //   381: istore_2
    //   382: goto -113 -> 269
    //   385: aload 4
    //   387: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   390: aload_0
    //   391: aload_1
    //   392: invokestatic 482	cooperation/qzone/util/QZoneAppCtrlUploadFileLogic:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   395: aload 5
    //   397: invokevirtual 154	java/io/InputStream:close	()V
    //   400: return
    //   401: aconst_null
    //   402: astore 4
    //   404: goto -157 -> 247
    //   407: goto -160 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramString	String
    //   257	125	2	m	int
    //   288	93	3	n	int
    //   75	328	4	localObject	Object
    //   12	384	5	localInputStream	InputStream
    //   252	28	6	arrayOfByte1	byte[]
    //   305	67	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   273	289	305	finally
    //   294	305	305	finally
    //   369	378	305	finally
    //   258	269	320	finally
    //   307	320	320	finally
    //   385	395	320	finally
    //   0	121	328	java/io/IOException
    //   121	127	328	java/io/IOException
    //   127	238	328	java/io/IOException
    //   238	244	328	java/io/IOException
    //   247	254	328	java/io/IOException
    //   321	328	328	java/io/IOException
    //   395	400	328	java/io/IOException
  }
  
  public static void f(Context paramContext, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneAppCtrlUploadFileLogic", 4, "uploadLogcat start zip");
    }
    paramContext = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "LOGCAT" + File.separator + paramString + "logcatwyx.txt");
    if (!paramContext.exists()) {}
    int m;
    do
    {
      return;
      Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + b + File.separator + "LOGCAT";
      String str = (String)localObject + File.separator + "upload.log.zip";
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (QLog.isDevelopLevel())
      {
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logcat zip filepath: " + str);
        QLog.d("QZoneAppCtrlUploadFileLogic", 4, "logcat file:" + paramContext.getAbsolutePath());
      }
      m = a(str, paramContext);
      if (m == 1)
      {
        a(m);
        a(str);
        return;
      }
      if (m != 0) {
        break;
      }
      b(str);
      paramContext = new File(str);
    } while (!paramContext.exists());
    a(paramContext, paramString);
    return;
    b(m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qzone.util.QZoneAppCtrlUploadFileLogic
 * JD-Core Version:    0.7.0.1
 */