import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQMapActivity;

public class ett
  implements View.OnClickListener
{
  public ett(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.l)
    {
      this.a.v();
      return;
    }
    if ("group_activity".equals(this.a.s))
    {
      this.a.f();
      return;
    }
    this.a.setResult(-1, this.a.a());
    this.a.finish();
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ett
 * JD-Core Version:    0.7.0.1
 */