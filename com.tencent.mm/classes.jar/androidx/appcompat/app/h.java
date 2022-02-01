package androidx.appcompat.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class h
{
  private static h iA;
  public long iB;
  public long iC;
  public int state;
  
  static h bV()
  {
    AppMethodBeat.i(200508);
    if (iA == null) {
      iA = new h();
    }
    h localh = iA;
    AppMethodBeat.o(200508);
    return localh;
  }
  
  public final void b(long paramLong, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(200525);
    float f1 = (float)(paramLong - 946728000000L) / 86400000.0F;
    float f2 = 6.24006F + 0.01720197F * f1;
    double d1 = f2 + 0.03341960161924362D * Math.sin(f2) + 0.0003490659873933D * Math.sin(2.0F * f2) + 5.236000106378924E-006D * Math.sin(3.0F * f2) + 1.796593063D + 3.141592653589793D;
    paramDouble2 = -paramDouble2 / 360.0D;
    double d2 = (float)Math.round(f1 - 0.0009F - paramDouble2) + 0.0009F;
    paramDouble2 = Math.sin(f2) * 0.0053D + (paramDouble2 + d2) + -0.0069D * Math.sin(2.0D * d1);
    d1 = Math.asin(Math.sin(d1) * Math.sin(0.4092797040939331D));
    double d4 = 0.0174532923847437D * paramDouble1;
    paramDouble1 = Math.sin(-0.1047197580337524D);
    d2 = Math.sin(d4);
    double d3 = Math.sin(d1);
    d4 = Math.cos(d4);
    paramDouble1 = (paramDouble1 - d2 * d3) / (Math.cos(d1) * d4);
    if (paramDouble1 >= 1.0D)
    {
      this.state = 1;
      this.iB = -1L;
      this.iC = -1L;
      AppMethodBeat.o(200525);
      return;
    }
    if (paramDouble1 <= -1.0D)
    {
      this.state = 0;
      this.iB = -1L;
      this.iC = -1L;
      AppMethodBeat.o(200525);
      return;
    }
    f1 = (float)(Math.acos(paramDouble1) / 6.283185307179586D);
    this.iB = (Math.round((f1 + paramDouble2) * 86400000.0D) + 946728000000L);
    this.iC = (Math.round((paramDouble2 - f1) * 86400000.0D) + 946728000000L);
    if ((this.iC < paramLong) && (this.iB > paramLong))
    {
      this.state = 0;
      AppMethodBeat.o(200525);
      return;
    }
    this.state = 1;
    AppMethodBeat.o(200525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.appcompat.app.h
 * JD-Core Version:    0.7.0.1
 */