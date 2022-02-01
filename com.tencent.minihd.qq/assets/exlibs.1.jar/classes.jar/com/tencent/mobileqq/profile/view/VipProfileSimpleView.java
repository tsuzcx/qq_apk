package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import jor;
import jos;

public class VipProfileSimpleView
  extends ProfileHeaderView
{
  public static final int j = 129;
  public static final int n = 18;
  View a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public VipPhotoViewForSimple a;
  public VoteView a;
  public View b;
  public ImageView b;
  public TextView b;
  public boolean b;
  public TextView c;
  public TextView d;
  public TextView e;
  public int o = -1;
  public int p = -1;
  
  public VipProfileSimpleView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    a(paramProfileCardInfo);
    b(paramProfileCardInfo);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a.size();
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
    localHashMap.put("simpleQQNumColor", "color");
    localHashMap.put("simpleNickNameColor", "color");
    localHashMap.put("simpleAddressColor", "color");
    localHashMap.put("simpleGridAddBackground", "color");
    localHashMap.put("simpleAddressBackground", "drawable");
    localHashMap.put("simpleAddSrc", "drawable");
    localHashMap.put("simpleGridAddSrc", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.i(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    c(paramProfileCardInfo);
    super.j(paramProfileCardInfo);
    super.n(paramProfileCardInfo);
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return true;
    }
    return super.a(paramView, paramMotionEvent);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    super.b(paramProfileCardInfo);
    Object localObject1 = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject1).inflate(2130904127, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300925));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300937));
    ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    Object localObject2 = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localObject2);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
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
      this.o = getResources().getDimensionPixelSize(2131493124);
      this.p = ProfileCardUtil.a(getResources());
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300957);
      localObject1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)this.jdField_c_of_type_Float - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.o - this.p);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "rl.height: " + ((RelativeLayout.LayoutParams)localObject1).height);
      }
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300928));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300960));
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300959));
      this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300961));
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.e, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.d, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressColor");
      ProfileCardTemplate.a(this.jdField_c_of_type_AndroidWidgetTextView, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.e, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      ProfileCardTemplate.a(this.d, "background", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "simpleAddressBackground");
      c(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300216));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300934));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple = ((VipPhotoViewForSimple)this.jdField_a_of_type_AndroidViewView.findViewById(2131300949));
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzonecover", this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.setBackgroundResource(17170445);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300923));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, 0.0F, 0, -100.0F);
      ((Animation)localObject1).setDuration(500L);
      ((Animation)localObject1).setFillAfter(true);
      localObject2 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -100.0F, 0, 0.0F);
      ((Animation)localObject2).setDuration(500L);
      ((Animation)localObject2).setAnimationListener(new jor(this, paramProfileCardInfo));
      ((Animation)localObject1).setAnimationListener(new jos(this, (Animation)localObject2));
      startAnimation((Animation)localObject1);
      return;
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    int k = -1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368854);
      this.e.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setPadding(0, 10, 0, 0);
      this.e.setText(paramProfileCardInfo);
      this.e.setContentDescription(paramProfileCardInfo);
      return;
    }
    Object localObject = "";
    Card localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
    ContactCard localContactCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataContactCard;
    int i;
    if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 0) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte == 1)) {
      i = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Byte;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366573);
        label141:
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea sex=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label669;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(paramProfileCardInfo);
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(paramProfileCardInfo);
        label204:
        paramProfileCardInfo = "";
        if (localCard == null) {
          break label681;
        }
        i = localCard.age;
        label219:
        if (i > 0) {
          paramProfileCardInfo = i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366575);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea age=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label697;
        }
        this.e.setVisibility(0);
        this.e.setText(paramProfileCardInfo);
        this.e.setContentDescription(paramProfileCardInfo);
        label314:
        localObject = "";
        if (localCard == null) {
          break label709;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCountry))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!"中国".equals(localCard.strCountry)) {
            paramProfileCardInfo = "" + localCard.strCountry;
          }
        }
        localObject = paramProfileCardInfo;
        if (!TextUtils.isEmpty(localCard.strProvince))
        {
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(paramProfileCardInfo)) {
            localObject = paramProfileCardInfo + "，";
          }
          localObject = (String)localObject + localCard.strProvince;
        }
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (!TextUtils.isEmpty(localCard.strCity))
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramProfileCardInfo = (String)localObject + "，";
          }
          paramProfileCardInfo = paramProfileCardInfo + localCard.strCity;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea place=" + paramProfileCardInfo);
        }
        if (TextUtils.isEmpty(paramProfileCardInfo)) {
          break label917;
        }
        this.d.setVisibility(0);
        this.d.setText(paramProfileCardInfo);
        this.d.setContentDescription(paramProfileCardInfo);
        return;
        if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
        {
          i = localCard.shGender;
          break;
        }
        if ((localContactCard == null) || ((localContactCard.bSex != 0) && (localContactCard.bSex != 1))) {
          break label927;
        }
        i = localContactCard.bSex;
        break;
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (i != 1) {
          break label141;
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131366574);
        break label141;
        label669:
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        break label204;
        label681:
        i = k;
        if (localContactCard == null) {
          break label219;
        }
        i = localContactCard.bAge;
        break label219;
        label697:
        this.e.setVisibility(8);
        break label314;
        label709:
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (localContactCard != null)
        {
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCountry))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!"中国".equals(localContactCard.strCountry)) {
              paramProfileCardInfo = "" + localContactCard.strCountry;
            }
          }
          localObject = paramProfileCardInfo;
          if (!TextUtils.isEmpty(localContactCard.strProvince))
          {
            localObject = paramProfileCardInfo;
            if (!TextUtils.isEmpty(paramProfileCardInfo)) {
              localObject = paramProfileCardInfo + "，";
            }
            localObject = (String)localObject + localContactCard.strProvince;
          }
          paramProfileCardInfo = (ProfileCardInfo)localObject;
          if (!TextUtils.isEmpty(localContactCard.strCity))
          {
            paramProfileCardInfo = (ProfileCardInfo)localObject;
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              paramProfileCardInfo = (String)localObject + "，";
            }
            paramProfileCardInfo = paramProfileCardInfo + localContactCard.strCity;
          }
        }
      }
      label917:
      this.d.setVisibility(8);
      return;
      label927:
      i = -1;
    }
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      paramConfiguration = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      paramConfiguration.height = ((int)this.jdField_c_of_type_Float - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 129) - ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 18) - this.o - this.p);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams(paramConfiguration);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.VipProfileSimpleView
 * JD-Core Version:    0.7.0.1
 */