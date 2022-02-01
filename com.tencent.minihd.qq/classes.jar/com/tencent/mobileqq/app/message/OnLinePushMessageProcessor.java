package com.tencent.mobileqq.app.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.FriendsManagerImp;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForEnterTroop.User;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.DateEventManager;
import com.tencent.mobileqq.dating.DatingManager;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.msf.service.protocol.pb.SubMsgType0x51.MsgBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import htf;
import htg;
import hth;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgType0x210;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;

public class OnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  public htg a;
  
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_Htg = new htg(this, null);
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    PkgTools.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    PkgTools.a(paramMsgInfo, 5);
    PkgTools.a(paramMsgInfo, 9);
    PkgTools.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    PkgTools.a(paramMsgInfo, 18);
    PkgTools.a(paramMsgInfo, 22);
    PkgTools.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramInt);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsgResp");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.aO = paramSvcReqPushMsg.wUserActive;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:" + paramSvcReqPushMsg.wUserActive);
    }
    String str = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    ArrayList localArrayList3;
    long l3;
    int m;
    ArrayList localArrayList4;
    MsgInfo localMsgInfo;
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localArrayList3 = new ArrayList();
      BaseApplication.getContext().getSharedPreferences("share", 0).getString("no_auto_reply" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "");
      l3 = paramSvcReqPushMsg.lUin;
      m = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (localIterator.hasNext()) {
        localMsgInfo = (MsgInfo)localIterator.next();
      }
    }
    for (;;)
    {
      int k;
      long l2;
      long l1;
      long l4;
      label536:
      Object localObject2;
      try
      {
        new ArrayList();
        j = localMsgInfo.shMsgType;
        k = -1000;
        localObject1 = null;
        l2 = localMsgInfo.lFromUin;
        l1 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l4 = paramToServiceMsg.longValue();
        if (l4 == l2) {}
        paramToServiceMsg = new DelMsgInfo();
        ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", str, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2166;
        }
        if (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localArrayList1.add(paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
        if (paramToServiceMsg.jdField_a_of_type_Boolean) {
          break;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localObject2 = MessageRecordFactory.a(k);
        ((MessageRecord)localObject2).init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, k, i, localMsgInfo.uMsgTime);
        ((MessageRecord)localObject2).shmsgseq = localMsgInfo.shMsgSeq;
        ((MessageRecord)localObject2).isread = bool1;
        ((MessageRecord)localObject2).msgUid = localMsgInfo.lMsgUid;
        ((MessageRecord)localObject2).msgData = ((byte[])localObject1);
        if (j > 0) {
          ((MessageRecord)localObject2).extraflag = j;
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, true)) {
          localArrayList1.add(localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + k + " friendType: " + i + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break;
      }
      localArrayList4.add(AppShareIDUtil.a(localMsgInfo.uAppShareID));
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break;
      }
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = PkgTools.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2183;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = PkgTools.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject1;
          if (localMsgInfo.vMsg.length < 9) {
            break label2205;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.b(paramToServiceMsg), "utf-8");
          break label2205;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          }
          if ((i != 16) || (localMsgInfo.vMsg.length <= 7)) {
            break label2228;
          }
          localObject1 = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
          localObject2 = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a((byte[])localObject2, 0, localMsgInfo.vMsg, 7, localObject2.length);
          ((TroopTipsMsgMgr)localObject1).a((byte[])localObject2, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false);
          break label2228;
          label1421:
          if (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramToServiceMsg, localMsgInfo.shMsgSeq)) {
            break label2227;
          }
          break label2245;
          label1448:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2262;
          }
          c(paramToServiceMsg);
          break label2245;
          label1482:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2245;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          a(paramToServiceMsg, i);
          break label2245;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(MessageUtils.b(localMsgInfo.vMsg), "utf-8");
          localObject1 = ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(l1 + "");
          if ((localObject1 == null) || (!((Friends)localObject1).isFriend())) {
            break label2279;
          }
          i = 0;
          label1611:
          localObject1 = new SafeMsg.SafeMoreInfo();
          ((SafeMsg.SafeMoreInfo)localObject1).strFromMobile.set(localMsgInfo.strFromMobile);
          ((SafeMsg.SafeMoreInfo)localObject1).strFromName.set(localMsgInfo.strFromName);
          ((SafeMsg.SafeMoreInfo)localObject1).strMsgTxt.set(paramToServiceMsg);
          localObject1 = ((SafeMsg.SafeMoreInfo)localObject1).toByteArray();
          k = -1002;
          bool1 = true;
          j = -1;
          continue;
        }
        if (SystemMsg.isSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
          k = -1006 - (j - 187);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, j, k);
          FriendSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          l1 = 9998L;
          localObject1 = null;
          paramToServiceMsg = null;
          j = -1;
          bool1 = false;
          i = 0;
          continue;
        }
        if (SystemMsg.isTroopSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
          if (j == 45)
          {
            paramToServiceMsg = a(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2287;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2287;
          }
        }
      }
      for (;;)
      {
        GroupSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = null;
        paramToServiceMsg = null;
        bool1 = false;
        j = i;
        i = 0;
        break label536;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
        l1 = 9998L;
        i = 32769;
        k = SystemMsg.getTroopSystemMsgType(j);
        continue;
        if (528 == j)
        {
          paramToServiceMsg = b(localMsgInfo, l4);
          if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
            break label2293;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2293;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        break;
        if (localArrayList4.size() > 0) {
          a(localArrayList4);
        }
        i = paramFromServiceMsg.getRequestSsoSeq();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, m, i);
        boolean bool2;
        boolean bool3;
        if (localArrayList1.size() > 0)
        {
          bool2 = MessageHandlerUtils.a(localArrayList1);
          bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
          i = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause)) {
            break label2155;
          }
        }
        label2155:
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
          return;
        }
        paramToServiceMsg = null;
        break label2183;
        label2166:
        paramToServiceMsg = null;
        j = -1;
        localObject1 = null;
        bool1 = false;
        i = 0;
        break label536;
        label2183:
        i = 1000;
        k = -1000;
        j = -1;
        localObject1 = null;
        bool1 = false;
        break label536;
        label2205:
        k = -1000;
        j = -1;
        localObject1 = null;
        bool1 = false;
        i = 1020;
        break label536;
        label2227:
        return;
        label2228:
        if (i == 12) {
          break label1421;
        }
        if (i != 14) {
          break label1448;
        }
        break label1421;
        label2245:
        label2262:
        do
        {
          paramToServiceMsg = null;
          j = -1;
          localObject1 = null;
          bool1 = false;
          i = 0;
          break;
          if (i == 11) {
            break label1482;
          }
        } while (i != 13);
        break label1482;
        label2279:
        i = 1000;
        break label1611;
        label2287:
        i = -1;
      }
      label2293:
      paramToServiceMsg = null;
      int j = -1;
      Object localObject1 = null;
      boolean bool1 = false;
      int i = 0;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      paramArrayOfByte = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject1).mergeFrom(paramArrayOfByte);
      long l = paramArrayOfByte.uint64_group_code.get();
      paramArrayOfByte = paramArrayOfByte.rpt_msg_visitor_join_info.get();
      Object localObject3;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = (FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
        localObject3 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
        if (!((FriendManager)localObject2).f(String.valueOf(l))) {
          break label301;
        }
        localObject2 = (MessageForEnterTroop)MessageRecordFactory.a(-4003);
        ((MessageForEnterTroop)localObject2).init((String)localObject1, "" + l, (String)localObject1, "", MessageCache.a(), -4003, 1, 0L);
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (cmd0x2dc.VisitorJoinInfo)paramArrayOfByte.next();
          if (!("" + ((cmd0x2dc.VisitorJoinInfo)localObject3).uint64_visitor_uin.get()).equalsIgnoreCase((String)localObject1)) {
            ((MessageForEnterTroop)localObject2).mList.add(new MessageForEnterTroop.User("" + ((cmd0x2dc.VisitorJoinInfo)localObject3).uint64_visitor_uin.get(), ((cmd0x2dc.VisitorJoinInfo)localObject3).bytes_visitor_name.get().toStringUtf8()));
          }
        }
        if (((MessageForEnterTroop)localObject2).mList.size() > 0)
        {
          ((MessageForEnterTroop)localObject2).isread = true;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject2, (String)localObject1);
        }
      }
      label301:
      while (!((HotChatManager)localObject3).d(String.valueOf(l))) {
        return;
      }
      Object localObject2 = paramArrayOfByte.iterator();
      paramArrayOfByte = "";
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cmd0x2dc.VisitorJoinInfo)((Iterator)localObject2).next();
        String str = "" + ((cmd0x2dc.VisitorJoinInfo)localObject3).uint64_visitor_uin.get();
        if (!str.equalsIgnoreCase((String)localObject1))
        {
          if (((cmd0x2dc.VisitorJoinInfo)localObject3).bytes_visitor_name.get().toStringUtf8().equals("")) {}
          for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + ((cmd0x2dc.VisitorJoinInfo)localObject3).bytes_visitor_name.get().toStringUtf8() + "、") {
            break;
          }
        }
      }
      paramArrayOfByte = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
      if (paramInt == 11) {}
      for (paramArrayOfByte = paramArrayOfByte + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131369511);; paramArrayOfByte = paramArrayOfByte + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131369512))
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.a(paramArrayOfByte, 5);
      long l3 = PkgTools.a(paramArrayOfByte, 9);
      int i = PkgTools.b(paramArrayOfByte, 13);
      paramArrayOfByte = PkgTools.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +13 -> 16
    //   6: ldc_w 672
    //   9: iconst_2
    //   10: ldc_w 674
    //   13: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: aload_1
    //   17: getfield 25	OnlinePushPack/MsgInfo:vMsg	[B
    //   20: invokestatic 679	com/tencent/mobileqq/service/gamecenter/GameCenterPackeger:a	([B)LIMMsgBodyPack/MsgType0x210;
    //   23: astore 13
    //   25: aload 13
    //   27: ifnonnull +5 -> 32
    //   30: aconst_null
    //   31: areturn
    //   32: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +34 -> 69
    //   38: ldc_w 672
    //   41: iconst_2
    //   42: new 74	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 681
    //   52: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 13
    //   57: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   60: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload 13
    //   71: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   74: ldc2_w 687
    //   77: lcmp
    //   78: ifne +140 -> 218
    //   81: aload 13
    //   83: getfield 692	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   86: ifnull +132 -> 218
    //   89: aload 13
    //   91: getfield 692	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +167 -> 263
    //   99: aload_1
    //   100: getfield 697	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   103: ifnull +160 -> 263
    //   106: aload_1
    //   107: getfield 697	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   110: astore 9
    //   112: aload 9
    //   114: ifnull +149 -> 263
    //   117: aload 9
    //   119: invokeinterface 572 1 0
    //   124: ifle +139 -> 263
    //   127: aload_0
    //   128: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   131: bipush 11
    //   133: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   136: checkcast 699	com/tencent/mobileqq/servlet/GameCenterManagerImp
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +122 -> 263
    //   144: aload 9
    //   146: invokeinterface 585 1 0
    //   151: astore 9
    //   153: aload 9
    //   155: invokeinterface 153 1 0
    //   160: ifeq +103 -> 263
    //   163: aload 9
    //   165: invokeinterface 157 1 0
    //   170: checkcast 701	IMMsgBodyPack/PluginNum
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull -24 -> 153
    //   180: aload 10
    //   182: getfield 704	IMMsgBodyPack/PluginNum:dwID	J
    //   185: lstore_2
    //   186: aload 10
    //   188: getfield 708	IMMsgBodyPack/PluginNum:cFlag	B
    //   191: ifne +21 -> 212
    //   194: iconst_0
    //   195: istore 8
    //   197: aload_1
    //   198: lload_2
    //   199: iload 8
    //   201: aload 10
    //   203: getfield 711	IMMsgBodyPack/PluginNum:dwNUm	J
    //   206: invokevirtual 714	com/tencent/mobileqq/servlet/GameCenterManagerImp:a	(JZJ)V
    //   209: goto -56 -> 153
    //   212: iconst_1
    //   213: istore 8
    //   215: goto -18 -> 197
    //   218: aload 13
    //   220: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   223: ifnull +40 -> 263
    //   226: aload 13
    //   228: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   231: ldc2_w 718
    //   234: lcmp
    //   235: ifne +30 -> 265
    //   238: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +13 -> 254
    //   244: ldc_w 672
    //   247: iconst_2
    //   248: ldc_w 721
    //   251: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload_0
    //   255: aload 13
    //   257: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   260: invokevirtual 723	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([B)V
    //   263: aconst_null
    //   264: areturn
    //   265: aload 13
    //   267: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   270: ldc2_w 724
    //   273: lcmp
    //   274: ifeq +15 -> 289
    //   277: aload 13
    //   279: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   282: ldc2_w 726
    //   285: lcmp
    //   286: ifne +47 -> 333
    //   289: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +13 -> 305
    //   295: ldc_w 729
    //   298: iconst_2
    //   299: ldc_w 731
    //   302: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_0
    //   306: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: bipush 10
    //   311: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   314: checkcast 733	com/tencent/mobileqq/app/PublicAccountHandler
    //   317: aload 13
    //   319: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   322: aload 13
    //   324: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   327: invokevirtual 736	com/tencent/mobileqq/app/PublicAccountHandler:a	(J[B)V
    //   330: goto -67 -> 263
    //   333: aload 13
    //   335: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   338: ldc2_w 737
    //   341: lcmp
    //   342: ifne +42 -> 384
    //   345: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   348: ifeq +13 -> 361
    //   351: ldc_w 740
    //   354: iconst_2
    //   355: ldc_w 742
    //   358: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   365: bipush 17
    //   367: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   370: checkcast 744	com/tencent/mobileqq/app/ShieldListHandler
    //   373: aload 13
    //   375: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   378: invokevirtual 745	com/tencent/mobileqq/app/ShieldListHandler:a	([B)V
    //   381: goto -118 -> 263
    //   384: aload 13
    //   386: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   389: ldc2_w 746
    //   392: lcmp
    //   393: ifne +16 -> 409
    //   396: aload_0
    //   397: lload_2
    //   398: aload 13
    //   400: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   403: invokespecial 749	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	(J[B)V
    //   406: goto -143 -> 263
    //   409: aload 13
    //   411: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   414: ldc2_w 750
    //   417: lcmp
    //   418: ifne +85 -> 503
    //   421: new 753	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   424: dup
    //   425: invokespecial 754	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   428: aload 13
    //   430: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   433: invokevirtual 755	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   436: checkcast 753	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   439: getfield 759	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   442: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   445: istore 4
    //   447: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq -187 -> 263
    //   453: ldc 57
    //   455: iconst_2
    //   456: new 74	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 765
    //   466: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload 4
    //   471: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: goto -217 -> 263
    //   483: astore_1
    //   484: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq -224 -> 263
    //   490: ldc 57
    //   492: iconst_2
    //   493: ldc_w 767
    //   496: aload_1
    //   497: invokestatic 771	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   500: goto -237 -> 263
    //   503: aload 13
    //   505: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   508: ldc2_w 772
    //   511: lcmp
    //   512: ifne +333 -> 845
    //   515: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +13 -> 531
    //   521: ldc_w 775
    //   524: iconst_2
    //   525: ldc_w 777
    //   528: invokestatic 780	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: new 782	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   534: dup
    //   535: invokespecial 783	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   538: astore 9
    //   540: aload 9
    //   542: aload 13
    //   544: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   547: invokevirtual 784	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   550: pop
    //   551: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq +111 -> 665
    //   557: new 74	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 786
    //   567: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: astore 10
    //   572: aload 9
    //   574: getfield 787	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   577: invokevirtual 790	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   580: ifeq +253 -> 833
    //   583: aload 9
    //   585: getfield 787	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   588: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   591: invokestatic 212	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   594: astore_1
    //   595: aload 10
    //   597: aload_1
    //   598: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: ldc_w 792
    //   604: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: astore 10
    //   609: aload 9
    //   611: getfield 795	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   614: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   617: ifeq +222 -> 839
    //   620: aload 9
    //   622: getfield 795	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   625: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   628: invokestatic 798	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   631: astore_1
    //   632: ldc_w 775
    //   635: iconst_2
    //   636: aload 10
    //   638: aload_1
    //   639: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: ldc_w 800
    //   645: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload 9
    //   650: getfield 803	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   653: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   656: invokevirtual 806	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   659: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 808	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: aload 9
    //   667: getfield 787	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   670: invokevirtual 790	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   673: ifeq -410 -> 263
    //   676: aload 9
    //   678: getfield 795	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   681: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   684: ifeq +87 -> 771
    //   687: aload 9
    //   689: getfield 795	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   692: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   695: istore 4
    //   697: aload 9
    //   699: getfield 787	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   702: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   705: invokestatic 212	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   708: astore_1
    //   709: aload_0
    //   710: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   713: bipush 8
    //   715: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   718: checkcast 189	com/tencent/mobileqq/app/FriendsManagerImp
    //   721: astore 10
    //   723: aload 10
    //   725: aload_1
    //   726: invokevirtual 811	com/tencent/mobileqq/app/FriendsManagerImp:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   729: astore 11
    //   731: aload 11
    //   733: iload 4
    //   735: i2b
    //   736: putfield 816	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   739: aload 10
    //   741: aload 11
    //   743: invokevirtual 819	com/tencent/mobileqq/app/FriendsManagerImp:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   746: iconst_1
    //   747: aload 11
    //   749: getfield 816	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   752: if_icmpne +19 -> 771
    //   755: aload_0
    //   756: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   759: bipush 19
    //   761: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   764: checkcast 821	com/tencent/mobileqq/app/TroopHandler
    //   767: aload_1
    //   768: invokevirtual 824	com/tencent/mobileqq/app/TroopHandler:g	(Ljava/lang/String;)V
    //   771: aload 9
    //   773: getfield 803	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   776: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   779: ifeq -516 -> 263
    //   782: aload 9
    //   784: getfield 787	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   787: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   790: lstore_2
    //   791: aload_0
    //   792: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   795: bipush 19
    //   797: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   800: checkcast 821	com/tencent/mobileqq/app/TroopHandler
    //   803: lload_2
    //   804: invokestatic 212	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   807: invokevirtual 824	com/tencent/mobileqq/app/TroopHandler:g	(Ljava/lang/String;)V
    //   810: goto -547 -> 263
    //   813: astore_1
    //   814: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   817: ifeq -554 -> 263
    //   820: ldc_w 775
    //   823: iconst_2
    //   824: ldc_w 826
    //   827: invokestatic 808	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: goto -567 -> 263
    //   833: ldc 131
    //   835: astore_1
    //   836: goto -241 -> 595
    //   839: ldc 131
    //   841: astore_1
    //   842: goto -210 -> 632
    //   845: aload 13
    //   847: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   850: ldc2_w 827
    //   853: lcmp
    //   854: ifne +26 -> 880
    //   857: aload_0
    //   858: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   861: bipush 16
    //   863: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   866: checkcast 830	com/tencent/mobileqq/stt/SttManager
    //   869: aload 13
    //   871: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   874: invokevirtual 831	com/tencent/mobileqq/stt/SttManager:a	([B)V
    //   877: goto -614 -> 263
    //   880: aload 13
    //   882: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   885: ldc2_w 832
    //   888: lcmp
    //   889: ifne +18 -> 907
    //   892: aload_0
    //   893: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   896: aload 13
    //   898: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   901: invokestatic 838	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   904: goto -641 -> 263
    //   907: aload 13
    //   909: ifnull +36 -> 945
    //   912: aload 13
    //   914: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   917: ldc2_w 839
    //   920: lcmp
    //   921: ifne +24 -> 945
    //   924: aload 13
    //   926: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   929: ifnull +16 -> 945
    //   932: aload_0
    //   933: lload_2
    //   934: aload 13
    //   936: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   939: invokevirtual 841	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(J[B)V
    //   942: goto -679 -> 263
    //   945: aload 13
    //   947: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   950: ldc2_w 842
    //   953: lcmp
    //   954: ifne +23 -> 977
    //   957: aload 13
    //   959: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   962: ifnull +15 -> 977
    //   965: aload_0
    //   966: aload 13
    //   968: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   971: invokevirtual 845	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	([B)V
    //   974: goto -711 -> 263
    //   977: aload 13
    //   979: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   982: ldc2_w 846
    //   985: lcmp
    //   986: ifne +313 -> 1299
    //   989: aload 13
    //   991: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   994: ifnull +305 -> 1299
    //   997: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1000: ifeq +13 -> 1013
    //   1003: ldc_w 849
    //   1006: iconst_2
    //   1007: ldc_w 851
    //   1010: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1013: new 853	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   1016: dup
    //   1017: invokespecial 854	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   1020: astore_1
    //   1021: aload_1
    //   1022: aload 13
    //   1024: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1027: invokevirtual 855	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1030: pop
    //   1031: new 857	android/content/Intent
    //   1034: dup
    //   1035: invokespecial 858	android/content/Intent:<init>	()V
    //   1038: astore 9
    //   1040: aload 9
    //   1042: ldc_w 860
    //   1045: aload_1
    //   1046: getfield 863	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1049: invokevirtual 867	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1052: invokevirtual 871	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1055: pop
    //   1056: aload 9
    //   1058: ldc_w 873
    //   1061: aload_1
    //   1062: getfield 876	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1065: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1068: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1071: pop
    //   1072: aload 9
    //   1074: ldc_w 883
    //   1077: aload_1
    //   1078: getfield 886	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1081: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1084: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1087: pop
    //   1088: aload 9
    //   1090: ldc_w 888
    //   1093: aload_1
    //   1094: getfield 891	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1097: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1100: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1103: pop
    //   1104: aload 9
    //   1106: ldc_w 893
    //   1109: aload_1
    //   1110: getfield 896	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1113: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1116: invokevirtual 881	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1119: pop
    //   1120: aload_1
    //   1121: getfield 900	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1124: invokevirtual 903	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1127: astore 10
    //   1129: new 102	java/util/ArrayList
    //   1132: dup
    //   1133: invokespecial 103	java/util/ArrayList:<init>	()V
    //   1136: astore 11
    //   1138: aload 10
    //   1140: ifnull +21 -> 1161
    //   1143: aload 10
    //   1145: invokeinterface 572 1 0
    //   1150: ifle +11 -> 1161
    //   1153: aload 11
    //   1155: aload 10
    //   1157: invokevirtual 907	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1160: pop
    //   1161: aload 9
    //   1163: ldc_w 909
    //   1166: aload 11
    //   1168: invokevirtual 913	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1171: pop
    //   1172: aload_0
    //   1173: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1176: aload 9
    //   1178: invokevirtual 917	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   1181: aload_0
    //   1182: sipush 8007
    //   1185: iconst_1
    //   1186: bipush 6
    //   1188: anewarray 919	java/lang/Object
    //   1191: dup
    //   1192: iconst_0
    //   1193: aload_1
    //   1194: getfield 863	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1197: invokevirtual 867	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1200: invokestatic 924	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1203: aastore
    //   1204: dup
    //   1205: iconst_1
    //   1206: aload_1
    //   1207: getfield 876	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1210: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1213: aastore
    //   1214: dup
    //   1215: iconst_2
    //   1216: aload_1
    //   1217: getfield 886	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1220: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1223: aastore
    //   1224: dup
    //   1225: iconst_3
    //   1226: aload_1
    //   1227: getfield 891	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1230: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1233: aastore
    //   1234: dup
    //   1235: iconst_4
    //   1236: aload_1
    //   1237: getfield 896	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1240: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1243: aastore
    //   1244: dup
    //   1245: iconst_5
    //   1246: aload 11
    //   1248: aastore
    //   1249: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1252: goto -989 -> 263
    //   1255: astore_1
    //   1256: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1259: ifeq +13 -> 1272
    //   1262: ldc_w 849
    //   1265: iconst_2
    //   1266: ldc_w 929
    //   1269: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1272: aload_0
    //   1273: sipush 8007
    //   1276: iconst_0
    //   1277: iconst_2
    //   1278: anewarray 919	java/lang/Object
    //   1281: dup
    //   1282: iconst_0
    //   1283: iconst_1
    //   1284: invokestatic 924	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_1
    //   1290: ldc 131
    //   1292: aastore
    //   1293: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1296: goto -1033 -> 263
    //   1299: aload 13
    //   1301: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1304: ldc2_w 930
    //   1307: lcmp
    //   1308: ifne +328 -> 1636
    //   1311: aload 13
    //   1313: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1316: ifnull +320 -> 1636
    //   1319: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1322: ifeq +13 -> 1335
    //   1325: ldc_w 849
    //   1328: iconst_2
    //   1329: ldc_w 933
    //   1332: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1335: new 935	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   1338: dup
    //   1339: invokespecial 936	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   1342: pop
    //   1343: aconst_null
    //   1344: astore 9
    //   1346: aconst_null
    //   1347: astore 10
    //   1349: aconst_null
    //   1350: astore 11
    //   1352: aconst_null
    //   1353: astore 12
    //   1355: new 935	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   1358: dup
    //   1359: invokespecial 936	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   1362: astore 14
    //   1364: aload 14
    //   1366: aload 13
    //   1368: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1371: invokevirtual 937	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1374: pop
    //   1375: aload 14
    //   1377: getfield 940	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1380: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1383: ifeq +26 -> 1409
    //   1386: new 100	java/lang/String
    //   1389: dup
    //   1390: aload 14
    //   1392: getfield 940	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1395: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1398: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1401: ldc_w 368
    //   1404: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1407: astore 9
    //   1409: aload 14
    //   1411: getfield 945	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1414: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1417: ifeq +26 -> 1443
    //   1420: new 100	java/lang/String
    //   1423: dup
    //   1424: aload 14
    //   1426: getfield 945	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1429: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1432: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1435: ldc_w 368
    //   1438: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1441: astore 10
    //   1443: aload 14
    //   1445: getfield 948	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1448: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1451: ifeq +26 -> 1477
    //   1454: new 100	java/lang/String
    //   1457: dup
    //   1458: aload 14
    //   1460: getfield 948	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1463: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1466: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1469: ldc_w 368
    //   1472: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   1475: astore 11
    //   1477: aload 14
    //   1479: getfield 951	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1482: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1485: ifeq +16 -> 1501
    //   1488: aload 14
    //   1490: getfield 951	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1493: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1496: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1499: astore 12
    //   1501: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1504: ifeq +53 -> 1557
    //   1507: ldc_w 849
    //   1510: iconst_2
    //   1511: new 74	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 953
    //   1521: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload 9
    //   1526: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1529: ldc_w 955
    //   1532: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: aload 10
    //   1537: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1540: ldc_w 957
    //   1543: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: aload 11
    //   1548: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1557: invokestatic 962	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipmentLockImpl;
    //   1560: aload_0
    //   1561: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1564: aload 9
    //   1566: aload 10
    //   1568: aload 11
    //   1570: aload 12
    //   1572: invokevirtual 965	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   1575: aload_1
    //   1576: getfield 164	OnlinePushPack/MsgInfo:lFromUin	J
    //   1579: lstore_2
    //   1580: aload_1
    //   1581: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   1584: istore 4
    //   1586: aload_1
    //   1587: getfield 236	OnlinePushPack/MsgInfo:lMsgUid	J
    //   1590: lstore 6
    //   1592: aload_1
    //   1593: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   1596: istore 5
    //   1598: aload_0
    //   1599: getfield 523	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   1602: lload_2
    //   1603: iload 4
    //   1605: lload 6
    //   1607: iload 5
    //   1609: invokestatic 970	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   1612: goto -1349 -> 263
    //   1615: astore 9
    //   1617: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1620: ifeq -45 -> 1575
    //   1623: ldc_w 849
    //   1626: iconst_2
    //   1627: ldc_w 972
    //   1630: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1633: goto -58 -> 1575
    //   1636: aload 13
    //   1638: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1641: ldc2_w 973
    //   1644: lcmp
    //   1645: ifne +34 -> 1679
    //   1648: aload 13
    //   1650: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1653: ifnull +26 -> 1679
    //   1656: aload_0
    //   1657: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1660: bipush 24
    //   1662: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1665: checkcast 976	com/tencent/mobileqq/app/SafeCenterPushHandler
    //   1668: aload 13
    //   1670: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1673: invokevirtual 977	com/tencent/mobileqq/app/SafeCenterPushHandler:a	([B)V
    //   1676: goto -1413 -> 263
    //   1679: aload 13
    //   1681: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1684: ldc2_w 978
    //   1687: lcmp
    //   1688: ifne +222 -> 1910
    //   1691: aload 13
    //   1693: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1696: ifnull +214 -> 1910
    //   1699: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1702: ifeq +13 -> 1715
    //   1705: ldc_w 981
    //   1708: iconst_2
    //   1709: ldc_w 983
    //   1712: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1715: aload_0
    //   1716: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1719: iconst_4
    //   1720: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1723: checkcast 835	com/tencent/mobileqq/app/ConfigHandler
    //   1726: astore_1
    //   1727: aload_1
    //   1728: ifnull -1465 -> 263
    //   1731: new 985	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   1734: dup
    //   1735: invokespecial 986	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   1738: astore 9
    //   1740: aload 9
    //   1742: aload 13
    //   1744: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1747: invokevirtual 987	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1750: pop
    //   1751: aload 9
    //   1753: getfield 991	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   1756: invokevirtual 994	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   1759: istore 4
    //   1761: aload 9
    //   1763: getfield 997	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   1766: invokevirtual 569	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   1769: astore 11
    //   1771: new 102	java/util/ArrayList
    //   1774: dup
    //   1775: invokespecial 103	java/util/ArrayList:<init>	()V
    //   1778: astore 10
    //   1780: aload 11
    //   1782: ifnull +87 -> 1869
    //   1785: aload 11
    //   1787: invokeinterface 572 1 0
    //   1792: ifle +77 -> 1869
    //   1795: aload 11
    //   1797: invokeinterface 585 1 0
    //   1802: astore 11
    //   1804: aload 11
    //   1806: invokeinterface 153 1 0
    //   1811: ifeq +58 -> 1869
    //   1814: aload 11
    //   1816: invokeinterface 157 1 0
    //   1821: checkcast 999	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   1824: astore 12
    //   1826: new 1001	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   1829: dup
    //   1830: invokespecial 1002	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   1833: astore 13
    //   1835: aload 13
    //   1837: aload 12
    //   1839: getfield 1005	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1842: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1845: putfield 1008	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   1848: aload 10
    //   1850: aload 13
    //   1852: invokevirtual 209	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1855: pop
    //   1856: goto -52 -> 1804
    //   1859: astore 10
    //   1861: aload 10
    //   1863: invokevirtual 1009	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1866: goto -115 -> 1751
    //   1869: aload 9
    //   1871: getfield 1012	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1874: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1877: lstore_2
    //   1878: iload 4
    //   1880: iconst_1
    //   1881: if_icmpne +21 -> 1902
    //   1884: iconst_0
    //   1885: istore 4
    //   1887: aload_1
    //   1888: lload_2
    //   1889: invokestatic 212	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1892: iload 4
    //   1894: aload 10
    //   1896: invokevirtual 1015	com/tencent/mobileqq/app/ConfigHandler:a	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   1899: goto -1636 -> 263
    //   1902: sipush 3000
    //   1905: istore 4
    //   1907: goto -20 -> 1887
    //   1910: aload 13
    //   1912: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1915: ldc2_w 1016
    //   1918: lcmp
    //   1919: ifne +22 -> 1941
    //   1922: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1925: ifeq -1662 -> 263
    //   1928: ldc_w 1019
    //   1931: iconst_2
    //   1932: ldc_w 1021
    //   1935: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1938: goto -1675 -> 263
    //   1941: aload 13
    //   1943: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1946: ldc2_w 1022
    //   1949: lcmp
    //   1950: ifne +161 -> 2111
    //   1953: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1956: ifeq +44 -> 2000
    //   1959: new 74	java/lang/StringBuilder
    //   1962: dup
    //   1963: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   1966: ldc_w 1025
    //   1969: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1972: astore_1
    //   1973: aload 13
    //   1975: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1978: ifnull +85 -> 2063
    //   1981: iconst_1
    //   1982: istore 8
    //   1984: ldc_w 1027
    //   1987: iconst_2
    //   1988: aload_1
    //   1989: iload 8
    //   1991: invokevirtual 806	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1994: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1997: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2000: new 1029	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   2003: dup
    //   2004: invokespecial 1030	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   2007: astore_1
    //   2008: aload_1
    //   2009: aload 13
    //   2011: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2014: invokevirtual 1031	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2017: pop
    //   2018: aload_1
    //   2019: getfield 1034	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2022: invokevirtual 1035	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2025: ifeq -1762 -> 263
    //   2028: aload_1
    //   2029: getfield 1034	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2032: invokevirtual 569	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2035: astore_1
    //   2036: aload_0
    //   2037: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2040: iconst_3
    //   2041: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2044: checkcast 1037	com/tencent/mobileqq/app/LBSHandler
    //   2047: astore 9
    //   2049: aload 9
    //   2051: ifnull -1788 -> 263
    //   2054: aload 9
    //   2056: aload_1
    //   2057: invokevirtual 1040	com/tencent/mobileqq/app/LBSHandler:b	(Ljava/util/List;)V
    //   2060: goto -1797 -> 263
    //   2063: iconst_0
    //   2064: istore 8
    //   2066: goto -82 -> 1984
    //   2069: astore 9
    //   2071: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2074: ifeq -56 -> 2018
    //   2077: ldc_w 1027
    //   2080: iconst_2
    //   2081: new 74	java/lang/StringBuilder
    //   2084: dup
    //   2085: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   2088: ldc_w 1042
    //   2091: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: aload 9
    //   2096: invokevirtual 1043	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   2099: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2105: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2108: goto -90 -> 2018
    //   2111: aload 13
    //   2113: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2116: ldc2_w 1044
    //   2119: lcmp
    //   2120: ifne +28 -> 2148
    //   2123: aload_0
    //   2124: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2127: bipush 21
    //   2129: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2132: checkcast 1047	com/tencent/mobileqq/app/RecommendTroopManagerImp
    //   2135: astore_1
    //   2136: aload_1
    //   2137: ifnull -1874 -> 263
    //   2140: aload_1
    //   2141: invokevirtual 1049	com/tencent/mobileqq/app/RecommendTroopManagerImp:a	()Z
    //   2144: pop
    //   2145: goto -1882 -> 263
    //   2148: aload 13
    //   2150: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2153: ldc2_w 1050
    //   2156: lcmp
    //   2157: ifne +11 -> 2168
    //   2160: aload 13
    //   2162: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2165: ifnonnull -1902 -> 263
    //   2168: aload 13
    //   2170: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2173: ldc2_w 1052
    //   2176: lcmp
    //   2177: ifne +38 -> 2215
    //   2180: aload 13
    //   2182: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2185: ifnull +30 -> 2215
    //   2188: invokestatic 1056	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2191: ifeq +13 -> 2204
    //   2194: getstatic 1060	com/tencent/biz/common/offline/OfflineExpire:a	Ljava/lang/String;
    //   2197: iconst_4
    //   2198: ldc_w 1062
    //   2201: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2204: aload 13
    //   2206: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2209: invokestatic 1063	com/tencent/biz/common/offline/OfflineExpire:a	([B)V
    //   2212: goto -1949 -> 263
    //   2215: aload 13
    //   2217: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2220: ldc2_w 1064
    //   2223: lcmp
    //   2224: ifne +42 -> 2266
    //   2227: aload 13
    //   2229: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2232: ifnull +34 -> 2266
    //   2235: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2238: ifeq +13 -> 2251
    //   2241: ldc_w 1067
    //   2244: iconst_2
    //   2245: ldc_w 1069
    //   2248: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2251: aload_0
    //   2252: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2255: aload 13
    //   2257: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2260: invokestatic 1072	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   2263: goto -2000 -> 263
    //   2266: aload 13
    //   2268: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2271: ldc2_w 1073
    //   2274: lcmp
    //   2275: ifne +82 -> 2357
    //   2278: aload 13
    //   2280: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2283: ifnull +74 -> 2357
    //   2286: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2289: ifeq +13 -> 2302
    //   2292: ldc_w 1076
    //   2295: iconst_2
    //   2296: ldc_w 1078
    //   2299: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2302: aload_0
    //   2303: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2306: aload 13
    //   2308: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2311: invokestatic 1079	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   2314: aload_1
    //   2315: getfield 164	OnlinePushPack/MsgInfo:lFromUin	J
    //   2318: lstore_2
    //   2319: aload_1
    //   2320: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2323: istore 4
    //   2325: aload_1
    //   2326: getfield 236	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2329: lstore 6
    //   2331: aload_1
    //   2332: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   2335: istore 5
    //   2337: aload_0
    //   2338: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2341: invokevirtual 328	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   2344: lload_2
    //   2345: iload 4
    //   2347: lload 6
    //   2349: iload 5
    //   2351: invokestatic 970	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2354: goto -2091 -> 263
    //   2357: aload 13
    //   2359: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2362: ldc2_w 1080
    //   2365: lcmp
    //   2366: ifne +434 -> 2800
    //   2369: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2372: ifeq +13 -> 2385
    //   2375: ldc_w 1083
    //   2378: iconst_2
    //   2379: ldc_w 1078
    //   2382: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2385: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2388: ifeq +13 -> 2401
    //   2391: ldc_w 1085
    //   2394: iconst_2
    //   2395: ldc_w 1087
    //   2398: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2401: new 1089	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   2404: dup
    //   2405: invokespecial 1090	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   2408: astore 12
    //   2410: aload 12
    //   2412: aload 13
    //   2414: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2417: invokevirtual 1091	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2420: pop
    //   2421: aload 12
    //   2423: getfield 1094	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2426: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2429: lstore_2
    //   2430: aload_0
    //   2431: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2434: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   2437: astore 9
    //   2439: invokestatic 1099	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2442: lload_2
    //   2443: invokestatic 1101	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2446: aconst_null
    //   2447: ldc_w 1103
    //   2450: iconst_0
    //   2451: invokestatic 1109	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   2454: ifne +327 -> 2781
    //   2457: lload_2
    //   2458: invokestatic 1101	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2461: aload 9
    //   2463: invokevirtual 626	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2466: istore 8
    //   2468: iload 8
    //   2470: ifeq +311 -> 2781
    //   2473: aconst_null
    //   2474: astore 9
    //   2476: aconst_null
    //   2477: astore 10
    //   2479: aconst_null
    //   2480: astore 14
    //   2482: aload 12
    //   2484: getfield 1112	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2487: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2490: ifeq +1339 -> 3829
    //   2493: new 100	java/lang/String
    //   2496: dup
    //   2497: aload 12
    //   2499: getfield 1112	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2502: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2505: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2508: ldc_w 368
    //   2511: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2514: astore 11
    //   2516: aload 11
    //   2518: astore 9
    //   2520: aload 12
    //   2522: getfield 1115	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2525: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2528: ifeq +1295 -> 3823
    //   2531: new 100	java/lang/String
    //   2534: dup
    //   2535: aload 12
    //   2537: getfield 1115	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2540: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2543: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2546: ldc_w 368
    //   2549: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2552: astore 11
    //   2554: aload 11
    //   2556: astore 10
    //   2558: aload 12
    //   2560: getfield 1118	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2563: invokevirtual 941	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2566: ifeq +1251 -> 3817
    //   2569: new 100	java/lang/String
    //   2572: dup
    //   2573: aload 12
    //   2575: getfield 1118	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2578: invokevirtual 608	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2581: invokevirtual 942	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2584: ldc_w 368
    //   2587: invokespecial 371	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2590: astore 11
    //   2592: aload 11
    //   2594: astore 12
    //   2596: aload 9
    //   2598: astore 11
    //   2600: aload 10
    //   2602: astore 13
    //   2604: invokestatic 1099	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   2607: lload_2
    //   2608: invokestatic 1101	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2611: aload 11
    //   2613: aload 12
    //   2615: aload 13
    //   2617: invokevirtual 1121	com/tencent/common/app/BaseApplicationImpl:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2620: aload_0
    //   2621: sipush 8013
    //   2624: iconst_1
    //   2625: iconst_4
    //   2626: anewarray 919	java/lang/Object
    //   2629: dup
    //   2630: iconst_0
    //   2631: lload_2
    //   2632: invokestatic 1101	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2635: aastore
    //   2636: dup
    //   2637: iconst_1
    //   2638: aload 11
    //   2640: aastore
    //   2641: dup
    //   2642: iconst_2
    //   2643: aload 12
    //   2645: aastore
    //   2646: dup
    //   2647: iconst_3
    //   2648: aload 13
    //   2650: aastore
    //   2651: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2654: aload_1
    //   2655: getfield 164	OnlinePushPack/MsgInfo:lFromUin	J
    //   2658: lstore_2
    //   2659: aload_1
    //   2660: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2663: istore 4
    //   2665: aload_1
    //   2666: getfield 236	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2669: lstore 6
    //   2671: aload_1
    //   2672: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   2675: istore 5
    //   2677: aload_0
    //   2678: getfield 523	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2681: lload_2
    //   2682: iload 4
    //   2684: lload 6
    //   2686: iload 5
    //   2688: invokestatic 970	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2691: goto -2428 -> 263
    //   2694: astore 11
    //   2696: aload 10
    //   2698: astore 13
    //   2700: aload 14
    //   2702: astore 12
    //   2704: aload 9
    //   2706: astore 11
    //   2708: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2711: ifeq -107 -> 2604
    //   2714: ldc_w 1083
    //   2717: iconst_2
    //   2718: ldc_w 1123
    //   2721: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2724: aload 10
    //   2726: astore 13
    //   2728: aload 14
    //   2730: astore 12
    //   2732: aload 9
    //   2734: astore 11
    //   2736: goto -132 -> 2604
    //   2739: astore 9
    //   2741: aload 9
    //   2743: invokevirtual 1009	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2746: aload_0
    //   2747: sipush 8013
    //   2750: iconst_0
    //   2751: iconst_4
    //   2752: anewarray 919	java/lang/Object
    //   2755: dup
    //   2756: iconst_0
    //   2757: ldc 131
    //   2759: aastore
    //   2760: dup
    //   2761: iconst_1
    //   2762: ldc 131
    //   2764: aastore
    //   2765: dup
    //   2766: iconst_2
    //   2767: ldc 131
    //   2769: aastore
    //   2770: dup
    //   2771: iconst_3
    //   2772: ldc 131
    //   2774: aastore
    //   2775: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2778: goto -124 -> 2654
    //   2781: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2784: ifeq -130 -> 2654
    //   2787: ldc_w 1083
    //   2790: iconst_2
    //   2791: ldc_w 1125
    //   2794: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2797: goto -143 -> 2654
    //   2800: ldc2_w 1126
    //   2803: aload 13
    //   2805: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2808: lcmp
    //   2809: ifne +29 -> 2838
    //   2812: aload_0
    //   2813: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2816: aload 13
    //   2818: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2821: invokestatic 1132	com/tencent/biz/TroopRedpoint/TroopRedTouchHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Z
    //   2824: ifeq -2561 -> 263
    //   2827: aload_0
    //   2828: bipush 105
    //   2830: iconst_1
    //   2831: aconst_null
    //   2832: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2835: goto -2572 -> 263
    //   2838: aload 13
    //   2840: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2843: ldc2_w 1133
    //   2846: lcmp
    //   2847: ifne +428 -> 3275
    //   2850: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2853: ifeq +13 -> 2866
    //   2856: ldc_w 1136
    //   2859: iconst_2
    //   2860: ldc_w 1078
    //   2863: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2866: new 1138	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   2869: dup
    //   2870: invokespecial 1139	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   2873: astore 9
    //   2875: aload 9
    //   2877: aload 13
    //   2879: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2882: invokevirtual 1140	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2885: pop
    //   2886: aload 9
    //   2888: getfield 1143	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2891: invokevirtual 569	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2894: iconst_0
    //   2895: invokeinterface 1146 2 0
    //   2900: checkcast 1148	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   2903: astore 9
    //   2905: iconst_m1
    //   2906: istore 4
    //   2908: aload 9
    //   2910: getfield 1151	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2913: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2916: ifeq +13 -> 2929
    //   2919: aload 9
    //   2921: getfield 1151	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2924: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2927: istore 4
    //   2929: iload 4
    //   2931: sipush 2000
    //   2934: if_icmpne +116 -> 3050
    //   2937: aload 9
    //   2939: getfield 1155	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_fanpanzi_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify;
    //   2942: invokevirtual 1158	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify:has	()Z
    //   2945: ifeq +105 -> 3050
    //   2948: aload_0
    //   2949: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2952: iconst_0
    //   2953: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2956: checkcast 330	com/tencent/mobileqq/app/MessageHandler
    //   2959: aload 9
    //   2961: getfield 1155	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_fanpanzi_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify;
    //   2964: invokevirtual 1161	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2967: checkcast 1157	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify
    //   2970: invokevirtual 1164	com/tencent/mobileqq/app/MessageHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$FanpaiziNotify;)V
    //   2973: aload_1
    //   2974: getfield 164	OnlinePushPack/MsgInfo:lFromUin	J
    //   2977: lstore_2
    //   2978: aload_1
    //   2979: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2982: istore 4
    //   2984: aload_1
    //   2985: getfield 236	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2988: lstore 6
    //   2990: aload_1
    //   2991: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   2994: istore 5
    //   2996: aload_0
    //   2997: getfield 523	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3000: lload_2
    //   3001: iload 4
    //   3003: lload 6
    //   3005: iload 5
    //   3007: invokestatic 970	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3010: goto -2747 -> 263
    //   3013: astore_1
    //   3014: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3017: ifeq -2754 -> 263
    //   3020: ldc_w 1136
    //   3023: iconst_2
    //   3024: new 74	java/lang/StringBuilder
    //   3027: dup
    //   3028: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3031: ldc_w 1166
    //   3034: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3037: aload_1
    //   3038: invokevirtual 1169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3041: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3044: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3047: goto -2784 -> 263
    //   3050: iload 4
    //   3052: sipush 2001
    //   3055: if_icmpne -82 -> 2973
    //   3058: aload 9
    //   3060: getfield 1173	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3063: invokevirtual 1176	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   3066: ifeq -93 -> 2973
    //   3069: aload 9
    //   3071: getfield 1173	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3074: invokevirtual 1177	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3077: checkcast 1175	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
    //   3080: astore 10
    //   3082: ldc 131
    //   3084: astore 9
    //   3086: lconst_0
    //   3087: lstore_2
    //   3088: iconst_0
    //   3089: istore 5
    //   3091: iconst_0
    //   3092: istore 4
    //   3094: aload 10
    //   3096: getfield 1180	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3099: invokevirtual 1181	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3102: ifeq +13 -> 3115
    //   3105: aload 10
    //   3107: getfield 1180	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3110: invokevirtual 878	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3113: astore 9
    //   3115: aload 10
    //   3117: getfield 1184	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3120: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3123: ifeq +13 -> 3136
    //   3126: aload 10
    //   3128: getfield 1184	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3131: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3134: istore 4
    //   3136: aload 10
    //   3138: getfield 1187	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3141: invokevirtual 790	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   3144: ifeq +12 -> 3156
    //   3147: aload 10
    //   3149: getfield 1187	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3152: invokevirtual 560	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3155: lstore_2
    //   3156: aload 10
    //   3158: getfield 1190	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3161: invokevirtual 796	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3164: ifeq +13 -> 3177
    //   3167: aload 10
    //   3169: getfield 1190	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3172: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3175: istore 5
    //   3177: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3180: ifeq +63 -> 3243
    //   3183: ldc_w 1136
    //   3186: iconst_2
    //   3187: new 74	java/lang/StringBuilder
    //   3190: dup
    //   3191: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3194: ldc_w 1192
    //   3197: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3200: aload 9
    //   3202: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: ldc_w 1194
    //   3208: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3211: iload 5
    //   3213: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3216: ldc_w 1196
    //   3219: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3222: iload 4
    //   3224: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3227: ldc_w 1198
    //   3230: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3233: lload_2
    //   3234: invokevirtual 222	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3237: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3240: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3243: aload_0
    //   3244: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3247: bipush 67
    //   3249: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3252: checkcast 1200	com/tencent/mobileqq/dating/DatingManager
    //   3255: astore 9
    //   3257: aload 9
    //   3259: ifnull -286 -> 2973
    //   3262: aload 9
    //   3264: invokevirtual 1203	com/tencent/mobileqq/dating/DatingManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   3267: aload 10
    //   3269: invokevirtual 1208	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   3272: goto -299 -> 2973
    //   3275: aload 13
    //   3277: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3280: ldc2_w 1209
    //   3283: lcmp
    //   3284: ifne +88 -> 3372
    //   3287: new 1212	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   3290: dup
    //   3291: invokespecial 1213	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   3294: astore_1
    //   3295: aload_1
    //   3296: aload 13
    //   3298: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3301: invokevirtual 1214	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3304: pop
    //   3305: aload_1
    //   3306: getfield 1217	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3309: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3312: sipush 1001
    //   3315: if_icmpne -3052 -> 263
    //   3318: aload_0
    //   3319: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3322: bipush 74
    //   3324: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3327: checkcast 1219	com/tencent/mobileqq/portal/PortalManager
    //   3330: astore 9
    //   3332: aload 9
    //   3334: ifnull -3071 -> 263
    //   3337: aload 9
    //   3339: aload_1
    //   3340: invokevirtual 1222	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   3343: goto -3080 -> 263
    //   3346: astore_1
    //   3347: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3350: ifeq +13 -> 3363
    //   3353: ldc_w 1224
    //   3356: iconst_2
    //   3357: ldc 131
    //   3359: aload_1
    //   3360: invokestatic 1226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3363: new 1228	java/lang/RuntimeException
    //   3366: dup
    //   3367: aload_1
    //   3368: invokespecial 1231	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   3371: athrow
    //   3372: aload 13
    //   3374: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3377: ldc2_w 1232
    //   3380: lcmp
    //   3381: ifne +37 -> 3418
    //   3384: aload_0
    //   3385: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3388: bipush 35
    //   3390: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3393: checkcast 1235	com/tencent/mobileqq/redtouch/RedTouchManager
    //   3396: aload 13
    //   3398: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3401: invokevirtual 1238	com/tencent/mobileqq/redtouch/RedTouchManager:a	([B)Z
    //   3404: ifeq -3141 -> 263
    //   3407: aload_0
    //   3408: bipush 113
    //   3410: iconst_1
    //   3411: aconst_null
    //   3412: invokevirtual 927	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3415: goto -3152 -> 263
    //   3418: aload 13
    //   3420: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3423: ldc2_w 1239
    //   3426: lcmp
    //   3427: ifne +129 -> 3556
    //   3430: aload_0
    //   3431: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3434: bipush 80
    //   3436: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3439: checkcast 1242	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   3442: aload_1
    //   3443: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3446: invokevirtual 1244	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(I)Z
    //   3449: ifeq +78 -> 3527
    //   3452: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3455: ifeq +32 -> 3487
    //   3458: ldc 57
    //   3460: iconst_2
    //   3461: new 74	java/lang/StringBuilder
    //   3464: dup
    //   3465: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3468: ldc_w 1246
    //   3471: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3474: aload_1
    //   3475: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3478: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3481: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3484: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3487: aload_1
    //   3488: getfield 164	OnlinePushPack/MsgInfo:lFromUin	J
    //   3491: lstore_2
    //   3492: aload_1
    //   3493: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3496: istore 4
    //   3498: aload_1
    //   3499: getfield 236	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3502: lstore 6
    //   3504: aload_1
    //   3505: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   3508: istore 5
    //   3510: aload_0
    //   3511: getfield 523	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3514: lload_2
    //   3515: iload 4
    //   3517: lload 6
    //   3519: iload 5
    //   3521: invokestatic 970	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3524: goto -3261 -> 263
    //   3527: aload_0
    //   3528: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3531: aload 13
    //   3533: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3536: invokestatic 1247	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Z
    //   3539: ifeq -52 -> 3487
    //   3542: aload_0
    //   3543: ldc_w 1249
    //   3546: iconst_1
    //   3547: iconst_1
    //   3548: iconst_1
    //   3549: iconst_0
    //   3550: invokevirtual 529	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ljava/lang/String;ZIZZ)V
    //   3553: goto -66 -> 3487
    //   3556: aload 13
    //   3558: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3561: ldc2_w 1250
    //   3564: lcmp
    //   3565: ifne +26 -> 3591
    //   3568: aload_0
    //   3569: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3572: bipush 49
    //   3574: invokevirtual 42	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   3577: checkcast 1253	com/tencent/mobileqq/app/QPayHandler
    //   3580: aload 13
    //   3582: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3585: invokevirtual 1254	com/tencent/mobileqq/app/QPayHandler:a	([B)V
    //   3588: goto -3325 -> 263
    //   3591: aload 13
    //   3593: getfield 686	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3596: ldc2_w 1255
    //   3599: lcmp
    //   3600: ifne -3337 -> 263
    //   3603: invokestatic 1056	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3606: ifeq +70 -> 3676
    //   3609: new 74	java/lang/StringBuilder
    //   3612: dup
    //   3613: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3616: getstatic 1260	cooperation/qzone/util/QZoneLogTags:b	Ljava/lang/String;
    //   3619: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3622: getstatic 1262	cooperation/qzone/util/QZoneLogTags:e	Ljava/lang/String;
    //   3625: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3628: ldc 57
    //   3630: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3636: iconst_4
    //   3637: new 74	java/lang/StringBuilder
    //   3640: dup
    //   3641: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3644: ldc_w 1264
    //   3647: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3650: aload_1
    //   3651: getfield 196	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3654: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3657: ldc_w 1266
    //   3660: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3663: aload_1
    //   3664: getfield 161	OnlinePushPack/MsgInfo:shMsgType	S
    //   3667: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3670: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3673: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3676: new 1268	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   3679: dup
    //   3680: invokespecial 1269	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   3683: astore_1
    //   3684: aload_1
    //   3685: aload 13
    //   3687: getfield 717	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3690: invokevirtual 1270	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3693: pop
    //   3694: aload_1
    //   3695: getfield 1273	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3698: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3701: pop
    //   3702: aload_1
    //   3703: getfield 1276	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3706: invokevirtual 763	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3709: istore 4
    //   3711: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3714: ifeq +55 -> 3769
    //   3717: new 74	java/lang/StringBuilder
    //   3720: dup
    //   3721: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3724: getstatic 1260	cooperation/qzone/util/QZoneLogTags:b	Ljava/lang/String;
    //   3727: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3730: getstatic 1262	cooperation/qzone/util/QZoneLogTags:e	Ljava/lang/String;
    //   3733: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3736: ldc 57
    //   3738: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3741: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3744: iconst_2
    //   3745: new 74	java/lang/StringBuilder
    //   3748: dup
    //   3749: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   3752: ldc_w 1278
    //   3755: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3758: iload 4
    //   3760: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3763: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3766: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3769: aload_0
    //   3770: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3773: bipush 9
    //   3775: invokevirtual 187	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3778: checkcast 1280	com/tencent/mobileqq/servlet/QZoneManagerImp
    //   3781: iconst_5
    //   3782: iload 4
    //   3784: aload_0
    //   3785: getfield 37	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3788: invokevirtual 1283	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   3791: ldc 131
    //   3793: invokevirtual 1286	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IIJLjava/lang/String;)V
    //   3796: goto -3533 -> 263
    //   3799: astore_1
    //   3800: aload_1
    //   3801: invokevirtual 1009	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3804: goto -3541 -> 263
    //   3807: astore 11
    //   3809: goto -1113 -> 2696
    //   3812: astore 11
    //   3814: goto -1118 -> 2696
    //   3817: aconst_null
    //   3818: astore 11
    //   3820: goto -1228 -> 2592
    //   3823: aconst_null
    //   3824: astore 10
    //   3826: goto -1268 -> 2558
    //   3829: aconst_null
    //   3830: astore 9
    //   3832: goto -1312 -> 2520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3835	0	this	OnLinePushMessageProcessor
    //   0	3835	1	paramMsgInfo	MsgInfo
    //   0	3835	2	paramLong	long
    //   445	3338	4	i	int
    //   1596	1924	5	j	int
    //   1590	1928	6	l	long
    //   195	2274	8	bool	boolean
    //   110	1455	9	localObject1	Object
    //   1615	1	9	localException1	Exception
    //   1738	317	9	localObject2	Object
    //   2069	26	9	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2437	296	9	localObject3	Object
    //   2739	3	9	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2873	958	9	localObject4	Object
    //   173	1676	10	localObject5	Object
    //   1859	36	10	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   2477	1348	10	localObject6	Object
    //   729	1910	11	localObject7	Object
    //   2694	1	11	localException2	Exception
    //   2706	29	11	localObject8	Object
    //   3807	1	11	localException3	Exception
    //   3812	1	11	localException4	Exception
    //   3818	1	11	localObject9	Object
    //   1353	1378	12	localObject10	Object
    //   23	3663	13	localObject11	Object
    //   1362	1367	14	localMsgBody	SubMsgType0x51.MsgBody
    // Exception table:
    //   from	to	target	type
    //   421	480	483	java/lang/Exception
    //   515	531	813	java/lang/Exception
    //   531	595	813	java/lang/Exception
    //   595	632	813	java/lang/Exception
    //   632	665	813	java/lang/Exception
    //   665	771	813	java/lang/Exception
    //   771	810	813	java/lang/Exception
    //   1021	1138	1255	java/lang/Exception
    //   1143	1161	1255	java/lang/Exception
    //   1161	1252	1255	java/lang/Exception
    //   1355	1375	1615	java/lang/Exception
    //   1375	1409	1615	java/lang/Exception
    //   1409	1443	1615	java/lang/Exception
    //   1443	1477	1615	java/lang/Exception
    //   1477	1501	1615	java/lang/Exception
    //   1501	1557	1615	java/lang/Exception
    //   1557	1575	1615	java/lang/Exception
    //   1740	1751	1859	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2008	2018	2069	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2482	2516	2694	java/lang/Exception
    //   2385	2401	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2401	2468	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2482	2516	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2520	2554	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2558	2592	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2604	2654	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2708	2724	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2781	2797	2739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2866	2905	3013	java/lang/Exception
    //   2908	2929	3013	java/lang/Exception
    //   2937	2973	3013	java/lang/Exception
    //   2973	3010	3013	java/lang/Exception
    //   3058	3082	3013	java/lang/Exception
    //   3094	3115	3013	java/lang/Exception
    //   3115	3136	3013	java/lang/Exception
    //   3136	3156	3013	java/lang/Exception
    //   3156	3177	3013	java/lang/Exception
    //   3177	3243	3013	java/lang/Exception
    //   3243	3257	3013	java/lang/Exception
    //   3262	3272	3013	java/lang/Exception
    //   3295	3305	3346	java/lang/Throwable
    //   3676	3769	3799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3769	3796	3799	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2520	2554	3807	java/lang/Exception
    //   2558	2592	3812	java/lang/Exception
  }
  
  private hth b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    SubAccountManager localSubAccountManager;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        long l2;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
            }
            paramArrayOfByte = null;
          }
          if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uinflag_null");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
          i = paramArrayOfByte.uint32_flag.get();
          l1 = paramArrayOfByte.uint32_time.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          l2 = paramArrayOfByte.uint64_bind_uin.get();
          if ((l1 <= 0L) || (l2 <= 0L))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uin_error");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        paramArrayOfByte = new SubAccountBackProtocData();
        paramArrayOfByte.c = String.valueOf(l1);
        paramArrayOfByte.b = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (SubAccountControll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
        if (i == 1)
        {
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramArrayOfByte.c);
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.c);
          paramArrayOfByte.p = 1;
          ((SubAccountControll)localObject1).a(paramArrayOfByte.c, 1);
          a(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      paramArrayOfByte.a((String)localObject1);
      localSubAccountManager.a(paramArrayOfByte);
      Object localObject2 = paramArrayOfByte.a();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
          }
          i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 7000);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label782;
      }
    }
    localSubAccountManager.a((String)localObject1, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new htf(this, localSubAccountManager));
    for (;;)
    {
      paramArrayOfByte.p = 0;
      a(8004, true, paramArrayOfByte);
      return;
      label782:
      if (localSubAccountManager.a(String.valueOf(l1), 2))
      {
        i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b((String)localObject1, 7000, i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.W, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    long l = PkgTools.a(paramArrayOfByte, 0);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    HotChatInfo localHotChatInfo;
    if (i == 3)
    {
      i = paramArrayOfByte[10];
      paramArrayOfByte = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
      if (i != 3) {
        break label118;
      }
      localHotChatInfo = paramArrayOfByte.a(String.valueOf(l));
      if (localHotChatInfo != null)
      {
        paramArrayOfByte.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
        HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369513), true);
      }
    }
    label118:
    do
    {
      do
      {
        return;
      } while (i != 2);
      localHotChatInfo = paramArrayOfByte.a(String.valueOf(l));
    } while (localHotChatInfo == null);
    paramArrayOfByte.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131369520), false);
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public List a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1105;
      }
    }
    int i;
    label344:
    Object localObject1;
    Object localObject2;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject1 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (StringUtil.d((String)localObject1)))
          {
            localObject2 = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
            localObject2 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            localObject1 = String.valueOf(localObject1);
            if (!((FriendListHandler)localObject2).a((String)localObject1, 0, j, null, false, false)) {
              ((FriendListHandler)localObject2).a((String)localObject1);
            }
          }
        }
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label1049:
    label1085:
    label1105:
    for (int j = i;; j = 0)
    {
      if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
        if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get()), paramArrayOfByte.msg_group_msg_sync.uint64_msg_seq.get(), true);
          i = 1;
          label603:
          if (b(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            localObject2 = SystemMsgUtils.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (StringUtil.d((String)localObject1)))
            {
              FriendsManagerImp localFriendsManagerImp = (FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8);
              if (localFriendsManagerImp.a((String)localObject1) == null)
              {
                TroopInfo localTroopInfo = new TroopInfo();
                localTroopInfo.troopuin = ((String)localObject1);
                localTroopInfo.troopcode = ((String)localObject2);
                localFriendsManagerImp.a(localTroopInfo);
                ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(localTroopInfo.troopuin, (byte)1, localTroopInfo.dwTimeStamp, 0);
              }
              a(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
          }
        }
      }
      for (int k = i;; k = 0)
      {
        if ((j != 0) || (k != 0))
        {
          if ((j == 0) || (k == 0)) {
            break label1049;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
        }
        for (;;)
        {
          if ((!paramArrayOfByte.msg_clean_count_msg.has()) || (paramArrayOfByte.msg_clean_count_msg.get() == null)) {
            break label1085;
          }
          if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
          {
            SystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(AppConstants.ap, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
            FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
            if (localObject1 != null) {
              ((Handler)localObject1).sendEmptyMessage(1009);
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
          return;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          } else if (k != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3);
          }
        }
        break;
        i = 0;
        break label603;
      }
      i = 0;
      break label344;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), localArrayList);
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg)
  {
    byte[] arrayOfByte = null;
    if (QLog.isColorLevel()) {
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv msg0x210.Submsgtype0x51");
    }
    if (paramMsgType0x210.sub_msg_type.get() != 81) {
      if (QLog.isColorLevel()) {
        QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush submsgtype != 0x51");
      }
    }
    do
    {
      do
      {
        return;
        if (paramMsgType0x210.msg_content != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush msg_content is null");
      return;
      paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
      if (paramMsgType0x210 != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush decode ox210Stream is null");
    return;
    new SubMsgType0x51.MsgBody();
    for (;;)
    {
      try
      {
        SubMsgType0x51.MsgBody localMsgBody = new SubMsgType0x51.MsgBody();
        localMsgBody.mergeFrom(paramMsgType0x210);
        if (!localMsgBody.bytes_qrsig_url.has()) {
          break label348;
        }
        paramMsgType0x210 = new String(localMsgBody.bytes_qrsig_url.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint1.has()) {
          break label343;
        }
        paramMsg = new String(localMsgBody.bytes_hint1.get().toByteArray(), "utf-8");
        if (!localMsgBody.bytes_hint2.has()) {
          break label338;
        }
        str = new String(localMsgBody.bytes_hint2.get().toByteArray(), "utf-8");
        if (localMsgBody.bytes_login_conf.has()) {
          arrayOfByte = localMsgBody.bytes_login_conf.get().toByteArray();
        }
        if (QLog.isColorLevel()) {
          QLog.d("DevLock", 2, "decodeDevlockQuickLoginPush recv devlock quicklogin push qrcode=" + paramMsgType0x210 + " maintip=" + paramMsg + " smalltip" + str);
        }
        EquipmentLockImpl.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgType0x210, paramMsg, str, arrayOfByte);
        return;
      }
      catch (Exception paramMsgType0x210) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DevLock", 2, "failed to parse msg0x210.Submsgtype0x51");
      return;
      label338:
      String str = null;
      continue;
      label343:
      paramMsg = null;
      continue;
      label348:
      paramMsgType0x210 = null;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    Object localObject1;
    FriendsManager localFriendsManager;
    TroopManager localTroopManager;
    PublicAccountDataManager localPublicAccountDataManager;
    Friends[] arrayOfFriends;
    int k;
    for (;;)
    {
      return;
      localObject1 = new SubMsgType0x27.MsgBody();
      try
      {
        paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte != null)
        {
          localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
          localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
          paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
          arrayOfFriends = new Friends[paramArrayOfByte.size()];
          Iterator localIterator = paramArrayOfByte.iterator();
          k = 0;
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label9400;
            }
            paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
            if ((!paramArrayOfByte.uint32_notify_type.has()) || (paramArrayOfByte.uint32_notify_type.get() != 1)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a no content，如何处理？");
            }
          }
          if (!paramArrayOfByte.uint32_op_type.has()) {
            break label340;
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
    }
    label340:
    Object localObject4;
    int m;
    label1030:
    label1119:
    Object localObject5;
    switch (paramArrayOfByte.uint32_op_type.get())
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          for (;;)
          {
            break;
            if (paramArrayOfByte.msg_add_group.has())
            {
              localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
              paramArrayOfByte = new Groups();
              if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
              }
              if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
              }
              if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
              }
              localFriendsManager.a(paramArrayOfByte);
              localObject1 = new AddGroupResp();
              ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
              ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
              ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
              ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
              paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(18, true, paramArrayOfByte);
              continue;
              if (paramArrayOfByte.msg_del_group.has())
              {
                localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                {
                  localObject4 = localFriendsManager.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                  }
                  paramArrayOfByte = new DelGroupResp();
                  paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                  paramArrayOfByte.dwSequence = ((Groups)localObject4).seqid;
                  paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                  localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                  ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                }
              }
            }
          }
        } while (!paramArrayOfByte.msg_mod_group_name.has());
        localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        if ((((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) && (((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()))
        {
          m = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          localObject4 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
          paramArrayOfByte = localFriendsManager.a(String.valueOf(m));
          if (paramArrayOfByte == null) {
            break label1030;
          }
        }
        for (paramArrayOfByte.group_name = ((String)localObject4);; paramArrayOfByte.group_name = ((String)localObject4))
        {
          localFriendsManager.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          m = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = m;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject4 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject4 != null)
      {
        paramArrayOfByte = new byte[((List)localObject4).size()];
        localObject1 = new byte[((List)localObject4).size()];
        localObject4 = ((List)localObject4).iterator();
        m = 0;
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (SubMsgType0x27.GroupSort)((Iterator)localObject4).next();
          if ((!((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.has())) {
            break label9423;
          }
          paramArrayOfByte[m] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get());
          localObject1[m] = ((byte)((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject5).uint32_sortid.get());
          }
          m += 1;
        }
      }
      break;
    }
    label1320:
    label4167:
    label5192:
    label9417:
    label9423:
    for (;;)
    {
      break label1119;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(22, true, null);
      localFriendsManager.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      long l1;
      int n;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
          if ((((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) && (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() > 0))
          {
            l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
            n = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
            if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() <= 0) {
              break label9417;
            }
          }
        }
      }
      for (m = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; m = 0)
      {
        localFriendsManager.a(l1 + "", n);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + n);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(9, true, new Object[] { l1 + "", Byte.valueOf((byte)n), Byte.valueOf((byte)m) });
        break label1320;
        break;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          l1 = ((Long)paramArrayOfByte.next()).longValue();
          localFriendsManager.d(l1 + "");
          localPublicAccountDataManager.a(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
          localObject4 = ((RecentUserProxy)localObject1).a(String.valueOf(l1), 0);
          if (localObject4 != null) {
            ((RecentUserProxy)localObject1).b((RecentUser)localObject4);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(15, true, Long.valueOf(l1));
        }
        paramArrayOfByte = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (paramArrayOfByte != null) {
          paramArrayOfByte.c();
        }
        break;
        Object localObject7;
        Object localObject8;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject5 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject7 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject5).next();
              m = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
              if (m == 13569)
              {
                localObject6 = localTroopManager.b(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_uin.get()).toString());
                m = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().size();
                if (m == 0)
                {
                  if (localTroopManager.c((String)localObject6)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21).a(18, true, new Object[] { localObject6, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (m >= 4)
                {
                  localObject7 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toByteArray();
                  localObject8 = new byte[m];
                  System.arraycopy(localObject7, 0, localObject8, 0, 4);
                  if (localTroopManager.a((String)localObject6, MessageHandlerUtils.a((byte[])localObject8))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21).a(18, true, new Object[] { localObject6, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (m == 13571)
              {
                l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_uin.get();
                l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject4).uint64_code.get();
                Long.valueOf(l1).toString();
                localObject6 = String.valueOf(Long.valueOf(l2));
                m = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().size();
                localObject7 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toByteArray();
                if (m >= 6)
                {
                  if ((localObject7[0] != 1) || (localObject7[0] == 0)) {}
                  m = localObject7[1];
                  if (m == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject8 = new byte[4];
                    System.arraycopy(localObject7, 2, localObject8, 0, 4);
                    if (localTroopManager.b((String)localObject6, MessageHandlerUtils.a((byte[])localObject8))) {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(53, true, new Object[] { localObject6, Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(m) });
                    }
                  }
                  if ((m == 0) && (localTroopManager.e((String)localObject6))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(53, true, new Object[] { localObject6, Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(m) });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_msg_sns_general_infos.has()))
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get();
          localObject4 = new HashMap();
          localObject5 = paramArrayOfByte.iterator();
          while (((Iterator)localObject5).hasNext())
          {
            paramArrayOfByte = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject5).next();
            if ((paramArrayOfByte != null) && (paramArrayOfByte.uint64_uin.has()) && (paramArrayOfByte.rpt_msg_sns_update_item.has()))
            {
              l1 = paramArrayOfByte.uint64_uin.get();
              localObject6 = String.valueOf(l1);
              localObject7 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
              while (((Iterator)localObject7).hasNext())
              {
                localObject8 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject7).next();
                if ((localObject8 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.has()))
                {
                  if (((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.get() == 13568) {
                    QvipSpecialCareManager.a((String)localObject6, ((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  }
                  localObject1 = (SpecialCareInfo)((HashMap)localObject4).get(localObject6);
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    localObject1 = localFriendsManager.a(String.valueOf(l1));
                    paramArrayOfByte = (byte[])localObject1;
                    if (localObject1 == null)
                    {
                      paramArrayOfByte = new SpecialCareInfo();
                      paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                    }
                    ((HashMap)localObject4).put(paramArrayOfByte.uin, paramArrayOfByte);
                  }
                  m = ((SubMsgType0x27.SnsUpdateItem)localObject8).uint32_update_sns_type.get();
                  localObject1 = ((SubMsgType0x27.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8();
                  FriendListHandler.a(paramArrayOfByte, m, (String)localObject1);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + m + ",itemVal=" + (String)localObject1);
                  }
                }
              }
            }
          }
          paramArrayOfByte = ((HashMap)localObject4).entrySet().iterator();
          localObject1 = new ArrayList();
          while (paramArrayOfByte.hasNext())
          {
            localObject4 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
            if ((localObject4 != null) && ((((SpecialCareInfo)localObject4).getStatus() != 1000) || (((SpecialCareInfo)localObject4).globalSwitch != 0))) {
              ((List)localObject1).add(localObject4);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject1).size());
          }
          localFriendsManager.c((List)localObject1);
          if (((List)localObject1).size() > 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(98, true, new Object[] { Boolean.valueOf(true), localObject1 });
          }
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        boolean bool1;
        if (paramArrayOfByte.rpt_msg_update_sns_flag.has())
        {
          paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            m = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + m + " id:" + l2);
            }
            if (l2 == 4051L)
            {
              localObject1 = localFriendsManager.c(String.valueOf(l1));
              if (localObject1 != null)
              {
                if (m == 1) {}
                for (bool1 = true;; bool1 = false)
                {
                  ((Friends)localObject1).setShieldFlag(bool1);
                  localFriendsManager.a((Friends)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool1), Boolean.valueOf(true), Boolean.valueOf(true), "" });
                  break;
                }
              }
            }
          }
        }
        break;
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModProfile)paramArrayOfByte.msg_mod_profile.get();
        n = k;
        if (paramArrayOfByte.uint64_uin.has())
        {
          l1 = paramArrayOfByte.uint64_uin.get();
          localObject4 = paramArrayOfByte.rpt_msg_profile_infos.get().iterator();
          m = k;
          for (;;)
          {
            n = m;
            if (!((Iterator)localObject4).hasNext()) {
              break;
            }
            paramArrayOfByte = (SubMsgType0x27.ProfileInfo)((Iterator)localObject4).next();
            if ((paramArrayOfByte.uint32_field.has()) && (paramArrayOfByte.bytes_value.has())) {
              switch (paramArrayOfByte.uint32_field.get())
              {
              default: 
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramArrayOfByte.uint32_field.get());
                }
                break;
              case 20002: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramArrayOfByte.toStringUtf8());
                }
                arrayOfFriends[m] = localFriendsManager.a(l1 + "", paramArrayOfByte.toStringUtf8());
                localObject1 = localFriendsManager.a(l1 + "");
                if (localObject1 != null)
                {
                  ((Card)localObject1).strNick = paramArrayOfByte.toStringUtf8();
                  localFriendsManager.a((Card)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, localObject1);
                }
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
                m += 1;
                break;
              case 20015: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == 2))
                {
                  k = paramArrayOfByte.byteAt(0);
                  k = (short)(paramArrayOfByte.byteAt(1) | k << 8);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Head = " + k);
                  }
                  ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(l1 + "");
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte != null)
                  {
                    paramArrayOfByte.nFaceID = k;
                    localFriendsManager.a(paramArrayOfByte);
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(4, true, new Object[] { l1 + "", paramArrayOfByte, null });
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  }
                }
                break;
              case 20009: 
                n = paramArrayOfByte.bytes_value.get().byteAt(0);
                if (n == 1) {
                  k = 0;
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModProfile Sex = " + k);
                  }
                  paramArrayOfByte = localFriendsManager.a(l1 + "");
                  if (paramArrayOfByte == null) {
                    break;
                  }
                  paramArrayOfByte.shGender = ((short)k);
                  localFriendsManager.a(paramArrayOfByte);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
                  break;
                  if (n == 2)
                  {
                    k = 1;
                  }
                  else
                  {
                    k = n;
                    if (n == 0) {
                      k = 2;
                    }
                  }
                }
              case 20059: 
                k = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get(0);
                a(k);
                ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(101, true, Integer.valueOf(k));
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "bubble id = " + k);
                }
                break;
              case 23105: 
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "vip update uin=" + l1);
                }
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                localObject1 = (Friends)localFriendsManager.c(Long.toString(l1)).clone();
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramArrayOfByte.byteAt(0)) }));
                }
                n = ((Friends)localObject1).qqVipInfo;
                if ((paramArrayOfByte.byteAt(0) & 0x80) == 0)
                {
                  k = 0;
                  ((Friends)localObject1).qqVipInfo = (k << 24 | 0xFFFFFF & n);
                  n = ((Friends)localObject1).superQqInfo;
                  if ((paramArrayOfByte.byteAt(0) & 0x8) != 0) {
                    break label4434;
                  }
                  k = 0;
                  ((Friends)localObject1).superQqInfo = (k << 24 | 0xFFFFFF & n);
                  if ((paramArrayOfByte.byteAt(0) & 0x40) == 0) {
                    break label4440;
                  }
                  bool1 = true;
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "is year vip =" + bool1);
                  }
                  if (!bool1) {
                    break label4446;
                  }
                  k = 65536;
                  if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                    break label4452;
                  }
                  ((Friends)localObject1).superVipInfo = (k | ((Friends)localObject1).superVipInfo & 0xFF00FFFF);
                }
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(((Friends)localObject1).superVipInfo), Integer.valueOf(((Friends)localObject1).qqVipInfo), Integer.valueOf(((Friends)localObject1).superQqInfo) }));
                  }
                  localFriendsManager.a((Friends)localObject1);
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(Long.toString(l1))) {
                    break;
                  }
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).c();
                  break;
                  k = 1;
                  break label4167;
                  k = 1;
                  break label4205;
                  bool1 = false;
                  break label4236;
                  k = 0;
                  break label4280;
                  if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                    ((Friends)localObject1).qqVipInfo = (k | ((Friends)localObject1).qqVipInfo & 0xFF00FFFF);
                  } else if (((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                    ((Friends)localObject1).superQqInfo = (k | ((Friends)localObject1).superQqInfo & 0xFF00FFFF);
                  }
                }
              case 23106: 
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "vip update uin=" + l1);
                }
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                localObject1 = Long.toString(l1);
                localObject5 = (Friends)localFriendsManager.c((String)localObject1).clone();
                bool1 = ((Friends)localObject5).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
                boolean bool2 = ((Friends)localObject5).isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
                boolean bool3 = ((Friends)localObject5).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
                }
                int i2 = 0;
                int i = paramArrayOfByte.byteAt(4);
                int j = paramArrayOfByte.byteAt(5);
                int i1;
                if ((j & 0xF0) != 0)
                {
                  n = 16;
                  i1 = 0;
                  k = i2;
                  if (i1 < 4)
                  {
                    if ((j & n) != 0) {
                      k = 13 - i1;
                    }
                  }
                  else
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(k) }));
                    }
                    if (!bool1) {
                      break label4909;
                    }
                    ((Friends)localObject5).superVipInfo = (k & 0xFFFF | ((Friends)localObject5).superVipInfo & 0xFFFF0000);
                  }
                }
                for (;;)
                {
                  localFriendsManager.a((Friends)localObject5);
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject1)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  break;
                  i1 += 1;
                  n = (byte)(n << 1);
                  break label4694;
                  if (i != 0)
                  {
                    n = 1;
                    i1 = 0;
                    for (;;)
                    {
                      k = i2;
                      if (i1 >= 8) {
                        break;
                      }
                      if ((i & n) != 0)
                      {
                        k = 9 - i1;
                        break;
                      }
                      i1 += 1;
                      n = (byte)(n << 1);
                    }
                  }
                  k = 1;
                  break label4718;
                  if (bool2) {
                    ((Friends)localObject5).qqVipInfo = (k & 0xFFFF | ((Friends)localObject5).qqVipInfo & 0xFFFF0000);
                  } else if (bool3) {
                    ((Friends)localObject5).superQqInfo = (k & 0xFFFF | ((Friends)localObject5).superQqInfo & 0xFFFF0000);
                  }
                }
              case 23107: 
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "svip update uin=" + l1);
                }
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                localObject1 = Long.toString(l1);
                localObject5 = (Friends)localFriendsManager.c((String)localObject1).clone();
                if ((paramArrayOfByte.byteAt(5) & 0x20) != 0)
                {
                  bool1 = true;
                  n = ((Friends)localObject5).superVipInfo;
                  if (!bool1) {
                    break label5192;
                  }
                }
                for (k = 1;; k = 0)
                {
                  ((Friends)localObject5).superVipInfo = (k << 24 | 0xFFFFFF & n);
                  localFriendsManager.a((Friends)localObject5);
                  if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + ((Friends)localObject5).superVipInfo);
                  }
                  if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(localObject1)) {
                    break;
                  }
                  ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(100, true, null);
                  ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).c();
                  break;
                  bool1 = false;
                  break label5045;
                }
              case 23104: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if ((paramArrayOfByte.byteAt(5) & 0x2) != 0)
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                  if ((paramArrayOfByte.byteAt(1) & 0x2) != 0) {
                    k = 2;
                  }
                  while (k != -1)
                  {
                    ((SharedPreferences)localObject1).edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), k).commit();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(100, true, Integer.valueOf(k));
                    break;
                    if (((SharedPreferences)localObject1).getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1) == 2) {
                      k = 1;
                    } else {
                      k = -1;
                    }
                  }
                }
                break;
              case 23109: 
                paramArrayOfByte = paramArrayOfByte.bytes_value.get();
                if (((paramArrayOfByte.byteAt(31) & 0x20) != 0) || ((paramArrayOfByte.byteAt(34) & 0x10) != 0) || ((paramArrayOfByte.byteAt(29) & 0x10) != 0))
                {
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
                  if (((paramArrayOfByte.byteAt(11) & 0x20) == 0) && ((paramArrayOfByte.byteAt(14) & 0x10) == 0)) {
                    break label5718;
                  }
                  k = 4;
                  if (k != -1)
                  {
                    ((SharedPreferences)localObject1).edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), k).commit();
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(100, true, Integer.valueOf(k));
                  }
                }
                if ((paramArrayOfByte.byteAt(12) & 0x8) != 0)
                {
                  bool1 = true;
                  SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
                  if ((paramArrayOfByte.byteAt(13) & 0x40) == 0) {
                    break label5802;
                  }
                }
                for (bool1 = true; SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "qqsetting_pcactive_key", false) != bool1; bool1 = false)
                {
                  SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.valueOf(l1).toString(), null, "qqsetting_pcactive_key", bool1);
                  paramArrayOfByte = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                  paramArrayOfByte.putExtra("pcActive", bool1);
                  paramArrayOfByte.putExtra("uin", Long.valueOf(l1).toString());
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().sendBroadcast(paramArrayOfByte);
                  if (!bool1) {
                    break;
                  }
                  SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "pcactive_config", true);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(Long.toString(l1), "config", true);
                  QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
                  break;
                  if ((paramArrayOfByte.byteAt(9) & 0x10) != 0)
                  {
                    k = 3;
                    break label5456;
                  }
                  k = ((SharedPreferences)localObject1).getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), -1);
                  if ((k == 4) || (k == 3))
                  {
                    k = 1;
                    break label5456;
                  }
                  k = -1;
                  break label5456;
                  bool1 = false;
                  break label5542;
                }
              case 27025: 
                l2 = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asLongBuffer().get();
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                paramArrayOfByte.pendantId = l2;
                paramArrayOfByte.timestamp = System.currentTimeMillis();
                localFriendsManager.a(paramArrayOfByte);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l1 + ", id=" + paramArrayOfByte.pendantId);
                }
                break;
              case 27032: 
                k = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get();
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                if (paramArrayOfByte.uVipFont != k)
                {
                  paramArrayOfByte.uVipFont = k;
                  paramArrayOfByte.timestamp = System.currentTimeMillis();
                  localFriendsManager.a(paramArrayOfByte);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l1 + ", id=" + paramArrayOfByte.uVipFont);
                }
                break;
              case 27041: 
                label4205:
                label4718:
                k = ByteBuffer.wrap(paramArrayOfByte.bytes_value.get().toByteArray()).asIntBuffer().get();
                label4434:
                label4440:
                label4446:
                label4452:
                localObject1 = localFriendsManager.a(String.valueOf(l1));
                label4694:
                paramArrayOfByte = (byte[])localObject1;
                label5456:
                label5718:
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ExtensionInfo();
                  paramArrayOfByte.uin = String.valueOf(l1);
                }
                if (paramArrayOfByte.colorRingId != k)
                {
                  paramArrayOfByte.colorRingId = k;
                  paramArrayOfByte.timestamp = System.currentTimeMillis();
                  localFriendsManager.a(paramArrayOfByte);
                  ColorRingManager.a(paramArrayOfByte.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l1 + ", id=" + paramArrayOfByte.colorRingId);
                }
                break;
              }
            }
          }
        }
        k = n;
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((paramArrayOfByte.uint32_type.has()) && (paramArrayOfByte.uint64_uin.has()))
        {
          localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
          if (paramArrayOfByte.uint32_type.get() != 0) {
            break label6385;
          }
          l1 = paramArrayOfByte.uint64_uin.get();
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          ((FriendListHandler)localObject1).c(l1 + "");
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
        }
        for (;;)
        {
          break;
          label6385:
          if (paramArrayOfByte.uint32_type.get() == 1)
          {
            l1 = paramArrayOfByte.uint64_group_code.get();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
            }
            ((FriendListHandler)localObject1).d(l1 + "");
          }
        }
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        m = paramArrayOfByte.uint32_login_days.get();
        n = paramArrayOfByte.uint32_days.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
          if ((m != paramArrayOfByte.lLoginDays) || (n != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = m;
            paramArrayOfByte.lQQMasterLogindays = n;
            localFriendsManager.a(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + m + ";days=" + n);
        }
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        paramArrayOfByte = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (SubMsgType0x27.FriendRemark)paramArrayOfByte.next();
          if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              }
              localFriendsManager.b(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8());
              localObject4 = localFriendsManager.a(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "");
              if (localObject4 != null)
              {
                localObject5 = ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8();
                if (!((String)localObject5).equals(((Card)localObject4).strReMark))
                {
                  ((Card)localObject4).strReMark = ((String)localObject5);
                  localFriendsManager.a((Card)localObject4);
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get()));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
            }
            else if (((SubMsgType0x27.FriendRemark)localObject1).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject1).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject1).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        break;
        break;
        if (!paramArrayOfByte.msg_mod_rich_long_nick.has()) {
          break;
        }
        Object localObject6 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick.get();
        localObject4 = Long.toString(((SubMsgType0x27.ModLongNick)localObject6).uint64_uin.get());
        paramArrayOfByte = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject6).bytes_value.get().toByteArray());
        l1 = paramArrayOfByte.getLong();
        localObject5 = new byte[paramArrayOfByte.remaining()];
        paramArrayOfByte.get((byte[])localObject5);
        localObject1 = localFriendsManager.a((String)localObject4);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject4);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject5, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, paramArrayOfByte.getRichStatus());
        localFriendsManager.a(paramArrayOfByte);
        paramArrayOfByte = localFriendsManager.a(((SubMsgType0x27.ModLongNick)localObject6).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject5);
          paramArrayOfByte.lSignModifyTime = l1;
          localFriendsManager.a(paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject4);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(2, true, new String[] { localObject4 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        if (((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.has())
        {
          l1 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_uin.get();
          l2 = ((SubMsgType0x27.ModGroupProfile)localObject1).uint64_group_code.get();
          paramArrayOfByte = localFriendsManager.a();
        }
        for (;;)
        {
          try
          {
            paramArrayOfByte.a();
            localObject1 = ((SubMsgType0x27.ModGroupProfile)localObject1).rpt_msg_group_profile_infos.get().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject4 = (SubMsgType0x27.GroupProfileInfo)((Iterator)localObject1).next();
              if ((!((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.has())) {
                continue;
              }
              if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8());
                }
                localObject5 = localTroopManager.a(l2 + "");
                if (localObject5 == null) {
                  continue;
                }
                ((TroopInfo)localObject5).troopname = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                localTroopManager.b((TroopInfo)localObject5);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(1, false, null);
                continue;
              }
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            paramArrayOfByte.b();
            break;
            if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() != 2) {
              continue;
            }
            localObject4 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get();
            if ((localObject4 == null) || (((ByteStringMicro)localObject4).size() != 2)) {
              continue;
            }
            m = ((ByteStringMicro)localObject4).byteAt(0);
            short s = (short)(((ByteStringMicro)localObject4).byteAt(1) | m << 8);
            localObject4 = localTroopManager.a(l1 + "");
            ((TroopInfo)localObject4).troopface = s;
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
            }
            localTroopManager.b((TroopInfo)localObject4);
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(l1 + "");
            continue;
          }
          finally
          {
            paramArrayOfByte.b();
          }
          paramArrayOfByte.c();
          paramArrayOfByte.b();
        }
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        Object localObject3 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.has()) && (((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.has()))
        {
          l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_uin.get();
          l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_group_code.get();
          long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).uint64_uin.get();
          paramArrayOfByte = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
          localObject3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject3).rpt_msg_group_member_profile_infos.get().iterator();
          label8826:
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject3).next();
            if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.has()))
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() != 1) {
                break label8391;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
              }
              QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size());
              localTroopManager.a(l1 + "", l3 + "", ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8(), -100, null, null, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.name = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
              }
            }
            for (;;)
            {
              if (paramArrayOfByte == null) {
                break label8826;
              }
              DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
              localObject4 = new ArrayList();
              ((ArrayList)localObject4).add(paramArrayOfByte);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(16, true, localObject4);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19).a(10, true, new Object[] { localObject4, Boolean.valueOf(true) });
              break;
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 2)
              {
                if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().size() == 1)
                {
                  byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().byteAt(0);
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                  }
                  localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                  if (paramArrayOfByte != null) {
                    paramArrayOfByte.sex = b;
                  }
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 3)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject4);
                }
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.tel = ((String)localObject4);
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 4)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject4);
                }
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.email = ((String)localObject4);
                }
              }
              else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject4).uint32_field.get() == 5)
              {
                localObject4 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject4).bytes_value.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject4);
                }
                ((FriendsManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).a(l1 + "", l3 + "", null, -100, null, (String)localObject4, -100, -100, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.memo = ((String)localObject4);
                }
              }
            }
          }
        }
        break;
        if (!paramArrayOfByte.msg_appointment_notify.has()) {
          break;
        }
        localObject6 = (SubMsgType0x27.AppointmentNotify)paramArrayOfByte.msg_appointment_notify.get();
        if (((SubMsgType0x27.AppointmentNotify)localObject6).uint32_notifytype.has())
        {
          l1 = ((SubMsgType0x27.AppointmentNotify)localObject6).uint32_notifytype.get();
          if ((l1 != 2L) && (l1 != 4L)) {
            break label8941;
          }
          paramArrayOfByte = (DatingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(67);
          if (paramArrayOfByte == null) {
            break label8922;
          }
          paramArrayOfByte.a().a((SubMsgType0x27.AppointmentNotify)localObject6);
        }
        label8922:
        label8941:
        while (((l1 < 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject6).uint64_from_uin.has())) {
          for (;;)
          {
            break;
            if (!QLog.isColorLevel()) {
              break label9196;
            }
            QLog.i("Q.dating", 2, "online push SubMsgType0x27.AppointmentNotify mng is null");
          }
        }
        long l2 = ((SubMsgType0x27.AppointmentNotify)localObject6).uint64_from_uin.get();
        localObject3 = null;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject5 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject4;; paramArrayOfByte = (byte[])localObject5)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject6).str_tips_content.has()) {
            localObject3 = ((SubMsgType0x27.AppointmentNotify)localObject6).str_tips_content.get();
          }
          localObject6 = new ArrayList();
          localObject7 = MessageRecordFactory.a(-1024);
          l2 = MessageCache.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject5 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject7).init((String)localObject4, (String)localObject5, paramArrayOfByte, (String)localObject3, l2, -1024, 1010, l2);
          ((MessageRecord)localObject7).isread = false;
          if (l1 == 0L)
          {
            ((MessageRecord)localObject7).issend = 1;
            ((MessageRecord)localObject7).isread = true;
          }
          ((ArrayList)localObject6).add(localObject7);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject7, ((MessageRecord)localObject7).selfuin);
          a("handleMsgType0x210SubMsgType0x27", true, (List)localObject6, false, false);
          break;
          label9196:
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject6).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject6).bytes_sig.get().toByteArray();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j((String)localObject5, paramArrayOfByte);
            }
          }
        }
        if (!paramArrayOfByte.msg_new_comein_user_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.NewComeinUserNotify)paramArrayOfByte.msg_new_comein_user_notify.get();
        if (paramArrayOfByte.uint32_msg_type.has()) {}
        for (m = paramArrayOfByte.uint32_msg_type.get();; m = -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SecMsgHandler", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + m);
          }
          if (m == 1)
          {
            localObject3 = (LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject3 != null) {
              ((LBSHandler)localObject3).a(paramArrayOfByte);
            }
          }
          for (;;)
          {
            break;
            if ((m == 2) || (m == 3))
            {
              localObject3 = (NearFieldTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
              if (localObject3 != null) {
                ((NearFieldTroopHandler)localObject3).a(m, paramArrayOfByte);
              }
            }
          }
          localFriendsManager.a(arrayOfFriends, k);
          return;
        }
      }
    }
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      do
      {
        do
        {
          do
          {
            try
            {
              localMsgBody.mergeFrom(paramArrayOfByte);
              if (!localMsgBody.uint32_sub_cmd.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
                }
                return;
              }
            }
            catch (Exception paramArrayOfByte)
            {
              while (!QLog.isColorLevel()) {}
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
              return;
            }
            if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
            {
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(19)).a(paramArrayOfByte);
              return;
            }
          } while (localMsgBody.uint32_sub_cmd.get() != 3);
          if ((!localMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
          }
          paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)localMsgBody.msg_subcmd_0x3_push_body.get();
        } while ((!paramArrayOfByte.uint64_conf_uin.has()) || (!paramArrayOfByte.msg_app_tip_notify.has()));
        paramArrayOfByte.uint64_conf_uin.get();
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)paramArrayOfByte.msg_app_tip_notify.get();
      } while (!paramArrayOfByte.bytes_text.has());
      paramArrayOfByte = paramArrayOfByte.bytes_text.get().toByteArray();
    } while (paramArrayOfByte.length <= 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */