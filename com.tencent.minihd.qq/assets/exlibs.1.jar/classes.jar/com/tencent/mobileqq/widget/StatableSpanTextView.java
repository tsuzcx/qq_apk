package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.ArrayList;

public class StatableSpanTextView
  extends TextView
{
  private ImageSpan[] jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
  private StatableSpanTextView.StatableForegroundColorSpan[] jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
  
  public StatableSpanTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatableSpanTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    int j = 0;
    super.drawableStateChanged();
    int[] arrayOfInt;
    Object localObject;
    int k;
    int i;
    if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        Drawable localDrawable = localObject[i].getDrawable();
        if (localDrawable.isStateful()) {
          localDrawable.setState(arrayOfInt);
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan != null)
    {
      arrayOfInt = getDrawableState();
      localObject = this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        localObject[i].a(arrayOfInt);
        i += 1;
      }
    }
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Spannable localSpannable;
    if ((paramCharSequence != null) && ((paramCharSequence instanceof Spannable)))
    {
      localSpannable = (Spannable)paramCharSequence;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localSpannable.getSpans(0, localSpannable.length(), ImageSpan.class));
      if (this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan != null)
      {
        ArrayList localArrayList = new ArrayList();
        ImageSpan[] arrayOfImageSpan = this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan;
        int j = arrayOfImageSpan.length;
        int i = 0;
        while (i < j)
        {
          ImageSpan localImageSpan = arrayOfImageSpan[i];
          if (!(localImageSpan instanceof ClickableImageSpan)) {
            localArrayList.add(localImageSpan);
          }
          i += 1;
        }
        if (localArrayList.size() <= 0) {
          break label172;
        }
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = new ImageSpan[localArrayList.size()];
        this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = ((ImageSpan[])localArrayList.toArray(this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan));
      }
    }
    for (this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = ((StatableSpanTextView.StatableForegroundColorSpan[])localSpannable.getSpans(0, localSpannable.length(), StatableSpanTextView.StatableForegroundColorSpan.class));; this.jdField_a_of_type_ArrayOfComTencentMobileqqWidgetStatableSpanTextView$StatableForegroundColorSpan = null)
    {
      super.setText(paramCharSequence, paramBufferType);
      return;
      label172:
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
      break;
      this.jdField_a_of_type_ArrayOfAndroidTextStyleImageSpan = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView
 * JD-Core Version:    0.7.0.1
 */