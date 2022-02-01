package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.data.PublishDatingOption;
import com.tencent.mobileqq.data.PublishDatingOption.ShopInfo;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.IosTimepicker.OnTimePickerSelectListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.ScrollRadioGroup;
import com.tencent.widget.ActionSheet;
import iel;
import iem;
import ien;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class PublishDatingHelper
  implements ViewStub.OnInflateListener
{
  public static final int a = 0;
  private static final boolean jdField_a_of_type_Boolean = true;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RadioGroup.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  private ScrollRadioGroup jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  View jdField_b_of_type_AndroidViewView;
  ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  View jdField_f_of_type_AndroidViewView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private int jdField_g_of_type_Int = 0;
  View jdField_g_of_type_AndroidViewView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private int jdField_h_of_type_Int = -1;
  View jdField_h_of_type_AndroidViewView;
  TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int = -1;
  View jdField_i_of_type_AndroidViewView;
  TextView jdField_i_of_type_AndroidWidgetTextView;
  View jdField_j_of_type_AndroidViewView;
  TextView jdField_j_of_type_AndroidWidgetTextView;
  View jdField_k_of_type_AndroidViewView;
  TextView jdField_k_of_type_AndroidWidgetTextView;
  View jdField_l_of_type_AndroidViewView;
  TextView jdField_l_of_type_AndroidWidgetTextView;
  private View m;
  private View n;
  
  public PublishDatingHelper(Context paramContext, View paramView1, View paramView2, View.OnClickListener paramOnClickListener, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.m = paramView1;
    this.n = paramView2;
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)paramView1.findViewById(2131300047));
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)paramView1.findViewById(2131300048));
    this.jdField_a_of_type_AndroidViewViewStub.setOnInflateListener(this);
    this.jdField_b_of_type_AndroidViewViewStub.setOnInflateListener(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener = paramOnCheckedChangeListener;
    a(false);
  }
  
  private String a(int paramInt)
  {
    String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230754);
    if (paramInt < arrayOfString.length) {
      return arrayOfString[paramInt];
    }
    return "";
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = "";
    Date localDate = new Date(paramLong);
    if (paramInt == 0) {
      str = new SimpleDateFormat("MM月dd日 E HH:mm").format(localDate);
    }
    while (paramInt != 1) {
      return str;
    }
    return new SimpleDateFormat("MM月dd日 E").format(localDate);
  }
  
  private String b(int paramInt)
  {
    String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230752);
    if (paramInt < arrayOfString.length) {}
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return arrayOfString[2];
    case 2: 
      return arrayOfString[1];
    }
    return arrayOfString[0];
  }
  
  private String c(int paramInt)
  {
    String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230753);
    if (paramInt < arrayOfString.length) {
      return arrayOfString[paramInt];
    }
    return "";
  }
  
  private String d(int paramInt)
  {
    String[] arrayOfString = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230755);
    if (paramInt == 7) {
      paramInt = 0;
    }
    while (paramInt < arrayOfString.length)
    {
      return arrayOfString[paramInt];
      paramInt += 1;
    }
    return "";
  }
  
  public void a()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (!this.jdField_b_of_type_Boolean) {
        i2 = 1;
      }
      if ((i1 & i2) != 0)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup.check(this.jdField_i_of_type_Int);
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup.a(paramInt);
    }
  }
  
  public void a(int paramInt, PublishDatingOption paramPublishDatingOption, IphonePickerView.IphonePickListener paramIphonePickListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidContentContext);
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296635)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)localLayoutInflater.inflate(2130903932, null));
    int i1 = -1;
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      paramPublishDatingOption = null;
    case 0: 
    case 1: 
    case 2: 
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(new ien(this, paramPublishDatingOption));
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(paramIphonePickListener);
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new iem(this));
        try
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
          return;
        }
        catch (Throwable paramPublishDatingOption) {}
        switch (paramPublishDatingOption.genderId)
        {
        default: 
          paramInt = i1;
        }
        for (;;)
        {
          paramPublishDatingOption = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230752);
          break;
          paramInt = 2;
          continue;
          paramInt = 0;
          continue;
          paramInt = 1;
        }
        paramInt = paramPublishDatingOption.payTypeId;
        paramPublishDatingOption = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230753);
        continue;
        paramInt = paramPublishDatingOption.partCountId;
        paramPublishDatingOption = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230754);
      }
    }
    if (paramPublishDatingOption.vehicleId == 7) {}
    for (paramInt = 0;; paramInt = paramPublishDatingOption.vehicleId + 1)
    {
      paramPublishDatingOption = this.jdField_a_of_type_AndroidContentContext.getResources().getStringArray(2131230755);
      break;
    }
  }
  
  public void a(PublishDatingOption paramPublishDatingOption)
  {
    if ((paramPublishDatingOption == null) || (paramPublishDatingOption.themeId == this.jdField_h_of_type_Int)) {
      return;
    }
    this.jdField_h_of_type_Int = paramPublishDatingOption.themeId;
    switch (this.jdField_h_of_type_Int)
    {
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      if (this.jdField_b_of_type_AndroidViewViewStub.getVisibility() == 0) {
        this.jdField_b_of_type_AndroidViewViewStub.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
      b(paramPublishDatingOption);
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewStub.getVisibility() == 0) {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewViewStub.setVisibility(0);
    b(paramPublishDatingOption);
  }
  
  public void a(PublishDatingOption paramPublishDatingOption, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, View.OnClickListener paramOnClickListener)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (paramPublishDatingOption == null) {
      return;
    }
    int i2 = paramPublishDatingOption.themeId;
    long l1 = paramPublishDatingOption.time;
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_AndroidContentContext);
    }
    int i1 = paramPublishDatingOption.maxTimeRequest;
    if (i1 <= 0) {
      i1 = 15;
    }
    for (;;)
    {
      paramPublishDatingOption = (IosTimepicker)localLayoutInflater.inflate(2130904525, null);
      paramPublishDatingOption.setMaxDays(i1 + (int)TimeHelper.a(System.currentTimeMillis()));
      if (i2 == 5) {
        paramPublishDatingOption.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetActionSheet, l1, paramOnTimePickerSelectListener, paramOnClickListener, 1);
      }
      for (;;)
      {
        paramPublishDatingOption.setTips(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131369689));
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
        }
        ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296635)).a = true;
        this.jdField_a_of_type_ComTencentWidgetActionSheet.b(paramPublishDatingOption, null);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new iel(this));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
        return;
        paramPublishDatingOption.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetActionSheet, l1, paramOnTimePickerSelectListener, paramOnClickListener, 0);
      }
    }
  }
  
  public void a(HashMap paramHashMap, int paramInt1, int paramInt2)
  {
    if (paramHashMap == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup = ((ScrollRadioGroup)this.m.findViewById(2131300046));
    Iterator localIterator = paramHashMap.entrySet().iterator();
    int i2 = 0;
    int i3 = 0;
    int i5;
    int i1;
    for (int i4 = -1;; i4 = i5) {
      for (;;)
      {
        if (localIterator.hasNext())
        {
          i5 = ((Integer)((Map.Entry)localIterator.next()).getKey()).intValue();
          Object localObject = (PublishDatingOption)paramHashMap.get(Integer.valueOf(i5));
          if ((i5 >= 0) && (localObject != null))
          {
            localObject = ((PublishDatingOption)localObject).themeName;
            switch (i5)
            {
            default: 
              i1 = -1;
              label147:
              if ((i1 != -1) && (!TextUtils.isEmpty((CharSequence)localObject)))
              {
                this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup.a(i1, (String)localObject, i5);
                this.jdField_g_of_type_Int += 1;
                if (i4 != -1) {
                  break label378;
                }
              }
              break;
            }
          }
        }
      }
    }
    label378:
    for (;;)
    {
      i1 = i3;
      if (i3 == 0)
      {
        i1 = i3;
        if (i5 == paramInt1) {
          i1 = 1;
        }
      }
      if ((i2 == 0) && (i5 == paramInt2))
      {
        i3 = 1;
        i2 = i1;
        i1 = i3;
      }
      for (;;)
      {
        i3 = i2;
        i2 = i1;
        break;
        i1 = 2130840190;
        break label147;
        i1 = 2130840234;
        break label147;
        i1 = 2130840228;
        break label147;
        i1 = 2130840241;
        break label147;
        i1 = 2130840263;
        break label147;
        paramHashMap.remove(Integer.valueOf(i5));
        i1 = i2;
        i2 = i3;
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetRadioGroup$OnCheckedChangeListener);
        if (i3 != 0) {
          this.jdField_i_of_type_Int = paramInt1;
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollRadioGroup.check(i4);
          return;
          if (i2 != 0) {
            this.jdField_i_of_type_Int = paramInt2;
          } else {
            this.jdField_i_of_type_Int = i4;
          }
        }
        i3 = i1;
        i1 = i2;
        i2 = i3;
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    Drawable localDrawable;
    if (paramBoolean) {
      if (!this.n.isEnabled())
      {
        localDrawable = this.n.getBackground();
        if (localDrawable != null) {
          localDrawable.setAlpha(255);
        }
        this.n.setEnabled(true);
      }
    }
    do
    {
      do
      {
        return;
      } while (!this.n.isEnabled());
      this.n.setEnabled(false);
      localDrawable = this.n.getBackground();
    } while (localDrawable == null);
    localDrawable.setAlpha(102);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  public void b(PublishDatingOption paramPublishDatingOption)
  {
    int i1 = paramPublishDatingOption.themeId;
    boolean bool = false;
    switch (i1)
    {
    default: 
      a(bool);
      return;
    case 5: 
      i1 = 0;
      int i2 = 0;
      str2 = "";
      str1 = "";
      str4 = "";
      localObject1 = "";
      String str5 = "";
      Object localObject2 = "";
      if (paramPublishDatingOption.time != -1L)
      {
        str2 = a(paramPublishDatingOption.time, 1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427972));
        this.jdField_f_of_type_AndroidWidgetTextView.setText(str2);
      }
      if (paramPublishDatingOption.depLocalState == 1)
      {
        this.jdField_g_of_type_AndroidViewView.setEnabled(true);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427972));
        if (paramPublishDatingOption.depLocal != null)
        {
          str1 = DatingUtil.a(paramPublishDatingOption.depLocal, -1);
          if (!TextUtils.isEmpty(str1))
          {
            this.jdField_g_of_type_AndroidWidgetTextView.setText(str1);
            i1 = 1;
          }
        }
        else
        {
          label202:
          if (paramPublishDatingOption.desLocal == null) {
            break label812;
          }
          String str6 = DatingUtil.a(paramPublishDatingOption.desLocal, paramPublishDatingOption.destType);
          str3 = str6;
          if (!TextUtils.isEmpty(str6))
          {
            this.jdField_h_of_type_AndroidWidgetTextView.setText(str6);
            i2 = 1;
            str3 = str6;
          }
          label249:
          if (paramPublishDatingOption.partCountId != -1)
          {
            str4 = a(paramPublishDatingOption.partCountId);
            this.jdField_i_of_type_AndroidWidgetTextView.setText(str4);
          }
          if (paramPublishDatingOption.genderId != -1)
          {
            localObject1 = b(paramPublishDatingOption.genderId);
            this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
          }
          if (paramPublishDatingOption.vehicleId != -1)
          {
            str5 = d(paramPublishDatingOption.vehicleId);
            this.jdField_k_of_type_AndroidWidgetTextView.setText(str5);
          }
          if ((!paramPublishDatingOption.hasIntro) || (TextUtils.isEmpty(paramPublishDatingOption.introduce))) {
            break label841;
          }
          paramPublishDatingOption = paramPublishDatingOption.introduce;
          localObject2 = new QQText(paramPublishDatingOption, 1, 16);
          this.jdField_l_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          label374:
          if ((i1 == 0) || (i2 == 0)) {
            break label866;
          }
        }
      }
      label812:
      label841:
      label866:
      for (bool = true;; bool = false)
      {
        this.jdField_f_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369932) + str2 + "连按两次修改约会时间");
        this.jdField_g_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369933) + str1);
        this.jdField_h_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369934) + str3);
        this.jdField_i_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369935) + str4 + "连按两次来选择人数");
        this.jdField_j_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369696) + (String)localObject1 + "连按两次来选择对象");
        this.jdField_k_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369936) + str5 + "连按两次来选择交通工具");
        this.jdField_l_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369688) + paramPublishDatingOption + "连按两次来进入其他说明页");
        break;
        i1 = 0;
        paramPublishDatingOption.depLocalState = -1;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131369937));
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427938));
        break label202;
        if (paramPublishDatingOption.depLocalState == 0)
        {
          i1 = 0;
          str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131369938);
          this.jdField_g_of_type_AndroidWidgetTextView.setText(str1);
          this.jdField_g_of_type_AndroidViewView.setEnabled(false);
          break label202;
        }
        i1 = 0;
        str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131369937);
        this.jdField_g_of_type_AndroidWidgetTextView.setText(str1);
        this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131427938));
        this.jdField_g_of_type_AndroidViewView.setEnabled(true);
        break label202;
        i2 = 0;
        str3 = "连按两次进入选择目的地页面";
        this.jdField_h_of_type_AndroidWidgetTextView.setText("");
        this.jdField_h_of_type_AndroidWidgetTextView.setHint(2131369817);
        break label249;
        this.jdField_l_of_type_AndroidWidgetTextView.setText("");
        this.jdField_l_of_type_AndroidWidgetTextView.setHint(2131369818);
        paramPublishDatingOption = (PublishDatingOption)localObject2;
        break label374;
      }
    }
    String str1 = "";
    String str2 = "";
    String str3 = "";
    String str4 = "";
    Object localObject1 = "";
    if (paramPublishDatingOption.time != -1L)
    {
      str1 = a(paramPublishDatingOption.time, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
    if ((paramPublishDatingOption.shopInfo != null) && (!TextUtils.isEmpty(paramPublishDatingOption.shopInfo.shopName)))
    {
      str2 = paramPublishDatingOption.shopInfo.shopName;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str2);
      bool = true;
      label964:
      if (paramPublishDatingOption.genderId != -1)
      {
        str3 = b(paramPublishDatingOption.genderId);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str3);
      }
      if (paramPublishDatingOption.payTypeId != -1)
      {
        str4 = c(paramPublishDatingOption.payTypeId);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(str4);
      }
      if ((!paramPublishDatingOption.hasIntro) || (TextUtils.isEmpty(paramPublishDatingOption.introduce))) {
        break label1294;
      }
      paramPublishDatingOption = paramPublishDatingOption.introduce;
      localObject1 = new QQText(paramPublishDatingOption, 1, 16);
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369932) + str1 + "连按两次修改约会时间");
      this.jdField_b_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369695) + str2 + "连按两次修改约会地点");
      this.jdField_c_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369696) + str3 + "连按两次修改约会对象");
      this.jdField_d_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369697) + str4 + "连按两次修改约会类型");
      this.jdField_e_of_type_AndroidViewView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131369688) + paramPublishDatingOption + "连按两次进入约会说明页");
      break;
      bool = false;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_b_of_type_AndroidWidgetTextView.setHint(2131369817);
      break label964;
      label1294:
      this.jdField_e_of_type_AndroidWidgetTextView.setText("");
      this.jdField_e_of_type_AndroidWidgetTextView.setHint(2131369818);
      paramPublishDatingOption = (PublishDatingOption)localObject1;
    }
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    if (paramViewStub == this.jdField_a_of_type_AndroidViewViewStub)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131300017);
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131300020);
      this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131300024);
      this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131300027);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131300030);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300018));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300023));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300025));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300028));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300033));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    while (paramViewStub != this.jdField_b_of_type_AndroidViewViewStub) {
      return;
    }
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131300053);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131300056);
    this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131300059);
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131300063);
    this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131300066);
    this.jdField_k_of_type_AndroidViewView = paramView.findViewById(2131300069);
    this.jdField_l_of_type_AndroidViewView = paramView.findViewById(2131300072);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300054));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300057));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300062));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300064));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300067));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300070));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131300075));
    this.jdField_f_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_i_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_l_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.PublishDatingHelper
 * JD-Core Version:    0.7.0.1
 */