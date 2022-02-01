package com.tencent.mobileqq.profile.view;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.widget.BounceScrollView.MotionEventInterceptor;
import com.tencent.mobileqq.widget.QZoneCoverView;
import com.tencent.mobileqq.widget.Rotate3dAnimation;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import jnu;
import jnv;
import jnw;
import jnx;
import jnz;

public abstract class ProfileHeaderView
  extends RelativeLayout
  implements ProfileViewUpdate, BounceScrollView.MotionEventInterceptor
{
  public static int a = 0;
  public static String a;
  public static int b = 0;
  public static int d = 1000;
  public static int e = 1001;
  public static int f = 1002;
  protected static final int h = 1;
  protected static final int i = 2;
  protected float a;
  public long a;
  public Handler a;
  public BaseActivity a;
  public QQAppInterface a;
  public NewVoteAnimHelper a;
  public ProfileCardInfo a;
  public HashMap a;
  public boolean a;
  protected float b;
  protected float c;
  public int c;
  public int g = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = "Q.profilecard.FrdProfileCard.ProfileHeaderView";
    jdField_a_of_type_Int = 500;
    jdField_b_of_type_Int = jdField_a_of_type_Int * 2 + 3000;
  }
  
  public ProfileHeaderView(BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo)
  {
    super(paramBaseActivity);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    paramProfileCardInfo = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = paramProfileCardInfo.density;
    int j = SizeMeasure.e(paramBaseActivity);
    this.jdField_b_of_type_Float = Math.min(j, paramProfileCardInfo.heightPixels);
    this.jdField_c_of_type_Float = Math.max(j, paramProfileCardInfo.heightPixels);
  }
  
  public int a()
  {
    return 0;
  }
  
  public CoverCacheData a()
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getCoverCacheData");
      }
      return ((QZoneCoverView)localObject).a();
    }
    if ((localObject instanceof QzonePhotoView))
    {
      localObject = (QzonePhotoView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
      }
      return ((QzonePhotoView)localObject).a();
    }
    if ((localObject instanceof VipPhotoViewForSimple))
    {
      localObject = (VipPhotoViewForSimple)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
      }
      return ((VipPhotoViewForSimple)localObject).a();
    }
    return null;
  }
  
  public void a()
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QZoneCoverView)) {
      ((QZoneCoverView)localView).b();
    }
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne)
  {
    if (paramAllInOne.jdField_a_of_type_Int == 33)
    {
      a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    if (ProfileActivity.AllInOne.f(paramAllInOne))
    {
      if ((paramAllInOne.jdField_a_of_type_Int == 41) && (!TextUtils.isEmpty(paramAllInOne.jdField_a_of_type_JavaLangString)) && (paramAllInOne.jdField_a_of_type_JavaLangString.equals("0")) && (!TextUtils.isEmpty(paramAllInOne.p)))
      {
        a(paramAllInOne, 0, paramAllInOne.p);
        return;
      }
      a(paramAllInOne, 0, paramAllInOne.jdField_a_of_type_JavaLangString);
      return;
    }
    String str = ProfileCardUtil.a(paramAllInOne);
    if ((str != null) && (str.length() > 0))
    {
      a(paramAllInOne, 1, str);
      return;
    }
    a(paramAllInOne, 2, paramAllInOne.jdField_a_of_type_JavaLangString);
  }
  
  public void a(ProfileActivity.AllInOne paramAllInOne, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "updateAvatar() type = " + paramInt + "key = " + paramString);
    }
    ThreadManager.b(new jnx(this, paramInt, paramAllInOne, paramString));
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo);
  
  public void a(ProfileCardInfo paramProfileCardInfo, long paramLong)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if ((localObject instanceof VoteView))
    {
      localObject = (VoteView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLiked");
      }
      long l = paramLong;
      if (paramLong == -1L) {
        l = ((VoteView)localObject).jdField_a_of_type_Int;
      }
      ((VoteView)localObject).a(false, true, (int)l, 0, null);
      ((VoteView)localObject).setTag(null);
      ((VoteView)localObject).setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((VoteView)localObject).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361996), new Object[] { String.valueOf(l) }));
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, HashMap paramHashMap)
  {
    paramProfileCardInfo = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap;
    String str1 = getClass().getName();
    if ((paramProfileCardInfo == null) || (paramProfileCardInfo.size() <= 0)) {
      throw new ProfileTemplateException(str1 + " template templateAttr is null");
    }
    paramHashMap.put("commonBottomBtnBackground", "drawable");
    paramHashMap.put("commonBottomBtnTextColor", "color");
    paramHashMap.put("commonItemTitleColor", "color");
    paramHashMap.put("commonItemContentColor", "color");
    paramHashMap.put("commonItemContentLinkColor", "color");
    paramHashMap.put("commonItemTopBorderBackground", "drawable");
    paramHashMap.put("commonItemBottomBorderBackground", "drawable");
    paramHashMap.put("commonItemBorderBackground", "drawable");
    paramHashMap.put("commonItemMoreSrc", "drawable");
    paramHashMap.put("commonQrCodeSrc", "drawable");
    paramHashMap.put("commonMaskBackground", "color");
    paramHashMap = paramHashMap.entrySet().iterator();
    label435:
    label438:
    for (;;)
    {
      Object localObject1;
      String str2;
      Object localObject2;
      int j;
      String str3;
      if (paramHashMap.hasNext())
      {
        localObject1 = (Map.Entry)paramHashMap.next();
        str2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = (String)((Map.Entry)localObject1).getValue();
        localObject2 = paramProfileCardInfo.get(str2);
        String[] arrayOfString = ((String)localObject1).split(",");
        int k = arrayOfString.length;
        j = 0;
        if (j >= k) {
          break label435;
        }
        str3 = arrayOfString[j];
        if ((localObject2 != null) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
          if ((str3.equalsIgnoreCase("color")) && (((localObject2 instanceof ColorStateList)) || ((localObject2 instanceof String)))) {
            j = 1;
          }
        }
      }
      for (;;)
      {
        if (j != 0) {
          break label438;
        }
        throw new ProfileTemplateException(str1 + " template attr " + str2 + " type is not " + (String)localObject1);
        if ((str3.equalsIgnoreCase("drawable")) && ((localObject2 instanceof Drawable)))
        {
          j = 1;
        }
        else if ((str3.equalsIgnoreCase("string")) && ((localObject2 instanceof String)) && (!TextUtils.isEmpty((String)localObject2)))
        {
          j = 1;
        }
        else
        {
          j += 1;
          break;
          return;
          j = 0;
        }
      }
    }
  }
  
  public abstract void a(ProfileCardInfo paramProfileCardInfo, boolean paramBoolean);
  
  public void a(CoverCacheData paramCoverCacheData)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "updateCoverView");
      }
      ((QZoneCoverView)localObject).a(paramCoverCacheData);
    }
    do
    {
      return;
      if ((localObject instanceof QzonePhotoView))
      {
        localObject = (QzonePhotoView)localObject;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateQzonePhotoView");
        }
        ((QzonePhotoView)localObject).a(paramCoverCacheData);
        return;
      }
    } while (!(localObject instanceof VipPhotoViewForSimple));
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateVipPhotoViewForSimple");
    }
    ((VipPhotoViewForSimple)localObject).a(paramCoverCacheData);
  }
  
  public void a(String paramString, int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QZoneCoverView)) {
      ((QZoneCoverView)localView).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    if ((localObject2 != null) && (localObject1 != null)) {
      if (!paramBoolean) {
        break label151;
      }
    }
    for (;;)
    {
      Object localObject3 = new Rotate3dAnimation(0.0F, -90.0F, 1, 0.5F, 0.5F, 0.0F, false);
      Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(-90.0F, 0.0F, 1, 0.5F, 0.5F, 0.0F, false);
      ((Rotate3dAnimation)localObject3).setDuration(jdField_a_of_type_Int);
      ((Rotate3dAnimation)localObject3).setFillAfter(false);
      localRotate3dAnimation.setDuration(jdField_a_of_type_Int);
      localRotate3dAnimation.setFillAfter(false);
      ((Rotate3dAnimation)localObject3).setAnimationListener(new jnv(this, (View)localObject2, (View)localObject1, localRotate3dAnimation));
      localRotate3dAnimation.setAnimationListener(new jnw(this, paramBoolean));
      ((View)localObject2).startAnimation((Animation)localObject3);
      return;
      label151:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localObject instanceof QZoneCoverView))
    {
      localObject = (QZoneCoverView)localObject;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "QZoneCoverView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
      }
      ((QZoneCoverView)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
    }
    do
    {
      return;
      if ((localObject instanceof QzonePhotoView))
      {
        localObject = (QzonePhotoView)localObject;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "QzonePhotoView onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
        }
        ((QzonePhotoView)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
        return;
      }
    } while (!(localObject instanceof VipPhotoViewForSimple));
    localObject = (VipPhotoViewForSimple)localObject;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "VipPhotoViewForSimple onGetQZoneCover isSuccess=" + String.valueOf(paramBoolean) + ",uin=" + paramString);
    }
    ((VipPhotoViewForSimple)localObject).a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
  }
  
  public boolean a()
  {
    return (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover") != null;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView onInit");
    }
    j(paramProfileCardInfo);
    k(paramProfileCardInfo);
    this.jdField_a_of_type_AndroidOsHandler = new jnu(this, Looper.getMainLooper(), paramProfileCardInfo);
    paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(d);
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (paramProfileCardInfo != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramProfileCardInfo);
    }
  }
  
  public void c()
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QZoneCoverView)) {
      ((QZoneCoverView)localView).a();
    }
  }
  
  public void d()
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzonecover");
    if ((localView instanceof QZoneCoverView)) {
      ((QZoneCoverView)localView).c();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void d(ProfileCardInfo paramProfileCardInfo)
  {
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag_jueban");
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    if (((localView instanceof TextView)) && (localObject != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan()) && (ProfileCardUtil.a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray())))
    {
      int j = ((View)localObject).getWidth();
      int k = localView.getWidth();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateJueban widthLike = " + j + ", widthJueban = " + k);
      }
      if ((j != 0) && (k != 0))
      {
        localObject = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin -= (k - j) / 2;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localView.setTag(new DataTag(34, null));
      localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_Boolean = true;
      a(true);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(f, jdField_b_of_type_Int);
    }
  }
  
  public void e(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_profile_nick_name");
    TextView localTextView;
    ProfileActivity.AllInOne localAllInOne;
    if ((localObject instanceof TextView))
    {
      localTextView = (TextView)localObject;
      localObject = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName;
      localAllInOne = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne;
      localObject = ((MQQProfileName)localObject).a.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "updateHead titleName = " + Utils.b((String)localObject));
      }
      if (localObject != null)
      {
        paramProfileCardInfo = (ProfileCardInfo)localObject;
        if (((String)localObject).length() != 0) {}
      }
      else
      {
        if (!ProfileActivity.AllInOne.a(localAllInOne)) {
          break label168;
        }
      }
    }
    label168:
    for (paramProfileCardInfo = String.valueOf(localAllInOne.jdField_a_of_type_JavaLangString);; paramProfileCardInfo = " ")
    {
      localTextView.setText(paramProfileCardInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361973) + ":";
      localTextView.setContentDescription((String)localObject + paramProfileCardInfo);
      return;
    }
  }
  
  public void f(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sex_age_area");
    String str;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      str = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramProfileCardInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateSexAgeArea strInfo=" + Utils.b(str));
      }
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label125;
      }
      paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368854);
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setPadding(0, 10, 0, 0);
      ((TextView)localObject).setText(paramProfileCardInfo);
      ((TextView)localObject).setContentDescription(paramProfileCardInfo);
    }
    label125:
    do
    {
      return;
      if ((str != null) && (str.length() > 0))
      {
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        ((TextView)localObject).setPadding(0, 0, 0, 0);
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361978) + ":" + str);
        ((TextView)localObject).setClickable(true);
        return;
      }
    } while (((TextView)localObject).getVisibility() == 8);
    ((TextView)localObject).setVisibility(8);
  }
  
  public void g(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level");
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_level_accelerate");
    int j;
    if ((localObject instanceof TextView))
    {
      localObject = (TextView)localObject;
      if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) {
        break label299;
      }
      j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iQQLevel;
    }
    for (long l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.uAccelerateMultiple;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLevel level=" + j);
      }
      if ((j == 0) || (!ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        if (((TextView)localObject).getVisibility() != 8) {
          ((TextView)localObject).setVisibility(8);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        return;
      }
      paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_icon");
      if ((paramProfileCardInfo != null) && (paramProfileCardInfo.getVisibility() == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        ((TextView)localObject).setText(ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 6, j, bool));
        if (((TextView)localObject).getVisibility() != 0) {
          ((TextView)localObject).setVisibility(0);
        }
        paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362016);
        if (l > 10L)
        {
          localView.setVisibility(0);
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362017);
        }
        for (;;)
        {
          ((TextView)localObject).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361979) + ":" + Integer.toString(j) + paramProfileCardInfo);
          return;
        }
      }
      label299:
      j = 0;
    }
  }
  
  public void h(ProfileCardInfo paramProfileCardInfo)
  {
    try
    {
      Object localObject3 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_icon");
      View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_text");
      View localView2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_login_day_layout");
      Object localObject2 = null;
      Card localCard = null;
      Object localObject1 = localObject2;
      if (localView2 != null)
      {
        localObject1 = localObject2;
        if ((localView2 instanceof RelativeLayout)) {
          localObject1 = (RelativeLayout)localView2;
        }
      }
      localObject2 = localCard;
      if (localView1 != null)
      {
        localObject2 = localCard;
        if ((localView1 instanceof TextView)) {
          localObject2 = (TextView)localView1;
        }
      }
      long l;
      if ((localObject3 instanceof ImageView))
      {
        localObject3 = (ImageView)localObject3;
        l = 30L;
        localCard = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
        if ((localCard != null) && (localCard.isShowXMan()))
        {
          if (localCard.lQQMasterLogindays > 0L) {
            l = localCard.lQQMasterLogindays;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLoginDays lQQMasterLogindays=" + l + ",lLoginDays=" + localCard.lLoginDays + ",AllinOne Pa=" + paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
          }
          ((ImageView)localObject3).setVisibility(0);
          if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
            if (localCard.lLoginDays >= l)
            {
              ((RelativeLayout)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362018), new Object[] { Long.valueOf(localCard.lLoginDays) }));
              if (localCard.allowClick)
              {
                ((ImageView)localObject3).setBackgroundResource(2130840451);
                ((TextView)localObject2).setTextColor(-155129);
              }
              while (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                ((TextView)localObject2).setText(localCard.lLoginDays + "天");
                return;
                ((ImageView)localObject3).setBackgroundResource(2130842128);
              }
            }
          }
        }
      }
      label615:
      label755:
      return;
    }
    catch (Exception paramProfileCardInfo)
    {
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "updateQQLoginDays exception ", paramProfileCardInfo);
        return;
        ((RelativeLayout)localObject1).setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362019), new Object[] { Long.valueOf(localCard.lLoginDays) }));
        if (localCard.allowClick)
        {
          ((ImageView)localObject3).setBackgroundResource(2130840450);
          ((TextView)localObject2).setTextColor(-5855578);
        }
        while (localObject1 != null)
        {
          ((RelativeLayout)localObject1).setVisibility(0);
          ((TextView)localObject2).setText(localCard.lLoginDays + "天");
          return;
          ((ImageView)localObject3).setBackgroundResource(2130842129);
        }
        if (localCard.lLoginDays >= l)
        {
          if (localCard.allowClick)
          {
            ((ImageView)localObject3).setBackgroundResource(2130840451);
            ((TextView)localObject2).setTextColor(-155129);
            if (localObject1 == null) {
              return;
            }
            ((RelativeLayout)localObject1).setVisibility(0);
            if (!localCard.allowPeopleSee) {
              break label615;
            }
            paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362020), new Object[] { Long.valueOf(localCard.lLoginDays) });
            ((TextView)localObject2).setText(localCard.lLoginDays + "天");
          }
          for (;;)
          {
            ((RelativeLayout)localObject1).setContentDescription(paramProfileCardInfo);
            return;
            ((ImageView)localObject3).setBackgroundResource(2130842128);
            break;
            paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362022);
            ((TextView)localObject2).setVisibility(8);
          }
        }
        else
        {
          if (localCard.allowClick)
          {
            ((ImageView)localObject3).setBackgroundResource(2130840450);
            ((TextView)localObject2).setTextColor(-5855578);
            if (localObject1 == null) {
              return;
            }
            ((RelativeLayout)localObject1).setVisibility(0);
            if (!localCard.allowPeopleSee) {
              break label755;
            }
            paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362021), new Object[] { Long.valueOf(localCard.lLoginDays) });
            ((TextView)localObject2).setText(localCard.lLoginDays + "天");
          }
          for (;;)
          {
            ((RelativeLayout)localObject1).setContentDescription(paramProfileCardInfo);
            return;
            ((ImageView)localObject3).setBackgroundResource(2130842129);
            break;
            paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131362023);
            ((TextView)localObject2).setVisibility(8);
          }
          ((ImageView)localObject3).setVisibility(8);
        }
      }
    }
  }
  
  public void i(ProfileCardInfo paramProfileCardInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_like");
    } while (!(localObject1 instanceof VoteView));
    VoteView localVoteView = (VoteView)localObject1;
    if (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null) {}
    for (boolean bool = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.isShowZan();; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateLike type isShowVote = " + String.valueOf(bool));
      }
      if (bool)
      {
        if ((localVoteView.getVisibility() != 0) && (!this.jdField_a_of_type_Boolean)) {
          localVoteView.setVisibility(0);
        }
        Object localObject2;
        int k;
        int j;
        if (((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) || ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361999);
          localObject2 = null;
          k = 0;
          bool = false;
          j = 0;
        }
        for (;;)
        {
          localVoteView.a(false, bool, j, k, this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper);
          localVoteView.setTag(localObject2);
          localVoteView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          localVoteView.setContentDescription((CharSequence)localObject1);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper == null) {
            this.jdField_a_of_type_ComTencentMobileqqDatingNewVoteAnimHelper = new NewVoteAnimHelper(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
          }
          k = (int)paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lVoteCount;
          j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.iVoteIncrement;
          if (1 == paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.bVoted) {}
          for (bool = true;; bool = false)
          {
            if (!bool) {
              break label312;
            }
            localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361996), new Object[] { String.valueOf(k) });
            localObject2 = null;
            m = j;
            j = k;
            k = m;
            break;
          }
          label312:
          localObject2 = new DataTag(10, paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard);
          localObject1 = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131361997), new Object[] { String.valueOf(k) });
          int m = j;
          j = k;
          k = m;
        }
      }
      localVoteView.setVisibility(8);
      return;
    }
  }
  
  public void j(ProfileCardInfo paramProfileCardInfo)
  {
    this.g &= 0xFFFFFFFE;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904131, null);
    }
    for (;;)
    {
      Object localObject;
      int j;
      if ((localView != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (ProfileActivity.AllInOne.c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
      {
        localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        if (localObject != null)
        {
          localObject = ((FriendManager)localObject).c(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          j = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          if ((2 != j) && (j != 0)) {
            break label178;
          }
          this.g &= 0xFFFFFFFE;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip local network: " + j);
          }
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_net_voice", localView);
        return;
        label178:
        if ((localObject == null) || ((((Friends)localObject).iTermType != 68104) && (((Friends)localObject).iTermType != 65805))) {
          break;
        }
        this.g &= 0xFFFFFFFE;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip not show netvoice tip friend iTermType=" + ((Friends)localObject).iTermType);
        }
      }
      TextView localTextView;
      if ((localObject != null) && ((((Friends)localObject).abilityBits & 1L) != 0L))
      {
        localTextView = (TextView)localView.findViewById(2131300970);
        switch (((Friends)localObject).getNetWorkType())
        {
        default: 
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368270);
        }
      }
      label663:
      for (;;)
      {
        label331:
        if (localTextView != null) {
          localTextView.setText(paramProfileCardInfo);
        }
        if (ContactUtils.a((Friends)localObject)) {}
        for (this.g = 0; QLog.isColorLevel(); this.g |= 0x1)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip has ability,show tip.net=" + ((Friends)localObject).getNetWorkType());
          break;
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368271);
          break label331;
          paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368273), new Object[] { "4G" });
          break label331;
          paramProfileCardInfo = String.format(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368273), new Object[] { "3G" });
          break label331;
          paramProfileCardInfo = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368274);
          if (localTextView == null) {
            break label663;
          }
          Resources localResources = getResources();
          if (((Friends)localObject).iTermType == 67586) {}
          for (j = 2130840527;; j = 2130840528)
          {
            localTextView.setCompoundDrawablesWithIntrinsicBounds(localResources.getDrawable(j), null, null, null);
            localTextView.setCompoundDrawablePadding((int)DisplayUtils.a(getContext(), 4.0F));
            break;
          }
        }
        if ((localObject == null) || ((((Friends)localObject).abilityBits & 0x2) == 0L)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateNetVoiceTip-->show PC has camera,state=" + ((Friends)localObject).status);
        }
        paramProfileCardInfo = (TextView)localView.findViewById(2131300970);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131368272);
        if ((paramProfileCardInfo != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          paramProfileCardInfo.setText((CharSequence)localObject);
        }
        this.g |= 0x1;
        break;
      }
    }
  }
  
  public void k(ProfileCardInfo paramProfileCardInfo)
  {
    this.g &= 0xFFFFFFFD;
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
    if (localView == null) {
      localView = View.inflate(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130904120, null);
    }
    for (;;)
    {
      long l2;
      int j;
      Object localObject1;
      TextView localTextView;
      ImageView localImageView;
      Object localObject2;
      if ((localView != null) && (paramProfileCardInfo != null) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard != null))
      {
        l1 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
        l2 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId;
        j = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet;
        localObject3 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.getBgTypeArray();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar bgtype = " + localObject3);
        }
        localObject1 = getResources();
        localTextView = (TextView)localView.findViewById(2131296666);
        localImageView = (ImageView)localView.findViewById(2131300941);
        if ((paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
          break label440;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        boolean bool = false;
        if (localObject2 != null) {
          bool = ((SharedPreferences)localObject2).getBoolean("svip_profile_use_guide_shown_flag", false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "isShowTips" + bool + ",templateRet=" + j + ",myTemplateId=" + l1);
        }
        if (((101107 == j) || (101108 == j)) && (!bool) && (localObject2 != null))
        {
          ((SharedPreferences)localObject2).edit().putBoolean("svip_profile_use_guide_shown_flag", true).commit();
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          if (101107 != j) {
            break label427;
          }
          localObject1 = ((Resources)localObject1).getString(2131369211);
          localObject1 = ((BaseActivity)localObject2).getString(2131369210, new Object[] { localObject1 });
          localTextView.setText((CharSequence)localObject1);
          localImageView.setContentDescription((CharSequence)localObject1);
          localView.setTag(new DataTag(24, Integer.valueOf(j)));
          localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
          this.g |= 0x2;
        }
      }
      label427:
      label440:
      do
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tips_set_card", localView);
          return;
          localObject1 = ((Resources)localObject1).getString(2131369212);
          break;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("ProfileCardTips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), 0);
          localObject4 = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
          if ((!ProfileCardUtil.d((ArrayList)localObject3)) && (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentBgId != 160L)) {
            break label540;
          }
          this.g &= 0xFFFFFFFD;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar isSpecilaBg");
          }
        }
      } while ((localObject4 == null) || (l2 <= 0L) || (l1 <= 0L) || (j != 0));
      label540:
      Object localObject3 = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
      Object localObject4 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (localObject4 != null) {}
      for (long l1 = ((Card)localObject4).lCurrentBgId;; l1 = 0L)
      {
        localObject4 = ((SharedPreferences)localObject2).getString(String.valueOf(l2), "");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "updateSetCardBar today=" + (String)localObject3 + ",userLastAccessDay=" + (String)localObject4 + ",friendBackgroundId=" + l2 + ",myBackgroundId=" + l1);
        }
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).equals(localObject4)) || (l1 == l2)) {
          break;
        }
        ((SharedPreferences)localObject2).edit().putString(String.valueOf(l2), (String)localObject3).commit();
        localTextView.setText(((Resources)localObject1).getString(2131369209));
        localImageView.setContentDescription(((Resources)localObject1).getString(2131369209));
        localView.setTag(new DataTag(29, "CLICK_BANNER"));
        localView.setOnClickListener(paramProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        this.g |= 0x2;
        break;
      }
    }
  }
  
  public void l(ProfileCardInfo paramProfileCardInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips");
    }
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips");
    LinearLayout localLinearLayout;
    if ((localObject instanceof LinearLayout))
    {
      localLinearLayout = (LinearLayout)localObject;
      if ((paramProfileCardInfo == null) || (paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
        break label464;
      }
      long l = paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId;
      if ((l != ProfileCardTemplate.jdField_b_of_type_Long) && (l != ProfileCardTemplate.c) && (l != ProfileCardTemplate.d)) {
        break label464;
      }
    }
    label403:
    label464:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        localLinearLayout.setVisibility(8);
        if (((this.g & 0x1) == 0) || ((this.g & 0x2) == 0)) {
          break label342;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice and setcard");
        }
        paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
        localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
        if ((paramProfileCardInfo != null) && (localObject != null))
        {
          if (localLinearLayout.getChildCount() != 0) {
            break label245;
          }
          localLinearLayout.addView(paramProfileCardInfo);
          localLinearLayout.setVisibility(0);
          if (this.jdField_c_of_type_Int < 4)
          {
            this.jdField_c_of_type_Int += 1;
            paramProfileCardInfo = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(d);
            this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramProfileCardInfo, 4000L);
          }
        }
      }
      label245:
      do
      {
        do
        {
          do
          {
            return;
            localLinearLayout.setVisibility(4);
            break;
            View localView = localLinearLayout.getChildAt(0);
            if (localView != null)
            {
              if (localView.getId() == 2131300969) {
                paramProfileCardInfo = (ProfileCardInfo)localObject;
              }
              for (;;)
              {
                localObject = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130968731);
                ((Animation)localObject).setFillAfter(true);
                ((Animation)localObject).setAnimationListener(new jnz(this, localLinearLayout, paramProfileCardInfo));
                localLinearLayout.setVisibility(0);
                localView.startAnimation((Animation)localObject);
                return;
              }
            }
            if (j != 0)
            {
              localLinearLayout.setVisibility(8);
              return;
            }
            localLinearLayout.setVisibility(4);
            return;
            if ((this.g & 0x1) == 0) {
              break label403;
            }
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips netvoice");
            }
            paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_net_voice");
          } while (paramProfileCardInfo == null);
          localLinearLayout.removeAllViews();
          localLinearLayout.addView(paramProfileCardInfo);
          localLinearLayout.setVisibility(0);
          return;
        } while ((this.g & 0x2) == 0);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips setcard");
        }
        paramProfileCardInfo = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tips_set_card");
      } while (paramProfileCardInfo == null);
      label342:
      localLinearLayout.removeAllViews();
      localLinearLayout.addView(paramProfileCardInfo);
      localLinearLayout.setVisibility(0);
      return;
    }
  }
  
  public void m(ProfileCardInfo paramProfileCardInfo) {}
  
  public void n(ProfileCardInfo paramProfileCardInfo)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
    if ((localObject instanceof URLImageView))
    {
      localObject = (URLImageView)localObject;
      if (ProfileActivity.AllInOne.f(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
        break label47;
      }
      ((URLImageView)localObject).setVisibility(4);
      this.jdField_a_of_type_Long = 0L;
    }
    label47:
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    paramProfileCardInfo = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(paramProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    if ((paramProfileCardInfo != null) && (paramProfileCardInfo.isPendantValid()))
    {
      this.jdField_a_of_type_Long = paramProfileCardInfo.pendantId;
      paramProfileCardInfo = (AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
      ((URLImageView)localObject).setVisibility(0);
      if (AvatarPendantUtil.a(this.jdField_a_of_type_Long))
      {
        paramProfileCardInfo.a(this.jdField_a_of_type_Long).a((View)localObject, 2, PendantInfo.i);
        return;
      }
      paramProfileCardInfo.a(this.jdField_a_of_type_Long).a((View)localObject, 1, PendantInfo.i);
      return;
    }
    ((URLImageView)localObject).setVisibility(4);
    this.jdField_a_of_type_Long = 0L;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramConfiguration.orientation == 1) {}
    for (int j = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);; j = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels))
    {
      int k = SizeMeasure.e(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      this.jdField_b_of_type_Float = Math.min(k, j);
      this.jdField_c_of_type_Float = Math.max(k, j);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView
 * JD-Core Version:    0.7.0.1
 */