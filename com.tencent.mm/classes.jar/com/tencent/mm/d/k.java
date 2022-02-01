package com.tencent.mm.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  implements Cloneable
{
  long value;
  
  public k(long paramLong)
  {
    this.value = paramLong;
  }
  
  public k(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, (byte)0);
  }
  
  private k(byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(965);
    this.value = (paramArrayOfByte[3] << 24 & 0xFF000000);
    this.value += (paramArrayOfByte[2] << 16 & 0xFF0000);
    this.value += (paramArrayOfByte[1] << 8 & 0xFF00);
    this.value += (paramArrayOfByte[0] & 0xFF);
    AppMethodBeat.o(965);
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
    return new byte[] { (byte)(int)(this.value & 0xFF), (byte)(int)((this.value & 0xFF00) >> 8), (byte)(int)((this.value & 0xFF0000) >> 16), (byte)(int)((this.value & 0xFF000000) >> 24) };
  }
  
  public final int hashCode()
  {
    return (int)this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.d.k
 * JD-Core Version:    0.7.0.1
 */