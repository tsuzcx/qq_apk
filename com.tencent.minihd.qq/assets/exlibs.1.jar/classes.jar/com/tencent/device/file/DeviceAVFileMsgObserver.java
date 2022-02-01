package com.tencent.device.file;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import czv;
import czw;
import czx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAVFileMsgObserver
  extends DeviceFileObserver
{
  public static final String a;
  DevAudioMsgProcessor jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor = new DevAudioMsgProcessor();
  DevVideoMsgProcessor jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor = new DevVideoMsgProcessor();
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new czv(this, Looper.getMainLooper());
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet(10);
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
  private ConcurrentHashMap b = new ConcurrentHashMap(10);
  
  static
  {
    jdField_a_of_type_JavaLangString = DeviceAVFileMsgObserver.class.getSimpleName();
  }
  
  private void b(Session paramSession, boolean paramBoolean)
  {
    int j = 1;
    czx localczx = (czx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localczx == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.c))
    {
      this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramSession, localczx.jdField_a_of_type_JavaLangString, localczx.jdField_a_of_type_Long, localczx.jdField_a_of_type_Int, paramBoolean);
      localObject1 = BaseApplicationImpl.a().a();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).a(53)).a(Long.parseLong(localczx.jdField_a_of_type_JavaLangString));
        if (localObject2 == null) {
          break label352;
        }
      }
    }
    label148:
    label159:
    label345:
    label352:
    for (int i = ((DeviceInfo)localObject2).productId;; i = 0)
    {
      if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.d) == 0) {
        if (paramBoolean)
        {
          j = 0;
          SmartDeviceReport.a((AppRuntime)localObject1, "Net_SendMsg_Audio", 0, j, i);
          localObject1 = ((QQAppInterface)localObject1).a(Conversation.class);
          if (localObject1 != null) {
            ((Handler)localObject1).sendEmptyMessage(1009);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
          localObject2 = new DeviceAVFileMsgObserver.DevMsgViewData(this);
          if (!paramBoolean) {
            break label345;
          }
        }
      }
      for (i = 1003;; i = 1005)
      {
        ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Int = i;
        ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Long = localczx.jdField_a_of_type_Long;
        ((Message)localObject1).obj = localObject2;
        this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
        return;
        if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.d)) {
          break;
        }
        this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a(paramSession, localczx.jdField_a_of_type_JavaLangString, localczx.jdField_a_of_type_Long, localczx.jdField_a_of_type_Int, paramBoolean);
        break;
        j = 1;
        break label148;
        if (paramSession.actionInfo.strServiceName.compareTo(DeviceMsgHandle.c) != 0) {
          break label159;
        }
        if (paramBoolean) {
          j = 0;
        }
        SmartDeviceReport.a((AppRuntime)localObject1, "Net_SendMsg_Video", 0, j, i);
        break label159;
      }
    }
  }
  
  public String a(DataPoint paramDataPoint)
  {
    int i = 1;
    try
    {
      Object localObject1 = new JSONObject(paramDataPoint.mValue);
      long l1 = ((JSONObject)localObject1).optLong("msg_time", MessageCache.a());
      long l2 = ((JSONObject)localObject1).optLong("duration", 0L);
      localObject1 = ((JSONObject)localObject1).optString("file_key", "");
      Object localObject2 = BaseApplicationImpl.a().a();
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (QQAppInterface)localObject2;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "receive audiomsg length:" + l2);
        }
        MessageForDevPtt localMessageForDevPtt = (MessageForDevPtt)MessageRecordFactory.a(-4501);
        localMessageForDevPtt.url = "";
        localMessageForDevPtt.itemType = 2;
        if ((SttManager.a(0)) && (SttManager.a((QQAppInterface)localObject2))) {}
        for (;;)
        {
          localMessageForDevPtt.sttAbility = i;
          localMessageForDevPtt.longPttVipFlag = 0;
          localMessageForDevPtt.c2cViaOffline = true;
          localMessageForDevPtt.msgtype = -4501;
          localMessageForDevPtt.istroop = 9501;
          localMessageForDevPtt.issend = 0;
          localMessageForDevPtt.isread = false;
          localMessageForDevPtt.selfuin = ((QQAppInterface)localObject2).a();
          localMessageForDevPtt.senderuin = Long.toString(paramDataPoint.mDin);
          localMessageForDevPtt.frienduin = Long.toString(paramDataPoint.mDin);
          localMessageForDevPtt.time = l1;
          localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
          localMessageForDevPtt.timeLength = ((int)l2);
          localMessageForDevPtt.urlAtServer = ((String)localObject1);
          localMessageForDevPtt.serial();
          ((QQAppInterface)localObject2).a().a(localMessageForDevPtt, ((QQAppInterface)localObject2).a());
          paramDataPoint = localMessageForDevPtt.msg;
          return paramDataPoint;
          i = 0;
        }
      }
      return "";
    }
    catch (JSONException paramDataPoint)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getString from json error:" + paramDataPoint.getMessage());
      }
    }
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage" + ((DeviceAVFileMsgObserver.DevMsgViewData)paramMessage.obj).jdField_a_of_type_Long + " status " + paramMessage.what + "retCode " + paramMessage.arg1);
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Object localObject = (czw)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      View localView = ((czw)localObject).a();
      localObject = ((czw)localObject).a();
      if ((localView != null) && (localObject != null)) {
        ((DeviceAVFileMsgObserver.DevMsgViewCallback)localObject).a(localView, (DeviceAVFileMsgObserver.DevMsgViewData)paramMessage.obj);
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
  
  public void a(View paramView, DeviceAVFileMsgObserver.DevMsgViewCallback paramDevMsgViewCallback)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      czw localczw = (czw)localIterator.next();
      if (localczw.a() == paramView)
      {
        localczw.b = new WeakReference(paramDevMsgViewCallback);
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new czw(this, paramView, paramDevMsgViewCallback));
  }
  
  public void a(MessageForDevPtt paramMessageForDevPtt)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramMessageForDevPtt.uniseq))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!this.b.containsKey(Long.valueOf(paramMessageForDevPtt.uniseq))) {
              break;
            }
            l = ((Long)this.b.get(Long.valueOf(paramMessageForDevPtt.uniseq))).longValue();
          } while (MessageCache.a() - l < 3600L);
          localObject = BaseApplicationImpl.a().a();
        } while (!(localObject instanceof QQAppInterface));
        localObject = (QQAppInterface)localObject;
      } while (TextUtils.isEmpty(paramMessageForDevPtt.urlAtServer));
      byte[] arrayOfByte = Base64.decode(paramMessageForDevPtt.urlAtServer, 0);
      long l = ((DeviceFileHandler)((QQAppInterface)localObject).a(52)).a(arrayOfByte);
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramMessageForDevPtt.uniseq));
      Object localObject = String.valueOf(l);
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
      {
        paramMessageForDevPtt = new czx(this, paramMessageForDevPtt.frienduin, paramMessageForDevPtt.uniseq, paramMessageForDevPtt.istroop);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, paramMessageForDevPtt);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "found resume");
  }
  
  public void a(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onServiceSessionNew : service@" + paramSession.actionInfo.strServiceName);
    }
  }
  
  public void a(Session paramSession, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onServiceSessionProgress : service@" + paramSession.actionInfo.strServiceName);
    }
    czx localczx = (czx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
    if (localczx != null)
    {
      if (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.c)) {
        break label156;
      }
      this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramSession, localczx.jdField_a_of_type_JavaLangString, localczx.jdField_a_of_type_Long, localczx.jdField_a_of_type_Int, paramFloat);
    }
    for (;;)
    {
      paramSession = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      DeviceAVFileMsgObserver.DevMsgViewData localDevMsgViewData = new DeviceAVFileMsgObserver.DevMsgViewData(this);
      localDevMsgViewData.jdField_a_of_type_Int = 1002;
      localDevMsgViewData.jdField_a_of_type_Float = paramFloat;
      localDevMsgViewData.jdField_a_of_type_Long = localczx.jdField_a_of_type_Long;
      paramSession.obj = localDevMsgViewData;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed(paramSession, 0L);
      return;
      label156:
      if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.d)) {
        this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a(paramSession, localczx.jdField_a_of_type_JavaLangString, localczx.jdField_a_of_type_Long, localczx.jdField_a_of_type_Int, paramFloat);
      }
    }
  }
  
  public void a(Session paramSession, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onServiceSessionComplete : service@" + paramSession.actionInfo.strServiceName);
    }
    if (paramSession.bSend) {
      b(paramSession, paramBoolean);
    }
    czx localczx;
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.c)) || (paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.d)) || (!paramSession.actionInfo.strServiceName.equalsIgnoreCase(DeviceMsgHandle.e)));
        localczx = (czx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramSession.uSessionID));
      } while (localczx == null);
      localObject1 = BaseApplicationImpl.a().a();
      if (!(localObject1 instanceof QQAppInterface)) {
        break;
      }
      localObject1 = (QQAppInterface)localObject1;
      localObject2 = ((QQAppInterface)localObject1).a().a(localczx.jdField_a_of_type_JavaLangString, localczx.jdField_a_of_type_Int, localczx.jdField_a_of_type_Long);
    } while (localObject2 == null);
    MessageForDevPtt localMessageForDevPtt;
    if ((localObject2 instanceof MessageForDevPtt))
    {
      localMessageForDevPtt = (MessageForDevPtt)localObject2;
      localMessageForDevPtt.url = paramSession.strFilePathSrc;
      if (paramBoolean)
      {
        localMessageForDevPtt.fileSize = paramSession.uFileSizeSrc;
        localMessageForDevPtt.msg = localMessageForDevPtt.getSummary();
        localMessageForDevPtt.serial();
        ((QQAppInterface)localObject1).a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, ((MessageRecord)localObject2).uniseq, localMessageForDevPtt.msgData);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.obtainMessage();
      localObject2 = new DeviceAVFileMsgObserver.DevMsgViewData(this);
      if (!paramBoolean) {
        break label384;
      }
    }
    label384:
    for (int i = 2003;; i = 2005)
    {
      ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Int = i;
      ((DeviceAVFileMsgObserver.DevMsgViewData)localObject2).jdField_a_of_type_Long = localczx.jdField_a_of_type_Long;
      ((Message)localObject1).obj = localObject2;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.sendMessageDelayed((Message)localObject1, 0L);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(String.valueOf(paramSession.uSessionID));
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(localczx.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label391;
      }
      this.b.remove(Long.valueOf(localczx.jdField_a_of_type_Long));
      return;
      localMessageForDevPtt.fileSize = -1L;
      break;
    }
    label391:
    this.b.put(Long.valueOf(localczx.jdField_a_of_type_Long), Long.valueOf(MessageCache.a()));
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      paramString2 = ((DeviceFileHandler)((QQAppInterface)localObject).a(52)).a(paramString2, paramString1, null, paramLong1);
      if (paramString2 != null) {
        break label42;
      }
    }
    label42:
    do
    {
      for (;;)
      {
        return;
        localObject = String.valueOf(paramString2.uSessionID);
        if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject))
        {
          czx localczx = new czx(this, String.valueOf(paramLong1), paramLong2, paramInt);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localczx);
        }
        while (!NetworkUtil.e(BaseApplication.getContext()))
        {
          if (!paramString1.equalsIgnoreCase(DeviceMsgHandle.c)) {
            break label149;
          }
          this.jdField_a_of_type_ComTencentDeviceFileDevVideoMsgProcessor.a(paramString2, String.valueOf(paramLong1), paramLong2, paramInt, false);
          return;
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "found resume");
          }
        }
      }
    } while (!paramString1.equalsIgnoreCase(DeviceMsgHandle.d));
    label149:
    this.jdField_a_of_type_ComTencentDeviceFileDevAudioMsgProcessor.a(paramString2, String.valueOf(paramLong1), paramLong2, paramInt, false);
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (((czx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).jdField_a_of_type_Long == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  public void b(Session paramSession)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onServiceSessionStart : service@" + paramSession.actionInfo.strServiceName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DeviceAVFileMsgObserver
 * JD-Core Version:    0.7.0.1
 */