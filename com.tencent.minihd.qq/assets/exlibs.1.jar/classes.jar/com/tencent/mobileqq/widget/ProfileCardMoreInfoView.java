package com.tencent.mobileqq.widget;

import QQService.EVIPSPEC;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileBusiEntry;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileGameView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unifiedname.MQQName;
import com.tencent.mobileqq.unifiedname.MQQProfileName;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SizeMeasure;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProfileCardMoreInfoView
  extends LinearLayout
{
  private static final String jdField_a_of_type_JavaLangString = "map_key_account_info";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "map_key_account_info", "map_key_nick", "map_key_qqloginday", "map_key_qrcode", "map_key_sig", "map_key_diamond" };
  private static final String jdField_b_of_type_JavaLangString = "map_key_sig";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "map_key_qzone_feed", "map_key_qzone_photo", "map_key_third_part_app_entrance" };
  private static final String jdField_c_of_type_JavaLangString = "map_key_phone_";
  private static final String jdField_d_of_type_JavaLangString = "map_key_qzone_feed";
  private static final String jdField_e_of_type_JavaLangString = "map_key_diamond";
  private static final String f = "map_key_qzone_photo";
  private static final String g = "map_key_nick";
  private static final String h = "map_key_recommendname";
  private static final String i = "map_key_circlenick";
  private static final String j = "map_key_troopnick";
  private static final String k = "map_key_remark";
  private static final String l = "map_key_qrcode";
  private static final String m = "map_key_tag";
  private static final String n = "map_key_qqloginday";
  private static final String o = "map_key_lightalk";
  private static final String p = "map_key_third_part_app_entrance";
  private static final String q = "card_content_description";
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ProfileCardInfo jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo;
  public ProfileCardTemplate a;
  public ProfileHeaderView a;
  public RichStatus a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean = false;
  private final String[] jdField_c_of_type_ArrayOfJavaLangString = { "map_key_tag", "map_key_account_info", "map_key_qrcode", "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_sig", "map_key_phone_", "map_key_lightalk", "map_key_diamond", "map_key_qzone_feed", "map_key_qzone_photo", "map_key_qqloginday", "map_key_third_part_app_entrance" };
  private boolean jdField_d_of_type_Boolean = false;
  private final String[] jdField_d_of_type_ArrayOfJavaLangString = { "map_key_nick", "map_key_circlenick", "map_key_remark", "map_key_recommendname", "map_key_troopnick", "map_key_phone_" };
  private boolean jdField_e_of_type_Boolean;
  
  public ProfileCardMoreInfoView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
    this.e = false;
    b(paramContext);
  }
  
  public ProfileCardMoreInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate = null;
    this.e = false;
    b(paramContext);
  }
  
  private int a(TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, String paramString, Card paramCard)
  {
    int i2 = 0;
    Object localObject2 = paramTextView.getPaint();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TextPaint(1);
      ((TextPaint)localObject1).density = this.jdField_c_of_type_Float;
    }
    int i3 = 0;
    localObject2 = new StringBuffer(paramString);
    float f1;
    int i1;
    if ((paramBoolean1) || (paramBoolean2) || (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0))
    {
      f1 = ((TextPaint)localObject1).measureText(paramString);
      i2 = (int)(f1 % this.jdField_b_of_type_Float);
      if (paramBoolean1) {
        if ((paramCard != null) && (paramCard.iQQVipType == 1))
        {
          i1 = 42;
          f1 = 10 + i1;
          f1 = this.jdField_c_of_type_Float;
          f1 = i2;
          i1 = (int)((i1 + 10) * this.jdField_c_of_type_Float + f1);
        }
      }
    }
    for (;;)
    {
      label149:
      label176:
      label199:
      label222:
      SpannableString localSpannableString;
      label296:
      String str;
      label360:
      Drawable localDrawable;
      double d1;
      if (this.jdField_b_of_type_Float - i1 < 0.0F)
      {
        i1 = 2;
        ((StringBuffer)localObject2).append("\n");
        i3 = 1;
        if (!paramBoolean1) {
          break label658;
        }
        i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERVIP);
        if (i2 >= 1) {
          break label590;
        }
        i2 = 1;
        if ((paramCard == null) || (paramCard.iQQVipType != 1)) {
          break label601;
        }
        if (i3 == 0) {
          break label593;
        }
        paramCard = "S";
        ((StringBuffer)localObject2).append(paramCard);
        paramCard = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/year_svip_" + i2 + ".png";
        ((StringBuffer)localObject2).append(" ");
        localObject1 = ((StringBuffer)localObject2).toString();
        localObject2 = getResources();
        localSpannableString = new SpannableString((CharSequence)localObject1);
        i2 = paramString.length();
        if (i2 >= ((String)localObject1).length()) {
          break label1110;
        }
        paramString = null;
        str = ((String)localObject1).substring(i2, i2 + 1);
        if ((!"S".equalsIgnoreCase(str)) || (TextUtils.isEmpty(paramCard))) {
          break label893;
        }
        paramString = getResources();
        if (!str.equals("S")) {
          break label869;
        }
        i3 = 2130840541;
        localDrawable = paramString.getDrawable(i3);
        paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
        i3 = localDrawable.getIntrinsicHeight();
        if (!str.equals("S")) {
          break label877;
        }
        d1 = 85.0D * (i3 / 27.0D);
        label410:
        paramString.setBounds(0, 0, (int)d1, i3);
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(str)) && (paramString != null)) {
          localSpannableString.setSpan(new ImageSpan(paramString, 1), i2, i2 + 1, 33);
        }
        i2 += 1;
        break label296;
        i1 = 34;
        break;
        if (paramBoolean2)
        {
          if ((paramCard != null) && (paramCard.iQQVipType == 1)) {}
          for (i1 = 38;; i1 = 29)
          {
            f1 = 10 + i1;
            f1 = this.jdField_c_of_type_Float;
            f1 = i2;
            i1 = (int)((i1 + 10) * this.jdField_c_of_type_Float + f1);
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1119;
        }
        f1 = 33;
        f1 = this.jdField_c_of_type_Float;
        i1 = (int)(i2 + 33 * this.jdField_c_of_type_Float);
        break label149;
        i1 = 1;
        break label176;
        label590:
        break label199;
        label593:
        paramCard = "BS";
        break label222;
        label601:
        if (i3 != 0) {}
        for (paramCard = "s";; paramCard = "Bs")
        {
          ((StringBuffer)localObject2).append(paramCard);
          paramCard = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/svip_" + i2 + ".png";
          break;
        }
        label658:
        if (paramBoolean2)
        {
          i2 = paramCard.getVipLevel(EVIPSPEC.E_SP_QQVIP);
          if (i2 < 1)
          {
            i2 = 1;
            label681:
            if ((paramCard == null) || (paramCard.iQQVipType != 1)) {
              break label755;
            }
            if (i3 == 0) {
              break label747;
            }
          }
          label747:
          for (paramCard = "V";; paramCard = "BV")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/year_vip_" + i2 + ".png";
            break;
            break label681;
          }
          label755:
          if (i3 != 0) {}
          for (paramCard = "v";; paramCard = "Bv")
          {
            ((StringBuffer)localObject2).append(paramCard);
            paramCard = "https://i.gtimg.cn/club/mobile/profile/vipiconnew/android/vip_" + i2 + ".png";
            break;
          }
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {
          if (i3 == 0) {
            break label861;
          }
        }
        label861:
        for (paramCard = "N";; paramCard = "BN")
        {
          ((StringBuffer)localObject2).append(paramCard);
          i2 = i1;
          paramCard = null;
          i1 = i2;
          break;
        }
        label869:
        i3 = 2130840538;
        break label360;
        label877:
        d1 = 67.0D * (i3 / 27.0D);
        break label410;
        label893:
        if (("V".equalsIgnoreCase(str)) && (!TextUtils.isEmpty(paramCard)))
        {
          paramString = getResources();
          if (str.equals("V"))
          {
            i3 = 2130840542;
            localDrawable = paramString.getDrawable(i3);
            paramString = URLDrawable.getDrawable(paramCard, localDrawable, localDrawable);
            i3 = localDrawable.getIntrinsicHeight();
            if (!str.equals("V")) {
              break label1008;
            }
          }
          for (d1 = 76.0D * (i3 / 26.0D);; d1 = 58.0D * (i3 / 26.0D))
          {
            paramString.setBounds(0, 0, (int)d1, i3);
            break;
            i3 = 2130840539;
            break label934;
          }
        }
        label934:
        label1008:
        if ("N".equals(str))
        {
          paramString = ((Resources)localObject2).getDrawable(2130840530);
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
        }
        else if ("B".equals(str))
        {
          paramString = ((Resources)localObject2).getDrawable(2130840540);
          paramString.setBounds(0, 0, (int)(10.0F * this.jdField_c_of_type_Float), paramString.getIntrinsicHeight());
        }
      }
      label1110:
      paramTextView.setText(localSpannableString);
      return i1;
      label1119:
      i1 = i2;
    }
  }
  
  private int a(List paramList, String paramString)
  {
    if (paramList == null) {
      return -1;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.equals(paramString)) {
        return paramList.indexOf(str);
      }
    }
    return -1;
  }
  
  private View a(LayoutInflater paramLayoutInflater, View paramView, ProfileActivity.CardContactInfo paramCardContactInfo, String paramString)
  {
    if (paramCardContactInfo == null) {
      return paramView;
    }
    Object localObject = paramView;
    if (paramView == null) {
      localObject = (LinearLayout)paramLayoutInflater.inflate(2130903993, null);
    }
    paramLayoutInflater = (TextView)((View)localObject).findViewById(2131297001);
    paramView = (TextView)((View)localObject).findViewById(2131297409);
    ImageView localImageView = (ImageView)((View)localObject).findViewById(2131298739);
    if (localImageView.getVisibility() != 0) {
      localImageView.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 33)
    {
      paramLayoutInflater.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString);
      paramView.setText(paramCardContactInfo.c);
      ((View)localObject).setTag(new DataTag(4, paramCardContactInfo));
      ((View)localObject).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      paramCardContactInfo = new StringBuilder();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 33) {
        break label261;
      }
      paramCardContactInfo.append(a(2131361994));
    }
    for (;;)
    {
      paramCardContactInfo.append(":").append(paramView.getText());
      ((View)localObject).setContentDescription(paramCardContactInfo.toString());
      a(paramString, paramLayoutInflater, paramView, localImageView);
      return localObject;
      paramLayoutInflater.setText(2131368200);
      paramView.setText(paramCardContactInfo.jdField_a_of_type_JavaLangString + " " + paramCardContactInfo.c);
      break;
      label261:
      paramCardContactInfo.append(a(2131361993));
    }
  }
  
  private String a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {
      return a(2131368211);
    }
    if ("map_key_circlenick".equals(paramString)) {
      return a(2131368213);
    }
    if ("map_key_remark".equals(paramString)) {
      return a(2131368212);
    }
    if ("map_key_recommendname".equals(paramString)) {
      return a(2131368215);
    }
    if ("map_key_troopnick".equals(paramString)) {
      return a(2131368216);
    }
    return null;
  }
  
  private List a(HashMap paramHashMap, List paramList, String[] paramArrayOfString, int paramInt)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("Argument Error");
    }
    ArrayList localArrayList = new ArrayList();
    int i1;
    int i2;
    label38:
    String str;
    if ((paramHashMap == null) || (paramArrayOfString == null))
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        break label243;
      }
      str = paramArrayOfString[i2];
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap == null) || (!"map_key_sig".equals(str)) || (!this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.containsKey("map_key_sign"))) {
        break label110;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label38;
      i1 = paramArrayOfString.length;
      break;
      label110:
      View localView;
      if ("map_key_phone_".equals(str))
      {
        int i3 = 0;
        while (i3 < paramInt)
        {
          localView = (View)paramHashMap.get("map_key_phone_" + String.valueOf(i3));
          if (localView != null)
          {
            paramList.add(str);
            localView.setContentDescription(str);
            localArrayList.add(localView);
          }
          i3 += 1;
        }
      }
      else
      {
        localView = (View)paramHashMap.get(str);
        if (localView != null)
        {
          paramList.add(str);
          localView.setContentDescription(str);
          localArrayList.add(localView);
        }
      }
    }
    label243:
    return localArrayList;
  }
  
  private void a(Context paramContext)
  {
    int i1 = 1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setContentDescription("SL_container_for_qzone");
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setContentDescription("SL_container_for_qq");
    this.jdField_a_of_type_JavaUtilList = Arrays.asList(jdField_a_of_type_ArrayOfJavaLangString);
    this.jdField_b_of_type_JavaUtilList = Arrays.asList(jdField_b_of_type_ArrayOfJavaLangString);
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
    while (i1 == 0)
    {
      a(this.jdField_b_of_type_AndroidWidgetLinearLayout, 2130837951);
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout, 2130837951);
      return;
      i1 = 0;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(0);
  }
  
  private void a(View paramView)
  {
    ColorDrawable localColorDrawable = (ColorDrawable)paramView.getBackground();
    GradientDrawable localGradientDrawable;
    if (localColorDrawable != null)
    {
      localGradientDrawable = (GradientDrawable)this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840500);
      localGradientDrawable.setColor(localColorDrawable.getColor());
      if (Build.VERSION.SDK_INT >= 16) {
        paramView.setBackground(localGradientDrawable);
      }
    }
    else
    {
      return;
    }
    paramView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void a(View paramView, int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt);
    Rect localRect = new Rect();
    localDrawable.getPadding(localRect);
    paramInt = paramView.getPaddingTop();
    int i1 = localRect.top;
    int i2 = paramView.getPaddingLeft();
    int i3 = localRect.left;
    int i4 = paramView.getPaddingRight();
    int i5 = localRect.right;
    int i6 = paramView.getPaddingBottom();
    int i7 = localRect.bottom;
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.setBackground(localDrawable);
    }
    for (;;)
    {
      paramView.setPadding(i2 + i3, paramInt + i1, i4 + i5, i7 + i6);
      return;
      paramView.setBackgroundDrawable(localDrawable);
    }
  }
  
  private void a(ViewGroup paramViewGroup, Card paramCard, List paramList)
  {
    paramViewGroup.removeAllViews();
    int i3 = paramList.size();
    int i1 = SizeMeasure.e(getContext()) - (int)(128.0F * this.jdField_c_of_type_Float) - this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131493015);
    Object localObject1;
    int i2;
    label87:
    ProfileBusiEntry localProfileBusiEntry;
    if (i3 <= 5)
    {
      i1 /= 5;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = null;
      i2 = 0;
      if (i2 >= i3) {
        break label858;
      }
      localProfileBusiEntry = (ProfileBusiEntry)paramList.get(i2);
      if (localProfileBusiEntry != null) {
        break label136;
      }
    }
    label136:
    while (((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileGameView)) && (localProfileBusiEntry != null) && (localProfileBusiEntry.jdField_a_of_type_Int == 1))
    {
      i2 += 1;
      break label87;
      i1 = i1 * 146 / 640;
      break;
    }
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903988, null);
    Object localObject3 = (ImageView)localView.findViewById(2131299367);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130840501);
      label206:
      Object localObject4 = localProfileBusiEntry.jdField_a_of_type_JavaLangString;
      String str = localProfileBusiEntry.b;
      localObject1 = localProfileBusiEntry.c;
      if ((localObject1 != null) && (5 < ((String)localObject1).length()))
      {
        localObject1 = ((String)localObject1).substring(0, 5) + "...";
        try
        {
          label269:
          localObject4 = new URL((String)localObject4);
          localObject4 = URLDrawable.getDrawable(new URL("popularize", ((URL)localObject4).getAuthority(), ((URL)localObject4).getFile()), (Drawable)localObject2, (Drawable)localObject2);
          if (localObject4 != null)
          {
            if (localProfileBusiEntry.jdField_a_of_type_Int == 6) {
              ((ImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            ((ImageView)localObject3).setImageDrawable((Drawable)localObject4);
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localMalformedURLException.printStackTrace();
          }
          localObject1 = new DataTag(19, new Object[] { Boolean.valueOf(paramCard.isOpenRecentPlayingGamesByNative()), paramCard.strProfileUrl, localProfileBusiEntry });
          if (this.jdField_c_of_type_Boolean) {
            break label878;
          }
        }
        localObject3 = (TextView)localView.findViewById(2131299368);
        ((TextView)localObject3).setText(str);
        localObject4 = (TextView)localView.findViewById(2131299719);
        ((TextView)localObject4).setText((CharSequence)localObject1);
        localView.setContentDescription(str + (String)localObject1);
        a("map_key_third_part_app_entrance", (TextView)localObject4, (TextView)localObject3, null);
        switch (localProfileBusiEntry.jdField_a_of_type_Int)
        {
        default: 
          localObject1 = new DataTag(27, localProfileBusiEntry);
        }
      }
    }
    label858:
    label878:
    for (;;)
    {
      localView.setTag(localObject1);
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramViewGroup.addView(localView, new LinearLayout.LayoutParams(i1, -2));
      localObject1 = localObject2;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004315 ", "0X8004315 ", 0, 0, "", "", "", "");
      this.jdField_c_of_type_Boolean = true;
      continue;
      localObject1 = new DataTag(22, localProfileBusiEntry);
      if (!this.jdField_d_of_type_Boolean)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004314", "0X8004314", 0, 0, "", "", "", "");
        this.jdField_d_of_type_Boolean = true;
        continue;
        localObject1 = new DataTag(21, localProfileBusiEntry);
        if (!this.jdField_b_of_type_Boolean)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004316", "0X8004316", 0, 0, "", "", "", "");
          this.jdField_b_of_type_Boolean = true;
          continue;
          localObject1 = new DataTag(28, localProfileBusiEntry);
          if (!this.jdField_a_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004300", "0X8004300", 0, 0, "", "", "", "");
            this.jdField_a_of_type_Boolean = true;
            continue;
            localObject1 = new DataTag(33, localProfileBusiEntry);
            continue;
            localObject1 = new DataTag(30, localProfileBusiEntry);
            continue;
            return;
            break label269;
            localObject2 = localObject1;
            break label206;
          }
          continue;
        }
        continue;
      }
    }
  }
  
  private void a(ViewGroup paramViewGroup, List paramList)
  {
    int i1 = 0;
    View localView;
    while (i1 < paramList.size())
    {
      localView = (View)paramList.get(i1);
      if (localView != null)
      {
        paramViewGroup.addView(localView);
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903992, null);
        localView.setContentDescription("card_content_description");
        paramViewGroup.addView(localView);
      }
      i1 += 1;
    }
    paramList = paramViewGroup.getChildAt(paramViewGroup.getChildCount() - 1);
    if ((paramList != null) && ("card_content_description".equals(paramList.getContentDescription()))) {
      paramViewGroup.removeView(paramList);
    }
    int i2 = (int)(12.0F * this.jdField_c_of_type_Float);
    if (paramViewGroup.getChildCount() > 0)
    {
      paramList = paramViewGroup.getChildAt(0);
      if ((paramList != null) && (paramList.getPaddingTop() < i2)) {
        paramList.setPadding(paramList.getPaddingLeft(), paramList.getPaddingTop() + i2, paramList.getPaddingRight(), paramList.getPaddingBottom());
      }
      paramList = paramViewGroup.getChildAt(paramViewGroup.getChildCount() - 1);
      if ((paramList != null) && (paramList.getPaddingBottom() < i2)) {
        paramList.setPadding(paramList.getPaddingLeft(), paramList.getPaddingTop(), paramList.getPaddingRight(), paramList.getPaddingBottom() + i2);
      }
    }
    i1 = 0;
    while (i1 < paramViewGroup.getChildCount())
    {
      paramList = paramViewGroup.getChildAt(i1);
      if ((paramList != null) && (paramList.getContentDescription() != null) && ("map_key_account_info".equals(paramList.getContentDescription())))
      {
        paramList.setPadding(paramList.getPaddingLeft(), 0, paramList.getPaddingRight(), paramList.getPaddingBottom());
        localView = paramList.findViewById(2131300410);
        if ((localView != null) && (localView.getPaddingTop() < i2)) {
          localView.setPadding(paramList.getPaddingLeft(), localView.getPaddingTop() + i2, localView.getPaddingRight(), localView.getPaddingBottom());
        }
      }
      i1 += 1;
    }
  }
  
  private void a(String paramString, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.size() > 0))
      {
        this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.h));
        ProfileCardTemplate.a(paramTextView1, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
        ProfileCardTemplate.a(paramTextView2, "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemContentColor");
        ProfileCardTemplate.a(paramImageView, "src", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemMoreSrc");
        paramImageView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(paramString, String.valueOf(0));
      if (paramTextView1 != null) {
        paramTextView1.setTextColor(getResources().getColorStateList(2131427972));
      }
      if (paramTextView2 != null) {
        paramTextView2.setTextColor(getResources().getColorStateList(2131427934));
      }
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130838068);
        paramImageView.setVisibility(8);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateItemTheme exception msg=" + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  private void a(List paramList1, List paramList2)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    View[] arrayOfView1 = new View[jdField_a_of_type_ArrayOfJavaLangString.length];
    View[] arrayOfView2 = new View[jdField_b_of_type_ArrayOfJavaLangString.length];
    ArrayList localArrayList = new ArrayList();
    a(paramList1, paramList2, arrayOfView1, arrayOfView2, localArrayList);
    a(this.jdField_b_of_type_AndroidWidgetLinearLayout, Arrays.asList(arrayOfView1));
    a(this.jdField_a_of_type_AndroidWidgetLinearLayout, Arrays.asList(arrayOfView2));
    a(this, localArrayList);
    paramList1 = new LinearLayout.LayoutParams(-1, -2);
    paramList1.topMargin = ((int)(this.jdField_c_of_type_Float * 32.0F));
    paramList1.bottomMargin = ((int)(this.jdField_c_of_type_Float * 32.0F));
    paramList2 = new LinearLayout.LayoutParams(-1, -2);
    paramList2.topMargin = ((int)(22.0F * this.jdField_c_of_type_Float));
    addView(this.jdField_b_of_type_AndroidWidgetLinearLayout, paramList2);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramList1);
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) && (getVisibility() != 0)) {
      setVisibility(0);
    }
  }
  
  private void a(List paramList1, List paramList2, View[] paramArrayOfView1, View[] paramArrayOfView2, List paramList3)
  {
    if ((paramList1 == null) || (paramArrayOfView1 == null) || (paramArrayOfView2 == null) || (paramList3 == null)) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        View localView = (View)localIterator.next();
        String str = (String)paramList2.get(paramList1.indexOf(localView));
        int i1;
        if (this.jdField_a_of_type_JavaUtilList.contains(str))
        {
          i1 = a(this.jdField_a_of_type_JavaUtilList, str);
          if (i1 != -1) {
            paramArrayOfView1[i1] = localView;
          }
        }
        else if (this.jdField_b_of_type_JavaUtilList.contains(str))
        {
          i1 = a(this.jdField_b_of_type_JavaUtilList, str);
          if (i1 != -1) {
            paramArrayOfView2[i1] = localView;
          }
        }
        else
        {
          paramList3.add(localView);
        }
      }
    }
  }
  
  private boolean a()
  {
    HashMap localHashMap;
    int i2;
    label40:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.size();
      localHashMap = new HashMap();
      i2 = 0;
      if (i2 >= i1) {
        break label227;
      }
      localObject = (MQQName)this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqUnifiednameMQQProfileName.jdField_a_of_type_JavaUtilList.get(i2);
      if (localObject != null) {
        break label83;
      }
    }
    for (;;)
    {
      i2 += 1;
      break label40;
      i1 = 0;
      break;
      label83:
      switch (((MQQName)localObject).jdField_a_of_type_Int)
      {
      default: 
        break;
      case 0: 
        localHashMap.put("map_key_nick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 2: 
        localHashMap.put("map_key_circlenick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 1: 
        localHashMap.put("map_key_troopnick", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 5: 
        localHashMap.put("map_key_recommendname", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 4: 
        localHashMap.put("map_key_remark", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
        break;
      case 3: 
        localHashMap.put("map_key_phone_", ((MQQName)localObject).jdField_a_of_type_JavaLangString);
      }
    }
    label227:
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_d_of_type_ArrayOfJavaLangString.length)
    {
      localObject = (String)localHashMap.get(this.jdField_d_of_type_ArrayOfJavaLangString[i1]);
      if ((a(this.jdField_d_of_type_ArrayOfJavaLangString[i1], (String)localObject)) || (bool)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    return bool;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2;
    if (paramInt != 0)
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qrcode") != null) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        return bool2;
      }
    }
    Object localObject1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qrcode");
    if (localObject1 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903993, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qrcode", localObject1);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      Object localObject2 = (TextView)((View)localObject1).findViewById(2131297001);
      ((TextView)localObject2).setText(2131368205);
      TextView localTextView = (TextView)((View)localObject1).findViewById(2131297409);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130840487, 0, 0, 0);
      ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131298739);
      localImageView.setVisibility(0);
      ((View)localObject1).setTag(new DataTag(13, null));
      ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      ((View)localObject1).setContentDescription(a(2131368205));
      a("map_key_qrcode", (TextView)localObject2, null, localImageView);
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate == null) {
        break;
      }
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap == null) {
        break;
      }
      bool2 = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.size() <= 0) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.jdField_b_of_type_JavaUtilHashMap.get("commonQrCodeSrc");
      bool2 = bool1;
      if (!(localObject1 instanceof Drawable)) {
        break;
      }
      localObject1 = (Drawable)localObject1;
      localObject2 = getResources().getDrawable(2130840487);
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight());
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return bool1;
    }
  }
  
  private boolean a(Card paramCard)
  {
    boolean bool2;
    if ((paramCard == null) || (!paramCard.showLightalk) || (StringUtil.b(paramCard.lightalkNick)))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_lightalk");
      bool2 = false;
      return bool2;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_lightalk");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903993, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_lightalk", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297001);
      TextView localTextView2 = (TextView)localView.findViewById(2131297409);
      ImageView localImageView = (ImageView)localView.findViewById(2131298739);
      localTextView1.setText(2131369906);
      Drawable localDrawable = getContext().getResources().getDrawable(2130840483);
      localView.setClickable(true);
      localView.setContentDescription("来电帐号" + paramCard.lightalkNick + "点击进入");
      localView.setTag(new DataTag(35, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localImageView.setVisibility(0);
      localTextView2.setVisibility(0);
      localTextView2.setText(paramCard.lightalkNick);
      localTextView2.setSingleLine(true);
      localTextView2.setEllipsize(TextUtils.TruncateAt.END);
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      localTextView2.setCompoundDrawablePadding(ProfileCardUtil.a(getContext(), 6));
      a("map_key_lightalk", localTextView1, localTextView2, localImageView);
      bool2 = bool1;
      if (this.e) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005109", "0X8005109", 0, 0, "", "", "", "");
      return bool1;
    }
  }
  
  private boolean a(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowPhoto()) || (!paramCard.hasGotPhotoUrl()))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone_photo") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_photo");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903997, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_photo", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      String str1 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      List localList = paramCard.getQZonePhotoList();
      int i1 = 0;
      if (i1 < 3)
      {
        ImageView localImageView = (ImageView)localView.findViewById(2131300407 + i1);
        if ((localList != null) && (localList.size() > i1))
        {
          paramCard = (String)localList.get(i1);
          label172:
          if ((!TextUtils.isEmpty(paramCard)) || (localImageView == null)) {
            break label203;
          }
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          i1 += 1;
          break;
          paramCard = null;
          break label172;
          label203:
          if (localImageView != null)
          {
            String str2 = AppConstants.bV + str1 + "_" + MD5.toMD5(paramCard);
            if (this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
              this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(getResources().getColor(2131427451));
            }
            try
            {
              paramCard = URLDrawable.getDrawable(new URL("profile_img_icon", paramCard, str2), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable);
              localImageView.setVisibility(0);
              localImageView.setImageDrawable(paramCard);
            }
            catch (MalformedURLException paramCard)
            {
              localImageView.setVisibility(8);
            }
            if (QLog.isColorLevel()) {
              QLog.e("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
            }
          }
        }
      }
      localView.setTag(new DataTag(6, null));
      localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      localView.setContentDescription(a(2131361992));
      a("map_key_qzone_photo", (TextView)localView.findViewById(2131300404), null, (ImageView)localView.findViewById(2131300405));
      return paramBoolean;
    }
  }
  
  private boolean a(RichStatus paramRichStatus)
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramRichStatus == null) || (Arrays.equals(paramRichStatus.a(), RichStatus.a().a())))) {
      return (View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_sig") != null;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_sig");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903998, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_sig", localView);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297001);
      TextView localTextView2 = (TextView)localView.findViewById(2131297409);
      ImageView localImageView = (ImageView)localView.findViewById(2131298739);
      localTextView1.setText(2131368198);
      StatusManager localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
      Resources localResources = getResources();
      if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
      {
        ProfileCardUtil.a(localResources, localView, localStatusManager, paramRichStatus, bool2);
        if ((paramRichStatus == null) || (TextUtils.isEmpty(paramRichStatus.c))) {
          break label308;
        }
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
        label223:
        if ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))) {
          break label316;
        }
        localImageView.setVisibility(0);
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      for (;;)
      {
        localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        a("map_key_sig", localTextView1, localTextView2, localImageView);
        return bool1;
        bool2 = false;
        break;
        label308:
        this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
        break label223;
        label316:
        localImageView.setVisibility(8);
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if ("map_key_nick".equals(paramString)) {}
    while (("map_key_circlenick".equals(paramString)) || ("map_key_remark".equals(paramString)) || ("map_key_recommendname".equals(paramString)) || ("map_key_troopnick".equals(paramString))) {
      return true;
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (!a(paramString1)) {
      return false;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString1) != null) {}
      for (bool = true;; bool = false) {
        return bool;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903993, null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297001);
      localTextView1.setText(a(paramString1));
      TextView localTextView2 = (TextView)localView.findViewById(2131297409);
      localTextView2.setText(paramString2);
      localView.setTag(new DataTag(11, paramString2));
      localView.setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
      ImageView localImageView = (ImageView)localView.findViewById(2131298739);
      if (localImageView.getVisibility() != 4) {
        localImageView.setVisibility(4);
      }
      localView.setContentDescription(a(paramString1) + ":" + paramString2);
      a(paramString1, localTextView1, localTextView2, localImageView);
      return bool;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if ((ProfileActivity.AllInOne.h(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (ProfileActivity.AllInOne.b(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)))
    {
      label40:
      Object localObject;
      View localView;
      ProfileActivity.CardContactInfo localCardContactInfo;
      if (paramArrayList != null)
      {
        i1 = paramArrayList.size();
        i2 = 0;
        bool = false;
        if (i2 >= i1) {
          break label177;
        }
        localObject = "map_key_phone_" + String.valueOf(i2);
        localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        localCardContactInfo = (ProfileActivity.CardContactInfo)paramArrayList.get(i2);
        if (localCardContactInfo != null) {
          break label143;
        }
        localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(localObject);
        if ((!bool) && (localObject == null)) {
          break label137;
        }
        bool = true;
      }
      for (;;)
      {
        i2 += 1;
        break label40;
        i1 = 0;
        break;
        label137:
        bool = false;
        continue;
        label143:
        localView = a(this.jdField_a_of_type_AndroidViewLayoutInflater, localView, localCardContactInfo, (String)localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localView);
        bool = true;
      }
      label177:
      int i2 = i1;
      if (i2 < this.jdField_b_of_type_Int)
      {
        paramArrayList = "map_key_phone_" + String.valueOf(i2);
        paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
        if ((bool) || (paramArrayList != null)) {}
        for (bool = true;; bool = false)
        {
          i2 += 1;
          break;
        }
      }
      this.jdField_b_of_type_Int = i1;
      return bool;
    }
    int i1 = 0;
    boolean bool = false;
    if (i1 < this.jdField_b_of_type_Int)
    {
      paramArrayList = "map_key_phone_" + String.valueOf(i1);
      paramArrayList = (View)this.jdField_a_of_type_JavaUtilHashMap.remove(paramArrayList);
      if ((bool) || (paramArrayList != null)) {}
      for (bool = true;; bool = false)
      {
        i1 += 1;
        break;
      }
    }
    this.jdField_b_of_type_Int = 0;
    return bool;
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initCommonWidth");
    }
    Resources localResources = getResources();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = localDisplayMetrics.density;
    this.jdField_a_of_type_Float = Math.min(SizeMeasure.e(paramContext), localDisplayMetrics.heightPixels);
    int i1 = localResources.getDimensionPixelSize(2131493031);
    int i2 = localResources.getDimensionPixelSize(2131493015);
    int i3 = localResources.getDimensionPixelSize(2131493011);
    float f1 = this.jdField_c_of_type_Float;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float - i2 - 12.0F * f1 - i3 * 2 - i1 * 2);
    this.jdField_a_of_type_Int = 4;
    for (i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.jdField_c_of_type_Float); (i1 > this.jdField_b_of_type_Float) && (this.jdField_a_of_type_Int >= 1); i1 = (int)((this.jdField_a_of_type_Int * 44 + (this.jdField_a_of_type_Int - 1) * 10) * this.jdField_c_of_type_Float)) {
      this.jdField_a_of_type_Int -= 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "initInfoCardCommonLayout|mMaxGameLogoNum = " + this.jdField_a_of_type_Int);
    }
    a(paramContext);
  }
  
  private boolean b(Card paramCard)
  {
    if (paramCard == null) {
      return false;
    }
    boolean bool2 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
    boolean bool3 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool4 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERQQ);
    int i1;
    if ((!paramCard.isGreenDiamond) && (!paramCard.isRedDiamond) && (!paramCard.isYellowDiamond) && (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) && (!bool2) && (!bool3) && (!bool4))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_diamond") != null) {}
      for (i1 = 1;; i1 = 0) {
        return 0x0 | i1;
      }
    }
    View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_diamond");
    if (localView1 == null)
    {
      localView1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903994, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_diamond", localView1);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      TextView localTextView = (TextView)localView1.findViewById(2131297001);
      localTextView.setText(2131368202);
      ImageView localImageView2 = (ImageView)localView1.findViewById(2131300394);
      ImageView localImageView3 = (ImageView)localView1.findViewById(2131300393);
      RelativeLayout localRelativeLayout = (RelativeLayout)localView1.findViewById(2131300392);
      ImageView localImageView4 = (ImageView)localView1.findViewById(2131300397);
      ImageView localImageView5 = (ImageView)localView1.findViewById(2131300396);
      View localView2 = localView1.findViewById(2131300395);
      ImageView localImageView6 = (ImageView)localView1.findViewById(2131300391);
      ImageView localImageView1 = (ImageView)localView1.findViewById(2131300398);
      ImageView localImageView7 = (ImageView)localView1.findViewById(2131300401);
      ImageView localImageView8 = (ImageView)localView1.findViewById(2131300400);
      Object localObject1 = localView1.findViewById(2131300399);
      i1 = 0;
      if (bool4) {
        i1 = paramCard.getVipLevel(EVIPSPEC.E_SP_SUPERQQ);
      }
      int i2;
      Object localObject2;
      if (i1 < 1)
      {
        i2 = 1;
        localObject2 = "https://i.gtimg.cn/club/mobile/profile/icon/qvip_profile_supperqq_" + i2 + ".png";
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label1494;
        }
        if (!bool3) {
          break label727;
        }
        localImageView6.setBackgroundResource(2130839295);
        label388:
        if (!paramCard.isSuperYellowDiamond) {
          break label817;
        }
        if (paramCard.yellowLevel != 8) {
          break label759;
        }
        localRelativeLayout.setBackgroundResource(2130839090);
        localImageView3.setVisibility(8);
        label419:
        if (!paramCard.isRedDiamond) {
          break label1006;
        }
        localImageView2.setBackgroundResource(2130839069);
        localImageView2.setImageResource(getResources().getIdentifier("qb_diamond_red_lv" + paramCard.redLevel, "drawable", "com.tencent.minihd.qq"));
        label475:
        localView2.setVisibility(0);
        if (!paramCard.isSuperGreenDiamond) {
          break label1088;
        }
        localImageView4.setBackgroundResource(2130839068);
        localImageView5.setVisibility(8);
        if ((paramCard.greenLevel >= 9) || (paramCard.greenLevel <= 0)) {
          break label1079;
        }
        if (paramCard.greenLevel == 8)
        {
          localImageView5.setBackgroundResource(2130839043);
          localImageView5.setVisibility(0);
        }
        localImageView4.setImageResource(getResources().getIdentifier("qb_diamond_green_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
        label583:
        ((View)localObject1).setVisibility(8);
        if (!bool4) {
          break label1478;
        }
        paramCard = getResources().getDrawable(2130840879);
        localObject2 = URLDrawable.getDrawable((String)localObject2, paramCard, paramCard);
        ((Drawable)localObject2).setBounds(0, 0, paramCard.getIntrinsicWidth(), paramCard.getIntrinsicHeight());
        localImageView1.setImageDrawable((Drawable)localObject2);
        localImageView1.setVisibility(0);
        label643:
        if (((View)localObject1).getVisibility() == 0) {
          ((View)localObject1).bringToFront();
        }
      }
      for (;;)
      {
        localView1.setTag(new DataTag(26, null));
        localView1.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramCard = (ImageView)localView1.findViewById(2131298739);
        paramCard.setVisibility(0);
        a("map_key_diamond", localTextView, null, paramCard);
        return bool1;
        i2 = i1;
        if (i1 <= 8) {
          break;
        }
        i2 = 8;
        break;
        label727:
        if (bool2)
        {
          localImageView6.setBackgroundResource(2130839560);
          break label388;
        }
        localImageView6.setBackgroundResource(2130839561);
        localImageView6.bringToFront();
        break label388;
        label759:
        localRelativeLayout.setBackgroundResource(2130839089);
        localImageView3.setVisibility(0);
        localImageView3.setBackgroundResource(getResources().getIdentifier("qb_diamond_yellow_lv" + paramCard.yellowLevel, "drawable", "com.tencent.minihd.qq"));
        break label419;
        label817:
        if (paramCard.isYellowDiamond)
        {
          if (paramCard.yellowLevel == 8)
          {
            localRelativeLayout.setBackgroundResource(2130839080);
            localImageView3.setVisibility(8);
            break label419;
          }
          localImageView3.setVisibility(0);
          localRelativeLayout.setBackgroundDrawable(null);
          localImageView3.setBackgroundResource(2130839079);
          localImageView3.setImageResource(getResources().getIdentifier("qb_diamond_yellow_lv" + paramCard.yellowLevel, "drawable", "com.tencent.minihd.qq"));
          break label419;
        }
        localImageView3.setBackgroundResource(2130839056);
        if (paramCard.yellowLevel == 8)
        {
          localRelativeLayout.setBackgroundResource(2130839057);
          localImageView3.setVisibility(8);
        }
        for (;;)
        {
          localRelativeLayout.bringToFront();
          break;
          if (paramCard.yellowLevel > 0) {
            localImageView3.setImageResource(getResources().getIdentifier("qb_diamond_gray_lv" + paramCard.yellowLevel, "drawable", "com.tencent.minihd.qq"));
          }
        }
        label1006:
        localImageView2.setBackgroundResource(2130839055);
        if ((paramCard.redLevel < 9) && (paramCard.redLevel > 0)) {
          localImageView2.setImageResource(getResources().getIdentifier("qb_diamond_gray_lv" + paramCard.redLevel, "drawable", "com.tencent.minihd.qq"));
        }
        localImageView2.bringToFront();
        break label475;
        label1079:
        localImageView4.setImageDrawable(null);
        break label583;
        label1088:
        if (paramCard.isGreenDiamond)
        {
          localImageView4.setBackgroundResource(2130839058);
          localImageView7.setBackgroundResource(2130839046);
          localImageView5.setVisibility(8);
          localImageView8.setVisibility(8);
          if ((paramCard.greenLevel < 9) && (paramCard.greenLevel > 0))
          {
            if (paramCard.greenLevel == 8)
            {
              localImageView5.setBackgroundResource(2130839043);
              localImageView8.setBackgroundResource(2130839044);
              localImageView5.setVisibility(0);
              localImageView8.setVisibility(0);
            }
            localImageView4.setImageResource(getResources().getIdentifier("qb_diamond_green_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
            localImageView7.setImageResource(getResources().getIdentifier("qb_diamond_gray_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
          }
          for (;;)
          {
            ((View)localObject1).setVisibility(0);
            break;
            localImageView4.setImageDrawable(null);
            localImageView7.setImageDrawable(null);
          }
        }
        localImageView4.setBackgroundResource(2130839045);
        localImageView7.setBackgroundResource(2130839046);
        localImageView5.setVisibility(8);
        localImageView8.setVisibility(8);
        if ((paramCard.greenLevel < 9) && (paramCard.greenLevel > 0))
        {
          if (paramCard.greenLevel == 8)
          {
            localImageView5.setBackgroundResource(2130839044);
            localImageView8.setBackgroundResource(2130839044);
            localImageView5.setVisibility(0);
            localImageView8.setVisibility(0);
          }
          localImageView4.setImageResource(getResources().getIdentifier("qb_diamond_gray_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
          localImageView7.setImageResource(getResources().getIdentifier("qb_diamond_gray_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
        }
        for (;;)
        {
          ((View)localObject1).setVisibility(0);
          localView2.bringToFront();
          break;
          localImageView4.setImageDrawable(null);
          localImageView7.setImageDrawable(null);
        }
        label1478:
        localImageView1.setBackgroundResource(2130840880);
        localImageView1.bringToFront();
        break label643;
        label1494:
        if (bool3)
        {
          localImageView6.setBackgroundResource(2130839295);
          localImageView6.setVisibility(0);
          label1513:
          if (!paramCard.isRedDiamond) {
            break label1822;
          }
          localImageView2.setVisibility(0);
          localImageView2.setBackgroundResource(2130839069);
          localImageView2.setImageResource(getResources().getIdentifier("qb_diamond_red_lv" + paramCard.redLevel, "drawable", "com.tencent.minihd.qq"));
          if (!paramCard.isSuperYellowDiamond) {
            break label1890;
          }
          localRelativeLayout.setVisibility(0);
          if (paramCard.yellowLevel != 8) {
            break label1832;
          }
          localRelativeLayout.setBackgroundResource(2130839090);
          localImageView3.setVisibility(8);
          ((View)localObject1).setVisibility(8);
          if (!paramCard.isGreenDiamond) {
            break label2024;
          }
          if (!paramCard.isSuperGreenDiamond) {
            break label2004;
          }
          localImageView4.setBackgroundResource(2130839068);
          label1641:
          localImageView5.setVisibility(8);
          if ((paramCard.greenLevel >= 9) || (paramCard.greenLevel <= 0)) {
            break label2015;
          }
          if (paramCard.greenLevel == 8)
          {
            localImageView5.setBackgroundResource(2130839043);
            localImageView5.setVisibility(0);
          }
          localImageView4.setImageResource(getResources().getIdentifier("qb_diamond_green_lv" + paramCard.greenLevel, "drawable", "com.tencent.minihd.qq"));
          localView2.setVisibility(0);
        }
        for (;;)
        {
          label1575:
          label1612:
          if (!bool4) {
            break label2034;
          }
          label1728:
          paramCard = getResources().getDrawable(2130840879);
          localObject1 = URLDrawable.getDrawable((String)localObject2, paramCard, paramCard);
          ((Drawable)localObject1).setBounds(0, 0, paramCard.getIntrinsicWidth(), paramCard.getIntrinsicHeight());
          localImageView1.setImageDrawable((Drawable)localObject1);
          localImageView1.setVisibility(0);
          break;
          if (bool2)
          {
            localImageView6.setBackgroundResource(2130839560);
            localImageView6.setVisibility(0);
            break label1513;
          }
          localImageView6.setVisibility(8);
          break label1513;
          label1822:
          localImageView2.setVisibility(8);
          break label1575;
          label1832:
          localRelativeLayout.setBackgroundResource(2130839089);
          localImageView3.setVisibility(0);
          localImageView3.setBackgroundResource(getResources().getIdentifier("qb_diamond_yellow_lv" + paramCard.yellowLevel, "drawable", "com.tencent.minihd.qq"));
          break label1612;
          label1890:
          if (paramCard.isYellowDiamond)
          {
            localRelativeLayout.setVisibility(0);
            if (paramCard.yellowLevel == 8)
            {
              localRelativeLayout.setBackgroundResource(2130839080);
              localImageView3.setVisibility(8);
              break label1612;
            }
            localImageView3.setVisibility(0);
            localRelativeLayout.setBackgroundDrawable(null);
            localImageView3.setBackgroundResource(2130839079);
            localImageView3.setImageResource(getResources().getIdentifier("qb_diamond_yellow_lv" + paramCard.yellowLevel, "drawable", "com.tencent.minihd.qq"));
            break label1612;
          }
          localRelativeLayout.setVisibility(8);
          break label1612;
          label2004:
          localImageView4.setBackgroundResource(2130839058);
          break label1641;
          label2015:
          localImageView4.setImageDrawable(null);
          break label1728;
          label2024:
          localView2.setVisibility(8);
        }
        label2034:
        localImageView1.setVisibility(8);
      }
    }
  }
  
  private boolean b(Card paramCard, boolean paramBoolean)
  {
    if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (paramCard == null) || (!paramCard.isShowFeeds()))
    {
      if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qzone_feed") != null) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903996, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qzone_feed", localView);
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297001);
      TextView localTextView2 = (TextView)localView.findViewById(2131297409);
      ImageView localImageView = (ImageView)localView.findViewById(2131298739);
      localTextView1.setText(a(2131368201));
      if (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) {
        localTextView2.setText(paramCard.strQzoneFeedsDesc);
      }
      for (;;)
      {
        localView.setTag(new DataTag(5, null));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setContentDescription(a(2131361990));
        a("map_key_qzone_feed", localTextView1, localTextView2, localImageView);
        return paramBoolean;
        if (TextUtils.isEmpty(paramCard.strSpaceName)) {
          break;
        }
        localTextView2.setText(paramCard.strSpaceName);
      }
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
      if ((paramCard == null) || (paramCard.length() == 0)) {
        paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
      }
      for (;;)
      {
        Object localObject;
        if (paramCard != null)
        {
          localObject = paramCard;
          if (paramCard.length() != 0) {}
        }
        else
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        }
        localTextView2.setText((String)localObject + a(2131368259));
        break;
      }
    }
  }
  
  private boolean c(Card paramCard)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool5;
    boolean bool6;
    boolean bool1;
    if (paramCard != null)
    {
      bool5 = paramCard.isVipOpen(EVIPSPEC.E_SP_QQVIP);
      bool6 = paramCard.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      if ((paramCard.lUserFlag & 1L) == 1L)
      {
        bool1 = true;
        if (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
          break label255;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
        bool2 = bool1;
        bool3 = bool6;
        bool4 = bool5;
        localObject1 = localObject2;
        if (!bool1) {
          break label1139;
        }
        bool2 = bool1;
        bool3 = bool6;
        bool4 = bool5;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(paramCard.strShowName)) {
          break label1139;
        }
        localObject1 = paramCard.strShowName;
        bool4 = bool5;
        bool3 = bool6;
      }
    }
    for (;;)
    {
      label138:
      Object localObject3;
      long l1;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        localObject3 = ((StringBuilder)localObject2).append("makeOrFrefreshAccountInfoView").append(", strShowName = ").append((String)localObject1).append(", bEnterprise = ").append(bool1).append(", lUserFlag = ");
        if (paramCard == null)
        {
          l1 = 0L;
          label198:
          ((StringBuilder)localObject3).append(l1);
          QLog.i("Q.profilecard.FrdProfileCard", 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label319;
        }
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_account_info") == null) {
          break label313;
        }
      }
      label313:
      for (int i1 = 1;; i1 = 0)
      {
        return 0x0 | i1;
        bool1 = false;
        break;
        label255:
        if ((!bool6) && (!bool5))
        {
          bool2 = bool1;
          bool3 = bool6;
          bool4 = bool5;
          localObject1 = localObject2;
          if (paramCard.iQQLevel < 0) {
            break label1139;
          }
        }
        localObject1 = "********";
        bool3 = bool6;
        bool4 = bool5;
        break label138;
        l1 = paramCard.lUserFlag;
        break label198;
      }
      label319:
      localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_account_info");
      if (localObject2 == null)
      {
        localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903999, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_account_info", localObject2);
        ((View)localObject2).setClickable(false);
      }
      for (bool2 = true;; bool2 = false)
      {
        localObject3 = ((View)localObject2).findViewById(2131300410);
        Object localObject4 = ((View)localObject3).findViewById(2131300412);
        TextView localTextView1 = (TextView)((View)localObject3).findViewById(2131297001);
        localTextView1.setText(2131368199);
        ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131298739);
        localImageView.setVisibility(0);
        TextView localTextView2 = (TextView)((View)localObject3).findViewById(2131297409);
        TextView localTextView3;
        double d1;
        if (paramCard.iQQLevel >= 0)
        {
          localTextView3 = (TextView)((View)localObject4).findViewById(2131300413);
          localTextView3.setText(ProfileCardUtil.a(getContext(), 8, paramCard.iQQLevel, true));
          localTextView3.setContentDescription(paramCard.iQQLevel + "级");
          localTextView3 = (TextView)((View)localObject4).findViewById(2131300414);
          d1 = paramCard.uAccelerateMultiple / 10.0D;
          if (d1 < 0.0D)
          {
            if ("".equals(localTextView3.getText()))
            {
              localTextView3.setText("");
              localTextView3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            ((View)localObject4).setVisibility(0);
            label578:
            a(localTextView2, bool3, bool4, (String)localObject1, paramCard);
            ((View)localObject3).setContentDescription("帐号:" + (String)localObject1);
            ((View)localObject3).setTag(new DataTag(14, localObject1));
            ((View)localObject3).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((View)localObject3).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            localObject2 = ((View)localObject2).findViewById(2131300415);
            localObject4 = (TextView)((View)localObject2).findViewById(2131300417);
            if ((bool1) || (!ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) || (TextUtils.isEmpty(paramCard.strShowName)) || (paramCard.strShowName.equals(localObject1))) {
              break label1117;
            }
            ((TextView)localObject4).setText(paramCard.strShowName);
            ((View)localObject2).setVisibility(0);
            ((View)localObject2).setTag(new DataTag(2, paramCard.strShowName));
            ((View)localObject2).setOnLongClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnLongClickListener);
            ((View)localObject2).setContentDescription("主显帐号:" + paramCard.strShowName);
            label793:
            a("map_key_account_info", localTextView1, localTextView2, localImageView);
            a("map_key_account_info", null, (TextView)localObject4, null);
            if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) || ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {
              break label1127;
            }
          }
        }
        label1117:
        label1127:
        for (i1 = 1;; i1 = 0)
        {
          if (i1 != 0) {}
          ((View)localObject3).setBackgroundResource(2130840502);
          return bool2;
          if ((!bool4) && (!bool3))
          {
            localTextView3.setText("慢速中");
            localTextView3.setTextColor(-5855578);
            localTextView3.setContentDescription("慢速中");
            break;
          }
          if ((bool4) && (!bool3))
          {
            localTextView3.setText(d1 + "倍加速中");
            localTextView3.setTextColor(-28672);
            localTextView3.setContentDescription("加速" + d1 + "倍");
            break;
          }
          if (!bool3) {
            break;
          }
          if (paramCard.getVipType(EVIPSPEC.E_SP_SUPERVIP) == 1)
          {
            localTextView3.setText(d1 + "倍极速中");
            localTextView3.setContentDescription("极速" + d1 + "倍");
          }
          for (;;)
          {
            localTextView3.setTextColor(-28672);
            break;
            localTextView3.setText(d1 + "倍高速中");
            localTextView3.setContentDescription("高速" + d1 + "倍");
          }
          ((View)localObject4).setVisibility(8);
          break label578;
          ((View)localObject2).setVisibility(8);
          break label793;
        }
      }
      label1139:
      bool1 = bool2;
    }
  }
  
  private boolean d(Card paramCard)
  {
    boolean bool = true;
    List localList;
    if (ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
      if (paramCard == null) {
        localList = null;
      }
    }
    for (;;)
    {
      if ((localList == null) || (localList.size() == 0))
      {
        if ((View)this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_third_part_app_entrance") != null) {}
        for (bool = true;; bool = false)
        {
          return bool;
          localList = paramCard.getBusiEntrys();
          break;
        }
      }
      View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_third_part_app_entrance");
      if (localView == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903995, null);
        this.jdField_a_of_type_JavaUtilHashMap.put("map_key_third_part_app_entrance", localView);
      }
      for (;;)
      {
        HorizontalScrollLayout localHorizontalScrollLayout = (HorizontalScrollLayout)localView.findViewById(2131300402);
        localHorizontalScrollLayout.setScreenWidth(SizeMeasure.e(getContext()) - (int)(64.0F * this.jdField_c_of_type_Float));
        a(localHorizontalScrollLayout, paramCard, localList);
        ProfileCardTemplate.a((TextView)localView.findViewById(2131297001), "color", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonItemTitleColor");
        return bool;
        bool = false;
      }
      localList = null;
    }
  }
  
  private boolean e(Card paramCard)
  {
    if ((paramCard == null) || (paramCard.lCurrentStyleId != ProfileCardTemplate.f))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_tag");
      return false;
    }
    Object localObject2 = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_tag");
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904000, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_tag", localObject1);
    }
    localObject2 = (AdaptiveLayout)((View)localObject1).findViewById(2131300418);
    int i2 = getResources().getDimensionPixelSize(2131493353);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0) {}
    for (int i1 = 8;; i1 = 7)
    {
      int i3;
      Object localObject3;
      if (this.jdField_a_of_type_ArrayOfAndroidWidgetTextView == null)
      {
        ((AdaptiveLayout)localObject2).setGap(i2, i2);
        this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[i1];
        i3 = getResources().getDimensionPixelSize(2131493347);
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131493350);
        int i4 = getResources().getDimensionPixelSize(2131493355);
        getResources().getDimensionPixelSize(2131493357);
        getResources().getDimensionPixelSize(2131493358);
        getResources().getDimensionPixelSize(2131493356);
        i2 = 0;
        if (i2 < i1)
        {
          localObject3 = new TextView(getContext());
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i2] = localObject3;
          ((TextView)localObject3).setBackgroundResource(2130840697);
          ((TextView)localObject3).setPadding(i4, 0, i4, 0);
          ((TextView)localObject3).setTextSize(0, i3);
          ((TextView)localObject3).setTextColor(-16777216);
          ((TextView)localObject3).setGravity(17);
          if (7 == i2)
          {
            i3 = getResources().getDimensionPixelSize(2131493349);
            ((TextView)localObject3).setTextSize(0, i3);
            ((TextView)localObject3).setTag(new DataTag(32, null));
            ((TextView)localObject3).setText("+");
            ((TextView)localObject3).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
            localObject1 = new ViewGroup.LayoutParams(-2, -2);
            ((ViewGroup.LayoutParams)localObject1).width = getResources().getDimensionPixelSize(2131493350);
            ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(2131493350);
          }
          for (;;)
          {
            ((AdaptiveLayout)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
            i2 += 1;
            break;
            ((TextView)localObject3).setVisibility(8);
          }
        }
      }
      localObject1 = paramCard.getLabelList();
      if ((localObject2 != null) && (localObject1 != null))
      {
        label468:
        float f1;
        if (((List)localObject1).size() > 7)
        {
          i2 = 7;
          i3 = 0;
          if (i3 >= i1) {
            break label651;
          }
          localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i3];
          if (i3 >= i2) {
            break label611;
          }
          ((TextView)localObject2).setText(((ProfileLabelInfo)((List)localObject1).get(i3)).labelName);
          ((TextView)localObject2).setVisibility(0);
          label516:
          if (((TextView)localObject2).getVisibility() == 0)
          {
            localObject3 = ((TextView)localObject2).getBackground();
            if ((localObject3 instanceof GradientDrawable))
            {
              localObject3 = (GradientDrawable)localObject3;
              f1 = 2.0F * getResources().getDisplayMetrics().density;
              if (paramCard.backgroundColor != 1L) {
                break label628;
              }
              ((GradientDrawable)localObject3).setColor(-2130706433);
              ((GradientDrawable)localObject3).setCornerRadius(f1);
              ((TextView)localObject2).setTextColor(-16777216);
            }
          }
        }
        for (;;)
        {
          i3 += 1;
          break label468;
          i2 = ((List)localObject1).size();
          break;
          label611:
          if (i3 >= 7) {
            break label516;
          }
          ((TextView)localObject2).setVisibility(8);
          break label516;
          label628:
          ((GradientDrawable)localObject3).setColor(-2147483648);
          ((GradientDrawable)localObject3).setCornerRadius(f1);
          ((TextView)localObject2).setTextColor(-1);
        }
        label651:
        return true;
      }
      return false;
    }
  }
  
  private boolean f(Card paramCard)
  {
    if ((paramCard == null) || (paramCard.lCurrentStyleId == ProfileCardTemplate.a) || (paramCard.lCurrentStyleId == -1L) || (!paramCard.isShowXMan()) || (!paramCard.allowClick))
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("map_key_qqloginday");
      return false;
    }
    View localView = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qqloginday");
    if (localView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903993, null);
      this.jdField_a_of_type_JavaUtilHashMap.put("map_key_qqloginday", localView);
    }
    for (boolean bool = true;; bool = false)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131297001);
      TextView localTextView2 = (TextView)localView.findViewById(2131297409);
      ImageView localImageView = (ImageView)localView.findViewById(2131298739);
      localTextView1.setText(2131368203);
      long l1 = 30L;
      if (paramCard.lQQMasterLogindays > 0L) {
        l1 = paramCard.lQQMasterLogindays;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateQQLoginDays lQQMasterLogindays=" + l1 + ",lLoginDays=" + paramCard.lLoginDays + ",AllinOne Pa=" + this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int + ",card.allowClick=" + paramCard.allowClick);
      }
      Drawable localDrawable;
      if (paramCard.lLoginDays >= l1)
      {
        localDrawable = getContext().getResources().getDrawable(2130840451);
        localView.setClickable(true);
        localView.setTag(new DataTag(31, null));
        localView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_AndroidViewView$OnClickListener);
        localImageView.setVisibility(0);
        localTextView2.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int != 0) {
          break label435;
        }
        localTextView2.setText(paramCard.lLoginDays + "天");
        if (paramCard.lLoginDays < l1) {
          break label424;
        }
        localTextView2.setTextColor(-155129);
      }
      for (;;)
      {
        localTextView2.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
        localTextView2.setCompoundDrawablePadding(ProfileCardUtil.a(getContext(), 10));
        a("map_key_qqloginday", localTextView1, localTextView2, localImageView);
        return bool;
        localDrawable = getContext().getResources().getDrawable(2130840450);
        break;
        label424:
        localTextView2.setTextColor(-5855578);
        continue;
        label435:
        if (paramCard.allowPeopleSee)
        {
          localTextView2.setText(paramCard.lLoginDays + "天");
          if (paramCard.lLoginDays >= l1) {
            localTextView2.setTextColor(-155129);
          } else {
            localTextView2.setTextColor(-5855578);
          }
        }
        else
        {
          localTextView2.setText("");
        }
      }
    }
  }
  
  protected String a(int paramInt)
  {
    return getResources().getString(paramInt);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "update more info");
    }
    removeAllViews();
    ArrayList localArrayList = new ArrayList();
    List localList = a(this.jdField_a_of_type_JavaUtilHashMap, localArrayList, this.jdField_c_of_type_ArrayOfJavaLangString, this.jdField_b_of_type_Int);
    if (localList != null) {}
    for (int i1 = localList.size(); i1 == 0; i1 = 0) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) && (!(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView instanceof ProfileBaseView))) {}
    for (int i2 = 1;; i2 = 0)
    {
      int i3 = 0;
      while (i3 < i1)
      {
        View localView = (View)localList.get(i3);
        if (i2 != 0) {}
        localView.setBackgroundResource(2130840502);
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        i3 += 1;
      }
    }
    a(localList, localArrayList);
  }
  
  public void a(Card paramCard)
  {
    Object localObject = (View)this.jdField_a_of_type_JavaUtilHashMap.get("map_key_qzone_feed");
    if ((paramCard == null) || (localObject == null) || (!TextUtils.isEmpty(paramCard.strQzoneFeedsDesc)) || (!TextUtils.isEmpty(paramCard.strSpaceName))) {
      return;
    }
    TextView localTextView = (TextView)((View)localObject).findViewById(2131297409);
    localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[4];
    if (localObject != null)
    {
      paramCard = (Card)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramCard = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ArrayOfJavaLangString[0];
    }
    if (paramCard != null)
    {
      localObject = paramCard;
      if (paramCard.length() != 0) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
    }
    localTextView.setText((String)localObject + a(2131368259));
  }
  
  public void a(Card paramCard, boolean paramBoolean)
  {
    if (a(paramCard, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaUtilArrayList)) {
      a();
    }
  }
  
  public void a(ProfileCardInfo paramProfileCardInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo = paramProfileCardInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(RichStatus paramRichStatus)
  {
    if (a(paramRichStatus)) {
      a();
    }
  }
  
  public void a(MQQProfileName paramMQQProfileName)
  {
    if (a()) {
      a();
    }
  }
  
  public boolean a(Card paramCard, boolean paramBoolean, ArrayList paramArrayList)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "build more info map");
    }
    boolean bool2;
    try
    {
      bool2 = e(paramCard);
      if (!bool2) {
        break label450;
      }
      bool2 = true;
      bool1 = bool2;
    }
    catch (Exception paramCard)
    {
      boolean bool4;
      label61:
      label94:
      label117:
      paramBoolean = bool1;
      label141:
      label163:
      label188:
      label212:
      label236:
      label365:
      paramCard.printStackTrace();
      label259:
      label281:
      label327:
      label333:
      label339:
      label345:
      label351:
      label356:
      return paramBoolean;
    }
    try
    {
      bool4 = c(paramCard);
      if (bool2) {
        break label378;
      }
      if (!bool4) {
        break label456;
      }
    }
    catch (Exception paramCard)
    {
      paramBoolean = bool1;
      break label365;
      bool2 = true;
      break label61;
      bool2 = true;
      break label94;
      bool2 = true;
      break label117;
      bool2 = true;
      break label141;
      if ((!bool2) && (!bool1)) {
        break label327;
      }
      bool2 = true;
      break label163;
      bool2 = true;
      break label188;
      bool2 = true;
      break label212;
      bool2 = true;
      break label236;
      paramBoolean = true;
      break label259;
      paramBoolean = true;
      break label281;
      paramBoolean = true;
    }
    bool1 = bool2;
    bool4 = a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
    if (!bool2)
    {
      if (!bool4) {
        break label462;
      }
      break label384;
      bool1 = bool2;
      bool4 = a();
      if (bool2) {
        break label390;
      }
      if (!bool4) {
        break label468;
      }
      break label390;
      bool1 = bool2;
      bool4 = a(paramArrayList);
      if (bool2) {
        break label396;
      }
      if (!bool4) {
        break label474;
      }
      break label396;
    }
    for (;;)
    {
      if (paramCard == null)
      {
        bool1 = bool2;
        bool4 = a(null);
        bool1 = bool4;
        break label402;
        bool1 = bool2;
        bool4 = b(paramCard, paramBoolean);
        if (bool2) {
          break label418;
        }
        if (!bool4) {
          break label333;
        }
        break label418;
        bool1 = bool2;
        bool4 = a(paramCard);
        if (bool2) {
          break label424;
        }
        if (!bool4) {
          break label339;
        }
        break label424;
        bool1 = bool2;
        bool4 = b(paramCard);
        if (bool2) {
          break label430;
        }
        if (!bool4) {
          break label345;
        }
        break label430;
        bool1 = bool2;
        paramBoolean = a(paramCard, paramBoolean);
        if (bool2) {
          break label436;
        }
        if (!paramBoolean) {
          break label351;
        }
        break label436;
        bool1 = paramBoolean;
        bool2 = f(paramCard);
        if (paramBoolean) {
          break label441;
        }
        if (!bool2) {
          break label356;
        }
        break label441;
      }
      for (;;)
      {
        bool1 = paramBoolean;
        bool2 = d(paramCard);
        if (paramBoolean) {
          break label446;
        }
        paramBoolean = bool3;
        if (!bool2) {
          break label448;
        }
        break label446;
        bool1 = bool2;
        bool4 = a(paramCard.getRichStatus());
        bool1 = bool4;
        break label402;
        bool2 = false;
        break;
        bool2 = false;
        break label188;
        bool2 = false;
        break label212;
        bool2 = false;
        break label236;
        paramBoolean = false;
        break label259;
        paramBoolean = false;
      }
      label378:
      return paramBoolean;
      label384:
      label390:
      label396:
      label402:
      label418:
      label424:
      label430:
      label436:
      label441:
      label446:
      label448:
      label450:
      bool2 = false;
      break;
      label456:
      bool2 = false;
      break label61;
      label462:
      bool2 = false;
      break label94;
      label468:
      bool2 = false;
      break label117;
      label474:
      bool2 = false;
    }
  }
  
  public boolean a(ProfileCardTemplate paramProfileCardTemplate)
  {
    if (paramProfileCardTemplate == null) {}
    for (paramProfileCardTemplate = "0"; this.jdField_b_of_type_JavaUtilHashMap.size() > 0; paramProfileCardTemplate = String.valueOf(paramProfileCardTemplate.h))
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      String str;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
      } while (((String)this.jdField_b_of_type_JavaUtilHashMap.get(str)).equals(paramProfileCardTemplate));
      return false;
    }
    return true;
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_AndroidWidgetLinearLayout != null)
    {
      ProfileCardTemplate.a(this.jdField_b_of_type_AndroidWidgetLinearLayout, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      a(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      ProfileCardTemplate.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, "background", this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate, "commonMaskBackground");
      a(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    }
  }
  
  public void b(Card paramCard)
  {
    e(paramCard);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    if (paramConfiguration.orientation == 1) {}
    for (int i1 = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);; i1 = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels))
    {
      this.jdField_a_of_type_Float = Math.min(SizeMeasure.e(getContext()), i1);
      return;
    }
  }
  
  public void setNewSignature(byte[] paramArrayOfByte, long paramLong)
  {
    EntityManager localEntityManager;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 0)
    {
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      localObject = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
      if (localObject != null) {
        break label105;
      }
      localObject = null;
      if (localObject != null) {
        break label127;
      }
      localObject = new Card();
      ((Card)localObject).uin = this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString;
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
    for (;;)
    {
      a(((Card)localObject).getRichStatus());
      return;
      label105:
      localObject = ((FriendManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      break;
      label127:
      ((Card)localObject).vRichSign = paramArrayOfByte;
      ((Card)localObject).lSignModifyTime = paramLong;
      localEntityManager.a((Entity)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProfileCardMoreInfoView
 * JD-Core Version:    0.7.0.1
 */