package midas.x;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.zip.GZIPOutputStream;

@SuppressLint({"NewApi"})
public class cf
  extends bx
{
  private String a = "";
  
  public cf(String paramString)
  {
    String str2 = String.format("/cgi-bin/log_data.fcg?offer_id=%s", new Object[] { em.b().n().a.offerId });
    this.k = 1;
    String str1 = APAppDataInterface.singleton().e();
    if (str1.equals("custom"))
    {
      if (APAppDataInterface.singleton().k().equals("dev")) {
        str1 = "sandbox.api.unipay.qq.com";
      } else {
        str1 = "szmg.qq.com";
      }
    }
    else if (str1.equals("dev"))
    {
      str1 = "dev.api.unipay.qq.com";
    }
    else if (str1.equals("test"))
    {
      str1 = "sandbox.api.unipay.qq.com";
    }
    else if (str1.equals("release"))
    {
      str1 = "szmg.qq.com";
    }
    else if (str1.equals("testing"))
    {
      str1 = "szmg.qq.com";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!!!!Env error = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", so use release domain!!!!!!");
      APLog.e("APDataReportReq", localStringBuilder.toString());
      str1 = "szmg.qq.com";
    }
    this.u = false;
    a(str1, "https", str2, "443");
    this.a = paramString;
    b();
  }
  
  private String a(String paramString)
  {
    try
    {
      localObject = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      paramString = URLEncoder.encode(new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 2)), "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encodeGzip error:");
      ((StringBuilder)localObject).append(paramString.toString());
      APLog.w("APDataReportReq", ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void b()
  {
    e("offer_id", em.b().f());
    if (this.a.equals("")) {
      return;
    }
    String str = a(this.a);
    if ((!TextUtils.isEmpty(str)) && (str.length() < this.a.length()))
    {
      e("t", "g");
      e("c", str);
      return;
    }
    e(this.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cf
 * JD-Core Version:    0.7.0.1
 */