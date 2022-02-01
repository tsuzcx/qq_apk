package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ei
  extends lh
{
  public int a = -1;
  private byte[] b = null;
  
  public ei(lw paramlw)
  {
    super(paramlw);
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle success = ");
    ((StringBuilder)localObject1).append(paramkz);
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject1).toString());
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
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.j = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      if (this.j != 0)
      {
        this.k = ((JSONObject)localObject1).getString("msg");
        localObject1 = ((JSONObject)localObject1).getString("err_code");
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
      this.b = e.a(((JSONObject)localObject1).getString("qrcode"));
      int i = em.b().g();
      localObject2 = em.b().n();
      if (i != 4) {
        ((el)localObject2).b.b = ((JSONObject)localObject1).getString("goodsname");
      }
      ((el)localObject2).b.e = ((JSONObject)localObject1).getString("unit_price");
      ((el)localObject2).b.f = ((JSONObject)localObject1).getString("discount_price");
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
          em.b().a(5);
          gc.a().a(gc.a.a);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      em.b().a(5);
      gc.a().a(gc.a.b);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parse get qr code ans exception = ");
      ((StringBuilder)localObject2).append(localJSONException);
      APLog.e("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    }
    em.b().a(4);
    gc.a().a(gc.a.a);
    break label572;
    em.b().a(4);
    gc.a().a(gc.a.b);
    for (;;)
    {
      label572:
      return super.a(paramkz);
    }
  }
  
  public byte[] a()
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
 * Qualified Name:     midas.x.ei
 * JD-Core Version:    0.7.0.1
 */