package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;

public class zzab
  extends ByteArrayOutputStream
{
  private final zzv zzaq;
  
  public zzab(zzv paramzzv, int paramInt)
  {
    this.zzaq = paramzzv;
    this.buf = this.zzaq.zzb(Math.max(paramInt, 256));
  }
  
  private void zzd(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.zzaq.zzb((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.zzaq.zza(this.buf);
    this.buf = arrayOfByte;
  }
  
  public void close()
  {
    this.zzaq.zza(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.zzaq.zza(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      zzd(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      zzd(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzab
 * JD-Core Version:    0.7.0.1
 */