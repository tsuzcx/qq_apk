package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemSummary
  extends AbsStructMsgTextElement
{
  public StructMsgItemSummary()
  {
    this(null);
  }
  
  public StructMsgItemSummary(String paramString)
  {
    super(paramString, "summary");
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public String a()
  {
    return "Summary";
  }
  
  public int b()
  {
    return 3;
  }
  
  public int c()
  {
    return 2131296342;
  }
  
  public int d()
  {
    return -8355712;
  }
  
  public int e()
  {
    return 18;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemSummary
 * JD-Core Version:    0.7.0.1
 */