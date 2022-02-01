import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class jza
  implements Runnable
{
  public jza(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void run()
  {
    try
    {
      if ((ShareAppLogActivity.a(this.a) != null) && (ShareAppLogActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
      {
        ShareAppLogActivity.a(this.a).dismiss();
        ShareAppLogActivity.a(this.a).cancel();
      }
      ShareAppLogActivity.a(this.a, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jza
 * JD-Core Version:    0.7.0.1
 */