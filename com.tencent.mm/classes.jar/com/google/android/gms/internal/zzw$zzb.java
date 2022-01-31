package com.google.android.gms.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

class zzw$zzb
  extends FilterInputStream
{
  private int zzaC = 0;
  
  private zzw$zzb(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public int read()
  {
    int i = super.read();
    if (i != -1) {
      this.zzaC += 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.zzaC += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.internal.zzw.zzb
 * JD-Core Version:    0.7.0.1
 */