import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.Switch;

public class dht
  implements CompoundButton.OnCheckedChangeListener
{
  public dht(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if ((this.a.app.d(true)) && (paramBoolean) && (AutoRemarkActivity.a(this.a) != null)) {
      AutoRemarkActivity.a(this.a).setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dht
 * JD-Core Version:    0.7.0.1
 */