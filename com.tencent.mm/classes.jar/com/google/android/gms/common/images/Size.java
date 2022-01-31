package com.google.android.gms.common.images;

public final class Size
{
  private final int zzrC;
  private final int zzrD;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zzrC = paramInt1;
    this.zzrD = paramInt2;
  }
  
  public static Size parseSize(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("string must not be null");
    }
    int j = paramString.indexOf('*');
    int i = j;
    if (j < 0) {
      i = paramString.indexOf('x');
    }
    if (i < 0) {
      throw zzdi(paramString);
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw zzdi(paramString);
    }
  }
  
  private static NumberFormatException zzdi(String paramString)
  {
    throw new NumberFormatException(String.valueOf(paramString).length() + 16 + "Invalid Size: \"" + paramString + "\"");
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
    } while ((this.zzrC != paramObject.zzrC) || (this.zzrD != paramObject.zzrD));
    return true;
  }
  
  public final int getHeight()
  {
    return this.zzrD;
  }
  
  public final int getWidth()
  {
    return this.zzrC;
  }
  
  public final int hashCode()
  {
    return this.zzrD ^ (this.zzrC << 16 | this.zzrC >>> 16);
  }
  
  public final String toString()
  {
    int i = this.zzrC;
    int j = this.zzrD;
    return 23 + i + "x" + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.images.Size
 * JD-Core Version:    0.7.0.1
 */