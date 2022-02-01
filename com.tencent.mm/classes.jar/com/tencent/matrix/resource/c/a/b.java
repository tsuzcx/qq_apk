package com.tencent.matrix.resource.c.a;

import java.util.Arrays;

public final class b
{
  public final byte[] cZp;
  
  public b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    this.cZp = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, this.cZp, 0, i);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {
      return false;
    }
    return Arrays.equals(this.cZp, ((b)paramObject).cZp);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.cZp);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0x");
    byte[] arrayOfByte = this.cZp;
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