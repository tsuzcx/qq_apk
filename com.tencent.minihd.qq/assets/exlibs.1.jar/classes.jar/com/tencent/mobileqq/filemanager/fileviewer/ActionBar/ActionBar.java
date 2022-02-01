package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View.OnClickListener;

public class ActionBar
{
  private StateListDrawable jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private String jdField_a_of_type_JavaLangString;
  
  public StateListDrawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable;
  }
  
  public View.OnClickListener a()
  {
    return this.jdField_a_of_type_AndroidViewView$OnClickListener;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable = new StateListDrawable();
    Drawable localDrawable = paramContext.getResources().getDrawable(paramInt1);
    paramContext = paramContext.getResources().getDrawable(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842919, 16842910 }, paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[] { 16842910 }, localDrawable);
    this.jdField_a_of_type_AndroidGraphicsDrawableStateListDrawable.addState(new int[0], localDrawable);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBar
 * JD-Core Version:    0.7.0.1
 */