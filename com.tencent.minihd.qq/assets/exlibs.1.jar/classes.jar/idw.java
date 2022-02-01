import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class idw
  implements IphonePickerView.IphonePickListener
{
  public idw(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void a()
  {
    if (PublicDatingActivity.f(this.a) != -1)
    {
      PublicDatingActivity.a(this.a).partCountId = PublicDatingActivity.f(this.a);
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      PublicDatingActivity.d(this.a, -1);
    }
    PublicDatingActivity.a(this.a).b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    PublicDatingActivity.d(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idw
 * JD-Core Version:    0.7.0.1
 */