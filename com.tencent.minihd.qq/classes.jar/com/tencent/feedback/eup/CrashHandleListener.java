package com.tencent.feedback.eup;

public abstract interface CrashHandleListener
{
  public abstract byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong);
  
  public abstract String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong);
  
  public abstract boolean onCrashHandleEnd(boolean paramBoolean);
  
  public abstract void onCrashHandleStart(boolean paramBoolean);
  
  public abstract boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.CrashHandleListener
 * JD-Core Version:    0.7.0.1
 */