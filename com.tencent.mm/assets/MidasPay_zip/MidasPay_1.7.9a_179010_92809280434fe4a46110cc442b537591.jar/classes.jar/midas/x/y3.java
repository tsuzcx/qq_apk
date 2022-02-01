package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class y3
  extends ob
{
  public byte[] g = null;
  public String h = null;
  public long i = 0L;
  
  public y3(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean b(gb paramgb)
  {
    return super.b(paramgb);
  }
  
  public boolean c(gb paramgb)
  {
    return super.c(paramgb);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle success = ");
    ((StringBuilder)localObject1).append(paramgb);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject1).toString());
    if (paramgb == null) {
      return super.d(paramgb);
    }
    localObject1 = paramgb.b;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.a = -1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("系统繁忙,请稍后再试\n");
      ((StringBuilder)localObject1).append(x1.a(20004));
      this.b = ((StringBuilder)localObject1).toString();
      return super.d(paramgb);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.a = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resultCoderesultCode = ");
      ((StringBuilder)localObject2).append(this.a);
      APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
      if (this.a != 0)
      {
        this.b = ((JSONObject)localObject1).optString("msg");
        localObject1 = ((JSONObject)localObject1).optString("err_code");
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("系统繁忙,请稍后再试\n(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          this.b = ((StringBuilder)localObject2).toString();
        }
        return super.d(paramgb);
      }
      this.h = ((JSONObject)localObject1).optString("result_url");
      localObject2 = ((JSONObject)localObject1).optString("qrcode");
      if (this.g != null) {
        this.g = e.a((String)localObject2);
      }
      this.i = ((JSONObject)localObject1).optInt("valid_time");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parse get qr code ans exception = ");
      ((StringBuilder)localObject2).append(localJSONException);
      APLog.e("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
    }
    return super.d(paramgb);
  }
  
  public String g()
  {
    return this.h;
  }
  
  public long h()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y3
 * JD-Core Version:    0.7.0.1
 */