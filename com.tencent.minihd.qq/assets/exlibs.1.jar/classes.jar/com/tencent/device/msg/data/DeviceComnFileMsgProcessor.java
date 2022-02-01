package com.tencent.device.msg.data;

import android.os.Handler;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.DeviceFileItemCallback;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dbi;
import dbj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class DeviceComnFileMsgProcessor
  extends DeviceFileObserver
{
  private static final String jdField_a_of_type_JavaLangString = DeviceComnFileMsgProcessor.class.getSimpleName();
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  
  public DeviceComnFileMsgProcessor(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramLong1)))
    {
      paramString = new dbj(this, paramString, paramInt, paramLong2);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong1), paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "found resume");
  }
  
  private void a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (dbi)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((dbi)localObject).a();
      localObject = ((dbi)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((MessageForDeviceFile.DeviceFileItemCallback)localObject).a(localView, paramMessageForDeviceFile);
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
  
  private void a(List paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  public MessageForDeviceFile a(Long paramLong)
  {
    paramLong = (dbj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
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
      if ((paramLong instanceof MessageForDeviceFile)) {
        return (MessageForDeviceFile)paramLong;
      }
    }
    return null;
  }
  
  public MessageForDeviceFile a(String paramString, MessageForDeviceFile paramMessageForDeviceFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageForDeviceFile.frienduin, paramMessageForDeviceFile.istroop, paramMessageForDeviceFile.uniseq);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceFile.uSessionID));
    String str1 = paramMessageForDeviceFile.filePath;
    String str2 = paramMessageForDeviceFile.frienduin;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(paramMessageForDeviceFile);
    localMessageForDeviceFile.strServiceName = paramString;
    localMessageForDeviceFile.filePath = str1;
    localMessageForDeviceFile.srcFileName = paramMessageForDeviceFile.srcFileName;
    localMessageForDeviceFile.msgStatus = 2;
    localMessageForDeviceFile.nFileStatus = 1;
    localMessageForDeviceFile.progress = 0.0F;
    localMessageForDeviceFile.nFileMsgType = paramMessageForDeviceFile.nFileMsgType;
    localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369921);
    if (paramString.compareTo(DeviceMsgHandle.b) == 0) {
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369922);
    }
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(localMessageForDeviceFile);
    paramString = ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52)).a(str1, paramString, null, Long.parseLong(str2));
    if (paramString == null) {
      return localMessageForDeviceFile;
    }
    localMessageForDeviceFile.uSessionID = paramString.uSessionID;
    localMessageForDeviceFile.fileSize = paramString.uFileSizeSrc;
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      localMessageForDeviceFile.nFileStatus = 6;
      localMessageForDeviceFile.msgStatus = 1;
    }
    localMessageForDeviceFile.serial();
    a(paramString.uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
    paramString = new ArrayList();
    paramString.add(localMessageForDeviceFile);
    a(paramString);
    return localMessageForDeviceFile;
  }
  
  public void a(View paramView, MessageForDeviceFile.DeviceFileItemCallback paramDeviceFileItemCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      dbi localdbi = (dbi)localIterator.next();
      if (localdbi.a() == paramView)
      {
        localdbi.b = new WeakReference(paramDeviceFileItemCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new dbi(this, paramView, paramDeviceFileItemCallback));
  }
  
  public void a(Session paramSession) {}
  
  public void a(Session paramSession, float paramFloat)
  {
    if (paramSession.bSend)
    {
      paramSession = a(Long.valueOf(paramSession.uSessionID));
      if (paramSession != null) {}
    }
    else
    {
      return;
    }
    paramSession.nFileStatus = 3;
    paramSession.progress = paramFloat;
    a(paramSession);
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    Object localObject;
    if (paramSession.bSend)
    {
      localObject = a(Long.valueOf(paramSession.uSessionID));
      if (localObject != null) {
        break label26;
      }
    }
    label26:
    label314:
    label317:
    for (;;)
    {
      return;
      ((MessageForDeviceFile)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368069);
      if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.b) == 0) {
        ((MessageForDeviceFile)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368066);
      }
      ((MessageForDeviceFile)localObject).progress = 1.0F;
      if (paramBoolean)
      {
        ((MessageForDeviceFile)localObject).nFileStatus = 5;
        ((MessageForDeviceFile)localObject).msgStatus = 0;
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "onServiceSessionComplete:" + paramSession.uSessionID);
        }
        ((MessageForDeviceFile)localObject).serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForDeviceFile)localObject).frienduin, 9501, ((MessageForDeviceFile)localObject).uniseq, ((MessageForDeviceFile)localObject).msgData);
        a((MessageForDeviceFile)localObject);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramSession.uSessionID));
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        if (localHandler != null) {
          localHandler.sendEmptyMessage(1009);
        }
        localObject = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(Long.parseLong(((MessageForDeviceFile)localObject).frienduin));
        if (localObject == null) {
          break label314;
        }
      }
      for (int i = ((DeviceInfo)localObject).productId;; i = 0)
      {
        if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.b) != 0) {
          break label317;
        }
        paramSession = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramBoolean) {}
        for (int j = 0;; j = 1)
        {
          SmartDeviceReport.a(paramSession, "Net_SendMsg_Pic", 0, j, i);
          return;
          ((MessageForDeviceFile)localObject).nFileStatus = 6;
          ((MessageForDeviceFile)localObject).msgStatus = 1;
          break;
        }
      }
    }
  }
  
  public boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramMessageForDeviceFile.nFileStatus = 4;
    paramMessageForDeviceFile.progress = 0.0F;
    paramMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368066);
    paramMessageForDeviceFile.serial();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForDeviceFile.frienduin, 9501, paramMessageForDeviceFile.uniseq, paramMessageForDeviceFile.msgData);
    a(paramMessageForDeviceFile);
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(paramMessageForDeviceFile.uSessionID))) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForDeviceFile.uSessionID));
    }
    ((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52)).a(0, paramMessageForDeviceFile.uSessionID, false);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, List paramList)
  {
    DeviceFileHandler localDeviceFileHandler = (DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(52);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)MessageRecordFactory.a(-4500);
      localMessageForDeviceFile.strServiceName = paramString1;
      localMessageForDeviceFile.msgtype = -4500;
      localMessageForDeviceFile.istroop = 9501;
      localMessageForDeviceFile.filePath = ((String)localObject);
      localMessageForDeviceFile.srcFileName = FileManagerUtil.a((String)localObject);
      localMessageForDeviceFile.issend = 1;
      localMessageForDeviceFile.isread = true;
      localMessageForDeviceFile.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localMessageForDeviceFile.senderuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localMessageForDeviceFile.frienduin = paramString2;
      localMessageForDeviceFile.msgStatus = 2;
      localMessageForDeviceFile.nFileStatus = 1;
      localMessageForDeviceFile.time = MessageCache.a();
      localMessageForDeviceFile.progress = 0.0F;
      localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369921);
      localMessageForDeviceFile.nFileMsgType = 2;
      if (paramString1.compareTo(DeviceMsgHandle.b) == 0)
      {
        localMessageForDeviceFile.nFileMsgType = 2;
        localMessageForDeviceFile.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369922);
      }
      ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(localMessageForDeviceFile);
      localObject = localDeviceFileHandler.a((String)localObject, paramString1, null, Long.parseLong(paramString2));
      if (localObject != null)
      {
        localMessageForDeviceFile.uSessionID = ((Session)localObject).uSessionID;
        localMessageForDeviceFile.fileSize = ((Session)localObject).uFileSizeSrc;
        if (!NetworkUtil.e(BaseApplication.getContext()))
        {
          localMessageForDeviceFile.nFileStatus = 6;
          localMessageForDeviceFile.msgStatus = 1;
        }
        localMessageForDeviceFile.serial();
        a(((Session)localObject).uSessionID, localMessageForDeviceFile.frienduin, localMessageForDeviceFile.istroop, localMessageForDeviceFile.uniseq);
        localArrayList.add(localMessageForDeviceFile);
      }
    }
    a(localArrayList);
    return true;
  }
  
  public void b(Session paramSession)
  {
    if (paramSession.bSend)
    {
      paramSession = a(Long.valueOf(paramSession.uSessionID));
      if (paramSession != null) {}
    }
    else
    {
      return;
    }
    paramSession.nFileStatus = 2;
    a(paramSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor
 * JD-Core Version:    0.7.0.1
 */