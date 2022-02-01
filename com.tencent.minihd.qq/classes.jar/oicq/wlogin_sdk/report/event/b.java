package oicq.wlogin_sdk.report.event;

import java.util.HashMap;

public class b
{
  private String a;
  private String b;
  private String c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private String g;
  private final HashMap<String, String> h = new HashMap();
  
  public b(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public b a(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public b a(String paramString1, String paramString2)
  {
    this.h.put(paramString1, paramString2);
    return this;
  }
  
  public b a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public b b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public HashMap<String, String> c()
  {
    return this.h;
  }
  
  public b c(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.d;
  }
  
  public boolean f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.event.b
 * JD-Core Version:    0.7.0.1
 */