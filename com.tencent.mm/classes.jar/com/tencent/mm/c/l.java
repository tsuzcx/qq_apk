package com.tencent.mm.c;

public final class l
  implements Cloneable
{
  public int value;
  
  public l(int paramInt)
  {
    this.value = paramInt;
  }
  
  public l(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, (byte)0);
  }
  
  private l(byte[] paramArrayOfByte, byte paramByte)
  {
    this.value = (paramArrayOfByte[1] << 8 & 0xFF00);
    this.value += (paramArrayOfByte[0] & 0xFF);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof l))) {}
    while (this.value != ((l)paramObject).value) {
      return false;
    }
    return true;
  }
  
  public final byte[] getBytes()
  {
    return new byte[] { (byte)(this.value & 0xFF), (byte)((this.value & 0xFF00) >> 8) };
  }
  
  public final int hashCode()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.c.l
 * JD-Core Version:    0.7.0.1
 */