package com.tencent.map.lib.gl.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
{
  private float a;
  private float b;
  private float c;
  
  public d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(98152);
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    c();
    AppMethodBeat.o(98152);
  }
  
  private void c()
  {
    AppMethodBeat.i(98154);
    double d = b();
    if (d == 0.0D)
    {
      AppMethodBeat.o(98154);
      return;
    }
    this.a = ((float)(this.a / d));
    this.b = ((float)(this.b / d));
    this.c = ((float)(this.c / d));
    AppMethodBeat.o(98154);
  }
  
  public float[] a()
  {
    return new float[] { this.a, this.b, this.c };
  }
  
  public double b()
  {
    AppMethodBeat.i(98153);
    double d = Math.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
    AppMethodBeat.o(98153);
    return d;
  }
  
  public String toString()
  {
    AppMethodBeat.i(98155);
    String str = this.a + "," + this.b + "," + this.c;
    AppMethodBeat.o(98155);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.lib.gl.model.d
 * JD-Core Version:    0.7.0.1
 */