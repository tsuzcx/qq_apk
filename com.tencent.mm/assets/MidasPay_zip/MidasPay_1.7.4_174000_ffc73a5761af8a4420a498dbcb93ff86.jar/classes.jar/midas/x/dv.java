package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dv
  extends lh
{
  private byte[] a = null;
  private String b = null;
  private long c = 0L;
  
  public dv(lw paramlw)
  {
    super(paramlw);
  }
  
  public long a()
  {
    return this.c;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle success = ");
    ((StringBuilder)localObject1).append(paramkz);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject1).toString());
    if (paramkz == null) {
      return super.a(paramkz);
    }
    localObject1 = paramkz.b;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.j = -1;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("系统繁忙,请稍后再试\n");
      ((StringBuilder)localObject1).append(bw.a(20004));
      this.k = ((StringBuilder)localObject1).toString();
      return super.a(paramkz);
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("resultData = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.j = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resultCoderesultCode = ");
      ((StringBuilder)localObject2).append(this.j);
      APLog.d("APShortenQRCodeAns", ((StringBuilder)localObject2).toString());
      if (this.j != 0)
      {
        this.k = ((JSONObject)localObject1).optString("msg");
        localObject1 = ((JSONObject)localObject1).optString("err_code");
        if (!((String)localObject1).equals(""))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("系统繁忙,请稍后再试\n(");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(")");
          this.k = ((StringBuilder)localObject2).toString();
        }
        return super.a(paramkz);
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
    return super.a(paramkz);
  }
  
  public String b()
  {
    return this.b;
  }
  
  protected boolean b(kz paramkz)
  {
    return super.b(paramkz);
  }
  
  protected boolean c(kz paramkz)
  {
    return super.c(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.dv
 * JD-Core Version:    0.7.0.1
 */