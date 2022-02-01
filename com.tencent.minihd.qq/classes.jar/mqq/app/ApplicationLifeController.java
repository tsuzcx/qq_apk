package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class ApplicationLifeController
{
  private static final String TAG = "ApplicationLife";
  private static ApplicationLifeController sLifeController;
  private byte mActiviyCount = 0;
  private boolean mIsRuntimeReady;
  private boolean mNeedSendBroadcast;
  
  public static ApplicationLifeController getController()
  {
    if (sLifeController == null) {}
    try
    {
      if (sLifeController == null) {
        sLifeController = new ApplicationLifeController();
      }
      return sLifeController;
    }
    finally {}
  }
  
  byte getVisibleActivityCount()
  {
    return this.mActiviyCount;
  }
  
  public void onActivityStart(Activity paramActivity)
  {
    int i = this.mActiviyCount;
    this.mActiviyCount = ((byte)(i + 1));
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, MobileQQ.processName + " is running on foreground" + this.mIsRuntimeReady + ". count = " + this.mActiviyCount);
      }
      paramActivity = new Intent("com.tencent.process.starting");
      paramActivity.putExtra("runningProcessName", MobileQQ.processName);
      paramActivity.putExtra("runningtime", SystemClock.uptimeMillis());
      MobileQQ.sMobileQQ.sendBroadcast(paramActivity);
      if (!this.mIsRuntimeReady) {
        this.mNeedSendBroadcast = true;
      }
    }
  }
  
  public void onActivityStop(Activity paramActivity)
  {
    byte b = (byte)(this.mActiviyCount - 1);
    this.mActiviyCount = b;
    if (b == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("mqq", 2, MobileQQ.processName + " is running on background" + this.mIsRuntimeReady + ". count = " + this.mActiviyCount);
      }
      paramActivity = new Intent("com.tencent.process.stopping");
      paramActivity.putExtra("runningProcessName", MobileQQ.processName);
      paramActivity.putExtra("runningtime", SystemClock.uptimeMillis());
      MobileQQ.sMobileQQ.sendBroadcast(paramActivity);
      if (!this.mIsRuntimeReady) {
        this.mNeedSendBroadcast = true;
      }
    }
  }
  
  public void setRuntimeReady(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, MobileQQ.processName + " setRuntimeReady:" + this.mIsRuntimeReady);
    }
    this.mIsRuntimeReady = paramBoolean;
    if ((this.mIsRuntimeReady) && (this.mNeedSendBroadcast))
    {
      if (this.mActiviyCount > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("mqq", 2, MobileQQ.processName + " is running on foreground" + this.mIsRuntimeReady + ". count = " + this.mActiviyCount);
        }
        localIntent = new Intent("com.tencent.process.starting");
        localIntent.putExtra("runningProcessName", MobileQQ.processName);
        localIntent.putExtra("runningtime", SystemClock.uptimeMillis());
        MobileQQ.sMobileQQ.sendBroadcast(localIntent);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("mqq", 2, MobileQQ.processName + " is running on background" + this.mIsRuntimeReady + ". count = " + this.mActiviyCount);
    }
    Intent localIntent = new Intent("com.tencent.process.stopping");
    localIntent.putExtra("runningProcessName", MobileQQ.processName);
    localIntent.putExtra("runningtime", SystemClock.uptimeMillis());
    MobileQQ.sMobileQQ.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.ApplicationLifeController
 * JD-Core Version:    0.7.0.1
 */