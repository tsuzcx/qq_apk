import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class idx
  implements IphonePickerView.IphonePickListener
{
  public idx(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void a()
  {
    if (PublicDatingActivity.g(this.a) != -1)
    {
      PublicDatingActivity.a(this.a).vehicleId = PublicDatingActivity.g(this.a);
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      PublicDatingActivity.e(this.a, -1);
    }
    PublicDatingActivity.a(this.a).b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      PublicDatingActivity.e(this.a, 7);
      return;
    }
    PublicDatingActivity.e(this.a, paramInt2 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idx
 * JD-Core Version:    0.7.0.1
 */