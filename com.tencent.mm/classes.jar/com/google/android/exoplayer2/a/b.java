package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;

public final class b
{
  public static final b avR;
  public final int avS;
  public final int avT;
  AudioAttributes avU;
  public final int flags;
  
  static
  {
    b.a locala = new b.a();
    avR = new b(locala.avS, locala.flags, locala.avT, (byte)0);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.avS = paramInt1;
    this.flags = paramInt2;
    this.avT = paramInt3;
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
      paramObject = (b)paramObject;
    } while ((this.avS == paramObject.avS) && (this.flags == paramObject.flags) && (this.avT == paramObject.avT));
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.avS + 527) * 31 + this.flags) * 31 + this.avT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */