package com.tencent.mobileqq.observer;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneLogTags;
import mqq.observer.BusinessObserver;

public class QZoneObserver
  implements BusinessObserver
{
  public static final int a = 1000;
  public static final String a = QZoneLogTags.b + "QZoneObserver";
  public static final int b = 1001;
  
  public void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      bool = paramBundle.getBoolean("new");
      paramInt = paramBundle.getInt("notify_type", 0);
      if (QLog.isColorLevel())
      {
        if (5 == paramInt) {
          QLog.d(QZoneLogTags.e + a, 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + paramInt + "and then call onGetQZoneFeedCountFin");
        }
        QLog.d(QZoneLogTags.e + a, 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + paramInt + "and then call onGetQZoneFeedCountFin");
      }
      a(paramBoolean, bool, paramInt);
    }
    while (paramInt != 1001)
    {
      boolean bool;
      return;
    }
    a(paramBoolean, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.observer.QZoneObserver
 * JD-Core Version:    0.7.0.1
 */