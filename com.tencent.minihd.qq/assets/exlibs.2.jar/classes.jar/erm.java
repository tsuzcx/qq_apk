import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class erm
  implements View.OnClickListener
{
  public erm(QQBrowserActivity paramQQBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    QQBrowserActivity.b(this.a).setVisibility(8);
    this.a.b.setVisibility(8);
    this.a.a(QQBrowserActivity.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erm
 * JD-Core Version:    0.7.0.1
 */