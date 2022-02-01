package com.d.a.b;

import java.util.Arrays;

public final class d
{
  public final p cjW;
  public final String mName;
  
  public d(p paramp, String paramString)
  {
    this.cjW = paramp;
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
    } while ((this.cjW == paramObject.cjW) && (this.mName.equals(paramObject.mName)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.cjW, this.mName });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */