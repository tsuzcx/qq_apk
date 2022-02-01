package midas.x;

import com.tencent.midas.comm.APLog;
import java.math.BigDecimal;

public class f
{
  public static BigDecimal a(double paramDouble1, double paramDouble2)
  {
    BigDecimal localBigDecimal2 = new BigDecimal(paramDouble1);
    Object localObject = new BigDecimal(paramDouble2);
    BigDecimal localBigDecimal1 = new BigDecimal(0);
    try
    {
      localBigDecimal2 = localBigDecimal2.divide((BigDecimal)localObject, 2, 4);
      return localBigDecimal2;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("divide 1 exception:");
      ((StringBuilder)localObject).append(localException.toString());
      APLog.w("BigDecimal", ((StringBuilder)localObject).toString());
    }
    return localBigDecimal1;
  }
  
  public static BigDecimal a(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2)
  {
    BigDecimal localBigDecimal = new BigDecimal(0);
    try
    {
      paramBigDecimal1 = paramBigDecimal1.divide(paramBigDecimal2, 2, 4);
      return paramBigDecimal1;
    }
    catch (Exception paramBigDecimal1)
    {
      paramBigDecimal2 = new StringBuilder();
      paramBigDecimal2.append("divide 2 exception:");
      paramBigDecimal2.append(paramBigDecimal1.toString());
      APLog.w("BigDecimal", paramBigDecimal2.toString());
    }
    return localBigDecimal;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.f
 * JD-Core Version:    0.7.0.1
 */