package android.support.v7.d;

public final class c
{
  public static final c YM;
  public static final c YN;
  public static final c YO;
  public static final c YP;
  public static final c YQ;
  public static final c YR;
  final float[] YS = new float[3];
  final float[] YT = new float[3];
  final float[] YU = new float[3];
  boolean YV = true;
  
  static
  {
    c localc = new c();
    YM = localc;
    c(localc);
    d(YM);
    localc = new c();
    YN = localc;
    b(localc);
    d(YN);
    localc = new c();
    YO = localc;
    a(localc);
    d(YO);
    localc = new c();
    YP = localc;
    c(localc);
    e(YP);
    localc = new c();
    YQ = localc;
    b(localc);
    e(YQ);
    localc = new c();
    YR = localc;
    a(localc);
    e(YR);
  }
  
  c()
  {
    f(this.YS);
    f(this.YT);
    this.YU[0] = 0.24F;
    this.YU[1] = 0.52F;
    this.YU[2] = 0.24F;
  }
  
  private static void a(c paramc)
  {
    paramc.YT[1] = 0.26F;
    paramc.YT[2] = 0.45F;
  }
  
  private static void b(c paramc)
  {
    paramc.YT[0] = 0.3F;
    paramc.YT[1] = 0.5F;
    paramc.YT[2] = 0.7F;
  }
  
  private static void c(c paramc)
  {
    paramc.YT[0] = 0.55F;
    paramc.YT[1] = 0.74F;
  }
  
  private static void d(c paramc)
  {
    paramc.YS[0] = 0.35F;
    paramc.YS[1] = 1.0F;
  }
  
  private static void e(c paramc)
  {
    paramc.YS[1] = 0.3F;
    paramc.YS[2] = 0.4F;
  }
  
  private static void f(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.d.c
 * JD-Core Version:    0.7.0.1
 */