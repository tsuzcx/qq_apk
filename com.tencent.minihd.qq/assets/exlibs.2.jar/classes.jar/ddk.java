import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class ddk
  implements Runnable
{
  public ddk(AccountManageActivity paramAccountManageActivity) {}
  
  public void run()
  {
    if ((AccountManageActivity.a(this.a) != null) && (AccountManageActivity.a(this.a).isShowing())) {
      AccountManageActivity.b(this.a);
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ddk
 * JD-Core Version:    0.7.0.1
 */