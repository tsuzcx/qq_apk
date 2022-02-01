package midas.x;

import com.tencent.midas.comm.APLog;

public class fv
{
  private static fv a;
  private String b = "";
  private String c = "";
  private String d = "";
  private boolean e = false;
  
  public static void a()
  {
    a = new fv();
  }
  
  public static fv b()
  {
    if (a == null) {
      a = new fv();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fv
 * JD-Core Version:    0.7.0.1
 */