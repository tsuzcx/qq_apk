package midas.x;

import java.util.Comparator;
import java.util.TreeMap;

public class gd
{
  private static gd a;
  private int b;
  private TreeMap<String, String> c = new TreeMap(new a(null));
  private String d = "";
  
  public static gd a()
  {
    if (a == null) {
      a = new gd();
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public TreeMap<String, String> b()
  {
    return this.c;
  }
  
  class a
    implements Comparator<String>
  {
    private a() {}
    
    public int a(String paramString1, String paramString2)
    {
      return Integer.valueOf(paramString1).compareTo(Integer.valueOf(paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gd
 * JD-Core Version:    0.7.0.1
 */