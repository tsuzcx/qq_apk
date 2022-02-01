import com.tencent.mobileqq.activity.contact.addcontact.AddContactsView;
import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;

public class gfo
  implements ConditionSearchManager.IConfigListener
{
  public gfo(AddContactsView paramAddContactsView) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == 2) && (paramBoolean))
    {
      this.a.b = true;
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfo
 * JD-Core Version:    0.7.0.1
 */