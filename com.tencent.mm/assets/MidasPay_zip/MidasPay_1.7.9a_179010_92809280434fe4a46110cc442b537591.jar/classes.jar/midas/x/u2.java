package midas.x;

import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class u2
  extends ob
{
  public String g = "";
  public String h = "";
  
  public u2(fc paramfc)
  {
    super(paramfc);
  }
  
  public boolean d(gb paramgb)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resultData=");
    ((StringBuilder)localObject1).append(paramgb.b);
    APLog.i("APGoodsTokenAns", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new JSONObject(paramgb.b);
      this.a = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.a == 0)
      {
        if (((JSONObject)localObject1).has("token")) {
          this.g = ((JSONObject)localObject1).getString("token");
        }
        if (((JSONObject)localObject1).has("mid"))
        {
          localObject2 = ((JSONObject)localObject1).getString("mid");
          localObject1 = new StringBuffer();
          ((StringBuffer)localObject1).append("/v1");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("/");
          localStringBuilder.append((String)localObject2);
          ((StringBuffer)localObject1).append(localStringBuilder.toString());
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(p4.p().e().b.offerId);
          ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
          ((StringBuffer)localObject1).append("/mobile_goods_info?token_id=");
          ((StringBuffer)localObject1).append(this.g);
          this.h = ((StringBuffer)localObject1).toString();
        }
        else
        {
          this.h = "";
        }
      }
      else
      {
        this.b = ((JSONObject)localObject1).getString("msg").toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject2).append(x1.a(20003));
      this.b = ((StringBuilder)localObject2).toString();
      APLog.w("APGetBuyInfoAdapter", localJSONException.getMessage());
    }
    return super.d(paramgb);
  }
  
  public String g()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u2
 * JD-Core Version:    0.7.0.1
 */