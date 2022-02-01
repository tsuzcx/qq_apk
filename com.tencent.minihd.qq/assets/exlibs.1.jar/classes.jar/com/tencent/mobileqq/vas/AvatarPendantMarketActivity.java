package com.tencent.mobileqq.vas;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webviewplugin.WebViewPluginEngine;
import java.util.HashMap;
import java.util.Map;

public class AvatarPendantMarketActivity
  extends QQBrowserActivity
{
  public static final String a = "key_update_flag";
  public static final String b = "key_page_open_time";
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ReportController.b(this.app, "CliOper", "", "", "PendantMarket", "WebviewCreate", 0, 0, "", "", "", "");
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("intent", paramIntent);
    this.a.a(this.M, 20, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantMarketActivity
 * JD-Core Version:    0.7.0.1
 */