package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.WebpSoData;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class WebpSoDownloadHandler
  extends EarlyHandler
{
  public static final String c = "QWebpSoDownloadHandler";
  public static final String d = "qq.android.pic.webp.so";
  QQAppInterface a = null;
  
  public WebpSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public WebpSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public Class a()
  {
    return WebpSoData.class;
  }
  
  public String a()
  {
    return "QWebpSoDownloadDuration";
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWebpSoDownloadHandler", 2, "onDownload success: " + paramString);
      }
      FileUtils.a(paramString, WebpSoLoader.a(BaseApplicationImpl.getContext()), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */