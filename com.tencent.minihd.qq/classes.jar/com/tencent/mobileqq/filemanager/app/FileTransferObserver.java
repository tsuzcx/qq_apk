package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FileTransferObserver
{
  private static final String a = "FileTransferObserver<FileAssistant>";
  
  public void a() {}
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    for (paramObject = (Object[])paramObject;; paramObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileTransferObserver<FileAssistant>", 2, "onUpdate : type[" + paramInt + "], isSuccess[" + paramBoolean + "]");
      }
      switch (paramInt)
      {
      case 5008: 
      case 5009: 
      case 5010: 
      case 5011: 
      case 5012: 
      case 5017: 
      case 5018: 
      case 5019: 
      default: 
        QLog.e("FileTransferObserver<FileAssistant>", 1, "onUpdate : Can Not process type" + paramInt);
        return;
      case 5004: 
        a(paramBoolean, (FileTransferHandler.FileUploadInfo)paramObject[0], (MessageObserver.StatictisInfo)paramObject[1], (List)paramObject[2]);
        return;
      case 5005: 
        a(paramBoolean, (FileTransferHandler.FileUploadInfo)paramObject[0], (MessageObserver.StatictisInfo)paramObject[1]);
        return;
      case 5006: 
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (ByteStringMicro)paramObject[2], (String)paramObject[3], ((Short)paramObject[4]).shortValue(), (String)paramObject[5], (List)paramObject[6], ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
        return;
      case 5007: 
        b(paramBoolean, (FileTransferHandler.FileUploadInfo)paramObject[0], (MessageObserver.StatictisInfo)paramObject[1]);
        return;
      case 5013: 
        a(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Long)paramObject[8]).longValue());
        return;
      case 5014: 
        paramBoolean = ((Boolean)paramObject[0]).booleanValue();
        long l = ((Long)paramObject[1]).longValue();
        paramInt = ((Integer)paramObject[2]).intValue();
        a(paramBoolean, l, ((Long)paramObject[3]).longValue(), paramInt);
        return;
      case 5015: 
        Long localLong = (Long)paramObject[0];
        String str1 = (String)paramObject[1];
        String str2 = (String)paramObject[2];
        String str3 = (String)paramObject[3];
        String str4 = (String)paramObject[4];
        Integer localInteger = (Integer)paramObject[5];
        String str5 = (String)paramObject[6];
        paramObject = (String)paramObject[7];
        a(paramBoolean, localLong.longValue(), str1, str2, str3, str4, localInteger.intValue(), str5, paramObject);
        return;
      case 5016: 
        a(paramBoolean, (Long)paramObject[0]);
        return;
      }
      b(paramBoolean, (FileTransferHandler.FileUploadInfo)paramObject[0], (MessageObserver.StatictisInfo)paramObject[1], (List)paramObject[2]);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, ByteStringMicro paramByteStringMicro, String paramString2, short paramShort, String paramString3, List paramList, int paramInt, String paramString4) {}
  
  public void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6) {}
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList) {}
  
  public void a(boolean paramBoolean, Long paramLong) {}
  
  public void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo) {}
  
  public void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferObserver
 * JD-Core Version:    0.7.0.1
 */