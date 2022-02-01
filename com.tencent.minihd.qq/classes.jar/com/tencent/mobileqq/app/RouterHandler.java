package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.dataline.util.QualityReportUtil;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.litetransfersdk.FTNInfo;
import com.tencent.litetransfersdk.FTNNotify;
import com.tencent.litetransfersdk.FileControl;
import com.tencent.litetransfersdk.LiteTransferListenerCallback;
import com.tencent.litetransfersdk.LiteTransferOperatorCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.MsgCSBody0x211;
import com.tencent.litetransfersdk.MsgCSBody0x211_0x7;
import com.tencent.litetransfersdk.MsgCSBody0x346;
import com.tencent.litetransfersdk.MsgHeader;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.MsgSCBody0x211;
import com.tencent.litetransfersdk.MsgSCBody0x211_0x7;
import com.tencent.litetransfersdk.MsgSCBody0x346;
import com.tencent.litetransfersdk.NFCInfo;
import com.tencent.litetransfersdk.NFCNotify;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.RouterMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hop;
import hoq;
import hor;
import hos;
import hot;
import hou;
import hov;
import how;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tencent.im.cs.cmd0x346.cmd0x346.ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.FTNNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify;

public class RouterHandler
  extends BusinessHandler
  implements LiteTransferListenerCallback, LiteTransferOperatorCallback
{
  private static final int jdField_a_of_type_Int = 0;
  private static SmartDeviceProxyMgr jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr = null;
  private static final int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString = "dataline.Router";
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 10;
  public static final int g = 100;
  public static final int h = 101;
  long jdField_a_of_type_Long = 0L;
  public RouterSessionAdapter a;
  public LiteTransferWrapper a;
  public ProtocolHelper a;
  private RouterHandler.NotifyReceiver jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = null;
  public String a;
  public ArrayList a;
  public HashMap a;
  public QQAppInterface b;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public RouterHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = "router";
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter = null;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr = (SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
    this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper = new ProtocolHelper(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper = new LiteTransferWrapper(this, this);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCSReply");
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCCReply");
    paramQQAppInterface.addAction("SmartDevice_receiveDatalineCCPush");
    paramQQAppInterface.addAction("com.tencent.mobileqq.intent.logout");
    paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_KICKED");
    paramQQAppInterface.addAction("mqq.intent.action.FORCE_LOGOUT");
    paramQQAppInterface.addAction("mqq.intent.action.EXIT_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().getPackageName());
    paramQQAppInterface.addAction("mqq.intent.action.LOGOUT");
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = new RouterHandler.NotifyReceiver(this);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver, paramQQAppInterface);
  }
  
  public static long a()
  {
    return jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a();
  }
  
  private void a(int paramInt, FTNNotify paramFTNNotify, long paramLong)
  {
    paramFTNNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFTNNotify(paramFTNNotify, paramLong).toByteArray();
    jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramLong, paramInt, paramFTNNotify);
  }
  
  private void a(int paramInt, FileControl paramFileControl, long paramLong)
  {
    paramFileControl = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromFileControl(paramFileControl, paramLong).toByteArray();
    jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramLong, paramInt, paramFileControl);
  }
  
  private void a(int paramInt, MsgCSBody0x211 paramMsgCSBody0x211)
  {
    switch (paramMsgCSBody0x211.uMsgSubType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211");
      }
      return;
    }
    a(paramInt, paramMsgCSBody0x211.msgBody0x211_0x7);
  }
  
  private void a(int paramInt, MsgCSBody0x211_0x7 paramMsgCSBody0x211_0x7)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    long l = paramMsgCSBody0x211_0x7.msgHeader.uint64_dst_uin;
    switch (paramMsgCSBody0x211_0x7.uMsgSubCmd)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form 0X211_0x7");
      }
      break;
    }
    for (;;)
    {
      return;
      while (i < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x1_FTNNotifySrc[i], l);
        i += 1;
      }
      while (j < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x2_NFCNotifySrc[j], l);
        j += 1;
      }
      continue;
      while (k < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl.length)
      {
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x3_FileControl[k], l);
        k += 1;
      }
      continue;
      while (m < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb.length)
      {
        paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m].bytes_originfile_md5 = null;
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0x9_FTNNotifyThumb[m], l);
        m += 1;
      }
      continue;
      while (n < paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb.length)
      {
        paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n].bytes_originfile_md5 = null;
        a(paramInt, paramMsgCSBody0x211_0x7.pMsgBody0x211_0x7_0xa_NFCNotifyThumb[n], l);
        n += 1;
      }
    }
  }
  
  private void a(int paramInt, MsgCSBody0x346 paramMsgCSBody0x346)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "SendPbMsg: _handleCSMsg0x346");
    }
    cmd0x346.ReqBody localReqBody = new cmd0x346.ReqBody();
    localReqBody.uint32_cmd.set(paramMsgCSBody0x346.uMsgSubType);
    localReqBody.uint32_seq.set(paramInt);
    localReqBody.uint32_business_id.set(56);
    localReqBody.uint32_client_type.set(310);
    if (!this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillReqBody(paramMsgCSBody0x346, localReqBody)) {
      return;
    }
    jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramMsgCSBody0x346.uMsgSubType, paramInt, localReqBody.toByteArray());
  }
  
  private void a(int paramInt, NFCNotify paramNFCNotify, long paramLong)
  {
    paramNFCNotify = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromNFCNotify(paramNFCNotify, paramLong).toByteArray();
    jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramLong, paramInt, paramNFCNotify);
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    paramArrayOfByte1 = new MsgSCBody();
    paramArrayOfByte1.uMsgType = 529;
    paramArrayOfByte1.msgBody0x211 = new MsgSCBody0x211();
    paramArrayOfByte1.msgBody0x211.uMsgSubType = 7;
    paramArrayOfByte1.msgBody0x211.msgBody0x211_0x7 = new MsgSCBody0x211_0x7();
    paramArrayOfByte1.bTimeOut = paramBoolean;
    paramArrayOfByte2 = paramArrayOfByte1.msgBody0x211.msgBody0x211_0x7;
    if (!paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      paramArrayOfByte2.uResult = i;
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "DoCCReply : nCookie[" + paramInt + "], isTimeout[" + paramBoolean);
      }
      this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte1);
      return;
    }
  }
  
  private void a(long paramLong, SubMsgType0x7.MsgBody.GenericSubCmd paramGenericSubCmd)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals("router")) {}
    for (;;)
    {
      return;
      try
      {
        if (paramGenericSubCmd.uint32_type.has())
        {
          paramGenericSubCmd.uint32_type.get();
          return;
        }
      }
      catch (Exception paramGenericSubCmd)
      {
        paramGenericSubCmd.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte)
  {
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0x7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte.msg_header.uint32_src_app_id.set(1001);
        paramArrayOfByte.msg_header.uint32_src_inst_id.set(0);
        paramArrayOfByte.msg_header.uint32_dst_app_id.set(AppSetting.a);
        paramArrayOfByte.msg_header.uint32_dst_inst_id.set(0);
        paramArrayOfByte.msg_header.uint64_src_uin.set(paramLong);
        paramArrayOfByte.msg_header.setHasFlag(true);
        if (paramArrayOfByte.uint32_sub_cmd.has())
        {
          i = paramArrayOfByte.uint32_sub_cmd.get();
          switch (i)
          {
          case 5: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("dataline.Router", 2, "onRecvRouterMsg : subMsgType[0x7] failed", paramArrayOfByte);
        return;
      }
      int i = 0;
    }
    b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x1_ftn_notify.get(), false);
    return;
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x2_nfc_notify.get(), false);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "app 文件控制命令");
    }
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x3_filecontrol.get());
    return;
    a(paramLong, paramArrayOfByte.msg_subcmd_0x4_generic);
    return;
    b(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0x9_ftn_thumb_notify.get(), true);
    return;
    a(paramArrayOfByte.msg_header, paramArrayOfByte.rpt_msg_subcmd_0xa_nfc_thumb_notify.get(), true);
  }
  
  private void a(RouterMsgRecord paramRouterMsgRecord, boolean paramBoolean)
  {
    String str = MsgProxyUtils.a(String.valueOf(paramRouterMsgRecord.peerDin), 6002);
    boolean bool = false;
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade == null) {}
    do
    {
      return;
      if (localQQMessageFacade.a.containsKey(str))
      {
        bool = ((QQMessageFacade.Message)localQQMessageFacade.a.get(str)).hasReply;
        localQQMessageFacade.a.remove(str);
      }
      paramRouterMsgRecord.frienduin = String.valueOf(paramRouterMsgRecord.peerDin);
      QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
      MessageRecord.copyMessageRecordBaseField(localMessage, paramRouterMsgRecord);
      localMessage.emoRecentMsg = null;
      localMessage.hasReply = bool;
      localQQMessageFacade.a(localMessage);
      localQQMessageFacade.a.put(str, localMessage);
    } while (!paramBoolean);
    c(String.valueOf(paramRouterMsgRecord.peerDin));
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList)
  {
    paramMsgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgCSBodyFromFileControl(paramMsgHeader, paramList);
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReceive(paramMsgHeader);
  }
  
  private void a(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.NFCNotify localNFCNotify = (SubMsgType0x7.MsgBody.NFCNotify)paramList.next();
      if ((localNFCNotify.uint64_sessionid.has()) && (localNFCNotify.uint32_originfiletype.has()) && (localNFCNotify.str_file_name.has()) && (localNFCNotify.uint64_file_len.has()) && (localNFCNotify.bytes_file_md5.has()) && (localNFCNotify.fixed32_ip.has()) && (localNFCNotify.uint32_port.has()) && (localNFCNotify.bytes_url_notify.has()) && (localNFCNotify.bytes_tokenkey.has()) && (this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.CheckActionInfo(localNFCNotify, this.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(localNFCNotify);
      }
    }
    if (localArrayList.size() > 0) {
      new Handler(Looper.getMainLooper()).post(new hop(this, paramMsgHeader, localArrayList, paramBoolean));
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    return jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramInt1, paramInt2, paramArrayOfByte);
  }
  
  public static boolean a(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(paramLong, paramInt, paramArrayOfByte);
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0)) {
        if (QLog.isColorLevel()) {
          QLog.e("dataline.Router", 2, "DoCSReply : reqBuff is null");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramArrayOfByte2 = new cmd0x346.ReqBody();
          try
          {
            paramArrayOfByte2.mergeFrom(paramArrayOfByte1);
            paramArrayOfByte1 = new MsgSCBody();
            paramArrayOfByte1.bTimeOut = true;
            paramArrayOfByte1.uMsgType = 838;
            paramArrayOfByte1.msgBody0x346 = new MsgSCBody0x346();
            paramArrayOfByte1.msgBody0x346.uMsgSubType = paramArrayOfByte2.uint32_cmd.get();
            this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte1);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramArrayOfByte1) {}
        } while (!QLog.isColorLevel());
        QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.ReqBody prase failed", paramArrayOfByte1);
        return;
        if ((paramArrayOfByte2 != null) && (paramArrayOfByte2.length != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("dataline.Router", 2, "DoCSReply : rspBuff is null");
      return;
      paramArrayOfByte1 = new cmd0x346.RspBody();
      try
      {
        paramArrayOfByte1.mergeFrom(paramArrayOfByte2);
        paramArrayOfByte2 = new MsgSCBody();
        paramArrayOfByte2.uMsgType = 838;
        paramArrayOfByte2.bTimeOut = false;
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.FillMsgSCBody(paramArrayOfByte2, paramArrayOfByte1, paramArrayOfByte1.uint32_cmd.get());
        this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.OnPbMsgReply(paramInt, paramArrayOfByte2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte1) {}
    } while (!QLog.isColorLevel());
    QLog.e("dataline.Router", 2, "DoCSReply : cmd0x346.rspBody prase failed", paramArrayOfByte1);
  }
  
  private void b(SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SubMsgType0x7.MsgBody.FTNNotify localFTNNotify = (SubMsgType0x7.MsgBody.FTNNotify)paramList.next();
      if ((localFTNNotify.uint64_sessionid.has()) && (localFTNNotify.uint32_originfiletype.has()) && (localFTNNotify.str_file_name.has()) && (localFTNNotify.uint64_file_len.has()) && (localFTNNotify.bytes_file_md5.has()) && (localFTNNotify.str_file_index.has()) && (this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.CheckActionInfo(localFTNNotify, this.jdField_a_of_type_JavaLangString))) {
        localArrayList.add(localFTNNotify);
      }
    }
    if (localArrayList.size() > 0) {
      new Handler(Looper.getMainLooper()).post(new hoq(this, paramMsgHeader, localArrayList, paramBoolean));
    }
  }
  
  private int c(int paramInt)
  {
    if (paramInt == 3) {}
    do
    {
      return -2005;
      if (paramInt == 1) {
        return -2000;
      }
    } while (paramInt != 2);
    return -2005;
  }
  
  private void c(String paramString)
  {
    QQMessageFacade localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localQQMessageFacade == null) {}
    do
    {
      return;
      EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
      paramString = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramString, 6002);
      localEntityManager.a();
    } while (paramString == null);
    localQQMessageFacade.a(paramString);
  }
  
  private void d(RouterMsgRecord paramRouterMsgRecord)
  {
    Object localObject = Long.toString(paramRouterMsgRecord.peerDin);
    String str = a(paramRouterMsgRecord.peerDin);
    RecentUserProxy localRecentUserProxy = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    localObject = localRecentUserProxy.a((String)localObject, 6002);
    ((RecentUser)localObject).type = 6002;
    ((RecentUser)localObject).lastmsgtime = MessageCache.a();
    ((RecentUser)localObject).displayName = str;
    ((RecentUser)localObject).msgType = paramRouterMsgRecord.msgtype;
    localRecentUserProxy.a((RecentUser)localObject);
  }
  
  private void d(String paramString)
  {
    if (paramString == null) {}
    QQMessageFacade localQQMessageFacade;
    do
    {
      return;
      paramString = MsgProxyUtils.a(paramString, 6002);
      localQQMessageFacade = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while ((localQQMessageFacade == null) || (!localQQMessageFacade.a.containsKey(paramString)));
    localQQMessageFacade.a.remove(paramString);
  }
  
  public void GetThumbFilePath(int paramInt, Session paramSession) {}
  
  public void HandleSession(int paramInt1, long paramLong, int paramInt2, MsgHeader paramMsgHeader)
  {
    if (paramInt2 == 5) {
      new Handler(Looper.getMainLooper()).post(new hor(this, paramLong, paramMsgHeader));
    }
  }
  
  public void InvokeReport(ReportItem paramReportItem)
  {
    QualityReportUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramReportItem, QualityReportUtil.c);
  }
  
  public void OnGroupComplete(int paramInt1, int paramInt2) {}
  
  public void OnGroupStart(int paramInt) {}
  
  public boolean OnQueryAutoDownload(long paramLong, byte paramByte)
  {
    boolean bool2 = false;
    if (paramByte == 2)
    {
      boolean bool1 = NetworkUtil.g(BaseApplication.getContext());
      if (paramLong <= 5242880L) {}
      for (paramByte = 1;; paramByte = 0)
      {
        if (!bool1)
        {
          bool1 = bool2;
          if (getAutoDownload())
          {
            bool1 = bool2;
            if (paramByte == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
    }
    return true;
  }
  
  public void OnSessionComplete(long paramLong, int paramInt1, int paramInt2)
  {
    new Handler(Looper.getMainLooper()).post(new hov(this, paramLong, paramInt1));
  }
  
  public void OnSessionNew(Session paramSession, NFCInfo paramNFCInfo, FTNInfo paramFTNInfo)
  {
    new Handler(Looper.getMainLooper()).post(new hos(this, paramSession));
  }
  
  public void OnSessionProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    new Handler(Looper.getMainLooper()).post(new hou(this, paramLong1, paramLong2, paramLong3));
  }
  
  public void OnSessionStart(long paramLong)
  {
    new Handler(Looper.getMainLooper()).post(new hot(this, paramLong));
  }
  
  public void OnSessionUpdate(int paramInt, long paramLong, String paramString) {}
  
  public void SendPbMsg(int paramInt, MsgCSBody paramMsgCSBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "SendPbMsg: msgBody.uMsgType[" + paramMsgCSBody.uMsgType + "], nCookie[" + paramInt);
    }
    switch (paramMsgCSBody.uMsgType)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "SendPbMsg: cannot recognize the pb msg form JNI");
      }
      return;
    case 529: 
      a(paramInt, paramMsgCSBody.msgBody0x211);
      return;
    }
    a(paramInt, paramMsgCSBody.msgBody0x346);
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = 0;
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (DataLineMsgProxy.a((ProxyManager)localObject2, RouterMsgRecord.sBasicTableName + paramString)) {
      ((ProxyManager)localObject2).a((EntityManager)localObject1);
    }
    long l = 2147483647L;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      l = ((RouterMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).msgId;
    }
    paramString = ((EntityManager)localObject1).a(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + paramString + " where msgid<? order by msgid desc limit " + paramInt, new String[] { String.valueOf(l) });
    ((EntityManager)localObject1).a();
    paramInt = i;
    if (paramString != null)
    {
      i = paramString.size();
      paramInt = 0;
      if (paramInt < paramString.size())
      {
        localObject1 = (RouterMsgRecord)paramString.get(paramInt);
        localObject2 = (RouterMsgRecord)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(((RouterMsgRecord)localObject1).uSessionID));
        if (localObject2 == null)
        {
          if (((RouterMsgRecord)localObject1).status < 3) {
            ((RouterMsgRecord)localObject1).status = 4;
          }
          this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((RouterMsgRecord)localObject1).uSessionID), localObject1);
          this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject2);
        }
      }
      paramInt = i;
    }
    return paramInt;
  }
  
  public QQMessageFacade.Message a(String paramString)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (DataLineMsgProxy.a(localProxyManager, RouterMsgRecord.sBasicTableName + paramString)) {
      localProxyManager.a(localEntityManager);
    }
    paramString = localEntityManager.a(RouterMsgRecord.class, "select * from " + RouterMsgRecord.sBasicTableName + paramString + " order by msgid desc", null);
    localEntityManager.a();
    if (paramString == null) {
      return null;
    }
    paramString = (RouterMsgRecord)paramString.get(0);
    localMessage.extInt = paramString.status;
    localMessage.extStr = paramString.extStr;
    localMessage.msgtype = paramString.msgtype;
    localMessage.time = paramString.time;
    return localMessage;
  }
  
  public Class a()
  {
    return DataLineObserver.class;
  }
  
  public String a(long paramLong)
  {
    DeviceInfo localDeviceInfo = ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a(paramLong);
    if (localDeviceInfo == null) {
      return BaseApplication.getContext().getString(2131362208);
    }
    return localDeviceInfo.getDisplayName();
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("dataline.Router", 2, "--->>logout cancel all task");
    }
    a(32);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelAll(paramInt);
  }
  
  public void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.CancelGroup(paramInt, paramLong, 32, paramBoolean);
  }
  
  public void a(int paramInt1, Session paramSession, double paramDouble, int paramInt2)
  {
    if (paramSession == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "updateSession时，session为空, updateType[" + paramInt1 + "], fProgress[" + paramDouble + "], emTaskStatus[" + paramInt2);
      }
      return;
    }
    switch (paramInt1)
    {
    }
    Object localObject;
    label155:
    label448:
    label453:
    do
    {
      paramInt1 = 0;
      bool = false;
      paramSession = null;
      for (;;)
      {
        a(paramInt1, bool, paramSession);
        return;
        long l = this.jdField_a_of_type_Long + 1L;
        this.jdField_a_of_type_Long = l;
        localObject = new RouterMsgRecord(l);
        if (paramSession.msgHeader.uint64_src_uin == jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a())
        {
          l = paramSession.msgHeader.uint64_dst_uin;
          ((RouterMsgRecord)localObject).setTableName(String.valueOf(l));
          ((RouterMsgRecord)localObject).uSessionID = paramSession.uSessionID;
          if (QLog.isColorLevel()) {
            QLog.d("dataline.Router", 2, "获得sessionID=" + ((RouterMsgRecord)localObject).uSessionID + ", path=" + paramSession.strFilePathSrc + "din:" + l);
          }
          ((RouterMsgRecord)localObject).filename = paramSession.strFilePathSrc;
          ((RouterMsgRecord)localObject).fileSize = paramSession.uFileSizeSrc;
          if (!paramSession.bSend) {
            break label448;
          }
          paramInt1 = 1;
          ((RouterMsgRecord)localObject).issend = paramInt1;
          ((RouterMsgRecord)localObject).peerDin = l;
          ((RouterMsgRecord)localObject).msg = "file";
          ((RouterMsgRecord)localObject).msgtype = c(paramSession.emFileType);
          ((RouterMsgRecord)localObject).extInt = 1;
          ((RouterMsgRecord)localObject).time = MessageCache.a();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          b((RouterMsgRecord)localObject);
          this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((RouterMsgRecord)localObject).uSessionID), localObject);
          if (!paramSession.bSend) {
            break label453;
          }
        }
        for (paramInt1 = 7;; paramInt1 = 6)
        {
          bool = true;
          localObject = new Object[7];
          localObject[0] = Long.valueOf(0L);
          localObject[1] = Long.valueOf(paramSession.uSessionID);
          localObject[2] = paramSession.strFilePathSrc;
          localObject[3] = Byte.valueOf((byte)paramSession.emFileType);
          localObject[4] = Boolean.valueOf(false);
          localObject[5] = Boolean.valueOf(false);
          localObject[6] = Long.valueOf(paramSession.uFileSizeSrc);
          paramSession = (Session)localObject;
          break;
          l = paramSession.msgHeader.uint64_src_uin;
          break label155;
          paramInt1 = 0;
          break label261;
        }
        localObject = (RouterMsgRecord)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
        if (localObject == null) {
          break;
        }
        ((RouterMsgRecord)localObject).status = 2;
        ((RouterMsgRecord)localObject).progress = paramDouble;
        if (paramSession.bSend) {}
        for (paramInt1 = 7;; paramInt1 = 6)
        {
          bool = true;
          localObject = new Object[7];
          localObject[0] = Long.valueOf(0L);
          localObject[1] = Long.valueOf(paramSession.uSessionID);
          localObject[2] = paramSession.strFilePathSrc;
          localObject[3] = Byte.valueOf((byte)paramSession.emFileType);
          localObject[4] = Boolean.valueOf(false);
          localObject[5] = Boolean.valueOf(true);
          localObject[6] = Long.valueOf(paramSession.uFileSizeSrc);
          paramSession = (Session)localObject;
          break;
        }
        localObject = (RouterMsgRecord)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
        if (localObject == null) {
          break;
        }
        ((RouterMsgRecord)localObject).status = 2;
        ((RouterMsgRecord)localObject).progress = ((float)paramDouble);
        paramInt1 = 4;
        bool = true;
        localObject = new Object[3];
        localObject[0] = Long.valueOf(0L);
        localObject[1] = Long.valueOf(paramSession.uSessionID);
        localObject[2] = Float.valueOf((float)paramDouble);
        paramSession = (Session)localObject;
      }
      localObject = (RouterMsgRecord)this.jdField_b_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
    } while (localObject == null);
    label261:
    if (paramInt2 == 2)
    {
      ((RouterMsgRecord)localObject).progress = 1.0D;
      ((RouterMsgRecord)localObject).status = 3;
      label719:
      ((RouterMsgRecord)localObject).msgtype = c(paramSession.emFileType);
      ((RouterMsgRecord)localObject).msg = "file";
      ((RouterMsgRecord)localObject).extInt = ((RouterMsgRecord)localObject).status;
      ((RouterMsgRecord)localObject).time = MessageCache.a();
      c((RouterMsgRecord)localObject);
      if (((RouterMsgRecord)localObject).status != 5) {
        this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramSession.uSessionID));
      }
      if (!paramSession.bSend) {
        break label884;
      }
      paramInt1 = 2;
      label797:
      if (paramInt2 != 2) {
        break label889;
      }
    }
    label884:
    label889:
    for (boolean bool = true;; bool = false)
    {
      localObject = new Object[3];
      localObject[0] = Long.valueOf(0L);
      localObject[1] = Long.valueOf(paramSession.uSessionID);
      localObject[2] = paramSession.strFilePathSrc;
      paramSession = (Session)localObject;
      break;
      if ((paramInt2 == 32) || (paramInt2 == 11) || (paramInt2 == 8))
      {
        ((RouterMsgRecord)localObject).status = 5;
        break label719;
      }
      ((RouterMsgRecord)localObject).status = 4;
      break label719;
      paramInt1 = 3;
      break label797;
    }
  }
  
  public void a(RouterMsgRecord paramRouterMsgRecord)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramRouterMsgRecord);
    this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(paramRouterMsgRecord.uSessionID));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(0), 0, paramRouterMsgRecord.getTableName(), "msgId=?", new String[] { String.valueOf(paramRouterMsgRecord.msgId) }, 2, null);
    paramRouterMsgRecord = String.valueOf(paramRouterMsgRecord.peerDin);
    d(paramRouterMsgRecord);
    c(paramRouterMsgRecord);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    int i;
    if (this.jdField_b_of_type_JavaUtilHashMap != null)
    {
      i = this.jdField_b_of_type_JavaUtilHashMap.size();
      if (i <= 10) {}
    }
    for (;;)
    {
      a(paramString, i);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_Long = ((RouterMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).msgId;
      }
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Router", 2, "初始化RouterMsgRecord的msgid为" + this.jdField_a_of_type_Long);
      }
      return;
      i = 10;
    }
  }
  
  public void a(ArrayList paramArrayList, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      int j = paramArrayList.size();
      localArrayList = new ArrayList();
      int i = 0;
      if (i < j)
      {
        Object localObject = ((FileInfo)paramArrayList.get(i)).d();
        localObject = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, (String)localObject, null, 0, 0, 0L, 0, 0, 0, false);
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localObject);
          ((Session)localObject).uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(0);
          ((Session)localObject).msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService((Session)localObject, paramString, paramArrayOfByte);
        }
      }
    } while (localArrayList.size() <= 0);
    a(localArrayList, false);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (!NetworkUtil.e(BaseApplication.getContext())) {
      this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showNoNetworkDialog();
    }
    do
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Session localSession = (Session)paramArrayList.next();
        File localFile = new File(localSession.strFilePathSrc);
        if ((!paramBoolean) && (!localFile.exists())) {
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileNotExistDialog(localFile.getName());
        } else if ((!paramBoolean) && (localFile.length() == 0L)) {
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileIsEmptyDialog(localFile.getName());
        } else if ((!paramBoolean) && (localFile.length() > 2147483648L)) {
          this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.showFileTooLargeDialog(localFile.getName());
        } else {
          localArrayList.add(localSession);
        }
      }
    } while (localArrayList.size() == 0);
    paramArrayList = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (localArrayList.size() == 1) {}
    for (boolean bool = false;; bool = true)
    {
      paramArrayList.SendGroup(localArrayList, paramBoolean, bool);
      return;
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramArrayList.next();
      Session localSession = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.genSession(0, localDataLineMsgRecord.path, localDataLineMsgRecord.thumbPath, DataLineHandler.d(localDataLineMsgRecord.msgtype), 0, localDataLineMsgRecord.sessionid, localDataLineMsgRecord.groupId, localDataLineMsgRecord.groupSize, localDataLineMsgRecord.groupIndex, true);
      if (localSession != null)
      {
        if (0L == localSession.uSessionID) {
          localSession.uSessionID = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper.generateSessionID(localDataLineMsgRecord.groupId);
        }
        localSession.msgHeader = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.msgHeader(paramLong);
        this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.fillService(localSession, paramString, paramArrayOfByte);
        localArrayList.add(localSession);
        if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(localSession.uSessionID)) == null)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localSession.uSessionID), localSession);
        }
      }
    }
    if (localArrayList.size() > 0) {
      a(localArrayList, paramBoolean);
    }
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    SubMsgType0x7.MsgBody localMsgBody = this.jdField_a_of_type_ComTencentLitetransfersdkProtocolHelper.MsgBodyFromMpFileNotify(paramLong1, paramLong3, paramInt2);
    byte[] arrayOfByte = localMsgBody.toByteArray();
    return jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceProxyMgr.a(localMsgBody.msg_header.uint64_dst_uin.get(), 1, arrayOfByte);
  }
  
  void b()
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread()) {
      new Handler(localLooper).post(new how(this));
    }
    while (this.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
  }
  
  public void b(RouterMsgRecord paramRouterMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RouterMsgRecord localRouterMsgRecord = paramRouterMsgRecord.clone();
    localProxyManager.a(String.valueOf(0), 0, paramRouterMsgRecord.getTableName(), localRouterMsgRecord, 0, null);
    d(paramRouterMsgRecord);
    a(paramRouterMsgRecord, true);
  }
  
  public void b(String paramString)
  {
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (DataLineMsgProxy.a(localProxyManager, RouterMsgRecord.sBasicTableName + paramString)) {
      localProxyManager.a(localEntityManager);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void c()
  {
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((RouterMsgRecord)localObject1).getTableName())
    {
      localObject1 = (RouterMsgRecord)((Iterator)localObject2).next();
      if (((RouterMsgRecord)localObject1).status < 3) {
        a(0, ((RouterMsgRecord)localObject1).uSessionID, true);
      }
      this.jdField_b_of_type_JavaUtilHashMap.remove(Long.valueOf(((RouterMsgRecord)localObject1).uSessionID));
    }
    localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (localObject1 != null) {
      ((ProxyManager)localObject2).a(String.valueOf(0), 0, (String)localObject1, null, null, 2, null);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    b();
  }
  
  public void c(RouterMsgRecord paramRouterMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramRouterMsgRecord.status));
    localProxyManager.a(String.valueOf(0), 0, paramRouterMsgRecord.getTableName(), localContentValues, "msgId=?", new String[] { String.valueOf(paramRouterMsgRecord.msgId) }, 1, null);
    a(paramRouterMsgRecord, true);
  }
  
  public void e()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver);
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler$NotifyReceiver = null;
    }
    a(32);
    LiteTransferWrapper localLiteTransferWrapper = this.jdField_a_of_type_ComTencentLitetransfersdkLiteTransferWrapper;
    if (this.jdField_b_of_type_JavaUtilHashMap.size() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localLiteTransferWrapper.endLiteTransfer(bool);
      return;
    }
  }
  
  public boolean getAutoDownload()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getBoolean("auto_receive_files", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler
 * JD-Core Version:    0.7.0.1
 */