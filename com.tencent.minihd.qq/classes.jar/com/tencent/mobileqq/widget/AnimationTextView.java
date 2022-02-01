package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.qphone.base.util.QLog;

public class AnimationTextView
  extends PatchedTextView
{
  private static final String jdField_a_of_type_JavaLangString = AnimationTextView.class.getSimpleName();
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public AnimationTextView.OnDoubleClick a;
  private boolean jdField_a_of_type_Boolean = false;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private MotionEvent b;
  
  public AnimationTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < m)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= 10000);
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (QQText.EmotcationSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), QQText.EmotcationSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.jdField_a_of_type_Boolean = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.a() == paramDrawable) {
            a(localObject2);
          }
          i += 1;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
      if ((this.b != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.b != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.b, paramMotionEvent)))
        {
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.b = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetAnimationTextView$OnDoubleClick != null) {
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        Layout localLayout = getLayout();
        if (localLayout == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        int k = getTotalPaddingLeft();
        int m = getTotalPaddingTop();
        int n = getScrollX();
        i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(j - m + getScrollY()), i - k + n);
        if (((ClickableSpan[])((Spannable)getText()).getSpans(i, i, ClickableSpan.class)).length == 0) {
          break label189;
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label189:
      this.b = MotionEvent.obtain(paramMotionEvent);
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int i = 0;
    if (getText() != paramCharSequence)
    {
      super.setText(paramCharSequence, paramBufferType);
      if ((getText() instanceof Spannable))
      {
        paramCharSequence = (Spannable)getText();
        paramCharSequence = (QQText.EmotcationSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), QQText.EmotcationSpan.class);
        paramBufferType = new Drawable[paramCharSequence.length];
        while (i < paramCharSequence.length)
        {
          paramBufferType[i] = paramCharSequence[i].a();
          paramBufferType[i].setCallback(this);
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramBufferType;
      }
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView
 * JD-Core Version:    0.7.0.1
 */