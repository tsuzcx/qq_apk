package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KOfflinePayService
{
  public abstract void cleanCftToken(String paramString);
  
  public abstract boolean deleteCftCert(String paramString);
  
  public abstract String getCertid();
  
  public abstract String getCftCSR(String paramString);
  
  public abstract String getCftCertSign(String paramString1, String paramString2);
  
  public abstract String getCftToken(String paramString);
  
  public abstract String getCodever();
  
  public abstract String getDeviceid();
  
  public abstract String getLastSelectedCardBindSerial();
  
  public abstract long getLastTokenUpdateTs();
  
  public abstract boolean getOfflinePayHasSuccess();
  
  public abstract ArrayList<ITransmitKvData> getPaymentCardList();
  
  public abstract int getRegetTokenNum();
  
  public abstract int getRemainCftTokenNum(String paramString);
  
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
  
  public abstract void setOfflinePayHasSuccess();
  
  public abstract void setRegetTokenNum(int paramInt);
  
  public abstract boolean setTokenPin(String paramString);
  
  public abstract void setTokenUpdateInterval(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.KOfflinePayService
 * JD-Core Version:    0.7.0.1
 */