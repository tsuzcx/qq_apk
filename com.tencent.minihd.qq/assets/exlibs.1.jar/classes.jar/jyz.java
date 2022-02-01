import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class jyz
  implements Runnable
{
  public jyz(ShareAppLogActivity paramShareAppLogActivity) {}
  
  public void run()
  {
    try
    {
      if (ShareAppLogActivity.a(this.a) == null)
      {
        ShareAppLogActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        ShareAppLogActivity.a(this.a).b(2131367583);
      }
      ShareAppLogActivity.a(this.a).show();
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
 * Qualified Name:     jyz
 * JD-Core Version:    0.7.0.1
 */