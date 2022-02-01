import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.PicInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;

public class jid
  implements ActionSheet.OnButtonClickListener
{
  public jid(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a();
        return;
        paramView = new ArrayList();
        paramInt = 0;
        while (paramInt < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.size() - 1)
        {
          localObject = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a.get(paramInt);
          if (!StringUtil.b(((NearbyPeopleProfileActivity.PicInfo)localObject).a)) {
            paramView.add(((NearbyPeopleProfileActivity.PicInfo)localObject).a);
          }
          paramInt += 1;
        }
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoListActivity.class);
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
        paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
        paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
        paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        paramView.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
        paramView.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
        localObject = AppConstants.aG + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a() + "/" + "nearby_people_photo/";
        paramView.putExtra("PhotoConst.TARGET_PATH", (String)localObject + System.currentTimeMillis() + ".jpg");
        paramView.putExtra("PhotoConst.CLIP_WIDTH", 640);
        paramView.putExtra("PhotoConst.CLIP_HEIGHT", 640);
        paramView.putExtra("PhotoConst.TARGET_WIDTH", 640);
        paramView.putExtra("PhotoConst.TARGET_HEIGHT", 640);
        paramView.putExtra("is_change_head", this.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramView);
        AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, false, true);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 1, 0, "", "", "", "");
      }
    }
    paramView = QZoneHelper.UserInfo.a();
    paramView.a = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a();
    paramView.b = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.c();
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("key_title", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getString(2131365485));
    ((Bundle)localObject).putInt("key_personal_album_enter_model", 2);
    ((Bundle)localObject).putBoolean("show_album", false);
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 8;; paramInt = 5)
    {
      QZoneHelper.a(localNearbyPeopleProfileActivity, paramView, (Bundle)localObject, paramInt);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481F", "0X800481F", 2, 0, "", "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jid
 * JD-Core Version:    0.7.0.1
 */