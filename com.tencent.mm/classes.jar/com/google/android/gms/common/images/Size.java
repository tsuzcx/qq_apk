package com.google.android.gms.common.images;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Size
{
  private final int zzps;
  private final int zzpt;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zzps = paramInt1;
    this.zzpt = paramInt2;
  }
  
  public static Size parseSize(String paramString)
  {
    AppMethodBeat.i(11737);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("string must not be null");
      AppMethodBeat.o(11737);
      throw paramString;
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0)
    {
      paramString = zzi(paramString);
      AppMethodBeat.o(11737);
      throw paramString;
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      AppMethodBeat.o(11737);
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = zzi(paramString);
      AppMethodBeat.o(11737);
      throw paramString;
    }
  }
  
  private static NumberFormatException zzi(String paramString)
  {
    AppMethodBeat.i(11736);
    paramString = new NumberFormatException(String.valueOf(paramString).length() + 16 + "Invalid Size: \"" + paramString + "\"");
    AppMethodBeat.o(11736);
    throw paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (!(paramObject instanceof Size));
      paramObject = (Size)paramObject;
    } while ((this.zzps != paramObject.zzps) || (this.zzpt != paramObject.zzpt));
    return true;
  }
  
  public final int getHeight()
  {
    return this.zzpt;
  }
  
  public final int getWidth()
  {
    return this.zzps;
  }
  
  public final int hashCode()
  {
    return this.zzpt ^ (this.zzps << 16 | this.zzps >>> 16);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(11735);
    int i = this.zzps;
    int j = this.zzpt;
    String str = 23 + i + "x" + j;
    AppMethodBeat.o(11735);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.Size
 * JD-Core Version:    0.7.0.1
 */