import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;

public class elu
  implements View.OnClickListener
{
  public elu(NearbyActivity paramNearbyActivity) {}
  
  public void onClick(View paramView)
  {
    NearbyActivity.b(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     elu
 * JD-Core Version:    0.7.0.1
 */