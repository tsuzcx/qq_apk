package midas.x;

import android.os.CountDownTimer;

public class fw
{
  private static volatile fw a;
  private static CountDownTimer b;
  private long c = -1L;
  
  public static fw a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new fw();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fw
 * JD-Core Version:    0.7.0.1
 */