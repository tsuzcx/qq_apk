import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class fnq
  implements Runnable
{
  public fnq(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  public void run()
  {
    try
    {
      if ((VerifyPhoneNumActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        VerifyPhoneNumActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        VerifyPhoneNumActivity.a(this.a).b(2131367583);
      }
      if ((VerifyPhoneNumActivity.a(this.a) != null) && (!VerifyPhoneNumActivity.a(this.a).isShowing())) {
        VerifyPhoneNumActivity.a(this.a).show();
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
 * Qualified Name:     fnq
 * JD-Core Version:    0.7.0.1
 */