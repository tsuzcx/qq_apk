package com.etrump.mixlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;
import com.tencent.qphone.base.util.QLog;

public class ETTextView
  extends AnimationTextView
{
  static final String jdField_a_of_type_JavaLangString = "ETTextView";
  public int a;
  private long jdField_a_of_type_Long;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public ETFont a;
  private ETLayout jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  private int c;
  
  public ETTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  public ETTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null) {
      return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt1, paramInt2);
    }
    return -1;
  }
  
  public ETLayout a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETLayout;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId != 0)
      {
        bool1 = bool2;
        if (!ETEngine.getInstance().native_containComplexScript(getText().toString())) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!a())
    {
      super.onDraw(paramCanvas);
      return;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor != getTextColors().getDefaultColor()) {}
    try
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontColor = getTextColors().getDefaultColor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_ComEtrumpMixlayoutETFont.mFontColor = getLinkTextColors().getDefaultColor();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.c();
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramCanvas, getPaddingLeft(), getPaddingTop());
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETTextView", 2, "onDraw err" + localThrowable.getMessage());
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!a())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int n;
    int m;
    int j;
    int k;
    int i;
    for (;;)
    {
      try
      {
        n = View.MeasureSpec.getMode(paramInt1);
        m = View.MeasureSpec.getMode(paramInt2);
        j = View.MeasureSpec.getSize(paramInt1);
        k = View.MeasureSpec.getSize(paramInt2);
        if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int != this.jdField_b_of_type_Int))
        {
          i = 1;
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout == null) || (i != 0)) {
            this.jdField_a_of_type_ComEtrumpMixlayoutETLayout = new ETLayout();
          }
          this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {
            break label448;
          }
          i = this.jdField_b_of_type_Int;
          int i1 = getPaddingLeft();
          int i2 = getPaddingRight();
          if (n == -2147483648) {}
          int i3 = getLinkTextColors().getDefaultColor();
          if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)
          {
            this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(getTextColors().getDefaultColor());
            this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setSize(getTextSize());
          }
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(this.c);
          this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i - (i1 + i2), getText(), this.jdField_a_of_type_ComEtrumpMixlayoutETFont, i3);
          if ((this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int < 2048) && (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int < 2048)) {
            break;
          }
          throw new Exception("large bitmap width=" + 0 + ", height=" + 0);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ETTextView", 2, "measure fail " + localThrowable.getMessage());
        }
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = 0;
        this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Long = -1L;
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
      i = 0;
    }
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Boolean) {
      throw new Exception("no text use system measure2");
    }
    for (;;)
    {
      setMeasuredDimension(j, i);
      return;
      label371:
      j = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_a_of_type_Int + getPaddingLeft() + getPaddingRight();
      label445:
      label448:
      while (m != 1073741824)
      {
        if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null)
        {
          i = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.jdField_b_of_type_Int + getPaddingTop() + getPaddingBottom();
          if (m != -2147483648) {
            break label445;
          }
          i = Math.min(i, k);
          break;
        }
        throw new Exception("measure height fail Layout is null");
        break;
        if (n != 1073741824) {
          break label371;
        }
      }
      i = k;
    }
  }
  
  public boolean onPreDraw()
  {
    if (!a()) {
      return super.onPreDraw();
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!a()) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        int k = getPaddingLeft();
        int m = getPaddingTop();
        int n = getScrollX();
        int i1 = getScrollY();
        i = this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(i - k + n, j - m + i1) + 1;
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class);
        if (arrayOfClickableSpan.length != 0)
        {
          arrayOfClickableSpan[0].onClick(this);
          return true;
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setFont(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(paramInt, "", getTextSize());
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return;
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.mFontId = paramInt;
    }
  }
  
  public void setLinkBackcolor(int paramInt)
  {
    this.c = paramInt;
    if (this.jdField_a_of_type_ComEtrumpMixlayoutETLayout != null) {
      this.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a(paramInt);
    }
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    super.setMaxWidth(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView
 * JD-Core Version:    0.7.0.1
 */