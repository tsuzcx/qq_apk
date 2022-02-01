package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BankCardType
{
  public String mBankName;
  public String mBankType;
  public String mBankaccType;
  public String mBankaccTypeName;
  public String mForbidWord;
  public boolean mIsMaintainance;
  
  public BankCardType() {}
  
  public BankCardType(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.mBankType = paramString1;
    this.mBankName = paramString2;
    this.mBankaccType = paramString3;
    this.mBankaccTypeName = paramString4;
    this.mIsMaintainance = paramBoolean;
    this.mForbidWord = paramString5;
  }
  
  public final String getBankName()
  {
    return this.mBankName;
  }
  
  public final String getBankType()
  {
    return this.mBankType;
  }
  
  public final String getBankaccType()
  {
    return this.mBankaccType;
  }
  
  public final String getBankaccTypeName()
  {
    return this.mBankaccTypeName;
  }
  
  public final String getForbidWord()
  {
    return this.mForbidWord;
  }
  
  public final boolean getIsMaintainance()
  {
    return this.mIsMaintainance;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135647);
    String str = "BankCardType{mBankType=" + this.mBankType + ",mBankName=" + this.mBankName + ",mBankaccType=" + this.mBankaccType + ",mBankaccTypeName=" + this.mBankaccTypeName + ",mIsMaintainance=" + this.mIsMaintainance + ",mForbidWord=" + this.mForbidWord + "}";
    AppMethodBeat.o(135647);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.gen.BankCardType
 * JD-Core Version:    0.7.0.1
 */