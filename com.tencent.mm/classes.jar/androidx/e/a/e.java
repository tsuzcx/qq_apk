package androidx.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  double bzB;
  double bzC;
  double bzD;
  double bzE;
  private double bzF;
  private double bzG;
  private double bzH;
  double bzI;
  private final b.a bzJ;
  private boolean mInitialized;
  
  public e()
  {
    AppMethodBeat.i(196503);
    this.bzB = Math.sqrt(1500.0D);
    this.bzC = 0.5D;
    this.mInitialized = false;
    this.bzI = 1.7976931348623157E+308D;
    this.bzJ = new b.a();
    AppMethodBeat.o(196503);
  }
  
  public e(float paramFloat)
  {
    AppMethodBeat.i(196515);
    this.bzB = Math.sqrt(1500.0D);
    this.bzC = 0.5D;
    this.mInitialized = false;
    this.bzI = 1.7976931348623157E+308D;
    this.bzJ = new b.a();
    this.bzI = paramFloat;
    AppMethodBeat.o(196515);
  }
  
  private void init()
  {
    AppMethodBeat.i(196530);
    if (this.mInitialized)
    {
      AppMethodBeat.o(196530);
      return;
    }
    if (this.bzI == 1.7976931348623157E+308D)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
      AppMethodBeat.o(196530);
      throw localIllegalStateException;
    }
    if (this.bzC > 1.0D)
    {
      this.bzF = (-this.bzC * this.bzB + this.bzB * Math.sqrt(this.bzC * this.bzC - 1.0D));
      this.bzG = (-this.bzC * this.bzB - this.bzB * Math.sqrt(this.bzC * this.bzC - 1.0D));
    }
    for (;;)
    {
      this.mInitialized = true;
      AppMethodBeat.o(196530);
      return;
      if ((this.bzC >= 0.0D) && (this.bzC < 1.0D)) {
        this.bzH = (this.bzB * Math.sqrt(1.0D - this.bzC * this.bzC));
      }
    }
  }
  
  final b.a a(double paramDouble1, double paramDouble2, long paramLong)
  {
    AppMethodBeat.i(196576);
    init();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.bzI;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.bzC > 1.0D)
    {
      d2 = paramDouble1 - (this.bzG * paramDouble1 - paramDouble2) / (this.bzG - this.bzF);
      paramDouble1 = (this.bzG * paramDouble1 - paramDouble2) / (this.bzG - this.bzF);
      paramDouble2 = Math.pow(2.718281828459045D, this.bzG * d1) * d2 + Math.pow(2.718281828459045D, this.bzF * d1) * paramDouble1;
      d3 = this.bzG;
      d4 = Math.pow(2.718281828459045D, this.bzG * d1);
      d5 = this.bzF;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.bzF) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.bzJ.bzo = ((float)(paramDouble2 + this.bzI));
      this.bzJ.bzn = ((float)paramDouble1);
      b.a locala = this.bzJ;
      AppMethodBeat.o(196576);
      return locala;
      if (this.bzC == 1.0D)
      {
        d2 = paramDouble2 + this.bzB * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.bzB * d1);
        d3 = Math.pow(2.718281828459045D, -this.bzB * d1);
        d4 = -this.bzB;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.bzB) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.bzH;
        d2 = (this.bzC * this.bzB * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.bzC * this.bzB * d1) * (Math.cos(this.bzH * d1) * paramDouble1 + Math.sin(this.bzH * d1) * d2);
        d3 = -this.bzB;
        d4 = this.bzC;
        d5 = Math.pow(2.718281828459045D, -this.bzC * this.bzB * d1);
        double d6 = -this.bzH;
        double d7 = Math.sin(this.bzH * d1);
        double d8 = this.bzH;
        paramDouble1 = (Math.cos(d1 * this.bzH) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public final e aw(float paramFloat)
  {
    AppMethodBeat.i(196541);
    if (paramFloat <= 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Spring stiffness constant must be positive.");
      AppMethodBeat.o(196541);
      throw localIllegalArgumentException;
    }
    this.bzB = Math.sqrt(paramFloat);
    this.mInitialized = false;
    AppMethodBeat.o(196541);
    return this;
  }
  
  public final e ax(float paramFloat)
  {
    AppMethodBeat.i(196556);
    if (paramFloat < 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Damping ratio must be non-negative");
      AppMethodBeat.o(196556);
      throw localIllegalArgumentException;
    }
    this.bzC = paramFloat;
    this.mInitialized = false;
    AppMethodBeat.o(196556);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.e.a.e
 * JD-Core Version:    0.7.0.1
 */