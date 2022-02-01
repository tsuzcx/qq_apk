package com.tencent.midas.api.request;

public class APMidasMonthRequest
  extends APMidasBaseRequest
{
  public static final int SERVICETYPE_NORMAL = 1;
  public static final int SERVICETYPE_RENEW = 2;
  public static final int SERVICETYPE_UPGRADE = 3;
  private static final long serialVersionUID = -557287896140460926L;
  public boolean autoPay = false;
  public int gameLogo = 0;
  public String serviceCode = "";
  public String serviceName = "";
  public int serviceType = 1;
  
  public boolean getAutoPay()
  {
    return this.autoPay;
  }
  
  public int getGameLogo()
  {
    return this.gameLogo;
  }
  
  public String getServiceCode()
  {
    return this.serviceCode;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public int getServiceType()
  {
    return this.serviceType;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.api.request.APMidasMonthRequest
 * JD-Core Version:    0.7.0.1
 */