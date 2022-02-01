import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.DataLineObserver;
import java.util.ArrayList;

public class drp
  extends DataLineObserver
{
  public drp(Contacts paramContacts) {}
  
  protected void a(ArrayList paramArrayList)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a.clear();
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterBuddyListAdapter.a = ((ArrayList)paramArrayList.clone());
    } while (!this.a.jdField_a_of_type_Boolean);
    this.a.a(1400L, true);
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drp
 * JD-Core Version:    0.7.0.1
 */