import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.activities.LiteVideoActivity;
import com.tencent.mobileqq.utils.NetworkUtil;

public class ch
  implements View.OnClickListener
{
  public ch(LiteVideoActivity paramLiteVideoActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a) && (NetworkUtil.f(this.a)) && (!NetworkUtil.g(this.a)) && (LiteVideoActivity.a(this.a) > LiteVideoActivity.a()))
    {
      LiteVideoActivity.a(this.a);
      return;
    }
    LiteVideoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ch
 * JD-Core Version:    0.7.0.1
 */