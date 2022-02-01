package com.tencent.matrix.resource.c.a;

import java.util.Arrays;

public final class b
{
  public final byte[] cAf;
  
  public b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    this.cAf = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, this.cAf, 0, i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return Arrays.equals(this.cAf, ((b)paramObject).cAf);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.cAf);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    byte[] arrayOfByte = this.cAf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.b
 * JD-Core Version:    0.7.0.1
 */