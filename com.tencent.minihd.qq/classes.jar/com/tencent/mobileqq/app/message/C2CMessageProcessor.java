package com.tencent.mobileqq.app.message;

import MessageSvcPack.SvcResponseMsgReadedReport;
import MessageSvcPack.UinPairReadInfo;
import OnlinePushPack.DelMsgInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.widget.WidgetConstants;
import com.tencent.mobileqq.activity.widget.WidgetController;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.LifeOnlineAccountInfoManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import hso;
import hsp;
import hsq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.PbGetOneDayRoamMsgResp;
import msf.msgsvc.msg_svc.PbGetRoamMsgResp;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class C2CMessageProcessor
  extends BaseMessageProcessor
{
  public static int b = 0;
  public static final String b = "Q.msg.C2CMessageProcessor";
  public static int c = 0;
  public static int d = 0;
  public static int e = 0;
  public static int f = 1;
  public static int g = 5;
  public static int h = 0;
  public static int i = 0;
  private static final int j = 33;
  HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  HashSet b;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 3;
  }
  
  public C2CMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
  }
  
  private Pair a(String paramString, msg_comm.UinPairMsg paramUinPairMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    long l7 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = paramUinPairMsg.msg.get();
    if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
      return new Pair(paramString, Integer.valueOf(0));
    }
    ArrayList localArrayList2 = new ArrayList();
    a((List)localObject1, localArrayList2);
    StringBuilder localStringBuilder = new StringBuilder();
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    DecodeProtoPkgContext localDecodeProtoPkgContext = new DecodeProtoPkgContext(l7, Long.parseLong(paramString), true, paramBoolean2, paramBoolean3, false);
    localDecodeProtoPkgContext.jdField_e_of_type_Boolean = true;
    localDecodeProtoPkgContext.a(1000, localHashMap);
    localDecodeProtoPkgContext.a(1001, localHashSet);
    long l1 = -1L;
    int k = 0;
    localObject1 = paramString;
    long l2 = -1L;
    int n = 0;
    if (n < localArrayList2.size()) {}
    try
    {
      localObject2 = (msg_comm.Msg)localArrayList2.get(n);
      localObject3 = (msg_comm.MsgHead)((msg_comm.Msg)localObject2).msg_head.get();
      im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)((msg_comm.Msg)localObject2).msg_body.get();
      if (!((msg_comm.Msg)localObject2).msg_head.has())
      {
        if (!QLog.isColorLevel()) {
          break label1751;
        }
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---decodeC2CMessagePackage: msgList[" + n + "] : msg doesn't has msgHead.");
        break label1751;
      }
      l3 = ((msg_comm.MsgHead)localObject3).to_uin.get();
      l8 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l4 = ((msg_comm.MsgHead)localObject3).from_uin.get();
      l5 = ((msg_comm.MsgHead)localObject3).msg_time.get();
      if (l5 <= paramLong) {
        break label1742;
      }
      paramBoolean3 = false;
      bool = false;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        long l8;
        long l4;
        long l5;
        long l9;
        int m;
        continue;
        continue;
        paramBoolean3 = true;
        boolean bool = true;
      }
      l3 = l2;
      l2 = l1;
      l1 = l3;
    }
    l9 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l4, l3, paramUinPairMsg.peer_uin.get());
    localObject1 = String.valueOf(l9);
    long l3 = l2;
    l4 = l1;
    m = k;
    for (;;)
    {
      try
      {
        l6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), 0);
        if ((l5 <= l6) && (bool))
        {
          l3 = l2;
          l4 = l1;
          m = k;
          if (!QLog.isColorLevel()) {
            break label1784;
          }
          l3 = l2;
          l4 = l1;
          m = k;
          localStringBuilder.setLength(0);
          l3 = l2;
          l4 = l1;
          m = k;
          localStringBuilder.append("<---decodeC2CMessagePackage : msgList[").append(n).append("] : filter msg by del time delTime =").append(l6).append(", msgTime = ").append(l5);
          l3 = l2;
          l4 = l1;
          m = k;
          QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
          break label1784;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = bool;
        l3 = l2;
        l4 = l1;
        m = k;
        localDecodeProtoPkgContext.jdField_e_of_type_Long = l9;
        l3 = l2;
        l4 = l1;
        m = k;
        localDecodeProtoPkgContext.h = paramBoolean3;
        l3 = l2;
        l4 = l1;
        m = k;
        localObject2 = a((msg_comm.Msg)localObject2, localDecodeProtoPkgContext);
        if (localObject2 == null) {
          break label1739;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        if (((ArrayList)localObject2).size() <= 0) {
          break label1739;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        if (((MessageRecord)((ArrayList)localObject2).get(0)).istroop != 1008) {
          break label1739;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        localObject2 = ((LifeOnlineAccountInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82)).a((ArrayList)localObject2);
        l3 = l2;
        l4 = l1;
        m = k;
        localObject2 = ((ArrayList)localObject2).iterator();
        l3 = l2;
        l4 = l1;
        m = k;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        localObject3 = (MessageRecord)((Iterator)localObject2).next();
        l3 = l2;
        l4 = l1;
        m = k;
        l5 = ((MessageRecord)localObject3).vipBubbleID;
        if (l5 == -1L) {
          break label1051;
        }
        l3 = l2;
        l4 = l1;
        m = k;
        if (!MsgUtils.a(((MessageRecord)localObject3).issend)) {
          break label1040;
        }
        l6 = l1;
        l3 = l5;
        l4 = l6;
        m = k;
        int i1 = ((MessageRecord)localObject3).istroop;
        l3 = l5;
        l4 = l6;
        m = i1;
        paramBoolean3 = a((MessageRecord)localObject3, true);
        if (!paramBoolean3)
        {
          l3 = l5;
          l4 = l6;
          m = i1;
          localArrayList1.add(localObject3);
        }
        l2 = l5;
        l1 = l6;
        k = i1;
        l3 = l5;
        l4 = l6;
        m = i1;
        if (((MessageRecord)localObject3).msgtype != -2002) {
          continue;
        }
        if (!paramBoolean3)
        {
          l3 = l5;
          l4 = l6;
          m = i1;
          if (StreamDataManager.a(((MessageRecord)localObject3).msgUid, ((MessageRecord)localObject3).shmsgseq) != null)
          {
            l3 = l5;
            l4 = l6;
            m = i1;
            PttInfoCollector.a(true);
          }
        }
        l2 = l5;
        l1 = l6;
        k = i1;
        if (!paramBoolean3) {
          continue;
        }
        l3 = l5;
        l4 = l6;
        m = i1;
        PttInfoCollector.a(false);
        l2 = l5;
        l1 = l6;
        k = i1;
        continue;
        if (!QLog.isColorLevel()) {
          break label1025;
        }
      }
      catch (Exception localException1)
      {
        k = m;
        l1 = l4;
        l2 = l3;
      }
      QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", localException1);
      label1025:
      l3 = l1;
      l1 = l2;
      l2 = l3;
      break label1763;
      label1040:
      long l6 = l5;
      l5 = l2;
      continue;
      label1051:
      l3 = l2;
      l4 = l1;
      m = k;
      if (((MessageRecord)localObject3).msgtype == -2002)
      {
        l3 = l2;
        l4 = l1;
        m = k;
        if (MsgUtils.a(((MessageRecord)localObject3).issend))
        {
          if (l2 != -1L)
          {
            l3 = l2;
            l4 = l1;
            m = k;
            ((MessageRecord)localObject3).vipBubbleID = l2;
            l5 = l2;
            l6 = l1;
          }
          else
          {
            l3 = l2;
            l4 = l1;
            m = k;
            ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
            l5 = l2;
            l6 = l1;
          }
        }
        else if (l1 != -1L)
        {
          l3 = l2;
          l4 = l1;
          m = k;
          ((MessageRecord)localObject3).vipBubbleID = l1;
          l5 = l2;
          l6 = l1;
        }
        else
        {
          l3 = l2;
          l4 = l1;
          m = k;
          ((MessageRecord)localObject3).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(l9), String.valueOf(l8));
          l5 = l2;
          l6 = l1;
        }
      }
      else
      {
        l3 = l2;
        l4 = l1;
        m = k;
        ((MessageRecord)localObject3).vipBubbleID = 0L;
        l5 = l2;
        l6 = l1;
      }
    }
    l3 = l1;
    l1 = l2;
    l2 = l3;
    break label1763;
    if (localObject1 != null)
    {
      paramUinPairMsg = (msg_comm.UinPairMsg)localObject1;
      if (!((String)localObject1).equals("0")) {}
    }
    else
    {
      paramUinPairMsg = paramString;
    }
    if (!localHashMap.isEmpty())
    {
      paramString = localHashSet.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (Long)paramString.next();
        localHashMap.remove(localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("svenxu", 2, "Discard video request because canceled: fromUin = " + localObject1);
        }
      }
      paramString = localHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject1 = (msg_comm.Msg)localHashMap.get((Long)paramString.next());
        if ((((msg_comm.Msg)localObject1).msg_body.has()) && (((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.has())) {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l7, ((im_msg_body.MsgBody)((msg_comm.Msg)localObject1).msg_body.get()).msg_content.get().toByteArray(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject1).msg_head.get()).msg_time.get());
        }
      }
    }
    if (localArrayList1.size() > 0)
    {
      if (!paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramUinPairMsg), 0, localArrayList1, paramBoolean1);
      paramBoolean3 = a(localArrayList1);
      m = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if ((!paramBoolean3) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
        break label1728;
      }
    }
    label1728:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString.a(localArrayList1, str, paramBoolean1);
      a(localArrayList1);
      a("handleGetBuddyMessageResp", true, m, paramBoolean3, paramBoolean2);
      a(localArrayList1, paramBoolean2);
      if (k == 1008)
      {
        paramString = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
        if (paramString != null) {
          paramString.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      return new Pair(paramUinPairMsg, Integer.valueOf(k));
    }
    for (;;)
    {
      label1739:
      label1742:
      label1751:
      label1763:
      n += 1;
      l3 = l2;
      l2 = l1;
      l1 = l3;
      break;
      label1784:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
  
  private Pair a(List paramList1, List paramList2, long paramLong1, long paramLong2, long paramLong3)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86)).a(String.valueOf(paramLong1), paramLong2 - 30L, 30L + paramLong3);
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramList1 = paramList1.iterator();
      Object localObject;
      int k;
      while (paramList1.hasNext())
      {
        localObject = (msg_comm.Msg)paramList1.next();
        if (!((msg_comm.Msg)localObject).msg_head.has())
        {
          paramList1.remove();
        }
        else
        {
          localObject = (msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get();
          paramLong1 = ((msg_comm.MsgHead)localObject).msg_uid.get();
          paramLong2 = (short)((msg_comm.MsgHead)localObject).msg_seq.get();
          paramLong3 = ((msg_comm.MsgHead)localObject).from_uin.get();
          k = 0;
          while (k < localList.size())
          {
            localObject = (MessageRecord)localList.get(k);
            if ((((MessageRecord)localObject).msgUid == paramLong1) && (((MessageRecord)localObject).shmsgseq == paramLong2) && (((MessageRecord)localObject).senderuin.equals(String.valueOf(paramLong3))))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
              }
              localArrayList.add(localObject);
              paramList1.remove();
            }
            k += 1;
          }
        }
      }
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        localObject = (MessageRecord)paramList1.next();
        k = 0;
        while (k < localList.size())
        {
          MessageRecord localMessageRecord = (MessageRecord)localList.get(k);
          if ((localMessageRecord.msgUid == ((MessageRecord)localObject).msgUid) && (localMessageRecord.shmsgseq == ((MessageRecord)localObject).shmsgseq) && (localMessageRecord.senderuin.equals(((MessageRecord)localObject).senderuin)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "filterRoamMsgFromDB duplicated " + localObject);
            }
            paramList1.remove();
          }
          k += 1;
        }
      }
    }
    return new Pair(localArrayList, paramList2);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    String str = paramQQAppInterface.a();
    Long localLong = Long.valueOf(Long.parseLong(str));
    Object localObject1 = String.valueOf(paramLong1);
    Object localObject2 = "" + paramMsgHead.auth_uin.get();
    paramMsgHead = paramMsgHead.auth_nick.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramMsgHead)) && (((String)localObject2).equals(paramString1))) {}
    for (;;)
    {
      if ((str != null) && (str.equals(paramString1))) {
        return;
      }
      if (TextUtils.isEmpty(paramMsgHead)) {
        paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, (String)localObject1);
      }
      for (;;)
      {
        if ((paramInt == -126) || (paramInt == 2))
        {
          localObject1 = paramMsgHead + " 已加入该群";
          paramString2 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
          paramString2.init(localLong.longValue(), paramLong1, paramLong1, (String)localObject1, paramLong2, -1012, 1, paramLong3);
          paramString2.switch2HightlightMsg();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("key_action", 5);
          ((Bundle)localObject1).putString("troop_mem_uin", paramString1);
          ((Bundle)localObject1).putBoolean("need_update_nick", false);
          paramString2.addHightlightItem(0, paramMsgHead.length(), (Bundle)localObject1);
          paramString2.isread = true;
          if (a(paramString2, false)) {
            break;
          }
          paramQQAppInterface.a().a(paramString2, String.valueOf(localLong));
          return;
        }
        if ((paramInt != -125) && (paramInt != 3)) {
          break;
        }
        localObject1 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, (String)localObject1);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramInt = 1;
          localObject1 = "你";
        }
        for (;;)
        {
          if (paramInt != 0) {}
          for (str = (String)localObject1 + "邀请 ";; str = (String)localObject1 + " 邀请 ")
          {
            Object localObject3 = str + paramMsgHead + " 加入了群";
            localObject2 = (MessageForGrayTips)MessageRecordFactory.a(-1012);
            ((MessageForGrayTips)localObject2).init(localLong.longValue(), paramLong1, paramLong1, (String)localObject3, paramLong2, -1012, 1, paramLong3);
            ((MessageForGrayTips)localObject2).switch2HightlightMsg();
            if (paramInt == 0)
            {
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("key_action", 5);
              ((Bundle)localObject3).putString("troop_mem_uin", paramString2);
              ((Bundle)localObject3).putBoolean("need_update_nick", false);
              ((MessageForGrayTips)localObject2).addHightlightItem(0, ((String)localObject1).length(), (Bundle)localObject3);
            }
            paramString2 = new Bundle();
            paramString2.putInt("key_action", 5);
            paramString2.putString("troop_mem_uin", paramString1);
            paramString2.putBoolean("need_update_nick", false);
            ((MessageForGrayTips)localObject2).addHightlightItem(str.length(), str.length() + paramMsgHead.length(), paramString2);
            ((MessageForGrayTips)localObject2).isread = true;
            if (a((MessageRecord)localObject2, false)) {
              break;
            }
            paramQQAppInterface.a().a((MessageRecord)localObject2, String.valueOf(localLong));
            return;
          }
          paramInt = 0;
        }
      }
      paramMsgHead = "";
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg.getServiceCmd();
    long l1 = paramToServiceMsg.extraData.getLong("msgSeq");
    long l2 = paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg.getResultCode() != 2901) {
        break label93;
      }
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
      paramToServiceMsg.getClass();
      if (!paramFromServiceMsg.a(paramToServiceMsg, "msf")) {
        break label93;
      }
    }
    label93:
    while ((480000L != l2) && (!paramToServiceMsg.a())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><E>_C2C_reqSeq:" + l1);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l1);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcResponseMsgReadedReport paramSvcResponseMsgReadedReport)
  {
    paramToServiceMsg.getServiceCmd();
    long l = paramToServiceMsg.extraData.getLong("msgSeq");
    paramToServiceMsg.extraData.getLong("timeOut");
    paramToServiceMsg.extraData.getInt("retryIndex");
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramToServiceMsg, paramFromServiceMsg);
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l) == null) {}
    while (paramSvcResponseMsgReadedReport == null) {
      return;
    }
    int k = paramSvcResponseMsgReadedReport.cReplyCode;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "<ReadReport><R>_C2C_reqSeq:" + l + " replyCode:" + k);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l);
  }
  
  /* Error */
  private void a(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 533	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 592
    //   7: iconst_1
    //   8: invokevirtual 596	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   11: istore 9
    //   13: aload_1
    //   14: getfield 533	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc_w 598
    //   20: iconst_1
    //   21: invokevirtual 596	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   24: istore 11
    //   26: aload_1
    //   27: getfield 533	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   30: ldc_w 600
    //   33: iconst_0
    //   34: invokevirtual 596	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   37: istore 10
    //   39: aload_2
    //   40: invokevirtual 603	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   43: ifnonnull +246 -> 289
    //   46: aload_0
    //   47: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 606	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   53: invokestatic 609	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   56: astore 22
    //   58: aload 22
    //   60: invokevirtual 474	java/lang/Long:longValue	()J
    //   63: pop2
    //   64: new 611	msf/msgsvc/msg_svc$PbGetMsgResp
    //   67: dup
    //   68: invokespecial 612	msf/msgsvc/msg_svc$PbGetMsgResp:<init>	()V
    //   71: astore 22
    //   73: aload 22
    //   75: aload_3
    //   76: checkcast 614	[B
    //   79: checkcast 614	[B
    //   82: invokevirtual 618	msf/msgsvc/msg_svc$PbGetMsgResp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 611	msf/msgsvc/msg_svc$PbGetMsgResp
    //   88: astore 22
    //   90: aload 22
    //   92: ifnonnull +35 -> 127
    //   95: invokestatic 624	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   98: invokestatic 629	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   101: aload_0
    //   102: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   105: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   108: ldc_w 631
    //   111: iconst_0
    //   112: lconst_0
    //   113: lconst_0
    //   114: new 110	java/util/HashMap
    //   117: dup
    //   118: invokespecial 111	java/util/HashMap:<init>	()V
    //   121: ldc_w 443
    //   124: invokevirtual 634	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   127: new 107	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   134: astore 23
    //   136: aload 22
    //   138: ifnull +25 -> 163
    //   141: aload 22
    //   143: getfield 637	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 638	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   149: ifeq +14 -> 163
    //   152: aload 22
    //   154: getfield 637	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: ifeq +207 -> 367
    //   163: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   166: ifeq +113 -> 279
    //   169: aload 23
    //   171: iconst_0
    //   172: invokevirtual 222	java/lang/StringBuilder:setLength	(I)V
    //   175: aload 23
    //   177: ldc_w 640
    //   180: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore 24
    //   185: aload_1
    //   186: ifnonnull +140 -> 326
    //   189: ldc_w 642
    //   192: astore_3
    //   193: aload 24
    //   195: aload_3
    //   196: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: ldc_w 644
    //   202: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: astore 24
    //   207: aload 22
    //   209: ifnonnull +128 -> 337
    //   212: ldc_w 642
    //   215: astore_3
    //   216: aload 24
    //   218: aload_3
    //   219: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   222: ldc_w 646
    //   225: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: astore 24
    //   230: aload 22
    //   232: ifnonnull +120 -> 352
    //   235: ldc_w 642
    //   238: astore_3
    //   239: aload 24
    //   241: aload_3
    //   242: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   245: ldc_w 648
    //   248: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: iload 9
    //   253: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   256: ldc_w 653
    //   259: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: iload 11
    //   264: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: ldc 10
    //   270: iconst_2
    //   271: aload 23
    //   273: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 655	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload_0
    //   280: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   283: aload_1
    //   284: aload_2
    //   285: invokevirtual 657	com/tencent/mobileqq/app/MessageHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;)V
    //   288: return
    //   289: aload_2
    //   290: invokevirtual 603	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   293: invokestatic 609	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   296: astore 22
    //   298: goto -240 -> 58
    //   301: astore 22
    //   303: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +14 -> 320
    //   309: ldc 10
    //   311: iconst_2
    //   312: ldc_w 659
    //   315: aload 22
    //   317: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: aconst_null
    //   321: astore 22
    //   323: goto -233 -> 90
    //   326: aload_1
    //   327: invokevirtual 664	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   330: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: astore_3
    //   334: goto -141 -> 193
    //   337: aload 22
    //   339: getfield 637	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   342: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   345: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: astore_3
    //   349: goto -133 -> 216
    //   352: aload 22
    //   354: getfield 667	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   357: invokevirtual 356	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   360: invokestatic 672	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   363: astore_3
    //   364: goto -125 -> 239
    //   367: aconst_null
    //   368: astore_2
    //   369: aload 22
    //   371: getfield 667	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   374: invokevirtual 356	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   377: ifeq +15 -> 392
    //   380: aload 22
    //   382: getfield 667	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   385: invokevirtual 362	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   388: invokevirtual 368	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   391: astore_2
    //   392: aload 22
    //   394: getfield 675	msf/msgsvc/msg_svc$PbGetMsgResp:uin_pair_msgs	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   397: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   400: astore 24
    //   402: aload_0
    //   403: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   406: iconst_0
    //   407: putfield 678	com/tencent/mobileqq/app/MessageHandler:bI	I
    //   410: aload 22
    //   412: getfield 682	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   415: invokevirtual 685	com/tencent/mobileqq/pb/PBEnumField:has	()Z
    //   418: ifeq +1378 -> 1796
    //   421: aload 22
    //   423: getfield 682	msf/msgsvc/msg_svc$PbGetMsgResp:sync_flag	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   426: invokevirtual 686	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   429: istore 5
    //   431: iload 5
    //   433: iconst_2
    //   434: if_icmpge +1356 -> 1790
    //   437: iconst_1
    //   438: i2b
    //   439: istore 4
    //   441: aload_0
    //   442: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   448: aload_2
    //   449: invokevirtual 689	com/tencent/mobileqq/service/message/MessageCache:a	([B)V
    //   452: aload_0
    //   453: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   456: iconst_0
    //   457: invokevirtual 691	com/tencent/mobileqq/app/MessageHandler:c	(Z)V
    //   460: iconst_0
    //   461: istore 8
    //   463: aload_0
    //   464: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   467: invokevirtual 692	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   470: ifeq +6 -> 476
    //   473: iconst_1
    //   474: istore 8
    //   476: iload 4
    //   478: ifle +21 -> 499
    //   481: aload_0
    //   482: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   485: iload 4
    //   487: aload_2
    //   488: iload 5
    //   490: iload 9
    //   492: iload 11
    //   494: iload 8
    //   496: invokevirtual 695	com/tencent/mobileqq/app/MessageHandler:a	(B[BIZZZ)V
    //   499: invokestatic 700	java/lang/System:currentTimeMillis	()J
    //   502: pop2
    //   503: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +150 -> 656
    //   509: aload 23
    //   511: iconst_0
    //   512: invokevirtual 222	java/lang/StringBuilder:setLength	(I)V
    //   515: aload 23
    //   517: ldc_w 640
    //   520: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: astore_2
    //   524: aload_1
    //   525: ifnonnull +797 -> 1322
    //   528: ldc_w 642
    //   531: astore_1
    //   532: aload_2
    //   533: aload_1
    //   534: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   537: ldc_w 644
    //   540: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 22
    //   545: getfield 637	msf/msgsvc/msg_svc$PbGetMsgResp:result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   548: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   551: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: ldc_w 702
    //   557: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 22
    //   562: getfield 667	msf/msgsvc/msg_svc$PbGetMsgResp:sync_cookie	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   565: invokevirtual 356	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   568: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   571: ldc_w 704
    //   574: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: iload 4
    //   579: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   582: ldc_w 706
    //   585: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: iload 5
    //   590: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc_w 708
    //   596: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 9
    //   601: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: ldc_w 653
    //   607: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: iload 11
    //   612: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   615: ldc_w 710
    //   618: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 24
    //   623: invokeinterface 91 1 0
    //   628: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc_w 712
    //   634: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_3
    //   638: invokevirtual 715	java/lang/Object:hashCode	()I
    //   641: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   644: pop
    //   645: ldc 10
    //   647: iconst_2
    //   648: aload 23
    //   650: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: iconst_0
    //   657: istore 5
    //   659: lconst_0
    //   660: lstore 12
    //   662: iload 5
    //   664: aload 24
    //   666: invokeinterface 91 1 0
    //   671: if_icmpge +745 -> 1416
    //   674: invokestatic 700	java/lang/System:currentTimeMillis	()J
    //   677: lstore 14
    //   679: aload 24
    //   681: iload 5
    //   683: invokeinterface 431 2 0
    //   688: checkcast 75	msf/msgcomm/msg_comm$UinPairMsg
    //   691: astore 22
    //   693: aload 22
    //   695: getfield 200	msf/msgcomm/msg_comm$UinPairMsg:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   698: invokevirtual 186	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   701: invokestatic 210	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   704: astore_2
    //   705: aload 22
    //   707: getfield 718	msf/msgcomm/msg_comm$UinPairMsg:last_read_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   710: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   713: i2l
    //   714: ldc2_w 719
    //   717: land
    //   718: lstore 16
    //   720: aload 22
    //   722: getfield 79	msf/msgcomm/msg_comm$UinPairMsg:msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   725: invokevirtual 85	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   728: astore_3
    //   729: aload 22
    //   731: getfield 723	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   734: invokevirtual 638	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   737: ifeq +596 -> 1333
    //   740: aload 22
    //   742: getfield 723	msf/msgcomm/msg_comm$UinPairMsg:msg_completed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   745: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   748: ifeq +585 -> 1333
    //   751: iconst_1
    //   752: istore 8
    //   754: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq +77 -> 834
    //   760: aload 23
    //   762: iconst_0
    //   763: invokevirtual 222	java/lang/StringBuilder:setLength	(I)V
    //   766: aload 23
    //   768: ldc_w 725
    //   771: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_2
    //   775: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: ldc_w 727
    //   781: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: iload 8
    //   786: invokevirtual 651	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   789: ldc_w 729
    //   792: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: lload 16
    //   797: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   800: ldc_w 731
    //   803: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: astore 25
    //   808: aload_3
    //   809: ifnonnull +530 -> 1339
    //   812: ldc_w 642
    //   815: astore_1
    //   816: aload 25
    //   818: aload_1
    //   819: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: ldc 10
    //   825: iconst_2
    //   826: aload 23
    //   828: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: aload_3
    //   835: ifnull +559 -> 1394
    //   838: aload_3
    //   839: invokeinterface 91 1 0
    //   844: ifle +550 -> 1394
    //   847: aload_3
    //   848: invokeinterface 91 1 0
    //   853: iconst_1
    //   854: if_icmple +15 -> 869
    //   857: aload_3
    //   858: new 733	hsn
    //   861: dup
    //   862: aload_0
    //   863: invokespecial 736	hsn:<init>	(Lcom/tencent/mobileqq/app/message/C2CMessageProcessor;)V
    //   866: invokestatic 742	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   869: aload_0
    //   870: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   873: bipush 8
    //   875: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   878: checkcast 744	com/tencent/mobileqq/app/FriendsManagerImp
    //   881: aload_3
    //   882: iconst_0
    //   883: invokeinterface 431 2 0
    //   888: checkcast 136	msf/msgcomm/msg_comm$Msg
    //   891: getfield 140	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   894: invokevirtual 145	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   897: checkcast 142	msf/msgcomm/msg_comm$MsgHead
    //   900: getfield 189	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   903: invokevirtual 186	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   906: invokevirtual 745	com/tencent/mobileqq/app/FriendsManagerImp:a	(J)V
    //   909: aload_0
    //   910: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   913: aload_2
    //   914: iconst_0
    //   915: invokevirtual 748	com/tencent/mobileqq/app/MessageHandler:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   918: astore_1
    //   919: aload_1
    //   920: monitorenter
    //   921: aload_0
    //   922: aload_2
    //   923: aload 22
    //   925: lload 16
    //   927: iload 8
    //   929: iload 9
    //   931: iload 10
    //   933: invokespecial 750	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(Ljava/lang/String;Lmsf/msgcomm/msg_comm$UinPairMsg;JZZZ)Landroid/util/Pair;
    //   936: astore 22
    //   938: aload 22
    //   940: getfield 754	android/util/Pair:first	Ljava/lang/Object;
    //   943: checkcast 207	java/lang/String
    //   946: astore_2
    //   947: aload 22
    //   949: getfield 757	android/util/Pair:second	Ljava/lang/Object;
    //   952: checkcast 95	java/lang/Integer
    //   955: invokevirtual 760	java/lang/Integer:intValue	()I
    //   958: istore 7
    //   960: aload_1
    //   961: monitorexit
    //   962: iload 7
    //   964: istore 6
    //   966: aload_2
    //   967: astore_1
    //   968: iload 8
    //   970: ifne +183 -> 1153
    //   973: aload_0
    //   974: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   977: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   980: aload_2
    //   981: invokevirtual 762	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;)J
    //   984: lstore 18
    //   986: aload_3
    //   987: iconst_0
    //   988: invokeinterface 431 2 0
    //   993: checkcast 136	msf/msgcomm/msg_comm$Msg
    //   996: getfield 140	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   999: invokevirtual 145	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1002: checkcast 142	msf/msgcomm/msg_comm$MsgHead
    //   1005: getfield 193	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1008: invokevirtual 197	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1011: i2l
    //   1012: lstore 20
    //   1014: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1017: ifeq +62 -> 1079
    //   1020: ldc 10
    //   1022: iconst_2
    //   1023: new 107	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1030: ldc_w 764
    //   1033: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload_2
    //   1037: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: ldc_w 766
    //   1043: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: lload 18
    //   1048: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1051: ldc_w 768
    //   1054: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: lload 20
    //   1059: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1062: ldc_w 704
    //   1065: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: iload 4
    //   1070: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1079: lload 18
    //   1081: lconst_0
    //   1082: lcmp
    //   1083: ifeq +11 -> 1094
    //   1086: lload 20
    //   1088: lload 18
    //   1090: lcmp
    //   1091: ifge +35 -> 1126
    //   1094: aload_0
    //   1095: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1098: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1101: aload_2
    //   1102: lload 20
    //   1104: lconst_0
    //   1105: invokevirtual 771	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;JJ)V
    //   1108: iload 4
    //   1110: ifle +16 -> 1126
    //   1113: aload_0
    //   1114: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1120: aload_2
    //   1121: lload 20
    //   1123: invokevirtual 774	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;J)V
    //   1126: iload 7
    //   1128: istore 6
    //   1130: aload_2
    //   1131: astore_1
    //   1132: iload 4
    //   1134: ifne +19 -> 1153
    //   1137: aload_0
    //   1138: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1141: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1144: invokevirtual 776	com/tencent/mobileqq/service/message/MessageCache:c	()V
    //   1147: aload_2
    //   1148: astore_1
    //   1149: iload 7
    //   1151: istore 6
    //   1153: invokestatic 700	java/lang/System:currentTimeMillis	()J
    //   1156: lstore 18
    //   1158: iload 9
    //   1160: ifeq +143 -> 1303
    //   1163: aload_1
    //   1164: astore_2
    //   1165: iload 6
    //   1167: sipush 1006
    //   1170: if_icmpne +30 -> 1200
    //   1173: aload_0
    //   1174: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1177: bipush 10
    //   1179: invokevirtual 250	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1182: checkcast 778	com/tencent/mobileqq/model/PhoneContactManager
    //   1185: aload_1
    //   1186: invokeinterface 781 2 0
    //   1191: astore_3
    //   1192: aload_1
    //   1193: astore_2
    //   1194: aload_3
    //   1195: ifnull +5 -> 1200
    //   1198: aload_3
    //   1199: astore_2
    //   1200: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1203: ifeq +29 -> 1232
    //   1206: ldc 10
    //   1208: iconst_2
    //   1209: new 107	java/lang/StringBuilder
    //   1212: dup
    //   1213: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1216: ldc_w 783
    //   1219: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1222: aload_2
    //   1223: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: new 785	android/os/Message
    //   1235: dup
    //   1236: invokespecial 786	android/os/Message:<init>	()V
    //   1239: astore_1
    //   1240: aload_1
    //   1241: iconst_1
    //   1242: putfield 789	android/os/Message:what	I
    //   1245: new 483	android/os/Bundle
    //   1248: dup
    //   1249: invokespecial 484	android/os/Bundle:<init>	()V
    //   1252: astore_3
    //   1253: aload_3
    //   1254: ldc_w 791
    //   1257: lload 16
    //   1259: invokevirtual 794	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1262: aload_3
    //   1263: ldc_w 796
    //   1266: aload_2
    //   1267: invokevirtual 496	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1270: aload_3
    //   1271: ldc_w 798
    //   1274: iload 6
    //   1276: invokevirtual 490	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1279: aload_1
    //   1280: aload_3
    //   1281: invokevirtual 802	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1284: aload_0
    //   1285: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1288: aload_1
    //   1289: invokevirtual 805	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1292: aload_0
    //   1293: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1296: aload_2
    //   1297: invokeinterface 806 2 0
    //   1302: pop
    //   1303: lload 12
    //   1305: lload 18
    //   1307: lload 14
    //   1309: lsub
    //   1310: ladd
    //   1311: lstore 12
    //   1313: iload 5
    //   1315: iconst_1
    //   1316: iadd
    //   1317: istore 5
    //   1319: goto -657 -> 662
    //   1322: aload_1
    //   1323: invokevirtual 664	com/tencent/qphone/base/remote/ToServiceMsg:getRequestSsoSeq	()I
    //   1326: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1329: astore_1
    //   1330: goto -798 -> 532
    //   1333: iconst_0
    //   1334: istore 8
    //   1336: goto -582 -> 754
    //   1339: aload_3
    //   1340: invokeinterface 91 1 0
    //   1345: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1348: astore_1
    //   1349: goto -533 -> 816
    //   1352: astore_2
    //   1353: aload_1
    //   1354: monitorexit
    //   1355: aload_2
    //   1356: athrow
    //   1357: astore_1
    //   1358: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1361: ifeq +30 -> 1391
    //   1364: ldc 10
    //   1366: iconst_2
    //   1367: new 107	java/lang/StringBuilder
    //   1370: dup
    //   1371: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1374: ldc_w 808
    //   1377: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: aload_1
    //   1381: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: aload_1
    //   1388: invokestatic 661	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1391: goto -78 -> 1313
    //   1394: aload_0
    //   1395: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1398: invokevirtual 314	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1401: aload_2
    //   1402: iconst_0
    //   1403: invokevirtual 811	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1406: getfield 814	com/tencent/mobileqq/app/message/QQMessageFacade$Message:istroop	I
    //   1409: istore 6
    //   1411: aload_2
    //   1412: astore_1
    //   1413: goto -260 -> 1153
    //   1416: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1419: ifeq +30 -> 1449
    //   1422: ldc 10
    //   1424: iconst_2
    //   1425: new 107	java/lang/StringBuilder
    //   1428: dup
    //   1429: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1432: ldc_w 816
    //   1435: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: lload 12
    //   1440: invokevirtual 229	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1449: iload 4
    //   1451: ifgt -1163 -> 288
    //   1454: iload 9
    //   1456: ifeq +285 -> 1741
    //   1459: aload_0
    //   1460: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1463: invokevirtual 819	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/ConversationFacade;
    //   1466: invokevirtual 823	com/tencent/mobileqq/app/message/ConversationFacade:a	()Ljava/util/Set;
    //   1469: invokeinterface 346 1 0
    //   1474: astore_1
    //   1475: aload_1
    //   1476: invokeinterface 264 1 0
    //   1481: ifeq +251 -> 1732
    //   1484: aload_1
    //   1485: invokeinterface 268 1 0
    //   1490: checkcast 825	com/tencent/mobileqq/data/ConversationInfo
    //   1493: astore_2
    //   1494: aload_2
    //   1495: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1498: ifnull -23 -> 1475
    //   1501: aload_0
    //   1502: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1505: invokeinterface 829 1 0
    //   1510: ifle +19 -> 1529
    //   1513: aload_0
    //   1514: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1517: aload_2
    //   1518: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1521: invokeinterface 832 2 0
    //   1526: ifne -51 -> 1475
    //   1529: aload_2
    //   1530: getfield 835	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1533: invokestatic 837	com/tencent/mobileqq/app/message/MsgProxyUtils:c	(I)Z
    //   1536: ifeq -61 -> 1475
    //   1539: aload_2
    //   1540: getfield 840	com/tencent/mobileqq/data/ConversationInfo:unreadCount	I
    //   1543: ifle -68 -> 1475
    //   1546: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1549: ifeq +32 -> 1581
    //   1552: ldc 10
    //   1554: iconst_2
    //   1555: new 107	java/lang/StringBuilder
    //   1558: dup
    //   1559: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1562: ldc_w 842
    //   1565: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1568: aload_2
    //   1569: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1572: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1575: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1581: aload_2
    //   1582: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1585: invokevirtual 505	java/lang/String:length	()I
    //   1588: iconst_4
    //   1589: if_icmple -114 -> 1475
    //   1592: aload_2
    //   1593: getfield 835	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1596: sipush 1001
    //   1599: if_icmpne +59 -> 1658
    //   1602: aload_0
    //   1603: getfield 64	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1606: invokevirtual 213	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1609: aload_2
    //   1610: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1613: invokevirtual 846	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;)[B
    //   1616: astore_3
    //   1617: aload_3
    //   1618: ifnull -143 -> 1475
    //   1621: aload_3
    //   1622: arraylength
    //   1623: ifle -148 -> 1475
    //   1626: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1629: ifeq +29 -> 1658
    //   1632: ldc 10
    //   1634: iconst_2
    //   1635: new 107	java/lang/StringBuilder
    //   1638: dup
    //   1639: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   1642: ldc_w 848
    //   1645: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1648: aload_3
    //   1649: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1652: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1655: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1658: new 785	android/os/Message
    //   1661: dup
    //   1662: invokespecial 786	android/os/Message:<init>	()V
    //   1665: astore_3
    //   1666: aload_3
    //   1667: iconst_1
    //   1668: putfield 789	android/os/Message:what	I
    //   1671: new 483	android/os/Bundle
    //   1674: dup
    //   1675: invokespecial 484	android/os/Bundle:<init>	()V
    //   1678: astore 22
    //   1680: aload 22
    //   1682: ldc_w 791
    //   1685: ldc2_w 849
    //   1688: invokevirtual 794	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1691: aload 22
    //   1693: ldc_w 796
    //   1696: aload_2
    //   1697: getfield 828	com/tencent/mobileqq/data/ConversationInfo:uin	Ljava/lang/String;
    //   1700: invokevirtual 496	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1703: aload 22
    //   1705: ldc_w 798
    //   1708: aload_2
    //   1709: getfield 835	com/tencent/mobileqq/data/ConversationInfo:type	I
    //   1712: invokevirtual 490	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1715: aload_3
    //   1716: aload 22
    //   1718: invokevirtual 802	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   1721: aload_0
    //   1722: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1725: aload_3
    //   1726: invokevirtual 805	com/tencent/mobileqq/app/MessageHandler:a	(Landroid/os/Message;)V
    //   1729: goto -254 -> 1475
    //   1732: aload_0
    //   1733: getfield 51	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   1736: invokeinterface 853 1 0
    //   1741: invokestatic 858	com/tencent/util/MsgAutoMonitorUtil:a	()Lcom/tencent/util/MsgAutoMonitorUtil;
    //   1744: invokevirtual 860	com/tencent/util/MsgAutoMonitorUtil:e	()V
    //   1747: aload_0
    //   1748: sipush 4001
    //   1751: iconst_1
    //   1752: aconst_null
    //   1753: invokevirtual 863	com/tencent/mobileqq/app/message/C2CMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1756: aload_0
    //   1757: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1760: invokevirtual 692	com/tencent/mobileqq/app/MessageHandler:a	()Z
    //   1763: ifeq -1475 -> 288
    //   1766: invokestatic 161	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1769: ifeq +12 -> 1781
    //   1772: ldc 10
    //   1774: iconst_2
    //   1775: ldc_w 865
    //   1778: invokestatic 178	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1781: aload_0
    //   1782: getfield 359	com/tencent/mobileqq/app/message/C2CMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1785: iconst_0
    //   1786: invokevirtual 867	com/tencent/mobileqq/app/MessageHandler:b	(Z)V
    //   1789: return
    //   1790: iconst_0
    //   1791: istore 4
    //   1793: goto -1352 -> 441
    //   1796: iconst_2
    //   1797: istore 5
    //   1799: goto -1368 -> 431
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1802	0	this	C2CMessageProcessor
    //   0	1802	2	paramFromServiceMsg	FromServiceMsg
    //   0	1802	3	paramObject	Object
    //   439	1353	4	b1	byte
    //   429	1369	5	k	int
    //   964	446	6	m	int
    //   958	192	7	n	int
    //   461	874	8	bool1	boolean
    //   11	1444	9	bool2	boolean
    //   37	895	10	bool3	boolean
    //   24	587	11	bool4	boolean
    //   660	779	12	l1	long
    //   677	631	14	l2	long
    //   718	540	16	l3	long
    //   984	322	18	l4	long
    //   1012	110	20	l5	long
    //   56	241	22	localObject1	Object
    //   301	15	22	localException	Exception
    //   321	1396	22	localObject2	Object
    //   134	693	23	localStringBuilder1	StringBuilder
    //   183	497	24	localObject3	Object
    //   806	11	25	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	90	301	java/lang/Exception
    //   921	962	1352	finally
    //   1353	1355	1352	finally
    //   909	921	1357	java/lang/Exception
    //   1355	1357	1357	java/lang/Exception
  }
  
  private void a(List paramList1, List paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---C2CMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.C2CMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg)
  {
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!localMsgHead.c2c_cmd.has()) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster: no C2CCmd.");
      }
    }
    long l1;
    long l2;
    int k;
    int m;
    Object localObject1;
    long l7;
    Object localObject2;
    boolean bool2;
    boolean bool3;
    for (;;)
    {
      return;
      l1 = localMsgHead.c2c_cmd.get();
      l2 = localMsgHead.from_uin.get();
      long l3 = localMsgHead.to_uin.get();
      long l4 = localMsgHead.msg_seq.get();
      long l5 = localMsgHead.msg_time.get();
      long l6 = localMsgHead.msg_uid.get();
      k = localMsgHead.user_active.get();
      m = localMsgHead.from_instid.get();
      if (paramFromServiceMsg.getUin() == null)
      {
        localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        l7 = ((Long)localObject1).longValue();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "<---handleMsgPush_PB_SlaveMaster:fromUin:" + l2 + ",toUin:" + l3 + ",msgTime:" + l5 + ",msgSeq:" + l4 + ",msgUid:" + l6 + ",userActive:" + k + ",fromInstid:" + m + ",hasAppShare:" + paramMsg.appshare_info.has() + ",hasMsgBody:" + paramMsg.msg_body.has());
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.aO = k;
        localObject1 = new ArrayList();
        Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      }
      try
      {
        localObject2 = new DecodeProtoPkgContext(l7, l3, true, false, false, false);
        ((DecodeProtoPkgContext)localObject2).h = true;
        paramMsg = a(paramMsg, (PBDecodeContext)localObject2);
        MessageHandlerUtils.a(paramMsg);
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          if (localObject1 != null) {
            a(paramMsg, (ArrayList)localObject1, true);
          }
          paramMsg = new ArrayList();
          localObject2 = new ArrayList();
          if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
          {
            m = ((ArrayList)localObject1).size();
            k = 0;
            while (k < m)
            {
              MessageRecord localMessageRecord = (MessageRecord)((ArrayList)localObject1).get(k);
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.C2CMessageProcessor", 2, "----------handleMsgPush_PB_SlaveMaster after analysis mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
              }
              localMessageRecord.isread = true;
              localMessageRecord.issend = 2;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.time);
              ((ArrayList)localObject2).add(localMessageRecord);
              DelMsgInfo localDelMsgInfo = new DelMsgInfo();
              localDelMsgInfo.lFromUin = Long.parseLong(localMessageRecord.senderuin);
              localDelMsgInfo.shMsgSeq = ((short)(int)localMessageRecord.shmsgseq);
              localDelMsgInfo.uMsgTime = localMessageRecord.time;
              paramMsg.add(localDelMsgInfo);
              k += 1;
              continue;
              localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
            }
          }
        }
      }
      catch (Exception paramMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", paramMsg);
          }
          paramMsg = null;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject2);
        bool2 = MessageHandlerUtils.a((ArrayList)localObject2);
        bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ArrayList)localObject2);
        k = MsgProxyUtils.a((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (!bool2) {
          break label837;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) {}
    label837:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((QQMessageFacade)localObject1).a((ArrayList)localObject2, String.valueOf(l7), bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMsgHead.msg_seq.get());
      m = paramFromServiceMsg.getRequestSsoSeq();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(l2, paramMsg, paramPbPushMsg.svrip.get(), m);
      if (l1 == 127L) {
        break;
      }
      a("handleMsgPush_PB_SlaveMaster", true, k, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b((ArrayList)localObject2);
      return;
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1004, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new msg_svc.PbGetRoamMsgResp();
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg != null)
      {
        paramObject = String.valueOf(paramFromServiceMsg.peer_uin.get());
        m = paramFromServiceMsg.result.get();
        localObject2 = paramFromServiceMsg.msg.get();
        if (localObject2 == null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramObject)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(paramObject);
          }
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + m + ", msgList is null !");
          }
          a(1004, false, null);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg InvalidProtocolBufferMicroException ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
    }
    catch (OutOfMemoryError paramFromServiceMsg)
    {
      int m;
      Object localObject2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramFromServiceMsg);
        }
        paramFromServiceMsg = null;
      }
      Object localObject1 = new ArrayList();
      a((List)localObject2, (List)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg code=" + m + ", msgList.size()=" + ((List)localObject1).size() + ",peerUin=" + paramObject + ",time=" + paramFromServiceMsg.last_msgtime.get());
      }
      int k = 0;
      if (((m != 0) && (m != 1)) || (m == 0)) {}
      for (;;)
      {
        try
        {
          if (((List)localObject1).size() > 0)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramObject)) {
              continue;
            }
            localObject2 = (List)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(paramObject);
            if (((List)localObject2).size() == 0) {
              ((List)localObject2).addAll(0, (Collection)localObject1);
            }
          }
          else
          {
            localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86);
            if (paramFromServiceMsg.sig.has()) {
              ((MessageRoamManager)localObject1).a(paramFromServiceMsg.sig.get().toByteArray());
            }
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject, paramToServiceMsg.extraData.getLong("lBeginTime"), paramFromServiceMsg.last_msgtime.get(), paramToServiceMsg.extraData.getLong("lEndTime"), (short)0, paramFromServiceMsg.random.get(), 1, ((MessageRoamManager)localObject1).a(), ((MessageRoamManager)localObject1).b());
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", paramToServiceMsg);
          }
          k = 0;
          if (k != 0) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramObject)) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(paramObject);
          }
          paramToServiceMsg = new Object[2];
          if (!paramFromServiceMsg.errmsg.has()) {
            break label1645;
          }
          paramToServiceMsg[0] = Boolean.valueOf(false);
          paramToServiceMsg[1] = paramFromServiceMsg.errmsg.get();
          paramFromServiceMsg = new HashMap();
          paramFromServiceMsg.put("ERROR_DATA", paramToServiceMsg);
          if (m == 51) {
            paramFromServiceMsg.put("CODE_51", Boolean.valueOf(true));
          }
          a(1004, false, paramFromServiceMsg);
          return;
          if ((((List)localObject2).size() <= 0) || ((((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_uid.get() == ((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject1).get(0)).msg_head.get()).msg_uid.get()) && (((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject2).get(0)).msg_head.get()).msg_seq.get() == ((msg_comm.MsgHead)((msg_comm.Msg)((List)localObject1).get(0)).msg_head.get()).msg_seq.get()))) {
            continue;
          }
          ((List)localObject2).addAll(0, (Collection)localObject1);
          continue;
        }
        catch (OutOfMemoryError paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", paramToServiceMsg);
          }
          k = 0;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.put(paramObject, localObject1);
          continue;
        }
        localObject1 = new ArrayList((Collection)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.containsKey(paramObject))
        {
          ((ArrayList)localObject1).addAll((Collection)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.get(paramObject));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a.remove(paramObject);
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          paramToServiceMsg = new Object[2];
          paramToServiceMsg[0] = Boolean.valueOf(true);
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("ERROR_DATA", paramToServiceMsg);
          a(1004, false, localObject1);
          return;
        }
        long l1 = paramToServiceMsg.extraData.getLong("lBeginTime");
        long l2 = paramToServiceMsg.extraData.getLong("lEndTime");
        localObject2 = new ArrayList();
        Object localObject3 = ((ArrayList)localObject1).iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (msg_comm.Msg)((Iterator)localObject3).next();
          if (!((msg_comm.Msg)localObject4).msg_head.has())
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msg msg_head = null");
            }
          }
          else
          {
            long l3 = ((msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get()).msg_time.get();
            if ((l3 >= l1) && (l3 <= l2)) {
              ((ArrayList)localObject2).add(localObject4);
            }
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg msgTime = " + l3 + ", begTime = " + l1 + ", endTime = " + l2);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg resList size = " + ((ArrayList)localObject1).size() + ", dayList size = " + ((ArrayList)localObject2).size());
        }
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, (List)localObject2, Long.valueOf(paramObject).longValue(), true);
        localObject1 = new ArrayList();
        l1 = Long.parseLong(paramObject);
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject4 = (msg_comm.Msg)((ArrayList)localObject2).get(0);
          l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject4).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
        }
        ((ArrayList)localObject1).addAll((Collection)a((List)localObject2, (List)localObject3, l1, paramToServiceMsg.extraData.getLong("lBeginTime"), paramToServiceMsg.extraData.getLong("lEndTime")).second);
        localObject3 = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
        ((DecodeProtoPkgContext)localObject3).h = true;
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (msg_comm.Msg)((Iterator)localObject2).next();
          try
          {
            localObject4 = a((msg_comm.Msg)localObject4, (PBDecodeContext)localObject3);
            if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
              continue;
            }
            ((ArrayList)localObject1).addAll((Collection)localObject4);
          }
          catch (Exception localException2) {}
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
          }
        }
        if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0)) {
          Collections.sort((List)localObject1, new hso(this));
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((List)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a((ArrayList)localObject1, false);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()));
          if ((localObject1 == null) || (((Long)((Pair)localObject1).first).longValue() > paramFromServiceMsg.last_msgtime.get())) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramToServiceMsg.extraData.getLong("lBeginTime"), 0L);
          }
          localObject1 = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(86);
          if (paramFromServiceMsg.sig.has()) {
            ((MessageRoamManager)localObject1).a(paramFromServiceMsg.sig.get().toByteArray());
          }
          ((MessageRoamManager)localObject1).a().b(paramObject, paramToServiceMsg.extraData.getLong("lBeginTime"), 3);
          a(1004, true, Long.valueOf(paramToServiceMsg.extraData.getLong("lBeginTime")));
          k = 1;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg exception ! ", localException1);
            }
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsg OutOfMemoryError ! ", localOutOfMemoryError);
            }
          }
        }
        label1645:
        paramToServiceMsg = null;
      }
      a(1004, false, null);
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    a(1004, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay ");
    }
    paramFromServiceMsg = new msg_svc.PbGetOneDayRoamMsgResp();
    Bundle localBundle;
    long l2;
    int k;
    long l1;
    try
    {
      paramFromServiceMsg = (msg_svc.PbGetOneDayRoamMsgResp)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      localBundle = paramToServiceMsg.extraData.getBundle("context");
      paramObject = null;
      l2 = 0L;
      if (paramFromServiceMsg == null) {
        break label691;
      }
      k = paramFromServiceMsg.result.get();
      Object localObject = paramFromServiceMsg.msg.get();
      paramToServiceMsg = new ArrayList();
      a((List)localObject, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "handlePBGetRoamMsgInOneDay code=" + k + ", complete=" + paramFromServiceMsg.iscomplete.get() + " ,respRandom:" + paramFromServiceMsg.random.get() + ", lastMsgTime:" + paramFromServiceMsg.last_msgtime.get() + ", msgList.size()=" + paramToServiceMsg.size() + ", context" + localBundle);
      }
      if (k != 0) {
        break label692;
      }
      paramObject = new ArrayList();
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramToServiceMsg, paramFromServiceMsg.peer_uin.get(), true);
        if (localObject != null) {
          paramObject.addAll((Collection)localObject);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          DecodeProtoPkgContext localDecodeProtoPkgContext;
          Iterator localIterator;
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.C2CMessageProcessor", 2, "FileMsg filter error,", localException1);
          }
        }
      }
      l1 = paramFromServiceMsg.peer_uin.get();
      if (!paramToServiceMsg.isEmpty())
      {
        localObject = (msg_comm.Msg)paramToServiceMsg.get(0);
        l1 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).from_uin.get(), ((msg_comm.MsgHead)((msg_comm.Msg)localObject).msg_head.get()).to_uin.get(), paramFromServiceMsg.peer_uin.get());
      }
      localDecodeProtoPkgContext = new DecodeProtoPkgContext(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()), l1, true, true, false, false);
      localDecodeProtoPkgContext.h = true;
      localIterator = paramToServiceMsg.iterator();
      paramToServiceMsg = null;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label479;
        }
        localObject = (msg_comm.Msg)localIterator.next();
        try
        {
          localObject = a((msg_comm.Msg)localObject, localDecodeProtoPkgContext);
          paramToServiceMsg = (ToServiceMsg)localObject;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeSinglePBMsg_C2C error,", localException2);
            }
          }
        }
        if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0)) {
          paramObject.addAll(paramToServiceMsg);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
      }
    }
    label479:
    if (paramObject.size() > 0)
    {
      Collections.sort(paramObject, new hsp(this));
      l1 = ((MessageRecord)paramObject.get(0)).time;
    }
    for (paramToServiceMsg = paramObject;; paramToServiceMsg = null)
    {
      for (;;)
      {
        boolean bool3;
        boolean bool1;
        label563:
        boolean bool2;
        if (localBundle != null)
        {
          localBundle.getInt("size_req", 0);
          l2 = localBundle.getLong("UIN", 0L);
          bool3 = localBundle.getBoolean("canUpdateEct", true);
          if (paramFromServiceMsg.iscomplete.get() == 0) {
            break label734;
          }
          bool1 = true;
          if ((k != 0) && (k != 1) && (k != 4)) {
            break label740;
          }
          bool2 = true;
          label583:
          if ((!bool2) || (!bool3)) {
            break label783;
          }
          if (!bool1) {
            break label746;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(l2), 0L, 0L);
          label615:
          localBundle.putBoolean("complete", bool1);
          localBundle.putBoolean("success", bool2);
          localBundle.putLong("lowTime", l1);
          paramObject = new ArrayList();
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(paramFromServiceMsg.peer_uin.get()), 0, paramToServiceMsg, paramObject, localBundle);
          if (paramToServiceMsg != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramObject, false);
          }
          label691:
          return;
          label692:
          l1 = l2;
          paramToServiceMsg = paramObject;
          if (k == 1)
          {
            l1 = l2;
            paramToServiceMsg = paramObject;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.C2CMessageProcessor", 2, "code == 0x01");
              l1 = l2;
              paramToServiceMsg = paramObject;
              continue;
              label734:
              bool1 = false;
              break label563;
              label740:
              bool2 = false;
              break label583;
              label746:
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(String.valueOf(paramFromServiceMsg.peer_uin.get()), paramFromServiceMsg.last_msgtime.get(), paramFromServiceMsg.random.get());
              break label615;
              label783:
              if (bool3) {
                break label615;
              }
              if (bool1)
              {
                localBundle.putLong("tempEct", 0L);
                localBundle.putLong("tempRandom", 0L);
                break label615;
              }
              localBundle.putLong("tempEct", paramFromServiceMsg.last_msgtime.get());
              localBundle.putLong("tempRandom", paramFromServiceMsg.random.get());
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
      l1 = 0L;
    }
  }
  
  protected String a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    return 64 + "key_uid_" + l1 + "_seq_" + l2;
  }
  
  public ArrayList a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    if (!(paramPBDecodeContext instanceof DecodeProtoPkgContext)) {
      return new ArrayList();
    }
    DecodeProtoPkgContext localDecodeProtoPkgContext = (DecodeProtoPkgContext)paramPBDecodeContext;
    long l2 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    if ((paramMsg == null) || (!paramMsg.msg_head.has()) || (!paramMsg.msg_body.has()))
    {
      if (QLog.isColorLevel())
      {
        paramPBDecodeContext = new StringBuilder().append("decodeSinglePBMsg_C2C return : ");
        if (paramMsg != null) {
          break label104;
        }
      }
      label104:
      for (paramMsg = " msg=null";; paramMsg = " msg.msg_head:" + paramMsg.msg_head + " msg.msg_body:" + paramMsg.msg_body.has())
      {
        QLog.d("Q.msg.C2CMessageProcessor", 2, paramMsg);
        return localArrayList;
      }
    }
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i4 = (short)localMsgHead.msg_seq.get();
    long l5 = localMsgHead.to_uin.get();
    long l3 = localMsgHead.from_uin.get();
    long l6 = localMsgHead.msg_time.get();
    long l4 = localMsgHead.msg_uid.get();
    int i3 = localMsgHead.msg_type.get();
    int k = paramMsg.msg_head.c2c_cmd.get();
    int m = 0;
    int i2;
    int i1;
    int n;
    if (paramMsg.content_head.has())
    {
      paramPBDecodeContext = (msg_comm.ContentHead)paramMsg.content_head.get();
      i2 = paramPBDecodeContext.div_seq.get();
      i1 = paramPBDecodeContext.pkg_num.get();
      n = paramPBDecodeContext.pkg_index.get();
    }
    for (;;)
    {
      long l1 = -1L;
      paramPBDecodeContext = null;
      label393:
      Object localObject1;
      Object localObject2;
      if (!localDecodeProtoPkgContext.jdField_d_of_type_Boolean)
      {
        paramPBDecodeContext = MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), String.valueOf(l3));
        if (((Long)paramPBDecodeContext.first).longValue() != 4294967295L) {
          l1 = ((Long)paramPBDecodeContext.first).longValue();
        }
      }
      else
      {
        localDecodeProtoPkgContext.jdField_d_of_type_Long = l1;
        localDecodeProtoPkgContext.jdField_b_of_type_Long = l3;
        localDecodeProtoPkgContext.jdField_c_of_type_Long = l6;
        if (l3 != localDecodeProtoPkgContext.jdField_a_of_type_Long) {
          break label1169;
        }
        localDecodeProtoPkgContext.jdField_a_of_type_Boolean = true;
        localDecodeProtoPkgContext.f = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          localObject2 = ((StringBuilder)localObject1).append("<---decodeSinglePBMsg_C2C : decode msg: msgTime:").append(l6).append(" shortSeq:").append(i4).append(" uint32Seq:").append(localMsgHead.msg_seq.get()).append(" msgUid:").append(l4).append(" toUin:").append(l5).append(" senderUin:").append(l3).append(" friendUin:").append(localDecodeProtoPkgContext.jdField_e_of_type_Long).append(" isReaded:").append(localDecodeProtoPkgContext.jdField_a_of_type_Boolean).append(" isSyncFromOtherTerm:").append(localDecodeProtoPkgContext.f).append(" msgType:").append(i3).append(" C2CCmd:").append(k).append(" hasTemp:").append(localMsgHead.c2c_tmp_msg_head.has()).append(" hasShare:").append(paramMsg.appshare_info.has()).append(" pkgID:");
          if (paramPBDecodeContext != null) {
            break label1178;
          }
          paramPBDecodeContext = "nullPair";
          label594:
          ((StringBuilder)localObject2).append(paramPBDecodeContext).append(" longMsgID:").append(i2).append(" longMsgCount:").append(i1).append(" longMsgIndex:").append(n).append("init_direction_flag").append(0);
          QLog.d("Q.msg.C2CMessageProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        paramPBDecodeContext = new ArrayList();
        if ((i3 != 140) && (i3 != 141) && ((i3 != 529) || (localMsgHead.c2c_cmd.get() != 6))) {
          break label1244;
        }
        m = 1;
        localObject1 = MessageProtoCodec.a(paramMsg);
        if (((TempSessionInfo)localObject1).jdField_b_of_type_Int != -1) {
          break label1189;
        }
        k = 0;
        label720:
        if (k == 0) {
          break label1241;
        }
        m = ((TempSessionInfo)localObject1).jdField_b_of_type_Int;
        k = ((TempSessionInfo)localObject1).jdField_c_of_type_Int;
        MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.C2CMessageProcessor", 2, "friendType:" + m + ", direction_flag:" + k);
        }
      }
      for (;;)
      {
        label793:
        paramPBDecodeContext = paramPBDecodeContext.iterator();
        for (;;)
        {
          if (paramPBDecodeContext.hasNext())
          {
            localObject1 = (MessageRecord)paramPBDecodeContext.next();
            if (localObject1 != null)
            {
              ((MessageRecord)localObject1).selfuin = String.valueOf(localDecodeProtoPkgContext.jdField_a_of_type_Long);
              ((MessageRecord)localObject1).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
              ((MessageRecord)localObject1).senderuin = String.valueOf(localDecodeProtoPkgContext.jdField_b_of_type_Long);
              ((MessageRecord)localObject1).time = localDecodeProtoPkgContext.jdField_c_of_type_Long;
              ((MessageRecord)localObject1).shmsgseq = i4;
              ((MessageRecord)localObject1).msgUid = l4;
              ((MessageRecord)localObject1).istroop = m;
              ((MessageRecord)localObject1).longMsgId = i2;
              ((MessageRecord)localObject1).longMsgCount = i1;
              ((MessageRecord)localObject1).longMsgIndex = n;
              if (1 == k)
              {
                MsgProxyUtils.a((MessageRecord)localObject1, true);
                label926:
                localObject2 = (msg_comm.C2CTmpMsgHead)localMsgHead.c2c_tmp_msg_head.get();
                if ((localObject2 != null) && (((msg_comm.C2CTmpMsgHead)localObject2).lock_display.has()) && (((msg_comm.C2CTmpMsgHead)localObject2).lock_display.get() == 1))
                {
                  ((MessageRecord)localObject1).extLong |= 0x1;
                  ((MessageRecord)localObject1).saveExtInfoToExtStr("lockDisplay", "true");
                }
                if (m == 1006)
                {
                  if (localMsgHead.from_nick.has()) {
                    ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long), (short)0, localMsgHead.from_nick.get(), "");
                  }
                  ((MessageRecord)localObject1).frienduin = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long));
                  ((MessageRecord)localObject1).senderuin = ContactUtils.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l3));
                  if ((TextUtils.isEmpty(((MessageRecord)localObject1).frienduin)) && (localDecodeProtoPkgContext.jdField_d_of_type_Boolean)) {
                    ((MessageRecord)localObject1).frienduin = String.valueOf(localDecodeProtoPkgContext.jdField_e_of_type_Long);
                  }
                }
                if (!localDecodeProtoPkgContext.f) {
                  break label2192;
                }
                ((MessageRecord)localObject1).issend = 2;
                ((MessageRecord)localObject1).isread = true;
                label1133:
                ((MessageRecord)localObject1).vipBubbleID = localDecodeProtoPkgContext.jdField_d_of_type_Long;
                localArrayList.add(localObject1);
                continue;
                l1 = ((Long)paramPBDecodeContext.second).longValue();
                break;
                label1169:
                localDecodeProtoPkgContext.f = false;
                break label393;
                label1178:
                paramPBDecodeContext = (Serializable)paramPBDecodeContext.first;
                break label594;
                label1189:
                if ((((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1000) && (((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1020))
                {
                  k = m;
                  if (((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1004) {
                    break label720;
                  }
                }
                localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_c_of_type_Long;
                k = m;
                break label720;
                label1241:
                return localArrayList;
                label1244:
                if (paramMsg.appshare_info.has())
                {
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, 0L, 0L, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                  k = 0;
                  break label793;
                }
                if ((MessageUtils.c(i3)) && (localMsgHead.c2c_cmd.has())) {}
                switch (k)
                {
                default: 
                  k = 0;
                  break;
                case 169: 
                case 241: 
                case 242: 
                case 243: 
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, k, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                  k = 0;
                  break;
                case 11: 
                case 175: 
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                  k = 0;
                  break;
                case 193: 
                  k = 0;
                  break;
                case 129: 
                case 131: 
                case 133: 
                  MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_e_of_type_Long, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.jdField_b_of_type_Boolean, localDecodeProtoPkgContext.jdField_d_of_type_Long);
                  k = 0;
                  break;
                  if (i3 == 208)
                  {
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg);
                    k = 0;
                    break;
                  }
                  if (i3 == 193)
                  {
                    if (localDecodeProtoPkgContext.jdField_d_of_type_Boolean) {
                      break label2251;
                    }
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext);
                    k = 0;
                    break;
                  }
                  if (i3 == 734)
                  {
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f);
                    k = 0;
                    break;
                  }
                  if (i3 == 519)
                  {
                    k = 0;
                    break;
                  }
                  if (SystemMsg.isSystemMessage(i3))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.systemmsg.", 2, "friend system msg notify");
                    }
                    k = 0;
                    if ((i3 == 188) || (i3 == 189)) {
                      k = 1;
                    }
                    if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (k == 0)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
                    }
                    localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    if (k != 0) {
                      SystemMsgController.a().b(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                    for (;;)
                    {
                      return localArrayList;
                      paramMsg = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
                      if (!MessageHandler.jdField_c_of_type_Boolean) {
                        SystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      } else {
                        FriendSystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                      }
                    }
                  }
                  if (a(i3))
                  {
                    a(paramPBDecodeContext, paramMsg, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    k = 0;
                    break;
                  }
                  if (732 == i3)
                  {
                    a(paramMsg, i4, l3, l4, i3);
                    k = 0;
                    break;
                  }
                  if (SystemMsg.isTroopSystemMessage(i3))
                  {
                    k = 0;
                    if ((i3 == 85) || (i3 == 36)) {
                      k = 1;
                    }
                    if ((!localDecodeProtoPkgContext.jdField_c_of_type_Boolean) && (k == 0)) {
                      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
                    }
                    localDecodeProtoPkgContext.jdField_e_of_type_Long = 9998L;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramMsg, localDecodeProtoPkgContext.jdField_a_of_type_Boolean, localDecodeProtoPkgContext.f, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
                    if (k != 0) {
                      SystemMsgController.a().b(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                    for (;;)
                    {
                      return localArrayList;
                      GroupSystemMsgController.a().a(l3, l6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    }
                  }
                  if (i3 == 528)
                  {
                    if (localDecodeProtoPkgContext.jdField_d_of_type_Boolean) {
                      break label2251;
                    }
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, localDecodeProtoPkgContext.jdField_a_of_type_Long, paramMsg, localDecodeProtoPkgContext.h);
                    k = 0;
                    break;
                  }
                  if (i3 != 529) {
                    break label2251;
                  }
                  if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
                    break label2246;
                  }
                  m = 1;
                  localObject1 = MessageProtoCodec.a(paramMsg);
                  if (((TempSessionInfo)localObject1).jdField_b_of_type_Int == -1)
                  {
                    k = 0;
                    label2024:
                    if (k == 0) {
                      break label2246;
                    }
                    k = ((TempSessionInfo)localObject1).jdField_b_of_type_Int;
                    MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler, paramPBDecodeContext, paramMsg, (TempSessionInfo)localObject1, localDecodeProtoPkgContext);
                  }
                  break;
                }
              }
            }
          }
        }
        for (;;)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler;
          l1 = localDecodeProtoPkgContext.jdField_e_of_type_Long;
          boolean bool2 = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
          boolean bool3 = localDecodeProtoPkgContext.jdField_b_of_type_Boolean;
          if (l3 == localDecodeProtoPkgContext.jdField_a_of_type_Long) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            MessageProtoCodec.a((MessageHandler)localObject1, paramPBDecodeContext, paramMsg, l1, bool2, bool3, bool1, localDecodeProtoPkgContext.jdField_d_of_type_Long, localDecodeProtoPkgContext.jdField_d_of_type_Boolean);
            i3 = 0;
            m = k;
            k = i3;
            break;
            if ((((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1000) && (((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1020))
            {
              k = m;
              if (((TempSessionInfo)localObject1).jdField_b_of_type_Int != 1004) {
                break label2024;
              }
            }
            localDecodeProtoPkgContext.jdField_b_of_type_Long = ((TempSessionInfo)localObject1).jdField_c_of_type_Long;
            k = m;
            break label2024;
          }
          MsgProxyUtils.a((MessageRecord)localObject1, false);
          break label926;
          label2192:
          ((MessageRecord)localObject1).isread = localDecodeProtoPkgContext.jdField_a_of_type_Boolean;
          break label1133;
          if (m == 1008) {
            ((LifeOnlineAccountInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82)).a(localArrayList, paramMsg);
          }
          MsgAutoMonitorUtil.a().f(System.currentTimeMillis() - l2);
          return localArrayList;
          label2246:
          k = 0;
        }
        label2251:
        k = 0;
      }
      n = 0;
      i1 = 0;
      i2 = 0;
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 2002: 
    case 2003: 
    default: 
      return;
    case 2004: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "processType" + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        b((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        c((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 2003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcResponseMsgReadedReport)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(String paramString1, String paramString2, msg_comm.Msg paramMsg, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.C2CMessageProcessor", 2, "decodePreSendMsgPackage  presendShowTime : " + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    paramString1 = new DecodeProtoPkgContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), Long.parseLong(paramString1), false, false, false, false);
    msg_comm.MsgHead localMsgHead = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (paramInt > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.C2CMessageProcessor", 2, "presendShowTime:" + paramInt);
      }
      localMsgHead.msg_time.set(paramInt);
    }
    paramString1 = a(paramMsg, paramString1);
    if ((paramString1 != null) && (paramString1.size() > 0) && (((MessageRecord)paramString1.get(0)).istroop == 1008)) {
      paramString1 = ((LifeOnlineAccountInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(82)).a(paramString1);
    }
    for (;;)
    {
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext())
      {
        paramMsg = (MessageRecord)paramString1.next();
        try
        {
          if (a(paramMsg, true)) {
            continue;
          }
          localArrayList.add(paramMsg);
        }
        catch (Exception paramMsg) {}
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.C2CMessageProcessor", 2, "decodeC2CMessage error,", paramMsg);
        }
      }
      boolean bool2;
      boolean bool3;
      if (localArrayList.size() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList);
        bool2 = MessageHandlerUtils.a(localArrayList);
        bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
        paramInt = MsgProxyUtils.a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
          break label353;
        }
      }
      label353:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramString1.a(localArrayList, paramString2, bool1);
        a(localArrayList);
        a("handleGetBuddyMessageResp", true, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
        return;
      }
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -3006) || (localMessageRecord.msgtype == -5004))
      {
        PAMessage localPAMessage = XMLMessageUtils.a(localMessageRecord);
        if ((localPAMessage != null) && (localPAMessage.mMsgId > 0L)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localMessageRecord.frienduin, "mp_msg_sys_15", "msg_get", 0, 1, 0, Long.toString(localPAMessage.mMsgId), "", "", "");
        }
        if (WidgetConstants.a(localMessageRecord.frienduin, 1008)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    label551:
    label1581:
    for (;;)
    {
      return;
      if ((!UserguideActivity.a(BaseApplicationImpl.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) && (NoDisturbUtil.a(BaseApplicationImpl.a().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
      {
        Object localObject1 = paramArrayList.iterator();
        Object localObject2;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
        } while ((!MsgProxyUtils.p(((MessageRecord)localObject2).istroop)) || (!MsgProxyUtils.b((MessageRecord)localObject2)) || (((MessageRecord)localObject2).isSend()) || (((MessageRecord)localObject2).isread));
        for (int k = 1;; k = 0)
        {
          if (k == 0) {
            break label1581;
          }
          localObject1 = ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject1 == null)
          {
            if (!QLog.isColorLevel()) {
              break label1573;
            }
            QLog.d("Q.msg.C2CMessageProcessor", 2, "findFriendCardByUin card is null");
            k = 1;
          }
          for (;;)
          {
            localObject2 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            localObject2 = ((String)localObject2).split("\\|");
            localObject1 = ((String)localObject1).split("\\|");
            if ((localObject2.length >= 4) && (localObject1.length >= 4))
            {
              jdField_b_of_type_Int = Integer.parseInt(localObject2[0]);
              jdField_c_of_type_Int = Integer.parseInt(localObject2[1]);
              f = Integer.parseInt(localObject1[0]);
              g = Integer.parseInt(localObject1[1]);
            }
            SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "OneWayMsgRecentUinList", 0);
            localObject1 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgDateRecentUinList", "");
            localObject2 = ((String)localObject1).split("\\|");
            this.jdField_a_of_type_JavaUtilHashSet.clear();
            int n = localObject2.length;
            int m = 0;
            for (;;)
            {
              if (m < n)
              {
                localObject3 = localObject2[m];
                if ((((String)localObject3).length() > 0) && (Long.parseLong((String)localObject3) > 0L)) {
                  this.jdField_a_of_type_JavaUtilHashSet.add(localObject3);
                }
                m += 1;
                continue;
                k = ((Card)localObject1).shGender;
                break;
              }
            }
            localObject2 = localSharedPreferences.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgLBSFriendRecentUinList", "");
            Object localObject3 = ((String)localObject2).split("\\|");
            this.jdField_b_of_type_JavaUtilHashSet.clear();
            n = localObject3.length;
            m = 0;
            Object localObject4;
            while (m < n)
            {
              localObject4 = localObject3[m];
              if ((((String)localObject4).length() > 0) && (Long.parseLong((String)localObject4) > 0L)) {
                this.jdField_b_of_type_JavaUtilHashSet.add(localObject4);
              }
              m += 1;
            }
            localObject3 = paramArrayList.iterator();
            paramArrayList = (ArrayList)localObject2;
            for (;;)
            {
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (MessageRecord)((Iterator)localObject3).next();
                if ((a((MessageRecord)localObject4)) && (localQQMessageFacade != null)) {
                  if (k == 0)
                  {
                    if (((MessageRecord)localObject4).istroop == 1010)
                    {
                      localObject2 = localObject1;
                      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(((MessageRecord)localObject4).frienduin))
                      {
                        this.jdField_a_of_type_JavaUtilHashSet.add(((MessageRecord)localObject4).frienduin);
                        if (((String)localObject1).length() != 0) {
                          break label807;
                        }
                      }
                      for (localObject1 = ((MessageRecord)localObject4).frienduin;; localObject1 = (String)localObject1 + "|" + ((MessageRecord)localObject4).frienduin)
                      {
                        localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgDateRecentUinList", (String)localObject1);
                        localSharedPreferences.edit().commit();
                        localObject2 = localObject1;
                        d = this.jdField_a_of_type_JavaUtilHashSet.size();
                        localObject1 = localObject2;
                        if (d % jdField_b_of_type_Int != 0) {
                          break;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((MessageRecord)localObject4, paramBoolean);
                        this.jdField_a_of_type_JavaUtilHashSet.clear();
                        localSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgDateRecentUinList");
                        localSharedPreferences.edit().commit();
                        localObject1 = localObject2;
                        break;
                      }
                    }
                    if (((MessageRecord)localObject4).istroop == 1001)
                    {
                      localObject2 = paramArrayList;
                      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(((MessageRecord)localObject4).frienduin))
                      {
                        this.jdField_b_of_type_JavaUtilHashSet.add(((MessageRecord)localObject4).frienduin);
                        if (paramArrayList.length() != 0) {
                          break label1050;
                        }
                      }
                      for (paramArrayList = ((MessageRecord)localObject4).frienduin;; paramArrayList = paramArrayList + "|" + ((MessageRecord)localObject4).frienduin)
                      {
                        localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgLBSFriendRecentUinList", paramArrayList);
                        localSharedPreferences.edit().commit();
                        localObject2 = paramArrayList;
                        h = this.jdField_b_of_type_JavaUtilHashSet.size();
                        paramArrayList = (ArrayList)localObject2;
                        if (h % f != 0) {
                          break;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((MessageRecord)localObject4, paramBoolean);
                        this.jdField_b_of_type_JavaUtilHashSet.clear();
                        localSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgLBSFriendRecentUinList");
                        localSharedPreferences.edit().commit();
                        paramArrayList = (ArrayList)localObject2;
                        break;
                      }
                    }
                  }
                  else
                  {
                    if (((MessageRecord)localObject4).istroop == 1010)
                    {
                      localObject2 = localObject1;
                      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(((MessageRecord)localObject4).frienduin))
                      {
                        this.jdField_a_of_type_JavaUtilHashSet.add(((MessageRecord)localObject4).frienduin);
                        if (((String)localObject1).length() != 0) {
                          break label1298;
                        }
                      }
                      for (localObject1 = ((MessageRecord)localObject4).frienduin;; localObject1 = (String)localObject1 + "|" + ((MessageRecord)localObject4).frienduin)
                      {
                        localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgDateRecentUinList", (String)localObject1);
                        localSharedPreferences.edit().commit();
                        localObject2 = localObject1;
                        e = this.jdField_a_of_type_JavaUtilHashSet.size();
                        localObject1 = localObject2;
                        if (e % jdField_c_of_type_Int != 0) {
                          break;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((MessageRecord)localObject4, paramBoolean);
                        this.jdField_a_of_type_JavaUtilHashSet.clear();
                        localSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgDateRecentUinList");
                        localSharedPreferences.edit().commit();
                        localObject1 = localObject2;
                        break;
                      }
                    }
                    if (((MessageRecord)localObject4).istroop == 1001)
                    {
                      localObject2 = paramArrayList;
                      if (!this.jdField_b_of_type_JavaUtilHashSet.contains(((MessageRecord)localObject4).frienduin))
                      {
                        this.jdField_b_of_type_JavaUtilHashSet.add(((MessageRecord)localObject4).frienduin);
                        if (paramArrayList.length() != 0) {
                          break label1541;
                        }
                      }
                    }
                  }
                }
              }
            }
            for (paramArrayList = ((MessageRecord)localObject4).frienduin;; paramArrayList = paramArrayList + "|" + ((MessageRecord)localObject4).frienduin)
            {
              localSharedPreferences.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgLBSFriendRecentUinList", paramArrayList);
              localSharedPreferences.edit().commit();
              localObject2 = paramArrayList;
              i = this.jdField_b_of_type_JavaUtilHashSet.size();
              paramArrayList = (ArrayList)localObject2;
              if (i % g != 0) {
                break label551;
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a((MessageRecord)localObject4, paramBoolean);
              this.jdField_b_of_type_JavaUtilHashSet.clear();
              localSharedPreferences.edit().remove(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() + "_OneWayMsgLBSFriendRecentUinList");
              localSharedPreferences.edit().commit();
              paramArrayList = (ArrayList)localObject2;
              break label551;
              break;
            }
            k = 1;
          }
        }
      }
    }
  }
  
  public void a(List paramList, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = Utils.a(paramMsg, 0);
    int k = paramMsg[4];
    long l2 = Utils.a(paramMsg, 5);
    k = paramMsg[9];
    long l3 = Utils.a(paramMsg, 10);
    int m = paramMsg[14];
    try
    {
      new String(paramMsg, 15, m, "GBK");
      if (!paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, k, String.valueOf(l2), String.valueOf(l3), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        paramMsg = new ArrayList();
        paramMsg.add(new UinPairReadInfo(paramList.from_uin.get(), paramList.msg_time.get(), 0L, null));
        ((C2CMessageProcessor)this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a("c2c_processor")).b(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, m);
      }
    }
  }
  
  public void a(msg_comm.Msg paramMsg, int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    if ((paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    do
    {
      byte[] arrayOfByte1;
      Object localObject;
      int k;
      do
      {
        do
        {
          do
          {
            return;
            arrayOfByte1 = paramMsg.msg_body.msg_content.get().toByteArray();
            localObject = new byte[arrayOfByte1.length];
            PkgTools.a((byte[])localObject, 0, arrayOfByte1, 0, localObject.length);
          } while (localObject.length < 5);
          k = localObject[4];
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.C2CMessageProcessor", 2, "<---hotchat and opentroop push  groupCode:" + PkgTools.a(arrayOfByte1, 0) + " subType:" + k);
          }
          if ((k != 12) && (k != 14)) {
            break;
          }
        } while (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a((byte[])localObject, paramInt1));
        return;
      } while (k != 16);
      if (arrayOfByte1.length > 7)
      {
        localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length - 7];
        PkgTools.a(arrayOfByte2, 0, arrayOfByte1, 7, arrayOfByte2.length);
        ((TroopTipsMsgMgr)localObject).a(arrayOfByte2, paramInt1, paramMsg.msg_head.msg_time.get(), true);
      }
      MessageProtoCodec.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramLong1, paramInt1, paramLong2, paramInt2);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.C2CMessageProcessor", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%f, seq:%f, msgUid:%f, msgType:%d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Long.valueOf(paramLong2), Integer.valueOf(paramInt2) }));
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 33;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 1010) && (paramMessageRecord.istroop != 1001)) {}
    while (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) || ((paramMessageRecord.istroop == 1001) && (paramMessageRecord.msgtype == -3001))) {
      return false;
    }
    return true;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread) || ((MsgProxyUtils.b(localMessageRecord)) && (!MsgProxyUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord))) || (localMessageRecord.istroop == 7100));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    switch (paramInt)
    {
    case 2002: 
    case 2003: 
    default: 
      return;
    case 2004: 
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void b(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    a(true, false, false, 0L, new hsq(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageProcessor
 * JD-Core Version:    0.7.0.1
 */