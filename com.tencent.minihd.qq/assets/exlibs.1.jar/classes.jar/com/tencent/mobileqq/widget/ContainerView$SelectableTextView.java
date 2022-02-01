package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kxi;
import kxj;
import kxk;

public class ContainerView$SelectableTextView
  extends TextView
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new kxj(this);
  private SelectableTextView jdField_a_of_type_ComTencentMobileqqWidgetContainerView$SelectableTextView = this;
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext)
  {
    this(paramContainerView, paramContext, null);
  }
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContainerView, paramContext, paramAttributeSet, 0);
  }
  
  public ContainerView$SelectableTextView(ContainerView paramContainerView, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    clearFocus();
    setTextIsSelectable(true);
    setBackgroundColor(17170445);
    setGravity(19);
    setScroller(null);
    setHighlightColor(1722605812);
    setTextSelectHandle(2130842054);
    setTextSelectHandleLeft(2130842053);
    setTextSelectHandleRight(2130842055);
    setTextSize(28.0F);
    setTextColor(-16777216);
    setVisibility(4);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new kxi(this, paramContainerView));
    }
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return -2147483648;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = getScrollX();
    return localLayout.getOffsetForHorizontal(localLayout.getLineForVertical((int)(paramMotionEvent.getY() + getScrollY())), f1 + f2);
  }
  
  private void a()
  {
    try
    {
      Method localMethod = TextView.class.getDeclaredMethod("hideSelectionModifierCursorController", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      Selection.removeSelection((Spannable)getText());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean a(Context paramContext)
  {
    return getSelectionEnd() - getSelectionStart() > 0;
  }
  
  protected boolean getDefaultEditable()
  {
    return false;
  }
  
  protected MovementMethod getDefaultMovementMethod()
  {
    return ArrowKeyMovementMethod.getInstance();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    if (Build.VERSION.SDK_INT < 11)
    {
      Rect localRect = new Rect();
      getGlobalVisibleRect(localRect);
      if (!localRect.contains((int)f1, (int)f2)) {
        break label106;
      }
      if (paramMotionEvent.getAction() == 0)
      {
        this.jdField_a_of_type_Int = a(paramMotionEvent);
        if ((getSelectionEnd() - getSelectionStart() > 0) && ((this.jdField_a_of_type_Int < getSelectionStart()) || (this.jdField_a_of_type_Int > getSelectionEnd()))) {
          a();
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label106:
      a();
    }
  }
  
  public void setTextIsSelectable(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setTextIsSelectable(paramBoolean);
      return;
    }
    setFocusable(true);
    setFocusableInTouchMode(true);
    setClickable(paramBoolean);
    setOnLongClickListener(new kxk(this));
  }
  
  public void setTextSelectHandle(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setTextSelectHandleLeft(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleLeftRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setTextSelectHandleRight(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleRightRes");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ContainerView.SelectableTextView
 * JD-Core Version:    0.7.0.1
 */