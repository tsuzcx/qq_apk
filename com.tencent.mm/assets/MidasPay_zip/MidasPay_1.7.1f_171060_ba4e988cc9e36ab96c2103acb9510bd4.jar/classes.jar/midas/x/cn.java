package midas.x;

import com.pay.api.request.APBaseRequest;
import com.tencent.midas.comm.APLog;
import org.json.JSONException;
import org.json.JSONObject;

public class cn
  extends jw
{
  private String a = "";
  private String b = "";
  
  public cn(kl paramkl)
  {
    super(paramkl);
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected boolean a(jo paramjo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("resultData=");
    ((StringBuilder)localObject1).append(paramjo.b);
    APLog.i("APGoodsTokenAns", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = new JSONObject(paramjo.b);
      this.i = Integer.parseInt(((JSONObject)localObject1).getString("ret").toString());
      if (this.i == 0)
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
          ((StringBuilder)localObject2).append(ed.b().n().a.offerId);
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
        this.j = ((JSONObject)localObject1).getString("msg").toString();
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("系统繁忙,请稍后再试 ");
      ((StringBuilder)localObject2).append(bq.a(20003));
      this.j = ((StringBuilder)localObject2).toString();
      APLog.w("APGetBuyInfoAdapter", localJSONException.getMessage());
    }
    return super.a(paramjo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.cn
 * JD-Core Version:    0.7.0.1
 */