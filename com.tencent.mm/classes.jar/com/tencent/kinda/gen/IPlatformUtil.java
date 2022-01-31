package com.tencent.kinda.gen;

public abstract interface IPlatformUtil
{
  public abstract int androidAPILevel();
  
  public abstract AndroidDpiLevel androidDpiLevel();
  
  public abstract String currentLanguageCode();
  
  public abstract Platform currentPlatform();
  
  public abstract float getBottomSafeAreaHeight();
  
  public abstract boolean getExptBoolValue(String paramString);
  
  public abstract float getLoigcalResolutionHeight();
  
  public abstract float getLoigcalResolutionWidth();
  
  public abstract float getNavigationBarHeight();
  
  public abstract String getPlatformString(String paramString);
  
  public abstract float getPx(float paramFloat);
  
  public abstract float getStatusBarHeight();
  
  public abstract IOSDevice iOSDevice();
  
  public abstract String iOSVersion();
  
  public abstract void setLanguageChangeCallbackImpl(VoidStringCallback paramVoidStringCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.IPlatformUtil
 * JD-Core Version:    0.7.0.1
 */