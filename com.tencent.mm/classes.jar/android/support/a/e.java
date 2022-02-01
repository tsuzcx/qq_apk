package android.support.a;

public final class e
{
  double er = Math.sqrt(1500.0D);
  double es = 0.5D;
  double et;
  double eu;
  private double ev;
  private double ew;
  private double ex;
  double ey = 1.7976931348623157E+308D;
  private final b.a ez = new b.a();
  private boolean mInitialized = false;
  
  public e() {}
  
  public e(float paramFloat)
  {
    this.ey = paramFloat;
  }
  
  private void init()
  {
    if (this.mInitialized) {
      return;
    }
    if (this.ey == 1.7976931348623157E+308D) {
      throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
    if (this.es > 1.0D)
    {
      this.ev = (-this.es * this.er + this.er * Math.sqrt(this.es * this.es - 1.0D));
      this.ew = (-this.es * this.er - this.er * Math.sqrt(this.es * this.es - 1.0D));
    }
    for (;;)
    {
      this.mInitialized = true;
      return;
      if ((this.es >= 0.0D) && (this.es < 1.0D)) {
        this.ex = (this.er * Math.sqrt(1.0D - this.es * this.es));
      }
    }
  }
  
  final b.a a(double paramDouble1, double paramDouble2, long paramLong)
  {
    init();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.ey;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.es > 1.0D)
    {
      d2 = paramDouble1 - (this.ew * paramDouble1 - paramDouble2) / (this.ew - this.ev);
      paramDouble1 = (this.ew * paramDouble1 - paramDouble2) / (this.ew - this.ev);
      paramDouble2 = Math.pow(2.718281828459045D, this.ew * d1) * d2 + Math.pow(2.718281828459045D, this.ev * d1) * paramDouble1;
      d3 = this.ew;
      d4 = Math.pow(2.718281828459045D, this.ew * d1);
      d5 = this.ev;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.ev) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.ez.ed = ((float)(paramDouble2 + this.ey));
      this.ez.ec = ((float)paramDouble1);
      return this.ez;
      if (this.es == 1.0D)
      {
        d2 = paramDouble2 + this.er * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.er * d1);
        d3 = Math.pow(2.718281828459045D, -this.er * d1);
        d4 = -this.er;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.er) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.ex;
        d2 = (this.es * this.er * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.es * this.er * d1) * (Math.cos(this.ex * d1) * paramDouble1 + Math.sin(this.ex * d1) * d2);
        d3 = -this.er;
        d4 = this.es;
        d5 = Math.pow(2.718281828459045D, -this.es * this.er * d1);
        double d6 = -this.ex;
        double d7 = Math.sin(this.ex * d1);
        double d8 = this.ex;
        paramDouble1 = (Math.cos(d1 * this.ex) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public final e h(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }
    this.er = Math.sqrt(paramFloat);
    this.mInitialized = false;
    return this;
  }
  
  public final e i(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Damping ratio must be non-negative");
    }
    this.es = paramFloat;
    this.mInitialized = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.e
 * JD-Core Version:    0.7.0.1
 */