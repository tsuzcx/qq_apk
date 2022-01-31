package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzc
{
  public static final zzc zzbgR = new zzc(0, 30, 3600);
  public static final zzc zzbgS = new zzc(1, 30, 3600);
  private final int zzbgT;
  private final int zzbgU;
  private final int zzbgV;
  
  private zzc(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzbgT = paramInt1;
    this.zzbgU = paramInt2;
    this.zzbgV = paramInt3;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      paramObject = (zzc)paramObject;
    } while ((paramObject.zzbgT == this.zzbgT) && (paramObject.zzbgU == this.zzbgU) && (paramObject.zzbgV == this.zzbgV));
    return false;
  }
  
  public int hashCode()
  {
    return ((this.zzbgT + 1 ^ 0xF4243) * 1000003 ^ this.zzbgU) * 1000003 ^ this.zzbgV;
  }
  
  public String toString()
  {
    int i = this.zzbgT;
    int j = this.zzbgU;
    int k = this.zzbgV;
    return 74 + "policy=" + i + " initial_backoff=" + j + " maximum_backoff=" + k;
  }
  
  public int zzGT()
  {
    return this.zzbgT;
  }
  
  public int zzGU()
  {
    return this.zzbgU;
  }
  
  public int zzGV()
  {
    return this.zzbgV;
  }
  
  public Bundle zzK(Bundle paramBundle)
  {
    paramBundle.putInt("retry_policy", this.zzbgT);
    paramBundle.putInt("initial_backoff_seconds", this.zzbgU);
    paramBundle.putInt("maximum_backoff_seconds", this.zzbgV);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.gcm.zzc
 * JD-Core Version:    0.7.0.1
 */