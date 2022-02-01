package com.tencent.kinda.gen;

public abstract interface KDeviceService
{
  public abstract void invokePhoneCall(String paramString);
  
  public abstract boolean isDeviceOpenBiometricVerification();
  
  public abstract boolean isDeviceSupportFaceId();
  
  public abstract boolean isDeviceSupportTouchId();
  
  public abstract boolean isRoot();
  
  public abstract String soterCpuId();
  
  public abstract String soterUid();
  
  public abstract void updateBiometricVerificationState(int paramInt, boolean paramBoolean);
  
  public abstract boolean useLastestTouchInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KDeviceService
 * JD-Core Version:    0.7.0.1
 */