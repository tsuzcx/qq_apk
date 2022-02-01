package com.tencent.device.msg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.device.DeviceScanner;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class DeviceQRAgentActivity
  extends IphoneTitleBarActivity
{
  public static final String a = "DeviceShareAgentActivity";
  boolean a = false;
  
  protected void a()
  {
    setTitle(2131362316);
    setLeftViewName(2131362315);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("qrurl");
    if (!TextUtils.isEmpty(paramBundle))
    {
      this.a = true;
      setContentView(2130903267);
      a();
      DeviceScanner.a(this, null, paramBundle);
      return true;
    }
    finish();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceQRAgentActivity
 * JD-Core Version:    0.7.0.1
 */