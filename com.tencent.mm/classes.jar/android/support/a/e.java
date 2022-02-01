package android.support.a;

public final class e
{
  double gm = Math.sqrt(1500.0D);
  double gn = 0.5D;
  double go;
  double gp;
  private double gq;
  private double gr;
  private double gs;
  double gt = 1.7976931348623157E+308D;
  private final b.a gu = new b.a();
  private boolean mInitialized = false;
  
  public e() {}
  
  public e(float paramFloat)
  {
    this.gt = paramFloat;
  }
  
  private void init()
  {
    if (this.mInitialized) {
      return;
    }
    if (this.gt == 1.7976931348623157E+308D) {
      throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
    if (this.gn > 1.0D)
    {
      this.gq = (-this.gn * this.gm + this.gm * Math.sqrt(this.gn * this.gn - 1.0D));
      this.gr = (-this.gn * this.gm - this.gm * Math.sqrt(this.gn * this.gn - 1.0D));
    }
    for (;;)
    {
      this.mInitialized = true;
      return;
      if ((this.gn >= 0.0D) && (this.gn < 1.0D)) {
        this.gs = (this.gm * Math.sqrt(1.0D - this.gn * this.gn));
      }
    }
  }
  
  final b.a a(double paramDouble1, double paramDouble2, long paramLong)
  {
    init();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.gt;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.gn > 1.0D)
    {
      d2 = paramDouble1 - (this.gr * paramDouble1 - paramDouble2) / (this.gr - this.gq);
      paramDouble1 = (this.gr * paramDouble1 - paramDouble2) / (this.gr - this.gq);
      paramDouble2 = Math.pow(2.718281828459045D, this.gr * d1) * d2 + Math.pow(2.718281828459045D, this.gq * d1) * paramDouble1;
      d3 = this.gr;
      d4 = Math.pow(2.718281828459045D, this.gr * d1);
      d5 = this.gq;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.gq) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.gu.fZ = ((float)(paramDouble2 + this.gt));
      this.gu.fY = ((float)paramDouble1);
      return this.gu;
      if (this.gn == 1.0D)
      {
        d2 = paramDouble2 + this.gm * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.gm * d1);
        d3 = Math.pow(2.718281828459045D, -this.gm * d1);
        d4 = -this.gm;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.gm) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.gs;
        d2 = (this.gn * this.gm * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.gn * this.gm * d1) * (Math.cos(this.gs * d1) * paramDouble1 + Math.sin(this.gs * d1) * d2);
        d3 = -this.gm;
        d4 = this.gn;
        d5 = Math.pow(2.718281828459045D, -this.gn * this.gm * d1);
        double d6 = -this.gs;
        double d7 = Math.sin(this.gs * d1);
        double d8 = this.gs;
        paramDouble1 = (Math.cos(d1 * this.gs) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public final e g(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }
    this.gm = Math.sqrt(paramFloat);
    this.mInitialized = false;
    return this;
  }
  
  public final e h(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Damping ratio must be non-negative");
    }
    this.gn = paramFloat;
    this.mInitialized = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.a.e
 * JD-Core Version:    0.7.0.1
 */