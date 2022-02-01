package com.tencent.device.bind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cyx;
import cyy;
import java.util.Observable;
import java.util.Observer;

public class DevicePluginDownloadActivity
  extends IphoneTitleBarActivity
  implements Observer
{
  private static String a = "DevicePluginDownloadActivity";
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130903269);
    super.setTitle(2131362095);
    SmartDevicePluginLoader.a().addObserver(this);
    this.leftView.setText(2131365114);
    if (!SmartDevicePluginLoader.a().a(this.app)) {
      SmartDevicePluginLoader.a().a();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    SmartDevicePluginLoader.a().deleteObserver(this);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "recv notify : plugin install finished with code " + paramObservable);
      }
      if (paramObservable.intValue() != 0)
      {
        paramObservable = DialogUtil.a(this, 230);
        paramObservable.setNegativeButton(2131365736, new cyx(this));
        paramObservable.setPositiveButton(2131362321, new cyy(this));
        paramObservable.setTitle(2131362326);
        paramObservable.setMessage(2131362327);
        paramObservable.show();
      }
    }
    else
    {
      return;
    }
    paramObservable = new Intent();
    paramObject = getIntent();
    paramObservable.putExtra("DevicePID", paramObject.getStringExtra("DevicePID"));
    paramObservable.putExtra("DeviceSN", paramObject.getStringExtra("DeviceSN"));
    SmartDevicePluginLoader.a().a(this, this.app, this.app.getAccount(), paramObservable, "com.tencent.device.activities.DeviceScanActivity", -1, null, SmartDevicePluginProxyActivity.class);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.bind.DevicePluginDownloadActivity
 * JD-Core Version:    0.7.0.1
 */