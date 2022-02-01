package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class jz
{
  int a = -1;
  int b = 100;
  String c = "default_resultMsg";
  public String d = "";
  public Exception e;
  
  jz(Context paramContext, jo paramjo)
  {
    if (paramjo == null) {
      return;
    }
    this.d = paramjo.b;
    this.e = paramjo.c;
    this.b = paramjo.a;
    if (paramjo.d())
    {
      d(paramjo);
      return;
    }
    if (paramjo.g())
    {
      a(paramContext, paramjo);
      return;
    }
    if (!paramjo.e())
    {
      paramContext = new StringBuilder();
      paramContext.append("网络错误(错误码");
      paramContext.append(paramjo.a);
      paramContext.append(")");
      this.c = paramContext.toString();
      return;
    }
    if (!paramjo.f()) {
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
  
  static jo a(int paramInt, String paramString)
  {
    jo localjo = new jo();
    localjo.c = null;
    localjo.a = 100;
    localjo.b = b(paramInt, paramString);
    return localjo;
  }
  
  static jz a(jo paramjo)
  {
    if (paramjo == null) {
      return null;
    }
    paramjo = paramjo.c();
    if (paramjo == null) {
      return null;
    }
    if (!(paramjo instanceof jz)) {
      return null;
    }
    return (jz)paramjo;
  }
  
  private void a(Context paramContext, jo paramjo)
  {
    Object localObject = paramjo.c;
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
    if (paramjo.b()) {
      for (paramjo = paramjo.c; paramjo != null; paramjo = paramjo.getCause())
      {
        if (jx.a(paramjo))
        {
          this.a = 20100;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的设备系统时间不正确，请更改");
          ((StringBuilder)localObject).append(a(20100));
          this.c = ((StringBuilder)localObject).toString();
        }
        if (jx.a(paramjo, paramContext))
        {
          this.a = 20102;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的wifi设置了代理，请更改");
          ((StringBuilder)localObject).append(a(20102));
          this.c = ((StringBuilder)localObject).toString();
        }
        if ((!(paramjo instanceof ConnectTimeoutException)) && (!(paramjo instanceof SocketTimeoutException)) && (!(paramjo instanceof UnknownHostException)))
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
  
  static int b(jo paramjo)
  {
    if ((paramjo != null) && (paramjo.d())) {
      try
      {
        int i = Integer.parseInt(new JSONObject(paramjo.b).optString("ret"));
        return i;
      }
      catch (Exception paramjo)
      {
        paramjo.printStackTrace();
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
  
  static boolean c(jo paramjo)
  {
    return (paramjo != null) && (b(paramjo) == 0);
  }
  
  private void d(jo paramjo)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramjo.b)) && (!paramjo.b.startsWith("{")) && (!paramjo.b.endsWith("}")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append(paramjo.b);
      ((StringBuilder)localObject).append("}");
      paramjo.b = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramjo = new JSONObject(paramjo.b);
      localObject = paramjo.optString("ret");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a = -102;
        this.c = "系统繁忙，请稍后再试";
        return;
      }
      try
      {
        this.a = Integer.parseInt((String)localObject);
        this.c = paramjo.optString("msg");
        return;
      }
      catch (NumberFormatException paramjo)
      {
        paramjo.printStackTrace();
        this.a = -103;
        this.c = "系统繁忙，请稍后再试";
        return;
      }
      return;
    }
    catch (JSONException paramjo)
    {
      paramjo.printStackTrace();
      this.a = -101;
      this.c = "系统繁忙，请稍后再试";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jz
 * JD-Core Version:    0.7.0.1
 */