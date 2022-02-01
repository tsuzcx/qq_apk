package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.tool.APTools;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.List<Lmidas.x.gv;>;

public class eu
  extends et
{
  private String a(List<gv> paramList)
  {
    Object localObject1 = "";
    String str = em.b().n().e.g;
    boolean bool = TextUtils.isEmpty(str);
    int j = 0;
    if (!bool) {
      i = i.a(str);
    }
    int k;
    for (int i = 0; j < paramList.size(); i = k)
    {
      gv localgv = (gv)paramList.get(j);
      Object localObject2 = localObject1;
      k = i;
      if (i >= localgv.a)
      {
        k = i / localgv.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(localgv.b);
        localObject2 = ((StringBuilder)localObject2).toString();
        k = i % localgv.a;
      }
      j += 1;
      localObject1 = localObject2;
    }
    paramList = (List<gv>)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramList = str;
    }
    return paramList;
  }
  
  public String a()
  {
    return a(em.b().n().e.g);
  }
  
  public String a(String paramString)
  {
    String str = b(paramString);
    paramString = str;
    int i;
    if (n.a().c(em.b().n().e.f))
    {
      i = APTools.g(str);
      List localList = n.a().h(em.b().n().e.f);
      paramString = str;
      if (localList != null) {
        paramString = APTools.a(i - n.a().a(localList), 2);
      }
    }
    str = paramString;
    if (o.a().b())
    {
      str = paramString;
      if (o.a().c())
      {
        str = paramString;
        if (o.a().o())
        {
          i = APTools.g(paramString);
          str = APTools.a(i - o.a().a(i), 2);
        }
      }
    }
    return str;
  }
  
  public String b(String paramString)
  {
    if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      Object localObject = new BigDecimal(this.e);
      paramString = f.a(new BigDecimal(paramString), (BigDecimal)localObject);
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).applyPattern("0.00");
      paramString = ((DecimalFormat)localObject).format(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      label67:
      break label67;
    }
    return "0";
    return null;
  }
  
  public String b(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      paramString2 = new BigDecimal(paramString2);
      paramString1 = f.a(new BigDecimal(paramString1), paramString2);
      paramString2 = new DecimalFormat();
      paramString2.applyPattern("0.00");
      paramString2 = paramString2.format(paramString1);
      paramString1 = paramString2;
      if (o.a().b())
      {
        paramString1 = paramString2;
        if (o.a().c())
        {
          paramString1 = paramString2;
          if (o.a().o())
          {
            int i = APTools.g(paramString2);
            paramString1 = APTools.a(i - o.a().a(i), 2);
          }
        }
      }
      return paramString1;
    }
    return null;
  }
  
  public String h()
  {
    if (APUICommonMethod.h())
    {
      Object localObject1 = em.b().n().a.extendInfo.unit.split("=");
      if (localObject1.length < 2) {
        return em.b().n().a.extendInfo.unit;
      }
      Object localObject2 = localObject1[1].split("\\|");
      localObject1 = new ArrayList();
      int i = 0;
      while (i < localObject2.length)
      {
        try
        {
          if (localObject2[i].split(":").length == 2)
          {
            String str2 = localObject2[i].split(":")[0];
            String str1 = localObject2[i].split(":")[1];
            int j;
            try
            {
              j = Integer.parseInt(str2);
            }
            catch (Exception localException2)
            {
              APLog.w("unitArray rate", localException2.toString());
              j = 0;
            }
            if (j > 0)
            {
              gv localgv = new gv();
              localgv.a = j;
              localgv.b = str1;
              ((List)localObject1).add(localgv);
            }
          }
        }
        catch (Exception localException1)
        {
          label177:
          break label177;
        }
        i += 1;
      }
      Collections.sort((List)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(a((List)localObject1));
      return ((StringBuilder)localObject2).toString();
    }
    else
    {
      return em.b().n().a.extendInfo.unit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.eu
 * JD-Core Version:    0.7.0.1
 */