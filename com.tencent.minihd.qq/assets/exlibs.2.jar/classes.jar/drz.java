import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.app.CardObserver;

public class drz
  extends CardObserver
{
  private drz(Contacts paramContacts) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.a.a)) {
      this.a.a(1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drz
 * JD-Core Version:    0.7.0.1
 */