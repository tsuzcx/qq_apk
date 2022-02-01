package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class ew
  extends et
{
  public String k = "";
  public int l = 0;
  public String m = "";
  public String n = "1";
  
  private String a(Object paramObject)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    localDecimalFormat.applyPattern("0.00");
    return localDecimalFormat.format(paramObject);
  }
  
  public String a()
  {
    return a(em.b().n().e.g);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    paramString = str;
    if (n.a().c(em.b().n().e.f))
    {
      int i = APTools.g(str);
      List localList = n.a().h(em.b().n().e.f);
      paramString = str;
      if (localList != null) {
        paramString = APTools.a(i - n.a().a(localList), 2);
      }
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(paramString)))
    {
      BigDecimal localBigDecimal = new BigDecimal(this.e);
      return a(f.a(new BigDecimal(paramString).multiply(localBigDecimal), new BigDecimal(100.0D)));
    }
    return null;
  }
  
  public String h()
  {
    String str2 = "";
    String str1 = str2;
    if (em.b().n().a.saveType == 4)
    {
      str1 = str2;
      if (gc.a().f() == gc.a.b) {
        str1 = "个月";
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ew
 * JD-Core Version:    0.7.0.1
 */