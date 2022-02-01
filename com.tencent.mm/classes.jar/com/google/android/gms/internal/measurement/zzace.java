package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzace
{
  protected volatile int zzbxh = -1;
  
  public static final <T extends zzace> T zza(T paramT, byte[] paramArrayOfByte)
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzace paramzzace, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzabw.zzb(paramArrayOfByte, 0, paramInt2);
      paramzzace.zza(paramArrayOfByte);
      paramArrayOfByte.zzve();
      return;
    }
    catch (IOException paramzzace)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzace);
    }
  }
  
  private static final <T extends zzace> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzabv.zza(paramArrayOfByte, 0, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzaj(0);
      return paramT;
    }
    catch (zzacd paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramT);
    }
  }
  
  public String toString()
  {
    return zzacf.zzc(this);
  }
  
  protected int zza()
  {
    return 0;
  }
  
  public void zza(zzabw paramzzabw) {}
  
  public abstract zzace zzb(zzabv paramzzabv);
  
  public zzace zzvf()
  {
    return (zzace)super.clone();
  }
  
  public final int zzvl()
  {
    if (this.zzbxh < 0) {
      zzvm();
    }
    return this.zzbxh;
  }
  
  public final int zzvm()
  {
    int i = zza();
    this.zzbxh = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzace
 * JD-Core Version:    0.7.0.1
 */