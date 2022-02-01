package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.QZoneCoverView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileBaseView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  QZoneCoverView jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public ProfileBaseView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo, View paramView)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_b_of_type_AndroidViewView = paramView;
    b(paramProfileCardInfo);
  }
  
  private void b(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      if (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.jdField_a_of_type_Long = 0L;
        return;
      }
      paramProfileCardInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((paramProfileCardInfo == null) || (!paramProfileCardInfo.isPendantValid())) {
        break;
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      this.jdField_a_of_type_Long = paramProfileCardInfo.pendantId;
      paramProfileCardInfo = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        paramProfileCardInfo.a(this.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentImageURLImageView, 2, PendantInfo.i);
      }
      while (paramBoolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AvatarClick", "ppshow", 0, 0, "", "", "", "");
        return;
        paramProfileCardInfo.a(this.jdField_a_of_type_Long).a(this.jdField_a_of_type_ComTencentImageURLImageView, 1, PendantInfo.i);
      }
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, false);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo) {}
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.h(paramProfileCardInfo);
    super.g(paramProfileCardInfo);
    super.i(paramProfileCardInfo);
    b(paramProfileCardInfo, false);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null)) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.findViewById(2131300926).getLayoutParams();
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
          break;
        }
        i = getResources().getDimensionPixelSize(2131493037);
        if ((localObject != null) && (((RelativeLayout.LayoutParams)localObject).topMargin != i)) {
          ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, i, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
        }
        localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131300922);
      } while (localObject == null);
      ((View)localObject).setBackgroundResource(0);
      return;
      int i = getResources().getDimensionPixelSize(2131493035);
      if ((localObject != null) && (((RelativeLayout.LayoutParams)localObject).topMargin != i)) {
        ((RelativeLayout.LayoutParams)localObject).setMargins(((RelativeLayout.LayoutParams)localObject).leftMargin, i, ((RelativeLayout.LayoutParams)localObject).rightMargin, ((RelativeLayout.LayoutParams)localObject).bottomMargin);
      }
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131300922);
    } while (localObject == null);
    ((View)localObject).setBackgroundResource(0);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject2 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject2).inflate(2130904116, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView = ((QZoneCoverView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300921));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView;
    this.jdField_b_of_type_AndroidViewView = null;
    Object localObject1 = new DataTag(17, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setTag(localObject1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setVisibility(0);
    label149:
    Object localObject3;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localObject1 = ((Context)localObject2).getString(2131362015);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.setContentDescription((CharSequence)localObject1);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label613;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 0);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300925));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject3 = new DataTag(1, null);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(localObject3);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
        break label691;
      }
    }
    label691:
    for (localObject1 = ((Context)localObject2).getString(2131362011);; localObject1 = ((Context)localObject2).getString(2131362010))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_b_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297799));
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject3);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_ComTencentImageURLImageView);
      b(paramProfileCardInfo, true);
      b();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300928));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_a_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300930));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.jdField_b_of_type_AndroidWidgetTextView);
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300927));
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300932));
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.allowClick)) {
        break label703;
      }
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300929));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_login_day_icon", this.jdField_a_of_type_AndroidWidgetImageView);
      super.h(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300216));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300923));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      return;
      localObject1 = ((Context)localObject2).getString(2131362014);
      break;
      label613:
      if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        if (!paramProfileCardInfo.jdField_a_of_type_Boolean) {}
        for (int i = 1;; i = 3)
        {
          ((QZoneCoverView)localObject1).a((QQAppInterface)localObject3, str, i);
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQZoneCoverView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 2);
      break label149;
    }
    label703:
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300929));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300931));
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_login_day_text", this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put("map_key_login_day_layout", this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      if ("infoLogindaysShow=" + this.c != null) {
        break label857;
      }
      localObject1 = "null";
    }
    for (;;)
    {
      QLog.d((String)localObject2, 2, (String)localObject1);
      localObject1 = new DataTag(31, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localObject1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      break;
      label857:
      if ("nonull infoLogindaysLayout=" + this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        localObject1 = "null";
      } else {
        localObject1 = "nonull";
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileBaseView
 * JD-Core Version:    0.7.0.1
 */