package midas.x;

public class ea
{
  public static u9.d a;
  
  public static void a(Runnable paramRunnable)
  {
    u9.d locald = a;
    if (locald != null) {
      locald.a(paramRunnable);
    }
  }
  
  public static void a(u9.d paramd)
  {
    a = paramd;
  }
  
  public static boolean a()
  {
    return a == null;
  }
  
  public static boolean b(Runnable paramRunnable)
  {
    u9.d locald = a;
    if (locald != null) {
      return locald.b(paramRunnable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ea
 * JD-Core Version:    0.7.0.1
 */