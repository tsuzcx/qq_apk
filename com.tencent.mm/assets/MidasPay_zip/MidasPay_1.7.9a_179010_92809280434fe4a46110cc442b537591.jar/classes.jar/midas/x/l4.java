package midas.x;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class l4
  extends ob
{
  public byte[] g = null;
  public int h = -1;
  
  public l4(fc paramfc)
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
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject1).toString());
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
    APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      this.a = Integer.parseInt(((JSONObject)localObject1).getString("ret"));
      if (this.a != 0)
      {
        this.b = ((JSONObject)localObject1).getString("msg");
        localObject1 = ((JSONObject)localObject1).getString("err_code");
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
      this.g = e.a(((JSONObject)localObject1).getString("qrcode"));
      int i = p4.p().g();
      localObject2 = p4.p().e();
      if (i != 4) {
        ((o4)localObject2).c.b = ((JSONObject)localObject1).getString("goodsname");
      }
      ((o4)localObject2).c.c = ((JSONObject)localObject1).getString("unit_price");
      ((o4)localObject2).c.d = ((JSONObject)localObject1).getString("discount_price");
      this.h = ((JSONObject)localObject1).getInt("token_valid_time");
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Token valid time = ");
      ((StringBuilder)localObject2).append(this.h);
      APLog.d("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
      if (((JSONObject)localObject1).has("month_type"))
      {
        localObject1 = ((JSONObject)localObject1).getString("month_type");
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        if (!bool) {
          try
          {
            i = Integer.parseInt((String)localObject1);
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4)
                  {
                    p4.p().a(5);
                    g6.k().a(g6.a.a);
                  }
                }
                else
                {
                  p4.p().a(5);
                  g6.k().a(g6.a.b);
                }
              }
              else
              {
                p4.p().a(4);
                g6.k().a(g6.a.a);
              }
            }
            else
            {
              p4.p().a(4);
              g6.k().a(g6.a.b);
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      return super.d(paramgb);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Parse get qr code ans exception = ");
      ((StringBuilder)localObject2).append(localJSONException);
      APLog.e("QRCodePay-GetQRCodeAns", ((StringBuilder)localObject2).toString());
    }
  }
  
  public byte[] g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.l4
 * JD-Core Version:    0.7.0.1
 */