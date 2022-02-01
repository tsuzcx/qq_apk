import android.os.Handler;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class eai
  extends TroopObserver
{
  public eai(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.profilecard.FrdProfileCard", 2, "onGetExtShowTroopList");
    }
    if ((!paramBoolean) || (paramList == null) || (paramList.size() == 0) || (paramInt != 0)) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.removeBuisEntry(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
      }
    }
    do
    {
      return;
      paramList = (ShowExternalTroop)paramList.get(0);
      this.a.c = paramList.troopUin;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry = new ProfileBusiEntry();
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_Int = 1024;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.b = this.a.getString(2131363980);
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c = paramList.troopName;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.jdField_a_of_type_JavaLangString = paramList.strFaceUrl;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry.c == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.addOrUpdateBuisEntry(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileBusiEntry);
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
    ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.a.c, "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eai
 * JD-Core Version:    0.7.0.1
 */