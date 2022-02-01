package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.qphone.base.util.QLog;

public class GetQZoneFeeds
  extends AsyncStep
{
  public static boolean b = false;
  public static final String c = "GetQZoneFeeds";
  
  protected int a()
  {
    b = true;
    if (QLog.isColorLevel()) {
      QLog.d("GetQZoneFeeds", 2, "GetQZoneFeeds doStep");
    }
    ((QzoneContactsFeedManager)this.a.a.getManager(85)).a();
    return super.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetQZoneFeeds
 * JD-Core Version:    0.7.0.1
 */