package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APMidasRSATools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

public class l
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private boolean e = false;
  
  public static l a()
  {
    return a.a();
  }
  
  private void a(final Context paramContext, String paramString1, final String paramString2)
  {
    final String str = paramString1;
    if (paramString1.startsWith("http://"))
    {
      str = paramString1.replace("http://", "https://");
      paramString1 = new StringBuilder();
      paramString1.append("download() force download with https url = ");
      paramString1.append(str);
      APLog.d("APMidasUpdateJS", paramString1.toString());
    }
    new Thread()
    {
      public void run()
      {
        super.run();
        try
        {
          Object localObject2 = new URL(str);
          Object localObject1 = (HttpURLConnection)((URL)localObject2).openConnection();
          ((HttpURLConnection)localObject1).setConnectTimeout(15000);
          ((HttpURLConnection)localObject1).setReadTimeout(15000);
          ((HttpURLConnection)localObject1).setRequestMethod("GET");
          ((HttpURLConnection)localObject1).setDoOutput(true);
          ((HttpURLConnection)localObject1).setUseCaches(false);
          ((HttpURLConnection)localObject1).setRequestProperty("Connection", "Keep-Alive");
          ((HttpURLConnection)localObject1).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
          if ((localObject1 instanceof HttpsURLConnection)) {
            al.a((HttpsURLConnection)localObject1, ((URL)localObject2).getHost());
          }
          ((HttpURLConnection)localObject1).connect();
          localObject2 = ((HttpURLConnection)localObject1).getInputStream();
          FileOutputStream localFileOutputStream = paramContext.openFileOutput(paramString2, 0);
          if (((HttpURLConnection)localObject1).getResponseCode() == 200)
          {
            localObject1 = new byte[1024];
            for (;;)
            {
              int i = ((InputStream)localObject2).read((byte[])localObject1);
              if (i <= 0) {
                break;
              }
              localFileOutputStream.write((byte[])localObject1, 0, i);
            }
            localFileOutputStream.flush();
            localFileOutputStream.close();
            ((InputStream)localObject2).close();
            localObject1 = new au();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramContext.getFilesDir().getAbsolutePath());
            ((StringBuilder)localObject2).append("/");
            ((StringBuilder)localObject2).append(paramString2);
            localObject1 = ((au)localObject1).a(((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("downLoad done fileMd5:");
            ((StringBuilder)localObject2).append((String)localObject1);
            APLog.i("APMidasUpdateJS", ((StringBuilder)localObject2).toString());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("downLoad done dencodedMD5:");
            ((StringBuilder)localObject2).append(l.a(l.this));
            APLog.i("APMidasUpdateJS", ((StringBuilder)localObject2).toString());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equalsIgnoreCase(l.a(l.this))))
            {
              APLog.i("APMidasUpdateJS", "downLoad succ");
              l.a(l.this, paramContext);
              return;
            }
            APLog.i("APMidasUpdateJS", "downLoad error");
            paramContext.deleteFile(paramString2);
            return;
          }
          ((InputStream)localObject2).close();
          localFileOutputStream.close();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }.start();
  }
  
  private void d(Context paramContext)
  {
    a(paramContext, this.a);
    b(paramContext, this.c);
    this.e = true;
  }
  
  public void a(Context paramContext)
  {
    if ((!this.e) && (!TextUtils.isEmpty(this.a)) && (paramContext != null))
    {
      Object localObject = k.a(paramContext).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateJS currentVersion:");
      localStringBuilder.append((String)localObject);
      APLog.i("APMidasUpdateJS", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateJS updateVersion:");
      localStringBuilder.append(this.a);
      APLog.i("APMidasUpdateJS", localStringBuilder.toString());
      int i = this.a.compareTo((String)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateJS comp:");
      ((StringBuilder)localObject).append(i);
      APLog.i("APMidasUpdateJS", ((StringBuilder)localObject).toString());
      if ((i > 0) && (!TextUtils.isEmpty(this.b))) {
        a(paramContext, this.b, "tencentmidas_js_brige");
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      str = e.a(paramString.getBytes());
      paramString = new StringBuilder();
      paramString.append("setJSVersionToFile enCodeVersion:");
      paramString.append(str);
      APLog.i("APMidasUpdateJS", paramString.toString());
    }
    new fz().a(paramContext, "TencentUnipay", "tencentMidasJSVersion", str);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("analyzeJson 1 jsinfo:");
    localStringBuilder.append(paramJSONObject);
    APLog.i("APMidasUpdateJS", localStringBuilder.toString());
    localStringBuilder = null;
    if (paramJSONObject != null)
    {
      try
      {
        if (!paramJSONObject.has("comm_config")) {
          return;
        }
        Object localObject = paramJSONObject.getJSONObject("comm_config");
        paramJSONObject = localStringBuilder;
        if (localObject != null)
        {
          paramJSONObject = localStringBuilder;
          if (((JSONObject)localObject).has("js_update_info"))
          {
            localObject = ((JSONObject)localObject).getJSONArray("js_update_info");
            paramJSONObject = localStringBuilder;
            if (((JSONArray)localObject).length() > 0) {
              paramJSONObject = (JSONObject)((JSONArray)localObject).get(0);
            }
          }
        }
        if ((paramJSONObject != null) && (paramJSONObject.has("update_version"))) {
          a().a = paramJSONObject.getString("update_version");
        }
        if ((paramJSONObject != null) && (paramJSONObject.has("download_url")))
        {
          a().b = paramJSONObject.getString("download_url");
          if (a().b.startsWith("http://"))
          {
            a().b = a().b.replace("http://", "https://");
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("analyzeJson() force https url = ");
            localStringBuilder.append(a().b);
            APLog.d("APMidasUpdateJS", localStringBuilder.toString());
          }
        }
        if ((paramJSONObject != null) && (paramJSONObject.has("md5")))
        {
          this.c = paramJSONObject.getString("md5");
          if (!TextUtils.isEmpty(this.c))
          {
            paramJSONObject = new APMidasRSATools().deCodeKey(this.c);
            a().d = paramJSONObject.substring(paramJSONObject.length() - 32);
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("analyzeJson update_version:");
      paramJSONObject.append(a().a);
      APLog.i("APMidasUpdateJS", paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("analyzeJson downloadUrl:");
      paramJSONObject.append(a().b);
      APLog.i("APMidasUpdateJS", paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("analyzeJson dencodedMD5:");
      paramJSONObject.append(a().d);
      APLog.i("APMidasUpdateJS", paramJSONObject.toString());
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("analyzeJson rsaMD5:");
      paramJSONObject.append(a().c);
      APLog.i("APMidasUpdateJS", paramJSONObject.toString());
      return;
    }
  }
  
  public String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = new String(e.a(new fz().a(paramContext, "TencentUnipay", "tencentMidasJSVersion")));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getJSVersionFromFile version:");
    localStringBuilder.append(paramContext.toString());
    APLog.i("APMidasUpdateJS", localStringBuilder.toString());
    return paramContext.toString();
  }
  
  public void b(Context paramContext, String paramString)
  {
    new fz().a(paramContext, "TencentUnipay", "tencentMidasJSMD5", paramString);
  }
  
  public String c(Context paramContext)
  {
    String str1 = "";
    String str2 = new fz().a(paramContext, "TencentUnipay", "tencentMidasJSMD5");
    paramContext = new StringBuilder();
    paramContext.append("getJSMD5FromFile rsaMD5:");
    paramContext.append(str2);
    APLog.i("APMidasUpdateJS", paramContext.toString());
    paramContext = str1;
    if (!TextUtils.isEmpty(str2))
    {
      str2 = new APMidasRSATools().deCodeKey(str2);
      paramContext = str1;
      if (str2.length() > 32) {
        paramContext = str2.substring(str2.length() - 32);
      }
    }
    return paramContext;
  }
  
  static class a
  {
    private static l a = new l(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.l
 * JD-Core Version:    0.7.0.1
 */