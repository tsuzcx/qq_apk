package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KPaySettingsService
{
  public abstract void commitHbRefundWayTypeChange();
  
  public abstract void commitTransferDelayTypeChange();
  
  public abstract KHbRefundWayType getHbRefundWayType();
  
  public abstract boolean getReddotStatus(String paramString);
  
  public abstract KTransferDelayType getTransferDelayType();
  
  public abstract int getTransferPhoneGrantFlag();
  
  public abstract void handlePushBioPaySettingPageImpl(VoidCallback paramVoidCallback);
  
  public abstract boolean isBioPayTypeEnabled(KBioPayType paramKBioPayType);
  
  public abstract void logGeneralUserAction(int paramInt);
  
  public abstract void markReddotConsumed(String paramString);
  
  public abstract void setBioPayTypeEnabledImpl(KBioPayType paramKBioPayType, boolean paramBoolean, VoidBoolCallback paramVoidBoolCallback);
  
  public abstract void setHbRefundWayType(KHbRefundWayType paramKHbRefundWayType);
  
  public abstract void setTransferDelayType(KTransferDelayType paramKTransferDelayType);
  
  public abstract void setTransferPhoneGrantFlag(int paramInt);
  
  public abstract ArrayList<KBioPayType> supportedBioPayTypes();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KPaySettingsService
 * JD-Core Version:    0.7.0.1
 */