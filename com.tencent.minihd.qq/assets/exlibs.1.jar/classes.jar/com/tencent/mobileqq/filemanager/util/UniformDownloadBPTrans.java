package com.tencent.mobileqq.filemanager.util;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;

public class UniformDownloadBPTrans
{
  private static UniformDownloadBPTrans jdField_a_of_type_ComTencentMobileqqFilemanagerUtilUniformDownloadBPTrans;
  private static final String jdField_a_of_type_JavaLangString = "UniformDownloadBPTrans<FileAssistant>";
  
  static
  {
    a = null;
  }
  
  public static UniformDownloadBPTrans a()
  {
    try
    {
      if (a == null) {
        a = new UniformDownloadBPTrans();
      }
      UniformDownloadBPTrans localUniformDownloadBPTrans = a;
      return localUniformDownloadBPTrans;
    }
    finally {}
  }
  
  public UniformDownloadBPTrans.BreakpointTransInfo a(String paramString)
  {
    Object localObject = UniformDownloadMgr.a().a();
    if (localObject == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + paramString + "]");
    }
    do
    {
      return null;
      paramString = ((QQAppInterface)localObject).a().a(paramString);
    } while (paramString == null);
    localObject = new UniformDownloadBPTrans.BreakpointTransInfo();
    ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).jdField_a_of_type_JavaLangString = paramString.mFileName;
    ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).jdField_a_of_type_Long = paramString.mFileSize;
    ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).c = paramString.mFilePath;
    ((UniformDownloadBPTrans.BreakpointTransInfo)localObject).b = paramString.mTempPath;
    return localObject;
  }
  
  public void a(String paramString)
  {
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem. url[" + paramString + "]");
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface == null)
    {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem failed APP=null. url[" + paramString + "]");
      return;
    }
    localQQAppInterface.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.mUrl = paramString1;
    localUniformDownloadBPTransEntity.mFileName = paramString2;
    localUniformDownloadBPTransEntity.mFileSize = paramLong;
    localUniformDownloadBPTransEntity.mFilePath = paramString4;
    localUniformDownloadBPTransEntity.mTempPath = paramString3;
    QQAppInterface localQQAppInterface = UniformDownloadMgr.a().a();
    if (localQQAppInterface == null)
    {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.failed APP=null, filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
      return;
    }
    localQQAppInterface.a().a(localUniformDownloadBPTransEntity);
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.UniformDownloadBPTrans
 * JD-Core Version:    0.7.0.1
 */