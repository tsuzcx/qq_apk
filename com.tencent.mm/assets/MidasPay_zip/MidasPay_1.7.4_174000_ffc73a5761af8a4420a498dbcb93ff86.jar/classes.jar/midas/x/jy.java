package midas.x;

public class jy
{
  private static jo.c a;
  
  public static void a(jo.c paramc)
  {
    a = paramc;
  }
  
  public static boolean a()
  {
    return a == null;
  }
  
  public static boolean a(Runnable paramRunnable)
  {
    if (a != null) {
      return a.a(paramRunnable);
    }
    return false;
  }
  
  public static void b(Runnable paramRunnable)
  {
    if (a != null) {
      a.b(paramRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jy
 * JD-Core Version:    0.7.0.1
 */