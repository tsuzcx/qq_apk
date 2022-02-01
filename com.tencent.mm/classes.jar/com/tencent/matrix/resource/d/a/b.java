package com.tencent.matrix.resource.d.a;

import java.util.Arrays;

public final class b
{
  public final byte[] fcb;
  
  public b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    this.fcb = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, this.fcb, 0, i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return Arrays.equals(this.fcb, ((b)paramObject).fcb);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.fcb);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    byte[] arrayOfByte = this.fcb;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toHexString(arrayOfByte[i] & 0xFF));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.b
 * JD-Core Version:    0.7.0.1
 */