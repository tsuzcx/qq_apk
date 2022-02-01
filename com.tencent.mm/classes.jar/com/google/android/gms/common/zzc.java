package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzc
  extends GoogleCertificates.CertData
{
  private static final WeakReference<byte[]> zzbf = new WeakReference(null);
  private WeakReference<byte[]> zzbe = zzbf;
  
  zzc(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  final byte[] getBytes()
  {
    try
    {
      byte[] arrayOfByte2 = (byte[])this.zzbe.get();
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
      {
        arrayOfByte1 = zzf();
        this.zzbe = new WeakReference(arrayOfByte1);
      }
      return arrayOfByte1;
    }
    finally {}
  }
  
  protected abstract byte[] zzf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.zzc
 * JD-Core Version:    0.7.0.1
 */