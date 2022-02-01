package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QavSoDownloadHandler
  extends EarlyHandler
{
  public static final String c = "QavSoDownloadHandler";
  public static final String d = "qq.android.qav.so55";
  QQAppInterface a = null;
  boolean d = true;
  
  public QavSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.so55", paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public QavSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public Class a()
  {
    return QavSoData.class;
  }
  
  public String a()
  {
    return "qavDownloadSoDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, UpdateAvSo.a(), false);
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
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */