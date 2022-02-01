package com.qqreader;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;

public class QRHardWareActivity
  extends QRPluginProxyActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    String str = Build.MANUFACTURER + "_" + Build.MODEL;
    if ((Build.VERSION.SDK_INT > 10) && (!"Meizu_M040".equals(str))) {
      getWindow().addFlags(16777216);
    }
    super.onCreate(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRHardWareActivity
 * JD-Core Version:    0.7.0.1
 */