package midas.x;

import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;

abstract class bx
  extends br
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.bx
 * JD-Core Version:    0.7.0.1
 */