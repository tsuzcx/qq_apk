package midas.x;

import java.util.ArrayList;

public class go
{
  private static volatile go a;
  private String b = "";
  private ArrayList<String> c = new ArrayList();
  
  public static go a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new go();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(String paramString)
  {
    a.c.add(paramString);
  }
  
  public void b()
  {
    a.c.clear();
  }
  
  public void b(String paramString)
  {
    a.b = paramString;
  }
  
  public ArrayList<String> c()
  {
    return a.c;
  }
  
  public String d()
  {
    return a.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.go
 * JD-Core Version:    0.7.0.1
 */