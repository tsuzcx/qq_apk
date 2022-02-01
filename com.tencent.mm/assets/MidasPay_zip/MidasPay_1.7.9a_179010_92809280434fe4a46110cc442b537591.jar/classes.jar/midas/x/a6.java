package midas.x;

import android.os.CountDownTimer;

public class a6
{
  public static volatile a6 b;
  public static CountDownTimer c;
  public long a = -1L;
  
  public static a6 b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new a6();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void c()
  {
    CountDownTimer localCountDownTimer = c;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      c = null;
    }
    b = null;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.a6
 * JD-Core Version:    0.7.0.1
 */