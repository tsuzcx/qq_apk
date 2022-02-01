package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class ProfilePhotoView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  public URLImageView a;
  public QzonePhotoView a;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float e;
  private float f;
  private float g;
  
  public ProfilePhotoView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    a(paramProfileCardInfo);
    b(paramProfileCardInfo);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a.size();
    }
    return super.a();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) {
      super.n(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("photoNickNameColor", "color");
    localHashMap.put("photoAddressColor", "color");
    localHashMap.put("photoAddSrc", "drawable");
    localHashMap.put("photoMore", "drawable");
    localHashMap.put("photoAddTipsImage", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.i(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.j(paramProfileCardInfo);
    super.n(paramProfileCardInfo);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130904123, this, true);
    Object localObject2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300947);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131493018);
    int j = getResources().getDimensionPixelSize(2131493031);
    this.e = (this.jdField_b_of_type_Float - (i + j * 3));
    this.d = (70.0F * this.jdField_a_of_type_Float);
    this.g = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300925));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300937));
    ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    localObject2 = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject1 = ((Context)localObject1).getString(2131362011);; localObject1 = ((Context)localObject1).getString(2131362010))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297799));
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(4);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentImageURLImageView.setTag(localObject2);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_avatar_pendant", this.jdField_a_of_type_ComTencentImageURLImageView);
      super.n(paramProfileCardInfo);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300928));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300930));
      ProfileCardTemplate.a(this.c, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "photoAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.c);
      super.f(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)findViewById(2131300216));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300934));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView = ((QzonePhotoView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300949));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.setBackgroundResource(17170445);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300923));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      super.d(paramProfileCardInfo);
      return;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.onConfigurationChanged(paramConfiguration);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfilePhotoView
 * JD-Core Version:    0.7.0.1
 */