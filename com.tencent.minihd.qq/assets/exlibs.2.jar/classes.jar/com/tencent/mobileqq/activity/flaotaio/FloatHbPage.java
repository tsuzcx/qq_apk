package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.util.SizeMeasure;
import gmd;
import gme;
import gmf;

public class FloatHbPage
{
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public FloatHbPage.FloatHbCallBack a;
  private SlipFrameLayout jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout;
  boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public FloatHbPage(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density;
    SizeMeasure.b(paramContext);
    c();
  }
  
  private void c()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903321, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout = ((SlipFrameLayout)localView);
    this.jdField_a_of_type_AndroidViewView = localView;
    this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131297702);
    try
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838379);
      this.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(localDrawable);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new gmd(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout.setCallBack(new gme(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297703));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131297704));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297705));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297706));
      this.c = ((TextView)localView.findViewById(2131297707));
      this.d = ((TextView)localView.findViewById(2131297708));
      this.e = ((TextView)localView.findViewById(2131297709));
      this.e.setOnClickListener(new gmf(this));
      return;
    }
    catch (Error localError)
    {
      for (;;)
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundColor(-65536);
      }
    }
  }
  
  public void a()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioSlipFrameLayout.a();
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.flags = 40;
      localLayoutParams.format = -3;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.type = 2002;
      localLayoutParams.windowAnimations = 2131558950;
    }
    try
    {
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(int paramInt)
  {
    this.c.setTextSize(paramInt);
  }
  
  public void a(Drawable paramDrawable, String paramString1, String paramString2)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (TextUtils.isEmpty(paramString1)) {
        break label89;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText("来自" + paramString1);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label100;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString2);
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838406);
      break;
      label89:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    label100:
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
  }
  
  public void a(FloatHbPage.FloatHbCallBack paramFloatHbCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHbPage$FloatHbCallBack = paramFloatHbCallBack;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.c.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2))
    {
      this.d.setVisibility(0);
      this.d.setText(paramString2);
    }
    while (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.d.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatHbPage
 * JD-Core Version:    0.7.0.1
 */