import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

public class fds
  implements View.OnClickListener
{
  public fds(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void onClick(View paramView)
  {
    SubAccountManager localSubAccountManager = (SubAccountManager)this.a.app.getManager(59);
    if ((localSubAccountManager != null) && (localSubAccountManager.a() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      SubAccountMessageActivity.a(this.a, bool, paramView, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fds
 * JD-Core Version:    0.7.0.1
 */