package com.qqreader;

import android.util.Log;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;

public class QRWebBrowserActivity
  extends QRHardWareActivity
{
  protected void onDestroy()
  {
    super.onDestroy();
    Log.e("QRWebBrowserActivity", "unregisterCommond");
    PluginCommunicationHandler.getInstance().unregister("qqreader_plugin_cmd");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRWebBrowserActivity
 * JD-Core Version:    0.7.0.1
 */