package com.tencent.mobileqq.servlet;

import android.content.Context;
import mqq.app.NewIntent;

public class GetSubAccountUnreadIntent
  extends NewIntent
{
  public QzoneSubAccountUnreadServlet.GetSubAccountUnreadListener a;
  
  public GetSubAccountUnreadIntent(Context paramContext, Class paramClass)
  {
    super(paramContext, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.GetSubAccountUnreadIntent
 * JD-Core Version:    0.7.0.1
 */