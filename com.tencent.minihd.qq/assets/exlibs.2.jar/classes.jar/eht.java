import android.view.View;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class eht
  implements AdapterView.OnItemLongClickListener
{
  public eht(LoginActivity paramLoginActivity) {}
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((LoginActivity.a(this.a)) && (!LoginActivity.b(this.a)) && (!LoginActivity.c(this.a))) {
      paramView.findViewById(2131296576).setVisibility(0);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eht
 * JD-Core Version:    0.7.0.1
 */