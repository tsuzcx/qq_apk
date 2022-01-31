package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShortField
  extends NumberField
{
  private short data;
  
  ShortField(short paramShort, int paramInt)
  {
    super(paramInt);
    this.data = paramShort;
  }
  
  public final short get()
  {
    return this.data;
  }
  
  public final Number getNumber()
  {
    AppMethodBeat.i(117008);
    short s = this.data;
    AppMethodBeat.o(117008);
    return Short.valueOf(s);
  }
  
  public final void set(short paramShort)
  {
    this.data = paramShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.ShortField
 * JD-Core Version:    0.7.0.1
 */