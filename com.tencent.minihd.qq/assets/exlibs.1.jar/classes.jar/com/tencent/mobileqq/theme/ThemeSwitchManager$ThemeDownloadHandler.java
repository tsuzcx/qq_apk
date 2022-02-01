package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class ThemeSwitchManager$ThemeDownloadHandler
  extends TransProcessorHandler
{
  private ThemeSwitchManager$ThemeDownloadHandler(ThemeSwitchManager paramThemeSwitchManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    int j = 0;
    Object localObject1 = (FileMsg)paramMessage.obj;
    int k;
    long l;
    if (localObject1 != null)
    {
      k = paramMessage.what;
      paramMessage = ((FileMsg)localObject1).jdField_e_of_type_JavaLangString;
      l = ((FileMsg)localObject1).jdField_e_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "handleMessage:" + k + "  " + paramMessage + " " + l + " ");
      }
      if ((!TextUtils.isEmpty(paramMessage)) && (paramMessage.startsWith(AppConstants.bP))) {
        break label142;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitch", 2, "not download theme file message" + AppConstants.bP);
      }
    }
    label142:
    label1431:
    label1432:
    for (;;)
    {
      return;
      Object localObject2 = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(this.this$0.currDownloadingThemeId);
      if ((localObject2 == null) || (!((ThemeUtil.ThemeInfo)localObject2).downloadUrl.equals(((FileMsg)localObject1).k)))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("ThemeSwitch", 4, "not download theme file url" + ((FileMsg)localObject1).k);
        }
      }
      else
      {
        paramMessage = new Bundle();
        int i;
        if (k == 2002)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("ThemeSwitch", 4, "download theme file process transferedSize: " + l + ", filesize=" + ((FileMsg)localObject1).a);
          }
          if (localObject2 != null)
          {
            ((ThemeUtil.ThemeInfo)localObject2).downsize = l;
            ((ThemeUtil.ThemeInfo)localObject2).status = "2";
            this.this$0.downloadThemeMap.put(this.this$0.currDownloadingThemeId, localObject2);
            ThemeUtil.setThemeInfo(this.this$0.mContext, (ThemeUtil.ThemeInfo)localObject2);
            paramMessage.putInt("result", 3);
            paramMessage.putLong("transferedSize", l);
            paramMessage.putLong("filesize", ((ThemeUtil.ThemeInfo)localObject2).size);
            this.this$0.notifyCallbacks(true, false, paramMessage);
            i = j;
            if (l == ((ThemeUtil.ThemeInfo)localObject2).size)
            {
              removeMessages(2002);
              i = j;
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            if (i == 0) {
              break label1432;
            }
            this.this$0.failAlert(paramMessage);
            return;
            if (ThemeSwitchManager.isDownloadingInProgress)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitch", 2, "downloadThemeMap themeInfo is null,themeId=" + this.this$0.currDownloadingThemeId);
              }
              ThemeSwitchManager.isDownloadingInProgress = false;
              paramMessage.putInt("result", 256);
              paramMessage.putCharSequence("message", "downloadThemeMap themeInfo is null,themeId=" + this.this$0.currDownloadingThemeId);
              i = 1;
            }
            else
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("ThemeSwitch", 2, "user pause download, themeId=" + this.this$0.currDownloadingThemeId);
                i = j;
                continue;
                if (k != 2003) {
                  break label1221;
                }
                try
                {
                  localObject1 = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(this.this$0.currDownloadingThemeId);
                  if (localObject1 == null) {
                    break label1129;
                  }
                  if (QLog.isDevelopLevel()) {
                    QLog.d("ThemeSwitch", 4, "download theme success themeID: " + ((ThemeUtil.ThemeInfo)localObject1).themeId);
                  }
                  ((ThemeUtil.ThemeInfo)localObject1).downsize = l;
                  ((ThemeUtil.ThemeInfo)localObject1).status = "3";
                  this.this$0.downloadThemeMap.remove(this.this$0.currDownloadingThemeId);
                  ThemeUtil.setThemeInfo(this.this$0.mContext, (ThemeUtil.ThemeInfo)localObject1);
                  paramMessage.putInt("result", 1);
                  paramMessage.putCharSequence("message", "ok, Theme downloaded.");
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  localObject2 = this.this$0.getTopActivity(this.this$0.mContext);
                  if (localObject2 == null) {
                    break;
                  }
                  Object localObject3 = localObject2[1];
                  Activity localActivity = (Activity)this.this$0.currActivityRef.get();
                  if ((localObject3 != null) && (localActivity != null) && (localObject3.equals(SplashActivity.class.getName())) && ((localActivity instanceof SplashActivity)) && (((FrameActivity)localActivity).a() == 3))
                  {
                    paramMessage.putSerializable("themeinfo", (Serializable)localObject1);
                    if (this.this$0.isLogin()) {
                      this.this$0.notifyCallbacks(true, false, paramMessage);
                    }
                    this.this$0.setup(BaseApplicationImpl.a.a(), (ThemeUtil.ThemeInfo)localObject1);
                  }
                  else if (!localObject2[0].equals(this.this$0.mContext.getPackageName()))
                  {
                    if (this.this$0.handler == null) {
                      this.this$0.handler = ThreadManager.b();
                    }
                    this.this$0.isComplete = false;
                    if (this.this$0.checkTopActivity == null) {
                      this.this$0.checkTopActivity = new ThemeSwitchManager.ThemeDownloadHandler.1(this, localActivity, paramMessage, (ThemeUtil.ThemeInfo)localObject1);
                    }
                    localObject1 = new IntentFilter();
                    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
                    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
                    if (this.this$0.screenBroadcastReceiver == null) {
                      this.this$0.screenBroadcastReceiver = new ThemeSwitchManager.ThemeDownloadHandler.2(this);
                    }
                    this.this$0.mContext.registerReceiver(this.this$0.screenBroadcastReceiver, (IntentFilter)localObject1);
                    this.this$0.handler.postDelayed(this.this$0.checkTopActivity, 3000L);
                  }
                }
                catch (Exception localException1)
                {
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  localException1.printStackTrace();
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "File download finish Exception:" + localException1.getMessage());
                  i = 1;
                }
              }
            }
          }
          continue;
          if (this.this$0.isLogin())
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("themedownloadalert", true);
            ((Intent)localObject2).putExtra("themeID", localException1.themeId);
            ((Intent)localObject2).setClass(this.this$0.mContext, ThemeSwitchDlgActivity.class);
            if (BaseActivity.sTopActivity != null)
            {
              BaseActivity.sTopActivity.startActivity((Intent)localObject2);
              return;
            }
            ((Intent)localObject2).setFlags(268435456);
            this.this$0.mContext.startActivity((Intent)localObject2);
            return;
            label1129:
            if (ThemeSwitchManager.isDownloadingInProgress)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeSwitch", 2, "downloadThemeMap themeInfo is null,themeId=" + this.this$0.currDownloadingThemeId);
              }
              ThemeSwitchManager.isDownloadingInProgress = false;
              paramMessage.putInt("result", 256);
              paramMessage.putCharSequence("message", "downloadThemeMap themeInfo is null,themeId=" + this.this$0.currDownloadingThemeId);
              i = 1;
              break label1431;
              if (k == 2005)
              {
                try
                {
                  ThemeUtil.ThemeInfo localThemeInfo = (ThemeUtil.ThemeInfo)this.this$0.downloadThemeMap.get(this.this$0.currDownloadingThemeId);
                  if (localThemeInfo != null)
                  {
                    localThemeInfo.downsize = l;
                    localThemeInfo.status = "4";
                    ThemeUtil.setThemeInfo(this.this$0.mContext, localThemeInfo);
                    this.this$0.downloadThemeMap.remove(this.this$0.currDownloadingThemeId);
                  }
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "recv error");
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  i = 1;
                }
                catch (Exception localException2)
                {
                  localException2.printStackTrace();
                  ThemeSwitchManager.isDownloadingInProgress = false;
                  paramMessage.putInt("result", 256);
                  paramMessage.putCharSequence("message", "File download revice error Exception:" + localException2.getMessage());
                  i = 1;
                }
              }
              else
              {
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.d("ThemeSwitch", 2, "unknown what: " + k);
                  i = j;
                }
              }
            }
            else
            {
              i = 0;
            }
          }
          else
          {
            label1221:
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler
 * JD-Core Version:    0.7.0.1
 */