package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ByteField
  extends NumberField
{
  private byte data;
  
  ByteField(byte paramByte, int paramInt)
  {
    super(paramInt);
    this.data = paramByte;
  }
  
  public final byte get()
  {
    return this.data;
  }
  
  public final Number getNumber()
  {
    AppMethodBeat.i(117017);
    byte b = this.data;
    AppMethodBeat.o(117017);
    return Byte.valueOf(b);
  }
  
  public final void set(byte paramByte)
  {
    this.data = paramByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ByteField
 * JD-Core Version:    0.7.0.1
 */