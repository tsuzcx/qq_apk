package midas.x;

import android.text.TextUtils;
import com.pay.data.report.APDataReportManager;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.log.APLogFileInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class p9
{
  public static int a = 3;
  
  public static void a(final String paramString, File paramFile, final d paramd)
  {
    try
    {
      APLog.flush();
      new Thread(new c(paramFile, paramString, paramd), "Thread-Log-Upload").start();
      return;
    }
    finally
    {
      paramString.printStackTrace();
      APLog.e("LOG-UPLOAD", paramString.getMessage());
      APDataReportManager.getInstance().insertData("sdk.log.error.upload", 0, "", "", paramString.getMessage());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2);
    if ((((File)localObject).exists()) && (((File)localObject).isFile()))
    {
      a(paramString1, (File)localObject, null);
      return;
    }
    paramString1 = APDataReportManager.getInstance();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not find file: ");
    ((StringBuilder)localObject).append(paramString2);
    paramString1.insertData("sdk.log.error.upload", 0, "", "", ((StringBuilder)localObject).toString());
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      b(paramString1, paramString2);
      return;
    }
    a(paramString1, paramString3);
  }
  
  public static boolean a()
  {
    Object localObject = new d6();
    String str = ((d6)localObject).a(a.r().d, "TencentUnipay", "logUploadTimes");
    int i;
    if (TextUtils.isEmpty(str)) {
      i = 0;
    } else {
      i = i.b(str);
    }
    str = ((d6)localObject).a(a.r().d, "TencentUnipay", "logUploadDate");
    try
    {
      localObject = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
    }
    catch (Exception localException)
    {
      label81:
      break label81;
    }
    APLog.e("LOG-UPLOAD", "get today string error");
    localObject = "";
    if (!((String)localObject).equals(str)) {
      return true;
    }
    if (i >= a)
    {
      APLog.e("LOG-UPLOAD", "upload too much times, try next day");
      APDataReportManager.getInstance().insertData("sdk.log.upload.too.much", 0);
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    d6 locald6 = new d6();
    try
    {
      str1 = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
    }
    catch (Exception localException)
    {
      String str1;
      label34:
      String str2;
      String str3;
      int i;
      break label34;
    }
    APLog.e("LOG-UPLOAD", "get today string error");
    str1 = "";
    str2 = locald6.a(a.r().d, "TencentUnipay", "logUploadDate");
    str3 = locald6.a(a.r().d, "TencentUnipay", "logUploadTimes");
    if (TextUtils.isEmpty(str3)) {
      i = 0;
    } else {
      i = i.b(str3);
    }
    if (!str1.equals(str2)) {
      locald6.a(a.r().d, "TencentUnipay", "logUploadTimes", "1");
    } else {
      i += 1;
    }
    locald6.a(a.r().d, "TencentUnipay", "logUploadDate", str1);
    locald6.a(a.r().d, "TencentUnipay", "logUploadTimes", String.valueOf(i));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (!a()) {
      return;
    }
    b();
    int j = 0;
    File[] arrayOfFile2 = new File[0];
    File localFile = new File(APLogFileInfo.dirName);
    int i = j;
    File[] arrayOfFile1 = arrayOfFile2;
    if (localFile.exists())
    {
      i = j;
      arrayOfFile1 = arrayOfFile2;
      if (localFile.isDirectory())
      {
        arrayOfFile1 = localFile.listFiles(new a(paramString2));
        Arrays.sort(arrayOfFile1, new b(paramString2));
        Collections.reverse(Arrays.asList(arrayOfFile1));
        paramString2 = new StringBuilder();
        paramString2.append("files: ");
        paramString2.append(Arrays.toString(arrayOfFile1));
        APLog.d("LOG-UPLOAD", paramString2.toString());
        i = j;
      }
    }
    while (i < arrayOfFile1.length)
    {
      if (i < 2) {
        a(paramString1, arrayOfFile1[i], null);
      }
      i += 1;
    }
  }
  
  public static final class a
    implements FilenameFilter
  {
    public a(String paramString) {}
    
    public boolean accept(File paramFile, String paramString)
    {
      return (paramString.startsWith(this.a)) && (paramString.endsWith(".txt"));
    }
  }
  
  public static final class b
    implements Comparator<File>
  {
    public b(String paramString) {}
    
    public int a(File paramFile1, File paramFile2)
    {
      try
      {
        int i = Integer.valueOf(paramFile1.getName().substring(this.a.length() + 1, 13)).compareTo(Integer.valueOf(paramFile2.getName().substring(this.a.length() + 1, 13)));
        return i;
      }
      catch (Exception paramFile1)
      {
        label48:
        break label48;
      }
      return 0;
    }
  }
  
  public static final class c
    implements Runnable
  {
    public c(File paramFile, String paramString, p9.d paramd) {}
    
    public void run()
    {
      try
      {
        final long l = System.currentTimeMillis();
        APDataReportManager.getInstance().insertData("sdk.log.upload", 0);
        o9 localo9 = new o9();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upload file: ");
        localStringBuilder.append(this.a.getName());
        APLog.e("LOG-UPLOAD", localStringBuilder.toString());
        if (!this.a.exists())
        {
          APLog.e("LOG-UPLOAD", "file is not exists");
          return;
        }
        localo9.d(String.valueOf(this.a.length()));
        localo9.b("openid", paramString);
        localo9.a(this.a);
        new mc().a(localo9).a(new a(l));
        return;
      }
      finally
      {
        APLog.e("LOG-UPLOAD", localObject.getMessage());
        APDataReportManager.getInstance().insertData("sdk.log.error.upload", 0, "", "", localObject.getMessage());
      }
    }
    
    public class a
      implements ra
    {
      public a(long paramLong) {}
      
      /* Error */
      public void a(gb paramgb)
      {
        // Byte code:
        //   0: aload_1
        //   1: getfield 30	midas/x/gb:a	I
        //   4: sipush 200
        //   7: if_icmpne +10 -> 17
        //   10: aload_1
        //   11: getfield 34	midas/x/gb:c	Ljava/lang/Exception;
        //   14: ifnull +93 -> 107
        //   17: invokestatic 40	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
        //   20: astore 5
        //   22: new 42	java/lang/StringBuilder
        //   25: dup
        //   26: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   29: astore 6
        //   31: aload 6
        //   33: ldc 45
        //   35: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: pop
        //   39: aload 6
        //   41: aload_1
        //   42: getfield 30	midas/x/gb:a	I
        //   45: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   48: pop
        //   49: aload 6
        //   51: ldc 54
        //   53: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   56: pop
        //   57: aload_1
        //   58: getfield 34	midas/x/gb:c	Ljava/lang/Exception;
        //   61: astore 4
        //   63: aload 4
        //   65: ifnonnull +10 -> 75
        //   68: ldc 56
        //   70: astore 4
        //   72: goto +10 -> 82
        //   75: aload 4
        //   77: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   80: astore 4
        //   82: aload 6
        //   84: aload 4
        //   86: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   89: pop
        //   90: aload 5
        //   92: ldc 64
        //   94: iconst_0
        //   95: ldc 66
        //   97: ldc 66
        //   99: aload 6
        //   101: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   104: invokevirtual 73	com/pay/data/report/APDataReportManager:insertData	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   107: new 42	java/lang/StringBuilder
        //   110: dup
        //   111: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   114: astore 4
        //   116: aload 4
        //   118: ldc 75
        //   120: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   123: pop
        //   124: aload 4
        //   126: aload_1
        //   127: getfield 78	midas/x/gb:b	Ljava/lang/String;
        //   130: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   133: pop
        //   134: ldc 80
        //   136: aload 4
        //   138: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   141: invokestatic 86	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   144: aload_1
        //   145: getfield 78	midas/x/gb:b	Ljava/lang/String;
        //   148: ifnull +95 -> 243
        //   151: new 88	org/json/JSONObject
        //   154: dup
        //   155: aload_1
        //   156: getfield 78	midas/x/gb:b	Ljava/lang/String;
        //   159: invokespecial 91	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   162: astore 4
        //   164: invokestatic 40	com/pay/data/report/APDataReportManager:getInstance	()Lcom/pay/data/report/APDataReportManager;
        //   167: astore 5
        //   169: aload_0
        //   170: getfield 21	midas/x/p9$c$a:a	J
        //   173: lstore_2
        //   174: new 42	java/lang/StringBuilder
        //   177: dup
        //   178: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   181: astore 6
        //   183: aload 6
        //   185: ldc 93
        //   187: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: pop
        //   191: aload 6
        //   193: aload_1
        //   194: getfield 30	midas/x/gb:a	I
        //   197: invokevirtual 52	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   200: pop
        //   201: aload 6
        //   203: ldc 95
        //   205: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   208: pop
        //   209: aload 6
        //   211: aload 4
        //   213: ldc 97
        //   215: invokevirtual 101	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   218: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   221: pop
        //   222: aload 5
        //   224: ldc 103
        //   226: lload_2
        //   227: aload 6
        //   229: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   232: invokevirtual 106	com/pay/data/report/APDataReportManager:a	(Ljava/lang/String;JLjava/lang/String;)V
        //   235: goto +8 -> 243
        //   238: astore_1
        //   239: aload_1
        //   240: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
        //   243: aload_0
        //   244: getfield 19	midas/x/p9$c$a:b	Lmidas/x/p9$c;
        //   247: getfield 114	midas/x/p9$c:a	Ljava/io/File;
        //   250: invokevirtual 119	java/io/File:getPath	()Ljava/lang/String;
        //   253: astore_1
        //   254: new 42	java/lang/StringBuilder
        //   257: dup
        //   258: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   261: astore 4
        //   263: aload 4
        //   265: aload_1
        //   266: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   269: pop
        //   270: aload 4
        //   272: ldc 121
        //   274: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   277: pop
        //   278: new 116	java/io/File
        //   281: dup
        //   282: aload 4
        //   284: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   287: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
        //   290: astore 4
        //   292: aload 4
        //   294: invokevirtual 126	java/io/File:exists	()Z
        //   297: ifeq +9 -> 306
        //   300: aload 4
        //   302: invokevirtual 129	java/io/File:delete	()Z
        //   305: pop
        //   306: new 42	java/lang/StringBuilder
        //   309: dup
        //   310: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   313: astore 4
        //   315: aload 4
        //   317: aload_1
        //   318: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   321: pop
        //   322: aload 4
        //   324: ldc 131
        //   326: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   329: pop
        //   330: new 116	java/io/File
        //   333: dup
        //   334: aload 4
        //   336: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   339: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
        //   342: astore_1
        //   343: aload_1
        //   344: invokevirtual 126	java/io/File:exists	()Z
        //   347: ifeq +16 -> 363
        //   350: aload_1
        //   351: invokevirtual 129	java/io/File:delete	()Z
        //   354: pop
        //   355: goto +8 -> 363
        //   358: astore_1
        //   359: aload_1
        //   360: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
        //   363: aload_0
        //   364: getfield 19	midas/x/p9$c$a:b	Lmidas/x/p9$c;
        //   367: getfield 134	midas/x/p9$c:c	Lmidas/x/p9$d;
        //   370: astore_1
        //   371: aload_1
        //   372: ifnull +9 -> 381
        //   375: aload_1
        //   376: invokeinterface 138 1 0
        //   381: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	382	0	this	a
        //   0	382	1	paramgb	gb
        //   173	54	2	l	long
        //   61	274	4	localObject	Object
        //   20	203	5	localAPDataReportManager	APDataReportManager
        //   29	199	6	localStringBuilder	StringBuilder
        // Exception table:
        //   from	to	target	type
        //   144	235	238	finally
        //   243	306	358	finally
        //   306	355	358	finally
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.p9
 * JD-Core Version:    0.7.0.1
 */