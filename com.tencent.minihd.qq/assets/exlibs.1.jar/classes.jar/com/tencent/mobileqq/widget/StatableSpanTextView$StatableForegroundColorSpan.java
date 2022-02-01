package com.tencent.mobileqq.widget;

import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.StateSet;
import java.util.ArrayList;
import java.util.Arrays;

public class StatableSpanTextView$StatableForegroundColorSpan
  extends ForegroundColorSpan
{
  public static final int[] a;
  private int jdField_a_of_type_Int;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  private int[] jdField_b_of_type_ArrayOfInt;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 16842919 };
  }
  
  public StatableSpanTextView$StatableForegroundColorSpan(int paramInt)
  {
    super(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public StatableSpanTextView$StatableForegroundColorSpan(int paramInt1, int paramInt2)
  {
    this(paramInt1);
    a(jdField_a_of_type_ArrayOfInt, Integer.valueOf(paramInt2));
  }
  
  public StatableSpanTextView$StatableForegroundColorSpan(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  private int a(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null) {
      return super.getForegroundColor();
    }
    int j = this.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (StateSet.stateSetMatches((int[])localArrayList.get(i), paramArrayOfInt)) {
        return ((Integer)this.jdField_b_of_type_JavaUtilArrayList.get(i)).intValue();
      }
      i += 1;
    }
    return super.getForegroundColor();
  }
  
  public int a(int[] paramArrayOfInt, Integer paramInteger)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayOfInt);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramInteger);
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.jdField_b_of_type_ArrayOfInt, paramArrayOfInt))
    {
      this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_a_of_type_Int = a(paramArrayOfInt);
    }
  }
  
  public int getForegroundColor()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan
 * JD-Core Version:    0.7.0.1
 */