package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dn
  extends jw
{
  private byte[] a = null;
  private String b = null;
  private long c = 0L;
  
  public dn(kl paramkl)
  {
    super(paramkl);
  }
  
  public long a()
  {
    return this.c;
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle success = ");
    ((StringBuilder)localObject1).append(paramjo);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject1).toString());
    if (paramjo == null) {
      return super.a(paramjo);
    }
    localObject1 = paramjo.b;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.i = -1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("系统繁忙,请稍后再试\n");
      ((StringBuilder)localObject1).append(bq.a(20004));
      this.j = ((StringBuilder)localObject1).toString();
      return super.a(paramjo);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.i = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resultCoderesultCode = ");
      ((StringBuilder)localObject2).append(this.i);
      APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
      if (this.i != 0)
      {
        this.j = ((JSONObject)localObject1).optString("msg");
        localObject1 = ((JSONObject)localObject1).optString("err_code");
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("系统繁忙,请稍后再试\n(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          this.j = ((StringBuilder)localObject2).toString();
        }
        return super.a(paramjo);
      }
      this.b = ((JSONObject)localObject1).optString("result_url");
      localObject2 = ((JSONObject)localObject1).optString("qrcode");
      if (this.a != null) {
        this.a = e.a((String)localObject2);
      }
      this.c = ((JSONObject)localObject1).optInt("valid_time");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parse get qr code ans exception = ");
      ((StringBuilder)localObject2).append(localJSONException);
      APLog.e("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
    }
    return super.a(paramjo);
  }
  
  public String b()
  {
    return this.b;
  }
  
  protected boolean b(jo paramjo)
  {
    return super.b(paramjo);
  }
  
  protected boolean c(jo paramjo)
  {
    return super.c(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dn
 * JD-Core Version:    0.7.0.1
 */