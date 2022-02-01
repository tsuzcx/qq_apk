import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;

public class etm
  implements PopupWindow.OnDismissListener
{
  public etm(QQMapActivity paramQQMapActivity) {}
  
  public void onDismiss()
  {
    if (this.a.q != null)
    {
      QQMapActivity.a(this.a);
      this.a.C = 0;
      this.a.a.a(this.a.getString(2131364034));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     etm
 * JD-Core Version:    0.7.0.1
 */