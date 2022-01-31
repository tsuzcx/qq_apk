package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public class FreeWifiTestActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.i.free_wifi_test_case);
    findViewById(R.h.free_wifi_test_btn1).setOnClickListener(new FreeWifiTestActivity.1(this));
    findViewById(R.h.free_wifi_test_btn2).setOnClickListener(new FreeWifiTestActivity.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity
 * JD-Core Version:    0.7.0.1
 */