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

public class x4
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
    int i;
    if (o.m().g(p4.p().e().f.e))
    {
      i = APTools.p(str);
      List localList = o.m().b(p4.p().e().f.e);
      paramString = str;
      if (localList != null) {
        paramString = APTools.a(i - o.m().a(localList).a, 2);
      }
    }
    str = paramString;
    if (p.o().h())
    {
      str = paramString;
      if (p.o().f())
      {
        str = paramString;
        if (p.o().j())
        {
          i = APTools.p(paramString);
          str = APTools.a(i - p.o().b(i), 2);
        }
      }
    }
    return str;
  }
  
  public final String a(List<z6> paramList)
  {
    String str = p4.p().e().f.f;
    boolean bool = TextUtils.isEmpty(str);
    int j = 0;
    int i;
    if (!bool) {
      i = i.b(str);
    } else {
      i = 0;
    }
    Object localObject2;
    for (Object localObject1 = ""; j < paramList.size(); localObject1 = localObject2)
    {
      z6 localz6 = (z6)paramList.get(j);
      int m = localz6.a;
      int k = i;
      localObject2 = localObject1;
      if (i >= m)
      {
        k = i / m;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(k);
        ((StringBuilder)localObject2).append(localz6.b);
        localObject2 = ((StringBuilder)localObject2).toString();
        k = i % localz6.a;
      }
      j += 1;
      i = k;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return str;
    }
    return localObject1;
  }
  
  public String b(String paramString)
  {
    if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      Object localObject = new BigDecimal(this.c);
      paramString = f.a(new BigDecimal(paramString), (BigDecimal)localObject);
      localObject = new DecimalFormat();
      ((DecimalFormat)localObject).applyPattern("0.00");
      paramString = ((DecimalFormat)localObject).format(paramString);
      return paramString;
    }
    finally
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
      if (p.o().h())
      {
        paramString1 = paramString2;
        if (p.o().f())
        {
          paramString1 = paramString2;
          if (p.o().j())
          {
            int i = APTools.p(paramString2);
            paramString1 = APTools.a(i - p.o().b(i), 2);
          }
        }
      }
      return paramString1;
    }
    return null;
  }
  
  public String h()
  {
    if (APUICommonMethod.e())
    {
      Object localObject1 = p4.p().e().b.extendInfo.unit.split("=");
      if (localObject1.length < 2) {
        return p4.p().e().b.extendInfo.unit;
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
              z6 localz6 = new z6();
              localz6.a = j;
              localz6.b = str1;
              ((List)localObject1).add(localz6);
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
      return p4.p().e().b.extendInfo.unit;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.x4
 * JD-Core Version:    0.7.0.1
 */