package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.ThemeSwitchDlgActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameActivity;
import com.tencent.qphone.base.util.QLog;

class ThemeSwitchManager$ThemeDownloadHandler$1
  implements Runnable
{
  ThemeSwitchManager$ThemeDownloadHandler$1(ThemeSwitchManager.ThemeDownloadHandler paramThemeDownloadHandler, Activity paramActivity, Bundle paramBundle, ThemeUtil.ThemeInfo paramThemeInfo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeSwitch", 2, "checkTopActivity is running");
    }
    this.this$1.this$0.handler.removeCallbacks(this.this$1.this$0.checkTopActivity);
    Object localObject1 = this.this$1.this$0.getTopActivity(this.this$1.this$0.mContext);
    if (localObject1 == null)
    {
      this.this$1.this$0.handler = null;
      return;
    }
    Object localObject2 = localObject1[1];
    if (!localObject1[0].equals(this.this$1.this$0.mContext.getPackageName()))
    {
      this.this$1.this$0.handler.postDelayed(this.this$1.this$0.checkTopActivity, 3000L);
      return;
    }
    if ((localObject2 != null) && (this.val$refActivity != null) && (localObject2.equals(SplashActivity.class.getName())) && ((this.val$refActivity instanceof SplashActivity)) && (((FrameActivity)this.val$refActivity).a() == 3))
    {
      this.val$result.putSerializable("themeinfo", this.val$themeInfo);
      if (this.this$1.this$0.isLogin()) {
        this.this$1.this$0.notifyCallbacks(true, false, this.val$result);
      }
      this.this$1.this$0.setup(BaseApplicationImpl.a.a(), this.val$themeInfo);
    }
    for (;;)
    {
      this.this$1.this$0.isComplete = true;
      this.this$1.this$0.handler = null;
      this.this$1.this$0.checkTopActivity = null;
      if (this.this$1.this$0.screenBroadcastReceiver == null) {
        break;
      }
      this.this$1.this$0.mContext.unregisterReceiver(this.this$1.this$0.screenBroadcastReceiver);
      this.this$1.this$0.screenBroadcastReceiver = null;
      return;
      if (this.this$1.this$0.isLogin())
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("themedownloadalert", true);
        ((Intent)localObject1).putExtra("themeID", this.val$themeInfo.themeId);
        ((Intent)localObject1).setClass(this.this$1.this$0.mContext, ThemeSwitchDlgActivity.class);
        if (BaseActivity.sTopActivity != null)
        {
          BaseActivity.sTopActivity.startActivity((Intent)localObject1);
        }
        else
        {
          ((Intent)localObject1).setFlags(268435456);
          this.this$1.this$0.mContext.startActivity((Intent)localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */