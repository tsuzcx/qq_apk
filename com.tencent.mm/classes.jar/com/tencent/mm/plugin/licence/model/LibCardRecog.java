package com.tencent.mm.plugin.licence.model;

import com.tencent.mm.compatible.util.k;

public final class LibCardRecog
{
  static
  {
    k.b("IDCardRecog", LibCardRecog.class.getClassLoader());
  }
  
  public static native int recognizeBankCardGetVersion();
  
  public static native int recognizeBankCardInit(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static native int recognizeBankCardProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, BankCardInfo paramBankCardInfo, boolean[] paramArrayOfBoolean);
  
  public static native int recognizeBankCardRelease();
  
  public static native String recognizeBankCardSegmentNumber(String paramString, int paramInt, int[] paramArrayOfInt);
  
  public static native int recognizeCardInit(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int recognizeCardProcess(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, CardInfo paramCardInfo, boolean[] paramArrayOfBoolean);
  
  public static native int recognizeCardRelease();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.licence.model.LibCardRecog
 * JD-Core Version:    0.7.0.1
 */