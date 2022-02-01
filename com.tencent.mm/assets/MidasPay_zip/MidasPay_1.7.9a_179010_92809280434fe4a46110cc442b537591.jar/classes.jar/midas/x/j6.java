package midas.x;

import com.tencent.midas.comm.APLog;

public class j6
{
  public static j6 e;
  public String a = "";
  public String b = "";
  public String c = "";
  public boolean d;
  
  public static void d()
  {
    e = new j6();
  }
  
  public static j6 e()
  {
    if (e == null) {
      e = new j6();
    }
    return e;
  }
  
  public String a()
  {
    APLog.i("getDrm_act_type", this.b);
    return e.b;
  }
  
  public void a(String paramString)
  {
    APLog.i("setDrm_act_type", paramString);
    e.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    e.d = paramBoolean;
  }
  
  public String b()
  {
    APLog.i("getDrm_resource", this.c);
    return e.c;
  }
  
  public void b(String paramString)
  {
    APLog.i("setDrm_resource", paramString);
    e.c = paramString;
  }
  
  public String c()
  {
    return e.a;
  }
  
  public void c(String paramString)
  {
    e.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.j6
 * JD-Core Version:    0.7.0.1
 */