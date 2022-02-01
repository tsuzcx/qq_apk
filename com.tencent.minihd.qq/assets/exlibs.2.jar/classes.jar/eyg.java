import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class eyg
  implements Runnable
{
  public eyg(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void run()
  {
    try
    {
      if ((RegisterQQNumberActivity.a(this.a) != null) && (RegisterQQNumberActivity.a(this.a).isShowing()))
      {
        RegisterQQNumberActivity.a(this.a).dismiss();
        RegisterQQNumberActivity.a(this.a).cancel();
      }
      RegisterQQNumberActivity.a(this.a, null);
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
 * Qualified Name:     eyg
 * JD-Core Version:    0.7.0.1
 */