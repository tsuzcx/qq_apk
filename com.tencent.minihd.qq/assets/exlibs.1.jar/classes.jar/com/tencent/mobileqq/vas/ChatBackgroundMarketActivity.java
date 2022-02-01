package com.tencent.mobileqq.vas;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class ChatBackgroundMarketActivity
  extends QQBrowserActivity
{
  public static final String a = "isFromPhoto";
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.setIntent(paramIntent);
    boolean bool = paramIntent.getBooleanExtra("isFromPhoto", false);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("friendUin");
    if ((bool) && (str != null) && (this.a != null))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("chatbgBroadcast");
      localIntent.setPackage(this.a.a().getPackageName());
      localIntent.putExtra("friendUin", paramIntent);
      localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
      this.a.a().sendBroadcast(localIntent);
      QQToast.a(this, 2131367510, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ChatBackgroundMarketActivity
 * JD-Core Version:    0.7.0.1
 */