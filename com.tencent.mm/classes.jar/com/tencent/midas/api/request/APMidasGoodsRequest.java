package com.tencent.midas.api.request;

public class APMidasGoodsRequest
  extends APMidasBaseRequest
{
  public static final int GETTOKENTYPE_CLIENT = 3;
  public static final int GETTOKENTYPE_SDK = 2;
  public static final int GETTOKENTYPE_SERVER = 1;
  private static final long serialVersionUID = -4326761659903564582L;
  public String developerPayload = "";
  public int gameLogo = 0;
  public String goodsTokenUrl = "";
  public boolean mIsReceiptMode = false;
  public String prodcutId = "";
  public int tokenType = -1;
  
  public String getDeveloperPayload()
  {
    return this.developerPayload;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public String getGoodsTokenUrl()
  {
    return this.goodsTokenUrl;
  }
  
  public boolean getIsReceiptMode()
  {
    return this.mIsReceiptMode;
  }
  
  public String getProdcutId()
  {
    return this.prodcutId;
  }
  
  public int getTokenType()
  {
    return this.tokenType;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.api.request.APMidasGoodsRequest
 * JD-Core Version:    0.7.0.1
 */