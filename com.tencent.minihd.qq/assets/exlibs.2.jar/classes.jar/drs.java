import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;

public class drs
  extends ContactBindObserver
{
  public drs(Contacts paramContacts) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.app.unRegistObserver(this);
    if (!((PhoneContactManager)this.a.app.getManager(10)).e()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drs
 * JD-Core Version:    0.7.0.1
 */