import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;

public class cfh
  implements Runnable
{
  public cfh(EnterpriseDetailActivity paramEnterpriseDetailActivity, EqqDetail paramEqqDetail) {}
  
  public void run()
  {
    EnterpriseDetailActivity.c(this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity, this.jdField_a_of_type_ComTencentMobileqqDataEqqDetail);
    this.jdField_a_of_type_ComTencentBizEqqEnterpriseDetailActivity.a.runOnUiThread(new cfi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cfh
 * JD-Core Version:    0.7.0.1
 */