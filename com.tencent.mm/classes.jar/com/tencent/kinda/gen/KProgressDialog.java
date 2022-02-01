package com.tencent.kinda.gen;

public abstract interface KProgressDialog
{
  public abstract void dismiss();
  
  public abstract void showCustomLoading(String paramString, boolean paramBoolean);
  
  public abstract void showImpl(String paramString, boolean paramBoolean, VoidCallback paramVoidCallback);
  
  public abstract void showNormalGlobalLoading(boolean paramBoolean);
  
  public abstract void showNormalLoading(boolean paramBoolean);
  
  public abstract void showPayGlobalLoading(boolean paramBoolean);
  
  public abstract void showPayProcessImpl(boolean paramBoolean, VoidCallback paramVoidCallback);
  
  public abstract void showToast(String paramString);
  
  public abstract void showTopLoading(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.kinda.gen.KProgressDialog
 * JD-Core Version:    0.7.0.1
 */