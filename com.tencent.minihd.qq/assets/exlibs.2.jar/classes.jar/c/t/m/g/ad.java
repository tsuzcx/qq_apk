package c.t.m.g;

public final class ad
  extends bb
{
  private static ai g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public ai f = null;
  
  public final void a(az paramaz)
  {
    this.a = paramaz.a(this.a, 0, false);
    this.b = paramaz.a(this.b, 1, false);
    this.c = paramaz.a(this.c, 2, false);
    this.d = paramaz.a(this.d, 3, false);
    this.e = paramaz.a(this.e, 4, false);
    if (g == null) {
      g = new ai();
    }
    this.f = ((ai)paramaz.a(g, 5, false));
  }
  
  public final void a(ba paramba)
  {
    paramba.a(this.a, 0);
    paramba.a(this.b, 1);
    paramba.a(this.c, 2);
    paramba.a(this.d, 3);
    paramba.a(this.e, 4);
    if (this.f != null) {
      paramba.a(this.f, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.ad
 * JD-Core Version:    0.7.0.1
 */