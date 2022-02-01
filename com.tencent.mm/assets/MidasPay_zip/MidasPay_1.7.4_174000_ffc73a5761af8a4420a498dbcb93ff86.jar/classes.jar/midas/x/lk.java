package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class lk
{
  int a = -1;
  int b = 100;
  String c = "default_resultMsg";
  public String d = "";
  public Exception e;
  
  lk(Context paramContext, kz paramkz)
  {
    if (paramkz == null) {
      return;
    }
    this.d = paramkz.b;
    this.e = paramkz.c;
    this.b = paramkz.a;
    if (paramkz.d())
    {
      d(paramkz);
      return;
    }
    if (paramkz.g())
    {
      a(paramContext, paramkz);
      return;
    }
    if (!paramkz.e())
    {
      paramContext = new StringBuilder();
      paramContext.append("网络错误(错误码");
      paramContext.append(paramkz.a);
      paramContext.append(")");
      this.c = paramContext.toString();
      return;
    }
    if (!paramkz.f()) {
      this.c = "网络连接返回空结果,请稍后再试";
    }
  }
  
  private static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(100-100-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  static kz a(int paramInt, String paramString)
  {
    kz localkz = new kz();
    localkz.c = null;
    localkz.a = 100;
    localkz.b = b(paramInt, paramString);
    return localkz;
  }
  
  static lk a(kz paramkz)
  {
    if (paramkz == null) {
      return null;
    }
    paramkz = paramkz.c();
    if (paramkz == null) {
      return null;
    }
    if (!(paramkz instanceof lk)) {
      return null;
    }
    return (lk)paramkz;
  }
  
  private void a(Context paramContext, kz paramkz)
  {
    Object localObject = paramkz.c;
    if ((localObject instanceof ConnectTimeoutException))
    {
      this.c = "网络连接超时,请检查网络";
      this.a = 20001;
    }
    else if ((localObject instanceof SocketTimeoutException))
    {
      this.c = "网络响应超时,请检查网络";
      this.a = 20002;
    }
    else if ((localObject instanceof IOException))
    {
      this.c = "网络连接异常,请检查网络";
      this.a = 20005;
    }
    else
    {
      this.c = "网络错误，请稍后再试";
      this.a = 20000;
    }
    if (paramkz.b()) {
      for (paramkz = paramkz.c; paramkz != null; paramkz = paramkz.getCause())
      {
        if (li.a(paramkz))
        {
          this.a = 20100;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的设备系统时间不正确，请更改");
          ((StringBuilder)localObject).append(a(20100));
          this.c = ((StringBuilder)localObject).toString();
        }
        if (li.a(paramkz, paramContext))
        {
          this.a = 20102;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的wifi设置了代理，请更改");
          ((StringBuilder)localObject).append(a(20102));
          this.c = ((StringBuilder)localObject).toString();
        }
        if ((!(paramkz instanceof ConnectTimeoutException)) && (!(paramkz instanceof SocketTimeoutException)) && (!(paramkz instanceof UnknownHostException)))
        {
          this.a = 20101;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("系统繁忙，请稍后再试");
          ((StringBuilder)localObject).append(a(20101));
          this.c = ((StringBuilder)localObject).toString();
        }
      }
    }
  }
  
  static int b(kz paramkz)
  {
    if ((paramkz != null) && (paramkz.d())) {
      try
      {
        int i = Integer.parseInt(new JSONObject(paramkz.b).optString("ret"));
        return i;
      }
      catch (Exception paramkz)
      {
        paramkz.printStackTrace();
      }
    }
    return -1;
  }
  
  private static String b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"ret\": \"");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\", \"msg\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  static boolean c(kz paramkz)
  {
    return (paramkz != null) && (b(paramkz) == 0);
  }
  
  private void d(kz paramkz)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramkz.b)) && (!paramkz.b.startsWith("{")) && (!paramkz.b.endsWith("}")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append(paramkz.b);
      ((StringBuilder)localObject).append("}");
      paramkz.b = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramkz = new JSONObject(paramkz.b);
      localObject = paramkz.optString("ret");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a = -102;
        this.c = "系统繁忙，请稍后再试";
        return;
      }
      try
      {
        this.a = Integer.parseInt((String)localObject);
        this.c = paramkz.optString("msg");
        return;
      }
      catch (NumberFormatException paramkz)
      {
        paramkz.printStackTrace();
        this.a = -103;
        this.c = "系统繁忙，请稍后再试";
        return;
      }
      return;
    }
    catch (JSONException paramkz)
    {
      paramkz.printStackTrace();
      this.a = -101;
      this.c = "系统繁忙，请稍后再试";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.lk
 * JD-Core Version:    0.7.0.1
 */