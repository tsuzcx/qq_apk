package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  Activity activity;
  String bHI;
  int bUR;
  Intent intent;
  
  public b(Activity paramActivity, String paramString, int paramInt)
  {
    if ((paramActivity == null) || (bk.bl(paramString))) {
      throw new IllegalArgumentException("acitvity or apKey cannot be null.");
    }
    this.activity = paramActivity;
    this.intent = paramActivity.getIntent();
    this.bHI = paramString;
    this.bUR = paramInt;
  }
  
  final void DE(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("free_wifi_error_ui_error_msg", paramString);
    localIntent.setClass(this.activity, FreeWifiErrorUI.class);
    this.activity.finish();
    this.activity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.b
 * JD-Core Version:    0.7.0.1
 */