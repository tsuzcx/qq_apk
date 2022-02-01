package com.tencent.mobileqq.activity.widget.doyen;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.QQDoyen;
import com.tencent.widget.widget.OnWheelScrollListener;
import com.tencent.widget.widget.WheelView;
import hcg;
import hch;
import hci;
import hcj;
import hck;
import hcm;
import java.util.ArrayList;
import java.util.List;

public class WidgetDoyen
  extends FrameLayout
{
  private static final int jdField_a_of_type_Int = 1000;
  private static final String jdField_a_of_type_JavaLangString = "连续登录";
  private static final int jdField_b_of_type_Int = 100;
  private static final String jdField_b_of_type_JavaLangString = "还有%s天你将超越全球%s的用户";
  private static final String jdField_c_of_type_JavaLangString = "变身QQ达人还需";
  private static final String d = "还有%s天变身QQ达人";
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DoyenEarthLayout jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenDoyenEarthLayout;
  private QQDoyen jdField_a_of_type_ComTencentMobileqqDataQQDoyen;
  OnWheelScrollListener jdField_a_of_type_ComTencentWidgetWidgetOnWheelScrollListener = new hck(this);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = { 2130838580, 2130838575, 2130838579, 2130838578, 2130838573, 2130838572, 2130838577, 2130838576, 2130838571, 2130838574 };
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private final int[] jdField_b_of_type_ArrayOfInt = { 2130838580, 2130838575, 2130838579, 2130838578, 2130838573, 2130838572, 2130838577, 2130838576, 2130838571, 2130838574 };
  private int[] jdField_c_of_type_ArrayOfInt;
  
  public WidgetDoyen(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WidgetDoyen(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WidgetDoyen(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(QQDoyen paramQQDoyen)
  {
    if (paramQQDoyen.sequenceDays < 3) {
      return 1.0F;
    }
    if ((paramQQDoyen.sequenceDays >= 3) && (paramQQDoyen.sequenceDays < 7)) {
      return 0.8F;
    }
    if ((paramQQDoyen.sequenceDays >= 7) && (paramQQDoyen.sequenceDays < 10)) {
      return 0.6F;
    }
    if ((paramQQDoyen.sequenceDays >= 10) && (paramQQDoyen.sequenceDays < 15)) {
      return 0.5F;
    }
    if ((paramQQDoyen.sequenceDays >= 15) && (paramQQDoyen.sequenceDays < 18)) {
      return 0.4F;
    }
    if ((paramQQDoyen.sequenceDays >= 18) && (paramQQDoyen.sequenceDays < 22)) {
      return 0.3F;
    }
    if ((paramQQDoyen.sequenceDays >= 22) && (paramQQDoyen.sequenceDays < 26)) {
      return 0.2F;
    }
    if ((paramQQDoyen.sequenceDays >= 26) && (paramQQDoyen.sequenceDays < 28)) {
      return 0.1F;
    }
    if ((paramQQDoyen.sequenceDays >= 28) && (paramQQDoyen.sequenceDays < 30)) {
      return 0.05F;
    }
    return 0.0F;
  }
  
  private int a(int paramInt)
  {
    int i = 0;
    int j = Math.abs(paramInt);
    paramInt = i;
    i = j;
    while (i > 0)
    {
      i /= 10;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private WheelView a(int paramInt)
  {
    WheelView localWheelView = new WheelView(getContext());
    localWheelView.a(this.jdField_a_of_type_ComTencentWidgetWidgetOnWheelScrollListener);
    localWheelView.setCurrentItem(0);
    localWheelView.setCyclic(false);
    localWheelView.setEnabled(true);
    localWheelView.setTag(Integer.valueOf(paramInt));
    localWheelView.setViewAdapter(a());
    localWheelView.a(new hci(this));
    localWheelView.setWheelViewOnClickListener(new hcj(this));
    return localWheelView;
  }
  
  private hcm a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.isDoyen) {
      return new hcm(this, getContext(), this.jdField_a_of_type_ArrayOfInt);
    }
    return new hcm(this, getContext(), this.jdField_b_of_type_ArrayOfInt);
  }
  
  private void a(int paramInt)
  {
    b(paramInt);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2130904528, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131296341));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302441));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302439));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302442));
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenDoyenEarthLayout = ((DoyenEarthLayout)findViewById(2131302438));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131302440));
  }
  
  private void a(WheelView paramWheelView)
  {
    if (paramWheelView == null) {
      return;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramWheelView.getTag().toString());
      if (this.jdField_a_of_type_Boolean)
      {
        paramWheelView.setCurrentItemCallListner(i);
        return;
      }
    }
    catch (Exception paramWheelView)
    {
      paramWheelView.printStackTrace();
      return;
    }
    paramWheelView.setCurrentItem(i, true);
  }
  
  private void a(WheelView paramWheelView, int paramInt1, int paramInt2)
  {
    paramWheelView.b(paramInt1, paramInt2);
  }
  
  private void b(int paramInt)
  {
    int j = 0;
    if (paramInt < 1) {
      return;
    }
    int i = a(paramInt);
    this.c = new int[i];
    int k;
    if (i > 1)
    {
      k = 0;
      i = paramInt;
      paramInt = k;
      while (i > 0)
      {
        this.c[paramInt] = (i % 10);
        i /= 10;
        paramInt += 1;
      }
    }
    this.c[0] = paramInt;
    paramInt = this.c.length - 1;
    i = 0;
    while (i <= paramInt)
    {
      k = this.c[i];
      this.c[i] = this.c[paramInt];
      this.c[paramInt] = k;
      i += 1;
      paramInt -= 1;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    paramInt = j;
    while (paramInt < this.c.length)
    {
      WheelView localWheelView = a(this.c[paramInt]);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localWheelView);
      this.jdField_a_of_type_JavaUtilList.add(localWheelView);
      paramInt += 1;
    }
    d();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen == null) {
      return;
    }
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.isDoyen)
    {
      str = String.format("还有%s天你将超越全球%s的用户", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.nextDays), this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.nextUserPer + "%" });
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840451);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.sequenceDays);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("连续登录");
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenDoyenEarthLayout.a(this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.isDoyen);
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenDoyenEarthLayout.setEarthCoverAlpha(a(this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840450);
      str = String.format("还有%s天变身QQ达人", new Object[] { this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen.becomeDoyenNeedDays + "" });
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    WheelView localWheelView = (WheelView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() - 1);
    localWheelView.postDelayed(new hch(this, localWheelView), 100L);
  }
  
  public QQDoyen a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen;
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    return paramInt1 + "月" + paramInt2 + "日";
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setDoyen(QQDoyen paramQQDoyen)
  {
    int i = 0;
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      i = 10000;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataQQDoyen = paramQQDoyen;
    postDelayed(new hcg(this), i);
  }
  
  public void setEarthCoverAlpha(QQDoyen paramQQDoyen)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetDoyenDoyenEarthLayout.setEarthCoverAlpha(a(paramQQDoyen));
  }
  
  public void setWidgetDoyenOnClickListner(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.doyen.WidgetDoyen
 * JD-Core Version:    0.7.0.1
 */