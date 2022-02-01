package midas.x;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

public abstract class gh
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.gh
 * JD-Core Version:    0.7.0.1
 */