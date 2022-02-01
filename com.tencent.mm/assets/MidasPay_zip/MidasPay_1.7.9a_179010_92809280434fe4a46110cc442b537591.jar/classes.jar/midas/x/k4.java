package midas.x;

import com.pay.tool.APAppDataInterface;

public class k4
  extends y1
{
  public k4()
  {
    this.o = 15000;
    this.p = 420000;
    this.h = 0;
    this.k = "GET";
    if (APAppDataInterface.singleton().D()) {
      localObject = "jspay.qq.com";
    } else {
      localObject = "sandbox.jspay.qq.com";
    }
    Object localObject = new za("https", (String)localObject);
    ((za)localObject).c = "";
    ((za)localObject).b = "443";
    a((za)localObject);
    G();
  }
  
  public boolean F()
  {
    return false;
  }
  
  public void G()
  {
    b("uuid", c6.s0().Z());
    b("uin", p4.p().d());
    a("Connection", "close");
    this.y = false;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k4
 * JD-Core Version:    0.7.0.1
 */