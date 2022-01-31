package com.tencent.kinda.gen;

public abstract interface IUIPagePlatformFuncDelegate
{
  public abstract void beginIgnoringInteractionEvents();
  
  public abstract void closeUI();
  
  public abstract void endEditing();
  
  public abstract void endIgnoringInteractionEvents();
  
  public abstract String getTitle();
  
  public abstract void refreshNavigationBar();
  
  public abstract void setBackgroundColor(long paramLong);
  
  public abstract void setKeyBoardShowCallbackImpl(VoidBoolI32Callback paramVoidBoolI32Callback);
  
  public abstract void setTitle(String paramString);
  
  public abstract void setTopLeftBackBtnCallbackImpl(VoidCallback paramVoidCallback);
  
  public abstract void setTopRightBtnImage(String paramString);
  
  public abstract void setTopRightBtnTitle(String paramString1, String paramString2);
  
  public abstract void setTopRightCallbackImpl(VoidCallback paramVoidCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.IUIPagePlatformFuncDelegate
 * JD-Core Version:    0.7.0.1
 */