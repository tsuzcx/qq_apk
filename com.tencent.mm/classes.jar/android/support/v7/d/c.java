package android.support.v7.d;

public final class c
{
  public static final c RJ;
  public static final c RK;
  public static final c RL;
  public static final c RM;
  public static final c RN;
  public static final c RO;
  public final float[] RP = new float[3];
  public final float[] RQ = new float[3];
  public final float[] RR = new float[3];
  public boolean RS = true;
  
  static
  {
    c localc = new c();
    RJ = localc;
    c(localc);
    d(RJ);
    localc = new c();
    RK = localc;
    b(localc);
    d(RK);
    localc = new c();
    RL = localc;
    a(localc);
    d(RL);
    localc = new c();
    RM = localc;
    c(localc);
    e(RM);
    localc = new c();
    RN = localc;
    b(localc);
    e(RN);
    localc = new c();
    RO = localc;
    a(localc);
    e(RO);
  }
  
  c()
  {
    e(this.RP);
    e(this.RQ);
    this.RR[0] = 0.24F;
    this.RR[1] = 0.52F;
    this.RR[2] = 0.24F;
  }
  
  private static void a(c paramc)
  {
    paramc.RQ[1] = 0.26F;
    paramc.RQ[2] = 0.45F;
  }
  
  private static void b(c paramc)
  {
    paramc.RQ[0] = 0.3F;
    paramc.RQ[1] = 0.5F;
    paramc.RQ[2] = 0.7F;
  }
  
  private static void c(c paramc)
  {
    paramc.RQ[0] = 0.55F;
    paramc.RQ[1] = 0.74F;
  }
  
  private static void d(c paramc)
  {
    paramc.RP[0] = 0.35F;
    paramc.RP[1] = 1.0F;
  }
  
  private static void e(c paramc)
  {
    paramc.RP[1] = 0.3F;
    paramc.RP[2] = 0.4F;
  }
  
  private static void e(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.d.c
 * JD-Core Version:    0.7.0.1
 */