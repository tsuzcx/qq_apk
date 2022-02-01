package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class dz
  extends jw
{
  public int a = -1;
  private byte[] b = null;
  
  public dz(kl paramkl)
  {
    super(paramkl);
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle success = ");
    ((StringBuilder)localObject1).append(paramjo);
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject1).toString());
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
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.i = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      if (this.i != 0)
      {
        this.j = ((JSONObject)localObject1).getString("msg");
        localObject1 = ((JSONObject)localObject1).getString("err_code");
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
      this.b = e.a(((JSONObject)localObject1).getString("qrcode"));
      int i = ed.b().g();
      localObject2 = ed.b().n();
      if (i != 4) {
        ((ec)localObject2).b.b = ((JSONObject)localObject1).getString("goodsname");
      }
      ((ec)localObject2).b.e = ((JSONObject)localObject1).getString("unit_price");
      ((ec)localObject2).b.f = ((JSONObject)localObject1).getString("discount_price");
      this.a = ((JSONObject)localObject1).getInt("token_valid_time");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Token valid time = ");
      ((StringBuilder)localObject2).append(this.a);
      APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
      if (!((JSONObject)localObject1).has("month_type")) {
        break label572;
      }
      localObject1 = ((JSONObject)localObject1).getString("month_type");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (bool) {
        break label572;
      }
      try
      {
        switch (Integer.parseInt((String)localObject1))
        {
        case 4: 
          ed.b().a(5);
          fs.a().a(fs.a.a);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ed.b().a(5);
      fs.a().a(fs.a.b);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parse get qr code ans exception = ");
      ((StringBuilder)localObject2).append(localJSONException);
      APLog.e("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    }
    ed.b().a(4);
    fs.a().a(fs.a.a);
    break label572;
    ed.b().a(4);
    fs.a().a(fs.a.b);
    for (;;)
    {
      label572:
      return super.a(paramjo);
    }
  }
  
  public byte[] a()
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
 * Qualified Name:     midas.x.dz
 * JD-Core Version:    0.7.0.1
 */