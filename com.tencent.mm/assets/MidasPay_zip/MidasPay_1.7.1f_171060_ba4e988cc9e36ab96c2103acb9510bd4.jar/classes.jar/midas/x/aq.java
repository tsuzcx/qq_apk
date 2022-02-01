package midas.x;

import java.util.ArrayList;

public class aq
{
  private static volatile aq a;
  private static boolean b = false;
  private ArrayList<ap> c;
  private ArrayList<ap> d;
  private ArrayList<as> e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private ArrayList<ap> i = new ArrayList();
  private ArrayList<ap> j;
  private ArrayList<ap> k = new ArrayList();
  private String l = "";
  private String m = "";
  private String n = "";
  private boolean o = false;
  private boolean p = false;
  
  public static aq a()
  {
    try
    {
      if (a == null) {
        try
        {
          if (a == null) {
            a = new aq();
          }
        }
        finally {}
      }
      aq localaq = a;
      return localaq;
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(ArrayList<ap> paramArrayList)
  {
    this.c = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public ArrayList<ap> b()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    this.m = paramString;
  }
  
  public void b(ArrayList<ap> paramArrayList)
  {
    this.d = paramArrayList;
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public ArrayList<ap> c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    this.n = paramString;
  }
  
  public void c(ArrayList<as> paramArrayList)
  {
    this.e = paramArrayList;
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void d(ArrayList<ap> paramArrayList)
  {
    this.i = paramArrayList;
  }
  
  public void d(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public void e(ArrayList<ap> paramArrayList)
  {
    this.j = paramArrayList;
  }
  
  public void e(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean e()
  {
    return this.p;
  }
  
  public void f(ArrayList<ap> paramArrayList)
  {
    this.k = paramArrayList;
  }
  
  public void f(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return b;
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public ArrayList<as> i()
  {
    return this.e;
  }
  
  public ArrayList<ap> j()
  {
    return this.i;
  }
  
  public ArrayList<ap> k()
  {
    return this.j;
  }
  
  public ArrayList<ap> l()
  {
    return this.k;
  }
  
  public String m()
  {
    return this.l;
  }
  
  public String n()
  {
    return this.m;
  }
  
  public String o()
  {
    return this.n;
  }
  
  public boolean p()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.aq
 * JD-Core Version:    0.7.0.1
 */