import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dhk
  implements Runnable
{
  public dhk(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.a) != null) && (AuthDevRenameActivity.a(this.a).isShowing()))
      {
        AuthDevRenameActivity.a(this.a).dismiss();
        AuthDevRenameActivity.a(this.a).cancel();
      }
      AuthDevRenameActivity.a(this.a, null);
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
 * Qualified Name:     dhk
 * JD-Core Version:    0.7.0.1
 */