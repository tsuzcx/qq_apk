package midas.x;

import java.util.Comparator;
import java.util.TreeMap;

public class ft
{
  private static ft a;
  private int b;
  private TreeMap<String, String> c = new TreeMap(new a(null));
  private String d = "";
  
  public static ft a()
  {
    if (a == null) {
      a = new ft();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ft
 * JD-Core Version:    0.7.0.1
 */