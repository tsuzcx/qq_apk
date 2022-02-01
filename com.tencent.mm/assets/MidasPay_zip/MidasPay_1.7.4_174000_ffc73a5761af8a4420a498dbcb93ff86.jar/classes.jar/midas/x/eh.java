package midas.x;

import com.pay.tool.APAppDataInterface;

public class eh
  extends bx
{
  public eh()
  {
    this.n = 15000;
    this.o = 420000;
    this.k = 0;
    this.l = "GET";
    Object localObject = "sandbox.jspay.qq.com";
    if (APAppDataInterface.singleton().f()) {
      localObject = "jspay.qq.com";
    }
    localObject = new kt("https", (String)localObject);
    ((kt)localObject).c = "";
    ((kt)localObject).b = "443";
    a((kt)localObject);
    c();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void c()
  {
    e("uuid", fy.a().i());
    e("uin", em.b().e());
    b("Connection", "close");
    this.u = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.eh
 * JD-Core Version:    0.7.0.1
 */