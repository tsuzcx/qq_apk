import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class ggt
  implements Runnable
{
  public ggt(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void run()
  {
    SearchContactsFragment.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggt
 * JD-Core Version:    0.7.0.1
 */