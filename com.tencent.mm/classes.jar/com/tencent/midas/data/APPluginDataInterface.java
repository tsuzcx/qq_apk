package com.tencent.midas.data;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class APPluginDataInterface
{
  public static final String LAUNCHPAY_INTERVAL_TIME = "launchpayintervaltime";
  public static final String LAUNCHPAY_TIME = "launchpaytime";
  public static final String LAUNCHPAY_UUID = "launchpayuuid";
  public static final String SHARE_PREFERENCE_NAME = "TencentUnipay";
  private static volatile APPluginDataInterface gInstance;
  private String acctType = "";
  private boolean autoPay = true;
  private String discountType = "";
  private String discountUrl = "";
  private String discoutId = "";
  private String drmInfo = "";
  private String extras = "";
  private String goodsTokenUrl = "";
  private String h5Message = "";
  private String h5Url = "";
  private boolean isCanChange = true;
  private boolean isNumVisible = true;
  private boolean isShowListOtherNum = true;
  private boolean isShowNum = true;
  private String launchInterface = "launchpay";
  private boolean logEnable = true;
  private int mallType = 0;
  private String offerId = "";
  private String openId = "";
  private String openKey = "";
  private String payChannel = "";
  private String pf = "";
  private String pfKey = "";
  private APMultiProcessData processData = null;
  private String prodcutId = "";
  private String propUnit = "";
  private String remark = "";
  private String reqType = "";
  private byte[] resData = null;
  private int resId = 0;
  private String resUrl = "";
  private String reserv = "";
  private int saveType = 0;
  private String saveValue = "";
  private String serviceCode = "";
  private String serviceName = "";
  private int serviceType = 0;
  private String sessionId = "";
  private String sessionType = "";
  private int tokenType = 0;
  private String unit = "";
  private String zoneId = "";
  
  static
  {
    AppMethodBeat.i(253252);
    gInstance = new APPluginDataInterface();
    AppMethodBeat.o(253252);
  }
  
  public static void init()
  {
    AppMethodBeat.i(253231);
    gInstance = new APPluginDataInterface();
    AppMethodBeat.o(253231);
  }
  
  public static APPluginDataInterface singleton()
  {
    AppMethodBeat.i(253232);
    if (gInstance == null) {}
    try
    {
      if (gInstance == null) {
        gInstance = new APPluginDataInterface();
      }
      APPluginDataInterface localAPPluginDataInterface = gInstance;
      AppMethodBeat.o(253232);
      return localAPPluginDataInterface;
    }
    finally
    {
      AppMethodBeat.o(253232);
    }
  }
  
  public String getAcctType()
  {
    return this.acctType;
  }
  
  public String getDiscountType()
  {
    return this.discountType;
  }
  
  public String getDiscountUrl()
  {
    return this.discountUrl;
  }
  
  public String getDiscoutId()
  {
    return this.discoutId;
  }
  
  public String getDrmInfo()
  {
    return this.drmInfo;
  }
  
  public String getExtras()
  {
    return this.extras;
  }
  
  public String getGoodsTokenUrl()
  {
    return this.goodsTokenUrl;
  }
  
  public String getH5Message()
  {
    return this.h5Message;
  }
  
  public String getH5Url()
  {
    return this.h5Url;
  }
  
  public String getLaunchInterface()
  {
    return this.launchInterface;
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
    return this.payChannel;
  }
  
  public String getPf()
  {
    return this.pf;
  }
  
  public String getPfKey()
  {
    return this.pfKey;
  }
  
  public APMultiProcessData getProcessData()
  {
    return this.processData;
  }
  
  public String getProdcutId()
  {
    return this.prodcutId;
  }
  
  public String getPropUnit()
  {
    return this.propUnit;
  }
  
  public String getRemark()
  {
    return this.remark;
  }
  
  public String getReqType()
  {
    return this.reqType;
  }
  
  public byte[] getResData()
  {
    return this.resData;
  }
  
  public int getResId()
  {
    return this.resId;
  }
  
  public String getResUrl()
  {
    return this.resUrl;
  }
  
  public String getReserv()
  {
    return this.reserv;
  }
  
  public int getSaveType()
  {
    return this.saveType;
  }
  
  public String getSaveValue()
  {
    return this.saveValue;
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
  
  public String getSessionId()
  {
    return this.sessionId;
  }
  
  public String getSessionType()
  {
    return this.sessionType;
  }
  
  public int getTokenType()
  {
    return this.tokenType;
  }
  
  public String getUnit()
  {
    return this.unit;
  }
  
  public String getZoneId()
  {
    return this.zoneId;
  }
  
  public boolean isAutoPay()
  {
    return this.autoPay;
  }
  
  public boolean isCanChange()
  {
    return this.isCanChange;
  }
  
  public boolean isLogEnable()
  {
    return this.logEnable;
  }
  
  public boolean isNumVisible()
  {
    return this.isNumVisible;
  }
  
  public boolean isShowListOtherNum()
  {
    return this.isShowListOtherNum;
  }
  
  public boolean isShowNum()
  {
    return this.isShowNum;
  }
  
  public void setAcctType(String paramString)
  {
    this.acctType = paramString;
  }
  
  public void setAutoPay(boolean paramBoolean)
  {
    this.autoPay = paramBoolean;
  }
  
  public void setCanChange(boolean paramBoolean)
  {
    this.isCanChange = paramBoolean;
  }
  
  public void setDiscountType(String paramString)
  {
    this.discountType = paramString;
  }
  
  public void setDiscountUrl(String paramString)
  {
    this.discountUrl = paramString;
  }
  
  public void setDiscoutId(String paramString)
  {
    this.discoutId = paramString;
  }
  
  public void setDrmInfo(String paramString)
  {
    this.drmInfo = paramString;
  }
  
  public void setExtras(String paramString)
  {
    this.extras = paramString;
  }
  
  public void setGoodsTokenUrl(String paramString)
  {
    this.goodsTokenUrl = paramString;
  }
  
  public void setH5Message(String paramString)
  {
    gInstance.h5Message = paramString;
  }
  
  public void setH5Url(String paramString)
  {
    this.h5Url = paramString;
  }
  
  public void setLaunchInterface(String paramString)
  {
    this.launchInterface = paramString;
  }
  
  public void setLogEnable(boolean paramBoolean)
  {
    this.logEnable = paramBoolean;
  }
  
  public void setMallType(int paramInt)
  {
    this.mallType = paramInt;
  }
  
  public void setNumVisible(boolean paramBoolean)
  {
    this.isNumVisible = paramBoolean;
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
    this.payChannel = paramString;
  }
  
  public void setPf(String paramString)
  {
    this.pf = paramString;
  }
  
  public void setPfKey(String paramString)
  {
    this.pfKey = paramString;
  }
  
  public void setProcessData(APMultiProcessData paramAPMultiProcessData)
  {
    this.processData = paramAPMultiProcessData;
  }
  
  public void setProdcutId(String paramString)
  {
    this.prodcutId = paramString;
  }
  
  public void setPropUnit(String paramString)
  {
    this.propUnit = paramString;
  }
  
  public void setRemark(String paramString)
  {
    this.remark = paramString;
  }
  
  public void setReqType(String paramString)
  {
    this.reqType = paramString;
  }
  
  public void setResData(byte[] paramArrayOfByte)
  {
    this.resData = paramArrayOfByte;
  }
  
  public void setResId(int paramInt)
  {
    this.resId = paramInt;
  }
  
  public void setResUrl(String paramString)
  {
    this.resUrl = paramString;
  }
  
  public void setReserv(String paramString)
  {
    this.reserv = paramString;
  }
  
  public void setSaveType(int paramInt)
  {
    this.saveType = paramInt;
  }
  
  public void setSaveValue(String paramString)
  {
    this.saveValue = paramString;
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
    this.isShowListOtherNum = paramBoolean;
  }
  
  public void setShowNum(boolean paramBoolean)
  {
    this.isShowNum = paramBoolean;
  }
  
  public void setTokenType(int paramInt)
  {
    this.tokenType = paramInt;
  }
  
  public void setUnit(String paramString)
  {
    this.unit = paramString;
  }
  
  public void setZoneId(String paramString)
  {
    this.zoneId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.data.APPluginDataInterface
 * JD-Core Version:    0.7.0.1
 */