package midas.x;

import java.util.ArrayList;

public class s6
{
  public static volatile s6 c;
  public String a = "";
  public ArrayList<String> b = new ArrayList();
  
  public static s6 d()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new s6();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a()
  {
    c.b.clear();
  }
  
  public void a(String paramString)
  {
    c.b.add(paramString);
  }
  
  public ArrayList<String> b()
  {
    return c.b;
  }
  
  public void b(String paramString)
  {
    c.a = paramString;
  }
  
  public String c()
  {
    return c.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.s6
 * JD-Core Version:    0.7.0.1
 */