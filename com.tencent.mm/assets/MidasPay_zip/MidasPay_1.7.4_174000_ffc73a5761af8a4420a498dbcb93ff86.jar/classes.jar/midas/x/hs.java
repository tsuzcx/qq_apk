package midas.x;

import android.app.Activity;
import com.pay.ui.common.APUICommonMethod;

public class hs
{
  public static a a;
  
  public static void a()
  {
    if (a != null)
    {
      a.b_();
      APUICommonMethod.c((Activity)a);
      a = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void b_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.hs
 * JD-Core Version:    0.7.0.1
 */