package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class EmoticonPageIndicator
  extends EmoticonPagerRadioGroup
{
  private static final String a = "EmoticonPageIndicator";
  
  public EmoticonPageIndicator(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPageIndicator
 * JD-Core Version:    0.7.0.1
 */