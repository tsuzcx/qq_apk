package midas.x;

import com.tencent.midas.comm.APLog;

public class gf
{
  private static gf a;
  private String b = "";
  private String c = "";
  private String d = "";
  private boolean e = false;
  
  public static void a()
  {
    a = new gf();
  }
  
  public static gf b()
  {
    if (a == null) {
      a = new gf();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    a.b = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    a.e = paramBoolean;
  }
  
  public void b(String paramString)
  {
    APLog.i("setDrm_act_type", paramString);
    a.c = paramString;
  }
  
  public String c()
  {
    return a.b;
  }
  
  public void c(String paramString)
  {
    APLog.i("setDrm_resource", paramString);
    a.d = paramString;
  }
  
  public String d()
  {
    APLog.i("getDrm_act_type", this.c);
    return a.c;
  }
  
  public String e()
  {
    APLog.i("getDrm_resource", this.d);
    return a.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gf
 * JD-Core Version:    0.7.0.1
 */