package midas.x;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

public abstract class gs
  implements View.OnClickListener
{
  private long a = 0L;
  
  public abstract void a(View paramView);
  
  public void onClick(View paramView)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if (l - this.a > 1000L)
    {
      this.a = l;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gs
 * JD-Core Version:    0.7.0.1
 */