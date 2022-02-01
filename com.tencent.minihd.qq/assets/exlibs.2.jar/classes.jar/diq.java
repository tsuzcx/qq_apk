import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;

public class diq
  implements Runnable
{
  public diq(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (this.a.f != null) {
      this.a.f.setVisibility(8);
    }
    if (BaseChatPie.a(this.a) != null) {
      BaseChatPie.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     diq
 * JD-Core Version:    0.7.0.1
 */