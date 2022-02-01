package midas.x;

import android.os.CountDownTimer;

public class fn
{
  private static volatile fn a;
  private static CountDownTimer b;
  private long c = -1L;
  
  public static fn a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new fn();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void b()
  {
    if (b != null)
    {
      b.cancel();
      b = null;
    }
    a = null;
  }
  
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fn
 * JD-Core Version:    0.7.0.1
 */