package com.tencent.midas.api.request;

public class APMidasNetRequest
  extends APMidasBaseRequest
{
  public static String NET_REQ_MP = "mp";
  private static final long serialVersionUID = 5582061948778338484L;
  public String reqType = "";
  
  public String getReqType()
  {
    return this.reqType;
  }
  
  public void setReqType(String paramString)
  {
    this.reqType = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.api.request.APMidasNetRequest
 * JD-Core Version:    0.7.0.1
 */