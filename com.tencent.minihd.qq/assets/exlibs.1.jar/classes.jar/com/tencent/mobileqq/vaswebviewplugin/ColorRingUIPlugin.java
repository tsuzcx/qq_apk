package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class ColorRingUIPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "ColorRingUIPlugin";
  
  void OnActivityCreate()
  {
    super.OnActivityCreate();
    this.activity.M = super.decodeUrl(this.activity.M);
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingUIPlugin", 2, this.activity.M);
    }
  }
  
  protected long getPluginBusiness()
  {
    return 4194304L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin
 * JD-Core Version:    0.7.0.1
 */