package com.google.android.gms.internal.wearable;

import java.io.IOException;

public abstract class zzt
{
  protected volatile int zzhl = -1;
  
  public static final <T extends zzt> T zza(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzk.zza(paramArrayOfByte, 0, paramInt2);
      paramT.zza(paramArrayOfByte);
      paramArrayOfByte.zzc(0);
      return paramT;
    }
    catch (zzs paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramT);
    }
  }
  
  public static final byte[] zzb(zzt paramzzt)
  {
    byte[] arrayOfByte = new byte[paramzzt.zzx()];
    int i = arrayOfByte.length;
    try
    {
      zzl localzzl = zzl.zzb(arrayOfByte, 0, i);
      paramzzt.zza(localzzl);
      localzzl.zzr();
      return arrayOfByte;
    }
    catch (IOException paramzzt)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzt);
    }
  }
  
  public String toString()
  {
    return zzu.zzc(this);
  }
  
  public abstract zzt zza(zzk paramzzk);
  
  public void zza(zzl paramzzl) {}
  
  protected int zzg()
  {
    return 0;
  }
  
  public zzt zzs()
  {
    return (zzt)super.clone();
  }
  
  public final int zzx()
  {
    int i = zzg();
    this.zzhl = i;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzt
 * JD-Core Version:    0.7.0.1
 */