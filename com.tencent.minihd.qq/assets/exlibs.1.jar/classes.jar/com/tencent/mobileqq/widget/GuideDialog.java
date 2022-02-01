package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;

public class GuideDialog
  extends Dialog
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 1.0F;
  private static final int jdField_a_of_type_Int = 140;
  private static final String jdField_a_of_type_JavaLangString = "shown";
  private static final int jdField_b_of_type_Int = 38;
  private static final boolean jdField_b_of_type_Boolean = true;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean = false;
  private int c;
  private int d = -1;
  private int e;
  
  public GuideDialog(Context paramContext)
  {
    this(paramContext, 2131558953);
  }
  
  public GuideDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  protected GuideDialog(Context paramContext, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    super(paramContext, paramBoolean, paramOnCancelListener);
  }
  
  public static Dialog a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (a(paramContext, paramString, paramBoolean))
    {
      paramContext = new GuideDialog(paramContext);
      paramContext.setContentView(paramInt);
      paramContext.show();
      return paramContext;
    }
    return null;
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    Drawable localDrawable;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!(paramView instanceof ViewGroup)) {
            break;
          }
          paramView = (ViewGroup)paramView;
          int j = paramView.getChildCount();
          int i = 0;
          while (i < j)
          {
            a(paramView.getChildAt(i));
            i += 1;
          }
        }
      } while (!(paramView instanceof ImageView));
      paramView = (ImageView)paramView;
      localDrawable = paramView.getDrawable();
    } while ((localDrawable == null) || (!XfermodeDrawable.a(localDrawable)));
    paramView.setImageDrawable(null);
    paramView.setImageDrawable(XfermodeDrawable.a(localDrawable, new PorterDuffXfermode(PorterDuff.Mode.SRC)));
  }
  
  private static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = paramString;
    if (paramBoolean) {
      str = paramString + "_" + 1.0F;
    }
    paramContext = ReflectedMethods.a(paramContext, str);
    paramBoolean = paramContext.getBoolean("shown", true);
    if (paramBoolean) {
      paramContext.edit().putBoolean("shown", false).commit();
    }
    return paramBoolean;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = getContext().getResources().getDisplayMetrics().widthPixels;
    if (QLog.isDevelopLevel()) {
      QLog.d("GuideGame", 4, "gameCenterY=" + this.d + " itemY=" + paramInt1 + " screenW=" + this.e + " tmpW=" + paramInt2);
    }
    if ((this.d == paramInt1) && (this.e == paramInt2)) {
      return;
    }
    this.d = paramInt1;
    this.e = paramInt2;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(getContext().getResources(), 2130838489, (BitmapFactory.Options)localObject);
    paramInt2 = ((BitmapFactory.Options)localObject).outWidth;
    int i = ((BitmapFactory.Options)localObject).outHeight;
    float f = this.e * 1.0F / paramInt2;
    this.c = ((int)(140.0F * f));
    paramInt2 = (int)(i * f);
    ((RelativeLayout)findViewById(2131297924)).setOnClickListener(this);
    paramInt1 = paramInt3 + paramInt1;
    localObject = findViewById(2131297925);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.height = paramInt1;
    ((View)localObject).setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297926));
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = findViewById(2131297928);
    localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.topMargin = paramInt1;
    localLayoutParams.height = this.c;
    ((View)localObject).setLayoutParams(localLayoutParams);
    ((View)localObject).setOnClickListener(this);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addContentView(paramView, paramLayoutParams);
    a(getWindow().getDecorView());
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297924: 
      cancel();
      return;
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_AndroidViewView$OnClickListener = null;
    }
    cancel();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      cancel();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a(getWindow().getDecorView());
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    a(getWindow().getDecorView());
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    a(getWindow().getDecorView());
  }
  
  public void show()
  {
    try
    {
      super.show();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideDialog
 * JD-Core Version:    0.7.0.1
 */