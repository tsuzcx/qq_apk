package midas.x;

import java.util.ArrayList;

public class gc
{
  private static gc a;
  private String b = "0";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private a g = a.b;
  private ArrayList<String> h = null;
  private ArrayList<ArrayList<hl>> i = null;
  private boolean j = false;
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "";
  
  public static gc a()
  {
    if (a == null) {
      a = new gc();
    }
    return a;
  }
  
  public static void b()
  {
    a = null;
  }
  
  public void a(String paramString)
  {
    a.c = paramString;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.h = paramArrayList;
  }
  
  public void a(a parama)
  {
    this.g = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    a.j = paramBoolean;
  }
  
  public void b(String paramString)
  {
    a.b = paramString;
  }
  
  public void b(ArrayList<ArrayList<hl>> paramArrayList)
  {
    this.i = paramArrayList;
  }
  
  public String c()
  {
    return a.c;
  }
  
  public void c(String paramString)
  {
    a.f = paramString;
  }
  
  public String d()
  {
    return a.b;
  }
  
  public void d(String paramString)
  {
    a.l = paramString;
  }
  
  public String e()
  {
    return a.f;
  }
  
  public void e(String paramString)
  {
    a.m = paramString;
  }
  
  public a f()
  {
    return this.g;
  }
  
  public void f(String paramString)
  {
    a.n = paramString;
  }
  
  public boolean g()
  {
    return this.g == a.a;
  }
  
  public String h()
  {
    return a.k;
  }
  
  public boolean i()
  {
    return a.j;
  }
  
  public String j()
  {
    return a.m;
  }
  
  public String k()
  {
    return a.n;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gc
 * JD-Core Version:    0.7.0.1
 */