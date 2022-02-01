import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.dating.DatingBaseActivity;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.PublicDatingActivity;

public class ieh
  implements Runnable
{
  public ieh(PublicDatingActivity paramPublicDatingActivity) {}
  
  public void run()
  {
    DatingHandler localDatingHandler = (DatingHandler)this.a.app.a(40);
    if (PublicDatingActivity.a(this.a).themeId == 5)
    {
      localDatingHandler.b(PublicDatingActivity.a(this.a), 1);
      DatingBaseActivity.a(this.a.app, "0X800493E", PublicDatingActivity.a(this.a).introKey, PublicDatingActivity.a(this.a).getVehicleKey(), PublicDatingActivity.a(this.a).getPartCountKey(), "");
    }
    for (;;)
    {
      if (PublicDatingActivity.a(this.a).equals("guide")) {
        this.a.b("0X8005012");
      }
      return;
      localDatingHandler.a(PublicDatingActivity.a(this.a), 1);
      DatingBaseActivity.a(this.a.app, "0X800493E", PublicDatingActivity.a(this.a).introKey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ieh
 * JD-Core Version:    0.7.0.1
 */