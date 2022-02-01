package midas.x;

import com.pay.tool.APAppDataInterface;

public class dy
  extends br
{
  public dy()
  {
    this.n = 15000;
    this.o = 420000;
    this.k = 0;
    this.l = "GET";
    Object localObject = "sandbox.jspay.qq.com";
    if (APAppDataInterface.singleton().f()) {
      localObject = "jspay.qq.com";
    }
    localObject = new ji("https", (String)localObject);
    ((ji)localObject).c = "";
    ((ji)localObject).b = "443";
    a((ji)localObject);
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
    e("uuid", fp.a().i());
    e("uin", ed.b().e());
    b("Connection", "close");
    this.u = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.dy
 * JD-Core Version:    0.7.0.1
 */