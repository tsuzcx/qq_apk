package midas.x;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class k
{
  public static volatile k c;
  public String a = "";
  public String b = "";
  
  public k(Context paramContext)
  {
    b(paramContext);
  }
  
  public static k d(Context paramContext)
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new k(paramContext);
        }
      }
      finally {}
    }
    return c;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String a(Context paramContext)
  {
    if (TextUtils.isEmpty(this.b)) {
      c(paramContext);
    }
    return this.b;
  }
  
  public final String b(Context paramContext)
  {
    this.a = new j().b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("init enter jsVersion:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(" context:");
    ((StringBuilder)localObject1).append(paramContext);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject1).toString());
    if (paramContext == null) {
      return this.a;
    }
    localObject1 = l.a().b(paramContext);
    String str = l.a().a(paramContext);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("init version:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" md5:");
    ((StringBuilder)localObject2).append(str);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject2).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str)))
    {
      localObject2 = new v0();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("tencentmidas_js_brige");
      localObject2 = ((v0)localObject2).a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("init fileMd5:");
      localStringBuilder.append((String)localObject2);
      APLog.i("APMidasLoadJS", localStringBuilder.toString());
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equalsIgnoreCase(str))) {
        this.a = ((String)localObject1);
      } else {
        l.a().b(paramContext, "");
      }
      return this.a;
    }
    return this.a;
  }
  
  public final void c(Context paramContext)
  {
    Object localObject1 = new j();
    this.b = ((j)localObject1).a();
    this.a = ((j)localObject1).b();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("loadJS enter jsVersion:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(" context:");
    ((StringBuilder)localObject1).append(paramContext);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject1).toString());
    if (paramContext == null) {
      return;
    }
    localObject1 = l.a().b(paramContext);
    Object localObject2 = l.a().a(paramContext);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("loadJS version:");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" md5:");
    ((StringBuilder)localObject3).append((String)localObject2);
    APLog.i("APMidasLoadJS", ((StringBuilder)localObject3).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = new v0();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
      localStringBuilder.append("/");
      localStringBuilder.append("tencentmidas_js_brige");
      localObject3 = ((v0)localObject3).a(localStringBuilder.toString());
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
          this.b = new String(((ByteArrayOutputStream)localObject2).toByteArray(), "utf-8");
          this.a = ((String)localObject1);
          paramContext.close();
          ((ByteArrayOutputStream)localObject2).close();
          paramContext = new StringBuilder();
          paramContext.append("loadJS read file jsVersion:");
          paramContext.append(this.a);
          APLog.i("APMidasLoadJS", paramContext.toString());
          paramContext = new StringBuilder();
          paramContext.append(this.b);
          paramContext.append("MidasJSBridge.version=\"1.7.9a\";void(0);");
          this.b = paramContext.toString();
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
      l.a().a(paramContext, "");
      l.a().b(paramContext, "");
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(this.b);
    paramContext.append("MidasJSBridge.version=\"1.7.9a\";void(0);");
    this.b = paramContext.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k
 * JD-Core Version:    0.7.0.1
 */