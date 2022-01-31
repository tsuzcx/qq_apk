package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzf$zzc
  extends zzf.zza
{
  private static final WeakReference<byte[]> zzayv = new WeakReference(null);
  private WeakReference<byte[]> zzayu = zzayv;
  
  zzf$zzc(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])this.zzayu.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = zzvc();
        this.zzayu = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] zzvc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.zzf.zzc
 * JD-Core Version:    0.7.0.1
 */