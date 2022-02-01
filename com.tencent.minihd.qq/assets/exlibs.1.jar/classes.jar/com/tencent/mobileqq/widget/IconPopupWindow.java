package com.tencent.mobileqq.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import kyb;
import kyc;
import kyd;

public class IconPopupWindow
{
  public static final int a = 0;
  public static final Integer a;
  public static final int b = 1;
  public static final Integer b;
  public static final int c = 2;
  public static final Integer c;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = -1;
  public static final int h = 2;
  public static final int i = 3;
  public static final int j = 5;
  private static final int k = 16;
  private static final int l = 145;
  private static final int m = 250;
  private static final int n = 7;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private PopupWindow.OnDismissListener jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private BoundedLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout;
  private boolean jdField_a_of_type_Boolean = false;
  private BoundedLinearLayout b;
  private BoundedLinearLayout c;
  private int o = 0;
  private int p = -1;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(0);
    jdField_b_of_type_JavaLangInteger = Integer.valueOf(1);
    jdField_c_of_type_JavaLangInteger = Integer.valueOf(4);
  }
  
  public IconPopupWindow(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context is null");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public static final int a(TextView paramTextView, String paramString)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString))) {
      return 0;
    }
    Rect localRect = new Rect();
    paramTextView.getPaint().getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.width();
  }
  
  public static final IconPopupWindow a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    paramContext = new IconPopupWindow(paramContext);
    paramContext.a(2131367817, jdField_a_of_type_JavaLangInteger, paramOnClickListener);
    paramContext.a(2131367820, jdField_b_of_type_JavaLangInteger, paramOnClickListener);
    paramContext.a(2131367821, jdField_c_of_type_JavaLangInteger, paramOnClickListener);
    return paramContext;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130903342, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout = ((BoundedLinearLayout)localView.findViewById(2131297791));
    this.jdField_b_of_type_ComTencentMobileqqWidgetBoundedLinearLayout = ((BoundedLinearLayout)localView.findViewById(2131297788));
    this.jdField_c_of_type_ComTencentMobileqqWidgetBoundedLinearLayout = ((BoundedLinearLayout)localView.findViewById(2131297790));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(localView);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-2, -2);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(paramContext.getResources().getDrawable(17170445));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setClippingEnabled(false);
  }
  
  public static final IconPopupWindow b(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    paramContext = new IconPopupWindow(paramContext);
    paramContext.a(2131367817, jdField_a_of_type_JavaLangInteger, paramOnClickListener);
    paramContext.a(2131367820, jdField_b_of_type_JavaLangInteger, paramOnClickListener);
    paramContext.a(2131367821, jdField_c_of_type_JavaLangInteger, paramOnClickListener);
    paramContext.a(2131363587, 5, paramOnClickListener);
    return paramContext;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new kyb(this);
    }
    IntentFilter localIntentFilter = new IntentFilter("action_on_configuration_changed");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return this.o;
  }
  
  public TextView a(int paramInt)
  {
    if (paramInt >= this.o) {
      return null;
    }
    return (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getChildAt(paramInt);
  }
  
  public IconPopupWindow a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext()).inflate(2130903344, null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.addView(localView);
    return this;
  }
  
  public IconPopupWindow a(int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt2);
    return a(localResources.getString(paramInt1), localDrawable, paramInt3, null, paramOnClickListener);
  }
  
  public IconPopupWindow a(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getString(paramInt1), null, paramInt2, null, paramOnClickListener);
  }
  
  public IconPopupWindow a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getString(paramInt), paramOnClickListener);
  }
  
  public IconPopupWindow a(int paramInt, Object paramObject, View.OnClickListener paramOnClickListener)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getString(paramInt), null, -1, paramObject, paramOnClickListener);
  }
  
  public IconPopupWindow a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = paramOnDismissListener;
    return this;
  }
  
  public IconPopupWindow a(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    return a(paramString, this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getResources().getDrawable(paramInt1), paramInt2, null, paramOnClickListener);
  }
  
  public IconPopupWindow a(String paramString, int paramInt1, int paramInt2, Object paramObject, View.OnClickListener paramOnClickListener)
  {
    return a(paramString, this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext().getResources().getDrawable(paramInt1), paramInt2, paramObject, paramOnClickListener);
  }
  
  public IconPopupWindow a(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    return a(paramString, null, paramInt, null, paramOnClickListener);
  }
  
  public IconPopupWindow a(String paramString, Drawable paramDrawable, int paramInt, Object paramObject, View.OnClickListener paramOnClickListener)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getContext()).inflate(2130903343, null);
    TextView localTextView = (TextView)localView.findViewById(2131296641);
    ImageView localImageView = (ImageView)localView.findViewById(2131296551);
    localTextView.setText(paramString);
    if (paramDrawable != null)
    {
      localImageView.setImageDrawable(paramDrawable);
      localImageView.setVisibility(0);
    }
    if (paramObject != null)
    {
      localView.setTag(paramObject);
      if (paramObject == null) {
        break label158;
      }
      localTextView.setTag(paramObject);
    }
    for (;;)
    {
      this.o += 1;
      localView.setOnClickListener(new kyc(this, paramOnClickListener, localTextView));
      if (paramInt != -1)
      {
        localView.setId(paramInt);
        localTextView.setId(paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.addView(localView);
      return this;
      localView.setTag(Integer.valueOf(this.o));
      break;
      label158:
      localTextView.setTag(Integer.valueOf(this.o));
    }
  }
  
  public IconPopupWindow a(String paramString, View.OnClickListener paramOnClickListener)
  {
    return a(paramString, null, -1, null, paramOnClickListener);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
    }
    d();
  }
  
  public void a(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.o)
    {
      if (i1 == paramInt)
      {
        this.p = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getChildAt(i1).setSelected(true);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getChildAt(i1).setSelected(false);
      }
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    a(paramView, paramInt, 10, 12);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new kyd(this, paramInt2, paramInt3, paramInt1, paramView, arrayOfInt));
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, 0, 0);
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedHeight(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493868) * 7);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedWidth(AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493868);
      int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493499);
      this.jdField_b_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedHeight(i1 * 7 + i2 * 2);
      this.jdField_b_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedWidth(AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_c_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedHeight(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131493868) * 7);
      this.jdField_c_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.setBoundedWidth(AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) && (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing());
  }
  
  public IconPopupWindow b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.removeAllViews();
    return this;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(null);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow$OnDismissListener = null;
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqWidgetBoundedLinearLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.IconPopupWindow
 * JD-Core Version:    0.7.0.1
 */