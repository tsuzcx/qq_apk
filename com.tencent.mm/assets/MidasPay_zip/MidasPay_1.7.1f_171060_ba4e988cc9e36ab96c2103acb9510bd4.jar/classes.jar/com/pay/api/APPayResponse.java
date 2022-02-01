package com.pay.api;

import com.tencent.midas.api.request.APPurchase;

public class APPayResponse
{
  public static final int PAYCHANEL_UNKOWN = -1;
  public static final int PAYPROVIDESTATE_FAIL = -2;
  public static final int PAYPROVIDESTATE_SUCC = 0;
  public static final int PAYPROVIDESTATE_UNKOWN = -1;
  public static final int PAYRESULT_ALREADY_OWNED = 102;
  public static final int PAYRESULT_CALLBUSY = 12;
  public static final int PAYRESULT_CANCEL = 2;
  public static final int PAYRESULT_ERROR = -1;
  public static final int PAYRESULT_H5UNSUPPORT = 14;
  public static final int PAYRESULT_HFLAUNCHERROR = 250002;
  public static final int PAYRESULT_HFPAYERROR = 250001;
  public static final int PAYRESULT_HFUNSUPPORTERROR = 250003;
  public static final int PAYRESULT_INFO_ERROR = 10;
  public static final int PAYRESULT_INFO_LOGIN_ERROR = 11;
  public static final int PAYRESULT_INFO_SUCCESS = 9;
  public static final int PAYRESULT_MCARDERROR = 240000;
  public static final int PAYRESULT_PARAMERROR = 3;
  public static final int PAYRESULT_PAYAGAIN = 4;
  public static final int PAYRESULT_PAYUNKOWN = 5;
  public static final int PAYRESULT_PENDING = 101;
  public static final int PAYRESULT_QQWALLETERROR = 230000;
  public static final int PAYRESULT_REALNAMECANCEL = 13;
  public static final int PAYRESULT_ROCERROR = 7;
  public static final int PAYRESULT_SUCC = 0;
  public static final int PAYRESULT_TENPAYERROR = 220004;
  public static final int PAYRESULT_VALIDERROR = 8;
  public static final int PAYRESULT_WECHATERROR = 210001;
  public static final int PAYSTATE_PAYCANCEL = 1;
  public static final int PAYSTATE_PAYERROR = 2;
  public static final int PAYSTATE_PAYSUCC = 0;
  public static final int PAYSTATE_PAYUNKOWN = -1;
  public String extendInfo = null;
  public APPurchase mAPPurchase = null;
  public int payChannel = -1;
  public String payReserve1 = null;
  public String payReserve2 = null;
  public String payReserve3 = null;
  public int payState = -1;
  public int provideState = -1;
  public int realSaveNum = 0;
  public int resultCode = -1;
  public int resultInerCode = 0;
  public String resultMsg = null;
  
  public String getExtendInfo()
  {
    return this.extendInfo;
  }
  
  public int getPayChannel()
  {
    return this.payChannel;
  }
  
  public String getPayReserve1()
  {
    return this.payReserve1;
  }
  
  public String getPayReserve2()
  {
    return this.payReserve2;
  }
  
  public String getPayReserve3()
  {
    return this.payReserve3;
  }
  
  public int getPayState()
  {
    return this.payState;
  }
  
  public int getProvideState()
  {
    return this.provideState;
  }
  
  public int getRealSaveNum()
  {
    return this.realSaveNum;
  }
  
  public APPurchase getReceipt()
  {
    return this.mAPPurchase;
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public int getResultInerCode()
  {
    return this.resultInerCode;
  }
  
  public String getResultMsg()
  {
    return this.resultMsg;
  }
  
  public void reset()
  {
    this.realSaveNum = 0;
    this.resultCode = -1;
    this.resultInerCode = 0;
    this.payChannel = -1;
    this.payState = -1;
    this.provideState = -1;
    this.resultMsg = "";
    this.extendInfo = "";
    this.payReserve1 = "";
    this.payReserve2 = "";
    this.payReserve3 = "";
    this.mAPPurchase = null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("APPayResponse{resultCode=");
    localStringBuilder.append(this.resultCode);
    localStringBuilder.append(", resultInerCode=");
    localStringBuilder.append(this.resultInerCode);
    localStringBuilder.append(", realSaveNum=");
    localStringBuilder.append(this.realSaveNum);
    localStringBuilder.append(", payChannel=");
    localStringBuilder.append(this.payChannel);
    localStringBuilder.append(", payState=");
    localStringBuilder.append(this.payState);
    localStringBuilder.append(", provideState=");
    localStringBuilder.append(this.provideState);
    localStringBuilder.append(", resultMsg='");
    localStringBuilder.append(this.resultMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extendInfo='");
    localStringBuilder.append(this.extendInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", payReserve1='");
    localStringBuilder.append(this.payReserve1);
    localStringBuilder.append('\'');
    localStringBuilder.append(", payReserve2='");
    localStringBuilder.append(this.payReserve2);
    localStringBuilder.append('\'');
    localStringBuilder.append(", payReserve3='");
    localStringBuilder.append(this.payReserve3);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mAPPurchase=");
    localStringBuilder.append(this.mAPPurchase);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.api.APPayResponse
 * JD-Core Version:    0.7.0.1
 */