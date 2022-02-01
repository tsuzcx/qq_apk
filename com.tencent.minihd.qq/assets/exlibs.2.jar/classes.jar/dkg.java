import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class dkg
  implements View.OnClickListener
{
  public dkg(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c < 0)
    {
      QQToast.a(this.a, 1, this.a.getString(2131368766), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      QQToast.a(this.a, 2131365730, 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (this.a.a == null)
    {
      QQToast.a(this.a, 2131368772, 0).b(this.a.getTitleBarHeight());
      return;
    }
    BookShareAdviceEditActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkg
 * JD-Core Version:    0.7.0.1
 */