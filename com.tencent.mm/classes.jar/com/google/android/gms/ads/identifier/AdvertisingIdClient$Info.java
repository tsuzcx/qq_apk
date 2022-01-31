package com.google.android.gms.ads.identifier;

public final class AdvertisingIdClient$Info
{
  private final String zzsl;
  private final boolean zzsm;
  
  public AdvertisingIdClient$Info(String paramString, boolean paramBoolean)
  {
    this.zzsl = paramString;
    this.zzsm = paramBoolean;
  }
  
  public final String getId()
  {
    return this.zzsl;
  }
  
  public final boolean isLimitAdTrackingEnabled()
  {
    return this.zzsm;
  }
  
  public final String toString()
  {
    String str = this.zzsl;
    boolean bool = this.zzsm;
    return String.valueOf(str).length() + 7 + "{" + str + "}" + bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient.Info
 * JD-Core Version:    0.7.0.1
 */