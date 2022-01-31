package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzbxt
{
  protected volatile int zzcuJ = -1;
  
  public static final <T extends zzbxt> T zza(T paramT, byte[] paramArrayOfByte)
  {
    return zzb(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final void zza(zzbxt paramzzbxt, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzbxm.zzc(paramArrayOfByte, paramInt1, paramInt2);
      paramzzbxt.zza(paramArrayOfByte);
      paramArrayOfByte.zzaeF();
      return;
    }
    catch (IOException paramzzbxt)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzbxt);
    }
  }
  
  public static final <T extends zzbxt> T zzb(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = zzbxl.zzb(paramArrayOfByte, paramInt1, paramInt2);
      paramT.zzb(paramArrayOfByte);
      paramArrayOfByte.zzqW(0);
      return paramT;
    }
    catch (zzbxs paramT)
    {
      throw paramT;
    }
    catch (IOException paramT)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  public static final byte[] zzf(zzbxt paramzzbxt)
  {
    byte[] arrayOfByte = new byte[paramzzbxt.zzaeS()];
    zza(paramzzbxt, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return zzbxu.zzg(this);
  }
  
  public void zza(zzbxm paramzzbxm) {}
  
  public zzbxt zzaeH()
  {
    return (zzbxt)super.clone();
  }
  
  public int zzaeR()
  {
    if (this.zzcuJ < 0) {
      zzaeS();
    }
    return this.zzcuJ;
  }
  
  public int zzaeS()
  {
    int i = zzu();
    this.zzcuJ = i;
    return i;
  }
  
  public abstract zzbxt zzb(zzbxl paramzzbxl);
  
  protected int zzu()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxt
 * JD-Core Version:    0.7.0.1
 */