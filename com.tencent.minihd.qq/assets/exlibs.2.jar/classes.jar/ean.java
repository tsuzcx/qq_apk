import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DetailProfileActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.IconPopupWindow;
import com.tencent.qav.activity.QavChatActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.permission.PermissionItem;
import mqq.app.permission.PermissionManager;

public class ean
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b = 0L;
  
  public ean(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    label4:
    long l;
    label305:
    do
    {
      do
      {
        return;
      } while (!(paramView.getTag() instanceof DataTag));
      localObject1 = (DataTag)paramView.getTag();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onClickListener and DataTag type=" + ((DataTag)localObject1).J);
      }
      l = System.currentTimeMillis();
      if (Math.abs(l - this.b) < 1000L) {
        break;
      }
      this.b = l;
      if ((!FriendProfileCardActivity.a(this.a)) && (FriendProfileCardActivity.a(this.a, ((DataTag)localObject1).J))) {
        break;
      }
      switch (((DataTag)localObject1).J)
      {
      case 11: 
      case 12: 
      case 15: 
      case 25: 
      default: 
        return;
      case 1: 
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1216;
        }
        if (!ProfileCardUtil.a()) {
          break label1111;
        }
        this.a.a(2131367097, 1);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
        {
          paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
          l = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
          if ((ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (paramView != null) && (paramView.getVisibility() == 0) && (l != 0L)) {
            ReportController.b(this.a.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoHeadClick", 0, 0, "", "", "", "");
          }
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004173", "0X8004173", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
      }
    } while ((!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null));
    label410:
    int i = 1;
    paramView = "0";
    Object localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a();
    int j;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((CoverCacheData)localObject1).type))) {
      if (((CoverCacheData)localObject1).type.equals("PhotoWallCover")) {
        if (((CoverCacheData)localObject1).photoWall != null)
        {
          j = ((CoverCacheData)localObject1).photoWall.size();
          if (j != 0)
          {
            i = 3;
            paramView = "3";
          }
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        label568:
        Object localObject2;
        String str1;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          localObject2 = this.a;
          str1 = this.a.app.a();
          String str2 = this.a.app.getSid();
          if (paramView.equals("1"))
          {
            localObject1 = "oldCustom=1";
            label627:
            ProfileCardUtil.a((Activity)localObject2, str1, "inside.defaultStyle", str2, 1, 0, i, (String)localObject1, true);
            ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004DBF", "0X8004DBF", 0, 0, "", "", paramView, VipUtils.a(this.a.app, this.a.app.a()));
            label691:
            localObject1 = this.a.app;
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
              break label1104;
            }
          }
        }
        label1104:
        for (paramView = "pro_self";; paramView = "pro_other")
        {
          ReportController.b((QQAppInterface)localObject1, "CliOper", "", "", "photo_wall", paramView, ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          j = 0;
          break;
          if (((CoverCacheData)localObject1).type.equals("StaticCover"))
          {
            paramView = "2";
            i = 1;
            break label568;
          }
          if (!((CoverCacheData)localObject1).type.equals("CustomCover")) {
            break label5917;
          }
          paramView = "1";
          i = 1;
          break label568;
          localObject1 = "";
          break label627;
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004DC0", "0X8004DC0", 0, 0, "", "", paramView, VipUtils.a(this.a.app, this.a.app.a()));
          if ((localObject1 != null) && ((paramView.equals("3")) || (paramView.equals("1")) || (paramView.equals("0"))))
          {
            if (paramView.equals("0"))
            {
              localObject1 = "otherDefault=1";
              localObject2 = this.a.b();
              paramView = (View)localObject1;
              if (localObject2 != null)
              {
                paramView = (View)localObject1;
                if (((String)localObject2).equals("CustomCover")) {
                  paramView = "otherDefault=1" + "&oldCustom=1";
                }
              }
              ProfileCardUtil.a(this.a, this.a.app.a(), "inside.defaultStyle", this.a.app.getSid(), 1, 1, 1, paramView, false);
              break label691;
            }
            paramView = QZoneHelper.UserInfo.a();
            paramView.jdField_a_of_type_JavaLangString = this.a.app.a();
            paramView.b = this.a.app.c();
            paramView.jdField_c_of_type_JavaLangString = this.a.app.getSid();
            QZoneHelper.b(this.a, paramView, (CoverCacheData)localObject1, 1008);
            break label691;
          }
          ProfileCardUtil.a(this.a, this.a.app.a(), "inside.defaultStyle", this.a.app.getSid(), 1, 1, 1);
          break label691;
        }
        label1111:
        if (this.a.jdField_a_of_type_ArrayOfInt == null) {
          this.a.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.a.jdField_a_of_type_ArrayOfInt[0] = 11;
        this.a.jdField_a_of_type_ArrayOfInt[1] = 12;
        this.a.jdField_a_of_type_ArrayOfInt[2] = 17;
        this.a.jdField_a_of_type_ArrayOfInt[3] = 16;
        i = 4;
        while (i < 5)
        {
          this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
          i += 1;
        }
        this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
        break label305;
        label1216:
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33) {
          break;
        }
        if (!ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          paramView = this.a.a();
          if ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
            break label410;
          }
          localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
          if (localObject1 == null) {
            break label410;
          }
          ProfileCardUtil.a(this.a, (View)localObject1, paramView);
          break label410;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
          break label410;
        }
        paramView = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
        localObject1 = (View)this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
        l = this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) && (localObject1 != null) && (paramView != null) && (((View)localObject1).getVisibility() == 0) && (l != 0L))
        {
          i = 0;
          if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 1) {
            i = 1;
          }
          for (;;)
          {
            ReportController.b(this.a.app, "CliOper", "", "", "AvatarClick", "KerenInfoHeadClick", i, 0, "", "", "", "");
            ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, l, i);
            break;
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 20) {
              i = 2;
            } else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 21) {
              i = 3;
            } else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 45) {
              i = 4;
            } else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 46) {
              i = 5;
            } else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
              i = 6;
            } else if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 42) {
              i = 7;
            }
          }
        }
        if (paramView == null) {
          break label410;
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")))
        {
          ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.p);
          break label410;
        }
        ProfileCardUtil.a(this.a, paramView, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
        break label410;
        this.a.e();
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo = ((ProfileActivity.CardContactInfo)((DataTag)localObject1).a);
        if (this.a.jdField_a_of_type_ArrayOfInt == null) {
          this.a.jdField_a_of_type_ArrayOfInt = new int[5];
        }
        this.a.jdField_a_of_type_ArrayOfInt[0] = 7;
        this.a.jdField_a_of_type_ArrayOfInt[1] = 8;
        if (ProfileActivity.AllInOne.b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
        {
          this.a.jdField_a_of_type_ArrayOfInt[2] = 9;
          this.a.jdField_a_of_type_ArrayOfInt[3] = 16;
        }
        for (;;)
        {
          i = 4;
          while (i < 5)
          {
            this.a.jdField_a_of_type_ArrayOfInt[i] = -1;
            i += 1;
          }
          this.a.jdField_a_of_type_ArrayOfInt[2] = 16;
          this.a.jdField_a_of_type_ArrayOfInt[3] = -1;
        }
        this.a.a(this.a.jdField_a_of_type_ArrayOfInt);
        return;
        this.a.f();
        return;
        this.a.j();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Prof_new_photo", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        this.a.k();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_qzone", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        this.a.h();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_add_frd", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j), "", "");
        return;
        this.a.i();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_send_msg", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.j), "", "");
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break;
        }
        paramView = new Intent(this.a.getActivity(), DetailProfileActivity.class);
        this.a.startActivityForResult(paramView, 1007);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g == 8)
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004178", "0X8004178", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        if (FriendProfileCardActivity.a(this.a) != null)
        {
          this.a.app.a().getSharedPreferences(this.a.app.a(), 0).edit().putBoolean("svip_profile_show_newer_guide_flag", true).commit();
          FriendProfileCardActivity.a(this.a).setVisibility(8);
          FriendProfileCardActivity.a(this.a, null);
        }
        paramView = paramView.findViewById(2131300446);
        i = 1;
        if (paramView != null) {
          if (paramView.getVisibility() != 0) {
            break label2621;
          }
        }
        label2621:
        for (i = 0;; i = 1)
        {
          paramView.setVisibility(8);
          FriendProfileCardActivity.a(this.a);
          ProfileCardUtil.a(this.a, this.a.app.a(), "inside.myCardButton", this.a.app.getSid(), i, 0, 1, "", true);
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_PERSOMCARD", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", VipUtils.a(this.a.app, this.a.app.a()));
          return;
        }
        j = ((Integer)((DataTag)localObject1).a).intValue();
        if ((j == 101107) || (j == 101108))
        {
          if (j != 101108) {
            break label2742;
          }
          i = 5;
          if (j != 101108) {
            break label2747;
          }
          VipUtils.b(this.a, 3, ProfileCardUtil.a(i));
        }
        for (;;)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "SummaryCard", "CLICK_TOPBARVIPINVALID", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          label2742:
          i = 2;
          break;
          label2747:
          VipUtils.a(this.a, 3, ProfileCardUtil.a(i));
        }
        if ((((DataTag)localObject1).a instanceof Card))
        {
          this.a.a((Card)((DataTag)localObject1).a);
          return;
        }
        this.a.a(null);
        return;
        this.a.g();
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pp_clk_myQR", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        FriendProfileCardActivity.b(this.a);
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA3", "0X8004FA3", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA5", "0X8004FA5", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
        return;
        paramView = new Intent(this.a, ProfileCardMoreActivity.class);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList != null) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.size() > 0)) {
          paramView.putExtra("SHARE_NICK_NAME", ((MQQName)this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
        }
        paramView.putExtra("AllInOne", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
        paramView.addFlags(536870912);
        this.a.startActivityForResult(paramView, 1012);
        return;
        this.a.d();
        ReportController.b(this.a.app, "CliOper", "", "", "QQ_rank", "click_qrank_in", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        return;
        l = System.currentTimeMillis();
        if (!ProfileActivity.a(this.a.jdField_c_of_type_Long, l)) {
          break;
        }
        this.a.jdField_c_of_type_Long = l;
        ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.app, this.a);
        ReportController.b(this.a.app, "CliOper", "", "", "P_prof", "Pro_account_info", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
        if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
        {
          ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA3", "0X8004FA3", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
          return;
        }
        ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA5", "0X8004FA5", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
        return;
        if ((((DataTag)localObject1).a instanceof ProfileBusiEntry))
        {
          paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
          localObject1 = new Intent(this.a, QQBrowserActivity.class);
          ((Intent)localObject1).putExtra("portraitOnly", true);
          ((Intent)localObject1).putExtra("url", paramView.d);
        }
        try
        {
          this.a.startActivity((Intent)localObject1);
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004184", "0X8004184", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          boolean bool;
          if ((((DataTag)localObject1).a instanceof Object[]))
          {
            paramView = (Object[])((DataTag)localObject1).a;
            bool = ((Boolean)paramView[0]).booleanValue();
            paramView = (String)paramView[1];
            this.a.a(bool, paramView);
          }
          ReportController.b(this.a.app, "CliOper", "", "", "0X8004183", "0X8004183 ", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
          return;
          if ((((DataTag)localObject1).a instanceof String))
          {
            paramView = (String)((DataTag)localObject1).a;
            if ((TextUtils.isEmpty(paramView)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
            {
              paramView = new Intent(this.a, EditActivity.class);
              paramView.putExtra("k_source", 4);
              this.a.startActivity(paramView);
              ReportController.b(this.a.app, "CliOper", "", "", "signiture", "pp_enter_set", 0, 0, "", "", "", "");
              return;
            }
            StatusHistoryActivity.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString, 1, "");
            ReportController.b(this.a.app, "CliOper", "", "", "signiture", "pp_enter", 0, 0, "", "", "", "");
            return;
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "free call click");
            }
            ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Clk_freecall", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            i = ProfileCardUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
            if (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
            {
              localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
              localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
              paramView = (View)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.i;
              }
              str1 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[1];
              localObject2 = str1;
              if (TextUtils.isEmpty(str1)) {
                localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.m;
              }
              if ((i != 0) || (TextUtils.isEmpty(paramView))) {
                break label4308;
              }
              label4037:
              if (i != 1000) {
                break label4490;
              }
              paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d;
              label4058:
              switch (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int)
              {
              default: 
                paramView = "4";
              }
            }
            for (;;)
            {
              ReportController.b(this.a.app, "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, paramView, "", "", "");
              paramView = (SplashActivity)SplashActivity.a();
              if ((paramView.permissionManager.checkPermission("android.permission.RECORD_AUDIO")) && (paramView.permissionManager.checkPermission("android.permission.CAMERA"))) {
                break label4542;
              }
              paramView.permissionManager.permissions(new PermissionItem[] { PermissionItem.init("android.permission.RECORD_AUDIO", 600), PermissionItem.init("android.permission.CAMERA", 600) }).requests(new eao(this, (String)localObject1, paramView));
              return;
              this.a.a();
              localObject1 = null;
              break;
              label4308:
              if (((i == 1000) || (i == 1020)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                break label4037;
              }
              if (i == 1021)
              {
                if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName == null)) {
                  break label5907;
                }
                paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQName.jdField_a_of_type_JavaLangString;
                if ((!TextUtils.isEmpty(paramView)) || (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[2]))) {
                  break label4037;
                }
                paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
                break label4037;
              }
              paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
              if (ProfileActivity.AllInOne.h(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
                paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[3];
              }
              if (!TextUtils.isEmpty(paramView)) {
                break label4037;
              }
              paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h;
              break label4037;
              label4490:
              if (i != 1004) {
                break label4058;
              }
              paramView = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e;
              break label4058;
              paramView = "4";
              continue;
              paramView = "5";
              continue;
              paramView = "6";
              continue;
              paramView = "7";
            }
            label4542:
            paramView = new Intent(this.a, QavChatActivity.class);
            paramView.addFlags(262144);
            paramView.putExtra("key_peer_uin", (String)localObject1);
            paramView.putExtra("key_only_audio", false);
            this.a.startActivity(paramView);
            return;
            paramView = new Intent(this.a, QQBrowserActivity.class);
            paramView.putExtra("url", "https://web.p.qq.com/qqmpmobile/profilevipcard/index.html?uin=" + this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            paramView.putExtra("hide_operation_bar", true);
            paramView.putExtra("hide_more_button", true);
            this.a.startActivity(paramView);
            ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
            {
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA4", "0X8004FA4", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
              return;
            }
            ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA6", "0X8004FA6", 0, 0, Long.toString(FriendProfileCardActivity.a(this.a)), "", "", "");
            return;
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              break;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            this.a.a(paramView.d);
            return;
            if ((((DataTag)localObject1).a instanceof ProfileBusiEntry))
            {
              paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
              localObject2 = new Intent(this.a, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", paramView.d);
              ((Intent)localObject2).putExtra("hide_operation_bar", true);
              ((Intent)localObject2).putExtra("hide_more_button", true);
              this.a.startActivity((Intent)localObject2);
            }
            if (28 != ((DataTag)localObject1).J) {
              break;
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X8004181", "0X8004181", ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.g), 0, Integer.toString(ProfileActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
            return;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
              break;
            }
            paramView = this.a.app.a();
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramView))
            {
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004435", "0X8004435", 0, 0, "", "", "", VipUtils.a(this.a.app, this.a.app.a()));
              ProfileCardUtil.a(this.a, this.a.app.a(), "inside.myCardBackground", this.a.app.getSid(), 1, 0, 1, "", true);
              return;
            }
            paramView = "CLICK_HEADER_BG";
            if ((((DataTag)localObject1).a instanceof String)) {
              paramView = (String)((DataTag)localObject1).a;
            }
            ReportController.b(this.a.app, "P_CliOper", paramView, "", "0X80047F0", "0X80047F0", 0, 0, "", "", "", VipUtils.a(this.a.app, this.a.app.a()));
            if ((FriendProfileCardActivity.a(this.a) != null) && (FriendProfileCardActivity.a(this.a).a())) {
              break;
            }
            localObject1 = this.a.app.getPreferences().getString("profile_card_other_head_click_text", this.a.getString(2131369616));
            if (FriendProfileCardActivity.a(this.a) == null)
            {
              FriendProfileCardActivity.a(this.a, new IconPopupWindow(this.a));
              FriendProfileCardActivity.a(this.a).a(2131369615, new eaq(this));
              FriendProfileCardActivity.a(this.a).a((String)localObject1, new ear(this, paramView));
            }
            FriendProfileCardActivity.a(this.a).a(FriendProfileCardActivity.a(this.a), 4);
            return;
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              break;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            paramView = new Intent(this.a, ShowExternalTroopListActivity.class);
            if ((FriendProfileCardActivity.a(this.a) != null) && (!TextUtils.isEmpty(FriendProfileCardActivity.a(this.a).getText()))) {
              paramView.putExtra("leftViewText", FriendProfileCardActivity.a(this.a).getText().toString().trim());
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
            for (bool = true;; bool = false)
            {
              paramView.putExtra("isHost", bool);
              paramView.putExtra("dest_uin_str", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
              this.a.startActivity(paramView);
              if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
                break;
              }
              ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.a.jdField_c_of_type_JavaLangString, "1", "", "");
              return;
            }
            ReportController.b(this.a.app, "P_CliOper", "Grp_join", "", "person_data", "Clk", 0, 0, this.a.jdField_c_of_type_JavaLangString, "0", "", "");
            return;
            ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X80047EE", "0X80047EE", 0, 0, "", "", "", "");
            paramView = new Intent(this.a, ProfileLabelEditorActivity.class);
            paramView.putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
            try
            {
              this.a.startActivityForResult(paramView, 1004);
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            if (!(((DataTag)localObject1).a instanceof ProfileBusiEntry)) {
              break;
            }
            paramView = (ProfileBusiEntry)((DataTag)localObject1).a;
            localObject1 = new Intent(this.a, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.d + "&_webviewtype=1");
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.a.startActivity((Intent)localObject1);
            return;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
              break;
            }
            if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA7", "0X8004FA7", 0, 0, "", "", "", "");
            }
            for (;;)
            {
              ProfileCardUtil.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId);
              return;
              ReportController.b(this.a.app, "P_CliOper", "Vip_SummaryCard", "", "0X8004FA8", "0X8004FA8", 0, 0, "", "", "", "");
            }
          }
        }
        catch (SecurityException paramView)
        {
          for (;;)
          {
            continue;
            label5907:
            paramView = null;
            continue;
            paramView = null;
          }
        }
      }
      label5917:
      paramView = "0";
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ean
 * JD-Core Version:    0.7.0.1
 */