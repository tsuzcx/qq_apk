package com.tencent.device.msg.data;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.file.DeviceProto.MsgFileKey;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct.DeviceSingleStructItemCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dbf;
import dbg;
import dbh;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class DevSingleStructMsgProcessor
  extends DeviceFileObserver
{
  private static final String jdField_a_of_type_JavaLangString = DevSingleStructMsgProcessor.class.getSimpleName();
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  private ConcurrentHashMap b = new ConcurrentHashMap(10);
  
  public DevSingleStructMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new dbh(this, paramString, paramInt, paramLong2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "found resume");
  }
  
  private void a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (dbg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((dbg)localObject).a();
      localObject = ((dbg)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((MessageForDeviceSingleStruct.DeviceSingleStructItemCallback)localObject).a(localView, paramMessageForDeviceSingleStruct);
      }
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
      }
    }
  }
  
  public long a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if ((paramMessageForDeviceSingleStruct == null) || (paramMessageForDeviceSingleStruct.mediaKey == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mr is null or strMediaKey is empty in downloadCoverFile!");
      }
      return 0L;
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      paramMessageForDeviceSingleStruct = Looper.getMainLooper();
      if (Thread.currentThread() == paramMessageForDeviceSingleStruct.getThread())
      {
        FMToastUtil.a(2131362120);
        return 0L;
      }
      new Handler(paramMessageForDeviceSingleStruct).post(new dbf(this));
      return 0L;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      return paramMessageForDeviceSingleStruct.nMediaSessionID;
    }
    long l = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52)).a(paramMessageForDeviceSingleStruct.mediaKey);
    MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
    if ((localMessageRecord instanceof MessageForDeviceSingleStruct)) {
      ((MessageForDeviceSingleStruct)localMessageRecord).nMediaSessionID = l;
    }
    paramMessageForDeviceSingleStruct.nMediaSessionID = l;
    a(l, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
    return l;
  }
  
  public long a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct, View paramView, MessageForDeviceSingleStruct.DeviceSingleStructItemCallback paramDeviceSingleStructItemCallback)
  {
    if ((paramMessageForDeviceSingleStruct == null) || (paramMessageForDeviceSingleStruct.coverKey == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mr is null or strCoverKey is empty in downloadCoverFile!");
      }
    }
    while (!NetworkUtil.e(BaseApplication.getContext())) {
      return 0L;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      dbg localdbg = (dbg)localIterator.next();
      if (localdbg.a() == paramView) {
        localdbg.b = new WeakReference(paramDeviceSingleStructItemCallback);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(new dbg(this, paramView, paramDeviceSingleStructItemCallback));
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nCoverSessionID))) {
        return paramMessageForDeviceSingleStruct.nCoverSessionID;
      }
      if (this.b.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq)))
      {
        l = ((Long)this.b.get(Long.valueOf(paramMessageForDeviceSingleStruct.uniseq))).longValue();
        if (MessageCache.a() - l < 3600L) {
          return paramMessageForDeviceSingleStruct.nCoverSessionID;
        }
      }
      long l = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52)).a(paramMessageForDeviceSingleStruct.coverKey);
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      if ((paramView instanceof MessageForDeviceSingleStruct)) {
        ((MessageForDeviceSingleStruct)paramView).nCoverSessionID = l;
      }
      paramMessageForDeviceSingleStruct.nCoverSessionID = l;
      a(l, paramMessageForDeviceSingleStruct.frienduin, paramMessageForDeviceSingleStruct.istroop, paramMessageForDeviceSingleStruct.uniseq);
      return l;
    }
  }
  
  public MessageForDeviceSingleStruct a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
    }
    a(paramMessageForDeviceSingleStruct);
    return paramMessageForDeviceSingleStruct;
  }
  
  protected MessageForDeviceSingleStruct a(Long paramLong)
  {
    paramLong = (dbh)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    if (paramLong == null) {
      return null;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      paramLong = ((QQAppInterface)localAppRuntime).a().a(paramLong.jdField_a_of_type_JavaLangString, paramLong.jdField_a_of_type_Int, paramLong.jdField_a_of_type_Long);
      if (paramLong == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "device file msg null");
        }
        return null;
      }
      if ((paramLong instanceof MessageForDeviceSingleStruct)) {
        return (MessageForDeviceSingleStruct)paramLong;
      }
    }
    return null;
  }
  
  public String a(DataPoint paramDataPoint)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
    localMessageForDeviceSingleStruct.msgtype = -4502;
    localMessageForDeviceSingleStruct.istroop = 9501;
    localMessageForDeviceSingleStruct.issend = 0;
    localMessageForDeviceSingleStruct.isread = false;
    localMessageForDeviceSingleStruct.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localMessageForDeviceSingleStruct.senderuin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.frienduin = Long.toString(paramDataPoint.mDin);
    localMessageForDeviceSingleStruct.nDataType = 1;
    localMessageForDeviceSingleStruct.parseFromJson(paramDataPoint.mValue);
    localMessageForDeviceSingleStruct.msg = localMessageForDeviceSingleStruct.strTitle;
    paramDataPoint = (DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52);
    DeviceProto.MsgFileKey localMsgFileKey;
    if (localMessageForDeviceSingleStruct.coverKey != null) {
      localMsgFileKey = paramDataPoint.a(localMessageForDeviceSingleStruct.coverKey);
    }
    try
    {
      localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, localMsgFileKey.bytes_file_md5.get().toByteArray()).toString(16);
      if (localMessageForDeviceSingleStruct.mediaKey != null)
      {
        paramDataPoint = paramDataPoint.a(localMessageForDeviceSingleStruct.mediaKey);
        localMessageForDeviceSingleStruct.strMediaFileName = paramDataPoint.str_file_name.get();
        localMessageForDeviceSingleStruct.nMediaFileSize = paramDataPoint.uint64_file_length.get();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDeviceSingleStruct, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      return localMessageForDeviceSingleStruct.msg;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "Exception in onReceiveSingleStructMsg: " + localException.getMessage());
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(Session paramSession, float paramFloat)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    while (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
      return;
    }
    localMessageForDeviceSingleStruct.nMediaFileStatus = 3;
    localMessageForDeviceSingleStruct.nMediaProgress = paramFloat;
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    do
    {
      return;
      if (localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID)
      {
        localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
        if (paramBoolean) {
          this.b.remove(Long.valueOf(localMessageForDeviceSingleStruct.uniseq));
        }
      }
      for (;;)
      {
        localMessageForDeviceSingleStruct.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForDeviceSingleStruct.frienduin, 9501, localMessageForDeviceSingleStruct.uniseq, localMessageForDeviceSingleStruct.msgData);
        if ((localMessageForDeviceSingleStruct.nCoverSessionID == paramSession.uSessionID) && (paramBoolean)) {
          a(localMessageForDeviceSingleStruct);
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramSession.uSessionID));
        return;
        this.b.put(Long.valueOf(localMessageForDeviceSingleStruct.uniseq), Long.valueOf(MessageCache.a()));
        continue;
        if (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
          break;
        }
        localMessageForDeviceSingleStruct.strMediaPath = paramSession.strFilePathSrc;
        localMessageForDeviceSingleStruct.nMediaProgress = 1.0F;
        if (paramBoolean) {}
        for (localMessageForDeviceSingleStruct.nMediaFileStatus = 5;; localMessageForDeviceSingleStruct.nMediaFileStatus = 6)
        {
          for (;;)
          {
            if (localMessageForDeviceSingleStruct.coverKey != null) {
              break label275;
            }
            localMessageForDeviceSingleStruct.strCoverPath = paramSession.strFilePathSrc;
            try
            {
              localMessageForDeviceSingleStruct.strCoverMD5 = new BigInteger(1, paramSession.vFileMD5Src).toString(16);
            }
            catch (Exception localException) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "error get file md5 in : onServiceSessionComplete" + localException.getMessage());
          break;
        }
      }
    } while (!QLog.isColorLevel());
    label275:
    QLog.d(jdField_a_of_type_JavaLangString, 2, "error:can not find session id in message record");
  }
  
  public boolean a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
  }
  
  public void b()
  {
    this.b.clear();
  }
  
  public void b(Session paramSession)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct;
    if (!paramSession.bSend)
    {
      localMessageForDeviceSingleStruct = a(Long.valueOf(paramSession.uSessionID));
      if (localMessageForDeviceSingleStruct != null) {
        break label24;
      }
    }
    label24:
    while (localMessageForDeviceSingleStruct.nMediaSessionID != paramSession.uSessionID) {
      return;
    }
    localMessageForDeviceSingleStruct.nMediaFileStatus = 2;
  }
  
  public boolean b(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceSingleStruct.nMediaSessionID));
    }
    paramMessageForDeviceSingleStruct.nMediaFileStatus = 6;
    paramMessageForDeviceSingleStruct.nMediaProgress = 0.0F;
    paramMessageForDeviceSingleStruct.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForDeviceSingleStruct.frienduin, 9501, paramMessageForDeviceSingleStruct.uniseq, paramMessageForDeviceSingleStruct.msgData);
    ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52)).a(0, paramMessageForDeviceSingleStruct.nMediaSessionID, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.data.DevSingleStructMsgProcessor
 * JD-Core Version:    0.7.0.1
 */