package com.tencent.kinda.gen;

public abstract interface KOfflinePayService
{
  public abstract void cleanCftToken(String paramString);
  
  public abstract String decryptByCftCert(String paramString1, String paramString2);
  
  public abstract byte[] decryptBySM4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);
  
  public abstract boolean deleteCftCert(String paramString);
  
  public abstract String getCertid();
  
  public abstract String getCftCSR(String paramString);
  
  public abstract String getCftCertSign(String paramString1, String paramString2);
  
  public abstract String getCodever();
  
  public abstract String getDeviceid();
  
  public abstract String getLastSelectedCardBindSerial();
  
  public abstract long getLastTokenUpdateTs();
  
  public abstract String getOfflinePayAckKey();
  
  public abstract boolean getOfflinePayHasSuccess();
  
  public abstract int getRegetTokenNum();
  
  public abstract String getTokenPin();
  
  public abstract int getTokenUpdateInterval();
  
  public abstract boolean importCftCert(String paramString1, String paramString2);
  
  public abstract void removeCertid();
  
  public abstract boolean setCertid(String paramString);
  
  public abstract boolean setCftTokenCode(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract boolean setCodever(String paramString);
  
  public abstract boolean setDeviceid(String paramString);
  
  public abstract void setLastSelectedCardBindSerial(String paramString);
  
  public abstract void setLastTokenUpdateTs(long paramLong);
  
  public abstract void setOfflinePayAckKey(String paramString);
  
  public abstract void setOfflinePayHasSuccess();
  
  public abstract void setOfflineStateClose();
  
  public abstract void setOfflineStateOpen();
  
  public abstract void setRegetTokenNum(int paramInt);
  
  public abstract boolean setTokenPin(String paramString);
  
  public abstract void setTokenUpdateInterval(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KOfflinePayService
 * JD-Core Version:    0.7.0.1
 */