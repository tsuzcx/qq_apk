import android.view.View;
import com.tencent.mobileqq.profile.ProfileCardWebviewPlugin;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class jms
  implements ActionSheet.OnButtonClickListener
{
  public jms(ProfileCardWebviewPlugin paramProfileCardWebviewPlugin) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ProfileCardWebviewPlugin.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jms
 * JD-Core Version:    0.7.0.1
 */