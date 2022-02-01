import com.dataline.activities.PrinterSubOptionActivity;
import com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import java.util.List;

public class co
  extends DataLineObserver
{
  public co(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  protected void b()
  {
    this.a.jdField_a_of_type_JavaLangString = this.a.getString(2131362205);
    this.a.jdField_a_of_type_JavaUtilList.clear();
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList != null) {
      this.a.jdField_a_of_type_JavaUtilList.addAll(this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_JavaUtilList);
    }
    this.a.jdField_a_of_type_Boolean = this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.jdField_a_of_type_Boolean;
    this.a.jdField_a_of_type_ComDatalineActivitiesPrinterSubOptionActivity$PrinterItemAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     co
 * JD-Core Version:    0.7.0.1
 */