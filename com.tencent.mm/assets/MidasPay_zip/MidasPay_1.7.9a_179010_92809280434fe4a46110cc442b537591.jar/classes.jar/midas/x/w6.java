package midas.x;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.Calendar;

public abstract class w6
  implements View.OnClickListener
{
  public long a = 0L;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.w6
 * JD-Core Version:    0.7.0.1
 */