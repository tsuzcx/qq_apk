package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class w4
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public int e = 0;
  public int f;
  public String g = "";
  public int h = -1;
  public int i = -1;
  public String j = "";
  
  public abstract String a();
  
  public abstract String a(String paramString);
  
  public String a(String paramString1, String paramString2)
  {
    String str = a(paramString1);
    if ("0.01".equals(str)) {
      return "0.01";
    }
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = "100";
    }
    if ((!TextUtils.isEmpty(str)) && (!"100".equals(paramString1))) {
      try
      {
        paramString2 = new BigDecimal(NumberFormat.getInstance().parse(str).toString());
        paramString1 = new BigDecimal(paramString1);
        BigDecimal localBigDecimal = new BigDecimal(100.0D);
        paramString1 = paramString2.multiply(paramString1).divide(localBigDecimal).setScale(2, 3);
        paramString2 = new DecimalFormat();
        paramString2.applyPattern("0.##");
        paramString1 = paramString2.format(paramString1);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return str;
  }
  
  public void a(int paramInt) {}
  
  public int b()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return APTools.p(str);
    }
    return 0;
  }
  
  public abstract String b(String paramString);
  
  public void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public String c()
  {
    Object localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new BigDecimal(NumberFormat.getInstance().parse((String)localObject).toString());
        DecimalFormat localDecimalFormat = new DecimalFormat();
        localDecimalFormat.applyPattern("0.##");
        localObject = localDecimalFormat.format(localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return "0";
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void c(String paramString)
  {
    this.j = paramString;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public String d()
  {
    Object localObject = a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = APTools.q((String)localObject);
      DecimalFormat localDecimalFormat = new DecimalFormat();
      localDecimalFormat.applyPattern("0.##");
      return localDecimalFormat.format(localObject);
    }
    return "0";
  }
  
  public int e()
  {
    return this.h;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public String g()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w4
 * JD-Core Version:    0.7.0.1
 */