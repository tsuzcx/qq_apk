import android.os.Handler;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class iaw
  implements Runnable
{
  iaw(iav paramiav, boolean paramBoolean, DatingInfo paramDatingInfo, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    if (this.jdField_a_of_type_Iav.a.b)
    {
      this.jdField_a_of_type_Iav.a.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_Iav.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 800L);
      PullRefreshHeader localPullRefreshHeader = this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
      if (this.jdField_a_of_type_Boolean) {
        localPullRefreshHeader.a(i);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null))
      {
        this.jdField_a_of_type_Iav.a.g = true;
        this.jdField_a_of_type_Iav.a.w = this.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_Iav.a.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, 2);
      return;
      i = 2;
      break;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Iav.a.a(2, this.jdField_a_of_type_Iav.a.getString(2131369809), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iaw
 * JD-Core Version:    0.7.0.1
 */