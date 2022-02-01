package com.tencent.device.file;

import com.tencent.litetransfersdk.ActionInfo;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DeviceFileHandler
  extends RouterHandler
{
  public static final int a = 1;
  public static final int b = 2;
  private static final String b = "Device.file";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  private HashSet a;
  
  public DeviceFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "Device";
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private long a(byte[] paramArrayOfByte, MsgCSBody paramMsgCSBody, Long paramLong)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
        }
        return 0L;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      paramMsgCSBody.uMsgType = 529;
      paramMsgCSBody.msgBody0x211 = new MsgCSBody0x211();
      paramMsgCSBody.msgBody0x211.uMsgSubType = 7;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7 = new MsgCSBody0x211_0x7();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.uMsgSubCmd = 1;
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader = new MsgHeader();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_app_id = paramArrayOfByte.uint32_appid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_src_inst_id = paramArrayOfByte.uint32_instid.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint64_dst_uin = paramArrayOfByte.uint64_src_uin.get();
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.msgHeader.uint32_dst_uin_type = paramArrayOfByte.uint32_uin_type.get();
      paramLong = new ArrayList();
      FTNNotify localFTNNotify = new FTNNotify();
      localFTNNotify.uint64_sessionid = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localFTNNotify.str_file_name = paramArrayOfByte.str_file_name.get();
      localFTNNotify.str_file_index = new String(paramArrayOfByte.bytes_file_index.get().toByteArray());
      localFTNNotify.bytes_file_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint64_file_len = paramArrayOfByte.uint64_file_length.get();
      localFTNNotify.bytes_originfile_md5 = paramArrayOfByte.bytes_file_md5.get().toByteArray();
      localFTNNotify.uint32_originfiletype = 0;
      localFTNNotify.uint32_group_id = 0;
      localFTNNotify.uint32_group_size = 0;
      localFTNNotify.uint32_group_curindex = 0;
      localFTNNotify.msg_ActionInfo = new ActionInfo();
      localFTNNotify.msg_ActionInfo.strServiceName = this.jdField_a_of_type_JavaLangString;
      localFTNNotify.msg_ActionInfo.vServiceInfo = null;
      localFTNNotify.uint32_batchID = 0;
      localFTNNotify.uint32_groupflag = 0;
      long l = localFTNNotify.uint64_sessionid;
      paramLong.add(localFTNNotify);
      paramMsgCSBody.msgBody0x211.msgBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc = ((FTNNotify[])paramLong.toArray(new FTNNotify[paramLong.size()]));
      return localFTNNotify.uint64_sessionid;
    }
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionComplete uSessionID=" + paramLong + " retCode=" + paramInt2 + " TaskStatus=" + paramInt1);
    }
    Session localSession = (Session)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionComplete no session for uSessionID=" + paramLong);
      }
      return;
    }
    if (paramInt1 == 2) {}
    for (boolean bool = true;; bool = false)
    {
      a(103, bool, localSession);
      return;
    }
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    if (paramSession.actionInfo.strServiceName.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)) {
      if (paramSession.actionInfo.vServiceInfo == null) {}
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        try
        {
          paramNFCInfo = (DeviceProto.MsgActionInfo)new DeviceProto.MsgActionInfo().mergeFrom(paramSession.actionInfo.vServiceInfo);
          if (paramNFCInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Device.file", 2, "OnSessionNew decode bussiness name error");
            }
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramNFCInfo)
        {
          for (;;)
          {
            paramNFCInfo.printStackTrace();
            paramNFCInfo = null;
          }
          paramSession.actionInfo.strServiceName = paramNFCInfo.str_bussiness_name.get();
          paramSession.actionInfo.vServiceInfo = paramNFCInfo.bytes_buff_with_file.get().toByteArray();
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramSession.uSessionID), paramSession);
      } while (this.jdField_a_of_type_JavaUtilHashSet.contains(Long.valueOf(paramSession.uSessionID)));
      a(100, true, paramSession);
    }
    QLog.d("Device.file", 2, "OnSessionStart uSessionID=" + paramSession.uSessionID + " bussiness=" + paramSession.actionInfo.strServiceName);
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionProgress uSessionID=" + paramLong1 + "=====" + (float)((float)paramLong2 * 1.0D / paramLong3));
    }
    Session localSession = (Session)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong1));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionProgress no session for uSessionID=" + paramLong1);
      }
      return;
    }
    a(102, true, new Object[] { localSession, Float.valueOf((float)((float)paramLong2 * 1.0D / (float)paramLong3)) });
  }
  
  public void OnSessionStart(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "OnSessionStart uSessionID=" + paramLong);
    }
    Session localSession = (Session)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "OnSessionStart no session for uSessionID=" + paramLong);
      }
      return;
    }
    a(101, true, localSession);
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public long a(byte[] paramArrayOfByte)
  {
    MsgCSBody localMsgCSBody = new MsgCSBody();
    long l = a(paramArrayOfByte, localMsgCSBody, Long.valueOf(0L));
    this.jdField_a_of_type_JavaUtilHashSet.add(Long.valueOf(l));
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(localMsgCSBody);
    return l;
  }
  
  public DeviceProto.MsgFileKey a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (DeviceProto.MsgFileKey)new DeviceProto.MsgFileKey().mergeFrom(paramArrayOfByte);
      if ((paramArrayOfByte == null) && (QLog.isColorLevel())) {
        QLog.w("Device.file", 2, "getFileKey decode MsgFileKey error");
      }
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
    }
  }
  
  public Session a(String paramString1, String paramString2, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Device.file", 2, "send file path=" + paramString1 + " servicename=" + paramString2 + " to " + paramLong);
    }
    ArrayList localArrayList = new ArrayList();
    Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, paramString1, null, 0, 0, 0L, 0, 0, 0, false);
    if (localSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Device.file", 2, "session create failed");
      }
      paramString1 = null;
    }
    do
    {
      return paramString1;
      localArrayList.add(localSession);
      localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
      localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
      paramString1 = new DeviceProto.MsgActionInfo();
      paramString1.str_bussiness_name.set(paramString2);
      if (paramArrayOfByte != null) {
        paramString1.bytes_buff_with_file.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramString1 = paramString1.toByteArray();
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, this.jdField_a_of_type_JavaLangString, paramString1);
      paramString1 = localSession;
    } while (localArrayList.size() <= 0);
    a(localArrayList, false);
    return localSession;
  }
  
  protected Class a()
  {
    return DeviceFileObserver.class;
  }
  
  public boolean getAutoDownload()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DeviceFileHandler
 * JD-Core Version:    0.7.0.1
 */