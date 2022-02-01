package com.google.android.gms.internal.measurement;

public abstract class zzze
{
  private static volatile boolean zzbrg = false;
  int zzbrd = 100;
  private int zzbre = 2147483647;
  private boolean zzbrf = false;
  
  static zzze zza(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new zzzg(paramArrayOfByte, paramInt1, paramInt2, false, null);
    try
    {
      paramArrayOfByte.zzaf(paramInt2);
      return paramArrayOfByte;
    }
    catch (zzzt paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public abstract int zzsz();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzze
 * JD-Core Version:    0.7.0.1
 */