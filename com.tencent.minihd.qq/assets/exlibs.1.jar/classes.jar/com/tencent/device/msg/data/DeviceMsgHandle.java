package com.tencent.device.msg.data;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.file.DeviceFileObserver;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dbk;
import dbl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class DeviceMsgHandle
  extends BusinessHandler
{
  public static final String a;
  public static String b = "ImgMsg";
  public static String c = "VideoMsg";
  public static String d = "AudioMsg";
  public static String e = "Device";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new dbl(this);
  public DeviceAVFileMsgObserver a;
  private DeviceFileObserver jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver = new dbk(this);
  public DevSingleStructMsgProcessor a;
  private DeviceComnFileMsgProcessor jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor;
  public HashMap a;
  
  static
  {
    jdField_a_of_type_JavaLangString = MessageForDeviceFile.class.getSimpleName();
  }
  
  public DeviceMsgHandle(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor = new DeviceComnFileMsgProcessor(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor = new DevSingleStructMsgProcessor(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver = new DeviceAVFileMsgObserver();
    a(d, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(c, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(e, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    a(e, this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor);
    a(b, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("SmartDevice_DeviceUnBindRst");
    localIntentFilter.addAction("SmartDevice_DeviceAdminUnbind");
    localIntentFilter.addAction("SmartDevice_receiveDPMsg");
    paramQQAppInterface.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.smartdevice.permission.broadcast2", null);
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
    localMessageForText.msgtype = -1000;
    localMessageForText.istroop = 9501;
    localMessageForText.issend = 0;
    localMessageForText.isread = false;
    localMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localMessageForText.senderuin = paramString1;
    localMessageForText.frienduin = paramString1;
    localMessageForText.msg = paramString2;
    localMessageForText.time = paramLong;
    paramString1 = new ArrayList();
    paramString1.add(localMessageForText);
    a(paramString1);
  }
  
  private void a(List paramList)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "cost:" + (System.currentTimeMillis() - l));
    }
  }
  
  public DeviceAVFileMsgObserver a()
  {
    return this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver;
  }
  
  public DevSingleStructMsgProcessor a()
  {
    return this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor;
  }
  
  public DeviceComnFileMsgProcessor a()
  {
    return this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor;
  }
  
  protected Class a()
  {
    return BusinessObserver.class;
  }
  
  public void a(DataPoint paramDataPoint)
  {
    try
    {
      Object localObject = new JSONObject(paramDataPoint.mValue);
      long l = ((JSONObject)localObject).optLong("msg_time", MessageCache.a());
      localObject = ((JSONObject)localObject).optString("text", " ");
      a(Long.toString(paramDataPoint.mDin), (String)localObject, l);
      return;
    }
    catch (Exception paramDataPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onRecvRawTextMsg parse from json error:" + paramDataPoint.getMessage());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString1, String paramString2)
  {
    MessageForDeviceSingleStruct localMessageForDeviceSingleStruct = (MessageForDeviceSingleStruct)MessageRecordFactory.a(-4502);
    localMessageForDeviceSingleStruct.msgtype = -4502;
    localMessageForDeviceSingleStruct.istroop = 9501;
    localMessageForDeviceSingleStruct.issend = 0;
    localMessageForDeviceSingleStruct.isread = false;
    localMessageForDeviceSingleStruct.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localMessageForDeviceSingleStruct.senderuin = paramString1;
    localMessageForDeviceSingleStruct.frienduin = paramString1;
    localMessageForDeviceSingleStruct.msg = localMessageForDeviceSingleStruct.strDigest;
    localMessageForDeviceSingleStruct.parseFromJson(paramString2);
    paramString1 = new ArrayList();
    paramString1.add(localMessageForDeviceSingleStruct);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    MessageForNewGrayTips localMessageForNewGrayTips;
    if (paramBoolean3)
    {
      i = -5001;
      localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
      localMessageForNewGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramString1, paramString1, paramString2, paramLong, i, 9501, paramLong);
      localMessageForNewGrayTips.isread = paramBoolean1;
      if (!paramBoolean2) {
        break label104;
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      localMessageForNewGrayTips.issend = i;
      localMessageForNewGrayTips.spans = null;
      localMessageForNewGrayTips.updateMsgData();
      paramString1 = new ArrayList();
      paramString1.add(localMessageForNewGrayTips);
      a(paramString1);
      return;
      i = -5000;
      break;
    }
  }
  
  public boolean a(String paramString, DeviceFileObserver paramDeviceFileObserver)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject);
    }
    if (!((List)localObject).contains(paramDeviceFileObserver)) {
      ((List)localObject).add(paramDeviceFileObserver);
    }
    return true;
  }
  
  public boolean b(String paramString, DeviceFileObserver paramDeviceFileObserver)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString != null) {
      paramString.remove(paramDeviceFileObserver);
    }
    return true;
  }
  
  public void e()
  {
    super.e();
    b(d, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(c, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(e, this.jdField_a_of_type_ComTencentDeviceFileDeviceAVFileMsgObserver);
    b(e, this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor);
    b(b, this.jdField_a_of_type_ComTencentDeviceMsgDataDeviceComnFileMsgProcessor);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentDeviceFileDeviceFileObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentDeviceMsgDataDevSingleStructMsgProcessor.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle
 * JD-Core Version:    0.7.0.1
 */