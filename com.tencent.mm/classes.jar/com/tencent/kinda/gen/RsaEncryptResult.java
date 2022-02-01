package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RsaEncryptResult
{
  public String mBase64Str;
  public int mRet;
  
  public RsaEncryptResult() {}
  
  public RsaEncryptResult(String paramString, int paramInt)
  {
    this.mBase64Str = paramString;
    this.mRet = paramInt;
  }
  
  public final String getBase64Str()
  {
    return this.mBase64Str;
  }
  
  public final int getRet()
  {
    return this.mRet;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135971);
    String str = "RsaEncryptResult{mBase64Str=" + this.mBase64Str + ",mRet=" + this.mRet + "}";
    AppMethodBeat.o(135971);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.RsaEncryptResult
 * JD-Core Version:    0.7.0.1
 */