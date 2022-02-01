package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements Cloneable
{
  public int value;
  
  public k(int paramInt)
  {
    this.value = paramInt;
  }
  
  public k(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, (byte)0);
  }
  
  private k(byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(958);
    this.value = (paramArrayOfByte[1] << 8 & 0xFF00);
    this.value += (paramArrayOfByte[0] & 0xFF);
    AppMethodBeat.o(958);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof k))) {}
    while (this.value != ((k)paramObject).value) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.d.k
 * JD-Core Version:    0.7.0.1
 */