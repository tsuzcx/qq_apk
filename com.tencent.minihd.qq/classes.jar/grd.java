import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class grd
  extends ContactBindObserver
{
  public grd(PhoneMatchActivity paramPhoneMatchActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      this.a.app.unRegistObserver(this.a.a);
      this.a.a = null;
    }
    this.a.a();
    if (paramBoolean)
    {
      if (this.a.a != null)
      {
        this.a.app.unRegistObserver(this.a.a);
        this.a.a = null;
      }
      this.a.finish();
      return;
    }
    this.a.a("更新失败，请稍后重试。");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grd
 * JD-Core Version:    0.7.0.1
 */