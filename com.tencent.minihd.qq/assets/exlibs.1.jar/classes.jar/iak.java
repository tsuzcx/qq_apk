import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.dating.DatingDestinationActivity;

public class iak
  implements View.OnClickListener
{
  public iak(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void onClick(View paramView)
  {
    DatingDestinationActivity.a(this.a).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iak
 * JD-Core Version:    0.7.0.1
 */