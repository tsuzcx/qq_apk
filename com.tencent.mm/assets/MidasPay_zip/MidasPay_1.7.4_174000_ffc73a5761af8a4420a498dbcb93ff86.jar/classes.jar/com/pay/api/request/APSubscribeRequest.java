package com.pay.api.request;

import org.json.JSONException;
import org.json.JSONObject;

public class APSubscribeRequest
  extends APMonthRequest
{
  public int gameLogo = 0;
  public String productId = "";
  
  public APSubscribeRequest()
  {
    this.saveType = 5;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public void setGameLogo(int paramInt)
  {
    this.gameLogo = paramInt;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
  
  public JSONObject toJson()
  {
    super.toJson();
    try
    {
      this.a.put("productId", this.productId);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("---{ productId=");
    localStringBuilder.append(this.productId);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APSubscribeRequest
 * JD-Core Version:    0.7.0.1
 */