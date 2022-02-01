package midas.x;

import java.util.ArrayList;

public class ge
{
  private static volatile ge a;
  private String b = "";
  private ArrayList<String> c = new ArrayList();
  
  public static ge a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ge();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ge
 * JD-Core Version:    0.7.0.1
 */