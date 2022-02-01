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
import org.json.JSONObject;

public class jj
{
  public static int a = 3;
  
  private static void a(final String paramString, File paramFile, final a parama)
  {
    try
    {
      APLog.flush();
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            final long l = System.currentTimeMillis();
            APDataReportManager.getInstance().insertData("sdk.log.upload", 0);
            ji localji = new ji();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("upload file: ");
            localStringBuilder.append(this.a.getName());
            APLog.e("LOG-UPLOAD", localStringBuilder.toString());
            if (!this.a.exists())
            {
              APLog.e("LOG-UPLOAD", "file is not exists");
              return;
            }
            localji.a(String.valueOf(this.a.length()));
            localji.e("openid", paramString);
            localji.a(this.a);
            new md().a(localji).a(new kl()
            {
              public void a_(kz paramAnonymous2kz)
              {
                APDataReportManager localAPDataReportManager;
                StringBuilder localStringBuilder;
                if ((paramAnonymous2kz.a != 200) || (paramAnonymous2kz.c != null))
                {
                  localAPDataReportManager = APDataReportManager.getInstance();
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("code: ");
                  localStringBuilder.append(paramAnonymous2kz.a);
                  localStringBuilder.append(" exception: ");
                  if (paramAnonymous2kz.c == null) {
                    localObject = "null";
                  } else {
                    localObject = paramAnonymous2kz.c.getMessage();
                  }
                  localStringBuilder.append((String)localObject);
                  localAPDataReportManager.insertData("sdk.log.upload.fail", 0, "", "", localStringBuilder.toString());
                }
                Object localObject = new StringBuilder();
                ((StringBuilder)localObject).append("response: ");
                ((StringBuilder)localObject).append(paramAnonymous2kz.b);
                APLog.d("LOG-UPLOAD", ((StringBuilder)localObject).toString());
                try
                {
                  if (paramAnonymous2kz.b != null)
                  {
                    localObject = new JSONObject(paramAnonymous2kz.b);
                    localAPDataReportManager = APDataReportManager.getInstance();
                    long l = l;
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("status=");
                    localStringBuilder.append(paramAnonymous2kz.a);
                    localStringBuilder.append("&ret=");
                    localStringBuilder.append(((JSONObject)localObject).optString("ret"));
                    localAPDataReportManager.a("sdk.log.upload.time", l, localStringBuilder.toString());
                  }
                }
                catch (Throwable paramAnonymous2kz)
                {
                  paramAnonymous2kz.printStackTrace();
                }
                try
                {
                  paramAnonymous2kz = jj.3.this.a.getPath();
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramAnonymous2kz);
                  ((StringBuilder)localObject).append(".gzip");
                  localObject = new File(((StringBuilder)localObject).toString());
                  if (((File)localObject).exists()) {
                    ((File)localObject).delete();
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append(paramAnonymous2kz);
                  ((StringBuilder)localObject).append(".gzip.encode");
                  paramAnonymous2kz = new File(((StringBuilder)localObject).toString());
                  if (paramAnonymous2kz.exists()) {
                    paramAnonymous2kz.delete();
                  }
                }
                catch (Throwable paramAnonymous2kz)
                {
                  paramAnonymous2kz.printStackTrace();
                }
                if (jj.3.this.c != null) {
                  jj.3.this.c.a();
                }
              }
            });
            return;
          }
          catch (Throwable localThrowable)
          {
            APLog.e("LOG-UPLOAD", localThrowable.getMessage());
            APDataReportManager.getInstance().insertData("sdk.log.error.upload", 0, "", "", localThrowable.getMessage());
          }
        }
      }, "Thread-Log-Upload").start();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      APLog.e("LOG-UPLOAD", paramString.getMessage());
      APDataReportManager.getInstance().insertData("sdk.log.error.upload", 0, "", "", paramString.getMessage());
    }
  }
  
  private static void a(String paramString1, String paramString2)
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
        arrayOfFile1 = localFile.listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymousFile, String paramAnonymousString)
          {
            return (paramAnonymousString.startsWith(this.a)) && (paramAnonymousString.endsWith(".txt"));
          }
        });
        Arrays.sort(arrayOfFile1, new Comparator()
        {
          public int a(File paramAnonymousFile1, File paramAnonymousFile2)
          {
            try
            {
              int i = Integer.valueOf(paramAnonymousFile1.getName().substring(this.a.length() + 1, 13)).compareTo(Integer.valueOf(paramAnonymousFile2.getName().substring(this.a.length() + 1, 13)));
              return i;
            }
            catch (Exception paramAnonymousFile1)
            {
              label48:
              break label48;
            }
            return 0;
          }
        });
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
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString2 != null) && (!paramString2.isEmpty()))
    {
      a(paramString1, paramString2);
      return;
    }
    b(paramString1, paramString3);
  }
  
  private static boolean a()
  {
    Object localObject = new fz();
    String str1 = ((fz)localObject).a(a.a().d, "TencentUnipay", "logUploadTimes");
    int i;
    if (TextUtils.isEmpty(str1)) {
      i = 0;
    } else {
      i = i.a(str1);
    }
    String str2 = ((fz)localObject).a(a.a().d, "TencentUnipay", "logUploadDate");
    localObject = "";
    try
    {
      str1 = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
      localObject = str1;
    }
    catch (Exception localException)
    {
      label86:
      break label86;
    }
    APLog.e("LOG-UPLOAD", "get today string error");
    if (!((String)localObject).equals(str2)) {
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
  
  private static void b()
  {
    fz localfz = new fz();
    Object localObject = "";
    try
    {
      str1 = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date());
      localObject = str1;
    }
    catch (Exception localException)
    {
      String str1;
      label39:
      String str2;
      int i;
      break label39;
    }
    APLog.e("LOG-UPLOAD", "get today string error");
    str1 = localfz.a(a.a().d, "TencentUnipay", "logUploadDate");
    str2 = localfz.a(a.a().d, "TencentUnipay", "logUploadTimes");
    if (TextUtils.isEmpty(str2)) {
      i = 0;
    } else {
      i = i.a(str2);
    }
    if (!((String)localObject).equals(str1)) {
      localfz.a(a.a().d, "TencentUnipay", "logUploadTimes", "1");
    } else {
      i += 1;
    }
    localfz.a(a.a().d, "TencentUnipay", "logUploadDate", (String)localObject);
    localfz.a(a.a().d, "TencentUnipay", "logUploadTimes", String.valueOf(i));
  }
  
  private static void b(String paramString1, String paramString2)
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
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jj
 * JD-Core Version:    0.7.0.1
 */