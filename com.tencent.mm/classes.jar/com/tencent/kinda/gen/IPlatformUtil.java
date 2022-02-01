package com.tencent.kinda.gen;

public abstract interface IPlatformUtil
{
  public abstract int androidAPILevel();
  
  public abstract AndroidDpiLevel androidDpiLevel();
  
  public abstract byte[] base64Decode(String paramString);
  
  public abstract String base64Encode(byte[] paramArrayOfByte);
  
  public abstract void beginIgnoringInteractionEvents();
  
  public abstract String currentLanguageCode();
  
  public abstract Platform currentPlatform();
  
  public abstract void endIgnoringInteractionEvents();
  
  public abstract String genUUID();
  
  public abstract float getBottomSafeAreaHeight();
  
  public abstract boolean getExptBoolValue(String paramString);
  
  public abstract float getIphoneSafeAreaBottomHeight();
  
  public abstract float getLoigcalResolutionHeight();
  
  public abstract float getLoigcalResolutionWidth();
  
  public abstract String getMemoryKVString(String paramString);
  
  public abstract float getNavigationBarHeight();
  
  public abstract float getPadSplitHeight();
  
  public abstract float getPadSplitWidth();
  
  public abstract String getPlatformString(String paramString);
  
  public abstract float getPx(float paramFloat);
  
  public abstract boolean getRedDotStatus(String paramString);
  
  public abstract String getRedDotWording(String paramString);
  
  public abstract float getScreenBrightness();
  
  public abstract float getStatusBarHeight();
  
  public abstract IOSDevice iOSDevice();
  
  public abstract String iOSVersion();
  
  public abstract boolean isNetworkConnected();
  
  public abstract boolean isPad();
  
  public abstract void makesureLonglink();
  
  public abstract String md5(String paramString);
  
  public abstract void playVibration();
  
  public abstract void setIdleTimerDisable(boolean paramBoolean);
  
  public abstract void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback);
  
  public abstract void setRedDotStatus(String paramString, boolean paramBoolean);
  
  public abstract void setReportLocationState(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setScreenBrightness(float paramFloat);
  
  public abstract void setStatusBarHidden(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean shouldReportCellInfo();
  
  public abstract boolean shouldReportLocation();
  
  public abstract boolean shouldReportWifiSsid();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IPlatformUtil
 * JD-Core Version:    0.7.0.1
 */