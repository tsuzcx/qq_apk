package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

final class b
  extends Thread
{
  b(int paramInt) {}
  
  public void run()
  {
    try
    {
      if (this.a == 0)
      {
        a.a.onNetNone2Mobile();
        return;
      }
      if (this.a == 1)
      {
        a.a.onNetWifi2Mobile();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d(a.i(), 1, "notifyChanged error, ", localException);
      return;
    }
    if (this.a == 2)
    {
      a.a.onNetNone2Wifi();
      return;
    }
    if (this.a == 3)
    {
      a.a.onNetMobile2Wifi();
      return;
    }
    if (this.a == 4)
    {
      a.a.onNetMobile2None();
      return;
    }
    if (this.a == 5) {
      a.a.onNetWifi2None();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b
 * JD-Core Version:    0.7.0.1
 */