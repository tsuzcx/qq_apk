package midas.x;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class rb
{
  public int a = -1;
  public String b = "default_resultMsg";
  
  public rb(Context paramContext, gb paramgb)
  {
    if (paramgb == null) {
      return;
    }
    Object localObject = paramgb.b;
    localObject = paramgb.c;
    int i = paramgb.a;
    if (paramgb.f())
    {
      a(paramgb);
      return;
    }
    if (paramgb.b())
    {
      a(paramContext, paramgb);
      return;
    }
    if (!paramgb.e())
    {
      paramContext = new StringBuilder();
      paramContext.append("网络错误(错误码");
      paramContext.append(paramgb.a);
      paramContext.append(")");
      this.b = paramContext.toString();
      return;
    }
    if (!paramgb.c()) {
      this.b = "网络连接返回空结果,请稍后再试";
    }
  }
  
  public static String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(100-100-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{\"ret\": \"");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\", \"msg\":\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
  
  public static int b(gb paramgb)
  {
    if ((paramgb != null) && (paramgb.f())) {
      try
      {
        int i = Integer.parseInt(new JSONObject(paramgb.b).optString("ret"));
        return i;
      }
      catch (Exception paramgb)
      {
        paramgb.printStackTrace();
      }
    }
    return -1;
  }
  
  public static gb b(int paramInt, String paramString)
  {
    gb localgb = new gb();
    localgb.c = null;
    localgb.a = 100;
    localgb.b = a(paramInt, paramString);
    return localgb;
  }
  
  public static rb c(gb paramgb)
  {
    if (paramgb == null) {
      return null;
    }
    paramgb = paramgb.a();
    if (paramgb == null) {
      return null;
    }
    if (!(paramgb instanceof rb)) {
      return null;
    }
    return (rb)paramgb;
  }
  
  public static boolean d(gb paramgb)
  {
    return (paramgb != null) && (b(paramgb) == 0);
  }
  
  public final void a(Context paramContext, gb paramgb)
  {
    Object localObject = paramgb.c;
    if ((localObject instanceof ConnectTimeoutException))
    {
      this.b = "网络连接超时,请检查网络";
      this.a = 20001;
    }
    else if ((localObject instanceof SocketTimeoutException))
    {
      this.b = "网络响应超时,请检查网络";
      this.a = 20002;
    }
    else if ((localObject instanceof IOException))
    {
      this.b = "网络连接异常,请检查网络";
      this.a = 20005;
    }
    else
    {
      this.b = "网络错误，请稍后再试";
      this.a = 20000;
    }
    if (paramgb.d()) {
      for (paramgb = paramgb.c; paramgb != null; paramgb = paramgb.getCause())
      {
        if (pb.a(paramgb))
        {
          this.a = 20100;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的设备系统时间不正确，请更改");
          ((StringBuilder)localObject).append(a(20100));
          this.b = ((StringBuilder)localObject).toString();
        }
        if (pb.a(paramgb, paramContext))
        {
          this.a = 20102;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("您的wifi设置了代理，请更改");
          ((StringBuilder)localObject).append(a(20102));
          this.b = ((StringBuilder)localObject).toString();
        }
        if ((!(paramgb instanceof ConnectTimeoutException)) && (!(paramgb instanceof SocketTimeoutException)) && (!(paramgb instanceof UnknownHostException)))
        {
          this.a = 20101;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("系统繁忙，请稍后再试");
          ((StringBuilder)localObject).append(a(20101));
          this.b = ((StringBuilder)localObject).toString();
        }
      }
    }
  }
  
  public final void a(gb paramgb)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramgb.b)) && (!paramgb.b.startsWith("{")) && (!paramgb.b.endsWith("}")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{");
      ((StringBuilder)localObject).append(paramgb.b);
      ((StringBuilder)localObject).append("}");
      paramgb.b = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramgb = new JSONObject(paramgb.b);
      localObject = paramgb.optString("ret");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        this.a = -102;
        this.b = "系统繁忙，请稍后再试";
        return;
      }
      try
      {
        this.a = Integer.parseInt((String)localObject);
        this.b = paramgb.optString("msg");
        return;
      }
      catch (NumberFormatException paramgb)
      {
        paramgb.printStackTrace();
        this.a = -103;
        this.b = "系统繁忙，请稍后再试";
        return;
      }
      return;
    }
    catch (JSONException paramgb)
    {
      paramgb.printStackTrace();
      this.a = -101;
      this.b = "系统繁忙，请稍后再试";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.rb
 * JD-Core Version:    0.7.0.1
 */