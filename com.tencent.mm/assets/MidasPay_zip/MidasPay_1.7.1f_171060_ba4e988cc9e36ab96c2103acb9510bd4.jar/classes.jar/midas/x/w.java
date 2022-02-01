package midas.x;

public class w
{
  private static volatile w a;
  private String b = "0";
  private String c = "";
  private String d = "";
  private String e = "";
  private x f = null;
  
  public static w a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new w();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(x paramx)
  {
    this.f = paramx;
  }
  
  public void b(String paramString)
  {
    this.c = paramString;
  }
  
  public void c()
  {
    this.b = "0";
    this.c = "";
    this.d = "";
    this.e = "";
    this.f = null;
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    this.e = paramString;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public String f()
  {
    return this.d;
  }
  
  public x g()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.w
 * JD-Core Version:    0.7.0.1
 */