package com.h.a.b;

import java.util.Arrays;

public final class d
{
  public final p ear;
  public final String mName;
  
  public d(p paramp, String paramString)
  {
    this.ear = paramp;
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
    } while ((this.ear == paramObject.ear) && (this.mName.equals(paramObject.mName)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.ear, this.mName });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.d
 * JD-Core Version:    0.7.0.1
 */