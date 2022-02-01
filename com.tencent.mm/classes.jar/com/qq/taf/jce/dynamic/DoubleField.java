package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DoubleField
  extends NumberField
{
  private double data;
  
  DoubleField(double paramDouble, int paramInt)
  {
    super(paramInt);
    this.data = paramDouble;
  }
  
  public double get()
  {
    return this.data;
  }
  
  public Number getNumber()
  {
    AppMethodBeat.i(109570);
    double d = this.data;
    AppMethodBeat.o(109570);
    return Double.valueOf(d);
  }
  
  public void set(double paramDouble)
  {
    this.data = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DoubleField
 * JD-Core Version:    0.7.0.1
 */