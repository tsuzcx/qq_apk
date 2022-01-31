package com.tencent.kinda.gen;

public abstract interface KFingerprintService
{
  public abstract void authenticateImpl(String paramString1, String paramString2, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback, VoidBoolCallback paramVoidBoolCallback, VoidStringCallback paramVoidStringCallback);
  
  public abstract void reGenFpRsaKeyImpl(boolean paramBoolean, int paramInt, String paramString, VoidStringStringCallback paramVoidStringStringCallback, VoidCallback paramVoidCallback);
  
  public abstract void releaseService();
  
  public abstract void showFaceIdAuthDialogImpl(String paramString, VoidBinaryI32Callback paramVoidBinaryI32Callback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2);
  
  public abstract BioType supportBioType();
  
  public abstract void userCancel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.KFingerprintService
 * JD-Core Version:    0.7.0.1
 */