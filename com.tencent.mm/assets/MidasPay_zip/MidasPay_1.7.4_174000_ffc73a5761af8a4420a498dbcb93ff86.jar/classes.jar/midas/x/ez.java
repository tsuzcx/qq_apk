package midas.x;

import com.tencent.midas.comm.APLog;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ez
  implements Cloneable
{
  public String a = "";
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public int g = 0;
  public int h = 0;
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  
  public String a()
  {
    Object localObject1 = f.a(this.g, 10.0D);
    Object localObject2 = new DecimalFormat();
    ((DecimalFormat)localObject2).applyPattern("0.#");
    try
    {
      ((BigDecimal)localObject1).toString();
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fQD exception:");
      localStringBuilder.append(localException2.toString());
      APLog.w("APUserInfo", localStringBuilder.toString());
    }
    try
    {
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sQD exception:");
      ((StringBuilder)localObject2).append(localException1.toString());
      APLog.w("APUserInfo", ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  public String b()
  {
    Object localObject1 = f.a(this.g, 100.0D);
    Object localObject2 = new DecimalFormat();
    ((DecimalFormat)localObject2).applyPattern("0.##");
    try
    {
      ((BigDecimal)localObject1).toString();
    }
    catch (Exception localException2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fQB exception:");
      localStringBuilder.append(localException2.toString());
      APLog.w("APUserInfo", localStringBuilder.toString());
    }
    try
    {
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sQB exception:");
      ((StringBuilder)localObject2).append(localException1.toString());
      APLog.w("APUserInfo", ((StringBuilder)localObject2).toString());
    }
    return "";
  }
  
  public String c()
  {
    Object localObject1 = f.a(this.h, 100.0D);
    Object localObject2 = new DecimalFormat();
    try
    {
      ((DecimalFormat)localObject2).applyPattern("0.00");
      localObject1 = ((DecimalFormat)localObject2).format(localObject1);
      return localObject1;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getUserMcardBalance exception:");
      ((StringBuilder)localObject2).append(localException.toString());
      APLog.w("APUserInfo", ((StringBuilder)localObject2).toString());
    }
    return "";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.ez
 * JD-Core Version:    0.7.0.1
 */