package com.tencent.kinda.gen;

public abstract interface KPwdInputView
  extends KView
{
  public abstract boolean getAutoRemarkKeyBoradType();
  
  public abstract boolean getChearInput();
  
  public abstract boolean getFocus();
  
  public abstract String getHashData();
  
  public abstract PwdEncryptMode getPwdEncryptMode();
  
  public abstract String getPwdNonce();
  
  public abstract PwdViewStyle getPwdStyle();
  
  public abstract long getPwdTimestamp();
  
  public abstract long getTextLength();
  
  public abstract void setAutoRemarkKeyBoradType(boolean paramBoolean);
  
  public abstract void setChearInput(boolean paramBoolean);
  
  public abstract void setFocus(boolean paramBoolean);
  
  public abstract void setFocusModalListener(IUIModal paramIUIModal);
  
  public abstract void setFocusUIPageListener(IUIPage paramIUIPage);
  
  public abstract void setHashData(String paramString);
  
  public abstract void setOnEndEnterPasswordCallback(KPwdInputViewOnEndEnterPasswordCallback paramKPwdInputViewOnEndEnterPasswordCallback);
  
  public abstract void setOnPasswordChangeCallback(KPwdInputViewOnPasswordChangeCallback paramKPwdInputViewOnPasswordChangeCallback);
  
  public abstract void setPwdEncryptMode(PwdEncryptMode paramPwdEncryptMode);
  
  public abstract void setPwdNonce(String paramString);
  
  public abstract void setPwdStyle(PwdViewStyle paramPwdViewStyle);
  
  public abstract void setPwdTimestamp(long paramLong);
  
  public abstract void setTextLength(long paramLong);
  
  public abstract Sm2HashType sm2HashType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KPwdInputView
 * JD-Core Version:    0.7.0.1
 */