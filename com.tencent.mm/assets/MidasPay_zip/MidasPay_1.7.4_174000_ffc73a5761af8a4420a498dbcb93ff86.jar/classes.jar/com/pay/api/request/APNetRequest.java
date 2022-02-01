package com.pay.api.request;

public class APNetRequest
  extends APBaseRequest
{
  public static String NET_REQ_FRIENDSPAY = "friendspay";
  public static String NET_REQ_MP = "mp";
  public static String NET_REQ_QQ = "qq";
  public String reqType = "";
  
  public void setReqType(String paramString)
  {
    this.reqType = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("---{ reqType=");
    localStringBuilder.append(this.reqType);
    localStringBuilder.append(" |  }");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.request.APNetRequest
 * JD-Core Version:    0.7.0.1
 */