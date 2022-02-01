package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class y4
  extends w4
{
  public String k = "";
  public String l = "";
  
  public String a()
  {
    return a(p4.p().e().f.f);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    int i;
    if (o.m().g(p4.p().e().f.e))
    {
      i = APTools.p(str);
      List localList = o.m().b(p4.p().e().f.e);
      paramString = str;
      if (localList != null) {
        return APTools.a(i - o.m().a(localList).a, 2);
      }
    }
    else
    {
      paramString = str;
      if (p.o().h())
      {
        paramString = str;
        if (p.o().f())
        {
          paramString = str;
          if (p.o().j())
          {
            i = APTools.p(str);
            paramString = APTools.a(i - p.o().b(i), 2);
          }
        }
      }
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.d)) {
      localObject = this.d;
    } else {
      localObject = this.c;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = new BigDecimal((String)localObject);
      paramString = f.a(new BigDecimal(paramString).multiply((BigDecimal)localObject), new BigDecimal(100.0D));
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).applyPattern("0.00");
      return ((DecimalFormat)localObject).format(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.y4
 * JD-Core Version:    0.7.0.1
 */