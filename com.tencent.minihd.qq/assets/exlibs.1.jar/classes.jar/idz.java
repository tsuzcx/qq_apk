import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class idz
  implements View.OnClickListener
{
  public idz(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void onClick(View paramView)
  {
    if (PublicDatingActivity.a(this.a, PublicDatingActivity.b(this.a)))
    {
      PublicDatingActivity.a(this.a).time = PublicDatingActivity.b(this.a);
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      PublicDatingActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idz
 * JD-Core Version:    0.7.0.1
 */