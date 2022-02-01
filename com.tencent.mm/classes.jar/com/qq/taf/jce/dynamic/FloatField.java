package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FloatField
  extends NumberField
{
  private float data;
  
  FloatField(float paramFloat, int paramInt)
  {
    super(paramInt);
    this.data = paramFloat;
  }
  
  public float get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    AppMethodBeat.i(109572);
    float f = this.data;
    AppMethodBeat.o(109572);
    return Float.valueOf(f);
  }
  
  public void set(float paramFloat)
  {
    this.data = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.FloatField
 * JD-Core Version:    0.7.0.1
 */