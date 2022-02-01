package midas.x;

public class hn
{
  private static hn a;
  private String[] b;
  private String[] c;
  private String[] d;
  private String[] e;
  
  public static hn a()
  {
    if (a == null) {
      a = new hn();
    }
    return a;
  }
  
  private void b(String[] paramArrayOfString)
  {
    this.b = paramArrayOfString;
  }
  
  private void c(String[] paramArrayOfString)
  {
    this.c = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      try
      {
        int j = i.a(paramArrayOfString[i]);
        j = i.a(em.b().n().b.a(String.valueOf(j)));
        this.c[i] = String.valueOf(j);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    b(paramArrayOfString);
    c(paramArrayOfString);
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    this.b = paramArrayOfString1;
    this.c = paramArrayOfString2;
    this.d = paramArrayOfString3;
    this.e = paramArrayOfString4;
  }
  
  public String[] b()
  {
    if (a.b == null) {
      a.b = new String[0];
    }
    return a.b;
  }
  
  public String[] c()
  {
    if (a.c == null) {
      a.c = new String[0];
    }
    return a.c;
  }
  
  public String[] d()
  {
    if (a.d == null) {
      a.d = new String[0];
    }
    return a.d;
  }
  
  public String[] e()
  {
    if (a.e == null) {
      a.e = new String[0];
    }
    return a.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hn
 * JD-Core Version:    0.7.0.1
 */