package midas.x;

import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ct
  extends lh
{
  private String a = "";
  private String b = "";
  
  public ct(lw paramlw)
  {
    super(paramlw);
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected boolean a(kz paramkz)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resultData=");
    ((StringBuilder)localObject1).append(paramkz.b);
    APLog.i("APGoodsTokenAns", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new JSONObject(paramkz.b);
      this.j = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.j == 0)
      {
        if (((JSONObject)localObject1).has("token")) {
          this.a = ((JSONObject)localObject1).getString("token");
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
          ((StringBuilder)localObject2).append(em.b().n().a.offerId);
          ((StringBuffer)localObject1).append(((StringBuilder)localObject2).toString());
          ((StringBuffer)localObject1).append("/mobile_goods_info?token_id=");
          ((StringBuffer)localObject1).append(this.a);
          this.b = ((StringBuffer)localObject1).toString();
        }
        else
        {
          this.b = "";
        }
      }
      else
      {
        this.k = ((JSONObject)localObject1).getString("msg").toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject2).append(bw.a(20003));
      this.k = ((StringBuilder)localObject2).toString();
      APLog.w("APGetBuyInfoAdapter", localJSONException.getMessage());
    }
    return super.a(paramkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ct
 * JD-Core Version:    0.7.0.1
 */