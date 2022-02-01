package com.tencent.kinda.gen;

public abstract interface KProgressDialog
{
  public abstract void dismiss();
  
  public abstract void showImpl(String paramString, boolean paramBoolean, VoidCallback paramVoidCallback);
  
  public abstract void showNormalLoading(boolean paramBoolean);
  
  public abstract void showPayProcessImpl(boolean paramBoolean, VoidCallback paramVoidCallback);
  
  public abstract void showToast(String paramString);
  
  public abstract void showTopLoading(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KProgressDialog
 * JD-Core Version:    0.7.0.1
 */