package android.support.a;

public final class e
{
  double gk = Math.sqrt(1500.0D);
  double gl = 0.5D;
  double gm;
  double gn;
  private double go;
  private double gp;
  private double gq;
  double gr = 1.7976931348623157E+308D;
  private final b.a gs = new b.a();
  private boolean mInitialized = false;
  
  public e() {}
  
  public e(float paramFloat)
  {
    this.gr = paramFloat;
  }
  
  private void init()
  {
    if (this.mInitialized) {
      return;
    }
    if (this.gr == 1.7976931348623157E+308D) {
      throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }
    if (this.gl > 1.0D)
    {
      this.go = (-this.gl * this.gk + this.gk * Math.sqrt(this.gl * this.gl - 1.0D));
      this.gp = (-this.gl * this.gk - this.gk * Math.sqrt(this.gl * this.gl - 1.0D));
    }
    for (;;)
    {
      this.mInitialized = true;
      return;
      if ((this.gl >= 0.0D) && (this.gl < 1.0D)) {
        this.gq = (this.gk * Math.sqrt(1.0D - this.gl * this.gl));
      }
    }
  }
  
  final b.a a(double paramDouble1, double paramDouble2, long paramLong)
  {
    init();
    double d1 = paramLong / 1000.0D;
    paramDouble1 -= this.gr;
    double d2;
    double d3;
    double d4;
    double d5;
    if (this.gl > 1.0D)
    {
      d2 = paramDouble1 - (this.gp * paramDouble1 - paramDouble2) / (this.gp - this.go);
      paramDouble1 = (this.gp * paramDouble1 - paramDouble2) / (this.gp - this.go);
      paramDouble2 = Math.pow(2.718281828459045D, this.gp * d1) * d2 + Math.pow(2.718281828459045D, this.go * d1) * paramDouble1;
      d3 = this.gp;
      d4 = Math.pow(2.718281828459045D, this.gp * d1);
      d5 = this.go;
      paramDouble1 = Math.pow(2.718281828459045D, d1 * this.go) * (paramDouble1 * d5) + d2 * d3 * d4;
    }
    for (;;)
    {
      this.gs.fX = ((float)(paramDouble2 + this.gr));
      this.gs.fW = ((float)paramDouble1);
      return this.gs;
      if (this.gl == 1.0D)
      {
        d2 = paramDouble2 + this.gk * paramDouble1;
        paramDouble2 = (d2 * d1 + paramDouble1) * Math.pow(2.718281828459045D, -this.gk * d1);
        d3 = Math.pow(2.718281828459045D, -this.gk * d1);
        d4 = -this.gk;
        paramDouble1 = Math.pow(2.718281828459045D, d1 * -this.gk) * d2 + (paramDouble1 + d2 * d1) * d3 * d4;
      }
      else
      {
        d2 = 1.0D / this.gq;
        d2 = (this.gl * this.gk * paramDouble1 + paramDouble2) * d2;
        paramDouble2 = Math.pow(2.718281828459045D, -this.gl * this.gk * d1) * (Math.cos(this.gq * d1) * paramDouble1 + Math.sin(this.gq * d1) * d2);
        d3 = -this.gk;
        d4 = this.gl;
        d5 = Math.pow(2.718281828459045D, -this.gl * this.gk * d1);
        double d6 = -this.gq;
        double d7 = Math.sin(this.gq * d1);
        double d8 = this.gq;
        paramDouble1 = (Math.cos(d1 * this.gq) * (d2 * d8) + paramDouble1 * d6 * d7) * d5 + d3 * paramDouble2 * d4;
      }
    }
  }
  
  public final e g(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }
    this.gk = Math.sqrt(paramFloat);
    this.mInitialized = false;
    return this;
  }
  
  public final e h(float paramFloat)
  {
    if (paramFloat < 0.0F) {
      throw new IllegalArgumentException("Damping ratio must be non-negative");
    }
    this.gl = paramFloat;
    this.mInitialized = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.a.e
 * JD-Core Version:    0.7.0.1
 */