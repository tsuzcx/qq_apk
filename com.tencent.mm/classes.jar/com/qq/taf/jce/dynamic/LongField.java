package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LongField
  extends NumberField
{
  private long data;
  
  LongField(long paramLong, int paramInt)
  {
    super(paramInt);
    this.data = paramLong;
  }
  
  public long get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    AppMethodBeat.i(109568);
    long l = this.data;
    AppMethodBeat.o(109568);
    return Long.valueOf(l);
  }
  
  public void set(long paramLong)
  {
    this.data = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.LongField
 * JD-Core Version:    0.7.0.1
 */