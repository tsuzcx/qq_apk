package com.tencent.midas.api.request;

public class APMidasSubscribeRequest
  extends APMidasMonthRequest
{
  private static final long serialVersionUID = 6111439524338439638L;
  public int gameLogo = 0;
  public String productId = "";
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  public void setGameLogo(int paramInt)
  {
    this.gameLogo = paramInt;
  }
  
  public void setProductId(String paramString)
  {
    this.productId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.api.request.APMidasSubscribeRequest
 * JD-Core Version:    0.7.0.1
 */