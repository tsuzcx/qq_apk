package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public boolean c = false;
  public int g = 0;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public String a()
  {
    return "Title";
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.g = paramInt;
  }
  
  protected int c()
  {
    return 2131296341;
  }
  
  public int d()
  {
    if ((this.c) && (this.g != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int e()
  {
    return 20;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */