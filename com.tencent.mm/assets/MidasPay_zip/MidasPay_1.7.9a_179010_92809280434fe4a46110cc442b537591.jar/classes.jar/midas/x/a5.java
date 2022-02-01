package midas.x;

import com.pay.tool.APTools;
import java.util.List;

public class a5
  extends w4
{
  public String a()
  {
    return a(p4.p().e().f.f);
  }
  
  public String a(String paramString)
  {
    b(paramString);
    String str = paramString;
    if (o.m().g(p4.p().e().f.e))
    {
      int i = APTools.p(paramString);
      List localList = o.m().b(p4.p().e().f.e);
      str = paramString;
      if (localList != null) {
        str = APTools.a(i - o.m().a(localList).a, 2);
      }
    }
    return str;
  }
  
  public String b(String paramString)
  {
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a5
 * JD-Core Version:    0.7.0.1
 */