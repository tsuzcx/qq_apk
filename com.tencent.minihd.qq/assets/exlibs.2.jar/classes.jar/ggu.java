import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class ggu
  implements Runnable
{
  public ggu(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void run()
  {
    if (SearchContactsFragment.a(this.a) != null) {
      SearchContactsFragment.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggu
 * JD-Core Version:    0.7.0.1
 */