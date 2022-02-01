import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DetailModel;
import java.util.List;

class iay
  implements Runnable
{
  iay(iav paramiav, boolean paramBoolean, DatingInfo paramDatingInfo, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null) && (this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.getDatingComment(true, 20);
        if (localObject != null)
        {
          this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(this.jdField_a_of_type_Int);
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.isReachOver(1, false);
          boolean bool1 = bool2;
          if (localObject != null)
          {
            bool1 = bool2;
            if (!((List)localObject).isEmpty())
            {
              bool1 = bool2;
              if (bool2) {
                bool1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.isReachCacheOver(1, ((List)localObject).get(((List)localObject).size() - 1), false);
              }
            }
          }
          if (this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.I == 1) {
            this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, true);
          }
          this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(4, 1, 3, true, bool1, (List)localObject, null, null);
          localObject = this.jdField_a_of_type_Iav.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(10, 1, 0);
          if (this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.I == 1) {
            break label236;
          }
          this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, true, true);
          this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, 0);
        }
      }
      return;
      label236:
      if (this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a() >= 1) {
        this.jdField_a_of_type_Iav.a.jdField_a_of_type_ComTencentMobileqqDatingDetailModel.a(1, 5, true);
      }
      this.jdField_a_of_type_Iav.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 0L);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Iav.a.a(2, "评论失败", 0);
      return;
    }
    this.jdField_a_of_type_Iav.a.a(2, this.jdField_a_of_type_JavaLangString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iay
 * JD-Core Version:    0.7.0.1
 */