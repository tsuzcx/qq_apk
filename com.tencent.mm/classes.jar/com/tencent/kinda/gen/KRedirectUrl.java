package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class KRedirectUrl
{
  public String mAppVersion;
  public String mAppid;
  public String mBtnName;
  public String mPath;
  public int mType;
  
  public KRedirectUrl() {}
  
  public KRedirectUrl(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mType = paramInt;
    this.mAppid = paramString1;
    this.mAppVersion = paramString2;
    this.mPath = paramString3;
    this.mBtnName = paramString4;
  }
  
  public final String getAppVersion()
  {
    return this.mAppVersion;
  }
  
  public final String getAppid()
  {
    return this.mAppid;
  }
  
  public final String getBtnName()
  {
    return this.mBtnName;
  }
  
  public final String getPath()
  {
    return this.mPath;
  }
  
  public final int getType()
  {
    return this.mType;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135883);
    String str = "KRedirectUrl{mType=" + this.mType + ",mAppid=" + this.mAppid + ",mAppVersion=" + this.mAppVersion + ",mPath=" + this.mPath + ",mBtnName=" + this.mBtnName + "}";
    AppMethodBeat.o(135883);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KRedirectUrl
 * JD-Core Version:    0.7.0.1
 */