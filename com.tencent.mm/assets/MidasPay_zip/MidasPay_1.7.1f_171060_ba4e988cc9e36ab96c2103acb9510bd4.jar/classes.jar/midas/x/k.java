package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class k
{
  private static volatile k a;
  private String b = "";
  private String c = "";
  
  private k(Context paramContext)
  {
    c(paramContext);
  }
  
  public static k a(Context paramContext)
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new k(paramContext);
        }
      }
      finally {}
    }
    return a;
  }
  
  private String c(Context paramContext)
  {
    this.b = new j().a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init enter jsVersion:");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" context:");
    ((StringBuilder)localObject1).append(paramContext);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject1).toString());
    if (paramContext == null) {
      return this.b;
    }
    localObject1 = l.a().b(paramContext);
    String str = l.a().c(paramContext);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("init version:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" md5:");
    ((StringBuilder)localObject2).append(str);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
    {
      localObject2 = new au();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("tencentmidas_js_brige");
      localObject2 = ((au)localObject2).a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init fileMd5:");
      localStringBuilder.append((String)localObject2);
      APLog.i("APMidasLoadJS", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equalsIgnoreCase(str))) {
        this.b = ((String)localObject1);
      } else {
        l.a().a(paramContext, "");
      }
      return this.b;
    }
    return this.b;
  }
  
  private void d(Context paramContext)
  {
    Object localObject1 = new j();
    this.c = ((j)localObject1).b();
    this.b = ((j)localObject1).a();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadJS enter jsVersion:");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(" context:");
    ((StringBuilder)localObject1).append(paramContext);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject1).toString());
    if (paramContext == null) {
      return;
    }
    localObject1 = l.a().b(paramContext);
    Object localObject2 = l.a().c(paramContext);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("loadJS version:");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" md5:");
    ((StringBuilder)localObject3).append((String)localObject2);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject3).toString());
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      localObject3 = new au();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("tencentmidas_js_brige");
      localObject3 = ((au)localObject3).a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadJS fileMd5:");
      localStringBuilder.append((String)localObject3);
      APLog.i("APMidasLoadJS", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
        try
        {
          paramContext = paramContext.openFileInput("tencentmidas_js_brige");
          localObject2 = new ByteArrayOutputStream();
          localObject3 = new byte[4096];
          for (;;)
          {
            int i = paramContext.read((byte[])localObject3, 0, 4096);
            if (i == -1) {
              break;
            }
            ((ByteArrayOutputStream)localObject2).write((byte[])localObject3, 0, i);
          }
          this.c = new String(((ByteArrayOutputStream)localObject2).toByteArray(), "utf-8");
          this.b = ((String)localObject1);
          paramContext.close();
          ((ByteArrayOutputStream)localObject2).close();
          paramContext = new StringBuilder();
          paramContext.append("loadJS read file jsVersion:");
          paramContext.append(this.b);
          APLog.i("APMidasLoadJS", paramContext.toString());
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
      }
      APLog.i("APMidasLoadJS", "loadJS error");
      paramContext.deleteFile("tencentmidas_js_brige");
      l.a().b(paramContext, "");
      l.a().a(paramContext, "");
      return;
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b(Context paramContext)
  {
    if (TextUtils.isEmpty(this.c)) {
      d(paramContext);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.k
 * JD-Core Version:    0.7.0.1
 */