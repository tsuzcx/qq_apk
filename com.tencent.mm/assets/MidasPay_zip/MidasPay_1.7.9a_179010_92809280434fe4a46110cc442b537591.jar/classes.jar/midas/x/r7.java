package midas.x;

public class r7
{
  public static r7 e;
  public String[] a;
  public String[] b;
  public String[] c;
  public String[] d;
  
  public static r7 e()
  {
    if (e == null) {
      e = new r7();
    }
    return e;
  }
  
  public final void a(String[] paramArrayOfString)
  {
    this.b = new String[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      try
      {
        int j = i.b(paramArrayOfString[i]);
        j = i.b(p4.p().e().c.a(String.valueOf(j)));
        this.b[i] = String.valueOf(j);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, String[] paramArrayOfString4)
  {
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.c = paramArrayOfString3;
    this.d = paramArrayOfString4;
  }
  
  public String[] a()
  {
    r7 localr7 = e;
    if (localr7.b == null) {
      localr7.b = new String[0];
    }
    return e.b;
  }
  
  public final void b(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public String[] b()
  {
    r7 localr7 = e;
    if (localr7.d == null) {
      localr7.d = new String[0];
    }
    return e.d;
  }
  
  public void c(String[] paramArrayOfString)
  {
    b(paramArrayOfString);
    a(paramArrayOfString);
  }
  
  public String[] c()
  {
    r7 localr7 = e;
    if (localr7.a == null) {
      localr7.a = new String[0];
    }
    return e.a;
  }
  
  public String[] d()
  {
    r7 localr7 = e;
    if (localr7.c == null) {
      localr7.c = new String[0];
    }
    return e.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r7
 * JD-Core Version:    0.7.0.1
 */