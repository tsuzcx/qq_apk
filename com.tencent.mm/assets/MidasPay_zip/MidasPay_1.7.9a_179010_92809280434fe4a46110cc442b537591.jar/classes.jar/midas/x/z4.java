package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class z4
  extends w4
{
  public String k = "";
  public int l = 0;
  public String m = "";
  public String n = "1";
  
  public String a()
  {
    return a(p4.p().e().f.f);
  }
  
  public final String a(Object paramObject)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("0.00");
    return localDecimalFormat.format(paramObject);
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
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(paramString)))
    {
      BigDecimal localBigDecimal = new BigDecimal(this.c);
      return a(f.a(new BigDecimal(paramString).multiply(localBigDecimal), new BigDecimal(100.0D)));
    }
    return null;
  }
  
  public String h()
  {
    if ((p4.p().e().b.saveType == 4) && (g6.k().e() == g6.a.b)) {
      return "个月";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.z4
 * JD-Core Version:    0.7.0.1
 */