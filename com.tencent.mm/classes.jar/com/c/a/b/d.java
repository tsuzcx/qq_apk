package com.c.a.b;

import java.util.Arrays;

public final class d
{
  public final p cow;
  public final String mName;
  
  public d(p paramp, String paramString)
  {
    this.cow = paramp;
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
    } while ((this.cow == paramObject.cow) && (this.mName.equals(paramObject.mName)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.cow, this.mName });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.d
 * JD-Core Version:    0.7.0.1
 */