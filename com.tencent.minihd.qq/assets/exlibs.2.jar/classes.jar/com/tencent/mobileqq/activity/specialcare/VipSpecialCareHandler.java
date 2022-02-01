package com.tencent.mobileqq.activity.specialcare;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hbn;
import java.util.ArrayList;
import java.util.List;

public class VipSpecialCareHandler
  extends QvipSpecialCareObserver
  implements IPCConstants
{
  public static final String KEY_SPECIALCARE_ALREADY_SET = "specialcare_already_set";
  private final int SETTING_TIMEOUT = 90000;
  private final int SPECIAL_CARE_REQ_TIMEOUT = 1;
  private Bundle mRequestBundle = null;
  private Bundle mResponseBundle = null;
  private volatile int mSynchronizer = 0;
  private Handler mTimerHandler = null;
  private HandlerThread mTimerThread = new HandlerThread("special-timer");
  
  public VipSpecialCareHandler()
  {
    this.mTimerThread.start();
    this.mTimerHandler = new hbn(this, this.mTimerThread.getLooper());
  }
  
  private void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipSpecialCareHandler", 2, paramString);
    }
  }
  
  private final void notifyResultToWeb(int paramInt)
  {
    int i = this.mSynchronizer - 1;
    this.mSynchronizer = i;
    if (i != 0)
    {
      log("-->warning:special care set,uncorrect state,seq=" + this.mSynchronizer);
      this.mSynchronizer = 0;
    }
    try
    {
      Bundle localBundle = this.mResponseBundle;
      i = paramInt;
      if (paramInt == 0) {
        i = 0;
      }
      localBundle.putInt("error", i);
      this.mRequestBundle.putBundle("response", this.mResponseBundle);
      doNotify(this.mRequestBundle);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  public void destroy()
  {
    this.mTimerHandler.removeMessages(1);
    this.mTimerThread.quit();
  }
  
  public void doNotify(Bundle paramBundle) {}
  
  public void onSendErrorEvent(Object paramObject)
  {
    int i = -1;
    if (paramObject != null)
    {
      i = ((Integer)paramObject).intValue();
      if (i != 10010) {
        break label41;
      }
      log("-->error:set quota limit");
    }
    for (;;)
    {
      this.mTimerHandler.removeMessages(1);
      notifyResultToWeb(i);
      return;
      label41:
      log("-->error:" + i);
    }
  }
  
  public void onSpecialSoundEvent(Object paramObject)
  {
    if (paramObject != null) {
      switch (((Integer)paramObject).intValue())
      {
      }
    }
    for (;;)
    {
      this.mTimerHandler.removeMessages(1);
      notifyResultToWeb(0);
      return;
      log("-->method_type_open_switch");
      continue;
      log("-->method_type_set_sound");
      continue;
      log("-->method_type_delete_sound");
    }
  }
  
  public void sendRequest(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle1, Bundle paramBundle2)
  {
    if (this.mSynchronizer != 0)
    {
      log("-->current request is ongoing,can't do request yet");
      paramBundle2.putInt("error", -1);
      paramBundle1.putBundle("response", paramBundle2);
      doNotify(paramBundle1);
      return;
    }
    this.mSynchronizer += 1;
    log("-->do request,seq=" + this.mSynchronizer);
    ArrayList localArrayList;
    for (;;)
    {
      try
      {
        updateBundle(paramBundle1, paramBundle2);
        if ((!"sepcial_care_delete_ring".equals(paramString)) && (!"special_care_set_ring".equals(paramString))) {
          break;
        }
        paramBundle1 = paramBundle1.getBundle("request");
        int i = paramBundle1.getInt("id", 1);
        paramBundle2 = paramBundle1.getString("uin");
        paramBundle1 = paramBundle2;
        if (paramBundle2 == null) {
          paramBundle1 = "";
        }
        paramBundle2 = new ArrayList();
        paramBundle2.add(paramBundle1);
        localArrayList = new ArrayList();
        localArrayList.add(String.valueOf(i));
        this.mTimerHandler.sendEmptyMessageDelayed(1, 90000L);
        if (!"special_care_set_ring".equals(paramString)) {
          break label281;
        }
        if (i == 1)
        {
          QvipSpecialCareManager.a(paramBundle2, 2, localArrayList, paramQQAppInterface);
          paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          paramString = "specialcare_already_set" + paramBundle1;
          paramQQAppInterface.edit().putBoolean(paramString, true).commit();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        this.mSynchronizer = 0;
        return;
      }
      QvipSpecialCareManager.a(paramBundle2, 3, localArrayList, paramQQAppInterface);
    }
    label281:
    QvipSpecialCareManager.a(paramBundle2, 4, localArrayList, paramQQAppInterface);
  }
  
  public final void updateBundle(Bundle paramBundle1, Bundle paramBundle2)
  {
    this.mRequestBundle = paramBundle1;
    this.mResponseBundle = paramBundle2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler
 * JD-Core Version:    0.7.0.1
 */