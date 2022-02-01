package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.QQBasePluginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.BasePadActivity;
import mqq.app.MyFragment;

public class NotRemoveFrameLayout
  extends FrameLayout
{
  public static final String a = "com.tencent.minihd.qq.action.drag";
  private static final int jdField_e_of_type_Int = 400;
  private static final int jdField_f_of_type_Int = 25;
  private static final int jdField_g_of_type_Int = 3;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  public boolean a;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int = 1;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = -1;
  private float jdField_e_of_type_Float;
  private float jdField_f_of_type_Float;
  private float jdField_g_of_type_Float;
  private float h;
  private float i = 0.0F;
  
  public NotRemoveFrameLayout(Context paramContext)
  {
    super(paramContext);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).getParent() == null)) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public NotRemoveFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (((paramContext instanceof Activity)) && (((Activity)paramContext).getParent() == null)) {}
    for (;;)
    {
      this.jdField_c_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  private void a()
  {
    Object localObject;
    if ((getContext() instanceof BaseActivity))
    {
      localObject = (BaseActivity)getContext();
      if (((BaseActivity)localObject).getParent() != null) {
        break label59;
      }
      ((BaseActivity)localObject).startScroll();
    }
    label58:
    label59:
    do
    {
      do
      {
        do
        {
          break label58;
          for (;;)
          {
            if ((getContext() instanceof QQBasePluginActivity))
            {
              localObject = (QQBasePluginActivity)getContext();
              if (((QQBasePluginActivity)localObject).getParent() != null) {
                break;
              }
              ((QQBasePluginActivity)localObject).c();
            }
            return;
            if (((BaseActivity)localObject).getRealFragmentCount() == 1)
            {
              localObject = (MyFragment)((BaseActivity)localObject).getTopFragment();
              if (localObject != null)
              {
                localObject = ((MyFragment)localObject).getBasePadAct();
                if ((localObject instanceof BaseActivity)) {
                  ((BaseActivity)localObject).startScroll();
                }
              }
            }
          }
        } while (((QQBasePluginActivity)localObject).getRealFragmentCount() != 1);
        localObject = (MyFragment)((QQBasePluginActivity)localObject).getTopFragment();
      } while (localObject == null);
      localObject = ((MyFragment)localObject).getBasePadAct();
    } while (!(localObject instanceof QQBasePluginActivity));
    ((QQBasePluginActivity)localObject).c();
  }
  
  private boolean a()
  {
    boolean bool2 = true;
    if (!b()) {
      return false;
    }
    Object localObject = (BasePadActivity)getContext();
    int j;
    boolean bool1;
    if (this.jdField_c_of_type_Boolean)
    {
      j = getChildCount();
      bool2 = ((BasePadActivity)localObject).isModeleWindow();
      if ((localObject instanceof BaseActivity)) {
        bool1 = ((BaseActivity)localObject).canDrag();
      }
    }
    for (;;)
    {
      if ((j > 0) && (!bool2) && (bool1)) {}
      for (bool1 = true;; bool1 = false)
      {
        return bool1;
        if (!(localObject instanceof QQBasePluginActivity)) {
          break label180;
        }
        bool1 = ((QQBasePluginActivity)localObject).c();
        break;
      }
      j = ((BasePadActivity)localObject).getRealFragmentCount();
      if (j == 1)
      {
        localObject = ((BasePadActivity)localObject).getTopFragment();
        if ((localObject instanceof MyFragment))
        {
          localObject = ((MyFragment)localObject).getBasePadAct();
          if (!(localObject instanceof BaseActivity)) {}
        }
      }
      for (bool1 = ((BaseActivity)localObject).canDrag();; bool1 = true)
      {
        if ((bool1) && (j > 0) && (getId() != 2131297931)) {}
        for (bool1 = bool2;; bool1 = false) {
          return bool1;
        }
      }
      label180:
      bool1 = false;
    }
  }
  
  private void b()
  {
    Object localObject;
    if ((getContext() instanceof BaseActivity))
    {
      localObject = (BaseActivity)getContext();
      if (((BaseActivity)localObject).getParent() != null) {
        break label59;
      }
      ((BaseActivity)localObject).startScroll();
    }
    label58:
    label59:
    do
    {
      do
      {
        do
        {
          break label58;
          for (;;)
          {
            if ((getContext() instanceof QQBasePluginActivity))
            {
              localObject = (QQBasePluginActivity)getContext();
              if (((QQBasePluginActivity)localObject).getParent() != null) {
                break;
              }
              ((QQBasePluginActivity)localObject).c();
            }
            return;
            if (((BaseActivity)localObject).getRealFragmentCount() == 1)
            {
              localObject = (MyFragment)((BaseActivity)localObject).getTopFragment();
              if (localObject != null)
              {
                localObject = ((MyFragment)localObject).getBasePadAct();
                if ((localObject instanceof BaseActivity)) {
                  ((BaseActivity)localObject).endScroll();
                }
              }
            }
          }
        } while (((QQBasePluginActivity)localObject).getRealFragmentCount() != 1);
        localObject = (MyFragment)((QQBasePluginActivity)localObject).getTopFragment();
      } while (localObject == null);
      localObject = ((MyFragment)localObject).getBasePadAct();
    } while (!(localObject instanceof QQBasePluginActivity));
    ((QQBasePluginActivity)localObject).d();
  }
  
  private boolean b()
  {
    return getContext() instanceof BasePadActivity;
  }
  
  public void addView(View paramView)
  {
    if (paramView.getParent() != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      if ((localViewGroup instanceof NotRemoveFrameLayout)) {
        ((NotRemoveFrameLayout)localViewGroup).jdField_a_of_type_Boolean = false;
      }
      localViewGroup.removeView(paramView);
    }
    super.addView(paramView);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((b()) && (this.jdField_b_of_type_Boolean))
    {
      if (!this.jdField_c_of_type_Boolean) {
        break label58;
      }
      ((Activity)getContext()).getWindow().getDecorView().setTranslationX(0.0F);
    }
    for (;;)
    {
      b();
      this.h = 0.0F;
      this.g = 0.0F;
      this.jdField_d_of_type_Int = -1;
      return;
      label58:
      getChildAt(getChildCount() - 1).scrollTo(0, 0);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!a()) {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      }
      while (!this.jdField_b_of_type_Boolean)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Boolean = false;
        float f1 = paramMotionEvent.getX();
        this.jdField_a_of_type_Float = f1;
        this.jdField_c_of_type_Float = f1;
        f1 = paramMotionEvent.getY();
        this.jdField_b_of_type_Float = f1;
        this.jdField_d_of_type_Float = f1;
        this.h = 0.0F;
        this.g = 0.0F;
        this.jdField_d_of_type_Int = -1;
        continue;
        this.e = (paramMotionEvent.getX() - this.jdField_c_of_type_Float);
        this.f = (paramMotionEvent.getY() - this.jdField_d_of_type_Float);
        this.jdField_c_of_type_Float = paramMotionEvent.getX();
        this.jdField_d_of_type_Float = paramMotionEvent.getY();
        if ((this.jdField_b_of_type_Boolean) || ((Math.abs(this.e) >= 3.0F * this.i) && (Math.abs(this.f / this.e) <= 1.0F)))
        {
          this.jdField_b_of_type_Boolean = true;
          getContext().sendBroadcast(new Intent("com.tencent.minihd.qq.action.drag"));
          a();
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int m = 0;
    boolean bool2 = true;
    BasePadActivity localBasePadActivity = (BasePadActivity)getContext();
    boolean bool1;
    if (this.jdField_c_of_type_Boolean)
    {
      j = getChildCount();
      if ((a()) && (this.jdField_b_of_type_Boolean)) {
        break label60;
      }
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label60:
    float f1;
    do
    {
      return bool1;
      j = localBasePadActivity.getRealFragmentCount();
      break;
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
      case 0: 
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Boolean = false;
        f1 = paramMotionEvent.getX();
        this.jdField_a_of_type_Float = f1;
        this.jdField_c_of_type_Float = f1;
        f1 = paramMotionEvent.getY();
        this.jdField_b_of_type_Float = f1;
        this.jdField_d_of_type_Float = f1;
        this.h = 0.0F;
        this.g = 0.0F;
        this.jdField_d_of_type_Int = -1;
        return true;
      case 2: 
        this.e = (paramMotionEvent.getX() - this.jdField_c_of_type_Float);
        this.f = (paramMotionEvent.getY() - this.jdField_d_of_type_Float);
        this.jdField_c_of_type_Float = paramMotionEvent.getX();
        this.jdField_d_of_type_Float = paramMotionEvent.getY();
        bool1 = bool2;
      }
    } while (this.e == 0.0F);
    if (this.e > 0.0F)
    {
      k = 1;
      label220:
      this.g += this.e;
      if ((this.jdField_d_of_type_Int != k) && (Math.abs(this.e) >= 3.0F * this.i)) {
        this.jdField_d_of_type_Int = k;
      }
      if (getResources().getConfiguration().orientation != 1) {
        break label399;
      }
    }
    label399:
    for (int k = 1;; k = 0)
    {
      if (!this.jdField_c_of_type_Boolean)
      {
        bool1 = bool2;
        if (j != 1) {
          break;
        }
        if (getId() == 2131302160)
        {
          bool1 = bool2;
          if (k == 0) {
            break;
          }
        }
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label405;
      }
      paramMotionEvent = ((Activity)getContext()).getWindow().getDecorView();
      if (this.jdField_d_of_type_Int != 1)
      {
        j = m;
        if (this.jdField_d_of_type_Int == 0)
        {
          j = m;
          if (paramMotionEvent.getTranslationX() + this.e < 0.0F) {}
        }
      }
      else
      {
        j = 1;
      }
      bool1 = bool2;
      if (j == 0) {
        break;
      }
      paramMotionEvent.setTranslationX(this.g);
      return true;
      k = 0;
      break label220;
    }
    label405:
    paramMotionEvent = getChildAt(getChildCount() - 1);
    if ((this.jdField_d_of_type_Int == 1) || ((this.jdField_d_of_type_Int == 0) && (paramMotionEvent.getScrollX() - this.e <= 0.0F))) {}
    for (int j = 1;; j = 0)
    {
      bool1 = bool2;
      if (j == 0) {
        break;
      }
      paramMotionEvent.scrollBy((int)-this.e, 0);
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      f1 = this.g * 1000.0F / (float)(l1 - l2);
      if (!this.jdField_c_of_type_Boolean) {
        break label633;
      }
      paramMotionEvent = ((Activity)getContext()).getWindow().getDecorView();
      if (this.jdField_d_of_type_Int != 1) {
        break label647;
      }
      j = 1;
      label538:
      if (this.g < paramMotionEvent.getWidth() / 5) {
        break label652;
      }
      k = 1;
      label556:
      if ((this.g < 25.0F * this.i) || (f1 < 400.0F * this.i)) {
        break label658;
      }
      m = 1;
      label588:
      if ((j == 0) || ((k == 0) && (m == 0))) {
        break label687;
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        paramMotionEvent = (Activity)getContext();
        paramMotionEvent.finish();
      }
      catch (Exception paramMotionEvent)
      {
        label633:
        paramMotionEvent.printStackTrace();
        label647:
        label652:
        label658:
        continue;
      }
      this.h = 0.0F;
      this.g = 0.0F;
      return true;
      paramMotionEvent = getChildAt(getChildCount() - 1);
      break;
      j = 0;
      break label538;
      k = 0;
      break label556;
      m = 0;
      break label588;
      paramMotionEvent = ((MyFragment)localBasePadActivity.getTopFragment()).getBasePadAct();
    }
    label687:
    if (this.jdField_c_of_type_Boolean) {
      paramMotionEvent.setTranslationX(0.0F);
    }
    for (;;)
    {
      b();
      break;
      paramMotionEvent.scrollTo(0, 0);
    }
  }
  
  public void removeView(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.removeView(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NotRemoveFrameLayout
 * JD-Core Version:    0.7.0.1
 */