import com.tencent.mobileqq.activity.OpenidToUinActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class eou
  implements Runnable
{
  public eou(OpenidToUinActivity paramOpenidToUinActivity) {}
  
  public void run()
  {
    if (OpenidToUinActivity.a(this.a) != null) {
      OpenidToUinActivity.a(this.a).dismiss();
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eou
 * JD-Core Version:    0.7.0.1
 */