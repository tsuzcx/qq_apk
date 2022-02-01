package com.tencent.mm.normsg;

import android.content.Context;

public abstract interface a
{
  public abstract String getAPKName(Context paramContext, String paramString);
  
  public abstract byte[] getByteFromMMKV(String paramString);
  
  public abstract String getDeviceId();
  
  public abstract long getLuckyPackTASCount();
  
  public abstract String getOAID();
  
  public abstract boolean getPhoneState(Context paramContext);
  
  public abstract String getRiskScanDataBase64();
  
  public abstract String getSoterId();
  
  public abstract String getSoterUid();
  
  public abstract boolean isUSBConnected();
  
  public abstract boolean putByteToMMKV(String paramString, byte[] paramArrayOfByte);
  
  public abstract void removeFromMMKV(String paramString);
  
  public abstract void reportGroupedIdKey(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void reportIdKey(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reportKVStat(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.normsg.a
 * JD-Core Version:    0.7.0.1
 */