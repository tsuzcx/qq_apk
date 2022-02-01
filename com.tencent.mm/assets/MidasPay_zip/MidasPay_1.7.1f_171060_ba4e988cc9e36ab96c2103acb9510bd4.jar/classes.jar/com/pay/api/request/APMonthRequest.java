package com.pay.api.request;

import org.json.JSONException;
import org.json.JSONObject;

public class APMonthRequest
  extends APBaseRequest
{
  public boolean autoPay = false;
  public int gameLogo = 0;
  public String serviceCode = "";
  public String serviceName = "";
  public int serviceType;
  
  public APMonthRequest()
  {
    this.saveType = 4;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public void setAutoPay(boolean paramBoolean)
  {
    this.autoPay = paramBoolean;
  }
  
  public void setGameLogo(int paramInt)
  {
    this.gameLogo = paramInt;
  }
  
  public void setServiceCode(String paramString)
  {
    this.serviceCode = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setServiceType(int paramInt)
  {
    this.serviceType = paramInt;
  }
  
  public JSONObject toJson()
  {
    super.toJson();
    try
    {
      this.a.put("serviceCode", this.serviceCode);
      this.a.put("serviceName", this.serviceName);
      this.a.put("autoPay", this.autoPay);
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
    localStringBuilder.append("---{ serviceCode=");
    localStringBuilder.append(this.serviceCode);
    localStringBuilder.append(" | serviceName=");
    localStringBuilder.append(this.serviceName);
    localStringBuilder.append(" | autoPay=");
    localStringBuilder.append(this.autoPay);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APMonthRequest
 * JD-Core Version:    0.7.0.1
 */