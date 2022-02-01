package com.e.a.b;

import java.util.Arrays;

public final class d
{
  public final p cdS;
  public final String mName;
  
  public d(p paramp, String paramString)
  {
    this.cdS = paramp;
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
    } while ((this.cdS == paramObject.cdS) && (this.mName.equals(paramObject.mName)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.cdS, this.mName });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.d
 * JD-Core Version:    0.7.0.1
 */