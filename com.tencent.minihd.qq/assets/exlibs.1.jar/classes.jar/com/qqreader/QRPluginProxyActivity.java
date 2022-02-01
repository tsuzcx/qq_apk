package com.qqreader;

import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;

public class QRPluginProxyActivity
  extends PluginProxyActivity
{
  public String getPluginID()
  {
    return "qqreaderplugin.apk";
  }
  
  protected Class getProxyActivity(String paramString)
  {
    if ("com.qqreader.ReaderPage".equals(paramString)) {
      return QRReaderPageProxyActivity.class;
    }
    if ("com.qqreader.WebBrowserOffline".equals(paramString)) {
      return QRWebBrowserActivity.class;
    }
    if ("com.qqreader.WebBrowserForContentsOffline".equals(paramString)) {
      return QRHardWareActivity.class;
    }
    if ("com.qqreader.qq.activity.SearchActivity".equals(paramString)) {
      return QRHardWareActivity.class;
    }
    return super.getProxyActivity(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.qqreader.QRPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */