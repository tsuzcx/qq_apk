package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfileGameView
  extends ProfileHeaderView
{
  View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public TextView a;
  private VoteView jdField_a_of_type_ComTencentMobileqqWidgetVoteView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private float jdField_d_of_type_Float;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private float e;
  private float f;
  private float g;
  
  public ProfileGameView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity, paramProfileCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    a(paramProfileCardInfo);
    b(paramProfileCardInfo);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "checkTemplateValid");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("commonFaceBackground", "drawable");
    localHashMap.put("gameHeadInfoBackground", "color");
    localHashMap.put("gameNickNameColor", "color");
    localHashMap.put("gameAddressColor", "color");
    localHashMap.put("gameSignColor", "color");
    localHashMap.put("gamePlayNowColor", "color");
    localHashMap.put("gameMoreColor", "color");
    localHashMap.put("gameMoreGameDrawableRight", "drawable");
    localHashMap.put("gamePlayTitleColor", "color");
    localHashMap.put("gameIconBorder", "drawable");
    super.a(paramProfileCardInfo, localHashMap);
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    super.i(paramProfileCardInfo);
    super.e(paramProfileCardInfo);
    super.f(paramProfileCardInfo);
    super.j(paramProfileCardInfo);
    c(paramProfileCardInfo);
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = getContext();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)localObject).inflate(2130904118, this, true);
    getResources().getDisplayMetrics();
    int i = getResources().getDimensionPixelSize(2131493018);
    int j = getResources().getDimensionPixelSize(2131493031);
    this.e = (this.jdField_b_of_type_Float - (i + j * 3));
    this.jdField_d_of_type_Float = (70.0F * this.jdField_a_of_type_Float);
    this.g = (this.jdField_b_of_type_Float - 103.0F * this.jdField_a_of_type_Float - j * 2);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300925));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300937));
    ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetImageView, "src", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonFaceBackground");
    DataTag localDataTag = new DataTag(1, null);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(localDataTag);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) {}
    for (localObject = ((Context)localObject).getString(2131362011);; localObject = ((Context)localObject).getString(2131362010))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_face", this.jdField_a_of_type_AndroidWidgetImageView);
      super.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300928));
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameNickNameColor");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_profile_nick_name", this.jdField_b_of_type_AndroidWidgetTextView);
      super.e(paramProfileCardInfo);
      this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300930));
      ProfileCardTemplate.a(this.c, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameAddressColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sex_age_area", this.c);
      super.f(paramProfileCardInfo);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300939));
      ProfileCardTemplate.a(this.jdField_d_of_type_AndroidWidgetTextView, "color", paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "gameSignColor");
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sign", this.jdField_d_of_type_AndroidWidgetTextView);
      c(paramProfileCardInfo);
      this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView = ((VoteView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300216));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_like", this.jdField_a_of_type_ComTencentMobileqqWidgetVoteView);
      super.i(paramProfileCardInfo);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300934));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag_jueban", this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131300923));
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips", this.jdField_a_of_type_AndroidWidgetLinearLayout);
      super.b(paramProfileCardInfo);
      super.d(paramProfileCardInfo);
      return;
    }
  }
  
  public void c(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sign");
    TextView localTextView;
    if ((localObject1 instanceof TextView))
    {
      localTextView = (TextView)localObject1;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
        break label40;
      }
      localTextView.setVisibility(4);
    }
    label40:
    SpannableString localSpannableString;
    SpannableStringBuilder localSpannableStringBuilder;
    do
    {
      return;
      localObject1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getRichStatus();
      if ((!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (localObject1 == null))
      {
        localTextView.setVisibility(4);
        return;
      }
      localSpannableString = ((RichStatus)localObject1).a("");
      if (TextUtils.isEmpty(((RichStatus)localObject1).c)) {
        break;
      }
      localSpannableStringBuilder = new SpannableStringBuilder(localSpannableString);
      localSpannableStringBuilder.insert(0, "[S] ");
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localStatusManager != null)
    {
      localObject1 = localStatusManager.a(((RichStatus)localObject1).b, 200);
      localObject1 = new StatableBitmapDrawable(getResources(), (Bitmap)localObject1, false, false);
      int i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
      ((BitmapDrawable)localObject1).setBounds(0, 0, i, i);
      localObject1 = new OffsetableImageSpan((Drawable)localObject1, 0);
      ((OffsetableImageSpan)localObject1).a(-0.1F);
      localSpannableStringBuilder.setSpan(localObject1, 0, "[S]".length(), 17);
      localTextView.setText(localSpannableStringBuilder);
      localTextView.setVisibility(0);
      label232:
      if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null) && ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a == 0) || (ProfileActivity.AllInOne.b(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
        localTextView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      if (TextUtils.isEmpty(localSpannableString)) {
        break label410;
      }
      localObject1 = localSpannableString.toString();
      label282:
      localTextView.setTag(new DataTag(3, localObject1));
      localTextView.setOnLongClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      localObject1 = new StringBuilder().append(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361985)).append(":");
      if (TextUtils.isEmpty(localSpannableString)) {
        break label417;
      }
    }
    label410:
    label417:
    for (paramProfileCardInfo = localSpannableString.toString();; paramProfileCardInfo = "")
    {
      for (;;)
      {
        localTextView.setContentDescription(paramProfileCardInfo);
        return;
        try
        {
          localObject1 = BitmapFactory.decodeResource(getResources(), 2130841575);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          Object localObject2 = null;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          str = null;
        }
      }
      break;
      localTextView.setText(localSpannableString);
      localTextView.setVisibility(0);
      break label232;
      String str = "";
      break label282;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileGameView
 * JD-Core Version:    0.7.0.1
 */