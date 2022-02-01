package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ThemeJsPlugin$4
  implements DialogInterface.OnClickListener
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeJsPlugin", 2, "not wifi network cancel download");
    }
    try
    {
      paramDialogInterface = new JSONObject();
      paramDialogInterface.put("result", 2);
      paramDialogInterface.put("message", "user cancel download theme in not wifi network");
      this.this$0.callJs(this.val$callbackId + "(" + paramDialogInterface.toString() + ");");
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */