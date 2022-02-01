package com.tencent.kinda.gen;

public abstract interface IPlatformUtil
{
  public abstract void accessibilityAnnounce(KView paramKView, String paramString);
  
  public abstract void accessibilityFocus(KView paramKView);
  
  public abstract int androidAPILevel();
  
  public abstract AndroidDpiLevel androidDpiLevel();
  
  public abstract byte[] base64Decode(String paramString);
  
  public abstract String base64Encode(byte[] paramArrayOfByte);
  
  public abstract void beginIgnoringInteractionEvents();
  
  public abstract String currentLanguageCode();
  
  public abstract Platform currentPlatform();
  
  public abstract boolean delSecurityStore(String paramString);
  
  public abstract float dynamicFontSize(float paramFloat);
  
  public abstract float dynamicSize(float paramFloat);
  
  public abstract float dynamicSizeByFontLevel(float paramFloat, int paramInt);
  
  public abstract void endIgnoringInteractionEvents();
  
  public abstract String genUUID();
  
  public abstract String getAndroidRepairConfig(String paramString);
  
  public abstract float getBottomSafeAreaHeight();
  
  public abstract boolean getExptBoolValue(String paramString);
  
  public abstract int getFontLevel();
  
  public abstract float getIphoneSafeAreaBottomHeight();
  
  public abstract boolean getIsAccessibilityServiceRunning();
  
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
  
  public abstract float getScaleByFontLevel(int paramInt);
  
  public abstract float getScreenBrightness();
  
  public abstract float getStatusBarHeight();
  
  public abstract float getViewScale();
  
  public abstract IOSDevice iOSDevice();
  
  public abstract String iOSVersion();
  
  public abstract boolean isCareModeOn();
  
  public abstract boolean isNetworkConnected();
  
  public abstract boolean isPad();
  
  public abstract byte[] loadSecurityStore(String paramString);
  
  public abstract void makesureLonglink();
  
  public abstract String md5(String paramString);
  
  public abstract void openTinyApp(ITransmitKvData paramITransmitKvData);
  
  public abstract void playVibration();
  
  public abstract String resolveLanguageStringForGlobal(String paramString);
  
  public abstract String resolveURLStringForGlobal(String paramString);
  
  public abstract boolean saveSecurityStore(String paramString, byte[] paramArrayOfByte);
  
  public abstract void setIdleTimerDisable(boolean paramBoolean);
  
  public abstract void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback);
  
  public abstract void setRedDotStatus(String paramString, boolean paramBoolean);
  
  public abstract void setReportLocationState(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setScreenBrightness(float paramFloat);
  
  public abstract void setStatusBarHidden(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract String sha256(byte[] paramArrayOfByte, boolean paramBoolean);
  
  public abstract boolean shouldReportCellInfo();
  
  public abstract boolean shouldReportLocation();
  
  public abstract boolean shouldReportWifiSsid();
  
  public abstract boolean supportSecurityStore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.IPlatformUtil
 * JD-Core Version:    0.7.0.1
 */