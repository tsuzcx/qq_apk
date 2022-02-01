package midas.x;

import com.pay.tool.APTools;
import java.util.List;

public class eo
  extends ek
{
  public String a()
  {
    return a(ed.b().n().e.g);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    paramString = str;
    if (n.a().c(ed.b().n().e.f))
    {
      int i = APTools.g(str);
      List localList = n.a().h(ed.b().n().e.f);
      paramString = str;
      if (localList != null) {
        paramString = APTools.a(i - n.a().a(localList), 2);
      }
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.eo
 * JD-Core Version:    0.7.0.1
 */