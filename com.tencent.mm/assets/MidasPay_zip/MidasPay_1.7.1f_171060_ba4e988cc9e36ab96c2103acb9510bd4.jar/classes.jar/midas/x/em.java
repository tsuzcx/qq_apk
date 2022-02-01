package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public class em
  extends ek
{
  public String k = "";
  public String l = "";
  public String m = "";
  
  public String a()
  {
    return a(ed.b().n().e.g);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    int i;
    if (n.a().c(ed.b().n().e.f))
    {
      i = APTools.g(str);
      List localList = n.a().h(ed.b().n().e.f);
      paramString = str;
      if (localList != null) {
        return APTools.a(i - n.a().a(localList), 2);
      }
    }
    else
    {
      paramString = str;
      if (o.a().b())
      {
        paramString = str;
        if (o.a().c())
        {
          paramString = str;
          if (o.a().o())
          {
            i = APTools.g(str);
            paramString = APTools.a(i - o.a().a(i), 2);
          }
        }
      }
    }
    return paramString;
  }
  
  public String b(String paramString)
  {
    Object localObject;
    if (!TextUtils.isEmpty(this.f)) {
      localObject = this.f;
    } else {
      localObject = this.e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.em
 * JD-Core Version:    0.7.0.1
 */