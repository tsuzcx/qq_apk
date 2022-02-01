package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr.LocationInfo;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.OpenTroopInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class MessageHandlerUtils
{
  public static final String a = "Q.msg.MessageHandlerUtils";
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramQQAppInterface.getLongAccountUin();
    if (paramLong1 == l) {
      return paramLong2;
    }
    if (paramLong2 == l) {
      return paramLong1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandlerUtils", 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
    }
    return paramLong3;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      return 0L;
    }
    return ((paramArrayOfByte[0] & 0xFF) << 24) + ((paramArrayOfByte[1] & 0xFF) << 16) + ((paramArrayOfByte[2] & 0xFF) << 8) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = paramQQAppInterface.a();
    if ((str != null) && (str.equals(paramString1))) {
      return "你";
    }
    paramString2 = ContactUtils.a(paramQQAppInterface, paramString1, paramString2, 1, 0);
    if (paramString2 == paramString1)
    {
      paramQQAppInterface = ((FriendManager)paramQQAppInterface.getManager(8)).c(paramString1);
      if (paramQQAppInterface != null) {
        return ContactUtils.a(paramQQAppInterface);
      }
    }
    return paramString2;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    im_msg_body.RichText localRichText = null;
    int j = 0;
    int i;
    if (paramMessageRecord.msgtype == -1000)
    {
      localRichText = MessageProtoCodec.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
    }
    while (localRichText == null)
    {
      return null;
      if (paramMessageRecord.msgtype == -2000)
      {
        localRichText = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == -2002)
      {
        localRichText = MessageProtoCodec.a((MessageForPtt)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == -2007)
      {
        localRichText = MessageProtoCodec.a((MessageForMarketFace)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == -2011)
      {
        localRichText = MessageProtoCodec.a((MessageForStructing)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == -2010)
      {
        localRichText = MessageProtoCodec.a((MessageForFunnyFace)paramMessageRecord);
        i = j;
      }
      else if (paramMessageRecord.msgtype == -2020)
      {
        localRichText = MessageProtoCodec.a((MessageForShakeWindow)paramMessageRecord);
        i = j;
      }
      else
      {
        i = j;
        if (paramMessageRecord.msgtype == -2022)
        {
          localRichText = MessageProtoCodec.a((MessageForShortVideo)paramMessageRecord);
          i = j;
        }
      }
    }
    if (AnonymousChatHelper.a(paramMessageRecord))
    {
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.AnonymousGroupMsg();
      localObject3 = AnonymousChatHelper.a(paramMessageRecord);
      ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_flags.set(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_a_of_type_JavaLangString)) {
        ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_id.set(ByteStringMicro.copyFrom(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_a_of_type_JavaLangString.getBytes()));
      }
      if (!TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_b_of_type_JavaLangString)) {
        ((im_msg_body.AnonymousGroupMsg)localObject2).str_anon_nick.set(ByteStringMicro.copyFrom(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_b_of_type_JavaLangString.getBytes()));
      }
      ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_head_portrait.set(((AnonymousChatHelper.AnonymousExtInfo)localObject3).jdField_b_of_type_Int);
      ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_expire_time.set(((AnonymousChatHelper.AnonymousExtInfo)localObject3).c);
      ((im_msg_body.AnonymousGroupMsg)localObject2).uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
      ((im_msg_body.Elem)localObject1).anon_group_msg.set((MessageMicro)localObject2);
      localRichText.elems.add((MessageMicro)localObject1);
    }
    Card localCard;
    label458:
    label478:
    do
    {
      do
      {
        return MessageProtoCodec.a(paramQQAppInterface, MessageProtoCodec.b(paramMessageRecord.istroop), paramMessageRecord, localRichText, null, i);
      } while (paramMessageRecord.istroop != 1);
      localObject1 = (FriendsManagerImp)paramQQAppInterface.getManager(8);
      localObject3 = ((FriendsManagerImp)localObject1).a(paramMessageRecord.frienduin);
      if (localObject3 != null)
      {
        localObject2 = new im_msg_body.PubGroup();
        localCard = ((FriendsManagerImp)localObject1).a(paramQQAppInterface.a());
        PBUInt32Field localPBUInt32Field = ((im_msg_body.PubGroup)localObject2).uint32_age;
        if (localCard != null) {
          break;
        }
        j = 0;
        localPBUInt32Field.set(j);
        localPBUInt32Field = ((im_msg_body.PubGroup)localObject2).uint32_gender;
        if (localCard != null) {
          break label796;
        }
        j = 2;
        localPBUInt32Field.set(j);
        ((im_msg_body.PubGroup)localObject2).uint32_distance.set(((OpenTroopInfo)localObject3).troopDistance);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).pub_group.set((MessageMicro)localObject2);
        localRichText.elems.add((MessageMicro)localObject3);
      }
      long l2 = 1L;
      long l1 = 1L;
      if ((!TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface).booleanValue()) && (!TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface))) {
        break label805;
      }
      j = 1;
      if (TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface).booleanValue())
      {
        localObject2 = TroopMemberLbsHelper.a(paramQQAppInterface);
        l2 = ((LbsInfoMgr.LocationInfo)localObject2).a;
        l1 = ((LbsInfoMgr.LocationInfo)localObject2).b;
      }
      if (TroopMemberLbsHelper.a(paramMessageRecord.frienduin, paramQQAppInterface)) {
        TroopMemberLbsHelper.c(paramMessageRecord.frienduin, paramQQAppInterface);
      }
      if (j != 0)
      {
        localObject2 = new im_msg_body.ElemFlags2();
        ((im_msg_body.ElemFlags2)localObject2).uint32_longtitude.set((int)l2);
        ((im_msg_body.ElemFlags2)localObject2).uint32_latitude.set((int)l1);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).elem_flags2.set((MessageMicro)localObject2);
        localRichText.elems.add((MessageMicro)localObject3);
      }
    } while (((HotChatManager)paramQQAppInterface.getManager(58)).a(paramMessageRecord.frienduin) == null);
    label559:
    Object localObject2 = new im_msg_body.PubGroup();
    Object localObject1 = ((FriendsManagerImp)localObject1).a(paramQQAppInterface.a());
    Object localObject3 = ((im_msg_body.PubGroup)localObject2).uint32_age;
    if (localObject1 == null)
    {
      j = 0;
      label729:
      ((PBUInt32Field)localObject3).set(j);
      localObject3 = ((im_msg_body.PubGroup)localObject2).uint32_gender;
      if (localObject1 != null) {
        break label819;
      }
    }
    label796:
    label805:
    label819:
    for (j = 2;; j = ((Card)localObject1).shGender)
    {
      ((PBUInt32Field)localObject3).set(j);
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).pub_group.set((MessageMicro)localObject2);
      localRichText.elems.add((MessageMicro)localObject1);
      break;
      j = localCard.age;
      break label458;
      j = localCard.shGender;
      break label478;
      j = 0;
      break label559;
      j = ((Card)localObject1).age;
      break label729;
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, "<" + paramString2 + paramLong);
      paramString3 = paramLong + "|" + paramString3 + "|" + paramString4;
      if (paramString2 != null) {
        QLog.d(paramString1, 2, paramString2 + paramString3);
      }
    }
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (MessageUtils.a(localMessageRecord)) {
        if (((i <= 0) || (((MessageRecord)paramList.get(i - 1)).shmsgseq != localMessageRecord.shmsgseq)) && ((i >= paramList.size() - 1) || (((MessageRecord)paramList.get(i + 1)).shmsgseq != localMessageRecord.shmsgseq))) {
          break label141;
        }
      }
      label141:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localArrayList.add(localMessageRecord);
        }
        i += 1;
        break;
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.a().a(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (paramQQAppInterface != null) {
        break label183;
      }
    }
    label183:
    for (paramInt = 0;; paramInt = paramQQAppInterface.size())
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramInt);
      boolean bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (paramQQAppInterface.size() > 0)
        {
          paramQQAppInterface = paramQQAppInterface.iterator();
          do
          {
            bool1 = bool2;
            if (!paramQQAppInterface.hasNext()) {
              break;
            }
            paramString1 = (MessageRecord)paramQQAppInterface.next();
          } while ((Math.abs(paramString1.time - paramLong1) >= 30L) || (paramString1.shmsgseq != paramLong2) || (!paramString1.senderuin.equals(paramString2)));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandlerUtils", 2, "------->msgFilter-duplicated msg.");
          }
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent());
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int j;
      int i;
      if (paramQQAppInterface == null)
      {
        j = 0;
        if (j <= 15) {
          break label289;
        }
        i = j - 15;
      }
      for (;;)
      {
        if (i >= j) {
          break label301;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.get(i);
        if ((localMessageRecord != null) && (localMessageRecord.msgtype == paramMessageRecord.msgtype) && (Utils.a(localMessageRecord.msg, paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
          return true;
          j = paramQQAppInterface.size();
          break;
          label289:
          i = 0;
          continue;
        }
        i += 1;
      }
      label301:
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent()).append(" isNormalMsg: ").append(paramBoolean);
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000))
      {
        if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
          paramQQAppInterface = paramQQAppInterface.iterator();
        }
      }
      else {
        while (paramQQAppInterface.hasNext()) {
          if (MsgProxyUtils.a((MessageRecord)paramQQAppInterface.next(), paramMessageRecord, false, paramBoolean))
          {
            if ((QLog.isColorLevel()) && (localStringBuilder != null))
            {
              localStringBuilder.append(" filterType: troop msg isNormalMsg=" + paramBoolean);
              QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
            }
            MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
            return true;
            if (MsgProxyUtils.c(paramMessageRecord.istroop))
            {
              if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
              {
                paramQQAppInterface = paramQQAppInterface.iterator();
                do
                {
                  if (!paramQQAppInterface.hasNext()) {
                    break;
                  }
                } while (!MsgProxyUtils.a((MessageRecord)paramQQAppInterface.next(), paramMessageRecord, paramBoolean));
                if ((QLog.isColorLevel()) && (localStringBuilder != null))
                {
                  localStringBuilder.append(" filterType: " + paramMessageRecord.istroop);
                  QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
                }
                MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
                return true;
              }
            }
            else if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
            {
              paramQQAppInterface = paramQQAppInterface.iterator();
              while (paramQQAppInterface.hasNext())
              {
                MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.next();
                if ((localMessageRecord.time == paramMessageRecord.time) && (localMessageRecord.msg.equals(paramMessageRecord.msg)))
                {
                  if ((QLog.isColorLevel()) && (localStringBuilder != null))
                  {
                    localStringBuilder.append(" filterType: other");
                    QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
                  }
                  MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
                  return true;
                }
              }
            }
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.a().h(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList)
  {
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
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
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return null;
    }
    String[] arrayOfString = new String[7];
    long l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
    long l5 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
    long l8 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
    long l3 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
    long l4 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
    long l2 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
    long l7 = System.currentTimeMillis();
    arrayOfString[1] = String.valueOf(l7 - l1);
    arrayOfString[2] = String.valueOf(l3 - l8);
    arrayOfString[3] = String.valueOf(l8 - l1);
    arrayOfString[4] = String.valueOf(l7 - l3);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handler");
    if (l6 != 0L)
    {
      paramToServiceMsg.append("|").append(String.valueOf(l6 - l1)).append("|app");
      l1 = l6;
    }
    for (;;)
    {
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|").append(String.valueOf(l5 - l1)).append("|msf");
        l1 = l5;
      }
      for (;;)
      {
        if (l8 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l8 - l1)).append("|net");
        }
        arrayOfString[5] = paramToServiceMsg.toString();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("net");
        if (l4 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l4 - l3)).append("|msf");
        }
        for (l1 = l4;; l1 = l3)
        {
          if (l2 != 0L)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l2 - l1)).append("|app");
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l7 - l1)).append("|handler");
            arrayOfString[6] = paramToServiceMsg.toString();
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("{");
            paramToServiceMsg.append("total:").append(arrayOfString[1]).append(",");
            paramToServiceMsg.append("net:").append(arrayOfString[2]).append(",");
            paramToServiceMsg.append("send:").append(arrayOfString[3]).append(",");
            paramToServiceMsg.append("recv:").append(arrayOfString[4]).append(",");
            paramToServiceMsg.append("sendDetail:").append(arrayOfString[5]).append(",");
            paramToServiceMsg.append("recvDetail:").append(arrayOfString[6]);
            paramToServiceMsg.append("}");
            arrayOfString[0] = paramToServiceMsg.toString();
            return arrayOfString;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtils
 * JD-Core Version:    0.7.0.1
 */