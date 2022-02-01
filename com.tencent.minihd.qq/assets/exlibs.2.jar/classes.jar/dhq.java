import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dhq
  implements Runnable
{
  public dhq(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.a(this.a).b(2131367583);
        AuthDevVerifyCodeActivity.a(this.a).d(true);
      }
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (!AuthDevVerifyCodeActivity.a(this.a).isShowing())) {
        AuthDevVerifyCodeActivity.a(this.a).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhq
 * JD-Core Version:    0.7.0.1
 */