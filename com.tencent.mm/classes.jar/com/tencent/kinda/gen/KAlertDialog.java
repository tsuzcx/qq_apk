package com.tencent.kinda.gen;

public abstract interface KAlertDialog
{
  public abstract void dismiss();
  
  public abstract void setContentAlign(TextAlign paramTextAlign);
  
  public abstract void showImpl(String paramString1, String paramString2, String paramString3, VoidCallback paramVoidCallback);
  
  public abstract void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2);
  
  public abstract void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3);
  
  public abstract void showTipsImpl(String paramString1, String paramString2, String paramString3, VoidCallback paramVoidCallback);
  
  public abstract void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, VoidCallback paramVoidCallback);
  
  public abstract void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2);
  
  public abstract void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2);
  
  public abstract void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3);
  
  public abstract void showTouchIdAuthViewImpl(String paramString, VoidStringCallback paramVoidStringCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.gen.KAlertDialog
 * JD-Core Version:    0.7.0.1
 */