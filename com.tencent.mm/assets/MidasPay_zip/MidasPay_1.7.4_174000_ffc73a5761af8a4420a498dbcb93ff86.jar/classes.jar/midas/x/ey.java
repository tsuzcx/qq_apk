package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class ey
  extends et
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ey
 * JD-Core Version:    0.7.0.1
 */