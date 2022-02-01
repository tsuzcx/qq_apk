import com.tencent.mobileqq.activity.phone.SettingActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

class grk
  extends ContactBindObserver
{
  grk(grj paramgrj) {}
  
  protected void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
    this.a.a.a();
    this.a.a.app.unRegistObserver(this);
    if (paramBoolean)
    {
      this.a.a.setResult(-1);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     grk
 * JD-Core Version:    0.7.0.1
 */