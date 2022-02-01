import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class iek
  implements IphonePickerView.IphonePickListener
{
  public iek(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void a()
  {
    if (PublicDatingActivity.e(this.a) != -1)
    {
      PublicDatingActivity.a(this.a).payTypeId = PublicDatingActivity.e(this.a);
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      PublicDatingActivity.c(this.a, -1);
    }
    PublicDatingActivity.a(this.a).b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    PublicDatingActivity.c(this.a, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iek
 * JD-Core Version:    0.7.0.1
 */