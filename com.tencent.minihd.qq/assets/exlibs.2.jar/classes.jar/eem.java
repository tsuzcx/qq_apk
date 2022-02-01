import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class eem
  implements View.OnClickListener
{
  public eem(HotChatListActivity paramHotChatListActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.a(2131369502);
      this.a.app.a(new een(this));
      if ((HotChatListActivity.a(this.a) != null) && (HotChatListActivity.a(this.a).isShowing())) {
        HotChatListActivity.a(this.a).dismiss();
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004413", "0X8004413", 1, 0, "", "", "", "");
    }
    do
    {
      return;
      QQToast.a(this.a.a, this.a.getString(2131369501), 0).b(this.a.getTitleBarHeight());
    } while ((HotChatListActivity.a(this.a) == null) || (!HotChatListActivity.a(this.a).isShowing()));
    HotChatListActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eem
 * JD-Core Version:    0.7.0.1
 */