package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoRepairData;

public class QavSoRepairHandler
  extends QavSoDownloadHandler
{
  public static final String e = "QavSoRepairHandler";
  public static final String f = "qq.android.qav.sorepair";
  
  public QavSoRepairHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.sorepair", paramQQAppInterface);
  }
  
  public Class a()
  {
    return QavSoRepairData.class;
  }
  
  public void a(boolean paramBoolean)
  {
    QavSoRepairData localQavSoRepairData = (QavSoRepairData)a();
    if ((localQavSoRepairData != null) && (!localQavSoRepairData.autoDownload))
    {
      localQavSoRepairData.autoDownload = true;
      EarlyDataFactory.a(localQavSoRepairData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public boolean i()
  {
    return ((QavSoRepairData)a()).autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoRepairHandler
 * JD-Core Version:    0.7.0.1
 */