package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FreeWifiOwnerUI
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onResume()
  {
    super.onResume();
    String str = getIntent().getStringExtra("wifi_owner_name");
    int i = getIntent().getIntExtra("wifi_owner_type", 0);
    com.tencent.mm.plugin.freewifi.j.userName = str;
    com.tencent.mm.plugin.freewifi.j.type = i;
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiOwnerUI
 * JD-Core Version:    0.7.0.1
 */