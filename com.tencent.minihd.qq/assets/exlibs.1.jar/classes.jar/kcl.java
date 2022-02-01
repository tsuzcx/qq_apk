import android.widget.ImageButton;
import com.tencent.mobileqq.troop.activity.AbsReplyActivity;

public class kcl
  implements Runnable
{
  public kcl(AbsReplyActivity paramAbsReplyActivity) {}
  
  public void run()
  {
    AbsReplyActivity.a(this.a, 3);
    this.a.b.setImageResource(2130841083);
    this.a.b.setContentDescription(this.a.getString(2131363926));
    this.a.a.setImageResource(2130841082);
    this.a.a.setContentDescription(this.a.getString(2131363925));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcl
 * JD-Core Version:    0.7.0.1
 */