package android.support.v7.d;

public final class c
{
  public static final c Sc;
  public static final c Sd;
  public static final c Se;
  public static final c Sf;
  public static final c Sg;
  public static final c Sh;
  public final float[] Si = new float[3];
  public final float[] Sj = new float[3];
  public final float[] Sk = new float[3];
  public boolean Sl = true;
  
  static
  {
    c localc = new c();
    Sc = localc;
    c(localc);
    d(Sc);
    localc = new c();
    Sd = localc;
    b(localc);
    d(Sd);
    localc = new c();
    Se = localc;
    a(localc);
    d(Se);
    localc = new c();
    Sf = localc;
    c(localc);
    e(Sf);
    localc = new c();
    Sg = localc;
    b(localc);
    e(Sg);
    localc = new c();
    Sh = localc;
    a(localc);
    e(Sh);
  }
  
  c()
  {
    e(this.Si);
    e(this.Sj);
    this.Sk[0] = 0.24F;
    this.Sk[1] = 0.52F;
    this.Sk[2] = 0.24F;
  }
  
  private static void a(c paramc)
  {
    paramc.Sj[1] = 0.26F;
    paramc.Sj[2] = 0.45F;
  }
  
  private static void b(c paramc)
  {
    paramc.Sj[0] = 0.3F;
    paramc.Sj[1] = 0.5F;
    paramc.Sj[2] = 0.7F;
  }
  
  private static void c(c paramc)
  {
    paramc.Sj[0] = 0.55F;
    paramc.Sj[1] = 0.74F;
  }
  
  private static void d(c paramc)
  {
    paramc.Si[0] = 0.35F;
    paramc.Si[1] = 1.0F;
  }
  
  private static void e(c paramc)
  {
    paramc.Si[1] = 0.3F;
    paramc.Si[2] = 0.4F;
  }
  
  private static void e(float[] paramArrayOfFloat)
  {
    paramArrayOfFloat[0] = 0.0F;
    paramArrayOfFloat[1] = 0.5F;
    paramArrayOfFloat[2] = 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.d.c
 * JD-Core Version:    0.7.0.1
 */