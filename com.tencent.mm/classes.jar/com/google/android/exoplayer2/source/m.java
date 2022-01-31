package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class m
{
  public static final m aIY = new m(new l[0]);
  public final l[] aIZ;
  private int auK;
  public final int length;
  
  public m(l... paramVarArgs)
  {
    this.aIZ = paramVarArgs;
    this.length = paramVarArgs.length;
  }
  
  public final int a(l paraml)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.aIZ[i] == paraml) {
        return i;
      }
      i += 1;
    }
    return -1;
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
      paramObject = (m)paramObject;
    } while ((this.length == paramObject.length) && (Arrays.equals(this.aIZ, paramObject.aIZ)));
    return false;
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = Arrays.hashCode(this.aIZ);
    }
    return this.auK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.source.m
 * JD-Core Version:    0.7.0.1
 */