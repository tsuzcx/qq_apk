package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import org.xmlpull.v1.XmlSerializer;

public class StructMsgItemHr
  extends AbsStructMsgElement
{
  public StructMsgItemHr()
  {
    this.a = "hr";
  }
  
  public View a(Context paramContext, View paramView)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = new View(paramContext);
      localView.setBackgroundDrawable(paramContext.getResources().getDrawable(2131427413));
    }
    return localView;
  }
  
  public View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return a(paramContext, paramView, null);
  }
  
  public String a()
  {
    return "Hr";
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "hr");
    paramXmlSerializer.endTag(null, "hr");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemHr
 * JD-Core Version:    0.7.0.1
 */