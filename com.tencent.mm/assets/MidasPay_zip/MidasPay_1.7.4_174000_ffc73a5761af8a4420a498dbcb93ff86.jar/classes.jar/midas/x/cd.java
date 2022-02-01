package midas.x;

import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

abstract class cd
  extends bx
{
  public void b()
  {
    f("app_pkg_name", APAppDataInterface.singleton().B());
    f("app_sign", APAppDataInterface.singleton().C());
    f("mobile", APTools.h(a.a().b()));
    f("operator", APTools.g(a.a().b()));
    f("mccmnc", APTools.f(a.a().b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.cd
 * JD-Core Version:    0.7.0.1
 */