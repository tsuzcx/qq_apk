import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.HashMap;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class ebi
  implements ActionSheet.OnButtonClickListener
{
  public ebi(FriendProfileCardActivity paramFriendProfileCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject = (SplashActivity)SplashActivity.a();
    if ((!((SplashActivity)localObject).permissionManager.checkPermission("android.permission.CAMERA")) || (!((SplashActivity)localObject).permissionManager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE"))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.CAMERA", 200), PermissionItem.init("android.permission.WRITE_EXTERNAL_STORAGE", 300) }).requests(new ebj(this, paramView, paramInt, (SplashActivity)localObject));
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[0] = 13;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[1] = 14;
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[2] = 16;
        paramInt = 3;
        while (paramInt < 5)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[paramInt] = -1;
          paramInt += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004174", "0X8004174", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, "", "", "", "");
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          localObject = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
          View localView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
          long l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
          if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) || (localView == null) || (localObject == null) || (localView.getVisibility() != 0) || (l == 0L)) {
            break label592;
          }
          ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a, l, 0);
        }
        for (;;)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004175", "0X8004175", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, "", "", "", "");
          break;
          label592:
          if (localObject != null) {
            paramView.postDelayed(new ebl(this, (View)localObject), 200L);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 5);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, "", "", "", "");
        continue;
        paramView = new Intent();
        paramInt = Math.min(482, ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity));
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        paramView.putExtra("Business_Origin", 100);
        PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, FriendProfileCardActivity.class.getName(), paramInt, paramInt, 640, 640, ProfileCardUtil.b());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004177", "0X8004177", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, "", "", "", "");
        continue;
        try
        {
          paramView = QZoneHelper.UserInfo.a();
          paramView.a = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.a();
          paramView.b = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.c();
          paramView.c = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getSid();
          QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a).longValue(), -1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.g), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
        }
        catch (Exception paramView) {}
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
          continue;
          if (!Utils.e())
          {
            Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131367289), 0).show();
          }
          else
          {
            AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoButtonClick", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ebi
 * JD-Core Version:    0.7.0.1
 */