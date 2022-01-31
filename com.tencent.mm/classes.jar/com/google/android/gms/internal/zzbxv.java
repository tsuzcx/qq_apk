package com.google.android.gms.internal;

import java.util.Arrays;

final class zzbxv
{
  final int tag;
  final byte[] zzbyd;
  
  zzbxv(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbyd = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzbxv)) {
        return false;
      }
      paramObject = (zzbxv)paramObject;
    } while ((this.tag == paramObject.tag) && (Arrays.equals(this.zzbyd, paramObject.zzbyd)));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.zzbyd);
  }
  
  final void zza(zzbxm paramzzbxm)
  {
    paramzzbxm.zzrj(this.tag);
    paramzzbxm.zzaj(this.zzbyd);
  }
  
  final int zzu()
  {
    return zzbxm.zzrk(this.tag) + 0 + this.zzbyd.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzbxv
 * JD-Core Version:    0.7.0.1
 */