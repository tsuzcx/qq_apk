package com.tencent.mobileqq.app.message;

import ActionMsg.MsgBody;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.servlet.GetSubAccountUnreadIntent;
import com.tencent.mobileqq.servlet.QzoneSubAccountUnreadServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import htk;
import htl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbBindUinGetMsgReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmReq;
import msf.msgsvc.msg_svc.PbBindUinMsgReadedConfirmResp;
import msf.msgsvc.msg_svc.PbGetMsgResp;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class SubAccountMessageProcessor
  extends C2CMessageProcessor
{
  public SubAccountMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    str1 = paramToServiceMsg.extraData.getString("nextAction");
    str2 = paramToServiceMsg.extraData.getString("subAccount");
    i = -1;
    l = 0L;
    localObject2 = null;
    paramFromServiceMsg = null;
    msg_svc.PbBindUinMsgReadedConfirmResp localPbBindUinMsgReadedConfirmResp = new msg_svc.PbBindUinMsgReadedConfirmResp();
    localObject1 = localObject2;
    j = i;
    try
    {
      paramObject = (msg_svc.PbBindUinMsgReadedConfirmResp)localPbBindUinMsgReadedConfirmResp.mergeFrom((byte[])paramObject);
      localObject1 = localObject2;
      j = i;
      i = paramObject.result.get();
      localObject1 = localObject2;
      j = i;
      if (paramObject.sync_cookie.has())
      {
        localObject1 = localObject2;
        j = i;
        paramFromServiceMsg = paramObject.sync_cookie.get().toByteArray();
      }
      localObject1 = paramFromServiceMsg;
      j = i;
      if (paramObject.bind_uin.has())
      {
        localObject1 = paramFromServiceMsg;
        j = i;
        l = paramObject.bind_uin.get();
      }
      localObject1 = paramFromServiceMsg;
      j = i;
      if (!paramObject.errmsg.has()) {
        break label510;
      }
      localObject1 = paramFromServiceMsg;
      j = i;
      paramObject = paramObject.errmsg.get();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() subUin=").append(str2).append(" lSubUin=").append(l).append(" errMsg=").append(paramObject).append(" cookie=");
            if (paramFromServiceMsg == null)
            {
              localObject1 = "null";
              QLog.d("SUB_ACCOUNT", 2, localObject1);
              j = i;
              localObject1 = paramFromServiceMsg;
              localObject2 = paramObject;
            }
          }
          else
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder().append("handleConfirmSubAccountMsgNumReaded() ssoSeq:");
              if (paramToServiceMsg != null) {
                continue;
              }
              paramToServiceMsg = "null";
              paramFromServiceMsg = paramFromServiceMsg.append(paramToServiceMsg).append(" result=").append(j).append(" syncCookie=");
              if (localObject1 != null) {
                continue;
              }
              paramToServiceMsg = "null";
              QLog.d("SUB_ACCOUNT", 2, paramToServiceMsg + " errms=" + String.valueOf(localObject2));
            }
            boolean bool = false;
            if (j == 0)
            {
              paramToServiceMsg = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
              if (paramToServiceMsg != null) {
                paramToServiceMsg.a(str2, (byte[])localObject1);
              }
              bool = true;
            }
            a(8011, bool, new String[] { str2, str1 });
            return;
          }
          j = paramFromServiceMsg.length;
          localObject1 = Integer.valueOf(j);
          continue;
          localException1 = localException1;
          paramObject = null;
          i = j;
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localObject2 = paramObject;
        localObject1 = paramFromServiceMsg;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.e("SUB_ACCOUNT", 2, "handleConfirmSubAccountMsgNumReaded() decode pb:", localException1);
          localObject2 = paramObject;
          localObject1 = paramFromServiceMsg;
          j = i;
          continue;
          paramToServiceMsg = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
          continue;
          paramToServiceMsg = Integer.toString(localObject1.length);
          continue;
          paramObject = null;
        }
      }
    }
    localObject2 = paramObject;
    localObject1 = paramFromServiceMsg;
    j = i;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    SubAccountBackProtocData localSubAccountBackProtocData = new SubAccountBackProtocData();
    String str1 = paramToServiceMsg.extraData.getString("subAccount");
    String str2 = paramToServiceMsg.getUin();
    localSubAccountBackProtocData.b = str2;
    localSubAccountBackProtocData.jdField_c_of_type_JavaLangString = str1;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd= CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handleGetSubC2CMessageResp_PB subUin=" + str1);
    }
    Object localObject1 = new msg_svc.PbGetMsgResp();
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("printPBuffer", 2, HexUtil.a((byte[])paramObject));
      }
      paramObject = (msg_svc.PbGetMsgResp)((msg_svc.PbGetMsgResp)localObject1).mergeFrom((byte[])paramObject);
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount <---handleGetSubC2CMessageResp_PB : decode pb:", paramObject);
        }
        paramObject = null;
        continue;
        localObject1 = Integer.valueOf(paramToServiceMsg.getRequestSsoSeq());
        continue;
        localObject1 = Integer.valueOf(paramObject.result.get());
        continue;
        localObject1 = Boolean.valueOf(paramObject.sync_cookie.has());
      }
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (!paramObject.result.has()) {
        break label378;
      }
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("subaccount <---handleGetSubC2CMessageResp_PB ssoSeq:");
      if (paramToServiceMsg == null)
      {
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(" msgStruct.cReplyCode: ");
        if (paramObject != null) {
          break label314;
        }
        localObject1 = "null";
        localStringBuilder = localStringBuilder.append(localObject1).append(",hasSyncCookie:");
        if (paramObject != null) {
          break label329;
        }
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1);
      }
    }
    else
    {
      if (paramObject != null) {
        break label344;
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12014");
      paramToServiceMsg.put("fail_step", "getmsgresp_null");
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      a(8003, false, localSubAccountBackProtocData);
      return;
    }
    label314:
    label329:
    label344:
    SubAccountManager localSubAccountManager;
    label378:
    int i;
    if (paramObject.result.get() != 0)
    {
      i = paramObject.result.get();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB rspResult = " + i);
      }
      paramToServiceMsg = new HashMap();
      paramToServiceMsg.put("param_FailCode", "12015");
      paramToServiceMsg.put("fail_step", "result_" + i);
      paramToServiceMsg.put("fail_location", "MessageHandler");
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
      if (i <= 100) {
        break label4940;
      }
      i -= 100;
    }
    label1816:
    label1817:
    label2501:
    label4940:
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB really rspResult = " + i);
        }
        boolean bool1;
        switch (i)
        {
        default: 
          if ((i == 1200) || (i == 1214) || (i == 1215) || (i == 1218) || (i == 1232) || (i == 1233) || (i == 1240) || (i == 1241) || (i == 1242) || (i == 1221))
          {
            localSubAccountBackProtocData.p = 1004;
            localSubAccountBackProtocData.q = i;
            localSubAccountBackProtocData.jdField_a_of_type_JavaLangString = paramObject.errmsg.get();
            localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
            SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
            SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
            localSubAccountBackProtocData.d = true;
            localSubAccountManager.a(str1, null, true);
            bool1 = localSubAccountManager.a(str1, 3);
            localSubAccountManager.a(str1, i, paramObject.errmsg.get());
            localSubAccountManager.e(str1);
            if (bool1)
            {
              i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 7000);
              if (i != 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, 7000, i);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.W, str1 });
              }
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "processSubAccountMessage() hint need to verify,msg num=1, subUin=" + str1);
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(str1, false);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().refreAccountList();
          }
          break;
        }
        for (;;)
        {
          a(8003, false, localSubAccountBackProtocData);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB getMsgResp == null || !getMsgResp.result.has() || getMsgResp.result.get() != 0 ");
          return;
          localSubAccountBackProtocData.p = 1008;
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "sub.uin.all");
          continue;
          localSubAccountBackProtocData.p = 1002;
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, str1);
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1);
          continue;
          localSubAccountBackProtocData.p = 1006;
          continue;
          localSubAccountBackProtocData.p = 1000;
        }
        localSubAccountManager.a(str1, 1);
        localObject1 = paramFromServiceMsg.getUin();
        long l2 = -1L;
        try
        {
          l1 = Long.parseLong(str1);
          if (localObject1 == null)
          {
            a(8003, false, localSubAccountBackProtocData);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB tmpBackUin == null ");
            }
            paramToServiceMsg = new HashMap();
            paramToServiceMsg.put("param_FailCode", "12014");
            paramToServiceMsg.put("fail_step", "backuin_null");
            paramToServiceMsg.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
            return;
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            localException1.printStackTrace();
            long l1 = l2;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB subAccount parselong error ");
              l1 = l2;
              continue;
              try
              {
                l2 = Long.valueOf(paramFromServiceMsg.getUin()).longValue();
                if (l2 == -1L)
                {
                  a(8003, false, localSubAccountBackProtocData);
                  if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin == -1 ");
                  }
                  paramToServiceMsg = new HashMap();
                  paramToServiceMsg.put("param_FailCode", "12014");
                  paramToServiceMsg.put("fail_step", "selfUin_null");
                  paramToServiceMsg.put("fail_location", "MessageHandler");
                  StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", false, 0L, 0L, paramToServiceMsg, "");
                  return;
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB selfUin parselong error ");
                  }
                  l2 = -1L;
                }
                if (paramObject.sync_cookie.has()) {}
                for (localObject1 = paramObject.sync_cookie.get().toByteArray();; localObject1 = null)
                {
                  if (paramObject.sync_flag.has()) {}
                  for (int j = paramObject.sync_flag.get();; j = 2)
                  {
                    byte b;
                    int k;
                    if (j < 2)
                    {
                      b = (byte)1;
                      k = 0;
                    }
                    for (;;)
                    {
                      if (paramObject.bind_uin.has()) {}
                      for (long l3 = paramObject.bind_uin.get();; l3 = 0L)
                      {
                        if (localSubAccountManager != null) {}
                        for (List localList1 = localSubAccountManager.a(Long.toString(l3));; localList1 = null)
                        {
                          ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("hadGetMsgListUin");
                          if (localArrayList == null) {
                            localArrayList = new ArrayList();
                          }
                          for (;;)
                          {
                            List localList2 = paramObject.uin_pair_msgs.get();
                            int m = 0;
                            if (m < localList2.size())
                            {
                              paramFromServiceMsg = (msg_comm.UinPairMsg)localList2.get(m);
                              long l6 = paramFromServiceMsg.peer_uin.get();
                              long l4 = paramFromServiceMsg.last_read_time.get();
                              paramObject = paramFromServiceMsg.msg.get();
                              int n = paramFromServiceMsg.unread_msg_num.get();
                              if (QLog.isColorLevel()) {
                                QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUi cc n:" + l6);
                              }
                              if ((paramObject == null) || (paramObject.size() == 0) || (n == 0))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB msgList == null || msgList.size() == 0 msg is null " + l6);
                                }
                                if (localList1 != null)
                                {
                                  paramFromServiceMsg = localList1.iterator();
                                  while (paramFromServiceMsg.hasNext())
                                  {
                                    paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                    if (paramObject != null)
                                    {
                                      paramObject = paramObject.frienduin;
                                      if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l6)))) {
                                        localArrayList.add(String.valueOf(l6));
                                      }
                                    }
                                  }
                                }
                              }
                              DecodeProtoPkgContext localDecodeProtoPkgContext;
                              do
                              {
                                m += 1;
                                break;
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + ",msgList size:" + paramObject.size());
                                }
                                localDecodeProtoPkgContext = new DecodeProtoPkgContext(l1, l6, false, false, false, true);
                              } while ((paramObject == null) || (paramObject.size() <= 0));
                              Collections.sort(paramObject, new htk(this));
                              Iterator localIterator1;
                              if ((paramFromServiceMsg.msg_completed.has()) && (paramFromServiceMsg.msg_completed.get() != 0))
                              {
                                bool1 = true;
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB pkgPeerUin:" + l6 + "msgList size: " + paramObject.size() + ",uMsgCompleted:" + bool1 + ",lastReadTime:" + (l4 & 0xFFFFFFFF));
                                }
                                localIterator1 = paramObject.iterator();
                                break label1940;
                              }
                              Object localObject2;
                              int i1;
                              for (;;)
                              {
                                if (!localIterator1.hasNext()) {
                                  break label4392;
                                }
                                localObject2 = (msg_comm.Msg)localIterator1.next();
                                if (localObject2 != null)
                                {
                                  msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                                  i = localMsgHead.msg_type.get();
                                  paramObject = null;
                                  i1 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get()).c2c_cmd.get();
                                  if ((193 == i) || (734 == i)) {
                                    if (l1 == l6) {
                                      paramFromServiceMsg = paramObject;
                                    }
                                  }
                                  for (;;)
                                  {
                                    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() != 0)) {
                                      break label2501;
                                    }
                                    if (localList1 == null) {
                                      break label1817;
                                    }
                                    paramFromServiceMsg = localList1.iterator();
                                    if (!paramFromServiceMsg.hasNext()) {
                                      break label1817;
                                    }
                                    paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                    if (paramObject == null) {
                                      break label1816;
                                    }
                                    paramObject = paramObject.frienduin;
                                    if ((paramObject == null) || (!paramObject.equalsIgnoreCase(String.valueOf(l6)))) {
                                      break label1816;
                                    }
                                    localArrayList.add(String.valueOf(l6));
                                    break label1817;
                                    bool1 = false;
                                    break;
                                    paramFromServiceMsg = new ArrayList();
                                    paramObject = MessageRecordFactory.a(193);
                                    paramObject.selfuin = String.valueOf(l1);
                                    paramObject.frienduin = String.valueOf(l6);
                                    paramObject.senderuin = String.valueOf(l6);
                                    paramObject.shmsgseq = localMsgHead.msg_seq.get();
                                    paramObject.msgUid = localMsgHead.msg_uid.get();
                                    paramObject.time = localMsgHead.msg_time.get();
                                    paramObject.istroop = 0;
                                    paramObject.msg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368383);
                                    paramObject.msgtype = 193;
                                    paramFromServiceMsg.add(paramObject);
                                    continue;
                                    if ((MessageUtils.c(i)) && (localMsgHead.c2c_cmd.has()) && ((i1 == 169) || (i1 == 241) || (i1 == 242) || (i1 == 243) || (i1 == 129) || (i1 == 131) || (i1 == 133)))
                                    {
                                      if ((i1 == 129) || (i1 == 131) || (i1 == 133) || (i1 == 135) || (i1 == 243)) {
                                        break label1817;
                                      }
                                      for (;;)
                                      {
                                        try
                                        {
                                          paramFromServiceMsg = ((im_msg_body.NotOnlineFile)((im_msg_body.RichText)((im_msg_body.MsgBody)((msg_comm.Msg)localObject2).msg_body.get()).rich_text.get()).not_online_file.get()).bytes_file_name.get().toStringUtf8();
                                          paramObject = paramFromServiceMsg;
                                        }
                                        catch (Exception paramObject)
                                        {
                                          try
                                          {
                                            if (QLog.isColorLevel())
                                            {
                                              QLog.d("SUB_ACCOUNT", 2, "fileName = " + paramFromServiceMsg);
                                              paramObject = paramFromServiceMsg;
                                            }
                                            paramFromServiceMsg = paramObject;
                                            if (TextUtils.isEmpty(paramObject)) {
                                              paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368069);
                                            }
                                            paramObject = MessageRecordFactory.a(-2005);
                                            paramObject.selfuin = String.valueOf(l1);
                                            paramObject.frienduin = String.valueOf(l6);
                                            paramObject.senderuin = String.valueOf(l6);
                                            paramObject.shmsgseq = localMsgHead.msg_seq.get();
                                            paramObject.msgUid = localMsgHead.msg_uid.get();
                                            paramObject.time = localMsgHead.msg_time.get();
                                            paramObject.istroop = 0;
                                            paramObject.msg = paramFromServiceMsg;
                                            paramObject.msgtype = -2005;
                                            paramFromServiceMsg = new ArrayList();
                                            paramFromServiceMsg.add(paramObject);
                                          }
                                          catch (Exception paramObject)
                                          {
                                            for (;;)
                                            {
                                              StringBuffer localStringBuffer;
                                              MessageRecord localMessageRecord;
                                              long l5;
                                              Iterator localIterator2;
                                              Object localObject3;
                                              boolean bool2;
                                              continue;
                                              k = 0;
                                              continue;
                                              paramFromServiceMsg = null;
                                              continue;
                                              continue;
                                              paramFromServiceMsg = paramObject;
                                              continue;
                                              i = 0;
                                            }
                                          }
                                          paramObject = paramObject;
                                          paramFromServiceMsg = null;
                                        }
                                        paramObject.printStackTrace();
                                        paramObject = paramFromServiceMsg;
                                      }
                                    }
                                    try
                                    {
                                      paramFromServiceMsg = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext);
                                    }
                                    catch (Exception localException2)
                                    {
                                      paramFromServiceMsg = paramObject;
                                    }
                                    if (QLog.isColorLevel())
                                    {
                                      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
                                      paramFromServiceMsg = paramObject;
                                    }
                                  }
                                  localStringBuffer = new StringBuffer();
                                  localMessageRecord = (MessageRecord)paramFromServiceMsg.get(0);
                                  l5 = localMessageRecord.time;
                                  localIterator2 = paramFromServiceMsg.iterator();
                                  bool1 = false;
                                  label2540:
                                  do
                                  {
                                    if (!localIterator2.hasNext()) {
                                      break;
                                    }
                                    localObject3 = (MessageRecord)localIterator2.next();
                                  } while (localObject3 == null);
                                  paramObject = ((MessageRecord)localObject3).msg;
                                  if (paramObject != null) {}
                                  try
                                  {
                                    if (QLog.isColorLevel()) {
                                      QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  basemsg  = ");
                                    }
                                    if (((MessageRecord)localObject3).frienduin == null) {
                                      break label2540;
                                    }
                                    if (String.valueOf(AppConstants.ae).equalsIgnoreCase(((MessageRecord)localObject3).frienduin))
                                    {
                                      paramFromServiceMsg = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject, ((MessageRecord)localObject3).msgtype, ((MessageRecord)localObject3).senderuin);
                                      if (paramFromServiceMsg == null)
                                      {
                                        i = 1;
                                        if ((localStringBuffer != null) && (localStringBuffer.length() != 0)) {
                                          break label3571;
                                        }
                                        if (!QLog.isColorLevel()) {
                                          continue;
                                        }
                                        QLog.d("SUB_ACCOUNT", 2, "subaccount <---handleGetSubC2CMessageResp_PB show == null || show.length() == 0; msg is not decode success.");
                                      }
                                    }
                                  }
                                  catch (Exception paramFromServiceMsg)
                                  {
                                    for (;;)
                                    {
                                      paramFromServiceMsg.printStackTrace();
                                      continue;
                                      localStringBuffer.append(paramFromServiceMsg);
                                      i = 1;
                                    }
                                    switch (((MessageRecord)localObject3).msgtype)
                                    {
                                    }
                                  }
                                }
                              }
                              for (;;)
                              {
                                try
                                {
                                  if (!ActionMsgUtil.a(((MessageRecord)localObject3).msgtype)) {
                                    continue;
                                  }
                                  localObject3 = ActionMsgUtil.a(((MessageRecord)localObject3).msg);
                                  paramFromServiceMsg = paramObject;
                                  if (localObject3 != null)
                                  {
                                    if ((((MsgBody)localObject3).actMsgContentValue == null) || (((MsgBody)localObject3).actMsgContentValue.length() <= 0)) {
                                      continue;
                                    }
                                    paramFromServiceMsg = ((MsgBody)localObject3).actMsgContentValue;
                                  }
                                }
                                catch (Exception localException3)
                                {
                                  paramObject = null;
                                  localException3.printStackTrace();
                                  paramFromServiceMsg = paramObject;
                                  if (!QLog.isColorLevel()) {
                                    continue;
                                  }
                                  QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + localException3.getMessage());
                                  paramFromServiceMsg = paramObject;
                                  continue;
                                }
                                paramObject = paramFromServiceMsg;
                                if (paramFromServiceMsg == null) {
                                  paramObject = "";
                                }
                                localStringBuffer.append(paramObject);
                                break;
                                if (!(localObject3 instanceof MessageForStructing)) {
                                  break label4893;
                                }
                                paramFromServiceMsg = (MessageForStructing)localObject3;
                                if (paramFromServiceMsg.structingMsg == null) {
                                  break label4893;
                                }
                                paramFromServiceMsg = paramFromServiceMsg.structingMsg.mMsgBrief;
                                if (!TextUtils.isEmpty(paramFromServiceMsg)) {
                                  break label4890;
                                }
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368785);
                                continue;
                                paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368066);
                                continue;
                                localObject3 = ((MessageRecord)localObject3).msg;
                                paramFromServiceMsg = null;
                                paramObject = paramFromServiceMsg;
                                try
                                {
                                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                                  {
                                    localObject3 = ((String)localObject3).split("/");
                                    paramObject = paramFromServiceMsg;
                                    if (localObject3 != null)
                                    {
                                      paramObject = paramFromServiceMsg;
                                      if (localObject3.length > 0)
                                      {
                                        localObject3 = localObject3[(localObject3.length - 1)].split("\\|");
                                        paramObject = paramFromServiceMsg;
                                        if (localObject3 != null)
                                        {
                                          paramObject = paramFromServiceMsg;
                                          if (localObject3.length > 0) {
                                            paramObject = localObject3[0];
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                                catch (Exception paramObject)
                                {
                                  paramObject.printStackTrace();
                                  paramObject = paramFromServiceMsg;
                                  continue;
                                  paramFromServiceMsg = paramObject;
                                  if (paramObject.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368069))) {
                                    continue;
                                  }
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368069) + paramObject;
                                  continue;
                                }
                                if (TextUtils.isEmpty(paramObject))
                                {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368069);
                                }
                                else
                                {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368067);
                                  continue;
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131368619);
                                  continue;
                                  paramFromServiceMsg = paramObject;
                                  if (!(localObject3 instanceof MessageForPubAccount)) {
                                    continue;
                                  }
                                  if ("2010741172".equals(localMessageRecord.senderuin)) {
                                    bool1 = true;
                                  }
                                  try
                                  {
                                    paramObject = ((MessageForPubAccount)localObject3).mPAMessage;
                                    if (paramObject == null)
                                    {
                                      paramFromServiceMsg = null;
                                      continue;
                                    }
                                    paramFromServiceMsg = ((PAMessage.Item)paramObject.items.get(0)).title;
                                    if ((((PAMessage.Item)paramObject.items.get(0)).cover == null) && (((PAMessage.Item)paramObject.items.get(0)).digestList != null))
                                    {
                                      paramFromServiceMsg = paramFromServiceMsg + "：" + (String)((PAMessage.Item)paramObject.items.get(0)).digestList.get(0);
                                      continue;
                                    }
                                    continue;
                                  }
                                  catch (Exception paramObject)
                                  {
                                    paramFromServiceMsg = null;
                                    paramObject.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                      QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + paramObject.getMessage());
                                    }
                                  }
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppShareIDUtil.a(((MsgBody)localObject3).shareAppID));
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368376) + paramFromServiceMsg.messagetail + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131368377);
                                  continue;
                                  paramFromServiceMsg = paramObject;
                                  if (!ActionMsgUtil.b(((MessageRecord)localObject3).msgtype))
                                  {
                                    paramFromServiceMsg = paramObject;
                                    if (((MessageRecord)localObject3).msg != null)
                                    {
                                      paramFromServiceMsg = paramObject;
                                      if (((MessageRecord)localObject3).msg.indexOf("http://maps.google.com/maps?q=") != -1)
                                      {
                                        localObject3 = MessageUtils.a(((MessageRecord)localObject3).msg);
                                        paramObject = "";
                                        paramFromServiceMsg = paramObject;
                                        if (localObject3 != null)
                                        {
                                          paramFromServiceMsg = paramObject;
                                          if (localObject3[2] != null) {
                                            paramFromServiceMsg = localObject3[2];
                                          }
                                        }
                                        paramFromServiceMsg = "[" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366488) + "] " + paramFromServiceMsg;
                                      }
                                    }
                                  }
                                }
                              }
                              label3571:
                              if ((localList1 != null) && (i == 0))
                              {
                                paramFromServiceMsg = localList1.iterator();
                                while (paramFromServiceMsg.hasNext())
                                {
                                  paramObject = (SubAccountMessage)paramFromServiceMsg.next();
                                  if (paramObject != null)
                                  {
                                    paramObject = paramObject.frienduin;
                                    if ((paramObject != null) && (paramObject.equalsIgnoreCase(String.valueOf(l6)))) {
                                      localArrayList.add(String.valueOf(l6));
                                    }
                                  }
                                }
                              }
                              paramFromServiceMsg = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
                              if ((paramFromServiceMsg != null) && (paramFromServiceMsg.from_nick.has()))
                              {
                                paramFromServiceMsg = paramFromServiceMsg.from_nick.get();
                                if (i != 0) {
                                  paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getString(2131367460);
                                }
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "sub.account.msg isQQMail=" + bool1);
                                }
                                localSubAccountBackProtocData.jdField_c_of_type_Boolean = true;
                                localObject2 = new SubAccountMessage();
                                if (i != 0)
                                {
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(AppConstants.ae);
                                  if (!bool1) {
                                    break label4407;
                                  }
                                  bool2 = true;
                                  ((SubAccountMessage)localObject2).isread = bool2;
                                  ((SubAccountMessage)localObject2).msg = localStringBuffer.toString();
                                  ((SubAccountMessage)localObject2).extInt = localMessageRecord.extInt;
                                  ((SubAccountMessage)localObject2).extLong = localMessageRecord.extLong;
                                  ((SubAccountMessage)localObject2).extraflag = localMessageRecord.extraflag;
                                  ((SubAccountMessage)localObject2).extStr = localMessageRecord.extStr;
                                  ((SubAccountMessage)localObject2).istroop = localMessageRecord.istroop;
                                  ((SubAccountMessage)localObject2).isValid = localMessageRecord.isValid;
                                  ((SubAccountMessage)localObject2).longMsgCount = localMessageRecord.longMsgCount;
                                  ((SubAccountMessage)localObject2).longMsgId = localMessageRecord.longMsgId;
                                  ((SubAccountMessage)localObject2).longMsgIndex = localMessageRecord.longMsgIndex;
                                  ((SubAccountMessage)localObject2).msgUid = localMessageRecord.msgUid;
                                  ((SubAccountMessage)localObject2).shmsgseq = localMessageRecord.shmsgseq;
                                  ((SubAccountMessage)localObject2).uniseq = localMessageRecord.uniseq;
                                  ((SubAccountMessage)localObject2).msgseq = localMessageRecord.msgseq;
                                  if (!bool1) {
                                    break label4413;
                                  }
                                  i = 0;
                                  label3927:
                                  ((SubAccountMessage)localObject2).unreadNum = i;
                                  ((SubAccountMessage)localObject2).msgtype = -1000;
                                  ((SubAccountMessage)localObject2).selfuin = String.valueOf(l2);
                                  if (paramFromServiceMsg != null)
                                  {
                                    paramObject = paramFromServiceMsg;
                                    if (paramFromServiceMsg.length() != 0) {}
                                  }
                                  else
                                  {
                                    paramObject = ((SubAccountMessage)localObject2).frienduin;
                                  }
                                  ((SubAccountMessage)localObject2).sendername = paramObject;
                                  ((SubAccountMessage)localObject2).senderuin = String.valueOf(l6);
                                  ((SubAccountMessage)localObject2).subUin = Long.toString(l3);
                                  if (l5 != 0L) {
                                    break label4420;
                                  }
                                }
                                for (l4 = System.currentTimeMillis() / 1000L;; l4 = l5)
                                {
                                  ((SubAccountMessage)localObject2).time = l4;
                                  ((SubAccountMessage)localObject2).needNotify = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause;
                                  ((SubAccountMessage)localObject2).mTimeString = TimeFormatterUtils.a(1000L * l5, true, SubAccountControll.d);
                                  ((SubAccountMessage)localObject2).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject2).msg, 3, 16);
                                  if (localSubAccountManager != null) {
                                    localSubAccountManager.a((SubAccountMessage)localObject2);
                                  }
                                  if (QLog.isColorLevel())
                                  {
                                    QLog.d("SUB_ACCOUNT", 2, "subaccount set msg read false hasData = false  unreadNum=" + ((SubAccountMessage)localObject2).unreadNum);
                                    if (!TextUtils.isEmpty(((SubAccountMessage)localObject2).msg)) {
                                      QLog.d("SUB_ACCOUNT", 2, "msg=" + ((SubAccountMessage)localObject2).msg.charAt(0));
                                    }
                                  }
                                  SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, 6);
                                  localSubAccountBackProtocData.d = true;
                                  paramFromServiceMsg = MessageRecordFactory.a(localMessageRecord.msgtype);
                                  MessageRecord.copyMessageRecordBaseField(paramFromServiceMsg, localMessageRecord);
                                  paramFromServiceMsg.istroop = 7000;
                                  paramFromServiceMsg.frienduin = str1;
                                  i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop);
                                  i = 0;
                                  if (localSubAccountManager != null) {
                                    i = localSubAccountManager.d(str1);
                                  }
                                  int i2 = i - i1;
                                  if (i2 != 0) {
                                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg.frienduin, paramFromServiceMsg.istroop, i2);
                                  }
                                  if (QLog.isColorLevel()) {
                                    QLog.d("SUB_ACCOUNT", 2, "sub.account.msg conversion subUin=" + str1 + " target=" + i + " old=" + i1 + " increase=" + i2);
                                  }
                                  paramObject = new ArrayList();
                                  paramObject.add(paramFromServiceMsg);
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramObject, str2, false, false, true);
                                  if (bool1) {
                                    break label1817;
                                  }
                                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramObject.size(), true, true);
                                  break label1817;
                                  break;
                                  ((SubAccountMessage)localObject2).frienduin = String.valueOf(l6);
                                  break label3764;
                                  bool2 = false;
                                  break label3772;
                                  i = n;
                                  break label3927;
                                }
                              }
                            }
                            else
                            {
                              if ((localList1 != null) && (localList1.size() > 0) && (k != 0))
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.d("SUB_ACCOUNT", 2, "handleGetSubC2CMessageResp_PB dbSubMsgList......");
                                }
                                i = 0;
                                if (i < localList1.size())
                                {
                                  paramFromServiceMsg = (SubAccountMessage)localList1.get(i);
                                  if ((paramFromServiceMsg == null) || (paramFromServiceMsg.frienduin == null)) {}
                                  for (;;)
                                  {
                                    i += 1;
                                    break;
                                    if (!paramFromServiceMsg.frienduin.equals(String.valueOf(AppConstants.ae)))
                                    {
                                      paramObject = localArrayList.iterator();
                                      do
                                      {
                                        if (!paramObject.hasNext()) {
                                          break;
                                        }
                                        str2 = (String)paramObject.next();
                                      } while ((str2 == null) || (!paramFromServiceMsg.frienduin.equalsIgnoreCase(str2)));
                                      k = 1;
                                      if ((k == 0) && (!paramFromServiceMsg.frienduin.equalsIgnoreCase("2005060620050606")) && (localSubAccountManager != null))
                                      {
                                        k = localSubAccountManager.a(String.valueOf(l3), paramFromServiceMsg.frienduin);
                                        if (k != 0)
                                        {
                                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str1, 7000, k);
                                          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.W, str1 });
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              if (QLog.isColorLevel())
                              {
                                if (localObject1 == null) {
                                  break label4816;
                                }
                                QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = ");
                              }
                              for (;;)
                              {
                                if (localSubAccountManager != null) {
                                  localSubAccountManager.a(str1, (byte[])localObject1);
                                }
                                paramFromServiceMsg = new HashMap();
                                paramFromServiceMsg.put("param_FailCode", "12016");
                                paramFromServiceMsg.put("fail_step", "success");
                                paramFromServiceMsg.put("fail_location", "MessageHandler");
                                StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBGetMsg", true, 0L, 0L, paramFromServiceMsg, "");
                                if (b <= 0) {
                                  break label4843;
                                }
                                if (l3 <= 0L) {
                                  break;
                                }
                                paramToServiceMsg = paramToServiceMsg.extraData.getString("subaccount_a2");
                                if (paramToServiceMsg == null) {
                                  break label4843;
                                }
                                a(b, j, String.valueOf(l3), paramToServiceMsg, localArrayList);
                                localSubAccountBackProtocData.jdField_a_of_type_Boolean = false;
                                a(8003, true, localSubAccountBackProtocData);
                                return;
                                label4816:
                                QLog.d("SUB_ACCOUNT", 2, "subaccount handleGetSubC2CMessageResp_PB  cookie = null");
                              }
                              if (QLog.isColorLevel()) {
                                QLog.e("Q.msg.C2CMessageProcessor", 2, "subaccount handleGetSubC2CMessageResp_PB error happen, binduin <= 0 from server");
                              }
                              label4843:
                              localSubAccountBackProtocData.p = 0;
                              a(8003, true, localSubAccountBackProtocData);
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("SUB_ACCOUNT", 2, "subaccount <PbGetMsg><R><---handleGetSubC2CMessageResp_PB end");
                              return;
                            }
                          }
                        }
                      }
                      k = 1;
                      b = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(byte paramByte, int paramInt, String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() start, subUin=" + paramString1);
    }
    ToServiceMsg localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("MessageSvc.PbBindUinGetMsg");
    localToServiceMsg.extraData.putByte("cChannel", paramByte);
    localToServiceMsg.extraData.putInt("cSyncFlag", paramInt);
    localToServiceMsg.extraData.putBoolean("isSubAccount", true);
    localToServiceMsg.extraData.putString("subAccount", paramString1);
    localToServiceMsg.extraData.putString("subaccount_a2", paramString2);
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      localToServiceMsg.extraData.putStringArrayList("hadGetMsgListUin", paramArrayList);
    }
    paramArrayList = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
    if (paramArrayList != null) {}
    for (paramArrayList = paramArrayList.a(paramString1);; paramArrayList = null)
    {
      msg_svc.PbBindUinGetMsgReq localPbBindUinGetMsgReq = new msg_svc.PbBindUinGetMsgReq();
      if (paramString1 != null) {}
      try
      {
        localPbBindUinGetMsgReq.bind_uin.set(Long.parseLong(paramString1));
        if (paramString2 == null) {}
      }
      catch (Exception paramString1)
      {
        try
        {
          do
          {
            localPbBindUinGetMsgReq.bind_uin_sig.set(ByteStringMicro.copyFrom(PkgTools.a(paramString2)));
            if (paramArrayList == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie=" + paramArrayList.length);
            }
            localPbBindUinGetMsgReq.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
            localPbBindUinGetMsgReq.sync_flag.set(paramInt);
            localToServiceMsg.putWupBuffer(localPbBindUinGetMsgReq.toByteArray());
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
            return;
            paramString1 = paramString1;
            paramString1.printStackTrace();
          } while (!QLog.isColorLevel());
          QLog.e("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() subAccount is null or not a long");
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "getSubAccoundMsg_PB() cookie = null");
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountError end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.p = 1001;
    a(8003, false, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountQZoneMsg() subAccount=" + paramString);
    }
    GetSubAccountUnreadIntent localGetSubAccountUnreadIntent = new GetSubAccountUnreadIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), QzoneSubAccountUnreadServlet.class);
    localGetSubAccountUnreadIntent.setAction("Qzone_Get_SubAccount_Count");
    try
    {
      long l = Long.parseLong(paramString);
      localGetSubAccountUnreadIntent.putExtra("qzone_get_sub_account_unread_uin", l);
      localGetSubAccountUnreadIntent.a = new htl(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localGetSubAccountUnreadIntent);
      return;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() subAccount=" + paramString1);
    }
    byte[] arrayOfByte;
    SubAccountManager localSubAccountManager;
    ToServiceMsg localToServiceMsg;
    try
    {
      l = Long.parseLong(paramString1);
      if (l <= 10000L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() return, lSubUin=" + l);
        }
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      arrayOfByte = null;
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if (localSubAccountManager != null) {
        arrayOfByte = localSubAccountManager.a(paramString1);
      }
      localToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("PbMessageSvc.PbBindUinMsgReadedConfirm");
      localToServiceMsg.extraData.putBoolean("isSubAccount", true);
      localToServiceMsg.extraData.putString("subAccount", paramString1);
      localToServiceMsg.extraData.putString("nextAction", paramString2);
      paramString2 = new msg_svc.PbBindUinMsgReadedConfirmReq();
      paramString2.bind_uin.set(l);
      if (arrayOfByte == null) {
        break label266;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  syncCookie=" + Integer.toString(arrayOfByte.length));
    }
    paramString2.sync_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
    for (;;)
    {
      localToServiceMsg.putWupBuffer(paramString2.toByteArray());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(localToServiceMsg);
      if (localSubAccountManager == null) {
        break;
      }
      localSubAccountManager.g(paramString1);
      return;
      label266:
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "confirmSubAccountMsgNumReaded() getSubAccoundMsg_PB  cookie = null");
      }
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "subaccount cmd =  CMD_MESSAGESERVICE_GETSUBACCOUNTMSG_PB handlerGetSubAccountTimeout end");
    }
    paramFromServiceMsg = new SubAccountBackProtocData();
    String str = paramToServiceMsg.extraData.getString("subAccount");
    paramFromServiceMsg.b = paramToServiceMsg.getUin();
    paramFromServiceMsg.jdField_c_of_type_JavaLangString = str;
    paramFromServiceMsg.p = 1007;
    a(8003, false, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SubAccountMessageProcessor
 * JD-Core Version:    0.7.0.1
 */