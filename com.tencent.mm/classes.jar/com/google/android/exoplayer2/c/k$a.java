package com.google.android.exoplayer2.c;

import java.util.Arrays;

public final class k$a
{
  public final int ayq;
  public final int ayr;
  public final int azo;
  public final byte[] azp;
  
  public k$a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    this.azo = paramInt1;
    this.azp = paramArrayOfByte;
    this.ayq = paramInt2;
    this.ayr = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (a)paramObject;
    } while ((this.azo == paramObject.azo) && (this.ayq == paramObject.ayq) && (this.ayr == paramObject.ayr) && (Arrays.equals(this.azp, paramObject.azp)));
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.azo * 31 + Arrays.hashCode(this.azp)) * 31 + this.ayq) * 31 + this.ayr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.k.a
 * JD-Core Version:    0.7.0.1
 */