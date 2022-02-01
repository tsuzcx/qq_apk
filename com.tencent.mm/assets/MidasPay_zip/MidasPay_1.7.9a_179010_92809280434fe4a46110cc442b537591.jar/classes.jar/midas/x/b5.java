package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class b5
  extends w4
{
  public String a()
  {
    return a(p4.p().e().f.f);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    paramString = str;
    if (o.m().g(p4.p().e().f.e))
    {
      int i = APTools.p(str);
      List localList = o.m().b(p4.p().e().f.e);
      paramString = str;
      if (localList != null) {
        paramString = APTools.a(i - o.m().a(localList).a, 2);
      }
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new BigDecimal(10.0D);
    paramString = f.a(new BigDecimal(paramString), (BigDecimal)localObject);
    localObject = new DecimalFormat();
    ((DecimalFormat)localObject).applyPattern("0.00");
    return ((DecimalFormat)localObject).format(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.b5
 * JD-Core Version:    0.7.0.1
 */