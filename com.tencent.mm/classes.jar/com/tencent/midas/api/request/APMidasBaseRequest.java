package com.tencent.midas.api.request;

import java.io.Serializable;

public abstract class APMidasBaseRequest
  implements Serializable
{
  public static final int MALL_TYPE_DEFAULT = 0;
  public static final int MALL_TYPE_GROUPBUY = 1;
  public static final int MALL_TYPE_VMALL = 2;
  private static final long serialVersionUID = -9123623786877679280L;
  public String acctType = "common";
  public APMidasExtendInfo extendInfo = new APMidasExtendInfo();
  public String h5Url = "";
  public boolean isCanChange = true;
  public int mallType = 0;
  public APMidasMPInfo mpInfo = new APMidasMPInfo();
  public String offerId = "";
  public String openId = "";
  public String openKey = "";
  public String pf = "";
  public String pfKey = "";
  public String remark = "";
  public byte[] resData;
  public int resId = 0;
  public String reserv;
  public String saveValue = "";
  public String sessionId = "";
  public String sessionType = "";
  public String zoneId = "";
  
  public String getAcctType()
  {
    return this.acctType;
  }
  
  public String getDiscountType()
  {
    return this.mpInfo.discountType;
  }
  
  public String getDiscountUrl()
  {
    return this.mpInfo.discountUrl;
  }
  
  public String getDiscoutId()
  {
    return this.mpInfo.discoutId;
  }
  
  public String getDrmInfo()
  {
    return this.mpInfo.drmInfo;
  }
  
  public String getExtras()
  {
    return this.mpInfo.extras;
  }
  
  public String getH5Url()
  {
    return this.h5Url;
  }
  
  public boolean getIsCanChange()
  {
    return this.isCanChange;
  }
  
  public int getMallType()
  {
    return this.mallType;
  }
  
  public String getOfferId()
  {
    return this.offerId;
  }
  
  public String getOpenId()
  {
    return this.openId;
  }
  
  public String getOpenKey()
  {
    return this.openKey;
  }
  
  public String getPayChannel()
  {
    return this.mpInfo.payChannel;
  }
  
  public String getPf()
  {
    return this.pf;
  }
  
  public String getPfKey()
  {
    return this.pfKey;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public byte[] getResData()
  {
    return this.resData;
  }
  
  public int getResId()
  {
    return this.resId;
  }
  
  public String getReserv()
  {
    return this.reserv;
  }
  
  public String getSaveValue()
  {
    return this.saveValue;
  }
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public String getSessionType()
  {
    return this.sessionType;
  }
  
  public boolean getShowListOtherNum()
  {
    return this.extendInfo.isShowListOtherNum;
  }
  
  public boolean getShowNum()
  {
    return this.extendInfo.isShowNum;
  }
  
  public String getUnit()
  {
    return this.extendInfo.unit;
  }
  
  public String getZoneId()
  {
    return this.zoneId;
  }
  
  public void setAcctType(String paramString)
  {
    this.acctType = paramString;
  }
  
  public void setDiscountType(String paramString)
  {
    this.mpInfo.discountType = paramString;
  }
  
  public void setDiscountUrl(String paramString)
  {
    this.mpInfo.discountUrl = paramString;
  }
  
  public void setDiscoutId(String paramString)
  {
    this.mpInfo.discoutId = paramString;
  }
  
  public void setDrmInfo(String paramString)
  {
    this.mpInfo.drmInfo = paramString;
  }
  
  public void setExtras(String paramString)
  {
    this.mpInfo.extras = paramString;
  }
  
  public void setH5Url(String paramString)
  {
    this.h5Url = paramString;
  }
  
  public void setIsCanChange(boolean paramBoolean)
  {
    this.isCanChange = paramBoolean;
  }
  
  public void setMallType(int paramInt)
  {
    this.mallType = paramInt;
  }
  
  public void setOfferId(String paramString)
  {
    this.offerId = paramString;
  }
  
  public void setOpenId(String paramString)
  {
    this.openId = paramString;
  }
  
  public void setOpenKey(String paramString)
  {
    this.openKey = paramString;
  }
  
  public void setPayChannel(String paramString)
  {
    this.mpInfo.payChannel = paramString;
  }
  
  public void setPf(String paramString)
  {
    this.pf = paramString;
  }
  
  public void setPfKey(String paramString)
  {
    this.pfKey = paramString;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setResData(byte[] paramArrayOfByte)
  {
    this.resData = paramArrayOfByte;
  }
  
  public void setResId(int paramInt)
  {
    this.resId = paramInt;
  }
  
  public void setReserv(String paramString)
  {
    this.reserv = paramString;
  }
  
  public void setSaveValue(String paramString)
  {
    this.saveValue = paramString;
  }
  
  public void setSessionId(String paramString)
  {
    this.sessionId = paramString;
  }
  
  public void setSessionType(String paramString)
  {
    this.sessionType = paramString;
  }
  
  public void setShowListOtherNum(boolean paramBoolean)
  {
    this.extendInfo.isShowListOtherNum = paramBoolean;
  }
  
  public void setShowNum(boolean paramBoolean)
  {
    this.extendInfo.isShowNum = paramBoolean;
  }
  
  public void setUnit(String paramString)
  {
    this.extendInfo.unit = paramString;
  }
  
  public void setZoneId(String paramString)
  {
    this.zoneId = paramString;
  }
  
  public class APMidasExtendInfo
    implements Serializable
  {
    private static final long serialVersionUID = -5387967973327966068L;
    public boolean isShowListOtherNum = true;
    public boolean isShowNum = true;
    public String unit = "";
    
    public APMidasExtendInfo() {}
  }
  
  public class APMidasMPInfo
    implements Serializable
  {
    private static final long serialVersionUID = 631101753621041424L;
    public String discountType = "";
    public String discountUrl = "";
    public String discoutId = "";
    public String drmInfo = "";
    public String extras = "";
    public String payChannel = "";
    
    public APMidasMPInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.api.request.APMidasBaseRequest
 * JD-Core Version:    0.7.0.1
 */