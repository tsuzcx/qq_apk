import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.widgets.XChooserActivity;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class crm
  implements AsyncBack
{
  crm(crk paramcrk) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "download progress:" + paramInt);
    }
    this.a.jdField_a_of_type_Crp.jdField_a_of_type_Int = paramInt;
    this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(XChooserActivity.jdField_a_of_type_JavaLangString, 2, "download finish, code:" + paramInt);
    }
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_Crp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
      this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.jdField_a_of_type_JavaLangRunnable);
      this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.b = this.a.b;
      UniformDownloadUtil.a(this.a.jdField_a_of_type_Crp.b);
      return;
    }
    this.a.jdField_a_of_type_Crp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
    this.a.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.runOnUiThread(new crn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     crm
 * JD-Core Version:    0.7.0.1
 */