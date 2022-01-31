package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KGenDigitalCrtReq
{
  public String mCreTail;
  public String mIdNo;
  public int mIdType;
  public String mReqKey;
  public String mToken;
  public int mType;
  public String mVerifyCode;
  
  public KGenDigitalCrtReq() {}
  
  public KGenDigitalCrtReq(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.mType = paramInt1;
    this.mIdType = paramInt2;
    this.mIdNo = paramString1;
    this.mReqKey = paramString2;
    this.mVerifyCode = paramString3;
    this.mToken = paramString4;
    this.mCreTail = paramString5;
  }
  
  public final String getCreTail()
  {
    return this.mCreTail;
  }
  
  public final String getIdNo()
  {
    return this.mIdNo;
  }
  
  public final int getIdType()
  {
    return this.mIdType;
  }
  
  public final String getReqKey()
  {
    return this.mReqKey;
  }
  
  public final String getToken()
  {
    return this.mToken;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final String getVerifyCode()
  {
    return this.mVerifyCode;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(141321);
    String str = "KGenDigitalCrtReq{mType=" + this.mType + ",mIdType=" + this.mIdType + ",mIdNo=" + this.mIdNo + ",mReqKey=" + this.mReqKey + ",mVerifyCode=" + this.mVerifyCode + ",mToken=" + this.mToken + ",mCreTail=" + this.mCreTail + "}";
    AppMethodBeat.o(141321);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KGenDigitalCrtReq
 * JD-Core Version:    0.7.0.1
 */