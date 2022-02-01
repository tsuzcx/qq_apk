package midas.x;

import java.util.Comparator;
import java.util.TreeMap;

public class h6
{
  public static h6 b;
  public TreeMap<String, String> a = new TreeMap(new b(null));
  
  public static h6 b()
  {
    if (b == null) {
      b = new h6();
    }
    return b;
  }
  
  public TreeMap<String, String> a()
  {
    return this.a;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public class b
    implements Comparator<String>
  {
    public b() {}
    
    public int a(String paramString1, String paramString2)
    {
      return Integer.valueOf(paramString1).compareTo(Integer.valueOf(paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.h6
 * JD-Core Version:    0.7.0.1
 */