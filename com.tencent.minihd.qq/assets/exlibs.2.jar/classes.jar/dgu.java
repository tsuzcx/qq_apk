import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dgu
  implements Runnable
{
  public dgu(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        AuthDevActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
      }
      if ((AuthDevActivity.a(this.a) != null) && (!AuthDevActivity.a(this.a).isShowing())) {
        AuthDevActivity.a(this.a).show();
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
 * Qualified Name:     dgu
 * JD-Core Version:    0.7.0.1
 */