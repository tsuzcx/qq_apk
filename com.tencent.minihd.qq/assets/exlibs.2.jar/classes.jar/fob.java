import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.widget.QQToast;

public class fob
  extends CardObserver
{
  public fob(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing())
    {
      if (!paramBoolean1) {
        break label96;
      }
      ActivateFriendActivity.a(this.a, paramBoolean2);
      if (!ActivateFriendActivity.a(this.a)) {
        break label83;
      }
    }
    label83:
    for (String str = this.a.getString(2131369441);; str = this.a.getString(2131369442))
    {
      str = this.a.getString(2131369444, new Object[] { str });
      QQToast.a(this.a, 2, str, 0).b(this.a.getTitleBarHeight());
      return;
    }
    label96:
    QQToast.a(this.a, 1, this.a.getResources().getString(2131368455), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fob
 * JD-Core Version:    0.7.0.1
 */