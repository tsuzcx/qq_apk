package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import lsy;
import lsz;
import lta;

public class TipsPopupWindow
  extends PopupWindow
  implements TipsLinearLayout.TipsLayoutAnimListener
{
  public static final float a = 42.0F;
  public static final int a = 1000;
  private static final String jdField_a_of_type_JavaLangString = "TipsPopupWindow";
  private static final int jdField_d_of_type_Int = 300;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TipsLinearLayout jdField_a_of_type_ComTencentWidgetTipsLinearLayout;
  private lta jdField_a_of_type_Lta;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private boolean b;
  public int c;
  private boolean c;
  private boolean jdField_d_of_type_Boolean;
  
  public TipsPopupWindow(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    a(paramContext);
  }
  
  public TipsPopupWindow(Context paramContext, Drawable paramDrawable, String paramString)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    a(paramContext);
    a(paramDrawable);
    a(paramString);
  }
  
  private void a(Activity paramActivity)
  {
    float f = this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources().getDimension(2131492875);
    Rect localRect = new Rect();
    if (paramActivity == null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = ((int)(f + 42.0F));
      return;
    }
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = ((int)(f + localRect.top));
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130903178, null));
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout = ((TipsLinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297219));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297221));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131297220));
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    localDisplay.getMetrics(new DisplayMetrics());
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    int k = (int)paramContext.getResources().getDimension(2131492872);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.measure(i, k);
    int m = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredWidth();
    int n = this.jdField_a_of_type_AndroidWidgetFrameLayout.getMeasuredHeight();
    setWidth(i);
    setHeight(k);
    if (QLog.isColorLevel()) {
      QLog.d("popup", 2, "initPopupWindow:width:" + m + ",height:" + n + ",screenWidth:" + i + ",screenHeight:" + j);
    }
    j = (int)paramContext.getResources().getDimension(2131492880);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.getLayoutParams()).width = (i - j * 2);
    paramContext = paramContext.getResources().getDrawable(2130842077);
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.setBackgroundDrawable(paramContext);
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.requestLayout();
    setWindowLayoutMode(-2, -2);
    setBackgroundDrawable(null);
    setContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    setAnimationStyle(2131558855);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.setmTipsLayoutAnimListener(this);
    this.jdField_a_of_type_Lta = new lta(this);
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(this.jdField_a_of_type_Lta, 1000L);
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.d)) {
      return;
    }
    this.d = true;
    f();
  }
  
  private void e()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.a();
      this.jdField_c_of_type_Boolean = true;
      this.d = false;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_Lta);
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).stop();
    }
    this.jdField_a_of_type_ComTencentWidgetTipsLinearLayout.b();
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean) {
      ((Animatable)this.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).start();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
  }
  
  public void a(Activity paramActivity, boolean paramBoolean, int paramInt)
  {
    if (this.jdField_c_of_type_Int == 0) {
      a(paramActivity);
    }
    showAtLocation(this.jdField_a_of_type_AndroidWidgetFrameLayout, 48, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(new lsy(this), paramInt);
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    if ((paramDrawable instanceof Animatable))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.invalidate();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.post(new lsz(this));
  }
  
  public void b(int paramInt)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(paramInt);
    if (localDrawable == null)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    if ((localDrawable instanceof Animatable))
    {
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_Lta);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    super.dismiss();
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TipsPopupWindow", 2, "dismiss");
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeCallbacks(this.jdField_a_of_type_Lta);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.postDelayed(this.jdField_a_of_type_Lta, 300L);
  }
  
  public void showAsDropDown(View paramView)
  {
    super.showAsDropDown(paramView);
    e();
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    super.showAsDropDown(paramView, paramInt1, paramInt2);
    e();
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.TipsPopupWindow
 * JD-Core Version:    0.7.0.1
 */