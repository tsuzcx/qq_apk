import com.tencent.biz.widgets.XChooserActivity;

public class crq
  implements Runnable
{
  cro jdField_a_of_type_Cro;
  
  public crq(XChooserActivity paramXChooserActivity, cro paramcro)
  {
    this.jdField_a_of_type_Cro = paramcro;
  }
  
  public void run()
  {
    if ((!this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.isFinishing()) && (this.jdField_a_of_type_Cro.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_Cro.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a(this.jdField_a_of_type_Cro.jdField_a_of_type_AndroidContentPmResolveInfo);
      this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crq
 * JD-Core Version:    0.7.0.1
 */