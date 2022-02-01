package com.tencent.mobileqq.nearby.profilecard;

import android.animation.LayoutTransition;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.AgeSelectionActivity;
import com.tencent.mobileqq.activity.JobSelectionActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.conditionsearch.LocationSelectActivity;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import jjb;
import jjc;
import jjd;
import jje;
import jjf;
import jji;
import jjj;
import jjl;
import jjm;
import jjn;
import jjo;
import jjp;
import jjq;
import jjs;
import jju;
import jjv;
import jjw;

public class NearbyProfileEditPanel
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private HorizontalScrollView jdField_a_of_type_AndroidWidgetHorizontalScrollView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new jjc(this);
  private NearbyPeopleCard jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard;
  private NearbyPeopleProfileActivity.PicInfo jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo;
  private NearbyPeopleProfileActivity jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new jji(this);
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CustomImgView jdField_a_of_type_ComTencentWidgetCustomImgView;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private jjw jdField_a_of_type_Jjw;
  private int jdField_b_of_type_Int;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private IphonePickerView.PickerViewAdapter jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = new jjd(this);
  private FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private CustomImgView jdField_b_of_type_ComTencentWidgetCustomImgView = null;
  private int jdField_c_of_type_Int;
  private EditText jdField_c_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_c_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private EditText jdField_d_of_type_AndroidWidgetEditText;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private EditText e;
  private EditText f;
  private EditText g;
  private EditText h;
  private EditText i;
  private EditText j;
  
  public NearbyProfileEditPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity = paramNearbyPeopleProfileActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDisplayMetrics().widthPixels;
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_Jjw = new jjw(this, this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p);
    }
    this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float + 0.5D));
    a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  private Intent a(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, PhotoCropActivity.class);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getClass().getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.minihd.qq");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
    localIntent.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    paramString = AppConstants.aG + this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a() + "/" + "nearby_people_photo/";
    localIntent.putExtra("PhotoConst.TARGET_PATH", paramString + System.currentTimeMillis() + ".jpg");
    localIntent.putExtra("PhotoConst.CLIP_WIDTH", 640);
    localIntent.putExtra("PhotoConst.CLIP_HEIGHT", 640);
    localIntent.putExtra("PhotoConst.TARGET_WIDTH", 640);
    localIntent.putExtra("PhotoConst.TARGET_HEIGHT", 640);
    return localIntent;
  }
  
  private View.OnClickListener a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new jjq(this);
    }
    return new jjs(this);
  }
  
  @TargetApi(11)
  private CustomImgView a(NearbyPeopleProfileActivity.PicInfo paramPicInfo)
  {
    CustomImgView localCustomImgView = new CustomImgView(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
    localCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840157));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p);
    if (paramPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo) {
      localLayoutParams.setMargins(0, 0, this.jdField_c_of_type_Int, 0);
    }
    localCustomImgView.setLayoutParams(localLayoutParams);
    a(localCustomImgView, paramPicInfo, null);
    localCustomImgView.setOnClickListener(a(false));
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)
      {
        localCustomImgView.setOnLongClickListener(new jjv(this, null));
        localCustomImgView.setOnDragListener(this.jdField_a_of_type_Jjw);
      }
    }
    else {
      return localCustomImgView;
    }
    localCustomImgView.setOnDragListener(new jjp(this));
    return localCustomImgView;
  }
  
  private void a(View paramView)
  {
    paramView.findViewById(2131297354).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297355));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297356));
    paramView.findViewById(2131297348).setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetCustomImgView = ((CustomImgView)paramView.findViewById(2131300261));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getLayoutParams();
    int k = this.jdField_b_of_type_Int;
    localLayoutParams.height = k;
    localLayoutParams.width = k;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131300260));
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)paramView.findViewById(2131300262));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300263));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299786));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300266));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300264));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300265));
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (this.jdField_b_of_type_Int / 2 + (int)(36.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
    ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams()).topMargin = (this.jdField_b_of_type_Int / 2 + (int)(22.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131300267));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131296683));
    this.jdField_c_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131297441));
    this.jdField_d_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2131299004));
    this.e = ((EditText)paramView.findViewById(2131299748));
    this.f = ((EditText)paramView.findViewById(2131299749));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300268));
    this.g = ((EditText)paramView.findViewById(2131300269));
    this.h = ((EditText)paramView.findViewById(2131300270));
    this.i = ((EditText)paramView.findViewById(2131300271));
    this.j = ((EditText)paramView.findViewById(2131300272));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131300273));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131300274));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131300258));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131300259));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetEditText.addTextChangedListener(new jjb(this));
    this.h.addTextChangedListener(new jjl(this));
    this.i.addTextChangedListener(new jjm(this));
    ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300257)).setNeedHorizontalGesture(true);
    ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300257)).h = 1;
  }
  
  private void a(EditText paramEditText, int paramInt)
  {
    String str = paramEditText.getText().toString();
    if (str.getBytes().length > paramInt)
    {
      while (str.getBytes().length > paramInt) {
        str = str.substring(0, str.length() - 1);
      }
      paramEditText.setText(str);
      paramEditText.setSelection(str.length());
    }
  }
  
  private void a(TextView paramTextView, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    RichStatus localRichStatus;
    if (paramArrayOfByte != null)
    {
      localRichStatus = RichStatus.a(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.a(null, -8947849, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getColor(2131427405));
      }
      localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus == null) || (TextUtils.isEmpty(localRichStatus.c))) {
        break label226;
      }
      localObject = new SpannableStringBuilder((CharSequence)localObject);
      ((SpannableStringBuilder)localObject).insert(0, "[S] ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
        break label209;
      }
    }
    label209:
    for (paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localRichStatus.jdField_b_of_type_Int, 200);; paramArrayOfByte = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), 2130841575))
    {
      paramArrayOfByte = new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources(), paramArrayOfByte, false, false);
      int k = (int)(paramTextView.getTextSize() * 1.1F + 0.5F);
      paramArrayOfByte.setBounds(0, 0, k, k);
      paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
      paramArrayOfByte.a(-0.1F);
      ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, "[S]".length(), 17);
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    label226:
    paramTextView.setText((CharSequence)localObject);
  }
  
  private void a(NearbyPeopleProfileActivity.PicInfo paramPicInfo, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(paramPicInfo);
      if (paramView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
      {
        paramPicInfo = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0).getTag();
        a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, ((CustomImgView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(0)).a());
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(0);
      }
      for (;;)
      {
        f();
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(paramView);
      }
    }
    paramPicInfo = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, "没有头像，怎么交朋友？请保留至少一张照片作为交友头像。", 0, 0, null, null);
    paramPicInfo.setPositiveButton(2131365737, new jju(this, paramPicInfo));
    paramPicInfo.show();
  }
  
  private void a(CustomImgView paramCustomImgView, NearbyPeopleProfileActivity.PicInfo paramPicInfo, Drawable paramDrawable)
  {
    paramCustomImgView.setTag(paramPicInfo);
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840456);
    }
    if (paramPicInfo == this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo) {
      if (paramCustomImgView != this.jdField_a_of_type_ComTencentWidgetCustomImgView) {
        paramCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840466));
      }
    }
    label368:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramPicInfo = (RelativeLayout.LayoutParams)paramCustomImgView.getLayoutParams();
          int k = (int)(5.0F * this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_Float);
          int m = this.jdField_b_of_type_Int - k * 2;
          paramPicInfo.height = m;
          paramPicInfo.width = m;
          paramPicInfo.setMargins(k, k, k, k);
          paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER);
          paramCustomImgView.setBackground(null);
          paramCustomImgView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840392));
          paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840393);
          return;
          if (paramCustomImgView == this.jdField_a_of_type_ComTencentWidgetCustomImgView)
          {
            paramDrawable = (RelativeLayout.LayoutParams)paramCustomImgView.getLayoutParams();
            k = this.jdField_b_of_type_Int;
            paramDrawable.height = k;
            paramDrawable.width = k;
            paramDrawable.setMargins(0, 0, 0, 0);
            paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            paramCustomImgView.setBackground(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getDrawable(2130840157));
            paramCustomImgView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(0);
          }
          try
          {
            if ((paramPicInfo.jdField_a_of_type_JavaLangString == null) || (paramPicInfo.jdField_a_of_type_JavaLangString.length() <= 0)) {
              break label368;
            }
            paramDrawable = new LocalMediaInfo();
            paramDrawable.jdField_a_of_type_JavaLangString = paramPicInfo.jdField_a_of_type_JavaLangString;
            paramDrawable.f = this.jdField_b_of_type_Int;
            paramDrawable.g = this.jdField_b_of_type_Int;
            paramPicInfo = new URL("albumthumb", "", LocalMediaInfo.a(paramDrawable));
            if (paramPicInfo != null)
            {
              paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo, localDrawable, localDrawable));
              return;
            }
          }
          catch (MalformedURLException paramCustomImgView) {}
        }
      } while (!QLog.isColorLevel());
      paramPicInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
      QLog.d("Q.nearby_people_card.", 2, "GridAdapter.getView() new URL(). " + paramCustomImgView.getMessage(), paramCustomImgView);
      return;
      if ((paramCustomImgView == this.jdField_a_of_type_ComTencentWidgetCustomImgView) && (!StringUtil.b(paramPicInfo.c)))
      {
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(new URL(paramPicInfo.c), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, localDrawable, localDrawable));
        return;
      }
      if (!StringUtil.b(paramPicInfo.b))
      {
        paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(new URL(paramPicInfo.b), this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.p, localDrawable, localDrawable));
        return;
      }
    } while (StringUtil.b(paramPicInfo.c));
    paramCustomImgView.setImageDrawable(URLDrawable.getDrawable(new URL(paramPicInfo.c), this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, localDrawable, localDrawable));
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add((NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag());
    int k = 0;
    while (k < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add((NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(k).getTag());
      k += 1;
    }
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void k()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      Object localObject = new StringBuilder("正在上传照片(");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int - this.jdField_a_of_type_JavaUtilLinkedList.size() + 1).append("/").append(this.jdField_a_of_type_Int).append(")...");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(((StringBuilder)localObject).toString());
      localObject = new jjj(this);
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a((Runnable)localObject);
      return;
    }
    m();
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a("正在保存资料...");
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while (k < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())
    {
      NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(k);
      if (localPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo) {
        localArrayList.add(Integer.valueOf(localPicInfo.jdField_a_of_type_Int));
      }
      k += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b.size()) {
      k = 1;
    }
    for (;;)
    {
      if (k != 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 10, 0, "", "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(localArrayList);
      return;
      k = 0;
      for (;;)
      {
        if (k >= this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label225;
        }
        if (((NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(k)).jdField_a_of_type_Int != ((NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.b.get(k)).jdField_a_of_type_Int)
        {
          k = 1;
          break;
        }
        k += 1;
      }
      label225:
      k = 0;
    }
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    int k = 0;
    while (k < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())
    {
      NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(k);
      if ((localPicInfo != this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo) && (localPicInfo.jdField_a_of_type_Int == -1)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(localPicInfo);
      }
      k += 1;
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaUtilLinkedList.size();
    return this.jdField_a_of_type_Int;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(paramInt);
  }
  
  void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    label395:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                Object localObject2;
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while (paramInt2 != -1);
                          paramIntent = paramIntent.getByteArrayExtra("param_new_xuan_yan");
                        } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
                        a(this.jdField_a_of_type_AndroidWidgetEditText, paramIntent);
                        this.jdField_a_of_type_AndroidWidgetEditText.setTag(paramIntent);
                        return;
                      } while ((paramInt2 != -1) || (this.e == null));
                      paramInt1 = paramIntent.getShortExtra("param_year", (short)-1);
                      paramInt2 = paramIntent.getByteExtra("param_month", (byte)-1);
                      int k = paramIntent.getByteExtra("param_day", (byte)-1);
                      int m = paramIntent.getIntExtra("param_age", 0);
                      this.e.setText(m + "岁");
                      localObject1 = paramIntent.getStringExtra("param_constellation");
                      int n = paramIntent.getIntExtra("param_constellation_id", 0);
                      this.f.setText((CharSequence)localObject1);
                      this.e.setTag(new Object[] { Integer.valueOf(paramInt1 << 16 | paramInt2 << 8 | k), Integer.valueOf(m), Integer.valueOf(n) });
                      return;
                    } while ((paramInt2 != -1) || (this.g == null));
                    localObject1 = paramIntent.getStringExtra("param_name");
                    paramInt1 = paramIntent.getIntExtra("param_id", -1);
                    localObject2 = paramIntent.getStringExtra("param_tag");
                    paramInt2 = paramIntent.getIntExtra("param_tag_bg", -1);
                    if ((localObject2 != null) && (((String)localObject2).length() > 0) && (paramInt2 > 0))
                    {
                      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
                      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(paramInt2);
                      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
                    }
                    for (;;)
                    {
                      this.g.setText((CharSequence)localObject1);
                      this.g.setTag(Integer.valueOf(paramInt1));
                      return;
                      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
                    }
                  } while (paramInt2 != -1);
                  localObject2 = paramIntent.getStringArrayExtra("param_location");
                  paramIntent = null;
                  try
                  {
                    localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a((String[])localObject2);
                    paramIntent = (Intent)localObject1;
                  }
                  catch (Exception localException)
                  {
                    break label395;
                  }
                  if (paramIntent != null)
                  {
                    localObject1 = paramIntent;
                    if (!paramIntent.equals("不限")) {}
                  }
                  else
                  {
                    localObject1 = "";
                  }
                } while (this.j == null);
                this.j.setText((CharSequence)localObject1);
                this.j.setTag(localObject2);
                return;
              } while (paramInt2 != -1);
              paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
            } while (StringUtil.b(paramIntent));
            paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
          } while ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() >= 13));
          paramIntent = a(paramIntent);
          paramIntent.putExtra("is_change_head", true);
          this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
          return;
        } while (paramInt2 != -1);
        paramIntent = paramIntent.getStringExtra("key_cover_selected_img_path");
      } while (StringUtil.b(paramIntent));
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.o;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity;
    } while ((paramInt1 != 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() >= 13));
    paramIntent = a(paramIntent);
    paramIntent.putExtra("is_change_head", false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivity(paramIntent);
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    h();
    this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard = paramNearbyPeopleCard;
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.e) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
    }
    e();
    a(this.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_a_of_type_AndroidWidgetEditText.setTag(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan);
    this.jdField_b_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname);
    this.jdField_c_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus - 1));
    this.jdField_c_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus));
    this.jdField_d_of_type_AndroidWidgetEditText.setText(NearbyProfileUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.jdField_d_of_type_AndroidWidgetEditText.setTag(Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender));
    this.e.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age + "岁");
    this.f.setText(NearbyProfileUtil.c(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation));
    this.e.setTag(new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age), Byte.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.constellation) });
    this.jdField_d_of_type_AndroidWidgetTextView.setText(NearbyProfileUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
    if (StringUtil.b(NearbyProfileUtil.d(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job))) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.g.setText(NearbyProfileUtil.e(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.g.setTag(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.h.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company);
      this.h.clearFocus();
      this.i.setText(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college);
      this.i.clearFocus();
      c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(NearbyProfileUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  void a(NearbyPeopleProfileActivity.PicInfo paramPicInfo)
  {
    NearbyPeopleProfileActivity.PicInfo localPicInfo = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentWidgetCustomImgView.getTag();
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < 12) || ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 12) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)))) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(localPicInfo), 0);
    }
    a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, null);
    f();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag())) {
        return true;
      }
      if (!this.jdField_b_of_type_AndroidWidgetEditText.getText().toString().equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname)) {
        return true;
      }
      if ((this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus)) {
        return true;
      }
      if ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender)) {
        return true;
      }
      if (((Integer)((Object[])(Object[])this.e.getTag())[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday) {
        return true;
      }
      if (((Integer)this.g.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job) {
        return true;
      }
      if (!StringUtil.e(this.h.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company)) {
        return true;
      }
      if (!StringUtil.e(this.i.getText().toString()).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college)) {
        return true;
      }
      if (!Arrays.equals((String[])this.j.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict })) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone) {
        return true;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby) {
        return true;
      }
    }
    return false;
  }
  
  boolean a(NearbyPeopleProfileActivity.PicInfo paramPicInfo)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 1))
    {
      a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, paramPicInfo, null);
      bool = false;
    }
    for (;;)
    {
      f();
      return bool;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(paramPicInfo), this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.fullScroll(66);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry;
      arrayOfString[1] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice;
      arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity;
      arrayOfString[3] = this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict;
      String str = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager.a(arrayOfString);
      if (this.j != null)
      {
        if (!"不限".equals(str)) {
          this.j.setText(str);
        }
        this.j.setTag(arrayOfString);
      }
    }
  }
  
  public void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    Object localObject2;
    int k;
    if (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard != null)
    {
      localObject2 = (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new byte[0];
      }
      localBundle.putByteArray("key_xuan_yan", (byte[])localObject1);
      if (!Arrays.equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.xuanYan, (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag())) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 2, 0, "", "", "", "");
      }
      localObject1 = this.jdField_b_of_type_AndroidWidgetEditText.getText().toString();
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.nickname))
      {
        localBundle.putString("key_new_nickname", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 1, 0, "", "", "", "");
      }
      if ((this.jdField_c_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.maritalStatus))
      {
        localBundle.putByte("key_marital_status", ((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 3, 0, "", "", "", "");
      }
      if ((this.jdField_d_of_type_AndroidWidgetEditText.getTag() != null) && (((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.gender))
      {
        localBundle.putByte("sex", ((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 4, 0, "", "", "", "");
      }
      localObject1 = (Object[])this.e.getTag();
      if (((Integer)localObject1[0]).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.birthday)
      {
        localBundle.putInt("birthday", ((Integer)localObject1[0]).intValue());
        localBundle.putInt("age", ((Integer)localObject1[1]).intValue());
        localBundle.putByte("key_constellation", (byte)((Integer)localObject1[2]).intValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 5, 0, "", "", "", "");
      }
      if (((Integer)this.g.getTag()).intValue() != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.job)
      {
        localBundle.putInt("profession", ((Integer)this.g.getTag()).intValue());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 6, 0, "", "", "", "");
      }
      localObject1 = StringUtil.e(this.h.getText().toString());
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.company))
      {
        localBundle.putString("company", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 7, 0, "", "", "", "");
      }
      localObject1 = StringUtil.e(this.i.getText().toString());
      if (!((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.college))
      {
        localBundle.putString("college", (String)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 8, 0, "", "", "", "");
      }
      if (!Arrays.equals((String[])this.j.getTag(), new String[] { this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCountry, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownProvice, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownCity, this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.hometownDistrict }))
      {
        localBundle.putStringArray("hometown", (String[])this.j.getTag());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X8004820", "0X8004820", 9, 0, "", "", "", "");
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (bool != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchQzone)
      {
        if (!bool) {
          break label1098;
        }
        k = 0;
        localBundle.putShort("key_qzone_switch", (short)k);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (!bool) {
        break label1103;
      }
      localObject1 = "1";
      label932:
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004821", "0X8004821", 0, 0, (String)localObject1, "", "", "");
      bool = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.a();
      if (bool != this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.switchHobby)
      {
        if (!bool) {
          break label1110;
        }
        k = 0;
        label989:
        localBundle.putShort("key_hobby_switch", (short)k);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app;
      if (!bool) {
        break label1115;
      }
    }
    label1098:
    label1103:
    label1110:
    label1115:
    for (Object localObject1 = "1";; localObject1 = "0")
    {
      ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8004822", "0X8004822", 0, 0, (String)localObject1, "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.update_profile", 2, "Q.nearby_people_card..updateProfile(), modified_data = " + localBundle.toString());
      }
      return;
      k = 1;
      break;
      localObject1 = "0";
      break label932;
      k = 1;
      break label989;
    }
  }
  
  @TargetApi(11)
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.oldPhotoCount > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age >= 14) && (this.jdField_a_of_type_ComTencentMobileqqDataNearbyPeopleCard.age <= 24) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1))
    {
      a(0);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app, "CliOper", "", "", "0X800481B", "0X800481B", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      Object localObject = (NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(0);
      a(this.jdField_a_of_type_ComTencentWidgetCustomImgView, (NearbyPeopleProfileActivity.PicInfo)localObject, null);
      this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnClickListener(a(true));
      if (Build.VERSION.SDK_INT >= 11)
      {
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnLongClickListener(new jjv(this, null));
        this.jdField_a_of_type_ComTencentWidgetCustomImgView.setOnDragListener(this.jdField_a_of_type_Jjw);
        localObject = new LayoutTransition();
        ((LayoutTransition)localObject).setAnimator(2, null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutTransition((LayoutTransition)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int k = 1;
      while (k < this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a((NearbyPeopleProfileActivity.PicInfo)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.get(k)));
        k += 1;
      }
      a(8);
    }
    f();
  }
  
  void f()
  {
    int k = 1;
    i();
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() > 12) && (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.remove(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() < 12) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() <= 1)
    {
      j();
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(8);
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.contains(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity$PicInfo)) {
        break label251;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_JavaUtilArrayList.size() - k + "/" + 12);
      return;
      k();
      this.jdField_a_of_type_AndroidWidgetHorizontalScrollView.setVisibility(0);
      break;
      label251:
      k = 0;
    }
  }
  
  public void g()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, LocationSelectActivity.class);
    localIntent.putExtra("param_req_type", 3);
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.app.getManager(57);
    int k = localConditionSearchManager.a();
    if (k != 0)
    {
      k = localConditionSearchManager.a(k);
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "startLocationSelectActivity | update result = " + k);
      }
      if (k == 2)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, 2131367328, 0).b(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getTitleBarHeight());
        return;
      }
      if (k == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131369485));
        localConditionSearchManager.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppConditionSearchManager$IConfigListener);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.getResources().getString(2131369485));
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 20000L);
      return;
    }
    String[] arrayOfString2 = (String[])this.j.getTag();
    String[] arrayOfString1;
    if (arrayOfString2 != null)
    {
      arrayOfString1 = arrayOfString2;
      if (arrayOfString2.length == 4) {}
    }
    else
    {
      arrayOfString1 = new String[4];
      arrayOfString1[0] = "0";
      arrayOfString1[1] = "0";
      arrayOfString1[2] = "0";
      arrayOfString1[3] = "0";
    }
    localIntent.putExtra("param_location", arrayOfString1);
    localIntent.putExtra("param_is_popup", false);
    localIntent.putExtra("param_location_param", localConditionSearchManager.b(arrayOfString1));
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(localIntent, 4);
  }
  
  void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("编辑交友资料");
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("交友信息仅陌生人可见");
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131297357).setVisibility(8);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297358);
    localTextView.setVisibility(0);
    localTextView.setText(2131365736);
    localTextView.setOnClickListener(new jje(this));
    localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297360);
    localTextView.setVisibility(0);
    localTextView.setText(2131367064);
    localTextView.setEnabled(true);
    localTextView.setOnClickListener(new jjf(this));
  }
  
  public void onClick(View paramView)
  {
    int m = 0;
    if (paramView == this.jdField_a_of_type_AndroidWidgetEditText)
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, EditActivity.class);
      paramView.putExtra("param_entry", 1);
      paramView.putExtra("param_old_xuan_yan", (byte[])this.jdField_a_of_type_AndroidWidgetEditText.getTag());
      this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(paramView, 1);
    }
    do
    {
      Object localObject;
      int k;
      do
      {
        do
        {
          return;
          if (paramView != this.jdField_c_of_type_AndroidWidgetEditText) {
            break;
          }
          paramView = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
          localObject = (DispatchActionMoveScrollView)paramView.findViewById(2131296635);
          ((DispatchActionMoveScrollView)localObject).a = true;
          ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
          localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130903932, null);
          ((IphonePickerView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
        } while (this.jdField_c_of_type_AndroidWidgetEditText.getTag() == null);
        m = (byte)(((Byte)this.jdField_c_of_type_AndroidWidgetEditText.getTag()).byteValue() - 1);
        if (m >= 0)
        {
          k = m;
          if (m <= 3) {}
        }
        else
        {
          k = 0;
        }
        ((IphonePickerView)localObject).setSelection(0, k);
        ((IphonePickerView)localObject).setPickListener(new jjn(this, (IphonePickerView)localObject, paramView));
        paramView.b((View)localObject, null);
        paramView.show();
        return;
        if (paramView != this.jdField_d_of_type_AndroidWidgetEditText) {
          break;
        }
        paramView = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity);
        localObject = (DispatchActionMoveScrollView)paramView.findViewById(2131296635);
        ((DispatchActionMoveScrollView)localObject).a = true;
        ((DispatchActionMoveScrollView)localObject).setBackgroundResource(17170445);
        localObject = (IphonePickerView)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity).inflate(2130903932, null);
        ((IphonePickerView)localObject).a(this.jdField_b_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter);
      } while (this.jdField_d_of_type_AndroidWidgetEditText.getTag() == null);
      m = ((Byte)this.jdField_d_of_type_AndroidWidgetEditText.getTag()).byteValue();
      if (m >= 0)
      {
        k = m;
        if (m <= 1) {}
      }
      else
      {
        k = 0;
      }
      ((IphonePickerView)localObject).setSelection(0, k);
      ((IphonePickerView)localObject).setPickListener(new jjo(this, (IphonePickerView)localObject, paramView));
      paramView.b((View)localObject, null);
      paramView.show();
      return;
      if ((paramView == this.e) || (paramView == this.f))
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, AgeSelectionActivity.class);
        localObject = (Object[])this.e.getTag();
        k = m;
        if (localObject != null)
        {
          k = m;
          if (localObject.length > 0) {
            k = ((Integer)localObject[0]).intValue();
          }
        }
        paramView.putExtra("param_birthday", k);
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(paramView, 2);
        return;
      }
      if (paramView == this.g)
      {
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity, JobSelectionActivity.class);
        if ((this.g != null) && (this.g.getTag() != null) && ((this.g.getTag() instanceof Integer))) {
          paramView.putExtra("param_id", (Integer)this.g.getTag());
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.startActivityForResult(paramView, 3);
        return;
      }
      if (paramView == this.j)
      {
        g();
        return;
      }
    } while (paramView != this.jdField_a_of_type_AndroidWidgetButton);
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.a("正在导入");
    this.jdField_a_of_type_ComTencentMobileqqNearbyProfilecardNearbyPeopleProfileActivity.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel
 * JD-Core Version:    0.7.0.1
 */