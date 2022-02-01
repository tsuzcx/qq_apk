import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.dating.PublicDatingActivity;
import com.tencent.mobileqq.dating.PublishDatingHelper;

public class iej
  implements IphonePickerView.IphonePickListener
{
  public iej(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void a()
  {
    if (PublicDatingActivity.d(this.a) != -1)
    {
      PublicDatingActivity.a(this.a).genderId = PublicDatingActivity.d(this.a);
      PublicDatingActivity.a(this.a).b(PublicDatingActivity.a(this.a));
      PublicDatingActivity.b(this.a, -1);
    }
    PublicDatingActivity.a(this.a).b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      PublicDatingActivity.b(this.a, 1);
      return;
    case 1: 
      PublicDatingActivity.b(this.a, 2);
      return;
    }
    PublicDatingActivity.b(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iej
 * JD-Core Version:    0.7.0.1
 */