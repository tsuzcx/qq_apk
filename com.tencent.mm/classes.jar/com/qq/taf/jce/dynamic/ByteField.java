package com.qq.taf.jce.dynamic;

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
    return Byte.valueOf(this.data);
  }
  
  public final void set(byte paramByte)
  {
    this.data = paramByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ByteField
 * JD-Core Version:    0.7.0.1
 */