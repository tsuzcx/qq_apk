import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.widget.QQToast;

class crn
  implements Runnable
{
  crn(crm paramcrm) {}
  
  public void run()
  {
    if (!this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.isFinishing()) {
      QQToast.a(this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getApplicationContext(), 1, 2131364028, 1).b(this.a.a.jdField_a_of_type_Int);
    }
    this.a.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crn
 * JD-Core Version:    0.7.0.1
 */