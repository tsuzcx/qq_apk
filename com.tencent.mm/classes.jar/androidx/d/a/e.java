package androidx.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  double Tl;
  double Tm;
  double Tn;
  double To;
  private double Tp;
  private double Tq;
  private double Tr;
  double Ts;
  private final b.a Tt;
  private boolean mInitialized;
  
  public e()
  {
    AppMethodBeat.i(250196);
    this.Tl = Math.sqrt(1500.0D);
    this.Tm = 0.5D;
    this.mInitialized = false;
    this.Ts = 1.7976931348623157E+308D;
    this.Tt = new b.a();
    AppMethodBeat.o(250196);
  }
  
  public e(float paramFloat)
  {
    AppMethodBeat.i(250198);
    this.Tl = Math.sqrt(1500.0D);
    this.Tm = 0.5D;
    this.mInitialized = false;
    this.Ts = 1.7976931348623157E+308D;
    this.Tt = new b.a();
    this.Ts = paramFloat;
    AppMethodBeat.o(250198);
  }
  
  private void init()
  {
    AppMethodBeat.i(250202);
    if (this.mInitialized)
    {
      AppMethodBeat.o(250202);
      return;
    }
    if (this.Ts == 1.7976931348623157E+308D)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
      AppMethodBeat.o(250202);
      throw localIllegalStateException;
    }
    if (this.Tm > 1.0D)
    {
      this.Tp = (-this.Tm * this.Tl + this.Tl * Math.sqrt(this.Tm * this.Tm - 1.0D));
      this.Tq = (-this.Tm * this.Tl - this.Tl * Math.sqrt(this.Tm * this.Tm - 1.0D));
    }
    for (;;)
    {
      this.mInitialized = true;
      AppMethodBeat.o(250202);
      return;
      if ((this.Tm >= 0.0D) && (this.Tm < 1.0D)) {
        this.Tr = (this.Tl * Math.sqrt(1.0D - this.Tm * this.Tm));
      }
    }
  }
  
  final b.a a(double paramDouble1, double paramDouble2, long paramLong)
  {
    AppMethodBeat.i(250204);
    init();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.Ts;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.Tm > 1.0D)
    {
      d2 = paramDouble1 - (this.Tq * paramDouble1 - paramDouble2) / (this.Tq - this.Tp);
      paramDouble1 = (this.Tq * paramDouble1 - paramDouble2) / (this.Tq - this.Tp);
      paramDouble2 = Math.pow(2.718281828459045D, this.Tq * d1) * d2 + Math.pow(2.718281828459045D, this.Tp * d1) * paramDouble1;
      d3 = this.Tq;
      d4 = Math.pow(2.718281828459045D, this.Tq * d1);
      d5 = this.Tp;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.Tp) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.Tt.SY = ((float)(paramDouble2 + this.Ts));
      this.Tt.SX = ((float)paramDouble1);
      b.a locala = this.Tt;
      AppMethodBeat.o(250204);
      return locala;
      if (this.Tm == 1.0D)
      {
        d2 = paramDouble2 + this.Tl * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.Tl * d1);
        d3 = Math.pow(2.718281828459045D, -this.Tl * d1);
        d4 = -this.Tl;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.Tl) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.Tr;
        d2 = (this.Tm * this.Tl * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.Tm * this.Tl * d1) * (Math.cos(this.Tr * d1) * paramDouble1 + Math.sin(this.Tr * d1) * d2);
        d3 = -this.Tl;
        d4 = this.Tm;
        d5 = Math.pow(2.718281828459045D, -this.Tm * this.Tl * d1);
        double d6 = -this.Tr;
        double d7 = Math.sin(this.Tr * d1);
        double d8 = this.Tr;
        paramDouble1 = (Math.cos(d1 * this.Tr) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public final e p(float paramFloat)
  {
    AppMethodBeat.i(250200);
    if (paramFloat <= 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Spring stiffness constant must be positive.");
      AppMethodBeat.o(250200);
      throw localIllegalArgumentException;
    }
    this.Tl = Math.sqrt(paramFloat);
    this.mInitialized = false;
    AppMethodBeat.o(250200);
    return this;
  }
  
  public final e q(float paramFloat)
  {
    AppMethodBeat.i(250201);
    if (paramFloat < 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Damping ratio must be non-negative");
      AppMethodBeat.o(250201);
      throw localIllegalArgumentException;
    }
    this.Tm = paramFloat;
    this.mInitialized = false;
    AppMethodBeat.o(250201);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.d.a.e
 * JD-Core Version:    0.7.0.1
 */