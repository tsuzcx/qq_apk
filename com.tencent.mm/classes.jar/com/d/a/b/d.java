package com.d.a.b;

import java.util.Arrays;

public final class d
{
  public final p bVX;
  public final String mName;
  
  public d(p paramp, String paramString)
  {
    this.bVX = paramp;
    this.mName = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = (d)paramObject;
    } while ((this.bVX == paramObject.bVX) && (this.mName.equals(paramObject.mName)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.bVX, this.mName });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */