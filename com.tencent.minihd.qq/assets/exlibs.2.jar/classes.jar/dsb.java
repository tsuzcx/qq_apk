import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.MessageObserver;

public class dsb
  extends MessageObserver
{
  private dsb(Contacts paramContacts) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    Contacts localContacts = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localContacts.e = bool;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.d();
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.b();
      }
      return;
    }
  }
  
  protected void b()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      this.a.a(1400L, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsb
 * JD-Core Version:    0.7.0.1
 */