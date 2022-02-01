package com.tencent.mobileqq.earlydownload.handler;

import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.JpegSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegSoLoad;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class JpegSoDownloadHandler
  extends EarlyHandler
{
  public static final String c = "QJpegSoDownloadHandler";
  public static final String d = "qq.android.pic.jpeg.so";
  long jdField_a_of_type_Long = 0L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  boolean d = true;
  
  public JpegSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.jpeg.so", paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public JpegSoDownloadHandler(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public Class a()
  {
    return JpegSoData.class;
  }
  
  public String a()
  {
    return "qjpegDownloadSoDuration";
  }
  
  public void a(XmlData paramXmlData)
  {
    if (paramXmlData == null) {
      return;
    }
    String str = Build.CPU_ABI;
    JpegSoData localJpegSoData = (JpegSoData)paramXmlData;
    if ((str != null) && (!"".equals(str)) && ("armeabi-v7a".equalsIgnoreCase(str)))
    {
      str = paramXmlData.strResURL_big;
      paramXmlData.strResURL_big = paramXmlData.strResURL_small;
      paramXmlData.strResURL_small = str;
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "doOnServerResp[armeabi-v7a]");
      }
      if (QLog.isColorLevel())
      {
        QLog.d("QJpegSoDownloadHandler", 2, "   arm_md5=" + paramXmlData.MD5);
        QLog.d("QJpegSoDownloadHandler", 2, "armv7a_md5=" + localJpegSoData.v7a_MD5);
      }
      str = paramXmlData.MD5;
      paramXmlData.MD5 = localJpegSoData.v7a_MD5;
      localJpegSoData.v7a_MD5 = str;
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "download success: " + paramString);
      }
      FileUtils.a(paramString, JpegSoLoad.getJpegSolibPath(BaseApplicationImpl.getContext()), false);
      JpegCompressor.jpegcompressLoadSo();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a().loadState == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QJpegSoDownloadHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.JpegSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */