package com.pay.api.request;

import org.json.JSONObject;

public class APGameRequest
  extends APBaseRequest
{
  public int gameLogo = 0;
  
  public APGameRequest()
  {
    this.saveType = 0;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public void setGameLogo(int paramInt)
  {
    this.gameLogo = paramInt;
  }
  
  public JSONObject toJson()
  {
    return super.toJson();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APGameRequest
 * JD-Core Version:    0.7.0.1
 */