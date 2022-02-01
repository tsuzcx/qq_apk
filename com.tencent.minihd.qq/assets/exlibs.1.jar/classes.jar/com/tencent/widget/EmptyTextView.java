package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class EmptyTextView
  extends TextView
{
  public CharSequence a;
  public boolean a;
  
  public EmptyTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmptyTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmptyTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setIsNormalTextView(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = "";
    if (this.jdField_a_of_type_Boolean) {
      localObject = paramCharSequence;
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.EmptyTextView
 * JD-Core Version:    0.7.0.1
 */