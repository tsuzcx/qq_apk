package com.tencent.mobileqq.activity.recent.cur;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import gvv;

public class DragTextView
  extends TextView
  implements IDragView
{
  public static final String a = "tab_tag";
  private final float jdField_a_of_type_Float = 12.0F * getResources().getDisplayMetrics().density;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final TouchDelegate jdField_a_of_type_AndroidViewTouchDelegate = new gvv(this, this.jdField_a_of_type_AndroidGraphicsRect, this);
  private IDragView.OnChangeModeListener jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  private boolean jdField_a_of_type_Boolean;
  private int f = -1;
  
  public DragTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DragTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a()
  {
    if ("tab_tag".equals(getTag()))
    {
      for (Object localObject = this; (localObject != null) && (!(((View)localObject).getParent() instanceof TabWidget)); localObject = (View)((View)localObject).getParent()) {}
      if ((localObject != null) && ((((View)localObject).getParent() instanceof TabWidget)))
      {
        ViewGroup localViewGroup = (ViewGroup)((View)localObject).getParent();
        int i = localViewGroup.indexOfChild((View)localObject);
        for (localObject = (View)localViewGroup.getParent(); (localObject != null) && (!(localObject instanceof TabHost)); localObject = (View)((View)localObject).getParent()) {}
        if ((localObject instanceof TabHost))
        {
          localObject = (TabHost)localObject;
          if ((localObject != null) && (((TabHost)localObject).getCurrentTab() != i)) {
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public IDragView.OnChangeModeListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null)
    {
      getHitRect(this.jdField_a_of_type_AndroidGraphicsRect);
      Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.top = ((int)(localRect.top - this.jdField_a_of_type_Float * 1.5D));
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.bottom = ((int)(localRect.bottom + this.jdField_a_of_type_Float));
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.left = ((int)(localRect.left - this.jdField_a_of_type_Float));
      localRect = this.jdField_a_of_type_AndroidGraphicsRect;
      localRect.right = ((int)(localRect.right + this.jdField_a_of_type_Float * 1.5D));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.f != -1) && (!this.jdField_a_of_type_Boolean) && (paramMotionEvent.getAction() == 0) && (a()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener.a(this, this.f);
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setDragViewType(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setOnModeChangeListener(IDragView.OnChangeModeListener paramOnChangeModeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener = paramOnChangeModeListener;
    if (QLog.isColorLevel()) {
      QLog.d("Drag", 2, "setOnModeChangeListener:" + paramOnChangeModeListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurIDragView$OnChangeModeListener != null) {
      ((ViewGroup)getParent()).setTouchDelegate(this.jdField_a_of_type_AndroidViewTouchDelegate);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.DragTextView
 * JD-Core Version:    0.7.0.1
 */