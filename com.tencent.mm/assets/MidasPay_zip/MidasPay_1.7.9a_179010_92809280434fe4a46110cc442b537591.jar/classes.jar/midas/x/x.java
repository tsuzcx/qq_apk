package midas.x;

public class x
{
  public static volatile x e;
  public String a = "0";
  public String b = "";
  public String c = "";
  public y d = null;
  
  public static x f()
  {
    if (e == null) {
      try
      {
        if (e == null) {
          e = new x();
        }
      }
      finally {}
    }
    return e;
  }
  
  public static void g()
  {
    e = null;
  }
  
  public void a()
  {
    this.a = "0";
    this.b = "";
    this.c = "";
    this.d = null;
  }
  
  public void a(String paramString) {}
  
  public void a(y paramy)
  {
    this.d = paramy;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public y c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public void d(String paramString)
  {
    this.a = paramString;
  }
  
  public String e()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x
 * JD-Core Version:    0.7.0.1
 */