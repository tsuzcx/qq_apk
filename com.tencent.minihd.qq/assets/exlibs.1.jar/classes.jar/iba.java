import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DetailModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class iba
  implements Runnable
{
  iba(iav paramiav, boolean paramBoolean, DatingInfo paramDatingInfo, String paramString, int paramInt) {}
  
  public void run()
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo != null)) {
      this.jdField_a_of_type_Iav.a.a(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo, 2, 1, 0, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    do
    {
      List localList;
      boolean bool1;
      do
      {
        return;
        if ((this.jdField_a_of_type_Iav.a.a == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null) || (this.jdField_a_of_type_Int != 3)) {
          break;
        }
        localList = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.getDatingComment(true, 20);
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.isReachOver(1, false);
        bool1 = bool3;
        if (localList != null)
        {
          bool1 = bool3;
          if (!localList.isEmpty())
          {
            bool1 = bool3;
            if (bool3) {
              bool1 = this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.isReachCacheOver(1, localList.get(localList.size() - 1), false);
            }
          }
        }
        this.jdField_a_of_type_Iav.a.a.a(1, 1, this.jdField_a_of_type_Int, true, bool1, localList, null, null);
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("onGetDateComment not success fet_dir is new old list is empty :");
      if (localList != null)
      {
        bool1 = bool2;
        if (!localList.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      QLog.i("Q.dating.detail", 2, bool1);
      return;
    } while (this.jdField_a_of_type_Iav.a.a == null);
    this.jdField_a_of_type_Iav.a.a.a(3, 1, this.jdField_a_of_type_Int, false, false, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iba
 * JD-Core Version:    0.7.0.1
 */