package com.tencent.mobileqq.dating.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingItemActionListener;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomImgView;

public class DatingFeedItemView
  extends LinearLayout
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable.URLDrawableOptions jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions;
  public DatingInfo a;
  DatingItemActionListener jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  int jdField_b_of_type_Int;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private TextView h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private TextView n;
  
  public DatingFeedItemView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DatingFeedItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt, DatingInfo paramDatingInfo)
  {
    String str1 = "";
    Object localObject1;
    String str2;
    label87:
    int i4;
    label261:
    label277:
    int i1;
    int i2;
    int i3;
    if (paramDatingInfo.datingStatus != 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      str1 = "已结束";
      if (paramDatingInfo.datingSubject != 5) {
        break label634;
      }
      localObject1 = DatingUtil.a(paramDatingInfo);
      str2 = "从" + ((String)localObject1).replace("-", "到");
      localObject1 = DatingUtil.a(getContext(), this.k.getPaint(), 135, (String)localObject1);
      if (!((String)localObject1).equals(this.k.getText())) {
        this.k.setText((CharSequence)localObject1);
      }
      if (!this.j.getText().equals(paramDatingInfo.datingIntroduce)) {
        this.j.setText(paramDatingInfo.datingIntroduce);
      }
      localObject1 = DatingUtil.a(1, paramDatingInfo.datingCommentNum);
      if (!this.m.getText().equals(localObject1)) {
        this.m.setText((CharSequence)localObject1);
      }
      localObject1 = DatingUtil.a(2, paramDatingInfo.datingApplyNum);
      if (!this.n.getText().equals(localObject1)) {
        this.n.setText((CharSequence)localObject1);
      }
      localObject1 = DatingUtil.a(0, paramDatingInfo.datingVisitNum);
      if (!this.l.getText().equals(localObject1)) {
        this.l.setText((CharSequence)localObject1);
      }
      getResources().getDrawable(2130838406);
      if (paramDatingInfo.datingStatus == 0) {
        break label703;
      }
      i4 = 1;
      if (paramDatingInfo.datingSubject != 3) {
        break label716;
      }
      if (i4 == 0) {
        break label709;
      }
      paramInt = 2130840253;
      i1 = 2130840252;
      i2 = 2131369682;
      int i5 = 2130840194;
      i3 = paramInt;
      paramInt = i5;
      label294:
      if (i4 == 0) {
        break label997;
      }
      paramInt = 2130840196;
    }
    Object localObject2;
    label703:
    label709:
    label716:
    label997:
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setBackgroundResource(i3);
      this.jdField_f_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt);
      this.jdField_g_of_type_AndroidWidgetImageView.setBackgroundResource(paramInt);
      String str3 = getResources().getString(i2);
      if (!str3.equals(this.i.getText())) {
        this.i.setText(i2);
      }
      if (paramDatingInfo.datingSubject == 5) {}
      for (localObject1 = paramDatingInfo.placePicUrl;; localObject1 = paramDatingInfo.addressCompanyPicUrl)
      {
        Drawable localDrawable = getResources().getDrawable(i1);
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = getResources().getDimensionPixelSize(2131493363);
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = localDrawable;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = localDrawable;
          localObject1 = URLDrawable.getDrawable((String)localObject1, this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            CustomImgView localCustomImgView;
            localObject2 = null;
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.i("Q.dating", 2, localException1.toString());
              localObject1 = localObject2;
            }
          }
        }
        try
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = null;
          this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = null;
          localCustomImgView = this.jdField_b_of_type_ComTencentWidgetCustomImgView;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localDrawable;
          }
          localCustomImgView.setImageDrawable((Drawable)localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("约会内容");
          ((StringBuilder)localObject1).append("  ");
          ((StringBuilder)localObject1).append(str3);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append("地点");
          ((StringBuilder)localObject1).append("  ");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(paramDatingInfo.datingIntroduce);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append("连按两次进入约会详情页");
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setContentDescription(((StringBuilder)localObject1).toString());
          return;
        }
        catch (Exception localException2)
        {
          localObject2 = localObject1;
          break label959;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        label634:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramDatingInfo.addressCompanyName);
        if (!TextUtils.isEmpty(paramDatingInfo.addressCompanyZone))
        {
          ((StringBuilder)localObject1).append(" ( ");
          ((StringBuilder)localObject1).append(paramDatingInfo.addressCompanyZone);
          ((StringBuilder)localObject1).append(" ) ");
        }
        str2 = ((StringBuilder)localObject1).toString();
        localObject1 = str2;
        break label87;
        i4 = 0;
        break label261;
        paramInt = 2130840251;
        break label277;
        if (paramDatingInfo.datingSubject == 2)
        {
          if (i4 != 0) {}
          for (paramInt = 2130840256;; paramInt = 2130840254)
          {
            i1 = 2130840255;
            i2 = 2131369684;
            i3 = paramInt;
            paramInt = 2130840195;
            break;
          }
        }
        if (paramDatingInfo.datingSubject == 4)
        {
          if (i4 != 0) {}
          for (paramInt = 2130840259;; paramInt = 2130840257)
          {
            i1 = 2130840258;
            i2 = 2131369683;
            i3 = paramInt;
            paramInt = 2130840197;
            break;
          }
        }
        if (paramDatingInfo.datingSubject == 1)
        {
          if (i4 != 0) {}
          for (paramInt = 2130840250;; paramInt = 2130840248)
          {
            i1 = 2130840249;
            i2 = 2131369681;
            i3 = paramInt;
            paramInt = 2130840193;
            break;
          }
        }
        if (paramDatingInfo.datingSubject == 5)
        {
          if (i4 != 0) {}
          for (paramInt = 2130840262;; paramInt = 2130840260)
          {
            i1 = 2130840261;
            i2 = 2131369685;
            i3 = paramInt;
            paramInt = 2130840198;
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "datingfeeditemview bindDatingInfo subject is wrong: " + paramDatingInfo.datingSubject);
        }
        i3 = 2130840257;
        i2 = 2131369683;
        i1 = 2130840258;
        paramInt = 2130840197;
        break label294;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903871, this, true);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299901));
    this.k = ((TextView)findViewById(2131299902));
    this.jdField_b_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131299897));
    this.n = ((TextView)findViewById(2131299913));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299884));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298048));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299892));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299894));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299893));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299888));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299887));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299889));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299890));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299891));
    this.h = ((TextView)findViewById(2131299885));
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)findViewById(2131299883));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299882));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131299896));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131298044));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299899));
    this.i = ((TextView)findViewById(2131299900));
    this.j = ((TextView)findViewById(2131299905));
    this.l = ((TextView)findViewById(2131299910));
    this.m = ((TextView)findViewById(2131299912));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299895));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299904));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299907));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131299886));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299898));
    int i1 = paramContext.getResources().getColor(2131427880);
    this.jdField_e_of_type_AndroidWidgetImageView.setBackgroundColor(i1);
    findViewById(2131299908).setBackgroundColor(i1);
    findViewById(2131299911).setBackgroundColor(i1);
    setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    paramContext = getResources().getDrawable(2130840233);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(paramContext);
    paramContext = getResources().getDrawable(2130840157);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setBackgroundDrawable(paramContext);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void a(DatingInfo paramDatingInfo, Drawable paramDrawable)
  {
    Object localObject = String.valueOf(paramDatingInfo.publisherAge);
    if (!((String)localObject).equals(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    if (paramDatingInfo.publisherGender == 1)
    {
      i1 = 2130838479;
      this.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(i1, 0, 0, 0);
      if (paramDatingInfo.publisherGender != 1) {
        break label508;
      }
      i1 = 2130840432;
      label68:
      this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(i1);
      i1 = paramDatingInfo.publisherEmo - 1;
      if ((i1 <= 0) || (i1 >= NearbyProfileUtil.b.length)) {
        break label515;
      }
      localObject = NearbyProfileUtil.b[i1];
      label102:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label521;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      label119:
      i1 = paramDatingInfo.publisherProfession;
      if ((i1 < 0) || (i1 >= NearbyProfileUtil.e.length)) {
        break label541;
      }
    }
    label271:
    label401:
    label541:
    for (localObject = NearbyProfileUtil.e[i1];; localObject = null)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label547;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = paramDatingInfo.publisherConstellation;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label604;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      label183:
      localObject = paramDatingInfo.publisherDistance;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label624;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      label206:
      localObject = paramDatingInfo.publisherNickname;
      if (!this.jdField_a_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      localObject = paramDatingInfo.publisherVip;
      if (!"svip".equalsIgnoreCase((String)localObject)) {
        break label661;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842003);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramDatingInfo.publisherNBflag != 1) {
        break label705;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      label287:
      long l1 = paramDatingInfo.publisherID;
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setTag(String.valueOf(l1));
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
      paramDrawable = "";
      if (paramDatingInfo.datingSubject != 5) {
        break label717;
      }
      this.h.setVisibility(4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("约会发布人");
      ((StringBuilder)localObject).append(paramDatingInfo.publisherNickname);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append("性别");
      if (paramDatingInfo.publisherGender != 0) {
        break label918;
      }
      ((StringBuilder)localObject).append("男");
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append("年龄");
      ((StringBuilder)localObject).append(paramDatingInfo.publisherAge);
      ((StringBuilder)localObject).append("岁");
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append("距离");
      ((StringBuilder)localObject).append(paramDatingInfo.publisherDistance);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDrawable);
      ((StringBuilder)localObject).append(" ");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(((StringBuilder)localObject).toString());
      return;
      i1 = 2130838484;
      break;
      label508:
      i1 = 2130840433;
      break label68;
      localObject = null;
      break label102;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label119;
    }
    label515:
    label521:
    label547:
    int i2;
    if ((i1 >= 0) && (i1 < NearbyProfileUtil.a.length))
    {
      i2 = NearbyProfileUtil.a[i1];
      i1 = i2;
      if (i2 >= 0) {}
    }
    for (int i1 = 0;; i1 = 0)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundResource(i1);
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break;
      label604:
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label183;
      label624:
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_g_of_type_AndroidWidgetTextView.getText().equals(localObject)) {
        break label206;
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramDatingInfo.publisherDistance);
      break label206;
      label661:
      if ("vip".equalsIgnoreCase((String)localObject))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842130);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        break label271;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      break label271;
      label705:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label287;
      label717:
      this.h.setVisibility(0);
      switch (paramDatingInfo.datingPayType)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.i("Q.dating", 2, "datingfeeditemview datingpay type is wrong :" + paramDatingInfo.datingPayType);
        }
        i1 = getResources().getColor(2131427882);
        i2 = 2131369678;
      }
      for (;;)
      {
        paramDrawable = getResources().getString(i2);
        if (!this.h.getText().equals(paramDrawable))
        {
          this.h.setText(i2);
          this.h.setTextColor(i1);
          this.jdField_b_of_type_AndroidWidgetTextView.setText(i2);
        }
        break;
        i1 = getResources().getColor(2131427882);
        i2 = 2131369678;
        continue;
        i2 = 2131369679;
        i1 = getResources().getColor(2131427881);
        continue;
        i2 = 2131369680;
        i1 = getResources().getColor(2131427883);
      }
      label918:
      if (paramDatingInfo.publisherGender == 1)
      {
        ((StringBuilder)localObject).append("女");
        break label401;
      }
      ((StringBuilder)localObject).append("未知");
      break label401;
    }
  }
  
  public void a(int paramInt1, int paramInt2, DatingInfo paramDatingInfo, Drawable paramDrawable, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo = paramDatingInfo;
    switch (paramInt1)
    {
    default: 
      switch (paramInt1)
      {
      default: 
        label72:
        switch (paramInt1)
        {
        }
        break;
      }
      break;
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
        break;
        a(paramDatingInfo, paramDrawable);
        a(paramInt1, paramDatingInfo);
        break label72;
        a(paramInt1, paramDatingInfo);
        break label72;
        a(paramDatingInfo, paramDrawable);
        a(paramInt1, paramDatingInfo);
        break label72;
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        if (paramInt3 == 0)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_ComTencentWidgetCustomImgView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
          return;
        }
      } while (paramInt3 != 1);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_ComTencentWidgetCustomImgView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      paramDatingInfo = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      if (paramInt3 == 0)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
        this.h.setVisibility(0);
        paramDatingInfo.addRule(0, this.jdField_g_of_type_AndroidWidgetTextView.getId());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(true);
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setClickable(true);
        this.jdField_b_of_type_ComTencentWidgetCustomImgView.setClickable(true);
        return;
      }
    } while (paramInt3 != 1);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    this.h.setVisibility(8);
    paramDatingInfo.addRule(0, this.jdField_b_of_type_AndroidWidgetButton.getId());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setClickable(false);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setClickable(false);
    this.jdField_b_of_type_ComTencentWidgetCustomImgView.setClickable(false);
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    while ((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetCustomImgView.setImageDrawable(paramDrawable);
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null) {}
      for (Object localObject = null;; localObject = Long.toString(this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherID)) {
        return Utils.a(paramString, localObject);
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo == null)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramView != this.jdField_a_of_type_AndroidWidgetLinearLayout) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener == null);
          this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo);
          return;
          if (paramView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener == null);
        this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo);
        return;
        if (paramView != this.jdField_b_of_type_ComTencentWidgetCustomImgView) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener == null);
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener.c(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo);
      return;
    } while (((paramView != this.jdField_b_of_type_AndroidWidgetButton) && (paramView != this.jdField_a_of_type_AndroidWidgetButton)) || (this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener == null));
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener.d(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataDatingInfo);
  }
  
  public void setDatingItemActionListener(DatingItemActionListener paramDatingItemActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemActionListener = paramDatingItemActionListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.widget.DatingFeedItemView
 * JD-Core Version:    0.7.0.1
 */