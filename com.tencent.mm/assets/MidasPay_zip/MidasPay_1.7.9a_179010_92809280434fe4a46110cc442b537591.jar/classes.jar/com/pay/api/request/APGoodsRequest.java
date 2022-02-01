package com.pay.api.request;

import org.json.JSONException;
import org.json.JSONObject;

public class APGoodsRequest
  extends APBaseRequest
{
  public static final int GETTOKENTYPE_CLIENT = 3;
  public static final int GETTOKENTYPE_SDK = 2;
  public static final int GETTOKENTYPE_SERVER = 1;
  public String developerPayload = "";
  public int gameLogo = 0;
  public String goodsTokenUrl = "";
  public boolean mIsReceiptMode = false;
  public String prodcutId = "";
  public int tokenType = 0;
  
  public APGoodsRequest()
  {
    this.saveType = 1;
  }
  
  public String getDeveloperPayload()
  {
    return this.developerPayload;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public boolean getIsReceiptMode()
  {
    return this.mIsReceiptMode;
  }
  
  public void setDeveloperPayload(String paramString)
  {
    this.developerPayload = paramString;
  }
  
  public void setGameLogo(int paramInt)
  {
    this.gameLogo = paramInt;
  }
  
  public void setGoodsTokenUrl(String paramString)
  {
    this.goodsTokenUrl = paramString;
  }
  
  public void setIsReceiptMode(boolean paramBoolean)
  {
    this.mIsReceiptMode = paramBoolean;
  }
  
  public void setProdcutId(String paramString)
  {
    this.prodcutId = paramString;
  }
  
  public void setTokenType(int paramInt)
  {
    this.tokenType = paramInt;
  }
  
  public JSONObject toJson()
  {
    super.toJson();
    try
    {
      this.a.put("tokenType", this.tokenType);
      this.a.put("goodsTokenUrl", this.goodsTokenUrl);
      this.a.put("prodcutId", this.prodcutId);
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
    localStringBuilder.append("---{ tokenType=");
    localStringBuilder.append(this.tokenType);
    localStringBuilder.append(" | goodsTokenUrl=");
    localStringBuilder.append(this.goodsTokenUrl);
    localStringBuilder.append(" | prodcutId=");
    localStringBuilder.append(this.prodcutId);
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APGoodsRequest
 * JD-Core Version:    0.7.0.1
 */