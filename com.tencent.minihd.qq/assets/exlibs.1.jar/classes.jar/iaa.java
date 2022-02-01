import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.TextView;
import com.tencent.mobileqq.dating.DatingDestinationActivity;

public class iaa
  implements View.OnKeyListener
{
  public iaa(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((66 == paramInt) && (paramKeyEvent.getAction() == 0))
    {
      paramView = ((TextView)paramView).getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        DatingDestinationActivity.a(this.a, paramView, DatingDestinationActivity.a(this.a));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iaa
 * JD-Core Version:    0.7.0.1
 */