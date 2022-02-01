package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

public class BackKeyEditText
  extends EditText
{
  private BackKeyEditText.EditCallBack a;
  
  public BackKeyEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public BackKeyEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BackKeyEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1) && (this.a != null)) {
      this.a.a();
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setEditCallBack(BackKeyEditText.EditCallBack paramEditCallBack)
  {
    this.a = paramEditCallBack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.BackKeyEditText
 * JD-Core Version:    0.7.0.1
 */