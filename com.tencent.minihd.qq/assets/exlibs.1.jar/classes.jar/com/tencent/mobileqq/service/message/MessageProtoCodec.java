package com.tencent.mobileqq.service.message;

import IMMsgBodyPack.SlaveMasterMsg;
import MessageSvcPack.UinPairReadInfo;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QPayHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.message.C2CMessageProcessor;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QlinkServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Inflater;
import jvg;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgcomm.msg_comm.PluginInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.BsnsTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import msf.msgsvc.msg_svc.WPATmp;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TmpPtt;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.FanpaiziNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class MessageProtoCodec
{
  public static final int a = 30;
  private static final long jdField_a_of_type_Long = 4294967295L;
  private static final String jdField_a_of_type_JavaLangString = "Q.msg.MessageHandler";
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    default: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
    case 8: 
      return 1008;
    case 10: 
      return 1006;
    case 5: 
      return 1004;
    case 11: 
      return 1009;
    case 12: 
      return 1001;
    case 4: 
      return 3000;
    case 2: 
      return 1;
    case 14: 
      return 1020;
    case 16: 
      return 1021;
    case 17: 
      return 1022;
    case 18: 
      return 1023;
    case 15: 
      return 1024;
    case 19: 
      return 1010;
    }
    return 7100;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_ptt_change_bit.has())) {
        if (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_ptt_change_bit.get() == 1) {
          return 1;
        }
      }
    }
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int j = 0;
    int i = 0;
    label30:
    Object localObject;
    if (k < paramString.length())
    {
      if (paramArrayList == null) {
        break label454;
      }
      if (j >= paramArrayList.size()) {
        break label448;
      }
      localObject = (MessageForText.AtTroopMemberInfo)paramArrayList.get(j);
      if ((localObject == null) || (!((MessageForText.AtTroopMemberInfo)localObject).isValid())) {}
    }
    for (;;)
    {
      int m;
      im_msg_body.Elem localElem;
      if ((localObject != null) && (((MessageForText.AtTroopMemberInfo)localObject).startPos <= k))
      {
        m = i;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = i + 1;
        }
        localElem = a(paramRichText, paramString.substring(((MessageForText.AtTroopMemberInfo)localObject).startPos, ((MessageForText.AtTroopMemberInfo)localObject).startPos + ((MessageForText.AtTroopMemberInfo)localObject).textLen));
        ((MessageForText.AtTroopMemberInfo)localObject).startPos = 0;
        a((MessageForText.AtTroopMemberInfo)localObject, localElem);
        localStringBuilder.delete(0, localStringBuilder.length());
        i = m + 1;
        m = ((MessageForText.AtTroopMemberInfo)localObject).textLen;
        j += 1;
        k += m - 1;
      }
      for (;;)
      {
        k += 1;
        break;
        j += 1;
        break label30;
        if (paramString.charAt(k) == '\024')
        {
          m = i;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            localStringBuilder.delete(0, localStringBuilder.length());
            m = i + 1;
          }
          int i1 = paramString.charAt(k + 1);
          int n = k;
          i = m;
          if (i1 >= 0)
          {
            n = k;
            i = m;
            if (i1 < MessageUtils.a.length)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + MessageUtils.a[i1]);
              }
              localObject = new im_msg_body.Face();
              ((im_msg_body.Face)localObject).index.set(MessageUtils.a[i1]);
              localElem = new im_msg_body.Elem();
              localElem.face.set((MessageMicro)localObject);
              paramRichText.elems.add(localElem);
              i = m + 1;
              n = k + 1;
            }
          }
          k = n;
        }
        else
        {
          localStringBuilder.append(paramString.charAt(k));
        }
      }
      j = i;
      if (localStringBuilder.length() > 0)
      {
        a(paramRichText, localStringBuilder.toString());
        j = i + 1;
      }
      return j;
      label448:
      localObject = null;
      continue;
      label454:
      localObject = null;
    }
  }
  
  public static long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    long l3 = Long.valueOf(paramMessageHandler.a.a()).longValue();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = PkgTools.a(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(l3, i, arrayOfByte, l4, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return l1;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    do
    {
      do
      {
        return l1;
        paramMsg = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
      } while (!paramMsg.bytes_reserve.has());
      paramMsg = paramMsg.bytes_reserve.get().toByteArray();
    } while ((paramMsg == null) || (paramMsg.length <= 1));
    int i = paramMsg[0];
    i = 1;
    while (i < paramMsg.length - 1)
    {
      int j = paramMsg[i];
      int k = i + 1;
      i = PkgTools.a(paramMsg, k);
      k += 2;
      long l2 = l1;
      if (j == 3)
      {
        byte[] arrayOfByte = new byte[i];
        PkgTools.a(arrayOfByte, 0, paramMsg, k, i);
        long l3 = PkgTools.a(arrayOfByte, 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "--->decodeC2CMsgPkg_msgTime PTT_ROAM : TimeStamp in d0 :" + l1);
        }
        l2 = l1;
        if (l3 > 0L) {
          l2 = l3;
        }
      }
      i = k + i;
      l1 = l2;
    }
    return l1;
  }
  
  public static Pair a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    Object localObject;
    long l1;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      label151:
      if (l1 == 4294967295L) {}
      for (long l2 = paramMessageHandler.a.a().a(paramString1, paramString2);; l2 = -1L)
      {
        return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        if (!((im_msg_body.Elem)localObject).secret_file.has()) {
          break;
        }
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((!((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) || (!((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has())) {
          break;
        }
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
        break label151;
      }
      l1 = -1L;
    }
  }
  
  public static MessageRecord a(List paramList, byte[] paramArrayOfByte)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      if (((MessageRecord)localObject).msgtype == -1000) {
        localElem.textMsg.set(((MessageRecord)localObject).msg);
      }
      for (;;)
      {
        localMsg.elems.get().add(localElem);
        break;
        if (((MessageRecord)localObject).msgtype == -2000)
        {
          RichMsg.PicRec localPicRec = new RichMsg.PicRec();
          try
          {
            localObject = (RichMsg.PicRec)localPicRec.mergeFrom(((MessageRecord)localObject).msgData);
            localElem.picMsg.set((MessageMicro)localObject);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  private static PAMessage a(String paramString)
  {
    paramString = PAMessageUtil.a(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static MessageDecContent a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.a.a();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "recv roam online msg, return null!");
        }
        return null;
      }
      localObject = paramMessageHandler.a.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((OnlineFileSessionInfo)localObject).c)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.a.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.a.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label634;
          }
          if (!paramMessageHandler.a.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.a.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2);
        }
      }
    }
    label634:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      localTempSessionInfo.jdField_c_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label228:
        localTempSessionInfo.jdField_b_of_type_Int = i;
        localTempSessionInfo.jdField_b_of_type_Long = -1L;
        localTempSessionInfo.jdField_c_of_type_Long = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append("direction_flag:").append(localTempSessionInfo.jdField_c_of_type_Int).append(" info:").append(localTempSessionInfo.toString());
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return localTempSessionInfo;
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label228;
      i = 1004;
      break label228;
      i = 1024;
      if ((!BmqqSegmentUtil.b(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.b(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label228;
      }
      i = 1025;
      break label228;
      i = 1005;
      break label228;
      i = 1008;
      break label228;
      i = 1006;
      break label228;
      i = 1009;
      break label228;
      i = 1001;
      break label228;
      i = 1020;
      break label228;
      i = 1021;
      break label228;
      i = 1022;
      break label228;
      i = 1023;
      break label228;
      i = 1010;
      break label228;
      i = 7100;
      break label228;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_uin.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_code.get();
      continue;
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_c_of_type_Long = localC2CTmpMsgHead.group_uin.get();
    }
  }
  
  public static msg_svc.PbSendMsgReq a(MessageHandler paramMessageHandler, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    if (paramTransMsgContext == null) {
      paramMessageHandler = null;
    }
    do
    {
      return paramMessageHandler;
      int i = (short)(int)paramLong;
      int j = 0xFFFF & i;
      long l = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createTempSessionSendMsgReq: routingType:13,toUin:" + paramString + ",msgUid:" + (0x0 | l << 16 | 0xA6) + ",msgSeq:" + paramLong + ",uint32Seq:" + j + ",shortSeq:" + i + ",randomNum:" + paramInt3 + ",msgContext:" + paramTransMsgContext);
      }
      paramMessageHandler = paramMessageHandler.a.a();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      Object localObject = new msg_svc.Trans0x211();
      ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
      if (paramArrayOfByte != null) {
        ((msg_svc.Trans0x211)localObject).sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((msg_svc.Trans0x211)localObject).c2c_type.set(paramInt1);
      ((msg_svc.Trans0x211)localObject).service_type.set(paramInt2);
      localRoutingHead.trans_0x211.set((MessageMicro)localObject);
      paramArrayOfByte = new msg_comm.ContentHead();
      paramArrayOfByte.pkg_num.set(1);
      paramArrayOfByte.div_seq.set(i);
      paramArrayOfByte.pkg_index.set(0);
      localObject = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject).msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set(paramArrayOfByte);
      paramString.msg_body.set((MessageMicro)localObject);
      paramString.msg_seq.set(j);
      paramString.msg_rand.set(paramInt3);
      paramArrayOfByte = paramMessageHandler.a();
      paramMessageHandler = paramString;
    } while (paramArrayOfByte == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, msg_comm.AppShareInfo paramAppShareInfo, int paramInt2)
  {
    if ((paramInt1 == 9) || (paramInt1 == 13) || (paramMessageRecord == null)) {
      return null;
    }
    long l = paramMessageRecord.msgUid;
    int k = (short)(int)paramMessageRecord.msgseq;
    int m = MessageUtils.a(l);
    MessageCache localMessageCache = paramQQAppInterface.a();
    msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
    int j = 0;
    int i = j;
    switch (paramInt1)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      paramQQAppInterface = new msg_svc.C2C();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.c2c.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.GrpTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.grp_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.Dis();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.DisTmp();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.dis_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.b(paramMessageRecord.frienduin);
      Object localObject = new msg_svc.WPATmp();
      ((msg_svc.WPATmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      byte[] arrayOfByte;
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.WPATmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.wpa_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.c(paramMessageRecord.frienduin);
      localObject = new msg_svc.QQQueryBusinessTmp();
      ((msg_svc.QQQueryBusinessTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(arrayOfByte) + ",length:" + arrayOfByte.length);
        }
        ((msg_svc.QQQueryBusinessTmp)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.qq_querybusiness_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      localObject = localMessageCache.d(paramMessageRecord.frienduin);
      paramQQAppInterface = new msg_svc.BusinessWPATmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sig:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localObject = localMessageCache.e(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sigt:" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sigt.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.business_wpa_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.AddressListTmp();
      paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
      paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
      localObject = localMessageCache.f(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.address_list.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = localMessageCache.a(paramMessageRecord.frienduin);
      localObject = new msg_svc.PublicPlat();
      ((msg_svc.PublicPlat)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        arrayOfByte = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(arrayOfByte, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        ((msg_svc.PublicPlat)localObject).sig.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      localRoutingHead.public_plat.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.RichStatusTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.j(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.rich_status_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      localObject = new msg_svc.AccostTmp();
      ((msg_svc.AccostTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      ((msg_svc.AccostTmp)localObject).reply.set(paramQQAppInterface.hasReply);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "LBSFriend------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = localMessageCache.k(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.AccostTmp)localObject).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      localRoutingHead.accost_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.PubGroupTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localRoutingHead.pub_group_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.BsnsTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.g(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "circleGroup------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.bsns_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.AuthTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.i(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "friendValidation------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.auth_tmp.set(paramQQAppInterface);
      i = 1;
      continue;
      localObject = new msg_svc.NearByDatingTmp();
      ((msg_svc.NearByDatingTmp)localObject).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1010);
      ((msg_svc.NearByDatingTmp)localObject).reply.set(paramQQAppInterface.hasReply);
      paramQQAppInterface = localMessageCache.m(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_dating", 4, "发送附近人约会临时会话消息 有keyNearbyDating------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.NearByDatingTmp)localObject).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      localRoutingHead.nearby_dating_tmp.set((MessageMicro)localObject);
      i = 1;
      continue;
      paramQQAppInterface = new msg_svc.NearByAssistantTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      localObject = localMessageCache.l(paramMessageRecord.frienduin);
      if (localObject != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_assistant", 4, "发送附近人助手临时会话消息 有NearbyAssistantKey------>" + HexUtil.a((byte[])localObject) + ",length:" + localObject.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject));
      }
      localRoutingHead.nearby_assistant_tmp.set(paramQQAppInterface);
      i = 1;
    }
    paramQQAppInterface = new msg_comm.ContentHead();
    paramQQAppInterface.pkg_num.set(paramMessageRecord.longMsgCount);
    paramQQAppInterface.div_seq.set(paramMessageRecord.longMsgId);
    paramQQAppInterface.pkg_index.set(paramMessageRecord.longMsgIndex);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramRichText);
    paramRichText = new msg_svc.PbSendMsgReq();
    paramRichText.routing_head.set(localRoutingHead);
    paramRichText.content_head.set(paramQQAppInterface);
    paramRichText.msg_body.set(paramMessageRecord);
    paramRichText.msg_seq.set(k & 0xFFFF);
    paramRichText.msg_rand.set(m);
    if ((paramInt1 != 2) && (paramInt1 != 4))
    {
      paramQQAppInterface = localMessageCache.a();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    if (paramAppShareInfo != null) {
      paramRichText.app_share.set(paramAppShareInfo);
    }
    paramRichText.msg_via.set(paramInt2);
    return paramRichText;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    if (paramTransMsgContext == null) {
      paramQQAppInterface = null;
    }
    label338:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x0 | paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramTransMsgContext);
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localRoutingHead = new msg_svc.RoutingHead();
        int i = 0;
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label338;
        }
        return null;
        l = 0x0 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramTransMsgContext = paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (paramTransMsgContext == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramTransMsgContext));
    return paramString;
  }
  
  private static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null)
    {
      if ((paramChatMessage instanceof MessageForPic)) {
        return ((MessageForPic)paramChatMessage).richText;
      }
      if ((paramChatMessage instanceof MessageForPtt)) {
        return ((MessageForPtt)paramChatMessage).richText;
      }
      if ((paramChatMessage instanceof MessageForShortVideo)) {
        return ((MessageForShortVideo)paramChatMessage).richText;
      }
    }
    return null;
  }
  
  public static im_msg_body.RichText a(FunnyFaceMessage paramFunnyFaceMessage)
  {
    im_msg_body.FunFace localFunFace = new im_msg_body.FunFace();
    Object localObject;
    if (paramFunnyFaceMessage.faceId == 1)
    {
      localObject = new im_msg_body.FunFace.Turntable();
      Iterator localIterator = paramFunnyFaceMessage.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((im_msg_body.FunFace.Turntable)localObject).rpt_uint64_uin_list.add(Long.valueOf(str));
      }
      ((im_msg_body.FunFace.Turntable)localObject).uint64_hit_uin.set(Long.valueOf(paramFunnyFaceMessage.turntable.hitUin).longValue());
      localFunFace.msg_turntable.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramFunnyFaceMessage = new im_msg_body.RichText();
      localObject = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject).fun_face.set(localFunFace);
      paramFunnyFaceMessage.elems.add((MessageMicro)localObject);
      return paramFunnyFaceMessage;
      if (paramFunnyFaceMessage.faceId == 2)
      {
        localObject = new im_msg_body.FunFace.Bomb();
        ((im_msg_body.FunFace.Bomb)localObject).bool_burst.set(paramFunnyFaceMessage.bomb.isBurst);
        localFunFace.msg_bomb.set((MessageMicro)localObject);
      }
    }
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    String str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]";
    boolean bool = true;
    if (paramMessageForMarketFace.istroop == 3000) {
      bool = false;
    }
    return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow == null) || (paramMessageForShakeWindow.mShakeWindowMsg == null)) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
    localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
    paramMessageForShakeWindow = new im_msg_body.Elem();
    paramMessageForShakeWindow.shake_window.set(localShakeWindow);
    localRichText.elems.add(paramMessageForShakeWindow);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    im_msg_body.RichText localRichText = null;
    Object localObject1 = localRichText;
    if (paramMessageForStructing != null)
    {
      if (paramMessageForStructing.structingMsg != null) {
        break label19;
      }
      localObject1 = localRichText;
    }
    label19:
    do
    {
      do
      {
        return localObject1;
        if (paramMessageForStructing.richText != null) {
          return paramMessageForStructing.richText;
        }
        localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
        localObject1 = localRichText;
      } while (localObject2 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject2));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      localRichText = new im_msg_body.RichText();
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).rich_msg.set((MessageMicro)localObject1);
      localRichText.elems.add((MessageMicro)localObject2);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      localObject1 = localRichText;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    localObject1 = new im_msg_body.Elem();
    Object localObject2 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    localRichText.elems.add((MessageMicro)localObject1);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList paramArrayList)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramString, paramArrayList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  private static void a(long paramLong1, long paramLong2, int paramInt) {}
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.a.a(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.a.a());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.a.a(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    for (;;)
    {
      return;
      msg_comm.MsgType0x210 localMsgType0x210 = new msg_comm.MsgType0x210();
      try
      {
        localMsgType0x210 = (msg_comm.MsgType0x210)localMsgType0x210.mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
        if (localMsgType0x210 == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException1);
          }
          localObject1 = null;
        }
        if ((!((msg_comm.MsgType0x210)localObject1).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject1).msg_content.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject1).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject1).msg_content.has());
          }
        }
        else
        {
          i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
          }
          switch (i)
          {
          }
        }
      }
    }
    return;
    a(paramMessageHandler, paramMsg, paramBoolean);
    return;
    ((ShieldListHandler)paramMessageHandler.a.a(17)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
    return;
    a(paramMessageHandler, (msg_comm.MsgType0x210)localObject1);
    return;
    ((SttManager)paramMessageHandler.a.getManager(16)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
    return;
    ((PublicAccountHandler)paramMessageHandler.a.a(10)).a(i, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.troopgetnews.", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
    }
    ((TroopHandler)paramMessageHandler.a.a(19)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    Object localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
    a(paramMessageHandler.a, (byte[])localObject1);
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
    }
    paramMessageHandler.a((msg_comm.MsgType0x210)localObject1, paramMsg);
    a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
    }
    String str;
    label1888:
    label1894:
    label1900:
    for (localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();; str = null) {
      for (;;)
      {
        try
        {
          localObject4 = new SubMsgType0x6b.MsgBody();
          ((SubMsgType0x6b.MsgBody)localObject4).mergeFrom((byte[])localObject1);
          paramLong = ((SubMsgType0x6b.MsgBody)localObject4).uint64_to_uin.get();
          if (!SettingCloneUtil.readValue(BaseApplicationImpl.a(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false))
          {
            if (!((SubMsgType0x6b.MsgBody)localObject4).bytes_tips_content.has()) {
              break label1900;
            }
            localObject1 = new String(((SubMsgType0x6b.MsgBody)localObject4).bytes_tips_content.get().toByteArray(), "utf-8");
            if (!((SubMsgType0x6b.MsgBody)localObject4).bytes_yes_text.has()) {
              break label1894;
            }
            localObject3 = new String(((SubMsgType0x6b.MsgBody)localObject4).bytes_yes_text.get().toByteArray(), "utf-8");
            if (!((SubMsgType0x6b.MsgBody)localObject4).bytes_no_text.has()) {
              break label1888;
            }
            localObject4 = new String(((SubMsgType0x6b.MsgBody)localObject4).bytes_no_text.get().toByteArray(), "utf-8");
            BaseApplicationImpl.a().a(Long.toString(paramLong), (String)localObject1, (String)localObject4, (String)localObject3);
            Intent localIntent = new Intent("mqq.intent.action.PCACTIVE_TIPS");
            localIntent.putExtra("uin", Long.toString(paramLong));
            localIntent.putExtra("Message", (String)localObject1);
            localIntent.putExtra("lButton", (String)localObject4);
            localIntent.putExtra("rButton", (String)localObject3);
            if (NotifyPCActiveActivity.a == null) {
              BaseApplicationImpl.a().startActivity(localIntent);
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
          continue;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
          continue;
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
        }
        if (localUnsupportedEncodingException.msg_content == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
          return;
        }
        Object localObject2 = localUnsupportedEncodingException.msg_content.get().toByteArray();
        if (localObject2 == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
          return;
        }
        do
        {
          try
          {
            localObject3 = new SubMsgType0x6f.MsgBody();
            ((SubMsgType0x6f.MsgBody)localObject3).mergeFrom((byte[])localObject2);
            localObject2 = (SubMsgType0x6f.ForwardBody)((SubMsgType0x6f.MsgBody)localObject3).rpt_msg_mod_infos.get().get(0);
            i = -1;
            if (((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.has()) {
              i = ((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.get();
            }
            if ((i != 2000) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_fanpanzi_notify.has())) {
              continue;
            }
            paramMessageHandler.a((SubMsgType0x6f.FanpaiziNotify)((SubMsgType0x6f.ForwardBody)localObject2).msg_fanpanzi_notify.get());
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
          catch (Exception paramMessageHandler) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMessageHandler);
          return;
        } while ((i != 2001) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.has()));
        Object localObject3 = (SubMsgType0x6f.MCardNotificationLike)((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.get();
        paramLong = 0L;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject3).str_wording.has()) {}
        for (localObject2 = ((SubMsgType0x6f.MCardNotificationLike)localObject3).str_wording.get();; str = "")
        {
          if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_new.has()) {}
          for (i = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_new.get();; i = 0)
          {
            if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint64_from_uin.has()) {
              paramLong = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint64_from_uin.get();
            }
            if (((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_total.has()) {
              j = ((SubMsgType0x6f.MCardNotificationLike)localObject3).uint32_counter_total.get();
            }
            if (QLog.isColorLevel()) {
              QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + (String)localObject2 + " totalCount: " + j + " newCount: " + i + " fromUin: " + paramLong);
            }
            localObject2 = (DatingManager)paramMessageHandler.a.getManager(67);
            if (localObject2 == null) {
              break;
            }
            ((DatingManager)localObject2).a().a((SubMsgType0x6f.MCardNotificationLike)localObject3);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("TurnBrand", 2, "decode recv msg0x210.Submsgtype0x6e");
            }
            localObject2 = (RecommendTroopManagerImp)paramMessageHandler.a.getManager(21);
            if (localObject2 != null) {
              ((RecommendTroopManagerImp)localObject2).a();
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
            }
            localObject3 = new submsgtype0x67.MsgBody();
            try
            {
              ((submsgtype0x67.MsgBody)localObject3).mergeFrom(((msg_comm.MsgType0x210)localObject2).msg_content.get().toByteArray());
              if (((submsgtype0x67.MsgBody)localObject3).rpt_msg_grpinfo.has())
              {
                localObject2 = ((submsgtype0x67.MsgBody)localObject3).rpt_msg_grpinfo.get();
                localObject3 = (LBSHandler)paramMessageHandler.a.a(3);
                if (localObject3 != null) {
                  ((LBSHandler)localObject3).b((List)localObject2);
                }
              }
              a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + localException2.toString());
                }
              }
            }
            ((QPayHandler)paramMessageHandler.a.a(49)).a(true);
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (a(paramMessageHandler.a, localException2.msg_content.get().toByteArray())) {
              paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
        }
        Object localObject4 = null;
        continue;
        localObject3 = null;
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject = new SubMsgType0x4.MsgBody();
    try
    {
      localObject = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
      if (!((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    localObject = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.get();
    ArrayList localArrayList = new ArrayList();
    msg_comm.Msg localMsg = new msg_comm.Msg();
    localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
    localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
    localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
    localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
    paramMessageHandler.a.a().a(paramMessageHandler, localArrayList, localMsg, (im_msg_body.NotOnlineFile)localObject, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, int paramInt, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
        localObject1 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject2).not_online_file.get();
        if (((im_msg_body.RichText)localObject2).not_online_file.has()) {
          break;
        }
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject2).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.has());
      } while (!QLog.isColorLevel());
      QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      return;
      if ((paramInt != 169) && (paramInt != 243)) {
        break;
      }
    } while (paramBoolean4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt + "]");
    }
    paramMessageHandler.a.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject1, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2);
    return;
    Object localObject2 = new String(((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.get().toStringUtf8() + l1);
    paramMsg = ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.get().toStringUtf8();
    localStringBuilder.append("     NotOnLineFile info : serverPath:").append(paramMsg).append(";fileKey :").append((String)localObject2).append(";");
    if (!paramMessageHandler.a().a((String)localObject2))
    {
      paramMessageHandler = ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.get().toStringUtf8();
      localStringBuilder.append("strFileName:").append(paramMessageHandler).append(";");
      paramLong1 = ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.get();
      if ((paramInt == 241) || (MessageUtils.a(paramMessageHandler, paramInt)))
      {
        paramMessageHandler = new RichMsg.PicRec();
        paramMessageHandler.localPath.set(paramMsg);
        paramMessageHandler.size.set(paramLong1);
        paramMessageHandler.type.set(1);
        paramMessageHandler.isRead.set(false);
        paramMessageHandler.uuid.set(paramMsg);
        paramMessageHandler.serverStorageSource.set("ftn");
        paramMessageHandler.version.set(5);
        paramMessageHandler.isReport.set(0);
        paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
        paramMsg.msgtype = -2000;
        paramMsg.msgData = paramMessageHandler.toByteArray();
        paramMsg.parse();
        paramList.add(paramMsg);
        paramMessageHandler = null;
      }
    }
    for (;;)
    {
      localStringBuilder.append("protocolStr:").append(paramMessageHandler).append(";");
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label1075;
        }
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        return;
        if ((paramInt != 242) && (!MessageUtils.b(paramMessageHandler, paramInt))) {
          break label1077;
        }
        if ((paramMessageHandler != null) && (!paramMessageHandler.equals("")))
        {
          if (!paramMessageHandler.contains("_")) {}
          for (paramMessageHandler = paramMessageHandler.substring(0, paramMessageHandler.length() - 4);; paramMessageHandler = paramMessageHandler.substring(paramMessageHandler.lastIndexOf("_") + 1, paramMessageHandler.length() - 4))
          {
            paramMessageHandler = l2 + paramMessageHandler;
            localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMessageHandler).append(";");
            if (paramBoolean4) {
              break label879;
            }
            if (!StreamDataManager.e(paramMessageHandler)) {
              break;
            }
            localStringBuilder.append("DuplicateKey:").append(paramMessageHandler).append(";");
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            StreamDataManager.d(paramMessageHandler);
            return;
          }
          StreamDataManager.c(paramMessageHandler);
        }
        for (;;)
        {
          label879:
          paramMessageHandler = TransfileUtile.a(paramMsg, paramLong1, 2, false, paramMsg, null, "ftn");
          localObject1 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject1).localPath.set(paramMsg);
          ((RichMsg.PttRec)localObject1).size.set(paramLong1);
          ((RichMsg.PttRec)localObject1).type.set(2);
          ((RichMsg.PttRec)localObject1).uuid.set(paramMsg);
          ((RichMsg.PttRec)localObject1).isRead.set(false);
          ((RichMsg.PttRec)localObject1).serverStorageSource.set("ftn");
          ((RichMsg.PttRec)localObject1).isReport.set(0);
          ((RichMsg.PttRec)localObject1).version.set(5);
          paramLong1 = System.currentTimeMillis() / 1000L;
          ((RichMsg.PttRec)localObject1).msgRecTime.set(paramLong1);
          ((RichMsg.PttRec)localObject1).msgTime.set(l1);
          paramMsg = (MessageForPtt)MessageRecordFactory.a(-2002);
          paramMsg.msgtype = -2002;
          paramMsg.msgData = ((RichMsg.PttRec)localObject1).toByteArray();
          paramMsg.parse();
          paramList.add(paramMsg);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "offline ptt no filename");
          }
        }
        localStringBuilder.append("rcv a repeated offline file push msg");
      }
      label1075:
      break;
      label1077:
      paramMessageHandler = null;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    im_msg_body.Ptt localPtt;
    do
    {
      return;
      localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)localObject1).ptt.get();
      if ((((im_msg_body.RichText)localObject1).ptt.has()) && (localPtt.uint32_file_type.has()) && ((localPtt.uint32_file_type.get() == 4) || (localPtt.uint32_file_type.get() == 6)) && (localPtt.bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localPtt == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(localPtt.uint32_file_type.has()).append(" fileType:").append(localPtt.uint32_file_type.get()).append(" hasUUID:").append(localPtt.bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + localPtt.uint32_file_type.get());
    }
    int i;
    long l2;
    long l1;
    int k;
    label364:
    int m;
    int n;
    if (SttManager.a(paramMessageHandler.a))
    {
      i = 1;
      l2 = -1L;
      j = i;
      l1 = l2;
      if (!localPtt.bytes_reserve.has()) {
        break label586;
      }
      localObject1 = localPtt.bytes_reserve.get().toByteArray();
      j = i;
      l1 = l2;
      if (localObject1 == null) {
        break label586;
      }
      j = i;
      l1 = l2;
      if (localObject1.length <= 1) {
        break label586;
      }
      j = localObject1[0];
      l1 = -1L;
      k = 1;
      if (k >= localObject1.length - 1) {
        break label583;
      }
      m = localObject1[k];
      j = k + 1;
      k = PkgTools.a((byte[])localObject1, j);
      n = j + 2;
      if (m != 2) {
        break label483;
      }
      localObject2 = new byte[k];
      PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, n, k);
      l2 = l1;
      j = i;
      if (localObject2.length > 0)
      {
        l2 = l1;
        j = i;
        if (localObject2[0] == 1)
        {
          j = 1;
          l2 = l1;
        }
      }
    }
    for (;;)
    {
      k = n + k;
      l1 = l2;
      i = j;
      break label364;
      i = 0;
      break;
      label483:
      l2 = l1;
      j = i;
      if (m == 3)
      {
        localObject2 = new byte[k];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject1, n, k);
        l2 = PkgTools.a((byte[])localObject2, 0);
        if (l2 > 0L) {
          l1 = l2;
        }
        l2 = l1;
        j = i;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
          l2 = l1;
          j = i;
        }
      }
    }
    label583:
    int j = i;
    label586:
    Object localObject2 = localPtt.bytes_file_uuid.get().toStringUtf8();
    Object localObject1 = localPtt.bytes_file_name.get().toStringUtf8();
    if (!((String)localObject1).contains("_")) {}
    for (localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 4);; localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("_") + 1, ((String)localObject1).length() - 4))
    {
      localObject1 = l3 + "_" + (String)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject1 + " fileUuid:" + (String)localObject2);
      }
      localObject1 = new RichMsg.PttRec();
      ((RichMsg.PttRec)localObject1).localPath.set((String)localObject2);
      ((RichMsg.PttRec)localObject1).size.set(localPtt.uint32_file_size.get());
      ((RichMsg.PttRec)localObject1).type.set(2);
      ((RichMsg.PttRec)localObject1).uuid.set((String)localObject2);
      ((RichMsg.PttRec)localObject1).isRead.set(false);
      ((RichMsg.PttRec)localObject1).serverStorageSource.set("pttcenter");
      ((RichMsg.PttRec)localObject1).isReport.set(0);
      ((RichMsg.PttRec)localObject1).version.set(5);
      ((RichMsg.PttRec)localObject1).pttFlag.set(j);
      l2 = System.currentTimeMillis() / 1000L;
      long l4 = paramMsg.msg_head.msg_time.get();
      ((RichMsg.PttRec)localObject1).msgRecTime.set(l2);
      ((RichMsg.PttRec)localObject1).msgTime.set(l4);
      i = MessageUtils.a(paramMessageHandler.a, String.valueOf(l3));
      ((RichMsg.PttRec)localObject1).longPttVipFlag.set(i);
      paramMessageHandler = MessageRecordFactory.a(-2002);
      paramMessageHandler.msgtype = -2002;
      paramMessageHandler.msgData = ((RichMsg.PttRec)localObject1).toByteArray();
      paramMessageHandler.time = l1;
      ((MessageForPtt)paramMessageHandler).parse();
      paramList.add(paramMessageHandler);
      return;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1881;
      }
      localObject1 = AppShareIDUtil.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().a(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().a((Entity)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.a.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label301:
    label569:
    label1869:
    label1878:
    label1881:
    for (int i = 1;; i = 0)
    {
      Object localObject3;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject2 = BaseApplication.getContext().getString(2131368640);
        Iterator localIterator = ((List)localObject1).iterator();
        paramBoolean = false;
        localObject3 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject1 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject1).text.has();
          bool3 = ((im_msg_body.Elem)localObject1).not_online_image.has();
          if (!bool3) {
            break label1878;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          Object localObject4;
          if (bool3)
          {
            localObject1 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject1).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject1).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject1).download_path.has()) {
              break label1869;
            }
            localObject4 = ((im_msg_body.NotOnlineImage)localObject1).download_path.get().toStringUtf8();
            localObject1 = localObject4;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + (String)localObject4);
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              localObject3 = new RichMsg.PicRec();
              localObject4 = ((RichMsg.PicRec)localObject3).localPath;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                ((RichMsg.PicRec)localObject3).size.set(j);
                ((RichMsg.PicRec)localObject3).type.set(1);
                localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                if (localObject1 == null) {
                  break label774;
                }
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                localObject2 = TransfileUtile.a((String)localObject1, j, 1, false, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
                }
              }
            }
            for (localObject1 = localObject3;; localObject1 = localObject3)
            {
              localObject3 = localObject1;
              for (;;)
              {
                break label301;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().b((Entity)localObject2);
                  paramMessageHandler.a().a((Entity)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                localObject2 = "";
                break label526;
                localObject2 = "";
                break label569;
                if (bool2)
                {
                  localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                  paramMsg = ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject1).link.has() + ",str:" + ((im_msg_body.Text)localObject1).str.has() + ",strC:" + ((im_msg_body.Text)localObject1).str.get().toStringUtf8());
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject1).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject1).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject1).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject1).custom_face.has())
                {
                  Object localObject6 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject1).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject6).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject6).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                  localObject4 = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                  String str = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject6).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject6).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject6).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject6).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject6).uint32_useful.get();
                  Object localObject7 = ((im_msg_body.CustomFace)localObject6).bytes_md5.get().toByteArray();
                  Object localObject5 = ((im_msg_body.CustomFace)localObject6).bytes_signature.get().toByteArray();
                  ((im_msg_body.CustomFace)localObject6).bytes_buffer.get().toByteArray();
                  localObject6 = ((im_msg_body.CustomFace)localObject6).bytes_flag.get().toByteArray();
                  localObject7 = HexUtil.a((byte[])localObject7);
                  localObject5 = HexUtil.a((byte[])localObject5);
                  localObject6 = HexUtil.a((byte[])localObject6);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject7 + ",signature:" + (String)localObject5 + ",flag:" + (String)localObject6 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + (String)localObject4 + ",downURLThum:" + str);
                  }
                  localObject1 = "https://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.a.a();
                  localObject3 = new RichMsg.PicRec();
                  localObject4 = ((RichMsg.PicRec)localObject3).localPath;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    ((PBStringField)localObject4).set((String)localObject2);
                    ((RichMsg.PicRec)localObject3).size.set(0L);
                    ((RichMsg.PicRec)localObject3).type.set(1);
                    localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                    if (localObject1 == null) {
                      break label1522;
                    }
                  }
                  label1522:
                  for (localObject2 = localObject1;; localObject2 = "")
                  {
                    ((PBStringField)localObject4).set((String)localObject2);
                    localObject2 = TransfileUtile.a((String)localObject1, 0L, 1, false, (String)localObject1);
                    paramBoolean = true;
                    break;
                    localObject2 = "";
                    break label1448;
                  }
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
                    paramMsg.msgtype = -2000;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject3).toByteArray();
                    paramMsg.msg = ((String)localObject2);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    return;
                    if ((!paramBoolean) && (bool1))
                    {
                      paramMessageHandler = (MessageForText)MessageRecordFactory.a(-1000);
                      paramMessageHandler.msgtype = -1000;
                      paramMessageHandler.msg = paramMsg;
                      paramList.add(paramMessageHandler);
                      return;
                    }
                    localObject1 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(AppShareIDUtil.b(l1)));
                    paramMsg = ActionMsgUtil.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2 + ",opType:" + paramMsg.jdField_b_of_type_Int);
                    }
                    localObject1 = ActionMsgUtil.a((String)localObject2, (String)localObject1, l1, paramMsg.a);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject2 + ",encodeMsg:" + (String)localObject1);
                    }
                    localObject2 = MessageRecordFactory.a(paramMsg.jdField_b_of_type_Int);
                    ((MessageRecord)localObject2).msgtype = paramMsg.jdField_b_of_type_Int;
                    ((MessageRecord)localObject2).msg = ((String)localObject1);
                    paramList.add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    label48:
    Object localObject1;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()))
    {
      return;
    }
    else
    {
      while (!paramMsg.content_head.has()) {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
          return;
        }
      }
      localObject1 = (msg_comm.ContentHead)paramMsg.content_head.get();
      if ((!((msg_comm.ContentHead)localObject1).auto_reply.has()) || (((msg_comm.ContentHead)localObject1).auto_reply.get() != 1)) {
        break label428;
      }
    }
    label428:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder(128);
        ((StringBuilder)localObject2).append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject1).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
      if (!paramBoolean2) {
        break label434;
      }
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label48;
      }
      paramMsg = BaseApplication.getContext().getString(2131367640);
      localObject1 = ((List)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label48;
      }
      Object localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
      if (!((im_msg_body.Elem)localObject2).text.has()) {
        break;
      }
      localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get();
      if ((BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + paramMessageHandler.a.a(), "").contains("NAR" + paramLong + ",")) || (paramBoolean1)) {
        break label48;
      }
      paramMessageHandler = paramMsg + " " + ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
      paramMsg = MessageRecordFactory.a(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label434:
    a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    label445:
    label461:
    label511:
    long l;
    label557:
    label619:
    do
    {
      byte[] arrayOfByte;
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
              }
              switch (i)
              {
              case 5: 
              case 6: 
              case 10: 
              case 11: 
              case 12: 
              default: 
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
                return;
              }
            }
            catch (Exception paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
              return;
              paramList = new SubMsgType0x3.MsgBody();
              int j;
              int k;
              for (;;)
              {
                try
                {
                  paramList.mergeFrom(arrayOfByte);
                  if (!paramList.msg_fail_notify.has()) {
                    break label557;
                  }
                  j = 0;
                  paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
                  if (!paramList.uint32_sessionid.has()) {
                    break label445;
                  }
                  k = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_retCode.has()) {
                    break label461;
                  }
                  i = paramList.uint32_retCode.get();
                  if (!paramList.bytes_reason.has()) {
                    break label511;
                  }
                  paramList = new String(paramList.bytes_reason.get().toStringUtf8());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + k + "], retCode[" + i + "], reason[" + paramList + "]");
                  }
                  paramMessageHandler.a.a().a(String.valueOf(paramLong1), k, i, paramList);
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                return;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not RetCode");
                  i = j;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not reason");
                  }
                  paramList = "";
                }
              }
              if (paramList.msg_progress_notify.has())
              {
                j = 0;
                paramList = (SubMsgType0x3.ProgressNotify)paramList.msg_progress_notify.get();
                if (paramList.uint32_sessionid.has())
                {
                  k = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_progress.has()) {
                    break label736;
                  }
                  i = paramList.uint32_progress.get();
                  if (!paramList.uint32_average_speed.has()) {
                    break label786;
                  }
                }
                for (j = paramList.uint32_average_speed.get();; j = 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + k + "], progress[" + i + "], speed[" + j + "]");
                  }
                  paramMessageHandler.a.a().a(String.valueOf(paramLong1), k, i, j);
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                  return;
                  i = j;
                  if (!QLog.isColorLevel()) {
                    break label619;
                  }
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not Progress");
                  i = j;
                  break label619;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not AverageSpeed");
                  }
                }
              }
              if (QLog.isColorLevel())
              {
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
                }
                localObject = new SubMsgType0x4.MsgBody();
                try
                {
                  localObject = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(arrayOfByte);
                  if (((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.has()) {
                    break label928;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (QLog.isColorLevel())
                {
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
                  return;
                  localObject = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject).msg_not_online_file.get();
                  if (paramBoolean4)
                  {
                    paramMessageHandler = new MessageRecord();
                    paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                    l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                    paramMessageHandler.msg = ((im_msg_body.NotOnlineFile)localObject).bytes_file_name.get().toStringUtf8();
                    paramMessageHandler.senderuin = Long.toString(l);
                    paramMessageHandler.msgtype = -2005;
                    paramMessageHandler.frienduin = Long.toString(paramLong1);
                    paramMessageHandler.time = paramLong2;
                    paramList.add(paramMessageHandler);
                    return;
                  }
                  paramMessageHandler.a.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<dataline> message come: cmd[0x211, 0x7]");
                  }
                  paramList = new SubMsgType0x7.MsgBody();
                  try
                  {
                    paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom(arrayOfByte);
                    if (!paramBoolean4)
                    {
                      ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg, paramList);
                      return;
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
        return;
        paramLong1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        paramList = null;
        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
          localObject = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
        }
        try
        {
          paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
          paramList = (List)localObject;
          if (paramMsg != null)
          {
            FMDataCache.a(String.valueOf(paramLong1), paramMsg);
            paramList = (List)localObject;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            paramList = (List)localObject;
          }
        }
        paramMessageHandler.a.a().a(paramLong1, i, paramLong2, l, paramList, arrayOfByte);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        paramList = new C2CType0x211_SubC2CType0x9.MsgBody();
        try
        {
          paramList = (C2CType0x211_SubC2CType0x9.MsgBody)paramList.mergeFrom(arrayOfByte);
          ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg, paramList);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      return;
      paramLong1 = paramMsg.msg_head.from_uin.get();
      int i = paramMsg.msg_head.msg_seq.get();
      paramLong2 = paramMsg.msg_head.msg_uid.get();
      l = paramMsg.msg_head.msg_time.get();
      ((SmartDeviceProxyMgr)paramMessageHandler.a.a(53)).a(i, "im_push.msg_push", (byte[])arrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "device msg push, receive 0x211,0xd msg, fromuin:" + paramLong1 + ", msg seq:" + i + ",msg_uid:" + paramLong2 + ",msg_time:" + l);
      }
    } while (l == 0L);
    label736:
    paramList = new ArrayList();
    label786:
    label928:
    paramList.add(new UinPairReadInfo(paramLong1, l, 0L, null));
    ((C2CMessageProcessor)paramMessageHandler.a.a().a("c2c_processor")).b(paramList);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if ((!((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.has()) || (!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    int i;
    int j;
    Object localObject2;
    do
    {
      return;
      localObject1 = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.get();
      i = ((msg_comm.C2CTmpMsgHead)localObject1).c2c_type.get();
      j = ((msg_comm.C2CTmpMsgHead)localObject1).service_type.get();
      if ((paramDecodeProtoPkgContext.d) || (paramTempSessionInfo.jdField_b_of_type_Int != 1006)) {
        break label220;
      }
      localObject2 = ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get();
      if ((((msg_comm.C2CTmpMsgHead)localObject1).from_phone.has()) && (localObject2 != null) && (!((String)localObject2).equals("+0"))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get());
    return;
    ContactUtils.a(paramMessageHandler.a, ((msg_comm.C2CTmpMsgHead)localObject1).from_phone.get(), paramDecodeProtoPkgContext.e + "");
    label220:
    if ((!paramDecodeProtoPkgContext.d) && (((msg_comm.C2CTmpMsgHead)localObject1).sig.has()))
    {
      localObject2 = ((msg_comm.C2CTmpMsgHead)localObject1).sig.get().toByteArray();
      localObject1 = localObject2;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.msg.MessageHandler", 4, "tempHead.sig.get()----> sig:" + HexUtil.a((byte[])localObject2) + ",length:" + localObject2.length);
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      for (;;)
      {
        if (localObject1 != null) {}
        switch (paramTempSessionInfo.jdField_b_of_type_Int)
        {
        default: 
          label416:
          j = 0;
          i = j;
          if (paramMsg.content_head.has())
          {
            i = j;
            if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()) {
              if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
                break label1098;
              }
            }
          }
          break;
        }
        label1098:
        for (i = 1;; i = 0)
        {
          localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          if (i == 0) {
            break label1104;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramMsg = (im_msg_body.Text)((im_msg_body.Elem)((List)localObject1).get(0)).text.get();
          if ((BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + paramMessageHandler.a.a(), "").contains("NAR" + paramDecodeProtoPkgContext.e + ",")) || (paramDecodeProtoPkgContext.b)) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131367640) + " " + paramMsg.str.get().toStringUtf8();
          paramMsg = MessageRecordFactory.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().a(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label416;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().b(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label416;
          paramMessageHandler.a.a().c(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().e(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label416;
          localObject2 = new byte[localObject1.length + 2];
          localObject2[0] = ((byte)i);
          localObject2[1] = ((byte)j);
          PkgTools.a((byte[])localObject2, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.a.a().f(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject2);
          break label416;
          paramMessageHandler.a.a().g(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          paramMessageHandler.a.a().h(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          paramMessageHandler.a.a().k(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          paramMessageHandler.a.a().m(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          paramMessageHandler.a.a().j(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
          paramMessageHandler.a.a().i(String.valueOf(paramDecodeProtoPkgContext.e), (byte[])localObject1);
          break label416;
        }
        label1104:
        if (paramTempSessionInfo == null) {
          break;
        }
        if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
        {
          paramMessageHandler = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          paramTempSessionInfo = new im_msg_body.TmpPtt();
          try
          {
            paramMessageHandler = (im_msg_body.TmpPtt)paramTempSessionInfo.mergeFrom(paramMessageHandler);
            if ((paramMessageHandler == null) || (!paramMessageHandler.uint32_file_type.has()) || (paramMessageHandler.uint32_file_type.get() != 4) || (!paramMessageHandler.bytes_file_uuid.has())) {
              break;
            }
            paramDecodeProtoPkgContext = paramMessageHandler.bytes_file_uuid.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + paramDecodeProtoPkgContext);
            }
            paramTempSessionInfo = new RichMsg.PttRec();
            paramTempSessionInfo.localPath.set(paramMessageHandler.bytes_file_uuid.get().toStringUtf8());
            paramTempSessionInfo.size.set(paramMessageHandler.uint32_file_size.get());
            paramTempSessionInfo.type.set(2);
            paramTempSessionInfo.uuid.set(paramDecodeProtoPkgContext);
            paramTempSessionInfo.isRead.set(false);
            paramTempSessionInfo.serverStorageSource.set("pttcenter");
            paramTempSessionInfo.isReport.set(0);
            paramTempSessionInfo.version.set(5);
            paramTempSessionInfo.pttFlag.set(0);
            j = 0;
            i = j;
            if (paramMessageHandler.uint32_user_type.has())
            {
              int k = paramMessageHandler.uint32_user_type.get();
              if (k != 1)
              {
                i = j;
                if (k != 2) {}
              }
              else
              {
                i = k;
              }
            }
            paramTempSessionInfo.longPttVipFlag.set(i);
            long l1 = System.currentTimeMillis() / 1000L;
            long l2 = paramMsg.msg_head.msg_time.get();
            paramTempSessionInfo.msgRecTime.set(l1);
            paramTempSessionInfo.msgTime.set(l2);
            paramMessageHandler = MessageRecordFactory.a(-2002);
            paramMessageHandler.msgtype = -2002;
            paramMessageHandler.msgData = paramTempSessionInfo.toByteArray();
            ((MessageForPtt)paramMessageHandler).parse();
            paramList.add(paramMessageHandler);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramMessageHandler)
          {
            for (;;)
            {
              paramMessageHandler.printStackTrace();
              paramMessageHandler = null;
            }
          }
        }
      }
      a(paramMessageHandler, paramList, paramMsg, true, paramDecodeProtoPkgContext.b, null);
      return;
    }
  }
  
  /* Error */
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, com.tencent.mobileqq.troop.data.MessageInfo paramMessageInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   4: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   10: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   13: invokevirtual 44	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   16: checkcast 42	tencent/im/msg/im_msg_body$RichText
    //   19: getfield 48	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   22: invokevirtual 53	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   25: astore 59
    //   27: aconst_null
    //   28: astore 49
    //   30: new 91	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 2308
    //   37: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: astore 56
    //   42: new 99	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 1588	java/util/ArrayList:<init>	()V
    //   49: astore 57
    //   51: aload 59
    //   53: ifnull +13 -> 66
    //   56: aload 59
    //   58: invokeinterface 2067 1 0
    //   63: ifgt +30 -> 93
    //   66: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +23 -> 92
    //   72: aload 56
    //   74: ldc_w 2310
    //   77: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: ldc 13
    //   83: iconst_2
    //   84: aload 56
    //   86: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: return
    //   93: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +28 -> 124
    //   99: aload 56
    //   101: ldc_w 2312
    //   104: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 59
    //   109: invokeinterface 2067 1 0
    //   114: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc_w 1652
    //   120: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: iconst_0
    //   125: istore 14
    //   127: iconst_0
    //   128: istore 13
    //   130: iconst_0
    //   131: istore 7
    //   133: new 91	java/lang/StringBuilder
    //   136: dup
    //   137: ldc_w 281
    //   140: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: astore 58
    //   145: aconst_null
    //   146: astore 48
    //   148: aconst_null
    //   149: astore 52
    //   151: iconst_0
    //   152: istore 8
    //   154: iconst_0
    //   155: istore 9
    //   157: iconst_0
    //   158: istore 10
    //   160: bipush 10
    //   162: istore 11
    //   164: iconst_0
    //   165: istore 6
    //   167: iconst_0
    //   168: istore 12
    //   170: lconst_0
    //   171: lstore 29
    //   173: iconst_0
    //   174: istore 26
    //   176: aload_2
    //   177: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   180: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   183: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   186: i2l
    //   187: lstore 39
    //   189: aload 59
    //   191: invokestatic 2315	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;)Z
    //   194: istore 28
    //   196: aconst_null
    //   197: astore 51
    //   199: aconst_null
    //   200: astore 50
    //   202: aconst_null
    //   203: astore 47
    //   205: aload_2
    //   206: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   209: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   212: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   215: ifeq +10821 -> 11036
    //   218: aload_2
    //   219: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   222: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   225: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   228: lstore 31
    //   230: aload_0
    //   231: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   237: lload 31
    //   239: invokestatic 1389	java/lang/Long:toString	(J)Ljava/lang/String;
    //   242: invokestatic 2318	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   245: ifeq +10791 -> 11036
    //   248: iconst_1
    //   249: istore 20
    //   251: iconst_0
    //   252: istore 21
    //   254: iload 21
    //   256: aload 59
    //   258: invokeinterface 2067 1 0
    //   263: if_icmpge +1503 -> 1766
    //   266: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +23 -> 292
    //   272: aload 56
    //   274: ldc_w 2320
    //   277: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload 21
    //   282: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   285: ldc_w 2322
    //   288: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 59
    //   294: iload 21
    //   296: invokeinterface 1460 2 0
    //   301: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   304: astore 60
    //   306: aload 60
    //   308: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   311: invokevirtual 2329	tencent/im/msg/im_msg_body$LifeOnlineAccount:has	()Z
    //   314: ifeq +161 -> 475
    //   317: aload 60
    //   319: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   322: getfield 2332	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_ack	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   325: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   328: ifeq +147 -> 475
    //   331: aload 60
    //   333: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   336: getfield 2332	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_ack	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   339: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   342: iconst_1
    //   343: if_icmpne +132 -> 475
    //   346: aload 60
    //   348: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   351: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   354: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   357: ifeq +396 -> 753
    //   360: aload 60
    //   362: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   365: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   368: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   371: lstore 31
    //   373: aload 60
    //   375: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   378: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   381: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   384: ifeq +375 -> 759
    //   387: aload 60
    //   389: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   392: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   395: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   398: i2l
    //   399: lstore 33
    //   401: aload_2
    //   402: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   405: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   408: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   411: ifeq +354 -> 765
    //   414: aload_2
    //   415: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   418: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   421: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   424: lstore 35
    //   426: aload_2
    //   427: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   430: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   433: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   436: ifeq +335 -> 771
    //   439: aload_2
    //   440: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   443: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   446: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   449: lstore 37
    //   451: invokestatic 2343	com/tencent/biz/pubaccount/PublicAccountManager:a	()Lcom/tencent/biz/pubaccount/PublicAccountManager;
    //   454: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   457: aload_0
    //   458: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   461: lload 31
    //   463: lload 33
    //   465: lload 35
    //   467: lload 37
    //   469: iconst_1
    //   470: aconst_null
    //   471: invokevirtual 2346	com/tencent/biz/pubaccount/PublicAccountManager:a	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;JJJJILjava/util/List;)Lmqq/app/NewIntent;
    //   474: pop
    //   475: iload 13
    //   477: ifeq +10556 -> 11033
    //   480: aload 60
    //   482: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   485: invokevirtual 1864	tencent/im/msg/im_msg_body$Text:has	()Z
    //   488: ifeq +10545 -> 11033
    //   491: aload 49
    //   493: aload 60
    //   495: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   498: invokevirtual 1911	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   501: checkcast 972	tencent/im/msg/im_msg_body$Text
    //   504: getfield 976	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   507: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   510: invokevirtual 1645	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   513: putfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   516: aload 49
    //   518: getfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   521: iconst_0
    //   522: invokevirtual 140	java/lang/String:charAt	(I)C
    //   525: bipush 91
    //   527: if_icmpne +50 -> 577
    //   530: aload 49
    //   532: getfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   535: aload 49
    //   537: getfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   540: invokevirtual 97	java/lang/String:length	()I
    //   543: iconst_1
    //   544: isub
    //   545: invokevirtual 140	java/lang/String:charAt	(I)C
    //   548: bipush 93
    //   550: if_icmpne +27 -> 577
    //   553: aload 49
    //   555: aload 49
    //   557: getfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   560: iconst_1
    //   561: aload 49
    //   563: getfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   566: invokevirtual 97	java/lang/String:length	()I
    //   569: iconst_1
    //   570: isub
    //   571: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   574: putfield 1160	com/tencent/mobileqq/data/MarkFaceMessage:faceName	Ljava/lang/String;
    //   577: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +32 -> 612
    //   583: aload 56
    //   585: ldc_w 2348
    //   588: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload 60
    //   593: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   596: invokevirtual 1911	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   599: checkcast 972	tencent/im/msg/im_msg_body$Text
    //   602: getfield 976	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   605: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   608: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: iload 28
    //   614: ifne +163 -> 777
    //   617: iload 12
    //   619: istore 15
    //   621: iload 6
    //   623: istore 16
    //   625: iload 11
    //   627: istore 17
    //   629: iload 8
    //   631: istore 13
    //   633: iload 7
    //   635: istore 6
    //   637: iconst_0
    //   638: istore 7
    //   640: iload 14
    //   642: istore 8
    //   644: aload 47
    //   646: astore 53
    //   648: aload 52
    //   650: astore 47
    //   652: iload 9
    //   654: istore 12
    //   656: iload 10
    //   658: istore 11
    //   660: iload 17
    //   662: istore 10
    //   664: iload 16
    //   666: istore 9
    //   668: iload 15
    //   670: istore 14
    //   672: aload 53
    //   674: astore 52
    //   676: iload 21
    //   678: iconst_1
    //   679: iadd
    //   680: istore 21
    //   682: iload 11
    //   684: istore 15
    //   686: iload 12
    //   688: istore 16
    //   690: iload 13
    //   692: istore 17
    //   694: aload 47
    //   696: astore 53
    //   698: iload 6
    //   700: istore 18
    //   702: iload 8
    //   704: istore 19
    //   706: iload 7
    //   708: istore 13
    //   710: aload 52
    //   712: astore 47
    //   714: iload 14
    //   716: istore 12
    //   718: iload 9
    //   720: istore 6
    //   722: iload 10
    //   724: istore 11
    //   726: iload 15
    //   728: istore 10
    //   730: iload 16
    //   732: istore 9
    //   734: iload 17
    //   736: istore 8
    //   738: aload 53
    //   740: astore 52
    //   742: iload 18
    //   744: istore 7
    //   746: iload 19
    //   748: istore 14
    //   750: goto -496 -> 254
    //   753: lconst_0
    //   754: lstore 31
    //   756: goto -383 -> 373
    //   759: lconst_0
    //   760: lstore 33
    //   762: goto -361 -> 401
    //   765: lconst_0
    //   766: lstore 35
    //   768: goto -342 -> 426
    //   771: lconst_0
    //   772: lstore 37
    //   774: goto -323 -> 451
    //   777: iconst_0
    //   778: istore 13
    //   780: aload 60
    //   782: getfield 1219	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   785: invokevirtual 2349	tencent/im/msg/im_msg_body$RichMsg:has	()Z
    //   788: ifeq +852 -> 1640
    //   791: aload 58
    //   793: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   796: ifle +54 -> 850
    //   799: sipush -1000
    //   802: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   805: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   808: astore 53
    //   810: aload 53
    //   812: sipush -1000
    //   815: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   818: aload 53
    //   820: aload 58
    //   822: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   828: aload 57
    //   830: aload 53
    //   832: invokeinterface 375 2 0
    //   837: pop
    //   838: aload 58
    //   840: iconst_0
    //   841: aload 58
    //   843: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   846: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   853: ifeq +12 -> 865
    //   856: aload 56
    //   858: ldc_w 2351
    //   861: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: pop
    //   865: aload 60
    //   867: getfield 1219	tencent/im/msg/im_msg_body$Elem:rich_msg	Ltencent/im/msg/im_msg_body$RichMsg;
    //   870: invokevirtual 2352	tencent/im/msg/im_msg_body$RichMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   873: checkcast 1205	tencent/im/msg/im_msg_body$RichMsg
    //   876: getfield 1209	tencent/im/msg/im_msg_body$RichMsg:bytes_template_1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   879: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   882: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   885: astore 54
    //   887: new 1193	com/tencent/mobileqq/data/MessageForStructing
    //   890: dup
    //   891: invokespecial 2353	com/tencent/mobileqq/data/MessageForStructing:<init>	()V
    //   894: astore 53
    //   896: aload 53
    //   898: sipush -2011
    //   901: putfield 2354	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   904: aload_2
    //   905: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   908: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   911: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   914: lstore 33
    //   916: aload_2
    //   917: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   920: getfield 248	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   923: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   926: istore 15
    //   928: iload 15
    //   930: bipush 82
    //   932: if_icmpeq +14 -> 946
    //   935: lload 33
    //   937: lstore 31
    //   939: iload 15
    //   941: bipush 43
    //   943: if_icmpne +52 -> 995
    //   946: lload 33
    //   948: lstore 31
    //   950: aload_2
    //   951: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   954: getfield 2358	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   957: ifnull +38 -> 995
    //   960: lload 33
    //   962: lstore 31
    //   964: aload_2
    //   965: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   968: getfield 2358	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   971: getfield 2361	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   974: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   977: ifeq +18 -> 995
    //   980: aload_2
    //   981: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   984: getfield 2358	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   987: getfield 2361	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   990: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   993: lstore 31
    //   995: aload 53
    //   997: aload_0
    //   998: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1001: iload 15
    //   1003: lload 31
    //   1005: aload 54
    //   1007: iconst_m1
    //   1008: invokestatic 2366	com/tencent/mobileqq/structmsg/StructMsgFactory:a	(Lcom/tencent/mobileqq/app/QQAppInterface;IJ[BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1011: putfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1014: aload 59
    //   1016: invokeinterface 59 1 0
    //   1021: astore 55
    //   1023: aload 55
    //   1025: invokeinterface 64 1 0
    //   1030: ifeq +115 -> 1145
    //   1033: aload 55
    //   1035: invokeinterface 68 1 0
    //   1040: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   1043: astore 60
    //   1045: aload 60
    //   1047: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   1050: invokevirtual 2329	tencent/im/msg/im_msg_body$LifeOnlineAccount:has	()Z
    //   1053: ifeq -30 -> 1023
    //   1056: aload 60
    //   1058: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   1061: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1064: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   1067: getfield 2370	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_report	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1070: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1073: ifeq -50 -> 1023
    //   1076: aload 60
    //   1078: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   1081: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1084: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   1087: getfield 2370	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_report	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1090: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1093: iconst_1
    //   1094: if_icmpne -71 -> 1023
    //   1097: aload 60
    //   1099: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   1102: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1105: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   1108: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1111: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1114: ifeq -91 -> 1023
    //   1117: aload 53
    //   1119: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1122: aload 60
    //   1124: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   1127: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1130: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   1133: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1136: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1139: putfield 2373	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   1142: goto -119 -> 1023
    //   1145: aload 53
    //   1147: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1150: getfield 1215	com/tencent/mobileqq/structmsg/AbsStructMsg:mMsgServiceID	I
    //   1153: bipush 37
    //   1155: if_icmpne +282 -> 1437
    //   1158: new 94	java/lang/String
    //   1161: dup
    //   1162: aload 54
    //   1164: iconst_m1
    //   1165: invokestatic 2378	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   1168: ldc_w 1402
    //   1171: invokespecial 1405	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1174: astore 53
    //   1176: aload 58
    //   1178: aload 53
    //   1180: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 53
    //   1186: invokestatic 2380	com/tencent/mobileqq/service/message/MessageProtoCodec:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   1189: astore 53
    //   1191: aload 53
    //   1193: ifnull +59 -> 1252
    //   1196: sipush -3006
    //   1199: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1202: checkcast 2382	com/tencent/mobileqq/data/MessageForPubAccount
    //   1205: astore 48
    //   1207: aload 48
    //   1209: sipush -3006
    //   1212: putfield 2383	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   1215: aload 48
    //   1217: aload 58
    //   1219: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1222: putfield 2384	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   1225: aload 48
    //   1227: aload 53
    //   1229: putfield 2388	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   1232: aload 48
    //   1234: aload 53
    //   1236: invokestatic 2391	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   1239: putfield 2392	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   1242: aload 57
    //   1244: aload 48
    //   1246: invokeinterface 375 2 0
    //   1251: pop
    //   1252: aload 58
    //   1254: iconst_0
    //   1255: aload 58
    //   1257: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1260: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1263: pop
    //   1264: aload 47
    //   1266: astore 54
    //   1268: iload 10
    //   1270: istore 15
    //   1272: iload 9
    //   1274: istore 16
    //   1276: aload 52
    //   1278: astore 47
    //   1280: aload 53
    //   1282: astore 48
    //   1284: iload 13
    //   1286: istore 17
    //   1288: iload 14
    //   1290: istore 18
    //   1292: aload 54
    //   1294: astore 52
    //   1296: iload 12
    //   1298: istore 14
    //   1300: iload 6
    //   1302: istore 9
    //   1304: iload 11
    //   1306: istore 10
    //   1308: iload 15
    //   1310: istore 11
    //   1312: iload 16
    //   1314: istore 12
    //   1316: iload 8
    //   1318: istore 13
    //   1320: iload 7
    //   1322: istore 6
    //   1324: iload 17
    //   1326: istore 7
    //   1328: iload 18
    //   1330: istore 8
    //   1332: goto -656 -> 676
    //   1335: astore 54
    //   1337: aload 54
    //   1339: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   1342: goto -110 -> 1232
    //   1345: astore 54
    //   1347: aload 53
    //   1349: astore 48
    //   1351: aload 54
    //   1353: astore 53
    //   1355: aload 53
    //   1357: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   1360: iload 10
    //   1362: istore 15
    //   1364: iload 9
    //   1366: istore 16
    //   1368: aload 52
    //   1370: astore 53
    //   1372: iload 13
    //   1374: istore 17
    //   1376: iload 14
    //   1378: istore 18
    //   1380: aload 47
    //   1382: astore 52
    //   1384: iload 12
    //   1386: istore 14
    //   1388: iload 6
    //   1390: istore 9
    //   1392: iload 11
    //   1394: istore 10
    //   1396: iload 15
    //   1398: istore 11
    //   1400: iload 16
    //   1402: istore 12
    //   1404: iload 8
    //   1406: istore 13
    //   1408: aload 53
    //   1410: astore 47
    //   1412: iload 7
    //   1414: istore 6
    //   1416: iload 17
    //   1418: istore 7
    //   1420: iload 18
    //   1422: istore 8
    //   1424: goto -748 -> 676
    //   1427: astore 54
    //   1429: aload 54
    //   1431: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   1434: goto -192 -> 1242
    //   1437: aload 51
    //   1439: ifnull +13 -> 1452
    //   1442: aload 53
    //   1444: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1447: aload 51
    //   1449: putfield 1223	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1452: aload 53
    //   1454: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1457: ifnull +16 -> 1473
    //   1460: aload 53
    //   1462: aload 53
    //   1464: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1467: invokevirtual 2394	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1470: putfield 2395	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1473: aload 53
    //   1475: ldc_w 2397
    //   1478: putfield 2398	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   1481: aload 53
    //   1483: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1486: ifnonnull +83 -> 1569
    //   1489: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1492: ifeq +12 -> 1504
    //   1495: aload 56
    //   1497: ldc_w 2400
    //   1500: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1503: pop
    //   1504: iload 6
    //   1506: istore 13
    //   1508: iload 10
    //   1510: istore 15
    //   1512: iload 9
    //   1514: istore 16
    //   1516: iconst_1
    //   1517: istore 17
    //   1519: aload 52
    //   1521: astore 53
    //   1523: iload 7
    //   1525: istore 6
    //   1527: iconst_0
    //   1528: istore 7
    //   1530: iload 14
    //   1532: istore 8
    //   1534: aload 47
    //   1536: astore 52
    //   1538: iload 12
    //   1540: istore 14
    //   1542: iload 13
    //   1544: istore 9
    //   1546: iload 11
    //   1548: istore 10
    //   1550: iload 15
    //   1552: istore 11
    //   1554: iload 16
    //   1556: istore 12
    //   1558: iload 17
    //   1560: istore 13
    //   1562: aload 53
    //   1564: astore 47
    //   1566: goto -890 -> 676
    //   1569: aload 57
    //   1571: aload 53
    //   1573: invokeinterface 375 2 0
    //   1578: pop
    //   1579: iload 6
    //   1581: istore 13
    //   1583: iload 10
    //   1585: istore 15
    //   1587: iload 9
    //   1589: istore 16
    //   1591: iconst_1
    //   1592: istore 17
    //   1594: iload 7
    //   1596: istore 6
    //   1598: iconst_0
    //   1599: istore 7
    //   1601: iload 14
    //   1603: istore 8
    //   1605: aload 47
    //   1607: astore 52
    //   1609: iload 12
    //   1611: istore 14
    //   1613: iload 13
    //   1615: istore 9
    //   1617: iload 11
    //   1619: istore 10
    //   1621: iload 15
    //   1623: istore 11
    //   1625: iload 16
    //   1627: istore 12
    //   1629: iload 17
    //   1631: istore 13
    //   1633: aload 53
    //   1635: astore 47
    //   1637: goto -961 -> 676
    //   1640: aload 60
    //   1642: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1645: invokevirtual 1864	tencent/im/msg/im_msg_body$Text:has	()Z
    //   1648: ifeq +792 -> 2440
    //   1651: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1654: ifeq +12 -> 1666
    //   1657: aload 56
    //   1659: ldc_w 2402
    //   1662: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: pop
    //   1666: aload 58
    //   1668: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1671: istore 19
    //   1673: aload 60
    //   1675: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   1678: invokevirtual 1911	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1681: checkcast 972	tencent/im/msg/im_msg_body$Text
    //   1684: astore 53
    //   1686: aconst_null
    //   1687: astore 51
    //   1689: aload 53
    //   1691: getfield 976	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1694: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1697: ifeq +28 -> 1725
    //   1700: aload 53
    //   1702: getfield 976	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1705: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1708: invokevirtual 1645	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1711: astore 51
    //   1713: aload 58
    //   1715: aload 51
    //   1717: iconst_0
    //   1718: invokestatic 2405	com/tencent/mobileqq/service/message/MessageUtils:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1721: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: iload 8
    //   1727: ifeq +264 -> 1991
    //   1730: aload 52
    //   1732: ifnull +259 -> 1991
    //   1735: aload 52
    //   1737: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1740: aload 51
    //   1742: putfield 1223	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   1745: aload 52
    //   1747: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1750: ifnull +16 -> 1766
    //   1753: aload 52
    //   1755: aload 52
    //   1757: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   1760: invokevirtual 2394	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   1763: putfield 2395	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   1766: aload 58
    //   1768: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   1771: ifle +38 -> 1809
    //   1774: sipush -1000
    //   1777: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1780: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   1783: astore_0
    //   1784: aload_0
    //   1785: sipush -1000
    //   1788: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   1791: aload_0
    //   1792: aload 58
    //   1794: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1797: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   1800: aload 57
    //   1802: aload_0
    //   1803: invokeinterface 375 2 0
    //   1808: pop
    //   1809: iload 14
    //   1811: ifle +74 -> 1885
    //   1814: aload 57
    //   1816: invokeinterface 2067 1 0
    //   1821: iconst_1
    //   1822: if_icmpne +63 -> 1885
    //   1825: aload 57
    //   1827: iconst_0
    //   1828: invokeinterface 1460 2 0
    //   1833: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   1836: astore_0
    //   1837: aload_0
    //   1838: instanceof 1238
    //   1841: ifeq +44 -> 1885
    //   1844: aload_0
    //   1845: iload 14
    //   1847: invokevirtual 2408	com/tencent/mobileqq/data/MessageRecord:setRepeatCount	(I)V
    //   1850: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1853: ifeq +32 -> 1885
    //   1856: ldc 13
    //   1858: iconst_2
    //   1859: new 91	java/lang/StringBuilder
    //   1862: dup
    //   1863: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   1866: ldc_w 2410
    //   1869: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1872: aload_0
    //   1873: invokevirtual 2413	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
    //   1876: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1885: iload 10
    //   1887: ifeq +8461 -> 10348
    //   1890: aload 57
    //   1892: invokeinterface 2067 1 0
    //   1897: iconst_1
    //   1898: isub
    //   1899: istore 9
    //   1901: aload 52
    //   1903: astore_0
    //   1904: iload 8
    //   1906: istore 7
    //   1908: iload 9
    //   1910: istore 8
    //   1912: iload 7
    //   1914: istore 9
    //   1916: aload_0
    //   1917: astore_2
    //   1918: iload 8
    //   1920: iflt +8435 -> 10355
    //   1923: aload 57
    //   1925: iload 8
    //   1927: invokeinterface 1460 2 0
    //   1932: instanceof 1193
    //   1935: ifeq +8265 -> 10200
    //   1938: iload 7
    //   1940: istore 9
    //   1942: aload_0
    //   1943: astore_2
    //   1944: iload 11
    //   1946: iconst_3
    //   1947: if_icmplt +29 -> 1976
    //   1950: aload 57
    //   1952: iload 8
    //   1954: invokeinterface 2416 2 0
    //   1959: pop
    //   1960: iload 7
    //   1962: istore 9
    //   1964: aload_0
    //   1965: astore_2
    //   1966: iload 7
    //   1968: ifeq +8 -> 1976
    //   1971: iconst_0
    //   1972: istore 9
    //   1974: aconst_null
    //   1975: astore_2
    //   1976: iload 8
    //   1978: iconst_1
    //   1979: isub
    //   1980: istore 8
    //   1982: iload 9
    //   1984: istore 7
    //   1986: aload_2
    //   1987: astore_0
    //   1988: goto -76 -> 1912
    //   1991: iload 9
    //   1993: ifne +14 -> 2007
    //   1996: iload 10
    //   1998: ifeq +29 -> 2027
    //   2001: iload 11
    //   2003: iconst_1
    //   2004: if_icmple +23 -> 2027
    //   2007: aload 58
    //   2009: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2012: ifle +15 -> 2027
    //   2015: aload 58
    //   2017: iconst_0
    //   2018: aload 58
    //   2020: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2023: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 60
    //   2029: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   2032: getfield 2419	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2035: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2038: ifeq +141 -> 2179
    //   2041: aload_2
    //   2042: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   2045: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2048: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2051: aload_0
    //   2052: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2055: invokevirtual 2422	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   2058: lcmp
    //   2059: ifeq +120 -> 2179
    //   2062: aload 5
    //   2064: ifnull +115 -> 2179
    //   2067: aload 5
    //   2069: getfield 2427	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2072: lload 39
    //   2074: invokevirtual 2432	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   2077: ifne +16 -> 2093
    //   2080: aload 5
    //   2082: getfield 2434	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2085: lload 39
    //   2087: invokevirtual 2432	com/tencent/mobileqq/troop/data/MessageNavInfo:a	(J)Z
    //   2090: ifeq +89 -> 2179
    //   2093: aload 60
    //   2095: getfield 984	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   2098: getfield 2419	tencent/im/msg/im_msg_body$Text:attr_6_buf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2101: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2104: astore 53
    //   2106: aload 53
    //   2108: ifnull +233 -> 2341
    //   2111: aload 53
    //   2113: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2116: astore 53
    //   2118: aload 53
    //   2120: ifnull +59 -> 2179
    //   2123: aload 53
    //   2125: arraylength
    //   2126: ifeq +53 -> 2179
    //   2129: aload 53
    //   2131: iconst_0
    //   2132: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   2135: istore 22
    //   2137: iconst_2
    //   2138: istore 15
    //   2140: iconst_0
    //   2141: istore 16
    //   2143: iload 16
    //   2145: iload 22
    //   2147: if_icmpge +32 -> 2179
    //   2150: iload 15
    //   2152: sipush 2048
    //   2155: if_icmpge +24 -> 2179
    //   2158: new 107	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo
    //   2161: dup
    //   2162: invokespecial 2435	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:<init>	()V
    //   2165: astore 54
    //   2167: aload 54
    //   2169: aload 53
    //   2171: iload 15
    //   2173: invokevirtual 2439	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:readFrom	([BI)Z
    //   2176: ifne +171 -> 2347
    //   2179: aload 47
    //   2181: astore 53
    //   2183: iload 12
    //   2185: istore 15
    //   2187: iload 6
    //   2189: istore 16
    //   2191: iload 11
    //   2193: istore 17
    //   2195: aload 48
    //   2197: astore 47
    //   2199: iload 7
    //   2201: istore 6
    //   2203: iload 13
    //   2205: istore 7
    //   2207: aload 49
    //   2209: astore 48
    //   2211: iload 8
    //   2213: istore 13
    //   2215: iload 9
    //   2217: istore 12
    //   2219: iload 10
    //   2221: istore 11
    //   2223: iload 17
    //   2225: istore 10
    //   2227: iload 16
    //   2229: istore 9
    //   2231: iload 15
    //   2233: istore 8
    //   2235: aload 53
    //   2237: astore 49
    //   2239: aload 60
    //   2241: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   2244: invokevirtual 77	tencent/im/msg/im_msg_body$ElemFlags2:has	()Z
    //   2247: ifeq +8666 -> 10913
    //   2250: aload 60
    //   2252: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   2255: getfield 2442	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2258: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2261: ifeq +8652 -> 10913
    //   2264: aload 60
    //   2266: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   2269: getfield 2442	tencent/im/msg/im_msg_body$ElemFlags2:uint32_msg_rpt_cnt	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2272: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2275: istore 15
    //   2277: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2280: ifeq +30 -> 2310
    //   2283: ldc 13
    //   2285: iconst_2
    //   2286: new 91	java/lang/StringBuilder
    //   2289: dup
    //   2290: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   2293: ldc_w 2444
    //   2296: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: iload 15
    //   2301: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2304: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2307: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2310: aload 48
    //   2312: astore 53
    //   2314: aload 47
    //   2316: astore 48
    //   2318: aload 52
    //   2320: astore 47
    //   2322: aload 49
    //   2324: astore 52
    //   2326: iload 8
    //   2328: istore 14
    //   2330: iload 15
    //   2332: istore 8
    //   2334: aload 53
    //   2336: astore 49
    //   2338: goto -1662 -> 676
    //   2341: aconst_null
    //   2342: astore 53
    //   2344: goto -226 -> 2118
    //   2347: iload 15
    //   2349: aload 54
    //   2351: invokevirtual 2445	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:length	()I
    //   2354: iadd
    //   2355: istore 17
    //   2357: aload 54
    //   2359: aload 54
    //   2361: getfield 114	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:startPos	S
    //   2364: iload 19
    //   2366: iadd
    //   2367: i2s
    //   2368: putfield 114	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:startPos	S
    //   2371: iload 16
    //   2373: iconst_1
    //   2374: iadd
    //   2375: i2s
    //   2376: istore 18
    //   2378: aload 54
    //   2380: invokevirtual 2448	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingAll	()Z
    //   2383: ifeq +13 -> 2396
    //   2386: aload 5
    //   2388: getfield 2434	com/tencent/mobileqq/troop/data/MessageInfo:c	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2391: lload 39
    //   2393: putfield 2450	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   2396: iload 18
    //   2398: istore 16
    //   2400: iload 17
    //   2402: istore 15
    //   2404: aload 54
    //   2406: aload_0
    //   2407: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2410: invokevirtual 2422	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   2413: invokevirtual 2453	com/tencent/mobileqq/data/MessageForText$AtTroopMemberInfo:isIncludingMe	(J)Z
    //   2416: ifeq -273 -> 2143
    //   2419: aload 5
    //   2421: getfield 2427	com/tencent/mobileqq/troop/data/MessageInfo:a	Lcom/tencent/mobileqq/troop/data/MessageNavInfo;
    //   2424: lload 39
    //   2426: putfield 2450	com/tencent/mobileqq/troop/data/MessageNavInfo:a	J
    //   2429: iload 18
    //   2431: istore 16
    //   2433: iload 17
    //   2435: istore 15
    //   2437: goto -294 -> 2143
    //   2440: aload 60
    //   2442: getfield 1189	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2445: invokevirtual 2454	tencent/im/msg/im_msg_body$ShakeWindow:has	()Z
    //   2448: ifeq +245 -> 2693
    //   2451: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2454: ifeq +12 -> 2466
    //   2457: aload 56
    //   2459: ldc_w 2456
    //   2462: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: pop
    //   2466: aload 60
    //   2468: getfield 1189	tencent/im/msg/im_msg_body$Elem:shake_window	Ltencent/im/msg/im_msg_body$ShakeWindow;
    //   2471: invokevirtual 2457	tencent/im/msg/im_msg_body$ShakeWindow:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2474: checkcast 1176	tencent/im/msg/im_msg_body$ShakeWindow
    //   2477: astore 53
    //   2479: sipush -2020
    //   2482: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   2485: checkcast 1170	com/tencent/mobileqq/data/MessageForShakeWindow
    //   2488: astore 54
    //   2490: aload 54
    //   2492: sipush -2020
    //   2495: putfield 2458	com/tencent/mobileqq/data/MessageForShakeWindow:msgtype	I
    //   2498: aload 54
    //   2500: ldc_w 2460
    //   2503: putfield 2461	com/tencent/mobileqq/data/MessageForShakeWindow:msg	Ljava/lang/String;
    //   2506: aload 58
    //   2508: iconst_0
    //   2509: aload 58
    //   2511: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   2514: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   2517: pop
    //   2518: new 1182	com/tencent/mobileqq/data/ShakeWindowMsg
    //   2521: dup
    //   2522: invokespecial 2462	com/tencent/mobileqq/data/ShakeWindowMsg:<init>	()V
    //   2525: astore 55
    //   2527: aload 55
    //   2529: aload 53
    //   2531: getfield 1180	tencent/im/msg/im_msg_body$ShakeWindow:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2534: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2537: putfield 1185	com/tencent/mobileqq/data/ShakeWindowMsg:mType	I
    //   2540: aload 55
    //   2542: aload 53
    //   2544: getfield 2465	tencent/im/msg/im_msg_body$ShakeWindow:uint32_reserve	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2547: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2550: putfield 2468	com/tencent/mobileqq/data/ShakeWindowMsg:mReserve	I
    //   2553: iload 4
    //   2555: ifeq +119 -> 2674
    //   2558: iconst_2
    //   2559: istore 15
    //   2561: aload 55
    //   2563: iload 15
    //   2565: putfield 2471	com/tencent/mobileqq/data/ShakeWindowMsg:onlineFlag	I
    //   2568: aload 55
    //   2570: iconst_1
    //   2571: putfield 2474	com/tencent/mobileqq/data/ShakeWindowMsg:shake	Z
    //   2574: aload 54
    //   2576: aload 55
    //   2578: invokevirtual 2475	com/tencent/mobileqq/data/ShakeWindowMsg:getBytes	()[B
    //   2581: putfield 2476	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2584: aload 54
    //   2586: getfield 2476	com/tencent/mobileqq/data/MessageForShakeWindow:msgData	[B
    //   2589: ifnonnull +91 -> 2680
    //   2592: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2595: ifeq +12 -> 2607
    //   2598: aload 56
    //   2600: ldc_w 2400
    //   2603: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2606: pop
    //   2607: iload 10
    //   2609: istore 15
    //   2611: iload 9
    //   2613: istore 16
    //   2615: iload 8
    //   2617: istore 17
    //   2619: iload 13
    //   2621: istore 18
    //   2623: aload 49
    //   2625: astore 53
    //   2627: aload 47
    //   2629: astore 49
    //   2631: iload 12
    //   2633: istore 8
    //   2635: iload 6
    //   2637: istore 9
    //   2639: iload 11
    //   2641: istore 10
    //   2643: iload 15
    //   2645: istore 11
    //   2647: iload 16
    //   2649: istore 12
    //   2651: iload 17
    //   2653: istore 13
    //   2655: aload 48
    //   2657: astore 47
    //   2659: iload 7
    //   2661: istore 6
    //   2663: iload 18
    //   2665: istore 7
    //   2667: aload 53
    //   2669: astore 48
    //   2671: goto -432 -> 2239
    //   2674: iconst_1
    //   2675: istore 15
    //   2677: goto -116 -> 2561
    //   2680: aload 57
    //   2682: aload 54
    //   2684: invokeinterface 375 2 0
    //   2689: pop
    //   2690: goto -924 -> 1766
    //   2693: aload 60
    //   2695: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2698: invokevirtual 2477	tencent/im/msg/im_msg_body$Face:has	()Z
    //   2701: ifeq +167 -> 2868
    //   2704: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2707: ifeq +12 -> 2719
    //   2710: aload 56
    //   2712: ldc_w 2479
    //   2715: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2718: pop
    //   2719: aload 47
    //   2721: astore 53
    //   2723: aload 60
    //   2725: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2728: invokevirtual 2480	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2731: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2734: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2737: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2740: ifeq +7397 -> 10137
    //   2743: aload 60
    //   2745: getfield 178	tencent/im/msg/im_msg_body$Elem:face	Ltencent/im/msg/im_msg_body$Face;
    //   2748: invokevirtual 2480	tencent/im/msg/im_msg_body$Face:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2751: checkcast 165	tencent/im/msg/im_msg_body$Face
    //   2754: getfield 169	tencent/im/msg/im_msg_body$Face:index	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2757: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2760: istore 15
    //   2762: iload 15
    //   2764: getstatic 2482	com/tencent/mobileqq/service/message/MessageUtils:b	[S
    //   2767: arraylength
    //   2768: if_icmpge +33 -> 2801
    //   2771: getstatic 2482	com/tencent/mobileqq/service/message/MessageUtils:b	[S
    //   2774: iload 15
    //   2776: saload
    //   2777: istore 15
    //   2779: iload 15
    //   2781: iflt +20 -> 2801
    //   2784: aload 58
    //   2786: bipush 20
    //   2788: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2791: pop
    //   2792: aload 58
    //   2794: iload 15
    //   2796: i2c
    //   2797: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2800: pop
    //   2801: iload 10
    //   2803: istore 15
    //   2805: iload 9
    //   2807: istore 16
    //   2809: iload 8
    //   2811: istore 17
    //   2813: iload 13
    //   2815: istore 18
    //   2817: aload 49
    //   2819: astore 53
    //   2821: aload 47
    //   2823: astore 49
    //   2825: iload 12
    //   2827: istore 8
    //   2829: iload 6
    //   2831: istore 9
    //   2833: iload 11
    //   2835: istore 10
    //   2837: iload 15
    //   2839: istore 11
    //   2841: iload 16
    //   2843: istore 12
    //   2845: iload 17
    //   2847: istore 13
    //   2849: aload 48
    //   2851: astore 47
    //   2853: iload 7
    //   2855: istore 6
    //   2857: iload 18
    //   2859: istore 7
    //   2861: aload 53
    //   2863: astore 48
    //   2865: goto -626 -> 2239
    //   2868: aload 60
    //   2870: getfield 2486	tencent/im/msg/im_msg_body$Elem:online_image	Ltencent/im/msg/im_msg_body$OnlineImage;
    //   2873: invokevirtual 2489	tencent/im/msg/im_msg_body$OnlineImage:has	()Z
    //   2876: ifeq +108 -> 2984
    //   2879: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2882: ifeq +12 -> 2894
    //   2885: aload 56
    //   2887: ldc_w 2491
    //   2890: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: pop
    //   2894: aload 47
    //   2896: astore 53
    //   2898: iload 7
    //   2900: ifne +7237 -> 10137
    //   2903: aload 58
    //   2905: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   2908: ldc_w 2492
    //   2911: invokevirtual 1863	android/content/Context:getString	(I)Ljava/lang/String;
    //   2914: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2917: pop
    //   2918: iload 10
    //   2920: istore 15
    //   2922: iload 9
    //   2924: istore 16
    //   2926: iload 8
    //   2928: istore 17
    //   2930: iconst_1
    //   2931: istore 18
    //   2933: iload 13
    //   2935: istore 7
    //   2937: aload 49
    //   2939: astore 53
    //   2941: aload 47
    //   2943: astore 49
    //   2945: iload 12
    //   2947: istore 8
    //   2949: iload 6
    //   2951: istore 9
    //   2953: iload 11
    //   2955: istore 10
    //   2957: iload 15
    //   2959: istore 11
    //   2961: iload 16
    //   2963: istore 12
    //   2965: iload 17
    //   2967: istore 13
    //   2969: aload 48
    //   2971: astore 47
    //   2973: iload 18
    //   2975: istore 6
    //   2977: aload 53
    //   2979: astore 48
    //   2981: goto -742 -> 2239
    //   2984: aload 60
    //   2986: getfield 1868	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   2989: invokevirtual 1871	tencent/im/msg/im_msg_body$NotOnlineImage:has	()Z
    //   2992: ifeq +1114 -> 4106
    //   2995: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2998: ifeq +12 -> 3010
    //   3001: aload 56
    //   3003: ldc_w 2494
    //   3006: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3009: pop
    //   3010: aload 58
    //   3012: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   3015: ifle +54 -> 3069
    //   3018: sipush -1000
    //   3021: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3024: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   3027: astore 53
    //   3029: aload 53
    //   3031: sipush -1000
    //   3034: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   3037: aload 53
    //   3039: aload 58
    //   3041: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3044: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   3047: aload 57
    //   3049: aload 53
    //   3051: invokeinterface 375 2 0
    //   3056: pop
    //   3057: aload 58
    //   3059: iconst_0
    //   3060: aload 58
    //   3062: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   3065: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   3068: pop
    //   3069: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3072: ldc_w 2492
    //   3075: invokevirtual 1863	android/content/Context:getString	(I)Ljava/lang/String;
    //   3078: pop
    //   3079: aload 60
    //   3081: getfield 1868	tencent/im/msg/im_msg_body$Elem:not_online_image	Ltencent/im/msg/im_msg_body$NotOnlineImage;
    //   3084: invokevirtual 1876	tencent/im/msg/im_msg_body$NotOnlineImage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3087: checkcast 1870	tencent/im/msg/im_msg_body$NotOnlineImage
    //   3090: astore 61
    //   3092: aload 61
    //   3094: getfield 1879	tencent/im/msg/im_msg_body$NotOnlineImage:file_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3097: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3100: istore 16
    //   3102: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3105: ifeq +30 -> 3135
    //   3108: ldc 13
    //   3110: iconst_2
    //   3111: new 91	java/lang/StringBuilder
    //   3114: dup
    //   3115: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3118: ldc_w 2496
    //   3121: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3124: iload 16
    //   3126: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3129: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3132: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3135: aload 61
    //   3137: getfield 2499	tencent/im/msg/im_msg_body$NotOnlineImage:flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3140: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3143: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3146: pop
    //   3147: aload 61
    //   3149: getfield 2500	tencent/im/msg/im_msg_body$NotOnlineImage:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3152: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3155: astore 62
    //   3157: aload 61
    //   3159: getfield 2503	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3162: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3165: istore 17
    //   3167: aload 61
    //   3169: getfield 2506	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3172: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3175: istore 18
    //   3177: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3180: ifeq +41 -> 3221
    //   3183: ldc 13
    //   3185: iconst_2
    //   3186: new 91	java/lang/StringBuilder
    //   3189: dup
    //   3190: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3193: ldc_w 2508
    //   3196: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: iload 17
    //   3201: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3204: ldc_w 2510
    //   3207: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3210: iload 18
    //   3212: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3215: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3218: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3221: aload 61
    //   3223: getfield 2511	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3226: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3229: ifeq +7798 -> 11027
    //   3232: aload 61
    //   3234: getfield 2511	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3237: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3240: istore 15
    //   3242: aload 61
    //   3244: getfield 2512	tencent/im/msg/im_msg_body$NotOnlineImage:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3247: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3250: astore 63
    //   3252: aload 61
    //   3254: getfield 2513	tencent/im/msg/im_msg_body$NotOnlineImage:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3257: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3260: astore 64
    //   3262: aload 61
    //   3264: getfield 2516	tencent/im/msg/im_msg_body$NotOnlineImage:pic_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3267: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3270: istore 19
    //   3272: aload 61
    //   3274: getfield 2519	tencent/im/msg/im_msg_body$NotOnlineImage:pic_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3277: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3280: istore 22
    //   3282: aload 61
    //   3284: getfield 2522	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_show_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3287: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3290: istore 23
    //   3292: aload 61
    //   3294: getfield 2525	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_download_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3297: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3300: istore 24
    //   3302: invokestatic 843	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3305: ifeq +53 -> 3358
    //   3308: ldc_w 2527
    //   3311: iconst_4
    //   3312: new 91	java/lang/StringBuilder
    //   3315: dup
    //   3316: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3319: ldc_w 2529
    //   3322: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3325: iload 23
    //   3327: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3330: ldc_w 2531
    //   3333: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3336: iload 24
    //   3338: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3341: ldc_w 2533
    //   3344: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3347: iload 16
    //   3349: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3352: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3355: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3358: aload 61
    //   3360: getfield 2536	tencent/im/msg/im_msg_body$NotOnlineImage:original	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3363: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3366: istore 25
    //   3368: aload 61
    //   3370: getfield 2539	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3373: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3376: ifeq +478 -> 3854
    //   3379: aload 61
    //   3381: getfield 2539	tencent/im/msg/im_msg_body$NotOnlineImage:res_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3384: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3387: invokevirtual 1645	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3390: astore 53
    //   3392: aload 53
    //   3394: ifnull +487 -> 3881
    //   3397: aload 53
    //   3399: ldc_w 281
    //   3402: invokevirtual 436	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3405: ifne +476 -> 3881
    //   3408: ldc_w 281
    //   3411: astore 55
    //   3413: aload 55
    //   3415: astore 54
    //   3417: aload 61
    //   3419: getfield 2542	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3422: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3425: ifeq +42 -> 3467
    //   3428: aload 61
    //   3430: getfield 2542	tencent/im/msg/im_msg_body$NotOnlineImage:pic_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3433: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3436: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3439: astore 65
    //   3441: aload 55
    //   3443: astore 54
    //   3445: aload 65
    //   3447: ifnull +20 -> 3467
    //   3450: aload 55
    //   3452: astore 54
    //   3454: aload 65
    //   3456: arraylength
    //   3457: ifle +10 -> 3467
    //   3460: aload 65
    //   3462: invokestatic 411	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   3465: astore 54
    //   3467: aload 53
    //   3469: iload 16
    //   3471: i2l
    //   3472: iconst_1
    //   3473: iconst_0
    //   3474: aload 53
    //   3476: aload 54
    //   3478: ldc_w 2544
    //   3481: aload 62
    //   3483: aload 63
    //   3485: aload 64
    //   3487: iload 25
    //   3489: iconst_0
    //   3490: invokestatic 2547	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   3493: astore 65
    //   3495: new 377	localpb/richMsg/RichMsg$PicRec
    //   3498: dup
    //   3499: invokespecial 378	localpb/richMsg/RichMsg$PicRec:<init>	()V
    //   3502: astore 55
    //   3504: aload 55
    //   3506: getfield 1668	localpb/richMsg/RichMsg$PicRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3509: aload 53
    //   3511: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3514: aload 55
    //   3516: getfield 1670	localpb/richMsg/RichMsg$PicRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3519: iload 16
    //   3521: i2l
    //   3522: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   3525: aload 55
    //   3527: getfield 1673	localpb/richMsg/RichMsg$PicRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3530: iconst_1
    //   3531: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3534: aload 55
    //   3536: getfield 1676	localpb/richMsg/RichMsg$PicRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   3539: iconst_0
    //   3540: invokevirtual 835	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   3543: aload 55
    //   3545: getfield 1679	localpb/richMsg/RichMsg$PicRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3548: aload 53
    //   3550: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3553: aload 55
    //   3555: getfield 2550	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3558: aload 54
    //   3560: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3563: aload 55
    //   3565: getfield 1682	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3568: ldc_w 2544
    //   3571: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3574: aload 55
    //   3576: getfield 2553	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3579: aload 62
    //   3581: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3584: aload 55
    //   3586: getfield 2554	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3589: iload 17
    //   3591: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3594: aload 55
    //   3596: getfield 2555	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3599: iload 18
    //   3601: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3604: aload 55
    //   3606: getfield 2558	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3609: iload 19
    //   3611: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3614: aload 55
    //   3616: getfield 2561	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3619: iload 22
    //   3621: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3624: aload 61
    //   3626: getfield 2511	tencent/im/msg/im_msg_body$NotOnlineImage:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3629: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3632: ifeq +14 -> 3646
    //   3635: aload 55
    //   3637: getfield 2564	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3640: iload 15
    //   3642: i2l
    //   3643: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   3646: aload 55
    //   3648: getfield 2567	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3651: aload 63
    //   3653: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3656: aload 55
    //   3658: getfield 2570	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3661: aload 64
    //   3663: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   3666: aload 55
    //   3668: getfield 2573	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3671: iload 25
    //   3673: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3676: aload 55
    //   3678: getfield 2576	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3681: iconst_0
    //   3682: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3685: aload 55
    //   3687: getfield 1688	localpb/richMsg/RichMsg$PicRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3690: iconst_5
    //   3691: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3694: aload 55
    //   3696: getfield 1694	localpb/richMsg/RichMsg$PicRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3699: iconst_0
    //   3700: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   3703: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3706: ifeq +17 -> 3723
    //   3709: aload 56
    //   3711: ldc_w 2578
    //   3714: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3717: aload 65
    //   3719: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3722: pop
    //   3723: aload 55
    //   3725: getfield 2579	localpb/richMsg/RichMsg$PicRec:uint32_show_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3728: iload 23
    //   3730: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3733: aload 55
    //   3735: getfield 2580	localpb/richMsg/RichMsg$PicRec:uint32_download_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3738: iload 24
    //   3740: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3743: sipush -2000
    //   3746: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   3749: checkcast 988	com/tencent/mobileqq/data/MessageForPic
    //   3752: astore 53
    //   3754: aload 53
    //   3756: sipush -2000
    //   3759: putfield 1695	com/tencent/mobileqq/data/MessageForPic:msgtype	I
    //   3762: aload 53
    //   3764: aload 55
    //   3766: invokevirtual 1696	localpb/richMsg/RichMsg$PicRec:toByteArray	()[B
    //   3769: putfield 1697	com/tencent/mobileqq/data/MessageForPic:msgData	[B
    //   3772: aload 53
    //   3774: invokevirtual 1698	com/tencent/mobileqq/data/MessageForPic:parse	()V
    //   3777: aload 57
    //   3779: aload 53
    //   3781: invokeinterface 375 2 0
    //   3786: pop
    //   3787: iload 10
    //   3789: istore 15
    //   3791: iload 9
    //   3793: istore 16
    //   3795: iload 8
    //   3797: istore 17
    //   3799: iload 13
    //   3801: istore 18
    //   3803: aload 49
    //   3805: astore 53
    //   3807: aload 47
    //   3809: astore 49
    //   3811: iload 12
    //   3813: istore 8
    //   3815: iload 6
    //   3817: istore 9
    //   3819: iload 11
    //   3821: istore 10
    //   3823: iload 15
    //   3825: istore 11
    //   3827: iload 16
    //   3829: istore 12
    //   3831: iload 17
    //   3833: istore 13
    //   3835: aload 48
    //   3837: astore 47
    //   3839: iload 7
    //   3841: istore 6
    //   3843: iload 18
    //   3845: istore 7
    //   3847: aload 53
    //   3849: astore 48
    //   3851: goto -1612 -> 2239
    //   3854: aload 61
    //   3856: getfield 1882	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3859: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3862: ifeq +7159 -> 11021
    //   3865: aload 61
    //   3867: getfield 1882	tencent/im/msg/im_msg_body$NotOnlineImage:download_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3870: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3873: invokevirtual 1645	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3876: astore 53
    //   3878: goto -486 -> 3392
    //   3881: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3884: ifeq +30 -> 3914
    //   3887: aload 56
    //   3889: new 91	java/lang/StringBuilder
    //   3892: dup
    //   3893: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   3896: ldc_w 2582
    //   3899: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: aload 53
    //   3904: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3907: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3910: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3913: pop
    //   3914: aload_2
    //   3915: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   3918: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3921: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   3924: astore 53
    //   3926: aload 53
    //   3928: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3931: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3934: i2l
    //   3935: lstore 31
    //   3937: aload 53
    //   3939: getfield 1368	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3942: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3945: lstore 33
    //   3947: aload 53
    //   3949: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3952: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3955: i2l
    //   3956: lstore 35
    //   3958: aload 53
    //   3960: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3963: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3966: lstore 37
    //   3968: aload 53
    //   3970: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3973: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3976: lstore 41
    //   3978: new 2584	java/util/HashMap
    //   3981: dup
    //   3982: invokespecial 2585	java/util/HashMap:<init>	()V
    //   3985: astore 53
    //   3987: aload 53
    //   3989: ldc_w 2587
    //   3992: sipush 10002
    //   3995: invokestatic 2589	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3998: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4001: pop
    //   4002: aload 53
    //   4004: ldc_w 2595
    //   4007: lload 37
    //   4009: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4012: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4015: pop
    //   4016: aload 53
    //   4018: ldc_w 2597
    //   4021: lload 41
    //   4023: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4026: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4029: pop
    //   4030: aload 53
    //   4032: ldc_w 2599
    //   4035: lload 31
    //   4037: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4040: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4043: pop
    //   4044: aload 53
    //   4046: ldc_w 2600
    //   4049: lload 33
    //   4051: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4054: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4057: pop
    //   4058: aload 53
    //   4060: ldc_w 2602
    //   4063: lload 35
    //   4065: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   4068: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   4071: pop
    //   4072: aload_0
    //   4073: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4076: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   4079: astore 54
    //   4081: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   4084: invokestatic 2607	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   4087: aload 54
    //   4089: ldc_w 2609
    //   4092: iconst_0
    //   4093: lconst_0
    //   4094: lconst_0
    //   4095: aload 53
    //   4097: ldc_w 281
    //   4100: invokevirtual 2612	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   4103: goto -316 -> 3787
    //   4106: aload 60
    //   4108: getfield 2616	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   4111: invokevirtual 2619	tencent/im/msg/im_msg_body$TransElem:has	()Z
    //   4114: ifeq +1414 -> 5528
    //   4117: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4120: ifeq +12 -> 4132
    //   4123: aload 56
    //   4125: ldc_w 2621
    //   4128: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4131: pop
    //   4132: aload 60
    //   4134: getfield 2616	tencent/im/msg/im_msg_body$Elem:trans_elem_info	Ltencent/im/msg/im_msg_body$TransElem;
    //   4137: invokevirtual 2622	tencent/im/msg/im_msg_body$TransElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4140: checkcast 2618	tencent/im/msg/im_msg_body$TransElem
    //   4143: astore 53
    //   4145: aload 53
    //   4147: getfield 2625	tencent/im/msg/im_msg_body$TransElem:elem_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4150: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4153: istore 15
    //   4155: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4158: ifeq +23 -> 4181
    //   4161: aload 56
    //   4163: ldc_w 2627
    //   4166: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4169: iload 15
    //   4171: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4174: ldc_w 1652
    //   4177: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4180: pop
    //   4181: aload 58
    //   4183: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4186: ifle +60 -> 4246
    //   4189: iload 15
    //   4191: iconst_3
    //   4192: if_icmpeq +54 -> 4246
    //   4195: sipush -1000
    //   4198: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4201: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   4204: astore 54
    //   4206: aload 54
    //   4208: sipush -1000
    //   4211: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   4214: aload 54
    //   4216: aload 58
    //   4218: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4221: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   4224: aload 57
    //   4226: aload 54
    //   4228: invokeinterface 375 2 0
    //   4233: pop
    //   4234: aload 58
    //   4236: iconst_0
    //   4237: aload 58
    //   4239: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4242: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   4245: pop
    //   4246: aload 53
    //   4248: getfield 2630	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4251: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4254: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4257: astore 54
    //   4259: aload 54
    //   4261: ifnull +9 -> 4270
    //   4264: aload 54
    //   4266: arraylength
    //   4267: ifne +79 -> 4346
    //   4270: aload 56
    //   4272: ldc_w 2632
    //   4275: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4278: pop
    //   4279: iload 10
    //   4281: istore 15
    //   4283: iload 9
    //   4285: istore 16
    //   4287: aload 52
    //   4289: astore 53
    //   4291: iload 13
    //   4293: istore 17
    //   4295: iload 14
    //   4297: istore 18
    //   4299: aload 47
    //   4301: astore 52
    //   4303: iload 12
    //   4305: istore 14
    //   4307: iload 6
    //   4309: istore 9
    //   4311: iload 11
    //   4313: istore 10
    //   4315: iload 15
    //   4317: istore 11
    //   4319: iload 16
    //   4321: istore 12
    //   4323: iload 8
    //   4325: istore 13
    //   4327: aload 53
    //   4329: astore 47
    //   4331: iload 7
    //   4333: istore 6
    //   4335: iload 17
    //   4337: istore 7
    //   4339: iload 18
    //   4341: istore 8
    //   4343: goto -3667 -> 676
    //   4346: iload 15
    //   4348: lookupswitch	default:+36->4384, 3:+107->4455, 16:+145->4493, 24:+512->4860
    //   4385: iconst_4
    //   4386: istore 18
    //   4388: aload 48
    //   4390: astore 53
    //   4392: iload 10
    //   4394: istore 7
    //   4396: iload 9
    //   4398: istore 15
    //   4400: iload 8
    //   4402: istore 16
    //   4404: iload 13
    //   4406: istore 17
    //   4408: aload 49
    //   4410: astore 48
    //   4412: aload 47
    //   4414: astore 49
    //   4416: iload 12
    //   4418: istore 8
    //   4420: iload 6
    //   4422: istore 9
    //   4424: iload 11
    //   4426: istore 10
    //   4428: iload 7
    //   4430: istore 11
    //   4432: iload 15
    //   4434: istore 12
    //   4436: iload 16
    //   4438: istore 13
    //   4440: aload 53
    //   4442: astore 47
    //   4444: iload 18
    //   4446: istore 6
    //   4448: iload 17
    //   4450: istore 7
    //   4452: goto -2213 -> 2239
    //   4455: aload 48
    //   4457: astore 53
    //   4459: iload 7
    //   4461: istore 18
    //   4463: iload 7
    //   4465: ifne -73 -> 4392
    //   4468: aload 58
    //   4470: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   4473: ldc_w 2492
    //   4476: invokevirtual 1863	android/content/Context:getString	(I)Ljava/lang/String;
    //   4479: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4482: pop
    //   4483: iconst_1
    //   4484: istore 18
    //   4486: aload 48
    //   4488: astore 53
    //   4490: goto -98 -> 4392
    //   4493: aload 48
    //   4495: astore 53
    //   4497: iload 7
    //   4499: istore 18
    //   4501: aload 54
    //   4503: iconst_0
    //   4504: baload
    //   4505: iconst_1
    //   4506: if_icmpne -114 -> 4392
    //   4509: aload 54
    //   4511: iconst_1
    //   4512: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   4515: istore 15
    //   4517: aload 54
    //   4519: iconst_3
    //   4520: baload
    //   4521: istore 16
    //   4523: iload 15
    //   4525: iconst_1
    //   4526: isub
    //   4527: newarray byte
    //   4529: astore 53
    //   4531: aload 53
    //   4533: iconst_0
    //   4534: aload 54
    //   4536: iconst_4
    //   4537: iload 15
    //   4539: iconst_1
    //   4540: isub
    //   4541: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   4544: aload 53
    //   4546: astore 55
    //   4548: iload 16
    //   4550: iconst_1
    //   4551: if_icmpne +10 -> 4561
    //   4554: aload 53
    //   4556: invokestatic 2635	com/tencent/mobileqq/service/message/MessageProtoCodec:a	([B)[B
    //   4559: astore 55
    //   4561: aload 48
    //   4563: astore 53
    //   4565: aload 55
    //   4567: ifnull +193 -> 4760
    //   4570: aload 48
    //   4572: astore 54
    //   4574: aload 48
    //   4576: astore 53
    //   4578: aload 55
    //   4580: arraylength
    //   4581: ifle +179 -> 4760
    //   4584: aload 48
    //   4586: astore 54
    //   4588: new 94	java/lang/String
    //   4591: dup
    //   4592: aload 55
    //   4594: ldc_w 1402
    //   4597: invokespecial 1405	java/lang/String:<init>	([BLjava/lang/String;)V
    //   4600: astore 53
    //   4602: aload 48
    //   4604: astore 54
    //   4606: aload 58
    //   4608: aload 53
    //   4610: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4613: pop
    //   4614: aload 48
    //   4616: astore 54
    //   4618: aload 53
    //   4620: invokestatic 2636	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/PAMessage;
    //   4623: astore 48
    //   4625: aload 48
    //   4627: astore 53
    //   4629: aload 48
    //   4631: ifnull +129 -> 4760
    //   4634: aload 48
    //   4636: astore 54
    //   4638: aload 59
    //   4640: invokeinterface 59 1 0
    //   4645: astore 55
    //   4647: aload 48
    //   4649: astore 54
    //   4651: aload 48
    //   4653: astore 53
    //   4655: aload 55
    //   4657: invokeinterface 64 1 0
    //   4662: ifeq +98 -> 4760
    //   4665: aload 48
    //   4667: astore 54
    //   4669: aload 55
    //   4671: invokeinterface 68 1 0
    //   4676: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   4679: astore 53
    //   4681: aload 48
    //   4683: astore 54
    //   4685: aload 53
    //   4687: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   4690: invokevirtual 77	tencent/im/msg/im_msg_body$ElemFlags2:has	()Z
    //   4693: ifeq -46 -> 4647
    //   4696: aload 48
    //   4698: astore 54
    //   4700: aload 53
    //   4702: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   4705: invokevirtual 78	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4708: checkcast 76	tencent/im/msg/im_msg_body$ElemFlags2
    //   4711: getfield 2639	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4714: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4717: ifeq -70 -> 4647
    //   4720: aload 48
    //   4722: astore 54
    //   4724: aload 48
    //   4726: aload 53
    //   4728: getfield 74	tencent/im/msg/im_msg_body$Elem:elem_flags2	Ltencent/im/msg/im_msg_body$ElemFlags2;
    //   4731: invokevirtual 78	tencent/im/msg/im_msg_body$ElemFlags2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4734: checkcast 76	tencent/im/msg/im_msg_body$ElemFlags2
    //   4737: getfield 2639	tencent/im/msg/im_msg_body$ElemFlags2:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4740: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4743: putfield 2644	com/tencent/mobileqq/data/PAMessage:mMsgId	J
    //   4746: goto -99 -> 4647
    //   4749: astore 48
    //   4751: aload 48
    //   4753: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   4756: aload 54
    //   4758: astore 53
    //   4760: aload 53
    //   4762: ifnull +59 -> 4821
    //   4765: sipush -3006
    //   4768: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   4771: checkcast 2382	com/tencent/mobileqq/data/MessageForPubAccount
    //   4774: astore 48
    //   4776: aload 48
    //   4778: sipush -3006
    //   4781: putfield 2383	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   4784: aload 48
    //   4786: aload 58
    //   4788: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4791: putfield 2384	com/tencent/mobileqq/data/MessageForPubAccount:msg	Ljava/lang/String;
    //   4794: aload 48
    //   4796: aload 53
    //   4798: putfield 2388	com/tencent/mobileqq/data/MessageForPubAccount:mPAMessage	Lcom/tencent/mobileqq/data/PAMessage;
    //   4801: aload 48
    //   4803: aload 53
    //   4805: invokestatic 2391	com/tencent/biz/pubaccount/util/PAMessageUtil:a	(Lcom/tencent/mobileqq/data/PAMessage;)[B
    //   4808: putfield 2392	com/tencent/mobileqq/data/MessageForPubAccount:msgData	[B
    //   4811: aload 57
    //   4813: aload 48
    //   4815: invokeinterface 375 2 0
    //   4820: pop
    //   4821: aload 58
    //   4823: iconst_0
    //   4824: aload 58
    //   4826: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   4829: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   4832: pop
    //   4833: iload 7
    //   4835: istore 18
    //   4837: goto -445 -> 4392
    //   4840: astore 54
    //   4842: aload 54
    //   4844: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   4847: goto -46 -> 4801
    //   4850: astore 54
    //   4852: aload 54
    //   4854: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   4857: goto -46 -> 4811
    //   4860: aload 53
    //   4862: getfield 2630	tencent/im/msg/im_msg_body$TransElem:elem_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4865: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4868: invokevirtual 1925	com/tencent/mobileqq/pb/ByteStringMicro:size	()I
    //   4871: istore 17
    //   4873: iconst_0
    //   4874: istore 16
    //   4876: iconst_0
    //   4877: istore 15
    //   4879: aload 48
    //   4881: astore 53
    //   4883: iload 7
    //   4885: istore 18
    //   4887: iload 17
    //   4889: iconst_3
    //   4890: if_icmple -498 -> 4392
    //   4893: iload 16
    //   4895: iconst_1
    //   4896: iadd
    //   4897: istore 19
    //   4899: aload 48
    //   4901: astore 53
    //   4903: iload 7
    //   4905: istore 18
    //   4907: iload 16
    //   4909: bipush 100
    //   4911: if_icmpgt -519 -> 4392
    //   4914: aload 54
    //   4916: iload 15
    //   4918: baload
    //   4919: istore 18
    //   4921: aload 54
    //   4923: iload 15
    //   4925: iconst_1
    //   4926: iadd
    //   4927: invokestatic 313	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)S
    //   4930: istore 22
    //   4932: iload 17
    //   4934: iload 22
    //   4936: iconst_3
    //   4937: iadd
    //   4938: isub
    //   4939: istore 16
    //   4941: iload 22
    //   4943: iconst_3
    //   4944: iadd
    //   4945: iload 15
    //   4947: iadd
    //   4948: istore 17
    //   4950: iload 18
    //   4952: iconst_1
    //   4953: if_icmpeq +18 -> 4971
    //   4956: iload 17
    //   4958: istore 15
    //   4960: iload 16
    //   4962: istore 17
    //   4964: iload 19
    //   4966: istore 16
    //   4968: goto -89 -> 4879
    //   4971: iload 22
    //   4973: newarray byte
    //   4975: astore 53
    //   4977: aload 53
    //   4979: iconst_0
    //   4980: aload 54
    //   4982: iload 15
    //   4984: iconst_3
    //   4985: iadd
    //   4986: iload 22
    //   4988: invokestatic 316	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   4991: new 2646	tencent/im/msg/obj_msg$ObjMsg
    //   4994: dup
    //   4995: invokespecial 2647	tencent/im/msg/obj_msg$ObjMsg:<init>	()V
    //   4998: astore 55
    //   5000: aload 55
    //   5002: aload 53
    //   5004: invokevirtual 2648	tencent/im/msg/obj_msg$ObjMsg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5007: checkcast 2646	tencent/im/msg/obj_msg$ObjMsg
    //   5010: astore 53
    //   5012: aload 53
    //   5014: getfield 2651	tencent/im/msg/obj_msg$ObjMsg:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5017: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5020: i2l
    //   5021: ldc2_w 2652
    //   5024: lcmp
    //   5025: ifeq +35 -> 5060
    //   5028: iload 17
    //   5030: istore 15
    //   5032: iload 16
    //   5034: istore 17
    //   5036: iload 19
    //   5038: istore 16
    //   5040: goto -161 -> 4879
    //   5043: astore 53
    //   5045: iload 17
    //   5047: istore 15
    //   5049: iload 16
    //   5051: istore 17
    //   5053: iload 19
    //   5055: istore 16
    //   5057: goto -178 -> 4879
    //   5060: new 2655	com/tencent/mobileqq/data/TroopFileData
    //   5063: dup
    //   5064: invokespecial 2656	com/tencent/mobileqq/data/TroopFileData:<init>	()V
    //   5067: astore 54
    //   5069: aload 54
    //   5071: new 94	java/lang/String
    //   5074: dup
    //   5075: aload 53
    //   5077: getfield 2659	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5080: iconst_0
    //   5081: invokevirtual 2662	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5084: checkcast 2664	tencent/im/msg/obj_msg$MsgContentInfo
    //   5087: getfield 2668	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   5090: getfield 2673	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:bytes_file_path	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5093: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5096: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5099: invokespecial 2675	java/lang/String:<init>	([B)V
    //   5102: putfield 2678	com/tencent/mobileqq/data/TroopFileData:fileUrl	Ljava/lang/String;
    //   5105: aload 54
    //   5107: aload 53
    //   5109: getfield 2659	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5112: iconst_0
    //   5113: invokevirtual 2662	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5116: checkcast 2664	tencent/im/msg/obj_msg$MsgContentInfo
    //   5119: getfield 2668	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   5122: getfield 2681	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint32_bus_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5125: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5128: putfield 2684	com/tencent/mobileqq/data/TroopFileData:bisID	I
    //   5131: aload 54
    //   5133: aload 53
    //   5135: getfield 2659	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5138: iconst_0
    //   5139: invokevirtual 2662	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5142: checkcast 2664	tencent/im/msg/obj_msg$MsgContentInfo
    //   5145: getfield 2668	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   5148: getfield 2687	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:str_file_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   5151: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   5154: putfield 2690	com/tencent/mobileqq/data/TroopFileData:fileName	Ljava/lang/String;
    //   5157: aload 54
    //   5159: aload 53
    //   5161: getfield 2659	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5164: iconst_0
    //   5165: invokevirtual 2662	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5168: checkcast 2664	tencent/im/msg/obj_msg$MsgContentInfo
    //   5171: getfield 2668	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   5174: getfield 2691	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5177: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5180: putfield 2694	com/tencent/mobileqq/data/TroopFileData:lfileSize	J
    //   5183: aload 54
    //   5185: aload 53
    //   5187: getfield 2659	tencent/im/msg/obj_msg$ObjMsg:msg_content_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5190: iconst_0
    //   5191: invokevirtual 2662	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5194: checkcast 2664	tencent/im/msg/obj_msg$MsgContentInfo
    //   5197: getfield 2668	tencent/im/msg/obj_msg$MsgContentInfo:msg_file	Ltencent/im/msg/obj_msg$MsgContentInfo$MsgFile;
    //   5200: getfield 2698	tencent/im/msg/obj_msg$MsgContentInfo$MsgFile:int64_dead_time	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   5203: invokevirtual 2701	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   5206: putfield 2704	com/tencent/mobileqq/data/TroopFileData:lastTime	J
    //   5209: aload 54
    //   5211: new 94	java/lang/String
    //   5214: dup
    //   5215: aload 53
    //   5217: getfield 2707	tencent/im/msg/obj_msg$ObjMsg:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5220: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5223: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5226: invokespecial 2675	java/lang/String:<init>	([B)V
    //   5229: putfield 2710	com/tencent/mobileqq/data/TroopFileData:dspFileName	Ljava/lang/String;
    //   5232: aload 54
    //   5234: new 94	java/lang/String
    //   5237: dup
    //   5238: aload 53
    //   5240: getfield 2713	tencent/im/msg/obj_msg$ObjMsg:rpt_bytes_abstact	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   5243: iconst_0
    //   5244: invokevirtual 2714	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   5247: checkcast 253	com/tencent/mobileqq/pb/ByteStringMicro
    //   5250: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5253: invokespecial 2675	java/lang/String:<init>	([B)V
    //   5256: putfield 2717	com/tencent/mobileqq/data/TroopFileData:dspFileSize	Ljava/lang/String;
    //   5259: aload 58
    //   5261: ldc_w 2719
    //   5264: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5267: pop
    //   5268: new 91	java/lang/StringBuilder
    //   5271: dup
    //   5272: ldc_w 2721
    //   5275: invokespecial 525	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5278: aload 54
    //   5280: invokevirtual 2722	com/tencent/mobileqq/data/TroopFileData:toString	()Ljava/lang/String;
    //   5283: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5286: astore 55
    //   5288: aload_0
    //   5289: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5292: aload_2
    //   5293: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   5296: getfield 2358	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   5299: getfield 2361	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5302: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5305: invokestatic 2727	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   5308: aload 54
    //   5310: getfield 2678	com/tencent/mobileqq/data/TroopFileData:fileUrl	Ljava/lang/String;
    //   5313: invokevirtual 2730	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopFileStatusInfo;
    //   5316: astore 53
    //   5318: aload 53
    //   5320: ifnull +5695 -> 11015
    //   5323: aload_0
    //   5324: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5327: invokevirtual 2733	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   5330: aload 53
    //   5332: getfield 2737	com/tencent/mobileqq/troop/data/TroopFileStatusInfo:d	J
    //   5335: invokevirtual 2742	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:a	(J)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   5338: astore 53
    //   5340: aload 53
    //   5342: aload 54
    //   5344: getfield 2704	com/tencent/mobileqq/data/TroopFileData:lastTime	J
    //   5347: putfield 2745	com/tencent/mobileqq/filemanager/data/FileManagerEntity:lastTime	J
    //   5350: sipush -2017
    //   5353: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5356: checkcast 2747	com/tencent/mobileqq/data/MessageForTroopFile
    //   5359: astore 61
    //   5361: aload 61
    //   5363: sipush -2017
    //   5366: putfield 2748	com/tencent/mobileqq/data/MessageForTroopFile:msgtype	I
    //   5369: aload 61
    //   5371: aload 58
    //   5373: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5376: putfield 2749	com/tencent/mobileqq/data/MessageForTroopFile:msg	Ljava/lang/String;
    //   5379: aload 61
    //   5381: aload 54
    //   5383: invokestatic 2754	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   5386: putfield 2755	com/tencent/mobileqq/data/MessageForTroopFile:msgData	[B
    //   5389: aload 61
    //   5391: invokevirtual 2756	com/tencent/mobileqq/data/MessageForTroopFile:parse	()V
    //   5394: aload_1
    //   5395: aload 61
    //   5397: invokeinterface 375 2 0
    //   5402: pop
    //   5403: aload 53
    //   5405: ifnull +73 -> 5478
    //   5408: aload_0
    //   5409: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5412: invokevirtual 333	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   5415: new 91	java/lang/StringBuilder
    //   5418: dup
    //   5419: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   5422: aload_2
    //   5423: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   5426: getfield 2358	msf/msgcomm/msg_comm$MsgHead:group_info	Lmsf/msgcomm/msg_comm$GroupInfo;
    //   5429: getfield 2361	msf/msgcomm/msg_comm$GroupInfo:group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5432: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5435: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5438: ldc_w 281
    //   5441: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5444: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5447: iconst_1
    //   5448: aload 53
    //   5450: getfield 2759	com/tencent/mobileqq/filemanager/data/FileManagerEntity:structMsgSeq	J
    //   5453: aload 61
    //   5455: getfield 2755	com/tencent/mobileqq/data/MessageForTroopFile:msgData	[B
    //   5458: invokevirtual 2762	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ[B)V
    //   5461: aload 55
    //   5463: ldc_w 2764
    //   5466: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5469: aload 53
    //   5471: getfield 2759	com/tencent/mobileqq/filemanager/data/FileManagerEntity:structMsgSeq	J
    //   5474: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5477: pop
    //   5478: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5481: ifeq +14 -> 5495
    //   5484: ldc 13
    //   5486: iconst_2
    //   5487: aload 55
    //   5489: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5492: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5495: aload 58
    //   5497: iconst_0
    //   5498: aload 58
    //   5500: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5503: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   5506: pop
    //   5507: aload 48
    //   5509: astore 53
    //   5511: iload 7
    //   5513: istore 18
    //   5515: goto -1123 -> 4392
    //   5518: astore 54
    //   5520: aload 54
    //   5522: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   5525: goto -136 -> 5389
    //   5528: aload 60
    //   5530: getfield 1138	tencent/im/msg/im_msg_body$Elem:market_face	Ltencent/im/msg/im_msg_body$MarketFace;
    //   5533: invokevirtual 2765	tencent/im/msg/im_msg_body$MarketFace:has	()Z
    //   5536: ifeq +480 -> 6016
    //   5539: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5542: ifeq +12 -> 5554
    //   5545: aload 56
    //   5547: ldc_w 2767
    //   5550: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5553: pop
    //   5554: aload 58
    //   5556: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5559: ifle +54 -> 5613
    //   5562: sipush -1000
    //   5565: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5568: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   5571: astore 53
    //   5573: aload 53
    //   5575: sipush -1000
    //   5578: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   5581: aload 53
    //   5583: aload 58
    //   5585: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5588: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   5591: aload 57
    //   5593: aload 53
    //   5595: invokeinterface 375 2 0
    //   5600: pop
    //   5601: aload 58
    //   5603: iconst_0
    //   5604: aload 58
    //   5606: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5609: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   5612: pop
    //   5613: aload 60
    //   5615: getfield 1138	tencent/im/msg/im_msg_body$Elem:market_face	Ltencent/im/msg/im_msg_body$MarketFace;
    //   5618: invokevirtual 2768	tencent/im/msg/im_msg_body$MarketFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5621: checkcast 1068	tencent/im/msg/im_msg_body$MarketFace
    //   5624: astore 53
    //   5626: aload 53
    //   5628: ifnull +312 -> 5940
    //   5631: new 1071	com/tencent/mobileqq/data/MarkFaceMessage
    //   5634: dup
    //   5635: invokespecial 2769	com/tencent/mobileqq/data/MarkFaceMessage:<init>	()V
    //   5638: astore 49
    //   5640: aload 49
    //   5642: aload 53
    //   5644: getfield 1089	tencent/im/msg/im_msg_body$MarketFace:uint32_face_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5647: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5650: putfield 1092	com/tencent/mobileqq/data/MarkFaceMessage:cFaceInfo	I
    //   5653: aload 49
    //   5655: iload 21
    //   5657: i2l
    //   5658: putfield 2771	com/tencent/mobileqq/data/MarkFaceMessage:index	J
    //   5661: aload 49
    //   5663: aload 53
    //   5665: getfield 1101	tencent/im/msg/im_msg_body$MarketFace:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5668: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5671: putfield 1104	com/tencent/mobileqq/data/MarkFaceMessage:cSubType	I
    //   5674: aload 49
    //   5676: aload 53
    //   5678: getfield 1095	tencent/im/msg/im_msg_body$MarketFace:uint32_item_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5681: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5684: putfield 1098	com/tencent/mobileqq/data/MarkFaceMessage:dwMSGItemType	I
    //   5687: aload 49
    //   5689: aload 53
    //   5691: getfield 1107	tencent/im/msg/im_msg_body$MarketFace:uint32_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5694: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5697: putfield 1110	com/tencent/mobileqq/data/MarkFaceMessage:dwTabID	I
    //   5700: aload 49
    //   5702: aload 53
    //   5704: getfield 1086	tencent/im/msg/im_msg_body$MarketFace:bytes_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5707: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5710: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5713: putfield 1083	com/tencent/mobileqq/data/MarkFaceMessage:sbfKey	[B
    //   5716: aload 49
    //   5718: aload 53
    //   5720: getfield 1077	tencent/im/msg/im_msg_body$MarketFace:bytes_face_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5723: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5726: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5729: putfield 1074	com/tencent/mobileqq/data/MarkFaceMessage:sbufID	[B
    //   5732: aload 49
    //   5734: aload 53
    //   5736: getfield 1113	tencent/im/msg/im_msg_body$MarketFace:uint32_media_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5739: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5742: putfield 1116	com/tencent/mobileqq/data/MarkFaceMessage:mediaType	I
    //   5745: aload 49
    //   5747: aload 53
    //   5749: getfield 1119	tencent/im/msg/im_msg_body$MarketFace:uint32_image_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5752: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5755: putfield 1122	com/tencent/mobileqq/data/MarkFaceMessage:imageWidth	I
    //   5758: aload 49
    //   5760: aload 53
    //   5762: getfield 1125	tencent/im/msg/im_msg_body$MarketFace:uint32_image_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5765: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5768: putfield 1128	com/tencent/mobileqq/data/MarkFaceMessage:imageHeight	I
    //   5771: aload 49
    //   5773: aload 53
    //   5775: getfield 1134	tencent/im/msg/im_msg_body$MarketFace:bytes_mobileparam	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5778: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5781: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5784: putfield 1131	com/tencent/mobileqq/data/MarkFaceMessage:mobileparam	[B
    //   5787: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5790: ifeq +20 -> 5810
    //   5793: aload 56
    //   5795: ldc_w 2773
    //   5798: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5801: aload 49
    //   5803: getfield 1116	com/tencent/mobileqq/data/MarkFaceMessage:mediaType	I
    //   5806: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5809: pop
    //   5810: aload 58
    //   5812: ldc_w 2775
    //   5815: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5818: pop
    //   5819: sipush -2007
    //   5822: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   5825: checkcast 1151	com/tencent/mobileqq/data/MessageForMarketFace
    //   5828: astore 53
    //   5830: aload 53
    //   5832: sipush -2007
    //   5835: putfield 2776	com/tencent/mobileqq/data/MessageForMarketFace:msgtype	I
    //   5838: aload 53
    //   5840: aload 58
    //   5842: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5845: putfield 2777	com/tencent/mobileqq/data/MessageForMarketFace:msg	Ljava/lang/String;
    //   5848: aload 53
    //   5850: aload 49
    //   5852: putfield 1155	com/tencent/mobileqq/data/MessageForMarketFace:mMarkFaceMessage	Lcom/tencent/mobileqq/data/MarkFaceMessage;
    //   5855: aload 49
    //   5857: getfield 1131	com/tencent/mobileqq/data/MarkFaceMessage:mobileparam	[B
    //   5860: ifnull +48 -> 5908
    //   5863: aload 49
    //   5865: getfield 1131	com/tencent/mobileqq/data/MarkFaceMessage:mobileparam	[B
    //   5868: arraylength
    //   5869: ifle +39 -> 5908
    //   5872: aload_0
    //   5873: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5876: ldc_w 2779
    //   5879: ldc_w 281
    //   5882: ldc_w 281
    //   5885: ldc_w 2781
    //   5888: ldc_w 2783
    //   5891: iconst_0
    //   5892: iconst_0
    //   5893: ldc_w 281
    //   5896: ldc_w 281
    //   5899: ldc_w 281
    //   5902: ldc_w 281
    //   5905: invokestatic 2788	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   5908: aload 53
    //   5910: aload 49
    //   5912: invokestatic 2754	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	(Ljava/io/Serializable;)[B
    //   5915: putfield 2789	com/tencent/mobileqq/data/MessageForMarketFace:msgData	[B
    //   5918: aload 57
    //   5920: aload 53
    //   5922: invokeinterface 375 2 0
    //   5927: pop
    //   5928: aload 58
    //   5930: iconst_0
    //   5931: aload 58
    //   5933: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   5936: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   5939: pop
    //   5940: iload 10
    //   5942: istore 13
    //   5944: iload 9
    //   5946: istore 15
    //   5948: iload 8
    //   5950: istore 16
    //   5952: iconst_1
    //   5953: istore 17
    //   5955: aload 49
    //   5957: astore 53
    //   5959: aload 47
    //   5961: astore 49
    //   5963: iload 12
    //   5965: istore 8
    //   5967: iload 6
    //   5969: istore 9
    //   5971: iload 11
    //   5973: istore 10
    //   5975: iload 13
    //   5977: istore 11
    //   5979: iload 15
    //   5981: istore 12
    //   5983: iload 16
    //   5985: istore 13
    //   5987: aload 48
    //   5989: astore 47
    //   5991: iload 7
    //   5993: istore 6
    //   5995: iload 17
    //   5997: istore 7
    //   5999: aload 53
    //   6001: astore 48
    //   6003: goto -3764 -> 2239
    //   6006: astore 54
    //   6008: aload 54
    //   6010: invokevirtual 2393	java/lang/Exception:printStackTrace	()V
    //   6013: goto -95 -> 5918
    //   6016: aload 60
    //   6018: getfield 1937	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   6021: invokevirtual 1940	tencent/im/msg/im_msg_body$CustomFace:has	()Z
    //   6024: ifeq +1176 -> 7200
    //   6027: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6030: ifeq +22 -> 6052
    //   6033: aload 56
    //   6035: ldc_w 2791
    //   6038: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6041: iload_3
    //   6042: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6045: ldc_w 1652
    //   6048: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6051: pop
    //   6052: iload_3
    //   6053: ifeq +274 -> 6327
    //   6056: aload 58
    //   6058: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   6061: ldc_w 2492
    //   6064: invokevirtual 1863	android/content/Context:getString	(I)Ljava/lang/String;
    //   6067: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6070: pop
    //   6071: aload_2
    //   6072: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   6075: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6078: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   6081: astore 53
    //   6083: aload 53
    //   6085: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6088: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6091: i2l
    //   6092: lstore 31
    //   6094: aload 53
    //   6096: getfield 1368	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6099: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6102: lstore 33
    //   6104: aload 53
    //   6106: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6109: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6112: i2l
    //   6113: lstore 35
    //   6115: aload 53
    //   6117: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6120: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6123: lstore 37
    //   6125: aload 53
    //   6127: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6130: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6133: lstore 41
    //   6135: new 2584	java/util/HashMap
    //   6138: dup
    //   6139: invokespecial 2585	java/util/HashMap:<init>	()V
    //   6142: astore 53
    //   6144: aload 53
    //   6146: ldc_w 2587
    //   6149: sipush 10001
    //   6152: invokestatic 2589	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   6155: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6158: pop
    //   6159: aload 53
    //   6161: ldc_w 2595
    //   6164: lload 37
    //   6166: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6169: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6172: pop
    //   6173: aload 53
    //   6175: ldc_w 2597
    //   6178: lload 41
    //   6180: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6183: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6186: pop
    //   6187: aload 53
    //   6189: ldc_w 2599
    //   6192: lload 31
    //   6194: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6197: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6200: pop
    //   6201: aload 53
    //   6203: ldc_w 2600
    //   6206: lload 33
    //   6208: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6211: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6214: pop
    //   6215: aload 53
    //   6217: ldc_w 2602
    //   6220: lload 35
    //   6222: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6225: invokevirtual 2593	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6228: pop
    //   6229: aload_0
    //   6230: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6233: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   6236: astore 54
    //   6238: invokestatic 1856	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   6241: invokestatic 2607	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   6244: aload 54
    //   6246: ldc_w 2609
    //   6249: iconst_0
    //   6250: lconst_0
    //   6251: lconst_0
    //   6252: aload 53
    //   6254: ldc_w 281
    //   6257: invokevirtual 2612	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   6260: iload 10
    //   6262: istore 15
    //   6264: iload 9
    //   6266: istore 16
    //   6268: aload 52
    //   6270: astore 53
    //   6272: iload 13
    //   6274: istore 17
    //   6276: iload 14
    //   6278: istore 18
    //   6280: aload 47
    //   6282: astore 52
    //   6284: iload 12
    //   6286: istore 14
    //   6288: iload 6
    //   6290: istore 9
    //   6292: iload 11
    //   6294: istore 10
    //   6296: iload 15
    //   6298: istore 11
    //   6300: iload 16
    //   6302: istore 12
    //   6304: iload 8
    //   6306: istore 13
    //   6308: aload 53
    //   6310: astore 47
    //   6312: iload 7
    //   6314: istore 6
    //   6316: iload 17
    //   6318: istore 7
    //   6320: iload 18
    //   6322: istore 8
    //   6324: goto -5648 -> 676
    //   6327: aload 58
    //   6329: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6332: ifle +54 -> 6386
    //   6335: sipush -1000
    //   6338: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6341: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   6344: astore 53
    //   6346: aload 53
    //   6348: sipush -1000
    //   6351: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   6354: aload 53
    //   6356: aload 58
    //   6358: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6361: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   6364: aload 57
    //   6366: aload 53
    //   6368: invokeinterface 375 2 0
    //   6373: pop
    //   6374: aload 58
    //   6376: iconst_0
    //   6377: aload 58
    //   6379: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   6382: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   6385: pop
    //   6386: aload 60
    //   6388: getfield 1937	tencent/im/msg/im_msg_body$Elem:custom_face	Ltencent/im/msg/im_msg_body$CustomFace;
    //   6391: invokevirtual 1941	tencent/im/msg/im_msg_body$CustomFace:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6394: checkcast 1939	tencent/im/msg/im_msg_body$CustomFace
    //   6397: astore 63
    //   6399: aload 63
    //   6401: getfield 1944	tencent/im/msg/im_msg_body$CustomFace:str_file_path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6404: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   6407: astore 53
    //   6409: aload 63
    //   6411: getfield 1947	tencent/im/msg/im_msg_body$CustomFace:str_shortcut	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6414: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   6417: pop
    //   6418: aload 63
    //   6420: getfield 1950	tencent/im/msg/im_msg_body$CustomFace:str_big_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6423: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   6426: astore 54
    //   6428: aload 63
    //   6430: getfield 1953	tencent/im/msg/im_msg_body$CustomFace:str_orig_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6433: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   6436: astore 55
    //   6438: aload 63
    //   6440: getfield 1956	tencent/im/msg/im_msg_body$CustomFace:str_thumb_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6443: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   6446: astore 61
    //   6448: aload 63
    //   6450: getfield 2792	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6453: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6456: istore 15
    //   6458: aload 63
    //   6460: getfield 2793	tencent/im/msg/im_msg_body$CustomFace:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6463: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6466: istore 16
    //   6468: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6471: ifeq +41 -> 6512
    //   6474: ldc 13
    //   6476: iconst_2
    //   6477: new 91	java/lang/StringBuilder
    //   6480: dup
    //   6481: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   6484: ldc_w 2795
    //   6487: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6490: iload 15
    //   6492: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6495: ldc_w 2510
    //   6498: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6501: iload 16
    //   6503: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6506: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6509: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6512: aload 63
    //   6514: getfield 2796	tencent/im/msg/im_msg_body$CustomFace:uint32_show_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6517: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6520: istore 17
    //   6522: aload 63
    //   6524: getfield 2797	tencent/im/msg/im_msg_body$CustomFace:uint32_download_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6527: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6530: istore 18
    //   6532: aload 63
    //   6534: getfield 1959	tencent/im/msg/im_msg_body$CustomFace:uint32_file_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6537: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6540: i2l
    //   6541: lstore 31
    //   6543: aload 63
    //   6545: getfield 1960	tencent/im/msg/im_msg_body$CustomFace:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6548: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6551: i2l
    //   6552: lstore 33
    //   6554: aload 63
    //   6556: getfield 1963	tencent/im/msg/im_msg_body$CustomFace:uint32_server_ip	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6559: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6562: i2l
    //   6563: lstore 33
    //   6565: aload 63
    //   6567: getfield 1966	tencent/im/msg/im_msg_body$CustomFace:uint32_server_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6570: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6573: i2l
    //   6574: lstore 33
    //   6576: aload 63
    //   6578: getfield 1969	tencent/im/msg/im_msg_body$CustomFace:uint32_useful	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6581: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6584: i2l
    //   6585: lstore 33
    //   6587: aload 63
    //   6589: getfield 2800	tencent/im/msg/im_msg_body$CustomFace:uint32_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6592: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6595: i2l
    //   6596: ldc2_w 9
    //   6599: land
    //   6600: lstore 33
    //   6602: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6605: ifeq +30 -> 6635
    //   6608: ldc 13
    //   6610: iconst_2
    //   6611: new 91	java/lang/StringBuilder
    //   6614: dup
    //   6615: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   6618: ldc_w 2802
    //   6621: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6624: lload 33
    //   6626: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6629: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6632: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6635: invokestatic 843	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6638: ifeq +53 -> 6691
    //   6641: ldc_w 2527
    //   6644: iconst_4
    //   6645: new 91	java/lang/StringBuilder
    //   6648: dup
    //   6649: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   6652: ldc_w 2529
    //   6655: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6658: iload 17
    //   6660: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6663: ldc_w 2531
    //   6666: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6669: iload 18
    //   6671: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6674: ldc_w 2533
    //   6677: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6680: lload 33
    //   6682: invokevirtual 277	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6685: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6688: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6691: aload 63
    //   6693: getfield 1972	tencent/im/msg/im_msg_body$CustomFace:bytes_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6696: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6699: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6702: astore 62
    //   6704: aload 63
    //   6706: getfield 1975	tencent/im/msg/im_msg_body$CustomFace:bytes_signature	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6709: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6712: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6715: astore 64
    //   6717: aload 63
    //   6719: getfield 1978	tencent/im/msg/im_msg_body$CustomFace:bytes_buffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6722: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6725: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6728: pop
    //   6729: aload 63
    //   6731: getfield 1981	tencent/im/msg/im_msg_body$CustomFace:bytes_flag	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6734: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6737: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6740: astore 65
    //   6742: aload 63
    //   6744: getfield 2803	tencent/im/msg/im_msg_body$CustomFace:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6747: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6750: i2l
    //   6751: ldc2_w 9
    //   6754: land
    //   6755: l2i
    //   6756: istore 19
    //   6758: aload 63
    //   6760: getfield 2804	tencent/im/msg/im_msg_body$CustomFace:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6763: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6766: i2l
    //   6767: ldc2_w 9
    //   6770: land
    //   6771: l2i
    //   6772: istore 22
    //   6774: aload 62
    //   6776: invokestatic 411	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   6779: astore 62
    //   6781: aload 64
    //   6783: invokestatic 411	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   6786: pop
    //   6787: aload 65
    //   6789: invokestatic 411	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   6792: pop
    //   6793: aload 63
    //   6795: getfield 2807	tencent/im/msg/im_msg_body$CustomFace:uint32_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6798: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6801: istore 23
    //   6803: aload 53
    //   6805: lconst_0
    //   6806: iconst_1
    //   6807: iconst_0
    //   6808: aload 53
    //   6810: aload 62
    //   6812: ldc_w 2544
    //   6815: aload 61
    //   6817: aload 54
    //   6819: aload 55
    //   6821: iload 23
    //   6823: iconst_0
    //   6824: invokestatic 2810	com/tencent/mobileqq/transfile/TranDbRecord$PicDbRecord:a	(Ljava/lang/String;JIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   6827: astore 64
    //   6829: new 377	localpb/richMsg/RichMsg$PicRec
    //   6832: dup
    //   6833: invokespecial 378	localpb/richMsg/RichMsg$PicRec:<init>	()V
    //   6836: astore 63
    //   6838: aload 63
    //   6840: getfield 1668	localpb/richMsg/RichMsg$PicRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6843: aload 53
    //   6845: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6848: aload 63
    //   6850: getfield 1670	localpb/richMsg/RichMsg$PicRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6853: lload 33
    //   6855: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   6858: aload 63
    //   6860: getfield 1673	localpb/richMsg/RichMsg$PicRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6863: iconst_1
    //   6864: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   6867: aload 63
    //   6869: getfield 1676	localpb/richMsg/RichMsg$PicRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   6872: iconst_0
    //   6873: invokevirtual 835	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   6876: aload 63
    //   6878: getfield 1679	localpb/richMsg/RichMsg$PicRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6881: aload 53
    //   6883: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6886: aload 63
    //   6888: getfield 2564	localpb/richMsg/RichMsg$PicRec:groupFileID	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6891: lload 31
    //   6893: ldc2_w 9
    //   6896: land
    //   6897: invokevirtual 598	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   6900: aload 63
    //   6902: getfield 2550	localpb/richMsg/RichMsg$PicRec:md5	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6905: aload 62
    //   6907: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6910: aload 63
    //   6912: getfield 1682	localpb/richMsg/RichMsg$PicRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6915: ldc_w 2544
    //   6918: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6921: aload 63
    //   6923: getfield 2553	localpb/richMsg/RichMsg$PicRec:thumbMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6926: aload 61
    //   6928: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6931: aload 63
    //   6933: getfield 2554	localpb/richMsg/RichMsg$PicRec:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6936: iload 15
    //   6938: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   6941: aload 63
    //   6943: getfield 2555	localpb/richMsg/RichMsg$PicRec:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6946: iload 16
    //   6948: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   6951: aload 63
    //   6953: getfield 2558	localpb/richMsg/RichMsg$PicRec:uint32_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6956: iload 19
    //   6958: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   6961: aload 63
    //   6963: getfield 2561	localpb/richMsg/RichMsg$PicRec:uint32_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6966: iload 22
    //   6968: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   6971: aload 63
    //   6973: getfield 2567	localpb/richMsg/RichMsg$PicRec:bigMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6976: aload 54
    //   6978: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6981: aload 63
    //   6983: getfield 2570	localpb/richMsg/RichMsg$PicRec:rawMsgUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   6986: aload 55
    //   6988: invokevirtual 371	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   6991: aload 63
    //   6993: getfield 2573	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   6996: iconst_0
    //   6997: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   7000: aload 63
    //   7002: getfield 2576	localpb/richMsg/RichMsg$PicRec:uiOperatorFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7005: iconst_0
    //   7006: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   7009: aload 63
    //   7011: getfield 1688	localpb/richMsg/RichMsg$PicRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7014: iconst_5
    //   7015: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   7018: aload 63
    //   7020: getfield 1694	localpb/richMsg/RichMsg$PicRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7023: iconst_0
    //   7024: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   7027: aload 63
    //   7029: getfield 2573	localpb/richMsg/RichMsg$PicRec:fileSizeFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7032: iload 23
    //   7034: invokevirtual 1691	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   7037: aload 63
    //   7039: getfield 2579	localpb/richMsg/RichMsg$PicRec:uint32_show_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7042: iload 17
    //   7044: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7047: aload 63
    //   7049: getfield 2580	localpb/richMsg/RichMsg$PicRec:uint32_download_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7052: iload 18
    //   7054: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   7057: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7060: ifeq +17 -> 7077
    //   7063: aload 56
    //   7065: ldc_w 1700
    //   7068: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7071: aload 64
    //   7073: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7076: pop
    //   7077: sipush -2000
    //   7080: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7083: checkcast 988	com/tencent/mobileqq/data/MessageForPic
    //   7086: astore 53
    //   7088: aload 53
    //   7090: sipush -2000
    //   7093: putfield 1695	com/tencent/mobileqq/data/MessageForPic:msgtype	I
    //   7096: aload 53
    //   7098: aload 63
    //   7100: invokevirtual 1696	localpb/richMsg/RichMsg$PicRec:toByteArray	()[B
    //   7103: putfield 1697	com/tencent/mobileqq/data/MessageForPic:msgData	[B
    //   7106: aload 53
    //   7108: invokevirtual 1698	com/tencent/mobileqq/data/MessageForPic:parse	()V
    //   7111: aload 57
    //   7113: aload 53
    //   7115: invokeinterface 375 2 0
    //   7120: pop
    //   7121: aload 58
    //   7123: iconst_0
    //   7124: aload 58
    //   7126: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7129: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7132: pop
    //   7133: iload 10
    //   7135: istore 15
    //   7137: iload 9
    //   7139: istore 16
    //   7141: iload 8
    //   7143: istore 17
    //   7145: iload 13
    //   7147: istore 18
    //   7149: aload 49
    //   7151: astore 53
    //   7153: aload 47
    //   7155: astore 49
    //   7157: iload 12
    //   7159: istore 8
    //   7161: iload 6
    //   7163: istore 9
    //   7165: iload 11
    //   7167: istore 10
    //   7169: iload 15
    //   7171: istore 11
    //   7173: iload 16
    //   7175: istore 12
    //   7177: iload 17
    //   7179: istore 13
    //   7181: aload 48
    //   7183: astore 47
    //   7185: iload 7
    //   7187: istore 6
    //   7189: iload 18
    //   7191: istore 7
    //   7193: aload 53
    //   7195: astore 48
    //   7197: goto -4958 -> 2239
    //   7200: aload 60
    //   7202: getfield 1044	tencent/im/msg/im_msg_body$Elem:fun_face	Ltencent/im/msg/im_msg_body$FunFace;
    //   7205: invokevirtual 2811	tencent/im/msg/im_msg_body$FunFace:has	()Z
    //   7208: ifeq +89 -> 7297
    //   7211: aload 47
    //   7213: astore 53
    //   7215: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7218: ifeq +2919 -> 10137
    //   7221: aload 56
    //   7223: ldc_w 2813
    //   7226: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7229: pop
    //   7230: iload 10
    //   7232: istore 15
    //   7234: iload 9
    //   7236: istore 16
    //   7238: iload 8
    //   7240: istore 17
    //   7242: iload 13
    //   7244: istore 18
    //   7246: aload 49
    //   7248: astore 53
    //   7250: aload 47
    //   7252: astore 49
    //   7254: iload 12
    //   7256: istore 8
    //   7258: iload 6
    //   7260: istore 9
    //   7262: iload 11
    //   7264: istore 10
    //   7266: iload 15
    //   7268: istore 11
    //   7270: iload 16
    //   7272: istore 12
    //   7274: iload 17
    //   7276: istore 13
    //   7278: aload 48
    //   7280: astore 47
    //   7282: iload 7
    //   7284: istore 6
    //   7286: iload 18
    //   7288: istore 7
    //   7290: aload 53
    //   7292: astore 48
    //   7294: goto -5055 -> 2239
    //   7297: aload 60
    //   7299: getfield 2817	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   7302: invokevirtual 2820	tencent/im/msg/im_msg_body$GroupFile:has	()Z
    //   7305: ifeq +516 -> 7821
    //   7308: lconst_0
    //   7309: lstore 31
    //   7311: aload_2
    //   7312: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   7315: invokevirtual 237	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7318: checkcast 236	msf/msgcomm/msg_comm$MsgHead
    //   7321: astore 53
    //   7323: aload 53
    //   7325: getfield 2824	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   7328: invokevirtual 2827	msf/msgcomm/msg_comm$DiscussInfo:has	()Z
    //   7331: ifeq +22 -> 7353
    //   7334: aload 53
    //   7336: getfield 2824	msf/msgcomm/msg_comm$MsgHead:discuss_info	Lmsf/msgcomm/msg_comm$DiscussInfo;
    //   7339: invokevirtual 2828	msf/msgcomm/msg_comm$DiscussInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7342: checkcast 2826	msf/msgcomm/msg_comm$DiscussInfo
    //   7345: getfield 2831	msf/msgcomm/msg_comm$DiscussInfo:discuss_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7348: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7351: lstore 31
    //   7353: aload 53
    //   7355: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7358: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7361: lstore 37
    //   7363: aload 53
    //   7365: getfield 291	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7368: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7371: i2l
    //   7372: lstore 43
    //   7374: aload 53
    //   7376: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7379: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7382: i2l
    //   7383: lstore 45
    //   7385: aload_0
    //   7386: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7389: invokevirtual 2422	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   7392: lstore 41
    //   7394: aload 60
    //   7396: getfield 2817	tencent/im/msg/im_msg_body$Elem:group_file	Ltencent/im/msg/im_msg_body$GroupFile;
    //   7399: invokevirtual 2832	tencent/im/msg/im_msg_body$GroupFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7402: checkcast 2819	tencent/im/msg/im_msg_body$GroupFile
    //   7405: astore 55
    //   7407: aload_0
    //   7408: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7411: sipush 3000
    //   7414: lload 31
    //   7416: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7419: lload 37
    //   7421: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7424: lload 43
    //   7426: lload 45
    //   7428: invokestatic 2837	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;Ljava/lang/String;JJ)Z
    //   7431: ifeq +70 -> 7501
    //   7434: iload 10
    //   7436: istore 15
    //   7438: iload 9
    //   7440: istore 16
    //   7442: aload 52
    //   7444: astore 53
    //   7446: iload 13
    //   7448: istore 17
    //   7450: iload 14
    //   7452: istore 18
    //   7454: aload 47
    //   7456: astore 52
    //   7458: iload 12
    //   7460: istore 14
    //   7462: iload 6
    //   7464: istore 9
    //   7466: iload 11
    //   7468: istore 10
    //   7470: iload 15
    //   7472: istore 11
    //   7474: iload 16
    //   7476: istore 12
    //   7478: iload 8
    //   7480: istore 13
    //   7482: aload 53
    //   7484: astore 47
    //   7486: iload 7
    //   7488: istore 6
    //   7490: iload 17
    //   7492: istore 7
    //   7494: iload 18
    //   7496: istore 8
    //   7498: goto -6822 -> 676
    //   7501: ldc_w 281
    //   7504: astore 53
    //   7506: new 94	java/lang/String
    //   7509: dup
    //   7510: aload 55
    //   7512: getfield 2840	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7515: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7518: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   7521: ldc_w 2842
    //   7524: invokespecial 1405	java/lang/String:<init>	([BLjava/lang/String;)V
    //   7527: astore 54
    //   7529: aload 54
    //   7531: astore 53
    //   7533: lconst_0
    //   7534: lstore 35
    //   7536: lload 35
    //   7538: lstore 33
    //   7540: aload_2
    //   7541: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   7544: invokevirtual 32	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   7547: ifeq +58 -> 7605
    //   7550: aload_2
    //   7551: getfield 26	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   7554: invokevirtual 36	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7557: checkcast 28	tencent/im/msg/im_msg_body$MsgBody
    //   7560: astore 54
    //   7562: lload 35
    //   7564: lstore 33
    //   7566: aload 54
    //   7568: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   7571: getfield 2846	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   7574: invokevirtual 2849	tencent/im/msg/im_msg_body$Attr:has	()Z
    //   7577: ifeq +28 -> 7605
    //   7580: aload 54
    //   7582: getfield 40	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   7585: getfield 2846	tencent/im/msg/im_msg_body$RichText:attr	Ltencent/im/msg/im_msg_body$Attr;
    //   7588: invokevirtual 2850	tencent/im/msg/im_msg_body$Attr:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7591: checkcast 2848	tencent/im/msg/im_msg_body$Attr
    //   7594: getfield 2853	tencent/im/msg/im_msg_body$Attr:random	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7597: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7600: invokestatic 2856	com/tencent/mobileqq/service/message/MessageUtils:a	(I)J
    //   7603: lstore 33
    //   7605: sipush -2005
    //   7608: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7611: checkcast 2858	com/tencent/mobileqq/data/MessageForFile
    //   7614: astore 54
    //   7616: aload 54
    //   7618: sipush -2005
    //   7621: putfield 2859	com/tencent/mobileqq/data/MessageForFile:msgtype	I
    //   7624: aload 54
    //   7626: aload_0
    //   7627: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7630: invokevirtual 455	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   7633: aload 54
    //   7635: getfield 2862	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   7638: lload 31
    //   7640: lload 37
    //   7642: lload 45
    //   7644: lload 33
    //   7646: lload 43
    //   7648: aload 55
    //   7650: invokevirtual 2865	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(JJJJJJLtencent/im/msg/im_msg_body$GroupFile;)J
    //   7653: putfield 2862	com/tencent/mobileqq/data/MessageForFile:uniseq	J
    //   7656: aload 55
    //   7658: getfield 2866	tencent/im/msg/im_msg_body$GroupFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7661: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7664: lstore 31
    //   7666: lload 37
    //   7668: lload 41
    //   7670: lcmp
    //   7671: ifne +144 -> 7815
    //   7674: iconst_1
    //   7675: istore 27
    //   7677: aload 54
    //   7679: aload 53
    //   7681: lload 31
    //   7683: iconst_0
    //   7684: iload 27
    //   7686: invokestatic 2869	com/tencent/mobileqq/transfile/TransfileUtile:a	(Ljava/lang/String;JIZ)Ljava/lang/String;
    //   7689: putfield 2870	com/tencent/mobileqq/data/MessageForFile:msg	Ljava/lang/String;
    //   7692: aload 54
    //   7694: invokevirtual 2873	com/tencent/mobileqq/data/MessageForFile:doParse	()V
    //   7697: aload_1
    //   7698: aload 54
    //   7700: invokeinterface 375 2 0
    //   7705: pop
    //   7706: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7709: ifeq +29 -> 7738
    //   7712: aload 56
    //   7714: ldc_w 2875
    //   7717: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7720: aload 55
    //   7722: getfield 2840	tencent/im/msg/im_msg_body$GroupFile:bytes_filename	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7725: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7728: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   7731: ldc_w 1652
    //   7734: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7737: pop
    //   7738: iload 10
    //   7740: istore 15
    //   7742: iload 9
    //   7744: istore 16
    //   7746: iload 8
    //   7748: istore 17
    //   7750: iload 13
    //   7752: istore 18
    //   7754: aload 49
    //   7756: astore 53
    //   7758: aload 47
    //   7760: astore 49
    //   7762: iload 12
    //   7764: istore 8
    //   7766: iload 6
    //   7768: istore 9
    //   7770: iload 11
    //   7772: istore 10
    //   7774: iload 15
    //   7776: istore 11
    //   7778: iload 16
    //   7780: istore 12
    //   7782: iload 17
    //   7784: istore 13
    //   7786: aload 48
    //   7788: astore 47
    //   7790: iload 7
    //   7792: istore 6
    //   7794: iload 18
    //   7796: istore 7
    //   7798: aload 53
    //   7800: astore 48
    //   7802: goto -5563 -> 2239
    //   7805: astore 54
    //   7807: aload 54
    //   7809: invokevirtual 2876	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   7812: goto -279 -> 7533
    //   7815: iconst_0
    //   7816: istore 27
    //   7818: goto -141 -> 7677
    //   7821: aload 60
    //   7823: getfield 2880	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   7826: invokevirtual 2883	tencent/im/msg/im_msg_body$MarketTrans:has	()Z
    //   7829: ifeq +402 -> 8231
    //   7832: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7835: ifeq +12 -> 7847
    //   7838: aload 56
    //   7840: ldc_w 2885
    //   7843: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7846: pop
    //   7847: aload 58
    //   7849: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7852: ifle +54 -> 7906
    //   7855: sipush -1000
    //   7858: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7861: checkcast 1238	com/tencent/mobileqq/data/MessageForText
    //   7864: astore 53
    //   7866: aload 53
    //   7868: sipush -1000
    //   7871: putfield 2020	com/tencent/mobileqq/data/MessageForText:msgtype	I
    //   7874: aload 53
    //   7876: aload 58
    //   7878: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7881: putfield 1239	com/tencent/mobileqq/data/MessageForText:msg	Ljava/lang/String;
    //   7884: aload 57
    //   7886: aload 53
    //   7888: invokeinterface 375 2 0
    //   7893: pop
    //   7894: aload 58
    //   7896: iconst_0
    //   7897: aload 58
    //   7899: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   7902: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   7905: pop
    //   7906: aload 60
    //   7908: getfield 2880	tencent/im/msg/im_msg_body$Elem:market_trans	Ltencent/im/msg/im_msg_body$MarketTrans;
    //   7911: invokevirtual 2886	tencent/im/msg/im_msg_body$MarketTrans:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7914: checkcast 2882	tencent/im/msg/im_msg_body$MarketTrans
    //   7917: astore 53
    //   7919: aload 53
    //   7921: getfield 2889	tencent/im/msg/im_msg_body$MarketTrans:int32_flag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7924: invokevirtual 2890	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   7927: istore 8
    //   7929: aload 53
    //   7931: getfield 2893	tencent/im/msg/im_msg_body$MarketTrans:bytes_xml	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7934: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7937: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   7940: iload 8
    //   7942: invokestatic 2896	com/tencent/mobileqq/structmsg/StructMsgFactory:a	([BI)Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   7945: astore 53
    //   7947: aload 59
    //   7949: invokeinterface 59 1 0
    //   7954: astore 54
    //   7956: aload 54
    //   7958: invokeinterface 64 1 0
    //   7963: ifeq +112 -> 8075
    //   7966: aload 54
    //   7968: invokeinterface 68 1 0
    //   7973: checkcast 70	tencent/im/msg/im_msg_body$Elem
    //   7976: astore 55
    //   7978: aload 55
    //   7980: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   7983: invokevirtual 2329	tencent/im/msg/im_msg_body$LifeOnlineAccount:has	()Z
    //   7986: ifeq -30 -> 7956
    //   7989: aload 55
    //   7991: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   7994: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7997: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   8000: getfield 2370	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_report	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8003: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8006: ifeq -50 -> 7956
    //   8009: aload 55
    //   8011: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8014: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8017: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   8020: getfield 2370	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_report	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8023: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8026: iconst_1
    //   8027: if_icmpne -71 -> 7956
    //   8030: aload 55
    //   8032: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8035: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8038: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   8041: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8044: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8047: ifeq -91 -> 7956
    //   8050: aload 53
    //   8052: aload 55
    //   8054: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8057: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8060: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   8063: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8066: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8069: putfield 2373	com/tencent/mobileqq/structmsg/AbsStructMsg:msgId	J
    //   8072: goto -116 -> 7956
    //   8075: aload 51
    //   8077: ifnull +10 -> 8087
    //   8080: aload 53
    //   8082: aload 51
    //   8084: putfield 1223	com/tencent/mobileqq/structmsg/AbsStructMsg:mCompatibleText	Ljava/lang/String;
    //   8087: aload 53
    //   8089: ifnull +124 -> 8213
    //   8092: sipush -2011
    //   8095: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8098: checkcast 1193	com/tencent/mobileqq/data/MessageForStructing
    //   8101: astore 54
    //   8103: aload 54
    //   8105: sipush -2011
    //   8108: putfield 2354	com/tencent/mobileqq/data/MessageForStructing:msgtype	I
    //   8111: aload 54
    //   8113: ldc_w 2898
    //   8116: putfield 2398	com/tencent/mobileqq/data/MessageForStructing:msg	Ljava/lang/String;
    //   8119: aload 54
    //   8121: aload 53
    //   8123: putfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   8126: aload 54
    //   8128: aload 54
    //   8130: getfield 1197	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   8133: invokevirtual 2394	com/tencent/mobileqq/structmsg/AbsStructMsg:getBytes	()[B
    //   8136: putfield 2395	com/tencent/mobileqq/data/MessageForStructing:msgData	[B
    //   8139: aload_1
    //   8140: aload 54
    //   8142: invokeinterface 375 2 0
    //   8147: pop
    //   8148: iload 12
    //   8150: istore 8
    //   8152: iload 6
    //   8154: istore 12
    //   8156: iload 10
    //   8158: istore 13
    //   8160: iload 9
    //   8162: istore 15
    //   8164: iconst_1
    //   8165: istore 16
    //   8167: iload 7
    //   8169: istore 6
    //   8171: iconst_0
    //   8172: istore 7
    //   8174: aload 49
    //   8176: astore 53
    //   8178: aload 47
    //   8180: astore 49
    //   8182: iload 12
    //   8184: istore 9
    //   8186: iload 11
    //   8188: istore 10
    //   8190: iload 13
    //   8192: istore 11
    //   8194: iload 15
    //   8196: istore 12
    //   8198: iload 16
    //   8200: istore 13
    //   8202: aload 48
    //   8204: astore 47
    //   8206: aload 53
    //   8208: astore 48
    //   8210: goto -5971 -> 2239
    //   8213: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8216: ifeq +12 -> 8228
    //   8219: aload 56
    //   8221: ldc_w 2400
    //   8224: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8227: pop
    //   8228: goto -80 -> 8148
    //   8231: aload 60
    //   8233: getfield 2902	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   8236: invokevirtual 2905	tencent/im/msg/im_msg_body$VideoFile:has	()Z
    //   8239: ifeq +404 -> 8643
    //   8242: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8245: ifeq +12 -> 8257
    //   8248: aload 56
    //   8250: ldc_w 2907
    //   8253: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8256: pop
    //   8257: aload 58
    //   8259: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   8262: ifle +21 -> 8283
    //   8265: aload 58
    //   8267: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8270: pop
    //   8271: aload 58
    //   8273: iconst_0
    //   8274: aload 58
    //   8276: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   8279: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   8282: pop
    //   8283: aload 60
    //   8285: getfield 2902	tencent/im/msg/im_msg_body$Elem:video_file	Ltencent/im/msg/im_msg_body$VideoFile;
    //   8288: invokevirtual 2908	tencent/im/msg/im_msg_body$VideoFile:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8291: checkcast 2904	tencent/im/msg/im_msg_body$VideoFile
    //   8294: astore 54
    //   8296: new 2910	localpb/richMsg/RichMsg$VideoFile
    //   8299: dup
    //   8300: invokespecial 2911	localpb/richMsg/RichMsg$VideoFile:<init>	()V
    //   8303: astore 53
    //   8305: aload 53
    //   8307: iconst_1
    //   8308: invokevirtual 2914	localpb/richMsg/RichMsg$VideoFile:setHasFlag	(Z)V
    //   8311: aload 53
    //   8313: getfield 2915	localpb/richMsg/RichMsg$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8316: aload 54
    //   8318: getfield 2916	tencent/im/msg/im_msg_body$VideoFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8321: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8324: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   8327: aload 53
    //   8329: getfield 2919	localpb/richMsg/RichMsg$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8332: aload 54
    //   8334: getfield 2920	tencent/im/msg/im_msg_body$VideoFile:bytes_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8337: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8340: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   8343: aload 53
    //   8345: getfield 2921	localpb/richMsg/RichMsg$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8348: aload 54
    //   8350: getfield 2922	tencent/im/msg/im_msg_body$VideoFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8353: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8356: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   8359: aload 53
    //   8361: getfield 2925	localpb/richMsg/RichMsg$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8364: aload 54
    //   8366: getfield 2926	tencent/im/msg/im_msg_body$VideoFile:uint32_file_format	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8369: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8372: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8375: aload 53
    //   8377: getfield 2927	localpb/richMsg/RichMsg$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8380: aload 54
    //   8382: getfield 2928	tencent/im/msg/im_msg_body$VideoFile:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8385: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8388: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8391: aload 53
    //   8393: getfield 2931	localpb/richMsg/RichMsg$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8396: aload 54
    //   8398: getfield 2932	tencent/im/msg/im_msg_body$VideoFile:uint32_file_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8401: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8404: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8407: aload 53
    //   8409: getfield 2933	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8412: aload 54
    //   8414: getfield 2934	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_width	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8417: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8420: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8423: aload 53
    //   8425: getfield 2935	localpb/richMsg/RichMsg$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8428: aload 54
    //   8430: getfield 2936	tencent/im/msg/im_msg_body$VideoFile:uint32_thumb_height	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8433: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8436: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8439: aload 53
    //   8441: getfield 2939	localpb/richMsg/RichMsg$VideoFile:uint32_file_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8444: sipush 2008
    //   8447: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8450: aload 53
    //   8452: getfield 2942	localpb/richMsg/RichMsg$VideoFile:uint32_file_progress	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8455: iconst_0
    //   8456: invokevirtual 173	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   8459: aload 53
    //   8461: getfield 2945	localpb/richMsg/RichMsg$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8464: aload 54
    //   8466: getfield 2946	tencent/im/msg/im_msg_body$VideoFile:bytes_thumb_file_md5	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8469: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8472: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   8475: sipush -2022
    //   8478: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8481: checkcast 996	com/tencent/mobileqq/data/MessageForShortVideo
    //   8484: astore 54
    //   8486: aload 54
    //   8488: sipush -2022
    //   8491: putfield 2947	com/tencent/mobileqq/data/MessageForShortVideo:msgtype	I
    //   8494: aload 54
    //   8496: aload 53
    //   8498: invokevirtual 2948	localpb/richMsg/RichMsg$VideoFile:toByteArray	()[B
    //   8501: putfield 2949	com/tencent/mobileqq/data/MessageForShortVideo:msgData	[B
    //   8504: aload 54
    //   8506: ldc_w 2951
    //   8509: putfield 2952	com/tencent/mobileqq/data/MessageForShortVideo:msg	Ljava/lang/String;
    //   8512: aload 54
    //   8514: invokevirtual 2953	com/tencent/mobileqq/data/MessageForShortVideo:parse	()V
    //   8517: aload 57
    //   8519: aload 54
    //   8521: invokeinterface 375 2 0
    //   8526: pop
    //   8527: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8530: ifeq +47 -> 8577
    //   8533: aload 56
    //   8535: ldc_w 2955
    //   8538: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8541: new 91	java/lang/StringBuilder
    //   8544: dup
    //   8545: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   8548: aload 54
    //   8550: invokevirtual 2956	com/tencent/mobileqq/data/MessageForShortVideo:toString	()Ljava/lang/String;
    //   8553: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8556: ldc_w 2958
    //   8559: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8562: aload 54
    //   8564: invokevirtual 2961	com/tencent/mobileqq/data/MessageForShortVideo:toLogString	()Ljava/lang/String;
    //   8567: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8570: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8573: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8576: pop
    //   8577: iload 6
    //   8579: istore 9
    //   8581: iload 10
    //   8583: istore 16
    //   8585: iconst_1
    //   8586: istore 17
    //   8588: iload 8
    //   8590: istore 6
    //   8592: iload 13
    //   8594: istore 15
    //   8596: aload 49
    //   8598: astore 53
    //   8600: aload 47
    //   8602: astore 49
    //   8604: iload 12
    //   8606: istore 8
    //   8608: iload 11
    //   8610: istore 10
    //   8612: iload 16
    //   8614: istore 11
    //   8616: iload 17
    //   8618: istore 12
    //   8620: iload 6
    //   8622: istore 13
    //   8624: aload 48
    //   8626: astore 47
    //   8628: iload 7
    //   8630: istore 6
    //   8632: iload 15
    //   8634: istore 7
    //   8636: aload 53
    //   8638: astore 48
    //   8640: goto -6401 -> 2239
    //   8643: aload 60
    //   8645: getfield 2965	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   8648: invokevirtual 2968	tencent/im/msg/im_msg_body$TipsInfo:has	()Z
    //   8651: ifeq +168 -> 8819
    //   8654: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8657: ifeq +12 -> 8669
    //   8660: aload 56
    //   8662: ldc_w 2970
    //   8665: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8668: pop
    //   8669: aload 60
    //   8671: getfield 2965	tencent/im/msg/im_msg_body$Elem:tips_info	Ltencent/im/msg/im_msg_body$TipsInfo;
    //   8674: invokevirtual 2971	tencent/im/msg/im_msg_body$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8677: checkcast 2967	tencent/im/msg/im_msg_body$TipsInfo
    //   8680: astore 53
    //   8682: sipush -5002
    //   8685: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8688: checkcast 2973	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips
    //   8691: astore 54
    //   8693: aload 54
    //   8695: aload 53
    //   8697: getfield 2975	tencent/im/msg/im_msg_body$TipsInfo:text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8700: invokevirtual 270	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8703: invokevirtual 2979	com/tencent/mobileqq/data/MessageForIncompatibleGrayTips:parseTextXML	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   8706: invokevirtual 2984	java/lang/Boolean:booleanValue	()Z
    //   8709: ifne +85 -> 8794
    //   8712: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8715: ifeq +12 -> 8727
    //   8718: aload 56
    //   8720: ldc_w 2986
    //   8723: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8726: pop
    //   8727: iload 10
    //   8729: istore 15
    //   8731: iload 9
    //   8733: istore 16
    //   8735: iload 8
    //   8737: istore 17
    //   8739: iload 13
    //   8741: istore 18
    //   8743: aload 49
    //   8745: astore 53
    //   8747: aload 47
    //   8749: astore 49
    //   8751: iload 12
    //   8753: istore 8
    //   8755: iload 6
    //   8757: istore 9
    //   8759: iload 11
    //   8761: istore 10
    //   8763: iload 15
    //   8765: istore 11
    //   8767: iload 16
    //   8769: istore 12
    //   8771: iload 17
    //   8773: istore 13
    //   8775: aload 48
    //   8777: astore 47
    //   8779: iload 7
    //   8781: istore 6
    //   8783: iload 18
    //   8785: istore 7
    //   8787: aload 53
    //   8789: astore 48
    //   8791: goto -6552 -> 2239
    //   8794: aload 57
    //   8796: aload 54
    //   8798: invokeinterface 375 2 0
    //   8803: pop
    //   8804: aload 58
    //   8806: iconst_0
    //   8807: aload 58
    //   8809: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   8812: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   8815: pop
    //   8816: goto -89 -> 8727
    //   8819: aload 60
    //   8821: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8824: invokevirtual 2329	tencent/im/msg/im_msg_body$LifeOnlineAccount:has	()Z
    //   8827: ifeq +497 -> 9324
    //   8830: aload 50
    //   8832: astore 53
    //   8834: iload 6
    //   8836: istore 12
    //   8838: aload 60
    //   8840: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8843: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8846: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8849: ifeq +321 -> 9170
    //   8852: aload 50
    //   8854: astore 53
    //   8856: iload 6
    //   8858: istore 12
    //   8860: aload 60
    //   8862: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8865: getfield 2989	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_show_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8868: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8871: ifeq +299 -> 9170
    //   8874: aload 50
    //   8876: astore 53
    //   8878: iload 6
    //   8880: istore 12
    //   8882: aload 60
    //   8884: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8887: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8890: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8893: ifeq +277 -> 9170
    //   8896: aload 60
    //   8898: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8901: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8904: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8907: bipush 9
    //   8909: if_icmpeq +41 -> 8950
    //   8912: aload 60
    //   8914: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8917: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8920: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8923: ifeq +27 -> 8950
    //   8926: aload 50
    //   8928: astore 53
    //   8930: iload 6
    //   8932: istore 12
    //   8934: aload 60
    //   8936: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8939: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8942: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8945: bipush 11
    //   8947: if_icmpne +223 -> 9170
    //   8950: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8953: ifeq +12 -> 8965
    //   8956: aload 56
    //   8958: ldc_w 2991
    //   8961: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8964: pop
    //   8965: iconst_1
    //   8966: istore 12
    //   8968: aload 60
    //   8970: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   8973: invokevirtual 2367	tencent/im/msg/im_msg_body$LifeOnlineAccount:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8976: checkcast 2328	tencent/im/msg/im_msg_body$LifeOnlineAccount
    //   8979: astore 50
    //   8981: sipush -5004
    //   8984: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   8987: checkcast 2382	com/tencent/mobileqq/data/MessageForPubAccount
    //   8990: astore 53
    //   8992: aload 53
    //   8994: sipush -5004
    //   8997: putfield 2383	com/tencent/mobileqq/data/MessageForPubAccount:msgtype	I
    //   9000: aload 53
    //   9002: aload 50
    //   9004: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9007: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9010: putfield 2994	com/tencent/mobileqq/data/MessageForPubAccount:pa_uuid	J
    //   9013: aload 53
    //   9015: aload 50
    //   9017: getfield 2338	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9020: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9023: putfield 2997	com/tencent/mobileqq/data/MessageForPubAccount:pa_op	I
    //   9026: aload 53
    //   9028: aload 50
    //   9030: getfield 2989	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint32_show_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9033: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9036: i2l
    //   9037: putfield 3000	com/tencent/mobileqq/data/MessageForPubAccount:pa_time	J
    //   9040: aload 53
    //   9042: aload_2
    //   9043: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9046: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9049: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9052: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9055: putfield 3001	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   9058: aload 53
    //   9060: aload_2
    //   9061: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9064: getfield 429	msf/msgcomm/msg_comm$MsgHead:to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9067: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9070: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   9073: putfield 3004	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   9076: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9079: ifeq +47 -> 9126
    //   9082: ldc 13
    //   9084: iconst_2
    //   9085: new 91	java/lang/StringBuilder
    //   9088: dup
    //   9089: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   9092: ldc_w 3006
    //   9095: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9098: aload 53
    //   9100: getfield 3001	com/tencent/mobileqq/data/MessageForPubAccount:frienduin	Ljava/lang/String;
    //   9103: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9106: ldc_w 3008
    //   9109: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9112: aload 53
    //   9114: getfield 3004	com/tencent/mobileqq/data/MessageForPubAccount:selfuin	Ljava/lang/String;
    //   9117: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9120: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9123: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   9126: aload_0
    //   9127: aload_2
    //   9128: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9131: getfield 241	msf/msgcomm/msg_comm$MsgHead:from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9134: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9137: aload_2
    //   9138: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9141: getfield 294	msf/msgcomm/msg_comm$MsgHead:msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9144: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9147: aload_2
    //   9148: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9151: getfield 1368	msf/msgcomm/msg_comm$MsgHead:msg_uid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9154: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9157: aload_2
    //   9158: getfield 234	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   9161: getfield 248	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9164: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9167: invokestatic 1370	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   9170: aload 60
    //   9172: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   9175: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9178: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   9181: ifeq +125 -> 9306
    //   9184: aload 60
    //   9186: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   9189: getfield 2335	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_unique_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9192: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9195: lstore 29
    //   9197: aload 60
    //   9199: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   9202: getfield 3011	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_bitmap	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9205: invokevirtual 1501	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   9208: ifeq +110 -> 9318
    //   9211: aload 60
    //   9213: getfield 2326	tencent/im/msg/im_msg_body$Elem:life_online	Ltencent/im/msg/im_msg_body$LifeOnlineAccount;
    //   9216: getfield 3011	tencent/im/msg/im_msg_body$LifeOnlineAccount:uint64_bitmap	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   9219: invokevirtual 245	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   9222: lconst_1
    //   9223: land
    //   9224: lconst_1
    //   9225: lcmp
    //   9226: ifne +86 -> 9312
    //   9229: iconst_1
    //   9230: istore 26
    //   9232: iconst_1
    //   9233: istore 18
    //   9235: iload 10
    //   9237: istore 6
    //   9239: iload 9
    //   9241: istore 15
    //   9243: iload 8
    //   9245: istore 16
    //   9247: iload 13
    //   9249: istore 17
    //   9251: aload 49
    //   9253: astore 54
    //   9255: aload 53
    //   9257: astore 50
    //   9259: aload 47
    //   9261: astore 49
    //   9263: iload 18
    //   9265: istore 8
    //   9267: iload 12
    //   9269: istore 9
    //   9271: iload 11
    //   9273: istore 10
    //   9275: iload 6
    //   9277: istore 11
    //   9279: iload 15
    //   9281: istore 12
    //   9283: iload 16
    //   9285: istore 13
    //   9287: aload 48
    //   9289: astore 47
    //   9291: iload 7
    //   9293: istore 6
    //   9295: iload 17
    //   9297: istore 7
    //   9299: aload 54
    //   9301: astore 48
    //   9303: goto -7064 -> 2239
    //   9306: lconst_0
    //   9307: lstore 29
    //   9309: goto -112 -> 9197
    //   9312: iconst_0
    //   9313: istore 26
    //   9315: goto -83 -> 9232
    //   9318: iconst_0
    //   9319: istore 26
    //   9321: goto -89 -> 9232
    //   9324: aload 60
    //   9326: getfield 3015	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   9329: invokevirtual 3018	tencent/im/msg/im_msg_body$QQWalletMsg:has	()Z
    //   9332: ifeq +465 -> 9797
    //   9335: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9338: ifeq +12 -> 9350
    //   9341: aload 56
    //   9343: ldc_w 3020
    //   9346: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9349: pop
    //   9350: aload 60
    //   9352: getfield 3015	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   9355: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9358: invokevirtual 3027	tencent/im/msg/im_msg_body$QQWalletAioBody:has	()Z
    //   9361: ifne +70 -> 9431
    //   9364: iload 10
    //   9366: istore 15
    //   9368: iload 9
    //   9370: istore 16
    //   9372: aload 52
    //   9374: astore 53
    //   9376: iload 13
    //   9378: istore 17
    //   9380: iload 14
    //   9382: istore 18
    //   9384: aload 47
    //   9386: astore 52
    //   9388: iload 12
    //   9390: istore 14
    //   9392: iload 6
    //   9394: istore 9
    //   9396: iload 11
    //   9398: istore 10
    //   9400: iload 15
    //   9402: istore 11
    //   9404: iload 16
    //   9406: istore 12
    //   9408: iload 8
    //   9410: istore 13
    //   9412: aload 53
    //   9414: astore 47
    //   9416: iload 7
    //   9418: istore 6
    //   9420: iload 17
    //   9422: istore 7
    //   9424: iload 18
    //   9426: istore 8
    //   9428: goto -8752 -> 676
    //   9431: aload 60
    //   9433: getfield 3015	tencent/im/msg/im_msg_body$Elem:qqwallet_msg	Ltencent/im/msg/im_msg_body$QQWalletMsg;
    //   9436: invokevirtual 3028	tencent/im/msg/im_msg_body$QQWalletMsg:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9439: checkcast 3017	tencent/im/msg/im_msg_body$QQWalletMsg
    //   9442: astore 53
    //   9444: sipush -2025
    //   9447: invokestatic 399	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   9450: checkcast 3030	com/tencent/mobileqq/data/MessageForQQWalletMsg
    //   9453: astore 54
    //   9455: aload 54
    //   9457: sipush -2025
    //   9460: putfield 3031	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgtype	I
    //   9463: aload 53
    //   9465: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9468: invokevirtual 3032	tencent/im/msg/im_msg_body$QQWalletAioBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   9471: checkcast 3026	tencent/im/msg/im_msg_body$QQWalletAioBody
    //   9474: getfield 3036	tencent/im/msg/im_msg_body$QQWalletAioBody:sint32_redtype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   9477: invokevirtual 3039	com/tencent/mobileqq/pb/PBSInt32Field:has	()Z
    //   9480: ifeq +148 -> 9628
    //   9483: aload 54
    //   9485: aconst_null
    //   9486: putfield 3043	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   9489: aload 54
    //   9491: new 3045	com/tencent/mobileqq/data/QQWalletRedPacketMsg
    //   9494: dup
    //   9495: aload 53
    //   9497: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9500: aload_0
    //   9501: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9504: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   9507: invokespecial 3048	com/tencent/mobileqq/data/QQWalletRedPacketMsg:<init>	(Ltencent/im/msg/im_msg_body$QQWalletAioBody;Ljava/lang/String;)V
    //   9510: putfield 3052	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   9513: aload 54
    //   9515: aload 54
    //   9517: invokevirtual 3055	com/tencent/mobileqq/data/MessageForQQWalletMsg:getMsgSummary	()Ljava/lang/String;
    //   9520: putfield 3056	com/tencent/mobileqq/data/MessageForQQWalletMsg:msg	Ljava/lang/String;
    //   9523: aload 54
    //   9525: aload 54
    //   9527: invokevirtual 3057	com/tencent/mobileqq/data/MessageForQQWalletMsg:getBytes	()[B
    //   9530: putfield 3058	com/tencent/mobileqq/data/MessageForQQWalletMsg:msgData	[B
    //   9533: aload 54
    //   9535: ifnull +11 -> 9546
    //   9538: aload 54
    //   9540: invokevirtual 3061	com/tencent/mobileqq/data/MessageForQQWalletMsg:isMsgEmpty	()Z
    //   9543: ifeq +118 -> 9661
    //   9546: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9549: ifeq +1399 -> 10948
    //   9552: aload 56
    //   9554: ldc_w 3063
    //   9557: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9560: pop
    //   9561: iload 10
    //   9563: istore 15
    //   9565: iload 9
    //   9567: istore 16
    //   9569: aload 52
    //   9571: astore 53
    //   9573: iload 13
    //   9575: istore 17
    //   9577: iload 14
    //   9579: istore 18
    //   9581: aload 47
    //   9583: astore 52
    //   9585: iload 12
    //   9587: istore 14
    //   9589: iload 6
    //   9591: istore 9
    //   9593: iload 11
    //   9595: istore 10
    //   9597: iload 15
    //   9599: istore 11
    //   9601: iload 16
    //   9603: istore 12
    //   9605: iload 8
    //   9607: istore 13
    //   9609: aload 53
    //   9611: astore 47
    //   9613: iload 7
    //   9615: istore 6
    //   9617: iload 17
    //   9619: istore 7
    //   9621: iload 18
    //   9623: istore 8
    //   9625: goto -8949 -> 676
    //   9628: aload 54
    //   9630: aconst_null
    //   9631: putfield 3052	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletRedPacketMsg	Lcom/tencent/mobileqq/data/QQWalletRedPacketMsg;
    //   9634: aload 54
    //   9636: new 3065	com/tencent/mobileqq/data/QQWalletTransferMsg
    //   9639: dup
    //   9640: aload 53
    //   9642: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9645: aload_0
    //   9646: getfield 216	com/tencent/mobileqq/app/MessageHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9649: invokevirtual 220	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   9652: invokespecial 3066	com/tencent/mobileqq/data/QQWalletTransferMsg:<init>	(Ltencent/im/msg/im_msg_body$QQWalletAioBody;Ljava/lang/String;)V
    //   9655: putfield 3043	com/tencent/mobileqq/data/MessageForQQWalletMsg:mQQWalletTransferMsg	Lcom/tencent/mobileqq/data/QQWalletTransferMsg;
    //   9658: goto -145 -> 9513
    //   9661: aload 53
    //   9663: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9666: getfield 3069	tencent/im/msg/im_msg_body$QQWalletAioBody:uint32_msg_priority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9669: invokevirtual 85	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   9672: ifeq +118 -> 9790
    //   9675: aload 53
    //   9677: getfield 3024	tencent/im/msg/im_msg_body$QQWalletMsg:aio_body	Ltencent/im/msg/im_msg_body$QQWalletAioBody;
    //   9680: getfield 3069	tencent/im/msg/im_msg_body$QQWalletAioBody:uint32_msg_priority	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9683: invokevirtual 88	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9686: istore 10
    //   9688: aload 58
    //   9690: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   9693: ifle +21 -> 9714
    //   9696: iload 10
    //   9698: iconst_1
    //   9699: if_icmple +15 -> 9714
    //   9702: aload 58
    //   9704: iconst_0
    //   9705: aload 58
    //   9707: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   9710: invokevirtual 126	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   9713: pop
    //   9714: aload 57
    //   9716: aload 54
    //   9718: invokeinterface 375 2 0
    //   9723: pop
    //   9724: iload 12
    //   9726: istore 11
    //   9728: iload 6
    //   9730: istore 16
    //   9732: iconst_1
    //   9733: istore 17
    //   9735: iload 9
    //   9737: istore 12
    //   9739: iload 8
    //   9741: istore 6
    //   9743: iload 13
    //   9745: istore 15
    //   9747: aload 49
    //   9749: astore 53
    //   9751: aload 47
    //   9753: astore 49
    //   9755: iload 11
    //   9757: istore 8
    //   9759: iload 16
    //   9761: istore 9
    //   9763: iload 17
    //   9765: istore 11
    //   9767: iload 6
    //   9769: istore 13
    //   9771: aload 48
    //   9773: astore 47
    //   9775: iload 7
    //   9777: istore 6
    //   9779: iload 15
    //   9781: istore 7
    //   9783: aload 53
    //   9785: astore 48
    //   9787: goto -7548 -> 2239
    //   9790: bipush 10
    //   9792: istore 10
    //   9794: goto -106 -> 9688
    //   9797: aload 47
    //   9799: astore 53
    //   9801: aload 60
    //   9803: getfield 3072	tencent/im/msg/im_msg_body$Elem:bankcode_ctrl_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9806: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   9809: ifeq +328 -> 10137
    //   9812: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9815: ifeq +12 -> 9827
    //   9818: aload 56
    //   9820: ldc_w 3074
    //   9823: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9826: pop
    //   9827: aload 60
    //   9829: getfield 3072	tencent/im/msg/im_msg_body$Elem:bankcode_ctrl_info	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   9832: invokevirtual 251	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   9835: invokevirtual 257	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   9838: astore 54
    //   9840: aload 54
    //   9842: iconst_0
    //   9843: baload
    //   9844: istore 15
    //   9846: aload 54
    //   9848: aload 54
    //   9850: arraylength
    //   9851: iconst_1
    //   9852: isub
    //   9853: baload
    //   9854: istore 16
    //   9856: iload 15
    //   9858: bipush 40
    //   9860: if_icmpne +10 -> 9870
    //   9863: iload 16
    //   9865: bipush 41
    //   9867: if_icmpeq +85 -> 9952
    //   9870: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9873: ifeq +1075 -> 10948
    //   9876: aload 56
    //   9878: ldc_w 3076
    //   9881: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9884: pop
    //   9885: iload 10
    //   9887: istore 15
    //   9889: iload 9
    //   9891: istore 16
    //   9893: aload 52
    //   9895: astore 53
    //   9897: iload 13
    //   9899: istore 17
    //   9901: iload 14
    //   9903: istore 18
    //   9905: aload 47
    //   9907: astore 52
    //   9909: iload 12
    //   9911: istore 14
    //   9913: iload 6
    //   9915: istore 9
    //   9917: iload 11
    //   9919: istore 10
    //   9921: iload 15
    //   9923: istore 11
    //   9925: iload 16
    //   9927: istore 12
    //   9929: iload 8
    //   9931: istore 13
    //   9933: aload 53
    //   9935: astore 47
    //   9937: iload 7
    //   9939: istore 6
    //   9941: iload 17
    //   9943: istore 7
    //   9945: iload 18
    //   9947: istore 8
    //   9949: goto -9273 -> 676
    //   9952: aload 54
    //   9954: iconst_2
    //   9955: iconst_2
    //   9956: invokestatic 3082	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   9959: invokevirtual 3086	java/nio/ByteBuffer:getShort	()S
    //   9962: sipush 29786
    //   9965: if_icmpeq +70 -> 10035
    //   9968: iload 10
    //   9970: istore 15
    //   9972: iload 9
    //   9974: istore 16
    //   9976: aload 52
    //   9978: astore 53
    //   9980: iload 13
    //   9982: istore 17
    //   9984: iload 14
    //   9986: istore 18
    //   9988: aload 47
    //   9990: astore 52
    //   9992: iload 12
    //   9994: istore 14
    //   9996: iload 6
    //   9998: istore 9
    //   10000: iload 11
    //   10002: istore 10
    //   10004: iload 15
    //   10006: istore 11
    //   10008: iload 16
    //   10010: istore 12
    //   10012: iload 8
    //   10014: istore 13
    //   10016: aload 53
    //   10018: astore 47
    //   10020: iload 7
    //   10022: istore 6
    //   10024: iload 17
    //   10026: istore 7
    //   10028: iload 18
    //   10030: istore 8
    //   10032: goto -9356 -> 676
    //   10035: aload 54
    //   10037: iconst_4
    //   10038: iconst_2
    //   10039: invokestatic 3082	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   10042: invokevirtual 3086	java/nio/ByteBuffer:getShort	()S
    //   10045: istore 15
    //   10047: iload 15
    //   10049: ifgt +70 -> 10119
    //   10052: iload 10
    //   10054: istore 15
    //   10056: iload 9
    //   10058: istore 16
    //   10060: aload 52
    //   10062: astore 53
    //   10064: iload 13
    //   10066: istore 17
    //   10068: iload 14
    //   10070: istore 18
    //   10072: aload 47
    //   10074: astore 52
    //   10076: iload 12
    //   10078: istore 14
    //   10080: iload 6
    //   10082: istore 9
    //   10084: iload 11
    //   10086: istore 10
    //   10088: iload 15
    //   10090: istore 11
    //   10092: iload 16
    //   10094: istore 12
    //   10096: iload 8
    //   10098: istore 13
    //   10100: aload 53
    //   10102: astore 47
    //   10104: iload 7
    //   10106: istore 6
    //   10108: iload 17
    //   10110: istore 7
    //   10112: iload 18
    //   10114: istore 8
    //   10116: goto -9440 -> 676
    //   10119: iload 15
    //   10121: newarray byte
    //   10123: astore 53
    //   10125: aload 54
    //   10127: bipush 6
    //   10129: aload 53
    //   10131: iconst_0
    //   10132: iload 15
    //   10134: invokestatic 3090	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   10137: iload 10
    //   10139: istore 15
    //   10141: iload 9
    //   10143: istore 16
    //   10145: iload 8
    //   10147: istore 17
    //   10149: aload 48
    //   10151: astore 47
    //   10153: iload 13
    //   10155: istore 18
    //   10157: aload 49
    //   10159: astore 48
    //   10161: aload 53
    //   10163: astore 49
    //   10165: iload 12
    //   10167: istore 8
    //   10169: iload 6
    //   10171: istore 9
    //   10173: iload 11
    //   10175: istore 10
    //   10177: iload 15
    //   10179: istore 11
    //   10181: iload 16
    //   10183: istore 12
    //   10185: iload 17
    //   10187: istore 13
    //   10189: iload 7
    //   10191: istore 6
    //   10193: iload 18
    //   10195: istore 7
    //   10197: goto -7958 -> 2239
    //   10200: aload 57
    //   10202: iload 8
    //   10204: invokeinterface 1460 2 0
    //   10209: instanceof 1238
    //   10212: ifeq +34 -> 10246
    //   10215: iload 7
    //   10217: istore 9
    //   10219: aload_0
    //   10220: astore_2
    //   10221: iload 11
    //   10223: iconst_2
    //   10224: if_icmplt -8248 -> 1976
    //   10227: aload 57
    //   10229: iload 8
    //   10231: invokeinterface 2416 2 0
    //   10236: pop
    //   10237: iload 7
    //   10239: istore 9
    //   10241: aload_0
    //   10242: astore_2
    //   10243: goto -8267 -> 1976
    //   10246: iload 7
    //   10248: istore 9
    //   10250: aload_0
    //   10251: astore_2
    //   10252: aload 57
    //   10254: iload 8
    //   10256: invokeinterface 1460 2 0
    //   10261: instanceof 3030
    //   10264: ifeq -8288 -> 1976
    //   10267: iload 11
    //   10269: iconst_1
    //   10270: if_icmpgt +36 -> 10306
    //   10273: iload 7
    //   10275: istore 9
    //   10277: aload_0
    //   10278: astore_2
    //   10279: aload 58
    //   10281: invokevirtual 115	java/lang/StringBuilder:length	()I
    //   10284: ifle -8308 -> 1976
    //   10287: aload 57
    //   10289: iload 8
    //   10291: invokeinterface 2416 2 0
    //   10296: pop
    //   10297: iload 7
    //   10299: istore 9
    //   10301: aload_0
    //   10302: astore_2
    //   10303: goto -8327 -> 1976
    //   10306: iload 7
    //   10308: istore 9
    //   10310: aload_0
    //   10311: astore_2
    //   10312: iload 11
    //   10314: iconst_2
    //   10315: if_icmpne -8339 -> 1976
    //   10318: iload 7
    //   10320: istore 9
    //   10322: aload_0
    //   10323: astore_2
    //   10324: iload 28
    //   10326: ifeq -8350 -> 1976
    //   10329: aload 57
    //   10331: iload 8
    //   10333: invokeinterface 2416 2 0
    //   10338: pop
    //   10339: iload 7
    //   10341: istore 9
    //   10343: aload_0
    //   10344: astore_2
    //   10345: goto -8369 -> 1976
    //   10348: aload 52
    //   10350: astore_2
    //   10351: iload 8
    //   10353: istore 9
    //   10355: new 99	java/util/ArrayList
    //   10358: dup
    //   10359: invokespecial 1588	java/util/ArrayList:<init>	()V
    //   10362: astore_0
    //   10363: iload 9
    //   10365: ifeq +231 -> 10596
    //   10368: aload_2
    //   10369: ifnull +199 -> 10568
    //   10372: aload_0
    //   10373: aload_2
    //   10374: invokeinterface 375 2 0
    //   10379: pop
    //   10380: aload_0
    //   10381: invokeinterface 2067 1 0
    //   10386: iconst_1
    //   10387: if_icmple +520 -> 10907
    //   10390: aload_0
    //   10391: invokeinterface 59 1 0
    //   10396: astore_2
    //   10397: iconst_0
    //   10398: istore 8
    //   10400: iconst_0
    //   10401: istore 7
    //   10403: aload_2
    //   10404: invokeinterface 64 1 0
    //   10409: ifeq +498 -> 10907
    //   10412: aload_2
    //   10413: invokeinterface 68 1 0
    //   10418: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10421: astore 5
    //   10423: aload 5
    //   10425: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   10428: sipush -1000
    //   10431: if_icmpne +177 -> 10608
    //   10434: iload 7
    //   10436: ifne +172 -> 10608
    //   10439: iconst_1
    //   10440: istore 7
    //   10442: iload 8
    //   10444: iconst_1
    //   10445: iadd
    //   10446: istore 8
    //   10448: iload 8
    //   10450: iconst_2
    //   10451: if_icmplt +177 -> 10628
    //   10454: iconst_1
    //   10455: istore 7
    //   10457: iload 7
    //   10459: ifeq +363 -> 10822
    //   10462: new 99	java/util/ArrayList
    //   10465: dup
    //   10466: invokespecial 1588	java/util/ArrayList:<init>	()V
    //   10469: astore_2
    //   10470: aload_0
    //   10471: invokeinterface 59 1 0
    //   10476: astore 5
    //   10478: aload 5
    //   10480: invokeinterface 64 1 0
    //   10485: ifeq +164 -> 10649
    //   10488: aload 5
    //   10490: invokeinterface 68 1 0
    //   10495: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10498: astore 48
    //   10500: aload 48
    //   10502: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   10505: sipush -1000
    //   10508: if_icmpeq +129 -> 10637
    //   10511: aload 48
    //   10513: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   10516: sipush -2000
    //   10519: if_icmpeq +118 -> 10637
    //   10522: aload_2
    //   10523: invokeinterface 2067 1 0
    //   10528: ifle +28 -> 10556
    //   10531: iload 20
    //   10533: ifeq +98 -> 10631
    //   10536: aconst_null
    //   10537: astore_0
    //   10538: aload_1
    //   10539: aload_2
    //   10540: aload_0
    //   10541: invokestatic 3092	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;[B)Lcom/tencent/mobileqq/data/MessageRecord;
    //   10544: invokeinterface 375 2 0
    //   10549: pop
    //   10550: aload_2
    //   10551: invokeinterface 3095 1 0
    //   10556: aload_1
    //   10557: aload 48
    //   10559: invokeinterface 375 2 0
    //   10564: pop
    //   10565: goto -87 -> 10478
    //   10568: aload 57
    //   10570: invokeinterface 2067 1 0
    //   10575: ifle -195 -> 10380
    //   10578: aload_0
    //   10579: aload 57
    //   10581: iconst_0
    //   10582: invokeinterface 1460 2 0
    //   10587: invokeinterface 375 2 0
    //   10592: pop
    //   10593: goto -213 -> 10380
    //   10596: aload_0
    //   10597: aload 57
    //   10599: invokeinterface 3099 2 0
    //   10604: pop
    //   10605: goto -225 -> 10380
    //   10608: aload 5
    //   10610: getfield 362	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   10613: sipush -2000
    //   10616: if_icmpne +288 -> 10904
    //   10619: iload 8
    //   10621: iconst_1
    //   10622: iadd
    //   10623: istore 8
    //   10625: goto -177 -> 10448
    //   10628: goto -225 -> 10403
    //   10631: aload 47
    //   10633: astore_0
    //   10634: goto -96 -> 10538
    //   10637: aload_2
    //   10638: aload 48
    //   10640: invokeinterface 375 2 0
    //   10645: pop
    //   10646: goto -168 -> 10478
    //   10649: aload_2
    //   10650: invokeinterface 2067 1 0
    //   10655: ifle +30 -> 10685
    //   10658: iload 20
    //   10660: ifeq +6 -> 10666
    //   10663: aconst_null
    //   10664: astore 47
    //   10666: aload_1
    //   10667: aload_2
    //   10668: aload 47
    //   10670: invokestatic 3092	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Ljava/util/List;[B)Lcom/tencent/mobileqq/data/MessageRecord;
    //   10673: invokeinterface 375 2 0
    //   10678: pop
    //   10679: aload_2
    //   10680: invokeinterface 3095 1 0
    //   10685: iload 6
    //   10687: ifeq +12 -> 10699
    //   10690: aload_1
    //   10691: aload 50
    //   10693: invokeinterface 375 2 0
    //   10698: pop
    //   10699: iload 12
    //   10701: ifeq +85 -> 10786
    //   10704: aload_1
    //   10705: iconst_0
    //   10706: invokeinterface 1460 2 0
    //   10711: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10714: astore_0
    //   10715: aload_0
    //   10716: aload_0
    //   10717: getfield 3102	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   10720: iconst_1
    //   10721: ior
    //   10722: putfield 3102	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   10725: aload_1
    //   10726: iconst_0
    //   10727: invokeinterface 1460 2 0
    //   10732: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10735: ldc_w 3104
    //   10738: ldc_w 3106
    //   10741: invokevirtual 3107	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   10744: aload_1
    //   10745: iconst_0
    //   10746: invokeinterface 1460 2 0
    //   10751: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10754: ldc_w 3109
    //   10757: lload 29
    //   10759: invokestatic 475	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   10762: invokevirtual 3107	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   10765: aload_1
    //   10766: iconst_0
    //   10767: invokeinterface 1460 2 0
    //   10772: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10775: ldc_w 3111
    //   10778: iload 26
    //   10780: invokestatic 3114	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   10783: invokevirtual 3107	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   10786: invokestatic 150	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10789: ifeq -10697 -> 92
    //   10792: aload 56
    //   10794: ldc_w 3116
    //   10797: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10800: aload_1
    //   10801: invokeinterface 2067 1 0
    //   10806: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   10809: pop
    //   10810: ldc 13
    //   10812: iconst_2
    //   10813: aload 56
    //   10815: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10818: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10821: return
    //   10822: aload 47
    //   10824: ifnonnull +14 -> 10838
    //   10827: aload_1
    //   10828: aload_0
    //   10829: invokeinterface 3099 2 0
    //   10834: pop
    //   10835: goto -150 -> 10685
    //   10838: aload_0
    //   10839: invokeinterface 59 1 0
    //   10844: astore_0
    //   10845: aload_0
    //   10846: invokeinterface 64 1 0
    //   10851: ifeq -166 -> 10685
    //   10854: aload_0
    //   10855: invokeinterface 68 1 0
    //   10860: checkcast 356	com/tencent/mobileqq/data/MessageRecord
    //   10863: astore_2
    //   10864: aload_2
    //   10865: instanceof 1238
    //   10868: ifeq +20 -> 10888
    //   10871: iload 20
    //   10873: ifne +15 -> 10888
    //   10876: aload_2
    //   10877: ldc_w 406
    //   10880: aload 47
    //   10882: invokestatic 411	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   10885: invokevirtual 3107	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   10888: aload_1
    //   10889: aload_2
    //   10890: invokeinterface 375 2 0
    //   10895: pop
    //   10896: goto -51 -> 10845
    //   10899: astore 53
    //   10901: goto -9546 -> 1355
    //   10904: goto -456 -> 10448
    //   10907: iconst_0
    //   10908: istore 7
    //   10910: goto -453 -> 10457
    //   10913: aload 48
    //   10915: astore 53
    //   10917: iload 14
    //   10919: istore 15
    //   10921: aload 47
    //   10923: astore 48
    //   10925: aload 52
    //   10927: astore 47
    //   10929: aload 49
    //   10931: astore 52
    //   10933: iload 8
    //   10935: istore 14
    //   10937: iload 15
    //   10939: istore 8
    //   10941: aload 53
    //   10943: astore 49
    //   10945: goto -10269 -> 676
    //   10948: iload 10
    //   10950: istore 15
    //   10952: iload 9
    //   10954: istore 16
    //   10956: aload 52
    //   10958: astore 53
    //   10960: iload 13
    //   10962: istore 17
    //   10964: iload 14
    //   10966: istore 18
    //   10968: aload 47
    //   10970: astore 52
    //   10972: iload 12
    //   10974: istore 14
    //   10976: iload 6
    //   10978: istore 9
    //   10980: iload 11
    //   10982: istore 10
    //   10984: iload 15
    //   10986: istore 11
    //   10988: iload 16
    //   10990: istore 12
    //   10992: iload 8
    //   10994: istore 13
    //   10996: aload 53
    //   10998: astore 47
    //   11000: iload 7
    //   11002: istore 6
    //   11004: iload 17
    //   11006: istore 7
    //   11008: iload 18
    //   11010: istore 8
    //   11012: goto -10336 -> 676
    //   11015: aconst_null
    //   11016: astore 53
    //   11018: goto -5668 -> 5350
    //   11021: aconst_null
    //   11022: astore 53
    //   11024: goto -7632 -> 3392
    //   11027: iconst_0
    //   11028: istore 15
    //   11030: goto -7788 -> 3242
    //   11033: goto -10253 -> 780
    //   11036: iconst_0
    //   11037: istore 20
    //   11039: goto -10788 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	11042	0	paramMessageHandler	MessageHandler
    //   0	11042	1	paramList	List
    //   0	11042	2	paramMsg	msg_comm.Msg
    //   0	11042	3	paramBoolean1	boolean
    //   0	11042	4	paramBoolean2	boolean
    //   0	11042	5	paramMessageInfo	com.tencent.mobileqq.troop.data.MessageInfo
    //   165	10838	6	i	int
    //   131	10876	7	j	int
    //   152	10859	8	k	int
    //   155	10824	9	m	int
    //   158	10825	10	n	int
    //   162	10825	11	i1	int
    //   168	10823	12	i2	int
    //   128	10867	13	i3	int
    //   125	10850	14	i4	int
    //   619	10410	15	i5	int
    //   623	10366	16	i6	int
    //   627	10378	17	i7	int
    //   700	10309	18	i8	int
    //   704	6253	19	i9	int
    //   249	10789	20	i10	int
    //   252	5404	21	i11	int
    //   2135	4832	22	i12	int
    //   3290	3743	23	i13	int
    //   3300	439	24	i14	int
    //   3366	306	25	i15	int
    //   174	10605	26	bool1	boolean
    //   7675	142	27	bool2	boolean
    //   194	10131	28	bool3	boolean
    //   171	10587	29	l1	long
    //   228	7454	31	l2	long
    //   399	7246	33	l3	long
    //   424	7139	35	l4	long
    //   449	7218	37	l5	long
    //   187	2238	39	l6	long
    //   3976	3693	41	l7	long
    //   7372	275	43	l8	long
    //   7383	260	45	l9	long
    //   203	10796	47	localObject1	Object
    //   146	4579	48	localObject2	Object
    //   4749	3	48	localException1	Exception
    //   4774	6150	48	localObject3	Object
    //   28	10916	49	localObject4	Object
    //   200	10492	50	localObject5	Object
    //   197	7886	51	str	String
    //   149	10822	52	localObject6	Object
    //   646	4367	53	localObject7	Object
    //   5043	196	53	localException2	Exception
    //   5316	4846	53	localObject8	Object
    //   10899	1	53	localException3	Exception
    //   10915	108	53	localObject9	Object
    //   885	408	54	localObject10	Object
    //   1335	3	54	localException4	Exception
    //   1345	7	54	localException5	Exception
    //   1427	3	54	localException6	Exception
    //   2165	2592	54	localObject11	Object
    //   4840	3	54	localException7	Exception
    //   4850	131	54	localException8	Exception
    //   5067	315	54	localTroopFileData	com.tencent.mobileqq.data.TroopFileData
    //   5518	3	54	localException9	Exception
    //   6006	3	54	localException10	Exception
    //   6236	1463	54	localObject12	Object
    //   7805	3	54	localUnsupportedEncodingException	UnsupportedEncodingException
    //   7954	2172	54	localObject13	Object
    //   1021	7032	55	localObject14	Object
    //   40	10774	56	localStringBuilder1	StringBuilder
    //   49	10549	57	localArrayList	ArrayList
    //   143	10137	58	localStringBuilder2	StringBuilder
    //   25	7923	59	localList	List
    //   304	9524	60	localElem	im_msg_body.Elem
    //   3090	3837	61	localObject15	Object
    //   3155	3751	62	localObject16	Object
    //   3250	3849	63	localObject17	Object
    //   3260	3812	64	localObject18	Object
    //   3439	3349	65	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   1225	1232	1335	java/lang/Exception
    //   1196	1225	1345	java/lang/Exception
    //   1242	1252	1345	java/lang/Exception
    //   1252	1264	1345	java/lang/Exception
    //   1337	1342	1345	java/lang/Exception
    //   1429	1434	1345	java/lang/Exception
    //   1232	1242	1427	java/lang/Exception
    //   4578	4584	4749	java/lang/Exception
    //   4588	4602	4749	java/lang/Exception
    //   4606	4614	4749	java/lang/Exception
    //   4618	4625	4749	java/lang/Exception
    //   4638	4647	4749	java/lang/Exception
    //   4655	4665	4749	java/lang/Exception
    //   4669	4681	4749	java/lang/Exception
    //   4685	4696	4749	java/lang/Exception
    //   4700	4720	4749	java/lang/Exception
    //   4724	4746	4749	java/lang/Exception
    //   4794	4801	4840	java/lang/Exception
    //   4801	4811	4850	java/lang/Exception
    //   5000	5012	5043	java/lang/Exception
    //   5379	5389	5518	java/lang/Exception
    //   5908	5918	6006	java/lang/Exception
    //   7506	7529	7805	java/io/UnsupportedEncodingException
    //   1158	1191	10899	java/lang/Exception
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext) {}
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List paramList)
  {
    Object localObject3 = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    String str = ((im_msg_body.Ptt)localObject3).bytes_file_name.get().toStringUtf8();
    int i;
    int j;
    int k;
    boolean bool;
    long l1;
    long l2;
    long l3;
    long l4;
    long l5;
    Object localObject1;
    Object localObject2;
    if (str.endsWith(".amr"))
    {
      if (!SttManager.a(paramMessageHandler.a)) {
        break label615;
      }
      i = 1;
      j = b(paramMsg);
      k = ((im_msg_body.Ptt)localObject3).uint32_file_type.get();
      bool = ((im_msg_body.Ptt)localObject3).bool_valid.get();
      l1 = ((im_msg_body.Ptt)localObject3).uint64_src_uin.get();
      l2 = ((im_msg_body.Ptt)localObject3).uint32_file_size.get();
      l3 = ((im_msg_body.Ptt)localObject3).uint32_file_id.get() & 0xFFFFFFFF;
      l4 = ((im_msg_body.Ptt)localObject3).uint32_server_ip.get();
      l5 = ((im_msg_body.Ptt)localObject3).uint32_server_port.get();
      localObject1 = ((im_msg_body.Ptt)localObject3).bytes_file_uuid.get().toByteArray();
      paramMessageHandler = ((im_msg_body.Ptt)localObject3).bytes_file_md5.get().toByteArray();
      localObject2 = HexUtil.a((byte[])localObject1);
      localObject1 = HexUtil.a(paramMessageHandler);
      if (!((im_msg_body.Ptt)localObject3).bytes_group_file_key.has()) {
        break label632;
      }
    }
    label615:
    label632:
    for (paramMessageHandler = ((im_msg_body.Ptt)localObject3).bytes_group_file_key.get().toByteArray();; paramMessageHandler = null) {
      try
      {
        paramMessageHandler = new String(paramMessageHandler, "utf-8");
        if (localObject1 == null)
        {
          localObject1 = "";
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
            ((StringBuilder)localObject3).append(" pttType:").append(k).append(" isValid:").append(bool).append(" srcUin:").append(l1).append(" fileSize:").append(l2 & 0xFFFFFFFF).append(" fileID").append(l3).append(" serverIP:").append(l4 & 0xFFFFFFFF).append(" serverPort:").append(l5 & 0xFFFFFFFF).append(" fileName:").append(str).append(" uuidStr:").append((String)localObject2).append(" md5Str:").append((String)localObject1).append(" GrpFileKey:").append(paramMessageHandler);
            QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject3).toString());
          }
          TransfileUtile.a(str, 0L, 2, false, str);
          localObject2 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject2).localPath.set(str);
          ((RichMsg.PttRec)localObject2).size.set(0L);
          ((RichMsg.PttRec)localObject2).type.set(2);
          ((RichMsg.PttRec)localObject2).uuid.set(str);
          ((RichMsg.PttRec)localObject2).isRead.set(false);
          ((RichMsg.PttRec)localObject2).md5.set((String)localObject1);
          ((RichMsg.PttRec)localObject2).isReport.set(0);
          ((RichMsg.PttRec)localObject2).version.set(5);
          ((RichMsg.PttRec)localObject2).groupFileID.set(l3);
          ((RichMsg.PttRec)localObject2).pttFlag.set(i);
          ((RichMsg.PttRec)localObject2).longPttVipFlag.set(j);
          if (paramMessageHandler != null) {
            ((RichMsg.PttRec)localObject2).group_file_key.set(paramMessageHandler);
          }
          l1 = System.currentTimeMillis() / 1000L;
          l2 = paramMsg.msg_head.msg_time.get();
          ((RichMsg.PttRec)localObject2).msgRecTime.set(l1);
          ((RichMsg.PttRec)localObject2).msgTime.set(l2);
          paramMessageHandler = MessageRecordFactory.a(-2002);
          paramMessageHandler.msgtype = -2002;
          paramMessageHandler.msgData = ((RichMsg.PttRec)localObject2).toByteArray();
          ((MessageForPtt)paramMessageHandler).parse();
          paramList.add(paramMessageHandler);
          return;
          i = a(paramMsg);
        }
      }
      catch (UnsupportedEncodingException paramMessageHandler)
      {
        for (;;)
        {
          paramMessageHandler = null;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new jvg(paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.a.a(8)).a(paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.a.a()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187), paramMsg);
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMessageHandler = paramMsgType0x210.msg_content.get().toByteArray();
    paramMsgType0x210 = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)paramMsgType0x210.mergeFrom(paramMessageHandler)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x35.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)MessageCache.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.a().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (TroopNotificationHelper.c(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.a(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "notice has exist!");
        }
      }
      else {
        TroopNotificationHelper.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
      }
    }
    paramArrayOfByte.a();
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.a(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  private static boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((im_msg_body.Elem)paramList.next()).rich_msg.has()) {
        return true;
      }
    }
    return false;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException3)
      {
        for (;;)
        {
          localIOException3.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      localException.printStackTrace();
      try
      {
        localByteArrayOutputStream.close();
        for (;;)
        {
          localInflater.end();
          return paramArrayOfByte;
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          paramArrayOfByte = arrayOfByte2;
          try
          {
            localByteArrayOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1000: 
      return 3;
    case 1005: 
      return 6;
    case 1008: 
      return 8;
    case 1006: 
      return 10;
    case 1004: 
      return 5;
    case 1009: 
      return 11;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    case 1001: 
      return 12;
    case 1020: 
      return 14;
    case 1021: 
      return 16;
    case 1022: 
      return 17;
    case 1023: 
      return 18;
    case 1024: 
    case 1025: 
      return 15;
    case 1010: 
      return 19;
    }
    return 20;
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  private static PAMessage b(String paramString)
  {
    paramString = PAMessageUtil.b(paramString);
    if (paramString != null) {
      return paramString;
    }
    return null;
  }
  
  public static void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    MessageCache.a();
    Long.valueOf(paramMessageHandler.a.a()).longValue();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "recv MultiVideo offline msg !msgTime is:" + l1);
    }
    paramMessageHandler.a.a().i(paramMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */