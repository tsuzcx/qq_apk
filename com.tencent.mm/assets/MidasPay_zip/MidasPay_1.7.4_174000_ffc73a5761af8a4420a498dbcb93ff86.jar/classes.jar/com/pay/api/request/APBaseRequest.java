package com.pay.api.request;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class APBaseRequest
  implements Cloneable
{
  public static final int MALL_TYPE_DEFAULT = 0;
  public static final int MALL_TYPE_GROUPBUY = 1;
  public static final int MALL_TYPE_VMALL = 2;
  public static final int REQUESTYPE_GAME = 0;
  public static final int REQUESTYPE_GOODS = 1;
  public static final int REQUESTYPE_MONTH = 4;
  public static final int REQUESTYPE_SUBSCRIBE = 5;
  protected JSONObject a = new JSONObject();
  public String acctType = "common";
  public APExtendInfo extendInfo = new APExtendInfo();
  public String h5Url = "";
  public boolean isCanChange = true;
  public int mallType = 0;
  public APMPInfo mpInfo = new APMPInfo();
  public String offerId = "";
  public String openId = "";
  public String openKey = "";
  public String pf = "";
  public String pfKey = "";
  public String remark = "";
  public byte[] resData;
  public int resId = 0;
  public String reserv;
  public int saveType = 0;
  public String saveValue = "";
  public String sessionId = "";
  public String sessionType = "";
  public String zoneId = "";
  
  public Object clone()
    throws CloneNotSupportedException
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public String getReportInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(":{oF=");
    localStringBuilder.append(this.offerId);
    localStringBuilder.append("|opI=");
    localStringBuilder.append(this.openId);
    localStringBuilder.append("|opK=******|sI=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append("|sT=");
    localStringBuilder.append(this.sessionType);
    localStringBuilder.append("|zI=");
    localStringBuilder.append(this.zoneId);
    localStringBuilder.append("|pF=");
    localStringBuilder.append(this.pf);
    localStringBuilder.append("|pK=");
    localStringBuilder.append(this.pfKey);
    localStringBuilder.append("|rI=");
    localStringBuilder.append(this.resId);
    localStringBuilder.append("|aT=");
    localStringBuilder.append(this.acctType);
    localStringBuilder.append("|sV=");
    localStringBuilder.append(this.saveValue);
    localStringBuilder.append("iC=");
    localStringBuilder.append(this.isCanChange);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
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
  
  public void setExtendInfo(APExtendInfo paramAPExtendInfo)
  {
    this.extendInfo = paramAPExtendInfo;
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
  
  public JSONObject toJson()
  {
    try
    {
      this.a.put("saveType", this.saveType);
      this.a.put("offerId", this.offerId);
      this.a.put("openId", this.openId);
      this.a.put("openKey", this.openKey);
      this.a.put("sessionId", this.sessionId);
      this.a.put("sessionType", this.sessionType);
      this.a.put("zoneId", this.zoneId);
      this.a.put("pf", this.pf);
      this.a.put("pfKey", this.pfKey);
      this.a.put("acctType", this.acctType);
      this.a.put("saveValue", this.saveValue);
      this.a.put("isCanChange", this.isCanChange);
      this.a.put("remark", this.remark);
      this.a.put("mallType", this.mallType);
      this.a.put("extendInfo", this.extendInfo.toJson().toString());
      this.a.put("mpInfo", this.mpInfo.toJson().toString());
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
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(":{ saveType=");
    localStringBuilder.append(this.saveType);
    localStringBuilder.append(" | offerId=");
    localStringBuilder.append(this.offerId);
    localStringBuilder.append(" | openId=");
    localStringBuilder.append(this.openId);
    localStringBuilder.append(" | openKey=****** | sessionId=");
    localStringBuilder.append(this.sessionId);
    localStringBuilder.append(" | sessionType=");
    localStringBuilder.append(this.sessionType);
    localStringBuilder.append(" | zoneId=");
    localStringBuilder.append(this.zoneId);
    localStringBuilder.append(" | pf=");
    localStringBuilder.append(this.pf);
    localStringBuilder.append(" | pfKey=");
    localStringBuilder.append(this.pfKey);
    localStringBuilder.append(" | resId=");
    localStringBuilder.append(this.resId);
    localStringBuilder.append(" | acctType=");
    localStringBuilder.append(this.acctType);
    localStringBuilder.append(" | saveValue=");
    localStringBuilder.append(this.saveValue);
    localStringBuilder.append(" | isCanChange=");
    localStringBuilder.append(this.isCanChange);
    localStringBuilder.append(" | remark=");
    localStringBuilder.append(this.remark);
    localStringBuilder.append(" | mallType=");
    localStringBuilder.append(this.mallType);
    localStringBuilder.append(" | h5Url=");
    localStringBuilder.append(this.h5Url);
    localStringBuilder.append(" | ");
    localStringBuilder.append(this.extendInfo.toString());
    localStringBuilder.append(" | ");
    localStringBuilder.append(this.mpInfo.toString());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public class APExtendInfo
  {
    public boolean isShowListOtherNum = true;
    public boolean isShowNum = true;
    public String unit = "";
    
    public APExtendInfo() {}
    
    public JSONObject toJson()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("unit", this.unit);
        localJSONObject.put("isShowNum", this.isShowNum);
        localJSONObject.put("isShowListOtherNum", this.isShowListOtherNum);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ext=[unit=");
      localStringBuilder.append(this.unit);
      localStringBuilder.append(" | isShowNum=");
      localStringBuilder.append(this.isShowNum);
      localStringBuilder.append(" | isShowListOtherNum=");
      localStringBuilder.append(this.isShowListOtherNum);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  public class APMPInfo
  {
    public String discountType = "";
    public String discountUrl = "";
    public String discoutId = "";
    public String drmInfo = "";
    public String extras = "";
    public String payChannel = "";
    
    public APMPInfo() {}
    
    public JSONObject toJson()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("payChannel", this.payChannel);
        localJSONObject.put("discountTyp", this.discountType);
        localJSONObject.put("discountUrl", this.discountUrl);
        localJSONObject.put("drmInfo", this.drmInfo);
        localJSONObject.put("discoutId", this.discoutId);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mp=[payChannel=");
      localStringBuilder.append(this.payChannel);
      localStringBuilder.append(" | discountTyp=");
      localStringBuilder.append(this.discountType);
      localStringBuilder.append(" | discountUrl=");
      localStringBuilder.append(this.discountUrl);
      localStringBuilder.append(" | drmInfo=");
      localStringBuilder.append(this.drmInfo);
      localStringBuilder.append(" | discoutId=");
      localStringBuilder.append(this.discoutId);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APBaseRequest
 * JD-Core Version:    0.7.0.1
 */