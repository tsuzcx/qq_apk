package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IntField
  extends NumberField
{
  private int data;
  
  IntField(int paramInt1, int paramInt2)
  {
    super(paramInt2);
    this.data = paramInt1;
  }
  
  public int get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    AppMethodBeat.i(109561);
    int i = this.data;
    AppMethodBeat.o(109561);
    return Integer.valueOf(i);
  }
  
  public void set(int paramInt)
  {
    this.data = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.IntField
 * JD-Core Version:    0.7.0.1
 */