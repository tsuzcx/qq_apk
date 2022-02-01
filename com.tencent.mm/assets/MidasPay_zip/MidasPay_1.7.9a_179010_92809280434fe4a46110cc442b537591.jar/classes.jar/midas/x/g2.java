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
public class g2
  extends y1
{
  public String A = "";
  
  public g2(String paramString)
  {
    String str1 = String.format("/cgi-bin/log_data.fcg?offer_id=%s", new Object[] { p4.p().e().b.offerId });
    this.h = 1;
    String str2 = APAppDataInterface.singleton().h();
    boolean bool = str2.equals("custom");
    Object localObject2 = "sandbox.api.unipay.qq.com";
    Object localObject1 = "szmg.qq.com";
    if (bool)
    {
      if (!APAppDataInterface.singleton().f().equals("dev")) {}
    }
    else
    {
      do
      {
        localObject1 = localObject2;
        if (str2.equals("dev"))
        {
          localObject1 = "dev.api.unipay.qq.com";
          break;
        }
      } while (str2.equals("test"));
      if ((!str2.equals("release")) && (!str2.equals("testing")))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("!!!!!!Env error = ");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(", so use release domain!!!!!!");
        APLog.e("APDataReportReq", ((StringBuilder)localObject2).toString());
      }
    }
    this.y = false;
    b((String)localObject1, "https", str1, "443");
    this.A = paramString;
    G();
  }
  
  public boolean F()
  {
    return false;
  }
  
  public void G()
  {
    b("offer_id", p4.p().c());
    if (this.A.equals("")) {
      return;
    }
    String str = e(this.A);
    if ((!TextUtils.isEmpty(str)) && (str.length() < this.A.length()))
    {
      b("t", "g");
      b("c", str);
      return;
    }
    b(this.A, "");
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public final String e(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.g2
 * JD-Core Version:    0.7.0.1
 */