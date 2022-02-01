package com.tencent.bankcardrecog;

public class BankCardRecog
{
  public static native String getBankCardSegmentNumber(String paramString, int paramInt, int[] paramArrayOfInt);
  
  public static native int recognizeBankCardGetVersion();
  
  public static native int recognizeBankCardInit(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int recognizeBankCardProcess(byte[] paramArrayOfByte, BankCardInfo paramBankCardInfo, boolean[] paramArrayOfBoolean);
  
  public static native int recognizeBankCardRelease();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.bankcardrecog.BankCardRecog
 * JD-Core Version:    0.7.0.1
 */